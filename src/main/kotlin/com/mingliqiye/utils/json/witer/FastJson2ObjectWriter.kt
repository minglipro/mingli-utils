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
 * CurrentFile FastJson2ObjectWriter.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.alibaba.fastjson2.JSONWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter

/**
 * 基于 Fastjson2 [JSONWriter] 的 JSON 对象写入器实现。
 *
 * @param writer Fastjson2 流式写入器
 */
class FastJson2ObjectWriter(
	private val writer: JSONWriter,
) : BaseJsonObjectWriter {

	override fun addNull(name: String): BaseJsonObjectWriter {
		writer.writeName(name)
		writer.writeNull()
		return this
	}

	override fun addString(name: String, value: String): BaseJsonObjectWriter {
		writer.writeName(name)
		writer.writeString(value)
		return this
	}

	override fun addNumber(name: String, value: Number): BaseJsonObjectWriter {
		writer.writeName(name)
		writer.writeAny(value)
		return this
	}

	override fun addBoolean(name: String, value: Boolean): BaseJsonObjectWriter {
		writer.writeName(name)
		writer.writeBool(value)
		return this
	}

	override fun addObject(
		name: String,
		valueCaller: (BaseJsonObjectWriter) -> Unit,
	): BaseJsonObjectWriter {
		writer.writeName(name)
		writer.startObject()
		valueCaller(FastJson2ObjectWriter(writer))
		writer.endObject()
		return this
	}

	override fun addArray(
		name: String,
		valueCaller: (BaseJsonArrayWriter) -> Unit,
	): BaseJsonObjectWriter {
		writer.writeName(name)
		writer.startArray()
		valueCaller(FastJson2ArrayWriter(writer))
		writer.endArray()
		return this
	}
}
