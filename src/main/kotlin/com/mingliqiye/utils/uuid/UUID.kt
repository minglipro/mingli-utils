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
 * CurrentFile UUID.kt
 * LastUpdate 2026-02-06 14:33:24
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.uuid

import com.mingliqiye.utils.base.*
import com.mingliqiye.utils.io.IO.println
import com.mingliqiye.utils.random.randomByte
import com.mingliqiye.utils.random.secureRandom
import com.mingliqiye.utils.system.macAddressBytes
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.DateTimeOffset
import java.io.Serializable
import java.nio.ByteBuffer
import java.security.MessageDigest
import java.time.temporal.ChronoUnit
import java.util.UUID as JUUID


/**
 * UUID 类用于生成和操作不同版本的 UUID（通用唯一标识符）。
 * 支持 UUID 的序列化、转换、解析和时间/版本信息提取。
 */
class UUID : Serializable {
    private val data: ByteArray
    private val mostSigBits: Long
    private val leastSigBits: Long
    private val version: Int

    companion object {

        /**
         * 预期 UUID 字符串中连字符的位置数组。
         */
        @JvmStatic
        val expectedHyphenPositions = intArrayOf(8, 13, 18, 23)

        /**
         * UUID 纪元偏移量（以天为单位）。
         */
        @JvmStatic
        val UUID_EPOCH_OFFSET = 141427L


        @JvmStatic
        fun ofBase64ShortString(baseShortString: String): UUID {
            return UUID(BASE64.decode(baseShortString))
        }

        @JvmStatic
        fun ofBase256ShortString(baseShortString: String): UUID {
            return UUID(BASE256.decode(baseShortString))
        }

        @JvmStatic
        fun ofBase91ShortString(baseShortString: String): UUID {
            return UUID(BASE91.decode(baseShortString))
        }

        /**
         * 生成一个 UUID V1 版本，使用系统时钟、随机数和 MAC 地址。
         * 如果 MAC 地址为空，则使用随机生成的 MAC 地址。
         *
         * @return UUID V1 实例
         */
        @JvmStatic
        fun getV1(): UUID {
            val time = DateTime.now().add(DateTimeOffset.of(UUID_EPOCH_OFFSET, ChronoUnit.DAYS)).to100NanoTime()

            val timeLow = (time and 0xFFFFFFFFL).toInt()
            val timeMid = ((time shr 32) and 0xFFFFL).toShort()
            val timeHighAndVersion = (((time shr 48) and 0x0FFFL) or 0x1000L).toShort()
            val clockSeq = (secureRandom.nextInt(16384)) and 0x3FFF

            val byteBuffer = ByteBuffer.wrap(ByteArray(16))
            byteBuffer.putInt(timeLow)
            byteBuffer.putShort(timeMid)
            byteBuffer.putShort(timeHighAndVersion)
            byteBuffer.putShort(clockSeq.toShort())
            byteBuffer.put(macAddressBytes)

            return UUID(byteBuffer.array())
        }

        /**
         * 生成一个 UUID V4 版本，使用加密安全的随机数。
         *
         * @return UUID V4 实例
         */
        @JvmStatic
        fun getV4(): UUID {
            val randomBytes = randomByte(16)
            randomBytes[6] = (randomBytes[6].toInt() and 0x0F).toByte()
            randomBytes[6] = (randomBytes[6].toInt() or 0x40).toByte()
            randomBytes[8] = (randomBytes[8].toInt() and 0x3F).toByte()
            randomBytes[8] = (randomBytes[8].toInt() or 0x80).toByte()
            return UUID(randomBytes)
        }

        /**
         * 生成一个 UUID V3 版本，基于命名空间和名称的 MD5 哈希值。
         *
         * @param namepath 命名空间 UUID
         * @param user 用户提供的字符串
         * @return UUID V3 实例
         */
        @JvmStatic
        fun getV3(namepath: UUID, user: String): UUID {
            val md = MessageDigest.getInstance("MD5")
            val userB = user.toByteArray()
            val array = md.digest(
                ByteBuffer.wrap(ByteArray(16 + userB.size)).put(namepath.data).put(userB).array()
            )
            array[6] = (array[6].toInt() and 0x0F or 0x30).toByte()
            array[8] = (array[8].toInt() and 0x3F or 0x80).toByte()
            return UUID(array)
        }

        /**
         * 生成一个 UUID V5 版本，基于命名空间和名称的 SHA-1 哈希值。
         *
         * @param namepath 命名空间 UUID
         * @param user 用户提供的字符串
         * @return UUID V5 实例
         */
        @JvmStatic
        fun getV5(namepath: UUID, user: String): UUID {
            val sha1 = MessageDigest.getInstance("SHA-1")
            val userB = user.toByteArray()
            val array = sha1.digest(
                ByteBuffer.wrap(ByteArray(namepath.data.size + userB.size)).put(namepath.data).put(userB).array()
            )
            array[6] = (array[6].toInt() and 0x0F or 0x50).toByte()
            array[8] = (array[8].toInt() and 0x3F or 0x80).toByte()
            return UUID(ByteBuffer.wrap(ByteArray(16)).put(array, 0, 16).array())
        }

        /**
         * 生成一个 UUID V6 版本，使用时间戳和随机节点信息。
         *
         * @return UUID V6 实例
         */
        @JvmStatic
        fun getV6(): UUID {
            val timestamp = DateTime.now()
                .add(DateTimeOffset.of(UUID_EPOCH_OFFSET, ChronoUnit.DAYS))
                .to100NanoTime() and 0x0FFFFFFFFFFFFFFFL
            val timeHigh = (timestamp ushr 12) and 0xFFFFFFFFFFFFL
            val timeMid = timestamp and 0x0FFFL
            val clockSeq = secureRandom.nextInt(16384) and 0x3FFF
            val node = secureRandom.nextLong() and 0x0000FFFFFFFFFFFFL
            val buffer = ByteBuffer.allocate(16)
            buffer.putLong((timeHigh shl 16) or (0x6000L) or (timeMid and 0x0FFF))
            buffer.putShort((0x8000 or (clockSeq and 0x3FFF)).toShort())
            buffer.put((node shr 40).toByte())
            buffer.put((node shr 32).toByte())
            buffer.put((node shr 24).toByte())
            buffer.put((node shr 16).toByte())
            buffer.put((node shr 8).toByte())
            buffer.put(node.toByte())
            return UUID(buffer.array())
        }

        /**
         * 生成一个 UUID V7 版本，使用毫秒级时间戳和随机数。
         *
         * @return UUID V7 实例
         */
        @JvmStatic
        fun getV7(): UUID {
            val instant = DateTime.now().toMillisecondTime()
            val buffer = ByteBuffer.allocate(16)
            buffer.putInt((instant shr 16).toInt())
            buffer.putShort((instant).toShort())
            buffer.put(randomByte(2))
            buffer.putLong(secureRandom.nextLong())
            val bytes = buffer.array()
            bytes[6] = (bytes[6].toInt() and 0x0F or 0x70).toByte()
            bytes[8] = (bytes[8].toInt() and 0x3F or 0x80).toByte()
            return UUID(bytes)
        }

        /**
         * 根据字符串创建 UUID 实例。
         *
         * @param uuid UUID 字符串
         * @return UUID 实例
         */
        @JvmStatic
        fun of(uuid: String): UUID {
            return UUID(uuid)
        }

        /**
         * 根据字节数组创建 UUID 实例。
         *
         * @param uuid UUID 字节数组
         * @return UUID 实例
         */
        @JvmStatic
        fun of(uuid: ByteArray): UUID {
            return UUID(uuid)
        }

        /**
         * 根据高位和低位长整型创建 UUID 实例。
         *
         * @param msb 高位长整型
         * @param lsb 低位长整型
         * @return UUID 实例
         */
        @JvmStatic
        fun of(msb: Long, lsb: Long): UUID {
            return UUID(msb, lsb)
        }

        /**
         * 从ByteBuffer创建UUID对象
         *
         * @param byteBuffer 包含UUID字节数据的ByteBuffer对象，必须包含至少16个字节的数据
         * @return 从ByteBuffer中读取的16个字节创建的UUID对象
         */
        @JvmStatic
        fun of(byteBuffer: ByteBuffer): UUID {
            val byte = ByteArray(16)
            byteBuffer.get(byte)
            return UUID(byte)
        }

        /**
         * 根据 MySQL UUID 字节数组创建 UUID 实例。
         *
         * @param byteArray MySQL UUID 字节数组
         * @return UUID 实例
         */
        @JvmStatic
        fun ofMysqlUUID(byteArray: ByteArray): UUID {
            return UUID(mysqlToUuid(byteArray))
        }

        /**
         * 根据 MySQL UUID 实例创建 UUID 实例。
         *
         * @param uuid MySQL UUID 实例
         * @return UUID 实例
         */
        @JvmStatic
        fun ofMysqlUUID(uuid: UUID): UUID {
            return UUID(mysqlToUuid(uuid.data))
        }

        /**
         * 获取最大 UUID（所有字节为 0xFF）。
         *
         * @return 最大 UUID 实例
         */
        @JvmStatic
        fun getMaxUUID(): UUID {
            return UUID(
                ByteArray(
                    16
                ) { 0xFF.toByte() }
            )
        }

        /**
         * 获取最小 UUID（所有字节为 0x00）。
         *
         * @return 最小 UUID 实例
         */
        @JvmStatic
        fun getMinUUID(): UUID {
            return UUID(
                ByteArray(
                    16
                ) { 0x00.toByte() }
            )
        }

        /**
         * 将 Java UUID 转换为自定义 UUID 实例。
         *
         * @receiver Java UUID 实例
         * @return 自定义 UUID 实例
         */
        @JvmStatic
        @JvmName("ofJUUID")
        fun JUUID.toMLUUID(): UUID {
            return UUID(this)
        }

        /**
         * 从字符串解析 UUID 字节数组。
         *
         * @param uuidString UUID 字符串
         * @return UUID 字节数组
         */
        private fun fromString(uuidString: String): ByteArray {
            val cleanStr = when (uuidString.length) {
                36 -> {
                    for (i in expectedHyphenPositions) {
                        if (uuidString[i] != '-') {
                            throw IllegalArgumentException("Invalid UUID string: $uuidString at index $i")
                        }
                    }
                    uuidString.replace("-", "")
                }

                32 -> uuidString
                else -> throw IllegalArgumentException("Invalid UUID string: $uuidString")
            }

            // 直接按索引提取各段并校验
            val segments = arrayOf(
                cleanStr.take(8),
                cleanStr.substring(8, 12),
                cleanStr.substring(12, 16),
                cleanStr.substring(16, 20),
                cleanStr.substring(20, 32)
            )

            for (segment in segments) {
                if (!segment.matches(Regex("^[0-9A-Fa-f]+$"))) {
                    throw IllegalArgumentException("Invalid UUID segment: $segment")
                }
            }

            return cleanStr.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
        }

        /**
         * 将 MAC 地址字节数组转换为长整型。
         *
         * @param mac MAC 地址字节数组（必须为 6 字节）
         * @return MAC 地址对应的长整型值
         */
        private fun macBytesToLong(mac: ByteArray): Long {
            require(mac.size == 6) { "MAC地址必须是6字节" }
            var result = 0L
            for (i in 0 until 6) {
                result = (result shl 8) or (mac[i].toLong() and 0xFF)
            }
            return result
        }

        fun of(str: String, base: BaseType): UUID {
            return UUID(base.baseCodec.decode(str))
        }

    }

    /**
     * 构造函数，根据字节数组初始化 UUID。
     *
     * @param data UUID 字节数组（必须为 16 字节）
     */
    constructor(data: ByteArray) {
        require(data.size == 16) { "UUID byte array length must be 16" }
        this.data = data
        val bb: ByteBuffer = ByteBuffer.wrap(data)
        mostSigBits = bb.long
        leastSigBits = bb.long
        version = (mostSigBits shr 12 and 0xF).toInt()
    }

    /**
     * 构造函数，根据高位和低位长整型初始化 UUID。
     *
     * @param msb 高位长整型
     * @param lsb 低位长整型
     */
    constructor(msb: Long, lsb: Long) {
        mostSigBits = msb
        leastSigBits = lsb
        val bb: ByteBuffer = ByteBuffer.wrap(ByteArray(16))
        bb.putLong(msb)
        bb.putLong(lsb)
        this.data = bb.array()
        version = (mostSigBits shr 12 and 0xF).toInt()
    }

    /**
     * 构造函数，根据 Java UUID 初始化自定义 UUID。
     *
     * @param juuid Java UUID 实例
     */
    constructor(juuid: JUUID) {
        mostSigBits = juuid.mostSignificantBits
        leastSigBits = juuid.leastSignificantBits
        val bb: ByteBuffer = ByteBuffer.wrap(ByteArray(16))
        bb.putLong(mostSigBits)
        bb.putLong(leastSigBits)
        this.data = bb.array()
        version = (mostSigBits shr 12 and 0xF).toInt()
    }

    /**
     * 构造函数，根据字符串初始化 UUID。
     *
     * @param uuid UUID 字符串
     */
    constructor(uuid: String) {
        fromString(uuid).let {
            val bb: ByteBuffer = ByteBuffer.wrap(it)
            mostSigBits = bb.long
            leastSigBits = bb.long
            this.data = it
            version = (mostSigBits shr 12 and 0xF).toInt()
        }
    }

    /**
     * 返回 UUID 的字节数组表示。
     *
     * @return UUID 字节数组
     */
    fun toBytes(): ByteArray {
        return data
    }

    fun writeToByteBuffer(byteBuffer: ByteBuffer): ByteBuffer {
        return byteBuffer.put(data)
    }

    /**
     * 返回 UUID 的高位长整型部分。
     *
     * @return 高位长整型
     */
    fun getMostSignificantBits(): Long {
        return mostSigBits
    }

    /**
     * 返回 UUID 的低位长整型部分。
     *
     * @return 低位长整型
     */
    fun getLeastSignificantBits(): Long {
        return leastSigBits
    }

    /**
     * 返回 UUID 的字符串表示。
     *
     * @param isUpper 是否使用大写字母（默认为 false）
     * @return UUID 字符串
     */
    fun getString(isUpper: Boolean = false): String {
        return getString().let {
            if (isUpper) {
                it.uppercase()
            } else it
        }
    }

    /**
     * 返回 UUID 的字符串表示。
     *
     * @param isUpper 是否使用大写字母（默认为 false）
     * @param isnotSpace 是否移除连字符（默认为 false）
     * @return UUID 字符串
     */
    fun getString(isUpper: Boolean = false, isnotSpace: Boolean = false): String {
        return getString(isUpper).let {
            if (isnotSpace) {
                it.replace("-", "")
            } else it
        }
    }

    fun getString(uuidFormatType: UUIDFormatType): String {
        return getString(isUpper = uuidFormatType.isUpper, isnotSpace = uuidFormatType.isnotSpace)
    }

    fun getString(baseType: BaseType): String {
        return getString(baseType.baseCodec)
    }

    fun getString(baseCodec: BaseCodec): String {
        return baseCodec.encode(data)
    }

    /**
     * 返回标准格式的 UUID 字符串（带连字符）。
     *
     * @return 标准格式的 UUID 字符串
     */
    // 优化后的 toString 方法
    fun getString(): String {
        return buildString(36) {
            val msbHigh = (mostSigBits ushr 32).toInt()
            val msbMid = ((mostSigBits ushr 16) and 0xFFFF).toInt()
            val msbLow = (mostSigBits and 0xFFFF).toInt()
            val lsbHigh = ((leastSigBits ushr 48) and 0xFFFF).toInt()
            val lsbLow = (leastSigBits and 0xFFFFFFFFFFFFL)

            append(msbHigh.toHexString())
            append('-')
            append(msbMid.toShort().toHexString(4))
            append('-')
            append(msbLow.toShort().toHexString(4))
            append('-')
            append(lsbHigh.toShort().toHexString(4))
            append('-')
            append(lsbLow.toHexString(12))
        }
    }

    /**
     * 将长整型转换为指定长度的十六进制字符串。
     *
     * @param length 字符串长度
     * @return 十六进制字符串
     */
    private fun Long.toHexString(length: Int): String {
        return this.toString(16).padStart(length, '0')
    }

    /**
     * 将短整型转换为指定长度的十六进制字符串。
     *
     * @param length 字符串长度
     * @return 十六进制字符串
     */
    private fun Short.toHexString(length: Int): String {
        return this.toLong().and(0xFFFF).toString(16).padStart(length, '0')
    }

    /**
     * 返回 MySQL 格式的 UUID 字节数组。
     *
     * @return MySQL 格式的 UUID 字节数组
     */
    fun toMysql(): ByteArray {
        return uuidToMysql(this.data)
    }

    /**
     * 返回 MySQL 格式的 UUID 实例。
     *
     * @return MySQL 格式的 UUID 实例
     */
    fun toMysqlUUID(): UUID {
        return of(uuidToMysql(this.data))
    }

    /**
     * 比较两个 UUID 是否相等。
     *
     * @param other 另一个对象
     * @return 如果相等则返回 true，否则返回 false
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return when (other) {
            is UUID -> {
                this.println()
                other.println()
                this.data.contentEquals(other.data)
            }

            is JUUID -> {
                other.mostSignificantBits == this.getMostSignificantBits() && other.leastSignificantBits == this.getLeastSignificantBits()
            }

            else -> {
                false
            }
        }
    }

    /**
     * 返回对应的 Java UUID 实例。
     *
     * @return Java UUID 实例
     */
    fun getUuid(): JUUID {
        return JUUID(mostSigBits, leastSigBits)
    }

    /**
     * 返回 UUID 的版本号。
     *
     * @return 版本号
     */
    fun getVersion(): Int {
        return version
    }

    /**
     * 计算 UUID 的哈希码。
     *
     * @return 哈希码
     */
    override fun hashCode(): Int {
        return data.contentHashCode()
    }

    /**
     * 返回 UUID 的字符串表示。
     *
     * @return 包含 UUID 和版本号的字符串
     */
    override fun toString(): String {
        when (version) {
            1 -> {
                return "UUID(uuid=${getString()},version=${version},datetime=${getDateTime()},mac=${getMac()})"
            }

            6, 7 -> {
                return "UUID(uuid=${getString()},version=${version},datetime=${getDateTime()})"
            }
        }
        return "UUID(uuid=${getString()},version=${version})"
    }

    /**
     * 根据 UUID 版本提取对应的时间信息。
     *
     * @return 对应的时间信息
     */
    fun getDateTime(): DateTime {

        when (version) {
            1 -> {
                val timestamp =
                    ((mostSigBits and 0x0FFFL) shl 48 or (((mostSigBits shr 16) and 0x0FFFFL) shl 32) or (mostSigBits ushr 32))
                val timestampBigInt = java.math.BigInteger.valueOf(timestamp)
                val nanosecondsBigInt = timestampBigInt.multiply(java.math.BigInteger.valueOf(100L))
                val divisor = java.math.BigInteger.valueOf(1_000_000_000L)
                val seconds = nanosecondsBigInt.divide(divisor)
                val nanos = nanosecondsBigInt.remainder(divisor)
                return DateTime.of(seconds.toLong(), nanos.toLong())
                    .sub(DateTimeOffset.of(ChronoUnit.DAYS, UUID_EPOCH_OFFSET))
            }

            6 -> {
                val timeHigh = (
                        ((data[0].toLong() and 0xFF) shl 40) or
                                ((data[1].toLong() and 0xFF) shl 32) or
                                ((data[2].toLong() and 0xFF) shl 24) or
                                ((data[3].toLong() and 0xFF) shl 16) or
                                ((data[4].toLong() and 0xFF) shl 8) or
                                (data[5].toLong() and 0xFF)
                        )
                val timeMidAndVersion = ((data[6].toInt() and 0xFF) shl 8) or (data[7].toInt() and 0xFF)
                val timeMid = timeMidAndVersion and 0x0FFF
                val hundredNanosSinceUuidEpoch = (timeHigh shl 12) or timeMid.toLong()
                val seconds = hundredNanosSinceUuidEpoch / 10_000_000
                val nanos = (hundredNanosSinceUuidEpoch % 10_000_000) * 100
                return DateTime.of(seconds, nanos).sub(DateTimeOffset.of(ChronoUnit.DAYS, UUID_EPOCH_OFFSET))
            }

            7 -> {
                val times =
                    (data[0].toLong() and 0xFF shl 40) or
                            (data[1].toLong() and 0xFF shl 32) or
                            (data[2].toLong() and 0xFF shl 24) or
                            (data[3].toLong() and 0xFF shl 16) or
                            (data[4].toLong() and 0xFF shl 8) or
                            (data[5].toLong() and 0xFF)
                return DateTime.of(times)
            }

            else -> {
                throw IllegalArgumentException("UUID version is $version not v1 or v6 or v7 : not supported  ")
            }
        }
    }

    /**
     * 提取 UUID V1 中的 MAC 地址，默认使用冒号分隔符。
     *
     * @return MAC 地址字符串
     */
    fun getMac(): String {
        return getMac(":")
    }

    fun getBase64ShortString(): String {
        return BASE64.encode(data).substring(0, 22)
    }

    fun getBase91ShortString(): String {
        return BASE91.encode(data)
    }

    fun getBase256ShortString(): String {
        return BASE256.encode(data)
    }

    /**
     * 提取 UUID V1 中的 MAC 地址。
     *
     * @param spec 分隔符（默认为冒号）
     * @return MAC 地址字符串
     */
    fun getMac(spec: String = ":"): String {
        if (version != 1) {
            throw IllegalArgumentException("UUID version is $version not v1 : not supported  ")
        }
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
}
