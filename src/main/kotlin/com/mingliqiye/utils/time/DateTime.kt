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
 * CurrentFile DateTime.kt
 * LastUpdate 2025-09-15 22:32:50
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.time

import com.mingliqiye.utils.jna.FILETIME_EPOCH_OFFSET
import com.mingliqiye.utils.jna.NANOS_PER_100NS
import com.mingliqiye.utils.jna.WinKernel32Api
import com.mingliqiye.utils.jna.getWinKernel32Apis
import com.mingliqiye.utils.logger.mingLiLoggerFactory
import com.mingliqiye.utils.system.isWindows
import com.mingliqiye.utils.system.javaVersionAsInteger
import org.slf4j.Logger
import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.Instant


/**
 * 时间位移 类
 *
 * @author MingLiPro
 */
class DateTimeOffset private constructor(
    val offsetType: ChronoUnit,
    val offset: Long
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


/**
 * 时间格式化枚举类
 *
 *
 * 定义了常用的时间格式化模式，用于日期时间的解析和格式化操作
 * 每个枚举常量包含对应的格式化字符串和字符串长度
 *
 */
enum class Formatter(private val value: String) {
    /**
     * 标准日期时间格式：yyyy-MM-dd HH:mm:ss
     */
    STANDARD_DATETIME("yyyy-MM-dd HH:mm:ss"),

    /**
     * 标准日期时间格式(7位毫秒)：yyyy-MM-dd HH:mm:ss.SSSSSSS
     */
    STANDARD_DATETIME_MILLISECOUND7("yyyy-MM-dd HH:mm:ss.SSSSSSS"),

    /**
     * 标准日期时间格式(6位毫秒)：yyyy-MM-dd HH:mm:ss.SSSSSS
     */
    STANDARD_DATETIME_MILLISECOUND6("yyyy-MM-dd HH:mm:ss.SSSSSS"),

    /**
     * 标准日期时间格式(5位毫秒)：yyyy-MM-dd HH:mm:ss.SSSSS
     */
    STANDARD_DATETIME_MILLISECOUND5("yyyy-MM-dd HH:mm:ss.SSSSS"),

    /**
     * 标准日期时间格式(4位毫秒)：yyyy-MM-dd HH:mm:ss.SSSS
     */
    STANDARD_DATETIME_MILLISECOUND4("yyyy-MM-dd HH:mm:ss.SSSS"),

    /**
     * 标准日期时间格式(3位毫秒)：yyyy-MM-dd HH:mm:ss.SSS
     */
    STANDARD_DATETIME_MILLISECOUND3("yyyy-MM-dd HH:mm:ss.SSS"),

    /**
     * 标准日期时间格式(2位毫秒)：yyyy-MM-dd HH:mm:ss.SS
     */
    STANDARD_DATETIME_MILLISECOUND2("yyyy-MM-dd HH:mm:ss.SS"),

    /**
     * 标准日期时间格式(1位毫秒)：yyyy-MM-dd HH:mm:ss.S
     */
    STANDARD_DATETIME_MILLISECOUND1("yyyy-MM-dd HH:mm:ss.S"),

    /**
     * 标准ISO格式：yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
     */
    STANDARD_ISO("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),

    /**
     * 标准日期时间秒格式：yyyy-MM-dd HH:mm:ss
     */
    STANDARD_DATETIME_SECOUND("yyyy-MM-dd HH:mm:ss"),

    /**
     * 标准日期格式：yyyy-MM-dd
     */
    STANDARD_DATE("yyyy-MM-dd"),

    /**
     * ISO8601格式：yyyy-MM-dd'T'HH:mm:ss.SSS'000'
     */
    ISO8601("yyyy-MM-dd'T'HH:mm:ss.SSS'000'"),

    /**
     * 紧凑型日期时间格式：yyyyMMddHHmmss
     */
    COMPACT_DATETIME("yyyyMMddHHmmss");

    private val len: Int = value.length

    fun getLen(): Int {
        return this.len
    }

    fun getValue(): String {
        return this.value
    }
}

/**
 * 时间类，用于处理日期时间的转换、格式化等操作。
 * 提供了多种静态方法来创建 DateTime 实例，并支持与 Date、LocalDateTime 等类型的互转。
 *<br>
 * windows java 1.8 及以下 使用windows Api 获取高精度时间
 *
 * @author MingLiPro
 * @see java.time
 * @see LocalDateTime
 * @see ChronoUnit
 * @see Date
 * @see DateTimeFormatter
 * @see ZoneId
 * @see Instant
 */
class DateTime private constructor(
    private var localDateTime: LocalDateTime,
    private val zoneId: ZoneId = ZoneId.systemDefault()
) : Serializable {

    companion object {
        private val WIN_KERNEL_32_API: WinKernel32Api? = if (
            javaVersionAsInteger == 8 &&
            isWindows
        ) {
            val log: Logger = mingLiLoggerFactory.getLogger("mingli-utils DateTime")
            val a = getWinKernel32Apis()

            if (a.size > 1) {
                log.warn("Multiple Size:{} WinKernel32Api implementations found.", a.size)
                a.forEach { api ->
                    log.warn("Found WinKernel32Api: {}", api.javaClass.name)
                }
            }

            if (a.isEmpty()) {
                log.warn("No WinKernel32Api implementation found. Use Jdk1.8 LocalDateTime")
                null
            } else {
                log.info("Found and Use WinKernel32Api: {}", a[a.size - 1].javaClass.name)
                a[a.size - 1]
            }
        } else {
            null
        }

        /**
         * 获取当前时间的 DateTime 实例。
         * 如果运行在 Java 1.8 环境下，则通过 WinKernel32 获取高精度时间。
         *
         * @return 返回当前时间的 DateTime 实例
         */
        @JvmStatic
        fun now(): DateTime {
            if (WIN_KERNEL_32_API != null) {
                return DateTime(
                    WIN_KERNEL_32_API.getTime()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime()
                )
            }
            return DateTime(LocalDateTime.now())
        }

        /**
         * 将 Date 对象转换为 DateTime 实例。
         *
         * @param zoneId 时区信息
         * @param date   Date 对象
         * @return 返回对应的 DateTime 实例
         */
        @JvmStatic
        fun of(date: Date, zoneId: ZoneId): DateTime {
            return DateTime(date.toInstant().atZone(zoneId).toLocalDateTime(), zoneId)
        }

        /**
         * 将 Date 对象转换为 DateTime 实例，使用系统默认时区。
         *
         * @param date Date 对象
         * @return 返回对应的 DateTime 实例
         */
        @JvmStatic
        fun of(date: Date): DateTime {
            return DateTime(
                date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
            )
        }

        /**
         * 根据 LocalDateTime 创建 DateTime 实例。
         *
         * @param localDateTime LocalDateTime 对象
         * @return 返回对应的 DateTime 实例
         */
        @JvmStatic
        fun of(localDateTime: LocalDateTime): DateTime {
            return DateTime(localDateTime)
        }

        /**
         * 解析时间字符串并生成 DateTime 实例。
         *
         * @param timestr   时间字符串
         * @param formatter 格式化模板
         * @param fillZero  是否补零到模板长度
         * @return 返回解析后的 DateTime 实例
         */
        @JvmStatic
        fun parse(
            timestr: String,
            formatter: String,
            fillZero: Boolean
        ): DateTime {
            return DateTime(
                LocalDateTime.parse(
                    if (fillZero) getFillZeroByLen(timestr, formatter) else timestr,
                    DateTimeFormatter.ofPattern(formatter)
                )
            )
        }

        /**
         * 使用 Formatter 枚举解析时间字符串并生成 DateTime 实例。
         *
         * @param timestr   时间字符串
         * @param formatter 格式化模板枚举
         * @param fillZero  是否补零到模板长度
         * @return 返回解析后的 DateTime 实例
         */
        @JvmStatic
        fun parse(
            timestr: String,
            formatter: Formatter,
            fillZero: Boolean
        ): DateTime {
            return parse(timestr, formatter.getValue(), fillZero)
        }

        /**
         * 使用 Formatter 枚举解析时间字符串并生成 DateTime 实例，默认不补零。
         *
         * @param timestr   时间字符串
         * @param formatter 格式化模板枚举
         * @return 返回解析后的 DateTime 实例
         */
        @JvmStatic
        fun parse(timestr: String, formatter: Formatter): DateTime {
            return parse(timestr, formatter.getValue())
        }

        /**
         * 解析时间字符串并生成 DateTime 实例，默认不补零。
         *
         * @param timestr   时间字符串
         * @param formatter 格式化模板
         * @return 返回解析后的 DateTime 实例
         */
        @JvmStatic
        fun parse(timestr: String, formatter: String): DateTime {
            return parse(timestr, formatter, false)
        }

        /**
         * 补零处理时间字符串以匹配格式化模板长度。
         *
         * @param dstr    原始时间字符串
         * @param formats 格式化模板
         * @return 补零后的时间字符串
         */
        private fun getFillZeroByLen(dstr: String, formats: String): String {
            if (dstr.length == formats.length) {
                return dstr
            }
            if (formats.length > dstr.length) {
                var modifiedDstr = dstr
                if (dstr.length == 19) {
                    modifiedDstr += "."
                }
                val sb = StringBuilder(modifiedDstr)
                for (i in 0 until formats.length - dstr.length) {
                    sb.append("0")
                }
                return sb.toString()
            }
            throw IllegalArgumentException(
                String.format(
                    "Text: '%s' len %s < %s %s",
                    dstr,
                    dstr.length,
                    formats,
                    formats.length
                )
            )
        }

        /**
         * 根据年、月、日创建 DateTime 实例
         *
         * @param year  年份
         * @param month 月份 (1-12)
         * @param day   日期 (1-31)
         * @return 返回指定日期的 DateTime 实例（时间部分为 00:00:00）
         */
        @JvmStatic
        fun of(year: Int, month: Int, day: Int): DateTime {
            return DateTime(LocalDateTime.of(year, month, day, 0, 0))
        }

        /**
         * 根据年、月、日、时、分创建 DateTime 实例
         *
         * @param year   年份
         * @param month  月份 (1-12)
         * @param day    日期 (1-31)
         * @param hour   小时 (0-23)
         * @param minute 分钟 (0-59)
         * @return 返回指定日期时间的 DateTime 实例（秒部分为 00）
         */
        @JvmStatic
        fun of(
            year: Int,
            month: Int,
            day: Int,
            hour: Int,
            minute: Int
        ): DateTime {
            return DateTime(LocalDateTime.of(year, month, day, hour, minute))
        }

        /**
         * 将 FILETIME 转换为 LocalDateTime。
         *
         * @param fileTime FILETIME 时间戳（100纳秒单位自1601年1月1日起）
         * @return 转换后的 LocalDateTime 实例
         */
        @OptIn(ExperimentalTime::class)
        @JvmStatic
        fun fileTimeToLocalDateTime(fileTime: Long): LocalDateTime {
            // 1. 将 FILETIME (100ns间隔 since 1601) 转换为 Unix 时间戳 (纳秒 since 1970)
            val unixNanos = (fileTime + FILETIME_EPOCH_OFFSET) * NANOS_PER_100NS

            // 2. 从纳秒时间戳创建 Instant
            val instant = java.time.Instant.ofEpochSecond(
                unixNanos / 1_000_000_000L,
                unixNanos % 1_000_000_000L
            )

            // 3. 转换为系统默认时区的 LocalDateTime
            return instant.atZone(ZoneId.systemDefault()).toLocalDateTime()
        }

        /**
         * 根据年、月、日、时、分、秒创建 DateTime 实例
         *
         * @param year   年份
         * @param month  月份 (1-12)
         * @param day    日期 (1-31)
         * @param hour   小时 (0-23)
         * @param minute 分钟 (0-59)
         * @param second 秒 (0-59)
         * @return 返回指定日期时间的 DateTime 实例
         */
        @JvmStatic
        fun of(
            year: Int,
            month: Int,
            day: Int,
            hour: Int,
            minute: Int,
            second: Int
        ): DateTime {
            return DateTime(
                LocalDateTime.of(year, month, day, hour, minute, second)
            )
        }

        /**
         * 根据年、月、日、时、分、秒、纳秒创建 DateTime 实例
         *
         * @param year   年份
         * @param month  月份 (1-12)
         * @param day    日期 (1-31)
         * @param hour   小时 (0-23)
         * @param minute 分钟 (0-59)
         * @param second 秒 (0-59)
         * @param nano   纳秒 (0-999,999,999)
         * @return 返回指定日期时间的 DateTime 实例
         */
        @JvmStatic
        fun of(
            year: Int,
            month: Int,
            day: Int,
            hour: Int,
            minute: Int,
            second: Int,
            nano: Int
        ): DateTime {
            return DateTime(
                LocalDateTime.of(year, month, day, hour, minute, second, nano)
            )
        }

        /**
         * 根据毫秒时间戳创建 DateTime 实例
         *
         * @param epochMilli 毫秒时间戳
         * @return 返回对应时间的 DateTime 实例
         */
        @JvmStatic
        fun of(epochMilli: Long): DateTime {
            return DateTime(
                java.time.Instant.ofEpochMilli(epochMilli)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime()
            )
        }

        /**
         * 根据毫秒时间戳和时区创建 DateTime 实例
         *
         * @param epochMilli 毫秒时间戳
         * @param zoneId     时区信息
         * @return 返回对应时间的 DateTime 实例
         */
        @JvmStatic
        fun of(epochMilli: Long, zoneId: ZoneId): DateTime {
            return DateTime(
                java.time.Instant.ofEpochMilli(epochMilli).atZone(zoneId).toLocalDateTime(),
                zoneId
            )
        }
    }

    /**
     * 将当前 DateTime 转换为 Date 对象。
     *
     * @return 返回对应的 Date 对象
     */
    fun toDate(): Date {
        return Date.from(localDateTime.atZone(zoneId).toInstant())
    }

    /**
     * 获取当前 DateTime 中的 LocalDateTime 实例。
     *
     * @return 返回 LocalDateTime 对象
     */
    fun toLocalDateTime(): LocalDateTime {
        return localDateTime
    }

    /**
     * 在当前时间基础上增加指定的时间偏移量。
     *
     * @param dateTimeOffset 时间偏移对象
     * @return 返回修改后的 DateTime 实例
     */
    fun add(dateTimeOffset: DateTimeOffset): DateTime {
        return DateTime(
            this.localDateTime.plus(
                dateTimeOffset.offset,
                dateTimeOffset.offsetType
            )
        )
    }

    /**
     * 在当前时间基础上减少指定的时间偏移量。
     *
     * @param dateTimeOffset 时间偏移对象
     * @return 返回修改后的 DateTime 实例
     */
    fun sub(dateTimeOffset: DateTimeOffset): DateTime {
        return DateTime(
            this.localDateTime.plus(
                -dateTimeOffset.offset,
                dateTimeOffset.offsetType
            )
        )
    }

    /**
     * 使用指定格式化模板将当前时间格式化为字符串。
     *
     * @param formatter 格式化模板
     * @return 返回格式化后的时间字符串
     */
    fun format(formatter: String): String {
        return format(formatter, false)
    }

    /**
     * 使用 Formatter 枚举将当前时间格式化为字符串。
     *
     * @param formatter 格式化模板枚举
     * @return 返回格式化后的时间字符串
     */
    fun format(formatter: Formatter): String {
        return format(formatter.getValue())
    }

    /**
     * 使用指定格式化模板将当前时间格式化为字符串，并可选择是否去除末尾多余的零。
     *
     * @param formatter 格式化模板
     * @param repcZero  是否去除末尾多余的零
     * @return 返回格式化后的时间字符串
     */
    fun format(formatter: String, repcZero: Boolean): String {
        var formatted = DateTimeFormatter.ofPattern(formatter).format(
            toLocalDateTime()
        )
        if (repcZero) {
            // 处理小数点后多余的0
            formatted = formatted.replace(Regex("(\\.\\d*?)0+\\b"), "$1")
            formatted = formatted.replace(Regex("\\.$"), "")
        }
        return formatted
    }

    /**
     * 使用 Formatter 枚举将当前时间格式化为字符串，并可选择是否去除末尾多余的零。
     *
     * @param formatter 格式化模板枚举
     * @param repcZero  是否去除末尾多余的零
     * @return 返回格式化后的时间字符串
     */
    fun format(formatter: Formatter, repcZero: Boolean): String {
        return format(formatter.getValue(), repcZero)
    }

    /**
     * 返回当前时间的标准字符串表示形式。
     *
     * @return 返回标准格式的时间字符串
     */
    override fun toString(): String {
        return String.format(
            "DateTime(%s)",
            format(Formatter.STANDARD_DATETIME_MILLISECOUND7, true)
        )
    }

    /**
     * 比较当前DateTime对象与指定对象是否相等
     *
     * @param other 要比较的对象
     * @return 如果对象相等则返回true，否则返回false
     */
    override fun equals(other: Any?): Boolean {
        // 检查对象类型是否为DateTime
        if (other is DateTime) {
            // 比较两个DateTime对象转换为LocalDateTime后的值
            return toLocalDateTime() == other.toLocalDateTime()
        }
        return false
    }

    /**
     * 获取对象的哈希码
     *
     * @return 哈希码
     */
    override fun hashCode(): Int {
        return localDateTime.hashCode()
    }

    /**
     * 将当前 DateTime 转换为 Instant 对象。
     *
     * @return 返回 Instant 对象
     */
    fun toInstant(): java.time.Instant {
        return localDateTime.atZone(zoneId).toInstant()
    }

    /**
     * 判断当前时间是否在指定时间之后。
     *
     * @param dateTime 指定时间
     * @return 如果当前时间在指定时间之后则返回 true，否则返回 false
     */
    fun isAfter(dateTime: DateTime?): Boolean {
        if (dateTime == null) {
            return false
        }
        return toInstant().isAfter(dateTime.toInstant())
    }

    /**
     * 判断当前时间是否在指定时间之前。
     *
     * @param dateTime 指定时间
     * @return 如果当前时间在指定时间之前则返回 true，否则返回 false
     */
    fun isBefore(dateTime: DateTime?): Boolean {
        if (dateTime == null) {
            return false
        }
        return toInstant().isBefore(dateTime.toInstant())
    }

    /**
     * 获取时区ID
     *
     * @return ZoneId对象
     */
    fun getZoneId(): ZoneId {
        return zoneId
    }
}
