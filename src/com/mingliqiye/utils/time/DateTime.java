package com.mingliqiye.utils.time;

import lombok.Getter;
import lombok.Setter;
import lombok.var;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类，用于处理日期时间的转换、格式化等操作。
 * 提供了多种静态方法来创建 DateTime 实例，并支持与 Date、LocalDateTime 等类型的互转。
 *
 * @author MingLiPro
 * @see LocalDateTime
 */
public final class DateTime {

    @Getter
    @Setter
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
     *
     * @return 返回当前时间的 DateTime 实例
     */
    public static DateTime now() {
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
     * 设置 LocalDateTime 实例。
     *
     * @param localDateTime LocalDateTime 对象
     */
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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
        this.localDateTime = this.localDateTime.plus(
            dateTimeOffset.getOffset(),
            dateTimeOffset.getOffsetType()
        );
        return this;
    }

    /**
     * 在当前时间基础上减少指定的时间偏移量。
     *
     * @param dateTimeOffset 时间偏移对象
     * @return 返回修改后的 DateTime 实例
     */
    public DateTime sub(DateTimeOffset dateTimeOffset) {
        this.localDateTime = this.localDateTime.plus(
            -dateTimeOffset.getOffset(),
            dateTimeOffset.getOffsetType()
        );
        return this;
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

    public Instant toInstant() {
        return localDateTime.atZone(zoneId).toInstant();
    }
}
