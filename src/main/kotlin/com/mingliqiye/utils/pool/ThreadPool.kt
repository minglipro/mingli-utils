/*
 * Copyright 2026 mingliqiye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ProjectName mingli-utils
 * ModuleName mingli-utils.main
 * CurrentFile ThreadPool.kt
 * LastUpdate 2026-10-12 13:57:11
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.pool

import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

/**
 * 可复用线程池。
 *
 * 与直接管理 [Thread] 的对象池不同，本实现的池对象是一个 [Worker]：
 * 每个 Worker 内部持有一个**长期存活**的守护线程和一个任务队列，
 * 线程通过 `while` 循环不断消费队列中的任务，从而实现真正意义上的线程复用
 * （避免频繁创建/销毁线程带来的开销，并保留线程本地状态）。
 *
 * ## 使用方式
 *
 * ```kotlin
 * ThreadPool(maxSize = 4, initialSize = 2).use { pool ->
 *     // 同步执行：借出 Worker -> 执行 -> 归还
 *     pool.execute { println("task on ${Thread.currentThread().name}") }
 *
 *     // 带返回值
 *     val result = pool.call(Callable { 1 + 1 })
 *
 *     // 异步提交：任务完成后自动归还 Worker
 *     val future = pool.submit(Callable { doSomething() })
 *     future.get()
 *
 *     // 直接借出 Worker 使用
 *     pool.use { data -> data.obj.execute { /* ... */ } }
 * }
 * ```
 *
 * @property maxSize 最大 Worker 数量（同时也是最大并发任务数）
 * @property minSize 保留的最小空闲 Worker 数量
 * @property initialSize 预热的 Worker 数量
 * @property namePrefix Worker 线程名前缀，最终名称为 `${namePrefix}-${id}`
 * @property daemon Worker 线程是否为守护线程，默认 true
 * @property uncaughtHandler 任务抛出未捕获异常时的处理器
 */
class ThreadPool(
    maxSize: Int = Runtime.getRuntime().availableProcessors().coerceAtLeast(2),
    minSize: Int = 0,
    initialSize: Int = 1,
    private val namePrefix: String = "MingLiThreadPool",
    private val daemon: Boolean = true,
    private val uncaughtHandler: Thread.UncaughtExceptionHandler = Thread.UncaughtExceptionHandler { _, _ -> },
) : ObjectPool<ThreadPool.Worker>(maxSize, minSize, initialSize), AutoCloseable {

    /** 已提交任务总数 */
    private val submittedTasks = AtomicLong(0)

    /** 已完成任务总数 */
    private val completedTasks = AtomicLong(0)

    /** 已失败任务总数 */
    private val failedTasks = AtomicLong(0)

    /** 已创建的全部 Worker 引用，用于 [closeAndAwait] 等待线程退出 */
    private val allWorkers = CopyOnWriteArrayList<Worker>()

    override fun init(id: Int): ObjectPoolData<Worker> {
        val worker = Worker(id, namePrefix, daemon, uncaughtHandler)
        worker.start()
        allWorkers.add(worker)
        return ObjectPoolData(
            obj = worker,
            objectPool = this,
            id = id,
            name = worker.threadName,
        )
    }

    override fun destroy(data: ObjectPoolData<Worker>) {
        data.obj.shutdown()
        allWorkers.remove(data.obj)
    }

    /**
     * 同步执行任务：从池借出一个 Worker，在其线程上运行 [task]，结束后归还。
     * 任务的异常会被封装为 [ExecutionException] 抛出。
     */
    @JvmOverloads
    fun execute(task: Runnable, timeoutMillis: Long = 0) {
        call(Callable { task.run(); null }, timeoutMillis)
    }

    /**
     * 同步执行带返回值的任务。
     */
    @JvmOverloads
    fun <R> call(task: Callable<R>, timeoutMillis: Long = 0): R {
        return useResult(timeoutMillis) { data ->
            data.obj.call(task)
        }
    }

    /**
     * 异步提交任务，立即返回 [CompletableFuture]。
     *
     * Worker 会一直被占用直到任务执行完成，然后自动归还给池；
     * 因此在 `maxSize` 达到上限时，新的提交会阻塞在 borrow 阶段。
     */
    @JvmOverloads
    fun <R> submit(task: Callable<R>, timeoutMillis: Long = 0): CompletableFuture<R> {
        val data = borrow(timeoutMillis)
        submittedTasks.incrementAndGet()
        val future = data.obj.submitAsync(task)
        return future.whenComplete { _, err ->
            if (err != null) failedTasks.incrementAndGet() else completedTasks.incrementAndGet()
            runCatching { returnObject(data) }
        }
    }

    /** 异步提交无返回值任务；使用独立方法名避免与 [submit] 的 lambda 重载歧义 */
    @JvmOverloads
    fun submitRunnable(task: Runnable, timeoutMillis: Long = 0): CompletableFuture<Void?> {
        return submit(Callable { task.run(); null as Void? }, timeoutMillis)
    }

    /** 已提交任务总数 */
    fun submittedCount(): Long = submittedTasks.get()

    /** 已完成任务总数 */
    fun completedCount(): Long = completedTasks.get()

    /** 已失败任务总数 */
    fun failedCount(): Long = failedTasks.get()

    /**
     * 池中的工作单元：一个长期存活的守护线程 + 一个任务队列。
     *
     * 通过 [submit]/[call]/[execute] 向 Worker 投递任务，Worker 线程循环消费执行。
     * 只有在池 [close] 时才会调用 [shutdown] 结束该线程。
     */
    class Worker internal constructor(
        val id: Int,
        namePrefix: String,
        daemon: Boolean,
        private val uncaughtHandler: Thread.UncaughtExceptionHandler,
    ) {

        private val taskQueue = LinkedBlockingQueue<Runnable>()
        private val shutdown = AtomicBoolean(false)
        private val started = AtomicBoolean(false)

        /** Worker 线程名称 */
        val threadName: String = "$namePrefix-$id"

        /** Worker 线程引用，只读 */
        val thread: Thread = Thread({ runLoop() }, threadName).apply {
            isDaemon = daemon
        }

        internal fun start() {
            if (started.compareAndSet(false, true)) {
                thread.start()
            }
        }

        private fun runLoop() {
            while (!shutdown.get() || taskQueue.isNotEmpty()) {
                val task = try {
                    // 使用轮询而非 take()，以便 shutdown 标志能及时生效
                    taskQueue.poll(100, TimeUnit.MILLISECONDS)
                } catch (_: InterruptedException) {
                    if (shutdown.get()) break else null
                }
                if (task != null) {
                    try {
                        task.run()
                    } catch (t: Throwable) {
                        try {
                            uncaughtHandler.uncaughtException(thread, t)
                        } catch (_: Throwable) {
                            // 忽略处理器自身的异常，防止线程意外退出
                        }
                    }
                }
            }
        }

        /**
         * 异步提交任务，返回 Future。任务在该 Worker 线程上执行。
         * @throws IllegalStateException 若 Worker 已关闭
         */
        fun <R> submitAsync(task: Callable<R>): CompletableFuture<R> {
            check(!shutdown.get()) { "Worker[$threadName] already shutdown" }
            val future = CompletableFuture<R>()
            val wrapper = Runnable {
                try {
                    future.complete(task.call())
                } catch (t: Throwable) {
                    future.completeExceptionally(t)
                }
            }
            if (!taskQueue.offer(wrapper)) {
                future.completeExceptionally(IllegalStateException("Worker[$threadName] rejected task"))
            }
            return future
        }

        /** 同步执行任务，返回结果 */
        fun <R> call(task: Callable<R>): R {
            try {
                return submitAsync(task).get()
            } catch (e: ExecutionException) {
                throw e.cause ?: e
            }
        }

        /** 同步执行任务，忽略返回值 */
        fun execute(task: Runnable) {
            call(Callable { task.run(); null })
        }

        /** 当前待执行任务数 */
        fun pendingTasks(): Int = taskQueue.size

        /** Worker 是否已关闭 */
        fun isShutdown(): Boolean = shutdown.get()

        /** 线程是否存活 */
        fun isAlive(): Boolean = thread.isAlive

        internal fun shutdown() {
            if (shutdown.compareAndSet(false, true)) {
                thread.interrupt()
            }
        }

        /** 等待 Worker 线程结束，最多 [timeoutMillis] 毫秒 */
        @JvmOverloads
        fun awaitTermination(timeoutMillis: Long = 0) {
            if (timeoutMillis <= 0) thread.join() else thread.join(timeoutMillis)
        }

        override fun toString(): String =
            "Worker(id=$id, name=$threadName, pending=${taskQueue.size}, alive=${thread.isAlive})"
    }

    /**
     * 关闭池：销毁所有 Worker 线程。
     * 由于 Worker 线程默认为守护线程，未调用 [closeAndAwait] 时不会阻塞 JVM 退出。
     */
    override fun close() {
        super.close()
    }

    /**
     * 关闭池并阻塞等待所有 Worker 线程结束。
     * @param timeoutMillis 每个 Worker 最长等待时间
     */
    @JvmOverloads
    fun closeAndAwait(timeoutMillis: Long = 5_000) {
        val snapshot = allWorkers.toList()
        super.close()
        snapshot.forEach { it.awaitTermination(timeoutMillis) }
    }

    companion object {
        /** 依据 CPU 核数创建默认大小的线程池 */
        @JvmStatic
        fun defaultPool(): ThreadPool = ThreadPool()

        /** 创建固定大小的线程池 */
        @JvmStatic
        fun fixed(size: Int, namePrefix: String = "MingLiFixedPool"): ThreadPool =
            ThreadPool(maxSize = size, minSize = size, initialSize = size, namePrefix = namePrefix)

        /** 创建单线程池，保证任务串行执行 */
        @JvmStatic
        fun single(namePrefix: String = "MingLiSinglePool"): ThreadPool =
            ThreadPool(maxSize = 1, minSize = 1, initialSize = 1, namePrefix = namePrefix)
    }
}
