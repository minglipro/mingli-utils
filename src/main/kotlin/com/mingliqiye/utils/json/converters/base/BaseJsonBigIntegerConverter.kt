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
 * CurrentFile BaseJsonBigIntegerConverter.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference
import java.math.BigInteger

/**
 * 接口 [BaseJsonBigIntegerConverter] 定义了一个用于将 JSON 数据转换为 `BigInteger` 类型的转换器。
 * 该接口继承自 [BaseJsonConverter]，并指定了泛型参数 [E] 和 `BigInteger`。
 *
 * @param E 表示需要转换的目标类型，由实现类具体指定。
 */
interface BaseJsonBigIntegerConverter<E> : BaseJsonConverter<E, BigInteger> {

    /**
     * 获取目标类型的引用，用于 JSON 反序列化时确定目标类型。
     * 该方法重写了父接口中的 [getToType] 方法，并返回 `BigInteger` 类型的引用。
     *
     * @return 返回 [JsonTypeReference] 对象，表示 `BigInteger` 类型的引用。
     * @throws Exception 如果在获取类型引用过程中发生异常，则抛出该异常。
     */
    @Throws(Exception::class)
    override fun getToType() = JsonTypeReference.of<BigInteger>()
}
