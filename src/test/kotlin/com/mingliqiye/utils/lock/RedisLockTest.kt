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
 * CurrentFile RedisLockTest.kt
 * LastUpdate 2026-11-23 10:21:41
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.lock

import com.mingliqiye.utils.exception.RedisLockTimeoutException
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.redisson.api.RFuture
import org.redisson.api.RLock
import org.redisson.api.RedissonClient
import java.lang.reflect.Proxy
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicInteger

/**
 * RedisLock 的单元测试，通过动态代理模拟 Redisson 客户端，不依赖真实 Redis。
 */
class RedisLockTest {

	/** 测试正常加锁、执行业务并释放锁，等待时间/租约/owner 传递正确 */
	@Test
	fun testWithLockAcquiresAndReleases() = runBlocking {
		val fake = FakeRedisson(acquireResult = true)
		val lock = RedisLock(fake.client, keyPrefix = "test:", defaultWaitMillis = 1234)

		var executed = false
		lock.withLock("order:1") { executed = true }

		assertTrue(executed)
		assertEquals(listOf("test:order:1"), fake.lockNames)
		assertEquals("test:order:1", lock.lockName("order:1"))
		assertEquals(1, fake.acquireCalls.get())
		assertEquals(1, fake.unlockCalls.get())
		assertEquals(fake.acquireOwnerId, fake.unlockOwnerId)
		assertEquals(1234L, fake.lastWaitMillis)
		assertEquals(RedisLock.WATCHDOG_LEASE, fake.lastLeaseMillis)
	}

	/** 测试等待超时：抛 RedisLockTimeoutException，业务不执行、不释放锁 */
	@Test
	fun testWithLockTimeout() {
		val fake = FakeRedisson(acquireResult = false)
		val lock = RedisLock(fake.client)

		var executed = false
		assertThrows(RedisLockTimeoutException::class.java) {
			runBlocking {
				lock.withLock("k", waitMillis = 50) { executed = true }
			}
		}

		assertFalse(executed)
		assertEquals(0, fake.unlockCalls.get())
	}

	/** 测试 tryWithLock 抢不到锁时立即返回 null，不等待、不执行 */
	@Test
	fun testTryWithLockBusy() = runBlocking {
		val fake = FakeRedisson(acquireResult = false)
		val lock = RedisLock(fake.client)

		val result = lock.tryWithLock("k") { "should not run" }

		assertNull(result)
		assertEquals(0L, fake.lastWaitMillis)
		assertEquals(0, fake.unlockCalls.get())
	}

	/** 测试 tryWithLock 抢到锁时执行并返回结果，随后释放 */
	@Test
	fun testTryWithLockSuccess() = runBlocking {
		val fake = FakeRedisson(acquireResult = true)
		val lock = RedisLock(fake.client)

		assertEquals("ok", lock.tryWithLock("k") { "ok" })
		assertEquals(1, fake.unlockCalls.get())
		assertEquals(fake.acquireOwnerId, fake.unlockOwnerId)
	}

	/** 测试公平锁配置使用 getFairLock */
	@Test
	fun testFairLock() = runBlocking {
		val fake = FakeRedisson(acquireResult = true)
		val lock = RedisLock(fake.client, fair = true)

		lock.withLock("k") { }

		assertTrue(fake.fairUsed)
	}

	/** 测试业务抛异常时依然释放锁 */
	@Test
	fun testReleaseOnBlockFailure() {
		val fake = FakeRedisson(acquireResult = true)
		val lock = RedisLock(fake.client)

		assertThrows(IllegalStateException::class.java) {
			runBlocking {
				lock.withLock("k") { error("boom") }
			}
		}

		assertEquals(1, fake.unlockCalls.get())
	}

	/** 测试自定义等待时间与固定租期会透传给 Redisson */
	@Test
	fun testCustomWaitAndLease() = runBlocking {
		val fake = FakeRedisson(acquireResult = true)
		val lock = RedisLock(fake.client, defaultWaitMillis = 100, leaseMillis = 5_000)

		lock.withLock("k", waitMillis = 200) { }

		assertEquals(200L, fake.lastWaitMillis)
		assertEquals(5_000L, fake.lastLeaseMillis)
	}
}

/**
 * 使用动态代理模拟 RedissonClient / RLock。
 */
private class FakeRedisson(private val acquireResult: Boolean) {

	val lockNames = mutableListOf<String>()
	val acquireCalls = AtomicInteger()
	val unlockCalls = AtomicInteger()

	@Volatile
	var acquireOwnerId: Long = -1

	@Volatile
	var unlockOwnerId: Long = -1

	@Volatile
	var lastWaitMillis: Long = -1

	@Volatile
	var lastLeaseMillis: Long = -1

	@Volatile
	var fairUsed: Boolean = false

	private val lock: RLock = Proxy.newProxyInstance(
		RLock::class.java.classLoader,
		arrayOf(RLock::class.java),
	) { proxy, method, args ->
		when (method.name) {
			"tryLockAsync" -> {
				acquireCalls.incrementAndGet()
				lastWaitMillis = args[0] as Long
				lastLeaseMillis = args[1] as Long
				acquireOwnerId = args[3] as Long
				completedFuture(acquireResult)
			}

			"unlockAsync" -> {
				unlockCalls.incrementAndGet()
				unlockOwnerId = args[0] as Long
				completedFuture<Void>(null)
			}

			"getName" -> "fake-lock"
			"toString" -> "FakeRLock"
			"hashCode" -> System.identityHashCode(proxy)
			"equals" -> proxy === args[0]
			else -> defaultValue(method.returnType)
		}
	} as RLock

	val client: RedissonClient = Proxy.newProxyInstance(
		RedissonClient::class.java.classLoader,
		arrayOf(RedissonClient::class.java),
	) { proxy, method, args ->
		when (method.name) {
			"getLock" -> {
				lockNames += args[0] as String
				fairUsed = false
				lock
			}

			"getFairLock" -> {
				lockNames += args[0] as String
				fairUsed = true
				lock
			}

			"toString" -> "FakeRedisson"
			"hashCode" -> System.identityHashCode(proxy)
			"equals" -> proxy === args[0]
			else -> defaultValue(method.returnType)
		}
	} as RedissonClient
}

private fun <V> completedFuture(value: V?): RFuture<V> = object : CompletableFuture<V>(), RFuture<V> {
	init {
		complete(value)
	}
}

private fun defaultValue(type: Class<*>): Any? = when (type) {
	java.lang.Boolean.TYPE -> false
	java.lang.Byte.TYPE -> 0.toByte()
	java.lang.Short.TYPE -> 0.toShort()
	java.lang.Integer.TYPE -> 0
	java.lang.Long.TYPE -> 0L
	java.lang.Float.TYPE -> 0f
	java.lang.Double.TYPE -> 0.0
	java.lang.Character.TYPE -> '\u0000'
	else -> null
}
