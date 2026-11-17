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
 * CurrentFile BaseJsonArrayReader.kt
 * LastUpdate 2026-11-17 19:32:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader.base

import com.mingliqiye.utils.exception.JsonParserException
import java.math.BigDecimal
import java.math.BigInteger

interface BaseJsonArrayReader : BaseJsonReader {
	override fun getObject(): BaseJsonObjectReader =
		throw JsonParserException("not supported getObject on BaseJsonArrayReader")

	override fun getArray(): BaseJsonArrayReader =
		throw JsonParserException("not supported getArray on BaseJsonArrayReader")

	override fun getString(): String =
		throw JsonParserException("not supported getString on BaseJsonArrayReader")

	override fun getBoolean(): Boolean =
		throw JsonParserException("not supported getBoolean on BaseJsonArrayReader")

	override fun getByte(): Byte =
		throw JsonParserException("not supported getByte on BaseJsonArrayReader")

	override fun getShort(): Short =
		throw JsonParserException("not supported getShort on BaseJsonArrayReader")

	override fun getInt(): Int =
		throw JsonParserException("not supported getInt on BaseJsonArrayReader")

	override fun getLong(): Long =
		throw JsonParserException("not supported getLong on BaseJsonArrayReader")

	override fun getFloat(): Float =
		throw JsonParserException("not supported getFloat on BaseJsonArrayReader")

	override fun getDouble(): Double =
		throw JsonParserException("not supported getDouble on BaseJsonArrayReader")

	override fun getBigInteger(): BigInteger =
		throw JsonParserException("not supported getBigInteger on BaseJsonArrayReader")

	override fun getBigDecimal(): BigDecimal =
		throw JsonParserException("not supported getBigDecimal on BaseJsonArrayReader")

	fun getIndexObject(key: Int): BaseJsonObjectReader
	fun getIndexArray(key: Int): BaseJsonArrayReader
	fun getIndexString(key: Int): String
	fun getIndexBoolean(key: Int): Boolean
	fun getIndexByte(key: Int): Byte
	fun getIndexShort(key: Int): Short
	fun getIndexInt(key: Int): Int
	fun getIndexLong(key: Int): Long
	fun getIndexFloat(key: Int): Float
	fun getIndexDouble(key: Int): Double
	fun getIndexBigInteger(key: Int): BigInteger
	fun getIndexBigDecimal(key: Int): BigDecimal
}
