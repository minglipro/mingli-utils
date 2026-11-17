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
 * CurrentFile Jackson3AutoConfiguration.kt
 * LastUpdate 2026-11-17 10:16:38
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure;

import com.mingliqiye.utils.json.converters.base.getJackson3Module
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.springboot.autoconfigure.builder.JacksonBuilder
import com.mingliqiye.utils.springboot.autoconfigure.builder.JacksonJsonBuilderImpl
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer
import org.springframework.context.annotation.Bean

/**
 * Jackson 3 的序列化模块自动配置。
 *
 * 在类路径存在 Jackson 3（`tools.jackson.databind.json.JsonMapper`）
 * 及 Spring Boot 的 Jackson 自动配置时生效，并在其之后处理，
 * 向容器注册名为 `jackson3MapperBuilderCustomizer` 的 [JsonMapperBuilderCustomizer] Bean，
 * 将容器中所有 [JacksonBuilder] 定制器收集的 JSON 转换器以 Jackson 3 模块形式安装到 JsonMapper。
 */
@ConditionalOnClass(name = ["tools.jackson.databind.json.JsonMapper", "org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration"])
@AutoConfigureAfter(name = ["org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration"])
open class Jackson3AutoConfiguration {

	private val log = MingLiLoggerFactory.getLogger<Jackson3AutoConfiguration>()

	/**
	 * 创建 Jackson 3 的 JsonMapper 构建定制器 Bean。
	 *
	 * 按 `@Order` 顺序依次应用容器中所有 [JacksonBuilder] 定制器，
	 * 将收集到的 JSON 转换器转换为 Jackson 3 模块并注册到 JsonMapper 构建器。
	 * 仅在容器中不存在同名 Bean 时创建。
	 *
	 * @param builders 容器中的 Jackson 构建定制器，按顺序依次应用
	 * @return 安装自定义模块的 [JsonMapperBuilderCustomizer]
	 */
	@Bean("jackson3MapperBuilderCustomizer")
	@ConditionalOnMissingBean(name = ["jackson3MapperBuilderCustomizer"])
	fun jsonMapperBuilderCustomizer(builders: ObjectProvider<JacksonBuilder>): JsonMapperBuilderCustomizer {
		val builderList = builders.orderedStream().toList()
		var jacksonJsonBuilderImpl = JacksonJsonBuilderImpl()
		log.info("scan ${builderList.size} JacksonBuilders")
		builderList.forEach {
			jacksonJsonBuilderImpl = it.customize(jacksonJsonBuilderImpl) as JacksonJsonBuilderImpl
		}
		return JsonMapperBuilderCustomizer {
			it.addModules(
				*jacksonJsonBuilderImpl.getData().map { converter ->
					converter.getJackson3Module().also { module ->
						log.debug("Jackson3 Module Install {}", module.moduleName)
					}
				}.toTypedArray()
			)
		}

	}

}
