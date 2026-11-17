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
 * CurrentFile DateTimeJsonConverter.kt
 * LastUpdate 2026-11-17 20:17:32
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters

import com.google.gson.JsonParseException
import com.mingliqiye.utils.annotation.DateTimeJsonFormat
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.base.AnnotationGetter
import com.mingliqiye.utils.json.converters.base.BaseJsonConverter
import com.mingliqiye.utils.json.converters.base.getAnnotation
import com.mingliqiye.utils.json.reader.base.BaseJsonReader
import com.mingliqiye.utils.json.witer.base.BaseJsonWriter
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.Formatter

class DateTimeJsonConverter : BaseJsonConverter<DateTime> {
	@Throws(Exception::class)
	override fun convert(
		obj: DateTime?,
		jsonWriter: BaseJsonWriter,
		annotationGetter: AnnotationGetter,
	) {
		if (obj == null) {
			jsonWriter.setNull()
			return
		}
		val dateTimeJsonFormat: DateTimeJsonFormat? = annotationGetter.getAnnotation<DateTimeJsonFormat>()
		val value = if (Formatter.NONE != dateTimeJsonFormat?.value && dateTimeJsonFormat != null) {
			obj.format(dateTimeJsonFormat.value, dateTimeJsonFormat.repcZero)
		} else if (dateTimeJsonFormat?.formatter?.isEmpty() == false) {
			obj.format(dateTimeJsonFormat.formatter, dateTimeJsonFormat.repcZero)
		} else {
			obj.format()
		}
		jsonWriter.setString(value)
	}


	override fun deConvert(jsonReader: BaseJsonReader, annotationGetter: AnnotationGetter): DateTime? {
		val dateTimeJsonFormat: DateTimeJsonFormat? = annotationGetter.getAnnotation<DateTimeJsonFormat>()
		if (jsonReader.isNull) return null
		if (!jsonReader.isString) throw JsonParseException("type item not string")
		val obj = jsonReader.getString()
		return if (Formatter.NONE != dateTimeJsonFormat?.value && dateTimeJsonFormat != null) {
			DateTime.parse(obj, dateTimeJsonFormat.value, dateTimeJsonFormat.repcZero)
		} else if (dateTimeJsonFormat?.formatter?.isEmpty() == false) {
			DateTime.parse(obj, dateTimeJsonFormat.formatter, dateTimeJsonFormat.repcZero)
		} else {
			DateTime.parse(obj)
		}
	}

	override fun getType(): JsonTypeReference<DateTime> = JsonTypeReference.of<DateTime>()
}
