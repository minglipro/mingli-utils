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
 * CurrentFile BaseJsonReader.kt
 * LastUpdate 2026-11-17 20:26:28
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader.base

import com.mingliqiye.utils.json.judgment.base.BaseJsonJudgment
import java.math.BigDecimal
import java.math.BigInteger

/**
 * JSON 读取器基础接口，继承类型判断能力，定义将当前节点读取为各种类型值的方法
 */
interface BaseJsonReader : BaseJsonJudgment {
	/**
	 * 将当前节点作为对象读取器返回
	 *
	 * @return JSON 对象读取器
	 */
	fun getObject(): BaseJsonObjectReader
	/**
	 * 将当前节点作为数组读取器返回
	 *
	 * @return JSON 数组读取器
	 */
	fun getArray(): BaseJsonArrayReader
	/**
	 * 读取当前节点的字符串值
	 *
	 * @return 字符串值
	 */
	fun getString(): String
	/**
	 * 读取当前节点的布尔值
	 *
	 * @return 布尔值
	 */
	fun getBoolean(): Boolean
	/**
	 * 读取当前节点的 Byte 数值
	 *
	 * @return Byte 数值
	 */
	fun getByte(): Byte
	/**
	 * 读取当前节点的 Short 数值
	 *
	 * @return Short 数值
	 */
	fun getShort(): Short
	/**
	 * 读取当前节点的 Int 数值
	 *
	 * @return Int 数值
	 */
	fun getInt(): Int
	/**
	 * 读取当前节点的 Long 数值
	 *
	 * @return Long 数值
	 */
	fun getLong(): Long
	/**
	 * 读取当前节点的 Float 数值
	 *
	 * @return Float 数值
	 */
	fun getFloat(): Float
	/**
	 * 读取当前节点的 Double 数值
	 *
	 * @return Double 数值
	 */
	fun getDouble(): Double
	/**
	 * 读取当前节点的 BigInteger 数值
	 *
	 * @return BigInteger 数值
	 */
	fun getBigInteger(): BigInteger
	/**
	 * 读取当前节点的 BigDecimal 数值
	 *
	 * @return BigDecimal 数值
	 */
	fun getBigDecimal(): BigDecimal

}
