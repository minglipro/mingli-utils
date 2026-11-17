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
 * LastUpdate 2026-11-17 20:10:50
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.reader.base.BaseJsonReader
import com.mingliqiye.utils.json.witer.base.BaseJsonWriter

/**
 * BaseJsonConverter 是一个通用的 JSON 转换器接口，用于定义对象之间的双向转换逻辑。
 *
 * @param F 源类型，表示需要被转换的对象类型。
 * @param T 目标类型，表示转换后的对象类型。
 */
interface BaseJsonConverter<T> {

	@Throws(Exception::class)
	fun convert(obj: T?, jsonWriter: BaseJsonWriter, annotationGetter: AnnotationGetter)

	@Throws(Exception::class)
	fun deConvert(jsonReader: BaseJsonReader, annotationGetter: AnnotationGetter): T?

	@Throws(Exception::class)
	fun getType(): JsonTypeReference<T>

	@Throws(Exception::class)
	fun getClazz() = getType().getRawType()
}
