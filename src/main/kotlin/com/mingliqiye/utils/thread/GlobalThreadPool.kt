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
 * CurrentFile GlobalThreadPool.kt
 * LastUpdate 2026-10-19 20:51:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import com.mingliqiye.utils.netty.NamedThreadFactory
import com.mingliqiye.utils.system.availableProcessors
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.ThreadPoolExecutor

/**
 * 全局线程池，按任务类型提供三类共享池，通过 `by lazy` 懒加载。
 *
 * ```kotlin
 * GlobalThreadPool.io.execute { download() }
 * val result = GlobalThreadPool.cpu.submit { compute() }.get()
 * runAsync { log("done") }
 * ```
 */
object GlobalThreadPool {

	/** IO 密集型全局池：线程多、队列有界，适合网络/磁盘等阻塞任务 */
	val io: ThreadPoolExecutor by lazy {
		threadPool("MingLiGlobalIO") {
			corePoolSize = availableProcessors * 2
			maximumPoolSize = availableProcessors * 4
			boundedQueue(1024)
			allowCoreThreadTimeout = true
			daemon = true
		}
	}

	/** CPU 密集型全局池：线程数等于核数，适合纯计算任务 */
	val cpu: ThreadPoolExecutor by lazy {
		threadPool("MingLiGlobalCPU") {
			corePoolSize = availableProcessors
			maximumPoolSize = availableProcessors
			daemon = true
		}
	}

	/** 全局定时任务池 */
	val scheduled: ScheduledThreadPoolExecutor by lazy {
		// 包装一层将定时线程设为守护线程，避免阻塞 JVM 退出
		val base = NamedThreadFactory.of("MingLiGlobalScheduled")
		ScheduledThreadPoolExecutor(
			(availableProcessors / 2).coerceAtLeast(1),
		) { runnable -> base.newThread(runnable).apply { isDaemon = true } }
	}

	// ---- 便捷提交 ----

	/**
	 * 向全局 IO 池提交无返回值任务
	 *
	 * @param runnable 要执行的任务
	 * @return 任务句柄，可用于等待完成或取消
	 */
	@JvmStatic
	fun execute(runnable: Runnable): Future<*> = io.submit(runnable)

	/**
	 * 向全局 IO 池提交带返回值任务
	 *
	 * @param T 任务返回值类型
	 * @param callable 要执行的任务
	 * @return 任务句柄，可通过 [Future.get] 获取结果
	 */
	@JvmStatic
	fun <T> submit(callable: Callable<T>): Future<T> = io.submit(callable)

	/**
	 * 向全局 IO 池提交无返回值任务
	 *
	 * @param runnable 要执行的任务
	 * @return 任务句柄，可用于等待完成或取消
	 */
	@JvmStatic
	fun submit(runnable: Runnable): Future<*> = io.submit(runnable)

	/**
	 * 向全局 IO 池提交任务，并指定完成后返回的固定结果
	 *
	 * @param T 结果类型
	 * @param runnable 要执行的任务
	 * @param result 任务完成后返回的结果
	 * @return 任务句柄，完成后通过 [Future.get] 得到 [result]
	 */
	@JvmStatic
	fun <T> submit(runnable: Runnable, result: T): Future<T> = io.submit(runnable, result)

	/**
	 * 优雅关闭全部线程池（先正常关闭，超时后强制关闭）
	 */
	@JvmStatic
	fun shutdownAll() {
		io.shutdownGracefully()
		cpu.shutdownGracefully()
		scheduled.shutdownGracefully()
	}
}

/**
 * 向全局 IO 池提交无返回值任务
 */
fun runAsync(block: () -> Unit): Future<*> = GlobalThreadPool.io.submit(block)

/**
 * 向全局 IO 池提交带返回值任务
 */
fun <T> callAsync(block: () -> T): Future<T> = GlobalThreadPool.io.submit(Callable(block))

/**
 * 向全局 CPU 池提交计算任务
 */
fun <T> computeAsync(block: () -> T): Future<T> = GlobalThreadPool.cpu.submit(Callable(block))

/**
 * 在全局 IO 池执行任务并阻塞等待完成
 */
fun runAsyncAwait(block: () -> Unit) {
	GlobalThreadPool.io.submit(block).get()
}

/**
 * 在全局 IO 池执行任务并阻塞等待结果
 */
fun <T> callAsyncAwait(block: () -> T): T = GlobalThreadPool.io.submit(Callable(block)).get()
