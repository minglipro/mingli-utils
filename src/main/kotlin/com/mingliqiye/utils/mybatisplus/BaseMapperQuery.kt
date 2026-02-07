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
 * CurrentFile BaseMapperQuery.kt
 * LastUpdate 2026-02-06 13:15:11
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


@Deprecated(
    "rename to FastBaseMapper",
    replaceWith = ReplaceWith(
        expression = "FastBaseMapper<*>",
        imports = ["com.mingliqiye.utils.mybatisplus.FastBaseMapper"]
    ),
    level = DeprecationLevel.WARNING
)
/**
 * @since 4.6.1
 * 已经重命名 [FastBaseMapper]
 */
interface BaseMapperQuery<T> : FastBaseMapper<T>

/**
 * 扩展[BaseMapper]接口，提供便捷的查询和更新包装器创建方法
 * 包含普通包装器、`Lambda`包装器和`Kotlin`专用包装器的创建方法
 */
interface FastBaseMapper<T> : BaseMapper<T> {
    /**
     * 创建[QueryWrapper]实例
     * @return QueryWrapper<T> 查询包装器实例
     */
    fun queryWrapper() = QueryWrapper<T>()

    /**
     * 创建[UpdateWrapper]实例
     * @return UpdateWrapper<T> 更新包装器实例
     */
    fun updateWrapper() = UpdateWrapper<T>()

    /**
     * 创建[LambdaQueryWrapper]实例
     * @return LambdaQueryWrapper<T> Lambda查询包装器实例
     */
    fun lambdaQueryWrapper() = LambdaQueryWrapper<T>()

    /**
     * 创建[LambdaUpdateWrapper]实例
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
         * 为[BaseMapper]创建[KtQueryWrapper]实例
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return KtQueryWrapper<T> Kotlin查询包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> BaseMapper<T>.ktQueryWrapper(): KtQueryWrapper<T> = KtQueryWrapper(T::class.java)

        /**
         * 为[BaseMapper]创建[KtQueryChainWrapper]实例
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return KtQueryChainWrapper<T> Kotlin查询链式包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> BaseMapper<T>.ktQueryChainWrapper(): KtQueryChainWrapper<T> =
            KtQueryChainWrapper(T::class.java)

        /**
         * 为[BaseMapper]创建[KtUpdateWrapper]实例
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return KtUpdateWrapper<T> Kotlin更新包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> BaseMapper<T>.ktUpdateWrapper(): KtUpdateWrapper<T> =
            KtUpdateWrapper(T::class.java)

        /**
         * 为[BaseMapper]创建[KtUpdateChainWrapper]实例
         * @param T 范型类型，必须继承自Any，通过reified获取实际类型
         * @receiver BaseMapper<T> 基础映射器实例
         * @return KtUpdateChainWrapper<T> Kotlin更新链式包装器实例，使用T类作为参数
         */
        inline fun <reified T : Any> BaseMapper<T>.ktUpdateChainWrapper(): KtUpdateChainWrapper<T> =
            KtUpdateChainWrapper(T::class.java)


    }


}
