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
 * CurrentFile JacksonJsonApiAutoConfiguration.kt
 * LastUpdate 2026-11-07 13:59:41
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.fasterxml.jackson.databind.ObjectMapper
import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.JacksonJsonApi
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.slf4j.Logger
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

/*
 * JacksonAutoConfiguration 是一个 Spring Boot 自动配置类，用于配置 Jackson 相关的序列化和反序列化功能。
 * 该类在检测到 ObjectMapper 和 Spring Boot 的 JacksonAutoConfiguration 存在时自动生效，
 * 并注册自定义的 JSON 转换器模块（如 UUID 和 DateTime 转换器）。
 *
 * @param objectMapper 用于 JSON 序列化和反序列化的 ObjectMapper 实例。
 */
@ConditionalOnClass(name = ["com.fasterxml.jackson.databind.ObjectMapper", "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration"])
@AutoConfigureAfter(name = ["com.mingliqiye.utils.springboot.autoconfigure.JacksonJsonAutoConfiguration"])
open class JacksonJsonApiAutoConfiguration {


	companion object {
		private val log: Logger = MingLiLoggerFactory.getLogger("MingliUtils-JacksonAutoConfiguration")
	}


	/*
	 * 创建并返回一个 JsonApi Bean 实例。
	 * 该方法会在没有其他 JsonApi Bean 存在时被调用，并将创建的 JacksonJsonApi 实例设置为全局默认的 JSON API。
	 *
	 * @param objectMapper 用于 JSON 操作的 ObjectMapper 实例。
	 * @return 返回配置好的 JsonApi 实例。
	 */
	@Bean
	@Primary
	@ConditionalOnMissingBean(JsonApi::class)
	open fun jsonApi(objectMapper: ObjectMapper): JsonApi {
		return JacksonJsonApi(objectMapper).also {
			log.info("JsonApi Bean Auto Configuration Success")
			try {
				JSONA.jsonApi
			} catch (_: NullPointerException) {
				JSONA.setJsonApi(it)
				log.info(
					"JSONA Using {}", it.javaClass.name
				)
			}
		}
	}
}
