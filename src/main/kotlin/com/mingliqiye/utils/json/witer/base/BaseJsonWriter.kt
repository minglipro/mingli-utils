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
 * LastUpdate 2026-11-17 19:32:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.witer.base

import com.mingliqiye.utils.json.judgment.BaseJsonJudgment


interface BaseJsonWriter : BaseJsonJudgment {
	fun setObject(objCall: (BaseJsonObjectWriter) -> BaseJsonObjectWriter)
	fun setArray(arrayCall: (BaseJsonArrayWriter) -> BaseJsonArrayWriter)
	fun setString(string: String)
	fun setNumber(number: Number)
	fun setBoolean(boolean: Boolean)
	fun setNull()
}
