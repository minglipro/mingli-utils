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
 * CurrentFile JackSonArrayWriter.kt
 * LastUpdate 2026-11-17 20:01:56
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.mingliqiye.utils.json.converters.base.writeNumber
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter

class JackSonArrayWriter(
	private val jsonGenerator: JsonGenerator,
	private val serializationContext: SerializerProvider?,
) : BaseJsonArrayWriter {
	override fun addNull(): JackSonArrayWriter {
		jsonGenerator.writeNull()
		return this
	}

	override fun addString(value: String): JackSonArrayWriter {
		jsonGenerator.writeString(value)
		return this
	}

	override fun addNumber(value: Number): JackSonArrayWriter {
		jsonGenerator.writeNumber(value)
		return this
	}

	override fun addBoolean(value: Boolean): JackSonArrayWriter {
		jsonGenerator.writeBoolean(value)
		return this
	}

	override fun addObject(value: (BaseJsonObjectWriter) -> Unit): JackSonArrayWriter {
		jsonGenerator.writeStartObject()
		value(JackSonObjectWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndObject()
		return this
	}

	override fun addArray(value: (BaseJsonArrayWriter) -> Unit): JackSonArrayWriter {
		jsonGenerator.writeStartArray()
		value(JackSonArrayWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndArray()
		return this
	}

}
