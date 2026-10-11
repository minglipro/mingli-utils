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
 * CurrentFile ObjectPool.kt
 * LastUpdate 2026-10-02 16:19:05
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.pool

import com.mingliqiye.utils.require.Require.require
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

@Deprecated("未实现")
abstract class ObjectPool<T>(
    private val maxSize: Int = Int.MAX_VALUE,
    private val minSize: Int = 0,
    private val initialSize: Int = 1,
) : Pool<T> {


    private val initialCount = AtomicInteger(0)
    private val pool = ConcurrentLinkedQueue<ObjectPoolData<T>>()
    private val isClosed = AtomicBoolean(false)
    private val lock = ReentrantLock()
    private val notEmpty: Condition = lock.newCondition()

    init {
        require(maxSize >= minSize)
        require(initialSize >= minSize)
        require(maxSize > 0)
        repeat(initialSize) {
            pool.add(init(initialCount.getAndIncrement()))
        }
    }

    override fun close() {
        for (poolData in pool) {
            destroy(poolData)
        }
    }

    override fun borrow(timeoutMillis: Long): ObjectPoolData<T> {
        lock.withLock {
            if (isClosed.get()) {
                throw IllegalStateException("Object pool closed")
            }
            pool.poll()?.let { return it }
            if (initialCount.get() < maxSize) {
                return init(initialCount.getAndIncrement())
            }

            // 3. 池已满且无空闲，等待归还
            if (timeoutMillis <= 0) {
                // 无限等待
                while (pool.isEmpty()) {
                    notEmpty.await()  // 释放锁并等待
                }
                return pool.poll()
            }

            // 有限时间等待
            var remainingNanos = TimeUnit.MILLISECONDS.toNanos(timeoutMillis)
            while (pool.isEmpty()) {
                if (remainingNanos <= 0) {
                    throw IllegalStateException("Timeout waiting for object from pool")
                }
                remainingNanos = notEmpty.awaitNanos(remainingNanos)
            }
            return pool.poll()
        }
    }

    override fun returnObject(obj: ObjectPoolData<T>) {
        lock.withLock {
            if (isClosed.get()) {
                throw InterruptedException("Object pool closed")
            }
            pool.add(obj)
            notEmpty.signal()
        }
    }

}


interface Pool<T> {
    fun close()
    fun borrow(timeoutMillis: Long): ObjectPoolData<T>
    fun borrow(): ObjectPoolData<T> = borrow(0)
    fun returnObject(obj: ObjectPoolData<T>)
    fun use(funs: (ObjectPoolData<T>) -> Unit) = use(0, funs)
    fun init(id: Int): ObjectPoolData<T>
    fun destroy(data: ObjectPoolData<T>)
    fun use(timeoutMillis: Long, funs: (ObjectPoolData<T>) -> Unit) {
        val i = borrow(timeoutMillis)
        funs(i)
        returnObject(i)
    }
}

data class ObjectPoolData<T>(
    val obj: T,
    val objectPool: ObjectPool<T>,
    val id: Int = obj.hashCode(),
    val name: String = "",
)


class TheardPool : ObjectPool<Thread>() {
    override fun init(id: Int): ObjectPoolData<Thread> {
        return ObjectPoolData(
            Thread().apply {
                name = "TheardPool $id"
            },
            this
        )
    }

    override fun destroy(data: ObjectPoolData<Thread>) {
        data.obj.interrupt()
    }

}
