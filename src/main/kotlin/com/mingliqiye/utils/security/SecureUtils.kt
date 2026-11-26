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
 * CurrentFile SecureUtils.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

@file:JvmName("SecureUtils")

package com.mingliqiye.utils.security

import java.nio.charset.Charset
import java.security.MessageDigest
import java.security.SecureRandom
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

/**
 * 全局安全随机数生成器，用于生成加密安全的随机字节。
 *
 * [SecureRandom] 本身是线程安全的，可被多个线程共享。
 */
internal val SECURE_RANDOM = SecureRandom()

/**
 * 以 UTF-8 作为字符串默认编码。
 */
private val DEFAULT_CHARSET: Charset = Charsets.UTF_8

/**
 * 合法的 AES 密钥长度（字节）。
 */
private val AES_KEY_LENGTHS = setOf(16, 24, 32)

/**
 * 生成指定长度的加密安全随机字节。
 *
 * @param length 字节数，必须大于等于 0
 * @return 随机字节数组
 * @throws IllegalArgumentException 长度为负数时抛出
 */
fun getRandomBytes(length: Int): ByteArray {
	require(length >= 0) { "length must be >= 0, but was $length" }
	return ByteArray(length).also(SECURE_RANDOM::nextBytes)
}

/**
 * 使用指定摘要算法对字节数组做哈希。
 *
 * 注意：这里的 `algorithm` 是 **MessageDigest** 算法（如 `SHA-256`），
 * 不是 AES 之类的加密算法；该函数也不是密码 KDF，不要直接用来保存用户密码。
 *
 * @param algorithm 摘要算法名称
 * @param data 输入数据
 * @return 摘要字节
 */
fun createSecretKey(algorithm: String, data: ByteArray): ByteArray {
	require(algorithm.isNotBlank()) { "algorithm must not be blank" }
	return MessageDigest.getInstance(algorithm).digest(data)
}

/**
 * 使用指定摘要算法对 UTF-8 字符串做哈希。
 *
 * @param algorithm 摘要算法名称
 * @param data 输入字符串
 * @return 摘要字节
 */
fun createSecretKey(algorithm: String, data: String): ByteArray {
	return createSecretKey(algorithm, data.toByteArray(DEFAULT_CHARSET))
}

/**
 * 使用指定摘要算法和字符集对字符串做哈希。
 *
 * @param algorithm 摘要算法名称
 * @param data 输入字符串
 * @param charset 字符集
 * @return 摘要字节
 */
fun createSecretKey(algorithm: String, data: String, charset: Charset): ByteArray {
	return createSecretKey(algorithm, data.toByteArray(charset))
}

/**
 * 根据输入材料创建 [SecretKeySpec]。
 *
 * 对 AES 来说：
 * - 输入正好是 16/24/32 字节时作为原始密钥使用；
 * - 其他长度会先用 SHA-256 归一化为 32 字节。
 *
 * 对其他算法直接使用输入字节，由调用方保证长度符合算法要求。
 *
 * @param algorithm 密钥算法，例如 AES
 * @param data 密钥材料
 * @return SecretKeySpec
 */
fun createSecretKeySpec(algorithm: String, data: ByteArray): SecretKey {
	require(algorithm.isNotBlank()) { "algorithm must not be blank" }
	return SecretKeySpec(normalizeKey(algorithm, data), algorithm)
}

/**
 * 根据 UTF-8 字符串密钥材料创建 [SecretKeySpec]。
 *
 * @param algorithm 密钥算法
 * @param data 密钥字符串
 * @return SecretKeySpec
 */
fun createSecretKeySpec(algorithm: String, data: String): SecretKey {
	return createSecretKeySpec(algorithm, data.toByteArray(DEFAULT_CHARSET))
}

/**
 * 根据指定字符集的字符串密钥材料创建 [SecretKeySpec]。
 *
 * @param algorithm 密钥算法
 * @param data 密钥字符串
 * @param charset 字符集
 * @return SecretKeySpec
 */
fun createSecretKeySpec(algorithm: String, data: String, charset: Charset): SecretKey {
	return createSecretKeySpec(algorithm, data.toByteArray(charset))
}

/**
 * 以常量时间比较两个字节数组。
 *
 * 适用于比较 MAC、Token、哈希等敏感值，避免基于比较耗时的旁路攻击。
 *
 * @param a 字节数组 A
 * @param b 字节数组 B
 * @return 相等返回 `true`
 */
fun constantTimeEquals(a: ByteArray, b: ByteArray): Boolean {
	return MessageDigest.isEqual(a, b)
}

/**
 * 按算法规则归一化密钥材料。
 *
 * @param algorithm 密钥算法
 * @param data 原始密钥材料
 * @return 实际用于 SecretKeySpec 的字节
 */
private fun normalizeKey(algorithm: String, data: ByteArray): ByteArray {
	if (!algorithm.equals("AES", ignoreCase = true)) {
		return data.copyOf()
	}
	return when (data.size) {
		16, 24, 32 -> data.copyOf()
		else -> MessageDigest.getInstance("SHA-256").digest(data)
	}
}
