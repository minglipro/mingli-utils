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
 * CurrentFile ByteConvertible.kt
 * LastUpdate 2026-02-08 10:25:22
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.bytes

import java.io.OutputStream
import java.io.Serializable
import java.nio.ByteBuffer

/**
 * 可转换为字节数组的对象接口。
 *
 * 实现该接口的对象可以将自身序列化为字节数组，并支持写入输出流或 [ByteBuffer]。
 */
interface ByteConvertible : Serializable {

	/**
	 * 将当前对象转换为字节数组。
	 *
	 * @return 表示当前对象的字节数组
	 */
	fun toBytes(): ByteArray

	/**
	 * 将当前对象转换后的字节数组写入指定的输出流。
	 *
	 * @param outputStream 目标输出流
	 */
	fun writeToStream(outputStream: OutputStream) {
		outputStream.write(toBytes())
	}

	/**
	 * 将当前对象转换后的字节数组写入指定的 [ByteBuffer]。
	 *
	 * @param byteBuffer 目标缓冲区
	 */
	fun putToByteBuffer(byteBuffer: ByteBuffer) {
		byteBuffer.put(toBytes())
	}

	/**
	 * 伴生对象，提供面向输出流和缓冲区的便捷扩展函数。
	 */
	companion object {
		/**
		 * 将 [ByteConvertible] 对象写入当前输出流。
		 *
		 * @param byteConvertible 要写入的可转换对象
		 */
		fun OutputStream.write(byteConvertible: ByteConvertible) {
			byteConvertible.writeToStream(this)
		}

		/**
		 * 将 [ByteConvertible] 对象写入当前 [ByteBuffer]。
		 *
		 * @param byteConvertible 要写入的可转换对象
		 */
		fun ByteBuffer.put(byteConvertible: ByteConvertible) {
			byteConvertible.putToByteBuffer(this)
		}
	}
}
