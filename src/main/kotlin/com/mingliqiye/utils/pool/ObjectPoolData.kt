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
 * CurrentFile ObjectPoolData.kt
 * LastUpdate 2026-10-12 13:43:53
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.pool

/**
 * 池对象的元数据包装。
 *
 * @property obj 实际对象
 * @property objectPool 归属的对象池
 * @property id 池内编号，默认取 [obj] 的 hashCode
 * @property name 可选的名称，用于日志/调试
 */
data class ObjectPoolData<T>(
    val obj: T,
    val objectPool: ObjectPool<T>,
    val id: Int = obj.hashCode(),
    val name: String = "",
) {
    /** 语法糖：归还到所属池 */
    fun release() = objectPool.returnObject(this)
}
