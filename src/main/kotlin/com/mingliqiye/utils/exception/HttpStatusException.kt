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
 * LastUpdate 2026-11-23 17:02:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.exception

import kotlin.reflect.KClass

/**
 * HTTP 状态异常基类，供所有携带状态码的异常继承。
 *
 * 子类在构造时固定 [statusCode]；调用方可以据此统一生成 HTTP 响应，
 * 而不必为每一种状态码单独判断异常类型。
 *
 * 构造函数标注了 `@JvmOverloads`，Java 侧可以按不同参数个数调用。
 *
 * @property statusCode HTTP 状态码
 * @param message 异常描述；为 `null` 时沿用父类行为
 * @param throwable 导致该异常的原始异常
 * @param enableSuppression 是否启用异常抑制
 * @param writableStackTrace 是否生成堆栈信息
 * @see MingLiUtilsBaseException
 */
open class HttpStatusException @JvmOverloads constructor(
	val statusCode: Int,
	message: String? = null,
	throwable: Throwable? = null,
	enableSuppression: Boolean = false,
	writableStackTrace: Boolean = true,
) : MingLiUtilsBaseException(message, throwable, enableSuppression, writableStackTrace)


/**
 * HTTP 状态异常类型枚举。
 *
 * 每个枚举项绑定一个 [HttpStatusException] 子类：可以用 [kClazz] / [clazz] 按类型查找，
 * 也可以用 [init] 按消息创建对应的异常实例。
 *
 * @property kClazz 异常类型的 Kotlin 类
 * @property init 使用给定消息创建异常的工厂函数
 */
enum class HttpStatusExceptionEnum(
	val kClazz: KClass<out HttpStatusException>,
	val init: (message: String?) -> HttpStatusException,
) {
	/** 502 Bad Gateway，对应 [BadGatewayException]。 */
	BAD_GATEWAY_EXCEPTION(BadGatewayException::class, ::BadGatewayException),

	/** 400 Bad Request，对应 [BadRequestException]。 */
	BAD_REQUEST_EXCEPTION(BadRequestException::class, ::BadRequestException),

	/** 409 Conflict，对应 [ConflictException]。 */
	CONFLICT_EXCEPTION(ConflictException::class, ::ConflictException),

	/** 403 Forbidden，对应 [ForbiddenException]。 */
	FORBIDDEN_EXCEPTION(ForbiddenException::class, ::ForbiddenException),

	/** 302 Found，对应 [FoundException]。 */
	FOUND_EXCEPTION(FoundException::class, ::FoundException),

	/** 504 Gateway Timeout，对应 [GatewayTimeoutException]。 */
	GATEWAY_TIMEOUT_EXCEPTION(GatewayTimeoutException::class, ::GatewayTimeoutException),

	/** 410 Gone，对应 [GoneException]。 */
	GONE_EXCEPTION(GoneException::class, ::GoneException),

	/** 505 HTTP Version Not Supported，对应 [HttpVersionNotSupportedException]。 */
	HTTP_VERSION_NOT_SUPPORTED_EXCEPTION(HttpVersionNotSupportedException::class, ::HttpVersionNotSupportedException),

	/** 500 Internal Server Error，对应 [InternalServerErrorException]。 */
	INTERNAL_SERVER_ERROR_EXCEPTION(InternalServerErrorException::class, ::InternalServerErrorException),

	/** 411 Length Required，对应 [LengthRequiredException]。 */
	LENGTH_REQUIRED_EXCEPTION(LengthRequiredException::class, ::LengthRequiredException),

	/** 405 Method Not Allowed，对应 [MethodNotAllowedException]。 */
	METHOD_NOT_ALLOWED_EXCEPTION(MethodNotAllowedException::class, ::MethodNotAllowedException),

	/** 301 Moved Permanently，对应 [MovedPermanentlyException]。 */
	MOVED_PERMANENTLY_EXCEPTION(MovedPermanentlyException::class, ::MovedPermanentlyException),

	/** 300 Multiple Choices，对应 [MultipleChoicesException]。 */
	MULTIPLE_CHOICES_EXCEPTION(MultipleChoicesException::class, ::MultipleChoicesException),

	/** 406 Not Acceptable，对应 [NotAcceptableException]。 */
	NOT_ACCEPTABLE_EXCEPTION(NotAcceptableException::class, ::NotAcceptableException),

	/** 404 Not Found，对应 [NotFoundException]。 */
	NOT_FOUND_EXCEPTION(NotFoundException::class, ::NotFoundException),

	/** 501 Not Implemented，对应 [NotImplementedException]。 */
	NOT_IMPLEMENTED_EXCEPTION(NotImplementedException::class, ::NotImplementedException),

	/** 304 Not Modified，对应 [NotModifiedException]。 */
	NOT_MODIFIED_EXCEPTION(NotModifiedException::class, ::NotModifiedException),

	/** 402 Payment Required，对应 [PaymentRequiredException]。 */
	PAYMENT_REQUIRED_EXCEPTION(PaymentRequiredException::class, ::PaymentRequiredException),

	/** 412 Precondition Failed，对应 [PreconditionFailedException]。 */
	PRECONDITION_FAILED_EXCEPTION(PreconditionFailedException::class, ::PreconditionFailedException),

	/** 407 Proxy Authentication Required，对应 [ProxyAuthenticationRequiredException]。 */
	PROXY_AUTHENTICATION_REQUIRED_EXCEPTION(
		ProxyAuthenticationRequiredException::class,
		::ProxyAuthenticationRequiredException
	),

	/** 416 Requested Range Not Satisfiable，对应 [RequestedRangeNotSatisfiableException]。 */
	REQUESTED_RANGE_NOT_SATISFIABLE_EXCEPTION(
		RequestedRangeNotSatisfiableException::class,
		::RequestedRangeNotSatisfiableException
	),

	/** 413 Request Entity Too Large，对应 [RequestEntityTooLargeException]。 */
	REQUEST_ENTITY_TOO_LARGE_EXCEPTION(RequestEntityTooLargeException::class, ::RequestEntityTooLargeException),

	/** 408 Request Timeout，对应 [RequestTimeoutException]。 */
	REQUEST_TIMEOUT_EXCEPTION(RequestTimeoutException::class, ::RequestTimeoutException),

	/** 414 Request URI Too Large，对应 [RequestUriTooLargeException]。 */
	REQUEST_URI_TOO_LARGE_EXCEPTION(RequestUriTooLargeException::class, ::RequestUriTooLargeException),

	/** 303 See Other，对应 [SeeOtherException]。 */
	SEE_OTHER_EXCEPTION(SeeOtherException::class, ::SeeOtherException),

	/** 503 Service Unavailable，对应 [ServiceUnavailableException]。 */
	SERVICE_UNAVAILABLE_EXCEPTION(ServiceUnavailableException::class, ::ServiceUnavailableException),

	/** 307 Temporary Redirect，对应 [TemporaryRedirectException]。 */
	TEMPORARY_REDIRECT_EXCEPTION(TemporaryRedirectException::class, ::TemporaryRedirectException),

	/** 401 Unauthorized，对应 [UnauthorizedException]。 */
	UNAUTHORIZED_EXCEPTION(UnauthorizedException::class, ::UnauthorizedException),

	/** 415 Unsupported Media Type，对应 [UnsupportedMediaTypeException]。 */
	UNSUPPORTED_MEDIA_TYPE_EXCEPTION(UnsupportedMediaTypeException::class, ::UnsupportedMediaTypeException),

	/** 305 Use Proxy，对应 [UseProxyException]。 */
	USE_PROXY_EXCEPTION(UseProxyException::class, ::UseProxyException);

	/** [kClazz] 对应的 Java 类，便于反射或按 `Class` 注册。 */
	val clazz: Class<out HttpStatusException> = this.kClazz.java

}

/**
 * 抛出 HTTP 502 Bad Gateway 异常。
 *
 * @param message 异常描述，默认为 `"Bad Gateway"`
 * @throws BadGatewayException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError502(message: String? = "Bad Gateway"): Nothing = throw BadGatewayException(message)

/**
 * 抛出 HTTP 400 Bad Request 异常。
 *
 * @param message 异常描述，默认为 `"Bad Request"`
 * @throws BadRequestException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError400(message: String? = "Bad Request"): Nothing = throw BadRequestException(message)

/**
 * 抛出 HTTP 409 Conflict 异常。
 *
 * @param message 异常描述，默认为 `"Conflict"`
 * @throws ConflictException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError409(message: String? = "Conflict"): Nothing = throw ConflictException(message)

/**
 * 抛出 HTTP 403 Forbidden 异常。
 *
 * @param message 异常描述，默认为 `"Forbidden"`
 * @throws ForbiddenException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError403(message: String? = "Forbidden"): Nothing = throw ForbiddenException(message)

/**
 * 抛出 HTTP 302 Found 异常。
 *
 * @param message 异常描述，默认为 `"Found"`
 * @throws FoundException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError302(message: String? = "Found"): Nothing = throw FoundException(message)

/**
 * 抛出 HTTP 504 Gateway Timeout 异常。
 *
 * @param message 异常描述，默认为 `"Gateway Timeout"`
 * @throws GatewayTimeoutException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError504(message: String? = "Gateway Timeout"): Nothing = throw GatewayTimeoutException(message)

/**
 * 抛出 HTTP 410 Gone 异常。
 *
 * @param message 异常描述，默认为 `"Gone"`
 * @throws GoneException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError410(message: String? = "Gone"): Nothing = throw GoneException(message)

/**
 * 抛出 HTTP 505 HTTP Version Not Supported 异常。
 *
 * @param message 异常描述，默认为 `"HTTP Version Not Supported"`
 * @throws HttpVersionNotSupportedException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError505(message: String? = "HTTP Version Not Supported"): Nothing =
	throw HttpVersionNotSupportedException(message)

/**
 * 抛出 HTTP 500 Internal Server Error 异常。
 *
 * @param message 异常描述，默认为 `"Internal Server Error"`
 * @throws InternalServerErrorException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError500(message: String? = "Internal Server Error"): Nothing =
	throw InternalServerErrorException(message)

/**
 * 抛出 HTTP 411 Length Required 异常。
 *
 * @param message 异常描述，默认为 `"Length Required"`
 * @throws LengthRequiredException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError411(message: String? = "Length Required"): Nothing = throw LengthRequiredException(message)

/**
 * 抛出 HTTP 405 Method Not Allowed 异常。
 *
 * @param message 异常描述，默认为 `"Method Not Allowed"`
 * @throws MethodNotAllowedException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError405(message: String? = "Method Not Allowed"): Nothing = throw MethodNotAllowedException(message)

/**
 * 抛出 HTTP 301 Moved Permanently 异常。
 *
 * @param message 异常描述，默认为 `"Moved Permanently"`
 * @throws MovedPermanentlyException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError301(message: String? = "Moved Permanently"): Nothing = throw MovedPermanentlyException(message)

/**
 * 抛出 HTTP 300 Multiple Choices 异常。
 *
 * @param message 异常描述，默认为 `"Multiple Choices"`
 * @throws MultipleChoicesException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError300(message: String? = "Multiple Choices"): Nothing = throw MultipleChoicesException(message)

/**
 * 抛出 HTTP 406 Not Acceptable 异常。
 *
 * @param message 异常描述，默认为 `"Not Acceptable"`
 * @throws NotAcceptableException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError406(message: String? = "Not Acceptable"): Nothing = throw NotAcceptableException(message)

/**
 * 抛出 HTTP 404 Not Found 异常。
 *
 * @param message 异常描述，默认为 `"Not Found"`
 * @throws NotFoundException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError404(message: String? = "Not Found"): Nothing = throw NotFoundException(message)

/**
 * 抛出 HTTP 501 Not Implemented 异常。
 *
 * @param message 异常描述，默认为 `"Not Implemented"`
 * @throws NotImplementedException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError501(message: String? = "Not Implemented"): Nothing = throw NotImplementedException(message)

/**
 * 抛出 HTTP 304 Not Modified 异常。
 *
 * @param message 异常描述，默认为 `"Not Modified"`
 * @throws NotModifiedException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError304(message: String? = "Not Modified"): Nothing = throw NotModifiedException(message)

/**
 * 抛出 HTTP 402 Payment Required 异常。
 *
 * @param message 异常描述，默认为 `"Payment Required"`
 * @throws PaymentRequiredException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError402(message: String? = "Payment Required"): Nothing = throw PaymentRequiredException(message)

/**
 * 抛出 HTTP 412 Precondition Failed 异常。
 *
 * @param message 异常描述，默认为 `"Precondition Failed"`
 * @throws PreconditionFailedException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError412(message: String? = "Precondition Failed"): Nothing = throw PreconditionFailedException(message)

/**
 * 抛出 HTTP 407 Proxy Authentication Required 异常。
 *
 * @param message 异常描述，默认为 `"Proxy Authentication Required"`
 * @throws ProxyAuthenticationRequiredException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError407(message: String? = "Proxy Authentication Required"): Nothing =
	throw ProxyAuthenticationRequiredException(message)

/**
 * 抛出 HTTP 416 Requested Range Not Satisfiable 异常。
 *
 * @param message 异常描述，默认为 `"Requested Range Not Satisfiable"`
 * @throws RequestedRangeNotSatisfiableException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError416(message: String? = "Requested Range Not Satisfiable"): Nothing =
	throw RequestedRangeNotSatisfiableException(message)

/**
 * 抛出 HTTP 413 Request Entity Too Large 异常。
 *
 * @param message 异常描述，默认为 `"Request Entity Too Large"`
 * @throws RequestEntityTooLargeException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError413(message: String? = "Request Entity Too Large"): Nothing =
	throw RequestEntityTooLargeException(message)

/**
 * 抛出 HTTP 408 Request Timeout 异常。
 *
 * @param message 异常描述，默认为 `"Request Timeout"`
 * @throws RequestTimeoutException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError408(message: String? = "Request Timeout"): Nothing = throw RequestTimeoutException(message)

/**
 * 抛出 HTTP 414 Request URI Too Large 异常。
 *
 * @param message 异常描述，默认为 `"Request URI Too Large"`
 * @throws RequestUriTooLargeException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError414(message: String? = "Request URI Too Large"): Nothing =
	throw RequestUriTooLargeException(message)

/**
 * 抛出 HTTP 303 See Other 异常。
 *
 * @param message 异常描述，默认为 `"See Other"`
 * @throws SeeOtherException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError303(message: String? = "See Other"): Nothing = throw SeeOtherException(message)

/**
 * 抛出 HTTP 503 Service Unavailable 异常。
 *
 * @param message 异常描述，默认为 `"Service Unavailable"`
 * @throws ServiceUnavailableException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError503(message: String? = "Service Unavailable"): Nothing = throw ServiceUnavailableException(message)

/**
 * 抛出 HTTP 307 Temporary Redirect 异常。
 *
 * @param message 异常描述，默认为 `"Temporary Redirect"`
 * @throws TemporaryRedirectException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError307(message: String? = "Temporary Redirect"): Nothing = throw TemporaryRedirectException(message)

/**
 * 抛出 HTTP 401 Unauthorized 异常。
 *
 * @param message 异常描述，默认为 `"Unauthorized"`
 * @throws UnauthorizedException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError401(message: String? = "Unauthorized"): Nothing = throw UnauthorizedException(message)

/**
 * 抛出 HTTP 415 Unsupported Media Type 异常。
 *
 * @param message 异常描述，默认为 `"Unsupported Media Type"`
 * @throws UnsupportedMediaTypeException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError415(message: String? = "Unsupported Media Type"): Nothing =
	throw UnsupportedMediaTypeException(message)

/**
 * 抛出 HTTP 305 Use Proxy 异常。
 *
 * @param message 异常描述，默认为 `"Use Proxy"`
 * @throws UseProxyException 总是抛出
 */
@Suppress("NOTHING_TO_INLINE")
inline fun httpError305(message: String? = "Use Proxy"): Nothing = throw UseProxyException(message)
