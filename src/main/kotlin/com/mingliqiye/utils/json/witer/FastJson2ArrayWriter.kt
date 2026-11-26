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
 * CurrentFile FastJson2ArrayWriter.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.alibaba.fastjson2.JSONWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter

/**
 * 基于 Fastjson2 [JSONWriter] 的 JSON 数组写入器实现。
 *
 * @param writer Fastjson2 流式写入器
 */
class FastJson2ArrayWriter(
	private val writer: JSONWriter,
) : BaseJsonArrayWriter {

	override fun addNull(): BaseJsonArrayWriter {
		writer.writeNull()
		return this
	}

	override fun addString(value: String): BaseJsonArrayWriter {
		writer.writeString(value)
		return this
	}

	override fun addNumber(value: Number): BaseJsonArrayWriter {
		writer.writeAny(value)
		return this
	}

	override fun addBoolean(value: Boolean): BaseJsonArrayWriter {
		writer.writeBool(value)
		return this
	}

	override fun addObject(value: (BaseJsonObjectWriter) -> Unit): BaseJsonArrayWriter {
		writer.startObject()
		value(FastJson2ObjectWriter(writer))
		writer.endObject()
		return this
	}

	override fun addArray(value: (BaseJsonArrayWriter) -> Unit): BaseJsonArrayWriter {
		writer.startArray()
		value(FastJson2ArrayWriter(writer))
		writer.endArray()
		return this
	}
}
