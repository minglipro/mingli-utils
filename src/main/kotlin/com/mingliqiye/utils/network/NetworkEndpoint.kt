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
 * LastUpdate 2026-02-05 10:20:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import java.io.Serializable
import java.net.InetSocketAddress
import java.nio.ByteBuffer

/**
 * IP和端口聚集类，用于封装网络地址与端口信息。
 * 该类提供了与InetSocketAddress之间的相互转换功能。
 *
 * @author MingLiPro
 * @see java.net.InetSocketAddress
 */
class NetworkEndpoint private constructor(
    val networkAddress: NetworkAddress, val networkPort: NetworkPort
) : Serializable, InetSocketAddress(networkAddress.toInetAddress(), networkPort.port) {


    companion object {
        /**
         * 根据给定的InetSocketAddress对象创建NetworkEndpoint实例。
         *
         * @param address InetSocketAddress对象
         * @return 新建的NetworkEndpoint实例
         * @see InetSocketAddress
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
