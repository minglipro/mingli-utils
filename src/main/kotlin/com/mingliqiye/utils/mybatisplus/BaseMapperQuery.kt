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
 * CurrentFile QueryWrapper.kt
 * LastUpdate 2026-02-03 12:03:27
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatisplus

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper

/**
 * BaseMapperQuery接口扩展了BaseMapper，提供了通用的查询包装器功能
 *
 * @param T 实体类类型
 */
interface BaseMapperQuery<T> : BaseMapper<T> {
    /**
     * 创建并返回一个新的QueryWrapper实例
     *
     * @return QueryWrapper<T> 返回类型化的查询包装器实例
     */
    fun queryWrapper() = QueryWrapper<T>()

    /**
     * 创建并返回一个新的UpdateWrapper实例
     *
     * @return UpdateWrapper<T> 返回类型化的更新包装器实例
     */
    fun updateWrapper() = UpdateWrapper<T>()

    /**
     * 创建并返回一个新的LambdaQueryWrapper实例
     *
     * @return LambdaQueryWrapper<T> 返回类型化的Lambda查询包装器实例
     */
    fun lambdaQueryWrapper() = LambdaQueryWrapper<T>()

    /**
     * 创建并返回一个新的LambdaUpdateWrapper实例
     *
     * @return LambdaUpdateWrapper<T> 返回类型化的Lambda更新包装器实例
     */
    fun lambdaUpdateWrapper() = LambdaUpdateWrapper<T>()


    companion object {

        /**
         * 创建并返回一个新的QueryWrapper实例
         *
         * @return QueryWrapper<T> 返回类型化的查询包装器实例
         */
        inline fun <reified T> BaseMapper<T>.queryWrapper(): QueryWrapper<T> = QueryWrapper<T>()

        /**
         * 创建并返回一个新的UpdateWrapper实例
         *
         * @return UpdateWrapper<T> 返回类型化的更新包装器实例
         */
        inline fun <reified T> BaseMapper<T>.updateWrapper(): UpdateWrapper<T> = UpdateWrapper<T>()

        /**
         * 创建并返回一个新的LambdaQueryWrapper实例
         *
         * @return LambdaQueryWrapper<T> 返回类型化的Lambda查询包装器实例
         */
        inline fun <reified T> BaseMapper<T>.lambdaQueryWrapper(): LambdaQueryWrapper<T> =
            LambdaQueryWrapper<T>(T::class.java)

        /**
         * 创建并返回一个新的LambdaUpdateWrapper实例
         *
         * @return LambdaUpdateWrapper<T> 返回类型化的Lambda更新包装器实例
         */
        inline fun <reified T> BaseMapper<T>.lambdaUpdateWrapper(): LambdaUpdateWrapper<T> =
            LambdaUpdateWrapper<T>(T::class.java)

        /**
         * 创建并返回一个新的KtUpdateWrapper实例
         *
         * @return KtUpdateWrapper<T> 返回类型化的Kotlin更新包装器实例
         */
        inline fun <reified T : Any> BaseMapper<T>.ktUpdateWrapper(): KtUpdateWrapper<T> =
            KtUpdateWrapper(T::class.java)

        /**
         * 创建并返回一个新的KtQueryWrapper实例
         *
         * @return KtQueryWrapper<T> 返回类型化的Kotlin查询包装器实例
         */
        inline fun <reified T : Any> BaseMapper<T>.ktQueryWrapper(): KtQueryWrapper<T> = KtQueryWrapper(T::class.java)

        /**
         * 创建并返回一个新的KtUpdateChainWrapper实例
         *
         * @return KtUpdateChainWrapper<T> 返回类型化的Kotlin更新链式包装器实例
         */
        inline fun <reified T : Any> BaseMapper<T>.ktUpdateChainWrapper(): KtUpdateChainWrapper<T> =
            KtUpdateChainWrapper(T::class.java)
    }
}
