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
 * CurrentFile TestAesUtils.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.security.AES_GCM_NO_PADDING_IV_LENGTH
import com.mingliqiye.utils.security.decryptAesGcmNoPadding
import com.mingliqiye.utils.security.decryptAesGcmNoPaddingToString
import com.mingliqiye.utils.security.encryptAesGcmNoPadding
import com.mingliqiye.utils.security.getRandomBytes
import com.mingliqiye.utils.security.randomAesGcmIv
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.security.GeneralSecurityException

/**
 * [com.mingliqiye.utils.security.AesUtils] 的测试。
 */
class TestAesUtils {

	private val key = getRandomBytes(32)
	private val iv = randomAesGcmIv()

	/**
	 * 验证字节数组加解密往返。
	 */
	@Test
	fun testByteArrayRoundTrip() {
		val plain = "hello AES-GCM 你好".toByteArray(Charsets.UTF_8)
		val encrypted = encryptAesGcmNoPadding(plain, key, iv)

		assertNotEquals(plain.toList(), encrypted.toList())
		assertArrayEquals(plain, decryptAesGcmNoPadding(encrypted, key, iv))
	}

	/**
	 * 验证字符串加解密往返。
	 */
	@Test
	fun testStringRoundTrip() {
		val plain = "敏感数据：订单 123456"
		val encrypted = encryptAesGcmNoPadding(plain, "a-secret-key", iv)
		val decrypted = decryptAesGcmNoPaddingToString(encrypted, "a-secret-key", iv)
		assertEquals(plain, decrypted)
	}

	/**
	 * 验证随机 IV 组合格式的加解密往返。
	 */
	@Test
	fun testRandomIvRoundTrip() {
		val plain = "random iv test".toByteArray(Charsets.UTF_8)
		val encrypted = encryptAesGcmNoPadding(plain, key)

		assertTrue(encrypted.size > AES_GCM_NO_PADDING_IV_LENGTH)
		assertArrayEquals(plain, decryptAesGcmNoPadding(encrypted, key))
	}

	/**
	 * 验证 GCM 认证标签能检测篡改。
	 */
	@Test
	fun testTamperDetection() {
		val plain = "tamper test".toByteArray(Charsets.UTF_8)
		val encrypted = encryptAesGcmNoPadding(plain, key, iv)
		encrypted[encrypted.size - 1] = (encrypted[encrypted.size - 1].toInt() xor 1).toByte()

		assertThrows(GeneralSecurityException::class.java) {
			decryptAesGcmNoPadding(encrypted, key, iv)
		}
	}

	/**
	 * 验证错误密钥无法解密。
	 */
	@Test
	fun testWrongKey() {
		val plain = "wrong key test".toByteArray(Charsets.UTF_8)
		val encrypted = encryptAesGcmNoPadding(plain, key, iv)
		val wrongKey = getRandomBytes(32)

		assertThrows(GeneralSecurityException::class.java) {
			decryptAesGcmNoPadding(encrypted, wrongKey, iv)
		}
	}

	/**
	 * 验证非法 IV 长度会被拒绝。
	 */
	@Test
	fun testInvalidIvLength() {
		val invalidIv = ByteArray(AES_GCM_NO_PADDING_IV_LENGTH - 1)
		assertThrows(IllegalArgumentException::class.java) {
			encryptAesGcmNoPadding("data", "key", invalidIv)
		}
	}

	/**
	 * 验证随机 IV 长度固定。
	 */
	@Test
	fun testRandomIvLength() {
		assertEquals(AES_GCM_NO_PADDING_IV_LENGTH, randomAesGcmIv().size)
	}
}
