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
 * LastUpdate 2026-02-27 22:16:15
 * UpdateUser MingLiPro
 */
@file:JvmName("OkHttpUtils")

package com.mingliqiye.utils.http.okhttp

import com.mingliqiye.utils.http.MediaType
import com.mingliqiye.utils.http.okhttp
import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.JSONA.toJson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response


inline fun <reified T> Response.json() = body.use {
    JSONA.parse<T>(it.bytes())
}

fun Response.text() = body.use {
    String(it.bytes())
}

fun OkHttpClient.request() = Request.Builder()
fun Request.Builder.call(okHttpClient: OkHttpClient) = okHttpClient.newCall(this.build())

fun Request.Builder.postWithJson(data: Any): Request.Builder {
    data.toJson().toRequestBody(MediaType.APPLICATION_JSON.okhttp())
    return this
}
