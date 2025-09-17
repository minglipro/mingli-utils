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
 * CurrentFile Base16.kt
 * LastUpdate 2025-09-17 10:56:07
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

/**
 * Base16编解码器实现类
 * 提供字节数组与十六进制字符串之间的相互转换功能
 */
class Base16 : BaseCodec {
    /**
     * 将字节数组编码为十六进制字符串
     * @param bytes 待编码的字节数组
     * @return 编码后的十六进制字符串，每个字节对应两位十六进制字符
     */
    override fun encode(bytes: ByteArray): String {
        // 将每个字节转换为两位十六进制字符串并拼接
        return bytes.joinToString("") {
            it.toInt().and(0xff).toString(16).padStart(2, '0')
        }
    }

    /**
     * 将十六进制字符串解码为字节数组
     * @param string 待解码的十六进制字符串
     * @return 解码后的字节数组
     */
    override fun decode(string: String): ByteArray {
        // 按每两个字符分组，转换为字节
        return string.chunked(2).map {
            it.toInt(16).toByte()
        }.toByteArray()
    }

}
