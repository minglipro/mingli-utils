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
 * CurrentFile ByteUtil.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

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

	public static final byte ESC_ASC = 0x1A;
	public static final byte ESC_DESC = 0x1B;
	public static final byte ESC_NONE = 0x00;
	public static final byte ESC_START = 0x01;
	public static final byte ESC_END = 0x02;
	public static final byte ESC_ESC = 0x03;
	public static final byte ESC_CONTROL = 0x04;
	public static final byte ESC_DATA = 0x05;
	public static final byte ESC_RESERVED = 0x06;

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
