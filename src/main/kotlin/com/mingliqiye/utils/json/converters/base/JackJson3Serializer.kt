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


/**
 * Jackson3 序列化适配器，将 [BaseJsonConverter] 包装为 Jackson3 的 [ValueSerializer]。
 *
 * @property property 当前属性信息，用于读取字段注解，可为null
 * @property jsonConverter 实际执行序列化逻辑的转换器
 */
class JackJson3Serializer<T>(
	val property: BeanProperty? = null,
	val jsonConverter: BaseJsonConverter<T>,
) : ValueSerializer<T>() {

	/**
	 * 注解获取器，从当前属性信息中读取字段注解
	 */
	val annotationGetter =
		object : AnnotationGetter {
			override fun <T : Annotation> getAnnotation(clazz: Class<T>): T? = property?.getAnnotation(clazz)
		}

	/**
	 * 序列化方法：将源对象交给转换器写入 JSON。
	 *
	 * @param value 源对象。
	 * @param gen JSON 生成器，用于写入 JSON 数据。
	 * @param ctxt 序列化上下文。
	 */
	override fun serialize(value: T, gen: JsonGenerator, ctxt: SerializationContext) {
		jsonConverter.convert(value, JackSon3JsonWriter(gen, ctxt), annotationGetter)
	}

	/**
	 * 上下文感知方法：设置当前属性信息。
	 *
	 * @param ctxt 序列化上下文，可选参数。
	 * @param property 当前属性信息。
	 * @return 携带属性信息的新序列化器实例。
	 */
	override fun createContextual(ctxt: SerializationContext?, property: BeanProperty?): ValueSerializer<*> {
		return JackJson3Serializer(property, jsonConverter)
	}
}
