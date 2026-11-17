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
 * CurrentFile JackSon3ArrayWriter.kt
 * LastUpdate 2026-11-17 19:34:28
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.mingliqiye.utils.json.converters.base.writeNumber
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter
import tools.jackson.core.JsonGenerator
import tools.jackson.databind.SerializationContext

class JackSon3ArrayWriter(
	private val jsonGenerator: JsonGenerator,
	private val serializationContext: SerializationContext,
) : BaseJsonArrayWriter {
	override fun addNull(): JackSon3ArrayWriter {
		jsonGenerator.writeNull()
		return this
	}

	override fun addString(value: String): JackSon3ArrayWriter {
		jsonGenerator.writeString(value)
		return this
	}

	override fun addNumber(value: Number): JackSon3ArrayWriter {
		jsonGenerator.writeNumber(value)
		return this
	}

	override fun addBoolean(value: Boolean): JackSon3ArrayWriter {
		jsonGenerator.writeBoolean(value)
		return this
	}

	override fun addObject(value: (BaseJsonObjectWriter) -> Unit): JackSon3ArrayWriter {
		jsonGenerator.writeStartObject()
		value(JackSon3ObjectWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndObject()
		return this
	}

	override fun addArray(value: (BaseJsonArrayWriter) -> Unit): JackSon3ArrayWriter {
		jsonGenerator.writeStartArray()
		value(JackSon3ArrayWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndArray()
		return this
	}

}
