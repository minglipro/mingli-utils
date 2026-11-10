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
 * CurrentFile NetworkEndpointJsonConverter.kt
 * LastUpdate 2026-11-09 14:36:36
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters

import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.NetworkEndpointJsonConverter.Companion.getJsonConverter
import com.mingliqiye.utils.json.converters.base.AnnotationGetter
import com.mingliqiye.utils.json.converters.base.BaseJsonStringConverter
import com.mingliqiye.utils.network.NetworkEndpoint

/**
 * [NetworkEndpoint] 的 JSON 字符串转换器。
 *
 * 继承 [BaseJsonStringConverter]，负责在网络端点对象与 JSON 字符串之间进行转换：
 * 序列化时输出形如 `host:port` 的字符串，反序列化时将 `host:port` 字符串还原为
 * [NetworkEndpoint] 实例。
 *
 * 本类为单例：构造器私有，通过 [getJsonConverter] 获取全局共享实例，
 * 避免在序列化框架中重复创建。
 *
 * @see BaseJsonStringConverter
 * @see NetworkEndpoint
 */
class NetworkEndpointJsonConverter private constructor() : BaseJsonStringConverter<NetworkEndpoint> {

	companion object {
		private val networkEndpointJsonConverter by lazy {
			NetworkEndpointJsonConverter()
		}

		/**
		 * 获取 [NetworkEndpointJsonConverter] 的全局单例。
		 *
		 * @return 共享的转换器实例。
		 */
		@JvmStatic
		fun getJsonConverter(): NetworkEndpointJsonConverter = networkEndpointJsonConverter
	}

	/**
	 * 将 [NetworkEndpoint] 序列化为 JSON 字符串。
	 *
	 * 输出格式为 `host:port`，由 [NetworkEndpoint.toHostPortString] 生成。
	 *
	 * @param obj 待序列化的网络端点，可能为 `null`。
	 * @param annotationGetter 注解信息提供者，用于在需要时读取格式化相关注解；
	 *   当前实现不依赖注解，保留该参数以符合转换器契约。
	 * @return 序列化后的 `host:port` 字符串；当 [obj] 为 `null` 时返回 `null`。
	 * @throws Exception 若序列化过程中发生异常。
	 */
	@Throws(Exception::class)
	override fun convert(obj: NetworkEndpoint?, annotationGetter: AnnotationGetter): String? {
		return obj?.let(NetworkEndpoint::toHostPortString)
	}

	/**
	 * 将 JSON 字符串反序列化为 [NetworkEndpoint]。
	 *
	 * 期望输入为 `host:port` 形式的字符串，由 [NetworkEndpoint.Companion.of] 解析。
	 *
	 * @param obj 待反序列化的字符串，可能为 `null`。
	 * @param annotationGetter 注解信息提供者，用于在需要时读取解析相关注解；
	 *   当前实现不依赖注解，保留该参数以符合转换器契约。
	 * @return 解析得到的 [NetworkEndpoint]；当 [obj] 为 `null` 时返回 `null`。
	 * @throws Exception 若字符串格式非法或解析过程中发生异常。
	 */
	@Throws(Exception::class)
	override fun deConvert(obj: String?, annotationGetter: AnnotationGetter): NetworkEndpoint? {
		return obj?.let(NetworkEndpoint.Companion::of)
	}

	/**
	 * 获取本转换器支持的目标类型引用。
	 *
	 * @return 指向 [NetworkEndpoint] 的 [JsonTypeReference]。
	 * @throws Exception 若获取类型引用时发生异常。
	 */
	@Throws(Exception::class)
	override fun getFromType(): JsonTypeReference<NetworkEndpoint> = JsonTypeReference.Companion.of()
}
