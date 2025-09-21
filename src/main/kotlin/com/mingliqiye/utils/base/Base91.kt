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
 * CurrentFile Base91.kt
 * LastUpdate 2025-09-19 20:08:46
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

/**
 * Base91 编解码工具类，用于将字节数组编码为 Base91 字符串，或将 Base91 字符串解码为原始字节数组。
 *
 * Base91 是一种高效的二进制到文本的编码方式，相较于 Base64，它使用更少的字符来表示相同的数据。
 */
class Base91 : BaseCodec {

    companion object {
        /**
         * Base91 编码表，共 91 个可打印 ASCII 字符。
         */
        val ENCODING_TABLE: CharArray = charArrayOf(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '#', '$',
            '%', '&', '(', ')', '*', '+', ',', '.', '/', ':', ';', '<', '=',
            '>', '?', '@', '[', ']', '^', '_', '`', '{', '|', '}', '~', '"'
        )

        /**
         * Base91 解码表，大小为 256，用于快速查找字符对应的数值。
         * 初始化时将所有元素设为 -1，表示无效字符；然后根据 ENCODING_TABLE 填充有效字符的索引。
         */
        val DECODING_TABLE: Array<Int> = arrayOf(
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            62,
            90,
            63,
            64,
            65,
            66,
            -1,
            67,
            68,
            69,
            70,
            71,
            -1,
            72,
            73,
            52,
            53,
            54,
            55,
            56,
            57,
            58,
            59,
            60,
            61,
            74,
            75,
            76,
            77,
            78,
            79,
            80,
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17,
            18,
            19,
            20,
            21,
            22,
            23,
            24,
            25,
            81,
            -1,
            82,
            83,
            84,
            85,
            26,
            27,
            28,
            29,
            30,
            31,
            32,
            33,
            34,
            35,
            36,
            37,
            38,
            39,
            40,
            41,
            42,
            43,
            44,
            45,
            46,
            47,
            48,
            49,
            50,
            51,
            86,
            87,
            88,
            89,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1,
            -1
        )
    }

    /**
     * 将字节数组编码为 Base91 字符串。
     *
     * @param bytes 待编码的字节数组
     * @return 编码后的 Base91 字符串
     */
    override fun encode(bytes: ByteArray): String {
        if (bytes.isEmpty()) return ""
        val sb = StringBuilder()
        var ebq = 0       // 编码缓冲区，用于暂存待处理的位数据
        var en = 0        // 当前缓冲区中的有效位数

        for (b in bytes) {
            // 将当前字节加入缓冲区
            ebq = ebq or ((b.toInt() and 0xFF) shl en)
            en += 8

            // 每当缓冲区中有超过 13 位的数据时，尝试进行编码
            if (en > 13) {
                var ev = ebq and 0x1FFF  // 取出低 13 位作为候选值
                if (ev > 88) {
                    // 如果候选值大于 88，则使用 13 位编码
                    ebq = ebq shr 13
                    en -= 13
                } else {
                    // 否则使用 14 位编码
                    ev = ebq and 0x3FFF
                    ebq = ebq shr 14
                    en -= 14
                }
                // 将两个字符追加到结果中
                sb.append(ENCODING_TABLE[ev % 91])
                sb.append(ENCODING_TABLE[ev / 91])
            }
        }

        // 处理剩余未编码的数据
        if (en > 0) {
            sb.append(ENCODING_TABLE[ebq % 91])
            if (en > 7 || ebq > 90) {
                sb.append(ENCODING_TABLE[ebq / 91])
            }
        }

        return sb.toString()
    }

    /**
     * 将 Base91 字符串解码为原始字节数组。
     *
     * @param string 待解码的 Base91 字符串
     * @return 解码后的字节数组
     */
    override fun decode(string: String): ByteArray {
        if (string.isEmpty()) return ByteArray(0)
        var dbq = 0       // 解码缓冲区，用于暂存待处理的位数据
        var dn = 0        // 当前缓冲区中的有效位数
        var dv = -1       // 当前读取到的 Base91 值
        val buffer = ByteArray(string.length * 13 / 8)  // 预分配输出缓冲区
        var index = 0     // 输出缓冲区写入位置

        for (c in string.toCharArray()) {
            // 忽略不在编码表中的字符
            if (DECODING_TABLE[c.code] == -1) continue

            if (dv == -1) {
                // 第一次读取字符，保存为 dv
                dv = DECODING_TABLE[c.code]
            } else {
                // 第二次读取字符，组合成完整的 Base91 值
                dv += DECODING_TABLE[c.code] * 91
                dbq = dbq or (dv shl dn)
                // 根据值大小判断是 13 位还是 14 位编码
                dn += if ((dv and 0x1FFF) > 88) 13 else 14

                // 将缓冲区中完整的字节写入输出数组
                do {
                    buffer[index++] = (dbq and 0xFF).toByte()
                    dbq = dbq shr 8
                    dn -= 8
                } while (dn > 7)

                dv = -1  // 重置 dv，准备下一轮读取
            }
        }

        // 处理最后剩余的一个字符（如果存在）
        if (dv != -1) {
            buffer[index++] = ((dbq or (dv shl dn)) and 0xFF).toByte()
        }

        // 返回实际使用的部分
        return buffer.copyOf(index)
    }
}
