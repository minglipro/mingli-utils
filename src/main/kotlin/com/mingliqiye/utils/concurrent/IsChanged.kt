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
 * CurrentFile IsChanged.kt
 * LastUpdate 2025-09-19 20:17:07
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.concurrent

import java.util.*
import java.util.concurrent.atomic.AtomicReference

/**
 * IsChanged 类提供了一个线程安全的包装器，用于检测值是否发生变化。
 * 它基于 AtomicReference 实现，适用于需要监控数据变更的并发场景。
 *
 * @param T 泛型类型，表示被包装的数据类型
 * @author MingLiPro
 */
class IsChanged<T> {

    /**
     * 使用 AtomicReference 来保证对数据的原子操作
     */
    private val atomicReferenceData: AtomicReference<T> = AtomicReference()

    /**
     * 默认构造函数，初始化数据为 null
     */
    constructor() : this(null)

    /**
     * 带参数的构造函数，使用指定的初始值初始化
     *
     * @param data 初始数据值
     */
    constructor(data: T?) : super() {
        atomicReferenceData.set(data)
    }

    /**
     * 设置新的数据值，不检查是否发生变化
     *
     * @param data 要设置的新数据值
     */
    fun set(data: T) {
        atomicReferenceData.set(data)
    }

    /**
     * 获取当前数据值
     *
     * @return 当前数据值
     */
    fun get(): T? {
        return atomicReferenceData.get()
    }

    /**
     * 设置新的数据值并返回旧的数据值
     *
     * @param data 要设置的新数据值
     * @return 设置前的旧数据值
     */
    fun setAndGet(data: T): T? {
        return atomicReferenceData.getAndSet(data)
    }

    /**
     * 设置新的数据值，如果新值与当前值不同则更新并返回 true，否则返回 false
     * 使用 CAS(Compare-And-Swap) 操作确保线程安全
     *
     * @param data 要设置的新数据值
     * @return 如果值发生变化返回 true，否则返回 false
     */
    fun setAndChanged(data: T): Boolean {
        var currentData: T?
        do {
            currentData = get()
            // 如果新值与当前值相等，则认为没有变化，直接返回 false
            if (Objects.equals(data, currentData)) {
                return false
            }
            // 使用 CAS 操作尝试更新值，如果失败则重试
        } while (!atomicReferenceData.compareAndSet(currentData, data))
        // 成功更新值，返回 true 表示发生了变化
        return true
    }
}
