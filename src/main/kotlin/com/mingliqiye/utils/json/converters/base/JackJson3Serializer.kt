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
 * CurrentFile JackJson3Serializer.kt
 * LastUpdate 2026-11-17 19:51:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.witer.JackSon3JsonWriter
import tools.jackson.core.JsonGenerator
import tools.jackson.databind.BeanProperty
import tools.jackson.databind.SerializationContext
import tools.jackson.databind.ValueSerializer


class JackJson3Serializer<T>(
	val property: BeanProperty? = null,
	val jsonConverter: BaseJsonConverter<T>,
) : ValueSerializer<T>() {

	val annotationGetter =
		object : AnnotationGetter {
			override fun <T : Annotation> getAnnotation(clazz: Class<T>): T? = property?.getAnnotation(clazz)
		}

	override fun serialize(value: T, gen: JsonGenerator, ctxt: SerializationContext) {
		jsonConverter.convert(value, JackSon3JsonWriter(gen, ctxt), annotationGetter)
	}

	override fun createContextual(ctxt: SerializationContext?, property: BeanProperty?): ValueSerializer<*> {
		return JackJson3Serializer(property, jsonConverter)
	}
}
