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
 * CurrentFile JsonTypeReference.java
 * LastUpdate 2025-09-09 09:20:05
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import lombok.Getter;

/**
 * 通用的 JSON 类型引用类，用于在运行时保留泛型类型信息
 * 适用于所有 JSON 库（Jackson、Gson、Fastjson 等）
 *
 * @param <T> 引用的泛型类型
 */
@Getter
public abstract class JsonTypeReference<T>
	implements Comparable<JsonTypeReference<T>> {

	protected final Type type;

	/**
	 * 构造函数，通过反射获取泛型类型信息
	 * 仅供内部匿名子类使用
	 */
	protected JsonTypeReference() {
		Type superClass = getClass().getGenericSuperclass();

		// 检查是否为匿名子类，防止直接实例化导致无法获取泛型信息
		if (superClass instanceof Class) {
			throw new IllegalArgumentException(
				"必须使用匿名子类方式创建 JsonTypeReference，" +
				"例如: new JsonTypeReference<List<String>>() {}"
			);
		}

		this.type =
			((ParameterizedType) superClass).getActualTypeArguments()[0];
	}

	/**
	 * 构造函数，直接指定类型
	 * @param type 具体的类型信息
	 */
	protected JsonTypeReference(Type type) {
		this.type = Objects.requireNonNull(type, "Type cannot be null");
	}

	/**
	 * 创建类型引用实例
	 * @param <T> 目标类型
	 * @return 类型引用实例
	 */
	public static <T> JsonTypeReference<T> of() {
		return new JsonTypeReference<T>() {};
	}

	/**
	 * 根据 Class 创建类型引用
	 * @param clazz 目标类
	 * @param <T> 目标类型
	 * @return 类型引用实例
	 */
	public static <T> JsonTypeReference<T> of(Class<T> clazz) {
		return new JsonTypeReference<T>(clazz) {};
	}

	/**
	 * 根据 Type 创建类型引用
	 * @param type 目标类型
	 * @param <T> 目标类型
	 * @return 类型引用实例
	 */
	public static <T> JsonTypeReference<T> of(Type type) {
		return new JsonTypeReference<T>(type) {};
	}

	/**
	 * 获取原始类型（去掉泛型参数的类型）
	 * @return 原始类型 Class
	 */
	@SuppressWarnings("unchecked")
	public Class<T> getRawType() {
		Type rawType = type;

		// 如果是参数化类型，则提取原始类型部分
		if (type instanceof ParameterizedType) {
			rawType = ((ParameterizedType) type).getRawType();
		}

		if (rawType instanceof Class) {
			return (Class<T>) rawType;
		}

		throw new IllegalStateException("无法获取原始类型: " + type);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JsonTypeReference<?> that = (JsonTypeReference<?>) o;

		// 对于 ParameterizedType，需要更完整的比较
		if (
			this.type instanceof ParameterizedType &&
			that.type instanceof ParameterizedType
		) {
			ParameterizedType thisParamType = (ParameterizedType) this.type;
			ParameterizedType thatParamType = (ParameterizedType) that.type;

			return (
				Objects.equals(
					thisParamType.getRawType(),
					thatParamType.getRawType()
				) &&
				Arrays.equals(
					thisParamType.getActualTypeArguments(),
					thatParamType.getActualTypeArguments()
				) &&
				Objects.equals(
					thisParamType.getOwnerType(),
					thatParamType.getOwnerType()
				)
			);
		}

		return Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		// 针对 ParameterizedType 进行完整哈希计算
		if (type instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType) type;
			return Objects.hash(
				paramType.getRawType(),
				Arrays.hashCode(paramType.getActualTypeArguments()),
				paramType.getOwnerType()
			);
		}
		return Objects.hash(type);
	}

	@Override
	public String toString() {
		return "JsonTypeReference{" + type + '}';
	}

	@Override
	public int compareTo(JsonTypeReference<T> o) {
		return this.type.toString().compareTo(o.type.toString());
	}
}
