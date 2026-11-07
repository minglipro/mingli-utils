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
 * CurrentFile JsonObject.kt
 * LastUpdate 2026-06-21 10:40:58
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.objects.base

import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

/**
 * JSON 元素接口，定义所有 JSON 数据类型的通用操作
 */
interface JsonItem {
	/**
	 * 作为 JSON 对象返回
	 * @throws IllegalStateException 如果不是对象类型
	 */
	fun asObject(): JsonObject {
		throw IllegalStateException("Current JSON element is ${name()} not a Object")
	}

	/**
	 * 作为 JSON 数组返回
	 * @throws IllegalStateException 如果不是数组类型
	 */
	fun asArray(): JsonArray {
		throw IllegalStateException("Current JSON element is ${name()} not a Array")
	}

	/**
	 * 作为字符串返回
	 * @throws IllegalStateException 如果不是字符串类型
	 */
	fun asString(): String {
		throw IllegalStateException("Current JSON element is ${name()} not a String")
	}

	/**
	 * 作为布尔值返回
	 * @throws IllegalStateException 如果不是布尔类型
	 */
	fun asBoolean(): Boolean {
		throw IllegalStateException("Current JSON element is ${name()} not a Boolean")
	}

	/**
	 * 作为数字返回
	 * @throws IllegalStateException 如果不是数字类型
	 */
	fun asNumber(): JsonNumber {
		throw IllegalStateException("Current JSON element is ${name()} not a Number")
	}

	/**
	 * 转换为 List 集合
	 * @throws IllegalStateException 如果不是数组类型
	 */
	fun toList(): List<JsonItem> {
		val it = asArray().iteratorArray()
		val list = LinkedList<JsonItem>()
		it.forEach { item -> list.add(item.value) }
		return list
	}

	/**
	 * 转换为 Map 集合
	 * @throws IllegalStateException 如果不是对象类型
	 */
	fun toMap(): Map<String, JsonItem> {
		val it = asObject().iteratorObject()
		val map = LinkedHashMap<String, JsonItem>()
		it.forEach { item -> map[item.key] = item.value }
		return map
	}

	/** 是否为 null */
	fun isNull(): Boolean = false

	/** 是否为布尔值 */
	fun isBoolean(): Boolean = false

	/** 是否为数字 */
	fun isNumber(): Boolean = false

	/** 是否为字符串 */
	fun isString(): Boolean = false

	/** 是否为对象 */
	fun isObject(): Boolean = false

	/** 是否为数组 */
	fun isArray(): Boolean = false

	/** 返回当前元素的类型名称 */
	fun name(): String = "Any"

	/** 根据索引获取元素（数组专用） */
	fun get(index: Int): JsonItem = getIndex(index)

	/** 根据字段名获取元素（对象专用） */
	fun get(fieldName: String): JsonItem = getField(fieldName)

	/**
	 * 根据索引获取元素
	 * @throws IllegalStateException 如果不是数组类型
	 */
	fun getIndex(index: Int): JsonItem {
		throw IllegalStateException("Current JSON element is ${name()} not a Array")
	}

	/**
	 * 根据字段名获取元素
	 * @throws IllegalStateException 如果不是对象类型
	 */
	fun getField(name: String): JsonItem {
		throw IllegalStateException("Current JSON element is ${name()} not a Object")
	}

	/**
	 * 遍历数组元素
	 * @param consumer 接收索引和元素的消费者函数
	 */
	fun forEachArray(consumer: (Int, JsonItem) -> Unit) {
		iteratorArray().forEach {
			consumer(it.index, it.value)
		}
	}

	/**
	 * 遍历对象字段
	 * @param consumer 接收字段名和值的消费者函数
	 */
	fun forEachObject(consumer: (String, JsonItem) -> Unit) {
		iteratorObject().forEach {
			consumer(it.key, it.value)
		}
	}

	/**
	 * 获取数组迭代器
	 * @throws IllegalStateException 如果不是数组类型
	 */
	fun iteratorArray(): Iterator<IndexedValue<JsonItem>> {
		throw IllegalStateException("Current JSON element is ${name()} not a Array")
	}

	/**
	 * 获取对象迭代器
	 * @throws IllegalStateException 如果不是对象类型
	 */
	fun iteratorObject(): Iterator<Map.Entry<String, JsonItem>> {
		throw IllegalStateException("Current JSON element is ${name()} not a Object")
	}
}

/**
 * JSON 对象抽象类
 * 表示键值对形式的 JSON 对象 {}
 */
abstract class JsonObject : JsonItem {
	override fun isObject(): Boolean = true
	override fun name(): String = "object"
	override fun asObject(): JsonObject = this
	override fun toString(): String = StringBuilder().apply {
		append("{")
		iteratorObject().forEach {
			append(it.key)
			append("=")
			append(it.value)
			append(",")
		}
		deleteCharAt(length - 1)
		append("}")
	}.toString()
}

/**
 * JSON 数组抽象类
 * 表示有序的 JSON 数组 []
 */
abstract class JsonArray : JsonItem {
	override fun isArray(): Boolean = true
	override fun name(): String = "array"
	override fun asArray() = this
	override fun toString(): String = StringBuilder().apply {
		append("[")
		iteratorArray().forEach {
			append(it.value)
			append(",")
		}
		deleteCharAt(length - 1)
		append("]")
	}.toString()
}

/**
 * JSON null 类型
 * 表示 JSON 中的 null 值
 */
open class JsonNull : JsonItem {
	override fun isNull(): Boolean = true
	override fun name(): String = "null"
	override fun toString(): String = "null"
}

/**
 * JSON 数字类型
 * 表示 JSON 中的数字，继承自 Number 以便转换为各种数值类型
 * @param numberString 数字的字符串表示形式
 */
open class JsonNumber(val numberString: String) : JsonItem, Number() {
	override fun isNumber(): Boolean = true
	override fun name(): String = "number"
	override fun asNumber(): JsonNumber = this
	override fun toDouble(): Double = numberString.toDouble()
	override fun toFloat(): Float = numberString.toFloat()
	override fun toLong(): Long = numberString.toLong()
	override fun toInt(): Int = numberString.toInt()
	override fun toShort(): Short = numberString.toShort()
	override fun toByte(): Byte = numberString.toByte()

	/** 转换为 BigDecimal */
	open fun toBigDecimal(): BigDecimal = numberString.toBigDecimal()

	/** 转换为指定精度的 BigDecimal */
	open fun toBigDecimal(scale: Int): BigDecimal = numberString.toBigDecimal().setScale(scale)

	/** 转换为 BigInteger */
	open fun toBigInteger(): BigInteger = numberString.toBigInteger()

	override fun toString(): String = numberString
}

/**
 * JSON 字符串类型
 * @param value 字符串值
 */
open class JsonString(val value: String) : JsonItem {
	override fun isString(): Boolean = true
	override fun name(): String = "string"
	override fun asString(): String {
		return value
	}

	override fun toString(): String = value
}

/**
 * JSON 布尔类型
 * @param value 布尔值
 */
open class JsonBoolean(val value: Boolean) : JsonItem {
	override fun isBoolean(): Boolean = true
	override fun name(): String = "boolean"
	override fun asBoolean(): Boolean {
		return value
	}

	override fun toString(): String = value.toString()
}
