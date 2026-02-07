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
 * CurrentFile UUIDJsonFormat.kt
 * LastUpdate 2026-02-07 08:05:58
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.annotation

import com.mingliqiye.utils.base.BaseType
import com.mingliqiye.utils.uuid.UUIDFormatType

/**
 * UUID JSON格式化注解，用于指定UUID字段在JSON序列化/反序列化时的格式
 *
 * @property value UUID格式类型，默认为 NO_UPPER_SPACE
 * @property base 基数类型，默认为 BASE16
 */
@Target(AnnotationTarget.FIELD)
annotation class UUIDJsonFormat(
    val value: UUIDFormatType = UUIDFormatType.NO_UPPER_SPACE,
    val base: BaseType = BaseType.BASE16
)
