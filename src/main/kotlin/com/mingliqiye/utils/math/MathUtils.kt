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
 * CurrentFile MathUtils.kt
 * LastUpdate 2026-02-05 10:25:32
 * UpdateUser MingLiPro
 */
@file:JvmName("MathUtils")

package com.mingliqiye.utils.math

import java.math.BigDecimal
import java.math.BigInteger

/**
 * BigDecimal减法运算符重载 - BigDecimal类型
 * @param value 被减数
 * @return 减法运算结果
 */
operator fun BigDecimal.minus(value: BigDecimal): BigDecimal = this.subtract(value)

/**
 * BigDecimal减法运算符重载 - Long类型
 * @param value 被减数
 * @return 减法运算结果
 */
operator fun BigDecimal.minus(value: Long): BigDecimal = this.subtract(BigDecimal(value))


/**
 * BigDecimal减法运算符重载 - Int类型
 * @param value 被减数
 * @return 减法运算结果
 */
operator fun BigDecimal.minus(value: Int): BigDecimal = this.subtract(BigDecimal(value))

/**
 * BigDecimal减法运算符重载 - Double类型
 * @param value 被减数
 * @return 减法运算结果
 */
operator fun BigDecimal.minus(value: Double): BigDecimal = this.subtract(BigDecimal(value.toString()))

/**
 * BigDecimal减法运算符重载 - Float类型
 * @param value 被减数
 * @return 减法运算结果
 */
operator fun BigDecimal.minus(value: Float): BigDecimal = this.subtract(BigDecimal(value.toString()))

/**
 * BigDecimal减法运算符重载 - BigInteger类型
 * @param value 被减数
 * @return 减法运算结果
 */
operator fun BigDecimal.minus(value: BigInteger): BigDecimal = this.subtract(BigDecimal(value))

/**
 * BigDecimal加法运算符重载 - BigDecimal类型
 * @param value 加数
 * @return 加法运算结果
 */
operator fun BigDecimal.plus(value: BigDecimal): BigDecimal = this.add(value)

/**
 * BigDecimal加法运算符重载 - Long类型
 * @param value 加数
 * @return 加法运算结果
 */
operator fun BigDecimal.plus(value: Long): BigDecimal = this.add(BigDecimal(value))

/**
 * BigDecimal加法运算符重载 - Int类型
 * @param value 加数
 * @return 加法运算结果
 */
operator fun BigDecimal.plus(value: Int): BigDecimal = this.add(BigDecimal(value))

/**
 * BigDecimal加法运算符重载 - Double类型
 * @param value 加数
 * @return 加法运算结果
 */
operator fun BigDecimal.plus(value: Double): BigDecimal = this.add(BigDecimal(value.toString()))

/**
 * BigDecimal加法运算符重载 - Float类型
 * @param value 加数
 * @return 加法运算结果
 */
operator fun BigDecimal.plus(value: Float): BigDecimal = this.add(BigDecimal(value.toString()))

/**
 * BigDecimal加法运算符重载 - BigInteger类型
 * @param value 加数
 * @return 加法运算结果
 */
operator fun BigDecimal.plus(value: BigInteger): BigDecimal = this.add(BigDecimal(value))

/**
 * BigDecimal乘法运算符重载 - BigDecimal类型
 * @param value 乘数
 * @return 乘法运算结果
 */
operator fun BigDecimal.times(value: BigDecimal): BigDecimal = this.multiply(value)

/**
 * BigDecimal乘法运算符重载 - Long类型
 * @param value 乘数
 * @return 乘法运算结果
 */
operator fun BigDecimal.times(value: Long): BigDecimal = this.multiply(BigDecimal(value))


/**
 * BigDecimal乘法运算符重载 - Int类型
 * @param value 乘数
 * @return 乘法运算结果
 */
operator fun BigDecimal.times(value: Int): BigDecimal = this.multiply(BigDecimal(value))

/**
 * BigDecimal乘法运算符重载 - Double类型
 * @param value 乘数
 * @return 乘法运算结果
 */
operator fun BigDecimal.times(value: Double): BigDecimal = this.multiply(BigDecimal(value.toString()))

/**
 * BigDecimal乘法运算符重载 - Float类型
 * @param value 乘数
 * @return 乘法运算结果
 */
operator fun BigDecimal.times(value: Float): BigDecimal = this.multiply(BigDecimal(value.toString()))

/**
 * BigDecimal乘法运算符重载 - BigInteger类型
 * @param value 乘数
 * @return 乘法运算结果
 */
operator fun BigDecimal.times(value: BigInteger): BigDecimal = this.multiply(BigDecimal(value))

/**
 * BigDecimal除法运算符重载 - BigDecimal类型
 * @param value 除数
 * @return 除法运算结果
 */
operator fun BigDecimal.div(value: BigDecimal): BigDecimal = this.divide(value)

/**
 * BigDecimal除法运算符重载 - Long类型
 * @param value 除数
 * @return 除法运算结果
 */
operator fun BigDecimal.div(
    value: Long
): BigDecimal = this.divide(BigDecimal(value))

/**
 * BigDecimal除法运算符重载 - Int类型
 * @param value 除数
 * @return 除法运算结果
 */
operator fun BigDecimal.div(
    value: Int
): BigDecimal = this.divide(BigDecimal(value))

/**
 * BigDecimal除法运算符重载 - Double类型
 * @param value 除数
 * @return 除法运算结果
 */
operator fun BigDecimal.div(
    value: Double
): BigDecimal = this.divide(BigDecimal(value.toString()))

/**
 * BigDecimal除法运算符重载 - Float类型
 * @param value 除数
 * @return 除法运算结果
 */
operator fun BigDecimal.div(
    value: Float
): BigDecimal = this.divide(BigDecimal(value.toString()))

/**
 * BigDecimal除法运算符重载 - BigInteger类型
 * @param value 除数
 * @return 除法运算结果
 */
operator fun BigDecimal.div(
    value: BigInteger
): BigDecimal = this.divide(BigDecimal(value))

/**
 * BigDecimal取余运算符重载 - BigDecimal类型
 * @param value 除数
 * @return 取余运算结果
 */
operator fun BigDecimal.rem(value: BigDecimal): BigDecimal = this.remainder(value)

/**
 * BigDecimal取余运算符重载 - Long类型
 * @param value 除数
 * @return 取余运算结果
 */
operator fun BigDecimal.rem(value: Long): BigDecimal = this.remainder(BigDecimal(value))

/**
 * BigDecimal取余运算符重载 - Int类型
 * @param value 除数
 * @return 取余运算结果
 */
operator fun BigDecimal.rem(value: Int): BigDecimal = this.remainder(BigDecimal(value))

/**
 * BigDecimal取余运算符重载 - Double类型
 * @param value 除数
 * @return 取余运算结果
 */
operator fun BigDecimal.rem(value: Double): BigDecimal = this.remainder(BigDecimal(value.toString()))

/**
 * BigDecimal取余运算符重载 - Float类型
 * @param value 除数
 * @return 取余运算结果
 */
operator fun BigDecimal.rem(value: Float): BigDecimal = this.remainder(BigDecimal(value.toString()))

/**
 * BigDecimal取余运算符重载 - BigInteger类型
 * @param value 除数
 * @return 取余运算结果
 */
operator fun BigDecimal.rem(value: BigInteger): BigDecimal = this.remainder(BigDecimal(value))

/**
 * 将BigDecimal转换为去除末尾零的字符串表示
 * @return 去除末尾零后的字符串表示
 */
fun BigDecimal.toFlexString(): String = this.stripTrailingZeros().toPlainString()

/**
 * 字符串转BigDecimal扩展函数
 * @return 转换后的BigDecimal对象
 */
fun String.toBigDecimal(): BigDecimal = BigDecimal(this)

/**
 * Int转BigDecimal扩展函数
 * @return 转换后的BigDecimal对象
 */
fun Int.toBigDecimal(): BigDecimal = BigDecimal(this)

/**
 * Byte转BigDecimal扩展函数
 * @return 转换后的BigDecimal对象
 */
fun Byte.toBigDecimal(): BigDecimal = BigDecimal(this.toInt())

/**
 * Short转BigDecimal扩展函数
 * @return 转换后的BigDecimal对象
 */
fun Short.toBigDecimal(): BigDecimal = BigDecimal(this.toInt())

/**
 * Float转BigDecimal扩展函数
 * @return 转换后的BigDecimal对象
 */
fun Float.toBigDecimal(): BigDecimal = BigDecimal(this.toString())

/**
 * Double转BigDecimal扩展函数
 * @return 转换后的BigDecimal对象
 */
fun Double.toBigDecimal(): BigDecimal = BigDecimal(this.toString())

/**
 * Long转BigDecimal扩展函数
 * @return 转换后的BigDecimal对象
 */
fun Long.toBigDecimal(): BigDecimal = BigDecimal(this)

/**
 * BigInteger转BigDecimal扩展函数
 * @return 转换后的BigDecimal对象
 */
fun BigInteger.toBigDecimal(): BigDecimal = BigDecimal(this)

/**
 * 带精度设置的字符串转BigDecimal扩展函数
 * @param scale 小数位数
 * @return 转换后并设置精度的BigDecimal对象
 */
fun String.toBigDecimal(scale: Int): BigDecimal = BigDecimal(this).setScale(scale)

/**
 * 带精度设置的Int转BigDecimal扩展函数
 * @param scale 小数位数
 * @return 转换后并设置精度的BigDecimal对象
 */
fun Int.toBigDecimal(scale: Int): BigDecimal = BigDecimal(this).setScale(scale)

/**
 * 带精度设置的Byte转BigDecimal扩展函数
 * @param scale 小数位数
 * @return 转换后并设置精度的BigDecimal对象
 */
fun Byte.toBigDecimal(scale: Int): BigDecimal = BigDecimal(this.toInt()).setScale(scale)

/**
 * 带精度设置的Short转BigDecimal扩展函数
 * @param scale 小数位数
 * @return 转换后并设置精度的BigDecimal对象
 */
fun Short.toBigDecimal(scale: Int): BigDecimal = BigDecimal(this.toInt()).setScale(scale)

/**
 * 带精度设置的Float转BigDecimal扩展函数
 * @param scale 小数位数
 * @return 转换后并设置精度的BigDecimal对象
 */
fun Float.toBigDecimal(scale: Int): BigDecimal = BigDecimal(this.toString()).setScale(scale)

/**
 * 带精度设置的Double转BigDecimal扩展函数
 * @param scale 小数位数
 * @return 转换后并设置精度的BigDecimal对象
 */
fun Double.toBigDecimal(scale: Int): BigDecimal = BigDecimal(this.toString()).setScale(scale)

/**
 * 带精度设置的Long转BigDecimal扩展函数
 * @param scale 小数位数
 * @return 转换后并设置精度的BigDecimal对象
 */
fun Long.toBigDecimal(scale: Int): BigDecimal = BigDecimal(this).setScale(scale)

/**
 * 将当前 Number 对象转换为 BigDecimal 类型。
 *
 * @return 返回与当前 Number 对象等值的 BigDecimal 实例。
 */
fun Number.toBigDecimal(): BigDecimal = BigDecimal(this.toString())

/**
 * 将当前 Number 对象转换为 BigInteger 类型。
 *
 * @return 返回与当前 Number 对象等值的 BigInteger 实例。
 */
fun Number.toBigInteger(): BigInteger = BigInteger(this.toString())

/**
 * 将当前 Number 对象转换为指定精度的 BigDecimal 类型。
 *
 * @param scale 指定小数点后的位数（精度）。
 * @return 返回与当前 Number 对象等值且具有指定精度的 BigDecimal 实例。
 */
fun Number.toBigDecimal(scale: Int): BigDecimal = BigDecimal(this.toString()).setScale(scale)
