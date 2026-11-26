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
 * CurrentFile GsonJsonConverterUtils.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */
@file:JvmName("GsonJsonConverterUtils")

package com.mingliqiye.utils.json.converters.base

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader as GsonStreamReader
import com.google.gson.stream.JsonWriter as GsonStreamWriter
import com.mingliqiye.utils.json.reader.GsonJsonReader
import com.mingliqiye.utils.json.witer.GsonJsonWriter

/**
 * 将转换器包装为 Gson 的 [TypeAdapterFactory]。
 *
 * 注册到 [GsonBuilder] 后，目标类型的序列化/反序列化会委托给当前转换器。
 *
 * ### 字段注解限制
 * Gson 的 [TypeAdapter] 无法获取所属字段的注解，因此这里的 [AnnotationGetter]
 * 始终返回 `null`。`@DateTimeJsonFormat`、`@UUIDJsonFormat` 等字段级注解
 * 不会生效；需要注解驱动转换时应使用 Jackson 实现。
 *
 * @return 适配当前转换器目标类型的 Gson 工厂
 */
fun <T> BaseJsonConverter<T>.getGsonTypeAdapterFactory(): TypeAdapterFactory =
	GsonConverterTypeAdapterFactory(this)

/**
 * 将转换器注册到 [GsonBuilder]。
 *
 * @param builder 目标 Gson 构建器
 * @return 当前构建器，便于链式调用
 */
fun <T> BaseJsonConverter<T>.registerToGson(builder: GsonBuilder): GsonBuilder =
	builder.registerTypeAdapterFactory(getGsonTypeAdapterFactory())

/**
 * 将 [BaseJsonConverter] 适配为 Gson [TypeAdapterFactory]。
 *
 * @param converter 实际转换器
 */
private class GsonConverterTypeAdapterFactory<T>(
	private val converter: BaseJsonConverter<T>,
) : TypeAdapterFactory {
	override fun <R> create(gson: Gson, type: TypeToken<R>): TypeAdapter<R>? {
		if (type.rawType != converter.getClazz()) {
			return null
		}
		@Suppress("UNCHECKED_CAST")
		return GsonConverterTypeAdapter(gson, converter) as TypeAdapter<R>
	}
}

/**
 * 将 [BaseJsonConverter] 适配为 Gson [TypeAdapter]。
 *
 * @param gson 当前 Gson 实例，用于读取 JSON 树
 * @param converter 实际转换器
 */
private class GsonConverterTypeAdapter<T>(
	private val gson: Gson,
	private val converter: BaseJsonConverter<T>,
) : TypeAdapter<T>() {

	/**
	 * Gson 无法提供字段上下文，因此注解获取器始终返回 null。
	 */
	private val annotationGetter = object : AnnotationGetter {}

	override fun write(out: GsonStreamWriter, value: T?) {
		converter.convert(value, GsonJsonWriter(out), annotationGetter)
	}

	override fun read(input: GsonStreamReader): T? {
		val element: JsonElement = gson.fromJson(input, JsonElement::class.java) ?: JsonNull.INSTANCE
		return converter.deConvert(GsonJsonReader(element), annotationGetter)
	}
}
