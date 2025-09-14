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
 * CurrentFile UUID.kt
 * LastUpdate 2025-09-14 19:55:47
 * UpdateUser MingLiPro
 */
package com.mingliqiye.utils.uuid

import com.github.f4b6a3.uuid.UuidCreator
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.DateTimeOffset
import java.io.Serializable
import java.nio.ByteBuffer
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.UUID as JUUID


class UUID : Serializable {
    private val uuid: JUUID

    companion object {
        /**
         * 获取 UUIDV1 版本的随机实例
         * @return UUID
         */
        @JvmStatic
        fun getV1(): UUID {
            return UUID(UuidCreator.getTimeBased())
        }

        /**
         * 获取 UUIDV4 版本的随机实例
         * @return UUID
         */
        @JvmStatic
        fun getV4(): UUID {
            return UUID(UuidCreator.getRandomBased())
        }

        /**
         * 获取 UUIDV1Fast 版本的随机实例
         * @return UUID
         */
        @JvmStatic
        fun getV4Fast(): UUID {
            return UUID(UuidCreator.getRandomBasedFast())
        }

        /**
         * 从2个8个字节转换到UUID
         * @param lsb 高位 8 字节的 Long
         * @param msb 低位 8 字节的 Long
         * @return UUID
         */
        @JvmStatic
        fun of(msb: Long, lsb: Long): UUID {
            return UUID(msb, lsb)
        }

        /**
         * 从字符串格式化
         * @param uuid 字符串
         * @return UUID
         */
        @JvmStatic
        fun of(uuid: String): UUID {
            return UUID(uuid)
        }

        /**
         * 从Java的UUID
         * @param uuid 字符串
         * @return UUID
         */
        @JvmStatic
        fun of(uuid: JUUID): UUID {
            return UUID(uuid)
        }

        /**
         * 从字节码转换到UUID
         * @param array 16字节
         * @return UUID
         */
        @JvmStatic
        fun of(array: ByteArray): UUID {
            return UUID(array)
        }

        fun JUUID.toMlUUID(): UUID {
            return of(this)
        }
    }

    internal constructor(msb: Long, lsb: Long) {
        uuid = JUUID(msb, lsb)
    }

    internal constructor(uuid: JUUID) {
        this.uuid = uuid
    }

    internal constructor(array: ByteArray) {
        val bb = ByteBuffer.wrap(array)
        this.uuid = JUUID(bb.getLong(), bb.getLong())
    }

    constructor(uuid: String) {
        this.uuid = JUUID.fromString(uuid)
    }


    /**
     * 获取对应的字节码
     * @return 字节码
     */
    fun toBytes(): ByteArray {
        val bb = ByteBuffer.wrap(ByteArray(16))
        bb.putLong(uuid.mostSignificantBits)
        bb.putLong(uuid.leastSignificantBits)

        return bb.array()
    }

    /**
     * 获取Java的UUID对象
     * @return Java的UUID对象
     */
    fun getUuid(): JUUID {
        return uuid
    }

    /**
     * 将 UUID 转换为字符串表示，默认使用小写格式。
     * @param u 是否大写
     * @return UUID 字符串
     */
    fun getString(u: Boolean): String {
        return if (u) {
            uuid.toString().uppercase(Locale.ROOT)
        } else {
            uuid.toString()
        }
    }

    /**
     * 将 UUID 转换为字符串表示，默认使用小写格式。
     *
     * @return UUID 字符串
     */
    fun getString(): String {
        return getString(false)
    }

    @Deprecated("使用 getString()", ReplaceWith("getString"), level = DeprecationLevel.WARNING)
    fun toUUIDString(): String {
        return this.getString()
    }

    @Deprecated("使用 getString(u:Boolean)", ReplaceWith("getString(u)"), level = DeprecationLevel.WARNING)
    fun toUUIDString(u: Boolean): String {
        return this.getString(u)
    }

    /**
     * 从时间戳型 UUID 中提取时间戳并转换为 DateTime 对象。
     *
     * @return 对应的 DateTime 对象；如果 不是 时间戳V1版本 返回 null
     */
    fun getDateTime(): DateTime? {
        if (uuid.version() != 1) {
            return null
        }
        return DateTime.of(uuid.timestamp() / 10000).add(
            DateTimeOffset.of(-141427L, ChronoUnit.DAYS)
        )
    }

    /**
     * 从时间戳型 UUID 中提取 MAC 地址，默认使用冒号分隔符。
     *
     * @return MAC 地址字符串
     */
    fun extractMACFromUUID(): String {
        return extractMACFromUUID(null)
    }

    /**
     * 从时间戳型 UUID 中提取 MAC 地址，并允许自定义分隔符。
     *
     * @param spec 分隔符字符，默认为 ":"
     * @return MAC 地址字符串
     */
    fun extractMACFromUUID(spec: String?): String {
        var spec = spec
        if (spec == null) {
            spec = ":"
        }
        val leastSigBits = uuid.leastSignificantBits
        val macLong = leastSigBits and 0xFFFFFFFFFFFFL
        val macBytes = ByteArray(6)
        for (i in 0..5) {
            macBytes[5 - i] = (macLong shr (8 * i)).toByte()
        }
        val mac = StringBuilder()
        for (i in 0..5) {
            mac.append(String.format("%02X", macBytes[i]))
            if (i < 5) {
                mac.append(spec)
            }
        }
        return mac.toString()
    }

    /**
     * 返回此 UUID 的字符串表示，包含版本信息和时间戳（如果是版本1）。
     *
     * @return UUID 的详细字符串表示
     */
    override fun toString(): String {
        return "UUID(uuid=${getString()},version=${uuid.version()})"
    }

    /**
     * 判断两个 UUID 是否相等。
     *
     * @param other 比较对象
     * @return 如果相等返回 true，否则返回 false
     */
    override fun equals(other: Any?): Boolean {
        return uuid == other
    }

    /**
     * 计算此 UUID 的哈希码。
     *
     * @return 哈希码值
     */
    override fun hashCode(): Int {
        return uuid.hashCode()
    }
}


