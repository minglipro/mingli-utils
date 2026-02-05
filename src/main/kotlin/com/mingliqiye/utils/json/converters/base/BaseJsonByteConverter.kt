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
 * CurrentFile BaseJsonByteConverter.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference

/**
 * BaseJsonByteConverter 是一个接口，继承自 BaseJsonConverter，用于定义字节类型（Byte）的 JSON 转换器。
 *
 * 该接口的主要作用是提供一个标准的字节类型转换实现，并通过 getToType 方法返回目标类型的引用。
 *
 * @param E 泛型参数，表示需要转换的目标对象类型。
 */
interface BaseJsonByteConverter<E> : BaseJsonConverter<E, Byte> {
    /**
     * 获取目标类型的引用，用于标识转换的目标类型为 Byte。
     *
     * @return 返回 JsonTypeReference 类型的实例，表示目标类型为 Byte。
     * @throws Exception 如果在获取类型引用过程中发生异常，则抛出该异常。
     */
    @Throws(Exception::class)
    override fun getToType() = JsonTypeReference.of<Byte>()
}
