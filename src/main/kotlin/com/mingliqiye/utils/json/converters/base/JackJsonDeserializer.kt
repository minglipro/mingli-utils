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
 * LastUpdate 2026-02-08 02:22:46
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.deser.ContextualDeserializer

class JackJsonDeserializer<F, T>(
    val property: BeanProperty? = null,
    val jsonConverter: JsonConverter<F, T>
) : JsonDeserializer<F>(), ContextualDeserializer {
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext?
    ): F? {
        if (p.currentToken == JsonToken.VALUE_NULL) return null
        return jsonConverter.deConvert(p.readValueAs(jsonConverter.getToClass()), object : AnnotationGetter {
            override fun <T : Annotation> get(clazz: Class<T>): T? = property?.getAnnotation(clazz)
        })
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
        property: BeanProperty?
    ): JackJsonDeserializer<F, T> {
        return JackJsonDeserializer(property, jsonConverter)
    }
}
