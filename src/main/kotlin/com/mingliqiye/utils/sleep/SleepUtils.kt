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
 * CurrentFile SleepUtils.kt
 * LastUpdate 2026-01-15 16:50:50
 * UpdateUser MingLiPro
 */
package com.mingliqiye.utils.sleep

import java.util.concurrent.TimeUnit

/**
 * 等待工具类，提供多种等待和延迟执行的方式
 */
object SleepUtils {

    /**
     * 基于 Thread.sleep 的等待，单位毫秒
     *
     * @param millis 等待时间（毫秒）
     * @throws RuntimeException 当线程被中断时抛出
     */
    @JvmStatic
    fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            throw RuntimeException("Sleep interrupted", e)
        }
    }

    /**
     * 基于 Thread.sleep 的等待，单位毫秒
     *
     * @param millis 等待时间（毫秒）
     * @throws RuntimeException 当线程被中断时抛出
     */
    @JvmStatic
    fun sleep(millis: Int) {
        try {
            Thread.sleep(millis.toLong())
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            throw RuntimeException("Sleep interrupted", e)
        }
    }

    /**
     * 基于 TimeUnit 的等待
     *
     * @param timeout 等待时间
     * @param unit 时间单位
     * @throws RuntimeException 当线程被中断时抛出
     */
    @JvmStatic
    fun sleep(timeout: Long, unit: TimeUnit) {
        try {
            unit.sleep(timeout)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            throw RuntimeException("Sleep interrupted", e)
        }
    }
}
