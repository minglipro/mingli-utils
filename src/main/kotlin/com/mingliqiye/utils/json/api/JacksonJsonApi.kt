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
 * CurrentFile JacksonJsonApi.kt
 * LastUpdate 2026-02-05 14:41:27
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectReader
import com.fasterxml.jackson.databind.node.ObjectNode
import com.mingliqiye.utils.exception.JsonException
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.base.BaseJsonConverter

/**
 * 基于Jackson的JSON处理实现类，提供JSON字符串解析、格式化、合并、节点操作等功能。
 */
class JacksonJsonApi : JsonApi {

    private val objectMapper: ObjectMapper

    /**
     * 使用默认的ObjectMapper构造实例
     */
    constructor() {
        this.objectMapper = ObjectMapper()
    }

    /**
     * 使用指定的ObjectMapper构造实例
     *
     * @param objectMapper 自定义的ObjectMapper实例
     */
    constructor(objectMapper: ObjectMapper) {
        this.objectMapper = objectMapper
    }

    /**
     * 将JSON字符串解析为指定类型的对象
     *
     * @param json  待解析的JSON字符串
     * @param clazz 目标对象类型
     * @param <T>   泛型参数，表示目标对象类型
     * @return 解析后的对象
     * @throws JsonException 当解析失败时抛出异常
     */
    override fun <T> parse(json: String, clazz: Class<T>): T {
        return try {
            objectMapper.readValue(json, clazz)
        } catch (e: Exception) {
            throw JsonException("Failed to parse JSON string", e)
        }
    }

    /**
     * 将JSON字符串解析为复杂泛型结构的对象（如List、Map等）
     *
     * @param json JSON字符串
     * @param type 泛型类型引用
     * @param <T>  泛型参数，表示目标对象类型
     * @return 解析后的对象
     * @throws JsonException 当解析失败时抛出异常
     */
    override fun <T> parse(json: String, type: JsonTypeReference<T>): T {
        return try {
            val reader: ObjectReader = objectMapper.readerFor(
                objectMapper.constructType(type.type)
            )
            reader.readValue(json)
        } catch (e: Exception) {
            throw JsonException("Failed to parse JSON string", e)
        }
    }

    /**
     * 将对象格式化为JSON字符串
     *
     * @param `object` 待格式化的对象
     * @return 格式化后的JSON字符串
     * @throws JsonException 当格式化失败时抛出异常
     */
    override fun format(obj: Any): String {
        return try {
            objectMapper.writeValueAsString(obj)
        } catch (e: Exception) {
            throw JsonException(
                "Failed to format object to JSON string", e
            )
        }
    }

    override fun formatUnicode(obj: Any): String {
        return try {
            objectMapper.writer().with(JsonGenerator.Feature.ESCAPE_NON_ASCII).writeValueAsString(obj)
        } catch (e: Exception) {
            throw JsonException(e)
        }
    }

    /**
     * 将对象格式化为美化（带缩进）的JSON字符串
     *
     * @param `object` 待格式化的对象
     * @return 美化后的JSON字符串
     * @throws JsonException 当格式化失败时抛出异常
     */
    override fun formatPretty(obj: Any): String {
        return try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj)
        } catch (e: Exception) {
            throw JsonException(
                "Failed to format object to pretty JSON string", e
            )
        }
    }

    override fun formatPrettyUnicode(obj: Any): String {
        return try {
            objectMapper.writerWithDefaultPrettyPrinter().with(JsonGenerator.Feature.ESCAPE_NON_ASCII)
                .writeValueAsString(obj)
        } catch (e: Exception) {
            throw JsonException(
                "Failed to format object to pretty JSON string", e
            )
        }
    }


    /**
     * 判断给定字符串是否是有效的JSON格式
     *
     * @param json 待验证的字符串
     * @return 如果是有效JSON返回true，否则返回false
     */
    override fun isValidJson(json: String): Boolean {
        return try {
            objectMapper.readTree(json)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * 合并多个JSON字符串为一个JSON对象
     *
     * @param jsons 多个JSON字符串
     * @return 合并后的JSON字符串
     * @throws JsonException 当合并失败时抛出异常
     */
    override fun merge(vararg jsons: String): String {
        val result: ObjectNode = objectMapper.createObjectNode()
        for (json in jsons) {
            try {
                val node: JsonNode = objectMapper.readTree(json)
                if (node.isObject) {
                    result.setAll<JsonNode>(node as ObjectNode)
                }
            } catch (e: Exception) {
            }
        }
        return try {
            objectMapper.writeValueAsString(result)
        } catch (e: JsonProcessingException) {
            throw JsonException("Failed to merge JSON strings", e)
        }
    }

    /**
     * 获取JSON字符串中指定路径的节点值
     *
     * @param json JSON字符串
     * @param path 节点路径，使用"."分隔
     * @return 节点值的文本表示，如果路径不存在则返回null
     * @throws JsonException 当获取节点值失败时抛出异常
     */
    override fun getNodeValue(json: String, path: String): String? {
        return try {
            var node: JsonNode = objectMapper.readTree(json)
            val paths: Array<String> = path.split("\\.".toRegex()).toTypedArray()
            for (p in paths) {
                node = node.get(p)
            }
            node.asText()
        } catch (e: Exception) {
            throw JsonException("Failed to get node value", e)
        }
    }

    /**
     * 更新JSON字符串中指定路径的节点值
     *
     * @param json     JSON字符串
     * @param path     节点路径，使用"."分隔
     * @param newValue 新的节点值
     * @return 更新后的JSON字符串
     * @throws JsonException 当更新节点值失败时抛出异常
     */
    override fun updateNodeValue(json: String, path: String, newValue: Any): String {
        return try {
            val node: JsonNode = objectMapper.readTree(json)
            if (node is ObjectNode) {
                val objectNode: ObjectNode = node
                val paths: Array<String> = path.split("\\.".toRegex()).toTypedArray()
                var current: JsonNode = objectNode

                // 导航到目标节点的父节点
                for (i in 0 until paths.size - 1) {
                    current = current.get(paths[i])
                    if (current !is ObjectNode) {
                        return json // 路径不存在或无效
                    }
                }

                // 更新值
                if (current is ObjectNode) {
                    val parent: ObjectNode = current
                    parent.set<JsonNode>(
                        paths[paths.size - 1], objectMapper.valueToTree(newValue)
                    )
                }

                objectMapper.writeValueAsString(objectNode)
            }
            json
        } catch (e: Exception) {
            throw JsonException("Failed to update node value", e)
        }
    }

    /**
     * 在不同对象类型之间进行转换
     *
     * @param source           源对象
     * @param destinationClass 目标对象类型
     * @param <T>              源对象类型
     * @param <D>              目标对象类型
     * @return 转换后的对象
     */
    override fun <D> convert(source: Any, destinationClass: Class<D>): D {
        try {
            return objectMapper.convertValue(source, destinationClass)
        } catch (e: Exception) {
            throw JsonException("Failed to update node value", e)
        }
    }

    /**
     * 在不同泛型对象类型之间进行转换
     *
     * @param source          源对象
     * @param destinationType 目标对象的泛型类型引用
     * @param <T>             源对象类型
     * @param <D>             目标对象类型
     * @return 转换后的对象
     */
    override fun <D> convert(source: Any, destinationType: JsonTypeReference<D>): D {
        try {
            return objectMapper.convertValue(
                source, objectMapper.constructType(destinationType.type)
            )
        } catch (e: Exception) {
            throw JsonException("Failed to update node value", e)
        }
    }

    override fun addJsonConverter(c: BaseJsonConverter<*, *>) {
        try {
            objectMapper.registerModule(c.getJacksonModule())
        } catch (e: Exception) {
            throw JsonException("Failed to update node value", e)
        }
    }
}
