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
 * CurrentFile Okhttp3AutoConfiguration.kt
 * LastUpdate 2026-11-18 08:22:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.springboot.annotation.ContextClosedEventListener
import com.mingliqiye.utils.springboot.autoconfigure.builder.OkhttpBuilder
import org.slf4j.Logger
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.event.ContextClosedEvent

/**
 * OkHttp 3 的 Spring Boot 自动配置。
 *
 * 在类路径存在 `okhttp3.OkHttpClient` 时生效，向容器注册一个默认的
 * [okhttp3.OkHttpClient] Bean。构建过程中会依次应用容器中所有
 * [OkhttpBuilder] 定制器（按 `@Order` / [org.springframework.core.Ordered] 排序），
 * 便于调用方追加拦截器、超时、代理、连接池等配置，而无需自行创建客户端。
 *
 * ## 覆盖方式
 *
 * 若调用方需要完全自定义客户端，只需自行声明一个 [okhttp3.OkHttpClient] Bean，
 * 本配置的 `@ConditionalOnMissingBean` 将自动跳过创建，不会产生多余实例。
 *
 * 若只想在默认客户端上做增量调整，实现 [OkhttpBuilder] 并注册为 Bean 即可，
 * 无需替换整个客户端。
 *
 * ## 生命周期
 *
 * 由本配置创建的客户端会在 Spring 上下文关闭时（[ContextClosedEvent]）
 * 主动清理连接池并关闭分发器线程池，避免线程与连接泄漏。
 * 调用方自行声明的客户端不会被本配置清理，其生命周期由调用方负责。
 *
 * @see OkhttpBuilder
 */
@AutoConfiguration
@ConditionalOnClass(name = ["okhttp3.OkHttpClient"])
open class Okhttp3AutoConfiguration {

	/**
	 * 伴生对象，持有本配置类的日志记录器。
	 */
	companion object {
		/**
		 * 本配置类的日志记录器。
		 */
		val log: Logger = MingLiLoggerFactory.getLogger<Okhttp3AutoConfiguration>()
	}

	/**
	 * 由本配置创建并注册的 [okhttp3.OkHttpClient] 实例，供上下文关闭时清理使用。
	 *
	 * 当调用方自行声明了 `OkHttpClient` Bean 时，本配置的 Bean 方法不会执行，
	 * 该字段保持 `null`，关闭时的清理逻辑也会相应跳过。
	 */
	var okhttp: okhttp3.OkHttpClient? = null

	/**
	 * 创建默认的 [okhttp3.OkHttpClient] Bean。
	 *
	 * 依次应用容器中所有 [OkhttpBuilder] 定制器后构建客户端。没有任何定制器时
	 * 也能正常构建（[ObjectProvider] 允许零个元素）。
	 *
	 * 该 Bean 仅在容器中不存在其他 `OkHttpClient` 时创建；若调用方已自行声明，
	 * 本方法不会被调用。
	 *
	 * @param builders 容器中的 OkHttp 构建定制器，按 `@Order` 排序后依次应用
	 * @return 构建完成的 OkHttp 客户端
	 */
	@Bean
	@ConditionalOnMissingBean
	open fun okHttpClient(builders: ObjectProvider<OkhttpBuilder>): okhttp3.OkHttpClient {
		var connt = 0
		return okhttp3.OkHttpClient.Builder().let { builder ->
			var b = builder
			builders.orderedStream().forEach {
				b = it.customize(b)
				connt++
			}
			b.build()
		}.also {
			okhttp = it
			log.info("load {} OkhttpBuilder initialized OkHttpClient successfully", connt)
		}
	}

	/**
	 * 在 Spring 上下文关闭时清理本配置创建的 OkHttp 客户端。
	 *
	 * 执行两步清理：
	 * 1. [okhttp3.ConnectionPool.evictAll] 立即关闭连接池中的空闲连接；
	 * 2. 关闭 [okhttp3.Dispatcher] 的线程池，中断未完成的任务。
	 *
	 * 仅当 [okhttp] 字段非空（即客户端由本配置创建）时执行；
	 * 调用方自行声明的客户端不会被清理。
	 */
	@ContextClosedEventListener
	open fun handleContextClosed() {
		okhttp?.let {
			log.info("Context closed, cleaning up OkHttpClient...")
			it.connectionPool.evictAll()
			it.dispatcher.executorService.shutdownNow()
		}
	}
}
