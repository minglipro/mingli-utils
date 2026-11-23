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
 * ModuleName mingli-utils.test
 * CurrentFile AsyncTasksTest.kt
 * LastUpdate 2026-11-23 09:45:49
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.concurrent.atomic.AtomicInteger

/**
 * AsyncTasks 并发任务编排与 GlobalThreadPool 的测试
 */
class AsyncTasksTest {

    // ---- runParallel ----

    /** 测试 runParallel 可变参数形式并行执行并按序返回结果 */
    @Test
    fun testRunParallelVararg() {
        val results = runParallel(
            { 1 },
            { 2 },
            { 3 },
        )
        assertEquals(listOf(1, 2, 3), results)
    }

    /** 测试 runParallel 集合形式并行执行任务 */
    @Test
    fun testRunParallelCollection() {
        val tasks = listOf<() -> String>({ "a" }, { "b" }, { "c" })
        assertEquals(listOf("a", "b", "c"), runParallel(tasks))
    }

    /** 测试 runParallel 结果顺序与输入顺序一致（慢任务在前） */
    @Test
    fun testRunParallelKeepsOrder() {
        // 慢任务在前，结果仍按输入顺序返回
        val results = runParallel(
            { Thread.sleep(100); "slow" },
            { "fast" },
        )
        assertEquals(listOf("slow", "fast"), results)
    }

    /** 测试 runParallel 使用自定义线程池执行 */
    @Test
    fun testRunParallelCustomExecutor() {
        val pool = fixedThreadPool(2, "parallel-test")
        try {
            val results = runParallel({ 1 }, { 2 }, executor = pool)
            assertEquals(listOf(1, 2), results)
        } finally {
            pool.shutdown()
        }
    }

    /** 测试 runParallel 中任务失败时向外抛出异常 */
    @Test
    fun testRunParallelFailure() {
        assertThrows(RuntimeException::class.java) {
            runParallel(
                { 1 },
                { throw RuntimeException("task failed") },
            )
        }
    }

    /** 测试 runParallelWithin 在超时时间内正常返回结果 */
    @Test
    fun testRunParallelWithin() {
        val tasks = listOf<() -> Int>({ 1 }, { 2 })
        assertEquals(listOf(1, 2), runParallelWithin(5, TimeUnit.SECONDS, tasks = tasks))
    }

    /** 测试 runParallelWithin 超时抛出 TimeoutException */
    @Test
    fun testRunParallelWithinTimeout() {
        assertThrows(TimeoutException::class.java) {
            runParallelWithin(
                timeout = 100,
                unit = TimeUnit.MILLISECONDS,
                tasks = listOf({ Thread.sleep(1000); 1 }),
            )
        }
    }

    // ---- firstCompleted ----

    /** 测试 firstCompleted 返回最先完成任务的结果 */
    @Test
    fun testFirstCompleted() {
        val result = firstCompleted(
            { Thread.sleep(200); "slow" },
            { "fast" },
        )
        assertEquals("fast", result)
    }

    // ---- awaitAll / invokeAllAndGet ----

    /** 测试 awaitAll 按序等待并收集所有 Future 结果 */
    @Test
    fun testAwaitAll() {
        val pool = fixedThreadPool(2, "await-all-test")
        try {
            val futures = (1..3).map { i -> pool.submit(Callable { i * 10 }) }
            assertEquals(listOf(10, 20, 30), awaitAll(futures))
        } finally {
            pool.shutdown()
        }
    }

    /** 测试 invokeAllAndGet 批量提交任务并获取结果 */
    @Test
    fun testInvokeAllAndGet() {
        val pool = fixedThreadPool(2, "invoke-all-test")
        try {
            val results = pool.invokeAllAndGet(listOf(Callable { "a" }, Callable { "b" }))
            assertEquals(listOf("a", "b"), results)
        } finally {
            pool.shutdown()
        }
    }

    /** 测试 awaitAllOrNull 对失败任务返回 null 而不抛异常 */
    @Test
    fun testAwaitAllOrNull() {
        val pool = fixedThreadPool(2, "await-ornull-test")
        try {
            val futures: List<java.util.concurrent.Future<Int>> = listOf(
                pool.submit(Callable { 1 }),
                pool.submit(Callable<Int> { throw RuntimeException("fail") }),
            )
            val results = awaitAllOrNull(futures)
            assertEquals(1, results[0])
            assertNull(results[1], "失败任务应返回 null")
        } finally {
            pool.shutdown()
        }
    }

    // ---- callWithRetry ----

    /** 测试 callWithRetry 失败后重试直至成功 */
    @Test
    fun testCallWithRetrySuccess() {
        val attempts = AtomicInteger()
        val result = callWithRetry(3) {
            if (attempts.incrementAndGet() < 3) throw IllegalStateException("fail")
            "ok"
        }
        assertEquals(3, attempts.get())
        assertEquals("ok", result)
    }

    /** 测试 callWithRetry 重试次数耗尽后抛出最后一次异常 */
    @Test
    fun testCallWithRetryExhausted() {
        val attempts = AtomicInteger()
        assertThrows(IllegalStateException::class.java) {
            callWithRetry(2) {
                attempts.incrementAndGet()
                throw IllegalStateException("always fail")
            }
        }
        assertEquals(2, attempts.get(), "应恰好尝试 2 次")
    }

    /** 测试 callAsyncWithRetry 异步重试直至成功 */
    @Test
    fun testCallAsyncWithRetry() {
        val attempts = AtomicInteger()
        val result = callAsyncWithRetry(3) {
            if (attempts.incrementAndGet() < 3) throw IllegalStateException("fail")
            "async-ok"
        }.get(5, TimeUnit.SECONDS)
        assertEquals(3, attempts.get())
        assertEquals("async-ok", result)
    }

    // ---- 定时任务 ----

    /** 测试 delayRun 延迟指定时间后执行任务 */
    @Test
    fun testDelayRun() {
        val latch = CountDownLatch(1)
        val start = System.nanoTime()
        val future = delayRun(100) { latch.countDown() }
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        assertTrue(System.nanoTime() - start >= 90_000_000L, "应至少延迟 100ms 执行")
        future.cancelQuietly()
    }

    /** 测试 scheduleWithFixedDelay 固定间隔重复执行任务 */
    @Test
    fun testScheduleWithFixedDelay() {
        val counter = AtomicInteger()
        val latch = CountDownLatch(3)
        val future = scheduleWithFixedDelay(30, TimeUnit.MILLISECONDS, initialDelay = 0) {
            counter.incrementAndGet()
            latch.countDown()
        }
        try {
            assertTrue(latch.await(5, TimeUnit.SECONDS))
            assertTrue(counter.get() >= 3)
        } finally {
            future.cancel(true)
        }
    }

    /** 测试 scheduleAtFixedRate 固定频率重复执行任务 */
    @Test
    fun testScheduleAtFixedRate() {
        val counter = AtomicInteger()
        val latch = CountDownLatch(3)
        val future = scheduleAtFixedRate(30, TimeUnit.MILLISECONDS, initialDelay = 0) {
            counter.incrementAndGet()
            latch.countDown()
        }
        try {
            assertTrue(latch.await(5, TimeUnit.SECONDS))
            assertTrue(counter.get() >= 3)
        } finally {
            future.cancel(true)
        }
    }

    // ---- GlobalThreadPool ----

    /** 测试 GlobalThreadPool 的 main/io/cpu/scheduled 全局线程池已正确初始化 */
    @Test
    fun testGlobalPools() {
        assertFalse(GlobalThreadPool.isShutdown)
        assertTrue(GlobalThreadPool.main.corePoolSize > 0)
        assertTrue(GlobalThreadPool.io.corePoolSize > 0)
        assertTrue(GlobalThreadPool.cpu.corePoolSize > 0)
        assertTrue(GlobalThreadPool.scheduled.corePoolSize > 0)
    }

    /** 测试全局池注册表与批量快照的名称、顺序一致 */
    @Test
    fun testGlobalPoolRegistry() {
        val pools = GlobalThreadPool.pools()
        assertEquals(listOf("main", "io", "cpu", "scheduled"), pools.keys.toList())
        val snapshots = GlobalThreadPool.snapshotAll()
        assertEquals(pools.keys.toList(), snapshots.keys.toList())
        assertTrue(snapshots.getValue("io").maximumPoolSize > 0)
    }

    /** 测试全局池的工作线程为守护线程，不会阻止 JVM 退出 */
    @Test
    fun testGlobalPoolThreadsAreDaemon() {
        val daemon = GlobalThreadPool.callAsync { Thread.currentThread().isDaemon }.get(5, TimeUnit.SECONDS)
        assertTrue(daemon)
    }

    /** 测试 mainDispatcher 复用 Dispatchers.Default，而不是 main 线程池 */
    @Test
    fun testMainDispatcher() = runBlocking {
        val caller = Thread.currentThread()
        val thread = withContext(GlobalThreadPool.mainDispatcher) { Thread.currentThread() }
        assertNotEquals(caller, thread)
        assertTrue(thread.name.startsWith("DefaultDispatcher-worker"), "unexpected thread: ${thread.name}")
        assertTrue(thread.isDaemon)
    }

    /** 测试 dispatcher 映射：main/io 是共享调度器的命名限流视图，cpu 绑定 cpu 池 */
    @Test
    fun testDispatchersMapping() {
        assertEquals("MingLiGlobalMainDispatcher", GlobalThreadPool.mainDispatcher.toString())
        assertEquals("MingLiGlobalIODispatcher", GlobalThreadPool.ioDispatcher.toString())
        val cpuExecutor = (GlobalThreadPool.cpuDispatcher as? ExecutorCoroutineDispatcher)?.executor
        assertSame(GlobalThreadPool.cpu, cpuExecutor)
    }

    /** 测试 cpuDispatcher 在 MingLiGlobalCPU 的守护线程上执行 */
    @Test
    fun testCpuDispatcher() = runBlocking {
        val thread = withContext(GlobalThreadPool.cpuDispatcher) { Thread.currentThread() }
        assertTrue(thread.name.startsWith("MingLiGlobalCPU"), "unexpected thread: ${thread.name}")
        assertTrue(thread.isDaemon)
    }

    /** 测试 ioDispatcher 上的 delay 悬起后仍能按时恢复 */
    @Test
    fun testIoDispatcherDelay() = runBlocking {
        val start = System.nanoTime()
        withContext(GlobalThreadPool.ioDispatcher) { delay(100) }
        val elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start)
        assertTrue(elapsedMillis >= 90, "delay resumed too early: ${elapsedMillis}ms")
    }

    /** 测试 runAsync 异步执行无返回值任务 */
    @Test
    fun testRunAsync() {
        assertNull(GlobalThreadPool.runAsync { }.get(5, TimeUnit.SECONDS))
    }

    /** 测试 callAsync 在 IO 线程池异步执行并返回结果 */
    @Test
    fun testCallAsync() {
        assertEquals("io", GlobalThreadPool.callAsync { "io" }.get(5, TimeUnit.SECONDS))
    }

    /** 测试 computeAsync 在 CPU 线程池异步计算并返回结果 */
    @Test
    fun testComputeAsync() {
        assertEquals(4, GlobalThreadPool.computeAsync { 2 + 2 }.get(5, TimeUnit.SECONDS))
    }

    /** 测试 runAsyncAwait 异步执行并阻塞等待完成 */
    @Test
    fun testRunAsyncAwait() {
        val counter = AtomicInteger()
        GlobalThreadPool.runAsyncAwait { counter.incrementAndGet() }
        assertEquals(1, counter.get())
    }

    /** 测试 callAsyncAwait 异步执行并阻塞等待返回结果 */
    @Test
    fun testCallAsyncAwait() {
        assertEquals("await", GlobalThreadPool.callAsyncAwait { "await" })
    }

    /** 测试 GlobalThreadPool.execute 提交任务并被执行 */
    @Test
    fun testGlobalExecute() {
        val latch = CountDownLatch(1)
        GlobalThreadPool.execute { latch.countDown() }
        assertTrue(latch.await(5, TimeUnit.SECONDS))
    }
}
