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
 * CurrentFile ThreadPoolBuilder.kt
 * LastUpdate 2026-11-23 09:31:23
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import com.mingliqiye.utils.netty.NamedThreadFactory
import com.mingliqiye.utils.system.availableProcessors
import java.util.concurrent.*

/**
 * 线程池构建器，采用链式 + DSL 风格配置 [ThreadPoolExecutor]。
 *
 * 充分利用 Kotlin 默认参数与具名参数，仅需覆盖关心的配置项：
 *
 * ```kotlin
 * val pool = threadPool("biz-pool") {
 *     corePoolSize = 8
 *     maximumPoolSize = 16
 *     queueCapacity = 1000          // 有界队列，防止任务无限堆积
 *     keepAliveSeconds = 30
 *     allowCoreThreadTimeout = true
 *     daemon = true
 *     rejectedHandler = ThreadPoolExecutor.AbortPolicy()
 * }
 * ```
 */
class ThreadPoolBuilder internal constructor() {

	/** 线程池名称，用于线程命名 */
	var name: String = "MingLiPool"

	/** 核心线程数，默认 CPU 核数 */
	var corePoolSize: Int = availableProcessors

	/** 最大线程数，默认 CPU 核数 x2 */
	var maximumPoolSize: Int = availableProcessors * 2

	/** 非核心线程空闲存活时间（秒） */
	var keepAliveSeconds: Long = 60

	/** 是否允许核心线程空闲超时回收 */
	var allowCoreThreadTimeout: Boolean = false

	/** 任务队列容量，<= 0 表示使用无界队列 */
	var queueCapacity: Int = 0

	/** 工作队列，设置 [queueCapacity] 后将被覆盖 */
	var workQueue: BlockingQueue<Runnable> = LinkedBlockingQueue()

	/** 线程是否为守护线程 */
	var daemon: Boolean = false

	/** 线程优先级 */
	var priority: Int = Thread.NORM_PRIORITY

	/** 任务拒绝策略，默认由调用线程执行 */
	var rejectedHandler: RejectedExecutionHandler = ThreadPoolExecutor.CallerRunsPolicy()

	/** 未捕获异常处理器 */
	var uncaughtHandler: Thread.UncaughtExceptionHandler? = null

	/** 自定义线程工厂，默认使用 [NamedThreadFactory] */
	var threadFactory: ThreadFactory? = null

	/**
	 * 使用无界队列（默认行为）
	 */
	fun unboundedQueue(): ThreadPoolBuilder = apply {
		queueCapacity = 0
		workQueue = LinkedBlockingQueue()
	}

	/**
	 * 使用有界队列
	 *
	 * @param capacity 队列容量，必须大于 0
	 */
	fun boundedQueue(capacity: Int): ThreadPoolBuilder = apply {
		require(capacity > 0) { "queue capacity must be positive: $capacity" }
		queueCapacity = capacity
		workQueue = ArrayBlockingQueue(capacity)
	}

	/**
	 * 使用同步队列，任务直接交接给线程（适合缓存线程池场景）
	 */
	fun synchronousQueue(): ThreadPoolBuilder = apply {
		queueCapacity = 1
		workQueue = SynchronousQueue()
	}

	/**
	 * 构建线程池
	 *
	 * @return 配置完成的 [ThreadPoolExecutor]
	 */
	fun build(): ThreadPoolExecutor {
		val factory = threadFactory
			?.let { decorateThreadFactory(it, daemon, priority, uncaughtHandler) }
			?: namedThreadFactory(name, daemon, priority, uncaughtHandler)
		return ThreadPoolExecutor(
			corePoolSize,
			maximumPoolSize,
			keepAliveSeconds,
			TimeUnit.SECONDS,
			workQueue,
			factory,
			rejectedHandler,
		).apply {
			if (allowCoreThreadTimeout) allowCoreThreadTimeOut(true)
		}
	}
}

/**
 * 创建带名称的线程工厂，可选配置守护线程、优先级与未捕获异常处理器。
 *
 * 适合与 JDK 原生线程池（如 [ScheduledThreadPoolExecutor]）搭配使用：
 *
 * ```kotlin
 * val scheduler = ScheduledThreadPoolExecutor(1, namedThreadFactory("scheduler", daemon = true))
 * ```
 *
 * @param name 线程名称前缀，实际线程名为 `name-1`、`name-2` ...
 * @param daemon 是否创建守护线程
 * @param priority 线程优先级
 * @param uncaughtHandler 未捕获异常处理器，为 null 时使用线程默认处理器
 */
@JvmOverloads
fun namedThreadFactory(
	name: String = "MingLiPool",
	daemon: Boolean = false,
	priority: Int = Thread.NORM_PRIORITY,
	uncaughtHandler: Thread.UncaughtExceptionHandler? = null,
): ThreadFactory = decorateThreadFactory(
	NamedThreadFactory.of(name),
	daemon,
	priority,
	uncaughtHandler,
)

/**
 * 按需装饰线程工厂：需要定制守护线程、优先级或异常处理器时包一层，否则原样返回。
 */
private fun decorateThreadFactory(
	base: ThreadFactory,
	daemon: Boolean,
	priority: Int,
	uncaughtHandler: Thread.UncaughtExceptionHandler?,
): ThreadFactory = if (daemon || priority != Thread.NORM_PRIORITY || uncaughtHandler != null) {
	ThreadFactory { runnable ->
		base.newThread(runnable).apply {
			isDaemon = daemon
			this.priority = priority
			uncaughtHandler?.let { setUncaughtExceptionHandler(it) }
		}
	}
} else base

/**
 * 以 DSL 方式构建线程池
 *
 * ```kotlin
 * val pool = threadPool("order-pool") {
 *     corePoolSize = 4
 *     boundedQueue(500)
 * }
 * ```
 *
 * @param name 线程池名称
 * @param configure 配置块
 */
fun threadPool(
	name: String = "MingLiPool",
	configure: ThreadPoolBuilder.() -> Unit = {},
): ThreadPoolExecutor = ThreadPoolBuilder().apply {
	this.name = name
	configure()
}.build()

/**
 * 创建固定大小线程池，任务队列无界
 */
fun fixedThreadPool(size: Int, name: String = "MingLiFixedPool"): ThreadPoolExecutor =
	threadPool(name) {
		corePoolSize = size
		maximumPoolSize = size
	}

/**
 * 创建单线程池，保证任务串行执行
 */
fun singleThreadPool(name: String = "MingLiSinglePool"): ThreadPoolExecutor =
	threadPool(name) {
		corePoolSize = 1
		maximumPoolSize = 1
	}

/**
 * 创建缓存线程池，空闲线程 60 秒后回收
 */
fun cachedThreadPool(name: String = "MingLiCachedPool"): ThreadPoolExecutor =
	threadPool(name) {
		corePoolSize = 0
		maximumPoolSize = Int.MAX_VALUE
		keepAliveSeconds = 60
		synchronousQueue()
	}

/**
 * 创建 IO 密集型线程池：更多线程 + 有界队列
 *
 * @param name 线程池名称
 * @param daemon 线程是否为守护线程
 * @param rejectedHandler 任务拒绝策略，默认为由提交线程执行
 */
@JvmOverloads
fun ioThreadPool(
	name: String = "MingLiIoPool",
	daemon: Boolean = false,
	rejectedHandler: RejectedExecutionHandler = ThreadPoolExecutor.CallerRunsPolicy(),
	corePoolSize: Int = availableProcessors * 2,
): ThreadPoolExecutor =
	threadPool(name) {
		this.corePoolSize = corePoolSize
		maximumPoolSize = availableProcessors * 4
		boundedQueue(1024)
		allowCoreThreadTimeout = true
		this.daemon = daemon
		this.rejectedHandler = rejectedHandler
	}

/**
 * 创建 CPU 密集型线程池：线程数等于核数，避免上下文切换开销
 *
 * @param name 线程池名称
 * @param daemon 线程是否为守护线程
 * @param rejectedHandler 任务拒绝策略，默认为由提交线程执行
 */
@JvmOverloads
fun cpuThreadPool(
	name: String = "MingLiCpuPool",
	daemon: Boolean = false,
	rejectedHandler: RejectedExecutionHandler = ThreadPoolExecutor.CallerRunsPolicy(),
): ThreadPoolExecutor =
	threadPool(name) {
		corePoolSize = availableProcessors
		maximumPoolSize = availableProcessors
		this.daemon = daemon
		this.rejectedHandler = rejectedHandler
	}

/**
 * 创建定时任务线程池
 *
 * @param coreSize 核心线程数，默认 CPU 核数 / 2（至少 1）
 * @param name 线程池名称
 * @param daemon 线程是否为守护线程
 */
@JvmOverloads
fun scheduledThreadPool(
	coreSize: Int = (availableProcessors / 2).coerceAtLeast(1),
	name: String = "MingLiScheduledPool",
	daemon: Boolean = false,
): ScheduledThreadPoolExecutor =
	ScheduledThreadPoolExecutor(coreSize, namedThreadFactory(name, daemon = daemon))
