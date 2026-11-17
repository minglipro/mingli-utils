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
 * CurrentFile StringToUUIDConverter.kt
 * LastUpdate 2026-02-04 21:58:01
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.converters

import com.mingliqiye.utils.uuid.UUID
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

/**
 * 字符串到 [UUID] 的 Spring 类型转换器。
 * 注册为组件后参与 Spring 的类型转换体系（如请求参数绑定、@Value 注入等）。
 */
@Component
class StringToUUIDConverter : Converter<String, UUID> {
	/**
	 * 将 UUID 字符串解析为 [UUID] 对象。
	 *
	 * @param source 待解析的 UUID 字符串
	 * @return 解析得到的 UUID 对象
	 */
	override fun convert(source: String): UUID {
		return UUID.of(source)
	}
}
