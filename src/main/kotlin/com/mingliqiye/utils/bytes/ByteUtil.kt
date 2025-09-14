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
 * CurrentFile ByteUtil.kt
 * LastUpdate 2025-09-14 18:19:29
 * UpdateUser MingLiPro
 */
@file:JvmName("ByteUtil")

package com.mingliqiye.utils.bytes

import com.mingliqiye.utils.collection.Lists
import com.mingliqiye.utils.stream.SuperStream

const val ESC_ASC: Byte = 0x10
const val ESC_DESC: Byte = 0x1B
const val ESC_NONE: Byte = 0x00
const val ESC_START: Byte = 0x01
const val ESC_END: Byte = 0x02
const val ESC_ESC: Byte = 0x03
const val ESC_CONTROL: Byte = 0x04
const val ESC_DATA: Byte = 0x05
const val ESC_RESERVED: Byte = 0x06


/**
 * 将字节数组转换为十六进制字符串列表
 *
 * @param bytes 输入的字节数组
 * @return 包含每个字节对应十六进制字符串的列表
 */
fun getByteArrayString(bytes: ByteArray): MutableList<String> {
    return SuperStream.of(Lists.toList(bytes))
        .map { a -> String.format("%02x", a!!.toInt() and 0xFF) }
        .collect(SuperStream.Collectors.toList())
}

