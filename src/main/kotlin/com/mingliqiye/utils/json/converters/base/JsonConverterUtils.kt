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
 * CurrentFile JsonConverterUtils.kt
 * LastUpdate 2026-02-07 22:33:09
 * UpdateUser MingLiPro
 */
@file:JvmName("JsonConverterUtils")

package com.mingliqiye.utils.json.converters.base


import com.mingliqiye.utils.logger.MingLiLoggerFactory
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

val log = MingLiLoggerFactory.getLogger("com.mingliqiye.utils.json.converters.base.JsonConverterUtils")

/**
 * 获取给定类型的实际类对象。
 *
 * @param type 类型对象，可以是Class、ParameterizedType或其他Type的实现。
 * @return 返回与给定类型对应的Class对象；如果无法解析，则返回null。
 */
fun getClass(type: Type?): Class<*>? {
    // 尝试将type直接转换为Class类型，如果失败则检查是否为ParameterizedType
    val clazz: Class<*>? = type as? Class<*> ?: if (type is ParameterizedType) {
        // 如果是ParameterizedType，则递归获取其原始类型
        getClass(type.rawType)
    } else {
        null
    }
    return clazz
}

inline fun <reified T : JsonConverter<*, *>> getJsonConverter(): T = getJsonConverter(T::class.java)

fun <T : JsonConverter<*, *>> getJsonConverter(clazz: Class<T>): T {
    try {
        return clazz.getDeclaredMethod(
            "getJsonConverter"
        ).invoke(null) as T
    } catch (e: Exception) {
        log.error("实现于 JsonConverter<*, *> 的类 必须实现静态方法 JsonConverter<*, *> getJsonConverter()", e)
        throw e
    }
}
