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
 * CurrentFile Maps.kt
 * LastUpdate 2026-03-11 08:46:40
 * UpdateUser MingLiPro
 */

@file:JvmName("Maps")

package com.mingliqiye.utils.map

import java.util.*
import java.util.concurrent.ConcurrentHashMap


/**
 * 使用键值对可变参数创建一个新的 HashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param elements 键值对可变参数列表
 * @return 新创建的 HashMap
 */
fun <K, V> newHashMap(vararg elements: Pair<K, V>): HashMap<K, V> {
	val map = HashMap<K, V>()
	for (element in elements) {
		map[element.first] = element.second
	}
	return map
}

/**
 * 创建一个指定初始容量的新 HashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param size 初始容量大小
 * @return 新创建的 HashMap
 */
fun <K, V> newHashMap(size: Int): HashMap<K, V> {
	return HashMap(size)
}

/**
 * 创建一个新的 HashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @return 新创建的 HashMap
 */
fun <K, V> newHashMap(): HashMap<K, V> {
	return HashMap()
}

/**
 * 使用 Map.Entry 可变参数创建一个新的 HashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param elements 映射项可变参数列表
 * @return 新创建的 HashMap
 */
fun <K, V> newHashMap(vararg elements: Map.Entry<K, V>): HashMap<K, V> {
	val map = HashMap<K, V>()
	for (element in elements) {
		map[element.key] = element.value
	}
	return map
}

/**
 * 使用 Map.Entry 可变参数创建一个新的 ConcurrentHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param elements 映射项可变参数列表
 * @return 新创建的 ConcurrentHashMap
 */
fun <K, V> newConcurrentHashMap(vararg elements: Map.Entry<K, V>): ConcurrentHashMap<K, V> {
	val map = newConcurrentHashMap<K, V>()
	for (element in elements) {
		map[element.key] = element.value
	}
	return map
}

/**
 * 使用 Map.Entry 可变参数创建一个新的 LinkedHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param elements 映射项可变参数列表
 * @return 新创建的 LinkedHashMap
 */
fun <K, V> newLinkedHashMap(vararg elements: Map.Entry<K, V>): LinkedHashMap<K, V> {
	val map = newLinkedHashMap<K, V>()
	for (element in elements) {
		map[element.key] = element.value
	}
	return map
}

/**
 * 使用 Map.Entry 可变参数创建一个新的 Hashtable 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param elements 映射项可变参数列表
 * @return 新创建的 Hashtable
 */
fun <K, V> newHashtable(vararg elements: Map.Entry<K, V>): Hashtable<K, V> {
	val map = newHashtable<K, V>()
	for (element in elements) {
		map[element.key] = element.value
	}
	return map
}

/**
 * 使用 Map.Entry 可变参数创建一个新的 TreeMap 实例。
 *
 * @param K 键类型，必须实现 Comparable 接口
 * @param V 值类型
 * @param elements 映射项可变参数列表
 * @return 新创建的 TreeMap
 */
fun <K : Comparable<K>, V> newTreeMap(vararg elements: Map.Entry<K, V>): TreeMap<K, V> {
	val map = newTreeMap<K, V>()
	for (element in elements) {
		map[element.key] = element.value
	}
	return map
}

/**
 * 将当前 Map 转换为新的 HashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @return 新创建的 HashMap
 */
inline fun <reified K, reified V> Map<K, V>.newHashMap(): HashMap<K, V> {
	return HashMap(this)
}

/**
 * 创建一个新的 LinkedHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @return 新创建的 LinkedHashMap
 */
fun <K, V> newLinkedHashMap(): LinkedHashMap<K, V> {
	return LinkedHashMap()
}

/**
 * 创建一个指定初始容量的新 LinkedHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param size 初始容量大小
 * @return 新创建的 LinkedHashMap
 */
fun <K, V> newLinkedHashMap(size: Int): LinkedHashMap<K, V> {
	return LinkedHashMap(size)
}

/**
 * 使用键值对可变参数创建一个新的 LinkedHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param elements 键值对可变参数列表
 * @return 新创建的 LinkedHashMap
 */
fun <K, V> newLinkedHashMap(vararg elements: Pair<K, V>): LinkedHashMap<K, V> {
	val map = newLinkedHashMap<K, V>()
	for (element in elements) {
		map[element.first] = element.second
	}
	return map
}

/**
 * 将当前 Map 转换为新的 LinkedHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @return 新创建的 LinkedHashMap
 */
inline fun <reified K, reified V> Map<K, V>.newLinkedHashMap(): LinkedHashMap<K, V> {
	return LinkedHashMap(this)
}

/**
 * 创建一个新的 TreeMap 实例。
 *
 * @param K 键类型，必须实现 Comparable 接口
 * @param V 值类型
 * @return 新创建的 TreeMap
 */
fun <K : Comparable<K>, V> newTreeMap(): TreeMap<K, V> {
	return TreeMap()
}

/**
 * 使用键值对可变参数创建一个新的 TreeMap 实例。
 *
 * @param K 键类型，必须实现 Comparable 接口
 * @param V 值类型
 * @param elements 键值对可变参数列表
 * @return 新创建的 TreeMap
 */
fun <K : Comparable<K>, V> newTreeMap(vararg elements: Pair<K, V>): TreeMap<K, V> {
	val map = newTreeMap<K, V>()
	for (element in elements) {
		map[element.first] = element.second
	}
	return map
}

/**
 * 将当前 Map 转换为新的 TreeMap 实例。
 *
 * @param K 键类型，必须实现 Comparable 接口
 * @param V 值类型
 * @return 新创建的 TreeMap
 */
inline fun <reified K : Comparable<K>, reified V> Map<K, V>.newTreeMap(): TreeMap<K, V> {
	return TreeMap(this)
}

/**
 * 创建一个新的 Hashtable 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @return 新创建的 Hashtable
 */
fun <K, V> newHashtable(): Hashtable<K, V> {
	return Hashtable()
}

/**
 * 创建一个指定初始容量的新 Hashtable 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param size 初始容量大小
 * @return 新创建的 Hashtable
 */
fun <K, V> newHashtable(size: Int): Hashtable<K, V> {
	return Hashtable(size)
}

/**
 * 使用键值对可变参数创建一个新的 Hashtable 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param elements 键值对可变参数列表
 * @return 新创建的 Hashtable
 */
fun <K, V> newHashtable(vararg elements: Pair<K, V>): Hashtable<K, V> {
	val map = newHashtable<K, V>()
	for (element in elements) {
		map[element.first] = element.second
	}
	return map
}

/**
 * 将当前 Map 转换为新的 Hashtable 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @return 新创建的 Hashtable
 */
inline fun <reified K, reified V> Map<K, V>.newHashtable(): Hashtable<K, V> {
	val hashtable = Hashtable<K, V>()
	hashtable.putAll(this)
	return hashtable
}

/**
 * 创建一个新的 ConcurrentHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @return 新创建的 ConcurrentHashMap
 */
fun <K, V> newConcurrentHashMap(): ConcurrentHashMap<K, V> {
	return ConcurrentHashMap()
}

/**
 * 创建一个指定初始容量的新 ConcurrentHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param size 初始容量大小
 * @return 新创建的 ConcurrentHashMap
 */
fun <K, V> newConcurrentHashMap(size: Int): ConcurrentHashMap<K, V> {
	return ConcurrentHashMap(size)
}

/**
 * 使用键值对可变参数创建一个新的 ConcurrentHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @param elements 键值对可变参数列表
 * @return 新创建的 ConcurrentHashMap
 */
fun <K, V> newConcurrentHashMap(vararg elements: Pair<K, V>): ConcurrentHashMap<K, V> {
	val map = newConcurrentHashMap<K, V>()
	for (element in elements) {
		map[element.first] = element.second
	}
	return map
}

/**
 * 将当前 Map 转换为新的 ConcurrentHashMap 实例。
 *
 * @param K 键类型
 * @param V 值类型
 * @return 新创建的 ConcurrentHashMap
 */
inline fun <reified K, reified V> Map<K, V>.newConcurrentHashMap(): ConcurrentHashMap<K, V> {
	return ConcurrentHashMap(this)
}

/**
 * 将映射项列表转换为 Map。
 *
 * @param K 键类型
 * @param V 值类型
 * @param entries 映射项列表
 * @return 由映射项组成的 Map
 */
fun <K, V> ofEntries(entries: List<MutableMap.MutableEntry<K, V>>): Map<K, V> {
	return entries.associate { it.key to it.value }
}
