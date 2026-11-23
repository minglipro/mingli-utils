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
 * CurrentFile SystemUtil.kt
 * LastUpdate 2026-11-23 07:50:35
 * UpdateUser MingLiPro
 */
@file:JvmName("SystemUtils")

package com.mingliqiye.utils.system

import java.net.*
import java.util.*
import com.mingliqiye.utils.random.Random.nextBytes as randomByte

private val UNIX_PREFIXES = arrayOf("Linux", "AIX", "SunOS", "Mac OS X", "FreeBSD")
private val HEX_UPPER: Array<String> = Array(256) { "%02X".format(it) }

private fun <T> Enumeration<T>?.toList(): List<T> = if (this == null) emptyList() else Collections.list(this)

/**
 * 操作系统名称属性，延迟初始化
 */
val osName: String? by lazy {
	runCatching { System.getProperty("os.name") }.getOrNull()
}

/**
 * 判断当前操作系统是否为 Windows
 */
val isWindows: Boolean by lazy {
	osName?.startsWith("Windows") == true
}

/**
 * 判断当前操作系统是否为 Mac
 */
val isMac: Boolean by lazy {
	osName?.startsWith("Mac") == true
}

/**
 * 判断当前操作系统是否为 Unix/Linux（含 macOS）
 */
val isUnix: Boolean by lazy {
	val name = osName ?: return@lazy false
	UNIX_PREFIXES.any { name.startsWith(it) }
}

/**
 * JDK 版本号属性，延迟初始化
 */
val jdkVersion: String? by lazy {
	runCatching { System.getProperty("java.specification.version") }.getOrNull()
}

/**
 * Java 版本号的主版本整数，延迟初始化
 *
 * 同时兼容 `1.8` 旧式版本号与 `9` / `17` / `100` 等新式版本号。
 *
 * @throws IllegalStateException 无法解析出整数版本时抛出
 */
val javaVersionAsInteger: Int by lazy {
	val version = jdkVersion
	if (version.isNullOrBlank()) {
		throw IllegalStateException(
			"Unable to determine Java version from property 'java.specification.version'"
		)
	}
	val normalized = if (version.startsWith("1.")) version.substring(2) else version
	val major = normalized.substringBefore('.').substringBefore('-')
	major.toIntOrNull() ?: throw IllegalStateException("Invalid Java version format: $version")
}

/**
 * 判断当前 JDK 版本是否大于 8
 */
val isJdk8Plus: Boolean by lazy {
	javaVersionAsInteger > 8
}

/**
 * 本地 IPv4 地址数组，跳过回环、虚拟与未启用网卡
 *
 * @throws RuntimeException 网络接口枚举失败时抛出
 */
val localIps: Array<String> by lazy {
	try {
		activeNetworkInterfaces().flatMap { it.inetAddresses.toList() }.filterIsInstance<Inet4Address>()
			.mapNotNull { it.hostAddress }.toList().toTypedArray()
	} catch (e: SocketException) {
		throw RuntimeException("Failed to get local IP addresses", e)
	}
}

/**
 * 本地 IPv4 地址列表
 */
val localIpsByList: List<String> by lazy { localIps.toList() }

/**
 * 本地回环地址数组；枚举失败时至少包含 `127.0.0.1`
 */
val loopbackIps: Array<String> by lazy {
	try {
		NetworkInterface.getNetworkInterfaces().toList().asSequence().filter { it.isLoopback && it.isUp }
			.flatMap { it.inetAddresses.toList().asSequence() }.mapNotNull { it.hostAddress }.toList().toTypedArray()
	} catch (_: SocketException) {
		arrayOf("127.0.0.1")
	}
}

/**
 * 本地回环地址列表
 */
val loopbackIpsByList: List<String> by lazy { loopbackIps.toList() }

/**
 * 当前进程 PID；获取失败返回 -1
 */
val getPid: Long by lazy {
	runCatching { ProcessHandle.current().pid() }.getOrElse { -1L }
}

/**
 * 当前进程 PID 字符串；获取失败返回 "-1"
 */
val pidAsString: String by lazy {
	val pid = getPid
	if (pid == -1L) "-1" else pid.toString()
}

/**
 * 计算机名；获取失败返回 "unknown"
 */
val computerName: String by lazy {
	getEnvVar("COMPUTERNAME") ?: getEnvVar("HOSTNAME")
	?: runCatching { InetAddress.getLocalHost().hostName }.getOrNull()?.takeIf { it.isNotBlank() } ?: "unknown"
}

/**
 * 当前用户名；获取失败返回 "unknown"
 */
val userName: String by lazy {
	getEnvVar("USERNAME") ?: getEnvVar("USER") ?: runCatching { System.getProperty("user.name") }.getOrNull()
		?.takeIf { it.isNotBlank() } ?: "unknown"
}

private fun getEnvVar(name: String): String? = runCatching {
	System.getenv(name)?.takeIf { it.isNotBlank() }
}.getOrNull()

/**
 * 本机 MAC 地址字节数组
 *
 * 未找到可用网卡时回退为 6 字节随机数，避免下游拿到空数组导致错误。
 */
val macAddressBytes: ByteArray by lazy {
	val found = try {
		activeNetworkInterfaces().mapNotNull { runCatching { it.hardwareAddress }.getOrNull() }
			.firstOrNull { it.isNotEmpty() }
	} catch (_: SocketException) {
		null
	}
	found ?: randomByte(6)
}

/**
 * 本机 MAC 地址的十六进制字符串列表（大写）
 */
val macAddressStringList: List<String> by lazy {
	macAddressBytes.map { HEX_UPPER[it.toInt() and 0xFF] }
}

/**
 * 本机 MAC 地址的格式化字符串，如 `00:11:22:33:44:55`
 */
val macAddressFormattedString: String by lazy {
	macAddressBytes.joinToString(":") { HEX_UPPER[it.toInt() and 0xFF] }
}

/**
 * 所有非回环、非虚拟网卡的 MAC 地址映射，key 为网卡名
 */
val allMacAddresses: Map<String, ByteArray> by lazy {
	try {
		NetworkInterface.getNetworkInterfaces().toList().asSequence().filter { !it.isLoopback && !it.isVirtual }
			.mapNotNull { ni ->
				val mac = runCatching { ni.hardwareAddress }.getOrNull()
				if (mac != null && mac.isNotEmpty()) ni.name to mac else null
			}.toMap()
	} catch (_: SocketException) {
		emptyMap()
	}
}

/**
 * 所有网卡 MAC 地址的十六进制字符串列表映射
 */
val allMacAddressesStringList: Map<String, List<String>> by lazy {
	allMacAddresses.mapValues { (_, bytes) -> bytes.map { HEX_UPPER[it.toInt() and 0xFF] } }
}

/**
 * 可用处理器数量
 */
val availableProcessors: Int by lazy {
	Runtime.getRuntime().availableProcessors()
}

private fun activeNetworkInterfaces(): Sequence<NetworkInterface> =
	NetworkInterface.getNetworkInterfaces().toList().asSequence().filter { !it.isLoopback && !it.isVirtual && it.isUp }


private val protocol: String by lazy {
	val target = ProtocolAnchor::class.java
	val resourceName = target.simpleName + ".class"
	val resource: URL = target.getResource(resourceName) ?: throw IllegalStateException(
		"Unable to locate resource '$resourceName' for class ${target.name}"
	)
	resource.protocol
}


/** 是否为开发模式（file 协议） */
val isDevMode: Boolean get() = protocol == "file"

/** 是否不为开发模式 */
val isNotDevMode: Boolean get() = protocol != "file"

/** 是否为 JAR 模式 */
val isJarMode: Boolean get() = protocol == "jar"

/** 是否不为 JAR 模式 */
val isNotJarMode: Boolean get() = protocol != "jar"

/** 是否为 WAR 模式 */
val isWarMode: Boolean get() = protocol == "war"

/** 是否不为 WAR 模式 */
val isNotWarMode: Boolean get() = protocol != "war"

/** 是否为 JSWAR 模式 */
val isJswarMode: Boolean get() = protocol == "jswar"

/** 是否不为 JSWAR 模式 */
val isNotJswarMode: Boolean get() = protocol != "jswar"

/**
 * 当前操作系统的行分隔符
 */
val lineSeparator: String
	get() = System.lineSeparator()

/**
 * LF 行分隔符常量（`\n`）
 */
const val lineSeparatorLF = "\n"

/**
 * CR 行分隔符常量（`\r`）
 */
const val lineSeparatorCR = "\r"

/**
 * CRLF 行分隔符常量（`\r\n`）
 */
const val lineSeparatorCRLF = lineSeparatorCR + lineSeparatorLF

private object ProtocolAnchor
