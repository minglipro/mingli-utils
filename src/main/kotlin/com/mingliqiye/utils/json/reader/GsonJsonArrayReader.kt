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
 * CurrentFile GsonJsonArrayReader.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.mingliqiye.utils.exception.JsonParserException
import com.mingliqiye.utils.json.judgment.GsonReaderJudgment
import com.mingliqiye.utils.json.reader.base.BaseJsonArrayReader
import com.mingliqiye.utils.json.reader.base.BaseJsonObjectReader
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 基于 Gson [JsonArray] 的 JSON 数组读取器实现，按索引读取各类型值。
 *
 * @param element 待读取的 Gson 数组节点
 */
class GsonJsonArrayReader(
	private val element: JsonArray,
) : BaseJsonArrayReader, GsonReaderJudgment(element) {

	/**
	 * 读取指定索引；越界时抛出异常。
	 *
	 * @param index 数组下标
	 * @return 元素节点
	 * @throws JsonParserException 下标越界时抛出
	 */
	private fun at(index: Int): JsonElement {
		if (index !in 0 until element.size()) {
			throw JsonParserException("array index out of bounds: $index")
		}
		return element.get(index)
	}

	/**
	 * 读取指定索引并要求它是对象。
	 */
	private fun objectAt(index: Int): com.google.gson.JsonObject {
		val value = at(index)
		if (!value.isJsonObject) {
			throw JsonParserException("array element $index is not a JSON object")
		}
		return value.asJsonObject
	}

	/**
	 * 读取指定索引并要求它是数组。
	 */
	private fun arrayAt(index: Int): JsonArray {
		val value = at(index)
		if (!value.isJsonArray) {
			throw JsonParserException("array element $index is not a JSON array")
		}
		return value.asJsonArray
	}

	override fun getIndexObject(key: Int): BaseJsonObjectReader = GsonJsonObjectReader(objectAt(key))

	override fun getIndexArray(key: Int): BaseJsonArrayReader = GsonJsonArrayReader(arrayAt(key))

	override fun getIndexString(key: Int): String = at(key).asString

	override fun getIndexBoolean(key: Int): Boolean = at(key).asBoolean

	override fun getIndexByte(key: Int): Byte = at(key).asByte

	override fun getIndexShort(key: Int): Short = at(key).asShort

	override fun getIndexInt(key: Int): Int = at(key).asInt

	override fun getIndexLong(key: Int): Long = at(key).asLong

	override fun getIndexFloat(key: Int): Float = at(key).asFloat

	override fun getIndexDouble(key: Int): Double = at(key).asDouble

	override fun getIndexBigInteger(key: Int): BigInteger = at(key).asBigInteger

	override fun getIndexBigDecimal(key: Int): BigDecimal = at(key).asBigDecimal
}
