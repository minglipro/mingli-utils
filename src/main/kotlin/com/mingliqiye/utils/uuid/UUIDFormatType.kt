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
 * CurrentFile UUIDFormatType.kt
 * LastUpdate 2026-02-04 21:54:04
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.uuid

enum class UUIDFormatType(val isUpper: Boolean, val isnotSpace: Boolean) {
    UPPER_SPACE(true, false),
    NO_UPPER_SPACE(false, false),
    NO_UPPER_NO_SPACE(false, true),
    UPPER_NO_SPACE(true, true),
}
