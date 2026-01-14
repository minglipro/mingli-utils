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
 * CurrentFile Debouncer.kt
 * LastUpdate 2026-01-11 09:10:30
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.functions

import java.util.concurrent.*

/**
 * 防抖器类，用于实现防抖功能，防止在短时间内重复执行相同任务
 *
 * @author MingLiPro
 */
class Debouncer(private val delay: Long, unit: TimeUnit) {

    private val scheduler: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
    private val delayedMap: ConcurrentHashMap<Any, Future<*>> = ConcurrentHashMap()
    private val delayMillis: Long = unit.toMillis(delay)

    /**
     * 执行防抖操作，如果在指定延迟时间内再次调用相同key的任务，则取消之前的任务并重新计时
     *
     * @param key  任务的唯一标识符，用于区分不同任务
     * @param task 要执行的任务
     */
    fun debounce(key: Any, task: Runnable) {
        // 提交新任务并获取之前可能存在的任务
        val prev = delayedMap.put(
            key,
            scheduler.schedule(
                {
                    try {
                        task.run()
                    } finally {
                        // 任务执行完成后从映射中移除
                        delayedMap.remove(key)
                    }
                },
                delayMillis,
                TimeUnit.MILLISECONDS
            )
        )

        // 如果之前存在任务，则取消它
        if (prev != null) {
            prev.cancel(true)
        }
    }

    /**
     * 关闭防抖器，取消所有待执行的任务并关闭调度器
     */
    fun shutdown() {
        // 先取消所有延迟任务
        for (future in delayedMap.values) {
            future.cancel(true)
        }
        delayedMap.clear()

        // 再关闭调度器
        scheduler.shutdownNow()
    }
}
