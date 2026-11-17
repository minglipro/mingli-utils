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

/**
 * JSON 节点类型判断接口，提供当前节点的类型判定属性，默认实现均返回 false
 */
interface BaseJsonJudgment {
	/** 当前节点是否为 JSON 对象 */
	val isObject: Boolean
		get() = false
	/** 当前节点是否为 JSON 数组 */
	val isArray: Boolean
		get() = false
	/** 当前节点是否为字符串 */
	val isString: Boolean
		get() = false
	/** 当前节点是否为数字 */
	val isNumber: Boolean
		get() = false
	/** 当前节点是否为布尔值 */
	val isBoolean: Boolean
		get() = false

	/** 当前节点是否为 null */
	val isNull: Boolean
		get() = false
	/** 当前节点是否不为 null */
	val isNotNull: Boolean
		get() = !isNull
}
