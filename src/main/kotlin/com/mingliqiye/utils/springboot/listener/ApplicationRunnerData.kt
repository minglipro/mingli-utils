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
 * CurrentFile ApplicationRunnerData.kt
 * LastUpdate 2026-03-10 09:10:50
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.listener

import java.lang.reflect.Method

data class ApplicationRunnerData(
    val beanName: String, val order: Int, val bean: Any, val method: Method
) {
    fun run() {
        method.invoke(bean)
    }
}
