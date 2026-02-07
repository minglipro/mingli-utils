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
 * CurrentFile RandomBytes.kt
 * LastUpdate 2026-01-28 10:47:13
 * UpdateUser MingLiPro
 */
@file:JvmName("RandomBytes")

package com.mingliqiye.utils.random

/**
 * 生成指定长度的随机字节数组
 * @param length 数组长度
 * @return 包含随机字节的数组
 */
fun randomBytes(length: Int): ByteArray {
    val bytes = ByteArray(length)
    for (i in 0..<length) {
        bytes[i] = randomByte(0x00.toByte(), 0xff.toByte())
    }
    return bytes
}


/**
 * 生成指定长度的随机字节数组
 * 从给定的字节数组中随机选择字节来填充新数组
 *
 * @param length 要生成的随机字节数组的长度
 * @param bytes 用于随机选择的源字节数组
 * @return 包含随机字节的新数组
 */
fun randomBytes(length: Int, bytes: ByteArray): ByteArray {
    val rbytes = ByteArray(length)
    // 从源数组中随机选择字节填充到结果数组中
    for (i in 0..<length) {
        rbytes[i] = bytes[randomInt(i, bytes.size - 1)]
    }
    return rbytes
}

/**
 * 生成指定范围内的随机字节
 * @param from 起始字节值（包含）
 * @param to 结束字节值（包含）
 * @return 指定范围内的随机字节
 */
fun randomByte(from: Byte, to: Byte): Byte {
    val fromInt = from.toInt() and 0xFF
    val toInt = to.toInt() and 0xFF
    val randomValue = randomInt(fromInt, toInt)
    return (randomValue and 0xFF).toByte()
}

/**
 * 生成指定范围内的随机字节（不包含边界值）
 * @param from 起始字节值（不包含）
 * @param to 结束字节值（不包含）
 * @return 指定范围内的随机字节
 */
fun randomByteNoHave(from: Byte, to: Byte): Byte {
    val fromInt = from.toInt() and 0xFF
    val toInt = to.toInt() and 0xFF
    val randomValue = randomIntNoHave(fromInt, toInt)
    return (randomValue and 0xFF).toByte()
}


fun randomByte(size: Int): ByteArray {
    val bytes = ByteArray(size)
    secureRandom.nextBytes(bytes)
    return bytes
}
