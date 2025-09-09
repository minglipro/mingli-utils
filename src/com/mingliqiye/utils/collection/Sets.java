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
 * CurrentFile Sets.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.collection;

import java.util.*;

/**
 * Sets工具类提供了一系列创建Set实现的便捷方法。
 *
 * @author MingLiPro
 */
public class Sets {

	/**
	 * 创建一个空的HashSet实例。
	 *
	 * @param <T> 集合元素的类型
	 * @return 新创建的空HashSet实例
	 */
	public static <T> Set<T> newHashSet() {
		return new HashSet<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的HashSet实例。
	 *
	 * @param ts  要添加到集合中的元素，可以为0个或多个
	 * @param <T> 集合元素的类型
	 * @return 包含指定元素的新HashSet实例
	 */
	public static <T> Set<T> newHashSet(T... ts) {
		Set<T> set = newHashSet();
		set.addAll(Arrays.asList(ts));
		return set;
	}

	/**
	 * 根据已有集合创建一个新的HashSet实例。
	 *
	 * @param set 要复制的集合
	 * @param <T> 集合元素的类型
	 * @return 包含原集合所有元素的新HashSet实例
	 */
	public static <T> Set<T> newHashSet(Set<T> set) {
		Set<T> newSet = newHashSet();
		newSet.addAll(set);
		return newSet;
	}

	/**
	 * 根据可迭代对象创建一个HashSet实例。
	 *
	 * @param iterable 可迭代对象
	 * @param <T>      集合元素的类型
	 * @return 包含可迭代对象中所有元素的新HashSet实例
	 */
	public static <T> Set<T> newHashSet(Iterable<T> iterable) {
		Set<T> set = newHashSet();
		for (T t : iterable) {
			set.add(t);
		}
		return set;
	}

	/**
	 * 创建一个指定初始容量的空HashSet实例。
	 *
	 * @param size 初始容量大小
	 * @param <T>  集合元素的类型
	 * @return 指定初始容量的空HashSet实例
	 */
	public static <T> Set<T> newHashSet(int size) {
		return new HashSet<>(size);
	}

	/**
	 * 创建一个空的LinkedHashSet实例。
	 *
	 * @param <T> 集合元素的类型
	 * @return 新创建的空LinkedHashSet实例
	 */
	public static <T> Set<T> newLinkedHashSet() {
		return new LinkedHashSet<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的LinkedHashSet实例。
	 *
	 * @param ts  要添加到集合中的元素，可以为0个或多个
	 * @param <T> 集合元素的类型
	 * @return 包含指定元素的新LinkedHashSet实例
	 */
	public static <T> Set<T> newLinkedHashSet(T... ts) {
		Set<T> set = newLinkedHashSet();
		set.addAll(Arrays.asList(ts));
		return set;
	}

	/**
	 * 根据已有集合创建一个新的LinkedHashSet实例。
	 *
	 * @param set 要复制的集合
	 * @param <T> 集合元素的类型
	 * @return 包含原集合所有元素的新LinkedHashSet实例
	 */
	public static <T> Set<T> newLinkedHashSet(Set<T> set) {
		Set<T> newSet = newLinkedHashSet();
		newSet.addAll(set);
		return newSet;
	}

	/**
	 * 创建一个空的TreeSet实例。
	 *
	 * @param <T> 集合元素的类型，必须实现Comparable接口
	 * @return 新创建的空TreeSet实例
	 */
	public static <T extends Comparable<T>> Set<T> newTreeSet() {
		return new TreeSet<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的TreeSet实例。
	 *
	 * @param ts  要添加到集合中的元素，可以为0个或多个
	 * @param <T> 集合元素的类型，必须实现Comparable接口
	 * @return 包含指定元素的新TreeSet实例
	 */
	public static <T extends Comparable<T>> Set<T> newTreeSet(T... ts) {
		Set<T> set = newTreeSet();
		set.addAll(Arrays.asList(ts));
		return set;
	}

	/**
	 * 根据已有集合创建一个新的TreeSet实例。
	 *
	 * @param set 要复制的集合
	 * @param <T> 集合元素的类型，必须实现Comparable接口
	 * @return 包含原集合所有元素的新TreeSet实例
	 */
	public static <T extends Comparable<T>> Set<T> newTreeSet(Set<T> set) {
		Set<T> newSet = newTreeSet();
		newSet.addAll(set);
		return newSet;
	}
}
