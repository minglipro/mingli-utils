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
 * LastUpdate 2025-09-20 14:03:46
 * UpdateUser MingLiPro
 */

@file:JvmName("Collections")

package com.mingliqiye.utils.collection

import com.mingliqiye.utils.stream.SuperStream
import java.util.*
import java.util.stream.Collectors


/**
 * 将当前集合转换为数组。
 *
 * @param T 集合元素类型
 * @return 转换后的数组
 */
inline fun <reified T> Collection<T>.toArray(): Array<T> {
    return arrayOf(*this.toTypedArray())
}

/**
 * 将当前集合转换为 Map，其中键为集合元素本身，值由给定函数生成。
 *
 * @param T 集合元素类型
 * @param V 映射值的类型
 * @param v 用于生成映射值的函数
 * @return 转换后的 Map
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T, V> Collection<T>.toMap(noinline v: (T) -> V): Map<T, V> {
    return this.stream().collect(
        SuperStream.toMap(
            v
        )
    ) as Map<T, V>
}

/**
 * 将当前集合转换为 Map，其中键和值分别由给定函数生成。
 *
 * @param T 集合元素类型
 * @param V 映射值的类型
 * @param K 映射键的类型
 * @param k 用于生成映射键的函数
 * @param v 用于生成映射值的函数
 * @return 转换后的 Map
 */
inline fun <reified T, V, K> Collection<T>.toMap(noinline k: (T) -> K, noinline v: (T) -> V): Map<K, V> {
    return this.stream().collect(
        Collectors.toMap(
            k, v
        )
    )
}

/**
 * 将数组转换为 Set。
 *
 * @param T 数组元素类型
 * @param array 输入数组
 * @return 转换后的 Set
 */
fun <T> toSet(array: Array<T>): Set<T> {
    return array.toSet()
}


/**
 * 获取集合中的第一个元素，如果集合为空则返回 null。
 *
 * @param T 集合元素类型
 * @return 第一个元素或 null
 */
inline fun <reified T> Collection<T>.getFirst(): T? {
    if (this.isEmpty()) {
        return null
    }
    if (this is MutableList<T>) {
        return this.first()
    }
    return this.iterator().next()
}

/**
 * 获取数组中的第一个元素，如果数组为空则返回 null。
 *
 * @param T 数组元素类型
 * @return 第一个元素或 null
 */
inline fun <reified T> Array<T>.getFirst(): T? {
    if (this.isEmpty()) {
        return null
    }
    return this.first()
}

/**
 * 获取集合中的最后一个元素，如果集合为空则返回 null。
 *
 * @param T 集合元素类型
 * @return 最后一个元素或 null
 */
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

/**
 * 获取数组中的最后一个元素，如果数组为空则返回 null。
 *
 * @param T 数组元素类型
 * @return 最后一个元素或 null
 */
inline fun <reified T> Array<T>.getLast(): T? {
    if (this.isEmpty()) {
        return null
    }
    return this.last()
}


/**
 * 根据索引获取集合中的元素，若索引越界则返回默认值。
 *
 * @param T 集合元素类型
 * @param index 索引位置
 * @param defaultValue 默认返回值
 * @return 指定索引处的元素或默认值
 */
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

/**
 * 创建一个新的 ArrayList 实例。
 *
 * @param T 元素类型
 * @return 新创建的 ArrayList
 */
fun <T> newArrayList(): ArrayList<T> {
    return ArrayList()
}

/**
 * 创建一个指定初始容量的新 ArrayList 实例。
 *
 * @param T 元素类型
 * @param size 初始容量大小
 * @return 新创建的 ArrayList
 */
fun <T> newArrayList(size: Int): ArrayList<T> {
    return ArrayList()
}

/**
 * 使用可变参数创建一个新的 ArrayList 实例。
 *
 * @param T 元素类型
 * @param elements 可变参数列表
 * @return 新创建的 ArrayList
 */
fun <T> newArrayList(vararg elements: T): ArrayList<T> {
    return newArrayList(elements.asList())
}

/**
 * 将当前集合转换为新的 ArrayList 实例。
 *
 * @param T 元素类型
 * @return 新创建的 ArrayList
 */
fun <T> Collection<T>.newArrayLists(): ArrayList<T> {
    return newArrayList(this)
}

/**
 * 将数组转换为新的 ArrayList 实例。
 *
 * @param T 元素类型
 * @param elements 输入数组
 * @return 新创建的 ArrayList
 */
fun <T> newArrayLists(elements: Array<T>): ArrayList<T> {
    return newArrayList(elements.asList())
}

/**
 * 将集合转换为新的 ArrayList 实例。
 *
 * @param T 元素类型
 * @param elements 输入集合
 * @return 新创建的 ArrayList
 */
fun <T> newArrayList(elements: Collection<T>): ArrayList<T> {
    return ArrayList(elements.toList())
}

/**
 * 将 Iterable 转换为新的 ArrayList 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Iterable
 * @return 新创建的 ArrayList
 */
fun <T> newArrayList(elements: Iterable<T>): ArrayList<T> {
    return newArrayList(elements.toList())
}

/**
 * 将 Sequence 转换为新的 ArrayList 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Sequence
 * @return 新创建的 ArrayList
 */
fun <T> newArrayList(elements: Sequence<T>): ArrayList<T> {
    return newArrayList(elements.toList())
}

/**
 * 创建一个新的 LinkedList 实例。
 *
 * @param T 元素类型
 * @return 新创建的 LinkedList
 */
fun <T> newLinkedList(): LinkedList<T> {
    return LinkedList()
}

/**
 * 使用可变参数创建一个新的 LinkedList 实例。
 *
 * @param T 元素类型
 * @param elements 可变参数列表
 * @return 新创建的 LinkedList
 */
fun <T> newLinkedList(vararg elements: T): LinkedList<T> {
    val list = newLinkedList<T>()
    list.addAll(elements.asList())
    return list
}

/**
 * 将集合转换为新的 LinkedList 实例。
 *
 * @param T 元素类型
 * @param elements 输入集合
 * @return 新创建的 LinkedList
 */
fun <T> newLinkedList(elements: Collection<T>): LinkedList<T> {
    val list = newLinkedList<T>()
    list.addAll(elements)
    return list
}

/**
 * 将 Iterable 转换为新的 LinkedList 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Iterable
 * @return 新创建的 LinkedList
 */
fun <T> newLinkedList(elements: Iterable<T>): LinkedList<T> {
    val list = newLinkedList<T>()
    for (element in elements) {
        list.add(element)
    }
    return list
}

/**
 * 将 Sequence 转换为新的 LinkedList 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Sequence
 * @return 新创建的 LinkedList
 */
fun <T> newLinkedList(elements: Sequence<T>): LinkedList<T> {
    return newLinkedList(elements.toList())
}

/**
 * 创建一个新的 Vector 实例。
 *
 * @param T 元素类型
 * @return 新创建的 Vector
 */
fun <T> newVector(): Vector<T> {
    return Vector()
}

/**
 * 使用可变参数创建一个新的 Vector 实例。
 *
 * @param T 元素类型
 * @param elements 可变参数列表
 * @return 新创建的 Vector
 */
fun <T> newVector(vararg elements: T): Vector<T> {
    val vector = newVector<T>()
    vector.addAll(elements.asList())
    return vector
}

/**
 * 将集合转换为新的 Vector 实例。
 *
 * @param T 元素类型
 * @param elements 输入集合
 * @return 新创建的 Vector
 */
fun <T> newVector(elements: Collection<T>): Vector<T> {
    val vector = newVector<T>()
    vector.addAll(elements)
    return vector
}

/**
 * 将 Iterable 转换为新的 Vector 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Iterable
 * @return 新创建的 Vector
 */
fun <T> newVector(elements: Iterable<T>): Vector<T> {
    val vector = newVector<T>()
    for (element in elements) {
        vector.add(element)
    }
    return vector
}

/**
 * 将 Sequence 转换为新的 Vector 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Sequence
 * @return 新创建的 Vector
 */
fun <T> newVector(elements: Sequence<T>): Vector<T> {
    return newVector(elements.toList())
}


/**
 * 创建一个新的 HashSet 实例。
 *
 * @param T 元素类型
 * @return 新创建的 HashSet
 */
fun <T> newHashSet(): HashSet<T> {
    return HashSet()
}

/**
 * 创建一个指定初始容量的新 HashSet 实例。
 *
 * @param T 元素类型
 * @param size 初始容量大小
 * @return 新创建的 HashSet
 */
fun <T> newHashSet(size: Int): HashSet<T> {
    return HashSet(size)
}

/**
 * 使用可变参数创建一个新的 HashSet 实例。
 *
 * @param T 元素类型
 * @param elements 可变参数列表
 * @return 新创建的 HashSet
 */
fun <T> newHashSet(vararg elements: T): HashSet<T> {
    val set = newHashSet<T>()
    set.addAll(elements.asList())
    return set
}

/**
 * 将集合转换为新的 HashSet 实例。
 *
 * @param T 元素类型
 * @param elements 输入集合
 * @return 新创建的 HashSet
 */
fun <T> newHashSet(elements: Collection<T>): HashSet<T> {
    val set = newHashSet<T>()
    set.addAll(elements)
    return set
}

/**
 * 将 Iterable 转换为新的 HashSet 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Iterable
 * @return 新创建的 HashSet
 */
fun <T> newHashSet(elements: Iterable<T>): HashSet<T> {
    val set = newHashSet<T>()
    for (element in elements) {
        set.add(element)
    }
    return set
}

/**
 * 将 Sequence 转换为新的 HashSet 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Sequence
 * @return 新创建的 HashSet
 */
fun <T> newHashSet(elements: Sequence<T>): HashSet<T> {
    return newHashSet(elements.toSet())
}

/**
 * 创建一个新的 LinkedHashSet 实例。
 *
 * @param T 元素类型
 * @return 新创建的 LinkedHashSet
 */
fun <T> newLinkedHashSet(): LinkedHashSet<T> {
    return LinkedHashSet()
}

/**
 * 创建一个指定初始容量的新 LinkedHashSet 实例。
 *
 * @param T 元素类型
 * @param size 初始容量大小
 * @return 新创建的 LinkedHashSet
 */
fun <T> newLinkedHashSet(size: Int): LinkedHashSet<T> {
    return LinkedHashSet(size)
}

/**
 * 使用可变参数创建一个新的 LinkedHashSet 实例。
 *
 * @param T 元素类型
 * @param elements 可变参数列表
 * @return 新创建的 LinkedHashSet
 */
fun <T> newLinkedHashSet(vararg elements: T): LinkedHashSet<T> {
    val set = newLinkedHashSet<T>()
    set.addAll(elements.asList())
    return set
}

/**
 * 将集合转换为新的 LinkedHashSet 实例。
 *
 * @param T 元素类型
 * @param elements 输入集合
 * @return 新创建的 LinkedHashSet
 */
fun <T> newLinkedHashSet(elements: Collection<T>): LinkedHashSet<T> {
    val set = newLinkedHashSet<T>()
    set.addAll(elements)
    return set
}

/**
 * 将 Iterable 转换为新的 LinkedHashSet 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Iterable
 * @return 新创建的 LinkedHashSet
 */
fun <T> newLinkedHashSet(elements: Iterable<T>): LinkedHashSet<T> {
    val set = newLinkedHashSet<T>()
    for (element in elements) {
        set.add(element)
    }
    return set
}

/**
 * 将 Sequence 转换为新的 LinkedHashSet 实例。
 *
 * @param T 元素类型
 * @param elements 输入 Sequence
 * @return 新创建的 LinkedHashSet
 */
fun <T> newLinkedHashSet(elements: Sequence<T>): LinkedHashSet<T> {
    return newLinkedHashSet(elements.toSet())
}

/**
 * 创建一个新的 TreeSet 实例。
 *
 * @param T 元素类型，必须实现 Comparable 接口
 * @return 新创建的 TreeSet
 */
fun <T : Comparable<T>> newTreeSet(): TreeSet<T> {
    return TreeSet()
}

/**
 * 使用可变参数创建一个新的 TreeSet 实例。
 *
 * @param T 元素类型，必须实现 Comparable 接口
 * @param elements 可变参数列表
 * @return 新创建的 TreeSet
 */
fun <T : Comparable<T>> newTreeSet(vararg elements: T): TreeSet<T> {
    val set = newTreeSet<T>()
    set.addAll(elements.asList())
    return set
}

/**
 * 将集合转换为新的 TreeSet 实例。
 *
 * @param T 元素类型，必须实现 Comparable 接口
 * @param elements 输入集合
 * @return 新创建的 TreeSet
 */
fun <T : Comparable<T>> newTreeSet(elements: Collection<T>): TreeSet<T> {
    val set = newTreeSet<T>()
    set.addAll(elements)
    return set
}

/**
 * 将 Iterable 转换为新的 TreeSet 实例。
 *
 * @param T 元素类型，必须实现 Comparable 接口
 * @param elements 输入 Iterable
 * @return 新创建的 TreeSet
 */
fun <T : Comparable<T>> newTreeSet(elements: Iterable<T>): TreeSet<T> {
    val set = newTreeSet<T>()
    for (element in elements) {
        set.add(element)
    }
    return set
}

/**
 * 将 Sequence 转换为新的 TreeSet 实例。
 *
 * @param T 元素类型，必须实现 Comparable 接口
 * @param elements 输入 Sequence
 * @return 新创建的 TreeSet
 */
fun <T : Comparable<T>> newTreeSet(elements: Sequence<T>): TreeSet<T> {
    return newTreeSet(elements.toSet())
}


/**
 * 将字节数组转换为 ArrayList。
 *
 * @param elements 输入字节数组
 * @return 转换后的 ArrayList
 */
fun newArrayLists(elements: ByteArray): ArrayList<Byte> {
    return ArrayList(elements.toList())
}

/**
 * 将短整型数组转换为 ArrayList。
 *
 * @param elements 输入短整型数组
 * @return 转换后的 ArrayList
 */
fun newArrayLists(elements: ShortArray): ArrayList<Short> {
    return ArrayList(elements.toList())
}

/**
 * 将整型数组转换为 ArrayList。
 *
 * @param elements 输入整型数组
 * @return 转换后的 ArrayList
 */
fun newArrayLists(elements: IntArray): ArrayList<Int> {
    return ArrayList(elements.toList())
}

/**
 * 将长整型数组转换为 ArrayList。
 *
 * @param elements 输入长整型数组
 * @return 转换后的 ArrayList
 */
fun newArrayLists(elements: LongArray): ArrayList<Long> {
    return ArrayList(elements.toList())
}

/**
 * 将浮点数组转换为 ArrayList。
 *
 * @param elements 输入浮点数组
 * @return 转换后的 ArrayList
 */
fun newArrayLists(elements: FloatArray): ArrayList<Float> {
    return ArrayList(elements.toList())
}

/**
 * 将双精度浮点数组转换为 ArrayList。
 *
 * @param elements 输入双精度浮点数组
 * @return 转换后的 ArrayList
 */
fun newArrayLists(elements: DoubleArray): ArrayList<Double> {
    return ArrayList(elements.toList())
}

/**
 * 将布尔数组转换为 ArrayList。
 *
 * @param elements 输入布尔数组
 * @return 转换后的 ArrayList
 */
fun newArrayLists(elements: BooleanArray): ArrayList<Boolean> {
    return ArrayList(elements.toList())
}

/**
 * 将字符数组转换为 ArrayList。
 *
 * @param elements 输入字符数组
 * @return 转换后的 ArrayList
 */
fun newArrayLists(elements: CharArray): ArrayList<Char> {
    return ArrayList(elements.toList())
}

/**
 * 创建一个新的 CopyOnWriteArrayList 实例。
 *
 * @param T 元素类型
 * @return 新创建的 CopyOnWriteArrayList
 */
fun <T> newCopyOnWriteArrayList(): java.util.concurrent.CopyOnWriteArrayList<T> {
    return java.util.concurrent.CopyOnWriteArrayList()
}

/**
 * 使用可变参数创建一个新的 CopyOnWriteArrayList 实例。
 *
 * @param T 元素类型
 * @param elements 可变参数列表
 * @return 新创建的 CopyOnWriteArrayList
 */
fun <T> newCopyOnWriteArrayList(vararg elements: T): java.util.concurrent.CopyOnWriteArrayList<T> {
    return java.util.concurrent.CopyOnWriteArrayList(elements.asList())
}

/**
 * 将集合转换为新的 CopyOnWriteArrayList 实例。
 *
 * @param T 元素类型
 * @param elements 输入集合
 * @return 新创建的 CopyOnWriteArrayList
 */
fun <T> newCopyOnWriteArrayList(elements: Collection<T>): java.util.concurrent.CopyOnWriteArrayList<T> {
    return java.util.concurrent.CopyOnWriteArrayList(elements)
}

/**
 * 创建一个新的 Stack 实例。
 *
 * @param T 元素类型
 * @return 新创建的 Stack
 */
fun <T> newStack(): Stack<T> {
    return Stack()
}

/**
 * 使用可变参数创建一个新的 Stack 实例。
 *
 * @param T 元素类型
 * @param elements 可变参数列表
 * @return 新创建的 Stack
 */
fun <T> newStack(vararg elements: T): Stack<T> {
    val stack = newStack<T>()
    stack.addAll(elements.asList())
    return stack
}

/**
 * 将集合转换为新的 Stack 实例。
 *
 * @param T 元素类型
 * @param elements 输入集合
 * @return 新创建的 Stack
 */
fun <T> newStack(elements: Collection<T>): Stack<T> {
    val stack = newStack<T>()
    stack.addAll(elements)
    return stack

}

/**
 * 创建一个新的 TreeSet 实例，并指定比较器。
 *
 * @param T 元素类型
 * @param comparator 用于排序的比较器
 * @return 新创建的 TreeSet
 */
fun <T> newTreeSet(comparator: Comparator<T>): TreeSet<T> {
    return TreeSet(comparator)
}

/**
 * 使用可变参数创建一个新的 TreeSet 实例，并指定比较器。
 *
 * @param T 元素类型
 * @param comparator 用于排序的比较器
 * @param elements 可变参数列表
 * @return 新创建的 TreeSet
 */
fun <T> newTreeSet(comparator: Comparator<T>, vararg elements: T): TreeSet<T> {
    val set = newTreeSet(comparator)
    set.addAll(elements.asList())
    return set
}

/**
 * 将集合转换为新的 TreeSet 实例，并指定比较器。
 *
 * @param T 元素类型
 * @param comparator 用于排序的比较器
 * @param elements 输入集合
 * @return 新创建的 TreeSet
 */
fun <T> newTreeSet(comparator: Comparator<T>, elements: Collection<T>): TreeSet<T> {
    val set = newTreeSet(comparator)
    set.addAll(elements)
    return set
}

/**
 * 将 Iterable 转换为新的 TreeSet 实例，并指定比较器。
 *
 * @param T 元素类型
 * @param comparator 用于排序的比较器
 * @param elements 输入 Iterable
 * @return 新创建的 TreeSet
 */
fun <T> newTreeSet(comparator: Comparator<T>, elements: Iterable<T>): TreeSet<T> {
    val set = newTreeSet(comparator)
    for (element in elements) {
        set.add(element)
    }
    return set
}

/**
 * 将 Sequence 转换为新的 TreeSet 实例，并指定比较器。
 *
 * @param T 元素类型
 * @param comparator 用于排序的比较器
 * @param elements 输入 Sequence
 * @return 新创建的 TreeSet
 */
fun <T> newTreeSet(comparator: Comparator<T>, elements: Sequence<T>): TreeSet<T> {
    return newTreeSet(comparator, elements.toSet())
}

/**
 * 将当前集合转换为新的 CopyOnWriteArrayList 实例。
 *
 * @param T 元素类型
 * @return 新创建的 CopyOnWriteArrayList
 */
fun <T> Collection<T>.newCopyOnWriteArrayLists(): java.util.concurrent.CopyOnWriteArrayList<T> {
    return java.util.concurrent.CopyOnWriteArrayList(this)
}

/**
 * 将当前集合转换为新的 Stack 实例。
 *
 * @param T 元素类型
 * @return 新创建的 Stack
 */
fun <T> Collection<T>.newStacks(): Stack<T> {
    val stack = Stack<T>()
    stack.addAll(this)
    return stack
}

/**
 * 将当前集合转换为新的 TreeSet 实例。
 *
 * @param T 元素类型，必须实现 Comparable 接口
 * @return 新创建的 TreeSet
 */
fun <T> Collection<T>.newTreeSets(): TreeSet<T> where T : Comparable<T> {
    val set = TreeSet<T>()
    set.addAll(this)
    return set
}

/**
 * 将当前集合转换为新的 TreeSet 实例，并指定比较器。
 *
 * @param T 元素类型
 * @param comparator 用于排序的比较器
 * @return 新创建的 TreeSet
 */
fun <T> Collection<T>.newTreeSets(comparator: Comparator<T>): TreeSet<T> {
    val set = TreeSet(comparator)
    set.addAll(this)
    return set
}

/**
 * 将 Byte 类型的 List 转换为字节数组。
 *
 * @param list 输入的 Byte 列表
 * @return 转换后的字节数组
 */
fun toArray(list: List<Byte>): ByteArray {
    val arr = ByteArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}


/**
 * 将 Short 类型的 List 转换为短整型数组。
 *
 * @param list 输入的 Short 列表
 * @return 转换后的短整型数组
 */
fun toArray(list: List<Short>): ShortArray {
    val arr = ShortArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

/**
 * 将 Int 类型的 List 转换为整型数组。
 *
 * @param list 输入的 Int 列表
 * @return 转换后的整型数组
 */
fun toArray(list: List<Int>): IntArray {
    val arr = IntArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

/**
 * 将 Long 类型的 List 转换为长整型数组。
 *
 * @param list 输入的 Long 列表
 * @return 转换后的长整型数组
 */
fun toArray(list: List<Long>): LongArray {
    val arr = LongArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

/**
 * 将 Float 类型的 List 转换为浮点数组。
 *
 * @param list 输入的 Float 列表
 * @return 转换后的浮点数组
 */
fun toArray(list: List<Float>): FloatArray {
    val arr = FloatArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

/**
 * 将 Double 类型的 List 转换为双精度浮点数组。
 *
 * @param list 输入的 Double 列表
 * @return 转换后的双精度浮点数组
 */
fun toArray(list: List<Double>): DoubleArray {
    val arr = DoubleArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

/**
 * 将 Boolean 类型的 List 转换为布尔数组。
 *
 * @param list 输入的 Boolean 列表
 * @return 转换后的布尔数组
 */
fun toArray(list: List<Boolean>): BooleanArray {
    val arr = BooleanArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}

/**
 * 将 Char 类型的 List 转换为字符数组。
 *
 * @param list 输入的 Char 列表
 * @return 转换后的字符数组
 */
fun toArray(list: List<Char>): CharArray {
    val arr = CharArray(list.size)
    for (i in list.indices) {
        arr[i] = list[i]
    }
    return arr
}


/**
 * 将任意类型的 List 转换为数组。
 *
 * @param T 元素类型
 * @param list 输入的 List
 * @return 转换后的数组
 */
fun <T> toArray(list: List<T>): Array<T> {
    return SuperStream.of<T>(list)
        .toArray()
}
