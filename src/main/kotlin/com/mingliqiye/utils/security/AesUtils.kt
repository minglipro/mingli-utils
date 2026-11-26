/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile AesUtils.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

@file:JvmName("AesUtils")

package com.mingliqiye.utils.security

import java.nio.charset.Charset
import java.security.GeneralSecurityException
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec

/** 加密算法名称：AES。 */
const val ALGORITHM = "AES"

/** AES 加密变换模式：GCM 模式，无填充。 */
const val AES_GCM_NO_PADDING = "AES/GCM/NoPadding"

/** GCM 模式初始化向量（IV）长度，单位字节。 */
const val AES_GCM_NO_PADDING_IV_LENGTH = 12

/** GCM 模式认证标签（Tag）长度，单位字节。 */
const val AES_GCM_NO_PADDING_TAG_LENGTH = 16

/** GCM 认证标签长度，单位 bit。 */
private const val AES_GCM_TAG_BITS = AES_GCM_NO_PADDING_TAG_LENGTH * 8

/** 合法的 AES 密钥长度（字节）：128/192/256 bit。 */
private val AES_KEY_LENGTHS = setOf(16, 24, 32)

/** 字符串默认 UTF-8 编码。 */
private val DEFAULT_CHARSET: Charset = Charsets.UTF_8

/**
 * 生成一个适用于 AES/GCM 的随机 IV。
 *
 * IV 不应在同一个密钥下重复使用。
 *
 * @return 12 字节随机 IV
 */
fun randomAesGcmIv(): ByteArray {
	return getRandomBytes(AES_GCM_NO_PADDING_IV_LENGTH)
}

/**
 * 使用 AES/GCM/NoPadding 加密字节数组。
 *
 * @param src 明文
 * @param key 密钥字节；支持 16/24/32 字节原始密钥，其他长度会经 SHA-256 归一化
 * @param iv 12 字节初始化向量
 * @return 密文（含 16 字节认证标签）
 * @throws IllegalArgumentException 密钥或 IV 长度非法时抛出
 * @throws GeneralSecurityException 加密失败时抛出
 */
fun encryptAesGcmNoPadding(src: ByteArray, key: ByteArray, iv: ByteArray): ByteArray {
	requireAesIv(iv)
	return aesCipher(Cipher.ENCRYPT_MODE, key, iv).doFinal(src)
}

/**
 * 使用 AES/GCM/NoPadding 加密字节数组，密钥以 UTF-8 字符串提供。
 *
 * @param src 明文
 * @param key 密钥字符串
 * @param iv 12 字节初始化向量
 * @return 密文（含认证标签）
 */
fun encryptAesGcmNoPadding(src: ByteArray, key: String, iv: ByteArray): ByteArray {
	return encryptAesGcmNoPadding(src, key.toByteArray(DEFAULT_CHARSET), iv)
}

/**
 * 使用 AES/GCM/NoPadding 加密字符串，密钥以 UTF-8 字符串提供。
 *
 * @param src 明文字符串
 * @param key 密钥字符串
 * @param iv 12 字节初始化向量
 * @return 密文（含认证标签）
 */
fun encryptAesGcmNoPadding(src: String, key: String, iv: ByteArray): ByteArray {
	return encryptAesGcmNoPadding(src.toByteArray(DEFAULT_CHARSET), key, iv)
}

/**
 * 使用 AES/GCM/NoPadding 加密字节数组，并自动生成随机 IV。
 *
 * 返回值格式为 `iv || ciphertext`，解密时使用 [decryptAesGcmNoPadding] 的
 * 两参数重载即可。
 *
 * @param src 明文
 * @param key 密钥字节
 * @return `iv + 密文` 组合后的字节数组
 */
fun encryptAesGcmNoPadding(src: ByteArray, key: ByteArray): ByteArray {
	val iv = randomAesGcmIv()
	return iv + encryptAesGcmNoPadding(src, key, iv)
}

/**
 * 使用 AES/GCM/NoPadding 加密字符串，并自动生成随机 IV。
 *
 * @param src 明文字符串
 * @param key 密钥字符串
 * @return `iv + 密文` 组合后的字节数组
 */
fun encryptAesGcmNoPadding(src: String, key: String): ByteArray {
	return encryptAesGcmNoPadding(src.toByteArray(DEFAULT_CHARSET), key.toByteArray(DEFAULT_CHARSET))
}

/**
 * 使用 AES/GCM/NoPadding 解密字节数组。
 *
 * @param src 密文（含认证标签）
 * @param key 密钥字节
 * @param iv 加密时使用的 12 字节 IV
 * @return 明文
 * @throws IllegalArgumentException 密钥或 IV 长度非法时抛出
 * @throws GeneralSecurityException 解密或认证失败时抛出
 */
fun decryptAesGcmNoPadding(src: ByteArray, key: ByteArray, iv: ByteArray): ByteArray {
	requireAesIv(iv)
	return aesCipher(Cipher.DECRYPT_MODE, key, iv).doFinal(src)
}

/**
 * 使用 AES/GCM/NoPadding 解密字节数组，密钥以 UTF-8 字符串提供。
 *
 * @param src 密文
 * @param key 密钥字符串
 * @param iv 加密时使用的 IV
 * @return 明文
 */
fun decryptAesGcmNoPadding(src: ByteArray, key: String, iv: ByteArray): ByteArray {
	return decryptAesGcmNoPadding(src, key.toByteArray(DEFAULT_CHARSET), iv)
}

/**
 * 使用 AES/GCM/NoPadding 解密，并自动从输入中读取前缀 IV。
 *
 * @param src `iv + 密文` 形式的字节数组
 * @param key 密钥字节
 * @return 明文
 * @throws IllegalArgumentException 数据长度不足时抛出
 * @throws GeneralSecurityException 解密或认证失败时抛出
 */
fun decryptAesGcmNoPadding(src: ByteArray, key: ByteArray): ByteArray {
	require(src.size >= AES_GCM_NO_PADDING_IV_LENGTH + AES_GCM_NO_PADDING_TAG_LENGTH) {
		"encrypted data is too short"
	}
	val iv = src.copyOfRange(0, AES_GCM_NO_PADDING_IV_LENGTH)
	val ciphertext = src.copyOfRange(AES_GCM_NO_PADDING_IV_LENGTH, src.size)
	return decryptAesGcmNoPadding(ciphertext, key, iv)
}

/**
 * 使用 AES/GCM/NoPadding 解密为 UTF-8 字符串。
 *
 * @param src 密文
 * @param key 密钥字节
 * @param iv 加密时使用的 IV
 * @return 明文字符串
 */
fun decryptAesGcmNoPaddingToString(src: ByteArray, key: ByteArray, iv: ByteArray): String {
	return String(decryptAesGcmNoPadding(src, key, iv), DEFAULT_CHARSET)
}

/**
 * 使用 AES/GCM/NoPadding 解密为 UTF-8 字符串，密钥以字符串提供。
 *
 * @param src 密文
 * @param key 密钥字符串
 * @param iv 加密时使用的 IV
 * @return 明文字符串
 */
fun decryptAesGcmNoPaddingToString(src: ByteArray, key: String, iv: ByteArray): String {
	return String(decryptAesGcmNoPadding(src, key, iv), DEFAULT_CHARSET)
}

/**
 * 使用 AES 密钥创建并初始化 [Cipher]。
 *
 * @param mode [Cipher.ENCRYPT_MODE] 或 [Cipher.DECRYPT_MODE]
 * @param key 密钥字节
 * @param iv 12 字节 IV
 * @return 已初始化的 Cipher
 */
private fun aesCipher(mode: Int, key: ByteArray, iv: ByteArray): Cipher {
	val secretKey = createSecretKeySpec(ALGORITHM, key)
	require(secretKey.encoded.size in AES_KEY_LENGTHS) {
		"AES key must be 16, 24 or 32 bytes after derivation, but was ${secretKey.encoded.size}"
	}
	val cipher = Cipher.getInstance(AES_GCM_NO_PADDING)
	cipher.init(mode, secretKey, GCMParameterSpec(AES_GCM_TAG_BITS, iv))
	return cipher
}

/**
 * 校验 GCM IV 长度。
 *
 * @param iv IV 字节
 */
private fun requireAesIv(iv: ByteArray) {
	require(iv.size == AES_GCM_NO_PADDING_IV_LENGTH) {
		"GCM IV must be $AES_GCM_NO_PADDING_IV_LENGTH bytes, but was ${iv.size}"
	}
}
