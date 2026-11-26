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
 * CurrentFile GsonArrayWriter.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.google.gson.stream.JsonWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter

/**
 * 基于 Gson [JsonWriter] 的 JSON 数组写入器实现，向数组追加各类型元素。
 *
 * @param writer Gson 流式 JSON 写入器
 */
class GsonArrayWriter(
	private val writer: JsonWriter,
) : BaseJsonArrayWriter {

	override fun addNull(): BaseJsonArrayWriter {
		writer.nullValue()
		return this
	}

	override fun addString(value: String): BaseJsonArrayWriter {
		writer.value(value)
		return this
	}

	override fun addNumber(value: Number): BaseJsonArrayWriter {
		writer.value(value)
		return this
	}

	override fun addBoolean(value: Boolean): BaseJsonArrayWriter {
		writer.value(value)
		return this
	}

	override fun addObject(value: (BaseJsonObjectWriter) -> Unit): BaseJsonArrayWriter {
		writer.beginObject()
		value(GsonObjectWriter(writer))
		writer.endObject()
		return this
	}

	override fun addArray(value: (BaseJsonArrayWriter) -> Unit): BaseJsonArrayWriter {
		writer.beginArray()
		value(GsonArrayWriter(writer))
		writer.endArray()
		return this
	}
}
