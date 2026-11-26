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
 * CurrentFile GsonJsonWriter.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer

import com.google.gson.stream.JsonWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonArrayWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonObjectWriter
import com.mingliqiye.utils.json.witer.base.BaseJsonWriter

/**
 * 基于 Gson [JsonWriter] 的 JSON 写入器实现。
 *
 * 对象/数组写入时自动补全起止标记，值类型通过 Gson 的流式 writer 输出。
 *
 * @param writer Gson 流式 JSON 写入器
 */
class GsonJsonWriter(
	private val writer: JsonWriter,
) : BaseJsonWriter {

	override fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter) {
		writer.beginObject()
		objCall(GsonObjectWriter(writer))
		writer.endObject()
	}

	override fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter) {
		writer.beginArray()
		arrayCall(GsonArrayWriter(writer))
		writer.endArray()
	}

	override fun setString(string: String) {
		writer.value(string)
	}

	override fun setNumber(number: Number) {
		writer.value(number)
	}

	override fun setBoolean(boolean: Boolean) {
		writer.value(boolean)
	}

	override fun setNull() {
		writer.nullValue()
	}
}
