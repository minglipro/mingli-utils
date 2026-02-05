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
 * LastUpdate 2026-01-28 08:03:28
 * UpdateUser MingLiPro
 */
@file:JvmName("ArrayUtils")

package com.mingliqiye.utils.array

/**
 * 复制数组元素到目标数组
 * @param from 源数组
 * @param to 目标数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun <T> arrayCopy(from: Array<T>, to: Array<T>, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前数组元素复制到目标数组
 * @param to 目标数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun <T> Array<T>.copyTo(to: Array<T>, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个数组到目标数组（重载版本）
 * @param from 源数组
 * @param to 目标数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun <T> arrayCopy(from: Array<T>, to: Array<T>) {
    return arrayCopy(from, to, 0, 0, from.size)
}

/**
 * 复制字节数组元素到目标数组
 * @param from 源字节数组
 * @param to 目标字节数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: ByteArray, to: ByteArray, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前字节数组元素复制到目标数组
 * @param to 目标字节数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun ByteArray.copyTo(to: ByteArray, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个字节数组到目标数组（重载版本）
 * @param from 源字节数组
 * @param to 目标字节数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: ByteArray, to: ByteArray) {
    arrayCopy(from, to, 0, 0, from.size)
}

/**
 * 复制短整型数组元素到目标数组
 * @param from 源短整型数组
 * @param to 目标短整型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: ShortArray, to: ShortArray, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前短整型数组元素复制到目标数组
 * @param to 目标短整型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun ShortArray.copyTo(to: ShortArray, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个短整型数组到目标数组（重载版本）
 * @param from 源短整型数组
 * @param to 目标短整型数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: ShortArray, to: ShortArray) {
    arrayCopy(from, to, 0, 0, from.size)
}

/**
 * 复制整型数组元素到目标数组
 * @param from 源整型数组
 * @param to 目标整型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: IntArray, to: IntArray, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前整型数组元素复制到目标数组
 * @param to 目标整型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun IntArray.copyTo(to: IntArray, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个整型数组到目标数组（重载版本）
 * @param from 源整型数组
 * @param to 目标整型数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: IntArray, to: IntArray) {
    arrayCopy(from, to, 0, 0, from.size)
}

/**
 * 复制长整型数组元素到目标数组
 * @param from 源长整型数组
 * @param to 目标长整型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: LongArray, to: LongArray, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前长整型数组元素复制到目标数组
 * @param to 目标长整型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun LongArray.copyTo(to: LongArray, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个长整型数组到目标数组（重载版本）
 * @param from 源长整型数组
 * @param to 目标长整型数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: LongArray, to: LongArray) {
    arrayCopy(from, to, 0, 0, from.size)
}

/**
 * 复制浮点型数组元素到目标数组
 * @param from 源浮点型数组
 * @param to 目标浮点型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: FloatArray, to: FloatArray, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前浮点型数组元素复制到目标数组
 * @param to 目标浮点型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun FloatArray.copyTo(to: FloatArray, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个浮点型数组到目标数组（重载版本）
 * @param from 源浮点型数组
 * @param to 目标浮点型数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: FloatArray, to: FloatArray) {
    arrayCopy(from, to, 0, 0, from.size)
}

/**
 * 复制双精度浮点型数组元素到目标数组
 * @param from 源双精度浮点型数组
 * @param to 目标双精度浮点型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: DoubleArray, to: DoubleArray, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前双精度浮点型数组元素复制到目标数组
 * @param to 目标双精度浮点型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun DoubleArray.copyTo(to: DoubleArray, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个双精度浮点型数组到目标数组（重载版本）
 * @param from 源双精度浮点型数组
 * @param to 目标双精度浮点型数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: DoubleArray, to: DoubleArray) {
    arrayCopy(from, to, 0, 0, from.size)
}

/**
 * 复制布尔型数组元素到目标数组
 * @param from 源布尔型数组
 * @param to 目标布尔型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(
    from: BooleanArray, to: BooleanArray, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos
) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前布尔型数组元素复制到目标数组
 * @param to 目标布尔型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun BooleanArray.copyTo(to: BooleanArray, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个布尔型数组到目标数组（重载版本）
 * @param from 源布尔型数组
 * @param to 目标布尔型数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: BooleanArray, to: BooleanArray) {
    arrayCopy(from, to, 0, 0, from.size)
}

/**
 * 复制字符型数组元素到目标数组
 * @param from 源字符型数组
 * @param to 目标字符型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: CharArray, to: CharArray, fromPos: Int = 0, toPos: Int = 0, length: Int = from.size - fromPos) {
    System.arraycopy(from, fromPos, to, toPos, length)
}

/**
 * 扩展函数：将当前字符型数组元素复制到目标数组
 * @param to 目标字符型数组
 * @param fromPos 源数组起始位置，默认为0
 * @param toPos 目标数组起始位置，默认为0
 * @param length 要复制的元素数量，默认为源数组从起始位置到末尾的长度
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 * @throws ArrayStoreException 当类型不匹配时抛出
 */
@JvmSynthetic
@Throws(IndexOutOfBoundsException::class, ArrayStoreException::class)
fun CharArray.copyTo(to: CharArray, fromPos: Int = 0, toPos: Int = 0, length: Int = this.size - fromPos) {
    System.arraycopy(this, fromPos, to, toPos, length)
}

/**
 * 复制整个字符型数组到目标数组（重载版本）
 * @param from 源字符型数组
 * @param to 目标字符型数组
 * @throws IndexOutOfBoundsException 当索引超出数组边界时抛出
 */
@Throws(IndexOutOfBoundsException::class)
fun arrayCopy(from: CharArray, to: CharArray) {
    arrayCopy(from, to, 0, 0, from.size)
}
