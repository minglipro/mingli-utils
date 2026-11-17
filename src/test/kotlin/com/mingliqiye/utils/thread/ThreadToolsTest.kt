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
 * CurrentFile ThreadToolsTest.kt
 * LastUpdate 2026-10-19 20:58:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

/**
 * ThreadUtils / ThreadExt / ThreadLocalDelegates 的测试
 */
class ThreadToolsTest {

    // ---- ThreadLocal 属性委托（每个测试方法独立实例，互不影响） ----

    private var userValue: Long by threadLocal { 0L }

    private var nullableValue: String? by nullableThreadLocal()

    /** 将已有 ThreadLocal 实例包装为属性委托 */
    private var delegatedValue: String? by ThreadLocal<String?>().asDelegate()

    // ---- ThreadUtils ----

    /** 测试 sleepQuietly 毫秒重载的休眠时长 */
    @Test
    fun testSleepQuietlyMillis() {
        val start = System.nanoTime()
        ThreadUtils.sleepQuietly(100)
        assertTrue(System.nanoTime() - start >= 90_000_000L, "应至少休眠 100ms")
    }

    /** 测试 sleepQuietly 时间单位重载的休眠时长 */
    @Test
    fun testSleepQuietlyTimeUnit() {
        val start = System.nanoTime()
        ThreadUtils.sleepQuietly(50, TimeUnit.MILLISECONDS)
        assertTrue(System.nanoTime() - start >= 40_000_000L, "应至少休眠 50ms")
    }

    /** 测试 currentThreadName 属性的读写 */
    @Test
    fun testCurrentThreadNameProperty() {
        assertEquals(Thread.currentThread().name, ThreadUtils.currentThreadName)
        val old = ThreadUtils.currentThreadName
        try {
            ThreadUtils.currentThreadName = "renamed-test"
            assertEquals("renamed-test", Thread.currentThread().name)
        } finally {
            ThreadUtils.currentThreadName = old
        }
    }

    /** 测试当前线程优先级、守护状态、主线程判断、堆栈与线程组等信息获取 */
    @Test
    fun testCurrentThreadInfo() {
        assertEquals(Thread.currentThread().priority, ThreadUtils.currentThreadPriority)
        assertFalse(ThreadUtils.isCurrentDaemon())
        assertEquals(Thread.currentThread().name == "main", ThreadUtils.isMainThread())
        assertTrue(ThreadUtils.currentStackTrace().isNotEmpty())
        assertSame(Thread.currentThread().threadGroup, ThreadUtils.currentThreadGroup())
        assertTrue(ThreadUtils.activeThreadCount() >= 1)
    }

    /** 测试 activeThreads 返回的活跃线程包含当前线程 */
    @Test
    fun testActiveThreads() {
        val threads = ThreadUtils.activeThreads()
        assertTrue(threads.any { it === Thread.currentThread() }, "活跃线程应包含当前线程")
    }

    /** 测试 allThreadsDump 全线程转储包含当前线程名 */
    @Test
    fun testAllThreadsDump() {
        val dump = ThreadUtils.allThreadsDump()
        assertTrue(dump.contains(Thread.currentThread().name), "全线程转储应包含当前线程名")
    }

    /** 测试 currentThreadDump 当前线程转储包含测试方法名 */
    @Test
    fun testCurrentThreadDump() {
        val dump = ThreadUtils.currentThreadDump()
        assertTrue(dump.contains("testCurrentThreadDump"), "当前线程转储应包含测试方法名")
    }

    // ---- ThreadExt ----

    /** 测试 Runnable.startThread 创建并启动指定名称的守护线程 */
    @Test
    fun testStartThread() {
        val latch = CountDownLatch(1)
        val thread = Runnable { latch.countDown() }.startThread("start-test", daemon = true)
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        assertTrue(thread.isDaemon)
        assertEquals("start-test", thread.name)
        thread.joinQuietly(2000)
    }

    /** 测试 asThread 仅创建线程而不启动 */
    @Test
    fun testAsThreadNotStarted() {
        val thread = Runnable { }.asThread("no-start")
        assertFalse(thread.isAlive)
        assertTrue(thread.isDaemon)
        assertEquals("no-start", thread.name)
    }

    /** 测试 daemonThread 与 userThread 的守护属性差异 */
    @Test
    fun testDaemonAndUserThread() {
        val latch = CountDownLatch(2)
        val daemon = daemonThread("daemon-t") { latch.countDown() }
        val user = userThread("user-t") { latch.countDown() }
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        assertTrue(daemon.isDaemon)
        assertFalse(user.isDaemon)
        daemon.joinQuietly(2000)
        user.joinQuietly(2000)
    }

    /** 测试 daemonThread start=false 时不启动线程 */
    @Test
    fun testDaemonThreadNotStarted() {
        val thread = daemonThread("no-start-daemon", start = false) { }
        assertFalse(thread.isAlive)
        assertTrue(thread.isDaemon)
    }

    /** 测试 uncaughtExceptionHandler 捕获线程未处理异常 */
    @Test
    fun testOnUncaughtHandler() {
        val latch = CountDownLatch(1)
        val captured = AtomicReference<Throwable?>()
        val handler = uncaughtExceptionHandler { _, e ->
            captured.set(e)
            latch.countDown()
        }
        Runnable { throw IllegalStateException("boom") }
            .asThread("crash-test", uncaughtHandler = handler)
            .start()
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        assertTrue(captured.get() is IllegalStateException)
        assertEquals("boom", captured.get()!!.message)
    }

    /** 测试 startIfNotStarted 幂等启动且对已终止线程不抛异常 */
    @Test
    fun testStartIfNotStarted() {
        val thread = Runnable { }.asThread("idempotent-start")
        assertSame(thread, thread.startIfNotStarted())
        assertTrue(thread.isAlive)
        thread.joinQuietly(2000)
        assertFalse(thread.isAlive)
        // 已终止线程再次调用不应抛异常
        assertSame(thread, thread.startIfNotStarted())
    }

    /** 测试 Thread.sleepQuietly 扩展函数的休眠时长 */
    @Test
    fun testSleepQuietlyExt() {
        val start = System.nanoTime()
        Thread.currentThread().sleepQuietly(50)
        assertTrue(System.nanoTime() - start >= 40_000_000L, "应至少休眠 50ms")
    }

    /** 测试 Thread.dumpStackTrace 扩展输出包含线程名与方法名 */
    @Test
    fun testDumpStackTrace() {
        val dump = Thread.currentThread().dumpStackTrace()
        assertTrue(dump.contains(Thread.currentThread().name))
        assertTrue(dump.contains("testDumpStackTrace"))
    }

    /** 测试顶层 currentThread() 返回当前线程 */
    @Test
    fun testCurrentThreadTopLevel() {
        assertSame(Thread.currentThread(), currentThread())
    }

    // ---- ThreadLocalDelegates ----

    /** 测试 ThreadLocal 属性委托在同线程内的初始值与读写 */
    @Test
    fun testThreadLocalSameThread() {
        assertNull(nullableValue)
        nullableValue = "hello"
        assertEquals("hello", nullableValue)

        assertEquals(0L, userValue)
        userValue = 42L
        assertEquals(42L, userValue)
    }

    /** 测试 ThreadLocal 属性委托的线程间隔离性 */
    @Test
    fun testThreadLocalIsolation() {
        val latch = CountDownLatch(1)
        val threadValues = ConcurrentLinkedQueue<Long>()
        // 主线程先设置自己的值
        userValue = 100L
        val thread = daemonThread("tl-isolation") {
            assertEquals(0L, userValue, "新线程应获得初始值而非主线程的值")
            userValue = 7L
            threadValues.add(userValue)
            latch.countDown()
        }
        assertTrue(latch.await(3, TimeUnit.SECONDS))
        thread.joinQuietly(2000)
        assertEquals(100L, userValue, "主线程的值不受子线程影响")
        assertEquals(listOf(7L), threadValues.toList())
    }

    /** 测试 asDelegate 将已有 ThreadLocal 包装为属性委托后的读写 */
    @Test
    fun testAsDelegateProperty() {
        assertNull(delegatedValue)
        delegatedValue = "set"
        assertEquals("set", delegatedValue)
    }
}
