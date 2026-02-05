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
 * CurrentFile BaseJsonStringConverter.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference

/**
 * 接口 [BaseJsonStringConverter] 定义了一个用于 JSON 字符串转换的基础接口。
 *
 * 该接口继承自 [BaseJsonConverter]，并指定泛型参数 [E] 和 [String]，
 * 表示将类型 [E] 转换为字符串类型的 JSON 数据。
 */
interface BaseJsonStringConverter<E> : BaseJsonConverter<E, String> {

    /**
     * 获取目标类型的引用信息。
     *
     * 该方法重写了父接口中的 [getToType] 方法，返回一个表示 [String] 类型的 [JsonTypeReference] 实例。
     * 此方法可能抛出异常，因此使用 [@Throws(Exception::class)] 注解标记。
     *
     * @return 返回一个 [JsonTypeReference] 实例，表示目标类型为 [String]。
     * @throws Exception 如果在获取类型引用时发生错误，则抛出此异常。
     */
    @Throws(Exception::class)
    override fun getToType() = JsonTypeReference.of<String>()
}
