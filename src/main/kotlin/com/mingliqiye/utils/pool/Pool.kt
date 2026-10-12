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
 * CurrentFile Pool.kt
 * LastUpdate 2026-10-12 13:43:53
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.pool

/**
 * 对象池通用接口。
 */
interface Pool<T> {
    /** 关闭池并释放全部资源 */
    fun close()

    /** 借出一个对象，[timeoutMillis] <= 0 表示无限等待 */
    fun borrow(timeoutMillis: Long): ObjectPoolData<T>

    /** 无限等待地借出一个对象 */
    fun borrow(): ObjectPoolData<T> = borrow(0)

    /** 归还对象 */
    fun returnObject(obj: ObjectPoolData<T>)

    /** 使用默认超时执行 [funs] */
    fun use(funs: (ObjectPoolData<T>) -> Unit) = use(0, funs)

    /** 创建一个新的池对象 */
    fun init(id: Int): ObjectPoolData<T>

    /** 销毁池对象 */
    fun destroy(data: ObjectPoolData<T>)

    /**
     * 借出对象执行 [funs]，无论是否抛出异常都会自动归还。
     */
    fun use(timeoutMillis: Long, funs: (ObjectPoolData<T>) -> Unit) {
        val data = borrow(timeoutMillis)
        try {
            funs(data)
        } finally {
            runCatching { returnObject(data) }
        }
    }

    /**
     * 借出对象执行 [funs] 并返回其结果，无论是否抛出异常都会自动归还。
     */
    fun <R> useResult(timeoutMillis: Long = 0, funs: (ObjectPoolData<T>) -> R): R {
        val data = borrow(timeoutMillis)
        try {
            return funs(data)
        } finally {
            runCatching { returnObject(data) }
        }
    }
}
