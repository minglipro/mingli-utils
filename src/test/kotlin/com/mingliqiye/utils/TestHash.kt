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
 * CurrentFile TestHash.kt
 * LastUpdate 2026-11-18 11:17:46
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.base.BaseType
import com.mingliqiye.utils.hash.code.Md2Codec
import com.mingliqiye.utils.hash.code.Md5Codec
import com.mingliqiye.utils.hash.code.MessageDigestCodec
import com.mingliqiye.utils.hash.code.Sha1Codec
import com.mingliqiye.utils.hash.code.Sha224Codec
import com.mingliqiye.utils.hash.code.Sha256Codec
import com.mingliqiye.utils.hash.code.Sha3224Codec
import com.mingliqiye.utils.hash.code.Sha3256Codec
import com.mingliqiye.utils.hash.code.Sha3384Codec
import com.mingliqiye.utils.hash.code.Sha3512Codec
import com.mingliqiye.utils.hash.code.Sha384Codec
import com.mingliqiye.utils.hash.code.Sha512224Codec
import com.mingliqiye.utils.hash.code.Sha512256Codec
import com.mingliqiye.utils.hash.code.Sha512Codec
import com.mingliqiye.utils.hash.code.HashCodec
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.FilterInputStream
import java.nio.file.Files
import java.security.MessageDigest

/**
 * [HashCodec] 及其全部内置算法实现的测试。
 */
class TestHash {

	private val codecs: List<Pair<HashCodec, String>> = listOf(
		Md2Codec() to "MD2",
		Md5Codec() to "MD5",
		Sha1Codec() to "SHA-1",
		Sha224Codec() to "SHA-224",
		Sha256Codec() to "SHA-256",
		Sha384Codec() to "SHA-384",
		Sha512Codec() to "SHA-512",
		Sha512224Codec() to "SHA-512/224",
		Sha512256Codec() to "SHA-512/256",
		Sha3224Codec() to "SHA3-224",
		Sha3256Codec() to "SHA3-256",
		Sha3384Codec() to "SHA3-384",
		Sha3512Codec() to "SHA3-512",
	)

	/** 测试常见算法对 "hello" 的已知哈希向量 */
	@Test
	fun knownVectors() {
		assertEquals("5d41402abc4b2a76b9719d911017c592", Md5Codec().hashHex("hello"))
		assertEquals("aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d", Sha1Codec().hashHex("hello"))
		assertEquals(
			"2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824",
			Sha256Codec().hashHex("hello")
		)
	}

	/** 测试全部算法的流式结果与 MessageDigest 直接计算一致，且校验方法正确 */
	@Test
	fun allAlgorithmsMatchMessageDigest() {
		val data = ByteArray(100_000) { (it % 251).toByte() }
		for ((codec, algorithm) in codecs) {
			val expected = MessageDigest.getInstance(algorithm).digest(data)
			assertArrayEquals(expected, codec.hash(data), algorithm)
			assertArrayEquals(expected, codec.hash(data.inputStream()), algorithm)
			assertEquals(BaseType.BASE16.encode(expected), codec.hashHex(data), algorithm)
			assertTrue(codec.verifyHash(data, expected), algorithm)
			val tampered = expected.copyOf().also { it[0] = (it[0].toInt() xor 1).toByte() }
			assertFalse(codec.verifyHash(data, tampered), algorithm)
			assertTrue(codec.verifyHash("hello", codec.hashHex("hello")), algorithm)
			assertFalse(codec.verifyHash("hello", codec.hashHex("world")), algorithm)
		}
	}

	/** 测试实现不关闭调用方传入的输入流 */
	@Test
	fun doesNotCloseCallerStream() {
		var closed = false
		val stream = object : FilterInputStream("hello".byteInputStream()) {
			override fun close() {
				closed = true
				super.close()
			}
		}
		Sha256Codec().hash(stream)
		assertFalse(closed)
	}

	/** 测试文件与路径重载结果和字节数组一致 */
	@Test
	fun fileAndPathOverloads() {
		val data = ByteArray(20_000) { (it % 256).toByte() }
		val path = Files.createTempFile("mingli-hash-test", ".bin")
		try {
			Files.write(path, data)
			val codec = Sha256Codec()
			assertArrayEquals(codec.hash(data), codec.hash(path))
			assertArrayEquals(codec.hash(data), codec.hash(path.toFile()))
			assertEquals(codec.hashHex(data), codec.hashHex(path))
			assertEquals(codec.hashHex(data), codec.hashHex(path.toFile()))
		} finally {
			Files.deleteIfExists(path)
		}
	}

	/** 测试自定义算法名称的扩展基类用法 */
	@Test
	fun customAlgorithmViaBaseClass() {
		val codec = object : MessageDigestCodec("SHA-256") {}
		assertArrayEquals(Sha256Codec().hash("hello"), codec.hash("hello"))
	}

	/** 测试空输入可正常计算哈希 */
	@Test
	fun emptyInput() {
		val empty = ByteArray(0)
		for ((codec, algorithm) in codecs) {
			assertArrayEquals(MessageDigest.getInstance(algorithm).digest(empty), codec.hash(empty), algorithm)
		}
	}
}
