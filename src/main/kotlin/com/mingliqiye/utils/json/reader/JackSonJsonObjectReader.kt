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
 * CurrentFile JackSonJsonObjectReader.kt
 * LastUpdate 2026-11-17 20:29:39
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader

import com.fasterxml.jackson.databind.JsonNode
import com.mingliqiye.utils.json.judgment.JackSonReaderJudgment
import com.mingliqiye.utils.json.reader.base.BaseJsonArrayReader
import com.mingliqiye.utils.json.reader.base.BaseJsonObjectReader
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 基于 Jackson2 JsonNode 的 JSON 对象读取器实现，按字段名读取各类型值
 *
 * @param treeNode 待读取的 Jackson2 JsonNode 对象节点
 */
class JackSonJsonObjectReader(
	private val treeNode: JsonNode,
) : BaseJsonObjectReader, JackSonReaderJudgment(treeNode) {

	override fun getFieldObject(key: String): BaseJsonObjectReader {
		return JackSonJsonObjectReader(treeNode[key])
	}

	override fun getFieldArray(key: String): BaseJsonArrayReader {
		return JackSonJsonArrayReader(treeNode[key])
	}

	override fun getFieldString(key: String): String {
		return treeNode[key].textValue()
	}

	override fun getFieldBoolean(key: String): Boolean {
		return treeNode[key].booleanValue()
	}

	override fun getFieldByte(key: String): Byte {
		return getFieldShort(key).toByte()
	}

	override fun getFieldShort(key: String): Short {
		return treeNode[key].shortValue()
	}

	override fun getFieldInt(key: String): Int {
		return treeNode[key].intValue()
	}

	override fun getFieldLong(key: String): Long {
		return treeNode[key].longValue()
	}

	override fun getFieldFloat(key: String): Float {
		return treeNode[key].floatValue()

	}

	override fun getFieldDouble(key: String): Double {
		return treeNode[key].doubleValue()

	}

	override fun getFieldBigInteger(key: String): BigInteger {
		return treeNode[key].bigIntegerValue()

	}

	override fun getFieldBigDecimal(key: String): BigDecimal {
		return treeNode[key].decimalValue()
	}

	override val isObject: Boolean
		get() = treeNode.isObject

}
