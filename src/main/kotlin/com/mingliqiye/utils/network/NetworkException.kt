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
 * CurrentFile NetworkException.kt
 * LastUpdate 2026-02-05 10:20:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

class NetworkException : RuntimeException {
    /**
     * 构造一个带有指定详细消息的网络异常
     *
     * @param message 异常的详细消息
     */
    constructor(message: String?) : super(message)

    /**
     * 构造一个网络异常，指定原因异常
     *
     * @param e 导致此异常的原因异常
     */
    constructor(e: Exception?) : super(e)
}
