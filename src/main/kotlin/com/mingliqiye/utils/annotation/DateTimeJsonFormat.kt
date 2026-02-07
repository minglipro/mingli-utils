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
 * CurrentFile DateTimeJsonFormat.kt
 * LastUpdate 2026-02-07 08:05:39
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.annotation

import com.mingliqiye.utils.time.Formatter

/**
 * 日期时间JSON格式化注解，用于标注字段的日期时间格式化方式
 *
 * @property value 格式化器类型，默认为NONE
 * @property formatter 自定义格式化字符串，默认为空字符串
 * @property repcZero 是否替换零值，默认为true
 */
@Target(AnnotationTarget.FIELD)
annotation class DateTimeJsonFormat(
    val value: Formatter = Formatter.NONE,
    val formatter: String = "",
    val repcZero: Boolean = true,
)
