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
 * CurrentFile ByteBufferUtils.kt
 * LastUpdate 2026-01-11 09:44:19
 * UpdateUser MingLiPro
 */

@file:JvmName("ByteBufferUtils")

package com.mingliqiye.utils.bytes

import java.io.IOException
import java.io.OutputStream
import java.nio.ByteBuffer
import java.nio.charset.Charset

/**
 * 将字符串以指定字符集编码后写入 [ByteBuffer]，并在末尾追加一个空字节（`0x00`）作为字符串终止符。
 *
 * 此方法适用于需要 C 风格字符串（null-terminated string）的协议或场景。
 *
 * @param string 要写入的字符串，不可为 null
 * @param charset 字符编码，默认为 [Charsets.UTF_8]
 * @return 当前 [ByteBuffer] 实例（支持链式调用）
 */
fun ByteBuffer.putString(string: String, charset: Charset = Charsets.UTF_8): ByteBuffer =
    this.put(string.toByteArray(charset)).put(0x00)

/**
 * 从 [ByteBuffer] 中读取一个以空字节（`0x00`）结尾的字符串。
 *
 * 该方法会持续读取字节，直到遇到第一个 `0x00`（null terminator）为止，并将之前读取的字节按指定字符集解码为字符串。
 * **注意**：此操作会修改缓冲区的位置（position），且不处理缓冲区越界情况（若无终止符会抛出异常）。
 *
 * @param charset 字符编码，默认为 [Charsets.UTF_8]
 * @return 解码后的字符串（不含终止符）
 * @throws BufferUnderflowException 如果缓冲区中没有足够的字节（即未找到终止符）
 */
fun ByteBuffer.getString(charset: Charset = Charsets.UTF_8): String {
    val data = ArrayList<Byte>()
    while (true) {
        val byte = this.get()
        if (byte == 0x00.toByte()) {
            break
        }
        data.add(byte)
    }
    return String(data.toByteArray(), charset)
}

/**
 * 将 [ByteBuffer] 中剩余的全部字节读取为一个 [ByteArray]。
 *
 * 此方法会读取从当前位置到 limit 之间的所有字节，并推进 position。
 *
 * @return 包含剩余字节的新字节数组
 */
fun ByteBuffer.toByteArray(): ByteArray {
    val ba = ByteArray(this.remaining())
    this.get(ba)
    return ba
}

/**
 * 将一个布尔列表（长度必须为 8）转换为 [ByteFlags] 并写入 [ByteBuffer]。
 *
 * 列表索引 0~7 分别对应位 b0~b7（b0 为最低有效位）。
 *
 * @param bit 长度为 8 的布尔列表，表示 8 个位的状态
 * @return 当前 [ByteBuffer] 实例（支持链式调用）
 * @throws IndexOutOfBoundsException 如果列表长度不足 8
 */
fun ByteBuffer.putByteFlags(
    bit: List<Boolean> = List(8) { false },
): ByteBuffer = this.putByteFlags(
    ByteFlags(
        bit[0],
        bit[1],
        bit[2],
        bit[3],
        bit[4],
        bit[5],
        bit[6],
        bit[7],
    )
)

/**
 * 将一个布尔数组（长度必须为 8）转换为 [ByteFlags] 并写入 [ByteBuffer]。
 *
 * 数组索引 0~7 分别对应位 b0~b7（b0 为最低有效位）。
 *
 * @param bit 长度为 8 的布尔数组
 * @return 当前 [ByteBuffer] 实例（支持链式调用）
 * @throws IndexOutOfBoundsException 如果数组长度不足 8
 */
fun ByteBuffer.putByteFlags(
    bit: BooleanArray = BooleanArray(8),
): ByteBuffer = this.putByteFlags(
    ByteFlags(
        bit[0],
        bit[1],
        bit[2],
        bit[3],
        bit[4],
        bit[5],
        bit[6],
        bit[7],
    )
)

/**
 * 将 [ByteFlags] 对象转换为字节并写入 [ByteBuffer]。
 *
 * @param byteFlags 要写入的位标志对象
 * @return 当前 [ByteBuffer] 实例（支持链式调用）
 */
fun ByteBuffer.putByteFlags(byteFlags: ByteFlags): ByteBuffer = this.put(byteFlags.toByte())

/**
 * 通过 8 个独立的布尔参数构造 [ByteFlags] 并写入 [ByteBuffer]。
 *
 * 参数顺序：`bit0`（LSB）到 `bit7`（MSB）。
 *
 * @param bit0 第 0 位（最低位）
 * @param bit1 第 1 位
 * @param bit2 第 2 位
 * @param bit3 第 3 位
 * @param bit4 第 4 位
 * @param bit5 第 5 位
 * @param bit6 第 6 位
 * @param bit7 第 7 位（最高位）
 * @return 当前 [ByteBuffer] 实例（支持链式调用）
 */
fun ByteBuffer.putByteFlags(
    bit0: Boolean = false,
    bit1: Boolean = false,
    bit2: Boolean = false,
    bit3: Boolean = false,
    bit4: Boolean = false,
    bit5: Boolean = false,
    bit6: Boolean = false,
    bit7: Boolean = false,
): ByteBuffer = this.putByteFlags(
    ByteFlags(
        bit0,
        bit1,
        bit2,
        bit3,
        bit4,
        bit5,
        bit6,
        bit7,
    )
)

/**
 * 从 [ByteBuffer] 中读取一个字节，并将其解析为 [ByteFlags] 对象。
 *
 * @return 表示该字节各位状态的 [ByteFlags] 实例
 */
fun ByteBuffer.getByteFlags(): ByteFlags = ByteFlags(this.get())

/**
 * 从 [ByteBuffer] 中读取一个字节，并将其解释为布尔值。
 *
 * 约定：`0x01` 表示 `true`，其他值（包括 `0x00`）均视为 `false`。
 *
 * @return 布尔值
 */
fun ByteBuffer.getBoolean(): Boolean = this.get() == 0x01.toByte()

/**
 * 将布尔值写入 [ByteBuffer]。
 *
 * 约定：`true` 写为 `0x01`，`false` 写为 `0x00`。
 *
 * @param boolean 要写入的布尔值
 * @return 当前 [ByteBuffer] 实例（支持链式调用）
 */
fun ByteBuffer.putBoolean(boolean: Boolean): ByteBuffer = this.put(if (boolean) 0x01 else 0x00)

/**
 * 将当前字节数组包装为一个只读的 [ByteBuffer]。
 *
 * 使用 [ByteBuffer.wrap] 创建，position 初始为 0，limit 为数组长度。
 *
 * @return 包装后的 [ByteBuffer] 实例
 */
fun ByteArray.toByteBuffer(): ByteBuffer {
    return ByteBuffer.wrap(this)
}

/**
 * 从ByteBuffer中读取一个变长整数（VarNumber）。
 *
 * 变长整数使用可变长度编码方式，每个字节的最高位表示是否还有后续字节：
 * - 如果最高位为1，则表示还有下一个字节；
 * - 如果最高位为0，则表示当前字节是最后一个字节。
 *
 * @param size 最大允许读取的字节数，默认为8（即Long类型的最大长度）。
 * @return 解码后的长整型数值。
 * @throws IOException 当读取过程中发生IO异常时抛出。
 */
fun ByteBuffer.getVarLong(size: Int = 8): Long {
    var numRead = 0
    var result: Long = 0
    var read: Byte
    do {
        read = this.get()
        // 将当前字节的有效7位数据左移相应位置后与结果进行按位或运算
        result = result or ((read.toLong() and 127) shl (7 * numRead))
        numRead++
        if (numRead > size) {
            throw IOException("VarNumber is too big")
        }
    } while ((read.toLong() and 128) != 0L)
    return result
}

/**
 * 从ByteBuffer中读取一个变长整数（VarNumber），返回Int类型。
 *
 * @return 解码后的整型数值。
 */
fun ByteBuffer.getVarInt(): Int = this.getVarLong(4).toInt()

/**
 * 从ByteBuffer中读取一个变长整数（VarNumber），返回Short类型。
 *
 * @return 解码后的短整型数值。
 */
fun ByteBuffer.getVarShort(): Short = this.getVarLong(2).toShort()

/**
 * 从输入流中读取一个变长长整数（VarLong），最大长度默认为8个字节。
 *
 * @return 解码后的长整型数值。
 * @throws IOException 当读取过程中发生IO异常时抛出。
 */
@Throws(IOException::class)
fun ByteBuffer.getVarLong(): Long = this.getVarLong(8)


/**
 * 将长整型数值编码为变长格式并写入ByteBuffer
 *
 * 变长整数使用可变长度编码方式，每个字节的最高位表示是否还有后续字节：
 * - 如果数值还有更多字节，则最高位设为1；
 * - 最后一个字节最高位设为0。
 *
 * @param value 要写入的长整型数值
 * @return 当前ByteBuffer实例（支持链式调用）
 */
fun ByteBuffer.putVarLong(value: Long): ByteBuffer {
    var v = value
    while (v >= 0x80) {
        this.put((v and 0x7F or 0x80).toByte())
        v = v shr 7
    }
    this.put(v.toByte())
    return this
}

/**
 * 将整型数值编码为变长格式并写入ByteBuffer
 *
 * @param value 要写入的整型数值
 * @return 当前ByteBuffer实例（支持链式调用）
 */
fun ByteBuffer.putVarInt(value: Int): ByteBuffer = this.putVarLong(value.toLong())

/**
 * 将短整型数值编码为变长格式并写入ByteBuffer
 *
 * @param value 要写入的短整型数值
 * @return 当前ByteBuffer实例（支持链式调用）
 */
fun ByteBuffer.putVarShort(value: Short): ByteBuffer = this.putVarLong(value.toLong())


fun ByteBuffer.writeStream(outputStream: OutputStream) = outputStream.write(this.toByteArray())
