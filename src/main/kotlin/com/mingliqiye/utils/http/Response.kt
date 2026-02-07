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
 * CurrentFile Response.kt
 * LastUpdate 2026-02-07 22:18:42
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http

import com.mingliqiye.utils.annotation.DateTimeJsonFormat
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.base.AnnotationGetter
import com.mingliqiye.utils.time.DateTime

/**
 * HTTP响应数据类
 * 封装了时间、消息、数据和状态码等响应信息
 *
 * @param T 响应数据的类型
 * @property time 响应时间
 * @property message 响应消息
 * @property data 响应数据
 * @property statusCode 状态码
 */
data class Response<T>(
    private var time: DateTime,
    private var message: String,
    private var data: T?,
    private var statusCode: Int,
) {
    private var timeFormat: DateTimeJsonFormat = DateTimeJsonFormat()

    companion object {

        /**
         * 创建一个成功的响应对象（仅包含消息）
         *
         * @param message 响应消息
         * @return Response<Any> 成功的响应对象
         */
        @JvmStatic
        fun ok(message: String) = Response(
            time = DateTime.now(),
            message = message,
            data = null,
            statusCode = 200
        )

        /**
         * 创建一个成功的响应对象（仅包含数据）
         *
         * @param T 响应数据的类型
         * @param data 响应数据
         * @return Response<T> 成功的响应对象
         */
        @JvmStatic
        fun <T> okData(data: T) = Response(
            time = DateTime.now(),
            message = "操作成功",
            data = data,
            statusCode = 200
        )

        /**
         * 创建一个成功的响应对象（包含数据和消息）
         *
         * @param T 响应数据的类型
         * @param data 响应数据
         * @param message 响应消息
         * @return Response<T> 成功的响应对象
         */
        @JvmStatic
        fun <T> okData(data: T, message: String) = Response(
            time = DateTime.now(),
            message = message,
            data = data,
            statusCode = 200
        )


        /**
         * 创建一个指定状态码的响应对象（仅包含状态码）
         *
         * @param statusCode 状态码
         * @return Response<Any> 指定状态码的响应对象
         */
        @JvmStatic
        fun code(statusCode: Int) = Response(
            time = DateTime.now(),
            message = "操作成功",
            data = null,
            statusCode = statusCode
        )

        /**
         * 创建一个指定状态码的响应对象（包含状态码和消息）
         *
         * @param statusCode 状态码
         * @param message 响应消息
         * @return Response<Any> 指定状态码的响应对象
         */
        @JvmStatic
        fun code(statusCode: Int, message: String) = Response(
            time = DateTime.now(),
            message = message,
            data = null,
            statusCode = statusCode
        )
    }

    /**
     * 默认构造函数，创建一个默认的成功响应对象
     */
    constructor() : this(
        time = DateTime.now(), message = "操作成功", statusCode = 200, data = null
    )


    /**
     * 获取格式化后的时间字符串。
     *
     * @return 格式化后的时间字符串，使用 [DateTimeJsonConverter] 和 [timeFormat] 注解进行转换。
     */
    fun getTime(): String =
        DateTimeJsonConverter.getJsonConverter().convert(time, AnnotationGetter.oneGetter(timeFormat))!!

    /**
     * 设置时间字段的值。
     *
     * @param dateTime 格式化后的时间字符串，将被反序列化为内部时间对象。
     * @return 返回当前对象实例，支持链式调用。
     */
    fun setTime(dateTime: String): Response<T> {
        // 使用 DateTimeJsonConverter 将输入的字符串反序列化为时间对象，并更新内部 time 字段
        time = DateTimeJsonConverter.getJsonConverter().deConvert(dateTime, AnnotationGetter.oneGetter(timeFormat))!!
        return this
    }


    /**
     * 获取响应消息
     *
     * @return String 响应消息
     */
    fun getMessage(): String = message

    /**
     * 设置响应消息
     *
     * @param message 响应消息
     * @return Response<T> 当前响应对象（用于链式调用）
     */
    fun setMessage(message: String): Response<T> {
        this.message = message
        return this
    }

    /**
     * 获取响应数据
     *
     * @return T? 响应数据，可能为空
     */
    fun getData(): T? = data

    /**
     * 获取非空数据对象
     *
     * 此方法强制解包data属性，如果data为null则会抛出NullPointerException异常
     *
     * @param T 泛型类型参数，表示返回的数据类型
     * @return 返回非空的数据对象，类型为T
     * @throws NullPointerException 当data属性为null时抛出此异常
     */
    @Throws(NullPointerException::class)
    fun notNullData(): T {
        return data ?: throw NullPointerException("at Response.notNullData() because data is null")
    }


    /**
     * 设置响应数据
     *
     * @param D 数据类型
     * @param data 响应数据
     * @return Response<D> 当前响应对象（用于链式调用）
     *
     */
    fun setData(data: T): Response<T> {
        this.data = data
        return this
    }

    /**
     * 创建一个新的Response对象，使用指定的时间
     *
     * @param time 新的响应时间
     * @return Response<T> 新的响应对象
     */
    fun withTime(time: DateTime): Response<T> =
        if (this.time == time) this else Response(time, message, data, statusCode)

    /**
     * 创建一个新的Response对象，使用指定的数据
     *
     * @param D 新的数据类型
     * @param data 新的响应数据
     * @return Response<D> 新的响应对象
     */
    fun <D> withData(data: D): Response<D> =
        Response(this.time, this.message, data, this.statusCode)

    /**
     * 创建一个新的Response对象，使用指定的消息
     *
     * @param message 新的响应消息
     * @return Response<T> 新的响应对象
     */
    fun withMessage(message: String): Response<T> =
        if (this.message == message) this else Response(time, message, data, statusCode)

    /**
     * 创建一个新的Response对象，使用指定的状态码
     *
     * @param statusCode 新的状态码
     * @return Response<T> 新的响应对象
     */
    fun withStatusCode(statusCode: Int): Response<T> =
        if (this.statusCode == statusCode) this else Response(time, message, data, statusCode)

    /**
     * 获取状态码
     *
     * @return Int 状态码
     */
    fun getStatusCode(): Int = statusCode

    /**
     * 设置状态码
     *
     * @param statusCode 状态码
     * @return Response<T> 当前响应对象（用于链式调用）
     */
    fun setStatusCode(statusCode: Int): Response<T> {
        this.statusCode = statusCode
        return this
    }

    fun writeTimeFormat(timeFormat: DateTimeJsonFormat): Response<T> {
        this.timeFormat = timeFormat
        return this
    }

    fun readTimeFormat(): DateTimeJsonFormat = timeFormat

    /**
     * 返回响应对象的字符串表示
     */
    override fun toString(): String =
        "Response(time=${getTime()}, message=${getMessage()}, data:[${data?.javaClass?.simpleName}]=${getData()}, statusCode=${getStatusCode()})"
}
