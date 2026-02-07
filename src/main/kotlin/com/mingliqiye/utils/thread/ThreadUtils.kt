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
 * CurrentFile ThreadUtils.kt
 * LastUpdate 2026-01-31 20:48:19
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

/**
 * 线程工具类，提供线程名称的获取和设置功能
 */
object ThreadUtils {
    /**
     * 获取或设置当前线程的名称
     *
     * Getter: 返回当前线程的名称
     * Setter: 设置当前线程的名称
     *
     * @return 当前线程的名称字符串
     */
    @JvmStatic
    var name: String
        get() = Thread.currentThread().name
        set(s) {
            Thread.currentThread().name = s
        }
}
