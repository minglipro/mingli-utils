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
 * CurrentFile AutoService.kt
 * LastUpdate 2026-02-07 17:00:39
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.annotation

import kotlin.reflect.KClass

/**
 * 标记一个类为其提供自动服务注册功能的注解。
 *
 * 此注解用于标识那些需要被自动注册为服务的类。通过指定[value]参数，
 * 可以声明该类实现的服务接口类型。注解的作用范围限定为类（CLASS），
 * 并且仅在源码级别保留（SOURCE），不会编译到字节码中。
 * @since 4.6.3
 *
 * @param value 需要注册的服务接口类型数组，默认为空数组。
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class AutoService(
    val value: Array<KClass<*>> = []
)
