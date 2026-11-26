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
 * CurrentFile NetworkAddress.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import java.io.Serializable
import java.net.Inet6Address
import java.net.InetAddress
import java.net.UnknownHostException
import java.nio.ByteBuffer

/**
 * 网络地址，表示一个 IPv4/IPv6 地址，或一个已解析的域名。
 *
 * ### 创建方式
 * - [of]：接受 IP 或域名；域名会立即解析为 IP；
 * - [ofIpv4]：从 4 字节数组 / [ByteBuffer] 创建 IPv4 地址；
 * - [of]（[InetAddress] 重载）：从 JDK 地址对象创建。
 *
 * ### 不变性
 * 实例创建后地址、类型和域名信息不再变化；实例可作为 Map key 或集合元素使用。
 *
 * @see NetworkEndpoint
 * @see NetworkPort
 */
class NetworkAddress private constructor(domip: String) : Serializable {

	companion object {
		/** IPv4 版本标识，值为 4。 */
		const val IPV4 = 4

		/** IPv6 版本标识，值为 6。 */
		const val IPV6 = 6

		private const val serialVersionUID = 1L

		/**
		 * 创建 [NetworkAddress]。
		 *
		 * 如果输入是合法 IP 则直接使用；否则按域名解析出第一个地址。
		 *
		 * @param domip IP 或域名
		 * @return 网络地址实例
		 * @throws NetworkException 输入为空、不是合法 IP 且域名无法解析时抛出
		 */
		@JvmStatic
		fun of(domip: String): NetworkAddress {
			return NetworkAddress(domip)
		}

		/**
		 * 从 [ByteBuffer] 读取 4 字节创建 IPv4 地址。
		 *
		 * @param byteBuffer 包含至少 4 字节可读数据的缓冲区
		 * @return IPv4 网络地址
		 * @throws NetworkException 可读数据不足 4 字节时抛出
		 */
		@JvmStatic
		fun ofIpv4(byteBuffer: ByteBuffer): NetworkAddress {
			if (byteBuffer.remaining() < 4) {
				throw NetworkException("IPv4 address requires 4 bytes, but only ${byteBuffer.remaining()} available")
			}
			val byteArray = ByteArray(4)
			byteBuffer.get(byteArray)
			return ofIpv4(byteArray)
		}

		/**
		 * 从 4 字节数组创建 IPv4 地址。
		 *
		 * @param byteArray IPv4 地址字节数组，长度必须为 4
		 * @return IPv4 网络地址
		 * @throws NetworkException 长度不为 4 时抛出
		 */
		@JvmStatic
		fun ofIpv4(byteArray: ByteArray): NetworkAddress {
			if (byteArray.size != 4) {
				throw NetworkException("IPv4 address requires exactly 4 bytes, but was ${byteArray.size}")
			}
			return of(byteArray.joinToString(".") { (it.toInt() and 0xFF).toString() })
		}

		/**
		 * 通过 [InetAddress] 创建 [NetworkAddress]。
		 *
		 * @param inetAddress JDK 地址对象
		 * @return 网络地址实例
		 * @throws NetworkException 地址字符串无法识别时抛出
		 */
		@JvmStatic
		fun of(inetAddress: InetAddress): NetworkAddress {
			return NetworkAddress(inetAddress.hostAddress)
		}

		/**
		 * 解析域名并返回第一个 IP 地址。
		 *
		 * @param domain 域名
		 * @return 解析出的第一个 IP
		 * @throws UnknownHostException 域名无法解析时抛出
		 */
		@JvmStatic
		@Throws(UnknownHostException::class)
		fun getHostIp(domain: String): String {
			val value = domain.trim()
			if (value.isEmpty()) {
				throw UnknownHostException("domain must not be blank")
			}
			val addresses = InetAddress.getAllByName(value)
			return addresses.first().hostAddress
		}

		/**
		 * 判断字符串是 IPv4 还是 IPv6。
		 *
		 * IPv6 使用 JDK 的地址解析器校验，支持压缩形式、IPv4 映射地址和
		 * 带作用域的地址；IPv4 使用逐段校验，支持 4 段 0-255。
		 *
		 * @param ip 待检测字符串
		 * @return [IPV4] 或 [IPV6]
		 * @throws NetworkException 不是合法 IP 地址时抛出
		 */
		@JvmStatic
		fun testIp(ip: String?): Int {
			val value = ip?.trim()?.removeSurrounding("[", "]")
			if (value.isNullOrEmpty()) {
				throw NetworkException("IP address must not be null or blank")
			}

			if (value.contains(':')) {
				return try {
					InetAddress.getByName(value)
					IPV6
				} catch (e: UnknownHostException) {
					throw NetworkException("[$value] is not a valid IPv6 address", e)
				}
			}

			if (isValidIpv4(value)) {
				return IPV4
			}
			throw NetworkException("[$value] is not a valid IPv4 or IPv6 address")
		}

		/**
		 * 校验 IPv4 四个十进制段是否都在 0-255 内。
		 *
		 * @param value IPv4 字符串
		 * @return 合法返回 `true`
		 */
		private fun isValidIpv4(value: String): Boolean {
			val parts = value.split('.')
			if (parts.size != 4) {
				return false
			}
			return parts.all { part ->
				part.isNotEmpty() &&
						part.length <= 3 &&
						part.all(Char::isDigit) &&
						part.toInt() in 0..255
			}
		}
	}

	/**
	 * IP 版本：4 或 6。
	 */
	var iPv: Int = 0
		private set

	/**
	 * 解析后的 IP 地址；域名输入时会替换为解析结果。
	 */
	var ip: String? = null
		private set

	/**
	 * 原始域名；IP 输入时为 `null`。
	 */
	private var domain: String? = null

	/**
	 * 是否由域名解析得到。
	 */
	private var isdom = false

	init {
		val value = domip.trim().removeSurrounding("[", "]")
		if (value.isEmpty()) {
			throw NetworkException("address must not be blank")
		}

		val ipVersion = try {
			testIp(value)
		} catch (_: NetworkException) {
			null
		}

		if (ipVersion != null) {
			iPv = ipVersion
			ip = value
		} else {
			try {
				val addresses = InetAddress.getAllByName(value)
				val resolved = addresses.first()
				iPv = testIp(resolved.hostAddress)
				ip = resolved.hostAddress
				domain = value
				isdom = true
			} catch (e: UnknownHostException) {
				throw NetworkException("[$value] is neither a valid IP nor a resolvable domain", e)
			}
		}
	}

	/**
	 * 是否为 IPv4 地址。
	 *
	 * @return IPv4 返回 `true`
	 */
	fun isIpv4(): Boolean = iPv == IPV4

	/**
	 * 是否为 IPv6 地址。
	 *
	 * @return IPv6 返回 `true`
	 */
	fun isIpv6(): Boolean = iPv == IPV6

	/**
	 * 是否由域名解析而来。
	 *
	 * @return 域名输入返回 `true`
	 */
	fun isDomain(): Boolean = isdom

	/**
	 * 获取原始域名；IP 输入时返回 `null`。
	 *
	 * @return 域名或 `null`
	 */
	fun getDomain(): String? = domain

	/**
	 * 将 IPv4 地址转换为 4 字节数组。
	 *
	 * @return IPv4 字节数组
	 * @throws NetworkException 当前地址不是 IPv4 时抛出
	 */
	fun toIpv4ByteArray(): ByteArray {
		if (!isIpv4()) {
			throw NetworkException("[$ip] is not an IPv4 address")
		}
		return ip!!.split(".").map { it.toInt().toByte() }.toByteArray()
	}

	/**
	 * 将 IPv4 地址写入 [ByteBuffer]。
	 *
	 * @param byteBuffer 目标缓冲区，剩余空间至少 4 字节
	 * @return 当前 [ByteBuffer]，便于链式调用
	 * @throws NetworkException 当前地址不是 IPv4 时抛出
	 */
	fun writeIpv4ToByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
		return byteBuffer.put(toIpv4ByteArray())
	}

	/**
	 * 转换为 [InetAddress]。
	 *
	 * @return JDK 地址对象
	 * @throws NetworkException 解析失败时抛出
	 */
	fun toInetAddress(): InetAddress {
		return try {
			InetAddress.getByName(ip ?: domain)
		} catch (e: UnknownHostException) {
			throw NetworkException("cannot resolve [$ip]", e)
		}
	}

	/**
	 * 判断两个地址是否指向同一个 IP 和版本。
	 */
	override fun equals(other: Any?): Boolean {
		return other is NetworkAddress && ip == other.ip && iPv == other.iPv
	}

	override fun hashCode(): Int {
		return 31 * (ip?.hashCode() ?: 0) + iPv
	}

	override fun toString(): String {
		return if (isdom) {
			"NetworkAddress(IP='$ip',type='$iPv',domain='$domain')"
		} else {
			"NetworkAddress(IP='$ip',type='$iPv')"
		}
	}
}
