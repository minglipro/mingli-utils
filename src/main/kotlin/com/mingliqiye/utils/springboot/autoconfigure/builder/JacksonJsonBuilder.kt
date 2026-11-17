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
 * CurrentFile JacksonJsonBuilder.kt
 * LastUpdate 2026-11-17 20:09:28
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure.builder

import com.mingliqiye.utils.json.converters.base.BaseJsonConverter

/**
 * Jackson JSON 构建器抽象基类，定义向构建器追加 JSON 转换器的方法。
 * 收集到的转换器最终会被转换为 Jackson 2 / Jackson 3 的序列化模块并安装。
 */
sealed class JacksonJsonBuilder {
	/**
	 * 追加单个 JSON 转换器。
	 *
	 * @param jsonConverter 待追加的 JSON 转换器
	 * @return 当前构建器实例，支持链式调用
	 */
	abstract fun addJsonConverter(jsonConverter: BaseJsonConverter<*>): JacksonJsonBuilder

	/**
	 * 批量追加 JSON 转换器。
	 *
	 * @param jsonConverters 待追加的 JSON 转换器数组
	 * @return 当前构建器实例，支持链式调用
	 */
	abstract fun addJsonConverters(vararg jsonConverters: BaseJsonConverter<*>): JacksonJsonBuilder
}
