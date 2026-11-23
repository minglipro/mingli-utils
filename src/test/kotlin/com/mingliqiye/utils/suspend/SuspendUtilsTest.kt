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
 * CurrentFile SuspendUtilsTest.kt
 * LastUpdate 2026-11-23 09:14:46
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.suspend

import com.mingliqiye.utils.thread.GlobalThreadPool
import kotlinx.coroutines.delay
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

/**
 * SuspendUtils 协程工具与 [GlobalThreadPool] 调度器的集成测试
 */
class SuspendUtilsTest {

    /** 测试 CoroutineContext.runBlocking 使用接收者上下文执行协程 */
    @Test
    fun testContextRunBlockingUsesReceiverContext() {
        val caller = Thread.currentThread()
        val worker = GlobalThreadPool.ioDispatcher.runBlocking { Thread.currentThread() }
        assertNotEquals(caller, worker, "receiver context was ignored")
    }

    /** 测试顶层 runBlocking 使用调用线程的事件循环，不占用全局线程池 */
    @Test
    fun testRunBlockingRunsOnCallerThread() {
        val caller = Thread.currentThread()
        val thread = com.mingliqiye.utils.suspend.runBlocking { Thread.currentThread() }
        assertSame(caller, thread)
    }

    /** 测试 runBlocking 内挂起（delay）后仍能按时恢复 */
    @Test
    fun testRunBlockingSupportsDelay() {
        val start = System.nanoTime()
        com.mingliqiye.utils.suspend.runBlocking { delay(100) }
        val elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start)
        assertTrue(elapsedMillis >= 90, "delay resumed too early: ${elapsedMillis}ms")
    }
}
