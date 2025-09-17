/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile JsonTypeUtils.kt
 * LastUpdate 2025-09-17 11:12:06
 * UpdateUser MingLiPro
 */
@file:JvmName("JsonTypeUtils")

package com.mingliqiye.utils.json

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*


/**
 * 检查给定的类型是否是指定类或其子类/实现类。
 *
 * @param type          要检查的类型
 * @param expectedClass 期望匹配的类
 * @return 如果类型匹配则返回 true，否则返回 false
 */
fun isTypeOf(type: Type, expectedClass: Class<*>): Boolean {
    return when (type) {
        is Class<*> -> expectedClass.isAssignableFrom(type)
        is ParameterizedType -> isTypeOf(type.rawType, expectedClass)
        else -> false
    }
}

/**
 * 获取泛型类型的参数类型。
 *
 * @param type  泛型类型
 * @param index 参数索引（从0开始）
 * @return 指定位置的泛型参数类型
 * @throws IllegalArgumentException 当无法获取指定索引的泛型参数时抛出异常
 */
fun getGenericParameter(type: Type, index: Int): Type {
    if (type is ParameterizedType) {
        val typeArgs = type.actualTypeArguments
        if (index >= 0 && index < typeArgs.size) {
            return typeArgs[index]
        }
    }
    throw IllegalArgumentException(
        "无法获取泛型参数: $type at index $index"
    )
}

/**
 * 获取类型名称，支持普通类和泛型类型。
 *
 * @param type 类型对象
 * @return 类型名称字符串
 */
fun getTypeName(type: Type): String {
    return when (type) {
        is Class<*> -> type.simpleName
        is ParameterizedType -> {
            val rawType = type.rawType as Class<*>
            val typeArgs = type.actualTypeArguments

            val sb = StringBuilder(rawType.simpleName)
            sb.append("<")
            for (i in typeArgs.indices) {
                if (i > 0) sb.append(", ")
                sb.append(getTypeName(typeArgs[i]))
            }
            sb.append(">")
            sb.toString()
        }

        else -> type.typeName
    }
}

/**
 * 创建一个表示数组类型的引用对象。
 *
 * @param componentType 数组元素的类型
 * @param <T>           元素类型
 * @return 表示数组类型的 JsonTypeReference 对象
 */
fun <T> arrayType(componentType: Class<T>): JsonTypeReference<Array<T>> {
    return object : JsonTypeReference<Array<T>>() {
        private val arrayType: Type = java.lang.reflect.Array.newInstance(
            componentType, 0
        ).javaClass

        override var type: Type = Any::class.java
            get() = object : ParameterizedType {
                private val actualTypeArguments = arrayOf<Type>(componentType)

                override fun getActualTypeArguments(): Array<Type> {
                    return actualTypeArguments
                }

                override fun getRawType(): Type {
                    return arrayType
                }

                override fun getOwnerType(): Type? {
                    return null
                }
            }
    }
}

/**
 * 创建一个表示 List 类型的引用对象。
 *
 * @param componentType List 中元素的类型
 * @param <T>           元素类型
 * @return 表示 List 类型的 JsonTypeReference 对象
 * @throws IllegalArgumentException 如果 componentType 为 null，则抛出异常
 */
fun <T> listType(componentType: Class<T>): JsonTypeReference<List<T>> {

    return object : JsonTypeReference<List<T>>() {
        override var type: Type = Any::class.java
            get() = object : ParameterizedType {
                override fun getActualTypeArguments(): Array<Type> {
                    return arrayOf(componentType)
                }

                override fun getRawType(): Type {
                    return List::class.java
                }

                override fun getOwnerType(): Type? {
                    return null
                }
            }
    }
}

/**
 * 创建一个表示 Map 类型的引用对象。
 *
 * @param keyType   Map 键的类型
 * @param valueType Map 值的类型
 * @param <K>       键类型
 * @param <V>       值类型
 * @return 表示 Map 类型的 JsonTypeReference 对象
 * @throws IllegalArgumentException 如果 keyType 或 valueType 为 null，则抛出异常
 */
fun <K, V> MapType(keyType: Class<K>, valueType: Class<V>): JsonTypeReference<Map<K, V>> {

    return object : JsonTypeReference<Map<K, V>>() {
        override var type: Type = Any::class.java
            get() = object : ParameterizedType {
                override fun getActualTypeArguments(): Array<Type> {
                    return arrayOf(keyType, valueType)
                }

                override fun getRawType(): Type {
                    return Map::class.java
                }

                override fun getOwnerType(): Type? {
                    return null
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) return true
                    if (other !is ParameterizedType) return false

                    val that = other
                    return (Objects.equals(
                        rawType,
                        that.rawType
                    ) && actualTypeArguments.contentEquals(that.actualTypeArguments) && Objects.equals(
                        ownerType,
                        that.ownerType
                    ))
                }

                override fun hashCode(): Int {
                    return (actualTypeArguments.contentHashCode() xor Objects.hashCode(rawType) xor Objects.hashCode(
                        ownerType
                    ))
                }
            }
    }
}
