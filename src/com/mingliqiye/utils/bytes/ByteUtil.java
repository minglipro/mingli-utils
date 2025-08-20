package com.mingliqiye.utils.bytes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MingLiPro
 *
 * 字节数组处理工具类
 */
public class ByteUtil {

	/**
	 * 将字节数组转换为十六进制字符串列表
	 * <p>
	 * 每个字节都会被转换为两位的十六进制字符串表示形式
	 * 例如: 字节值为10的字节会被转换为"0a"，值为255的字节会被转换为"ff"
	 *
	 * @param bytes 输入的字节数组
	 * @return 包含每个字节对应十六进制字符串的列表
	 */
	public static List<String> getByteArrayString(byte[] bytes) {
		List<Byte> byteList = new ArrayList<>(bytes.length);
		for (byte aByte : bytes) {
			byteList.add(aByte);
		}
		return byteList
			.stream()
			.map(a -> String.format("%02x", a & 0xFF))
			.collect(Collectors.toList());
	}
}
