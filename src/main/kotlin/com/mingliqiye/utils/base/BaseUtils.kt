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
 * CurrentFile BaseUtils.kt
 * LastUpdate 2026-02-08 03:00:37
 * UpdateUser MingLiPro
 */

@file:JvmName("BaseUtils")

package com.mingliqiye.utils.base

import com.mingliqiye.utils.base.code.Base10
import com.mingliqiye.utils.base.code.Base16
import com.mingliqiye.utils.base.code.Base256
import com.mingliqiye.utils.base.code.Base64
import com.mingliqiye.utils.base.code.Base91


@Deprecated(
    "重命名", replaceWith = ReplaceWith(
        expression = "Base10", imports = ["com.mingliqiye.utils.base.code"]
    )
)
val BASE10: BaseCodec
    get() = Base10

@Deprecated(
    "重命名", replaceWith = ReplaceWith(
        expression = "Base16", imports = ["com.mingliqiye.utils.base.code"]
    )
)
val BASE16: BaseCodec
    get() = Base16

@Deprecated(
    "重命名", replaceWith = ReplaceWith(
        expression = "Base64", imports = ["com.mingliqiye.utils.base.code"]
    )
)
val BASE64: BaseCodec
    get() = Base64

@Deprecated(
    "重命名", replaceWith = ReplaceWith(
        expression = "Base91", imports = ["com.mingliqiye.utils.base.code"]
    )
)
val BASE91: BaseCodec
    get() = Base91

@Deprecated(
    "重命名", replaceWith = ReplaceWith(
        expression = "Base256", imports = ["com.mingliqiye.utils.base.code"]
    )
)
val BASE256: BaseCodec
    get() = Base256
