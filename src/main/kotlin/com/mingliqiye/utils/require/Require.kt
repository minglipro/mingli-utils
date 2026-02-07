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
 * CurrentFile Require.kt
 * LastUpdate 2026-02-06 08:27:44
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.require

import com.mingliqiye.utils.exception.InternalServerErrorException
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.slf4j.Logger
import java.lang.reflect.Constructor
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * 工具对象，用于提供条件检查功能。
 * 支持抛出自定义异常、延迟消息构造以及日志记录等功能。
 */
class Require(val defaultException: Class<out Throwable>) {

    companion object {
        @JvmStatic
        val RequireLayz by lazy {
            Require(IllegalArgumentException::class.java)
        }

        @JvmStatic
        val RequireHttpLayz by lazy {
            Require(InternalServerErrorException::class.java)
        }

        @JvmStatic
        var logger: Logger? = MingLiLoggerFactory.getLogger<Require>()

        @JvmStatic
        var isLogError = true

        /**
         * 检查给定条件是否为真。如果为假，则使用延迟消息构造器生成异常并抛出。
         *
         * @param value 需要检查的布尔值。
         * @param throwable 异常类型。
         * @param layzMessage 延迟消息构造器。
         */
        @OptIn(ExperimentalContracts::class)
        fun require(value: Boolean, throwable: Class<out Throwable>, layzMessage: RequireLayzMessageConstructor) {
            contract {
                returns() implies value
            }
            require(value, layzMessage.call(), throwable)
        }

        /**
         * 检查给定条件是否为真。如果为假，则使用延迟异常构造器生成异常并抛出。
         *
         * @param value 需要检查的布尔值。
         * @param layzThrowable 延迟异常构造器。
         */
        @JvmStatic
        @OptIn(ExperimentalContracts::class)
        fun require(value: Boolean, layzThrowable: RequireLayzExceptionConstructor) {
            contract {
                returns() implies value
            }
            if (!value) throwThrowable(layzThrowable.call())
        }

        /**
         * 检查给定条件是否为真。如果为假，则根据指定的异常类型和消息生成异常并抛出。
         *
         * @param value 需要检查的布尔值。
         * @param message 异常消息。
         * @param throwable 异常类型。
         */
        @JvmStatic
        @OptIn(ExperimentalContracts::class)
        fun require(value: Boolean, message: String, throwable: Class<out Throwable>) {
            contract {
                returns() implies value
            }
            if (!value) throwThrowable(getExceptionConstructor(throwable).newInstance(message))
        }

        /**
         * 抛出指定的异常，并在启用日志记录时记录错误信息。
         *
         * @param throwable 需要抛出的异常。
         */
        @JvmStatic
        fun throwThrowable(throwable: Throwable) {
            if (isLogError && logger != null) logger!!.error(throwable.message, throwable)
            throw throwable
        }

        /**
         * 检查给定条件是否为真。如果为假，则根据指定的异常类型抛出异常。
         *
         * @param value 需要检查的布尔值。
         * @param message 异常消息。
         * @param T 异常类型。
         */
        @OptIn(ExperimentalContracts::class)
        @JvmName("__inline_Require")
        inline fun <reified T : Throwable> require(value: Boolean, message: String) {
            contract {
                returns() implies value
            }
            require(value, message, T::class.java)
        }

        /**
         * 检查给定条件是否为真。如果为假，则根据指定的异常类型和延迟消息构造器生成异常并抛出。
         *
         * @param value 需要检查的布尔值。
         * @param layzMessage 延迟消息构造器。
         * @param T 异常类型。
         */
        @OptIn(ExperimentalContracts::class)
        @JvmName("__inline_Require")
        inline fun <reified T : Throwable> require(value: Boolean, layzMessage: RequireLayzMessageConstructor) {
            contract {
                returns() implies value
            }
            if (!value) throwThrowable(getExceptionConstructor<T>().newInstance(layzMessage.call()))
        }

        /**
         * 获取指定异常类型的构造函数（带字符串参数）。
         *
         * @param T 异常类型。
         * @return 异常类型的构造函数。
         */
        @JvmName("__inline_GetExceptionConstructor")
        inline fun <reified T : Throwable> getExceptionConstructor(): Constructor<out T> =
            getExceptionConstructor(T::class.java)

        /**
         * 获取指定异常类型的构造函数（带字符串参数）。
         *
         * @param throwable 异常类型。
         * @return 异常类型的构造函数。
         */

        @JvmStatic
        @JvmName("__GetExceptionConstructor")
        fun <T : Throwable> getExceptionConstructor(throwable: Class<out T>): Constructor<out T> =
            throwable.getConstructor(String::class.java)
    }

    /**
     * 检查给定条件是否为真。如果为假，则抛出 [IllegalArgumentException] 异常。
     *
     * @param value 需要检查的布尔值。
     */
    @OptIn(ExperimentalContracts::class)
    fun require(value: Boolean) {
        contract {
            returns() implies value
        }
        require(value, "the require conditions are not met.")
    }

    /**
     * 检查给定条件是否为真。如果为假，则使用延迟消息构造器生成 [IllegalArgumentException] 并抛出。
     *
     * @param value 需要检查的布尔值。
     * @param layzMessage 延迟消息构造器。
     */
    @OptIn(ExperimentalContracts::class)
    fun requireLayzMessage(value: Boolean, layzMessage: RequireLayzMessageConstructor) {
        contract {
            returns() implies value
        }
        require(value, defaultException, layzMessage)
    }

    /**
     * 检查给定条件是否为真。如果为假，则抛出 [IllegalArgumentException] 异常。
     *
     * @param value 需要检查的布尔值。
     * @param message 异常消息。
     */
    @OptIn(ExperimentalContracts::class)
    fun require(value: Boolean, message: String) {
        contract {
            returns() implies value
        }
        if (!value) throwThrowable(getExceptionConstructor(defaultException).newInstance(message))
    }
}
