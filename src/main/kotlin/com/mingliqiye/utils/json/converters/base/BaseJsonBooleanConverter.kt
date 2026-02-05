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
 * CurrentFile BaseJsonBooleanConverter.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference

/**
 * 接口 [BaseJsonBooleanConverter] 定义了一个用于处理布尔类型 JSON 转换的基础转换器。
 *
 * 该接口继承自 [BaseJsonConverter]，并专门用于将某种类型 [E] 转换为布尔类型 [Boolean]。
 * 实现该接口的类需要提供具体的转换逻辑。
 */
interface BaseJsonBooleanConverter<E> : BaseJsonConverter<E, Boolean> {

    /**
     * 获取目标类型的引用信息。
     *
     * 该方法返回一个 [JsonTypeReference] 对象，表示目标类型为 [Boolean]。
     * 此方法重写了父接口中的定义，并通过 [JsonTypeReference.Companion.of] 方法获取布尔类型的引用。
     *
     * @return [JsonTypeReference<Boolean>] 表示布尔类型的引用。
     * @throws Exception 如果在获取类型引用时发生异常，则抛出此异常。
     */
    @Throws(Exception::class)
    override fun getToType() = JsonTypeReference.of<Boolean>()
}
