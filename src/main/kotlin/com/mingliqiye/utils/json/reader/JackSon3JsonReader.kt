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
 * CurrentFile JackSon3JsonReader.kt
 * LastUpdate 2026-11-17 20:29:39
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.reader

import com.mingliqiye.utils.json.judgment.JackSon3ReaderJudgment
import com.mingliqiye.utils.json.reader.base.BaseJsonArrayReader
import com.mingliqiye.utils.json.reader.base.BaseJsonObjectReader
import com.mingliqiye.utils.json.reader.base.BaseJsonReader
import tools.jackson.databind.JsonNode
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 基于 Jackson3 JsonNode 的 JSON 读取器实现，将节点值读取为各种类型
 *
 * @param treeNode 待读取的 Jackson3 JsonNode 节点
 */
class JackSon3JsonReader(
	private val treeNode: JsonNode,
) : BaseJsonReader, JackSon3ReaderJudgment(treeNode) {
	override fun getObject(): BaseJsonObjectReader {
		return JackSon3JsonObjectReader(treeNode)
	}

	override fun getArray(): BaseJsonArrayReader {
		return JackSon3JsonArrayReader(treeNode)
	}

	override fun getString(): String {
		return treeNode.asString()
	}

	override fun getBoolean(): Boolean {
		return treeNode.booleanValue()
	}

	override fun getByte(): Byte {
		return getShort().toByte()
	}

	override fun getShort(): Short {
		return treeNode.shortValue()
	}

	override fun getInt(): Int {
		return treeNode.intValue()
	}

	override fun getLong(): Long {
		return treeNode.longValue()
	}

	override fun getFloat(): Float {
		return treeNode.floatValue()
	}

	override fun getDouble(): Double {
		return treeNode.doubleValue()
	}

	override fun getBigInteger(): BigInteger {
		return treeNode.bigIntegerValue()
	}

	override fun getBigDecimal(): BigDecimal {
		return treeNode.decimalValue()
	}

}
