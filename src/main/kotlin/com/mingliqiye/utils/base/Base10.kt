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
 * CurrentFile Base10.kt
 * LastUpdate 2026-02-08 03:08:10
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

import java.math.BigInteger

internal class Base10 : BaseCodec {

    /**
     * 将字节数组编码为Base10字符串（十进制）
     * 
     * @param bytes 需要编码的字节数组
     * @return 编码后的Base10字符串（十进制数字）
     */
    override fun encode(bytes: ByteArray): String {
        if (bytes.isEmpty()) return "0"

        // 将字节数组转换为正的大整数
        val bigInt = BigInteger(1, bytes)  // 参数1表示正数
        return bigInt.toString(10)  // 转换为10进制字符串
    }

    /**
     * 将Base10字符串解码为字节数组
     * 
     * @param string 需要解码的Base10字符串（十进制数字）
     * @return 解码后的字节数组
     */
    override fun decode(string: String): ByteArray {
        // 验证输入是否为有效的十进制数字
        if (!string.matches(Regex("\\d+"))) {
            throw IllegalArgumentException("Base10字符串只能包含数字0-9")
        }

        val bigInt = BigInteger(string, 10)  // 从10进制解析

        // 转换为字节数组，并确保保留前导零
        var byteArray = bigInt.toByteArray()

        // BigInteger.toByteArray() 可能会添加一个符号字节
        // 对于正数，如果第一个字节是0，需要移除它
        if (byteArray.isNotEmpty() && byteArray[0] == 0.toByte()) {
            byteArray = byteArray.copyOfRange(1, byteArray.size)
        }

        return byteArray
    }
}
