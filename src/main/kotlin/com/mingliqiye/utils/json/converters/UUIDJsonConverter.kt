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
 * CurrentFile UUIDJsonConverter.kt
 * LastUpdate 2026-11-17 20:01:08
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters

import com.google.gson.JsonParseException
import com.mingliqiye.utils.annotation.UUIDJsonFormat
import com.mingliqiye.utils.base.BaseType
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.base.AnnotationGetter
import com.mingliqiye.utils.json.converters.base.BaseJsonConverter
import com.mingliqiye.utils.json.converters.base.getAnnotation
import com.mingliqiye.utils.json.reader.base.BaseJsonReader
import com.mingliqiye.utils.json.witer.base.BaseJsonWriter
import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.UUIDFormatType

class UUIDJsonConverter : BaseJsonConverter<UUID> {

	override fun convert(
		obj: UUID?,
		jsonWriter: BaseJsonWriter,
		annotationGetter: AnnotationGetter,
	) {
		if (obj == null) {
			jsonWriter.setNull()
			return
		}
		val dateTimeJsonFormat: UUIDJsonFormat? = annotationGetter.getAnnotation<UUIDJsonFormat>()


		val uuid =
			if (dateTimeJsonFormat == null) obj.getString() else if (BaseType.BASE16 != dateTimeJsonFormat.base) {
				obj.getString(dateTimeJsonFormat.base)
			} else if (UUIDFormatType.NO_UPPER_SPACE != dateTimeJsonFormat.value) {
				obj.getString(dateTimeJsonFormat.value)
			} else {
				obj.getString()
			}

		jsonWriter.setString(uuid)
	}

	override fun deConvert(
		jsonReader: BaseJsonReader,
		annotationGetter: AnnotationGetter,
	): UUID? {
		if (jsonReader.isNull) return null
		if (!jsonReader.isString) throw JsonParseException("type item not string")

		val obj = jsonReader.getString()

		val dateTimeJsonFormat: UUIDJsonFormat = annotationGetter.getAnnotation<UUIDJsonFormat>() ?: return UUID.of(obj)
		return if (BaseType.BASE16 != dateTimeJsonFormat.base) {
			UUID.of(obj, dateTimeJsonFormat.base)
		} else {
			UUID.of(obj)
		}
	}

	override fun getType(): JsonTypeReference<UUID> = JsonTypeReference.of()
}
