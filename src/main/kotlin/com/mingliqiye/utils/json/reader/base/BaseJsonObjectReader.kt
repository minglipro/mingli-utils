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
 * CurrentFile BaseJsonObjectReader.kt
 * LastUpdate 2026-11-17 19:32:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader.base

import com.mingliqiye.utils.exception.JsonParserException
import java.math.BigDecimal
import java.math.BigInteger

interface BaseJsonObjectReader : BaseJsonReader {
	override val isObject: Boolean
		get() = true


	override fun getObject(): BaseJsonObjectReader =
		throw JsonParserException("not supported getObject on BaseJsonObjectReader")

	override fun getArray(): BaseJsonArrayReader =
		throw JsonParserException("not supported getArray on BaseJsonObjectReader")

	override fun getString(): String =
		throw JsonParserException("not supported getString on BaseJsonObjectReader")

	override fun getBoolean(): Boolean =
		throw JsonParserException("not supported getBoolean on BaseJsonObjectReader")

	override fun getByte(): Byte =
		throw JsonParserException("not supported getByte on BaseJsonObjectReader")

	override fun getShort(): Short =
		throw JsonParserException("not supported getShort on BaseJsonObjectReader")

	override fun getInt(): Int =
		throw JsonParserException("not supported getInt on BaseJsonObjectReader")

	override fun getLong(): Long =
		throw JsonParserException("not supported getLong on BaseJsonObjectReader")

	override fun getFloat(): Float =
		throw JsonParserException("not supported getFloat on BaseJsonObjectReader")

	override fun getDouble(): Double =
		throw JsonParserException("not supported getDouble on BaseJsonObjectReader")

	override fun getBigInteger(): BigInteger =
		throw JsonParserException("not supported getBigInteger on BaseJsonObjectReader")

	override fun getBigDecimal(): BigDecimal =
		throw JsonParserException("not supported getBigDecimal on BaseJsonObjectReader")

	fun getFieldObject(key: String): BaseJsonObjectReader
	fun getFieldArray(key: String): BaseJsonArrayReader
	fun getFieldString(key: String): String
	fun getFieldBoolean(key: String): Boolean
	fun getFieldByte(key: String): Byte
	fun getFieldShort(key: String): Short
	fun getFieldInt(key: String): Int
	fun getFieldLong(key: String): Long
	fun getFieldFloat(key: String): Float
	fun getFieldDouble(key: String): Double
	fun getFieldBigInteger(key: String): BigInteger
	fun getFieldBigDecimal(key: String): BigDecimal
}
