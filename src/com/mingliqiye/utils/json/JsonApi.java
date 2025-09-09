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
 * CurrentFile JsonApi.java
 * LastUpdate 2025-09-09 09:22:02
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json;

import java.util.List;
import java.util.Map;

/**
 * JSON处理接口，提供JSON字符串与Java对象之间的相互转换功能
 */
public interface JsonApi {
	/**
	 * 将JSON字符串解析为指定类型的对象
	 *
	 * @param json 待解析的JSON字符串
	 * @param clazz 目标对象的Class类型
	 * @param <T> 泛型参数，表示目标对象的类型
	 * @return 解析后的对象实例
	 */
	<T> T parse(String json, Class<T> clazz);

	/**
	 * 将JSON字符串解析为指定泛型类型对象
	 *
	 * @param json 待解析的JSON字符串
	 * @param type 目标对象的Type类型（支持泛型）
	 * @param <T> 泛型参数，表示目标对象的类型
	 * @return 解析后的对象实例
	 */
	<T> T parse(String json, JsonTypeReference<T> type);

	/**
	 * 将对象格式化为JSON字符串
	 *
	 * @param object 待格式化的对象
	 * @return 格式化后的JSON字符串
	 */
	String format(Object object);

	/**
	 * 将字节数组形式的JSON解析为指定类型的对象
	 *
	 * @param json 待解析的JSON字节数组
	 * @param clazz 目标对象的Class类型
	 * @param <T> 泛型参数，表示目标对象的类型
	 * @return 解析后的对象实例
	 */
	default <T> T parse(byte[] json, Class<T> clazz) {
		return parse(new String(json), clazz);
	}

	/**
	 * 将字节数组形式的JSON解析为指定泛型类型对象
	 *
	 * @param json 待解析的JSON字节数组
	 * @param type 目标对象的Type类型（支持泛型）
	 * @param <T> 泛型参数，表示目标对象的类型
	 * @return 解析后的对象实例
	 */
	default <T> T parse(byte[] json, JsonTypeReference<T> type) {
		return parse(new String(json), type);
	}

	/**
	 * 将JSON字符串解析为指定类型的对象，解析失败时返回默认值
	 *
	 * @param json 待解析的JSON字符串
	 * @param clazz 目标对象的Class类型
	 * @param defaultValue 解析失败时返回的默认值
	 * @param <T> 泛型参数，表示目标对象的类型
	 * @return 解析后的对象实例或默认值
	 */
	default <T> T parse(String json, Class<T> clazz, T defaultValue) {
		try {
			return parse(json, clazz);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 将JSON字符串解析为指定泛型类型对象，解析失败时返回默认值
	 *
	 * @param json 待解析的JSON字符串
	 * @param type 目标对象的Type类型（支持泛型）
	 * @param defaultValue 解析失败时返回的默认值
	 * @param <T> 泛型参数，表示目标对象的类型
	 * @return 解析后的对象实例或默认值
	 */
	default <T> T parse(
		String json,
		JsonTypeReference<T> type,
		T defaultValue
	) {
		try {
			return parse(json, type);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 将对象格式化为美化格式的JSON字符串（带缩进和换行）
	 *
	 * @param object 待格式化的对象
	 * @return 格式化后的美化JSON字符串
	 */
	String formatPretty(Object object);

	/**
	 * 将JSON字符串解析为指定元素类型的List集合
	 *
	 * @param json 待解析的JSON字符串
	 * @param elementType List中元素的类型
	 * @param <T> 泛型参数，表示List中元素的类型
	 * @return 解析后的List集合
	 */
	default <T> List<T> parseList(String json, Class<T> elementType) {
		return parse(json, JsonTypeUtils.listType(elementType));
	}

	/**
	 * 将JSON字符串解析为指定键值类型的Map集合
	 *
	 * @param json 待解析的JSON字符串
	 * @param keyType Map中键的类型
	 * @param valueType Map中值的类型
	 * @param <K> 泛型参数，表示Map中键的类型
	 * @param <V> 泛型参数，表示Map中值的类型
	 * @return 解析后的Map集合
	 */
	default <K, V> Map<K, V> parseMap(
		String json,
		Class<K> keyType,
		Class<V> valueType
	) {
		JsonTypeReference<Map<K, V>> mapType = new JsonTypeReference<
			Map<K, V>
		>() {};
		return parse(json, mapType);
	}

	/**
	 * 验证字符串是否为有效的JSON格式
	 *
	 * @param json 待验证的字符串
	 * @return 如果是有效的JSON格式返回true，否则返回false
	 */
	boolean isValidJson(String json);

	/**
	 * 将对象转换为JSON字节数组
	 *
	 * @param object 待转换的对象
	 * @return 转换后的JSON字节数组
	 */
	default byte[] toBytes(Object object) {
		return format(object).getBytes();
	}

	/**
	 * 将对象转换为美化格式的JSON字节数组
	 *
	 * @param object 待转换的对象
	 * @return 转换后的美化格式JSON字节数组
	 */
	default byte[] toBytesPretty(Object object) {
		return formatPretty(object).getBytes();
	}

	/**
	 * 合并多个JSON字符串为一个JSON对象
	 *
	 * @param jsons 待合并的JSON字符串数组
	 * @return 合并后的JSON字符串
	 */
	String merge(String... jsons);

	/**
	 * 获取JSON字符串中指定路径节点的值
	 *
	 * @param json JSON字符串
	 * @param path 节点路径（如："user.name"）
	 * @return 节点值的字符串表示
	 */
	String getNodeValue(String json, String path);

	/**
	 * 更新JSON字符串中指定路径节点的值
	 *
	 * @param json 原始JSON字符串
	 * @param path 节点路径（如："user.name"）
	 * @param newValue 新的节点值
	 * @return 更新后的JSON字符串
	 */
	String updateNodeValue(String json, String path, Object newValue);

	<T, D> D convert(T source, Class<D> destinationClass);
	<T, D> D convert(T source, JsonTypeReference<D> destinationType);
}
