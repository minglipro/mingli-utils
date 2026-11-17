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

/**
 * JSON 数组读取器接口，按索引读取数组中的各类型值。
 *
 * 直接读取当前节点的 getXxx 方法默认抛出 [JsonParserException]，应使用 getIndexXxx 系列方法。
 */
interface BaseJsonArrayReader : BaseJsonReader {
	/** 数组读取器不支持直接读取为对象，调用时抛出 [JsonParserException] */
	override fun getObject(): BaseJsonObjectReader =
		throw JsonParserException("not supported getObject on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为数组，调用时抛出 [JsonParserException] */
	override fun getArray(): BaseJsonArrayReader =
		throw JsonParserException("not supported getArray on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为字符串，调用时抛出 [JsonParserException] */
	override fun getString(): String =
		throw JsonParserException("not supported getString on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为布尔值，调用时抛出 [JsonParserException] */
	override fun getBoolean(): Boolean =
		throw JsonParserException("not supported getBoolean on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为 Byte，调用时抛出 [JsonParserException] */
	override fun getByte(): Byte =
		throw JsonParserException("not supported getByte on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为 Short，调用时抛出 [JsonParserException] */
	override fun getShort(): Short =
		throw JsonParserException("not supported getShort on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为 Int，调用时抛出 [JsonParserException] */
	override fun getInt(): Int =
		throw JsonParserException("not supported getInt on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为 Long，调用时抛出 [JsonParserException] */
	override fun getLong(): Long =
		throw JsonParserException("not supported getLong on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为 Float，调用时抛出 [JsonParserException] */
	override fun getFloat(): Float =
		throw JsonParserException("not supported getFloat on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为 Double，调用时抛出 [JsonParserException] */
	override fun getDouble(): Double =
		throw JsonParserException("not supported getDouble on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为 BigInteger，调用时抛出 [JsonParserException] */
	override fun getBigInteger(): BigInteger =
		throw JsonParserException("not supported getBigInteger on BaseJsonArrayReader")

	/** 数组读取器不支持直接读取为 BigDecimal，调用时抛出 [JsonParserException] */
	override fun getBigDecimal(): BigDecimal =
		throw JsonParserException("not supported getBigDecimal on BaseJsonArrayReader")

	/**
	 * 读取指定索引的对象元素
	 *
	 * @param key 数组索引
	 * @return 元素对应的 JSON 对象读取器
	 */
	fun getIndexObject(key: Int): BaseJsonObjectReader
	/**
	 * 读取指定索引的数组元素
	 *
	 * @param key 数组索引
	 * @return 元素对应的 JSON 数组读取器
	 */
	fun getIndexArray(key: Int): BaseJsonArrayReader
	/**
	 * 读取指定索引的字符串元素
	 *
	 * @param key 数组索引
	 * @return 元素的字符串值
	 */
	fun getIndexString(key: Int): String
	/**
	 * 读取指定索引的布尔元素
	 *
	 * @param key 数组索引
	 * @return 元素的布尔值
	 */
	fun getIndexBoolean(key: Int): Boolean
	/**
	 * 读取指定索引的 Byte 数值元素
	 *
	 * @param key 数组索引
	 * @return 元素的 Byte 数值
	 */
	fun getIndexByte(key: Int): Byte
	/**
	 * 读取指定索引的 Short 数值元素
	 *
	 * @param key 数组索引
	 * @return 元素的 Short 数值
	 */
	fun getIndexShort(key: Int): Short
	/**
	 * 读取指定索引的 Int 数值元素
	 *
	 * @param key 数组索引
	 * @return 元素的 Int 数值
	 */
	fun getIndexInt(key: Int): Int
	/**
	 * 读取指定索引的 Long 数值元素
	 *
	 * @param key 数组索引
	 * @return 元素的 Long 数值
	 */
	fun getIndexLong(key: Int): Long
	/**
	 * 读取指定索引的 Float 数值元素
	 *
	 * @param key 数组索引
	 * @return 元素的 Float 数值
	 */
	fun getIndexFloat(key: Int): Float
	/**
	 * 读取指定索引的 Double 数值元素
	 *
	 * @param key 数组索引
	 * @return 元素的 Double 数值
	 */
	fun getIndexDouble(key: Int): Double
	/**
	 * 读取指定索引的 BigInteger 数值元素
	 *
	 * @param key 数组索引
	 * @return 元素的 BigInteger 数值
	 */
	fun getIndexBigInteger(key: Int): BigInteger
	/**
	 * 读取指定索引的 BigDecimal 数值元素
	 *
	 * @param key 数组索引
	 * @return 元素的 BigDecimal 数值
	 */
	fun getIndexBigDecimal(key: Int): BigDecimal
}
