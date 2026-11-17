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
 * CurrentFile BaseJsonObjectWriter.kt
 * LastUpdate 2026-11-17 18:39:06
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer.base

import com.mingliqiye.utils.exception.JsonFormatException

/**
 * JSON 对象写入器接口，按字段名向对象中追加各类型值，支持链式调用。
 *
 * 直接设置当前节点的 setXxx 方法默认抛出 [JsonFormatException]，应使用 addXxx 系列方法。
 */
interface BaseJsonObjectWriter : BaseJsonWriter {
	override val isObject: Boolean
		get() = true

	/** 对象写入器不支持直接设置为对象，调用时抛出 [JsonFormatException] */
	override fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter) =
		throw JsonFormatException("setObject is not supported on BaseJsonObjectWriter")

	/** 对象写入器不支持直接设置为数组，调用时抛出 [JsonFormatException] */
	override fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter) =
		throw JsonFormatException("setArray is not supported on BaseJsonObjectWriter")

	/** 对象写入器不支持直接设置为字符串，调用时抛出 [JsonFormatException] */
	override fun setString(string: String) =
		throw JsonFormatException("setString is not supported on BaseJsonObjectWriter")

	/** 对象写入器不支持直接设置为数值，调用时抛出 [JsonFormatException] */
	override fun setNumber(number: Number) =
		throw JsonFormatException("setNumber is not supported on BaseJsonObjectWriter")

	/** 对象写入器不支持直接设置为布尔值，调用时抛出 [JsonFormatException] */
	override fun setBoolean(boolean: Boolean) =
		throw JsonFormatException("setBoolean is not supported on BaseJsonObjectWriter")

	/** 对象写入器不支持直接设置为 null，调用时抛出 [JsonFormatException] */
	override fun setNull() = throw JsonFormatException("setNull is not supported on BaseJsonObjectWriter")
	/**
	 * 追加值为 null 的字段
	 *
	 * @param name 字段名
	 * @return 当前对象写入器，便于链式调用
	 */
	fun addNull(name: String): BaseJsonObjectWriter

	/**
	 * 追加字符串字段
	 *
	 * @param name 字段名
	 * @param value 字符串值
	 * @return 当前对象写入器，便于链式调用
	 */
	fun addString(name: String, value: String): BaseJsonObjectWriter
	/**
	 * 追加数值字段
	 *
	 * @param name 字段名
	 * @param value 数值
	 * @return 当前对象写入器，便于链式调用
	 */
	fun addNumber(name: String, value: Number): BaseJsonObjectWriter
	/**
	 * 追加布尔字段
	 *
	 * @param name 字段名
	 * @param value 布尔值
	 * @return 当前对象写入器，便于链式调用
	 */
	fun addBoolean(name: String, value: Boolean): BaseJsonObjectWriter
	/**
	 * 追加对象字段，通过回调填充子对象
	 *
	 * @param name 字段名
	 * @param valueCaller 子对象写入回调
	 * @return 当前对象写入器，便于链式调用
	 */
	fun addObject(name: String, valueCaller: (BaseJsonObjectWriter) -> Unit): BaseJsonObjectWriter

	/**
	 * 追加数组字段，通过回调填充数组元素
	 *
	 * @param name 字段名
	 * @param valueCaller 数组写入回调
	 * @return 当前对象写入器，便于链式调用
	 */
	fun addArray(name: String, valueCaller: (BaseJsonArrayWriter) -> Unit): BaseJsonObjectWriter
	/**
	 * 追加字符串字段，[addString] 的简写
	 *
	 * @param name 字段名
	 * @param value 字符串值
	 * @return 当前对象写入器，便于链式调用
	 */
	fun add(name: String, value: String): BaseJsonObjectWriter = addString(name, value)
	/**
	 * 追加数值字段，[addNumber] 的简写
	 *
	 * @param name 字段名
	 * @param value 数值
	 * @return 当前对象写入器，便于链式调用
	 */
	fun add(name: String, value: Number): BaseJsonObjectWriter = addNumber(name, value)
	/**
	 * 追加布尔字段，[addBoolean] 的简写
	 *
	 * @param name 字段名
	 * @param value 布尔值
	 * @return 当前对象写入器，便于链式调用
	 */
	fun add(name: String, value: Boolean): BaseJsonObjectWriter = addBoolean(name, value)

}
