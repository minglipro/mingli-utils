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
 * CurrentFile ThreadEventTest.kt
 * LastUpdate 2026-10-19 20:58:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * ThreadEvent 线程事件同步的测试
 */
class ThreadEventTest {

    /** 属性委托支持：`var value by event` */
    private val event = ThreadEvent.of(0)
    private var value: Int by event

    @Test
    fun testAwaitAndSet() {
        val event = ThreadEvent.of(0)
        val latch = CountDownLatch(1)
        val thread = daemonThread("event-await") {
            event.await()
            latch.countDown()
        }
        event.set(42)
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        thread.joinQuietly(2000)
        assertEquals(42, event.get())
    }

    @Test
    fun testAwaitAndGet() {
        val event = ThreadEvent.of(0)
        val ready = CountDownLatch(1)
        val result = AtomicInteger()
        val thread = daemonThread("event-await-get") {
            ready.countDown()
            result.set(event.awaitAndGet())
        }
        assertTrue(ready.await(3, TimeUnit.SECONDS))
        event.set(99)
        thread.joinQuietly(3000)
        assertEquals(99, result.get())
    }

    @Test
    fun testAwaitTimeout() {
        val event = ThreadEvent.of(0)
        val start = System.nanoTime()
        assertFalse(event.await(100, TimeUnit.MILLISECONDS), "无 set 时 await 应超时")
        assertTrue(System.nanoTime() - start >= 90_000_000L, "应至少等待 100ms")
    }

    @Test
    fun testAwaitAndGetTimeout() {
        val event = ThreadEvent.of(10)
        // 超时未触发，返回旧数据（原有语义）
        assertEquals(10, event.awaitAndGet(50, TimeUnit.MILLISECONDS))
    }

    @Test
    fun testAwaitAndGetOrNullTimeout() {
        val event = ThreadEvent.of(10)
        assertNull(event.awaitAndGetOrNull(50, TimeUnit.MILLISECONDS), "超时未触发应返回 null")
    }

    @Test
    fun testAwaitAndGetOrNullTriggered() {
        val event = ThreadEvent.of(0)
        val thread = daemonThread("event-or-null") {
            Thread.sleep(50)
            event.set(5)
        }
        assertEquals(5, event.awaitAndGetOrNull(3, TimeUnit.SECONDS))
        thread.joinQuietly(2000)
    }

    @Test
    fun testIsSet() {
        val event = ThreadEvent.of(0)
        assertFalse(event.isSet())
        event.set(1)
        assertTrue(event.isSet())
        event.reset()
        assertFalse(event.isSet())
    }

    @Test
    fun testSetAndReset() {
        val event = ThreadEvent.of(0)
        event.setAndReset(5)
        assertEquals(5, event.get())
        assertFalse(event.isSet(), "reset 后事件应处于未设置状态")
    }

    @Test
    fun testOperatorInvoke() {
        val event = ThreadEvent.of("a")
        assertEquals("a", event(), "invoke() 应读取数据")

        val latch = CountDownLatch(1)
        val thread = daemonThread("event-invoke") {
            event.await()
            latch.countDown()
        }
        event("b")
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        thread.joinQuietly(2000)
        assertEquals("b", event())
    }

    @Test
    fun testPropertyDelegate() {
        assertEquals(0, value)
        value = 7
        assertEquals(7, event.get())
        assertEquals(7, value)
    }

    @Test
    fun testFactoryOf() {
        val event = ThreadEvent.of("data")
        assertEquals("data", event.get())
    }
}
