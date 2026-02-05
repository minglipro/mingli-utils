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
 * CurrentFile Exceptions.kt
 * LastUpdate 2026-02-05 11:12:36
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http.exception

/**
 * 表示 HTTP 异常的基类，继承自 [RuntimeException]。
 *
 * @param statusCode HTTP 状态码
 * @param message 异常信息，默认为 null
 * @param cause 异常原因，默认为 null
 */
sealed class HttpException(
    open val statusCode: Int,
    override val message: String? = null,
    override val cause: Throwable? = null
) : RuntimeException(message, cause)

// 3xx - 重定向异常

/**
 * 表示 HTTP 300 Multiple Choices 异常。
 *
 * @param message 异常信息，默认为 "Multiple Choices"
 * @param cause 异常原因，默认为 null
 */
class MultipleChoicesException(
    override val message: String? = "Multiple Choices",
    override val cause: Throwable? = null,
) : HttpException(300, message, cause)

/**
 * 表示 HTTP 301 Moved Permanently 异常。
 *
 * @param message 异常信息，默认为 "Moved Permanently"
 * @param cause 异常原因，默认为 null
 */
class MovedPermanentlyException(
    override val message: String? = "Moved Permanently",
    override val cause: Throwable? = null,
) : HttpException(301, message, cause)

/**
 * 表示 HTTP 302 Found 异常。
 *
 * @param message 异常信息，默认为 "Found"
 * @param cause 异常原因，默认为 null
 */
class FoundException(
    override val message: String? = "Found",
    override val cause: Throwable? = null,
) : HttpException(302, message, cause)

/**
 * 表示 HTTP 303 See Other 异常。
 *
 * @param message 异常信息，默认为 "See Other"
 * @param cause 异常原因，默认为 null
 */
class SeeOtherException(
    override val message: String? = "See Other",
    override val cause: Throwable? = null,
) : HttpException(303, message, cause)

/**
 * 表示 HTTP 304 Not Modified 异常。
 *
 * @param message 异常信息，默认为 "Not Modified"
 * @param cause 异常原因，默认为 null
 */
class NotModifiedException(
    override val message: String? = "Not Modified",
    override val cause: Throwable? = null,
) : HttpException(304, message, cause)

/**
 * 表示 HTTP 305 Use Proxy 异常。
 *
 * @param message 异常信息，默认为 "Use Proxy"
 * @param cause 异常原因，默认为 null
 */
class UseProxyException(
    override val message: String? = "Use Proxy",
    override val cause: Throwable? = null,
) : HttpException(305, message, cause)

/**
 * 表示 HTTP 307 Temporary Redirect 异常。
 *
 * @param message 异常信息，默认为 "Temporary Redirect"
 * @param cause 异常原因，默认为 null
 */
class TemporaryRedirectException(
    override val message: String? = "Temporary Redirect",
    override val cause: Throwable? = null,
) : HttpException(307, message, cause)

// 4xx - 客户端错误异常

/**
 * 表示 HTTP 400 Bad Request 异常。
 *
 * @param message 异常信息，默认为 "Bad Request"
 * @param cause 异常原因，默认为 null
 */
class BadRequestException(
    override val message: String? = "Bad Request",
    override val cause: Throwable? = null,
) : HttpException(400, message, cause)

/**
 * 表示 HTTP 401 Unauthorized 异常。
 *
 * @param message 异常信息，默认为 "Unauthorized"
 * @param cause 异常原因，默认为 null
 */
class UnauthorizedException(
    override val message: String? = "Unauthorized",
    override val cause: Throwable? = null,
) : HttpException(401, message, cause)

/**
 * 表示 HTTP 402 Payment Required 异常。
 *
 * @param message 异常信息，默认为 "Payment Required"
 * @param cause 异常原因，默认为 null
 */
class PaymentRequiredException(
    override val message: String? = "Payment Required",
    override val cause: Throwable? = null,
) : HttpException(402, message, cause)

/**
 * 表示 HTTP 403 Forbidden 异常。
 *
 * @param message 异常信息，默认为 "Forbidden"
 * @param cause 异常原因，默认为 null
 */
class ForbiddenException(
    override val message: String? = "Forbidden",
    override val cause: Throwable? = null,
) : HttpException(403, message, cause)

/**
 * 表示 HTTP 404 Not Found 异常。
 *
 * @param message 异常信息，默认为 "Not Found"
 * @param cause 异常原因，默认为 null
 */
class NotFoundException(
    override val message: String? = "Not Found",
    override val cause: Throwable? = null,
) : HttpException(404, message, cause)

/**
 * 表示 HTTP 405 Method Not Allowed 异常。
 *
 * @param message 异常信息，默认为 "Method Not Allowed"
 * @param cause 异常原因，默认为 null
 */
class MethodNotAllowedException(
    override val message: String? = "Method Not Allowed",
    override val cause: Throwable? = null,
) : HttpException(405, message, cause)

/**
 * 表示 HTTP 406 Not Acceptable 异常。
 *
 * @param message 异常信息，默认为 "Not Acceptable"
 * @param cause 异常原因，默认为 null
 */
class NotAcceptableException(
    override val message: String? = "Not Acceptable",
    override val cause: Throwable? = null,
) : HttpException(406, message, cause)

/**
 * 表示 HTTP 407 Proxy Authentication Required 异常。
 *
 * @param message 异常信息，默认为 "Proxy Authentication Required"
 * @param cause 异常原因，默认为 null
 */
class ProxyAuthenticationRequiredException(
    override val message: String? = "Proxy Authentication Required",
    override val cause: Throwable? = null,
) : HttpException(407, message, cause)

/**
 * 表示 HTTP 408 Request Timeout 异常。
 *
 * @param message 异常信息，默认为 "Request Timeout"
 * @param cause 异常原因，默认为 null
 */
class RequestTimeoutException(
    override val message: String? = "Request Timeout",
    override val cause: Throwable? = null,
) : HttpException(408, message, cause)

/**
 * 表示 HTTP 409 Conflict 异常。
 *
 * @param message 异常信息，默认为 "Conflict"
 * @param cause 异常原因，默认为 null
 */
class ConflictException(
    override val message: String? = "Conflict",
    override val cause: Throwable? = null,
) : HttpException(409, message, cause)

/**
 * 表示 HTTP 410 Gone 异常。
 *
 * @param message 异常信息，默认为 "Gone"
 * @param cause 异常原因，默认为 null
 */
class GoneException(
    override val message: String? = "Gone",
    override val cause: Throwable? = null,
) : HttpException(410, message, cause)

/**
 * 表示 HTTP 411 Length Required 异常。
 *
 * @param message 异常信息，默认为 "Length Required"
 * @param cause 异常原因，默认为 null
 */
class LengthRequiredException(
    override val message: String? = "Length Required",
    override val cause: Throwable? = null,
) : HttpException(411, message, cause)

/**
 * 表示 HTTP 412 Precondition Failed 异常。
 *
 * @param message 异常信息，默认为 "Precondition Failed"
 * @param cause 异常原因，默认为 null
 */
class PreconditionFailedException(
    override val message: String? = "Precondition Failed",
    override val cause: Throwable? = null,
) : HttpException(412, message, cause)

/**
 * 表示 HTTP 413 Request Entity Too Large 异常。
 *
 * @param message 异常信息，默认为 "Request Entity Too Large"
 * @param cause 异常原因，默认为 null
 */
class RequestEntityTooLargeException(
    override val message: String? = "Request Entity Too Large",
    override val cause: Throwable? = null,
) : HttpException(413, message, cause)

/**
 * 表示 HTTP 414 Request URI Too Large 异常。
 *
 * @param message 异常信息，默认为 "Request URI Too Large"
 * @param cause 异常原因，默认为 null
 */
class RequestUriTooLargeException(
    override val message: String? = "Request URI Too Large",
    override val cause: Throwable? = null,
) : HttpException(414, message, cause)

/**
 * 表示 HTTP 415 Unsupported Media Type 异常。
 *
 * @param message 异常信息，默认为 "Unsupported Media Type"
 * @param cause 异常原因，默认为 null
 */
class UnsupportedMediaTypeException(
    override val message: String? = "Unsupported Media Type",
    override val cause: Throwable? = null,
) : HttpException(415, message, cause)

/**
 * 表示 HTTP 416 Requested Range Not Satisfiable 异常。
 *
 * @param message 异常信息，默认为 "Requested Range Not Satisfiable"
 * @param cause 异常原因，默认为 null
 */
class RequestedRangeNotSatisfiableException(
    override val message: String? = "Requested Range Not Satisfiable",
    override val cause: Throwable? = null,
) : HttpException(416, message, cause)

// 5xx - 服务器错误异常

/**
 * 表示 HTTP 500 Internal Server Error 异常。
 *
 * @param message 异常信息，默认为 "Internal Server Error"
 * @param cause 异常原因，默认为 null
 */
class InternalServerErrorException(
    override val message: String? = "Internal Server Error",
    override val cause: Throwable? = null,
) : HttpException(500, message, cause)

/**
 * 表示 HTTP 501 Not Implemented 异常。
 *
 * @param message 异常信息，默认为 "Not Implemented"
 * @param cause 异常原因，默认为 null
 */
class NotImplementedException(
    override val message: String? = "Not Implemented",
    override val cause: Throwable? = null,
) : HttpException(501, message, cause)

/**
 * 表示 HTTP 502 Bad Gateway 异常。
 *
 * @param message 异常信息，默认为 "Bad Gateway"
 * @param cause 异常原因，默认为 null
 */
class BadGatewayException(
    override val message: String? = "Bad Gateway",
    override val cause: Throwable? = null,
) : HttpException(502, message, cause)

/**
 * 表示 HTTP 503 Service Unavailable 异常。
 *
 * @param message 异常信息，默认为 "Service Unavailable"
 * @param cause 异常原因，默认为 null
 */
class ServiceUnavailableException(
    override val message: String? = "Service Unavailable",
    override val cause: Throwable? = null,
) : HttpException(503, message, cause)

/**
 * 表示 HTTP 504 Gateway Timeout 异常。
 *
 * @param message 异常信息，默认为 "Gateway Timeout"
 * @param cause 异常原因，默认为 null
 */
class GatewayTimeoutException(
    override val message: String? = "Gateway Timeout",
    override val cause: Throwable? = null,
) : HttpException(504, message, cause)

/**
 * 表示 HTTP 505 HTTP Version Not Supported 异常。
 *
 * @param message 异常信息，默认为 "HTTP Version Not Supported"
 * @param cause 异常原因，默认为 null
 */
class HttpVersionNotSupportedException(
    override val message: String? = "HTTP Version Not Supported",
    override val cause: Throwable? = null,
) : HttpException(505, message, cause)
