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
 * LastUpdate 2026-10-19 20:58:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
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

    @Test
    fun testRunParallelVararg() {
        val results = runParallel(
            { 1 },
            { 2 },
            { 3 },
        )
        assertEquals(listOf(1, 2, 3), results)
    }

    @Test
    fun testRunParallelCollection() {
        val tasks = listOf<() -> String>({ "a" }, { "b" }, { "c" })
        assertEquals(listOf("a", "b", "c"), runParallel(tasks))
    }

    @Test
    fun testRunParallelKeepsOrder() {
        // 慢任务在前，结果仍按输入顺序返回
        val results = runParallel(
            { Thread.sleep(100); "slow" },
            { "fast" },
        )
        assertEquals(listOf("slow", "fast"), results)
    }

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

    @Test
    fun testRunParallelFailure() {
        assertThrows(RuntimeException::class.java) {
            runParallel(
                { 1 },
                { throw RuntimeException("task failed") },
            )
        }
    }

    @Test
    fun testRunParallelWithin() {
        val tasks = listOf<() -> Int>({ 1 }, { 2 })
        assertEquals(listOf(1, 2), runParallelWithin(5, TimeUnit.SECONDS, tasks = tasks))
    }

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

    @Test
    fun testFirstCompleted() {
        val result = firstCompleted(
            { Thread.sleep(200); "slow" },
            { "fast" },
        )
        assertEquals("fast", result)
    }

    // ---- awaitAll / invokeAllAndGet ----

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

    @Test
    fun testDelayRun() {
        val latch = CountDownLatch(1)
        val start = System.nanoTime()
        val future = delayRun(100) { latch.countDown() }
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        assertTrue(System.nanoTime() - start >= 90_000_000L, "应至少延迟 100ms 执行")
        future.cancelQuietly()
    }

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

    @Test
    fun testGlobalPools() {
        assertTrue(GlobalThreadPool.io.corePoolSize > 0)
        assertTrue(GlobalThreadPool.cpu.corePoolSize > 0)
        assertTrue(GlobalThreadPool.scheduled.corePoolSize > 0)
    }

    @Test
    fun testRunAsync() {
        assertNull(runAsync { }.get(5, TimeUnit.SECONDS))
    }

    @Test
    fun testCallAsync() {
        assertEquals("io", callAsync { "io" }.get(5, TimeUnit.SECONDS))
    }

    @Test
    fun testComputeAsync() {
        assertEquals(4, computeAsync { 2 + 2 }.get(5, TimeUnit.SECONDS))
    }

    @Test
    fun testRunAsyncAwait() {
        val counter = AtomicInteger()
        runAsyncAwait { counter.incrementAndGet() }
        assertEquals(1, counter.get())
    }

    @Test
    fun testCallAsyncAwait() {
        assertEquals("await", callAsyncAwait { "await" })
    }

    @Test
    fun testGlobalExecute() {
        val latch = CountDownLatch(1)
        GlobalThreadPool.execute { latch.countDown() }
        assertTrue(latch.await(5, TimeUnit.SECONDS))
    }
}
