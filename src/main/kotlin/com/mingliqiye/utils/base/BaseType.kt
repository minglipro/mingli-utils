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

/**
 * Base 编码类型枚举。
 *
 * 每个枚举项持有一个编解码器的工厂函数，枚举本身实现了 [BaseCodec]，
 * 可直接作为编解码器使用，编码与解码操作委托给对应的编解码器实例。
 *
 * @param baseCodec 编解码器的工厂函数，每次访问 [codec] 时调用以创建实例
 */
enum class BaseType(private val baseCodec: () -> BaseCodec) : BaseCodec {

	/** 二进制（Base2）编解码。 */
	BASE2(::CODE_BASE2),
	/** 十进制（Base10）编解码。 */
	BASE10(::CODE_BASE10),
	/** 十六进制（Base16）编解码。 */
	BASE16(::CODE_BASE16),
	/** 标准 Base64 编解码。 */
	BASE64(::CODE_BASE64),
	/** URL 安全的 Base64 编解码。 */
	BASE64_URL(::CODE_BASE64_URL),
	/** 无填充（不带末尾 '='）的 URL 安全 Base64 编解码。 */
	BASE64_NO_PADDING(::CODE_BASE64_NO_PADDING),
	/** Base91 编解码。 */
	BASE91(::CODE_BASE91),
	/** Base256 编解码。 */
	BASE256(::CODE_BASE256);

	/**
	 * 获取当前类型对应的编解码器实例（每次访问都会通过工厂函数新建）。
	 */
	val codec
		get() = baseCodec()

	override fun encode(bytes: ByteArray) = codec.encode(bytes)
	override fun decode(string: String) = codec.decode(string)

}
