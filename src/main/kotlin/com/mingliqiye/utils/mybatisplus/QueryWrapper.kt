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
 * LastUpdate 2026-01-14 13:00:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatisplus

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper

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
    fun queryWrapper(): QueryWrapper<T> {
        return QueryWrapper<T>()
    }

    /**
     * 创建并返回一个新的UpdateWrapper实例
     *
     * @return UpdateWrapper<T> 返回类型化的更新包装器实例
     */
    fun updateWrapper(): UpdateWrapper<T> {
        return UpdateWrapper<T>()
    }

    /**
     * 创建并返回一个新的LambdaQueryWrapper实例
     *
     * @return LambdaQueryWrapper<T> 返回类型化的Lambda查询包装器实例
     */
    fun lambdaQueryWrapper(): LambdaQueryWrapper<T> {
        return LambdaQueryWrapper<T>()
    }

    /**
     * 创建并返回一个新的LambdaUpdateWrapper实例
     *
     * @return LambdaUpdateWrapper<T> 返回类型化的Lambda更新包装器实例
     */
    fun lambdaUpdateWrapper(): LambdaUpdateWrapper<T> {
        return LambdaUpdateWrapper<T>()
    }
}
