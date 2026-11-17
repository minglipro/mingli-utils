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
 * CurrentFile RequireLayzExceptionConstructor.kt
 * LastUpdate 2026-02-05 09:36:19
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.require

/**
 * 延迟异常构造器函数式接口，用于在校验失败时按需创建异常实例。
 */
@FunctionalInterface
fun interface RequireLayzExceptionConstructor {
	/**
	 * 构造并返回一个异常实例。
	 *
	 * @return 新创建的异常实例
	 */
	fun call(): Throwable
}
