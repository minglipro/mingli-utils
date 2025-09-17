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
 * CurrentFile NumberUtils.kt
 * LastUpdate 2025-09-16 15:59:45
 * UpdateUser MingLiPro
 */

@file:JvmName("NumberUtils")

package com.mingliqiye.utils.number

import java.io.IOException
import java.io.InputStream


/**
 * 从输入流中读取一个变长整数（VarNumber）。
 *
 * 变长整数使用可变长度编码方式，每个字节的最高位表示是否还有后续字节：
 * - 如果最高位为1，则表示还有下一个字节；
 * - 如果最高位为0，则表示当前字节是最后一个字节。
 *
 * @param input 输入流，用于读取数据。
 * @param size 最大允许读取的字节数，默认为8（即Long类型的最大长度）。
 * @return 解码后的长整型数值。
 * @throws IOException 当读取过程中发生IO异常或到达流末尾时抛出。
 */
@Throws(IOException::class)
fun readVarNumber(input: InputStream, size: Int = 10): Long {
    var numRead = 0
    var result: Long = 0
    var read: Byte
    do {
        read = input.read().let {
            if (it == -1) {
                throw IOException("Reached end of stream")
            }
            it.toByte()
        }

        // 将当前字节的有效7位数据左移相应位数，并与结果进行或运算
        result = result or ((read.toLong() and 127) shl (7 * numRead))
        numRead++
        if (numRead > size) {
            throw IOException("VarNumber is too big")
        }
    } while ((read.toLong() and 128) != 0L)
    return result
}

/**
 * 从输入流中读取一个变长整数（VarInt），最大长度限制为4个字节。
 *
 * @param input 输入流，用于读取数据。
 * @return 解码后的整型数值。
 * @throws IOException 当读取过程中发生IO异常时抛出。
 */
@Throws(IOException::class)
fun readVarInt(input: InputStream): Int {
    return readVarNumber(input, size = 4).toInt()
}

/**
 * 从输入流中读取一个变长短整数（VarShort），最大长度限制为2个字节。
 *
 * @param input 输入流，用于读取数据。
 * @return 解码后的短整型数值。
 * @throws IOException 当读取过程中发生IO异常时抛出。
 */
@Throws(IOException::class)
fun readVarShort(input: InputStream): Short {
    return readVarNumber(input, size = 2).toShort()
}

/**
 * 从输入流中读取一个变长长整数（VarLong），最大长度默认为8个字节。
 *
 * @param input 输入流，用于读取数据。
 * @return 解码后的长整型数值。
 * @throws IOException 当读取过程中发生IO异常时抛出。
 */
@Throws(IOException::class)
fun readVarLong(input: InputStream): Long {
    return readVarNumber(input)
}
