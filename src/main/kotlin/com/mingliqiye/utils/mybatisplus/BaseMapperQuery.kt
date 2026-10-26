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
 * ProjectName FastBaseMapper.kt
 * ModuleName mingli-utils.main
 * CurrentFile BaseMapperQuery.kt
 * LastUpdate 2026-10-26 23:22:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatisplus


@Deprecated(
    "rename to FastBaseMapper",
    replaceWith = ReplaceWith(
        expression = "FastBaseMapper",
        imports = ["com.mingliqiye.utils.mybatisplus.FastBaseMapper"]
    ),
    level = DeprecationLevel.WARNING
)
/**
 * @since 4.6.1
 * 已经重命名 [FastBaseMapper]
 */
typealias BaseMapperQuery<T> = FastBaseMapper<T>
