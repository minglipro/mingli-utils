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
 * CurrentFile NetworkPort.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import java.io.Serializable
import java.nio.ByteBuffer

/**
 * 网络端口，取值范围 0-65535。
 *
 * 实例不可变，可作为 Map key 或集合元素使用；字节序列化统一使用大端序。
 *
 * @see NetworkEndpoint
 */
class NetworkPort : Serializable, Comparable<NetworkPort> {

	/** 端口号，取值范围 0-65535。 */
	val port: Int

	/**
	 * 创建端口实例。
	 *
	 * @param port 端口号，必须在 0-65535 之间
	 * @throws NetworkException 端口号越界时抛出
	 */
	constructor(port: Int) {
		testPort(port)
		this.port = port
	}

	/**
	 * 将端口号转换为 2 字节大端序数组。
	 *
	 * @return 长度为 2 的字节数组
	 */
	fun toByteArray(): ByteArray {
		return byteArrayOf(
			(port shr 8 and 0xFF).toByte(),
			(port and 0xFF).toByte(),
		)
	}

	/**
	 * 将端口号以 2 字节大端序写入 [ByteBuffer]。
	 *
	 * @param byteBuffer 目标缓冲区，剩余空间至少 2 字节
	 * @return 当前缓冲区，便于链式调用
	 * @throws NetworkException 缓冲区剩余空间不足时抛出
	 */
	fun writeToByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
		if (byteBuffer.remaining() < 2) {
			throw NetworkException("port requires 2 bytes, but only ${byteBuffer.remaining()} available")
		}
		return byteBuffer.put(toByteArray())
	}

	override fun compareTo(other: NetworkPort): Int = port.compareTo(other.port)

	override fun equals(other: Any?): Boolean = other is NetworkPort && port == other.port

	override fun hashCode(): Int = port

	override fun toString(): String = port.toString()

	companion object {

		private const val serialVersionUID = 1L

		/**
		 * 创建 [NetworkPort]。
		 *
		 * @param port 端口号
		 * @return 端口实例
		 * @throws NetworkException 端口号越界时抛出
		 */
		@JvmStatic
		fun of(port: Int): NetworkPort = NetworkPort(port)

		/**
		 * 从字节数组前 2 字节创建端口（大端序）。
		 *
		 * @param byteArray 至少 2 字节的数组
		 * @return 端口实例
		 * @throws NetworkException 长度不足时抛出
		 */
		@JvmStatic
		fun of(byteArray: ByteArray): NetworkPort {
			if (byteArray.size < 2) {
				throw NetworkException("port requires 2 bytes, but was ${byteArray.size}")
			}
			val port = ((byteArray[0].toInt() and 0xFF) shl 8) or (byteArray[1].toInt() and 0xFF)
			return of(port)
		}

		/**
		 * 从 [ByteBuffer] 读取 2 字节创建端口（大端序）。
		 *
		 * @param byteBuffer 至少 2 字节可读数据的缓冲区
		 * @return 端口实例
		 * @throws NetworkException 可读数据不足时抛出
		 */
		@JvmStatic
		fun of(byteBuffer: ByteBuffer): NetworkPort {
			if (byteBuffer.remaining() < 2) {
				throw NetworkException("port requires 2 bytes, but only ${byteBuffer.remaining()} available")
			}
			val byteArray = ByteArray(2)
			byteBuffer.get(byteArray)
			return of(byteArray)
		}

		/**
		 * 校验端口号是否在 0-65535 之间。
		 *
		 * @param port 端口号
		 * @throws NetworkException 端口号越界时抛出
		 */
		@JvmStatic
		fun testPort(port: Int) {
			if (port !in 0..65535) {
				throw NetworkException("[$port] is not a valid port, expected 0-65535")
			}
		}
	}
}
