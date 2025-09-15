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
 * CurrentFile Maps.kt
 * LastUpdate 2025-09-15 08:33:24
 * UpdateUser MingLiPro
 */

@file:JvmName("Maps")

package com.mingliqiye.utils.map

import java.util.*
import java.util.concurrent.ConcurrentHashMap


fun <K, V> newHashMap(vararg elements: Pair<K, V>): HashMap<K, V> {
    val map = HashMap<K, V>()
    for (element in elements) {
        map[element.first] = element.second
    }
    return map
}

fun <K, V> newHashMap(size: Int): HashMap<K, V> {
    return HashMap(size)
}

fun <K, V> newHashMap(vararg elements: Map.Entry<K, V>): HashMap<K, V> {
    val map = HashMap<K, V>()
    for (element in elements) {
        map[element.key] = element.value
    }
    return map
}

fun <K, V> newConcurrentHashMap(vararg elements: Map.Entry<K, V>): ConcurrentHashMap<K, V> {
    val map = newConcurrentHashMap<K, V>()
    for (element in elements) {
        map[element.key] = element.value
    }
    return map
}

fun <K, V> newLinkedHashMap(vararg elements: Map.Entry<K, V>): LinkedHashMap<K, V> {
    val map = newLinkedHashMap<K, V>()
    for (element in elements) {
        map[element.key] = element.value
    }
    return map
}

fun <K, V> newHashtable(vararg elements: Map.Entry<K, V>): Hashtable<K, V> {
    val map = newHashtable<K, V>()
    for (element in elements) {
        map[element.key] = element.value
    }
    return map
}

fun <K : Comparable<K>, V> newTreeMap(vararg elements: Map.Entry<K, V>): TreeMap<K, V> {
    val map = newTreeMap<K, V>()
    for (element in elements) {
        map[element.key] = element.value
    }
    return map
}

inline fun <reified K, reified V> Map<K, V>.newHashMap(): HashMap<K, V> {
    return HashMap(this)
}

fun <K, V> newLinkedHashMap(): LinkedHashMap<K, V> {
    return LinkedHashMap()
}

fun <K, V> newLinkedHashMap(size: Int): LinkedHashMap<K, V> {
    return LinkedHashMap(size)
}

fun <K, V> newLinkedHashMap(vararg elements: Pair<K, V>): LinkedHashMap<K, V> {
    val map = newLinkedHashMap<K, V>()
    for (element in elements) {
        map[element.first] = element.second
    }
    return map
}

inline fun <reified K, reified V> Map<K, V>.newLinkedHashMap(): LinkedHashMap<K, V> {
    return LinkedHashMap(this)
}

fun <K : Comparable<K>, V> newTreeMap(): TreeMap<K, V> {
    return TreeMap()
}

fun <K : Comparable<K>, V> newTreeMap(vararg elements: Pair<K, V>): TreeMap<K, V> {
    val map = newTreeMap<K, V>()
    for (element in elements) {
        map[element.first] = element.second
    }
    return map
}

inline fun <reified K : Comparable<K>, reified V> Map<K, V>.newTreeMap(): TreeMap<K, V> {
    return TreeMap(this)
}

fun <K, V> newHashtable(): Hashtable<K, V> {
    return Hashtable()
}

fun <K, V> newHashtable(size: Int): Hashtable<K, V> {
    return Hashtable(size)
}

fun <K, V> newHashtable(vararg elements: Pair<K, V>): Hashtable<K, V> {
    val map = newHashtable<K, V>()
    for (element in elements) {
        map[element.first] = element.second
    }
    return map
}

inline fun <reified K, reified V> Map<K, V>.newHashtable(): Hashtable<K, V> {
    val hashtable = Hashtable<K, V>()
    hashtable.putAll(this)
    return hashtable
}

fun <K, V> newConcurrentHashMap(): ConcurrentHashMap<K, V> {
    return ConcurrentHashMap()
}

fun <K, V> newConcurrentHashMap(size: Int): ConcurrentHashMap<K, V> {
    return ConcurrentHashMap(size)
}

fun <K, V> newConcurrentHashMap(vararg elements: Pair<K, V>): ConcurrentHashMap<K, V> {
    val map = newConcurrentHashMap<K, V>()
    for (element in elements) {
        map[element.first] = element.second
    }
    return map
}

inline fun <reified K, reified V> Map<K, V>.newConcurrentHashMap(): ConcurrentHashMap<K, V> {
    return ConcurrentHashMap(this)
}

fun <K, V> ofEntries(entries: List<MutableMap.MutableEntry<K, V>>): Map<K, V> {
    return entries.associate { it.key to it.value }
}
