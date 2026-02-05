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
 * CurrentFile RandomInt.kt
 * LastUpdate 2026-01-28 10:46:02
 * UpdateUser MingLiPro
 */
@file:JvmName("RandomInt")

package com.mingliqiye.utils.random

import java.security.SecureRandom

val secureRandom: SecureRandom by lazy {
    SecureRandom.getInstanceStrong()
}


fun SecureRandom.nextInt(min: Int, max: Int): Int {
    return min + nextInt(max - min)
}


/**
 * 生成指定范围内的随机整数
 * @param min 最小值（包含）
 * @param max 最大值（不包含）
 * @return 随机整数
 */
fun randomIntNoHave(min: Int, max: Int): Int {
    var min = min
    var max = max
    if (min > max) {
        val t = min
        min = max
        max = t
    }
    if (min == max) {
        return min
    }
    return secureRandom.nextInt(min, max)
}

/**
 * 生成指定范围内的随机整数
 * @param min 最小值（包含）
 * @param max 最大值（包含）
 * @return 随机整数
 */
fun randomInt(min: Int, max: Int): Int {
    var max = max
    return randomIntNoHave(min, ++max)
}
