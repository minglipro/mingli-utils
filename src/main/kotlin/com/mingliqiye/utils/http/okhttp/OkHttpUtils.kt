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
 * CurrentFile OkHttpUtils.kt
 * LastUpdate 2026-10-22 20:20:42
 * UpdateUser MingLiPro
 */
@file:JvmName("OkHttpUtils")

package com.mingliqiye.utils.http.okhttp

import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.api.base.JsonApi.Companion.parse
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


inline fun <reified T> Response.json(jsonApi: JsonApi? = null): T = body.use {
    if (jsonApi != null) {
        return jsonApi.parse<T>(it.bytes())
    } else {
        JSONA.parse<T>(it.bytes())
    }
}

fun Response.text() = body.use {
    String(it.bytes())
}


fun newRequest(calld: Request.Builder.() -> Unit): Request {
    val request = Request.Builder()
    calld(request)
    return request.build()
}

fun OkHttpClient.newCall(calld: Request.Builder.() -> Unit): Call {
    return this.newCall(newRequest(calld))
}

fun OkHttpClient.newExecute(calld: Request.Builder.() -> Unit): Response {
    return this.newCall(newRequest(calld)).execute()
}
