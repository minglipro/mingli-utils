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
 * CurrentFile ThreadPoolExtTest.kt
 * LastUpdate 2026-10-19 20:58:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * ThreadPoolExt 线程池扩展与 ThreadPoolMonitor 监控的测试
 */
class ThreadPoolExtTest {

    // ---- shutdownGracefully ----

    @Test
    fun testShutdownGracefully() {
        val pool = fixedThreadPool(2, "shutdown-test")
        pool.execute { Thread.sleep(50) }
        assertTrue(pool.shutdownGracefully(5, TimeUnit.SECONDS))
        assertTrue(pool.isTerminated)
    }

    @Test
    fun testShutdownAndAwait() {
        val pool = fixedThreadPool(1, "shutdown-await-test")
        pool.execute { }
        pool.shutdownAndAwait(5, TimeUnit.SECONDS)
        assertTrue(pool.isTerminated)
    }

    @Test
    fun testShutdownAndAwaitTimeout() {
        val pool = singleThreadPool("shutdown-timeout-test")
        // 忙等任务不响应中断，shutdownNow 无法立即终止它
        pool.execute {
            val end = System.nanoTime() + 2_000_000_000L
            while (System.nanoTime() < end) {
                // 忙等，忽略中断
            }
        }
        assertThrows(IllegalStateException::class.java) {
            pool.shutdownAndAwait(100, TimeUnit.MILLISECONDS)
        }
        pool.shutdownNow()
    }

    // ---- Future 扩展 ----

    @Test
    fun testFutureAwait() {
        val pool = singleThreadPool("await-test")
        try {
            val future = pool.submit(Callable { "result" })
            assertEquals("result", future.await())
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testFutureAwaitUnwrapException() {
        val pool = singleThreadPool("unwrap-test")
        try {
            val future = pool.submit(Callable { throw IllegalArgumentException("boom") })
            assertThrows(IllegalArgumentException::class.java) {
                future.await()
            }
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testFutureAwaitWithTimeout() {
        val pool = singleThreadPool("await-timeout-test")
        try {
            val future = pool.submit(Callable {
                Thread.sleep(500)
                "late"
            })
            assertThrows(java.util.concurrent.TimeoutException::class.java) {
                future.await(100, TimeUnit.MILLISECONDS)
            }
            // 任务最终仍会完成
            assertEquals("late", future.get(3, TimeUnit.SECONDS))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testGetOrNullTimeout() {
        val pool = singleThreadPool("getornull-test")
        try {
            val future = pool.submit(Callable {
                Thread.sleep(500)
                1
            })
            assertNull(future.getOrNull(100, TimeUnit.MILLISECONDS))
            assertEquals(1, future.get(3, TimeUnit.SECONDS))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testGetOrNullFailure() {
        val pool = singleThreadPool("getornull-fail-test")
        try {
            val future = pool.submit(Callable { throw RuntimeException("fail") })
            assertNull(future.getOrNull(3, TimeUnit.SECONDS))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testGetOrDefault() {
        val pool = singleThreadPool("getordefault-test")
        try {
            val failing: java.util.concurrent.Future<Int> =
                pool.submit(Callable<Int> { throw RuntimeException("fail") })
            assertEquals(-1, failing.getOrDefault(-1, 3, TimeUnit.SECONDS))

            val ok = pool.submit(Callable { 5 })
            assertEquals(5, ok.getOrDefault(-1, 3, TimeUnit.SECONDS))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testCancelQuietly() {
        val pool = singleThreadPool("cancel-test")
        try {
            val future = pool.submit(Callable {
                Thread.sleep(500)
                1
            })
            assertTrue(future.cancelQuietly())
            assertTrue(future.isCancelled)
        } finally {
            pool.shutdown()
        }
    }

    // ---- CompletableFuture ----

    @Test
    fun testCompletableFuture() {
        val future = completableFuture { 1 + 1 }
        assertEquals(2, future.get(3, TimeUnit.SECONDS))
    }

    @Test
    fun testCompletableFutureWithExecutor() {
        val pool = fixedThreadPool(2, "cf-test")
        try {
            val future = completableFuture(pool) { "exec" }
            assertEquals("exec", future.get(3, TimeUnit.SECONDS))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testRunCompletableFuture() {
        val latch = CountDownLatch(1)
        val future = runCompletableFuture { latch.countDown() }
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        assertNull(future.get(3, TimeUnit.SECONDS))
    }

    // ---- ThreadPoolMonitor ----

    @Test
    fun testSnapshot() {
        val pool = fixedThreadPool(2, "snapshot-test")
        try {
            pool.invokeAll(listOf(Callable { 1 }, Callable { 2 }))
            val snapshot = pool.snapshot()
            assertEquals(2, snapshot.corePoolSize)
            assertEquals(2, snapshot.maximumPoolSize)
            assertEquals(2, snapshot.poolSize)
            assertTrue(snapshot.completedTasks >= 2)
            assertTrue(snapshot.totalTasks >= 2)
            assertTrue(snapshot.utilization in 0.0..1.0)
            assertTrue(snapshot.queueSize >= 0)
            assertFalse(snapshot.isShutdown)
            assertFalse(snapshot.isTerminated)
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testSnapshotToString() {
        val pool = fixedThreadPool(1, "snapshot-string-test")
        try {
            val text = pool.snapshot().toString()
            assertTrue(text.startsWith("ThreadPoolSnapshot["))
            assertTrue(text.contains("size="))
            assertTrue(text.contains("queue="))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testReport() {
        val pool = fixedThreadPool(1, "report-test")
        try {
            val report = pool.report()
            assertTrue(report.startsWith("ThreadPoolSnapshot["))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testMonitorPeriodic() {
        val pool = fixedThreadPool(2, "monitor-test")
        val scheduler = ScheduledThreadPoolExecutor(1)
        val latch = CountDownLatch(2)
        val handle = pool.monitor(30, TimeUnit.MILLISECONDS, scheduler = scheduler) { snapshot ->
            if (snapshot.completedTasks >= 0) {
                latch.countDown()
            }
        }
        try {
            assertTrue(latch.await(5, TimeUnit.SECONDS), "应至少收到 2 次监控回调")
        } finally {
            handle.cancel(true)
            scheduler.shutdownNow()
            pool.shutdown()
        }
    }
}
