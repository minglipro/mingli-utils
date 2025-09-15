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
 * LastUpdate 2025-09-15 12:01:36
 * UpdateUser MingLiPro
 */
@file:JvmName("ForEach")

package com.mingliqiye.utils.foreach

import com.mingliqiye.utils.functions.P1Function
import com.mingliqiye.utils.functions.P1RFunction
import com.mingliqiye.utils.functions.P2Function
import com.mingliqiye.utils.functions.P2RFunction


fun <T> forEach(
    iterable: Iterable<T>, action: P2Function<in T, in Int>
) {
    when (iterable) {
        is RandomAccess if iterable is MutableList<*> -> {
            val list = iterable as MutableList<T>
            for (i in list.indices) {
                action.call(list[i], i)
            }
        }

        is MutableList<*> -> {
            var index = 0
            val it = iterable.iterator()
            while (it.hasNext()) {
                action.call(it.next(), index)
                index++
            }
        }

        else -> {
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
 * @param action     要对每个元素执行的操作，只接收元素值作为参数
 * @param <T>        可迭代对象中元素的类型
 **/
fun <T> forEach(
    iterable: Iterable<T>, action: P1Function<in T>
) {
    if (iterable is RandomAccess) {
        val list = iterable as MutableList<T>
        for (i in list.indices) {
            action.call(list[i])
        }
    } else {
        for (element in iterable) {
            action.call(element)
        }
    }
}

fun <T> forEach(
    iterable: Iterable<T>, action: P2RFunction<in T, in Int, out Boolean>
) {
    when (iterable) {
        is RandomAccess if iterable is MutableList<*> -> {
            val list = iterable as MutableList<T>
            for (i in list.indices) {
                if (action.call(list[i], i)) return
            }
        }

        is MutableList<*> -> {
            var index = 0
            val it = iterable.iterator()
            while (it.hasNext()) {
                if (action.call(it.next(), index)) return
                index++
            }
        }

        else -> {
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
 * 根据可迭代对象是否实现 RandomAccess 接口选择最优的遍历方式。
 *
 * @param iterable 要遍历的可迭代对象
 * @param action     要对每个元素执行的操作，只接收元素值作为参数
 * @param <T>        可迭代对象中元素的类型
 **/
fun <T> forEach(
    iterable: Iterable<T>, action: P1RFunction<in T, out Boolean>
) {
    if (iterable is RandomAccess) {
        val list = iterable as MutableList<T>
        for (i in list.indices) {
            if (action.call(list[i])) return
        }
    } else {
        for (element in iterable) {
            if (action.call(element)) return
        }
    }
}

fun <T> forEach(
    array: Array<T>, action: P2Function<in T, in Int>
) {
    forEach(array.toList(), action)
}

fun <T> forEach(
    array: Array<T>, action: P1Function<in T>
) {
    forEach(array.toList(), action)
}


fun <T> forEach(
    array: Array<T>, action: P2RFunction<in T, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun <T> forEach(
    array: Array<T>, action: P1RFunction<in T, out Boolean>
) {
    forEach(array.toList(), action)
}


fun forEach(
    array: ByteArray, action: P2Function<in Byte, in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: ByteArray, action: P1Function<in Byte>
) {
    forEach(array.toList(), action)
}


fun forEach(
    array: ByteArray, action: P2RFunction<in Byte, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: ByteArray, action: P1RFunction<in Byte, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: CharArray, action: P2Function<in Char, in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: CharArray, action: P1Function<in Char>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: CharArray, action: P2RFunction<in Char, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: CharArray, action: P1RFunction<in Char, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: IntArray, action: P2Function<in Int, in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: IntArray, action: P1Function<in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: IntArray, action: P2RFunction<in Int, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: IntArray, action: P1RFunction<in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: LongArray, action: P2Function<in Long, in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: LongArray, action: P1Function<in Long>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: LongArray, action: P2RFunction<in Long, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: LongArray, action: P1RFunction<in Long, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: ShortArray, action: P2Function<in Short, in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: ShortArray, action: P1Function<in Short>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: ShortArray, action: P2RFunction<in Short, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: ShortArray, action: P1RFunction<in Short, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: FloatArray, action: P2Function<in Float, in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: FloatArray, action: P1Function<in Float>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: FloatArray, action: P2RFunction<in Float, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: FloatArray, action: P1RFunction<in Float, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: DoubleArray, action: P2Function<in Double, in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: DoubleArray, action: P1Function<in Double>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: DoubleArray, action: P2RFunction<in Double, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: DoubleArray, action: P1RFunction<in Double, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: BooleanArray, action: P2Function<in Boolean, in Int>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: BooleanArray, action: P1Function<in Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: BooleanArray, action: P2RFunction<in Boolean, in Int, out Boolean>
) {
    forEach(array.toList(), action)
}

fun forEach(
    array: BooleanArray, action: P1RFunction<in Boolean, out Boolean>
) {
    forEach(array.toList(), action)
}
