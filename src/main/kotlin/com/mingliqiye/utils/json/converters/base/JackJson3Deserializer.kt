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
 * CurrentFile JackJson3Deserializer.kt
 * LastUpdate 2026-11-17 19:51:20
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.reader.JackSon3JsonReader
import tools.jackson.core.JsonParser
import tools.jackson.databind.BeanProperty
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.ValueDeserializer


class JackJson3Deserializer<T>(
	val property: BeanProperty? = null,
	val jsonConverter: BaseJsonConverter<T>,
) : ValueDeserializer<T>() {

	val annotationGetter =
		object : AnnotationGetter {
			override fun <T : Annotation> getAnnotation(clazz: Class<T>): T? = property?.getAnnotation(clazz)
		}

	override fun deserialize(
		p: JsonParser,
		ctxt: DeserializationContext?,
	): T? {
		return jsonConverter.deConvert(JackSon3JsonReader(p.readValueAsTree()), annotationGetter)
	}

	/**
	 * 上下文感知方法：设置当前属性信息。
	 *
	 * @param ctxt 反序列化上下文，可选参数。
	 * @param property 当前属性信息。
	 * @return 返回当前反序列化器实例。
	 */
	override fun createContextual(
		ctxt: DeserializationContext?,
		property: BeanProperty?,
	): JackJson3Deserializer<T> {
		return JackJson3Deserializer(property, jsonConverter)
	}


}
