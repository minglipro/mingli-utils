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
 * LastUpdate 2026-11-16 14:21:51
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

import com.mingliqiye.utils.base.code.BASE10 as CODE_BASE10
import com.mingliqiye.utils.base.code.BASE16 as CODE_BASE16
import com.mingliqiye.utils.base.code.BASE2 as CODE_BASE2
import com.mingliqiye.utils.base.code.BASE256 as CODE_BASE256
import com.mingliqiye.utils.base.code.BASE64 as CODE_BASE64
import com.mingliqiye.utils.base.code.BASE64_NO_PADDING as CODE_BASE64_NO_PADDING
import com.mingliqiye.utils.base.code.BASE64_URL as CODE_BASE64_URL
import com.mingliqiye.utils.base.code.BASE91 as CODE_BASE91

enum class BaseType(private val baseCodec: () -> BaseCodec) : BaseCodec {

	BASE2(::CODE_BASE2),
	BASE10(::CODE_BASE10),
	BASE16(::CODE_BASE16),
	BASE64(::CODE_BASE64),
	BASE64_URL(::CODE_BASE64_URL),
	BASE64_NO_PADDING(::CODE_BASE64_NO_PADDING),
	BASE91(::CODE_BASE91),
	BASE256(::CODE_BASE256);

	val codec
		get() = baseCodec()

	override fun encode(bytes: ByteArray) = codec.encode(bytes)
	override fun decode(string: String) = codec.decode(string)

}
