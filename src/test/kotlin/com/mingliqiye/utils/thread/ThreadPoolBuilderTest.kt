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
 * CurrentFile ThreadPoolBuilderTest.kt
 * LastUpdate 2026-10-19 20:58:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import com.mingliqiye.utils.system.availableProcessors
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.Callable
import java.util.concurrent.CountDownLatch
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * ThreadPoolBuilder DSL 与预设工厂的测试
 */
class ThreadPoolBuilderTest {

    @Test
    fun testDslBuild() {
        val pool = threadPool("dsl-test") {
            corePoolSize = 2
            maximumPoolSize = 4
            boundedQueue(10)
            keepAliveSeconds = 30
            allowCoreThreadTimeout = true
        }
        try {
            assertEquals(2, pool.corePoolSize)
            assertEquals(4, pool.maximumPoolSize)
            assertEquals(10, pool.queue.remainingCapacity())
            assertTrue(pool.queue is ArrayBlockingQueue<*>)
            assertTrue(pool.allowsCoreThreadTimeOut())
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testDefaultQueueIsUnbounded() {
        val pool = threadPool("unbounded-test")
        try {
            assertEquals(Int.MAX_VALUE, pool.queue.remainingCapacity())
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testFixedPool() {
        val pool = fixedThreadPool(4, "fixed-test")
        try {
            assertEquals(4, pool.corePoolSize)
            assertEquals(4, pool.maximumPoolSize)
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testSinglePool() {
        val pool = singleThreadPool("single-test")
        try {
            assertEquals(1, pool.corePoolSize)
            assertEquals(1, pool.maximumPoolSize)
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testCachedPool() {
        val pool = cachedThreadPool("cached-test")
        try {
            assertEquals(0, pool.corePoolSize)
            assertEquals(Int.MAX_VALUE, pool.maximumPoolSize)
            assertTrue(pool.queue is SynchronousQueue<*>)
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testIoPool() {
        val pool = ioThreadPool("io-test")
        try {
            assertEquals(availableProcessors * 2, pool.corePoolSize)
            assertEquals(availableProcessors * 4, pool.maximumPoolSize)
            assertEquals(1024, pool.queue.remainingCapacity())
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testCpuPool() {
        val pool = cpuThreadPool("cpu-test")
        try {
            assertEquals(availableProcessors, pool.corePoolSize)
            assertEquals(availableProcessors, pool.maximumPoolSize)
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testDaemonThread() {
        val pool = threadPool("daemon-test") {
            corePoolSize = 1
            maximumPoolSize = 1
            daemon = true
        }
        try {
            val future = pool.submit(Callable { Thread.currentThread().isDaemon })
            assertTrue(future.get(5, TimeUnit.SECONDS))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testNonDaemonThread() {
        val pool = threadPool("non-daemon-test") {
            corePoolSize = 1
            maximumPoolSize = 1
            daemon = false
        }
        try {
            val future = pool.submit(Callable { Thread.currentThread().isDaemon })
            assertFalse(future.get(5, TimeUnit.SECONDS))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testThreadNaming() {
        val pool = threadPool("naming-test") {
            corePoolSize = 2
            maximumPoolSize = 2
        }
        try {
            val future = pool.submit(Callable { Thread.currentThread().name })
            val name = future.get(5, TimeUnit.SECONDS)
            assertNotNull(name)
            assertTrue(name!!.contains("naming-test"))
        } finally {
            pool.shutdown()
        }
    }

    @Test
    fun testRejectedPolicy() {
        val pool = threadPool("reject-test") {
            corePoolSize = 1
            maximumPoolSize = 1
            boundedQueue(1)
            rejectedHandler = ThreadPoolExecutor.AbortPolicy()
        }
        val release = CountDownLatch(1)
        try {
            // 任务1 占用唯一线程
            pool.execute { release.await() }
            // 任务2 占满队列
            pool.execute { }
            // 任务3 触发拒绝
            assertThrows(RejectedExecutionException::class.java) {
                pool.execute { }
            }
        } finally {
            release.countDown()
            pool.shutdown()
        }
    }

    @Test
    fun testScheduledPool() {
        val pool = scheduledThreadPool(2, "scheduled-test")
        try {
            val latch = CountDownLatch(1)
            pool.schedule({ latch.countDown() }, 50, TimeUnit.MILLISECONDS)
            assertTrue(latch.await(3, TimeUnit.SECONDS))
        } finally {
            pool.shutdown()
        }
    }
}
