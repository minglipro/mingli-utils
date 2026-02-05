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
 * CurrentFile BaseJsonBigDecimalConverter.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference
import java.math.BigDecimal

/**
 * 接口 [BaseJsonBigDecimalConverter] 定义了一个用于将 JSON 数据转换为 [BigDecimal] 类型的转换器。
 *
 * 此接口继承自 [BaseJsonConverter]，并指定目标类型为 [BigDecimal]。
 * 实现此接口的类需要提供具体的转换逻辑。
 *
 * @param E 转换器处理的源数据类型。
 */
interface BaseJsonBigDecimalConverter<E> : BaseJsonConverter<E, BigDecimal> {

    /**
     * 获取目标类型的引用信息。
     *
     * 该方法返回一个 [JsonTypeReference] 对象，表示目标类型为 [BigDecimal]。
     * 通过调用 [JsonTypeReference.Companion.of] 方法创建类型引用。
     *
     * @return 目标类型 [BigDecimal] 的类型引用。
     * @throws Exception 如果在获取类型引用时发生异常。
     */
    @Throws(Exception::class)
    override fun getToType() = JsonTypeReference.of<BigDecimal>()
}
