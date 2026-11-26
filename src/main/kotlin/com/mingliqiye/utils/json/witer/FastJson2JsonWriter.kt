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
 * CurrentFile FastJson2JsonWriter.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.alibaba.fastjson2.JSONWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonWriter

/**
 * 基于 Fastjson2 [JSONWriter] 的 JSON 写入器实现。
 *
 * @param writer Fastjson2 流式写入器
 */
class FastJson2JsonWriter(
	private val writer: JSONWriter,
) : BaseJsonWriter {

	override fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter) {
		writer.startObject()
		objCall(FastJson2ObjectWriter(writer))
		writer.endObject()
	}

	override fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter) {
		writer.startArray()
		arrayCall(FastJson2ArrayWriter(writer))
		writer.endArray()
	}

	override fun setString(string: String) {
		writer.writeString(string)
	}

	override fun setNumber(number: Number) {
		writer.writeAny(number)
	}

	override fun setBoolean(boolean: Boolean) {
		writer.writeBool(boolean)
	}

	override fun setNull() {
		writer.writeNull()
	}
}
