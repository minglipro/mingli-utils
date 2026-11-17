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

interface BaseJsonObjectWriter : BaseJsonWriter {
	override val isObject: Boolean
		get() = true

	override fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter) =
		throw JsonFormatException("setObject is not supported on BaseJsonObjectWriter")

	override fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter) =
		throw JsonFormatException("setArray is not supported on BaseJsonObjectWriter")

	override fun setString(string: String) =
		throw JsonFormatException("setString is not supported on BaseJsonObjectWriter")

	override fun setNumber(number: Number) =
		throw JsonFormatException("setNumber is not supported on BaseJsonObjectWriter")

	override fun setBoolean(boolean: Boolean) =
		throw JsonFormatException("setBoolean is not supported on BaseJsonObjectWriter")

	override fun setNull() = throw JsonFormatException("setNull is not supported on BaseJsonObjectWriter")
	fun addNull(name: String): BaseJsonObjectWriter

	fun addString(name: String, value: String): BaseJsonObjectWriter
	fun addNumber(name: String, value: Number): BaseJsonObjectWriter
	fun addBoolean(name: String, value: Boolean): BaseJsonObjectWriter
	fun addObject(name: String, valueCaller: (BaseJsonObjectWriter) -> Unit): BaseJsonObjectWriter

	fun addArray(name: String, valueCaller: (BaseJsonArrayWriter) -> Unit): BaseJsonObjectWriter
	fun add(name: String, value: String): BaseJsonObjectWriter = addString(name, value)
	fun add(name: String, value: Number): BaseJsonObjectWriter = addNumber(name, value)
	fun add(name: String, value: Boolean): BaseJsonObjectWriter = addBoolean(name, value)

}
