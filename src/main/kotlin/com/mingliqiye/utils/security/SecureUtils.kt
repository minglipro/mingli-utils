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
    return SecretKeySpec( createSecretKey(algorithm,data), algorithm)
}

fun createSecretKeySpec(algorithm: String, data: ByteArray): SecretKey {
    return SecretKeySpec( createSecretKey(algorithm,data), algorithm)
}