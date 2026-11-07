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
 * LastUpdate 2026-11-07 13:44:21
 * UpdateUser MingLiPro
 */
@file:JvmName("OkHttpUtils")

package com.mingliqiye.utils.http.okhttp

import com.mingliqiye.utils.http.MediaType
import com.mingliqiye.utils.http.okhttp
import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.api.base.JsonApi.Companion.parse
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * 将 OkHttp 的 [Response] 响应体解析为指定泛型类型的对象。
 *
 * 会读取并关闭响应体。未显式传入 [jsonApi] 时使用 [JSONA.jsonApi]。
 *
 * @param T 目标对象类型，由调用方通过 reified 推断
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 解析后的对象实例
 * @throws NullPointerException 未传入 [jsonApi] 且 [JSONA] 尚未注入实例时抛出
 */
inline fun <reified T> Response.json(jsonApi: JsonApi? = null): T = body.use {
	(jsonApi ?: JSONA.jsonApi).parse<T>(it.bytes())
}

/**
 * 读取 [Response] 响应体为字符串，并关闭响应体。
 *
 * 按响应 `Content-Type` 的 `charset` 解码，缺省 UTF-8；读取后响应体被关闭。
 *
 * @return 响应体内容字符串
 */
fun Response.text() = this.body.string()

/**
 * 创建一个 [Request]，通过 [calld] 配置 [Request.Builder]。
 *
 * @param calld 在 [Request.Builder] 上执行的配置块
 * @return 构建完成的 [Request]
 */
fun newRequest(calld: Request.Builder.() -> Unit): Request =
	Request.Builder().apply(calld).build()

/**
 * 使用当前 [OkHttpClient] 创建一个 [Call]，请求通过 [calld] 配置。
 *
 * 调用返回的 [Call] 的 `execute()` 或 `enqueue()` 才会真正发起请求。
 *
 * @param calld 在 [Request.Builder] 上执行的配置块
 * @return 未执行的 [Call]
 */
fun OkHttpClient.newCall(calld: Request.Builder.() -> Unit): Call {
	return this.newCall(newRequest(calld))
}

/**
 * 使用当前 [OkHttpClient] 同步执行一次请求，请求通过 [calld] 配置。
 *
 * 注意：在 Android 主线程调用会抛出 `NetworkOnMainThreadException`。
 *
 * @param calld 在 [Request.Builder] 上执行的配置块
 * @return 同步执行得到的 [Response]
 * @throws java.io.IOException 网络或 I/O 失败时抛出
 */
fun OkHttpClient.newExecute(calld: Request.Builder.() -> Unit): Response {
	return this.newCall(newRequest(calld)).execute()
}

/**
 * 在 [Request.Builder] 上设置 URL，并通过 [calld] 配置查询参数。
 *
 * 示例：
 * ```
 * Request.Builder().url("https://example.com/api") {
 *     addQueryParameter("page", "1")
 * }
 * ```
 *
 * @param url 基础 URL 字符串
 * @param calld 可选的 [HttpUrl.Builder] 配置块（如添加查询参数）；为 `null` 时直接使用 [url]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.url(
	url: String,
	calld: (HttpUrl.Builder.() -> Unit)? = null,
): Request.Builder {
	return if (calld != null) {
		this.url(url.toHttpUrl().newBuilder().apply { calld() }.build())
	} else {
		this.url(url.toHttpUrl())
	}
}

/**
 * 在 [Request.Builder] 上设置请求方法和字节数组请求体。
 *
 * @param method 请求方法
 * @param body 请求体字节数组
 * @param mediaType 可选的媒体类型；为 `null` 时不设置 Content-Type
 * @param offset 起始偏移量，默认 0
 * @param length 读取长度，默认从 [offset] 到 [body] 末尾
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.methodBody(
	method: Method,
	body: ByteArray,
	mediaType: MediaType? = null,
	offset: Int = 0,
	length: Int = body.size - offset,
): Request.Builder {
	require(offset >= 0 && length >= 0 && offset + length <= body.size) {
		"offset/length 越界: offset=$offset, length=$length, size=${body.size}"
	}
	return method(method.name, body.toRequestBody(mediaType?.okhttp(), offset, length))
}

/**
 * 在 [Request.Builder] 上设置请求方法，并将对象序列化为 JSON 作为请求体。
 *
 * @param method 请求方法
 * @param body 待序列化的对象
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.methodJsonBody(
	method: Method,
	body: Any,
	jsonApi: JsonApi? = null,
): Request.Builder = methodBody(
	method,
	(jsonApi ?: JSONA.jsonApi).formatBytes(body),
	MediaType.APPLICATION_JSON,
)

/**
 * 在 [Request.Builder] 上设置 GET 方法，并将对象序列化为 JSON 作为请求体。
 *
 * 注意：GET 请求携带请求体在 HTTP 语义中不常见，部分服务端可能忽略或拒绝。
 *
 * @param body 待序列化的对象
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.getJsonBody(
	body: Any,
	jsonApi: JsonApi? = null,
) = methodBody(
	Method.GET,
	(jsonApi ?: JSONA.jsonApi).formatBytes(body),
	MediaType.APPLICATION_JSON,
)

/**
 * 在 [Request.Builder] 上设置 POST 方法，并将对象序列化为 JSON 作为请求体。
 *
 * @param body 待序列化的对象
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.postJsonBody(
	body: Any,
	jsonApi: JsonApi? = null,
) = methodBody(
	Method.POST,
	(jsonApi ?: JSONA.jsonApi).formatBytes(body),
	MediaType.APPLICATION_JSON,
)

/**
 * 在 [Request.Builder] 上设置 PUT 方法，并将对象序列化为 JSON 作为请求体。
 *
 * @param body 待序列化的对象
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.putJsonBody(
	body: Any,
	jsonApi: JsonApi? = null,
) = methodBody(
	Method.PUT,
	(jsonApi ?: JSONA.jsonApi).formatBytes(body),
	MediaType.APPLICATION_JSON,
)

/**
 * 在 [Request.Builder] 上设置 DELETE 方法，并将对象序列化为 JSON 作为请求体。
 *
 * @param body 待序列化的对象
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.deleteJsonBody(
	body: Any,
	jsonApi: JsonApi? = null,
) = methodBody(
	Method.DELETE,
	(jsonApi ?: JSONA.jsonApi).formatBytes(body),
	MediaType.APPLICATION_JSON,
)

/**
 * 在 [Request.Builder] 上设置 HEAD 方法，并将对象序列化为 JSON 作为请求体。
 *
 * 注意：HEAD 请求通常不应携带请求体，部分服务端可能忽略或拒绝。
 *
 * @param body 待序列化的对象
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.headJsonBody(
	body: Any,
	jsonApi: JsonApi? = null,
) = methodBody(
	Method.HEAD,
	(jsonApi ?: JSONA.jsonApi).formatBytes(body),
	MediaType.APPLICATION_JSON,
)

/**
 * 在 [Request.Builder] 上设置 OPTIONS 方法，并将对象序列化为 JSON 作为请求体。
 *
 * @param body 待序列化的对象
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.optionsJsonBody(
	body: Any,
	jsonApi: JsonApi? = null,
) = methodBody(
	Method.OPTIONS,
	(jsonApi ?: JSONA.jsonApi).formatBytes(body),
	MediaType.APPLICATION_JSON,
)

/**
 * 在 [Request.Builder] 上设置 QUERY 方法，并将对象序列化为 JSON 作为请求体。
 *
 * QUERY 是 HTTP 扩展方法，需服务端支持。
 *
 * @param body 待序列化的对象
 * @param jsonApi 可选的 [JsonApi] 实例；为 `null` 时使用 [JSONA.jsonApi]
 * @return 当前 [Request.Builder]，便于链式调用
 */
fun Request.Builder.queryJsonBody(
	body: Any,
	jsonApi: JsonApi? = null,
) = methodBody(
	Method.QUERY,
	(jsonApi ?: JSONA.jsonApi).formatBytes(body),
	MediaType.APPLICATION_JSON,
)

/**
 * HTTP 请求方法枚举，供 [Request.Builder.methodBody] 等扩展使用。
 */
enum class Method {
	/** GET 方法。 */
	GET,

	/** POST 方法。 */
	POST,

	/** PUT 方法。 */
	PUT,

	/** DELETE 方法。 */
	DELETE,

	/** HEAD 方法。 */
	HEAD,

	/** OPTIONS 方法。 */
	OPTIONS,

	/** QUERY 方法（HTTP 扩展方法，需服务端支持）。 */
	QUERY,
}
