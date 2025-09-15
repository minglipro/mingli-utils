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
 * LastUpdate 2025-09-15 22:32:50
 * UpdateUser MingLiPro
 */


@file:JvmName("AesUtils")

package com.mingliqiye.utils.aes

import com.mingliqiye.utils.base64.decode
import com.mingliqiye.utils.base64.encode
import java.nio.charset.StandardCharsets
import java.security.GeneralSecurityException
import java.security.MessageDigest
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

const val ALGORITHM = "AES"
const val TRANSFORMATION = "AES/GCM/NoPadding"
const val GCM_IV_LENGTH = 12
const val GCM_TAG_LENGTH = 16
val SECURE_RANDOM = SecureRandom()


/**
 * AES加密方法（使用GCM模式）
 * @param sSrc 待加密的字符串
 * @param sKey 加密密钥
 * @return 加密后的字符串，格式为 IV:EncryptedData+Tag（均为Base64编码）
 * @throws GeneralSecurityException 加密错误
 */
@Throws(GeneralSecurityException::class)
fun encrypt(sSrc: String, sKey: String?): String? {
    if (sKey == null) {
        return null
    }

    // 生成密钥
    val secretKeySpec = createSecretKey(sKey)

    // 生成安全随机IV
    val iv = ByteArray(GCM_IV_LENGTH)
    SECURE_RANDOM.nextBytes(iv)

    // 初始化加密器
    val cipher = Cipher.getInstance(TRANSFORMATION)
    val gcmParameterSpec = GCMParameterSpec(
        GCM_TAG_LENGTH * 8, iv
    )
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec)

    val encrypted = cipher.doFinal(
        sSrc.toByteArray(StandardCharsets.UTF_8)
    )
    return encode(
        "${encode(iv)}:${encode(encrypted)}".toByteArray()
    )
}

/**
 * AES解密方法（使用GCM模式）
 * @param sSrc 待解密的字符串，格式为 IV:EncryptedData+Tag（均为Base64编码）
 * @param sKey 解密密钥
 * @return 解密后的原始字符串
 */
fun decrypt(sSrc: String, sKey: String): String? {
    try {
        // 分割IV和加密数据
        val sSrcs = String(decode(sSrc))
        val parts: Array<String?> = sSrcs.split(":".toRegex(), limit = 2).toTypedArray()
        if (parts.size != 2) {
            return null
        }
        val iv = decode(parts[0]!!)
        val encryptedData = decode(parts[1]!!)
        if (iv.size != GCM_IV_LENGTH) {
            return null
        }
        val secretKeySpec = createSecretKey(sKey)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        val gcmParameterSpec = GCMParameterSpec(
            GCM_TAG_LENGTH * 8, iv
        )
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec)
        val original = cipher.doFinal(encryptedData)
        return String(original, StandardCharsets.UTF_8)
    } catch (e: Exception) {
        return null
    }
}

/**
 * 创建AES密钥，支持任意长度的密钥
 * @param sKey 字符串密钥
 * @return SecretKeySpec对象
 * @throws Exception 可能抛出的异常
 */
@Throws(Exception::class)
private fun createSecretKey(sKey: String): SecretKeySpec {
    val key = sKey.toByteArray(StandardCharsets.UTF_8)
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(key)
    return SecretKeySpec(digest, ALGORITHM)
}
