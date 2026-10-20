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
 * CurrentFile ThreadLocalDelegates.kt
 * LastUpdate 2026-10-19 20:51:35
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import java.util.function.Supplier
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 将 [ThreadLocal] 包装为 Kotlin 属性委托，通过 `by` 关键字即可实现线程级变量：
 *
 * ```kotlin
 * object RequestContext {
 *     var userId: Long by threadLocal { 0L }
 *     var traceId: String? by nullableThreadLocal()
 * }
 * ```
 *
 * 每个线程读写互不影响，切换线程后自动获得新线程的隔离值。
 */
class ThreadLocalDelegate<T>(
    private val threadLocal: ThreadLocal<T>,
) : ReadWriteProperty<Any?, T> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = threadLocal.get()

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        threadLocal.set(value)
    }

    override fun toString(): String = threadLocal.toString()
}

/**
 * 创建带初始值的线程局部属性委托
 *
 * @param initial 每个线程首次访问时的初始化器
 */
fun <T> threadLocal(initial: () -> T): ThreadLocalDelegate<T> =
    ThreadLocalDelegate(ThreadLocal.withInitial(Supplier(initial)))

/**
 * 创建无初始值的线程局部属性委托，属性类型需声明为可空：
 *
 * ```kotlin
 * var value: String? by nullableThreadLocal()
 * ```
 */
fun <T : Any> nullableThreadLocal(): ThreadLocalDelegate<T?> =
    ThreadLocalDelegate(ThreadLocal())

/**
 * 将已有 [ThreadLocal] 实例包装为属性委托
 */
fun <T> ThreadLocal<T>.asDelegate(): ThreadLocalDelegate<T> = ThreadLocalDelegate(this)
