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
 * CurrentFile NullUtils.kt
 * LastUpdate 2026-02-05 10:17:02
 * UpdateUser MingLiPro
 */
@file:JvmName("NullUtils")

package com.mingliqiye.utils.objects

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun Any?.isNotNull(): Boolean {
    contract {
        returns(true) implies (this@isNotNull != null)
    }
    return !isNull()
}

@OptIn(ExperimentalContracts::class)
fun Any?.isNull(): Boolean {
    contract {
        returns(false) implies (this@isNull != null)
    }
    return this == null
}

fun areEquals(a: Any?, b: Any?) = (a == null && b == null) || (a == b)

@OptIn(ExperimentalContracts::class)
fun areEqualsNoNull(a: Any?, b: Any?): Boolean {
    contract {
        returns(true) implies (a != null && b != null)
    }
    return a != null && b != null && a == b
}
