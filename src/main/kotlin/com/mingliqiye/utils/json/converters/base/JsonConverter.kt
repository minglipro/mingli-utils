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
 * CurrentFile JsonConverter.kt
 * LastUpdate 2026-02-05 11:18:33
 * UpdateUser MingLiPro
 */
@file:JvmName("JsonConverter")

package com.mingliqiye.utils.json.converters.base


import com.fasterxml.jackson.databind.ObjectMapper
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

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
        // 其他情况返回null
        null
    }
    return clazz
}

/**
 * 扩展ObjectMapper，用于注册指定类型的模块。
 *
 * 此函数通过反射创建指定类型的实例，并调用其getJacksonModule方法来获取Jackson模块，
 * 然后将该模块注册到当前ObjectMapper实例中。
 *
 * @param T 必须继承自BaseJsonConverter的泛型类型。
 * @return 返回注册了模块后的ObjectMapper实例。
 */
inline fun <reified T : BaseJsonConverter<*, *>> ObjectMapper.registerModule(): ObjectMapper =
    this.registerModule(T::class.java.newInstance().getJacksonModule())
