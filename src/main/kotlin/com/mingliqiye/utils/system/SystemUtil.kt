/*
 * Copyright 2025 mingliqiye
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
 * LastUpdate 2025-09-16 17:36:11
 * UpdateUser MingLiPro
 */
@file:JvmName("SystemUtils")

package com.mingliqiye.utils.system

import com.mingliqiye.utils.random.randomByteSecure
import java.lang.management.ManagementFactory
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException

/**
 * 操作系统名称属性，延迟初始化
 */
val osName: String? by lazy {
    System.getProperties().getProperty("os.name")
}

/**
 * 判断当前操作系统是否为Windows系统
 *
 * @return 如果是Windows系统返回true，否则返回false
 */
val isWindows: Boolean by lazy {
    osName != null && osName!!.startsWith("Windows")
}

/**
 * 判断当前操作系统是否为Mac系统
 *
 * @return 如果是Mac系统返回true，否则返回false
 */
val isMac: Boolean by lazy {
    osName != null && osName!!.startsWith("Mac")
}

/**
 * 判断当前操作系统是否为Unix/Linux系统
 *
 * @return 如果是Unix/Linux系统返回true，否则返回false
 */
val isUnix: Boolean by lazy {
    if (osName == null) {
        false
    } else {
        (osName!!.startsWith("Linux") || osName!!.startsWith("AIX") || osName!!.startsWith("SunOS") || osName!!.startsWith(
            "Mac OS X"
        ) || osName!!.startsWith(
            "FreeBSD"
        ))
    }
}

/**
 * JDK版本号属性，延迟初始化
 */
val jdkVersion: String? by lazy {
    System.getProperty("java.specification.version")
}

/**
 * Java版本号的整数形式属性，延迟初始化
 */
val javaVersionAsInteger: Int by lazy {
    val version = jdkVersion
    if (version == null || version.isEmpty()) {
        throw IllegalStateException(
            "Unable to determine Java version from property 'java.specification.version'"
        )
    }

    val uversion: String = if (version.startsWith("1.")) {
        if (version.length < 3) {
            throw IllegalStateException(
                "Invalid Java version format: $version"
            )
        }
        version[2] + ""
    } else {
        if (version.length < 2) {
            throw IllegalStateException(
                "Invalid Java version format: $version"
            )
        }
        version.take(2)
    }
    uversion.toInt()
}

/**
 * 判断当前JDK版本是否大于8
 *
 * @return 如果JDK版本大于8返回true，否则返回false
 */
val isJdk8Plus: Boolean by lazy {
    javaVersionAsInteger > 8
}

/**
 * 本地IP地址数组，延迟初始化
 *
 * @throws RuntimeException 当获取网络接口信息失败时抛出
 */
val localIps: Array<String> by lazy {
    try {
        val ipList: MutableList<String> = ArrayList()
        val interfaces = NetworkInterface.getNetworkInterfaces()

        while (interfaces.hasMoreElements()) {
            val networkInterface = interfaces.nextElement()
            // 跳过回环接口和虚拟接口
            if (networkInterface.isLoopback || networkInterface.isVirtual || !networkInterface.isUp) {
                continue
            }

            val addresses = networkInterface.inetAddresses
            while (addresses.hasMoreElements()) {
                val address = addresses.nextElement()
                // 只获取IPv4地址
                if (address is Inet4Address) {
                    ipList.add(address.hostAddress)
                }
            }
        }

        ipList.toTypedArray()
    } catch (e: SocketException) {
        throw RuntimeException("Failed to get local IP addresses", e)
    }
}

/**
 * 本地IP地址列表，延迟初始化
 */
val localIpsByList: List<String> by lazy {
    localIps.toList()
}

/**
 * 本地回环地址数组，延迟初始化
 */
val loopbackIps: Array<String> by lazy {
    val strings: MutableList<String> = ArrayList(3)
    return@lazy try {
        val interfaces = NetworkInterface.getNetworkInterfaces()

        while (interfaces.hasMoreElements()) {
            val networkInterface = interfaces.nextElement()

            // 只处理回环接口
            if (networkInterface.isLoopback && networkInterface.isUp) {
                val addresses = networkInterface.inetAddresses

                while (addresses.hasMoreElements()) {
                    val address = addresses.nextElement()
                    strings.add(address.hostAddress)
                }
            }
        }
        strings.toTypedArray()
    } catch (e: SocketException) {
        arrayOf("127.0.0.1")
    }
}

/**
 * 本地回环地址IP列表，延迟初始化
 */
val loopbackIpsByList: List<String> by lazy {
    loopbackIps.toList()
}

/**
 * 获取当前进程的PID
 *
 * @return 进程ID，如果无法获取则返回-1
 */
val getPid: Long by lazy {
    try {
        val name = ManagementFactory.getRuntimeMXBean().name
        val index = name.indexOf('@')
        if (index > 0) {
            name.take(index).toLong()
        } else {
            -1L
        }
    } catch (e: Exception) {
        -1L
    }
}

/**
 * 获取当前进程的PID字符串形式
 *
 * @return 进程ID字符串，如果无法获取则返回"-1"
 */
val pidAsString: String by lazy {
    try {
        val name = ManagementFactory.getRuntimeMXBean().name
        val index = name.indexOf('@')
        if (index > 0) {
            name.take(index)
        } else {
            "-1"
        }
    } catch (e: Exception) {
        "-1"
    }
}

/**
 * 获取计算机名
 *
 * @return 计算机名，如果无法获取则返回"unknown"
 */
val computerName: String by lazy {
    try {
        var name = System.getenv("COMPUTERNAME")
        if (name.isNullOrBlank()) {
            name = System.getenv("HOSTNAME")
        }
        if (name.isNullOrBlank()) {
            name = InetAddress.getLocalHost().hostName
        }
        name ?: "unknown"
    } catch (e: Exception) {
        "unknown"
    }
}

/**
 * 获取当前用户名
 *
 * @return 当前用户名，如果无法获取则返回"unknown"
 */
val userName: String by lazy {
    try {
        getEnvVar("USERNAME")
            ?: getEnvVar("USER")
            ?: System.getProperty("user.name")
            ?: "unknown"
    } catch (e: SecurityException) {
        "unknown"
    } catch (e: Exception) {
        "unknown"
    }
}

private fun getEnvVar(name: String): String? {
    return try {
        System.getenv(name)?.takeIf { it.isNotBlank() }
    } catch (e: SecurityException) {
        null
    }
}

/**
 * 获取本机MAC地址的字节数组形式
 *
 * @return MAC地址字节数组，如果无法获取则返回空数组
 */
val macAddressBytes: ByteArray by lazy {
    try {
        val interfaces = NetworkInterface.getNetworkInterfaces()

        while (interfaces.hasMoreElements()) {
            val networkInterface = interfaces.nextElement()

            // 跳过回环接口和虚拟接口
            if (networkInterface.isLoopback || networkInterface.isVirtual || !networkInterface.isUp) {
                continue
            }

            val mac = networkInterface.hardwareAddress
            if (mac != null && mac.isNotEmpty()) {
                return@lazy mac
            }
        }
        randomByteSecure(6)
    } catch (e: SocketException) {
        randomByteSecure(6)
    } catch (e: Exception) {
        randomByteSecure(6)
    }
}

/**
 * 获取本机MAC地址的十六进制字符串列表形式
 *
 * @return MAC地址字符串列表，每个元素表示一个字节的十六进制值（大写），如果无法获取则返回空列表
 */
val macAddressStringList: List<String> by lazy {
    val macBytes = macAddressBytes
    if (macBytes.isEmpty()) {
        return@lazy emptyList()
    }

    macBytes.map { String.format("%02X", it) }
}

/**
 * 获取本机MAC地址的格式化字符串形式（如 "00:11:22:33:44:55"）
 *
 * @return 格式化的MAC地址字符串，如果无法获取则返回空字符串
 */
val macAddressFormattedString: String by lazy {
    val macBytes = macAddressBytes
    if (macBytes.isEmpty()) {
        return@lazy ""
    }

    macBytes.joinToString(":") { String.format("%02X", it) }
}

/**
 * 获取所有网络接口的MAC地址映射
 *
 * @return Map结构，key为网络接口名称，value为对应的MAC地址字节数组
 */
val allMacAddresses: Map<String, ByteArray> by lazy {
    try {
        val result = mutableMapOf<String, ByteArray>()
        val interfaces = NetworkInterface.getNetworkInterfaces()

        while (interfaces.hasMoreElements()) {
            val networkInterface = interfaces.nextElement()

            // 跳过回环接口和虚拟接口
            if (networkInterface.isLoopback || networkInterface.isVirtual) {
                continue
            }

            val mac = networkInterface.hardwareAddress
            if (mac != null && mac.isNotEmpty()) {
                result[networkInterface.name] = mac
            }
        }

        result
    } catch (e: SocketException) {
        emptyMap()
    } catch (e: Exception) {
        emptyMap()
    }
}

/**
 * 获取所有网络接口的MAC地址字符串列表映射
 *
 * @return Map结构，key为网络接口名称，value为对应的MAC地址字符串列表
 */
val allMacAddressesStringList: Map<String, List<String>> by lazy {
    allMacAddresses.mapValues { entry ->
        entry.value.map { String.format("%02X", it) }
    }
}
