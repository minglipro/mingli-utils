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
 * LastUpdate 2026-02-27 11:04:05
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.time

import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

/**
 * 表示一个时间偏移量的类，用于封装时间单位和偏移值。
 *
 * @property offsetType 时间单位类型，使用 [ChronoUnit] 表示。
 * @property offset 偏移量的数值。
 */
class DateTimeOffset private constructor(
    val offsetType: ChronoUnit,
    val offset: Long
) {

    companion object {
        /**
         * 将 [ChronoUnit] 扩展为创建 [DateTimeOffset] 实例的函数。
         *
         * @param offset 偏移量的长整型数值。
         * @return 返回一个新的 [DateTimeOffset] 实例。
         */
        @JvmStatic
        @JvmName("of")
        fun ChronoUnit.toDateTimeOffset(offset: Long) = DateTimeOffset(this, offset)

        /**
         * 将 [ChronoUnit] 扩展为创建 [DateTimeOffset] 实例的函数。
         *
         * @param offset 偏移量的整型数值。
         * @return 返回一个新的 [DateTimeOffset] 实例。
         */
        @JvmStatic
        @JvmName("of")
        fun ChronoUnit.toDateTimeOffset(offset: Int) = DateTimeOffset(this, offset.toLong())

        /**
         * 将 [TimeUnit] 扩展为创建 [DateTimeOffset] 实例的函数。
         *
         * @param offset 偏移量的长整型数值。
         * @return 返回一个新的 [DateTimeOffset] 实例。
         */
        @JvmStatic
        @JvmName("of")
        fun TimeUnit.toDateTimeOffset(offset: Long) = DateTimeOffset(this.toChronoUnit(), offset)

        /**
         * 将 [TimeUnit] 扩展为创建 [DateTimeOffset] 实例的函数。
         *
         * @param offset 偏移量的整型数值。
         * @return 返回一个新的 [DateTimeOffset] 实例。
         */
        @JvmStatic
        @JvmName("of")
        fun TimeUnit.toDateTimeOffset(offset: Int) = DateTimeOffset(this.toChronoUnit(), offset.toLong())

        /**
         * 创建 [DateTimeOffset] 实例的静态工厂方法。
         *
         * @param offset 偏移量的长整型数值。
         * @param offsetType 时间单位类型，使用 [ChronoUnit] 表示。
         * @return 返回一个新的 [DateTimeOffset] 实例。
         */
        @JvmStatic
        fun of(offset: Long, offsetType: ChronoUnit) = offsetType.toDateTimeOffset(offset)

        /**
         * 创建 [DateTimeOffset] 实例的静态工厂方法。
         *
         * @param offset 偏移量的整型数值。
         * @param offsetType 时间单位类型，使用 [ChronoUnit] 表示。
         * @return 返回一个新的 [DateTimeOffset] 实例。
         */
        @JvmStatic
        fun of(offset: Int, offsetType: ChronoUnit) = offsetType.toDateTimeOffset(offset)

        /**
         * 创建 [DateTimeOffset] 实例的静态工厂方法。
         *
         * @param offset 偏移量的长整型数值。
         * @param offsetType 时间单位类型，使用 [TimeUnit] 表示。
         * @return 返回一个新的 [DateTimeOffset] 实例。
         */
        @JvmStatic
        fun of(offset: Long, offsetType: TimeUnit) = offsetType.toDateTimeOffset(offset)

        /**
         * 创建 [DateTimeOffset] 实例的静态工厂方法。
         *
         * @param offset 偏移量的整型数值。
         * @param offsetType 时间单位类型，使用 [TimeUnit] 表示。
         * @return 返回一个新的 [DateTimeOffset] 实例。
         */
        @JvmStatic
        fun of(offset: Int, offsetType: TimeUnit) = offsetType.toDateTimeOffset(offset)

        @Suppress("EXTENSION_SHADOWED_BY_MEMBER")
        @JvmStatic
        @JvmName("TimeUnitToChronoUnit")
        fun TimeUnit.toChronoUnit(): ChronoUnit {
            return when (this) {
                TimeUnit.NANOSECONDS -> ChronoUnit.NANOS
                TimeUnit.MICROSECONDS -> ChronoUnit.MICROS
                TimeUnit.MILLISECONDS -> ChronoUnit.MILLIS
                TimeUnit.SECONDS -> ChronoUnit.SECONDS
                TimeUnit.MINUTES -> ChronoUnit.MINUTES
                TimeUnit.HOURS -> ChronoUnit.HOURS
                TimeUnit.DAYS -> ChronoUnit.DAYS
            }
        }
    }
}
