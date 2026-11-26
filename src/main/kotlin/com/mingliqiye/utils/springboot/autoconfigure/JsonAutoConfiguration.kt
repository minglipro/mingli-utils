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
 * CurrentFile JsonAutoConfiguration.kt
 * LastUpdate 2026-11-17 20:10:26
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.NetworkEndpointJsonConverter
import com.mingliqiye.utils.json.converters.UUIDJsonConverter
import com.mingliqiye.utils.springboot.autoconfigure.builder.FastJson2JsonBuilder
import com.mingliqiye.utils.springboot.autoconfigure.builder.GsonJsonBuilder
import com.mingliqiye.utils.springboot.autoconfigure.builder.JacksonBuilder
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean

/**
 * 本工具库默认 JSON 转换器的自动配置。
 *
 * 向容器注册名为 `mingliUtilsJacksonBuilder` 的 [JacksonBuilder] Bean，
 * 预置 UUID、DateTime、NetworkEndpoint 三种类型的 JSON 转换器，
 * 供 Jackson 2 / Jackson 3 的自动配置收集并安装为序列化模块。
 */
@AutoConfiguration
open class JsonAutoConfiguration {

	/**
	 * 创建预置默认 JSON 转换器的 [JacksonBuilder] Bean。
	 *
	 * @return 追加了 UUID、DateTime、NetworkEndpoint 转换器的构建定制器
	 */
	@Bean("mingliUtilsJacksonBuilder")
	fun jacksonBuilder(): JacksonBuilder = JacksonBuilder {
		it.apply {
			addJsonConverters(
				UUIDJsonConverter(),
				DateTimeJsonConverter(),
				NetworkEndpointJsonConverter(),
			)
		}
	}

	/**
	 * 创建预置默认 JSON 转换器的 [GsonJsonBuilder] Bean。
	 *
	 * 与 [jacksonBuilder] 使用同一组默认转换器；仅当 Gson 自动配置生效时才会被
	 * [GsonJsonApiAutoConfiguration] 收集。
	 *
	 * @return 追加了 UUID、DateTime、NetworkEndpoint 转换器的 Gson 构建定制器
	 */
	@Bean("mingliUtilsGsonBuilder")
	fun gsonJsonBuilder(): GsonJsonBuilder = GsonJsonBuilder {
		it.apply {
			addJsonConverters(
				UUIDJsonConverter(),
				DateTimeJsonConverter(),
				NetworkEndpointJsonConverter(),
			)
		}
	}

	/**
	 * 创建预置默认 JSON 转换器的 [FastJson2JsonBuilder] Bean。
	 *
	 * @return 追加了 UUID、DateTime、NetworkEndpoint 转换器的 Fastjson2 构建定制器
	 */
	@Bean("mingliUtilsFastJson2Builder")
	fun fastJson2JsonBuilder(): FastJson2JsonBuilder = FastJson2JsonBuilder {
		it.apply {
			addJsonConverters(
				UUIDJsonConverter(),
				DateTimeJsonConverter(),
				NetworkEndpointJsonConverter(),
			)
		}
	}

}
