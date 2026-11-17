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
 * CurrentFile BaseJsonJudgment.kt
 * LastUpdate 2026-11-17 20:26:28
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.judgment.base

interface BaseJsonJudgment {
	val isObject: Boolean
		get() = false
	val isArray: Boolean
		get() = false
	val isString: Boolean
		get() = false
	val isNumber: Boolean
		get() = false
	val isBoolean: Boolean
		get() = false

	val isNull: Boolean
		get() = false
	val isNotNull: Boolean
		get() = !isNull
}
