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
 * CurrentFile StringToDateTimeConverter.kt
 * LastUpdate 2026-02-04 21:57:43
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.converters

import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.Formatter
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

/**
 * 字符串到 [DateTime] 的 Spring 类型转换器。
 * 注册为组件后参与 Spring 的类型转换体系（如请求参数绑定、@Value 注入等），
 * 按标准日期时间格式（含毫秒，宽松模式）解析。
 */
@Component
class StringToDateTimeConverter : Converter<String, DateTime> {
	/**
	 * 将日期时间字符串解析为 [DateTime]，支持毫秒部分，采用宽松解析模式。
	 *
	 * @param source 待解析的日期时间字符串
	 * @return 解析得到的 DateTime 对象
	 */
	override fun convert(source: String): DateTime {
		return DateTime.parse(source, Formatter.STANDARD_DATETIME_MILLISECOUND7, true)
	}
}
