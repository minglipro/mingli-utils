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
 * CurrentFile JsonTypeReference.kt
 * LastUpdate 2026-02-05 11:12:36
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api.type

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

/**
 * 通用的 JSON 类型引用类，用于在运行时保留泛型类型信息
 * 适用于所有 JSON 库（Jackson、Gson、Fastjson 等）
 *
 * @param <T> 引用的泛型类型
 */
abstract class JsonTypeReference<T> : Comparable<JsonTypeReference<T>> {

    open var type: Type = Any::class.java

    /**
     * 构造函数，通过反射获取泛型类型信息
     * 仅供内部匿名子类使用
     */
    protected constructor() {
        val superClass: Type = this.javaClass.genericSuperclass

        // 检查是否为匿名子类，防止直接实例化导致无法获取泛型信息
        if (superClass is Class<*>) {
            throw IllegalArgumentException(
                "必须使用匿名子类方式创建 JsonTypeReference，" +
                        "例如: new JsonTypeReference<List<String>>() {}"
            )
        }

        this.type = (superClass as ParameterizedType).actualTypeArguments[0]
    }

    /**
     * 构造函数，直接指定类型
     * @param type 具体的类型信息
     */
    protected constructor(type: Type) {
        this.type = Objects.requireNonNull(type, "Type cannot be null")
    }

    /**
     * 创建类型引用实例
     * @param <T> 目标类型
     * @return 类型引用实例
     */
    companion object {
        inline fun <reified T> of(): JsonTypeReference<T> {
            return object : JsonTypeReference<T>() {}
        }

        /**
         * 根据 Class 创建类型引用
         * @param clazz 目标类
         * @param <T> 目标类型
         * @return 类型引用实例
         */
        @JvmStatic
        fun <T> of(clazz: Class<T>): JsonTypeReference<T> {
            return object : JsonTypeReference<T>(clazz) {}
        }

        /**
         * 根据 Type 创建类型引用
         * @param type 目标类型
         * @param <T> 目标类型
         * @return 类型引用实例
         */
        @JvmStatic
        fun <T> of(type: Type): JsonTypeReference<T> {
            return object : JsonTypeReference<T>(type) {}
        }
    }

    /**
     * 获取原始类型（去掉泛型参数的类型）
     * @return 原始类型 Class
     */
    @Suppress("UNCHECKED_CAST")
    fun getRawType(): Class<T> {
        var rawType: Type = type

        // 如果是参数化类型，则提取原始类型部分
        if (type is ParameterizedType) {
            rawType = (type as ParameterizedType).rawType
        }

        if (rawType is Class<*>) {
            return rawType as Class<T>
        }

        throw IllegalStateException("无法获取原始类型: $type")
    }

    /**
     * 判断两个 JsonTypeReference 实例是否相等
     * @param other 另一个对象
     * @return 是否相等
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this.javaClass != other.javaClass) return false
        val that = other as JsonTypeReference<*>

        // 对于 ParameterizedType，需要更完整的比较
        if (this.type is ParameterizedType && that.type is ParameterizedType) {
            val thisParamType = this.type as ParameterizedType
            val thatParamType = that.type as ParameterizedType

            return (
                    Objects.equals(
                        thisParamType.rawType,
                        thatParamType.rawType
                    ) &&
                            thisParamType.actualTypeArguments.contentEquals(thatParamType.actualTypeArguments) &&
                            Objects.equals(
                                thisParamType.ownerType,
                                thatParamType.ownerType
                            )
                    )
        }

        return Objects.equals(type, that.type)
    }

    /**
     * 计算当前实例的哈希码
     * @return 哈希码值
     */
    override fun hashCode(): Int {
        if (type is ParameterizedType) {
            val paramType = type as ParameterizedType
            return Objects.hash(
                paramType.rawType,
                paramType.actualTypeArguments.contentHashCode(),
                paramType.ownerType
            )
        }
        return Objects.hash(type)
    }

    /**
     * 返回当前实例的字符串表示形式
     * @return 字符串描述
     */
    override fun toString(): String {
        return "com.mingliqiye.utils.json.JsonTypeReference<${TypeReference.getRawString(type)}>"
    }

    /**
     * 比较当前实例与另一个实例的大小关系
     * @param other 另一个 JsonTypeReference 实例
     * @return 比较结果
     */
    override fun compareTo(other: JsonTypeReference<T>): Int {
        return this.type.toString().compareTo(other.type.toString())
    }
}
