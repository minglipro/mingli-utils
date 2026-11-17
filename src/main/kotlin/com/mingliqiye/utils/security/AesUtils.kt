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
 * LastUpdate 2025-09-19 20:18:09
 * UpdateUser MingLiPro
 */

@file:JvmName("AesUtils")

package com.mingliqiye.utils.security

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

/**
 * 使用 AES/GCM/NoPadding 模式加密字节数组。
 *
 * @param src 待加密的字节数组
 * @param key 密钥字节数组
 * @param iv 初始化向量（建议 12 字节）
 * @return 加密后的字节数组（含认证标签）
 * @throws GeneralSecurityException 如果加密过程中发生安全相关异常
 */
fun encryptAesGcmNoPadding(src: ByteArray, key: ByteArray, iv: ByteArray): ByteArray {
	val secretKeySpec = createSecretKeySpec(ALGORITHM, key)
	val cipher = Cipher.getInstance(AES_GCM_NO_PADDING)
	val gcmParameterSpec = GCMParameterSpec(
		AES_GCM_NO_PADDING_TAG_LENGTH * 8,
		iv
	)
	cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec)
	return cipher.doFinal(src)
}

/**
 * 使用 AES/GCM/NoPadding 模式加密字节数组，密钥以字符串形式提供。
 *
 * @param src 待加密的字节数组
 * @param key 密钥字符串（按平台默认字符集转换为字节）
 * @param iv 初始化向量（建议 12 字节）
 * @return 加密后的字节数组（含认证标签）
 * @throws GeneralSecurityException 如果加密过程中发生安全相关异常
 */
fun encryptAesGcmNoPadding(src: ByteArray, key: String, iv: ByteArray): ByteArray {
	return encryptAesGcmNoPadding(src, key.toByteArray(), iv)
}

/**
 * 使用 AES/GCM/NoPadding 模式加密字符串，密钥以字符串形式提供。
 *
 * @param src 待加密的字符串（按平台默认字符集转换为字节）
 * @param key 密钥字符串（按平台默认字符集转换为字节）
 * @param iv 初始化向量（建议 12 字节）
 * @return 加密后的字节数组（含认证标签）
 * @throws GeneralSecurityException 如果加密过程中发生安全相关异常
 */
fun encryptAesGcmNoPadding(src: String, key: String, iv: ByteArray): ByteArray {
	return encryptAesGcmNoPadding(src.toByteArray(), key.toByteArray(), iv)
}
