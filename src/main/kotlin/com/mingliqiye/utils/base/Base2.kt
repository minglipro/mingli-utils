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
 * CurrentFile Base2.kt
 * LastUpdate 2026-02-08 03:06:23
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

internal class Base2 : BaseCodec {
    override fun encode(bytes: ByteArray): String {
        if (bytes.isEmpty()) return ""
        val result = StringBuilder()
        for ((index, byte) in bytes.withIndex()) {
            val unsignedByte = byte.toInt() and 0xFF
            val binary = unsignedByte.toString(2).padStart(8, '0')
            result.append(binary)
        }
        return result.toString()
    }

    override fun decode(string: String): ByteArray {
        if (string.length % 8 != 0) {
            throw IllegalArgumentException(
                "BASE1字符串长度必须是8的倍数，当前长度: ${string.length}"
            )
        }
        if (!string.matches(Regex("[01]+"))) {
            throw IllegalArgumentException(
                "BASE1字符串只能包含字符'0'和'1'"
            )
        }
        val byteCount = string.length / 8
        val result = ByteArray(byteCount)
        for (i in 0 until byteCount) {
            val startIndex = i * 8
            val endIndex = startIndex + 8
            val binaryStr = string.substring(startIndex, endIndex)
            val byteValue = binaryStr.toInt(2)
            result[i] = byteValue.toByte()
        }
        return result
    }
}
