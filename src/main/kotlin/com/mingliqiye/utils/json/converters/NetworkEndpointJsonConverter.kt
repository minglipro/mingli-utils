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
 * LastUpdate 2026-11-18 00:01:29
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters

import com.mingliqiye.utils.exception.JsonParserException
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.base.AnnotationGetter
import com.mingliqiye.utils.json.converters.base.BaseJsonConverter
import com.mingliqiye.utils.json.reader.base.BaseJsonReader
import com.mingliqiye.utils.json.witer.base.BaseJsonWriter
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
class NetworkEndpointJsonConverter : BaseJsonConverter<NetworkEndpoint> {
	/**
	 * 将网络端点写为 `host:port` 形式的 JSON 字符串，null 时写入 null
	 */
	override fun convert(
		obj: NetworkEndpoint?,
		jsonWriter: BaseJsonWriter,
		annotationGetter: AnnotationGetter,
	) {
		if (obj == null) jsonWriter.setNull() else jsonWriter.setString(obj.toHostPortString())
	}

	/**
	 * 从 `host:port` 形式的 JSON 字符串还原网络端点
	 *
	 * @throws JsonParseException 当节点不是字符串类型时抛出
	 */
	override fun deConvert(
		jsonReader: BaseJsonReader,
		annotationGetter: AnnotationGetter,
	): NetworkEndpoint? {
		return if (jsonReader.isNotNull) {
			if (!jsonReader.isString) throw JsonParserException("type item not string")
			NetworkEndpoint.of(jsonReader.getString())
		} else null
	}

	override fun getType(): JsonTypeReference<NetworkEndpoint> = JsonTypeReference.of()
}
