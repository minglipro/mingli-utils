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
 * LastUpdate 2026-02-24 09:03:42
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.require

import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.slf4j.Logger
import java.lang.reflect.Constructor
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.reflect.KClass

/**
 * 条件检查工具对象，提供多种重载的require方法用于参数验证和异常抛出
 * 支持自定义异常类型、延迟消息构造和日志记录功能
 */
object Require {
    @JvmStatic
    var logger: Logger? = MingLiLoggerFactory.getLogger<Require>()

    @JvmStatic
    var isLogError = true

    /**
     * 检查条件是否满足，如果不满足则抛出指定类型的异常
     * @param value 要检查的布尔条件
     * @param throwable 异常类型Class对象
     * @param layzMessage 延迟消息构造器
     */
    @JvmStatic
    @OptIn(ExperimentalContracts::class)
    fun require(value: Boolean, throwable: Class<out Throwable>, layzMessage: RequireLayzMessageConstructor) {
        contract {
            returns() implies value
        }
        require(value, layzMessage.call(), throwable)
    }

    /**
     * 检查条件是否满足，如果不满足则抛出指定类型的异常
     * @param value 要检查的布尔条件
     * @param throwable 异常类型KClass对象
     * @param layzMessage 延迟消息构造器
     */
    @JvmStatic
    @OptIn(ExperimentalContracts::class)
    fun require(value: Boolean, throwable: KClass<out Throwable>, layzMessage: RequireLayzMessageConstructor) {
        contract {
            returns() implies value
        }
        require(value, throwable.java, layzMessage)
    }

    /**
     * 检查条件是否满足，如果不满足则抛出延迟构造的异常
     * @param value 要检查的布尔条件
     * @param layzThrowable 延迟异常构造器
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
     * 检查条件是否满足，如果不满足则抛出指定消息和类型的异常
     * @param value 要检查的布尔条件
     * @param message 异常消息
     * @param throwable 异常类型Class对象
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
     * 检查条件是否满足，如果不满足则抛出指定消息和类型的异常
     * @param value 要检查的布尔条件
     * @param message 异常消息
     * @param throwable 异常类型KClass对象
     */
    @JvmStatic
    @OptIn(ExperimentalContracts::class)
    fun require(value: Boolean, message: String, throwable: KClass<out Throwable>) {
        contract {
            returns() implies value
        }
        require(value, message, throwable.java)
    }

    /**
     * 抛出异常并在启用日志时记录错误信息
     * @param throwable 要抛出的异常对象
     */
    @JvmStatic
    fun throwThrowable(throwable: Throwable) {
        if (isLogError && logger != null) logger!!.error(throwable.message, throwable)
        throw throwable
    }

    /**
     * 内联函数版本的条件检查，支持泛型异常类型
     * @param T 异常类型
     * @param value 要检查的布尔条件
     * @param message 异常消息
     */
    @OptIn(ExperimentalContracts::class)
    @JvmName("__inline_Require")
    @JvmStatic
    inline fun <reified T : Throwable> require(value: Boolean, message: String) {
        contract {
            returns() implies value
        }
        require(value, message, T::class.java)
    }

    /**
     * 内联函数版本的条件检查，支持泛型异常类型和延迟消息构造
     * @param T 异常类型
     * @param value 要检查的布尔条件
     * @param layzMessage 延迟消息构造器
     */
    @OptIn(ExperimentalContracts::class)
    @JvmName("__inline_Require")
    @JvmStatic
    inline fun <reified T : Throwable> require(value: Boolean, layzMessage: RequireLayzMessageConstructor) {
        contract {
            returns() implies value
        }
        if (!value) throwThrowable(getExceptionConstructor<T>().newInstance(layzMessage.call()))
    }

    /**
     * 获取指定异常类型的构造函数（内联泛型版本）
     * @param T 异常类型
     * @return 异常类型的构造函数
     */
    @JvmName("__inline_GetExceptionConstructor")
    @JvmStatic
    inline fun <reified T : Throwable> getExceptionConstructor(): Constructor<out T> =
        getExceptionConstructor(T::class.java)

    /**
     * 获取指定异常类型的构造函数
     * @param throwable 异常类型Class对象
     * @return 异常类型的构造函数
     */
    @JvmStatic
    @JvmName("__GetExceptionConstructor")
    fun <T : Throwable> getExceptionConstructor(throwable: Class<out T>): Constructor<out T> =
        throwable.getConstructor(String::class.java)

    /**
     * 获取指定异常类型的构造函数
     * @param throwable 异常类型KClass对象
     * @return 异常类型的构造函数
     */
    @JvmStatic
    @JvmName("__GetExceptionConstructor")
    fun <T : Throwable> getExceptionConstructor(throwable: KClass<out T>): Constructor<out T> =
        getExceptionConstructor(throwable.java)

    /**
     * 基础条件检查方法，不满足条件时抛出IllegalArgumentException
     * @param value 要检查的布尔条件
     */
    @OptIn(ExperimentalContracts::class)
    @JvmStatic
    fun require(value: Boolean) {
        contract {
            returns() implies value
        }
        require(value, "the require conditions are not met.")
    }

    /**
     * 使用延迟消息构造器进行条件检查，不满足时抛出IllegalArgumentException
     * @param value 要检查的布尔条件
     * @param layzMessage 延迟消息构造器
     */
    @OptIn(ExperimentalContracts::class)
    @JvmStatic
    fun requireLayzMessage(value: Boolean, layzMessage: RequireLayzMessageConstructor) {
        contract {
            returns() implies value
        }
        require(value, IllegalArgumentException::class.java, layzMessage)
    }

    /**
     * 带消息的条件检查方法，不满足条件时抛出IllegalArgumentException
     * @param value 要检查的布尔条件
     * @param message 异常消息
     */
    @OptIn(ExperimentalContracts::class)
    @JvmStatic
    fun require(value: Boolean, message: String) {
        contract {
            returns() implies value
        }
        if (!value) throwThrowable(getExceptionConstructor(IllegalArgumentException::class.java).newInstance(message))
    }
}
