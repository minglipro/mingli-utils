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
 * CurrentFile RedisLock.kt
 * LastUpdate 2026-11-23 10:26:28
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.lock

import com.mingliqiye.utils.exception.RedisLockTimeoutException
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.future.await
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import org.redisson.api.RLock
import org.redisson.api.RedissonClient
import java.util.concurrent.CompletionStage
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import kotlin.time.Duration.Companion.milliseconds

/**
 * 基于 Redisson 的 Redis 分布式锁工具，提供「协程挂起等待」的加锁 API。
 *
 * 与 `RLock.lock()` 的线程阻塞不同，加锁/解锁都走 Redisson 异步 API，
 * 等待期间只挂起协程、不占用业务线程，适合十秒级左右的操作：
 *
 * ```kotlin
 * val lock = RedisLock(redisson)
 * lock.withLock("settle:2026-11") {
 *     // 同一时刻只有一个节点会执行到这里
 *     doSettle()
 * }
 * ```
 *
 * 特性：
 * - 默认启用 Redisson 看门狗（`leaseMillis = -1`），业务执行超时也会自动续期
 * - 支持公平锁、自定义 key 前缀、固定租期
 * - `tryWithLock` 抢不到锁立即返回 `null`，不等待
 *
 * 使用前提：调用方需自行引入 Redisson（本库对 Redisson 仅有 `compileOnly` 依赖），
 * 建议 Redisson 3.13+ / 4.x。
 *
 * 注意：
 * - **不可重入**：每次加锁都会分配独立的 owner id，同一协程嵌套调用同一个 key 会等待超时
 * - Redis 锁可能因主从切换、网络分区而丢失，业务仍需幂等/唯一约束兜底
 * - [leaseMillis] 为正数时为固定租期、不会自动续期，[withLock] 的业务必须在该时间内完成
 * - 等待超时会抛出 [RedisLockTimeoutException]
 *
 * @param redisson Redisson 客户端
 * @param keyPrefix 锁 key 前缀，默认 `mingli:lock:`
 * @param fair 是否使用公平锁（`getFairLock`），默认非公平
 * @param defaultWaitMillis 默认最长等待时间（毫秒），默认 15 秒
 * @param leaseMillis 租约时间：默认 `-1` 使用看门狗自动续期；正数为固定租期
 */
class RedisLock @JvmOverloads constructor(
	private val redisson: RedissonClient,
	private val keyPrefix: String = DEFAULT_KEY_PREFIX,
	private val fair: Boolean = false,
	private val defaultWaitMillis: Long = DEFAULT_WAIT_MILLIS,
	private val leaseMillis: Long = WATCHDOG_LEASE,
) {

	private val log = MingLiLoggerFactory.getLogger<RedisLock>()

	init {
		require(defaultWaitMillis >= 0) { "defaultWaitMillis 不能为负数: $defaultWaitMillis" }
		require(leaseMillis == WATCHDOG_LEASE || leaseMillis > 0) {
			"leaseMillis 必须是 -1（看门狗自动续期）或正数: $leaseMillis"
		}
	}

	/**
	 * 获取锁并在持有期间执行 [block]，锁被占用时挂起等待，最长等待 [waitMillis]。
	 *
	 * 正常返回或 [block] 抛异常都会释放锁；等待期间协程被取消也会尽力释放。
	 *
	 * @param key 业务锁 key，实际 Redis key 为 `keyPrefix + key`
	 * @param waitMillis 最长等待时间（毫秒），默认取构造参数
	 * @param block 持锁执行的业务逻辑
	 * @return [block] 的返回值
	 * @throws RedisLockTimeoutException 等待超过 [waitMillis] 仍未获取到锁
	 */
	suspend fun <T> withLock(
		key: String,
		waitMillis: Long = defaultWaitMillis,
		block: suspend () -> T,
	): T {
		require(key.isNotBlank()) { "锁 key 不能为空" }
		require(waitMillis >= 0) { "waitMillis 不能为负数: $waitMillis" }
		val lock = lockOf(key)
		val ownerId = nextOwnerId()
		var acquired = false
		var cancelled = false
		try {
			acquired = awaitAcquire(lock, waitMillis, ownerId)
			if (!acquired) {
				log.debug("获取 Redis 分布式锁超时: key={}, wait={}ms", lock.name, waitMillis)
				throw RedisLockTimeoutException(lock.name, waitMillis)
			}
			log.debug("已获取 Redis 分布式锁: key={}, owner={}", lock.name, ownerId)
			return block()
		} catch (e: CancellationException) {
			cancelled = true
			throw e
		} finally {
			// 等待中被取消时，锁可能刚好已经拿到，这里统一尝试释放
			if (acquired || cancelled) {
				release(lock, ownerId)
			}
		}
	}

	/**
	 * 尝试获取锁：抢不到立即返回 `null`，不等待；抢到则执行 [block] 并返回其结果。
	 *
	 * 注意：如果 [block] 允许返回 `null`，调用方无法区分「锁被占用」和「业务返回 null」。
	 *
	 * @param key 业务锁 key，实际 Redis key 为 `keyPrefix + key`
	 * @param block 持锁执行的业务逻辑
	 * @return [block] 的返回值；锁被占用时返回 `null`
	 */
	suspend fun <T> tryWithLock(
		key: String,
		block: suspend () -> T,
	): T? {
		require(key.isNotBlank()) { "锁 key 不能为空" }
		val lock = lockOf(key)
		val ownerId = nextOwnerId()
		var acquired = false
		var cancelled = false
		try {
			acquired = awaitAcquire(lock, 0, ownerId)
			if (!acquired) {
				log.debug("Redis 分布式锁被占用，跳过执行: key={}", lock.name)
				return null
			}
			log.debug("已获取 Redis 分布式锁: key={}, owner={}", lock.name, ownerId)
			return block()
		} catch (e: CancellationException) {
			cancelled = true
			throw e
		} finally {
			if (acquired || cancelled) {
				release(lock, ownerId)
			}
		}
	}

	/**
	 * 计算某个业务 key 对应的完整 Redis 锁 key（`keyPrefix + key`）。
	 */
	fun lockName(key: String): String = keyPrefix + key

	private suspend fun awaitAcquire(lock: RLock, waitMillis: Long, ownerId: Long): Boolean {
		val future = lock.tryLockAsync(waitMillis, leaseMillis, TimeUnit.MILLISECONDS, ownerId)
		// RFuture 同时实现了 Future 和 CompletionStage，显式转成 CompletionStage 以匹配 await 扩展
		return (future as CompletionStage<Boolean>).await()
	}

	private suspend fun release(lock: RLock, ownerId: Long) {
		withContext(NonCancellable) {
			try {
				val released = withTimeoutOrNull(RELEASE_TIMEOUT_MILLIS.milliseconds) {
					(lock.unlockAsync(ownerId) as CompletionStage<Void>).await()
					true
				}
				if (released == true) {
					log.debug("已释放 Redis 分布式锁: key={}, owner={}", lock.name, ownerId)
				} else {
					log.warn("释放 Redis 分布式锁超时: key={}, owner={}", lock.name, ownerId)
				}
			} catch (t: Throwable) {
				// 锁可能已因租约到期/主从切换丢失，unlock 会抛 IllegalMonitorStateException
				log.debug("释放 Redis 分布式锁失败: key={}, owner={}", lock.name, ownerId, t)
			}
		}
	}

	private fun lockOf(key: String): RLock =
		if (fair) redisson.getFairLock(keyPrefix + key) else redisson.getLock(keyPrefix + key)

	companion object {

		/** 默认锁 key 前缀 */
		const val DEFAULT_KEY_PREFIX: String = "mingli:lock:"

		/** 默认等待时间：15 秒 */
		const val DEFAULT_WAIT_MILLIS: Long = 15_000L

		/** 使用 Redisson 看门狗自动续期租约 */
		const val WATCHDOG_LEASE: Long = -1L

		/** 释放锁的等待上限，避免 Redis 故障时卡住调用方 */
		private const val RELEASE_TIMEOUT_MILLIS: Long = 2_000L

		/**
		 * owner id 生成器。
		 *
		 * Redisson 用 `clientUuid:threadId` 区分持有者；这里不绑定真实线程，
		 * 而是给每次加锁生成一个唯一的 id，从而支持跨线程的协程解锁。
		 * 随机起始值是为了避开真实线程 id，避免和同一客户端里其它锁语义冲突。
		 */
		private val OWNER_IDS = AtomicLong(ThreadLocalRandom.current().nextLong())

		private fun nextOwnerId(): Long = OWNER_IDS.incrementAndGet()
	}
}
