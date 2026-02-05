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
 * CurrentFile JsonException.kt
 * LastUpdate 2026-02-05 11:12:36
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api.exception

/**
 * 自定义异常类，用于处理 JSON 相关操作中出现的错误。
 *
 * 该类继承自 [RuntimeException]，提供了三种构造函数以支持不同的异常场景：
 * 1. 仅包含错误信息的构造函数。
 * 2. 包含错误信息和原因（Throwable）的构造函数。
 * 3. 仅包含原因（Throwable）的构造函数。
 */
class JsonException : RuntimeException {

    /**
     * 构造函数：创建一个带有指定错误信息的 [JsonException] 实例。
     *
     * @param message 错误信息描述。
     */
    constructor(message: String) : super(message)

    /**
     * 构造函数：创建一个带有指定错误信息和原因的 [JsonException] 实例。
     *
     * @param message 错误信息描述。
     * @param cause 导致此异常的根本原因。
     */
    constructor(message: String, cause: Throwable) : super(message, cause)

    /**
     * 构造函数：创建一个由指定原因引发的 [JsonException] 实例。
     *
     * @param cause 导致此异常的根本原因。
     */
    constructor(cause: Throwable) : super(cause)
}
