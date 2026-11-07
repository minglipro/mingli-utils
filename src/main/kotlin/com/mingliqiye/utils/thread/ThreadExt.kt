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
 * CurrentFile ThreadExt.kt
 * LastUpdate 2026-10-19 20:51:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

// ---- Runnable 扩展 ----

/**
 * 将 [Runnable] 包装为新线程并立即启动
 *
 * ```kotlin
 * Runnable { download() }.startThread("downloader", daemon = true)
 * ```
 *
 * @param name 线程名称，null 表示使用默认名称
 * @param daemon 是否为守护线程
 * @param uncaughtHandler 未捕获异常处理器
 */
fun Runnable.startThread(
	name: String? = null,
	daemon: Boolean = true,
	uncaughtHandler: Thread.UncaughtExceptionHandler? = null,
): Thread = Thread(this).apply {
	if (name != null) this.name = name
	isDaemon = daemon
	if (uncaughtHandler != null) setUncaughtExceptionHandler(uncaughtHandler)
	start()
}

/**
 * 将 [Runnable] 包装为新线程但不启动
 */
fun Runnable.asThread(
	name: String? = null,
	daemon: Boolean = true,
	uncaughtHandler: Thread.UncaughtExceptionHandler? = null,
): Thread = Thread(this).apply {
	if (name != null) this.name = name
	isDaemon = daemon
	if (uncaughtHandler != null) setUncaughtExceptionHandler(uncaughtHandler)
}

// ---- Thread 扩展 ----

/**
 * 为线程设置未捕获异常处理器（链式风格）
 *
 * ```kotlin
 * thread.onUncaught { t, e -> log.error("thread {} crashed", t.name, e) }
 * ```
 */
fun Thread.onUncaught(action: (Thread, Throwable) -> Unit): Thread = apply {
	setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler { t, e -> action(t, e) })
}

/**
 * 安静休眠：忽略中断，但恢复线程中断状态以便上层感知
 */
fun Thread.sleepQuietly(millis: Long, nanos: Int = 0) {
	try {
		Thread.sleep(millis, nanos)
	} catch (_: InterruptedException) {
		interrupt() // 恢复中断标志
	}
}

/**
 * 若线程尚未启动则启动，返回自身（链式风格）；已终止线程无法重启，静默忽略。
 */
fun Thread.startIfNotStarted(): Thread {
	if (isAlive) return this
	return try {
		start()
		this
	} catch (_: IllegalThreadStateException) {
		this
	}
}

/**
 * 阻塞等待线程结束并捕获中断
 *
 * @return 是否在中断前正常结束
 */
fun Thread.joinQuietly(millis: Long = 0): Boolean = try {
	join(millis)
	!isAlive
} catch (_: InterruptedException) {
	false
}

/**
 * 转储线程调用栈（便于排查卡死问题）
 */
fun Thread.dumpStackTrace(): String = buildString {
	append("thread [").append(name).append("] state=").append(state)
	stackTrace.forEach { element ->
		append("\n\tat ").append(element)
	}
}

// ---- 顶层便捷函数 ----

/**
 * 创建并启动守护线程
 *
 * ```kotlin
 * val t = daemonThread("watchdog") { watch() }
 * ```
 */
fun daemonThread(
	name: String = "MingLiDaemon",
	start: Boolean = true,
	uncaughtHandler: Thread.UncaughtExceptionHandler? = null,
	block: () -> Unit,
): Thread = Thread(block, name).apply {
	isDaemon = true
	if (uncaughtHandler != null) setUncaughtExceptionHandler(uncaughtHandler)
	if (start) start()
}

/**
 * 创建非守护线程
 */
fun userThread(
	name: String = "MingLiUser",
	start: Boolean = true,
	uncaughtHandler: Thread.UncaughtExceptionHandler? = null,
	block: () -> Unit,
): Thread = Thread(block, name).apply {
	isDaemon = false
	if (uncaughtHandler != null) setUncaughtExceptionHandler(uncaughtHandler)
	if (start) start()
}

/**
 * 便捷构造未捕获异常处理器
 */
fun uncaughtExceptionHandler(action: (Thread, Throwable) -> Unit): Thread.UncaughtExceptionHandler =
	Thread.UncaughtExceptionHandler { t, e -> action(t, e) }

/**
 * 获取当前线程
 */
fun currentThread(): Thread = Thread.currentThread()
