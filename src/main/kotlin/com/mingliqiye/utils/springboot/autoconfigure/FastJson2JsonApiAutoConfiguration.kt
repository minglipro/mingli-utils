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
 * CurrentFile FastJson2JsonApiAutoConfiguration.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.alibaba.fastjson2.reader.ObjectReaderProvider
import com.alibaba.fastjson2.writer.ObjectWriterProvider
import com.mingliqiye.utils.json.api.FastJson2JsonApi
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.converters.base.registerToFastJson2
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.springboot.autoconfigure.builder.FastJson2JsonBuilder
import com.mingliqiye.utils.springboot.autoconfigure.builder.FastJson2JsonBuilderImpl
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean

/**
 * 基于 Fastjson2 的 [JsonApi] 自动配置。
 *
 * 在类路径存在 Fastjson2 时生效，收集容器中的 [FastJson2JsonBuilder] 定制器，
 * 把登记的 [com.mingliqiye.utils.json.converters.base.BaseJsonConverter] 注册到独立
 * 的 Fastjson2 writer/reader provider，最后包装为 [FastJson2JsonApi]。
 *
 * ### 优先级
 * 排在 Jackson 2 / Jackson 3 / Gson 的 `JsonApi` 自动配置之后；同时存在多个
 * JSON 实现时，优先 Jackson，其次 Gson，最后才使用 Fastjson2。
 *
 * @see FastJson2JsonApi
 */
@ConditionalOnClass(name = ["com.alibaba.fastjson2.JSON"])
@AutoConfigureAfter(
	name = [
		"com.mingliqiye.utils.springboot.autoconfigure.JacksonJsonApiAutoConfiguration",
		"com.mingliqiye.utils.springboot.autoconfigure.Jackson3JsonApiAutoConfiguration",
		"com.mingliqiye.utils.springboot.autoconfigure.GsonJsonApiAutoConfiguration",
		"com.mingliqiye.utils.springboot.autoconfigure.JsonAutoConfiguration",
	]
)
open class FastJson2JsonApiAutoConfiguration {

	/**
	 * 本配置类的日志记录器。
	 */
	private val log = MingLiLoggerFactory.getLogger<FastJson2JsonApiAutoConfiguration>()

	/**
	 * 创建基于 Fastjson2 的 [JsonApi] Bean（名称 `fastJson2JsonApi`）。
	 *
	 * @param builders Fastjson2 JSON 构建定制器
	 * @return Fastjson2 实现
	 */
	@Bean("fastJson2JsonApi")
	@ConditionalOnMissingBean(JsonApi::class)
	open fun jsonApi(builders: ObjectProvider<FastJson2JsonBuilder>): JsonApi {
		var builder = FastJson2JsonBuilderImpl()
		val builderList = builders.orderedStream().toList()
		log.info("scan ${builderList.size} FastJson2JsonBuilders")
		builderList.forEach {
			builder = it.customize(builder)
		}

		val writerProvider = ObjectWriterProvider()
		val readerProvider = ObjectReaderProvider()
		builder.getData().forEach { converter ->
			converter.registerToFastJson2(writerProvider, readerProvider)
		}
		return FastJson2JsonApi(writerProvider, readerProvider)
	}
}
