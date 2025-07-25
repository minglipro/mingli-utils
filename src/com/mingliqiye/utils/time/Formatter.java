package com.mingliqiye.utils.time;

import lombok.Getter;

/**
 * 时间格式化枚举类
 * <p>
 * 定义了常用的时间格式化模式，用于日期时间的解析和格式化操作
 * 每个枚举常量包含对应的格式化字符串和字符串长度
 * </p>
 */
public enum Formatter {
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

    @Getter
    private final String value;

    @Getter
    private final int len;

    /**
     * 构造函数
     *
     * @param value 格式化模式字符串
     */
    Formatter(String value) {
        this.value = value;
        this.len = value.length();
    }
}
