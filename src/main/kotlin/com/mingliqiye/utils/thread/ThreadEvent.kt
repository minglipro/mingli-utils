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
 * CurrentFile ThreadEvent.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 线程事件同步工具类，用于线程间的事件通知和等待。
 *
 * 支持 Kotlin 便捷语法：
 * - `event()` 读取数据，`event(newData)` 设置数据并唤醒等待线程
 * - `val value by event` 直接作为属性委托使用
 */
open class ThreadEvent<T> : ReadWriteProperty<Any?, T> {

	private var latch = CountDownLatch(1)

	@Volatile
	private var data: T

	constructor(data: T) {
		this.data = data
	}

	/**
	 * 获取当前事件状态
	 *
	 * @return 当前事件的数据值，如果未设置则返回null
	 */
	fun get(): T = data

	/**
	 * 设置事件数据并释放等待的线程
	 *
	 * @param data 要设置的事件数据
	 */
	@Synchronized
	fun set(data: T) {
		this.data = data
		latch.countDown()
	}

	/**
	 * 重置事件状态，重新初始化CountDownLatch
	 */
	@Synchronized
	fun reset() {
		latch = CountDownLatch(1)
	}

	/**
	 * 等待事件被设置，阻塞当前线程直到事件被触发
	 */
	fun await() {
		latch.await()
	}

	/**
	 * 等待事件被设置并获取数据
	 *
	 * @return 事件数据，当事件被设置后返回对应的数据
	 */
	fun awaitAndGet(): T {
		await()
		return data
	}

	/**
	 * 在指定超时时间内等待事件被设置并获取数据
	 *
	 * @param timeout 等待超时时间
	 * @param unit 时间单位
	 * @return 事件数据，如果在超时时间内事件被设置则返回数据，否则返回null
	 */
	fun awaitAndGet(timeout: Long, unit: TimeUnit): T? {
		await(timeout, unit)
		return data
	}

	/**
	 * 等待事件被设置并获取数据，超时返回 null
	 *
	 * @param timeout 等待超时时间
	 * @param unit 时间单位
	 * @return 事件数据；超时未触发则返回 null
	 */
	fun awaitAndGetOrNull(timeout: Long, unit: TimeUnit): T? =
		if (await(timeout, unit)) data else null

	/**
	 * 在指定超时时间内等待事件被设置
	 *
	 * @param timeout 等待超时时间
	 * @param unit 时间单位
	 * @return 如果在超时时间内事件被设置则返回true，否则返回false
	 */
	fun await(timeout: Long, unit: TimeUnit): Boolean {
		return latch.await(timeout, unit)
	}

	/**
	 * 事件是否已被设置（自上次 [reset] 以来）
	 */
	fun isSet(): Boolean = latch.count == 0L

	fun setAndReset(data: T) {
		set(data)
		reset()
	}

	// ---- Kotlin 便捷语法 ----

	/** 读取事件数据：`val d = event()` */
	operator fun invoke(): T = data

	/** 设置事件数据并唤醒等待线程：`event(newData)` */
	operator fun invoke(data: T) = set(data)

	/** 支持属性委托：`var value by event` */
	override operator fun getValue(thisRef: Any?, property: KProperty<*>): T = data

	/** 支持属性委托：`value = newData` 等价于 [set] */
	override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = set(value)

	/**
	 * 以自身为委托，返回属性委托视图
	 */
	fun asDelegate(): ReadWriteProperty<Any?, T> = this

	companion object {
		/**
		 * 创建事件实例
		 *
		 * @param data 初始数据
		 */
		@JvmStatic
		fun <T> of(data: T): ThreadEvent<T> = ThreadEvent(data)
	}
}
