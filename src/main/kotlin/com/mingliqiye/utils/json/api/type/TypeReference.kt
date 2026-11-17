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
 * LastUpdate 2026-02-26 14:11:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api.type

import com.mingliqiye.utils.string.join
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.lang.reflect.WildcardType

/**
 * 参数化类型的简单实现，用于在运行时构造并描述带泛型参数的类型
 *
 * @property rawClass 原始类型（如 List::class.java）
 * @param paramType 泛型参数类型列表
 */
class TypeReference(
	val rawClass: Type,
	vararg paramType: Type,
) : ParameterizedType {

	private val typeArguments: Array<out Type> = paramType
	override fun getActualTypeArguments(): Array<out Type> = typeArguments

	override fun getRawType(): Type = rawClass

	override fun getOwnerType(): Type? = null


	/**
	 * 返回"原始类型<参数1,参数2>"形式的类型描述字符串
	 */
	override fun toString(): String = "${getRawString(rawClass)}<${
		",".join(typeArguments) { getRawString(it) }
	}>"

	/**
	 * 伴生对象，提供类型描述与TypeReference的工厂方法
	 */
	companion object {

		/**
		 * 获取类型的完整描述字符串，支持通配符与参数化类型
		 *
		 * @param type 类型对象
		 * @return 类型的描述字符串
		 */
		fun getRawString(type: Type): String {
			return when (type) {
				is Class<*> -> type.name
				is WildcardType -> {
					val upperBounds = type.upperBounds
					val lowerBounds = type.lowerBounds
					when {
						upperBounds.isNotEmpty() && upperBounds[0] != Any::class.java -> {
							"? extends ${getRawString(upperBounds[0])}"
						}

						lowerBounds.isNotEmpty() -> {
							"? super ${getRawString(lowerBounds[0])}"
						}

						else -> "?"
					}
				}

				is ParameterizedType -> {
					of(type).toString()
				}

				else -> type.typeName
			}
		}

		/**
		 * 根据 reified 泛型参数创建TypeReference
		 *
		 * @param <T> 目标类型
		 * @return TypeReference实例
		 */
		inline fun <reified T> of(): TypeReference {
			return of((object : JsonTypeReference<T>() {}).type)
		}

		/**
		 * 将任意Type转换为TypeReference
		 *
		 * @param type 类型对象，支持Class、ParameterizedType和WildcardType
		 * @return TypeReference实例
		 * @throws IllegalStateException 当类型无法识别时抛出
		 */
		fun of(type: Type): TypeReference {
			return when (type) {
				is Class<*> -> TypeReference(type)
				is ParameterizedType -> TypeReference(type.rawType, *type.actualTypeArguments)
				is WildcardType -> {
					// 处理通配符类型，返回上界类型
					val upperBound = type.upperBounds.firstOrNull() ?: Any::class.java
					TypeReference(upperBound)
				}

				else -> throw IllegalStateException("无法获取类型: $type")
			}
		}
	}
}
