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
 * CurrentFile DateTimeOffset.kt
 * LastUpdate 2026-02-04 21:54:04
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.time

import java.time.temporal.ChronoUnit

/**
 * 时间位移 类
 *
 * @author MingLiPro
 */
class DateTimeOffset private constructor(
    val offsetType: ChronoUnit, val offset: Long
) {

    companion object {
        /**
         * 创建一个新的DateTimeOffset实例
         *
         * @param offsetType 偏移量的单位类型，指定偏移量的计算单位
         * @param offset     偏移量的数值，可以为正数、负数或零
         * @return 返回一个新的DateTimeOffset对象，包含指定的偏移量信息
         */
        @JvmStatic
        fun of(offsetType: ChronoUnit, offset: Long): DateTimeOffset {
            return DateTimeOffset(offsetType, offset)
        }

        /**
         * 创建一个 DateTimeOffset 实例
         *
         * @param offset     偏移量数值
         * @param offsetType 偏移量的时间单位类型
         * @return 返回一个新的 DateTimeOffset 实例
         */
        @JvmStatic
        fun of(offset: Long, offsetType: ChronoUnit): DateTimeOffset {
            return DateTimeOffset(offsetType, offset)
        }
    }
}
