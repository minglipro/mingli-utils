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
 * LastUpdate 2026-02-05 10:20:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import com.mingliqiye.utils.string.join
import java.io.Serializable
import java.net.InetAddress
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
         * @throws java.net.UnknownHostException 如果域名无法解析
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
