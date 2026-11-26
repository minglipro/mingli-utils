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
 * CurrentFile GsonJsonApiAutoConfiguration.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.google.gson.GsonBuilder
import com.mingliqiye.utils.json.api.GsonJsonApi
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.converters.base.registerToGson
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.springboot.autoconfigure.builder.GsonJsonBuilder
import com.mingliqiye.utils.springboot.autoconfigure.builder.GsonJsonBuilderImpl
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean

/**
 * 基于 Gson 的 [JsonApi] 自动配置。
 *
 * 在类路径存在 Gson 时生效，收集容器中的 [GsonJsonBuilder] 定制器，将其中登记的
 * [com.mingliqiye.utils.json.converters.base.BaseJsonConverter] 注册为 Gson 类型适配器，
 * 最后包装为 [GsonJsonApi] 并以 [JsonApi] 类型注册为 Bean。
 *
 * ### 优先级
 * 本配置排在 Jackson 2 / Jackson 3 的 `JsonApi` 自动配置之后，并同样带有
 * `@ConditionalOnMissingBean(JsonApi::class)`。因此：
 * - 类路径同时存在 Jackson 与 Gson 时，优先使用 Jackson；
 * - 只有 Gson 时会创建 Gson 实现。
 *
 * @see GsonJsonApi
 * @see GsonJsonBuilder
 */
@ConditionalOnClass(name = ["com.google.gson.Gson"])
@AutoConfigureAfter(
	name = [
		"com.mingliqiye.utils.springboot.autoconfigure.JacksonJsonApiAutoConfiguration",
		"com.mingliqiye.utils.springboot.autoconfigure.Jackson3JsonApiAutoConfiguration",
		"com.mingliqiye.utils.springboot.autoconfigure.JsonAutoConfiguration",
	]
)
open class GsonJsonApiAutoConfiguration {

	/**
	 * 本配置类的日志记录器。
	 */
	private val log = MingLiLoggerFactory.getLogger<GsonJsonApiAutoConfiguration>()

	/**
	 * 创建基于 Gson 的 [JsonApi] Bean（名称 `gsonJsonApi`）。
	 *
	 * 仅在容器中不存在其他 [JsonApi] Bean 时创建。
	 *
	 * @param builders 容器中的 Gson JSON 构建定制器，按顺序依次应用
	 * @return 包装了转换器的 [GsonJsonApi] 实例
	 */
	@Bean("gsonJsonApi")
	@ConditionalOnMissingBean(JsonApi::class)
	open fun jsonApi(builders: ObjectProvider<GsonJsonBuilder>): JsonApi {
		var builder = GsonJsonBuilderImpl()
		val builderList = builders.orderedStream().toList()
		log.info("scan ${builderList.size} GsonJsonBuilders")
		builderList.forEach {
			builder = it.customize(builder)
		}

		val gsonBuilder = GsonBuilder()
		builder.getData().forEach { converter ->
			converter.registerToGson(gsonBuilder)
		}
		return GsonJsonApi(gsonBuilder)
	}
}
