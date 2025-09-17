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
 * CurrentFile StringUtils.kt
 * LastUpdate 2025-09-17 21:09:10
 * UpdateUser MingLiPro
 */
@file:JvmName("StringUtils")

package com.mingliqiye.utils.string

import com.mingliqiye.utils.logger.mingLiLoggerFactory


val log = mingLiLoggerFactory.getLogger("StringUtils")

val NULLISH_STRINGS = setOf("null", "NaN", "undefined", "None", "none")

/**
 * 判断`字符串`是否为空
 *
 * @param str 待判断的字符串
 * @return `true`: 空 `false`: 非空
 */
@JvmName("isEmpty")
fun String?.isNullish(): Boolean {
    return this == null || this.isBlank() || this in NULLISH_STRINGS
}

/**
 * 格式化字符串，将字符串中的占位符{}替换为对应的参数值
 *
 * `Kotlin`语言给我老老实实用`$`啊
 *
 * @param str 需要格式化的字符串，包含{}占位符 \\{} 代表一个{}
 * @param args 要替换占位符的参数列表
 * @return 格式化后的字符串
 */
fun format(str: String, vararg args: Any?): String {
    var argIndex = 0
    val result = StringBuilder()
    var lastIndex = 0

    // 匹配所有非转义的 {}
    val pattern = Regex("(?<!\\\\)\\{}")
    val matches = pattern.findAll(str)

    for (match in matches) {
        // 添加匹配前的文本
        result.append(str, lastIndex, match.range.first)

        // 替换占位符
        if (argIndex < args.size) {
            result.append(args[argIndex].toString())
            argIndex++
        }

        lastIndex = match.range.last + 1
    }

    // 添加剩余文本
    if (lastIndex < str.length) {
        result.append(str, lastIndex, str.length)
    }

    // 处理转义的 \\{}（替换为 {}）
    val finalResult = result.toString().replace("\\{}", "{}")

    // 检查参数数量
    val placeholderCount = matches.count()
    if (argIndex != args.size) {
        log.warn("Placeholder count: $placeholderCount, Argument count: ${args.size}")
    }

    return finalResult
}


/**
 * 将字符串转换为Unicode编码格式
 *
 * @param str 待转换的字符串
 * @return 转换后的Unicode编码字符串，每个字符都以\\u开头的十六进制形式表示
 */
fun stringToUnicode(str: String): String {
    val sb = java.lang.StringBuilder()
    val c = str.toCharArray()
    for (value in c) {
        sb.append(stringToUnicode(value))
    }
    return sb.toString()
}

/**
 * 将字符转换为Unicode转义字符串
 *
 * @param c 需要转换的字符
 * @return 返回格式为"\\uXXXX"的Unicode转义字符串，其中XXXX为字符的十六进制Unicode码点
 */
fun stringToUnicode(c: Char): String {
    return "\\u" + String.format("%04x", c.code)
}

/**
 * 将整数转换为Unicode字符串表示形式
 *
 * @param c 要转换的整数，表示Unicode码点
 * @return 返回格式为"\\uXXXX"的Unicode字符串，其中XXXX是参数c的十六进制表示
 */
fun stringToUnicode(c: Int): String {
    return "\\u" + Integer.toHexString(c)
}

/**
 * 将Unicode编码字符串转换为普通字符串
 *
 * 该函数接收一个包含Unicode转义序列的字符串，将其解析并转换为对应的字符序列
 *
 * @param unicode 包含Unicode转义序列的字符串，格式如"\\uXXXX"，其中XXXX为十六进制数
 * @return 转换后的普通字符串，包含对应的Unicode字符
 */
fun unicodeToString(unicode: String): String {
    val sb = java.lang.StringBuilder()
    // 按照Unicode转义符分割字符串，得到包含十六进制编码的数组
    val hex: Array<String?> = unicode.split("\\\\u".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    // 从索引1开始遍历，因为分割后的第一个元素是转义符前面的内容（可能为空）
    for (i in 1..<hex.size) {
        // 将十六进制字符串转换为整数，作为字符的Unicode码点
        val index = hex[i]!!.toInt(16)
        // 将Unicode码点转换为对应字符并添加到结果中
        sb.append(index.toChar())
    }
    return sb.toString()
}

/**
 * 创建一个指定初始容量的StringBuilder实例
 *
 * @param i StringBuilder的初始容量
 * @return 指定初始容量的StringBuilder实例
 */
fun stringBuilder(i: Int): java.lang.StringBuilder {
    return StringBuilder(i)
}

/**
 * 根据当前字符串创建一个StringBuilder实例
 *
 * @return 包含当前字符串内容的StringBuilder实例
 */
fun String.stringBuilder(): java.lang.StringBuilder {
    return StringBuilder(this)
}


fun split(str: String, separator: String): List<String> {
    return str.split(separator)
}

fun List<String>.join(separator: String): String {
    return this.joinToString(separator)
}

