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
 * CurrentFile ThreadPoolMonitor.kt
 * LastUpdate 2026-10-19 20:51:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * 线程池运行快照，一次调用获取全部关键指标。
 */
data class ThreadPoolSnapshot(
	/** 当前线程数 */
	val poolSize: Int,
	/** 核心线程数 */
	val corePoolSize: Int,
	/** 最大线程数 */
	val maximumPoolSize: Int,
	/** 历史最大线程数 */
	val largestPoolSize: Int,
	/** 正在执行任务的线程数 */
	val activeThreads: Int,
	/** 队列中等待执行的任务数 */
	val queueSize: Int,
	/** 队列剩余容量（无界队列为 [Int.MAX_VALUE]） */
	val queueRemainingCapacity: Int,
	/** 已完成任务数 */
	val completedTasks: Long,
	/** 已提交任务总数 */
	val totalTasks: Long,
	/** 是否已调用 shutdown */
	val isShutdown: Boolean,
	/** 是否已终止 */
	val isTerminated: Boolean,
) {
	/** 线程利用率 = 活跃线程 / 最大线程，取值 [0.0, 1.0] */
	val utilization: Double
		get() = if (maximumPoolSize <= 0) 0.0
		else activeThreads.toDouble() / maximumPoolSize

	/** 队列积压率 = 队列任务 / 队列容量，无界队列返回 0.0 */
	val queueLoad: Double
		get() {
			val capacity = queueSize + queueRemainingCapacity
			return if (capacity <= 0 || capacity == Int.MAX_VALUE) 0.0
			else queueSize.toDouble() / capacity
		}

	override fun toString(): String = buildString {
		append("ThreadPoolSnapshot[")
		append("size=$poolSize/$maximumPoolSize(core=$corePoolSize,largest=$largestPoolSize)")
		append(",active=$activeThreads,util=${"%.1f".format(utilization * 100)}%")
		append(",queue=$queueSize,load=${"%.1f".format(queueLoad * 100)}%")
		append(",done=$completedTasks/$totalTasks")
		append(",shutdown=$isShutdown,terminated=$isTerminated")
		append("]")
	}
}

/**
 * 获取线程池当前运行快照
 */
fun ThreadPoolExecutor.snapshot(): ThreadPoolSnapshot = ThreadPoolSnapshot(
	poolSize = poolSize,
	corePoolSize = corePoolSize,
	maximumPoolSize = maximumPoolSize,
	largestPoolSize = largestPoolSize,
	activeThreads = activeCount,
	queueSize = queue.size,
	queueRemainingCapacity = queue.remainingCapacity(),
	completedTasks = completedTaskCount,
	totalTasks = taskCount,
	isShutdown = isShutdown,
	isTerminated = isTerminated,
)

/**
 * 周期性监控线程池，定期回调运行快照（可用于打日志、上报指标）。
 *
 * ```kotlin
 * pool.monitor(interval = 10) { snapshot ->
 *     log.info("pool status: {}", snapshot)
 * }
 * ```
 *
 * @param interval 监控间隔
 * @param unit 时间单位，默认秒
 * @param scheduler 执行监控的定时线程池，默认 [GlobalThreadPool.scheduled]
 * @param action 快照回调
 * @return 可取消的定时任务句柄
 */
fun ThreadPoolExecutor.monitor(
	interval: Long,
	unit: TimeUnit = TimeUnit.SECONDS,
	scheduler: ScheduledExecutorService = GlobalThreadPool.scheduled,
	action: (ThreadPoolSnapshot) -> Unit,
): ScheduledFuture<*> =
	scheduler.scheduleAtFixedRate({ action(snapshot()) }, interval, interval, unit)

/**
 * 打印线程池运行报告（多行字符串）
 */
fun ThreadPoolExecutor.report(): String = snapshot().toString()
