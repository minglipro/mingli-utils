/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile ComponentBean.kt
 * LastUpdate 2025-09-14 18:48:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.bean.annotation

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FIELD

/**
 * 组件bean注解
 * @author MingLiPro
 */
@Retention(RUNTIME)
@Target(CLASS)
annotation class ComponentBean(val value: String = "")

/**
 * 注入bean注解
 * @author MingLiPro
 */
@Retention(RUNTIME)
@Target(FIELD)
annotation class InjectBean(val value: String = "")
