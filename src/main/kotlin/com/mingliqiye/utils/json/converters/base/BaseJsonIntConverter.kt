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
 * CurrentFile BaseJsonIntConverter.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference

/**
 * 接口 [BaseJsonIntConverter] 是一个泛型接口，继承自 [BaseJsonConverter]，
 * 用于定义将 JSON 数据转换为 [Int] 类型的转换器。
 *
 * @param E 表示需要转换的目标类型，通常是一个具体的业务实体或数据模型。
 */
interface BaseJsonIntConverter<E> : BaseJsonConverter<E, Int> {

    /**
     * 获取目标类型的引用信息。
     *
     * 该方法重写了父接口中的 [getToType] 方法，返回 [Int] 类型的 [JsonTypeReference] 实例。
     * 用于标识当前转换器的目标类型为 [Int]。
     *
     * @return 返回 [JsonTypeReference] 的实例，表示目标类型为 [Int]。
     * @throws Exception 如果在获取类型引用时发生异常，则抛出该异常。
     */
    @Throws(Exception::class)
    override fun getToType() = JsonTypeReference.of<Int>()
}
