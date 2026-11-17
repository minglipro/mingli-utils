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
 * CurrentFile OkhttpBuilder.kt
 * LastUpdate 2026-11-09 13:32:25
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure.builder

import okhttp3.OkHttpClient

/**
 * OkHttp 客户端构建定制器函数式接口。
 * 实现类注册为 Spring Bean 后，会被 [com.mingliqiye.utils.springboot.autoconfigure.Okhttp3AutoConfiguration]
 * 按 `@Order` 顺序收集并依次应用，用于追加拦截器、超时、代理、连接池等配置。
 */
@FunctionalInterface
fun interface OkhttpBuilder {
	/**
	 * 对给定的 OkHttp 客户端构建器应用自定义配置。
	 *
	 * @param builder 待定制的 OkHttp 客户端构建器
	 * @return 定制后的构建器（通常为同一实例）
	 */
	fun customize(builder: OkHttpClient.Builder): OkHttpClient.Builder
}
