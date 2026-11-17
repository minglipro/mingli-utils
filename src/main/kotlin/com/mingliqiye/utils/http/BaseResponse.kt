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
 * CurrentFile BaseResponse.kt
 * LastUpdate 2026-10-26 23:22:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http

/**
 * HTTP 响应基类，封装时间、消息、数据和状态码等通用响应字段。
 *
 * 除 [time] 外字段均可变，本身非线程安全；
 * 如需不可变更新语义，请使用子类的 with* 系列方法。
 *
 * @param T 响应数据的类型
 */
open class BaseResponse<T>(
	/** 响应时间（格式化的字符串），创建后不可修改 */
	open val time: String,
	/** 响应消息，可通过 setter 修改 */
	open var message: String,
	/** 响应数据，可通过 setter 修改 */
	open var data: T,
	/** HTTP 状态码，可通过 setter 修改 */
	open var statusCode: Int,

	) {
	/**
	 * 返回响应对象的字符串表示
	 *
	 * 重写toString方法以提供更有意义的对象表示，便于日志记录和调试。
	 * 显示时间、消息、数据类型和值以及状态码。
	 *
	 * @return 格式化的字符串表示
	 */
	override fun toString(): String =
		"${javaClass.simpleName}(time=${time}, message=${message}, data=${data}, statusCode=${statusCode})"
}
