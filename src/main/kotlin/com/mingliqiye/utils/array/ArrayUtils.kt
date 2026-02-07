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
 * CurrentFile ArrayUtils.kt
 * LastUpdate 2026-02-06 14:01:56
 * UpdateUser MingLiPro
 */


@file:JvmName("ArrayUtils")

package com.mingliqiye.utils.array

import com.mingliqiye.utils.base.BASE16


/**
 * 将字节数组转换为十六进制字符串
 *
 * @return 大写的十六进制字符串，每两个字符表示一个字节
 * @since 4.6.0
 * @see toHexByteArray
 */
fun ByteArray.toHexString(): String = BASE16.encode(this).uppercase()

/**
 * 将十六进制字符串转换为字节数组
 *
 * @return 对应的字节数组
 * @throws IllegalArgumentException 如果字符串包含非十六进制字符
 * @since 4.6.0
 * @see toHexString
 */
fun String.toHexByteArray(): ByteArray = BASE16.decode(this.lowercase())

/* ==================== 数组复制扩展函数 ==================== */

/**
 * 将当前数组的指定范围复制到目标数组
 *
 * @param dest 目标数组
 * @param srcPos 源数组起始位置（包含）
 * @param distPos 目标数组起始位置（包含）
 * @param len 要复制的元素数量
 * @return 源数组自身（支持链式调用）
 * @throws IndexOutOfBoundsException 如果索引超出范围
 * @throws IllegalArgumentException 如果参数无效
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun <T> Array<T>.copyTo(dest: Array<T>, srcPos: Int, distPos: Int, len: Int): Array<T> = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * 创建新数组并复制当前数组的指定范围
 *
 * @param srcPos 源数组起始位置（包含）
 * @param distPos 目标数组起始位置（包含）
 * @param len 要复制的元素数量，也作为新数组的长度
 * @return 新创建的数组
 * @throws IndexOutOfBoundsException 如果索引超出范围
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun <T> Array<T>.copyTo(srcPos: Int, distPos: Int, len: Int): Array<T> =
    java.lang.reflect.Array.newInstance(this.javaClass.componentType, len).also {
        System.arraycopy(this, srcPos, it, distPos, len)
    }.let {
        @Suppress("UNCHECKED_CAST")
        it as Array<T>
    }

/**
 * 将源数组的指定范围复制到当前数组
 *
 * @param src 源数组
 * @param srcPos 源数组起始位置（包含）
 * @param distPos 当前数组起始位置（包含）
 * @param len 要复制的元素数量
 * @return 当前数组自身（支持链式调用）
 * @throws IndexOutOfBoundsException 如果索引超出范围
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun <T> Array<T>.copyFrom(src: Array<T>, srcPos: Int, distPos: Int, len: Int): Array<T> = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}

/* ==================== BooleanArray 扩展 ==================== */

/**
 * @see Array.copyTo
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun BooleanArray.copyTo(dest: BooleanArray, srcPos: Int, distPos: Int, len: Int): BooleanArray = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * @see Array.copyTo
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun BooleanArray.copyTo(srcPos: Int, distPos: Int, len: Int): BooleanArray =
    BooleanArray(len).also { newArray ->
        System.arraycopy(this, srcPos, newArray, distPos, len)
    }

/**
 * @see Array.copyFrom
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun BooleanArray.copyFrom(src: BooleanArray, srcPos: Int, distPos: Int, len: Int): BooleanArray = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}

/* ==================== ByteArray 扩展 ==================== */

/**
 * @see Array.copyTo
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun ByteArray.copyTo(dest: ByteArray, srcPos: Int, distPos: Int, len: Int): ByteArray = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * @see Array.copyTo
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun ByteArray.copyTo(srcPos: Int, distPos: Int, len: Int): ByteArray =
    ByteArray(len).also { newArray ->
        System.arraycopy(this, srcPos, newArray, distPos, len)
    }

/**
 * @see Array.copyFrom
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun ByteArray.copyFrom(src: ByteArray, srcPos: Int, distPos: Int, len: Int): ByteArray = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}

/* ==================== CharArray 扩展 ==================== */

/**
 * @see Array.copyTo
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun CharArray.copyTo(dest: CharArray, srcPos: Int, distPos: Int, len: Int): CharArray = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * @see Array.copyTo
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun CharArray.copyTo(srcPos: Int, distPos: Int, len: Int): CharArray =
    CharArray(len).also { newArray ->
        System.arraycopy(this, srcPos, newArray, distPos, len)
    }

/**
 * @see Array.copyFrom
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun CharArray.copyFrom(src: CharArray, srcPos: Int, distPos: Int, len: Int): CharArray = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}

/* ==================== DoubleArray 扩展 ==================== */

/**
 * @see Array.copyTo
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun DoubleArray.copyTo(dest: DoubleArray, srcPos: Int, distPos: Int, len: Int): DoubleArray = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * @see Array.copyTo
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun DoubleArray.copyTo(srcPos: Int, distPos: Int, len: Int): DoubleArray =
    DoubleArray(len).also { newArray ->
        System.arraycopy(this, srcPos, newArray, distPos, len)
    }

/**
 * @see Array.copyFrom
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun DoubleArray.copyFrom(src: DoubleArray, srcPos: Int, distPos: Int, len: Int): DoubleArray = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}

/* ==================== FloatArray 扩展 ==================== */

/**
 * @see Array.copyTo
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun FloatArray.copyTo(dest: FloatArray, srcPos: Int, distPos: Int, len: Int): FloatArray = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * @see Array.copyTo
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun FloatArray.copyTo(srcPos: Int, distPos: Int, len: Int): FloatArray =
    FloatArray(len).also { newArray ->
        System.arraycopy(this, srcPos, newArray, distPos, len)
    }

/**
 * @see Array.copyFrom
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun FloatArray.copyFrom(src: FloatArray, srcPos: Int, distPos: Int, len: Int): FloatArray = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}

/* ==================== IntArray 扩展 ==================== */

/**
 * @see Array.copyTo
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun IntArray.copyTo(dest: IntArray, srcPos: Int, distPos: Int, len: Int): IntArray = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * @see Array.copyTo
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun IntArray.copyTo(srcPos: Int, distPos: Int, len: Int): IntArray =
    IntArray(len).also { newArray ->
        System.arraycopy(this, srcPos, newArray, distPos, len)
    }

/**
 * @see Array.copyFrom
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun IntArray.copyFrom(src: IntArray, srcPos: Int, distPos: Int, len: Int): IntArray = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}

/* ==================== LongArray 扩展 ==================== */

/**
 * @see Array.copyTo
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun LongArray.copyTo(dest: LongArray, srcPos: Int, distPos: Int, len: Int): LongArray = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * @see Array.copyTo
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun LongArray.copyTo(srcPos: Int, distPos: Int, len: Int): LongArray =
    LongArray(len).also { newArray ->
        System.arraycopy(this, srcPos, newArray, distPos, len)
    }

/**
 * @see Array.copyFrom
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun LongArray.copyFrom(src: LongArray, srcPos: Int, distPos: Int, len: Int): LongArray = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}

/* ==================== ShortArray 扩展 ==================== */

/**
 * @see Array.copyTo
 * @since 4.6.0
 */
@JvmName("arrayCopy")
fun ShortArray.copyTo(dest: ShortArray, srcPos: Int, distPos: Int, len: Int): ShortArray = this.also {
    System.arraycopy(this, srcPos, dest, distPos, len)
}

/**
 * @see Array.copyTo
 * @since 4.6.2
 */
@JvmName("arrayCopy")
fun ShortArray.copyTo(srcPos: Int, distPos: Int, len: Int): ShortArray =
    ShortArray(len).also { newArray ->
        System.arraycopy(this, srcPos, newArray, distPos, len)
    }

/**
 * @see Array.copyFrom
 * @since 4.6.1
 */
@JvmName("arrayCopyFrom")
fun ShortArray.copyFrom(src: ShortArray, srcPos: Int, distPos: Int, len: Int): ShortArray = this.also {
    System.arraycopy(src, srcPos, this, distPos, len)
}
