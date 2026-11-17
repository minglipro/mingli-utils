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
 * CurrentFile JackSon3ReaderJudgment.kt
 * LastUpdate 2026-11-17 20:29:39
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.judgment

import com.mingliqiye.utils.json.judgment.base.BaseJsonJudgment
import tools.jackson.databind.JsonNode

open class JackSon3ReaderJudgment(
	private val treeNode: JsonNode,
) : BaseJsonJudgment {
	override val isObject: Boolean
		get() = treeNode.isObject
	override val isArray: Boolean
		get() = treeNode.isArray
	override val isString: Boolean
		get() = treeNode.isString
	override val isNumber: Boolean
		get() = treeNode.isNumber
	override val isBoolean: Boolean
		get() = treeNode.isBoolean
	override val isNull: Boolean
		get() = treeNode.isNull

}
