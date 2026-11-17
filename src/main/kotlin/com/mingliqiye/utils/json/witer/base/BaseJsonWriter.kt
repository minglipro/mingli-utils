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
 * CurrentFile BaseJsonWriter.kt
 * LastUpdate 2026-11-17 21:10:29
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer.base

import com.mingliqiye.utils.json.judgment.base.BaseJsonJudgment


/**
 * JSON 写入器基础接口，继承类型判断能力，定义将当前节点写为各种类型值的方法
 */
interface BaseJsonWriter : BaseJsonJudgment {
	/**
	 * 写入一个 JSON 对象，通过回调填充对象字段
	 *
	 * @param objCall 对象写入回调，接收对象写入器并返回它
	 */
	fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter)

	/**
	 * 写入一个 JSON 数组，通过回调填充数组元素
	 *
	 * @param arrayCall 数组写入回调，接收数组写入器并返回它
	 */
	fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter)

	/**
	 * 写入字符串值
	 *
	 * @param string 待写入的字符串
	 */
	fun setString(string: String)

	/**
	 * 写入数值
	 *
	 * @param number 待写入的数值
	 */
	fun setNumber(number: Number)

	/**
	 * 写入布尔值
	 *
	 * @param boolean 待写入的布尔值
	 */
	fun setBoolean(boolean: Boolean)

	/**
	 * 写入 null 值
	 */
	fun setNull()
}
