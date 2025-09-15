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

package com.mingliqiye.utils.security

import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec

const val ALGORITHM = "AES"
const val AES_GCM_NO_PADDING = "AES/GCM/NoPadding"
const val AES_GCM_NO_PADDING_IV_LENGTH = 12
const val AES_GCM_NO_PADDING_TAG_LENGTH = 16

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

fun encryptAesGcmNoPadding(src: ByteArray, key: String, iv: ByteArray): ByteArray {
    return encryptAesGcmNoPadding(src, key.toByteArray(), iv)
}

fun encryptAesGcmNoPadding(src: String, key: String, iv: ByteArray): ByteArray {
    return encryptAesGcmNoPadding(src.toByteArray(), key.toByteArray(), iv)
}

fun main() {
    val iv = getRandomBytes(16)
    println(encryptAesGcmNoPadding("mingliqiye", "key", iv))
}



