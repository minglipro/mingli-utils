/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile JacksonJsonApi.java
 * LastUpdate 2025-09-09 09:31:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 基于Jackson的JSON处理实现类，提供JSON字符串解析、格式化、合并、节点操作等功能。
 */
public class JacksonJsonApi implements JsonApi {

	private final ObjectMapper objectMapper;

	/**
	 * 使用默认的ObjectMapper构造实例
	 */
	public JacksonJsonApi() {
		this.objectMapper = new ObjectMapper();
	}

	/**
	 * 使用指定的ObjectMapper构造实例
	 *
	 * @param objectMapper 自定义的ObjectMapper实例
	 */
	public JacksonJsonApi(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
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
	@Override
	public <T> T parse(String json, Class<T> clazz) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new JsonException("Failed to parse JSON string", e);
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
	@Override
	public <T> T parse(String json, JsonTypeReference<T> type) {
		try {
			ObjectReader reader = objectMapper.readerFor(
				objectMapper.constructType(type.getType())
			);
			return reader.readValue(json);
		} catch (IOException e) {
			throw new JsonException("Failed to parse JSON string", e);
		}
	}

	/**
	 * 将对象格式化为JSON字符串
	 *
	 * @param object 待格式化的对象
	 * @return 格式化后的JSON字符串
	 * @throws JsonException 当格式化失败时抛出异常
	 */
	@Override
	public String format(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new JsonException(
				"Failed to format object to JSON string",
				e
			);
		}
	}

	/**
	 * 将对象格式化为美化（带缩进）的JSON字符串
	 *
	 * @param object 待格式化的对象
	 * @return 美化后的JSON字符串
	 * @throws JsonException 当格式化失败时抛出异常
	 */
	@Override
	public String formatPretty(Object object) {
		try {
			return objectMapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new JsonException(
				"Failed to format object to pretty JSON string",
				e
			);
		}
	}

	/**
	 * 将JSON字符串解析为指定元素类型的List
	 *
	 * @param json        JSON字符串
	 * @param elementType List中元素的类型
	 * @param <T>         泛型参数，表示List中元素的类型
	 * @return 解析后的List对象
	 */
	@Override
	public <T> List<T> parseList(String json, Class<T> elementType) {
		return parse(json, JsonTypeUtils.listType(elementType));
	}

	/**
	 * 将JSON字符串解析为指定键值类型的Map
	 *
	 * @param json      JSON字符串
	 * @param keyType   Map中键的类型
	 * @param valueType Map中值的类型
	 * @param <K>       泛型参数，表示Map中键的类型
	 * @param <V>       泛型参数，表示Map中值的类型
	 * @return 解析后的Map对象
	 */
	@Override
	public <K, V> Map<K, V> parseMap(
		String json,
		Class<K> keyType,
		Class<V> valueType
	) {
		return parse(json, JsonTypeUtils.MapType(keyType, valueType));
	}

	/**
	 * 判断给定字符串是否是有效的JSON格式
	 *
	 * @param json 待验证的字符串
	 * @return 如果是有效JSON返回true，否则返回false
	 */
	@Override
	public boolean isValidJson(String json) {
		try {
			objectMapper.readTree(json);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 合并多个JSON字符串为一个JSON对象
	 *
	 * @param jsons 多个JSON字符串
	 * @return 合并后的JSON字符串
	 * @throws JsonException 当合并失败时抛出异常
	 */
	@Override
	public String merge(String... jsons) {
		ObjectNode result = objectMapper.createObjectNode();
		for (String json : jsons) {
			try {
				JsonNode node = objectMapper.readTree(json);
				if (node.isObject()) {
					result.setAll((ObjectNode) node);
				}
			} catch (IOException e) {
				// 忽略无效的JSON字符串
			}
		}
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			throw new JsonException("Failed to merge JSON strings", e);
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
	@Override
	public String getNodeValue(String json, String path) {
		try {
			JsonNode node = objectMapper.readTree(json);
			String[] paths = path.split("\\.");
			for (String p : paths) {
				node = node.get(p);
				if (node == null) {
					return null;
				}
			}
			return node.asText();
		} catch (IOException e) {
			throw new JsonException("Failed to get node value", e);
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
	@Override
	public String updateNodeValue(String json, String path, Object newValue) {
		try {
			JsonNode node = objectMapper.readTree(json);
			if (node instanceof ObjectNode) {
				ObjectNode objectNode = (ObjectNode) node;
				String[] paths = path.split("\\.");
				JsonNode current = objectNode;

				// 导航到目标节点的父节点
				for (int i = 0; i < paths.length - 1; i++) {
					current = current.get(paths[i]);
					if (current == null || !(current instanceof ObjectNode)) {
						return json; // 路径不存在或无效
					}
				}

				// 更新值
				if (current instanceof ObjectNode) {
					ObjectNode parent = (ObjectNode) current;
					if (newValue == null) {
						parent.remove(paths[paths.length - 1]);
					} else {
						parent.set(
							paths[paths.length - 1],
							objectMapper.valueToTree(newValue)
						);
					}
				}

				return objectMapper.writeValueAsString(objectNode);
			}
			return json;
		} catch (IOException e) {
			throw new JsonException("Failed to update node value", e);
		}
	}

	/**
	 * 在不同对象类型之间进行转换
	 *
	 * @param source            源对象
	 * @param destinationClass  目标对象类型
	 * @param <T>               源对象类型
	 * @param <D>               目标对象类型
	 * @return 转换后的对象
	 */
	@Override
	public <T, D> D convert(T source, Class<D> destinationClass) {
		return objectMapper.convertValue(source, destinationClass);
	}

	/**
	 * 在不同泛型对象类型之间进行转换
	 *
	 * @param source           源对象
	 * @param destinationType  目标对象的泛型类型引用
	 * @param <T>              源对象类型
	 * @param <D>              目标对象类型
	 * @return 转换后的对象
	 */
	@Override
	public <T, D> D convert(T source, JsonTypeReference<D> destinationType) {
		return objectMapper.convertValue(
			source,
			objectMapper.constructType(destinationType.getType())
		);
	}
}
