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
 * CurrentFile DateTime.java
 * LastUpdate 2025-09-14 22:12:16
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.time;

import com.mingliqiye.utils.jna.WinKernel32Api;
import com.mingliqiye.utils.jna.WinKernel32ApiFactory;
import com.mingliqiye.utils.system.SystemUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import lombok.var;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static com.mingliqiye.utils.jna.WinKernel32ApiFactory.FILETIME_EPOCH_OFFSET;
import static com.mingliqiye.utils.jna.WinKernel32ApiFactory.NANOS_PER_100NS;
import static com.mingliqiye.utils.logger.Loggers.getMingLiLoggerFactory;

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
@Setter
public final class DateTime implements Serializable {

	private static final WinKernel32Api WIN_KERNEL_32_API;

	static {
		if (
			SystemUtils.getJavaVersionAsInteger() == 8 &&
			SystemUtils.isWindows()
		) {
			final Logger log = getMingLiLoggerFactory().getLogger(
				"mingli-utils DateTime"
			);
			val a = WinKernel32ApiFactory.getWinKernel32Apis();

			if (a.size() > 1) {
				log.warn(
					"Multiple Size:{} WinKernel32Api implementations found.",
					a.size()
				);
				a.forEach(api ->
					log.warn(
						"Found WinKernel32Api: {}",
						api.getClass().getName()
					)
				);
			}

			if (a.isEmpty()) {
				WIN_KERNEL_32_API = null;
				log.warn(
					"No WinKernel32Api implementation found. Use Jdk1.8 LocalDateTime"
				);
			} else {
				WIN_KERNEL_32_API = a.get(a.size() - 1);
				log.info(
					"Found and Use WinKernel32Api: {}",
					WIN_KERNEL_32_API.getClass().getName()
				);
			}
		} else {
			WIN_KERNEL_32_API = null;
		}
	}

	@Getter
	private ZoneId zoneId = ZoneId.systemDefault();

	@Getter
	private LocalDateTime localDateTime;

	/**
	 * 私有构造函数，使用指定的 LocalDateTime 初始化实例。
	 *
	 * @param time LocalDateTime 对象
	 */
	private DateTime(LocalDateTime time) {
		setLocalDateTime(time);
	}

	/**
	 * 私有构造函数，使用当前系统时间初始化实例。
	 */
	private DateTime() {
		setLocalDateTime(LocalDateTime.now());
	}

	/**
	 * 获取当前时间的 DateTime 实例。
	 * 如果运行在 Java 1.8 环境下，则通过 WinKernel32 获取高精度时间。
	 *
	 * @return 返回当前时间的 DateTime 实例
	 */
	public static DateTime now() {
		if (WIN_KERNEL_32_API != null) {
			return DateTime.of(
				WIN_KERNEL_32_API.getTime()
					.atZone(ZoneId.systemDefault())
					.toLocalDateTime()
			);
		}
		return new DateTime();
	}

	/**
	 * 将 Date 对象转换为 DateTime 实例。
	 *
	 * @param zoneId 时区信息
	 * @param date   Date 对象
	 * @return 返回对应的 DateTime 实例
	 */
	public static DateTime of(Date date, ZoneId zoneId) {
		return new DateTime(date.toInstant().atZone(zoneId).toLocalDateTime());
	}

	/**
	 * 将 Date 对象转换为 DateTime 实例，使用系统默认时区。
	 *
	 * @param date Date 对象
	 * @return 返回对应的 DateTime 实例
	 */
	public static DateTime of(Date date) {
		return new DateTime(
			date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
		);
	}

	/**
	 * 根据 LocalDateTime 创建 DateTime 实例。
	 *
	 * @param localDateTime LocalDateTime 对象
	 * @return 返回对应的 DateTime 实例
	 */
	public static DateTime of(LocalDateTime localDateTime) {
		return new DateTime(localDateTime);
	}

	/**
	 * 解析时间字符串并生成 DateTime 实例。
	 *
	 * @param timestr   时间字符串
	 * @param formatter 格式化模板
	 * @param fillZero  是否补零到模板长度
	 * @return 返回解析后的 DateTime 实例
	 */
	public static DateTime parse(
		String timestr,
		String formatter,
		boolean fillZero
	) {
		return new DateTime(
			LocalDateTime.parse(
				fillZero ? getFillZeroByLen(timestr, formatter) : timestr,
				DateTimeFormatter.ofPattern(formatter)
			)
		);
	}

	/**
	 * 使用 Formatter 枚举解析时间字符串并生成 DateTime 实例。
	 *
	 * @param timestr   时间字符串
	 * @param formatter 格式化模板枚举
	 * @param fillZero  是否补零到模板长度
	 * @return 返回解析后的 DateTime 实例
	 */
	public static DateTime parse(
		String timestr,
		Formatter formatter,
		boolean fillZero
	) {
		return parse(timestr, formatter.getValue(), fillZero);
	}

	/**
	 * 使用 Formatter 枚举解析时间字符串并生成 DateTime 实例，默认不补零。
	 *
	 * @param timestr   时间字符串
	 * @param formatter 格式化模板枚举
	 * @return 返回解析后的 DateTime 实例
	 */
	public static DateTime parse(String timestr, Formatter formatter) {
		return parse(timestr, formatter.getValue());
	}

	/**
	 * 解析时间字符串并生成 DateTime 实例，默认不补零。
	 *
	 * @param timestr   时间字符串
	 * @param formatter 格式化模板
	 * @return 返回解析后的 DateTime 实例
	 */
	public static DateTime parse(String timestr, String formatter) {
		return parse(timestr, formatter, false);
	}

	/**
	 * 补零处理时间字符串以匹配格式化模板长度。
	 *
	 * @param dstr    原始时间字符串
	 * @param formats 格式化模板
	 * @return 补零后的时间字符串
	 */
	private static String getFillZeroByLen(String dstr, String formats) {
		if (dstr.length() == formats.length()) {
			return dstr;
		}
		if (formats.length() > dstr.length()) {
			if (dstr.length() == 19) {
				dstr += ".";
			}
			var sb = new StringBuilder(dstr);
			for (int i = 0; i < formats.length() - dstr.length(); i++) {
				sb.append("0");
			}
			return sb.toString();
		}
		throw new IllegalArgumentException(
			String.format(
				"Text: '%s' len %s < %s %s",
				dstr,
				dstr.length(),
				formats,
				formats.length()
			)
		);
	}

	/**
	 * 根据年、月、日创建 DateTime 实例
	 *
	 * @param year  年份
	 * @param month 月份 (1-12)
	 * @param day   日期 (1-31)
	 * @return 返回指定日期的 DateTime 实例（时间部分为 00:00:00）
	 */
	public static DateTime of(int year, int month, int day) {
		return new DateTime(LocalDateTime.of(year, month, day, 0, 0));
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
	public static DateTime of(
		int year,
		int month,
		int day,
		int hour,
		int minute
	) {
		return new DateTime(LocalDateTime.of(year, month, day, hour, minute));
	}

	/**
	 * 将 FILETIME 转换为 LocalDateTime。
	 *
	 * @param fileTime FILETIME 时间戳（100纳秒单位自1601年1月1日起）
	 * @return 转换后的 LocalDateTime 实例
	 */
	public static LocalDateTime fileTimeToLocalDateTime(long fileTime) {
		// 1. 将 FILETIME (100ns间隔 since 1601) 转换为 Unix 时间戳 (纳秒 since 1970)
		long unixNanos = (fileTime + FILETIME_EPOCH_OFFSET) * NANOS_PER_100NS;

		// 2. 从纳秒时间戳创建 Instant
		Instant instant = Instant.ofEpochSecond(
			unixNanos / 1_000_000_000L,
			unixNanos % 1_000_000_000L
		);

		// 3. 转换为系统默认时区的 LocalDateTime
		return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
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
	public static DateTime of(
		int year,
		int month,
		int day,
		int hour,
		int minute,
		int second
	) {
		return new DateTime(
			LocalDateTime.of(year, month, day, hour, minute, second)
		);
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
	public static DateTime of(
		int year,
		int month,
		int day,
		int hour,
		int minute,
		int second,
		int nano
	) {
		return new DateTime(
			LocalDateTime.of(year, month, day, hour, minute, second, nano)
		);
	}

	/**
	 * 根据毫秒时间戳创建 DateTime 实例
	 *
	 * @param epochMilli 毫秒时间戳
	 * @return 返回对应时间的 DateTime 实例
	 */
	public static DateTime of(long epochMilli) {
		return new DateTime(
			Instant.ofEpochMilli(epochMilli)
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime()
		);
	}

	/**
	 * 根据毫秒时间戳和时区创建 DateTime 实例
	 *
	 * @param epochMilli 毫秒时间戳
	 * @param zoneId     时区信息
	 * @return 返回对应时间的 DateTime 实例
	 */
	public static DateTime of(long epochMilli, ZoneId zoneId) {
		return new DateTime(
			Instant.ofEpochMilli(epochMilli).atZone(zoneId).toLocalDateTime()
		);
	}

	/**
	 * 将当前 DateTime 转换为 Date 对象。
	 *
	 * @return 返回对应的 Date 对象
	 */
	public Date toDate() {
		return Date.from(localDateTime.atZone(getZoneId()).toInstant());
	}

	/**
	 * 获取当前 DateTime 中的 LocalDateTime 实例。
	 *
	 * @return 返回 LocalDateTime 对象
	 */
	public LocalDateTime toLocalDateTime() {
		return localDateTime;
	}

	/**
	 * 在当前时间基础上增加指定的时间偏移量。
	 *
	 * @param dateTimeOffset 时间偏移对象
	 * @return 返回修改后的 DateTime 实例
	 */
	public DateTime add(DateTimeOffset dateTimeOffset) {
		return new DateTime(
			this.localDateTime.plus(
				dateTimeOffset.getOffset(),
				dateTimeOffset.getOffsetType()
			)
		);
	}

	/**
	 * 在当前时间基础上减少指定的时间偏移量。
	 *
	 * @param dateTimeOffset 时间偏移对象
	 * @return 返回修改后的 DateTime 实例
	 */
	public DateTime sub(DateTimeOffset dateTimeOffset) {
		return new DateTime(
			this.localDateTime.plus(
				-dateTimeOffset.getOffset(),
				dateTimeOffset.getOffsetType()
			)
		);
	}

	/**
	 * 使用指定格式化模板将当前时间格式化为字符串。
	 *
	 * @param formatter 格式化模板
	 * @return 返回格式化后的时间字符串
	 */
	public String format(String formatter) {
		return format(formatter, false);
	}

	/**
	 * 使用 Formatter 枚举将当前时间格式化为字符串。
	 *
	 * @param formatter 格式化模板枚举
	 * @return 返回格式化后的时间字符串
	 */
	public String format(Formatter formatter) {
		return format(formatter.getValue());
	}

	/**
	 * 使用指定格式化模板将当前时间格式化为字符串，并可选择是否去除末尾多余的零。
	 *
	 * @param formatter 格式化模板
	 * @param repcZero  是否去除末尾多余的零
	 * @return 返回格式化后的时间字符串
	 */
	public String format(String formatter, boolean repcZero) {
		var formatted = DateTimeFormatter.ofPattern(formatter).format(
			toLocalDateTime()
		);
		if (repcZero) {
			// 处理小数点后多余的0
			formatted = formatted.replaceAll("(\\.\\d*?)0+\\b", "$1");
			formatted = formatted.replaceAll("\\.$", "");
		}
		return formatted;
	}

	/**
	 * 使用 Formatter 枚举将当前时间格式化为字符串，并可选择是否去除末尾多余的零。
	 *
	 * @param formatter 格式化模板枚举
	 * @param repcZero  是否去除末尾多余的零
	 * @return 返回格式化后的时间字符串
	 */
	public String format(Formatter formatter, boolean repcZero) {
		return format(formatter.getValue(), repcZero);
	}

	/**
	 * 返回当前时间的标准字符串表示形式。
	 *
	 * @return 返回标准格式的时间字符串
	 */
	@Override
	public String toString() {
		return String.format(
			"DateTime(%s)",
			format(Formatter.STANDARD_DATETIME_MILLISECOUND7, true)
		);
	}

	/**
	 * 比较当前DateTime对象与指定对象是否相等
	 *
	 * @param obj 要比较的对象
	 * @return 如果对象相等则返回true，否则返回false
	 */
	@Override
	public boolean equals(Object obj) {
		// 检查对象类型是否为DateTime
		if (obj instanceof DateTime) {
			// 比较两个DateTime对象转换为LocalDateTime后的值
			return toLocalDateTime().equals(((DateTime) obj).toLocalDateTime());
		}
		return false;
	}

	/**
	 * 将当前 DateTime 转换为 Instant 对象。
	 *
	 * @return 返回 Instant 对象
	 */
	@NotNull
	public Instant toInstant() {
		return localDateTime.atZone(zoneId).toInstant();
	}

	/**
	 * 判断当前时间是否在指定时间之后。
	 *
	 * @param dateTime 指定时间
	 * @return 如果当前时间在指定时间之后则返回 true，否则返回 false
	 */
	public boolean isAfter(DateTime dateTime) {
		if (dateTime == null) {
			return false;
		}
		return toInstant().isAfter(dateTime.toInstant());
	}

	/**
	 * 判断当前时间是否在指定时间之前。
	 *
	 * @param dateTime 指定时间
	 * @return 如果当前时间在指定时间之前则返回 true，否则返回 false
	 */
	public boolean isBefore(DateTime dateTime) {
		if (dateTime == null) {
			return false;
		}
		return toInstant().isBefore(dateTime.toInstant());
	}
}
