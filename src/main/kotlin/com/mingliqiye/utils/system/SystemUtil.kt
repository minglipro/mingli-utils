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
 * LastUpdate 2025-09-14 21:56:58
 * UpdateUser MingLiPro
 */
@file:JvmName("SystemUtils")

package com.mingliqiye.utils.system

import com.mingliqiye.utils.collection.Lists
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException

private val osName: String? = System.getProperties().getProperty("os.name")

/**
 * 判断当前操作系统是否为Windows系统
 *
 * @return 如果是Windows系统返回true，否则返回false
 */
fun isWindows(): Boolean {
    return osName != null && osName.startsWith("Windows")
}

/**
 * 判断当前操作系统是否为Mac系统
 *
 * @return 如果是Mac系统返回true，否则返回false
 */
fun isMac(): Boolean {
    return osName != null && osName.startsWith("Mac")
}

/**
 * 判断当前操作系统是否为Unix/Linux系统
 *
 * @return 如果是Unix/Linux系统返回true，否则返回false
 */
fun isUnix(): Boolean {
    if (osName == null) {
        return false
    }
    return (osName.startsWith("Linux") || osName.startsWith("AIX") || osName.startsWith("SunOS") || osName.startsWith("Mac OS X") || osName.startsWith(
        "FreeBSD"
    ))
}

/**
 * 获取JDK版本号
 *
 * @return JDK版本号字符串
 */
fun getJdkVersion(): String {
    return System.getProperty("java.specification.version")
}

/**
 * 获取Java版本号的整数形式
 *
 * @return Java版本号的整数形式（如：8、11、17等）
 */
fun getJavaVersionAsInteger(): Int {
    val version = getJdkVersion()
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
        version.substring(2, 3)
    } else {
        if (version.length < 2) {
            throw IllegalStateException(
                "Invalid Java version format: $version"
            )
        }
        version.substring(0, 2)
    }
    return uversion.toInt()
}

/**
 * 判断当前JDK版本是否大于8
 *
 * @return 如果JDK版本大于8返回true，否则返回false
 */
fun isJdk8Plus(): Boolean {
    return getJavaVersionAsInteger() > 8
}

/**
 * 获取本地IP地址数组
 *
 * @return 本地IP地址字符串数组
 * @throws RuntimeException 当获取网络接口信息失败时抛出
 */
fun getLocalIps(): Array<String> {
    return try {
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
 * 获取本地IP地址列表
 *
 * @return 本地IP地址的字符串列表
 */
fun getLocalIpsByList(): List<String> {
    return Lists.newArrayList(*getLocalIps())
}

/**
 * 获取本地回环地址
 *
 * @return 回环地址字符串，通常为"127.0.0.1"
 */
fun getLoopbackIps(): Array<String> {
    val strings: MutableList<String> = ArrayList(3)
    return try {
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
        // 可考虑添加日志记录
        arrayOf("127.0.0.1")
    }
}

/**
 * 获取本地回环地址IP列表
 *
 * @return 本地回环地址IP字符串列表的副本
 */
fun getLoopbackIpsByList(): List<String> {
    // 将本地回环地址IP数组转换为列表并返回
    return Lists.newArrayList(*getLoopbackIps())
}
