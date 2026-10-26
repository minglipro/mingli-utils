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
 * CurrentFile FastBaseMapper.kt
 * LastUpdate 2026-10-26 23:22:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatisplus

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import kotlin.reflect.KProperty1

/**
 * 扩展[com.baomidou.mybatisplus.core.mapper.BaseMapper]接口，提供便捷的查询和更新包装器创建方法
 * 包含普通包装器、`Lambda`包装器和`Kotlin`专用包装器的创建方法
 */
interface FastBaseMapper<T> : BaseMapper<T> {
    /**
     * 创建[com.baomidou.mybatisplus.core.conditions.query.QueryWrapper]实例
     * @return QueryWrapper<T> 查询包装器实例
     */
    fun queryWrapper() = QueryWrapper<T>()

    /**
     * 创建[com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper]实例
     * @return UpdateWrapper<T> 更新包装器实例
     */
    fun updateWrapper() = UpdateWrapper<T>()

    /**
     * 创建[com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper]实例
     * @return LambdaQueryWrapper<T> Lambda查询包装器实例
     */
    fun lambdaQueryWrapper() = LambdaQueryWrapper<T>()

    /**
     * 创建[com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper]实例
     * @return LambdaUpdateWrapper<T> Lambda更新包装器实例
     */
    fun lambdaUpdateWrapper() = LambdaUpdateWrapper<T>()

    companion object {

        /**
         * 为[BaseMapper]创建[QueryWrapper]实例
         * @param T 范型类型，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return QueryWrapper<T> 查询包装器实例，使用T类作为参数
         */
        inline fun <reified T> BaseMapper<T>.queryWrapper(): QueryWrapper<T> = QueryWrapper<T>(T::class.java)

        /**
         * 为[BaseMapper]创建[UpdateWrapper]实例
         * @param T 范型类型，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return UpdateWrapper<T> 更新包装器实例
         */
        inline fun <reified T> BaseMapper<T>.updateWrapper(): UpdateWrapper<T> = UpdateWrapper<T>()

        /**
         * 为[BaseMapper]创建[LambdaQueryWrapper]实例
         * @param T 范型类型，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return LambdaQueryWrapper<T> Lambda查询包装器实例，使用T类作为参数
         */
        inline fun <reified T> BaseMapper<T>.lambdaQueryWrapper(): LambdaQueryWrapper<T> =
            LambdaQueryWrapper<T>(T::class.java)

        /**
         * 为[BaseMapper]创建[LambdaUpdateWrapper]实例
         * @param T 范型类型，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return LambdaUpdateWrapper<T> Lambda更新包装器实例，使用T类作为参数
         */
        inline fun <reified T> BaseMapper<T>.lambdaUpdateWrapper(): LambdaUpdateWrapper<T> =
            LambdaUpdateWrapper<T>(T::class.java)


        /**
         * 为[BaseMapper]创建[com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper]实例
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return KtQueryWrapper<T> Kotlin查询包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> BaseMapper<T>.ktQueryWrapper(): KtQueryWrapper<T> = KtQueryWrapper(T::class.java)

        /**
         * 为[BaseMapper]创建[com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper]实例
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return KtQueryChainWrapper<T> Kotlin查询链式包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> BaseMapper<T>.ktQueryChainWrapper(): KtQueryChainWrapper<T> =
            KtQueryChainWrapper(T::class.java)

        /**
         * 为[BaseMapper]创建[com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper]实例
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return KtUpdateWrapper<T> Kotlin更新包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> BaseMapper<T>.ktUpdateWrapper(): KtUpdateWrapper<T> =
            KtUpdateWrapper(T::class.java)

        /**
         * 为[BaseMapper]创建[com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper]实例
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return KtUpdateChainWrapper<T> Kotlin更新链式包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> BaseMapper<T>.ktUpdateChainWrapper(): KtUpdateChainWrapper<T> =
            KtUpdateChainWrapper(T::class.java)

        /**
         * 创建绑定当前映射器的[com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper]实例
         * 与[ktQueryChainWrapper]不同，该链式包装器持有映射器引用，可直接调用`list`/`one`/`page`等方法执行查询
         * @param T 范型类型，必须继承自Any
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return KtQueryChainWrapper<T> 可执行的Kotlin查询链式包装器实例
         */
        fun <T : Any> FastBaseMapper<T>.ktQueryChain(): KtQueryChainWrapper<T> =
            KtQueryChainWrapper<T>(this as BaseMapper<T>)

        /**
         * 创建绑定当前映射器的[com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper]实例
         * 与[ktUpdateChainWrapper]不同，该链式包装器持有映射器引用，可直接调用`update`/`remove`等方法执行操作
         * @param T 范型类型，必须继承自Any
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return KtUpdateChainWrapper<T> 可执行的Kotlin更新链式包装器实例
         */
        fun <T : Any> FastBaseMapper<T>.ktUpdateChain(): KtUpdateChainWrapper<T> =
            KtUpdateChainWrapper<T>(this as BaseMapper<T>)

        /**
         * [queryWrapper]的简写形式
         * @param T 范型类型，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return QueryWrapper<T> 查询包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.qw(): QueryWrapper<T> = queryWrapper()

        /**
         * [updateWrapper]的简写形式
         * @param T 范型类型，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return UpdateWrapper<T> 更新包装器实例
         */
        inline fun <reified T : Any> FastBaseMapper<T>.uw(): UpdateWrapper<T> = updateWrapper()

        /**
         * [lambdaQueryWrapper]的简写形式
         * @param T 范型类型，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return LambdaQueryWrapper<T> Lambda查询包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.qcw(): LambdaQueryWrapper<T> = lambdaQueryWrapper()

        /**
         * [lambdaUpdateWrapper]的简写形式
         * @param T 范型类型，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return LambdaUpdateWrapper<T> Lambda更新包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.ucw(): LambdaUpdateWrapper<T> = lambdaUpdateWrapper()

        /**
         * [ktQueryWrapper]的简写形式
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return KtQueryWrapper<T> Kotlin查询包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.kqw(): KtQueryWrapper<T> = ktQueryWrapper()

        /**
         * [ktUpdateWrapper]的简写形式
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return KtUpdateWrapper<T> Kotlin更新包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.kuw(): KtUpdateWrapper<T> = ktUpdateWrapper()

        /**
         * [ktQueryChainWrapper]的简写形式
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return KtQueryChainWrapper<T> Kotlin查询链式包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.kqcw(): KtQueryChainWrapper<T> = ktQueryChainWrapper()

        /**
         * [ktUpdateChainWrapper]的简写形式
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @return KtUpdateChainWrapper<T> Kotlin更新链式包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.kucw(): KtUpdateChainWrapper<T> = ktUpdateChainWrapper()

        /**
         * 通过Lambda构建[com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper]并执行更新
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param funs 更新包装器构建函数，返回构建完成的更新包装器
         * @return Int 受影响的行数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.update(funs: (wrapper: KtUpdateWrapper<T>) -> KtUpdateWrapper<T>): Int =
            this.update(funs(kuw()))

        /**
         * 通过Lambda构建[com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper]并携带实体执行更新
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param entity 承载待更新字段值的实体对象
         * @param funs 更新包装器构建函数，返回构建完成的更新包装器
         * @return Int 受影响的行数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.update(
            entity: T,
            funs: (wrapper: KtUpdateWrapper<T>) -> KtUpdateWrapper<T>,
        ): Int = this.update(entity, funs(kuw()))

        /**
         * 通过Lambda构建[com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper]并执行查询
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param funs 查询包装器构建函数，返回构建完成的查询包装器
         * @return List<T> 查询结果列表
         */
        inline fun <reified T : Any> FastBaseMapper<T>.selectList(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>): List<T> =
            this.selectList(funs(kqw()))

        /**
         * 通过Lambda构建[com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper]并执行分页查询
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param page 分页参数对象
         * @param funs 查询包装器构建函数，返回构建完成的查询包装器
         * @return Page<T> 分页查询结果
         */
        inline fun <reified T : Any> FastBaseMapper<T>.selectPage(
            page: Page<T>,
            funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>,
        ): Page<T> = this.selectPage(page, funs(kqw()))

        /**
         * 通过页码与每页大小直接执行分页查询
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param current 当前页码，从1开始
         * @param size 每页记录数
         * @param funs 查询包装器构建函数，返回构建完成的查询包装器
         * @return Page<T> 分页查询结果
         */
        inline fun <reified T : Any> FastBaseMapper<T>.selectPage(
            current: Long,
            size: Long,
            funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>,
        ): Page<T> = this.selectPage(Page(current, size), funs(kqw()))

        /**
         * 通过Lambda构建[com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper]并查询单条记录
         * 结果数量不为1时返回null，不抛出异常
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param funs 查询包装器构建函数，返回构建完成的查询包装器
         * @return T? 唯一的查询结果，不存在或多于一条时返回null
         */
        inline fun <reified T : Any> FastBaseMapper<T>.selectOne(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>): T? =
            this.selectList(funs).let {
                if (it.size != 1) null
                else it[0]
            }

        /**
         * 通过Lambda构建[com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper]并统计记录数
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param funs 查询包装器构建函数，返回构建完成的查询包装器
         * @return Long 符合条件的记录总数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.selectCount(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>): Long =
            this.selectCount(funs(kqw()))

        /**
         * 通过Lambda构建[com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper]并判断记录是否存在
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param funs 查询包装器构建函数，返回构建完成的查询包装器
         * @return Boolean 存在符合条件的记录返回true，否则返回false
         */
        inline fun <reified T : Any> FastBaseMapper<T>.exists(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>): Boolean =
            this.exists(funs(kqw()))

        /**
         * 通过Lambda构建[com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper]并执行删除
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param funs 查询包装器构建函数，返回构建完成的查询包装器
         * @return Int 被删除的行数
         */
        inline fun <reified T : Any> FastBaseMapper<T>.delete(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>): Int =
            this.delete(funs(kqw()))

        /**
         * 按单列等值条件查询记录列表
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @param R 列值类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param column 实体列属性引用
         * @param value 列值，执行等值匹配
         * @return List<T> 查询结果列表
         */
        inline fun <reified T : Any, R> FastBaseMapper<T>.selectListByColumn(
            column: KProperty1<T, R>,
            value: R,
        ): List<T> = selectList {
            it.eq(column, value)
        }

        /**
         * 按单列IN条件查询记录列表，集合为空时直接返回空列表而不执行查询
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @param R 列值类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param column 实体列属性引用
         * @param value 列值集合，执行IN匹配
         * @return List<T> 查询结果列表
         */
        inline fun <reified T : Any, R> FastBaseMapper<T>.selectListByColumn(
            column: KProperty1<T, R>,
            value: Collection<R>,
        ): List<T> {
            if (value.isEmpty()) return emptyList()
            return selectList {
                it.`in`(column, value)
            }
        }

        /**
         * 按多列等值条件查询记录列表
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param columns 列属性引用与列值的键值对，逐项执行等值匹配
         * @return List<T> 查询结果列表
         */
        inline fun <reified T : Any> FastBaseMapper<T>.selectListByColumns(
            vararg columns: Pair<KProperty1<T, *>, Any?>,
        ): List<T> = selectList { wrapper ->
            columns.forEach { (column, value) -> wrapper.eq(column, value) }
            wrapper
        }

        /**
         * 按单列等值条件查询单条记录，结果数量不为1时返回null
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @param R 列值类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param column 实体列属性引用
         * @param value 列值，执行等值匹配
         * @return T? 唯一的查询结果，不存在或多于一条时返回null
         */
        inline fun <reified T : Any, R> FastBaseMapper<T>.selectOneByColumn(
            column: KProperty1<T, R>,
            value: R,
        ): T? = selectOne {
            it.eq(column, value)
        }

        /**
         * 按单列等值条件判断记录是否存在
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @param R 列值类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param column 实体列属性引用
         * @param value 列值，执行等值匹配
         * @return Boolean 存在符合条件的记录返回true，否则返回false
         */
        inline fun <reified T : Any, R> FastBaseMapper<T>.existsByColumn(
            column: KProperty1<T, R>,
            value: R,
        ): Boolean = exists {
            it.eq(column, value)
        }

        /**
         * 按单列IN条件查询记录并构建有序映射，集合为空时直接返回空映射而不执行查询
         * 返回的[LinkedHashMap]保持入参集合的迭代顺序，缺失的键对应的值为null
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @param R 列值类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param column 实体列属性引用
         * @param value 列值集合，执行IN匹配
         * @return LinkedHashMap<R, T?> 以列值为键、实体为值的有序映射
         */
        inline fun <reified T : Any, R> FastBaseMapper<T>.selectMapByColumn(
            column: KProperty1<T, R>,
            value: Collection<R>,
        ): LinkedHashMap<R, T?> {
            if (value.isEmpty()) return linkedMapOf()

            val data = selectList {
                it.`in`(column, value)
            }

            val mapdata: Map<R, T> = data
                .associateBy { column(it) }

            val map = LinkedHashMap<R, T?>(value.size)
            value.forEach { key ->
                map[key] = mapdata[key]
            }
            return map
        }

        /**
         * 按单列等值条件删除记录
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @param R 列值类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param column 实体列属性引用
         * @param value 列值，执行等值匹配
         * @return Int 被删除的行数
         */
        inline fun <reified T : Any, R> FastBaseMapper<T>.deleteByColumn(
            column: KProperty1<T, R>,
            value: R,
        ): Int = delete {
            it.eq(column, value)
        }

        /**
         * 按单列IN条件删除记录，集合为空时直接返回0而不执行删除
         * 注意：MyBatis-Plus对空集合的IN条件会整体跳过，若不拦截将导致全表删除
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @param R 列值类型
         * @receiver FastBaseMapper<T> 快速映射器实例
         * @param column 实体列属性引用
         * @param value 列值集合，执行IN匹配
         * @return Int 被删除的行数
         */
        inline fun <reified T : Any, R> FastBaseMapper<T>.deleteByColumn(
            column: KProperty1<T, R>,
            value: Collection<R>,
        ): Int {
            if (value.isEmpty()) return 0
            return delete {
                it.`in`(column, value)
            }
        }
    }


}
