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


fun <T> BaseJsonConverter<T>.getJacksonModule(): JackSon2SimpleModule =
	JackSon2SimpleModule("${getClazz().simpleName}Module")
		.addSerializer(getClazz(), JackJsonSerializer(null, this))
		.addDeserializer(getClazz(), JackJsonDeserializer(null, this))

fun <T> BaseJsonConverter<T>.getJackson3Module(): JackSon3SimpleModule =
	JackSon3SimpleModule("${getClazz().simpleName}Module")
		.addSerializer(getClazz(), JackJson3Serializer(null, this))
		.addDeserializer(getClazz(), JackJson3Deserializer(null, this))


inline fun <reified T : Annotation> AnnotationGetter.getAnnotation(): T? =
	getAnnotation(T::class.java)


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
