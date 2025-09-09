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
 * CurrentFile JsonTypeUtils.java
 * LastUpdate 2025-09-09 09:18:08
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * JSON 类型工具类，提供类型相关的工具方法
 */
public class JsonTypeUtils {

	private JsonTypeUtils() {
		// 工具类，防止实例化
	}

	/**
	 * 检查给定的类型是否是指定类或其子类/实现类。
	 *
	 * @param type          要检查的类型
	 * @param expectedClass 期望匹配的类
	 * @return 如果类型匹配则返回 true，否则返回 false
	 */
	public static boolean isTypeOf(Type type, Class<?> expectedClass) {
		if (type instanceof Class) {
			return expectedClass.isAssignableFrom((Class<?>) type);
		} else if (type instanceof ParameterizedType) {
			return isTypeOf(
				((ParameterizedType) type).getRawType(),
				expectedClass
			);
		}
		return false;
	}

	/**
	 * 获取泛型类型的参数类型。
	 *
	 * @param type  泛型类型
	 * @param index 参数索引（从0开始）
	 * @return 指定位置的泛型参数类型
	 * @throws IllegalArgumentException 当无法获取指定索引的泛型参数时抛出异常
	 */
	public static Type getGenericParameter(Type type, int index) {
		if (type instanceof ParameterizedType) {
			Type[] typeArgs =
				((ParameterizedType) type).getActualTypeArguments();
			if (index >= 0 && index < typeArgs.length) {
				return typeArgs[index];
			}
		}
		throw new IllegalArgumentException(
			"无法获取泛型参数: " + type + " at index " + index
		);
	}

	/**
	 * 获取类型名称，支持普通类和泛型类型。
	 *
	 * @param type 类型对象
	 * @return 类型名称字符串
	 */
	public static String getTypeName(Type type) {
		if (type instanceof Class) {
			return ((Class<?>) type).getSimpleName();
		} else if (type instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) type;
			Class<?> rawType = (Class<?>) pType.getRawType();
			Type[] typeArgs = pType.getActualTypeArguments();

			StringBuilder sb = new StringBuilder(rawType.getSimpleName());
			sb.append("<");
			for (int i = 0; i < typeArgs.length; i++) {
				if (i > 0) sb.append(", ");
				sb.append(getTypeName(typeArgs[i]));
			}
			sb.append(">");
			return sb.toString();
		}
		return type.getTypeName();
	}

	/**
	 * 创建一个表示数组类型的引用对象。
	 *
	 * @param componentType 数组元素的类型
	 * @param <T>           元素类型
	 * @return 表示数组类型的 JsonTypeReference 对象
	 */
	public static <T> JsonTypeReference<T[]> arrayType(Class<T> componentType) {
		return new JsonTypeReference<T[]>() {
			private final Type arrayType = java.lang.reflect.Array.newInstance(
				componentType,
				0
			).getClass();

			@Override
			public Type getType() {
				return new ParameterizedType() {
					private final Type[] actualTypeArguments = new Type[] {
						componentType,
					};

					@Override
					public Type[] getActualTypeArguments() {
						return actualTypeArguments;
					}

					@Override
					public Type getRawType() {
						return arrayType;
					}

					@Override
					public Type getOwnerType() {
						return null;
					}
				};
			}
		};
	}

	/**
	 * 创建一个表示 List 类型的引用对象。
	 *
	 * @param componentType List 中元素的类型
	 * @param <T>           元素类型
	 * @return 表示 List 类型的 JsonTypeReference 对象
	 * @throws IllegalArgumentException 如果 componentType 为 null，则抛出异常
	 */
	public static <T> JsonTypeReference<List<T>> listType(
		Class<T> componentType
	) {
		if (componentType == null) {
			throw new IllegalArgumentException("componentType cannot be null");
		}

		return new JsonTypeReference<List<T>>() {
			@Override
			public Type getType() {
				return new ParameterizedType() {
					@Override
					public Type[] getActualTypeArguments() {
						return new Type[] { componentType };
					}

					@Override
					public Type getRawType() {
						return List.class;
					}

					@Override
					public Type getOwnerType() {
						return null;
					}
				};
			}
		};
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
	public static <K, V> JsonTypeReference<Map<K, V>> MapType(
		Class<K> keyType,
		Class<V> valueType
	) {
		if (keyType == null) {
			throw new IllegalArgumentException("keyType cannot be null");
		}
		if (valueType == null) {
			throw new IllegalArgumentException("valueType cannot be null");
		}

		return new JsonTypeReference<Map<K, V>>() {
			@Override
			public Type getType() {
				return new ParameterizedType() {
					@Override
					public Type[] getActualTypeArguments() {
						return new Type[] { keyType, valueType };
					}

					@Override
					public Type getRawType() {
						return Map.class;
					}

					@Override
					public Type getOwnerType() {
						return null;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj) return true;
						if (!(obj instanceof ParameterizedType)) return false;

						ParameterizedType that = (ParameterizedType) obj;
						return (
							Objects.equals(getRawType(), that.getRawType()) &&
							Arrays.equals(
								getActualTypeArguments(),
								that.getActualTypeArguments()
							) &&
							Objects.equals(getOwnerType(), that.getOwnerType())
						);
					}

					@Override
					public int hashCode() {
						return (
							Arrays.hashCode(getActualTypeArguments()) ^
							Objects.hashCode(getRawType()) ^
							Objects.hashCode(getOwnerType())
						);
					}
				};
			}
		};
	}
}
