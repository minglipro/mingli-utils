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
 * CurrentFile ThreadPoolBuilder.kt
 * LastUpdate 2026-10-19 20:51:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import com.mingliqiye.utils.netty.NamedThreadFactory
import com.mingliqiye.utils.system.availableProcessors
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * 线程池构建器，采用链式 + DSL 风格配置 [ThreadPoolExecutor]。
 *
 * 充分利用 Kotlin 默认参数与具名参数，仅需覆盖关心的配置项：
 *
 * ```kotlin
 * val pool = threadPool("biz-pool") {
 *     corePoolSize = 8
 *     maximumPoolSize = 16
 *     queueCapacity = 1000          // 有界队列，防止任务无限堆积
 *     keepAliveSeconds = 30
 *     allowCoreThreadTimeout = true
 *     daemon = true
 *     rejectedHandler = ThreadPoolExecutor.AbortPolicy()
 * }
 * ```
 */
class ThreadPoolBuilder internal constructor() {

    /** 线程池名称，用于线程命名 */
    var name: String = "MingLiPool"

    /** 核心线程数，默认 CPU 核数 */
    var corePoolSize: Int = availableProcessors

    /** 最大线程数，默认 CPU 核数 x2 */
    var maximumPoolSize: Int = availableProcessors * 2

    /** 非核心线程空闲存活时间（秒） */
    var keepAliveSeconds: Long = 60

    /** 是否允许核心线程空闲超时回收 */
    var allowCoreThreadTimeout: Boolean = false

    /** 任务队列容量，<= 0 表示使用无界队列 */
    var queueCapacity: Int = 0

    /** 工作队列，设置 [queueCapacity] 后将被覆盖 */
    var workQueue: BlockingQueue<Runnable> = LinkedBlockingQueue()

    /** 线程是否为守护线程 */
    var daemon: Boolean = false

    /** 线程优先级 */
    var priority: Int = Thread.NORM_PRIORITY

    /** 任务拒绝策略，默认由调用线程执行 */
    var rejectedHandler: RejectedExecutionHandler = ThreadPoolExecutor.CallerRunsPolicy()

    /** 未捕获异常处理器 */
    var uncaughtHandler: Thread.UncaughtExceptionHandler? = null

    /** 自定义线程工厂，默认使用 [NamedThreadFactory] */
    var threadFactory: ThreadFactory? = null

    /**
     * 使用无界队列（默认行为）
     */
    fun unboundedQueue(): ThreadPoolBuilder = apply {
        queueCapacity = 0
        workQueue = LinkedBlockingQueue()
    }

    /**
     * 使用有界队列
     *
     * @param capacity 队列容量，必须大于 0
     */
    fun boundedQueue(capacity: Int): ThreadPoolBuilder = apply {
        require(capacity > 0) { "queue capacity must be positive: $capacity" }
        queueCapacity = capacity
        workQueue = ArrayBlockingQueue(capacity)
    }

    /**
     * 使用同步队列，任务直接交接给线程（适合缓存线程池场景）
     */
    fun synchronousQueue(): ThreadPoolBuilder = apply {
        queueCapacity = 1
        workQueue = SynchronousQueue()
    }

    /**
     * 构建线程池
     *
     * @return 配置完成的 [ThreadPoolExecutor]
     */
    fun build(): ThreadPoolExecutor {
        val baseFactory = threadFactory ?: NamedThreadFactory.of(name)
        // 提取局部变量，避免 apply 块内与 Thread 自身属性混淆
        val daemonThread = daemon
        val threadPriority = priority
        val exceptionHandler = uncaughtHandler
        // 需要定制 daemon/priority/异常处理时包装一层，否则直接复用
        val factory = if (daemonThread || threadPriority != Thread.NORM_PRIORITY || exceptionHandler != null) {
            ThreadFactory { runnable ->
                baseFactory.newThread(runnable).apply {
                    isDaemon = daemonThread
                    this.priority = threadPriority
                    exceptionHandler?.let { setUncaughtExceptionHandler(it) }
                }
            }
        } else baseFactory
        return ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveSeconds,
            TimeUnit.SECONDS,
            workQueue,
            factory,
            rejectedHandler,
        ).apply {
            if (allowCoreThreadTimeout) allowCoreThreadTimeOut(true)
        }
    }
}

/**
 * 以 DSL 方式构建线程池
 *
 * ```kotlin
 * val pool = threadPool("order-pool") {
 *     corePoolSize = 4
 *     boundedQueue(500)
 * }
 * ```
 *
 * @param name 线程池名称
 * @param configure 配置块
 */
fun threadPool(
    name: String = "MingLiPool",
    configure: ThreadPoolBuilder.() -> Unit = {},
): ThreadPoolExecutor = ThreadPoolBuilder().apply {
    this.name = name
    configure()
}.build()

/**
 * 创建固定大小线程池，任务队列无界
 */
fun fixedThreadPool(size: Int, name: String = "MingLiFixedPool"): ThreadPoolExecutor =
    threadPool(name) {
        corePoolSize = size
        maximumPoolSize = size
    }

/**
 * 创建单线程池，保证任务串行执行
 */
fun singleThreadPool(name: String = "MingLiSinglePool"): ThreadPoolExecutor =
    threadPool(name) {
        corePoolSize = 1
        maximumPoolSize = 1
    }

/**
 * 创建缓存线程池，空闲线程 60 秒后回收
 */
fun cachedThreadPool(name: String = "MingLiCachedPool"): ThreadPoolExecutor =
    threadPool(name) {
        corePoolSize = 0
        maximumPoolSize = Int.MAX_VALUE
        keepAliveSeconds = 60
        synchronousQueue()
    }

/**
 * 创建 IO 密集型线程池：更多线程 + 有界队列
 */
fun ioThreadPool(name: String = "MingLiIoPool"): ThreadPoolExecutor =
    threadPool(name) {
        corePoolSize = availableProcessors * 2
        maximumPoolSize = availableProcessors * 4
        boundedQueue(1024)
        allowCoreThreadTimeout = true
    }

/**
 * 创建 CPU 密集型线程池：线程数等于核数，避免上下文切换开销
 */
fun cpuThreadPool(name: String = "MingLiCpuPool"): ThreadPoolExecutor =
    threadPool(name) {
        corePoolSize = availableProcessors
        maximumPoolSize = availableProcessors
    }

/**
 * 创建定时任务线程池
 *
 * @param coreSize 核心线程数，默认 CPU 核数 / 2（至少 1）
 * @param name 线程池名称
 */
fun scheduledThreadPool(
    coreSize: Int = (availableProcessors / 2).coerceAtLeast(1),
    name: String = "MingLiScheduledPool",
): ScheduledThreadPoolExecutor =
    ScheduledThreadPoolExecutor(coreSize, NamedThreadFactory.of(name))
