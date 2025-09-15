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
 * CurrentFile AddressPort.kt
 * LastUpdate 2025-09-15 22:01:27
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import java.io.Serializable
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.UnknownHostException
import java.util.regex.Pattern

/**
 * 网络地址类，用于表示一个网络地址（IP或域名），并提供相关操作。
 * 支持IPv4和IPv6地址的解析与验证。
 *
 * @author MingLiPro
 */
class NetworkAddress private constructor(domip: String) : Serializable {

    /**
     * IPv6标识
     */
    companion object {
        const val IPV6 = 6

        /**
         * IPv4标识
         */
        const val IPV4 = 4

        /**
         * IPv4地址正则表达式
         */
        private const val IPV4REG =
            "^((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2" + "(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}$"

        /**
         * 编译后的IPv4地址匹配模式
         */
        private val IPV4_PATTERN = Pattern.compile(IPV4REG)

        /**
         * IPv6地址正则表达式
         */
        private const val IPV6REG =
            "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$|" + "^(::([0-9a-fA-F]{1,4}:){0,6}[0-9a-fA-F]{1,4})$" + "|" + "^(::)$|" + "^([0-9a-fA-F]{1,4}::([0-9a-fA-F]{1,4}:){0,5}[0-9a-fA-F]{1,4})$|" + "^(([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4})$|" + "^(([0-9a-fA-F]{1,4}:){6}(([0-9]{1,3}\\.){3}[0-9]{1,3}))$|" + "^::([fF]{4}:)?(([0-9]{1,3}\\.){3}[0-9]{1,3})$"

        /**
         * 编译后的IPv6地址匹配模式
         */
        private val IPV6_PATTERN = Pattern.compile(IPV6REG)

        /**
         * 静态工厂方法，创建 NetworkAddress 实例。
         *
         * @param domip 可能是IP地址或域名的字符串
         * @return 新建的 NetworkAddress 实例
         */
        @JvmStatic
        fun of(domip: String): NetworkAddress {
            return NetworkAddress(domip)
        }

        /**
         * 静态工厂方法，通过 InetAddress 创建 NetworkAddress 实例。
         *
         * @param inetAddress InetAddress 对象
         * @return 新建的 NetworkAddress 实例
         */
        @JvmStatic
        fun of(inetAddress: InetAddress): NetworkAddress {
            return NetworkAddress(inetAddress.hostAddress)
        }

        /**
         * 从DNS服务器解析域名获取对应的IP地址。
         *
         * @param domain 域名
         * @return 解析出的第一个IP地址
         * @throws UnknownHostException 如果域名无法解析
         */
        @JvmStatic
        @Throws(UnknownHostException::class)
        fun getHostIp(domain: String): String {
            val addresses = InetAddress.getAllByName(domain.trim())
            return addresses[0].hostAddress
        }

        /**
         * 检测给定字符串是否为有效的IPv4或IPv6地址。
         *
         * @param ip 要检测的IP地址字符串
         * @return 4 表示IPv4，6 表示IPv6
         * @throws NetworkException 如果IP格式无效
         */
        @JvmStatic
        fun testIp(ip: String?): Int {
            if (ip == null) {
                throw NetworkException("IP地址不能为null")
            }
            val trimmedIp = ip.trim()

            // 判断是否匹配IPv4格式
            if (IPV4_PATTERN.matcher(trimmedIp).matches()) {
                return IPV4
            }

            // 判断是否匹配IPv6格式
            if (IPV6_PATTERN.matcher(trimmedIp).matches()) {
                return IPV6
            }

            // 不符合任一格式时抛出异常
            throw NetworkException(
                "[$ip] 不是有效的IPv4或IPv6地址"
            )
        }
    }

    /**
     * IP地址类型：4 表示 IPv4，6 表示 IPv6
     */
    var iPv: Int = 0
        private set

    /**
     * IP地址字符串
     */
    var ip: String? = null
        private set

    /**
     * 域名（如果输入的是域名）
     */
    private var domain: String? = null

    /**
     * 标识是否是域名解析来的IP
     */
    private var isdom = false

    /**
     * 构造方法，根据传入的字符串判断是IP地址还是域名，并进行相应处理。
     *
     * @param domip 可能是IP地址或域名的字符串
     */
    init {
        try {
            // 尝试将输入识别为IP地址
            this.iPv = testIp(domip)
            this.ip = domip
        } catch (e: NetworkException) {
            try {
                // 如果不是有效IP，则尝试作为域名解析
                val ips = getHostIp(domip)
                this.iPv = testIp(ips)
                this.ip = ips
                this.isdom = true
                this.domain = domip
            } catch (ex: UnknownHostException) {
                throw NetworkException(ex)
            }
        }
    }

    /**
     * 将当前 NetworkAddress 转换为 InetAddress 对象。
     *
     * @return InetAddress 对象
     */
    fun toInetAddress(): InetAddress {
        try {
            return InetAddress.getByName(if (ip != null) ip else domain)
        } catch (e: UnknownHostException) {
            throw RuntimeException(e)
        }
    }

    /**
     * 返回 NetworkAddress 的字符串表示形式。
     *
     * @return 字符串表示
     */
    override fun toString(): String {
        return if (isdom) "NetworkAddress(IP='$ip',type='$iPv',domain='$domain')"
        else "NetworkAddress(IP='$ip',type='$iPv')"
    }
}


class NetworkPort : Serializable {
    val port: Int

    constructor(port: Int) {
        testPort(port)
        this.port = port
    }

    companion object {
        fun testPort(port: Int) {
            // 验证端口号范围是否在0-65535之间
            if (port !in 0..65535) {
                throw NetworkException("$port 不是正确的端口号")
            }
        }
    }
}

class NetworkException : RuntimeException {
    /**
     * 构造一个带有指定详细消息的网络异常
     *
     * @param message 异常的详细消息
     */
    constructor(message: String?) : super(message)

    /**
     * 构造一个网络异常，指定原因异常
     *
     * @param e 导致此异常的原因异常
     */
    constructor(e: Exception?) : super(e)
}

/**
 * IP和端口聚集类，用于封装网络地址与端口信息。
 * 该类提供了与InetSocketAddress之间的相互转换功能。
 *
 * @author MingLiPro
 * @see java.net.InetSocketAddress
 */
class NetworkEndpoint private constructor(
    val networkAddress: NetworkAddress, val networkPort: NetworkPort
) : Serializable {


    companion object {
        /**
         * 根据给定的InetSocketAddress对象创建NetworkEndpoint实例。
         *
         * @param address InetSocketAddress对象
         * @return 新建的NetworkEndpoint实例
         * @see java.net.InetSocketAddress
         */
        @JvmStatic
        fun of(address: InetSocketAddress): NetworkEndpoint {
            return NetworkEndpoint(
                NetworkAddress.of(address.hostString), NetworkPort(address.port)
            )
        }

        /**
         * 根据主机名或IP字符串和端口号创建NetworkEndpoint实例。
         *
         * @param s 主机名或IP地址字符串
         * @param i 端口号
         * @return 新建的NetworkEndpoint实例
         */
        @JvmStatic
        fun of(s: String, i: Int): NetworkEndpoint {
            val networkAddress = NetworkAddress.of(s)
            val networkPort = NetworkPort(i)
            return NetworkEndpoint(networkAddress, networkPort)
        }

        /**
         * 根据"host:port"格式的字符串创建NetworkEndpoint实例。
         * 例如："127.0.0.1:8080"
         *
         * @param s "host:port"格式的字符串
         * @return 新建的NetworkEndpoint实例
         */
        @JvmStatic
        fun of(s: String): NetworkEndpoint {
            val lastColonIndex = s.lastIndexOf(':')
            return of(
                s.take(lastColonIndex), s.substring(lastColonIndex + 1).toInt()
            )
        }
    }

    /**
     * 将当前NetworkEndpoint转换为InetSocketAddress对象。
     *
     * @return 对应的InetSocketAddress对象
     * @see InetSocketAddress
     */
    fun toInetSocketAddress(): InetSocketAddress {
        return InetSocketAddress(
            networkAddress.toInetAddress(), networkPort.port
        )
    }

    /**
     * 将当前NetworkEndpoint转换为"host:port"格式的字符串。
     * 例如："127.0.0.1:25563"
     *
     * @return 格式化后的字符串
     */
    fun toHostPortString(): String {
        return "${networkAddress.ip}:${networkPort.port}"
    }

    /**
     * 返回NetworkEndpoint的详细字符串表示形式。
     * 格式：NetworkEndpoint(IP=...,Port=...,Endpoint=...)
     *
     * @return 包含详细信息的字符串
     */
    override fun toString(): String {
        return "NetworkEndpoint(IP=${networkAddress.ip},Port=${networkPort.port},Endpoint=${toHostPortString()})"
    }

    /**
     * 获取主机名或IP地址字符串。
     *
     * @return 主机名或IP地址
     */
    fun host(): String {
        return networkAddress.ip ?: ""
    }

    /**
     * 获取端口号。
     *
     * @return 端口号
     */
    fun port(): Int {
        return networkPort.port
    }
}
