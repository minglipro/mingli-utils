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

	/**
	 * 序列化：将对象转换并写入 JSON
	 *
	 * @param obj 待写入的对象，可能为null
	 * @param jsonWriter JSON写入器
	 * @param annotationGetter 注解获取器，用于读取字段上的格式注解
	 * @throws Exception 当写入失败时抛出
	 */
	@Throws(Exception::class)
	fun convert(obj: T?, jsonWriter: BaseJsonWriter, annotationGetter: AnnotationGetter)

	/**
	 * 反序列化：从 JSON 读取并还原对象
	 *
	 * @param jsonReader JSON读取器
	 * @param annotationGetter 注解获取器，用于读取字段上的格式注解
	 * @return 还原后的对象，JSON为null时返回null
	 * @throws Exception 当读取失败时抛出
	 */
	@Throws(Exception::class)
	fun deConvert(jsonReader: BaseJsonReader, annotationGetter: AnnotationGetter): T?

	/**
	 * 获取本转换器处理的目标类型引用
	 *
	 * @return 目标类型的JsonTypeReference
	 * @throws Exception 当获取类型失败时抛出
	 */
	@Throws(Exception::class)
	fun getType(): JsonTypeReference<T>

	/**
	 * 获取本转换器处理的目标类型的原始Class
	 *
	 * @return 目标类型的Class对象
	 */
	@Throws(Exception::class)
	fun getClazz() = getType().getRawType()
}
