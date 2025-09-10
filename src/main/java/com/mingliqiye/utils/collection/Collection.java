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
 * CurrentFile Collection.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 集合工具类，提供对列表和数组的常用操作方法。
 *
 * @author MingLiPro
 */
public class Collection {

	/**
	 * 获取集合的第一个元素。
	 *
	 * @param collection 集合
	 * @param <T>        元素类型
	 * @return 第一个元素；如果集合为空或为null则返回 null
	 */
	@Nullable
	public static <T> T getFirst(@Nullable java.util.Collection<T> collection) {
		if (collection == null || collection.isEmpty()) {
			return null;
		}

		// 对于List类型，直接获取第一个元素
		if (collection instanceof List) {
			return ((List<T>) collection).get(0);
		}

		// 对于其他Collection类型，使用迭代器获取第一个元素
		return collection.iterator().next();
	}

	/**
	 * 获取数组的第一个元素。
	 *
	 * @param list 数组，不能为空
	 * @param <T>  元素类型
	 * @return 第一个元素；如果数组为空则返回 null
	 */
	@Nullable
	public static <T> T getFirst(@NotNull T[] list) {
		if (list.length == 0) {
			return null;
		}
		return list[0];
	}

	/**
	 * 获取集合的最后一个元素。
	 *
	 * @param collection 集合
	 * @param <T>        元素类型
	 * @return 最后一个元素；如果集合为空或为null则返回 null
	 */
	@Nullable
	public static <T> T getLast(@Nullable java.util.Collection<T> collection) {
		if (collection == null || collection.isEmpty()) {
			return null;
		}

		// 对于List类型，直接获取最后一个元素
		if (collection instanceof List) {
			List<T> list = (List<T>) collection;
			return list.get(list.size() - 1);
		}

		// 对于其他Collection类型，需要遍历到最后一个元素
		T lastElement = null;
		for (T element : collection) {
			lastElement = element;
		}
		return lastElement;
	}

	/**
	 * 获取数组的最后一个元素。
	 *
	 * @param list 数组，不能为空
	 * @param <T>  元素类型
	 * @return 最后一个元素；如果数组为空则返回 null
	 */
	@Nullable
	public static <T> T getLast(@NotNull T[] list) {
		if (list.length == 0) {
			return null;
		}
		return list[list.length - 1];
	}

	/**
	 * 获取列表中指定索引的元素，如果索引超出范围则返回默认值。
	 *
	 * @param list         列表
	 * @param index        索引
	 * @param defaultValue 默认值
	 * @param <T>          元素类型
	 * @return 指定索引的元素或默认值
	 */
	@Nullable
	public static <T> T getOrDefault(
		@NotNull List<T> list,
		int index,
		@Nullable T defaultValue
	) {
		if (index < 0 || index >= list.size()) {
			return defaultValue;
		}
		return list.get(index);
	}

	/**
	 * 获取数组中指定索引的元素，如果索引超出范围则返回默认值。
	 *
	 * @param array        数组
	 * @param index        索引
	 * @param defaultValue 默认值
	 * @param <T>          元素类型
	 * @return 指定索引的元素或默认值
	 */
	@Nullable
	public static <T> T getOrDefault(
		@NotNull T[] array,
		int index,
		@Nullable T defaultValue
	) {
		if (index < 0 || index >= array.length) {
			return defaultValue;
		}
		return array[index];
	}

	/**
	 * 获取列表的安全子列表，自动处理边界情况。
	 *
	 * @param list      原始列表
	 * @param fromIndex 起始索引（包含）
	 * @param toIndex   结束索引（不包含）
	 * @param <T>       元素类型
	 * @return 子列表
	 */
	@NotNull
	public static <T> List<T> safeSubList(
		@NotNull List<T> list,
		int fromIndex,
		int toIndex
	) {
		int size = list.size();
		if (size == 0) {
			return Collections.emptyList();
		}

		// 调整边界
		fromIndex = Math.max(0, fromIndex);
		toIndex = Math.min(size, toIndex);
		if (fromIndex >= toIndex) {
			return Collections.emptyList();
		}

		return list.subList(fromIndex, toIndex);
	}

	/**
	 * 判断列表是否为空或null。
	 *
	 * @param list 待检查的列表
	 * @return 如果列表为null或空则返回true，否则返回false
	 */
	public static boolean isEmpty(@Nullable List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * 判断数组是否为空或null。
	 *
	 * @param array 待检查的数组
	 * @return 如果数组为null或空则返回true，否则返回false
	 */
	public static boolean isEmpty(@Nullable Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 查找列表中第一个满足条件的元素。
	 *
	 * @param list      列表
	 * @param predicate 条件谓词
	 * @param <T>       元素类型
	 * @return 第一个满足条件的元素，如果没有则返回null
	 */
	@Nullable
	public static <T> T findFirst(
		@NotNull List<T> list,
		@NotNull Predicate<T> predicate
	) {
		for (T item : list) {
			if (predicate.test(item)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * 查找数组中第一个满足条件的元素。
	 *
	 * @param array     数组
	 * @param predicate 条件谓词
	 * @param <T>       元素类型
	 * @return 第一个满足条件的元素，如果没有则返回null
	 */
	@Nullable
	public static <T> T findFirst(
		@NotNull T[] array,
		@NotNull Predicate<T> predicate
	) {
		for (T item : array) {
			if (predicate.test(item)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * 过滤列表中满足条件的元素。
	 *
	 * @param list      原始列表
	 * @param predicate 条件谓词
	 * @param <T>       元素类型
	 * @return 包含满足条件元素的新列表
	 */
	@NotNull
	public static <T> List<T> filter(
		@NotNull List<T> list,
		@NotNull Predicate<T> predicate
	) {
		List<T> result = new ArrayList<>();
		for (T item : list) {
			if (predicate.test(item)) {
				result.add(item);
			}
		}
		return result;
	}

	/**
	 * 过滤数组中满足条件的元素。
	 *
	 * @param array     原始数组
	 * @param predicate 条件谓词
	 * @param <T>       元素类型
	 * @return 包含满足条件元素的新列表
	 */
	@NotNull
	public static <T> List<T> filter(
		@NotNull T[] array,
		@NotNull Predicate<T> predicate
	) {
		return filter(Arrays.asList(array), predicate);
	}

	/**
	 * 将列表转换为数组。
	 *
	 * @param list  列表
	 * @param clazz 元素类型class
	 * @param <T>   元素类型
	 * @return 转换后的数组
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public static <T> T[] toArray(
		@NotNull List<T> list,
		@NotNull Class<T> clazz
	) {
		T[] array = (T[]) java.lang.reflect.Array.newInstance(
			clazz,
			list.size()
		);
		return list.toArray(array);
	}

	/**
	 * 将集合转换为列表。
	 *
	 * @param collection 集合
	 * @param <T>        元素类型
	 * @return 转换后的列表
	 */
	@NotNull
	public static <T> List<T> toList(
		@NotNull java.util.Collection<T> collection
	) {
		return new ArrayList<>(collection);
	}
}
