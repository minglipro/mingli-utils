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
 * LastUpdate 2026-02-09 19:54:38
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

import com.mingliqiye.utils.base.code.Base10
import com.mingliqiye.utils.base.code.Base16
import com.mingliqiye.utils.base.code.Base2
import com.mingliqiye.utils.base.code.Base256
import com.mingliqiye.utils.base.code.Base64
import com.mingliqiye.utils.base.code.Base91

enum class BaseType(val baseCodec: BaseCodec) : BaseCodec {

    BASE2(Base2),
    BASE10(Base10),
    BASE16(Base16),
    BASE64(Base64),
    BASE91(Base91),
    BASE256(Base256);

    override fun encode(bytes: ByteArray) = baseCodec.encode(bytes)
    override fun decode(string: String) = baseCodec.decode(string)

}
