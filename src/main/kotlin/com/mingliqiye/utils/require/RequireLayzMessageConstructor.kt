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
 * CurrentFile RequireLayzMessageConstructor.kt
 * LastUpdate 2026-02-05 09:36:09
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.require

/**
 * 延迟消息构造器函数式接口，用于在校验失败时按需生成错误消息。
 */
@FunctionalInterface
fun interface RequireLayzMessageConstructor {
	/**
	 * 构造并返回错误消息字符串。
	 *
	 * @return 错误消息字符串
	 */
	fun call(): String
}
