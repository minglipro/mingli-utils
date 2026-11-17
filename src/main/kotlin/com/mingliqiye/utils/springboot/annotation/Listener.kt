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
 * CurrentFile Listener.kt
 * LastUpdate 2026-03-10 09:04:02
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

/**
 * 监听器组件注解，组合了 [Component] 的语义。
 * 被标注的类会被组件扫描注册为 Spring Bean，
 * [value] 通过 [AliasFor] 别名到 [Component.value]，用于指定 Bean 名称。
 *
 * @property value Bean 名称，默认为空字符串（由 Spring 按类名生成）
 */
@Component
annotation class Listener(
	@get:AliasFor(annotation = Component::class)
	val value: String = "",
)
