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
 * CurrentFile RandomString.kt
 * LastUpdate 2026-02-05 11:12:36
 * UpdateUser MingLiPro
 */
@file:JvmName("RandomString")

package com.mingliqiye.utils.random

/**
 * 生成指定长度和字符集的随机字符串
 *
 * @param length 要生成的随机字符串长度
 * @param chars  用于生成随机字符串的字符集
 * @return 指定长度的随机字符串
 */
fun randomString(length: Int, chars: String): String {
    val charsd: Array<String?> = chars.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val sb = StringBuilder(length)
    // 循环生成随机字符并拼接
    for (i in 0..<length) {
        val index = randomInt(0, charsd.size - 1)
        sb.append(charsd[index])
    }
    return sb.toString()
}

/**
 * 生成指定长度的随机字符串，使用默认字符集(数字+大小写字母)
 *
 * @param length 要生成的随机字符串长度
 * @return 指定长度的随机字符串
 */
fun randomString(length: Int): String {
    return randomString(
        length, "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    )
}
