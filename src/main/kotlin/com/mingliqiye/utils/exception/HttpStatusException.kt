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
 * CurrentFile HttpStatusException.kt
 * LastUpdate 2026-10-11 17:02:06
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.exception

/**
 * 表示 HTTP 异常的基类，继承自 [RuntimeException]。
 *
 * @param statusCode HTTP 状态码
 * @param message 异常信息，默认为 null
 * @param cause 异常原因，默认为 null
 */
open class HttpStatusException @JvmOverloads constructor(
    val statusCode: Int,
    message: String? = null,
    throwable: Throwable? = null,
    enableSuppression: Boolean = false,
    writableStackTrace: Boolean = true,
) : MingLiUtilsBaseException(message, throwable, enableSuppression, writableStackTrace)
