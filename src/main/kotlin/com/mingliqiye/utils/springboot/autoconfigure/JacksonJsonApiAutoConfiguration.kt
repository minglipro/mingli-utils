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
 * LastUpdate 2026-11-09 13:45:41
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.fasterxml.jackson.databind.ObjectMapper
import com.mingliqiye.utils.json.api.JacksonJsonApi
import com.mingliqiye.utils.json.api.base.JsonApi
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean

/*
 * JacksonAutoConfiguration 是一个 Spring Boot 自动配置类，用于配置 Jackson 相关的序列化和反序列化功能。
 * 该类在检测到 ObjectMapper 和 Spring Boot 的 JacksonAutoConfiguration 存在时自动生效，
 * 并注册自定义的 JSON 转换器模块（如 UUID 和 DateTime 转换器）。
 *
 * @param objectMapper 用于 JSON 序列化和反序列化的 ObjectMapper 实例。
 */
/**
 * 基于 Jackson 2 的 [JsonApi] 自动配置（过渡兼容）。
 *
 * 在类路径存在 Jackson 2（`com.fasterxml.jackson.databind.ObjectMapper`）
 * 及对应 Spring Boot 自动配置时生效，并在 [JacksonJsonAutoConfiguration] 之后处理，
 * 将容器中的 [ObjectMapper] 包装为 [JacksonJsonApi] 并以 [JsonApi] 类型注册为 Bean。
 * 若调用方已自行声明 [JsonApi] Bean，则跳过创建。
 */
@ConditionalOnClass(name = ["com.fasterxml.jackson.databind.ObjectMapper", "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration"])
@AutoConfigureAfter(name = ["com.mingliqiye.utils.springboot.autoconfigure.JacksonJsonAutoConfiguration"])
open class JacksonJsonApiAutoConfiguration {
	/**
	 * 创建基于 Jackson 2 的 [JsonApi] Bean（名称 `jacksonJsonApi`）。
	 *
	 * 仅在容器中不存在其他 [JsonApi] Bean 时创建。
	 *
	 * @param objectMapper 容器中已完成自定义模块配置的 ObjectMapper
	 * @return 包装 [objectMapper] 的 [JacksonJsonApi] 实例
	 */
	@Bean("jacksonJsonApi")
	@ConditionalOnMissingBean(JsonApi::class)
	open fun jsonApi(objectMapper: ObjectMapper): JsonApi {
		return JacksonJsonApi(objectMapper)
	}
}
