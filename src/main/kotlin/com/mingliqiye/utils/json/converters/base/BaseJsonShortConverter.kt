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
 * CurrentFile BaseJsonShortConverter.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference

/**
 * 接口 [BaseJsonShortConverter] 定义了一个用于将 JSON 数据转换为 Short 类型的转换器。
 *
 * 该接口继承自 [BaseJsonConverter]，并指定泛型参数 [E] 和 [Short]，
 * 表示该转换器处理的源类型为 [E]，目标类型为 [Short]。
 */
interface BaseJsonShortConverter<E> : BaseJsonConverter<E, Short> {

    /**
     * 获取目标类型的引用信息。
     *
     * 该方法重写了父接口中的 [getToType] 方法，返回 [Short] 类型的 [JsonTypeReference] 实例。
     * 通过 [JsonTypeReference.Companion.of] 方法创建类型引用。
     *
     * @return [JsonTypeReference] 表示 [Short] 类型的引用。
     * @throws Exception 如果在获取类型引用过程中发生异常，则抛出该异常。
     */
    @Throws(Exception::class)
    override fun getToType() = JsonTypeReference.of<Short>()
}
