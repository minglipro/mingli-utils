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
 * LastUpdate 2026-02-05 10:20:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import java.io.Serializable
import java.nio.ByteBuffer

/**
 * 网络端口类，封装合法的端口号（0-65535），并提供字节序列化能力。
 *
 * 实例创建后端口号不可变，线程安全。
 */
class NetworkPort : Serializable {
	/** 端口号，取值范围 0-65535 */
	val port: Int

	/**
	 * 构造端口实例，并校验端口号合法性
	 *
	 * @param port 端口号，必须在 0-65535 之间
	 * @throws NetworkException 端口号超出合法范围时抛出
	 */
	constructor(port: Int) {
		testPort(port)
		this.port = port
	}

	/**
	 * 将端口号转换为 2 字节数组（大端序，高字节在前）
	 *
	 * @return 长度为 2 的字节数组
	 */
	fun toByteArray(): ByteArray {
		val byteArray = ByteArray(2)
		byteArray[0] = (port shr 8 and 0xFF).toByte()
		byteArray[1] = (port and 0xFF).toByte()
		return byteArray
	}

	/**
	 * 将端口号以 2 字节写入指定的 ByteBuffer
	 *
	 * @param byteBuffer 目标字节缓冲区
	 * @return 写入后的缓冲区，便于链式调用
	 */
	fun writeToByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
		return byteBuffer.put(toByteArray())
	}

	/** 伴生对象，提供工厂方法与端口校验 */
	companion object {

		/**
		 * 创建NetworkPort实例
		 * @param port 端口号
		 * @return NetworkPort实例
		 */
		@JvmStatic
		fun of(port: Int): NetworkPort {
			return NetworkPort(port)
		}

		/**
		 * 从字节数组创建NetworkPort实例
		 * @param byteArray 包含端口信息的字节数组（长度至少为2）
		 * @return NetworkPort实例
		 */
		@JvmStatic
		fun of(byteArray: ByteArray): NetworkPort {
			// 将字节数组的前两个字节转换为端口号
			val port = ((byteArray[0].toInt() and 0xFF) shl 8) or (byteArray[1].toInt() and 0xFF)
			return of(port)
		}

		/**
		 * 从ByteBuffer创建NetworkPort实例
		 * @param byteBuffer 包含端口信息的ByteBuffer
		 * @return NetworkPort实例
		 */
		@JvmStatic
		fun of(byteBuffer: ByteBuffer): NetworkPort {
			val byteArray = ByteArray(2)
			byteBuffer.get(byteArray)
			return of(byteArray)
		}

		/**
		 * 校验端口号是否在合法范围（0-65535）内
		 *
		 * @param port 待校验的端口号
		 * @throws NetworkException 端口号非法时抛出
		 */
		@JvmStatic
		fun testPort(port: Int) {
			// 验证端口号范围是否在0-65535之间
			if (port !in 0..65535) {
				throw NetworkException("$port 不是正确的端口号")
			}
		}
	}
}
