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
 * CurrentFile Formatter.kt
 * LastUpdate 2026-02-04 21:54:36
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.time

/**
 * 时间格式化枚举类
 *
 *
 * 定义了常用的时间格式化模式，用于日期时间的解析和格式化操作
 * 每个枚举常量包含对应的格式化字符串和字符串长度
 *
 */
enum class Formatter(val value: String) {
    /**
     * 标准日期时间格式：yyyy-MM-dd HH:mm:ss
     */
    STANDARD_DATETIME("yyyy-MM-dd HH:mm:ss"),
    NONE(""),

    /**
     * 标准日期时间格式(7位毫秒)：yyyy-MM-dd HH:mm:ss.SSSSSSS
     */
    STANDARD_DATETIME_MILLISECOUND7("yyyy-MM-dd HH:mm:ss.SSSSSSS"),
    STANDARD_DATETIME_MILLISECOUND8("yyyy-MM-dd HH:mm:ss.SSSSSSSS"),
    STANDARD_DATETIME_MILLISECOUND9("yyyy-MM-dd HH:mm:ss.SSSSSSSSS"),

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
     * ISO8601格式：yyyy-MM-dd'T'HH:mm:ss.SSSSSS
     */
    ISO8601("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"),

    /**
     * 紧凑型日期时间格式：yyyyMMddHHmmss
     */
    COMPACT_DATETIME("yyyyMMddHHmmss");


    private val len: Int = value.replace("'", "").length

    fun getLen(): Int {
        return this.len
    }
}
