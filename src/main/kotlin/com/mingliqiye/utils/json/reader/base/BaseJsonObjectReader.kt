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

/**
 * JSON 对象读取器接口，按字段名读取对象中的各类型值。
 *
 * 直接读取当前节点的 getXxx 方法默认抛出 [JsonParserException]，应使用 getFieldXxx 系列方法。
 */
interface BaseJsonObjectReader : BaseJsonReader {
	override val isObject: Boolean
		get() = true


	/** 对象读取器不支持直接读取为对象，调用时抛出 [JsonParserException] */
	override fun getObject(): BaseJsonObjectReader =
		throw JsonParserException("not supported getObject on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为数组，调用时抛出 [JsonParserException] */
	override fun getArray(): BaseJsonArrayReader =
		throw JsonParserException("not supported getArray on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为字符串，调用时抛出 [JsonParserException] */
	override fun getString(): String =
		throw JsonParserException("not supported getString on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为布尔值，调用时抛出 [JsonParserException] */
	override fun getBoolean(): Boolean =
		throw JsonParserException("not supported getBoolean on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为 Byte，调用时抛出 [JsonParserException] */
	override fun getByte(): Byte =
		throw JsonParserException("not supported getByte on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为 Short，调用时抛出 [JsonParserException] */
	override fun getShort(): Short =
		throw JsonParserException("not supported getShort on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为 Int，调用时抛出 [JsonParserException] */
	override fun getInt(): Int =
		throw JsonParserException("not supported getInt on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为 Long，调用时抛出 [JsonParserException] */
	override fun getLong(): Long =
		throw JsonParserException("not supported getLong on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为 Float，调用时抛出 [JsonParserException] */
	override fun getFloat(): Float =
		throw JsonParserException("not supported getFloat on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为 Double，调用时抛出 [JsonParserException] */
	override fun getDouble(): Double =
		throw JsonParserException("not supported getDouble on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为 BigInteger，调用时抛出 [JsonParserException] */
	override fun getBigInteger(): BigInteger =
		throw JsonParserException("not supported getBigInteger on BaseJsonObjectReader")

	/** 对象读取器不支持直接读取为 BigDecimal，调用时抛出 [JsonParserException] */
	override fun getBigDecimal(): BigDecimal =
		throw JsonParserException("not supported getBigDecimal on BaseJsonObjectReader")

	/**
	 * 读取指定字段的对象值
	 *
	 * @param key 字段名
	 * @return 字段对应的 JSON 对象读取器
	 */
	fun getFieldObject(key: String): BaseJsonObjectReader
	/**
	 * 读取指定字段的数组值
	 *
	 * @param key 字段名
	 * @return 字段对应的 JSON 数组读取器
	 */
	fun getFieldArray(key: String): BaseJsonArrayReader
	/**
	 * 读取指定字段的字符串值
	 *
	 * @param key 字段名
	 * @return 字段的字符串值
	 */
	fun getFieldString(key: String): String
	/**
	 * 读取指定字段的布尔值
	 *
	 * @param key 字段名
	 * @return 字段的布尔值
	 */
	fun getFieldBoolean(key: String): Boolean
	/**
	 * 读取指定字段的 Byte 数值
	 *
	 * @param key 字段名
	 * @return 字段的 Byte 数值
	 */
	fun getFieldByte(key: String): Byte
	/**
	 * 读取指定字段的 Short 数值
	 *
	 * @param key 字段名
	 * @return 字段的 Short 数值
	 */
	fun getFieldShort(key: String): Short
	/**
	 * 读取指定字段的 Int 数值
	 *
	 * @param key 字段名
	 * @return 字段的 Int 数值
	 */
	fun getFieldInt(key: String): Int
	/**
	 * 读取指定字段的 Long 数值
	 *
	 * @param key 字段名
	 * @return 字段的 Long 数值
	 */
	fun getFieldLong(key: String): Long
	/**
	 * 读取指定字段的 Float 数值
	 *
	 * @param key 字段名
	 * @return 字段的 Float 数值
	 */
	fun getFieldFloat(key: String): Float
	/**
	 * 读取指定字段的 Double 数值
	 *
	 * @param key 字段名
	 * @return 字段的 Double 数值
	 */
	fun getFieldDouble(key: String): Double
	/**
	 * 读取指定字段的 BigInteger 数值
	 *
	 * @param key 字段名
	 * @return 字段的 BigInteger 数值
	 */
	fun getFieldBigInteger(key: String): BigInteger
	/**
	 * 读取指定字段的 BigDecimal 数值
	 *
	 * @param key 字段名
	 * @return 字段的 BigDecimal 数值
	 */
	fun getFieldBigDecimal(key: String): BigDecimal
}
