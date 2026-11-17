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
 * CurrentFile JacksonBuilder.kt
 * LastUpdate 2026-11-16 11:36:46
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure.builder

/**
 * Jackson JSON 构建定制器函数式接口。
 * 实现类注册为 Spring Bean 后，会被 Jackson 2 / Jackson 3 的自动配置按 `@Order` 顺序收集并依次应用，
 * 用于向 [JacksonJsonBuilder] 追加自定义 JSON 转换器。
 */
@FunctionalInterface
fun interface JacksonBuilder {
	/**
	 * 对给定的 JSON 构建器应用自定义配置。
	 *
	 * @param builder 待定制的 JSON 构建器
	 * @return 定制后的 JSON 构建器（通常为同一实例）
	 */
	fun customize(builder: JacksonJsonBuilder): JacksonJsonBuilder
}
