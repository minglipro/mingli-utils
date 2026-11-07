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
 * CurrentFile SuprtStreamUtils.kt
 * LastUpdate 2026-10-11 17:32:17
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.stream

import java.util.stream.Stream

/**
 * [SuperStream] 的工厂工具类，提供把各类常见数据源（Java [Stream]、数组、集合、映射）
 * 转换为 [SuperStream] 的扩展函数。
 *
 * 所有扩展函数均以 `toSuperStream` 命名，遵循 Kotlin 的 `toXxx` 转换命名惯例。
 *
 * 使用示例：
 * ```kotlin
 * intArrayOf(1, 2, 3).toSuperStream()
 * listOf("a", "b").toSuperStream(parallel = true)
 * mapOf(1 to "a").toSuperStream()
 * ```
 */
object SuperStreamUtils {

	/**
	 * 将 Java [Stream] 转换为 [SuperStream]。
	 *
	 * @param T 流中元素的类型，必须是不可空类型。
	 * @return 包装当前 [Stream] 的 [SuperStream]。
	 */
	fun <T : Any> Stream<T>.toSuperStream() = SuperStream.of(this)

	/**
	 * 将 [ByteArray] 转换为 [SuperStream]。
	 *
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前数组元素构成的 [SuperStream]。
	 */
	fun ByteArray.toSuperStream(parallel: Boolean = false) = SuperStream.of(this.toList(), parallel)

	/**
	 * 将 [ShortArray] 转换为 [SuperStream]。
	 *
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前数组元素构成的 [SuperStream]。
	 */
	fun ShortArray.toSuperStream(parallel: Boolean = false) = SuperStream.of(this.toList(), parallel)

	/**
	 * 将 [IntArray] 转换为 [SuperStream]。
	 *
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前数组元素构成的 [SuperStream]。
	 */
	fun IntArray.toSuperStream(parallel: Boolean = false) = SuperStream.of(this.toList(), parallel)

	/**
	 * 将 [LongArray] 转换为 [SuperStream]。
	 *
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前数组元素构成的 [SuperStream]。
	 */
	fun LongArray.toSuperStream(parallel: Boolean = false) = SuperStream.of(this.toList(), parallel)

	/**
	 * 将 [FloatArray] 转换为 [SuperStream]。
	 *
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前数组元素构成的 [SuperStream]。
	 */
	fun FloatArray.toSuperStream(parallel: Boolean = false) = SuperStream.of(this.toList(), parallel)

	/**
	 * 将 [DoubleArray] 转换为 [SuperStream]。
	 *
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前数组元素构成的 [SuperStream]。
	 */
	fun DoubleArray.toSuperStream(parallel: Boolean = false) = SuperStream.of(this.toList(), parallel)

	/**
	 * 将 [BooleanArray] 转换为 [SuperStream]。
	 *
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前数组元素构成的 [SuperStream]。
	 */
	fun BooleanArray.toSuperStream(parallel: Boolean = false) = SuperStream.of(this.toList(), parallel)

	/**
	 * 将对象数组 [Array] 转换为 [SuperStream]。
	 *
	 * @param T 数组元素类型，必须是不可空类型。
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前数组元素构成的 [SuperStream]。
	 */
	fun <T : Any> Array<T>.toSuperStream(parallel: Boolean = false) = SuperStream.of(this, parallel)

	/**
	 * 将 [Collection] 转换为 [SuperStream]。
	 *
	 * @param T 集合元素类型，必须是不可空类型。
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前集合元素构成的 [SuperStream]。
	 */
	fun <T : Any> Collection<T>.toSuperStream(parallel: Boolean = false) = SuperStream.of(this, parallel)

	/**
	 * 将 [Map] 转换为 [SuperStream]，流中元素为键值对 [Map.Entry]。
	 *
	 * @param K 键的类型。
	 * @param V 值的类型。
	 * @param parallel 是否创建并行流，默认为 `false`（串行）。
	 * @return 由当前映射的条目构成的 [SuperStream]。
	 */
	fun <K, V> Map<K, V>.toSuperStream(parallel: Boolean = false) = SuperStream.of(this, parallel)
}
