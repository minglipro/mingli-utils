/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile JsonStringConverter.kt
 * LastUpdate 2025-09-15 11:03:53
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters

import com.alibaba.fastjson2.JSONReader
import com.alibaba.fastjson2.JSONWriter
import com.alibaba.fastjson2.reader.ObjectReader
import com.alibaba.fastjson2.writer.ObjectWriter
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.module.SimpleModule
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.DateTime.Companion.parse
import com.mingliqiye.utils.time.Formatter
import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.UUID.Companion.of
import java.io.IOException
import java.lang.reflect.Type

/**
 * JSON转换器接口，提供对象与字符串之间的相互转换功能，并支持多种JSON库
 *
 * @param <T> 需要转换的对象类型
</T> */
abstract class JsonStringConverter<T> : JsonConverter<T, String> {
    val fastjsonJsonStringConverterAdapter: FastjsonJsonStringConverterAdapter<JsonStringConverter<T>, T>
        /**
         * 获取 Fastjson 的适配器
         * @return 适配器实例
         */
        get() = FastjsonJsonStringConverterAdapter.of(this)

    val gsonJsonStringConverterAdapter: GsonJsonStringConverterAdapter<JsonStringConverter<T>, T>
        /**
         * 获取 Gson 的适配器
         * @return 适配器实例
         */
        get() = GsonJsonStringConverterAdapter.of(this)

    val jacksonJsonStringConverterAdapter: JacksonJsonStringConverterAdapter<JsonStringConverter<T>, T>
        /**
         * 获取 Jackson 的适配器
         * @return 适配器实例
         */
        get() = JacksonJsonStringConverterAdapter.of(this)
}


class JacksonJsonStringConverterAdapter<T : JsonStringConverter<TT>, TT
        > private constructor(val jsonStringConverter: T) {

    val jacksonJsonDeserializer: JsonDeserializer<TT?>
        /**
         * 获取Jackson反序列化器
         *
         * @return Jackson的JsonDeserializer实例
         */
        get() = object : JsonDeserializer<TT?>() {
            @Throws(IOException::class)
            override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): TT? {
                if (p.isNaN) return null
                return jsonStringConverter.deConvert(p.valueAsString)
            }
        }

    val jacksonJsonSerializer: JsonSerializer<TT?>
        /**
         * 获取Jackson序列化器
         *
         * @return Jackson的JsonSerializer实例
         */
        get() = object : JsonSerializer<TT?>() {
            @Throws(IOException::class)
            override fun serialize(
                value: TT?,
                gen: JsonGenerator,
                serializers: SerializerProvider?
            ) {
                if (value == null) {
                    gen.writeNull()
                    return
                }
                gen.writeString(jsonStringConverter.convert(value))
            }
        }

    val jacksonModule: Module
        /**
         *
         * 获取 Jackson 的格式化模块
         *
         * @return 格式化模块
         */
        get() {
            val tClass = jsonStringConverter.tClass
            val m = SimpleModule(tClass.getSimpleName())
            m.addSerializer<TT?>(tClass, this.jacksonJsonSerializer)
            m.addDeserializer<TT?>(tClass, this.jacksonJsonDeserializer)
            return m
        }

    companion object {
        /**
         *
         * @param t JSON转换器实例
         * @return JSON转换器的适配器
         * @param <T> JSON转换器
         * @param <TT> JSON转换器的泛型
         **/
        fun <T : JsonStringConverter<TT>, TT
                > of(t: T): JacksonJsonStringConverterAdapter<T, TT> {
            return JacksonJsonStringConverterAdapter(t)
        }
    }
}

class GsonJsonStringConverterAdapter<T : JsonStringConverter<TT>, TT
        >(val jsonStringConverter: T) {

    val gsonTypeAdapter: TypeAdapter<TT?>
        /**
         * 获取Gson类型适配器
         *
         * @return Gson的TypeAdapter实例
         */
        get() = object : TypeAdapter<TT?>() {
            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: TT?) {
                if (value == null) {
                    out.nullValue()
                    return
                }
                out.value(jsonStringConverter.convert(value))
            }

            @Throws(IOException::class)
            override fun read(`in`: JsonReader): TT? {
                val value = `in`.nextString()
                return jsonStringConverter.deConvert(value)
            }
        }

    companion object {
        fun <T : JsonStringConverter<TT>, TT
                > of(t: T): GsonJsonStringConverterAdapter<T, TT> {
            return GsonJsonStringConverterAdapter(t)
        }
    }
}

class FastjsonJsonStringConverterAdapter<T : JsonConverter<TT, String>, TT
        >(val jsonStringConverter: T) {
    @Suppress("UNCHECKED_CAST")
    val fastJsonObjectWriter: ObjectWriter<T>
        /**
         * 获取FastJson对象写入器
         *
         * @return FastJson的ObjectWriter实例
         */
        get() = ObjectWriter { writer: JSONWriter?, obj: Any?, _: Any?, _: Type?, _: Long
            ->
            // 如果对象为null则写入null
            if (obj == null) {
                writer!!.writeNull()
                return@ObjectWriter
            }
            writer!!.writeString(jsonStringConverter.convert(obj as TT))
        }

    val fastJsonObjectReader: ObjectReader<TT>
        /**
         * 获取FastJson对象读取器
         *
         * @return FastJson的ObjectReader实例
         */
        get() = ObjectReader { reader: JSONReader?, _: Type?, _: Any?, _: Long
            ->
            val value = reader!!.readString()
            jsonStringConverter.deConvert(value)
        }

    companion object {
        fun <T : JsonConverter<TT, String>, TT
                > of(t: T): FastjsonJsonStringConverterAdapter<T, TT> {
            return FastjsonJsonStringConverterAdapter(t)
        }
    }
}


class DateTimeJsonConverter : JsonStringConverter<DateTime>() {
    override val tClass = DateTime::class.java

    override fun convert(obj: DateTime?): String? {
        if (obj == null) {
            return null
        }
        return obj.format(Formatter.STANDARD_DATETIME)
    }

    override fun deConvert(obj: String?): DateTime? {
        if (obj == null) {
            return null
        }
        return parse(
            obj,
            Formatter.STANDARD_DATETIME_MILLISECOUND7,
            true
        )
    }
}

class UUIDJsonStringConverter : JsonStringConverter<UUID>() {
    override val tClass: Class<UUID> = UUID::class.java

    override fun convert(obj: UUID?): String? {
        if (obj == null) {
            return null
        }
        return obj.getString()
    }

    override fun deConvert(obj: String?): UUID? {
        if (obj == null) {
            return null
        }
        return of(obj)
    }

}
