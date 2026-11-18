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
 * CurrentFile MessageDigestCodec.kt
 * LastUpdate 2026-11-18 11:18:32
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.hash.code

import java.io.InputStream
import java.security.MessageDigest

/**
 * 基于 JDK [MessageDigest] 的哈希编解码器抽象基类。
 *
 * 以固定 8KB 缓冲区流式读取输入，内存占用恒定，适用于任意大小的文件与数据流。
 * 每次调用 [hash] 都会新建 [MessageDigest] 实例（其本身非线程安全），
 * 因此本类实例无状态、可安全地在多线程间共享。
 *
 * 遵循 [HashCodec] 契约：不关闭输入流，由调用方负责流的生命周期。
 *
 * 子类只需指定算法名称，也可借此扩展 JDK 默认提供者之外的算法
 * （如 BouncyCastle 提供的 SM3），前提是相应 [java.security.Provider] 已注册。
 *
 * @param algorithm [MessageDigest.getInstance] 所用的算法名称
 */
abstract class MessageDigestCodec(private val algorithm: String) : HashCodec {

	/**
	 * 以 8KB 缓冲区流式计算输入流内容的哈希值。
	 *
	 * 不关闭输入流；每次调用新建 [MessageDigest] 实例，线程安全。
	 *
	 * @param input 待计算哈希的输入流
	 * @return 哈希结果字节数组
	 * @throws java.security.NoSuchAlgorithmException 当前环境无指定算法的提供者时抛出
	 */
	override fun hash(input: InputStream): ByteArray {
		val digest = MessageDigest.getInstance(algorithm)
		val buffer = ByteArray(8192)
		while (true) {
			val n = input.read(buffer)
			if (n == -1) break
			digest.update(buffer, 0, n)
		}
		return digest.digest()
	}
}
