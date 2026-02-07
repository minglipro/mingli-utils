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
 * CurrentFile NetworkPort.kt
 * LastUpdate 2026-02-05 10:20:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network

import java.io.Serializable
import java.nio.ByteBuffer

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
