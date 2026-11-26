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
 * ModuleName mingli-utils.test
 * CurrentFile TestNetwork.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.network.NetworkAddress
import com.mingliqiye.utils.network.NetworkEndpoint
import com.mingliqiye.utils.network.NetworkException
import com.mingliqiye.utils.network.NetworkPort
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.net.InetAddress
import java.nio.ByteBuffer

/**
 * network 包的地址、端口和端点测试。
 */
class TestNetwork {

	/**
	 * 验证 IPv4 解析、字节转换和值相等。
	 */
	@Test
	fun testIpv4Address() {
		val address = NetworkAddress.of("192.168.1.10")
		assertTrue(address.isIpv4())
		assertFalse(address.isIpv6())
		assertEquals("192.168.1.10", address.ip)
		assertArrayEquals(
			byteArrayOf(192.toByte(), 168.toByte(), 1, 10),
			address.toIpv4ByteArray()
		)

		val same = NetworkAddress.ofIpv4(byteArrayOf(192.toByte(), 168.toByte(), 1, 10))
		assertEquals(address, same)
		assertEquals(address.hashCode(), same.hashCode())
	}

	/**
	 * 验证非法 IPv4 与 IPv6 校验。
	 */
	@Test
	fun testIpValidation() {
		assertEquals(NetworkAddress.IPV4, NetworkAddress.testIp("127.0.0.1"))
		assertEquals(NetworkAddress.IPV6, NetworkAddress.testIp("::1"))
		assertEquals(NetworkAddress.IPV6, NetworkAddress.testIp("2001:db8::1"))

		assertThrows(NetworkException::class.java) { NetworkAddress.testIp("999.1.1.1") }
		assertThrows(NetworkException::class.java) { NetworkAddress.testIp("1.2.3") }
		assertThrows(NetworkException::class.java) { NetworkAddress.testIp("gggg::1") }
		assertThrows(NetworkException::class.java) { NetworkAddress.testIp(null) }
	}

	/**
	 * 验证 IPv6 地址和方括号输入。
	 */
	@Test
	fun testIpv6Address() {
		val address = NetworkAddress.of("[2001:db8::1]")
		assertTrue(address.isIpv6())
		assertEquals("2001:db8::1", address.ip)
		assertEquals(InetAddress.getByName("2001:db8::1"), address.toInetAddress())
	}

	/**
	 * 验证域名解析。
	 */
	@Test
	fun testDomainAddress() {
		val address = NetworkAddress.of("localhost")
		assertTrue(address.isDomain())
		assertEquals("localhost", address.getDomain())
		assertTrue(address.isIpv4() || address.isIpv6())
	}

	/**
	 * 验证 IPv4 字节数组和 ByteBuffer 读取。
	 */
	@Test
	fun testIpv4ByteBuffers() {
		val buffer = ByteBuffer.wrap(byteArrayOf(10, 0, 0, 1))
		assertEquals("10.0.0.1", NetworkAddress.ofIpv4(buffer).ip)

		assertThrows(NetworkException::class.java) {
			NetworkAddress.ofIpv4(ByteArray(3))
		}
		assertThrows(NetworkException::class.java) {
			NetworkAddress.ofIpv4(ByteBuffer.allocate(3))
		}
	}

	/**
	 * 验证端口范围、字节序和比较。
	 */
	@Test
	fun testNetworkPort() {
		val port = NetworkPort(8080)
		assertArrayEquals(byteArrayOf(0x1F, 0x90.toByte()), port.toByteArray())
		assertEquals(8080, NetworkPort.of(byteArrayOf(0x1F, 0x90.toByte())).port)
		assertEquals(port, NetworkPort.of(8080))
		assertTrue(NetworkPort(80) < NetworkPort(443))

		assertThrows(NetworkException::class.java) { NetworkPort(-1) }
		assertThrows(NetworkException::class.java) { NetworkPort(65536) }
		assertThrows(NetworkException::class.java) { NetworkPort.of(ByteArray(1)) }
		assertThrows(NetworkException::class.java) { NetworkPort.of(ByteBuffer.allocate(1)) }
	}

	/**
	 * 验证 IPv4 端点字符串、字节数组和 ByteBuffer。
	 */
	@Test
	fun testIpv4Endpoint() {
		val endpoint = NetworkEndpoint.of("127.0.0.1:8080")
		assertEquals("127.0.0.1:8080", endpoint.toHostPortString())
		assertEquals(8080, endpoint.port())
		assertEquals("127.0.0.1", endpoint.host())
		assertEquals(8080, endpoint.toInetSocketAddress().port)

		val bytes = endpoint.toIpv4ByteArray()
		assertArrayEquals(endpoint.toIpv4ByteArray(), NetworkEndpoint.ofIpv4(bytes).toIpv4ByteArray())

		val buffer = ByteBuffer.wrap(bytes)
		assertEquals(endpoint.toHostPortString(), NetworkEndpoint.ofIpv4(buffer).toHostPortString())

		assertThrows(NetworkException::class.java) { NetworkEndpoint.of("127.0.0.1") }
		assertThrows(NetworkException::class.java) { NetworkEndpoint.of("127.0.0.1:not-a-port") }
		assertThrows(NetworkException::class.java) { NetworkEndpoint.ofIpv4(ByteArray(5)) }
	}

	/**
	 * 验证 IPv6 端点的方括号格式。
	 */
	@Test
	fun testIpv6Endpoint() {
		val endpoint = NetworkEndpoint.of("[2001:db8::1]:443")
		assertEquals("[2001:db8::1]:443", endpoint.toHostPortString())
		assertEquals("2001:db8::1", endpoint.host())

		val parsed = NetworkEndpoint.of(endpoint.toHostPortString())
		assertEquals(endpoint.toHostPortString(), parsed.toHostPortString())

		assertThrows(NetworkException::class.java) { NetworkEndpoint.of("2001:db8::1:443") }
	}

	/**
	 * 验证直接使用 NetworkAddress/NetworkPort 创建端点。
	 */
	@Test
	fun testEndpointFactory() {
		val endpoint = NetworkEndpoint.of(
			NetworkAddress.of("10.0.0.1"),
			NetworkPort(9000)
		)
		assertEquals("10.0.0.1:9000", endpoint.toHostPortString())
	}
}
