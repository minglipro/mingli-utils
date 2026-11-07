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
 * CurrentFile ThreadUtils.kt
 * LastUpdate 2026-02-09 20:14:22
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

/**
 * 线程工具类，提供线程名称的获取和设置功能
 */
object ThreadUtils {
	/**
	 * 获取或设置当前线程的名称
	 *
	 * Getter: 返回当前线程的名称
	 * Setter: 设置当前线程的名称
	 *
	 * @return 当前线程的名称字符串
	 */
	@JvmStatic
	var currentThreadName: String
		get() = Thread.currentThread().name
		set(s) {
			Thread.currentThread().name = s
		}

	/**
	 * 当前线程的优先级
	 */
	@get:JvmStatic
	val currentThreadPriority: Int
		get() = Thread.currentThread().priority

	/**
	 * 当前线程是否为守护线程
	 */
	@JvmStatic
	fun isCurrentDaemon(): Boolean = Thread.currentThread().isDaemon

	/**
	 * 当前线程是否为主线程
	 */
	@JvmStatic
	fun isMainThread(): Boolean = Thread.currentThread().name == "main"

	/**
	 * 当前线程的调用栈
	 */
	@JvmStatic
	fun currentStackTrace(): Array<StackTraceElement> = Thread.currentThread().stackTrace

	/**
	 * 当前线程组
	 */
	@JvmStatic
	fun currentThreadGroup(): ThreadGroup = Thread.currentThread().threadGroup

	/**
	 * 当前线程组中活跃线程的估算数量
	 */
	@JvmStatic
	fun activeThreadCount(): Int = Thread.activeCount()

	/**
	 * 枚举当前线程组中所有活跃线程
	 */
	@JvmStatic
	fun activeThreads(): Array<Thread> {
		val all = arrayOfNulls<Thread>(Thread.activeCount() + 8)
		val count = Thread.enumerate(all)
		return all.copyOfRange(0, count).filterNotNull().toTypedArray()
	}

	/**
	 * 安静休眠：忽略中断异常，但恢复线程中断状态以便上层感知
	 *
	 * @param millis 休眠毫秒数
	 * @param nanos 额外纳秒数，取值 [0, 999999]
	 */
	@JvmStatic
	@JvmOverloads
	fun sleepQuietly(millis: Long, nanos: Int = 0) {
		try {
			Thread.sleep(millis, nanos)
		} catch (_: InterruptedException) {
			Thread.currentThread().interrupt()
		}
	}

	/**
	 * 按时间单位休眠，忽略中断异常
	 *
	 * @param timeout 休眠时长
	 * @param unit 时间单位
	 */
	@JvmStatic
	fun sleepQuietly(timeout: Long, unit: java.util.concurrent.TimeUnit) {
		sleepQuietly(unit.toMillis(timeout), (unit.toNanos(timeout) % 1_000_000).toInt())
	}

	/**
	 * 转储当前线程调用栈（字符串形式）
	 */
	@JvmStatic
	fun currentThreadDump(): String = Thread.currentThread().dumpStackTrace()

	/**
	 * 转储所有活跃线程的调用栈，便于诊断死锁/卡死
	 */
	@JvmStatic
	fun allThreadsDump(): String = buildString {
		Thread.getAllStackTraces().forEach { (thread, stack) ->
			append("thread [").append(thread.name).append("] state=").append(thread.state)
			stack.forEach { element ->
				append("\n\tat ").append(element)
			}
			append("\n\n")
		}
	}
}
