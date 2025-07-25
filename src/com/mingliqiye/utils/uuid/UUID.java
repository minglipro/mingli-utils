package com.mingliqiye.utils.uuid;

import com.github.f4b6a3.uuid.UuidCreator;
import com.mingliqiye.utils.string.StringUtil;
import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.time.DateTimeOffset;
import com.mingliqiye.utils.time.Formatter;
import lombok.Setter;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Objects;

/**
 * UUID 工具类，用于生成、解析和操作 UUID。
 * 支持时间戳型 UUID（版本1）以及标准 UUID 的创建与转换。
 *
 * @author MingLiPro
 */
@Setter
public class UUID implements Serializable {

    /**
     * 内部封装的 java.util.UUID 实例
     */
    private java.util.UUID uuid;

    /**
     * 构造一个由指定高位和低位组成的 UUID。
     *
     * @param msb 高64位
     * @param lsb 低64位
     */
    public UUID(long msb, long lsb) {
        uuid = new java.util.UUID(msb, lsb);
    }

    /**
     * 构造一个基于当前时间的时间戳型 UUID（版本1）。
     */
    public UUID() {
        uuid = UuidCreator.getTimeBased();
    }

    /**
     * 使用给定的 java.util.UUID 对象构造一个新的 UUID 实例。
     *
     * @param uuid java.util.UUID 实例
     */
    public UUID(java.util.UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * 根据字符串表示的 UUID 构造一个新的 UUID 实例。
     *
     * @param uuid 字符串形式的 UUID
     */
    public UUID(String uuid) {
        this.uuid = java.util.UUID.fromString(uuid);
    }

    /**
     * 将字节数组转换为 UUID 实例。
     *
     * @param bytes 表示 UUID 的 16 字节数据
     * @return 新建的 UUID 实例
     */
    public static UUID of(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long msb = bb.getLong();
        long lsb = bb.getLong();
        return new UUID(msb, lsb);
    }

    /**
     * 将字符串解析为 UUID 实例，如果解析失败则抛出 UUIDException。
     *
     * @param data UUID 字符串
     * @return 解析后的 UUID 实例
     * @throws UUIDException 如果解析失败
     */
    public static UUID ofString(String data) {
        try {
            java.util.UUID uuid1 = java.util.UUID.fromString(data);
            UUID uuid = new UUID();
            uuid.setUuid(uuid1);
            return uuid;
        } catch (Exception e) {
            throw new UUIDException(e.getMessage(), e);
        }
    }

    /**
     * 将 UUID 转换为 16 字节的字节数组。
     *
     * @return 表示该 UUID 的字节数组
     */
    public byte[] toBytes() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    /**
     * 获取内部封装的 java.util.UUID 实例。
     *
     * @return java.util.UUID 实例
     */
    public java.util.UUID GetUUID() {
        return uuid;
    }

    /**
     * 将 UUID 转换为字符串表示，默认使用小写格式。
     *
     * @return UUID 字符串
     */
    public String toUUIDString() {
        return toUUIDString(false);
    }

    /**
     * 将 UUID 转换为字符串表示，并可选择是否使用大写。
     *
     * @param u 是否使用大写格式
     * @return UUID 字符串
     * @throws UUIDException 如果 uuid 为 null
     */
    public String toUUIDString(boolean u) {
        if (uuid == null) {
            throw new UUIDException("uuid is null : NullPointerException");
        }
        if (u) {
            return uuid.toString().toUpperCase(Locale.ROOT);
        }
        return uuid.toString();
    }

    /**
     * 计算此 UUID 的哈希码。
     *
     * @return 哈希码值
     */
    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    /**
     * 判断两个 UUID 是否相等。
     *
     * @param o 比较对象
     * @return 如果相等返回 true，否则返回 false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UUID uuid = (UUID) o;
        return Objects.equals(this.uuid, uuid.uuid);
    }

    /**
     * 返回此 UUID 的字符串表示，包含版本信息和时间戳（如果是版本1）。
     *
     * @return UUID 的详细字符串表示
     */
    @Override
    public String toString() {
        if (uuid == null) {
            return "UUID(null)";
        }
        if (uuid.version() == 1) {
            return StringUtil.format(
                "UUID(uuid={},time={},mac={},version={})",
                toUUIDString(true),
                getDateTime().format(Formatter.STANDARD_DATETIME),
                extractMACFromUUID(),
                uuid.version()
            );
        }
        return StringUtil.format(
            "UUID(uuid={},version={})",
            toUUIDString(true),
            uuid.version()
        );
    }

    /**
     * 从时间戳型 UUID 中提取时间戳并转换为 DateTime 对象。
     *
     * @return 对应的 DateTime 对象；如果 uuid 为 null，则返回 null
     */
    public DateTime getDateTime() {
        if (uuid == null) {
            return null;
        }
        return DateTime.of(uuid.timestamp() / 10_000).add(
            DateTimeOffset.of(-141427L, ChronoUnit.DAYS)
        );
    }

    /**
     * 从时间戳型 UUID 中提取 MAC 地址，默认使用冒号分隔符。
     *
     * @return MAC 地址字符串
     * @throws UUIDException 如果 uuid 为 null
     */
    public String extractMACFromUUID() {
        return extractMACFromUUID(null);
    }

    /**
     * 从时间戳型 UUID 中提取 MAC 地址，并允许自定义分隔符。
     *
     * @param spec 分隔符字符，默认为 ":"
     * @return MAC 地址字符串
     * @throws UUIDException 如果 uuid 为 null
     */
    public String extractMACFromUUID(String spec) {
        if (uuid == null) {
            throw new UUIDException("uuid is null : NullPointerException");
        }
        if (spec == null) {
            spec = ":";
        }
        long leastSigBits = uuid.getLeastSignificantBits();
        long macLong = leastSigBits & 0xFFFFFFFFFFFFL;
        byte[] macBytes = new byte[6];
        // 提取 MAC 地址的每个字节
        for (int i = 0; i < 6; i++) {
            macBytes[5 - i] = (byte) (macLong >> (8 * i));
        }
        StringBuilder mac = new StringBuilder();
        // 构造 MAC 地址字符串
        for (int i = 0; i < 6; i++) {
            mac.append(String.format("%02X", macBytes[i]));
            if (i < 5) {
                mac.append(spec);
            }
        }
        return mac.toString();
    }
}
