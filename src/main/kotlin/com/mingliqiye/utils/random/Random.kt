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
 * CurrentFile Random.kt
 * LastUpdate 2026-10-20 20:05:37
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.random

import java.security.SecureRandom
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong

/**
 * Random对象 - 提供各种随机数据生成方法
 * 使用SecureRandom确保密码学安全，同时提供便捷的随机数生成接口
 */
object Random {
    /**
     * 安全随机数生成器 - 使用系统强随机算法
     * 通过lazy委托延迟初始化，提高性能
     */
    private val secureRandom: SecureRandom by lazy {
        SecureRandom.getInstanceStrong()
    }

    /**
     * 标准随机数生成器 - Kotlin标准库提供的随机数生成器
     * 通过lazy委托延迟初始化
     */
    private val random: Random by lazy {
        Random.Default
    }

    /**
     * 生成指定长度的随机字节数组
     * @param size 要生成的字节数组长度
     * @return 包含随机字节的ByteArray
     */
    @JvmStatic
    fun nextBytes(size: Int): ByteArray = ByteArray(size).also { secureRandom.nextBytes(it) }

    /**
     * 生成单个随机字节
     * @return 随机字节值（0-255）
     */
    @JvmStatic
    fun nextByte(): Byte = nextInt(0, 256).toByte()

    /**
     * 生成无符号随机字节
     * @return 无符号随机字节值（0-255）
     */
    @JvmStatic
    fun nextUByte(): UByte = nextInt(0, 256).toUByte()

    /**
     * 生成小于指定最大值的随机字节
     * @param max 最大值（包含）
     * @return 在Byte.MIN_VALUE到max范围内的随机字节
     */
    @JvmStatic
    fun nextByte(max: Byte): Byte = nextInt(Byte.MIN_VALUE.toInt(), max.toInt()).toByte()

    /**
     * 生成指定范围内的随机字节
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 在min到max范围内的随机字节
     */
    @JvmStatic
    fun nextByte(min: Byte, max: Byte): Byte = nextInt(min.toInt(), max.toInt() + 1).toByte()

    /**
     * 生成指定范围内的无符号随机字节
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 在min到max范围内的无符号随机字节
     */
    @JvmStatic
    fun nextByte(min: UByte, max: UByte): UByte = nextInt(min.toInt(), max.toInt() + 1).toUByte()

    /**
     * 生成指定IntRange范围内的随机字节
     * @param range 指定的整数范围
     * @return 在范围内转换为字节的随机值
     */
    @JvmStatic
    fun nextByte(range: IntRange): Byte = nextByte(range.first.toByte(), range.last.toByte())

    /**
     * 生成指定UIntRange范围内的无符号随机字节
     * @param range 指定的无符号整数范围
     * @return 在范围内转换为无符号字节的随机值
     */
    @JvmStatic
    fun nextByte(range: UIntRange): UByte = nextByte(range.first.toUByte(), range.last.toUByte())

    /**
     * 生成随机整数
     * @return 随机整数值
     */
    @JvmStatic
    fun nextInt(): Int = secureRandom.nextInt()

    /**
     * 生成小于指定最大值的随机整数
     * @param max 最大值（不包含）
     * @return 0到max-1范围内的随机整数
     */
    @JvmStatic
    fun nextInt(max: Int): Int = secureRandom.nextInt(max)

    /**
     * 生成指定范围内的随机整数
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 在min到max范围内的随机整数
     */
    @JvmStatic
    fun nextInt(min: Int, max: Int): Int = random.nextInt(min..max)

    /**
     * 生成指定IntRange范围内的随机整数
     * @param range 指定的整数范围
     * @return 在范围内的随机整数
     */
    @JvmStatic
    fun nextInt(range: IntRange): Int = random.nextInt(range)

    /**
     * 生成随机短整数
     * @return 在Short范围内的随机短整数
     */
    @JvmStatic
    fun nextShort(): Short = secureRandom.nextInt(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()

    /**
     * 生成小于指定最大值的随机短整数
     * @param max 最大值（包含）
     * @return 在Short.MIN_VALUE到max范围内的随机短整数
     */
    @JvmStatic
    fun nextShort(max: Short): Short = secureRandom.nextInt(Short.MIN_VALUE.toInt(), max.toInt()).toShort()

    /**
     * 生成指定范围内的随机短整数
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 在min到max范围内的随机短整数
     */
    @JvmStatic
    fun nextShort(min: Short, max: Short): Short = secureRandom.nextInt(min.toInt(), max.toInt()).toShort()

    /**
     * 生成指定IntRange范围内的随机短整数
     * @param range 指定的整数范围
     * @return 在范围内转换为短整数的随机值
     */
    @JvmStatic
    fun nextShort(range: IntRange): Short = secureRandom.nextInt(range.first, range.last).toShort()

    /**
     * 生成随机长整数
     * @return 随机长整数值
     */
    @JvmStatic
    fun nextLong(): Long = secureRandom.nextLong()

    /**
     * 生成小于指定最大值的随机长整数
     * @param max 最大值（不包含）
     * @return 0到max-1范围内的随机长整数
     */
    @JvmStatic
    fun nextLong(max: Long): Long = secureRandom.nextLong(max)

    /**
     * 生成指定范围内的随机长整数
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 在min到max范围内的随机长整数
     */
    @JvmStatic
    fun nextLong(min: Long, max: Long): Long = random.nextLong(min..max)

    /**
     * 生成指定LongRange范围内的随机长整数
     * @param range 指定的长整数范围
     * @return 在范围内的随机长整数
     */
    @JvmStatic
    fun nextLong(range: LongRange): Long = random.nextLong(range)

    /**
     * 生成随机布尔值
     * @return 随机true或false
     */
    @JvmStatic
    fun nextBoolean(): Boolean = secureRandom.nextBoolean()

    /**
     * String类型的扩展函数 - 从字符串中随机选择字符生成指定长度的新字符串
     * @param length 要生成的字符串长度
     * @return 由原字符串中随机字符组成的新字符串
     */
    @JvmStatic
    fun String.randomString(length: Int): String = String(CharArray(length) {
        this[nextInt(indices)]
    })

    /**
     * 生成包含数字和字母的随机字符串
     * @param length 要生成的字符串长度
     * @return 包含0-9、a-z、A-Z字符的随机字符串
     */
    @JvmStatic
    fun randomString(length: Int): String =
        "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".randomString(length)

    /**
     * Array类型的扩展函数 - 从数组中随机选择一个元素
     * @param T 数组元素类型
     * @return 数组中的随机元素
     */
    @JvmStatic
    fun <T> Array<T>.randomItem(): T = this[nextInt(indices)]

    /**
     * ByteArray类型的扩展函数 - 从字节数组中随机选择一个元素
     * @return 字节数组中的随机字节
     */
    @JvmStatic
    fun ByteArray.randomItem(): Byte = this[nextInt(indices)]

    /**
     * IntArray类型的扩展函数 - 从整数数组中随机选择一个元素
     * @return 整数数组中的随机整数
     */
    @JvmStatic
    fun IntArray.randomItem(): Int = this[nextInt(indices)]

    /**
     * LongArray类型的扩展函数 - 从长整数数组中随机选择一个元素
     * @return 长整数数组中的随机长整数
     */
    @JvmStatic
    fun LongArray.randomItem(): Long = this[nextInt(indices)]

    /**
     * FloatArray类型的扩展函数 - 从浮点数数组中随机选择一个元素
     * @return 浮点数数组中的随机浮点数
     */
    @JvmStatic
    fun FloatArray.randomItem(): Float = this[nextInt(indices)]

    /**
     * DoubleArray类型的扩展函数 - 从双精度浮点数数组中随机选择一个元素
     * @return 双精度浮点数数组中的随机双精度浮点数
     */
    @JvmStatic
    fun DoubleArray.randomItem(): Double = this[nextInt(indices)]

    /**
     * BooleanArray类型的扩展函数 - 从布尔数组中随机选择一个元素
     * @return 布尔数组中的随机布尔值
     */
    @JvmStatic
    fun BooleanArray.randomItem(): Boolean = this[nextInt(indices)]

    /**
     * CharArray类型的扩展函数 - 从字符数组中随机选择一个元素
     * @return 字符数组中的随机字符
     */
    @JvmStatic
    fun CharArray.randomItem(): Char = this[nextInt(indices)]

    /**
     * ShortArray类型的扩展函数 - 从短整数数组中随机选择一个元素
     * @return 短整数数组中的随机短整数
     */
    @JvmStatic
    fun ShortArray.randomItem(): Short = this[nextInt(indices)]

    /**
     * Collection类型的扩展函数 - 从集合中随机选择一个元素
     * @param T 集合元素类型
     * @return 集合中的随机元素
     */
    @JvmStatic
    fun <T> Collection<T>.randomItem(): T = this.elementAt(nextInt(indices))
}
