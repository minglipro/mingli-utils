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
 * CurrentFile ByteFlags.kt
 * LastUpdate 2026-01-07 09:37:09
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.bytes

/**
 * 表示一个字节（8 位）的布尔标志集合。
 *
 * 每一位对应一个布尔值，其中：
 * - `b0` 表示最低有效位（LSB，bit 0，值为 0x01）
 * - `b7` 表示最高有效位（MSB，bit 7，值为 0x80）
 *
 * 该类支持从字节、布尔数组、二进制字符串等构造，并提供位操作、状态查询和格式化输出等功能。
 */
data class ByteFlags(
    /** 第 0 位（最低位，0x01） */
    var b0: Boolean = false,
    /** 第 1 位（0x02） */
    var b1: Boolean = false,
    /** 第 2 位（0x04） */
    var b2: Boolean = false,
    /** 第 3 位（0x08） */
    var b3: Boolean = false,
    /** 第 4 位（0x10） */
    var b4: Boolean = false,
    /** 第 5 位（0x20） */
    var b5: Boolean = false,
    /** 第 6 位（0x40） */
    var b6: Boolean = false,
    /** 第 7 位（最高位，0x80） */
    var b7: Boolean = false
) {

    /**
     * 通过一个 [Byte] 值构造 [ByteFlags] 实例。
     *
     * @param byte 用于初始化的字节值（仅使用低 8 位）
     */
    constructor(byte: Byte) : this() {
        fromByte(byte)
    }

    /**
     * 从给定的 [Byte] 值解析并设置各个位标志。
     *
     * @param byte 要解析的字节
     */
    fun fromByte(byte: Byte) {
        val value = byte.toInt() and 0xFF
        b0 = (value and 0x01) != 0
        b1 = (value and 0x02) != 0
        b2 = (value and 0x04) != 0
        b3 = (value and 0x08) != 0
        b4 = (value and 0x10) != 0
        b5 = (value and 0x20) != 0
        b6 = (value and 0x40) != 0
        b7 = (value and 0x80) != 0
    }

    /**
     * 将当前标志状态转换为一个 [Byte] 值。
     *
     * @return 对应的字节值（范围 0x00 ~ 0xFF，以有符号字节形式返回）
     */
    fun toByte(): Byte {
        var result = 0
        if (b0) result = result or 0x01
        if (b1) result = result or 0x02
        if (b2) result = result or 0x04
        if (b3) result = result or 0x08
        if (b4) result = result or 0x10
        if (b5) result = result or 0x20
        if (b6) result = result or 0x40
        if (b7) result = result or 0x80
        return result.toByte()
    }

    /**
     * 通过索引（0~7）获取对应位的布尔值。
     *
     * @param index 位索引（0 = LSB, 7 = MSB）
     * @return 该位是否为 true
     * @throws IndexOutOfBoundsException 如果索引不在 0~7 范围内
     */
    operator fun get(index: Int): Boolean {
        return when (index) {
            0 -> b0
            1 -> b1
            2 -> b2
            3 -> b3
            4 -> b4
            5 -> b5
            6 -> b6
            7 -> b7
            else -> throw IndexOutOfBoundsException("索引必须在0-7之间")
        }
    }

    /**
     * 通过索引（0~7）设置对应位的布尔值。
     *
     * @param index 位索引（0 = LSB, 7 = MSB）
     * @param value 要设置的布尔值
     * @throws IndexOutOfBoundsException 如果索引不在 0~7 范围内
     */
    operator fun set(index: Int, value: Boolean) {
        when (index) {
            0 -> b0 = value
            1 -> b1 = value
            2 -> b2 = value
            3 -> b3 = value
            4 -> b4 = value
            5 -> b5 = value
            6 -> b6 = value
            7 -> b7 = value
            else -> throw IndexOutOfBoundsException("索引必须在0-7之间")
        }
    }

    /**
     * 将所有 8 个位设置为 `true`。
     */
    fun setAll() {
        b0 = true
        b1 = true
        b2 = true
        b3 = true
        b4 = true
        b5 = true
        b6 = true
        b7 = true
    }

    /**
     * 将所有 8 个位设置为 `false`。
     */
    fun clearAll() {
        b0 = false
        b1 = false
        b2 = false
        b3 = false
        b4 = false
        b5 = false
        b6 = false
        b7 = false
    }

    /**
     * 对所有位执行逻辑取反（true ↔ false）。
     */
    fun toggleAll() {
        b0 = !b0
        b1 = !b1
        b2 = !b2
        b3 = !b3
        b4 = !b4
        b5 = !b5
        b6 = !b6
        b7 = !b7
    }

    /**
     * 切换指定索引位的状态（true 变 false，反之亦然）。
     *
     * @param index 要切换的位索引（0~7）
     * @throws IndexOutOfBoundsException 如果索引无效
     */
    fun toggle(index: Int) {
        this[index] = !this[index]
    }

    /**
     * 检查是否所有位都为 `true`。
     *
     * @return 若全部为 true 则返回 true，否则 false
     */
    fun allTrue(): Boolean {
        return b0 && b1 && b2 && b3 && b4 && b5 && b6 && b7
    }

    /**
     * 检查是否所有位都为 `false`。
     *
     * @return 若全部为 false 则返回 true，否则 false
     */
    fun allFalse(): Boolean {
        return !b0 && !b1 && !b2 && !b3 && !b4 && !b5 && !b6 && !b7
    }

    /**
     * 统计值为 `true` 的位数量。
     *
     * @return true 位的个数（0~8）
     */
    fun countTrue(): Int {
        var count = 0
        if (b0) count++
        if (b1) count++
        if (b2) count++
        if (b3) count++
        if (b4) count++
        if (b5) count++
        if (b6) count++
        if (b7) count++
        return count
    }

    /**
     * 统计值为 `false` 的位数量。
     *
     * @return false 位的个数（0~8）
     */
    fun countFalse(): Int = 8 - countTrue()

    /**
     * 通过位名称（如 "b0"、"bit3" 等）获取对应位的值。
     *
     * 支持别名：`bN` 或 `bitN`（不区分大小写）。
     *
     * @param name 位的名称（例如 "b0", "BIT5"）
     * @return 对应位的布尔值
     * @throws IllegalArgumentException 如果名称无效
     */
    fun getByName(name: String): Boolean {
        return when (name.lowercase()) {
            "b0", "bit0" -> b0
            "b1", "bit1" -> b1
            "b2", "bit2" -> b2
            "b3", "bit3" -> b3
            "b4", "bit4" -> b4
            "b5", "bit5" -> b5
            "b6", "bit6" -> b6
            "b7", "bit7" -> b7
            else -> throw IllegalArgumentException("未知的位名称: $name")
        }
    }

    /**
     * 将当前状态转换为标准二进制字符串（MSB 在前）。
     *
     * 例如：若 b7=true, b6=false, ..., b0=true，则返回 "10000001"
     *
     * @return 8 位二进制字符串（高位在左）
     */
    fun toBinaryString(): String {
        return buildString {
            if (b7) append('1') else append('0')
            if (b6) append('1') else append('0')
            if (b5) append('1') else append('0')
            if (b4) append('1') else append('0')
            if (b3) append('1') else append('0')
            if (b2) append('1') else append('0')
            if (b1) append('1') else append('0')
            if (b0) append('1') else append('0')
        }
    }

    /**
     * 将当前状态转换为十六进制字符串（带 0x 前缀，大写，两位）。
     *
     * 例如：若值为 10，则返回 "0x0A"
     *
     * @return 格式如 "0xXX" 的十六进制字符串
     */
    fun toHexString(): String {
        return "0x" + (toByte().toInt() and 0xFF).toString(16).padStart(2, '0').uppercase()
    }

    /**
     * 将当前位状态转换为布尔数组。
     *
     * 数组顺序为 [b0, b1, b2, ..., b7]（LSB 在前）。
     *
     * @return 长度为 8 的布尔数组
     */
    fun toBooleanArray(): BooleanArray {
        return booleanArrayOf(b0, b1, b2, b3, b4, b5, b6, b7)
    }

    /**
     * 从布尔数组初始化位状态。
     *
     * 使用数组的前 8 个元素（索引 0~7），分别对应 b0~b7。
     *
     * @param array 布尔数组（长度至少为 8）
     * @throws IllegalArgumentException 如果数组长度不足 8
     */
    fun fromBooleanArray(array: BooleanArray) {
        require(array.size >= 8) { "数组长度至少为8" }
        b0 = array[0]
        b1 = array[1]
        b2 = array[2]
        b3 = array[3]
        b4 = array[4]
        b5 = array[5]
        b6 = array[6]
        b7 = array[7]
    }

    /**
     * 对两个 [ByteFlags] 执行按位“与”操作（AND）。
     *
     * 结果的每一位 = this位 && other位
     *
     * @param other 另一个 ByteFlags 实例
     * @return 新的 ByteFlags 实例，表示 AND 结果
     */
    infix fun and(other: ByteFlags): ByteFlags {
        return ByteFlags(
            this.b0 && other.b0,
            this.b1 && other.b1,
            this.b2 && other.b2,
            this.b3 && other.b3,
            this.b4 && other.b4,
            this.b5 && other.b5,
            this.b6 && other.b6,
            this.b7 && other.b7
        )
    }

    /**
     * 对两个 [ByteFlags] 执行按位“或”操作（OR）。
     *
     * 结果的每一位 = this位 || other位
     *
     * @param other 另一个 ByteFlags 实例
     * @return 新的 ByteFlags 实例，表示 OR 结果
     */
    infix fun or(other: ByteFlags): ByteFlags {
        return ByteFlags(
            this.b0 || other.b0,
            this.b1 || other.b1,
            this.b2 || other.b2,
            this.b3 || other.b3,
            this.b4 || other.b4,
            this.b5 || other.b5,
            this.b6 || other.b6,
            this.b7 || other.b7
        )
    }

    /**
     * 对两个 [ByteFlags] 执行按位“异或”操作（XOR）。
     *
     * 结果的每一位 = this位 != other位
     *
     * @param other 另一个 ByteFlags 实例
     * @return 新的 ByteFlags 实例，表示 XOR 结果
     */
    infix fun xor(other: ByteFlags): ByteFlags {
        return ByteFlags(
            this.b0 != other.b0,
            this.b1 != other.b1,
            this.b2 != other.b2,
            this.b3 != other.b3,
            this.b4 != other.b4,
            this.b5 != other.b5,
            this.b6 != other.b6,
            this.b7 != other.b7
        )
    }

    /**
     * 对当前 [ByteFlags] 执行按位“非”操作（NOT）。
     *
     * 每一位取反。
     *
     * @return 新的 ByteFlags 实例，所有位取反
     */
    operator fun not(): ByteFlags {
        return ByteFlags(
            !b0, !b1, !b2, !b3, !b4, !b5, !b6, !b7
        )
    }

    /**
     * 返回可读的字符串表示，包含二进制和十六进制形式。
     *
     * 示例：`ByteFlags(10100001 = 0xA1)`
     *
     * @return 字符串描述
     */
    override fun toString(): String {
        return "ByteFlags(${toBinaryString()} = ${toHexString()})"
    }

    companion object {
        /**
         * 创建一个所有位均为 `true` 的 [ByteFlags] 实例。
         *
         * @return 全 1 的 ByteFlags（值为 0xFF）
         */
        fun allTrue(): ByteFlags {
            return ByteFlags(true, true, true, true, true, true, true, true)
        }

        /**
         * 创建一个所有位均为 `false` 的 [ByteFlags] 实例。
         *
         * @return 全 0 的 ByteFlags（值为 0x00）
         */
        fun allFalse(): ByteFlags {
            return ByteFlags()
        }

        /**
         * 从 8 位二进制字符串创建 [ByteFlags] 实例。
         *
         * 字符串格式：高位在前（MSB first），如 "10000001" 表示 b7=1, b0=1。
         *
         * @param binary 8 位二进制字符串（仅含 '0' 和 '1'）
         * @return 对应的 ByteFlags 实例
         * @throws IllegalArgumentException 如果字符串长度不是 8 或包含非法字符
         */
        fun fromBinaryString(binary: String): ByteFlags {
            require(binary.length == 8) { "二进制字符串长度必须为8" }
            require(binary.all { it == '0' || it == '1' }) { "二进制字符串只能包含0和1" }

            return ByteFlags(
                binary[7] == '1',  // b0 是最低位（对应字符串最后一位）
                binary[6] == '1',
                binary[5] == '1',
                binary[4] == '1',
                binary[3] == '1',
                binary[2] == '1',
                binary[1] == '1',
                binary[0] == '1'   // b7 是最高位（对应字符串第一位）
            )
        }

        /**
         * 从整数创建 [ByteFlags] 实例（仅使用低 8 位）。
         *
         * @param value 输入整数
         * @return 对应的 ByteFlags 实例
         */
        fun fromInt(value: Int): ByteFlags {
            return ByteFlags((value and 0xFF).toByte())
        }
    }
}
