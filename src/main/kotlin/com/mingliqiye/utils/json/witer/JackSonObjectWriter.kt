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
 * CurrentFile JackSonObjectWriter.kt
 * LastUpdate 2026-11-17 20:06:55
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.mingliqiye.utils.json.converters.base.writeNumber
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter

/**
 * 基于 Jackson2 JsonGenerator 的 JSON 对象写入器实现，按字段名追加各类型值
 *
 * @param jsonGenerator Jackson2 的 JSON 生成器
 * @param serializationContext 序列化上下文，可为null
 */
class JackSonObjectWriter(
	private val jsonGenerator: JsonGenerator,
	private val serializationContext: SerializerProvider?,
) : BaseJsonObjectWriter {


	override fun addNull(name: String): BaseJsonObjectWriter {
		jsonGenerator.writeNullField(name)
		return this
	}

	override fun addString(
		name: String,
		value: String,
	): BaseJsonObjectWriter {
		jsonGenerator.writeStringField(name, value)
		return this
	}

	override fun addNumber(
		name: String,
		value: Number,
	): BaseJsonObjectWriter {
		jsonGenerator.writeFieldName(name)
		jsonGenerator.writeNumber(value)
		return this
	}

	override fun addBoolean(
		name: String,
		value: Boolean,
	): BaseJsonObjectWriter {
		jsonGenerator.writeBooleanField(name, value)
		return this
	}

	override fun addObject(
		name: String,
		valueCaller: (BaseJsonObjectWriter) -> Unit,
	): BaseJsonObjectWriter {
		jsonGenerator.writeFieldName(name)
		jsonGenerator.writeStartObject()
		valueCaller(JackSonObjectWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndObject()
		return this
	}

	override fun addArray(
		name: String,
		valueCaller: (BaseJsonArrayWriter) -> Unit,
	): BaseJsonObjectWriter {
		jsonGenerator.writeFieldName(name)
		jsonGenerator.writeStartArray()
		valueCaller(JackSonArrayWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndArray()
		return this
	}

}
