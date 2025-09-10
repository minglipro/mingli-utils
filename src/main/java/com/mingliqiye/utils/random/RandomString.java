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
 * CurrentFile RandomString.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.random;

/**
 * 随机字符串生成工具类
 * 提供生成指定长度随机字符串的功能
 *
 * @author MingLiPro
 */
public class RandomString {

	/**
	 * 生成指定长度和字符集的随机字符串
	 *
	 * @param length 要生成的随机字符串长度
	 * @param chars  用于生成随机字符串的字符集
	 * @return 指定长度的随机字符串
	 */
	public static String randomString(int length, String chars) {
		String[] charsd = chars.split("");
		StringBuilder sb = new StringBuilder(length);
		// 循环生成随机字符并拼接
		for (int i = 0; i < length; i++) {
			int index = RandomInt.randomInt(0, charsd.length - 1);
			sb.append(charsd[index]);
		}
		return sb.toString();
	}

	/**
	 * 生成指定长度的随机字符串，使用默认字符集(数字+大小写字母)
	 *
	 * @param length 要生成的随机字符串长度
	 * @return 指定长度的随机字符串
	 */
	public static String randomString(int length) {
		return randomString(
			length,
			"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
		);
	}
}
