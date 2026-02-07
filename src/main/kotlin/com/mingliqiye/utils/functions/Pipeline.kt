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
 * CurrentFile Pipeline.kt
 * LastUpdate 2026-02-05 15:22:21
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.functions

import com.mingliqiye.utils.require.Require
import java.util.*

/**
 * 流水线操作类，提供链式调用的操作方式来处理数据转换和操作
 * @param T 泛型类型，表示流水线中处理的数据类型
 */
class Pipeline<T>(private val value: T) {

    /**
     * 对当前值进行转换操作，并返回新的Pipeline实例
     * @param transformer 转换函数，接收当前值并返回转换后的结果
     * @return 包含转换后结果的新Pipeline实例
     */
    fun <R> transform(transformer: P1RFunction<T, R>): Pipeline<R> = Pipeline(transformer.call(value))

    /**
     * 对当前值进行转换操作，功能与transform相同，提供不同的方法名选择
     * @param transformer 转换函数，接收当前值并返回转换后的结果
     * @return 包含转换后结果的新Pipeline实例
     */
    fun <R> then(transformer: P1RFunction<T, R>): Pipeline<R> = transform(transformer)


    /**
     * 消费当前值但不改变流水线状态，用于执行副作用操作
     * @param consumer 消费函数，接收当前值进行消费操作
     * @return 当前Pipeline实例，支持链式调用
     */
    fun consume(consumer: P1Function<T>): Pipeline<T> {
        consumer.call(value)
        return this
    }

    /**
     * 判断当前值是否为null
     * @return true表示当前值为null，false表示不为null
     */
    fun isNull(): Boolean = (value == null)

    /**
     * 判断当前值是否不为null
     * @return true表示当前值不为null，false表示为null
     */
    fun isNotNull(): Boolean = (value != null)

    /**
     * 根据条件过滤当前值，如果条件满足则保持原值，否则设置为null
     * @param predicate 过滤条件函数，接收当前值并返回布尔值
     * @return 包含过滤后结果的Pipeline实例
     */
    fun filter(predicate: P1RFunction<T, Boolean>): Pipeline<T?> =
        if (predicate.call(value)) Pipeline(value) else Pipeline(null)

    /**
     * 获取当前流水线中的值
     * @return 当前流水线中存储的值
     */
    fun getValue(): T = value

    /**
     * 安全地转换当前值，允许转换结果为null
     * @param transformer 转换函数，可能返回null
     * @return 包含转换后结果（可能为null）的Pipeline实例
     */
    fun <R> safeTransform(transformer: P1RFunction<T, R?>): Pipeline<R?> = Pipeline(transformer.call(value))

    /**
     * 将当前值映射为另一个Pipeline实例
     * @param mapper 映射函数，接收当前值并返回Pipeline实例
     * @return 映射后的Pipeline实例
     */
    fun <R> flatMap(mapper: P1RFunction<T, Pipeline<R>>): Pipeline<R> = mapper.call(value)

    /**
     * 将当前值映射为非null结果，如果当前值为null则直接返回null
     * @param mapper 映射函数，可能返回null
     * @return 包含映射后结果的Pipeline实例
     */
    fun <R> mapNotNull(mapper: P1RFunction<T, R?>): Pipeline<out R?> =
        if (value != null) Pipeline(mapper.call(value)!!) else Pipeline(null)


    /**
     * 将当前值强制转换为指定类型
     * @param type 目标类型Class对象
     * @return 包含转换后类型的Pipeline实例
     * @throws ClassCastException 当类型转换失败时抛出异常
     */
    @Throws(ClassCastException::class)
    fun <E> cast(type: Class<E>): Pipeline<E> = Pipeline(value as E)

    /**
     * 根据条件判断是否保留当前值，条件满足时保留，否则返回null
     * @param predicate 条件判断函数
     * @return 包含条件判断结果的Pipeline实例
     */
    fun takeIf(predicate: P1RFunction<T, Boolean>): Pipeline<T?> = Pipeline(if (predicate.call(value)) value else null)

    /**
     * 根据条件判断是否保留当前值，条件不满足时保留，否则返回null
     * @param predicate 条件判断函数
     * @return 包含条件判断结果的Pipeline实例
     */
    fun takeUnless(predicate: P1RFunction<T, Boolean>): Pipeline<T?> =
        Pipeline(if (!predicate.call(value)) value else null)

    /**
     * 在当前值上执行指定操作并返回操作结果
     * @param block 执行函数，接收当前值并返回结果
     * @return 包含执行结果的Pipeline实例
     */
    fun <R> let(block: P1RFunction<T, R>): Pipeline<R> = Pipeline(block.call(value))

    /**
     * 如果当前值不为null则返回自身，否则返回默认值的Pipeline实例
     * @param defaultValue 默认值
     * @return 当前值或默认值的Pipeline实例
     */
    fun orElse(defaultValue: T): Pipeline<T> = if (value != null) this else Pipeline(defaultValue)

    /**
     * 如果当前值不为null则返回自身，否则通过供应商函数获取默认值
     * @param supplier 默认值供应商函数
     * @return 当前值或供应商提供的值的Pipeline实例
     */
    fun orElseGet(supplier: RFunction<T>): Pipeline<T> = if (value != null) this else Pipeline(supplier.call())

    /**
     * 验证当前值是否等于指定值，如果不相等则抛出异常
     * @param any 比较的目标值
     * @param message 错误消息
     * @param exception 异常类型，默认为IllegalArgumentException
     * @return 当前Pipeline实例
     */
    fun require(
        any: Any, message: String, exception: Class<out Exception> = IllegalArgumentException::class.java
    ): Pipeline<T> {
        Require.require(Objects.equals(any, value), message, exception)
        return this
    }


    /**
     * 验证当前值是否等于指定值，如果不相等则抛出IllegalArgumentException异常
     * @param any 比较的目标值
     * @param message 错误消息
     * @return 当前Pipeline实例
     */
    fun require(
        any: Any, message: String
    ): Pipeline<T> {
        Require.RequireLayz.require(any == value, message)
        return this
    }

    /**
     * 使用P1RFunction验证当前值是否满足条件，不满足则抛出异常
     * @param must 验证条件函数
     * @param message 错误消息
     * @param exception 异常类型，默认为IllegalArgumentException
     * @return 当前Pipeline实例
     */
    fun require(
        must: P1RFunction<T, Boolean>,
        message: String,
        exception: Class<out Throwable> = IllegalArgumentException::class.java
    ): Pipeline<T> {
        Require.require(must.call(value), message, exception)
        return this
    }

    /**
     * 使用P1RFunction验证当前值是否满足条件，不满足则抛出IllegalArgumentException异常
     * @param must 验证条件函数
     * @param message 错误消息
     * @return 当前Pipeline实例
     */
    fun require(
        must: P1RFunction<T, Boolean>, message: String
    ): Pipeline<T> {
        Require.require(must.call(value), message, IllegalArgumentException::class.java)
        return this
    }


    /**
     * 对当前值执行指定操作但不改变流水线状态
     * @param block 执行函数，接收当前值
     * @return 当前Pipeline实例
     */
    fun also(block: P1Function<T>): Pipeline<T> {
        block.call(value)
        return this
    }

    /**
     * 验证当前值是否满足指定条件，不满足则抛出IllegalArgumentException异常
     * @param predicate 验证条件函数
     * @param lazyMessage 延迟错误消息生成函数，默认返回"Requirement failed"
     * @return 当前Pipeline实例
     */
    fun require(
        predicate: P1RFunction<T, Boolean>,
        lazyMessage: P1RFunction<T, Any> = P1RFunction { "Requirement failed" }
    ): Pipeline<T> {
        if (!predicate.call(value)) {
            throw IllegalArgumentException(lazyMessage.call(value).toString())
        }
        return this
    }

    /**
     * 使用比较器比较当前值与另一个值
     * @param other 另一个比较值
     * @param comparator 比较器
     * @return 比较结果，负数表示小于，0表示相等，正数表示大于
     */
    fun compareWith(other: T, comparator: Comparator<in T>): Int = comparator.compare(value, other)

    /**
     * 使用选择器将当前值转换为可比较类型后与另一个值比较
     * @param other 另一个比较值
     * @param selector 选择器函数，将当前值转换为可比较类型
     * @return 比较结果
     */
    fun <R : Comparable<R>> compareTo(other: R, selector: P1RFunction<T, R>): Int =
        selector.call(value).compareTo(other)


    companion object {
        /**
         * 创建包含指定值的Pipeline实例
         * @param value 要包装的值
         * @return 新的Pipeline实例
         */
        @JvmStatic
        fun <T> of(value: T): Pipeline<T> = Pipeline(value)

        /**
         * 通过供应商函数创建Pipeline实例
         * @param transformer 值供应商函数
         * @return 新的Pipeline实例
         */
        @JvmStatic
        fun <T> of(transformer: RFunction<T>): Pipeline<T> = Pipeline(transformer.call())
    }
}
