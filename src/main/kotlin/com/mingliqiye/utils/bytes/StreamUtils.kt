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
 * CurrentFile StreamUtils.kt
 * LastUpdate 2026-01-11 09:41:14
 * UpdateUser MingLiPro
 */
@file:JvmName("StreamUtils")

package com.mingliqiye.utils.bytes

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream


/**
 * 从输入流中读取一个变长整数（VarNumber）。
 *
 * 变长整数使用可变长度编码方式，每个字节的最高位表示是否还有后续字节：
 * - 如果最高位为1，则表示还有下一个字节；
 * - 如果最高位为0，则表示当前字节是最后一个字节。
 *
 * @param size 最大允许读取的字节数，默认为8（即Long类型的最大长度）。
 * @return 解码后的长整型数值。
 * @throws IOException 当读取过程中发生IO异常或到达流末尾时抛出。
 */
@Throws(IOException::class)
fun InputStream.readVarNumber(size: Int = 8): Long {
    var numRead = 0
    var result: Long = 0
    var read: Byte
    do {
        read = this.read().let {
            if (it == -1) {
                throw IOException("Reached end of stream")
            }
            it.toByte()
        }
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
 * @return 解码后的整型数值。
 * @throws IOException 当读取过程中发生IO异常时抛出。
 */
@Throws(IOException::class)
fun InputStream.readVarInt(): Int = this.readVarNumber(4).toInt()


/**
 * 从输入流中读取一个变长短整数（VarShort），最大长度限制为2个字节。
 *
 * @return 解码后的短整型数值。
 * @throws IOException 当读取过程中发生IO异常时抛出。
 */
@Throws(IOException::class)
fun InputStream.readVarShort(): Short = this.readVarNumber(2).toShort()


/**
 * 从输入流中读取一个变长长整数（VarLong），最大长度默认为8个字节。
 *
 * @return 解码后的长整型数值。
 * @throws IOException 当读取过程中发生IO异常时抛出。
 */
@Throws(IOException::class)
fun InputStream.readVarLong(): Long = this.readVarNumber()

/**
 * 将长整型数值编码为变长格式并写入输出流
 *
 * 变长整数使用可变长度编码方式，每个字节的最高位表示是否还有后续字节：
 * - 如果数值还有更多字节，则最高位设为1；
 * - 最后一个字节最高位设为0。
 *
 * @param value 要写入的长整型数值
 * @param size 最大允许写入的字节数，默认为8
 * @throws IOException 当写入过程中发生IO异常时抛出
 */
@Throws(IOException::class)
fun OutputStream.writeVarNumber(value: Long, size: Int = 8) {
    var v = value
    var numWritten = 0

    while (v >= 0x80 && numWritten < size - 1) {
        this.write((v and 0x7F or 0x80).toInt())
        v = v ushr 7
        numWritten++
    }

    if (numWritten >= size) {
        throw IOException("VarNumber is too big")
    }

    this.write(v.toInt())
}

/**
 * 将整型数值编码为变长格式并写入输出流
 *
 * @param value 要写入的整型数值
 * @throws IOException 当写入过程中发生IO异常时抛出
 */
@Throws(IOException::class)
fun OutputStream.writeVarInt(value: Int): Unit = this.writeVarNumber(value.toLong(), 4)

/**
 * 将短整型数值编码为变长格式并写入输出流
 *
 * @param value 要写入的短整型数值
 * @throws IOException 当写入过程中发生IO异常时抛出
 */
@Throws(IOException::class)
fun OutputStream.writeVarShort(value: Short): Unit = this.writeVarNumber(value.toLong(), 2)

/**
 * 将长整型数值编码为变长格式并写入输出流
 *
 * @param value 要写入的长整型数值
 * @throws IOException 当写入过程中发生IO异常时抛出
 */
@Throws(IOException::class)
fun OutputStream.writeVarLong(value: Long): Unit = this.writeVarNumber(value, 8)
