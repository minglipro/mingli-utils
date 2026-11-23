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
 * CurrentFile ApplicationStartedRunner.kt
 * LastUpdate 2026-11-23 15:07:06
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.annotation

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.core.Ordered
import org.springframework.core.annotation.AliasFor
import org.springframework.core.annotation.Order

/**
 * 应用启动完成事件监听注解。
 *
 * 标注在 Spring Bean 的方法上，当 Spring Boot 应用完成启动并就绪
 * （[ApplicationReadyEvent] 发布）时自动调用该方法。
 *
 * 已弃用，请改用 [ApplicationReadyEventListener]（功能完全一致，命名更规范）。
 *
 * @see ApplicationReadyEventListener
 * @see EventListener
 * @see ApplicationReadyEvent
 */
@Deprecated(
	message = "已弃用，请改用 ApplicationReadyEventListener（功能完全一致，命名更规范）",
	replaceWith = ReplaceWith(
		expression = "ApplicationReadyEventListener",
		imports = ["com.mingliqiye.utils.springboot.annotation.ApplicationReadyEventListener"],
	),
)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@EventListener(ApplicationReadyEvent::class)
@Order
annotation class ApplicationStartedRunner(
	/**
	 * SpEL 条件表达式，仅当表达式求值为 true 时才执行监听方法。
	 *
	 * 默认为空字符串，表示无条件执行。
	 */
	@get:AliasFor(annotation = EventListener::class, attribute = "condition")
	val condition: String = "",

	/**
	 * 当事件不是 [ApplicationReadyEvent] 类型时是否仍默认执行监听方法。
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
