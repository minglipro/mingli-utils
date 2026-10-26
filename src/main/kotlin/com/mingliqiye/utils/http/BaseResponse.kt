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
 * CurrentFile BaseResponse.kt
 * LastUpdate 2026-10-26 23:22:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http

open class BaseResponse<T>(
    open val time: String,
    open var message: String,
    open var data: T,
    open var statusCode: Int,

    ) {
    /**
     * 返回响应对象的字符串表示
     *
     * 重写toString方法以提供更有意义的对象表示，便于日志记录和调试。
     * 显示时间、消息、数据类型和值以及状态码。
     *
     * @return 格式化的字符串表示
     */
    override fun toString(): String =
        "${javaClass.simpleName}(time=${time}, message=${message}, data=${data}, statusCode=${statusCode})"
}
