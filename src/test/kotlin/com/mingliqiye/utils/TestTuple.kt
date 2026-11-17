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
 * ModuleName mingli-utils.test
 * CurrentFile TestTuple.kt
 * LastUpdate 2026-11-17 21:20:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.tuple.Tuple
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * [Tuple] 字典序比较（compareTo）测试。
 */
class TestTuple {

	/** 测试首元素不同时按首元素自然顺序比较 */
	@Test
	fun compareByFirstElement() {
		assertTrue(Tuple.of(2, "a") > Tuple.of(1, "z"))
		assertTrue(Tuple.of(1, "z") < Tuple.of(2, "a"))
	}

	/** 测试首元素相同时按后续元素逐位比较 */
	@Test
	fun compareByLaterElement() {
		assertTrue(Tuple.of(1, "b") > Tuple.of(1, "a"))
		assertTrue(Tuple.of(1, 2, 3) < Tuple.of(1, 2, 4))
	}

	/** 测试公共前缀相等时元素个数少的元组较小 */
	@Test
	fun compareBySizeWhenPrefixEqual() {
		assertTrue(Tuple.of(1) < Tuple.of(1, 0))
		assertTrue(Tuple.of(1, 0, 0) > Tuple.of(1, 0))
	}

	/** 测试元素完全相同的元组比较结果为 0 */
	@Test
	fun compareEqualTuples() {
		assertEquals(0, Tuple.of(1, "a").compareTo(Tuple.of(1, "a")))
	}

	/** 测试非 Comparable 元素按字符串形式比较且不抛异常 */
	@Test
	fun compareNonComparableElements() {
		val a = Any()
		val b = Any()
		assertEquals(a.toString().compareTo(b.toString()), Tuple.of(a).compareTo(Tuple.of(b)))
	}

	/** 测试元组可直接使用 sorted 排序 */
	@Test
	fun sortedTuples() {
		val sorted = listOf(Tuple.of(2, "a"), Tuple.of(1, "z"), Tuple.of(1, "a")).sorted()
		assertEquals(listOf(listOf(1, "a"), listOf(1, "z"), listOf(2, "a")), sorted.map { it.toList() })
	}
}