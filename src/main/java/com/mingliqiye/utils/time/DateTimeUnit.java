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
 * CurrentFile DateTimeUnit.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.time;

/**
 * 时间单位常量定义
 *
 * @author MingLiPro
 */
public interface DateTimeUnit {
	// 时间单位常量
	String YEAR = "year";
	String MONTH = "month";
	String WEEK = "week";
	String DAY = "day";
	String HOUR = "hour";
	String MINUTE = "minute";
	String SECOND = "second";
	String MILLISECOND = "millisecond";
	String MICROSECOND = "microsecond";
	String NANOSECOND = "nanosecond";

	// 时间单位缩写
	String YEAR_ABBR = "y";
	String MONTH_ABBR = "M";
	String WEEK_ABBR = "w";
	String DAY_ABBR = "d";
	String HOUR_ABBR = "h";
	String MINUTE_ABBR = "m";
	String SECOND_ABBR = "s";
	String MILLISECOND_ABBR = "ms";
	String MICROSECOND_ABBR = "μs";
	String NANOSECOND_ABBR = "ns";

	// 时间单位转换系数（毫秒为基准）
	long MILLIS_PER_SECOND = 1000L;
	long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
	long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
	long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;
	long MILLIS_PER_WEEK = 7 * MILLIS_PER_DAY;

	// 月份和年的毫秒数仅为近似值
	long MILLIS_PER_MONTH = 30 * MILLIS_PER_DAY; // 近似值
	long MILLIS_PER_YEAR = 365 * MILLIS_PER_DAY; // 近似值
}
