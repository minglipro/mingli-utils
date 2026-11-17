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
 * CurrentFile NullUtils.kt
 * LastUpdate 2026-02-05 10:17:02
 * UpdateUser MingLiPro
 */
@file:JvmName("NullUtils")

package com.mingliqiye.utils.objects

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * 判断当前对象是否不为 null。
 *
 * 通过 Kotlin 契约支持智能类型转换：返回 true 后编译器可将接收者视为非空。
 *
 * @return 不为 null 返回 true，否则返回 false
 */
@OptIn(ExperimentalContracts::class)
fun Any?.isNotNull(): Boolean {
	contract {
		returns(true) implies (this@isNotNull != null)
	}
	return !isNull()
}

/**
 * 判断当前对象是否为 null。
 *
 * 通过 Kotlin 契约支持智能类型转换：返回 false 后编译器可将接收者视为非空。
 *
 * @return 为 null 返回 true，否则返回 false
 */
@OptIn(ExperimentalContracts::class)
fun Any?.isNull(): Boolean {
	contract {
		returns(false) implies (this@isNull != null)
	}
	return this == null
}

/**
 * 判断两个对象是否相等，两者均为 null 时也视为相等。
 *
 * @param a 第一个对象
 * @param b 第二个对象
 * @return 相等（含均为 null）返回 true，否则返回 false
 */
fun areEquals(a: Any?, b: Any?) = (a == null && b == null) || (a == b)

/**
 * 判断两个非空对象是否相等，任一为 null 时返回 false。
 *
 * 通过 Kotlin 契约支持智能类型转换：返回 true 后编译器可将两个参数视为非空。
 *
 * @param a 第一个对象
 * @param b 第二个对象
 * @return 两者均非空且相等返回 true，否则返回 false
 */
@OptIn(ExperimentalContracts::class)
fun areEqualsNoNull(a: Any?, b: Any?): Boolean {
	contract {
		returns(true) implies (a != null && b != null)
	}
	return a != null && b != null && a == b
}
