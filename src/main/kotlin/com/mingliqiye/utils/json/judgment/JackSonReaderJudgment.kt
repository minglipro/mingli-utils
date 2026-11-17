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
 * CurrentFile JackSonReaderJudgment.kt
 * LastUpdate 2026-11-17 20:29:39
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.judgment

import com.fasterxml.jackson.databind.JsonNode
import com.mingliqiye.utils.json.judgment.base.BaseJsonJudgment

/**
 * 基于 Jackson2 JsonNode 的类型判断实现，各判定属性直接委托给节点自身
 *
 * @param treeNode 待判断的 Jackson2 JsonNode 节点
 */
open class JackSonReaderJudgment(
	private val treeNode: JsonNode,
) : BaseJsonJudgment {
	override val isObject: Boolean
		get() = treeNode.isObject
	override val isArray: Boolean
		get() = treeNode.isArray
	override val isString: Boolean
		get() = treeNode.isTextual
	override val isNumber: Boolean
		get() = treeNode.isNumber
	override val isBoolean: Boolean
		get() = treeNode.isBoolean
	override val isNull: Boolean
		get() = treeNode.isNull

}
