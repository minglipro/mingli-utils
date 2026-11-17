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
 * CurrentFile JackJsonDeserializer.kt
 * LastUpdate 2026-11-17 19:53:29
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.deser.ContextualDeserializer
import com.mingliqiye.utils.json.reader.JackSonJsonReader

class JackJsonDeserializer<T>(
	val property: BeanProperty? = null,
	val jsonConverter: BaseJsonConverter<T>,
) : JsonDeserializer<T>(), ContextualDeserializer {


	val annotationGetter =
		object : AnnotationGetter {
			override fun <T : Annotation> getAnnotation(clazz: Class<T>): T? = property?.getAnnotation(clazz)
		}

	override fun deserialize(
		p: JsonParser,
		ctxt: DeserializationContext?,
	): T? {
		return jsonConverter.deConvert(JackSonJsonReader(p.readValueAsTree()), annotationGetter)
	}

	override fun createContextual(
		ctxt: DeserializationContext?,
		property: BeanProperty?,
	): JackJsonDeserializer<T> {
		return JackJsonDeserializer(property, jsonConverter)
	}
}
