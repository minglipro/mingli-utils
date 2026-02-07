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
 * CurrentFile JackSonJsonConverter.kt
 * LastUpdate 2026-02-08 02:28:49
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule

interface JackSonJsonConverter<F, T> : JsonConverter<F, T> {

    companion object {
        /**
         * 扩展ObjectMapper，用于注册指定类型的模块。
         *
         * 此函数通过反射创建指定类型的实例，并调用其getJacksonModule方法来获取Jackson模块，
         * 然后将该模块注册到当前ObjectMapper实例中。
         *
         * @param T 必须继承自BaseJsonConverter的泛型类型。
         * @return 返回注册了模块后的ObjectMapper实例。
         */
        inline fun <reified T : BaseJsonConverter<*, *>> ObjectMapper.addJsonConverter(): ObjectMapper =
            this.registerModule(getJsonConverter<T>().getJacksonModule())

        @JvmStatic
        fun <T : BaseJsonConverter<*, *>> ObjectMapper.addJsonConverter(clazz: Class<T>): ObjectMapper =
            this.registerModule(getJsonConverter(clazz).getJacksonModule())
    }

    /**
     * 创建并返回一个 Jackson 模块，该模块包含自定义的序列化器和反序列化器。
     *
     * @return 配置了自定义序列化器和反序列化器的 SimpleModule 对象。
     */
    fun getJacksonModule(): SimpleModule =
        SimpleModule("${getFromClass().name}To${getToClass().name}")
            .addSerializer(getFromClass(), JackJsonSerializer(null, this))
            .addDeserializer(getFromClass(), JackJsonDeserializer(null, this))
}
