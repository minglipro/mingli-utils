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
 * CurrentFile JackSon3JsonWriter.kt
 * LastUpdate 2026-11-17 19:32:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.mingliqiye.utils.json.converters.base.writeNumber
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonWriter
import tools.jackson.core.JsonGenerator
import tools.jackson.databind.SerializationContext

class JackSon3JsonWriter(
	private val jsonGenerator: JsonGenerator,
	private val serializationContext: SerializationContext,
) : BaseJsonWriter {

	override fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter) {
		jsonGenerator.writeStartObject()
		objCall(
			JackSon3ObjectWriter(
				jsonGenerator,
				serializationContext,
			)
		)
		jsonGenerator.writeEndObject()
	}

	override fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter) {
		jsonGenerator.writeStartArray()
		arrayCall(JackSon3ArrayWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndArray()
	}

	override fun setString(string: String) {
		jsonGenerator.writeString(string)
	}

	override fun setNumber(number: Number) {
		jsonGenerator.writeNumber(number)
	}

	override fun setBoolean(boolean: Boolean) {
		jsonGenerator.writeBoolean(boolean)
	}

	override fun setNull() {
		jsonGenerator.writeNull()
	}

}
