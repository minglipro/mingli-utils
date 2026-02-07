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
 * CurrentFile JsonConverter.kt
 * LastUpdate 2026-02-07 22:30:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference

/**
 * BaseJsonConverter 是一个通用的 JSON 转换器接口，用于定义对象之间的双向转换逻辑。
 *
 * @param F 源类型，表示需要被转换的对象类型。
 * @param T 目标类型，表示转换后的对象类型。
 */
interface JsonConverter<F, T> {
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
}
