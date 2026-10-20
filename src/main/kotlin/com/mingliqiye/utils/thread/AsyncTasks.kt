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
 * CurrentFile AsyncTasks.kt
 * LastUpdate 2026-10-19 20:51:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

// ---- 并行执行 ----

/**
 * 并行执行全部任务，阻塞等待所有完成，按输入顺序返回结果。
 * 任一任务失败立即抛出异常。
 *
 * ```kotlin
 * val results = runParallel(
 *     { fetchUser() },
 *     { fetchOrder() },
 *     { fetchCart() },
 * )
 * ```
 */
fun <T> runParallel(
    vararg tasks: () -> T,
    executor: ExecutorService = GlobalThreadPool.io,
): List<T> = executor.invokeAllAndGet(tasks.map { Callable(it) })

/**
 * 并行执行全部任务，阻塞等待所有完成，按输入顺序返回结果
 */
fun <T> runParallel(
    tasks: Collection<() -> T>,
    executor: ExecutorService = GlobalThreadPool.io,
): List<T> = executor.invokeAllAndGet(tasks.map { Callable(it) })

/**
 * 并行执行全部任务，任一任务在超时时间内未完成则抛出 [java.util.concurrent.TimeoutException]
 */
fun <T> runParallelWithin(
    timeout: Long,
    unit: TimeUnit = TimeUnit.MILLISECONDS,
    executor: ExecutorService = GlobalThreadPool.io,
    tasks: Collection<() -> T>,
): List<T> {
    val futures = tasks.map { executor.submit(Callable(it)) }
    val deadline = System.nanoTime() + unit.toNanos(timeout)
    return futures.map { future ->
        val remaining = deadline - System.nanoTime()
        if (remaining <= 0) throw java.util.concurrent.TimeoutException("runParallel timeout $timeout $unit")
        future.get(remaining, TimeUnit.NANOSECONDS)
    }
}

/**
 * 执行全部任务，返回第一个成功完成的任务结果，其余任务取消。
 */
fun <T> firstCompleted(
    vararg tasks: () -> T,
    executor: ExecutorService = GlobalThreadPool.io,
): T = executor.invokeAny(tasks.map { Callable(it) })

/**
 * 执行全部任务，返回第一个成功完成的任务结果，其余任务取消
 */
fun <T> firstCompleted(
    tasks: Collection<() -> T>,
    executor: ExecutorService = GlobalThreadPool.io,
): T = executor.invokeAny(tasks.map { Callable(it) })

// ---- 集合工具 ----

/**
 * 等待所有 Future 完成并按顺序收集结果，任一失败抛出原始异常
 */
fun <T> awaitAll(futures: Collection<Future<T>>): List<T> = futures.map { it.await() }

/**
 * 提交全部 Callable 并阻塞等待所有完成，任一失败抛出原始异常
 */
fun <T> ExecutorService.invokeAllAndGet(tasks: Collection<Callable<T>>): List<T> =
    invokeAll(tasks).map { it.await() }

/**
 * 等待所有 Future 完成，失败的任务返回 null（不中断整体流程）
 */
fun <T> awaitAllOrNull(futures: Collection<Future<T>>): List<T?> =
    futures.map { it.getOrNull() }

// ---- 重试 ----

/**
 * 带重试的调用：任务抛出异常时重试，全部失败抛出最后一次异常。
 *
 * ```kotlin
 * val data = callWithRetry(3, delayMillis = 500) { httpGet(url) }
 * ```
 *
 * @param times 总尝试次数（含首次），必须 >= 1
 * @param delayMillis 每次重试前的等待毫秒数
 */
fun <T> callWithRetry(
    times: Int,
    delayMillis: Long = 0,
    task: () -> T,
): T {
    require(times >= 1) { "times must be >= 1: $times" }
    var last: Throwable? = null
    repeat(times) { attempt ->
        try {
            return task()
        } catch (t: Throwable) {
            last = t
            // 最后一次失败不再等待
            if (attempt < times - 1 && delayMillis > 0) {
                Thread.sleep(delayMillis)
            }
        }
    }
    throw last ?: IllegalStateException("unreachable")
}

/**
 * 在全局 IO 池中带重试执行任务
 */
fun <T> callAsyncWithRetry(
    times: Int,
    delayMillis: Long = 0,
    task: () -> T,
): Future<T> = GlobalThreadPool.io.submit(Callable { callWithRetry(times, delayMillis, task) })

// ---- 定时任务 ----

/**
 * 延迟执行任务（全局定时池）
 *
 * ```kotlin
 * delayRun(5, TimeUnit.SECONDS) { log.info("5s later") }
 * ```
 */
fun delayRun(
    delay: Long,
    unit: TimeUnit = TimeUnit.MILLISECONDS,
    action: () -> Unit,
): ScheduledFuture<*> = GlobalThreadPool.scheduled.schedule(action, delay, unit)

/**
 * 以固定频率执行任务（周期 = 任务耗时 + [period]），全局定时池
 */
fun scheduleWithFixedDelay(
    period: Long,
    unit: TimeUnit = TimeUnit.MILLISECONDS,
    initialDelay: Long = 0,
    action: () -> Unit,
): ScheduledFuture<*> =
    GlobalThreadPool.scheduled.scheduleWithFixedDelay(action, initialDelay, period, unit)

/**
 * 以固定频率执行任务（周期恒定为 [period]），全局定时池
 */
fun scheduleAtFixedRate(
    period: Long,
    unit: TimeUnit = TimeUnit.MILLISECONDS,
    initialDelay: Long = 0,
    action: () -> Unit,
): ScheduledFuture<*> =
    GlobalThreadPool.scheduled.scheduleAtFixedRate(action, initialDelay, period, unit)
