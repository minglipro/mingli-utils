/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile Main.kt
 * LastUpdate 2025-09-15 18:02:00
 * UpdateUser MingLiPro
 */
package com.mingliqiye.utils

import com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration
import com.mingliqiye.utils.uuid.UUID

fun main() {
    AutoConfiguration.printBanner()

    println(UUID.of("b5c4579e-921a-11f0-ad12-d7949d0c61b8").equals(UUID.of("b5c4579e-921a-11f0-ad12-d7949d0c61b8")))
    println(UUID.getV1())
}
