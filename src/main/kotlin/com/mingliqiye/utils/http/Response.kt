/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile Response.kt
 * LastUpdate 2025-09-15 09:04:05
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http

import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.Formatter

data class Response<T>(
    val time: String,
    var message: String,
    var data: T?,
    var statusCode: Int
) {

    companion object {
        @JvmStatic
        fun <T> ok(data: T): Response<T?> {
            return Response(DateTime.now().format(Formatter.STANDARD_DATETIME_MILLISECOUND7), "操作成功", data, 200)
        }

        @JvmStatic
        fun <T> ok(message: String): Response<T?> {
            return Response(DateTime.now().format(Formatter.STANDARD_DATETIME_MILLISECOUND7), message, null, 200)
        }
    }

    fun setMessage(message: String): Response<T> {
        this.message = message
        return this
    }

    fun setData(data: T): Response<T?> {
        this.data = data
        return ok(this.data)
            .setMessage(this.message)
            .setStatusCode(this.statusCode)
    }

    fun setStatusCode(statusCode: Int): Response<T> {
        this.statusCode = statusCode
        return this
    }
}
