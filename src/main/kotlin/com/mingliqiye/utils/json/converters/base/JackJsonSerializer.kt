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
 * CurrentFile JackJsonSerializer.kt
 * LastUpdate 2026-11-17 19:54:12
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.ContextualSerializer
import com.mingliqiye.utils.json.witer.JackSonJsonWriter

class JackJsonSerializer<T>(
	val property: BeanProperty?,
	val jsonConverter: BaseJsonConverter<T>,
) : JsonSerializer<T>(), ContextualSerializer {

	val annotationGetter = object : AnnotationGetter {
		override fun <T : Annotation> getAnnotation(clazz: Class<T>): T? = property?.getAnnotation(clazz)
	}

	/**
	 * 序列化方法：将源对象转换为目标对象，并根据目标对象的类型写入 JSON。
	 *
	 * @param value 源对象，可能为 null。
	 * @param gen JSON 生成器，用于写入 JSON 数据。
	 * @param provider 序列化提供者，可选参数。
	 */
	override fun serialize(
		value: T?,
		gen: JsonGenerator,
		provider: SerializerProvider?,
	) {
		jsonConverter.convert(value, JackSonJsonWriter(gen, provider), annotationGetter)
	}

	/**
	 * 上下文感知方法：设置当前属性信息。
	 *
	 * @param prov 序列化提供者，可选参数。
	 * @param property 当前属性信息。
	 * @return 返回当前序列化器实例。
	 */
	override fun createContextual(
		prov: SerializerProvider?,
		property: BeanProperty?,
	): JsonSerializer<T> {
		return JackJsonSerializer(property, this.jsonConverter)
	}
}
