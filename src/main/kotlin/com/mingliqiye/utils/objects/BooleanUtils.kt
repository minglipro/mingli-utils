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

class BooleanIfFunction(private val boolean: Boolean) {

	fun elses(function: () -> Unit): Boolean {
		if (boolean) {
			function()
		}
		return !boolean
	}
}

inline fun Boolean.ifs(function: () -> Unit): BooleanIfFunction {
	return if (this) {
		function()
		BooleanIfFunction(false)
	} else BooleanIfFunction(true)
}
