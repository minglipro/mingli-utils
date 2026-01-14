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
 * LastUpdate 2026-01-10 09:01:03
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.request

import com.mingliqiye.utils.functions.P1RFunction
import com.mingliqiye.utils.functions.RFunction

/**
 * 扩展函数：基于布尔值创建Require对象，并指定异常消息和异常构造器
 * @param message 异常消息
 * @param exception 异常构造器函数
 * @return Require对象
 */
fun Boolean.require(message: String, exception: P1RFunction<String, out Exception>): Require {
    return Require(this, message, exception)
}

/**
 * 扩展函数：基于布尔值创建Require对象，并指定异常消息和异常类型
 * @param message 异常消息
 * @param exception 异常类型，默认为IllegalArgumentException
 * @return Require对象
 */
fun Boolean.require(
    message: String,
    exception: Class<out Exception> = IllegalArgumentException::class.java
): Require {
    return Require(this, message, exception)
}

/**
 * 条件检查工具类，用于验证条件并抛出相应异常
 * @param must 需要验证的布尔条件
 */
class Require(private val must: Boolean) {

    /**
     * 构造函数：通过函数调用结果初始化条件检查器
     * @param funs 返回布尔值的函数
     */
    constructor(funs: RFunction<Boolean>) : this(funs.call())

    /**
     * 构造函数：通过函数调用结果初始化条件检查器，并立即执行检查
     * @param must 返回布尔值的函数
     * @param message 检查失败时的异常消息
     */
    constructor(must: RFunction<Boolean>, message: String) : this(must) {
        throws(message)
    }

    /**
     * 构造函数：通过函数调用结果初始化条件检查器，并立即执行检查
     * @param must 返回布尔值的函数
     * @param message 检查失败时的异常消息
     * @param exception 检查失败时抛出的异常类型，默认为IllegalArgumentException
     */
    constructor(
        must: RFunction<Boolean>,
        message: String,
        exception: Class<out Exception> = IllegalArgumentException::class.java
    ) : this(must) {
        throws(message, exception)
    }

    /**
     * 构造函数：通过布尔值初始化条件检查器，并立即执行检查
     * @param must 需要验证的布尔条件
     * @param message 检查失败时的异常消息
     */
    constructor(must: Boolean, message: String) : this(must) {
        throws(message)
    }

    /**
     * 构造函数：通过布尔值初始化条件检查器，并立即执行检查
     * @param must 需要验证的布尔条件
     * @param message 检查失败时的异常消息
     * @param exception 检查失败时抛出的异常类型，默认为IllegalArgumentException
     */
    constructor(
        must: Boolean, message: String, exception: Class<out Exception> = IllegalArgumentException::class.java
    ) : this(must) {
        throws(message, exception)
    }

    /**
     * 构造函数：通过布尔值初始化条件检查器，并立即执行检查
     * @param must 需要验证的布尔条件
     * @param message 检查失败时的异常消息
     * @param exception 检查失败时抛出的异常构造器函数
     */
    constructor(
        must: Boolean, message: String, exception: P1RFunction<String, out Exception>
    ) : this(must) {
        throws(message, exception)
    }

    companion object {

        /**
         * 工厂方法：创建Require对象并指定异常消息和异常类型
         * @param must 需要验证的布尔条件
         * @param message 检查失败时的异常消息
         * @param exception 检查失败时抛出的异常类型，默认为IllegalArgumentException
         * @return Require对象
         */
        @JvmStatic
        fun require(
            must: Boolean, message: String, exception: Class<out Exception> = IllegalArgumentException::class.java
        ): Require {
            return Require(must, message, exception)
        }

        /**
         * 工厂方法：创建Require对象并指定异常消息
         * @param must 需要验证的布尔条件
         * @param message 检查失败时的异常消息
         * @return Require对象
         */
        @JvmStatic
        fun require(must: Boolean, message: String): Require {
            return Require(must, message)
        }

        /**
         * 工厂方法：创建Require对象
         * @param must 需要验证的布尔条件
         * @return Require对象
         */
        @JvmStatic
        fun require(must: Boolean): Require {
            return Require(must)
        }

        /**
         * 工厂方法：创建Require对象并指定异常消息和异常类型
         * @param must 返回布尔值的函数
         * @param message 检查失败时的异常消息
         * @param exception 检查失败时抛出的异常类型，默认为IllegalArgumentException
         * @return Require对象
         */
        @JvmStatic
        fun require(
            must: RFunction<Boolean>,
            message: String,
            exception: Class<out Exception> = IllegalArgumentException::class.java
        ): Require {
            return Require(must, message, exception)
        }

        /**
         * 工厂方法：创建Require对象并指定异常消息
         * @param must 返回布尔值的函数
         * @param message 检查失败时的异常消息
         * @return Require对象
         */
        @JvmStatic
        fun require(must: RFunction<Boolean>, message: String): Require {
            return Require(must, message)
        }

        /**
         * 工厂方法：创建Require对象
         * @param must 返回布尔值的函数
         * @return Require对象
         */
        @JvmStatic
        fun require(must: RFunction<Boolean>): Require {
            return Require(must)
        }
    }

    /**
     * 执行条件检查，如果条件为false则抛出IllegalArgumentException
     * @param message 检查失败时的异常消息
     */
    fun throws(message: String) {
        if (!must) {
            throw IllegalArgumentException(message)
        }
    }

    /**
     * 执行条件检查，如果条件为false则抛出指定类型的异常
     * @param string 检查失败时的异常消息
     * @param exception 检查失败时抛出的异常类型
     */
    fun throws(string: String, exception: Class<out Exception>) {
        if (!must) {
            throw exception.getConstructor(String::class.java).newInstance(string)
        }
    }

    /**
     * 执行条件检查，如果条件为false则抛出由函数构造的异常
     * @param string 检查失败时的异常消息
     * @param exception 检查失败时抛出的异常构造器函数
     */
    fun throws(string: String, exception: P1RFunction<String, out Exception>) {
        if (!must) {
            throw exception.call(string)
        }
    }
}
