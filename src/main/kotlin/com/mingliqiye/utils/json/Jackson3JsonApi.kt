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
 * LastUpdate 2026-03-11 08:46:40
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json

import com.mingliqiye.utils.exception.JsonException
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.base.BaseJsonConverter
import com.mingliqiye.utils.json.converters.base.getJackson3Module
import tools.jackson.core.type.TypeReference
import tools.jackson.databind.JsonNode
import tools.jackson.databind.ObjectMapper
import tools.jackson.databind.node.ObjectNode
import java.lang.reflect.Type

class Jackson3JsonApi : JsonApi {

    var get: () -> ObjectMapper
    var set: (ObjectMapper) -> Unit

    private var _prObjectMapper: ObjectMapper? = null


    private var objectMapper: ObjectMapper
        get() = get()
        set(value) = set(value)

    constructor(objectMapper: ObjectMapper) {
        _prObjectMapper = objectMapper
        get = { _prObjectMapper!! }
        set = { _prObjectMapper = it }
    }

    constructor(
        get: () -> ObjectMapper,
        set: (ObjectMapper) -> Unit,
    ) {
        this.get = get
        this.set = set
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
        } catch (e: Exception) {
            false
        }
    }

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
                "Failed to convert from ${source.javaClass.simpleName} to ${destinationClass.simpleName}",
                e
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

    override fun addJsonConverter(c: BaseJsonConverter<*, *>) {
        val mapperBuilder = Jackson3ApiJavaHelper.rebuild(objectMapper)
        mapperBuilder.addModule(c.getJackson3Module())
        this.objectMapper = mapperBuilder.build()
    }
}
