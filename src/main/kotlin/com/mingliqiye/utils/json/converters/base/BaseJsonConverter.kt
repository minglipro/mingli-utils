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
 * CurrentFile BaseJsonConverter.kt
 * LastUpdate 2026-02-05 11:16:12
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.ContextualDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.ContextualSerializer
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import java.math.BigDecimal
import java.math.BigInteger

/**
 * BaseJsonConverter 是一个通用的 JSON 转换器接口，用于定义对象之间的双向转换逻辑。
 *
 * @param F 源类型，表示需要被转换的对象类型。
 * @param T 目标类型，表示转换后的对象类型。
 */
interface BaseJsonConverter<F, T> {

    /**
     * 将源对象转换为目标对象。
     *
     * @param obj 源对象，可能为 null。
     * @param annotationGetter 注解获取器，用于获取字段上的注解信息。
     * @return 转换后的目标对象，可能为 null。
     * @throws Exception 转换过程中可能抛出的异常。
     */
    @Throws(Exception::class)
    fun convert(obj: F?, annotationGetter: AnnotationGetter): T?

    /**
     * 将目标对象反向转换为源对象。
     *
     * @param obj 目标对象，可能为 null。
     * @param annotationGetter 注解获取器，用于获取字段上的注解信息。
     * @return 反向转换后的源对象，可能为 null。
     * @throws Exception 转换过程中可能抛出的异常。
     */
    @Throws(Exception::class)
    fun deConvert(obj: T?, annotationGetter: AnnotationGetter): F?

    /**
     * 获取源类型的类型引用。
     *
     * @return 源类型的 JsonTypeReference 对象。
     * @throws Exception 获取过程中可能抛出的异常。
     */
    @Throws(Exception::class)
    fun getFromType(): JsonTypeReference<F>

    /**
     * 获取目标类型的类型引用。
     *
     * @return 目标类型的 JsonTypeReference 对象。
     * @throws Exception 获取过程中可能抛出的异常。
     */
    @Throws(Exception::class)
    fun getToType(): JsonTypeReference<T>

    /**
     * 获取源类型的原始类。
     *
     * @return 源类型的 Class 对象。
     * @throws Exception 获取过程中可能抛出的异常。
     */
    @Throws(Exception::class)
    fun getFromClass() = getFromType().getRawType()

    /**
     * 获取目标类型的原始类。
     *
     * @return 目标类型的 Class 对象。
     * @throws Exception 获取过程中可能抛出的异常。
     */
    @Throws(Exception::class)
    fun getToClass() = getToType().getRawType()

    /**
     * 创建并返回一个 Jackson 模块，该模块包含自定义的序列化器和反序列化器。
     *
     * @return 配置了自定义序列化器和反序列化器的 SimpleModule 对象。
     */
    fun getJacksonModule(): SimpleModule {
        // 创建一个 Jackson 模块，名称由源类型和目标类型组成
        val module = SimpleModule("${getFromClass().name}To${getToClass().name}")

        // 定义自定义序列化器
        val serializer = object : JsonSerializer<F>(), ContextualSerializer {
            var property: BeanProperty? = null

            /**
             * 序列化方法：将源对象转换为目标对象，并根据目标对象的类型写入 JSON。
             *
             * @param value 源对象，可能为 null。
             * @param gen JSON 生成器，用于写入 JSON 数据。
             * @param provider 序列化提供者，可选参数。
             */
            override fun serialize(
                value: F?,
                gen: JsonGenerator,
                provider: SerializerProvider?
            ) {
                // 执行转换逻辑
                val data: T? = convert(value, object : AnnotationGetter {
                    override fun <T : Annotation> get(clazz: Class<T>): T? = property?.getAnnotation(clazz)
                })

                // 根据目标对象的类型写入对应的 JSON 值
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

            /**
             * 上下文感知方法：设置当前属性信息。
             *
             * @param prov 序列化提供者，可选参数。
             * @param property 当前属性信息。
             * @return 返回当前序列化器实例。
             */
            override fun createContextual(
                prov: SerializerProvider?,
                property: BeanProperty?
            ): JsonSerializer<F> {
                this.property = property
                return this
            }
        }

        // 定义自定义反序列化器
        val deserializer = object : JsonDeserializer<F>(), ContextualDeserializer {
            /**
             * 反序列化方法：从 JSON 解析数据并转换回源对象。
             *
             * @param p JSON 解析器。
             * @param ctxt 反序列化上下文，可选参数。
             * @return 转换后的源对象，可能为 null。
             */
            override fun deserialize(
                p: JsonParser,
                ctxt: DeserializationContext?
            ): F? {
                // 处理 null 值情况
                if (p.currentToken == JsonToken.VALUE_NULL) return null

                // 执行反向转换逻辑
                return deConvert(p.readValueAs(getToClass()), object : AnnotationGetter {
                    override fun <T : Annotation> get(clazz: Class<T>): T? = property?.getAnnotation(clazz)
                })
            }

            var property: BeanProperty? = null

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
            ): JsonDeserializer<F> {
                this.property = property
                return this
            }
        }

        // 将自定义序列化器和反序列化器注册到模块中
        return module
            .addSerializer(getFromClass(), serializer)
            .addDeserializer(getFromClass(), deserializer)
    }
}
