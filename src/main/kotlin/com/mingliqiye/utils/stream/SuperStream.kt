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
 * CurrentFile SuperStream.kt
 * LastUpdate 2025-09-15 17:17:48
 * UpdateUser MingLiPro
 */
@file:JvmName("Colls")

package com.mingliqiye.utils.stream


import java.util.stream.Collector
import java.util.stream.Collectors
import java.util.stream.Stream


class SuperStream<T> private constructor(val stream: Stream<T>) : Stream<T> by stream {
    companion object {
        @JvmStatic
        fun <T> of(stream: Stream<T>): SuperStream<T> {
            return SuperStream(stream)
        }

        @JvmStatic
        fun <T> of(collection: Collection<T>): SuperStream<T> {
            return SuperStream(collection.stream())
        }

        @JvmStatic
        fun <T : Map<K, V>, K, V> of(map: T): SuperStream<Map.Entry<K, V>> {
            return of(map.entries)
        }

        @JvmStatic
        fun <T> of(vararg array: T): SuperStream<T> {
            return of(array.toList())
        }

        @JvmStatic
        fun <T> of(iterator: Iterator<T>): SuperStream<T> {
            val data = ArrayList<T>(20)
            while (iterator.hasNext()) {
                data.add(iterator.next())
            }
            return of(data)
        }
    }
}

interface Gettable<T> {
    fun get(): T
}

interface KeyGettable<T> : Gettable<T> {

    fun getKey(): T
    override fun get(): T {
        return getKey()
    }
}

interface IdGettable<T> : Gettable<T> {
    fun getId(): T
    override fun get(): T {
        return getId()
    }
}

fun <T> getThis(t: T): T {
    return t
}

fun <T, U> toMapValueThis(valueMapper: java.util.function.Function<in T, out U>): Collector<T, *, Map<T, U>> {
    return Collectors.toMap(
        java.util.function.Function<T, T> { it },
        valueMapper
    ) as Collector<T, *, Map<T, U>>
}

fun <T, K> toMap(keyMapper: java.util.function.Function<in T, out K>): Collector<T, *, Map<K, T>> {
    return Collectors.toMap(
        keyMapper,
        java.util.function.Function<T, T> { it },
    ) as Collector<T, *, Map<K, T>>
}

fun <K> toMapGet(): Collector<Gettable<K>, *, Map<K, Gettable<K>>> {
    return Collectors.toMap(
        java.util.function.Function<Gettable<K>, K> { it.get() },
        java.util.function.Function<Gettable<K>, Gettable<K>> { it },
    ) as Collector<Gettable<K>, *, Map<K, Gettable<K>>>
}

fun <K, V> toMap(): Collector<Map.Entry<K, V>, *, Map<K, V>> {
    return Collectors.toMap(
        { entry: Map.Entry<K, V> -> entry.key },
        { entry: Map.Entry<K, V> -> entry.value }
    ) as Collector<Map.Entry<K, V>, *, Map<K, V>>
}

fun <T> toList(): Collector<T, *, List<T>> {
    return Collectors.toList<T>()
}

fun <T> toSet(): Collector<T, *, Set<T>> {
    return Collectors.toSet<T>()
}
