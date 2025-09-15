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
 * CurrentFile ThreadLocalDataHolder.kt
 * LastUpdate 2025-09-15 09:15:14
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.data

/**
 * 泛型线程局部变量持有器
 *
 * 封装了 ThreadLocal 的常用操作，提供更便捷的 API 来管理线程本地变量。
 *
 * @param T 存储的数据类型
 * @author MingLiPro
 */
class ThreadLocalDataHolder<T> {

    private val threadLocal: ThreadLocal<T?> = ThreadLocal()

    /**
     * 获取当前线程存储的值
     *
     * @return 当前线程存储的值，如果没有则返回null
     */
    fun get(): T? {
        return threadLocal.get()
    }

    /**
     * 设置当前线程的值
     *
     * @param value 要存储的值
     */
    fun set(value: T) {
        threadLocal.set(value)
    }

    /**
     * 移除当前线程存储的值
     *
     * 防止内存泄漏，使用完毕后应调用此方法清理资源。
     */
    fun remove() {
        threadLocal.remove()
    }

    /**
     * 获取当前线程存储的值，如果不存在则返回默认值
     *
     * @param defaultValue 默认值
     * @return 当前线程存储的值或默认值
     */
    fun getOrDefault(defaultValue: T): T {
        val value = threadLocal.get()
        return value ?: defaultValue
    }

    /**
     * 安全获取值（避免NPE）
     *
     * 在某些异常情况下防止抛出异常，直接返回 null。
     *
     * @return 值或null
     */
    fun safeGet(): T? {
        return try {
            threadLocal.get()
        } catch (e: Exception) {
            null
        }
    }

    /**
     * 检查当前线程是否有值
     *
     * @return 是否有值
     */
    fun isPresent(): Boolean {
        return threadLocal.get() != null
    }
}
