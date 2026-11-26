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
 * CurrentFile FastJson2JsonConverterUtils.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */
@file:JvmName("FastJson2JsonConverterUtils")

package com.mingliqiye.utils.json.converters.base

import com.alibaba.fastjson2.JSONReader
import com.alibaba.fastjson2.JSONWriter
import com.alibaba.fastjson2.reader.ObjectReader
import com.alibaba.fastjson2.reader.ObjectReaderProvider
import com.alibaba.fastjson2.writer.ObjectWriter
import com.alibaba.fastjson2.writer.ObjectWriterProvider
import com.mingliqiye.utils.json.reader.FastJson2JsonReader
import com.mingliqiye.utils.json.witer.FastJson2JsonWriter
import java.lang.reflect.Type

/**
 * 将转换器注册到 Fastjson2 的写出/读取 provider。
 *
 * 注册后，Fastjson2 在遇到转换器目标类型时会分别调用
 * [FastJson2ConverterObjectWriter] 和 [FastJson2ConverterObjectReader]。
 *
 * 注意：Fastjson2 的 [ObjectWriter] 无法获取字段注解，因此与 Gson 适配器一样，
 * `@DateTimeJsonFormat` 等字段级注解不会生效。
 *
 * @param writerProvider Fastjson2 写出 provider
 * @param readerProvider Fastjson2 读取 provider
 */
fun <T> BaseJsonConverter<T>.registerToFastJson2(
	writerProvider: ObjectWriterProvider,
	readerProvider: ObjectReaderProvider,
) {
	writerProvider.register(getClazz(), FastJson2ConverterObjectWriter(this))
	readerProvider.register(getClazz(), FastJson2ConverterObjectReader(this))
}

/**
 * 将 [BaseJsonConverter] 适配为 Fastjson2 [ObjectWriter]。
 *
 * @param converter 实际转换器
 */
private class FastJson2ConverterObjectWriter<T>(
	private val converter: BaseJsonConverter<T>,
) : ObjectWriter<T> {

	/**
	 * Fastjson2 无法提供字段上下文，注解获取器返回 null。
	 */
	private val annotationGetter = object : AnnotationGetter {}

	@Suppress("UNCHECKED_CAST")
	override fun write(
		jsonWriter: JSONWriter,
		obj: Any?,
		fieldName: Any?,
		fieldType: Type?,
		features: Long,
	) {
		converter.convert(obj as T?, FastJson2JsonWriter(jsonWriter), annotationGetter)
	}
}

/**
 * 将 [BaseJsonConverter] 适配为 Fastjson2 [ObjectReader]。
 *
 * @param converter 实际转换器
 */
private class FastJson2ConverterObjectReader<T>(
	private val converter: BaseJsonConverter<T>,
) : ObjectReader<T> {

	/**
	 * Fastjson2 无法提供字段上下文，注解获取器返回 null。
	 */
	private val annotationGetter = object : AnnotationGetter {}

	override fun readObject(
		jsonReader: JSONReader,
		fieldType: Type?,
		fieldName: Any?,
		features: Long,
	): T? {
		return converter.deConvert(FastJson2JsonReader(jsonReader.readAny()), annotationGetter)
	}
}
