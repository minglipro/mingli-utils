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
 * CurrentFile JsonTypeException.kt
 * LastUpdate 2026-02-07 13:28:02
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.exception

class JsonTypeException : JsonException {
    constructor()
    constructor(message: String) : super(message)
    constructor(throwable: Throwable) : super(throwable)
    constructor(message: String, throwable: Throwable) : super(message, throwable)
    constructor(
        message: String? = null,
        throwable: Throwable? = null,
        enableSuppression: Boolean = false,
        writableStackTrace: Boolean = false
    ) : super(message, throwable, enableSuppression, writableStackTrace)
}
