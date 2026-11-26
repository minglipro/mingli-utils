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
 * CurrentFile FastJson2JsonReader.kt
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
import com.mingliqiye.utils.json.reader.base.BaseJsonReader
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 基于 Fastjson2 解析值的 JSON 读取器实现。
 *
 * @param value Fastjson2 解析出的值
 */
class FastJson2JsonReader(
	private val value: Any?,
) : BaseJsonReader, FastJson2ReaderJudgment(value) {

	override fun getObject(): BaseJsonObjectReader {
		if (value !is JSONObject) {
			throw JsonParserException("current value is not a JSON object")
		}
		return FastJson2JsonObjectReader(value)
	}

	override fun getArray(): BaseJsonArrayReader {
		if (value !is JSONArray) {
			throw JsonParserException("current value is not a JSON array")
		}
		return FastJson2JsonArrayReader(value)
	}

	override fun getString(): String = value as? String ?: value.toString()

	override fun getBoolean(): Boolean = value as? Boolean
		?: throw JsonParserException("current value is not a boolean")

	override fun getByte(): Byte = number().toByte()

	override fun getShort(): Short = number().toShort()

	override fun getInt(): Int = number().toInt()

	override fun getLong(): Long = number().toLong()

	override fun getFloat(): Float = number().toFloat()

	override fun getDouble(): Double = number().toDouble()

	override fun getBigInteger(): BigInteger {
		return when (val number = number()) {
			is BigInteger -> number
			is BigDecimal -> number.toBigInteger()
			else -> BigInteger(number.toString())
		}
	}

	override fun getBigDecimal(): BigDecimal {
		return when (val number = number()) {
			is BigDecimal -> number
			is BigInteger -> number.toBigDecimal()
			else -> BigDecimal(number.toString())
		}
	}

	/**
	 * 将当前值读取为数字。
	 *
	 * @return 数字值
	 * @throws JsonParserException 当前值不是数字时抛出
	 */
	private fun number(): Number {
		return value as? Number ?: throw JsonParserException("current value is not a number")
	}
}
