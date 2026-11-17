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


/**
 * Jackson3 反序列化适配器，将 [BaseJsonConverter] 包装为 Jackson3 的 [ValueDeserializer]。
 *
 * @property property 当前属性信息，用于读取字段注解，可为null
 * @property jsonConverter 实际执行反序列化逻辑的转换器
 */
class JackJson3Deserializer<T>(
	val property: BeanProperty? = null,
	val jsonConverter: BaseJsonConverter<T>,
) : ValueDeserializer<T>() {

	/**
	 * 注解获取器，从当前属性信息中读取字段注解
	 */
	val annotationGetter =
		object : AnnotationGetter {
			override fun <T : Annotation> getAnnotation(clazz: Class<T>): T? = property?.getAnnotation(clazz)
		}

	/**
	 * 反序列化方法：将 JSON 树交给转换器还原为目标对象。
	 *
	 * @param p JSON 解析器。
	 * @param ctxt 反序列化上下文，可选参数。
	 * @return 还原后的对象，可能为null。
	 */
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
