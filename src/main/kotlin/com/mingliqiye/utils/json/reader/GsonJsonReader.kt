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
 * CurrentFile GsonJsonReader.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader

import com.google.gson.JsonElement
import com.mingliqiye.utils.exception.JsonParserException
import com.mingliqiye.utils.json.judgment.GsonReaderJudgment
import com.mingliqiye.utils.json.reader.base.BaseJsonArrayReader
import com.mingliqiye.utils.json.reader.base.BaseJsonObjectReader
import com.mingliqiye.utils.json.reader.base.BaseJsonReader
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 基于 Gson [JsonElement] 的 JSON 读取器实现，将节点值读取为各种类型。
 *
 * @param element 待读取的 Gson 节点
 */
class GsonJsonReader(
	private val element: JsonElement,
) : BaseJsonReader, GsonReaderJudgment(element) {

	/**
	 * 将当前节点作为对象读取器返回。
	 *
	 * @return 对象读取器
	 * @throws JsonParserException 当前节点不是对象时抛出
	 */
	override fun getObject(): BaseJsonObjectReader {
		if (!element.isJsonObject) {
			throw JsonParserException("current element is not a JSON object")
		}
		return GsonJsonObjectReader(element.asJsonObject)
	}

	/**
	 * 将当前节点作为数组读取器返回。
	 *
	 * @return 数组读取器
	 * @throws JsonParserException 当前节点不是数组时抛出
	 */
	override fun getArray(): BaseJsonArrayReader {
		if (!element.isJsonArray) {
			throw JsonParserException("current element is not a JSON array")
		}
		return GsonJsonArrayReader(element.asJsonArray)
	}

	/**
	 * 读取当前节点的字符串值。
	 *
	 * @return 字符串值
	 */
	override fun getString(): String = element.asString

	/**
	 * 读取当前节点的布尔值。
	 *
	 * @return 布尔值
	 */
	override fun getBoolean(): Boolean = element.asBoolean

	/**
	 * 读取当前节点的 Byte 值。
	 *
	 * @return Byte 值
	 */
	override fun getByte(): Byte = element.asByte

	/**
	 * 读取当前节点的 Short 值。
	 *
	 * @return Short 值
	 */
	override fun getShort(): Short = element.asShort

	/**
	 * 读取当前节点的 Int 值。
	 *
	 * @return Int 值
	 */
	override fun getInt(): Int = element.asInt

	/**
	 * 读取当前节点的 Long 值。
	 *
	 * @return Long 值
	 */
	override fun getLong(): Long = element.asLong

	/**
	 * 读取当前节点的 Float 值。
	 *
	 * @return Float 值
	 */
	override fun getFloat(): Float = element.asFloat

	/**
	 * 读取当前节点的 Double 值。
	 *
	 * @return Double 值
	 */
	override fun getDouble(): Double = element.asDouble

	/**
	 * 读取当前节点的 BigInteger 值。
	 *
	 * @return BigInteger 值
	 */
	override fun getBigInteger(): BigInteger = element.asBigInteger

	/**
	 * 读取当前节点的 BigDecimal 值。
	 *
	 * @return BigDecimal 值
	 */
	override fun getBigDecimal(): BigDecimal = element.asBigDecimal
}
