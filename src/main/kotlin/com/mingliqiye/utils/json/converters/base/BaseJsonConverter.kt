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
 * LastUpdate 2026-02-08 01:22:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

/**
 * BaseJsonConverter 是一个泛型接口，用于定义 JSON 转换器的基本行为。
 *
 * 该接口继承自 JackSonJsonConverter，并通过泛型参数 F 和 T 定义了转换的源类型和目标类型。
 * 实现该接口的类需要提供具体的 JSON 转换逻辑。
 *
 * @param F 源类型，表示需要被转换的数据类型。
 * @param T 目标类型，表示转换后的数据类型。
 */
interface BaseJsonConverter<F, T> : JackSonJsonConverter<F, T>
