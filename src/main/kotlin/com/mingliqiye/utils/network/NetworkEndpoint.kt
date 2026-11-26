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
 * CurrentFile NetworkEndpoint.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import java.io.Serializable
import java.net.InetSocketAddress
import java.net.SocketAddress
import java.nio.ByteBuffer

/**
 * IP/域名与端口的组合，同时继承 [InetSocketAddress]。
 *
 * 支持以下创建方式：
 * - `NetworkEndpoint.of("host:port")`
 * - `NetworkEndpoint.of("[IPv6]:port")`
 * - `NetworkEndpoint.of("host", port)`
 * - 从 6 字节 IPv4+端口数据创建
 *
 * ### 字符串形式
 * IPv4/域名输出为 `host:port`；IPv6 输出为 `[address]:port`，便于再次解析。
 *
 * @author MingLiPro
 * @see InetSocketAddress
 */
class NetworkEndpoint private constructor(
	/** 网络地址。 */
	val networkAddress: NetworkAddress,
	/** 网络端口。 */
	val networkPort: NetworkPort,
) : Serializable, InetSocketAddress(networkAddress.toInetAddress(), networkPort.port) {

	companion object {

		private const val serialVersionUID = 1L

		/**
		 * 根据 [NetworkAddress] 与 [NetworkPort] 创建实例。
		 *
		 * @param address 网络地址
		 * @param port 网络端口
		 * @return 网络端点
		 */
		@JvmStatic
		fun of(address: NetworkAddress, port: NetworkPort): NetworkEndpoint {
			return NetworkEndpoint(address, port)
		}

		/**
		 * 根据 [InetSocketAddress] 创建实例。
		 *
		 * @param address InetSocketAddress
		 * @return 网络端点
		 * @throws NetworkException 地址不是 InetSocketAddress 或地址无法解析时抛出
		 */
		@JvmStatic
		fun of(address: SocketAddress): NetworkEndpoint {
			if (address !is InetSocketAddress) {
				throw NetworkException("${address.javaClass.name} cannot be converted to NetworkEndpoint")
			}
			return NetworkEndpoint(
				NetworkAddress.of(address.hostString),
				NetworkPort(address.port),
			)
		}

		/**
		 * 根据主机名/IP 和端口创建实例。
		 *
		 * @param host 主机名或 IP
		 * @param port 端口号
		 * @return 网络端点
		 */
		@JvmStatic
		fun of(host: String, port: Int): NetworkEndpoint {
			return NetworkEndpoint(NetworkAddress.of(host), NetworkPort(port))
		}

		/**
		 * 从 6 字节数据创建 IPv4 端点。
		 *
		 * 前 4 字节为 IPv4，后 2 字节为大端序端口。
		 *
		 * @param byteArray 6 字节数组
		 * @return 网络端点
		 * @throws NetworkException 长度不为 6 时抛出
		 */
		@JvmStatic
		fun ofIpv4(byteArray: ByteArray): NetworkEndpoint {
			if (byteArray.size != 6) {
				throw NetworkException("IPv4 endpoint requires exactly 6 bytes, but was ${byteArray.size}")
			}
			return NetworkEndpoint(
				NetworkAddress.ofIpv4(byteArray.copyOfRange(0, 4)),
				NetworkPort.of(byteArray.copyOfRange(4, 6)),
			)
		}

		/**
		 * 从 [ByteBuffer] 读取 IPv4 地址和端口创建端点。
		 *
		 * @param byteBuffer 至少 6 字节可读数据
		 * @return 网络端点
		 * @throws NetworkException 可读数据不足 6 字节时抛出
		 */
		@JvmStatic
		fun ofIpv4(byteBuffer: ByteBuffer): NetworkEndpoint {
			if (byteBuffer.remaining() < 6) {
				throw NetworkException("IPv4 endpoint requires 6 bytes, but only ${byteBuffer.remaining()} available")
			}
			return NetworkEndpoint(
				NetworkAddress.ofIpv4(byteBuffer),
				NetworkPort.of(byteBuffer),
			)
		}

		/**
		 * 根据 `host:port` 或 `[IPv6]:port` 字符串创建端点。
		 *
		 * @param s 端点字符串
		 * @return 网络端点
		 * @throws NetworkException 格式非法时抛出
		 */
		@JvmStatic
		fun of(s: String): NetworkEndpoint {
			val value = s.trim()
			if (value.isEmpty()) {
				throw NetworkException("endpoint must not be blank")
			}

			if (value.startsWith("[")) {
				val close = value.indexOf(']')
				if (close <= 1 || close + 1 >= value.length || value[close + 1] != ':') {
					throw NetworkException("invalid IPv6 endpoint: [$value]")
				}
				val host = value.substring(1, close)
				val port = parsePort(value.substring(close + 2))
				return of(host, port)
			}

			val lastColon = value.lastIndexOf(':')
			if (lastColon <= 0 || lastColon == value.length - 1) {
				throw NetworkException("endpoint must be in host:port format: [$value]")
			}
			val host = value.substring(0, lastColon)
			if (host.contains(':')) {
				throw NetworkException("IPv6 endpoint must use [address]:port format: [$value]")
			}
			return of(host, parsePort(value.substring(lastColon + 1)))
		}

		/**
		 * 将 [SocketAddress] 转换为 [NetworkEndpoint]。
		 */
		val SocketAddress.networkEndpoint: NetworkEndpoint
			get() = of(this)

		/**
		 * 获取 [SocketAddress] 的 `host:port` 字符串。
		 */
		val SocketAddress.hostPortString: String
			get() = networkEndpoint.toHostPortString()

		/**
		 * 兼容旧名称：将 [SocketAddress] 转换为 [NetworkEndpoint]。
		 */
		val SocketAddress.networkAddress: NetworkEndpoint
			get() = of(this)

		/**
		 * 解析端口字符串。
		 *
		 * @param value 端口文本
		 * @return 端口号
		 * @throws NetworkException 非数字或越界时抛出
		 */
		private fun parsePort(value: String): Int {
			return value.toIntOrNull()
				?: throw NetworkException("invalid port: [$value]")
		}
	}

	/**
	 * 转换为 [InetSocketAddress]。
	 *
	 * @return InetSocketAddress
	 */
	fun toInetSocketAddress(): InetSocketAddress {
		return InetSocketAddress(networkAddress.toInetAddress(), networkPort.port)
	}

	/**
	 * 转换为 `host:port` 字符串；IPv6 使用 `[address]:port` 形式。
	 *
	 * @return 端点字符串
	 */
	fun toHostPortString(): String {
		val host = networkAddress.ip ?: ""
		return if (networkAddress.isIpv6()) {
			"[$host]:${networkPort.port}"
		} else {
			"$host:${networkPort.port}"
		}
	}

	/**
	 * 获取主机名或 IP 字符串。
	 *
	 * @return 主机名或 IP
	 */
	fun host(): String = networkAddress.ip ?: ""

	/**
	 * 获取端口号。
	 *
	 * @return 端口号
	 */
	fun port(): Int = networkPort.port

	/**
	 * 将 IPv4 地址与端口转换为 6 字节数组。
	 *
	 * @return 4 字节 IPv4 + 2 字节端口
	 * @throws NetworkException 当前地址不是 IPv4 时抛出
	 */
	fun toIpv4ByteArray(): ByteArray {
		return networkAddress.toIpv4ByteArray() + networkPort.toByteArray()
	}

	/**
	 * 将 IPv4 地址与端口写入 [ByteBuffer]。
	 *
	 * @param byteBuffer 目标缓冲区
	 * @return 当前缓冲区
	 * @throws NetworkException 当前地址不是 IPv4 或空间不足时抛出
	 */
	fun writeIpv4ToByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
		networkAddress.writeIpv4ToByteBuffer(byteBuffer)
		networkPort.writeToByteBuffer(byteBuffer)
		return byteBuffer
	}

	/**
	 * 兼容旧名称的字节写入方法。
	 *
	 * @param byteBuffer 目标缓冲区
	 * @return 当前缓冲区
	 */
	@Deprecated("Use writeIpv4ToByteBuffer instead", ReplaceWith("writeIpv4ToByteBuffer(byteBuffer)"))
	fun writeIpv4toByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
		return writeIpv4ToByteBuffer(byteBuffer)
	}

	override fun toString(): String {
		return "NetworkEndpoint(IP=${networkAddress.ip},Port=${networkPort.port})"
	}
}
