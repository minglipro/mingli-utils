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
 * CurrentFile BaseJsonLongConverter.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference

/**
 * 接口 [BaseJsonLongConverter] 定义了一个用于将 JSON 数据转换为 Long 类型的转换器。
 *
 * 此接口继承自 [BaseJsonConverter]，并指定泛型参数 [E] 和 [Long]，
 * 表示该转换器处理的是从类型 [E] 到 [Long] 的转换。
 */
interface BaseJsonLongConverter<E> : BaseJsonConverter<E, Long> {

    /**
     * 获取目标类型的引用，用于标识此转换器的目标类型为 [Long]。
     *
     * @return 返回 [JsonTypeReference] 的实例，表示目标类型为 [Long]。
     * @throws Exception 如果在获取类型引用时发生异常，则抛出此异常。
     */
    @Throws(Exception::class)
    override fun getToType() = JsonTypeReference.of<Long>()
}
