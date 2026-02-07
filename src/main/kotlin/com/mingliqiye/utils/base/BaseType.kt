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
 * CurrentFile BaseType.kt
 * LastUpdate 2026-02-04 21:54:04
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

enum class BaseType(val baseCodec: BaseCodec) {
    BASE16(com.mingliqiye.utils.base.BASE16),
    BASE64(com.mingliqiye.utils.base.BASE64),
    BASE91(com.mingliqiye.utils.base.BASE91),
    BASE256(com.mingliqiye.utils.base.BASE256),
}
