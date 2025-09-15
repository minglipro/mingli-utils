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
 * CurrentFile Collection.kt
 * LastUpdate 2025-09-15 09:30:37
 * UpdateUser MingLiPro
 */

@file:JvmName("Collections")

package com.mingliqiye.utils.collection

import com.mingliqiye.utils.stream.SuperStream
import java.util.*


inline fun <reified T> Collection<T>.toArray(): Array<T> {
    return arrayOf(*this.toTypedArray())
}

inline fun <reified T, V> Collection<T>.toMap(noinline v: (T) -> V): Map<T, V> {
    return this.stream().collect(
        SuperStream.Collectors.toMap(
            SuperStream.Collectors::getThis, v
        )
    )
}

inline fun <reified T, V, K> Collection<T>.toMap(noinline k: (T) -> K, noinline v: (T) -> V): Map<K, V> {
    return this.stream().collect(
        SuperStream.Collectors.toMap(
            k, v
        )
    )
}

fun <T> toSet(array: Array<T>): Set<T> {
    return array.toSet()
}


inline fun <reified T> Collection<T>.getFirst(): T? {
    if (this.isEmpty()) {
        return null
    }
    if (this is MutableList<T>) {
        return this.first()
    }
    return this.iterator().next()
}

inline fun <reified T> Array<T>.getFirst(): T? {
    if (this.isEmpty()) {
        return null
    }
    return this.first()
}

inline fun <reified T> Collection<T>.getLast(): T? {
    if (this.isEmpty()) {
        return null
    }
    if (this is MutableList<T>) {
        return this.last()
    }
    var lastElement: T? = null
    for (element in this) {
        lastElement = element
    }
    return lastElement
}

inline fun <reified T> Array<T>.getLast(): T? {
    if (this.isEmpty()) {
        return null
    }
    return this.last()
}


inline fun <reified T> Collection<T>.getOrDefault(
    index: Int, defaultValue: T
): T {
    if (!(!this.isEmpty() && index < this.size)) {
        return defaultValue
    }
    if (this is List<T>) {
        return this[index]
    }
    var i = 0
    for (element in this) {
        if (i == index) {
            return element
        }
        i++
    }
    return defaultValue
}

fun <T> newArrayList(): ArrayList<T> {
    return ArrayList()
}

fun <T> newArrayList(size: Int): ArrayList<T> {
    return ArrayList()
}

fun <T> newArrayList(vararg elements: T): ArrayList<T> {
    return newArrayList(elements.asList())
}

fun <T> Collection<T>.newArrayLists(): ArrayList<T> {
    return newArrayList(this)
}

fun <T> newArrayLists(elements: Array<T>): ArrayList<T> {
    return newArrayList(elements.asList())
}

fun <T> newArrayList(elements: Collection<T>): ArrayList<T> {
    return ArrayList(elements.toList())
}

fun <T> newArrayList(elements: Iterable<T>): ArrayList<T> {
    return newArrayList(elements.toList())
}

fun <T> newArrayList(elements: Sequence<T>): ArrayList<T> {
    return newArrayList(elements.toList())
}

fun <T> newLinkedList(): LinkedList<T> {
    return LinkedList()
}

fun <T> newLinkedList(vararg elements: T): LinkedList<T> {
    val list = newLinkedList<T>()
    list.addAll(elements.asList())
    return list
}

fun <T> newLinkedList(elements: Collection<T>): LinkedList<T> {
    val list = newLinkedList<T>()
    list.addAll(elements)
    return list
}

fun <T> newLinkedList(elements: Iterable<T>): LinkedList<T> {
    val list = newLinkedList<T>()
    for (element in elements) {
        list.add(element)
    }
    return list
}

fun <T> newLinkedList(elements: Sequence<T>): LinkedList<T> {
    return newLinkedList(elements.toList())
}

fun <T> newVector(): Vector<T> {
    return Vector()
}

fun <T> newVector(vararg elements: T): Vector<T> {
    val vector = newVector<T>()
    vector.addAll(elements.asList())
    return vector
}

fun <T> newVector(elements: Collection<T>): Vector<T> {
    val vector = newVector<T>()
    vector.addAll(elements)
    return vector
}

fun <T> newVector(elements: Iterable<T>): Vector<T> {
    val vector = newVector<T>()
    for (element in elements) {
        vector.add(element)
    }
    return vector
}

fun <T> newVector(elements: Sequence<T>): Vector<T> {
    return newVector(elements.toList())
}


fun <T> newHashSet(): HashSet<T> {
    return HashSet()
}

fun <T> newHashSet(size: Int): HashSet<T> {
    return HashSet(size)
}

fun <T> newHashSet(vararg elements: T): HashSet<T> {
    val set = newHashSet<T>()
    set.addAll(elements.asList())
    return set
}

fun <T> newHashSet(elements: Collection<T>): HashSet<T> {
    val set = newHashSet<T>()
    set.addAll(elements)
    return set
}

fun <T> newHashSet(elements: Iterable<T>): HashSet<T> {
    val set = newHashSet<T>()
    for (element in elements) {
        set.add(element)
    }
    return set
}

fun <T> newHashSet(elements: Sequence<T>): HashSet<T> {
    return newHashSet(elements.toSet())
}

fun <T> newLinkedHashSet(): LinkedHashSet<T> {
    return LinkedHashSet()
}

fun <T> newLinkedHashSet(size: Int): LinkedHashSet<T> {
    return LinkedHashSet(size)
}

fun <T> newLinkedHashSet(vararg elements: T): LinkedHashSet<T> {
    val set = newLinkedHashSet<T>()
    set.addAll(elements.asList())
    return set
}

fun <T> newLinkedHashSet(elements: Collection<T>): LinkedHashSet<T> {
    val set = newLinkedHashSet<T>()
    set.addAll(elements)
    return set
}

fun <T> newLinkedHashSet(elements: Iterable<T>): LinkedHashSet<T> {
    val set = newLinkedHashSet<T>()
    for (element in elements) {
        set.add(element)
    }
    return set
}

fun <T> newLinkedHashSet(elements: Sequence<T>): LinkedHashSet<T> {
    return newLinkedHashSet(elements.toSet())
}

fun <T : Comparable<T>> newTreeSet(): TreeSet<T> {
    return TreeSet()
}

fun <T : Comparable<T>> newTreeSet(vararg elements: T): TreeSet<T> {
    val set = newTreeSet<T>()
    set.addAll(elements.asList())
    return set
}

fun <T : Comparable<T>> newTreeSet(elements: Collection<T>): TreeSet<T> {
    val set = newTreeSet<T>()
    set.addAll(elements)
    return set
}

fun <T : Comparable<T>> newTreeSet(elements: Iterable<T>): TreeSet<T> {
    val set = newTreeSet<T>()
    for (element in elements) {
        set.add(element)
    }
    return set
}

fun <T : Comparable<T>> newTreeSet(elements: Sequence<T>): TreeSet<T> {
    return newTreeSet(elements.toSet())
}


fun newArrayLists(elements: ByteArray): ArrayList<Byte> {
    return ArrayList(elements.toList())
}

fun newArrayLists(elements: ShortArray): ArrayList<Short> {
    return ArrayList(elements.toList())
}

fun newArrayLists(elements: IntArray): ArrayList<Int> {
    return ArrayList(elements.toList())
}

fun newArrayLists(elements: LongArray): ArrayList<Long> {
    return ArrayList(elements.toList())
}

fun newArrayLists(elements: FloatArray): ArrayList<Float> {
    return ArrayList(elements.toList())
}

fun newArrayLists(elements: DoubleArray): ArrayList<Double> {
    return ArrayList(elements.toList())
}

fun newArrayLists(elements: BooleanArray): ArrayList<Boolean> {
    return ArrayList(elements.toList())
}

fun newArrayLists(elements: CharArray): ArrayList<Char> {
    return ArrayList(elements.toList())
}

fun <T> newCopyOnWriteArrayList(): java.util.concurrent.CopyOnWriteArrayList<T> {
    return java.util.concurrent.CopyOnWriteArrayList()
}

fun <T> newCopyOnWriteArrayList(vararg elements: T): java.util.concurrent.CopyOnWriteArrayList<T> {
    return java.util.concurrent.CopyOnWriteArrayList(elements.asList())
}

fun <T> newCopyOnWriteArrayList(elements: Collection<T>): java.util.concurrent.CopyOnWriteArrayList<T> {
    return java.util.concurrent.CopyOnWriteArrayList(elements)
}

fun <T> newStack(): Stack<T> {
    return Stack()
}

fun <T> newStack(vararg elements: T): Stack<T> {
    val stack = newStack<T>()
    stack.addAll(elements.asList())
    return stack
}

fun <T> newStack(elements: Collection<T>): Stack<T> {
    val stack = newStack<T>()
    stack.addAll(elements)
    return stack

}

fun <T> newTreeSet(comparator: Comparator<T>): TreeSet<T> {
    return TreeSet(comparator)
}

fun <T> newTreeSet(comparator: Comparator<T>, vararg elements: T): TreeSet<T> {
    val set = newTreeSet(comparator)
    set.addAll(elements.asList())
    return set
}

fun <T> newTreeSet(comparator: Comparator<T>, elements: Collection<T>): TreeSet<T> {
    val set = newTreeSet(comparator)
    set.addAll(elements)
    return set
}

fun <T> newTreeSet(comparator: Comparator<T>, elements: Iterable<T>): TreeSet<T> {
    val set = newTreeSet(comparator)
    for (element in elements) {
        set.add(element)
    }
    return set
}

fun <T> newTreeSet(comparator: Comparator<T>, elements: Sequence<T>): TreeSet<T> {
    return newTreeSet(comparator, elements.toSet())
}

fun <T> Collection<T>.newCopyOnWriteArrayLists(): java.util.concurrent.CopyOnWriteArrayList<T> {
    return java.util.concurrent.CopyOnWriteArrayList(this)
}

fun <T> Collection<T>.newStacks(): Stack<T> {
    val stack = Stack<T>()
    stack.addAll(this)
    return stack
}

fun <T> Collection<T>.newTreeSets(): TreeSet<T> where T : Comparable<T> {
    val set = TreeSet<T>()
    set.addAll(this)
    return set
}

fun <T> Collection<T>.newTreeSets(comparator: Comparator<T>): TreeSet<T> {
    val set = TreeSet(comparator)
    set.addAll(this)
    return set
}

fun toArray(list: List<Byte>): ByteArray {
    val arr = ByteArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}


fun toArray(list: List<Short>): ShortArray {
    val arr = ShortArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

fun toArray(list: List<Int>): IntArray {
    val arr = IntArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

fun toArray(list: List<Long>): LongArray {
    val arr = LongArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

fun toArray(list: List<Float>): FloatArray {
    val arr = FloatArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

fun toArray(list: List<Double>): DoubleArray {
    val arr = DoubleArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

fun toArray(list: List<Boolean>): BooleanArray {
    val arr = BooleanArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

fun toArray(list: List<Char>): CharArray {
    val arr = CharArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}
