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
 * LastUpdate 2026-03-12 10:08:42
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

enum class BaseType(val baseCodec: BaseCodec) : BaseCodec {

    BASE2(com.mingliqiye.utils.base.code.BASE2),
    BASE10(com.mingliqiye.utils.base.code.BASE10),
    BASE16(com.mingliqiye.utils.base.code.BASE16),
    BASE64(com.mingliqiye.utils.base.code.BASE64),
    BASE64URL(com.mingliqiye.utils.base.code.BASE64URL),
    BASE91(com.mingliqiye.utils.base.code.BASE91),
    BASE256(com.mingliqiye.utils.base.code.BASE256);

    override fun encode(bytes: ByteArray) = baseCodec.encode(bytes)
    override fun decode(string: String) = baseCodec.decode(string)

}
