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
 * LastUpdate 2026-11-23 09:48:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.system.availableProcessors
import com.mingliqiye.utils.thread.GlobalThreadPool.SHUTDOWN_HOOK_TIMEOUT_SECONDS
import com.mingliqiye.utils.thread.GlobalThreadPool.cpu
import com.mingliqiye.utils.thread.GlobalThreadPool.cpuDispatcher
import com.mingliqiye.utils.thread.GlobalThreadPool.io
import com.mingliqiye.utils.thread.GlobalThreadPool.ioDispatcher
import com.mingliqiye.utils.thread.GlobalThreadPool.main
import com.mingliqiye.utils.thread.GlobalThreadPool.mainDispatcher
import com.mingliqiye.utils.thread.GlobalThreadPool.pools
import com.mingliqiye.utils.thread.GlobalThreadPool.scheduled
import com.mingliqiye.utils.thread.GlobalThreadPool.shutdownAll
import com.mingliqiye.utils.thread.GlobalThreadPool.submit
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 全局共享线程池，按负载类型划分，并额外提供协程调度器的统一入口。
 *
 * | 池 | 线程数 | 队列 | 适用场景 |
 * | :--- | :--- | :--- | :--- |
 * | [main] | 核数 / 2 ~ 核数 | 128 有界 | 通用异步任务 |
 * | [io] | 核数 x2 ~ 核数 x4 | 1024 有界 | 网络、磁盘等阻塞任务 |
 * | [cpu] | 核数 | 无界 | 纯计算任务 |
 * | [scheduled] | 核数 / 2（至少 1） | 延迟队列 | 延迟与周期任务 |
 *
 * 所有池的线程均为守护线程，不会阻止 JVM 退出；需要主动释放时调用 [shutdownAll]，
 * 进程正常退出时也会通过注册的关闭钩子自动调用一次（最多等 5 秒，超时强制关闭）。
 * 各池都是懒加载的，首次访问时才创建。
 *
 * 协程调度器（[mainDispatcher]、[ioDispatcher]、[cpuDispatcher]）与池的对应关系并不统一：
 * [mainDispatcher] 和 [ioDispatcher] 直接复用 kotlinx-coroutines 的共享调度器
 * （`asCoroutineDispatcher()` 会把每个续体变成一次线程池入队，高频调度下比
 * [Dispatchers.Default] 慢数倍）；只有 [cpuDispatcher] 绑定 [cpu] 池——计算任务粒度大、
 * 续体切换少，入队开销可以忽略，换来独立的计算线程与可辨识的线程名。
 * 线程池也仍然直接面向 ExecutorService / Future / 阻塞任务等场景。
 *
 * ```kotlin
 * GlobalThreadPool.io.execute { download() }
 * val result = GlobalThreadPool.cpu.submit { compute() }.get()
 * GlobalThreadPool.runAsync { log("done") }
 * ```
 */
object GlobalThreadPool {

	private val log = MingLiLoggerFactory.getLogger<GlobalThreadPool>()

	init {
		registerShutdownHook()
	}

	/** JVM 关闭时为在途任务保留的收尾时长（秒） */
	private const val SHUTDOWN_HOOK_TIMEOUT_SECONDS = 5L

	/** 可用处理器数，所有池的线程规模都由它推算 */
	private val cores: Int = availableProcessors

	/**
	 * 全局池拒绝策略：队列满时由提交线程执行，形成背压；
	 * 池已关闭时抛出 [RejectedExecutionException] 而不是静默丢弃，
	 * 避免 [submit] 返回一个永远不会完成的 [Future]。
	 */
	private val globalRejectedHandler = RejectedExecutionHandler { runnable, executor ->
		if (executor.isShutdown) {
			log.debug("全局池已关闭，拒绝任务提交")
			throw RejectedExecutionException("global thread pool is shutdown")
		}
		log.debug("全局池队列已满，任务改由提交线程 [{}] 执行", Thread.currentThread().name)
		runnable.run()
	}

	/**
	 * 通用全局池：适合短小的异步任务。
	 *
	 * 队列满时由提交线程直接执行，形成天然背压、不丢任务；
	 * 池关闭后提交会抛出 [RejectedExecutionException]。
	 */
	@JvmStatic
	@get:JvmName("main")
	val main: ThreadPoolExecutor by lazy {
		val corePoolSize = (cores / 2).coerceAtLeast(1)
		log.debug("初始化全局池 [main]: core={}, max={}, queue=128, daemon=true", corePoolSize, cores)
		threadPool("MingLiGlobalMain") {
			this.corePoolSize = corePoolSize
			maximumPoolSize = cores
			boundedQueue(128)
			allowCoreThreadTimeout = true
			daemon = true
			rejectedHandler = globalRejectedHandler
		}
	}

	/**
	 * IO 密集型全局池：线程较多、队列有界，适合网络、磁盘等阻塞任务。
	 *
	 * 核心线程允许空闲超时回收，空闲一段时间后会释放线程资源。
	 */
	@JvmStatic
	@get:JvmName("io")
	val io: ThreadPoolExecutor by lazy {
		val corePoolSize = cores * 2
		log.debug("初始化全局池 [io]: core={}, max={}, queue=1024, daemon=true", corePoolSize, cores * 4)
		ioThreadPool("MingLiGlobalIO", daemon = true, rejectedHandler = globalRejectedHandler)
	}

	/**
	 * CPU 密集型全局池：线程数等于核数，适合纯计算任务。
	 *
	 * 队列无界，突发任务不会被拒绝，但提交速度长期超过消费速度时会持续积压。
	 */
	@JvmStatic
	@get:JvmName("cpu")
	val cpu: ThreadPoolExecutor by lazy {
		log.debug("初始化全局池 [cpu]: core={}, max={}, queue=unbounded, daemon=true", cores, cores)
		cpuThreadPool("MingLiGlobalCPU", daemon = true, rejectedHandler = globalRejectedHandler)
	}

	/**
	 * 全局定时池：承载 [delayRun]、[scheduleWithFixedDelay]、[scheduleAtFixedRate] 等定时任务。
	 *
	 * 已取消的任务会立即移出队列（[ScheduledThreadPoolExecutor.getRemoveOnCancelPolicy]），
	 * 关闭时丢弃尚未到期的延迟任务，避免 [shutdownAll] 被长延时任务拖住。
	 */
	@JvmStatic
	@get:JvmName("scheduled")
	val scheduled: ScheduledThreadPoolExecutor by lazy {
		val coreSize = (cores / 2).coerceAtLeast(1)
		log.debug("初始化全局池 [scheduled]: core={}, daemon=true, removeOnCancelPolicy=true", coreSize)
		scheduledThreadPool(
			coreSize = coreSize,
			name = "MingLiGlobalScheduled",
			daemon = true,
		).apply {
			removeOnCancelPolicy = true
			executeExistingDelayedTasksAfterShutdownPolicy = false
			continueExistingPeriodicTasksAfterShutdownPolicy = false
		}
	}

	// ---- 协程调度器 ----

	/**
	 * 通用协程调度器：[Dispatchers.Default] 的命名视图。
	 *
	 * 它不包装 [main] 线程池，而是直接使用 kotlinx-coroutines 的共享调度器
	 * （每个 worker 本地队列 + work-stealing），避免"每个续体一次线程池入队"的开销。
	 * 并行度取 `max(4, CPU 核数)`；等于或大于 Default 核心池时只是命名视图，不做额外限流。
	 *
	 * 共享实例，不要 `close()`；它不归 [shutdownAll] 管。
	 */
	@JvmStatic
	@get:JvmName("mainDispatcher")
	val mainDispatcher: CoroutineDispatcher by lazy {
		val parallelism = cores.coerceAtLeast(4)
		log.debug("初始化协程调度器 [mainDispatcher]: Dispatchers.Default, parallelism={}", parallelism)
		Dispatchers.Default.limitedParallelism(parallelism, "MingLiGlobalMainDispatcher")
	}

	/**
	 * IO 密集型协程调度器：[Dispatchers.IO] 的命名限流视图，最大并发取 `max(128, CPU 核数)`。
	 *
	 * 底层仍是 IO 的弹性调度器；套一层 `limitedParallelism` 是为了给并发线程数一个
	 * 明确上限，代价是每次分发多一层原子计数。
	 *
	 * 共享实例，不要 `close()`；它不归 [shutdownAll] 管。
	 */
	@JvmStatic
	@get:JvmName("ioDispatcher")
	val ioDispatcher: CoroutineDispatcher by lazy {
		val parallelism = 128.coerceAtLeast(cores)
		log.debug("初始化协程调度器 [ioDispatcher]: Dispatchers.IO, parallelism={}", parallelism)
		Dispatchers.IO.limitedParallelism(parallelism, "MingLiGlobalIODispatcher")
	}

	/**
	 * 计算专用的协程调度器：绑定独立的 [cpu] 池，线程数等于 CPU 核数，
	 * 线程名为 `MingLiGlobalCPU-*`。
	 *
	 * 这里刻意不复用 [Dispatchers.Default]：计算任务粒度大、续体切换少，每次入队的那点
	 * 开销可以忽略，换来的是与全局 Default 调度器隔离的独立计算线程，以及随
	 * [shutdownAll] 一起关闭（关闭后投递的协程会被取消并转到 IO 清理）。
	 *
	 * 只用于 CPU 密集型计算，不要在里面做阻塞调用。
	 */
	@JvmStatic
	@get:JvmName("cpuDispatcher")
	val cpuDispatcher: CoroutineDispatcher by lazy {
		log.debug("初始化协程调度器 [cpuDispatcher]: 绑定全局池 [cpu]")
		cpu.asCoroutineDispatcher()
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

	// ---- 便捷任务 ----

	/**
	 * 向全局 IO 池提交无返回值任务
	 *
	 * Kotlin 可直接用 lambda，Java 也可直接传 `Runnable`。
	 *
	 * @param block 要执行的任务
	 * @return 任务句柄，可用于等待完成或取消
	 */
	@JvmStatic
	fun runAsync(block: Runnable): Future<*> = io.submit(block)

	/**
	 * 向全局 IO 池提交带返回值任务
	 *
	 * Kotlin 可直接用 lambda，Java 也可直接传 `Callable`。
	 *
	 * @param T 任务返回值类型
	 * @param block 要执行的任务
	 * @return 任务句柄，可通过 [Future.get] 获取结果
	 */
	@JvmStatic
	fun <T> callAsync(block: Callable<T>): Future<T> = io.submit(block)

	/**
	 * 向全局 CPU 池提交计算任务
	 *
	 * Kotlin 可直接用 lambda，Java 也可直接传 `Callable`。
	 *
	 * @param T 任务返回值类型
	 * @param block 要执行的计算任务
	 * @return 任务句柄，可通过 [Future.get] 获取结果
	 */
	@JvmStatic
	fun <T> computeAsync(block: Callable<T>): Future<T> = cpu.submit(block)

	/**
	 * 在全局 IO 池执行任务并阻塞等待完成
	 *
	 * @param block 要执行的任务
	 */
	@JvmStatic
	fun runAsyncAwait(block: Runnable) {
		io.submit(block).get()
	}

	/**
	 * 在全局 IO 池执行任务并阻塞等待结果
	 *
	 * @param T 任务返回值类型
	 * @param block 要执行的任务
	 * @return 任务执行结果
	 */
	@JvmStatic
	fun <T> callAsyncAwait(block: Callable<T>): T = io.submit(block).get()

	// ---- 监控 ----

	/**
	 * 全部全局池，按名称索引，便于统一监控、上报或统计。
	 *
	 * 键依次为 `main`、`io`、`cpu`、`scheduled`，值复用同一批单例。
	 * 每次调用返回新的只读视图；访问会初始化尚未创建的全局池。
	 */
	@JvmStatic
	fun pools(): Map<String, ExecutorService> = executorPools()

	/**
	 * 采集全部全局池的运行快照，键与 [pools] 一致。
	 *
	 * 适合周期性上报指标，例如：
	 *
	 * ```kotlin
	 * GlobalThreadPool.snapshotAll().forEach { (name, snapshot) ->
	 *     log.info("pool {}: {}", name, snapshot)
	 * }
	 * ```
	 *
	 * @return 池名称到 [ThreadPoolSnapshot] 的映射
	 */
	@JvmStatic
	fun snapshotAll(): Map<String, ThreadPoolSnapshot> =
		executorPools().mapValues { (_, pool) -> pool.snapshot() }

	// ---- 生命周期 ----

	private val shutdownState = AtomicBoolean(false)

	/**
	 * 是否已经调用过 [shutdownAll]
	 */
	@JvmStatic
	val isShutdown: Boolean get() = shutdownState.get()

	/**
	 * 优雅关闭全部全局池。
	 *
	 * 先停止接收新任务，再在统一的截止时间内等待线程池终止；
	 * 到期仍未结束的池会被 [ExecutorService.shutdownNow] 强制关闭。
	 * 全局池关闭后不可复用，重复调用直接返回 `true`；
	 * 之后再提交任务会抛出 [RejectedExecutionException]。
	 *
	 * @param timeout 整体等待时长，从开始关闭时计时，所有池共享
	 * @param unit 时间单位
	 * @return 是否所有池都在截止时间内正常终止
	 */
	@JvmStatic
	@JvmOverloads
	fun shutdownAll(timeout: Long = 30, unit: TimeUnit = TimeUnit.SECONDS): Boolean {
		if (!shutdownState.compareAndSet(false, true)) {
			log.debug("全局线程池已关闭，忽略重复的 shutdownAll 调用")
			return true
		}
		val startNanos = System.nanoTime()
		val pools = executorPools()
		log.debug("正在关闭全局线程池: {}，等待上限 {} {}", pools.keys, timeout, unit)
		val deadline = startNanos + unit.toNanos(timeout)
		pools.values.forEach { it.shutdown() }
		var terminated = true
		try {
			for ((name, pool) in pools) {
				val remaining = deadline - System.nanoTime()
				val done = remaining > 0 && pool.awaitTermination(remaining, TimeUnit.NANOSECONDS)
				if (done) {
					log.debug("线程池 [{}] 已关闭，完成任务数={}", name, pool.completedTaskCount)
				} else {
					terminated = false
					log.warn("线程池 [{}] 未在期限内终止，执行 shutdownNow()", name)
					pool.shutdownNow()
				}
			}
		} catch (_: InterruptedException) {
			// 保留中断状态，并强制关闭剩余池
			Thread.currentThread().interrupt()
			log.warn("等待全局线程池关闭时线程被中断，强制关闭剩余线程池")
			pools.values.forEach { it.shutdownNow() }
			terminated = false
		}
		val elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)
		if (terminated) {
			log.debug("全局线程池关闭完成，耗时 {} ms", elapsedMillis)
		} else {
			log.warn("全局线程池关闭完成，但存在未正常终止的池，耗时 {} ms", elapsedMillis)
		}
		return terminated
	}

	/**
	 * 注册 JVM 关闭钩子：进程退出前调用 [shutdownAll]，给在途任务一段收尾时间。
	 *
	 * 池线程都是守护线程，不注册钩子 JVM 也能正常退出；钩子的意义是把"直接中断"
	 * 变成"最多等 [SHUTDOWN_HOOK_TIMEOUT_SECONDS] 秒再强制关闭"。
	 * JVM 已在关闭中（例如本对象是在别的 shutdown hook 里第一次被访问）或安全管理器
	 * 拒绝注册时静默跳过，不影响全局池继续使用。
	 */
	private fun registerShutdownHook() {
		val hook = Thread({
			try {
				log.debug("JVM 关闭钩子触发，开始关闭全局线程池")
				shutdownAll(SHUTDOWN_HOOK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
			} catch (t: Throwable) {
				// 日志框架可能已先于本钩子关闭，这里也不能让异常阻塞 JVM 退出
				runCatching { log.warn("JVM 关闭钩子中关闭全局线程池失败", t) }
			}
		}, "MingLiGlobalPool-Shutdown")
		try {
			Runtime.getRuntime().addShutdownHook(hook)
			log.debug("已注册 JVM 关闭钩子: {}", hook.name)
		} catch (_: IllegalStateException) {
			// JVM 已在关闭中，无法再注册钩子
			log.debug("JVM 已在关闭中，跳过注册关闭钩子")
		} catch (_: SecurityException) {
			// 安全管理器拒绝注册钩子
			log.debug("安全管理器拒绝注册关闭钩子，跳过")
		}
	}

	/**
	 * 全部全局池的有序视图，键为池名称
	 */
	private fun executorPools(): Map<String, ThreadPoolExecutor> = linkedMapOf(
		"main" to main,
		"io" to io,
		"cpu" to cpu,
		"scheduled" to scheduled,
	)
}
