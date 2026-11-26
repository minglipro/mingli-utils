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
 * CurrentFile FastJson2JsonApi.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api

import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.JSONArray as FastJsonElementArray
import com.alibaba.fastjson2.JSONFactory
import com.alibaba.fastjson2.JSONObject as FastJsonElementObject
import com.alibaba.fastjson2.JSONReader
import com.alibaba.fastjson2.JSONWriter
import com.alibaba.fastjson2.reader.ObjectReaderProvider
import com.alibaba.fastjson2.writer.ObjectWriterProvider
import com.mingliqiye.utils.exception.JsonException
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.objects.base.JsonArray
import com.mingliqiye.utils.json.objects.base.JsonBoolean
import com.mingliqiye.utils.json.objects.base.JsonItem
import com.mingliqiye.utils.json.objects.base.JsonNull
import com.mingliqiye.utils.json.objects.base.JsonNumber
import com.mingliqiye.utils.json.objects.base.JsonObject
import com.mingliqiye.utils.json.objects.base.JsonString

/**
 * 基于 Fastjson2 的 [JsonApi] 实现。
 *
 * 使用独立的 [ObjectWriterProvider] / [ObjectReaderProvider]，不会修改 Fastjson2
 * 全局默认 provider；调用方可以注入预注册了自定义转换器的 provider。
 *
 * ### 安全
 * 本实现不启用 `SupportAutoType`，解析 `Object` 时只会得到 [FastJsonElementObject]、
 * [FastJsonElementArray] 和普通值，不会根据 JSON 内容实例化任意类。
 *
 * ### 字段注解
 * Fastjson2 自己的 `@JSONField` 会正常生效；但 JSONA 的
 * `@DateTimeJsonFormat` / `@UUIDJsonFormat` 等字段注解无法通过 Fastjson2 的
 * [com.alibaba.fastjson2.writer.ObjectWriter] 获取，和 Gson 适配器一样需要
 * 在 Bean 字段层自行接管。
 *
 * @constructor 创建使用独立默认 provider 的实例。
 * @see JsonApi
 */
class FastJson2JsonApi : JsonApi {

	/**
	 * 对象写出 provider，保存自定义 [ObjectWriterProvider] 注册。
	 */
	private val writerProvider: ObjectWriterProvider

	/**
	 * 对象读取 provider，保存自定义 [ObjectReaderProvider] 注册。
	 */
	private val readerProvider: ObjectReaderProvider

	/**
	 * 使用独立的默认 provider 创建实例。
	 */
	constructor() : this(ObjectWriterProvider(), ObjectReaderProvider())

	/**
	 * 使用调用方提供的 provider 创建实例。
	 *
	 * @param writerProvider 写出 provider
	 * @param readerProvider 读取 provider
	 */
	constructor(writerProvider: ObjectWriterProvider, readerProvider: ObjectReaderProvider) {
		this.writerProvider = writerProvider
		this.readerProvider = readerProvider
	}

	/**
	 * 获取当前写出 provider。
	 *
	 * @return 写出 provider
	 */
	fun getWriterProvider(): ObjectWriterProvider = writerProvider

	/**
	 * 获取当前读取 provider。
	 *
	 * @return 读取 provider
	 */
	fun getReaderProvider(): ObjectReaderProvider = readerProvider

	/**
	 * 创建一次写出上下文。
	 *
	 * @param features 额外写出 Feature
	 * @return 写出上下文
	 */
	private fun writeContext(vararg features: JSONWriter.Feature): JSONWriter.Context {
		return JSONFactory.createWriteContext(writerProvider, *features)
	}

	/**
	 * 创建一次读取上下文。
	 *
	 * @return 读取上下文
	 */
	private fun readContext(): JSONReader.Context {
		return JSONFactory.createReadContext(readerProvider)
	}

	override fun <T> parse(json: String, clazz: Class<T>): T {
		return try {
			JSON.parseObject(json, clazz, readContext())
		} catch (e: Exception) {
			throw JsonException("Failed to parse JSON to ${clazz.simpleName}", e)
		}
	}

	override fun <T> parse(json: String, type: JsonTypeReference<T>): T {
		return try {
			JSON.parseObject(json, type.type, readContext())
		} catch (e: Exception) {
			throw JsonException("Failed to parse JSON to type: $type", e)
		}
	}

	override fun <T> parse(json: ByteArray, clazz: Class<T>): T {
		return parse(String(json, Charsets.UTF_8), clazz)
	}

	override fun <T> parse(json: ByteArray, type: JsonTypeReference<T>): T {
		return parse(String(json, Charsets.UTF_8), type)
	}

	override fun format(obj: Any): String {
		return try {
			JSON.toJSONString(obj, writeContext())
		} catch (e: Exception) {
			throw JsonException("Failed to format object to JSON: ${obj.javaClass.simpleName}", e)
		}
	}

	override fun formatPretty(obj: Any): String {
		return try {
			JSON.toJSONString(obj, writeContext(JSONWriter.Feature.PrettyFormat))
		} catch (e: Exception) {
			throw JsonException("Failed to format object to pretty JSON: ${obj.javaClass.simpleName}", e)
		}
	}

	override fun isValidJson(json: String): Boolean {
		return try {
			JSON.parse(json, readContext())
			true
		} catch (_: Exception) {
			false
		}
	}

	override fun merge(vararg jsons: String): String {
		val result = FastJsonElementObject()
		for (json in jsons) {
			try {
				val value = JSON.parse(json, readContext())
				if (value is FastJsonElementObject) {
					result.putAll(value)
				}
			} catch (_: Exception) {
				// 与 Jackson2/Gson 实现保持一致：忽略非法 JSON
			}
		}
		return format(result)
	}

	override fun getNodeValue(json: String, path: String): String? {
		try {
			val root = parseValue(json)
			if (path.isBlank()) {
				return nodeText(root)
			}
			var current: Any? = root
			for (part in path.split('.')) {
				current = child(current, part) ?: return null
			}
			return nodeText(current)
		} catch (e: JsonException) {
			throw e
		} catch (e: Exception) {
			throw JsonException("Failed to get node value at path: $path", e)
		}
	}

	override fun updateNodeValue(json: String, path: String, newValue: Any): String {
		try {
			val root = parseValue(json) ?: return json
			if (path.isBlank()) {
				return format(newValue)
			}
			val parts = path.split('.')
			var current: Any? = root
			for (i in 0 until parts.size - 1) {
				current = child(current, parts[i]) ?: return json
			}
			val key = parts.last()
			when (current) {
				is FastJsonElementObject -> current[key] = newValue
				is FastJsonElementArray -> {
					val index = key.toIntOrNull() ?: return json
					if (index !in 0 until current.size) {
						return json
					}
					current[index] = newValue
				}
				else -> return json
			}
			return format(root)
		} catch (e: JsonException) {
			throw e
		} catch (e: Exception) {
			throw JsonException("Failed to update node value at path: $path", e)
		}
	}

	override fun <D> convert(source: Any, destinationClass: Class<D>): D {
		return try {
			JSON.parseObject(
				JSON.toJSONString(source, writeContext()),
				destinationClass,
				readContext()
			)
		} catch (e: Exception) {
			throw JsonException(
				"Failed to convert from ${source.javaClass.simpleName} to ${destinationClass.simpleName}", e
			)
		}
	}

	override fun <D> convert(source: Any, destinationType: JsonTypeReference<D>): D {
		return try {
			JSON.parseObject(
				JSON.toJSONString(source, writeContext()),
				destinationType.type,
				readContext()
			)
		} catch (e: Exception) {
			throw JsonException("Failed to convert from ${source.javaClass.simpleName} to type: $destinationType", e)
		}
	}

	override fun parseJsonItem(json: String): JsonItem {
		return FastJson2JsonItem.getJsonItem(parseValue(json))
	}

	override fun parseJsonItem(byte: ByteArray): JsonItem {
		return parseJsonItem(String(byte, Charsets.UTF_8))
	}

	/**
	 * 解析为 Fastjson2 的通用树。
	 *
	 * @param json JSON 字符串
	 * @return [FastJsonElementObject]、[FastJsonElementArray]、普通值或 null
	 * @throws JsonException 解析失败时抛出
	 */
	private fun parseValue(json: String): Any? {
		return try {
			JSON.parse(json, readContext())
		} catch (e: Exception) {
			throw JsonException("Failed to parse JSON", e)
		}
	}

	/**
	 * 读取容器中的子值。
	 *
	 * @param current 当前值
	 * @param part 字段名或数组下标
	 * @return 子值；不存在时返回 null
	 */
	private fun child(current: Any?, part: String): Any? {
		return when (current) {
			is FastJsonElementObject -> current[part]
			is FastJsonElementArray -> part.toIntOrNull()?.let { index ->
				if (index in 0 until current.size) current[index] else null
			}
			else -> null
		}
	}

	/**
	 * 将任意 JSON 值转为文本。
	 *
	 * @param value 值
	 * @return 文本；null 返回 null；对象/数组返回 JSON 文本
	 */
	private fun nodeText(value: Any?): String? {
		return when (value) {
			null -> null
			is String, is Number, is Boolean -> value.toString()
			else -> value.toString()
		}
	}
}

/**
 * 基于 Fastjson2 普通值的 [JsonItem] 工厂。
 */
class FastJson2JsonItem private constructor() {

	companion object {
		/**
		 * 将 Fastjson2 解析结果转换为统一的 [JsonItem]。
		 *
		 * @param value Fastjson2 值
		 * @return 对应的 [JsonItem]；null 转为 [JsonNull]
		 */
		fun getJsonItem(value: Any?): JsonItem {
			return when (value) {
				null -> JsonNull()
				is FastJsonElementObject -> FastJson2JsonObject(value)
				is FastJsonElementArray -> FastJson2JsonArray(value)
				is Boolean -> FastJson2JsonBoolean(value)
				is String -> FastJson2JsonString(value)
				is Number -> FastJson2JsonNumber(value.toString())
				else -> FastJson2JsonString(value.toString())
			}
		}
	}
}

/**
 * 基于 Fastjson2 JSONObject 的 [JsonObject] 实现。
 *
 * @param element Fastjson2 对象
 */
class FastJson2JsonObject(val element: FastJsonElementObject) : JsonObject() {
	override fun getField(name: String): JsonItem {
		return FastJson2JsonItem.getJsonItem(element[name])
	}

	override fun iteratorObject(): Iterator<Map.Entry<String, JsonItem>> {
		return element.entries.asSequence().map { entry ->
			object : Map.Entry<String, JsonItem> {
				override val key: String get() = entry.key
				override val value: JsonItem get() = FastJson2JsonItem.getJsonItem(entry.value)
			}
		}.iterator()
	}
}

/**
 * 基于 Fastjson2 JSONArray 的 [JsonArray] 实现。
 *
 * @param element Fastjson2 数组
 */
class FastJson2JsonArray(val element: FastJsonElementArray) : JsonArray() {
	override fun getIndex(index: Int): JsonItem {
		return if (index in 0 until element.size) {
			FastJson2JsonItem.getJsonItem(element[index])
		} else {
			JsonNull()
		}
	}

	override fun iteratorArray(): Iterator<IndexedValue<JsonItem>> {
		return element.withIndex().map { indexed ->
			IndexedValue(indexed.index, FastJson2JsonItem.getJsonItem(indexed.value))
		}.iterator()
	}
}

/**
 * 基于 Fastjson2 布尔值的 [JsonBoolean] 实现。
 *
 * @param value 布尔值
 */
class FastJson2JsonBoolean(value: Boolean) : JsonBoolean(value)

/**
 * 基于 Fastjson2 字符串的 [JsonString] 实现。
 *
 * @param value 字符串
 */
class FastJson2JsonString(value: String) : JsonString(value)

/**
 * 基于 Fastjson2 数字文本的 [JsonNumber] 实现。
 *
 * @param numberString 数字文本
 */
class FastJson2JsonNumber(numberString: String) : JsonNumber(numberString)
