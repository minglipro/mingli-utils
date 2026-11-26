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
 * CurrentFile GsonJsonObjectReader.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mingliqiye.utils.exception.JsonParserException
import com.mingliqiye.utils.json.judgment.GsonReaderJudgment
import com.mingliqiye.utils.json.reader.base.BaseJsonArrayReader
import com.mingliqiye.utils.json.reader.base.BaseJsonObjectReader
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 基于 Gson [JsonObject] 的 JSON 对象读取器实现，按字段名读取各类型值。
 *
 * @param element 待读取的 Gson 对象节点
 */
class GsonJsonObjectReader(
	private val element: JsonObject,
) : BaseJsonObjectReader, GsonReaderJudgment(element) {

	/**
	 * 读取指定字段；字段不存在时抛出异常。
	 *
	 * @param key 字段名
	 * @return 字段节点
	 * @throws JsonParserException 字段不存在时抛出
	 */
	private fun field(key: String): JsonElement {
		return element.get(key) ?: throw JsonParserException("field not found: $key")
	}

	/**
	 * 读取指定字段并要求它是对象。
	 */
	private fun objectField(key: String): JsonObject {
		val value = field(key)
		if (!value.isJsonObject) {
			throw JsonParserException("field $key is not a JSON object")
		}
		return value.asJsonObject
	}

	/**
	 * 读取指定字段并要求它是数组。
	 */
	private fun arrayField(key: String): com.google.gson.JsonArray {
		val value = field(key)
		if (!value.isJsonArray) {
			throw JsonParserException("field $key is not a JSON array")
		}
		return value.asJsonArray
	}

	override fun getFieldObject(key: String): BaseJsonObjectReader = GsonJsonObjectReader(objectField(key))

	override fun getFieldArray(key: String): BaseJsonArrayReader = GsonJsonArrayReader(arrayField(key))

	override fun getFieldString(key: String): String = field(key).asString

	override fun getFieldBoolean(key: String): Boolean = field(key).asBoolean

	override fun getFieldByte(key: String): Byte = field(key).asByte

	override fun getFieldShort(key: String): Short = field(key).asShort

	override fun getFieldInt(key: String): Int = field(key).asInt

	override fun getFieldLong(key: String): Long = field(key).asLong

	override fun getFieldFloat(key: String): Float = field(key).asFloat

	override fun getFieldDouble(key: String): Double = field(key).asDouble

	override fun getFieldBigInteger(key: String): BigInteger = field(key).asBigInteger

	override fun getFieldBigDecimal(key: String): BigDecimal = field(key).asBigDecimal

	/**
	 * 当前读取器固定表示 JSON 对象。
	 */
	override val isObject: Boolean
		get() = true
}
