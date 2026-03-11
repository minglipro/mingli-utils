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
 * LastUpdate 2026-02-26 13:04:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import tools.jackson.databind.BeanProperty
import tools.jackson.databind.SerializationContext
import tools.jackson.databind.ValueSerializer
import java.math.BigDecimal
import java.math.BigInteger

class JackJson3Serializer<F, T>(
    val property: BeanProperty? = null,
    val jsonConverter: JsonConverter<F, T>
) : ValueSerializer<F>() {

    /**
     * 序列化方法：将源对象转换为目标对象，并根据目标对象的类型写入 JSON。
     *
     * @param value 源对象，可能为 null。
     * @param gen JSON 生成器，用于写入 JSON 数据。
     * @param provider 序列化提供者，可选参数。
     */
    override fun serialize(value: F, gen: tools.jackson.core.JsonGenerator, ctxt: SerializationContext) {
        val data: T? = jsonConverter.convert(value, object : AnnotationGetter {
            override fun <T : Annotation> get(clazz: Class<T>): T? = property?.getAnnotation(clazz)
        })
        when (data) {
            null -> gen.writeNull()
            is String -> gen.writeString(data)
            is Long -> gen.writeNumber(data)
            is Short -> gen.writeNumber(data)
            is Byte -> gen.writeNumber(data.toShort())
            is Int -> gen.writeNumber(data)
            is BigDecimal -> gen.writeNumber(data)
            is BigInteger -> gen.writeNumber(data)
            is Float -> gen.writeNumber(data)
            is Double -> gen.writeNumber(data)
            is Boolean -> gen.writeBoolean(data)
            else -> throw IllegalArgumentException("not sport data type ${data.javaClass} $data")
        }
    }

    override fun createContextual(ctxt: SerializationContext?, property: BeanProperty?): ValueSerializer<*> {
        return JackJson3Serializer(property, jsonConverter)
    }
}
