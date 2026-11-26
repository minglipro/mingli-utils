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
 * CurrentFile FastJson2ReaderJudgment.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.judgment

import com.alibaba.fastjson2.JSONArray
import com.alibaba.fastjson2.JSONObject
import com.mingliqiye.utils.json.judgment.base.BaseJsonJudgment

/**
 * 基于 Fastjson2 解析值的类型判断实现。
 *
 * @param value Fastjson2 解析出的值
 */
open class FastJson2ReaderJudgment(
	private val value: Any?,
) : BaseJsonJudgment {

	override val isObject: Boolean
		get() = value is JSONObject

	override val isArray: Boolean
		get() = value is JSONArray

	override val isString: Boolean
		get() = value is String

	override val isNumber: Boolean
		get() = value is Number

	override val isBoolean: Boolean
		get() = value is Boolean

	override val isNull: Boolean
		get() = value == null
}
