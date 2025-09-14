@file:JvmName("AesUtils")

package com.mingliqiye.utils.security
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec

const val ALGORITHM = "AES"
const val AES_GCM_NO_PADDING = "AES/GCM/NoPadding"
const val AES_GCM_NO_PADDING_IV_LENGTH = 12
const val AES_GCM_NO_PADDING_TAG_LENGTH = 16

fun encryptAesGcmNoPadding(src: ByteArray, key: ByteArray,iv: ByteArray): ByteArray {
    val secretKeySpec = createSecretKeySpec(ALGORITHM,key)
    val cipher = Cipher.getInstance(AES_GCM_NO_PADDING)
    val gcmParameterSpec = GCMParameterSpec(
        AES_GCM_NO_PADDING_TAG_LENGTH * 8,
        iv
    )
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec)
    return cipher.doFinal(src)
}
fun encryptAesGcmNoPadding(src: ByteArray, key: String,iv: ByteArray): ByteArray {
    return encryptAesGcmNoPadding(src, key.toByteArray(), iv)
}
fun encryptAesGcmNoPadding(src: String, key: String,iv: ByteArray): ByteArray {
    return encryptAesGcmNoPadding(src.toByteArray(), key.toByteArray(), iv)
}

fun main() {
    val iv = getRandomBytes(16)
    println(encryptAesGcmNoPadding("mingliqiye","key", iv))
}



