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
 * CurrentFile GsonJsonBuilder.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure.builder

import com.mingliqiye.utils.json.converters.base.BaseJsonConverter

/**
 * Gson 的 JSON 构建定制器函数式接口。
 *
 * 实现类注册为 Spring Bean 后，会被 Gson 自动配置按 `@Order` 顺序收集，
 * 用于向 [GsonJsonBuilderImpl] 追加自定义 JSON 转换器。
 */
fun interface GsonJsonBuilder {
	/**
	 * 对给定的 Gson JSON 构建器应用自定义配置。
	 *
	 * @param builder 待定制的构建器
	 * @return 定制后的构建器（通常为同一实例）
	 */
	fun customize(builder: GsonJsonBuilderImpl): GsonJsonBuilderImpl
}

/**
 * Gson JSON 构建器，内部收集需要注册为 Gson [com.google.gson.TypeAdapterFactory]
 * 的 [BaseJsonConverter]。
 */
open class GsonJsonBuilderImpl {

	/**
	 * 已收集的转换器列表。
	 */
	private val data = mutableListOf<BaseJsonConverter<*>>()

	/**
	 * 追加单个 JSON 转换器。
	 *
	 * @param jsonConverter 待追加的转换器
	 * @return 当前构建器，便于链式调用
	 */
	fun addJsonConverter(jsonConverter: BaseJsonConverter<*>): GsonJsonBuilderImpl {
		data.add(jsonConverter)
		return this
	}

	/**
	 * 批量追加 JSON 转换器。
	 *
	 * @param jsonConverters 待追加的转换器数组
	 * @return 当前构建器，便于链式调用
	 */
	fun addJsonConverters(vararg jsonConverters: BaseJsonConverter<*>): GsonJsonBuilderImpl {
		data.addAll(jsonConverters)
		return this
	}

	/**
	 * 获取已收集的全部转换器。
	 *
	 * @return 转换器列表快照，修改返回值不影响内部数据
	 */
	fun getData(): List<BaseJsonConverter<*>> = data.toList()
}
