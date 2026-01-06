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
 * CurrentFile AddressPort.kt
 * LastUpdate 2026-01-06 14:03:47
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import com.mingliqiye.utils.string.join
import java.io.Serializable
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.UnknownHostException
import java.nio.ByteBuffer
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

        @JvmStatic
        fun ofIpv4(byteBuffer: ByteBuffer): NetworkAddress {
            val byteArray = ByteArray(4)
            byteBuffer.get(byteArray)
            return ofIpv4(byteArray)
        }

        @JvmStatic
        fun ofIpv4(byteArray: ByteArray): NetworkAddress {
            return of(".".join(byteArray.map {
                (it.toInt() and 0xFF).toString()
            }))
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
     * 将IPv4地址转换为字节数组
     *
     * @return 返回表示IPv4地址的4字节数组
     * @throws NetworkException 当当前地址不是IPv4地址时抛出异常
     */
    fun toIpv4ByteArray(): ByteArray {
        // 验证地址类型是否为IPv4
        if (iPv != IPV4) {
            throw NetworkException("该地址 不是IPv4地址")
        }
        // 将IP地址字符串按点分割，转换为整数并进行位运算处理，最后转为字节数组
        return ip!!.split(".").map { it.toInt() and 0xFF }.map { it.toByte() }.toByteArray()
    }

    /**
     * 将IPv4地址写入到指定的ByteBuffer中
     *
     * @param byteBuffer 要写入的ByteBuffer对象，IPv4地址将以字节数组形式写入到该缓冲区
     * @return 返回写入了IPv4地址的ByteBuffer对象，便于链式调用
     */
    fun writeIpv4ToByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
        return byteBuffer.put(toIpv4ByteArray())
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

    fun toByteArray(): ByteArray {
        val byteArray = ByteArray(2)
        byteArray[0] = (port shr 8 and 0xFF).toByte()
        byteArray[1] = (port and 0xFF).toByte()
        return byteArray
    }

    fun writeToByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
        return byteBuffer.put(toByteArray())
    }

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

        @JvmStatic
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
         * 从字节数组创建IPv4网络端点
         *
         * @param byteArray 包含IPv4地址和端口信息的字节数组，前4个字节表示IP地址，后2个字节表示端口号
         * @return NetworkEndpoint对象，封装了IPv4地址和端口信息
         */
        @JvmStatic
        fun ofIpv4(byteArray: ByteArray): NetworkEndpoint {
            // 提取前4个字节作为IP地址
            val address = ByteArray(4) {
                byteArray[it]
            }
            // 提取后2个字节作为端口号
            val portInt = ByteArray(2) {
                byteArray[it + 4]
            }
            return NetworkEndpoint(NetworkAddress.ofIpv4(address), NetworkPort.of(portInt))
        }

        /**
         * 从字节缓冲区创建IPv4网络端点实例
         *
         * 该方法从给定的ByteBuffer中读取数据，构建一个包含IPv4地址和端口的网络端点对象。
         * 该方法按照协议顺序从缓冲区中读取IPv4地址数据和端口数据。
         *
         * @param byteBuffer 包含IPv4地址和端口数据的字节缓冲区，缓冲区中的数据应按照先地址后端口的顺序排列
         * @return 返回一个NetworkEndpoint实例，包含从缓冲区解析出的IPv4地址和端口信息
         */
        @JvmStatic
        fun ofIpv4(byteBuffer: ByteBuffer): NetworkEndpoint {
            return NetworkEndpoint(
                NetworkAddress.ofIpv4(byteBuffer),
                NetworkPort.of(byteBuffer)
            )
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
        return "NetworkEndpoint(IP=${networkAddress.ip},Port=${networkPort.port})"
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

    /**
     * 将网络地址和端口转换为IPv4字节数组
     *
     * 该函数将当前对象的网络地址转换为IPv4字节数组，并与端口字节数组合并，
     * 生成一个包含6个字节的数组，其中前4个字节为IPv4地址，后2个字节为端口号
     *
     * @return ByteArray 包含6个字节的数组，前4个字节为IPv4地址，后2个字节为端口号
     */
    fun toIpv4ByteArray(): ByteArray {
        val ipv4ByteArray = networkAddress.toIpv4ByteArray()
        val portByteArray = networkPort.toByteArray()
        // 构建包含IPv4地址和端口的6字节数组
        val byteArray = ByteArray(6) {
            if (it < 4) {
                ipv4ByteArray[it]
            } else {
                portByteArray[it - 4]
            }
        }
        return byteArray
    }

    /**
     * 将IPv4地址和端口信息写入字节缓冲区
     *
     * 该函数依次将网络地址的IPv4表示和网络端口写入到指定的字节缓冲区中
     *
     * @param byteBuffer 要写入数据的目标字节缓冲区
     */
    fun writeIpv4toByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
        networkAddress.writeIpv4ToByteBuffer(byteBuffer)
        networkPort.writeToByteBuffer(byteBuffer)
        return byteBuffer
    }
}
