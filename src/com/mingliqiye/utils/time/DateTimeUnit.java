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
