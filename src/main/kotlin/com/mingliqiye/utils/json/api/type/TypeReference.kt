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
 * CurrentFile TypeReference.kt
 * LastUpdate 2026-02-04 21:00:48
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api.type

import com.mingliqiye.utils.string.join
import sun.reflect.generics.reflectiveObjects.WildcardTypeImpl
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class TypeReference(
    val rawClass: Type,
    vararg paramType: Type
) : ParameterizedType {

    private val typeArguments: Array<out Type> = paramType
    override fun getActualTypeArguments(): Array<out Type> = typeArguments

    override fun getRawType(): Type = rawClass

    override fun getOwnerType(): Type? = null


    override fun toString(): String = "${getRawString(rawType)}<${
        ",".join(typeArguments, TypeReference::getRawString)
    }>"

    companion object {

        fun getRawString(s: Any): String {
            if (s is Class<*>) {
                return s.name
            }
            if (s is WildcardTypeImpl) {
                return getRawString(s.upperBounds[0])
            }
            if (s is ParameterizedType) {
                return of(s).toString()
            }
            return s.toString()
        }

        inline fun <reified T> of(): TypeReference {
            return of((object : JsonTypeReference<T>() {}).type)
        }

        fun of(type: Type): TypeReference {
            if (type is Class<*>) {
                return TypeReference(type)
            }
            if (type is ParameterizedType) {
                return TypeReference(type.rawType, *type.actualTypeArguments)
            }
            throw IllegalStateException("无法获取类型: $type")
        }
    }
}
