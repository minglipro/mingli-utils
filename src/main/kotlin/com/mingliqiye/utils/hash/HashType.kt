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
 * CurrentFile HashType.kt
 * LastUpdate 2026-11-18 18:48:01
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.hash

import com.mingliqiye.utils.hash.code.HashCodec
import java.io.InputStream

/**
 * 哈希算法类型枚举。
 *
 * 每个枚举项持有一个哈希编解码器的工厂函数，枚举本身实现了 [HashCodec]，
 * 可直接作为编解码器使用，哈希操作委托给对应的编解码器实例。
 *
 * @param codec 哈希编解码器的工厂函数，每次访问 [code] 时调用以创建实例
 */
enum class HashType(private val codec: () -> HashCodec) : HashCodec {
	/** MD2 哈希（输出 128 位，已过时，仅用于兼容遗留系统）。 */
	MD2(::MD2),
	/** MD5 哈希（输出 128 位，存在碰撞漏洞，不得用于安全场景）。 */
	MD5(::MD5),
	/** SHA-1 哈希（输出 160 位，存在碰撞攻击，不得用于安全场景）。 */
	SHA1(::SHA1),
	/** SHA-224 哈希（SHA-2 家族，输出 224 位）。 */
	SHA224(::SHA224),
	/** SHA-256 哈希（SHA-2 家族，输出 256 位）。 */
	SHA256(::SHA256),
	/** SHA-384 哈希（SHA-2 家族，输出 384 位）。 */
	SHA384(::SHA384),
	/** SHA-512 哈希（SHA-2 家族，输出 512 位）。 */
	SHA512(::SHA512),
	/** SHA3-224 哈希（SHA-3 家族，输出 224 位）。 */
	SHA3224(::SHA3224),
	/** SHA3-256 哈希（SHA-3 家族，输出 256 位）。 */
	SHA3256(::SHA3256),
	/** SHA3-384 哈希（SHA-3 家族，输出 384 位）。 */
	SHA3384(::SHA3384),
	/** SHA3-512 哈希（SHA-3 家族，输出 512 位）。 */
	SHA3512(::SHA3512),
	/** SHA-512/224 哈希（SHA-2 家族，输出 224 位）。 */
	SHA512224(::SHA512224),
	/** SHA-512/256 哈希（SHA-2 家族，输出 256 位）。 */
	SHA512256(::SHA512256);


	/**
	 * 获取当前类型对应的哈希编解码器实例（每次访问都会通过工厂函数新建）。
	 */
	val code get() = codec()

	/**
	 * 计算输入流内容的哈希值，委托给 [code] 对应的编解码器。
	 *
	 * @param input 待计算哈希的输入流
	 * @return 哈希结果字节数组
	 */
	override fun hash(input: InputStream): ByteArray {
		return code.hash(input)
	}


}
