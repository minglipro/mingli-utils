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
 * CurrentFile SecureUtils.kt
 * LastUpdate 2025-09-15 22:32:50
 * UpdateUser MingLiPro
 */

@file:JvmName("SecureUtils")

package com.mingliqiye.utils.security

import java.security.MessageDigest
import java.security.SecureRandom
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

internal val SECURE_RANDOM = SecureRandom()

fun getRandomBytes(length: Int): ByteArray {
    val bytes = ByteArray(length)
    SECURE_RANDOM.nextBytes(bytes)
    return bytes
}

fun createSecretKey(algorithm: String, data: ByteArray): ByteArray {
    val md = MessageDigest.getInstance(algorithm)
    return md.digest(data)
}

fun createSecretKey(algorithm: String, data: String): ByteArray {
    return createSecretKey(algorithm, data.toByteArray())
}

fun createSecretKeySpec(algorithm: String, data: String): SecretKey {
    return SecretKeySpec(createSecretKey(algorithm, data), algorithm)
}

fun createSecretKeySpec(algorithm: String, data: ByteArray): SecretKey {
    return SecretKeySpec(createSecretKey(algorithm, data), algorithm)
}
