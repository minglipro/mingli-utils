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
 * CurrentFile FastJson2JsonObjectReader.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader

import com.alibaba.fastjson2.JSONArray
import com.alibaba.fastjson2.JSONObject
import com.mingliqiye.utils.exception.JsonParserException
import com.mingliqiye.utils.json.judgment.FastJson2ReaderJudgment
import com.mingliqiye.utils.json.reader.base.BaseJsonArrayReader
import com.mingliqiye.utils.json.reader.base.BaseJsonObjectReader
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 基于 Fastjson2 [JSONObject] 的 JSON 对象读取器实现。
 *
 * @param element Fastjson2 对象
 */
class FastJson2JsonObjectReader(
	private val element: JSONObject,
) : BaseJsonObjectReader, FastJson2ReaderJudgment(element) {

	/**
	 * 读取字段；字段不存在时抛出异常。
	 */
	private fun field(key: String): Any? {
		if (!element.containsKey(key)) {
			throw JsonParserException("field not found: $key")
		}
		return element[key]
	}

	private fun objectField(key: String): JSONObject {
		val value = field(key)
		if (value !is JSONObject) {
			throw JsonParserException("field $key is not a JSON object")
		}
		return value
	}

	private fun arrayField(key: String): JSONArray {
		val value = field(key)
		if (value !is JSONArray) {
			throw JsonParserException("field $key is not a JSON array")
		}
		return value
	}

	override fun getFieldObject(key: String): BaseJsonObjectReader = FastJson2JsonObjectReader(objectField(key))

	override fun getFieldArray(key: String): BaseJsonArrayReader = FastJson2JsonArrayReader(arrayField(key))

	override fun getFieldString(key: String): String = field(key) as? String
		?: throw JsonParserException("field $key is not a string")

	override fun getFieldBoolean(key: String): Boolean = field(key) as? Boolean
		?: throw JsonParserException("field $key is not a boolean")

	override fun getFieldByte(key: String): Byte = numberField(key).toByte()

	override fun getFieldShort(key: String): Short = numberField(key).toShort()

	override fun getFieldInt(key: String): Int = numberField(key).toInt()

	override fun getFieldLong(key: String): Long = numberField(key).toLong()

	override fun getFieldFloat(key: String): Float = numberField(key).toFloat()

	override fun getFieldDouble(key: String): Double = numberField(key).toDouble()

	override fun getFieldBigInteger(key: String): BigInteger {
		return when (val number = numberField(key)) {
			is BigInteger -> number
			is BigDecimal -> number.toBigInteger()
			else -> BigInteger(number.toString())
		}
	}

	override fun getFieldBigDecimal(key: String): BigDecimal {
		return when (val number = numberField(key)) {
			is BigDecimal -> number
			is BigInteger -> number.toBigDecimal()
			else -> BigDecimal(number.toString())
		}
	}

	override val isObject: Boolean
		get() = true

	/**
	 * 读取数字字段。
	 */
	private fun numberField(key: String): Number {
		return field(key) as? Number ?: throw JsonParserException("field $key is not a number")
	}
}
