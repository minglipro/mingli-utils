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
 * CurrentFile RandomBytes.java
 * LastUpdate 2025-09-09 08:37:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.random;

import com.mingliqiye.utils.collection.ForEach;

/**
 * @author MingLiPro
 */
public class RandomBytes {

	/**
	 * 生成指定长度的随机字节数组
	 * @param length 数组长度
	 * @return 包含随机字节的数组
	 */
	public static byte[] randomBytes(int length) {
		byte[] bytes = new byte[length];
		// 使用forEach遍历数组，为每个位置生成随机字节
		ForEach.forEach(bytes, (b, i) ->
			bytes[i] = randomByte((byte) 0x00, (byte) 0xff)
		);
		return bytes;
	}

	/**
	 * 生成指定长度的随机字节数组
	 * 从给定的字节数组中随机选择字节来填充新数组
	 *
	 * @param length 要生成的随机字节数组的长度
	 * @param bytes 用于随机选择的源字节数组
	 * @return 包含随机字节的新数组
	 */
	public static byte[] randomBytes(int length, byte[] bytes) {
		byte[] rbytes = new byte[length];
		// 从源数组中随机选择字节填充到结果数组中
		for (int i = 0; i < length; i++) {
			rbytes[i] = bytes[RandomInt.randomInt(i, bytes.length - 1)];
		}
		return rbytes;
	}

	/**
	 * 生成指定范围内的随机字节
	 * @param from 起始字节值（包含）
	 * @param to 结束字节值（包含）
	 * @return 指定范围内的随机字节
	 */
	public static byte randomByte(byte from, byte to) {
		// 将byte转换为int进行计算，避免符号问题
		int fromInt = from & 0xFF;
		int toInt = to & 0xFF;
		int randomValue = RandomInt.randomInt(fromInt, toInt);
		return (byte) (randomValue & 0xFF);
	}

	/**
	 * 生成指定范围内的随机字节（不包含边界值）
	 * @param from 起始字节值（不包含）
	 * @param to 结束字节值（不包含）
	 * @return 指定范围内的随机字节
	 */
	public static byte randomByteNoHave(byte from, byte to) {
		// 将byte转换为int进行计算，避免符号问题
		int fromInt = from & 0xFF;
		int toInt = to & 0xFF;
		int randomValue = RandomInt.randomIntNoHave(fromInt, toInt);
		return (byte) (randomValue & 0xFF);
	}
}
