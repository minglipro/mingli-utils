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
 * CurrentFile ThreadPoolExt.kt
 * LastUpdate 2026-10-19 20:51:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import java.util.concurrent.*
import java.util.function.Supplier

// ---- ExecutorService 扩展 ----

/**
 * 优雅关闭线程池：先正常关闭，超时未完成则强制关闭。
 *
 * ```kotlin
 * pool.shutdownGracefully(timeout = 30, unit = TimeUnit.SECONDS)
 * ```
 *
 * @return 线程池是否在超时前正常终止
 */
fun ExecutorService.shutdownGracefully(
	timeout: Long = 30,
	unit: TimeUnit = TimeUnit.SECONDS,
): Boolean {
	shutdown()
	if (awaitTermination(timeout, unit)) return true
	shutdownNow()
	return awaitTermination(timeout, unit)
}

/**
 * 关闭线程池并等待终止，超时抛异常
 *
 * @throws IllegalStateException 线程池未能在超时时间内终止
 */
fun ExecutorService.shutdownAndAwait(
	timeout: Long = 30,
	unit: TimeUnit = TimeUnit.SECONDS,
) {
	check(shutdownGracefully(timeout, unit)) {
		"executor did not terminate within $timeout $unit"
	}
}

// ---- Future 扩展 ----

/**
 * 阻塞等待任务完成并返回结果；[ExecutionException] 自动解包抛出原始异常。
 */
fun <T> Future<T>.await(): T = try {
	get()
} catch (e: ExecutionException) {
	throw e.cause ?: e
}

/**
 * 阻塞等待任务完成，返回结果；超时或执行失败返回 null。
 */
fun <T> Future<T>.getOrNull(
	timeout: Long = Long.MAX_VALUE,
	unit: TimeUnit = TimeUnit.MILLISECONDS,
): T? = try {
	get(timeout, unit)
} catch (_: Exception) {
	null
}

/**
 * 阻塞等待任务完成，失败或超时返回默认值。
 */
fun <T> Future<T>.getOrDefault(
	default: T,
	timeout: Long = Long.MAX_VALUE,
	unit: TimeUnit = TimeUnit.MILLISECONDS,
): T = getOrNull(timeout, unit) ?: default

/**
 * 非阻塞取消任务
 */
fun Future<*>.cancelQuietly(): Boolean = try {
	cancel(true)
} catch (_: Exception) {
	false
}

/**
 * 带超时等待：超时抛出 [TimeoutException]，失败抛出原始异常
 */
fun <T> Future<T>.await(timeout: Long, unit: TimeUnit): T = try {
	get(timeout, unit)
} catch (e: ExecutionException) {
	throw e.cause ?: e
}

// ---- CompletableFuture 便捷创建 ----

/**
 * 创建 [CompletableFuture] 并提交任务执行
 *
 * ```kotlin
 * val future = completableFuture { fetchData() }
 * val future2 = completableFuture(pool) { fetchData() }
 * ```
 *
 * @param executor 执行任务的线程池，默认使用公共 ForkJoinPool
 */
fun <T> completableFuture(
	executor: Executor? = null,
	block: () -> T,
): CompletableFuture<T> = if (executor == null) {
	CompletableFuture.supplyAsync(Supplier(block))
} else {
	CompletableFuture.supplyAsync(Supplier(block), executor)
}

/**
 * 在指定线程池创建无返回值 [CompletableFuture]
 */
fun runCompletableFuture(
	executor: Executor? = null,
	block: () -> Unit,
): CompletableFuture<Void> = if (executor == null) {
	CompletableFuture.runAsync(block)
} else {
	CompletableFuture.runAsync(block, executor)
}
