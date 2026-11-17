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
 * CurrentFile ApplicationDestroyedRunner.kt
 * LastUpdate 2026-03-10 09:04:02
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.annotation

/**
 * 标记在 Spring 上下文关闭时执行的方法。
 * 被标注的方法会在 ContextClosedEvent 触发时由
 * [com.mingliqiye.utils.springboot.listener.ApplicationListener] 反射调用，
 * 多个方法按 [order] 升序执行。
 *
 * @property order 执行顺序，值越小越先执行，默认为 [Int.MIN_VALUE]
 */
@Target(AnnotationTarget.FUNCTION)
annotation class ApplicationDestroyedRunner(
	val order: Int = Int.MIN_VALUE,
)
