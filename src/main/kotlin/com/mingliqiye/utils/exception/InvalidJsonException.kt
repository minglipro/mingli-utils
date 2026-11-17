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
 * CurrentFile InvalidJsonException.kt
 * LastUpdate 2026-10-11 16:53:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.exception

/**
 * 表示 JSON 内容无效或不合法时抛出的异常。
 *
 * @param message 异常信息，默认为 null
 * @param throwable 异常原因，默认为 null
 * @param enableSuppression 是否启用异常抑制，默认为 false
 * @param writableStackTrace 是否可写入堆栈跟踪信息，默认为 true
 */
class InvalidJsonException @JvmOverloads constructor(
	message: String? = null,
	throwable: Throwable? = null,
	enableSuppression: Boolean = false,
	writableStackTrace: Boolean = true,
) : JsonException(message, throwable, enableSuppression, writableStackTrace)
