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
 * CurrentFile NotAcceptableException.kt
 * LastUpdate 2026-02-05 14:55:04
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.exception

/**
 * 表示 HTTP 406 Not Acceptable 异常。
 *
 * @param message 异常信息，默认为 "Not Acceptable"
 * @param cause 异常原因，默认为 null
 */
class NotAcceptableException(
    override val message: String? = "Not Acceptable",
    override val cause: Throwable? = null,
) : HttpStatusException(406, message, cause)
