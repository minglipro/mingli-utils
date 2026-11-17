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
 * CurrentFile BaseJsonArrayWriter.kt
 * LastUpdate 2026-11-17 19:43:44
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer.base

import com.mingliqiye.utils.exception.JsonFormatException

/**
 * JSON 数组写入器接口，向数组中追加各类型元素，支持链式调用。
 *
 * 直接设置当前节点的 setXxx 方法默认抛出 [JsonFormatException]，应使用 addXxx 系列方法。
 */
interface BaseJsonArrayWriter : BaseJsonWriter {


	/** 数组写入器不支持直接设置为对象，调用时抛出 [JsonFormatException] */
	override fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter) =
		throw JsonFormatException("setObject is not supported on BaseJsonArrayWriter")

	/** 数组写入器不支持直接设置为数组，调用时抛出 [JsonFormatException] */
	override fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter) =
		throw JsonFormatException("setArray is not supported on BaseJsonArrayWriter")

	/** 数组写入器不支持直接设置为字符串，调用时抛出 [JsonFormatException] */
	override fun setString(string: String) =
		throw JsonFormatException("setString is not supported on BaseJsonArrayWriter")

	/** 数组写入器不支持直接设置为数值，调用时抛出 [JsonFormatException] */
	override fun setNumber(number: Number) =
		throw JsonFormatException("setNumber is not supported on BaseJsonArrayWriter")

	/** 数组写入器不支持直接设置为布尔值，调用时抛出 [JsonFormatException] */
	override fun setBoolean(boolean: Boolean) =
		throw JsonFormatException("setBoolean is not supported on BaseJsonArrayWriter")

	/** 数组写入器不支持直接设置为 null，调用时抛出 [JsonFormatException] */
	override fun setNull() = throw JsonFormatException("setNull is not supported on BaseJsonArrayWriter")
	override val isArray
		get() = true

	/**
	 * 追加 null 元素
	 *
	 * @return 当前数组写入器，便于链式调用
	 */
	fun addNull(): BaseJsonArrayWriter
	/**
	 * 追加字符串元素
	 *
	 * @param value 字符串值
	 * @return 当前数组写入器，便于链式调用
	 */
	fun addString(value: String): BaseJsonArrayWriter
	/**
	 * 追加数值元素
	 *
	 * @param value 数值
	 * @return 当前数组写入器，便于链式调用
	 */
	fun addNumber(value: Number): BaseJsonArrayWriter
	/**
	 * 追加布尔元素
	 *
	 * @param value 布尔值
	 * @return 当前数组写入器，便于链式调用
	 */
	fun addBoolean(value: Boolean): BaseJsonArrayWriter
	/**
	 * 追加对象元素，通过回调填充子对象
	 *
	 * @param value 子对象写入回调
	 * @return 当前数组写入器，便于链式调用
	 */
	fun addObject(value: (BaseJsonObjectWriter) -> Unit): BaseJsonArrayWriter
	/**
	 * 追加数组元素，通过回调填充子数组
	 *
	 * @param value 子数组写入回调
	 * @return 当前数组写入器，便于链式调用
	 */
	fun addArray(value: (BaseJsonArrayWriter) -> Unit): BaseJsonArrayWriter
	/**
	 * 追加字符串元素，[addString] 的简写
	 *
	 * @param value 字符串值
	 * @return 当前数组写入器，便于链式调用
	 */
	fun add(value: String): BaseJsonArrayWriter = addString(value)
	/**
	 * 追加数值元素，[addNumber] 的简写
	 *
	 * @param value 数值
	 * @return 当前数组写入器，便于链式调用
	 */
	fun add(value: Number): BaseJsonArrayWriter = addNumber(value)
	/**
	 * 追加布尔元素，[addBoolean] 的简写
	 *
	 * @param value 布尔值
	 * @return 当前数组写入器，便于链式调用
	 */
	fun add(value: Boolean): BaseJsonArrayWriter = addBoolean(value)
}
