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
 * CurrentFile ContextClosedEventListener.kt
 * LastUpdate 2026-11-23 15:07:06
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.annotation

import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.EventListener
import org.springframework.core.Ordered
import org.springframework.core.annotation.AliasFor
import org.springframework.core.annotation.Order

/**
 * 应用上下文关闭事件监听注解。
 *
 * 标注在 Spring Bean 的方法上，当 Spring 应用上下文关闭
 * （[ContextClosedEvent] 发布）时自动调用该方法，
 * 等价于 `@EventListener(ContextClosedEvent::class)` 的组合简化写法，
 * 适用于应用停机前的资源清理、状态保存等场景。
 *
 * ```kotlin
 * @Component
 * class CleanupTask {
 *     @ContextClosedEventListener
 *     fun onClosed() {
 *         // 上下文关闭前执行的清理逻辑
 *     }
 * }
 * ```
 *
 * @see EventListener
 * @see ContextClosedEvent
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@EventListener(ContextClosedEvent::class)
@Order
annotation class ContextClosedEventListener(
	/**
	 * SpEL 条件表达式，仅当表达式求值为 true 时才执行监听方法。
	 *
	 * 默认为空字符串，表示无条件执行。
	 */
	@get:AliasFor(annotation = EventListener::class, attribute = "condition")
	val condition: String = "",

	/**
	 * 当事件不是 [ContextClosedEvent] 类型时是否仍默认执行监听方法。
	 *
	 * 默认为 `true`。
	 */
	@get:AliasFor(annotation = EventListener::class, attribute = "defaultExecution")
	val defaultExecution: Boolean = true,

	/**
	 * 监听器的唯一标识，用于注册可指定 id 的监听器。
	 *
	 * 默认为空字符串，表示自动生成。
	 */
	@get:AliasFor(annotation = EventListener::class, attribute = "id")
	val id: String = "",

	/**
	 * 监听器的执行顺序，值越小优先级越高。
	 *
	 * 默认为 [Ordered.LOWEST_PRECEDENCE]。
	 */
	@get:AliasFor(annotation = Order::class, attribute = "value")
	val order: Int = Ordered.LOWEST_PRECEDENCE,
)
