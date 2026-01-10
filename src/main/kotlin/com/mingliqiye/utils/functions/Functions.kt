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
 * CurrentFile Functions.kt
 * LastUpdate 2026-01-09 08:12:01
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

@FunctionalInterface
fun interface P1Function<P> {
    fun call(p: P)
}

@FunctionalInterface
fun interface RFunction<R> {
    fun call(): R
}

@FunctionalInterface
fun interface P1RFunction<P, R> {
    fun call(p: P): R
}

@FunctionalInterface
fun interface P2Function<P, P1> {
    fun call(p: P, p1: P1)
}

@FunctionalInterface
fun interface P2RFunction<P, P1, R> {
    fun call(p: P, p1: P1): R
}

@FunctionalInterface
fun interface P3Function<P, P1, P2> {
    fun call(p: P, p1: P1, p2: P2)
}

@FunctionalInterface
fun interface P3RFunction<P, P1, P2, R> {
    fun call(p: P, p1: P1, p2: P2): R
}

@FunctionalInterface
fun interface P4Function<P, P1, P2, P3> {
    fun call(p: P, p1: P1, p2: P2, p3: P3)
}

@FunctionalInterface
fun interface P4RFunction<P, P1, P2, P3, R> {
    fun call(p: P, p1: P1, p2: P2, p3: P3): R
}

@FunctionalInterface
fun interface P5Function<P, P1, P2, P3, P4> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4)
}

@FunctionalInterface
fun interface P5RFunction<P, P1, P2, P3, P4, R> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4): R
}

@FunctionalInterface
fun interface P6Function<P, P1, P2, P3, P4, P5> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5)
}

@FunctionalInterface
fun interface P6RFunction<P, P1, P2, P3, P4, P5, R> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5): R
}

@FunctionalInterface
fun interface P7Function<P, P1, P2, P3, P4, P5, P6> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6)
}

@FunctionalInterface
fun interface P7RFunction<P, P1, P2, P3, P4, P5, P6, R> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6): R
}

@FunctionalInterface
fun interface P8Function<P, P1, P2, P3, P4, P5, P6, P7> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7)
}

@FunctionalInterface
fun interface P8RFunction<P, P1, P2, P3, P4, P5, P6, P7, R> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7): R
}

@FunctionalInterface
fun interface P9Function<P, P1, P2, P3, P4, P5, P6, P7, P8> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8)
}

@FunctionalInterface
fun interface P9RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, R> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8): R
}

@FunctionalInterface
fun interface P10Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9)
}

@FunctionalInterface
fun interface P10RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, R> {
    fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9): R
}
