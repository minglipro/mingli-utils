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
 * CurrentFile JsonConverterUtils.kt
 * LastUpdate 2026-11-17 20:11:04
 * UpdateUser MingLiPro
 */
@file:JvmName("JsonConverterUtils")

package com.mingliqiye.utils.json.converters.base


import java.math.BigDecimal
import java.math.BigInteger
import com.fasterxml.jackson.core.JsonGenerator as JackSon2JsonGenerator
import com.fasterxml.jackson.databind.module.SimpleModule as JackSon2SimpleModule
import tools.jackson.core.JsonGenerator as JackSon3JsonGenerator
import tools.jackson.databind.module.SimpleModule as JackSon3SimpleModule


/**
 * 将转换器包装为 Jackson2 的 SimpleModule，注册对应的序列化器与反序列化器。
 *
 * @return 注册了当前转换器的 Jackson2 模块
 */
fun <T> BaseJsonConverter<T>.getJacksonModule(): JackSon2SimpleModule =
	JackSon2SimpleModule("${getClazz().simpleName}Module")
		.addSerializer(getClazz(), JackJsonSerializer(null, this))
		.addDeserializer(getClazz(), JackJsonDeserializer(null, this))

/**
 * 将转换器包装为 Jackson3 的 SimpleModule，注册对应的序列化器与反序列化器。
 *
 * @return 注册了当前转换器的 Jackson3 模块
 */
fun <T> BaseJsonConverter<T>.getJackson3Module(): JackSon3SimpleModule =
	JackSon3SimpleModule("${getClazz().simpleName}Module")
		.addSerializer(getClazz(), JackJson3Serializer(null, this))
		.addDeserializer(getClazz(), JackJson3Deserializer(null, this))


/**
 * 根据 reified 泛型参数获取指定类型的注解。
 *
 * @param T 注解类型
 * @return 注解实例，不存在时返回null
 */
inline fun <reified T : Annotation> AnnotationGetter.getAnnotation(): T? =
	getAnnotation(T::class.java)


/**
 * 按数值的实际类型写入 JSON 数字（Jackson3），支持常见数值类型。
 *
 * @param value 待写入的数值
 * @return 当前 JsonGenerator 实例，便于链式调用
 */
fun JackSon3JsonGenerator.writeNumber(value: Number): JackSon3JsonGenerator {
	when (value) {
		is Long -> this.writeNumber(value)
		is Short -> this.writeNumber(value)
		is Byte -> this.writeNumber(value.toShort())
		is Int -> this.writeNumber(value)
		is BigDecimal -> this.writeNumber(value)
		is BigInteger -> this.writeNumber(value)
		is Float -> this.writeNumber(value)
		is Double -> this.writeNumber(value)
	}
	return this
}

/**
 * 按数值的实际类型写入 JSON 数字（Jackson2），支持常见数值类型。
 *
 * @param value 待写入的数值
 * @return 当前 JsonGenerator 实例，便于链式调用
 */
fun JackSon2JsonGenerator.writeNumber(value: Number): JackSon2JsonGenerator {
	when (value) {
		is Long -> this.writeNumber(value)
		is Short -> this.writeNumber(value)
		is Byte -> this.writeNumber(value.toShort())
		is Int -> this.writeNumber(value)
		is BigDecimal -> this.writeNumber(value)
		is BigInteger -> this.writeNumber(value)
		is Float -> this.writeNumber(value)
		is Double -> this.writeNumber(value)
	}
	return this
}
