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
 * CurrentFile HashCodec.kt
 * LastUpdate 2026-11-18 18:36:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.hash.code

import com.mingliqiye.utils.base.BaseType
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.security.MessageDigest

/**
 * 哈希编解码器接口。
 *
 * 实现类只需重写 [hash]（InputStream 版本）一个方法，
 * 其余字节数组、字符串、文件、路径的重载以及十六进制输出、
 * 哈希校验均由接口提供默认实现。
 *
 * 使用示例（以 SHA-256 为例）：
 * ```
 * val sha256 = Sha256Codec()
 * val hex = sha256.hashHex("hello")
 * val ok = sha256.verifyHash("hello", hex)
 * ```
 */
interface HashCodec {

	/**
	 * 计算输入流内容的哈希值（唯一需要实现的方法）。
	 *
	 * 实现不需要关闭输入流，由调用方负责流的生命周期。
	 *
	 * @param input 待计算哈希的输入流
	 * @return 哈希结果字节数组
	 */
	fun hash(input: InputStream): ByteArray

	/**
	 * 计算字节数组的哈希值。
	 *
	 * @param bytes 待计算哈希的字节数组
	 * @return 哈希结果字节数组
	 */
	fun hash(bytes: ByteArray): ByteArray = hash(bytes.inputStream())

	/**
	 * 计算字符串的哈希值。
	 *
	 * @param string 待计算哈希的字符串
	 * @param charset 字符串编码字符集，默认 UTF-8
	 * @return 哈希结果字节数组
	 */
	fun hash(string: String, charset: Charset = Charsets.UTF_8): ByteArray = hash(string.toByteArray(charset))

	/**
	 * 计算文件内容的哈希值。
	 *
	 * @param file 待计算哈希的文件
	 * @return 哈希结果字节数组
	 */
	fun hash(file: File): ByteArray = file.inputStream().use { hash(it) }

	/**
	 * 计算路径指向文件内容的哈希值。
	 *
	 * @param path 待计算哈希的文件路径
	 * @return 哈希结果字节数组
	 */
	fun hash(path: Path): ByteArray = Files.newInputStream(path).use { hash(it) }

	/**
	 * 计算输入流内容的哈希值并以小写十六进制字符串返回。
	 *
	 * @param input 待计算哈希的输入流
	 * @return 十六进制格式的哈希字符串
	 */
	fun hashHex(input: InputStream): String = BaseType.BASE16.encode(hash(input))

	/**
	 * 计算字节数组的哈希值并以小写十六进制字符串返回。
	 *
	 * @param bytes 待计算哈希的字节数组
	 * @return 十六进制格式的哈希字符串
	 */
	fun hashHex(bytes: ByteArray): String = BaseType.BASE16.encode(hash(bytes))

	/**
	 * 计算字符串的哈希值并以小写十六进制字符串返回。
	 *
	 * @param string 待计算哈希的字符串
	 * @param charset 字符串编码字符集，默认 UTF-8
	 * @return 十六进制格式的哈希字符串
	 */
	fun hashHex(string: String, charset: Charset = Charsets.UTF_8): String =
		BaseType.BASE16.encode(hash(string, charset))

	/**
	 * 计算文件内容的哈希值并以小写十六进制字符串返回。
	 *
	 * @param file 待计算哈希的文件
	 * @return 十六进制格式的哈希字符串
	 */
	fun hashHex(file: File): String = BaseType.BASE16.encode(hash(file))

	/**
	 * 计算路径指向文件内容的哈希值并以小写十六进制字符串返回。
	 *
	 * @param path 待计算哈希的文件路径
	 * @return 十六进制格式的哈希字符串
	 */
	fun hashHex(path: Path): String = BaseType.BASE16.encode(hash(path))

	/**
	 * 校验输入流内容的哈希值是否与期望值一致。
	 *
	 * 使用 [java.security.MessageDigest.isEqual] 进行常量时间比较，避免时序攻击。
	 *
	 * @param input 待校验的输入流
	 * @param hashed 期望的哈希值字节数组
	 * @return 一致返回 true，否则返回 false
	 */
	fun verifyHash(input: InputStream, hashed: ByteArray): Boolean = MessageDigest.isEqual(hash(input), hashed)

	/**
	 * 校验字节数组的哈希值是否与期望值一致。
	 *
	 * @param bytes 待校验的字节数组
	 * @param hashed 期望的哈希值字节数组
	 * @return 一致返回 true，否则返回 false
	 */
	fun verifyHash(bytes: ByteArray, hashed: ByteArray): Boolean = MessageDigest.isEqual(hash(bytes), hashed)

	/**
	 * 校验字符串的哈希值是否与期望值一致。
	 *
	 * @param string 待校验的字符串
	 * @param hashed 期望的哈希值字节数组
	 * @param charset 字符串编码字符集，默认 UTF-8
	 * @return 一致返回 true，否则返回 false
	 */
	fun verifyHash(string: String, hashed: ByteArray, charset: Charset = Charsets.UTF_8): Boolean =
		MessageDigest.isEqual(hash(string, charset), hashed)

	/**
	 * 校验字符串的哈希值是否与期望的十六进制字符串一致（忽略大小写）。
	 *
	 * @param string 待校验的字符串
	 * @param hashedHex 期望的十六进制哈希字符串
	 * @param charset 字符串编码字符集，默认 UTF-8
	 * @return 一致返回 true，否则返回 false
	 */
	fun verifyHash(string: String, hashedHex: String, charset: Charset = Charsets.UTF_8): Boolean =
		MessageDigest.isEqual(hash(string, charset), BaseType.BASE16.decode(hashedHex.lowercase()))

}
