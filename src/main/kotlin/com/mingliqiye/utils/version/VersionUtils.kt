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
 * CurrentFile VersionUtils.kt
 * LastUpdate 2025-09-12 15:09:57
 * UpdateUser MingLiPro
 */


@file:JvmName("VersionUtils")

package com.mingliqiye.utils.version

import kotlin.math.max

/**
 * 判断是否需要更新
 * @param now 当前版本
 * @param other 比较版本
 * @return 当前版本需要更新
 * @since 3.2.7
 */
fun isNew(now: String, other: String): Boolean {
    val otherA = now.split(".")
    val otherB = other.split(".")

    val maxLen = max(otherA.size, otherB.size)

    for (i in 0..<maxLen) {

        val a = if (otherA.size > i) otherA[i].toInt() else null
        val b = if (otherB.size > i) otherB[i].toInt() else null

        if (a == null) {
            return true
        }
        if (b == null) {
            return false
        }
        if (a != b) {
            return a < b
        }
    }

    return false
}

/**
 * 判断版本是否小于当前
 * @param now 当前版本
 * @param other 比较版本
 * @return 是否小于
 *
 */
fun isOld(now: String, other: String): Boolean {
    return (now != other) && !isNew(now, other)
}

/**
 * 判断是否版本相同
 * @param now 当前版本
 * @param other 比较版本
 * @return 是否相同
 */
fun equals(now: String, other: String): Boolean {
    return now == other
}

/**
 * 判断是否需要更新
 * @param now 当前版本
 * @param other 比较版本
 * @return null->版本相同 true->需要更新 false->不需要更新
 */
@JvmName("is")
fun isOther(now: String, other: String): Boolean? {
    return if (isNew(now, other)) {
        true
    } else if (isOld(now, other)) {
        false
    } else {
        null
    }
}

