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
 * CurrentFile ForEach.kt
 * LastUpdate 2025-09-15 12:44:46
 * UpdateUser MingLiPro
 */
@file:JvmName("ForEach")

package com.mingliqiye.utils.foreach

import com.mingliqiye.utils.functions.*


/**
 * 对给定的可迭代对象执行指定的操作，同时处理元素值和索引。
 * 根据可迭代对象是否实现 RandomAccess 接口选择最优的遍历方式。
 *
 * @param iterable 要遍历的可迭代对象
 * @param action   要对每个元素执行的操作，接收元素值和索引作为参数
 * @param <T>      可迭代对象中元素的类型
 */
fun <T> forEach(
    iterable: Iterable<T>, action: P2Function<in T, in Int>
) {
    when (iterable) {
        is RandomAccess if iterable is MutableList<*> -> {
            // 如果是支持随机访问的可变列表，则使用索引遍历以提高性能
            val list = iterable as MutableList<T>
            for (i in list.indices) {
                action.call(list[i], i)
            }
        }

        is MutableList<*> -> {
            // 对于普通可变列表，使用迭代器进行遍历，并手动维护索引
            var index = 0
            val it = iterable.iterator()
            while (it.hasNext()) {
                action.call(it.next(), index)
                index++
            }
        }

        else -> {
            // 对于其他类型的可迭代对象，使用增强 for 循环并手动维护索引
            var index = 0
            for (element in iterable) {
                action.call(element, index)
                index++
            }
        }
    }
}

/**
 * 对给定的可迭代对象执行指定的操作，仅处理元素值。
 * 根据可迭代对象是否实现 RandomAccess 接口选择最优的遍历方式。
 *
 * @param iterable 要遍历的可迭代对象
 * @param action   要对每个元素执行的操作，只接收元素值作为参数
 * @param <T>      可迭代对象中元素的类型
 */
fun <T> forEach(
    iterable: Iterable<T>, action: P1Function<in T>
) {
    if (iterable is RandomAccess) {
        // 如果是支持随机访问的列表，则使用索引遍历以提高性能
        val list = iterable as MutableList<T>
        for (i in list.indices) {
            action.call(list[i])
        }
    } else {
        // 否则使用增强 for 循环进行遍历
        for (element in iterable) {
            action.call(element)
        }
    }
}

/**
 * 对给定的可迭代对象执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 * 根据可迭代对象是否实现 RandomAccess 接口选择最优的遍历方式。
 *
 * @param iterable 要遍历的可迭代对象
 * @param action   要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 * @param <T>      可迭代对象中元素的类型
 */
fun <T> forEachB(
    iterable: Iterable<T>, action: P2RFunction<in T, in Int, out Boolean>
) {
    when (iterable) {
        is RandomAccess if iterable is MutableList<*> -> {
            // 如果是支持随机访问的可变列表，则使用索引遍历以提高性能
            val list = iterable as MutableList<T>
            for (i in list.indices) {
                if (action.call(list[i], i)) return
            }
        }

        is MutableList<*> -> {
            // 对于普通可变列表，使用迭代器进行遍历，并手动维护索引
            var index = 0
            val it = iterable.iterator()
            while (it.hasNext()) {
                if (action.call(it.next(), index)) return
                index++
            }
        }

        else -> {
            // 对于其他类型的可迭代对象，使用增强 for 循环并手动维护索引
            var index = 0
            for (element in iterable) {
                if (action.call(element, index)) return
                index++
            }
        }
    }
}

/**
 * 对给定的可迭代对象执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 * 根据可迭代对象是否实现 RandomAccess 接口选择最优的遍历方式。
 *
 * @param iterable 要遍历的可迭代对象
 * @param action   要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 * @param <T>      可迭代对象中元素的类型
 */
fun <T> forEachB(
    iterable: Iterable<T>, action: P1RFunction<in T, out Boolean>
) {
    if (iterable is RandomAccess) {
        // 如果是支持随机访问的列表，则使用索引遍历以提高性能
        val list = iterable as MutableList<T>
        for (i in list.indices) {
            if (action.call(list[i])) return
        }
    } else {
        // 否则使用增强 for 循环进行遍历
        for (element in iterable) {
            if (action.call(element)) return
        }
    }
}

/**
 * 对给定的数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 * @param <T>    数组中元素的类型
 */
fun <T> forEach(
    array: Array<T>, action: P2Function<in T, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 * @param <T>    数组中元素的类型
 */
fun <T> forEach(
    array: Array<T>, action: P1Function<in T>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 * @param <T>    数组中元素的类型
 */
fun <T> forEachB(
    array: Array<T>, action: P2RFunction<in T, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 * @param <T>    数组中元素的类型
 */
fun <T> forEachB(
    array: Array<T>, action: P1RFunction<in T, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的字节数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的字节数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 */
fun forEach(
    array: ByteArray, action: P2Function<in Byte, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的字节数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的字节数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 */
fun forEach(
    array: ByteArray, action: P1Function<in Byte>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的字节数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的字节数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: ByteArray, action: P2RFunction<in Byte, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的字节数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的字节数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: ByteArray, action: P1RFunction<in Byte, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的字符数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的字符数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 */
fun forEach(
    array: CharArray, action: P2Function<in Char, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的字符数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的字符数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 */
fun forEach(
    array: CharArray, action: P1Function<in Char>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的字符数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的字符数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: CharArray, action: P2RFunction<in Char, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的字符数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的字符数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: CharArray, action: P1RFunction<in Char, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的整型数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的整型数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 */
fun forEach(
    array: IntArray, action: P2Function<in Int, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的整型数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的整型数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 */
fun forEach(
    array: IntArray, action: P1Function<in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的整型数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的整型数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: IntArray, action: P2RFunction<in Int, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的整型数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的整型数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: IntArray, action: P1RFunction<in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的长整型数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的长整型数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 */
fun forEach(
    array: LongArray, action: P2Function<in Long, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的长整型数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的长整型数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 */
fun forEach(
    array: LongArray, action: P1Function<in Long>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的长整型数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的长整型数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: LongArray, action: P2RFunction<in Long, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的长整型数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的长整型数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: LongArray, action: P1RFunction<in Long, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的短整型数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的短整型数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 */
fun forEach(
    array: ShortArray, action: P2Function<in Short, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的短整型数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的短整型数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 */
fun forEach(
    array: ShortArray, action: P1Function<in Short>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的短整型数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的短整型数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: ShortArray, action: P2RFunction<in Short, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的短整型数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的短整型数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: ShortArray, action: P1RFunction<in Short, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的浮点数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的浮点数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 */
fun forEach(
    array: FloatArray, action: P2Function<in Float, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的浮点数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的浮点数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 */
fun forEach(
    array: FloatArray, action: P1Function<in Float>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的浮点数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的浮点数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: FloatArray, action: P2RFunction<in Float, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的浮点数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的浮点数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: FloatArray, action: P1RFunction<in Float, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的双精度浮点数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的双精度浮点数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 */
fun forEach(
    array: DoubleArray, action: P2Function<in Double, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的双精度浮点数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的双精度浮点数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 */
fun forEach(
    array: DoubleArray, action: P1Function<in Double>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的双精度浮点数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的双精度浮点数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: DoubleArray, action: P2RFunction<in Double, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的双精度浮点数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的双精度浮点数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: DoubleArray, action: P1RFunction<in Double, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的布尔数组执行指定的操作，同时处理元素值和索引。
 *
 * @param array  要遍历的布尔数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数
 */
fun forEach(
    array: BooleanArray, action: P2Function<in Boolean, in Int>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的布尔数组执行指定的操作，仅处理元素值。
 *
 * @param array  要遍历的布尔数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数
 */
fun forEach(
    array: BooleanArray, action: P1Function<in Boolean>
) {
    forEach(array.toList(), action)
}

/**
 * 对给定的布尔数组执行指定的操作，同时处理元素值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的布尔数组
 * @param action 要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: BooleanArray, action: P2RFunction<in Boolean, in Int, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的布尔数组执行指定的操作，仅处理元素值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的布尔数组
 * @param action 要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 表示是否提前终止
 */
fun forEachB(
    array: BooleanArray, action: P1RFunction<in Boolean, out Boolean>
) {
    forEachB(array.toList(), action)
}

/**
 * 对给定的键值对集合执行指定的操作，同时处理键、值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的键值对集合
 * @param action 要对每个键值对执行的操作，接收键、值和索引作为参数，返回 Boolean 表示是否提前终止
 * @param <K>    键的类型
 * @param <V>    值的类型
 * @param <A>    集合的具体类型
 */
fun <K, V, A : Collection<Map.Entry<K, V>>> forEachB(
    array: A, action: P3RFunction<in K, in V, in Int, out Boolean>
) {
    forEachB(array, P2RFunction<Map.Entry<K, V>, Int, Boolean> { p1, p2 -> action.call(p1.key, p1.value, p2) })
}

/**
 * 对给定的映射执行指定的操作，同时处理键、值和索引。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param map    要遍历的映射
 * @param action 要对每个键值对执行的操作，接收键、值和索引作为参数，返回 Boolean 表示是否提前终止
 * @param <K>    键的类型
 * @param <V>    值的类型
 * @param <A>    映射的具体类型
 */
fun <K, V, A : Map<K, V>> forEachB(
    map: A, action: P3RFunction<in K, in V, in Int, out Boolean>
) {
    forEachB(map.entries, P2RFunction<Map.Entry<K, V>, Int, Boolean> { p1, p2 -> action.call(p1.key, p1.value, p2) })
}

/**
 * 对给定的键值对集合执行指定的操作，仅处理键和值。
 *
 * @param array  要遍历的键值对集合
 * @param action 要对每个键值对执行的操作，接收键和值作为参数
 * @param <K>    键的类型
 * @param <V>    值的类型
 * @param <A>    集合的具体类型
 */
fun <K, V, A : Collection<Map.Entry<K, V>>> forEachMap(
    array: A, action: P2Function<in K, in V>
) {
    forEach(array, P1Function<Map.Entry<K, V>> { p1 -> action.call(p1.key, p1.value) })
}

/**
 * 对给定的映射执行指定的操作，仅处理键和值。
 *
 * @param map    要遍历的映射
 * @param action 要对每个键值对执行的操作，接收键和值作为参数
 * @param <K>    键的类型
 * @param <V>    值的类型
 * @param <A>    映射的具体类型
 */
fun <K, V, A : Map<K, V>> forEachMap(
    map: A, action: P2Function<in K, in V>
) {
    forEach(map.entries, P1Function<Map.Entry<K, V>> { p1 -> action.call(p1.key, p1.value) })
}

/**
 * 对给定的键值对集合执行指定的操作，仅处理键和值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param array  要遍历的键值对集合
 * @param action 要对每个键值对执行的操作，接收键和值作为参数，返回 Boolean 表示是否提前终止
 * @param <K>    键的类型
 * @param <V>    值的类型
 * @param <A>    集合的具体类型
 */
fun <K, V, A : Collection<Map.Entry<K, V>>> forEachMapB(
    array: A, action: P2RFunction<in K, in V, out Boolean>
) {
    forEachB(array, P1RFunction<Map.Entry<K, V>, Boolean> { p1 -> action.call(p1.key, p1.value) })
}

/**
 * 对给定的映射执行指定的操作，仅处理键和值。
 * 如果操作返回 true，则提前终止遍历。
 *
 * @param map    要遍历的映射
 * @param action 要对每个键值对执行的操作，接收键和值作为参数，返回 Boolean 表示是否提前终止
 * @param <K>    键的类型
 * @param <V>    值的类型
 * @param <A>    映射的具体类型
 */
fun <K, V, A : Map<K, V>> forEachMapB(
    map: A, action: P2RFunction<in K, in V, out Boolean>
) {
    forEachB(map.entries, P1RFunction<Map.Entry<K, V>, Boolean> { p1 -> action.call(p1.key, p1.value) })
}
