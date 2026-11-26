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
 * CurrentFile GsonReaderJudgment.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.judgment

import com.google.gson.JsonElement
import com.mingliqiye.utils.json.judgment.base.BaseJsonJudgment

/**
 * 基于 Gson [JsonElement] 的类型判断实现，各判定属性直接委托给节点自身。
 *
 * @param element 待判断的 Gson 节点
 */
open class GsonReaderJudgment(
	private val element: JsonElement,
) : BaseJsonJudgment {

	/**
	 * 当前节点是否为 JSON 对象。
	 */
	override val isObject: Boolean
		get() = element.isJsonObject

	/**
	 * 当前节点是否为 JSON 数组。
	 */
	override val isArray: Boolean
		get() = element.isJsonArray

	/**
	 * 当前节点是否为 JSON 字符串。
	 */
	override val isString: Boolean
		get() = element.isJsonPrimitive && element.asJsonPrimitive.isString

	/**
	 * 当前节点是否为 JSON 数字。
	 */
	override val isNumber: Boolean
		get() = element.isJsonPrimitive && element.asJsonPrimitive.isNumber

	/**
	 * 当前节点是否为 JSON 布尔值。
	 */
	override val isBoolean: Boolean
		get() = element.isJsonPrimitive && element.asJsonPrimitive.isBoolean

	/**
	 * 当前节点是否为 JSON null。
	 */
	override val isNull: Boolean
		get() = element.isJsonNull
}
