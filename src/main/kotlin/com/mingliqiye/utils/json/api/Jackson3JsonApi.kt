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
 * CurrentFile Jackson3JsonApi.kt
 * LastUpdate 2026-11-17 19:59:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api

import com.mingliqiye.utils.exception.JsonException
import com.mingliqiye.utils.json.api.JackSon3JsonItem.Companion.getJsonItem
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.objects.base.*
import tools.jackson.core.type.TypeReference
import tools.jackson.databind.JsonNode
import tools.jackson.databind.ObjectMapper
import tools.jackson.databind.node.JsonNodeType
import tools.jackson.databind.node.ObjectNode
import java.lang.reflect.Type

/**
 * 基于Jackson3的JSON处理实现类，提供JSON字符串解析、格式化、合并、节点操作等功能。
 *
 * 节点路径操作（[getNodeValue]、[updateNodeValue]）使用JSON Pointer风格路径（如"/user/name"）。
 * ObjectMapper支持直接持有，也支持通过get/set回调间接访问外部实例。
 */
class Jackson3JsonApi : JsonApi {

	/**
	 * ObjectMapper的获取回调，默认返回内部持有的实例
	 */
	var get: () -> ObjectMapper = { _prObjectMapper!! }
	/**
	 * ObjectMapper的设置回调，默认写入内部持有的实例
	 */
	var set: (ObjectMapper) -> Unit = { _prObjectMapper = it }

	private var _prObjectMapper: ObjectMapper? = null


	/**
	 * 当前使用的ObjectMapper实例，读写均通过[get]/[set]回调转发
	 */
	var objectMapper: ObjectMapper
		get() = get()
		private set(value) = set(value)

	/**
	 * 使用指定的ObjectMapper构造实例
	 *
	 * @param objectMapper 自定义的ObjectMapper实例
	 */
	constructor(objectMapper: ObjectMapper) {
		_prObjectMapper = objectMapper
	}

	/**
	 * 使用获取/设置回调构造实例，ObjectMapper由外部管理
	 *
	 * @param get ObjectMapper的获取回调
	 * @param set ObjectMapper的设置回调
	 */
	constructor(
		get: () -> ObjectMapper,
		set: (ObjectMapper) -> Unit,
	) {
		this.get = get
		this.set = set
	}

	/**
	 * 使用默认的ObjectMapper构造实例
	 */
	constructor() {
		_prObjectMapper = ObjectMapper()
	}

	override fun <T> parse(json: String, clazz: Class<T>): T {
		try {
			return objectMapper.readValue(json, clazz)
		} catch (e: Exception) {
			throw JsonException("Failed to parse JSON to ${clazz.simpleName}", e)
		}
	}

	override fun <T> parse(json: String, type: JsonTypeReference<T>): T {
		try {
			return objectMapper.readValue(json, object : TypeReference<T>() {
				override fun getType(): Type = type.type
			})
		} catch (e: Exception) {
			throw JsonException("Failed to parse JSON to type: $type", e)
		}
	}

	override fun format(obj: Any): String {
		try {
			return objectMapper.writeValueAsString(obj)
		} catch (e: Exception) {
			throw JsonException("Failed to format object to JSON: ${obj.javaClass.simpleName}", e)
		}
	}

	override fun formatPretty(obj: Any): String {
		try {
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj)
		} catch (e: Exception) {
			throw JsonException("Failed to format object to pretty JSON: ${obj.javaClass.simpleName}", e)
		}
	}

	override fun isValidJson(json: String): Boolean {
		return try {
			objectMapper.readTree(json)
			true
		} catch (_: Exception) {
			false
		}
	}

	/**
	 * 合并多个JSON对象字符串；无参数时返回"{}"，遇到非对象JSON时抛出JsonException
	 */
	override fun merge(vararg jsons: String): String {
		try {
			if (jsons.isEmpty()) return "{}"

			val resultNode = objectMapper.createObjectNode()

			for (json in jsons) {
				val node = objectMapper.readTree(json)
				if (node is ObjectNode) {
					resultNode.setAll(node)
				} else {
					throw JsonException("Cannot merge non-object JSON: $json")
				}
			}

			return objectMapper.writeValueAsString(resultNode)
		} catch (e: Exception) {
			throw JsonException("Failed to merge JSON objects", e)
		}
	}

	/**
	 * 获取指定路径的节点值，路径为JSON Pointer风格（如"/user/name"），节点缺失或为null时返回null
	 */
	override fun getNodeValue(json: String, path: String): String? {
		try {
			val rootNode = objectMapper.readTree(json)
			val node = rootNode.at(path)

			return if (node.isMissingNode || node.isNull) {
				null
			} else {
				node.asString()
			}
		} catch (e: Exception) {
			throw JsonException("Failed to get node value at path: $path", e)
		}
	}

	/**
	 * 更新指定路径的节点值，路径为JSON Pointer风格（如"/user/name"），空路径时替换整个根节点
	 */
	override fun updateNodeValue(json: String, path: String, newValue: Any): String {
		try {
			val rootNode = objectMapper.readTree(json)

			// 处理 JSON Pointer 路径
			val pathParts = path.split("/").filter { it.isNotEmpty() }

			if (pathParts.isEmpty()) {
				// 替换整个根节点
				return objectMapper.writeValueAsString(newValue)
			}

			when (val parentNode = findParentNode(rootNode, pathParts)) {
				is ObjectNode -> {
					val fieldName = pathParts.last()
					val valueNode = objectMapper.valueToTree<JsonNode>(newValue)
					parentNode.replace(fieldName, valueNode)
				}

				else -> {
					throw JsonException("Cannot update node: parent is not an object node at path: $path")
				}
			}

			return objectMapper.writeValueAsString(rootNode)
		} catch (e: Exception) {
			throw JsonException("Failed to update node value at path: $path", e)
		}
	}

	override fun <D> convert(source: Any, destinationClass: Class<D>): D {
		try {
			return objectMapper.convertValue(source, destinationClass)
		} catch (e: Exception) {
			throw JsonException(
				"Failed to convert from ${source.javaClass.simpleName} to ${destinationClass.simpleName}", e
			)
		}
	}

	override fun <D> convert(
		source: Any,
		destinationType: JsonTypeReference<D>,
	): D {
		try {
			return objectMapper.convertValue(source, object : TypeReference<D>() {
				override fun getType(): Type = destinationType.type
			})
		} catch (e: Exception) {
			throw JsonException("Failed to convert from ${source.javaClass.simpleName} to type: $destinationType", e)
		}
	}


	// 辅助方法：查找父节点
	private fun findParentNode(root: JsonNode, pathParts: List<String>): JsonNode {
		var current: JsonNode = root

		// 遍历到最后一个元素之前（即找到父节点）
		for (i in 0 until pathParts.size - 1) {
			val part = pathParts[i]
			current = when {
				part.matches(Regex("\\d+")) -> current.get(part.toInt())
				else -> current.get(part)
			} ?: throw JsonException("Path not found: ${pathParts.subList(0, i + 1).joinToString("/")}")
		}

		return current
	}


	/**
	 * 将JSON字符串解析为JsonItem对象，解析失败时包装为JsonException抛出
	 */
	override fun parseJsonItem(json: String): JsonItem {
		try {
			return getJsonItem(objectMapper.readTree(json))
		} catch (e: Exception) {
			throw JsonException("Failed to parseJsonItem", e)
		}
	}
}


/**
 * 基于Jackson3的JsonItem标记实现类，通过伴生对象工厂方法创建具体的JsonItem
 */
class JackSon3JsonItem : JsonItem {
	/**
	 * 伴生对象，提供JsonNode到JsonItem的工厂方法
	 */
	companion object {
		/**
		 * 根据JsonNode的节点类型创建对应的JsonItem实例
		 *
		 * @param node Jackson3的JsonNode节点
		 * @return 与节点类型对应的JsonItem实例
		 * @throws IllegalStateException 当节点类型未知时抛出
		 */
		fun getJsonItem(node: JsonNode): JsonItem {
			return when (node.nodeType) {
				JsonNodeType.OBJECT -> JackSon3JsonObject(node)
				JsonNodeType.ARRAY -> JackSon3JsonArray(node)
				JsonNodeType.BOOLEAN -> JackSon3JsonBoolean(node)
				JsonNodeType.NULL -> JsonNull()
				JsonNodeType.NUMBER -> JackSon3JsonNumber(node)
				JsonNodeType.STRING -> JackSon3JsonString(node)
				else -> throw IllegalStateException("unknown type ${node.nodeType}")
			}
		}
	}
}

/**
 * 基于Jackson3节点的JSON数字类型
 *
 * @param node 数字类型的JsonNode节点
 */
class JackSon3JsonNumber(node: JsonNode) : JsonNumber(node.asString())
/**
 * 基于Jackson3节点的JSON布尔类型
 *
 * @param node 布尔类型的JsonNode节点
 */
class JackSon3JsonBoolean(node: JsonNode) : JsonBoolean(node.asBoolean())
/**
 * 基于Jackson3节点的JSON字符串类型
 *
 * @param node 字符串类型的JsonNode节点
 */
class JackSon3JsonString(node: JsonNode) : JsonString(node.asString())


/**
 * 基于Jackson3节点的JSON数组类型
 *
 * @property node 数组类型的JsonNode节点
 */
class JackSon3JsonArray(val node: JsonNode) : JsonArray() {
	override fun getIndex(index: Int): JsonItem {
		return JackSon3JsonItem.getJsonItem(node.get(index))
	}

	override fun iteratorArray(): Iterator<IndexedValue<JsonItem>> {
		val iteet = node.iterator().withIndex()
		return object : Iterator<IndexedValue<JsonItem>> {
			override fun next(): IndexedValue<JsonItem> {
				val it = iteet.next()
				return IndexedValue(it.index, JackSon3JsonItem.getJsonItem(it.value))
			}

			override fun hasNext(): Boolean {
				return iteet.hasNext()
			}

		}
	}
}

/**
 * 基于Jackson3节点的JSON对象类型
 *
 * @property node 对象类型的JsonNode节点
 */
class JackSon3JsonObject(val node: JsonNode) : JsonObject() {
	override fun getField(name: String): JsonItem {
		return JackSon3JsonItem.getJsonItem(node.get(name))
	}

	override fun iteratorObject(): Iterator<Map.Entry<String, JsonItem>> {
		return object : Iterator<Map.Entry<String, JsonItem>> {
			val it = node.properties().iterator()
			override fun next(): Map.Entry<String, JsonItem> {
				val utem = it.next()
				return object : Map.Entry<String, JsonItem> {
					override val key: String
						get() = utem.key
					override val value: JsonItem
						get() = JackSon3JsonItem.getJsonItem(utem.value)
				}
			}

			override fun hasNext(): Boolean {
				return it.hasNext()
			}
		}
	}
}
