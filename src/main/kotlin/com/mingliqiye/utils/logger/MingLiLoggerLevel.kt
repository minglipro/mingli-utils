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
 * CurrentFile MingLiLoggerLevel.kt
 * LastUpdate 2026-02-06 08:27:44
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.logger

/**
 * 日志级别枚举，定义 MingLiLogger 支持的五个日志级别。
 */
enum class MingLiLoggerLevel {
	/**
	 * 跟踪级别，最详细的调试信息
	 */
	TRACE,

	/**
	 * 调试级别
	 */
	DEBUG,

	/**
	 * 信息级别
	 */
	INFO,

	/**
	 * 警告级别
	 */
	WARN,

	/**
	 * 错误级别
	 */
	ERROR
}
