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
 * CurrentFile TestSecureUtils.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.security.constantTimeEquals
import com.mingliqiye.utils.security.createSecretKey
import com.mingliqiye.utils.security.createSecretKeySpec
import com.mingliqiye.utils.security.getRandomBytes
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.HexFormat

/**
 * [com.mingliqiye.utils.security.SecureUtils] 的测试。
 */
class TestSecureUtils {

	/**
	 * 验证 SHA-256 已知向量。
	 */
	@Test
	fun testSha256KnownVector() {
		val digest = createSecretKey("SHA-256", "abc")
		assertEquals(
			"ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad",
			HexFormat.of().formatHex(digest)
		)
	}

	/**
	 * 验证随机字节长度与随机性。
	 */
	@Test
	fun testRandomBytes() {
		assertEquals(0, getRandomBytes(0).size)
		val a = getRandomBytes(32)
		val b = getRandomBytes(32)
		assertEquals(32, a.size)
		assertNotEquals(a.toList(), b.toList())
	}

	/**
	 * 验证负数长度被拒绝。
	 */
	@Test
	fun testRandomBytesNegativeLength() {
		assertThrows(IllegalArgumentException::class.java) {
			getRandomBytes(-1)
		}
	}

	/**
	 * 验证常量时间比较。
	 */
	@Test
	fun testConstantTimeEquals() {
		assertTrue(constantTimeEquals("abc".toByteArray(), "abc".toByteArray()))
		assertFalse(constantTimeEquals("abc".toByteArray(), "abd".toByteArray()))
		assertFalse(constantTimeEquals("abc".toByteArray(), "ab".toByteArray()))
	}

	/**
	 * 验证 AES 密钥长度归一化。
	 */
	@Test
	fun testAesSecretKeySpec() {
		val raw = getRandomBytes(32)
		assertArrayEquals(raw, createSecretKeySpec("AES", raw).encoded)

		// 非 16/24/32 字节的字符串密钥会被 SHA-256 归一化为 32 字节
		val derived = createSecretKeySpec("AES", "short-key")
		assertEquals(32, derived.encoded.size)
	}

	/**
	 * 验证非 AES 算法直接使用原始字节。
	 */
	@Test
	fun testNonAesSecretKeySpec() {
		val data = "hmac-key".toByteArray()
		assertArrayEquals(data, createSecretKeySpec("HmacSHA256", data).encoded)
	}
}
