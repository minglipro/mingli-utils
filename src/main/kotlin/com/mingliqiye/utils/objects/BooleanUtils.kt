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
 * CurrentFile BooleanUtils.kt
 * LastUpdate 2026-10-22 19:57:04
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.objects

/**
 * 布尔条件链式调用的辅助类。
 *
 * 由 [Boolean.ifs] 创建，用于在条件为 false 时执行 else 分支。
 *
 * @param boolean 取反后的条件值，为 true 时表示 if 分支未执行
 */
class BooleanIfFunction(private val boolean: Boolean) {

	/**
	 * 当 if 分支未执行（原条件为 false）时执行给定函数。
	 *
	 * @param function 条件为 false 时要执行的函数
	 * @return 原条件为 true 时返回 true，否则返回 false
	 */
	fun elses(function: () -> Unit): Boolean {
		if (boolean) {
			function()
		}
		return !boolean
	}
}

/**
 * 布尔值的链式 if 扩展：条件为 true 时立即执行给定函数。
 *
 * 可继续调用 [BooleanIfFunction.elses] 处理条件为 false 的分支。
 *
 * @param function 条件为 true 时要执行的函数
 * @return 用于衔接 else 分支的 [BooleanIfFunction] 实例
 */
inline fun Boolean.ifs(function: () -> Unit): BooleanIfFunction {
	return if (this) {
		function()
		BooleanIfFunction(false)
	} else BooleanIfFunction(true)
}
