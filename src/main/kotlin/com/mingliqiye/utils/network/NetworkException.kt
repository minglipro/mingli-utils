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
 * CurrentFile NetworkException.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

/**
 * 网络相关异常，用于表示 IP 地址、端口、域名解析或字节转换错误。
 *
 * 继承 [RuntimeException]，不强制调用方捕获。
 */
class NetworkException @JvmOverloads constructor(
	message: String? = null,
	cause: Throwable? = null,
) : RuntimeException(message, cause) {

	/**
	 * 使用原因异常创建网络异常。
	 *
	 * @param e 原因异常
	 */
	constructor(e: Exception?) : this(e?.message, e)
}
