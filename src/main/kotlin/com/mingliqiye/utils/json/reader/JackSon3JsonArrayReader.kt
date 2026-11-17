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
 * CurrentFile JackSon3JsonArrayReader.kt
 * LastUpdate 2026-11-17 20:29:39
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader

import com.mingliqiye.utils.json.judgment.JackSon3ReaderJudgment
import com.mingliqiye.utils.json.reader.base.BaseJsonArrayReader
import com.mingliqiye.utils.json.reader.base.BaseJsonObjectReader
import tools.jackson.databind.JsonNode
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 基于 Jackson3 JsonNode 的 JSON 数组读取器实现，按索引读取各类型值
 *
 * @param treeNode 待读取的 Jackson3 JsonNode 数组节点
 */
class JackSon3JsonArrayReader(
	private val treeNode: JsonNode,
) : BaseJsonArrayReader, JackSon3ReaderJudgment(treeNode) {
	override fun getIndexObject(key: Int): BaseJsonObjectReader {
		return JackSon3JsonObjectReader(treeNode[key])
	}

	override fun getIndexArray(key: Int): BaseJsonArrayReader {
		return JackSon3JsonArrayReader(treeNode[key])
	}

	override fun getIndexString(key: Int): String {
		return treeNode[key].stringValue()
	}

	override fun getIndexBoolean(key: Int): Boolean {
		return treeNode[key].booleanValue()
	}

	override fun getIndexByte(key: Int): Byte {
		return getIndexShort(key).toByte()
	}

	override fun getIndexShort(key: Int): Short {
		return treeNode[key].shortValue()
	}

	override fun getIndexInt(key: Int): Int {
		return treeNode[key].intValue()
	}

	override fun getIndexLong(key: Int): Long {
		return treeNode[key].longValue()
	}

	override fun getIndexFloat(key: Int): Float {
		return treeNode[key].floatValue()
	}

	override fun getIndexDouble(key: Int): Double {
		return treeNode[key].doubleValue()
	}

	override fun getIndexBigInteger(key: Int): BigInteger {
		return treeNode[key].bigIntegerValue()
	}

	override fun getIndexBigDecimal(key: Int): BigDecimal {
		return treeNode[key].decimalValue()
	}

}
