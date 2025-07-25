package com.mingliqiye.utils.minecraft.slp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mingliqiye.utils.network.NetworkEndpoint;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Minecraft 服务器列表协议（Server List Ping, SLP）工具类。
 * 提供了与 Minecraft 服务器通信以获取其状态信息的功能。
 */
public class SLP {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将 int32 值截断为无符号 short（2 字节）并按大端序写入字节数组。
     *
     * @param value 需要转换的整数（int32）
     * @return 包含两个字节的数组，表示无符号 short
     */
    public static byte[] toUnsignedShort(int value) {
        byte[] array = new byte[2];
        ByteBuffer.wrap(array, 0, 2)
            .order(ByteOrder.BIG_ENDIAN)
            .putShort((short) (value & 0xFFFF));
        return array;
    }

    /**
     * 构造 Minecraft 握手包数据。
     * 握手包用于初始化客户端与服务器之间的连接。
     *
     * @param serverIP   服务器 IP 地址或域名
     * @param serverPort 服务器端口号
     * @param type       连接类型（通常为 1 表示获取状态）
     * @return 握手包的完整字节数组
     * @throws IOException 如果构造过程中发生 IO 错误
     */
    public static byte[] getHandshakePack(
        String serverIP,
        int serverPort,
        int type
    ) throws IOException {
        ByteArrayOutputStream pack = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream =
            new ByteArrayOutputStream();
        pack.write(0x00); // 握手包标识符
        pack.write(toVarInt(1156)); // 协议版本号（示例值）
        byte[] sip = serverIP.getBytes();
        pack.write(toVarInt(sip.length)); // 服务器地址长度
        pack.write(sip); // 服务器地址
        pack.write(toUnsignedShort(serverPort)); // 服务器端口
        pack.write(toVarInt(type)); // 下一阶段类型（1 表示状态请求）
        byteArrayOutputStream.write(toVarInt(pack.size())); // 包长度前缀
        byteArrayOutputStream.write(pack.toByteArray());

        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 获取状态请求包的固定字节表示。
     * 此包用于向服务器请求当前状态信息。
     *
     * @return 状态请求包的字节数组
     */
    public static byte[] getStatusPack() {
        return new byte[] { 0x01, 0x00 };
    }

    /**
     * 从输入流中读取服务器返回的状态 JSON 数据，并解析为 MinecraftServerStatus 实体对象。
     *
     * @param inputStream 输入流，包含服务器响应的数据
     * @return 解析后的 MinecraftServerStatus 对象
     * @throws IOException 如果读取过程中发生 IO 错误
     */
    public static MinecraftServerStatus getStatusJsonEntity(
        DataInputStream inputStream
    ) throws IOException {
        readVarInt(inputStream); // 忽略第一个 VarInt（包长度）
        inputStream.readByte(); // 忽略包标识符
        int lengthjson = readVarInt(inputStream); // 读取 JSON 数据长度
        byte[] data = new byte[lengthjson];
        inputStream.readFully(data); // 读取完整的 JSON 数据
        MinecraftServerStatus serverStatus = objectMapper.readValue(
            data,
            MinecraftServerStatus.class
        );
        serverStatus.setJsonData(new String(data)); // 设置原始 JSON 字符串
        return serverStatus;
    }

    /**
     * 从输入流中读取一个 VarInt 类型的整数（最多 5 个字节）。
     *
     * @param in 输入流
     * @return 解码后的整数值
     * @throws IOException 如果读取过程中发生 IO 错误
     */
    public static int readVarInt(DataInputStream in) throws IOException {
        int value = 0;
        int length = 0;
        byte currentByte;
        do {
            currentByte = in.readByte();
            value |= (currentByte & 0x7F) << (length * 7);
            length += 1;
            if (length > 5) {
                throw new RuntimeException("VarInt too long");
            }
        } while ((currentByte & 0x80) != 0);
        return value;
    }

    /**
     * 将一个 int32 整数编码为 VarInt 格式的字节数组（1 到 5 个字节）。
     *
     * @param value 需要编码的整数
     * @return 编码后的 VarInt 字节数组
     */
    public static byte[] toVarInt(int value) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        while (true) {
            if ((value & 0xFFFFFF80) == 0) {
                buffer.write(value); // 最后一个字节
                break;
            }
            buffer.write((value & 0x7F) | 0x80); // 写入带继续位的字节
            value >>>= 7; // 右移 7 位继续处理
        }
        return buffer.toByteArray();
    }

    /**
     * 创建一个新的 Socket 连接到指定的网络端点，并设置超时时间。
     *
     * @param networkEndpoint 目标网络端点（包括主机和端口）
     * @return 已连接的 Socket 实例
     * @throws IOException 如果连接失败或发生 IO 错误
     */
    public static Socket getNewConnect(NetworkEndpoint networkEndpoint)
        throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(5000); // 设置读取超时时间为 5 秒
        socket.connect(networkEndpoint.toInetSocketAddress()); // 执行连接操作
        return socket;
    }

    /**
     * 使用 "host:port" 格式的字符串连接到 Minecraft 服务器并获取其状态信息。
     *
     * @param s 域名或 IP 地址加端口号组成的字符串，例如 "127.0.0.1:25565"
     * @return 服务器状态实体对象
     * @throws IOException 如果连接失败或发生 IO 错误
     */
    public static MinecraftServerStatus getServerStatus(String s)
        throws IOException {
        return getServerStatus(NetworkEndpoint.of(s));
    }

    /**
     * 使用指定的主机名和端口号连接到 Minecraft 服务器并获取其状态信息。
     *
     * @param s 主机名或 IP 地址
     * @param i 端口号
     * @return 服务器状态实体对象
     * @throws IOException 如果连接失败或发生 IO 错误
     */
    public static MinecraftServerStatus getServerStatus(String s, Integer i)
        throws IOException {
        return getServerStatus(NetworkEndpoint.of(s, i));
    }

    /**
     * 使用 NetworkEndpoint 实例连接到 Minecraft 服务器并获取其状态信息。
     *
     * @param e 网络端点实例，包含主机和端口信息
     * @return 服务器状态实体对象
     * @throws IOException 如果连接失败或发生 IO 错误
     * @see NetworkEndpoint
     */
    public static MinecraftServerStatus getServerStatus(NetworkEndpoint e)
        throws IOException {
        Socket socket = getNewConnect(e); // 建立 TCP 连接
        OutputStream out = socket.getOutputStream(); // 获取输出流发送数据
        DataInputStream in = new DataInputStream(socket.getInputStream()); // 获取输入流接收数据
        out.write(getHandshakePack(e.getHost(), e.getPort(), 1)); // 发送握手包
        out.write(getStatusPack()); // 发送状态请求包
        return getStatusJsonEntity(in); // 读取并解析服务器响应
    }
}
