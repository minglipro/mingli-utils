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
 * ProjectName FastBaseMapper.kt
 * ModuleName mingli-utils.main
 * CurrentFile Jackson3JsonApiAutoConfiguration.kt
 * LastUpdate 2026-10-26 23:22:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.exception.JsonException
import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.Jackson3JsonApi
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import tools.jackson.databind.json.JsonMapper

/**
 * 基于 Jackson 3 的 [JsonApi] 自动配置。
 *
 * 在类路径存在 Jackson 3（`tools.jackson.databind.json.JsonMapper`）
 * 及 Spring Boot 的 Jackson 自动配置时生效，将容器中的 [JsonMapper]
 * 包装为 [Jackson3JsonApi] 并以 [JsonApi] 类型注册为 Bean，
 * 同时尝试初始化全局单例 [JSONA]。
 *
 * ## 生效顺序
 *
 * 本类依赖 [Jackson3AutoConfiguration] 注册的 `JsonMapper` 构建定制器，
 * 通过 `@AutoConfigureAfter` 保证在其之后处理，确保 `JsonMapper` 已按
 * 自定义模块完成配置。
 *
 * ## 覆盖方式
 *
 * 若调用方需要自定义 [JsonApi] 实现，只需自行声明一个 [JsonApi] Bean，
 * 本配置的 `@ConditionalOnMissingBean(JsonApi::class)` 将自动跳过创建。
 *
 * ## 全局单例
 *
 * [JSONA] 是进程级全局 JSON 访问入口。本配置在创建 Bean 后尝试读取
 * [JSONA] 当前实例；若尚未设置（读取抛 [NullPointerException]），
 * 则将本次创建的 [JsonApi] 设置为其全局实现。若调用方已在更早阶段
 * 设置过 [JSONA]，则保留既有实现，不覆盖。
 *
 * @see Jackson3AutoConfiguration
 * @see Jackson3JsonApi
 */
@ConditionalOnClass(name = ["tools.jackson.databind.json.JsonMapper", "org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration"])
@AutoConfigureAfter(name = ["com.mingliqiye.utils.springboot.autoconfigure.Jackson3AutoConfiguration"])
open class Jackson3JsonApiAutoConfiguration {

	companion object {
		private val logger = MingLiLoggerFactory.getLogger<Jackson3JsonApiAutoConfiguration>()
	}

	/**
	 * 创建并注册默认的 [JsonApi] Bean。
	 *
	 * 使用容器中的 [JsonMapper] 构造 [Jackson3JsonApi]。读取器直接返回该 [JsonMapper]；
	 * 写入器被设计为抛出 [JsonException]，即本实现不允许通过 [JsonApi] 替换底层
	 * `JsonMapper`，底层实例由 Spring 容器统一管理。
	 *
	 * 创建完成后会尝试初始化全局 [JSONA]：
	 * - 若 [JSONA] 尚未设置，则设置为本实例；
	 * - 若已设置，则保留既有实现。
	 *
	 * 该 Bean 仅在容器中不存在其他 [JsonApi] 时创建。
	 *
	 * @param jsonMapper 容器中的 Jackson 3 映射器
	 * @return 基于 Jackson 3 的 JSON 访问门面
	 */
	@Bean
	@ConditionalOnMissingBean(JsonApi::class)
	open fun jsonApi(jsonMapper: JsonMapper): JsonApi {
		return Jackson3JsonApi(
			get = { jsonMapper },
			set = { throw JsonException("JSON API set method is not allowed.") })
			.also {
				logger.info("JsonApi Bean Auto Configuration Success")
				try {
					JSONA.getJsonApi()
				} catch (_: NullPointerException) {
					JSONA.setJsonApi(it)
					logger.info(
						"JSONA Using {}", it.javaClass.name
					)
				}
			}
	}
}
