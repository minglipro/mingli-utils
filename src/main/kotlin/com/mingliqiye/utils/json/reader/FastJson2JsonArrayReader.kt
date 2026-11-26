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
 * CurrentFile FastJson2JsonArrayReader.kt
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
 * 基于 Fastjson2 [JSONArray] 的 JSON 数组读取器实现。
 *
 * @param element Fastjson2 数组
 */
class FastJson2JsonArrayReader(
	private val element: JSONArray,
) : BaseJsonArrayReader, FastJson2ReaderJudgment(element) {

	/**
	 * 读取指定索引；越界时抛出异常。
	 */
	private fun at(index: Int): Any? {
		if (index !in 0 until element.size) {
			throw JsonParserException("array index out of bounds: $index")
		}
		return element[index]
	}

	private fun objectAt(index: Int): JSONObject {
		val value = at(index)
		if (value !is JSONObject) {
			throw JsonParserException("array element $index is not a JSON object")
		}
		return value
	}

	private fun arrayAt(index: Int): JSONArray {
		val value = at(index)
		if (value !is JSONArray) {
			throw JsonParserException("array element $index is not a JSON array")
		}
		return value
	}

	override fun getIndexObject(key: Int): BaseJsonObjectReader = FastJson2JsonObjectReader(objectAt(key))

	override fun getIndexArray(key: Int): BaseJsonArrayReader = FastJson2JsonArrayReader(arrayAt(key))

	override fun getIndexString(key: Int): String = at(key) as? String
		?: throw JsonParserException("array element $key is not a string")

	override fun getIndexBoolean(key: Int): Boolean = at(key) as? Boolean
		?: throw JsonParserException("array element $key is not a boolean")

	override fun getIndexByte(key: Int): Byte = numberAt(key).toByte()

	override fun getIndexShort(key: Int): Short = numberAt(key).toShort()

	override fun getIndexInt(key: Int): Int = numberAt(key).toInt()

	override fun getIndexLong(key: Int): Long = numberAt(key).toLong()

	override fun getIndexFloat(key: Int): Float = numberAt(key).toFloat()

	override fun getIndexDouble(key: Int): Double = numberAt(key).toDouble()

	override fun getIndexBigInteger(key: Int): BigInteger {
		return when (val number = numberAt(key)) {
			is BigInteger -> number
			is BigDecimal -> number.toBigInteger()
			else -> BigInteger(number.toString())
		}
	}

	override fun getIndexBigDecimal(key: Int): BigDecimal {
		return when (val number = numberAt(key)) {
			is BigDecimal -> number
			is BigInteger -> number.toBigDecimal()
			else -> BigDecimal(number.toString())
		}
	}

	/**
	 * 读取数字元素。
	 */
	private fun numberAt(index: Int): Number {
		return at(index) as? Number ?: throw JsonParserException("array element $index is not a number")
	}
}
