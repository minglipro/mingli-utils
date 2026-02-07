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
 * CurrentFile UUIDFormatType.kt
 * LastUpdate 2026-02-06 14:53:47
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.uuid

/**
 * UUID格式类型枚举
 * 定义了四种不同的UUID格式化选项，包括大小写和是否包含空格的组合
 *
 * @property isUpper 是否使用大写字母
 * @property isnotSpace 是否不包含空格（true表示无空格，false表示有空格）
 */
enum class UUIDFormatType(val isUpper: Boolean, val isnotSpace: Boolean) {
    /**
     * 大写带分隔符
     * 使用大写字母并保留空格分隔符
     */
    UPPER_SPACE(true, false),

    /**
     * 小写带分隔符
     * 使用小写字母并保留空格分隔符
     */
    NO_UPPER_SPACE(false, false),

    /**
     * 小写无分隔符
     * 使用小写字母且不包含空格分隔符
     */
    NO_UPPER_NO_SPACE(false, true),

    /**
     * 大写无分隔符
     * 使用大写字母且不包含空格分隔符
     */
    UPPER_NO_SPACE(true, true),
}
