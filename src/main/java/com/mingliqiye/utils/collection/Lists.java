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
 * CurrentFile Lists.java
 * LastUpdate 2025-09-14 22:12:16
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.collection;

import com.mingliqiye.utils.random.RandomInt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lists工具类提供了一系列创建List实现的便捷方法。
 *
 * @author MingLiPro
 */
public class Lists {

	/**
	 * 创建一个空的ArrayList实例。
	 *
	 * @param <T> 列表元素的类型
	 * @return 新创建的空ArrayList实例
	 */
	public static <T> List<T> newArrayList() {
		return new ArrayList<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的ArrayList实例。
	 *
	 * @param ts  要添加到列表中的元素，可以为0个或多个
	 * @param <T> 列表元素的类型
	 * @return 包含指定元素的新ArrayList实例
	 */
	public static <T> List<T> newArrayList(T... ts) {
		List<T> list = newArrayList();
		list.addAll(Arrays.asList(ts));
		return list;
	}

	/**
	 * 根据已有列表创建一个新的ArrayList实例。
	 *
	 * @param list 要复制的列表
	 * @param <T>  列表元素的类型
	 * @return 包含原列表所有元素的新ArrayList实例
	 */
	public static <T> List<T> newArrayList(List<T> list) {
		List<T> newList = newArrayList();
		newList.addAll(list);
		return newList;
	}

	/**
	 * 根据可迭代对象创建一个ArrayList实例。
	 *
	 * @param iterable 可迭代对象
	 * @param <T>      列表元素的类型
	 * @return 包含可迭代对象中所有元素的新ArrayList实例
	 */
	public static <T> List<T> newArrayList(Iterable<T> iterable) {
		List<T> list = newArrayList();
		for (T t : iterable) {
			list.add(t);
		}
		return list;
	}

	/**
	 * 创建一个指定初始容量的空ArrayList实例。
	 *
	 * @param size 初始容量大小
	 * @param <T>  列表元素的类型
	 * @return 指定初始容量的空ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size) {
		return new ArrayList<>(size);
	}

	/**
	 * 创建一个指定大小并用单个元素填充的ArrayList实例。
	 *
	 * @param size 列表大小
	 * @param t    用于填充列表的元素
	 * @param <T>  列表元素的类型
	 * @return 指定大小且所有元素都相同的ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size, T t) {
		List<T> list = newArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(t);
		}
		return list;
	}

	/**
	 * 创建一个指定大小并交替使用两个元素填充的ArrayList实例。
	 *
	 * @param size 列表大小
	 * @param t    第一个填充元素（索引为偶数时使用）
	 * @param t1   第二个填充元素（索引为奇数时使用）
	 * @param <T>  列表元素的类型
	 * @return 指定大小且交替填充两个元素的ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size, T t, T t1) {
		List<T> list = newArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(i % 2 == 0 ? t : t1);
		}
		return list;
	}

	/**
	 * 创建一个指定大小并循环使用三个元素填充的ArrayList实例。
	 *
	 * @param size 列表大小
	 * @param t    第一个填充元素（索引模3等于0时使用）
	 * @param t1   第二个填充元素（索引模3等于1时使用）
	 * @param t2   第三个填充元素（索引模3等于2时使用）
	 * @param <T>  列表元素的类型
	 * @return 指定大小且循环填充三个元素的ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size, T t, T t1, T t2) {
		List<T> list = newArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(i % 3 == 0 ? t : i % 3 == 1 ? t1 : t2);
		}
		return list;
	}

	/**
	 * 创建一个指定大小并循环使用四个元素填充的ArrayList实例。
	 *
	 * @param size 列表大小
	 * @param t    第一个填充元素（索引模4等于0时使用）
	 * @param t1   第二个填充元素（索引模4等于1时使用）
	 * @param t2   第三个填充元素（索引模4等于2时使用）
	 * @param t3   第四个填充元素（索引模4等于3时使用）
	 * @param <T>  列表元素的类型
	 * @return 指定大小且循环填充四个元素的ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size, T t, T t1, T t2, T t3) {
		List<T> list = newArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(i % 4 == 0 ? t : i % 4 == 1 ? t1 : i % 4 == 2 ? t2 : t3);
		}
		return list;
	}

	/**
	 * 创建一个空的LinkedList实例。
	 *
	 * @param <T> 列表元素的类型
	 * @return 新创建的空LinkedList实例
	 */
	public static <T> List<T> newLinkedList() {
		return new LinkedList<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的LinkedList实例。
	 *
	 * @param ts  要添加到列表中的元素，可以为0个或多个
	 * @param <T> 列表元素的类型
	 * @return 包含指定元素的新LinkedList实例
	 */
	public static <T> List<T> newLinkedList(T... ts) {
		List<T> list = newLinkedList();
		list.addAll(Arrays.asList(ts));
		return list;
	}

	/**
	 * 根据已有列表创建一个新的LinkedList实例。
	 *
	 * @param list 要复制的列表
	 * @param <T>  列表元素的类型
	 * @return 包含原列表所有元素的新LinkedList实例
	 */
	public static <T> List<T> newLinkedList(List<T> list) {
		List<T> newList = newLinkedList();
		newList.addAll(list);
		return newList;
	}

	/**
	 * 创建一个空的Vector实例。
	 *
	 * @param <T> 列表元素的类型
	 * @return 新创建的空Vector实例
	 */
	public static <T> List<T> newVector() {
		return new Vector<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的Vector实例。
	 *
	 * @param ts  要添加到列表中的元素，可以为0个或多个
	 * @param <T> 列表元素的类型
	 * @return 包含指定元素的新Vector实例
	 */
	public static <T> List<T> newVector(T... ts) {
		List<T> list = newVector();
		list.addAll(Arrays.asList(ts));
		return list;
	}

	/**
	 * 根据已有列表创建一个新的Vector实例。
	 *
	 * @param list 要复制的列表
	 * @param <T>  列表元素的类型
	 * @return 包含原列表所有元素的新Vector实例
	 */
	public static <T> List<T> newVector(List<T> list) {
		List<T> newList = newVector();
		newList.addAll(list);
		return newList;
	}

	/**
	 * 将指定列表中的每个元素转换为字符串表示形式
	 *
	 * @param <T>  列表元素的类型
	 * @param list 要转换的列表，不能为空
	 * @return 包含原列表各元素字符串表示的新列表，保持相同的顺序
	 */
	public static <T> List<String> toStringList(@NotNull List<T> list) {
		// 创建与原列表相同大小的新列表，用于存储字符串转换结果
		List<String> newList = newArrayList(list.size());
		for (T t : list) {
			newList.add(t == null ? "null" : t.toString());
		}
		return newList;
	}

	/**
	 * 将指定数组中的每个元素转换为字符串表示形式
	 *
	 * @param <T>  数组元素的类型
	 * @param list 要转换的数组，不能为空
	 * @return 包含原数组各元素字符串表示的新字符串数组
	 */
	public static <T> String[] toStringList(@NotNull T[] list) {
		// 创建新的字符串列表，用于存储转换后的结果
		List<String> newList = newArrayList(list.length);
		for (T t : list) {
			newList.add(t == null ? "null" : t.toString());
		}
		return newList.toArray(new String[0]);
	}

	/**
	 * 将列表转换为数组
	 *
	 * @param ts  要转换的列表
	 * @param <T> 数组元素的类型
	 * @return 包含列表中所有元素的数组，如果列表为null则返回null
	 */
	@Nullable
	public static <T> T[] toArray(List<T> ts) {
		if (ts == null) {
			return null;
		}
		T[] items = (T[]) new Object[ts.size()];
		ForEach.forEach(ts, (t, i) -> items[i] = t);
		return items;
	}

	/**
	 * 将数组转换为列表
	 *
	 * @param ts  要转换的数组
	 * @param <T> 列表元素的类型
	 * @return 包含数组中所有元素的列表，如果数组为null则返回null
	 */
	// 原始的方法 - 用于引用类型
	@Nullable
	public static <T> List<T> toList(T[] ts) {
		return ts == null ? null : new ArrayList<>(Arrays.asList(ts));
	}

	@NotNull
	public static <T> List<T> toList(Stream<T> ts) {
		return ts == null
			? newArrayList()
			: new ArrayList<>(ts.collect(Collectors.toList()));
	}

	/**
	 * 将int数组转换为Integer列表
	 *
	 * @param array 要转换的int数组
	 * @return 包含数组中所有元素的Integer列表，如果数组为null则返回null
	 */
	@Nullable
	public static List<Integer> toList(int[] array) {
		if (array == null) {
			return null;
		}
		List<Integer> list = new ArrayList<>(array.length);
		for (int value : array) {
			list.add(value);
		}
		return list;
	}

	/**
	 * 将long数组转换为Long列表
	 *
	 * @param array 要转换的long数组
	 * @return 包含数组中所有元素的Long列表，如果数组为null则返回null
	 */
	@Nullable
	public static List<Long> toList(long[] array) {
		if (array == null) {
			return null;
		}
		List<Long> list = new ArrayList<>(array.length);
		for (long value : array) {
			list.add(value);
		}
		return list;
	}

	/**
	 * 将double数组转换为Double列表
	 *
	 * @param array 要转换的double数组
	 * @return 包含数组中所有元素的Double列表，如果数组为null则返回null
	 */
	@Nullable
	public static List<Double> toList(double[] array) {
		if (array == null) {
			return null;
		}
		List<Double> list = new ArrayList<>(array.length);
		for (double value : array) {
			list.add(value);
		}
		return list;
	}

	/**
	 * 将float数组转换为Float列表
	 *
	 * @param array 要转换的float数组
	 * @return 包含数组中所有元素的Float列表，如果数组为null则返回null
	 */
	@Nullable
	public static List<Float> toList(float[] array) {
		if (array == null) {
			return null;
		}
		List<Float> list = new ArrayList<>(array.length);
		for (float value : array) {
			list.add(value);
		}
		return list;
	}

	/**
	 * 将boolean数组转换为Boolean列表
	 *
	 * @param array 要转换的boolean数组
	 * @return 包含数组中所有元素的Boolean列表，如果数组为null则返回null
	 */
	@Nullable
	public static List<Boolean> toList(boolean[] array) {
		if (array == null) {
			return null;
		}
		List<Boolean> list = new ArrayList<>(array.length);
		for (boolean value : array) {
			list.add(value);
		}
		return list;
	}

	/**
	 * 将char数组转换为Character列表
	 *
	 * @param array 要转换的char数组
	 * @return 包含数组中所有元素的Character列表，如果数组为null则返回null
	 */
	@Nullable
	public static List<Character> toList(char[] array) {
		if (array == null) {
			return null;
		}
		List<Character> list = new ArrayList<>(array.length);
		for (char value : array) {
			list.add(value);
		}
		return list;
	}

	/**
	 * 将byte数组转换为Byte列表
	 *
	 * @param array 要转换的byte数组
	 * @return 包含数组中所有元素的Byte列表，如果数组为null则返回null
	 */
	@Nullable
	public static List<Byte> toList(byte[] array) {
		if (array == null) {
			return null;
		}
		List<Byte> list = new ArrayList<>(array.length);
		for (byte value : array) {
			list.add(value);
		}
		return list;
	}

	/**
	 * 将short数组转换为Short列表
	 *
	 * @param array 要转换的short数组
	 * @return 包含数组中所有元素的Short列表，如果数组为null则返回null
	 */
	@Nullable
	public static List<Short> toList(short[] array) {
		if (array == null) {
			return null;
		}
		List<Short> list = new ArrayList<>(array.length);
		for (short value : array) {
			list.add(value);
		}
		return list;
	}

	public static <T> List<T> toList(Iterator<T> iterator) {
		List<T> list = newArrayList(10);
		ForEach.forEach(iterator, item -> list.add(item));
		return list;
	}

	public <T> T getFirst(Collection<T> collectors) {
		return com.mingliqiye.utils.collection.Collection.getFirst(collectors);
	}

	public <T> T getLast(Collection<T> collectors) {
		return com.mingliqiye.utils.collection.Collection.getFirst(collectors);
	}

	public <T> T getAny(Collection<T> collectors) {
		return com.mingliqiye.utils.collection.Collection.getOrDefault(
			collectors,
			RandomInt.randomInt(0, collectors.size()),
			null
		);
	}
}
