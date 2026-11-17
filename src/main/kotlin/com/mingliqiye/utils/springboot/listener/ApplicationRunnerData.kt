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
 * CurrentFile ApplicationRunnerData.kt
 * LastUpdate 2026-03-10 09:10:50
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.listener

import java.lang.reflect.Method

/**
 * 生命周期回调的执行数据，记录一个待反射执行的方法及其宿主 Bean 与执行顺序。
 *
 * @property beanName Bean 在容器中的名称
 * @property order 执行顺序，值越小越先执行
 * @property bean 方法所属的 Bean 实例
 * @property method 待执行的回调方法
 */
data class ApplicationRunnerData(
	val beanName: String, val order: Int, val bean: Any, val method: Method,
) {
	/**
	 * 反射调用 [method]，以 [bean] 为宿主实例执行回调。
	 */
	fun run() {
		method.invoke(bean)
	}
}
