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
 * CurrentFile JackSon3ObjectWriter.kt
 * LastUpdate 2026-11-17 19:32:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.mingliqiye.utils.json.converters.base.writeNumber
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter
import tools.jackson.core.JsonGenerator
import tools.jackson.databind.SerializationContext

/**
 * 基于 Jackson3 JsonGenerator 的 JSON 对象写入器实现，按字段名追加各类型值
 *
 * @param jsonGenerator Jackson3 的 JSON 生成器
 * @param serializationContext 序列化上下文
 */
class JackSon3ObjectWriter(
	private val jsonGenerator: JsonGenerator,
	private val serializationContext: SerializationContext,
) : BaseJsonObjectWriter {

	/**
	 * 写入字段名
	 *
	 * @param name 字段名
	 * @return 当前 JsonGenerator 实例，便于链式调用
	 */
	fun writeName(name: String): JsonGenerator = jsonGenerator.writeName(name)

	override fun addNull(name: String): BaseJsonObjectWriter {
		writeName(name)
		return this
	}

	override fun addString(
		name: String,
		value: String,
	): BaseJsonObjectWriter {
		writeName(name).writeString(value)
		return this
	}

	override fun addNumber(
		name: String,
		value: Number,
	): BaseJsonObjectWriter {
		writeName(name).writeNumber(value)
		return this
	}

	override fun addBoolean(
		name: String,
		value: Boolean,
	): BaseJsonObjectWriter {
		writeName(name).writeBoolean(value)
		return this
	}

	override fun addObject(
		name: String,
		valueCaller: (BaseJsonObjectWriter) -> Unit,
	): BaseJsonObjectWriter {
		writeName(name)
		jsonGenerator.writeStartObject()
		valueCaller(JackSon3ObjectWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndObject()
		return this
	}

	override fun addArray(
		name: String,
		valueCaller: (BaseJsonArrayWriter) -> Unit,
	): BaseJsonObjectWriter {
		writeName(name)
		jsonGenerator.writeStartArray()
		valueCaller(JackSon3ArrayWriter(jsonGenerator, serializationContext))
		jsonGenerator.writeEndArray()
		return this
	}

}
