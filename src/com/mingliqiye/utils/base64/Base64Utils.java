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
 * CurrentFile Base64Utils.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * Base64工具类，提供对字节数组、文件和字符串的Base64编码与解码功能。
 */
public class Base64Utils {

	// Base64编码器实例
	private static final Base64.Encoder BASE_64_ENCODER = Base64.getEncoder();
	// Base64解码器实例
	private static final Base64.Decoder BASE_64_DECODER = Base64.getDecoder();

	/**
	 * 对字节数组进行Base64编码。
	 *
	 * @param bytes 待编码的字节数组
	 * @return 编码后的Base64字符串
	 */
	public static String encode(byte[] bytes) {
		return BASE_64_ENCODER.encodeToString(bytes);
	}

	/**
	 * 对文件内容进行Base64编码。
	 *
	 * @param file 待编码的文件对象
	 * @return 编码后的Base64字符串
	 * @throws RuntimeException 如果读取文件时发生IO异常
	 */
	public static String encode(File file) {
		try {
			byte[] bytes = java.nio.file.Files.readAllBytes(file.toPath());
			return encode(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据文件路径对文件内容进行Base64编码。
	 *
	 * @param filePath 文件路径
	 * @return 编码后的Base64字符串
	 */
	public static String encode(String filePath) {
		return encode(new File(filePath));
	}

	/**
	 * 安全地对文件内容进行Base64编码，出错时返回null。
	 *
	 * @param file 待编码的文件对象
	 * @return 编码后的Base64字符串，出错时返回null
	 */
	public static String encodeSafe(File file) {
		try {
			return encode(file);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 安全地根据文件路径对文件内容进行Base64编码，出错时返回null。
	 *
	 * @param filePath 文件路径
	 * @return 编码后的Base64字符串，出错时返回null
	 */
	public static String encodeSafe(String filePath) {
		try {
			return encode(filePath);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 对Base64字符串进行解码。
	 *
	 * @param base64 待解码的Base64字符串
	 * @return 解码后的字节数组
	 */
	public static byte[] decode(String base64) {
		return BASE_64_DECODER.decode(base64);
	}

	/**
	 * 安全地对Base64字符串进行解码，出错时返回null。
	 *
	 * @param base64 待解码的Base64字符串
	 * @return 解码后的字节数组，出错时返回null
	 */
	public static byte[] decodeSafe(String base64) {
		try {
			return decode(base64);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将Base64字符串解码并写入指定文件。
	 *
	 * @param base64 待解码的Base64字符串
	 * @param file   目标文件对象
	 * @throws RuntimeException 如果写入文件时发生IO异常
	 */
	public static void decodeToFile(String base64, File file) {
		try (FileOutputStream fos = new FileOutputStream(file)) {
			byte[] bytes = decode(base64);
			fos.write(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将Base64字符串解码并写入指定路径的文件。
	 *
	 * @param base64   待解码的Base64字符串
	 * @param filePath 目标文件路径
	 */
	public static void decodeToFile(String base64, String filePath) {
		decodeToFile(base64, new File(filePath));
	}

	/**
	 * 安全地将Base64字符串解码并写入指定文件，出错时返回false。
	 *
	 * @param base64 待解码的Base64字符串
	 * @param file   目标文件对象
	 * @return 成功写入返回true，否则返回false
	 */
	public static boolean decodeToFileSafe(String base64, File file) {
		try {
			decodeToFile(base64, file);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 安全地将Base64字符串解码并写入指定路径的文件，出错时返回false。
	 *
	 * @param base64   待解码的Base64字符串
	 * @param filePath 目标文件路径
	 * @return 成功写入返回true，否则返回false
	 */
	public static boolean decodeToFileSafe(String base64, String filePath) {
		return decodeToFileSafe(base64, new File(filePath));
	}

	/**
	 * 对字节数组中指定范围的数据进行Base64编码。
	 *
	 * @param bytes  源字节数组
	 * @param offset 起始偏移量
	 * @param length 要编码的数据长度
	 * @return 编码后的Base64字符串
	 */
	public static String encodeBytes(byte[] bytes, int offset, int length) {
		byte[] data = new byte[length];
		System.arraycopy(bytes, offset, data, 0, length);
		return encode(data);
	}

	public static String encodeBytes(byte[] bytes) {
		return encodeBytes(bytes, 0, bytes.length);
	}
}
