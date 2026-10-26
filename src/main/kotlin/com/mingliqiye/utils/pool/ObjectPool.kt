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
 * ProjectName FastBaseMapper.kt
 * ModuleName mingli-utils.main
 * CurrentFile ObjectPool.kt
 * LastUpdate 2026-10-26 23:22:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.pool

import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * 通用对象池抽象实现。
 *
 * 支持最小空闲数量、最大容量、超时借用与自动回收。
 * 子类只需实现 [init] 与 [destroy] 即可完成对象的创建与销毁。
 *
 * 线程安全：内部通过 [ReentrantLock] + [Condition] 协调借出/归还的等待与唤醒。
 *
 * @param T 池中管理的对象类型
 * @property maxSize 池允许存在的对象总数上限（含已借出），必须大于 0
 * @property minSize 池需要保持的最小空闲对象数，[borrow] 归还会在低于该值时补充
 * @property initialSize 初始化时预热的对象数量，必须 >= [minSize] 且 <= [maxSize]
 */
abstract class ObjectPool<T>(
    private val maxSize: Int = Int.MAX_VALUE,
    private val minSize: Int = 0,
    private val initialSize: Int = 1,
) : Pool<T> {

    /**
     * 已创建（含空闲与借出）对象的总数，用于容量控制。
     * 所有读写均在 [lock] 内完成，保证与 [borrowedCount]、[pool] 一致。
     */
    private var createdCount: Int = 0

    /** 当前已借出、尚未归还的对象数量（[lock] 保护） */
    private var borrowedCount: Int = 0

    /**
     * 空闲对象队列。全部访问均在 [lock] 内完成，
     * 因此 [ArrayDeque.size] 即为精确空闲数。
     */
    private val pool = ArrayDeque<ObjectPoolData<T>>()

    /** 池是否已关闭 */
    private val isClosed = AtomicBoolean(false)

    private val lock = ReentrantLock()
    private val notEmpty: Condition = lock.newCondition()
    private val notFull: Condition = lock.newCondition()

    init {
        require(maxSize >= minSize)
        require(initialSize >= minSize)
        require(initialSize <= maxSize)
        require(maxSize > 0)
        repeat(initialSize) {
            pool.addLast(init(createdCount++))
        }
    }

    /**
     * 关闭对象池：销毁所有空闲对象，唤醒所有等待者。
     * 已借出的对象在归还时会被直接销毁。
     */
    override fun close() {
        lock.withLock {
            if (!isClosed.compareAndSet(false, true)) {
                return
            }
            while (pool.isNotEmpty()) {
                val data = pool.removeFirst()
                runCatching { destroy(data) }
                createdCount--
            }
            notEmpty.signalAll()
            notFull.signalAll()
        }
    }

    /**
     * 从池中借出一个对象。
     *
     * 若池中有空闲对象则直接返回；否则在未达 [maxSize] 时新建；
     * 达到上限时根据 [timeoutMillis] 阻塞等待归还，超时抛出 [IllegalStateException]。
     *
     * @param timeoutMillis 等待超时（毫秒）。<= 0 表示无限等待。
     */
    override fun borrow(timeoutMillis: Long): ObjectPoolData<T> {
        lock.withLock {
            var remainingNanos = if (timeoutMillis > 0) TimeUnit.MILLISECONDS.toNanos(timeoutMillis) else -1L

            while (true) {
                if (isClosed.get()) {
                    throw IllegalStateException("Object pool closed")
                }

                // 1. 优先取空闲对象
                if (pool.isNotEmpty()) {
                    val data = pool.removeFirst()
                    borrowedCount++
                    return data
                }

                // 2. 池未满则创建新对象
                if (createdCount < maxSize) {
                    val id = createdCount++
                    val data = try {
                        init(id)
                    } catch (e: Throwable) {
                        createdCount--
                        throw e
                    }
                    borrowedCount++
                    return data
                }

                // 3. 池已满且无空闲，等待归还
                if (remainingNanos < 0) {
                    notEmpty.await()
                } else if (remainingNanos == 0L) {
                    throw IllegalStateException("Timeout waiting for object from pool")
                } else {
                    remainingNanos = notEmpty.awaitNanos(remainingNanos)
                    if (remainingNanos <= 0L) {
                        throw IllegalStateException("Timeout waiting for object from pool")
                    }
                }
            }
        }
    }

    /**
     * 归还对象到池中。
     * 若池已关闭或对象不属于当前池，则直接销毁；否则回填到空闲队列并唤醒等待者。
     */
    override fun returnObject(obj: ObjectPoolData<T>) {
        lock.withLock {
            borrowedCount--

            if (isClosed.get() || obj.objectPool !== this) {
                runCatching { destroy(obj) }
                createdCount--
                notFull.signal()
                return
            }

            pool.addLast(obj)
            notEmpty.signal()
        }
    }

    /**
     * 当前空闲对象数量（精确值）。
     * 通过短暂持锁读取，与 [activeSize]/[totalSize] 各自独立但均为调用瞬间的真实值。
     */
    fun idleSize(): Int = lock.withLock { pool.size }

    /** 当前已借出、尚未归还的对象数量（精确值） */
    fun activeSize(): Int = lock.withLock { borrowedCount }

    /** 已创建对象总数，含空闲与借出（精确值） */
    fun totalSize(): Int = lock.withLock { createdCount }

    /** 池是否已关闭 */
    fun closed(): Boolean = isClosed.get()

    /**
     * 一次性读取空闲 / 借出 / 总数 的一致快照（同一把锁内）。
     *
     * 相比分别调用三个方法，可避免三者之间因并发导致的不自洽
     * （例如 `idle + active != total`）。
     */
    fun snapshot(): PoolSnapshot = lock.withLock {
        PoolSnapshot(idle = pool.size, active = borrowedCount, total = createdCount, closed = isClosed.get())
    }

    /**
     * 池状态快照。
     * @property idle 空闲对象数
     * @property active 已借出对象数
     * @property total 已创建对象总数（= idle + active）
     * @property closed 池是否已关闭
     */
    data class PoolSnapshot(val idle: Int, val active: Int, val total: Int, val closed: Boolean)
}
