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


    fun <T : Any> FastBaseMapper<T>.qw() = queryWrapper()
    fun <T : Any> FastBaseMapper<T>.uw() = updateWrapper()
    fun <T : Any> FastBaseMapper<T>.qcw() = lambdaQueryWrapper()
    fun <T : Any> FastBaseMapper<T>.ucw() = lambdaUpdateWrapper()


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

        inline fun <reified T : Any> FastBaseMapper<T>.kqw() = ktQueryWrapper()
        inline fun <reified T : Any> FastBaseMapper<T>.kuw() = ktUpdateWrapper()
        inline fun <reified T : Any> FastBaseMapper<T>.kqcw() = ktQueryChainWrapper()
        inline fun <reified T : Any> FastBaseMapper<T>.kucw() = ktUpdateChainWrapper()

        inline fun <reified T : Any> FastBaseMapper<T>.update(funs: (wrapper: KtUpdateWrapper<T>) -> KtUpdateWrapper<T>): Int =
            this.update(funs(kuw()))


        inline fun <reified T : Any> FastBaseMapper<T>.selectList(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>): List<T> =
            this.selectList(funs(kqw()))

        inline fun <reified T : Any> FastBaseMapper<T>.selectPage(
            page: Page<T>,
            funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>,
        ): Page<T> = this.selectPage(page, funs(kqw()))


        inline fun <reified T : Any> FastBaseMapper<T>.selectOne(funs: (wrapper: KtQueryWrapper<T>) -> KtQueryWrapper<T>): T? =
            this.selectList(funs).let {
                if (it.size != 1) null
                else it[0]
            }

        inline fun <reified T : Any, R> FastBaseMapper<T>.selectListByColumn(
            column: KProperty1<T, R>,
            value: R,
        ): List<T> = selectList {
            it.eq(column, value)
        }

        inline fun <reified T : Any, R> FastBaseMapper<T>.selectListByColumn(
            column: KProperty1<T, R>,
            value: Collection<R>,
        ): List<T> {
            if (value.isEmpty()) return emptyList()
            return selectList {
                it.eq(column, value)
            }
        }

        inline fun <reified T : Any, R> FastBaseMapper<T>.selectMapByColumn(
            column: KProperty1<T, R>,
            value: Collection<R>,
        ): LinkedHashMap<R, T?> {
            if (value.isEmpty()) return linkedMapOf()

            val data = selectList {
                it.eq(column, value)
            }

            val mapdata: Map<R, T> = data
                .associateBy { column(it) }

            val map = LinkedHashMap<R, T?>(value.size)
            value.forEach { key ->
                map[key] = mapdata[key]
            }
            return map
        }
    }


}
