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
 * LastUpdate 2026-02-05 11:12:36
 * UpdateUser MingLiPro
 */

@file:JvmName("SecureUtils")

package com.mingliqiye.utils.security

import java.security.MessageDigest
import java.security.SecureRandom
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

/**
 * 全局安全随机数生成器实例，用于生成加密安全的随机字节。
 */
internal val SECURE_RANDOM = SecureRandom()

/**
 * 生成指定长度的加密安全随机字节数组。
 *
 * @param length 需要生成的字节数组的长度。
 * @return 包含随机字节的 ByteArray。
 */
fun getRandomBytes(length: Int): ByteArray {
    val bytes = ByteArray(length)
    SECURE_RANDOM.nextBytes(bytes)
    return bytes
}

/**
 * 使用指定算法对输入数据进行哈希处理，生成密钥字节数组。
 *
 * @param algorithm 哈希算法名称（如 SHA-256）。
 * @param data 输入的字节数组数据。
 * @return 经过哈希处理后的密钥字节数组。
 */
fun createSecretKey(algorithm: String, data: ByteArray): ByteArray {
    val md = MessageDigest.getInstance(algorithm)
    return md.digest(data)
}

/**
 * 使用指定算法对输入字符串进行哈希处理，生成密钥字节数组。
 *
 * @param algorithm 哈希算法名称（如 SHA-256）。
 * @param data 输入的字符串数据。
 * @return 经过哈希处理后的密钥字节数组。
 */
fun createSecretKey(algorithm: String, data: String): ByteArray {
    return createSecretKey(algorithm, data.toByteArray())
}

/**
 * 使用指定算法和输入字符串创建 SecretKeySpec 对象。
 *
 * @param algorithm 哈希算法名称（如 AES）。
 * @param data 输入的字符串数据。
 * @return 根据输入数据和算法生成的 SecretKey 对象。
 */
fun createSecretKeySpec(algorithm: String, data: String): SecretKey {
    return SecretKeySpec(createSecretKey(algorithm, data), algorithm)
}

/**
 * 使用指定算法和输入字节数组创建 SecretKeySpec 对象。
 *
 * @param algorithm 哈希算法名称（如 AES）。
 * @param data 输入的字节数组数据。
 * @return 根据输入数据和算法生成的 SecretKey 对象。
 */
fun createSecretKeySpec(algorithm: String, data: ByteArray): SecretKey {
    return SecretKeySpec(createSecretKey(algorithm, data), algorithm)
}
