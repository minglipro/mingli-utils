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
 * CurrentFile GsonJsonApi.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonArray as GsonElementArray
import com.google.gson.JsonObject as GsonElementObject
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
 * 基于 Gson 的 [JsonApi] 实现。
 *
 * 提供解析、序列化、美化输出、树转换、节点读取/更新和对象转换能力。
 * 内部持有一个线程安全的 [Gson] 实例（[Gson] 本身不可变，可多线程共享）。
 *
 * ### 字段注解
 * Gson 的 [Gson] 自定义适配器在 `read` / `write` 时只能看到类型，看不到所属字段的
 * 注解（如 `@DateTimeJsonFormat`）。因此该实现**不会**自动应用依赖字段注解的
 * 转换器；需要字段注解驱动转换时，请使用 Jackson 实现，或在 Gson 的自定义
 * Bean 绑定中自行处理字段注解。
 *
 * ### 使用示例
 * ```kotlin
 * val api = GsonJsonApi()
 * val user = api.parse("""{"name":"mingli"}""", User::class.java)
 * val json = api.format(user)
 * val node = api.parseJsonItem(json)
 * ```
 *
 * @constructor 使用默认配置的 [Gson] 创建实例。
 * @see JsonApi
 * @see Gson
 */
class GsonJsonApi : JsonApi {

	/**
	 * 内部使用的 Gson 实例，所有解析、序列化和树转换都通过它完成。
	 */
	private val gson: Gson

	/**
	 * 用于 [formatPretty] 的 Gson 实例，继承 [gson] 的全部配置并开启美化输出。
	 */
	private val prettyGson: Gson

	/**
	 * 使用默认配置的 [Gson] 创建实例。
	 */
	constructor() : this(Gson())

	/**
	 * 使用调用方提供的 [Gson] 创建实例。
	 *
	 * @param gson 已配置好的 Gson 实例
	 */
	constructor(gson: Gson) {
		this.gson = gson
		this.prettyGson = gson.newBuilder().setPrettyPrinting().create()
	}

	/**
	 * 使用 [GsonBuilder] 创建实例。
	 *
	 * @param builder Gson 构建器
	 */
	constructor(builder: GsonBuilder) : this(builder.create())

	/**
	 * 获取内部使用的 [Gson] 实例。
	 *
	 * @return 当前 Gson 实例
	 */
	fun getGson(): Gson = gson

	/**
	 * 将 JSON 字符串解析为指定类型的对象。
	 *
	 * @param json JSON 字符串
	 * @param clazz 目标类型
	 * @param T 目标类型泛型
	 * @return 解析后的对象
	 * @throws JsonException 解析失败时抛出
	 */
	override fun <T> parse(json: String, clazz: Class<T>): T {
		return try {
			gson.fromJson(json, clazz)
		} catch (e: Exception) {
			throw JsonException("Failed to parse JSON to ${clazz.simpleName}", e)
		}
	}

	/**
	 * 将 JSON 字符串解析为指定泛型类型的对象。
	 *
	 * @param json JSON 字符串
	 * @param type 泛型类型引用
	 * @param T 目标类型泛型
	 * @return 解析后的对象
	 * @throws JsonException 解析失败时抛出
	 */
	override fun <T> parse(json: String, type: JsonTypeReference<T>): T {
		return try {
			gson.fromJson(json, type.type)
		} catch (e: Exception) {
			throw JsonException("Failed to parse JSON to type: $type", e)
		}
	}

	/**
	 * 将 UTF-8 字节数组解析为指定类型的对象。
	 *
	 * @param json JSON 字节数组
	 * @param clazz 目标类型
	 * @param T 目标类型泛型
	 * @return 解析后的对象
	 * @throws JsonException 解析失败时抛出
	 */
	override fun <T> parse(json: ByteArray, clazz: Class<T>): T {
		return parse(String(json, Charsets.UTF_8), clazz)
	}

	/**
	 * 将 UTF-8 字节数组解析为指定泛型类型的对象。
	 *
	 * @param json JSON 字节数组
	 * @param type 泛型类型引用
	 * @param T 目标类型泛型
	 * @return 解析后的对象
	 * @throws JsonException 解析失败时抛出
	 */
	override fun <T> parse(json: ByteArray, type: JsonTypeReference<T>): T {
		return parse(String(json, Charsets.UTF_8), type)
	}

	/**
	 * 将对象序列化为紧凑 JSON 字符串。
	 *
	 * @param obj 待序列化对象
	 * @return JSON 字符串
	 * @throws JsonException 序列化失败时抛出
	 */
	override fun format(obj: Any): String {
		return try {
			gson.toJson(obj)
		} catch (e: Exception) {
			throw JsonException("Failed to format object to JSON: ${obj.javaClass.simpleName}", e)
		}
	}

	/**
	 * 将对象序列化为带缩进和换行的美化 JSON 字符串。
	 *
	 * @param obj 待序列化对象
	 * @return 美化后的 JSON 字符串
	 * @throws JsonException 序列化失败时抛出
	 */
	override fun formatPretty(obj: Any): String {
		return try {
			prettyGson.toJson(obj)
		} catch (e: Exception) {
			throw JsonException("Failed to format object to pretty JSON: ${obj.javaClass.simpleName}", e)
		}
	}

	/**
	 * 判断字符串是否为有效 JSON。
	 *
	 * Gson 默认会拒绝空文档；JSON 的 `null` 会被认为是一个合法值。
	 *
	 * @param json 待验证字符串
	 * @return 有效返回 `true`
	 */
	override fun isValidJson(json: String): Boolean {
		return try {
			gson.fromJson(json, JsonElement::class.java) != null
		} catch (_: Exception) {
			false
		}
	}

	/**
	 * 合并多个 JSON 对象字符串。
	 *
	 * 与 Jackson2 实现保持一致：只做顶层浅合并，非对象或非法 JSON 会被忽略。
	 *
	 * @param jsons JSON 对象字符串
	 * @return 合并后的 JSON 字符串
	 * @throws JsonException 合并后序列化失败时抛出
	 */
	override fun merge(vararg jsons: String): String {
		val result = GsonElementObject()
		for (json in jsons) {
			try {
				val element = gson.fromJson(json, JsonElement::class.java)
				if (element != null && element.isJsonObject) {
					element.asJsonObject.entrySet().forEach { entry ->
						result.add(entry.key, entry.value)
					}
				}
			} catch (_: Exception) {
				// 与 Jackson2 实现一致：忽略非法 JSON
			}
		}
		return format(result)
	}

	/**
	 * 按点号路径读取节点值，例如 `user.name`。
	 *
	 * 路径中的数字段可用于数组下标，例如 `users.0.name`。
	 * 节点不存在或为 JSON null 时返回 `null`。
	 *
	 * @param json JSON 字符串
	 * @param path 点号分隔的路径
	 * @return 节点文本；容器节点返回其 JSON 文本
	 * @throws JsonException JSON 解析失败时抛出
	 */
	override fun getNodeValue(json: String, path: String): String? {
		try {
			val root = parseElement(json)
			if (path.isBlank()) {
				return nodeText(root)
			}
			var current: JsonElement = root
			for (part in path.split('.')) {
				current = child(current, part) ?: return null
				if (current.isJsonNull) {
					return null
				}
			}
			return nodeText(current)
		} catch (e: JsonException) {
			throw e
		} catch (e: Exception) {
			throw JsonException("Failed to get node value at path: $path", e)
		}
	}

	/**
	 * 按点号路径更新节点值，空路径表示替换整个根节点。
	 *
	 * 路径中的数字段可用于数组下标。路径不存在或父节点不是对象/数组时，
	 * 返回原始 JSON 字符串。
	 *
	 * @param json 原始 JSON 字符串
	 * @param path 点号分隔的路径
	 * @param newValue 新值
	 * @return 更新后的 JSON 字符串
	 * @throws JsonException JSON 解析或序列化失败时抛出
	 */
	override fun updateNodeValue(json: String, path: String, newValue: Any): String {
		try {
			val root = parseElement(json)
			if (path.isBlank()) {
				return format(newValue)
			}
			val parts = path.split('.')
			var current: JsonElement = root
			for (i in 0 until parts.size - 1) {
				current = child(current, parts[i]) ?: return json
				if (current.isJsonNull) {
					return json
				}
			}
			val key = parts.last()
			val value = gson.toJsonTree(newValue)
			when {
				current.isJsonObject -> current.asJsonObject.add(key, value)
				current.isJsonArray -> {
					val index = key.toIntOrNull() ?: return json
					val array = current.asJsonArray
					if (index !in 0 until array.size()) {
						return json
					}
					array.set(index, value)
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

	/**
	 * 将任意对象转换为指定类型。
	 *
	 * 实现方式为先通过 Gson 转成 JSON 树，再按目标类型反序列化。
	 *
	 * @param source 源对象
	 * @param destinationClass 目标类型
	 * @param D 目标类型泛型
	 * @return 转换后的对象
	 * @throws JsonException 转换失败时抛出
	 */
	override fun <D> convert(source: Any, destinationClass: Class<D>): D {
		return try {
			gson.fromJson(gson.toJsonTree(source), destinationClass)
		} catch (e: Exception) {
			throw JsonException(
				"Failed to convert from ${source.javaClass.simpleName} to ${destinationClass.simpleName}", e
			)
		}
	}

	/**
	 * 将任意对象转换为指定泛型类型。
	 *
	 * @param source 源对象
	 * @param destinationType 目标泛型类型引用
	 * @param D 目标类型泛型
	 * @return 转换后的对象
	 * @throws JsonException 转换失败时抛出
	 */
	override fun <D> convert(source: Any, destinationType: JsonTypeReference<D>): D {
		return try {
			gson.fromJson(gson.toJsonTree(source), destinationType.type)
		} catch (e: Exception) {
			throw JsonException("Failed to convert from ${source.javaClass.simpleName} to type: $destinationType", e)
		}
	}

	/**
	 * 将 JSON 字符串解析为统一的 [JsonItem] 树。
	 *
	 * @param json JSON 字符串
	 * @return 树根节点
	 * @throws JsonException 解析失败时抛出
	 */
	override fun parseJsonItem(json: String): JsonItem {
		return GsonJsonItem.getJsonItem(parseElement(json))
	}

	/**
	 * 将 UTF-8 字节数组解析为 [JsonItem] 树。
	 *
	 * @param byte JSON 字节数组
	 * @return 树根节点
	 * @throws JsonException 解析失败时抛出
	 */
	override fun parseJsonItem(byte: ByteArray): JsonItem {
		return parseJsonItem(String(byte, Charsets.UTF_8))
	}

	/**
	 * 解析 JSON 字符串并返回 Gson 的树元素。
	 *
	 * @param json JSON 字符串
	 * @return Gson [JsonElement]
	 * @throws JsonException 空文档或解析失败时抛出
	 */
	private fun parseElement(json: String): JsonElement {
		return try {
			gson.fromJson(json, JsonElement::class.java)
				?: throw JsonException("JSON is empty")
		} catch (e: JsonException) {
			throw e
		} catch (e: Exception) {
			throw JsonException("Failed to parse JSON", e)
		}
	}

	/**
	 * 读取容器中的子节点。
	 *
	 * @param element 当前节点
	 * @param part 对象字段名或数组下标
	 * @return 子节点；不存在时返回 `null`
	 */
	private fun child(element: JsonElement, part: String): JsonElement? {
		return when {
			element.isJsonObject -> element.asJsonObject.get(part)
			element.isJsonArray -> part.toIntOrNull()?.let { index ->
				val array = element.asJsonArray
				if (index in 0 until array.size()) array.get(index) else null
			}
			else -> null
		}
	}

	/**
	 * 将节点转换为文本。
	 *
	 * 原始类型返回文本值，对象/数组返回 JSON 文本，JSON null 返回 `null`。
	 *
	 * @param element 节点
	 * @return 文本值或 `null`
	 */
	private fun nodeText(element: JsonElement): String? {
		return when {
			element.isJsonNull -> null
			element.isJsonPrimitive -> element.asString
			else -> element.toString()
		}
	}
}

/**
 * 基于 Gson [JsonElement] 的 [JsonItem] 工厂。
 */
class GsonJsonItem private constructor() {

	companion object {
		/**
		 * 将 Gson 节点转换为统一的 [JsonItem]。
		 *
		 * @param element Gson 节点，允许为 `null`
		 * @return 对应的 [JsonItem]；`null` 转为 [JsonNull]
		 * @throws JsonException 遇到未知节点类型时抛出
		 */
		fun getJsonItem(element: JsonElement?): JsonItem {
			if (element == null || element.isJsonNull) {
				return JsonNull()
			}
			return when {
				element.isJsonObject -> GsonJsonObject(element.asJsonObject)
				element.isJsonArray -> GsonJsonArray(element.asJsonArray)
				element.isJsonPrimitive -> {
					val primitive = element.asJsonPrimitive
					when {
						primitive.isBoolean -> GsonJsonBoolean(primitive.asBoolean)
						primitive.isNumber -> GsonJsonNumber(primitive.asString)
						primitive.isString -> GsonJsonString(primitive.asString)
						else -> GsonJsonString(primitive.asString)
					}
				}
				else -> throw JsonException("Unknown JSON element: $element")
			}
		}
	}
}

/**
 * 基于 Gson 对象的 [JsonObject] 实现。
 *
 * @param element Gson 对象节点
 */
class GsonJsonObject(val element: GsonElementObject) : JsonObject() {
	override fun getField(name: String): JsonItem {
		return GsonJsonItem.getJsonItem(element.get(name))
	}

	override fun iteratorObject(): Iterator<Map.Entry<String, JsonItem>> {
		return element.entrySet().asSequence().map { entry ->
			object : Map.Entry<String, JsonItem> {
				override val key: String get() = entry.key
				override val value: JsonItem get() = GsonJsonItem.getJsonItem(entry.value)
			}
		}.iterator()
	}
}

/**
 * 基于 Gson 数组的 [JsonArray] 实现。
 *
 * @param element Gson 数组节点
 */
class GsonJsonArray(val element: GsonElementArray) : JsonArray() {
	override fun getIndex(index: Int): JsonItem {
		return if (index in 0 until element.size()) {
			GsonJsonItem.getJsonItem(element.get(index))
		} else {
			JsonNull()
		}
	}

	override fun iteratorArray(): Iterator<IndexedValue<JsonItem>> {
		return element.withIndex().map { indexed ->
			IndexedValue(indexed.index, GsonJsonItem.getJsonItem(indexed.value))
		}.iterator()
	}
}

/**
 * 基于 Gson 布尔值的 [JsonBoolean] 实现。
 *
 * @param value 布尔值
 */
class GsonJsonBoolean(value: Boolean) : JsonBoolean(value)

/**
 * 基于 Gson 字符串的 [JsonString] 实现。
 *
 * @param value 字符串值
 */
class GsonJsonString(value: String) : JsonString(value)

/**
 * 基于 Gson 数字文本的 [JsonNumber] 实现。
 *
 * @param numberString 数字的字符串表示
 */
class GsonJsonNumber(numberString: String) : JsonNumber(numberString)
