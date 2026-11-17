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

interface BaseJsonArrayWriter : BaseJsonWriter {


	override fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter) =
		throw JsonFormatException("setObject is not supported on BaseJsonArrayWriter")

	override fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter) =
		throw JsonFormatException("setArray is not supported on BaseJsonArrayWriter")

	override fun setString(string: String) =
		throw JsonFormatException("setString is not supported on BaseJsonArrayWriter")

	override fun setNumber(number: Number) =
		throw JsonFormatException("setNumber is not supported on BaseJsonArrayWriter")

	override fun setBoolean(boolean: Boolean) =
		throw JsonFormatException("setBoolean is not supported on BaseJsonArrayWriter")

	override fun setNull() = throw JsonFormatException("setNull is not supported on BaseJsonArrayWriter")
	override val isArray
		get() = true

	fun addNull(): BaseJsonArrayWriter
	fun addString(value: String): BaseJsonArrayWriter
	fun addNumber(value: Number): BaseJsonArrayWriter
	fun addBoolean(value: Boolean): BaseJsonArrayWriter
	fun addObject(value: (BaseJsonObjectWriter) -> Unit): BaseJsonArrayWriter
	fun addArray(value: (BaseJsonArrayWriter) -> Unit): BaseJsonArrayWriter
	fun add(value: String): BaseJsonArrayWriter = addString(value)
	fun add(value: Number): BaseJsonArrayWriter = addNumber(value)
	fun add(value: Boolean): BaseJsonArrayWriter = addBoolean(value)
}
