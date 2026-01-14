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
 * CurrentFile ByteUtils.kt
 * LastUpdate 2026-01-14 13:01:44
 * UpdateUser MingLiPro
 */
@file:JvmName("ByteUtils")

package com.mingliqiye.utils.bytes

import com.mingliqiye.utils.base.BASE16
import com.mingliqiye.utils.stream.SuperStream

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_ASC: Byte = 0x10

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_DESC: Byte = 0x1B

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_NONE: Byte = 0x00

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_START: Byte = 0x01

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_END: Byte = 0x02

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_ESC: Byte = 0x03

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_CONTROL: Byte = 0x04

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_DATA: Byte = 0x05

/**
 * 转义字符常量定义
 * 定义了用于数据传输或协议通信中的特殊控制字节值
 */
const val ESC_RESERVED: Byte = 0x06


/**
 * 将字节数组转换为十六进制字符串列表
 * @receiver 字节数组
 * @return 包含每个字节对应十六进制字符串的列表
 */
fun ByteArray.getByteArrayString(): MutableList<String> {
    return this.toList().stream().map { a -> String.format("0X%02X", a!!.toInt() and 0xFF) }
        .collect(SuperStream.toList()) as MutableList<String>
}


/**
 * 将十六进制字符转换为对应的数值
 * @receiver 十六进制字符
 * @return 对应的数值（0-15）
 * @throws NumberFormatException 当字符不是有效的十六进制字符时抛出
 */
fun Char.hexDigitToValue(): Int {
    return when (this) {
        in '0'..'9' -> this - '0'
        in 'A'..'F' -> this - 'A' + 10
        in 'a'..'f' -> this - 'a' + 10
        else -> throw NumberFormatException("Invalid hex character: $this")
    }
}

/**
 * 将十六进制字符串转换为字节数组
 *
 * @param string 输入的十六进制字符串
 * @return 转换后的字节数组
 */
fun hexStringToByteArray(string: String): ByteArray {
    return string.hexToByteArray()
}


/**
 * 将字节数组转换为十六进制字符串表示。
 *
 * @param bytes 输入的字节数组
 * @return 对应的十六进制字符串
 */
fun bytesToHex(bytes: ByteArray): String {
    return BASE16.encode(bytes)
}
