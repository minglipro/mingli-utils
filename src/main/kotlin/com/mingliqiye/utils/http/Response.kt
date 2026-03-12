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
 * LastUpdate 2026-03-12 10:33:32
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http

import com.mingliqiye.utils.time.DateTime

/**
 * HTTP响应数据类
 * 封装了时间、消息、数据和状态码等响应信息
 *
 * 该类用于统一API响应的格式，支持链式调用和不可变对象的创建。
 * 提供了多种工厂方法用于创建不同类型的响应对象。
 *
 * @param T 响应数据的类型
 * @property time 响应时间（格式化的字符串）
 * @property message 响应消息
 * @property data 响应数据，可能为空
 * @property statusCode HTTP状态码
 */
data class Response<T>(
    private val time: String,      // 响应时间，一旦创建不可修改
    private var message: String,   // 响应消息，可通过setter修改
    private var data: T?,          // 响应数据，可通过setter修改
    private var statusCode: Int,   // HTTP状态码，可通过setter修改
) {

    companion object {
        /**
         * 创建一个默认的成功响应对象
         * 使用默认消息"操作成功"，无数据，状态码200
         *
         * @return Response<Any> 默认的成功响应对象
         */
        fun ok() = ok("操作成功")

        /**
         * 创建一个成功的响应对象（仅包含消息）
         *
         * @param message 响应消息
         * @return Response<Any> 成功的响应对象，数据为null
         */
        @JvmStatic
        fun ok(message: String) = Response(
            time = DateTime.now().format(),
            message = message,
            data = null,
            statusCode = 200
        )

        /**
         * 创建一个错误的响应对象
         *
         * @param message 错误消息，默认为"服务器错误"
         * @param statusCode HTTP状态码，默认为500
         * @return Response<Any> 错误的响应对象
         */
        fun error(message: String = "服务器错误", statusCode: Int = 500) = ok(message).withStatusCode(statusCode)

        /**
         * 创建一个成功的响应对象（仅包含数据）
         * 使用默认消息"操作成功"
         *
         * @param T 响应数据的类型
         * @param data 响应数据
         * @return Response<T> 成功的响应对象，包含数据
         */
        @JvmStatic
        fun <T> okData(data: T) = Response(
            time = DateTime.now().format(),
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
         * @return Response<T> 成功的响应对象，包含数据和消息
         */
        @JvmStatic
        fun <T> okData(data: T, message: String) = Response(
            time = DateTime.now().format(),
            message = message,
            data = data,
            statusCode = 200
        )

        /**
         * 创建一个指定状态码的响应对象（仅包含状态码）
         * 使用默认消息"操作成功"，无数据
         *
         * @param statusCode HTTP状态码
         * @return Response<Any> 指定状态码的响应对象
         */
        @JvmStatic
        fun code(statusCode: Int) = Response(
            time = DateTime.now().format(),
            message = "操作成功",
            data = null,
            statusCode = statusCode
        )

        /**
         * 创建一个指定状态码的响应对象（包含状态码和消息）
         * 无数据
         *
         * @param statusCode HTTP状态码
         * @param message 响应消息
         * @return Response<Any> 指定状态码和消息的响应对象
         */
        @JvmStatic
        fun code(statusCode: Int, message: String) = Response(
            time = DateTime.now().format(),
            message = message,
            data = null,
            statusCode = statusCode
        )
    }

    /**
     * 默认构造函数，创建一个默认的成功响应对象
     * 使用当前时间、默认消息"操作成功"、状态码200、无数据
     */
    constructor() : this(
        time = DateTime.now().format(),
        message = "操作成功",
        statusCode = 200,
        data = null
    )

    /**
     * 获取格式化后的时间字符串。
     *
     * @return 格式化后的时间字符串
     */
    fun getTime(): String = time

    /**
     * 获取响应消息
     *
     * @return String 当前响应消息
     */
    fun getMessage(): String = message

    /**
     * 设置响应消息
     *
     * 该方法允许修改响应消息，并返回当前对象以支持链式调用。
     *
     * @param message 新的响应消息
     * @return Response<T> 当前响应对象（支持链式调用）
     */
    fun setMessage(message: String): Response<T> {
        this.message = message
        return this
    }

    /**
     * 获取响应数据
     *
     * 返回的响应数据可能为null，调用前应进行空值检查。
     *
     * @return T? 响应数据，可能为空
     */
    fun getData(): T? = data

    /**
     * 获取非空数据对象
     *
     * 该方法强制解包data属性，如果data为null则会抛出NullPointerException异常。
     * 适用于确定data不为null的场景，避免重复的空值检查。
     *
     * @return T 非空的数据对象
     * @throws NullPointerException 当data属性为null时抛出此异常
     */
    @Throws(NullPointerException::class)
    fun notNullData(): T {
        return data ?: throw NullPointerException("at Response.notNullData() because data is null")
    }

    /**
     * 设置响应数据
     *
     * 该方法允许修改响应数据，并返回当前对象以支持链式调用。
     *
     * @param data 新的响应数据
     * @return Response<T> 当前响应对象（支持链式调用）
     */
    fun setData(data: T): Response<T> {
        this.data = data
        return this
    }

    /**
     * 创建一个新的Response对象，使用指定的时间
     *
     * 该方法用于创建具有新时间的响应对象，遵循不可变对象的设计模式。
     * 如果时间相同，则返回原对象避免不必要的对象创建。
     *
     * @param time 新的响应时间
     * @return Response<T> 新的响应对象（如果时间相同则返回原对象）
     */
    fun withTime(time: String): Response<T> =
        if (this.time == time) this else Response(time, message, data, statusCode)

    /**
     * 创建一个新的Response对象，使用指定的数据
     *
     * 该方法允许改变响应数据的类型，创建一个新的响应对象。
     * 适用于需要在保持其他字段不变的情况下更新数据类型的场景。
     *
     * @param D 新的数据类型
     * @param data 新的响应数据
     * @return Response<D> 新的响应对象，数据类型为D
     */
    fun <D> withData(data: D): Response<D> =
        Response(this.time, this.message, data, this.statusCode)

    /**
     * 创建一个新的Response对象，使用指定的消息
     *
     * 该方法用于创建具有新消息的响应对象，遵循不可变对象的设计模式。
     * 如果消息相同，则返回原对象避免不必要的对象创建。
     *
     * @param message 新的响应消息
     * @return Response<T> 新的响应对象（如果消息相同则返回原对象）
     */
    fun withMessage(message: String): Response<T> =
        if (this.message == message) this else Response(time, message, data, statusCode)

    /**
     * 创建一个新的Response对象，使用指定的状态码
     *
     * 该方法用于创建具有新状态码的响应对象，遵循不可变对象的设计模式。
     * 如果状态码相同，则返回原对象避免不必要的对象创建。
     *
     * @param statusCode 新的状态码
     * @return Response<T> 新的响应对象（如果状态码相同则返回原对象）
     */
    fun withStatusCode(statusCode: Int): Response<T> =
        if (this.statusCode == statusCode) this else Response(time, message, data, statusCode)

    /**
     * 获取状态码
     *
     * @return Int 当前HTTP状态码
     */
    fun getStatusCode(): Int = statusCode

    /**
     * 设置状态码
     *
     * 该方法允许修改状态码，并返回当前对象以支持链式调用。
     *
     * @param statusCode 新的HTTP状态码
     * @return Response<T> 当前响应对象（支持链式调用）
     */
    fun setStatusCode(statusCode: Int): Response<T> {
        this.statusCode = statusCode
        return this
    }

    /**
     * 返回响应对象的字符串表示
     *
     * 重写toString方法以提供更有意义的对象表示，便于日志记录和调试。
     * 显示时间、消息、数据类型和值以及状态码。
     *
     * @return 格式化的字符串表示
     */
    override fun toString(): String =
        "Response(time=${getTime()}, message=${getMessage()}, data:[${data?.javaClass?.simpleName}]=${getData()}, statusCode=${getStatusCode()})"
}
