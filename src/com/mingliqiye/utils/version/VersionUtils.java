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
 * CurrentFile VersionUtils.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.version;

import java.util.Objects;

/**
 * 版本工具类，提供版本比较相关的方法
 */
public class VersionUtils {

	/**
	 * 判断当前版本是否比另一个版本新
	 *
	 * @param now 当前版本号字符串，格式如"1.0.0"
	 * @param other 要比较的版本号字符串，格式如"2.0.0"
	 * @return 如果当前版本更新则返回true，否则返回false
	 */
	public static boolean isNew(String now, String other) {
		String[] currentParts = now.split("\\.");
		String[] minimumParts = other.split("\\.");

		for (
			int i = 0;
			i < Math.max(currentParts.length, minimumParts.length);
			i++
		) {
			int currentNum = i < currentParts.length
				? Integer.parseInt(currentParts[i])
				: 0;
			int minimumNum = i < minimumParts.length
				? Integer.parseInt(minimumParts[i])
				: 0;

			if (currentNum < minimumNum) {
				return true;
			} else if (currentNum > minimumNum) {
				return false;
			}
		}
		return false;
	}

	/**
	 * 判断当前版本是否比另一个版本旧
	 *
	 * @param now 当前版本号字符串，格式如"1.0.0"
	 * @param other 要比较的版本号字符串，格式如"2.0.0"
	 * @return 如果当前版本更旧则返回true，否则返回false
	 */
	public static boolean isOld(String now, String other) {
		return !equals(now, other) && !isNew(now, other);
	}

	/**
	 * 判断两个版本号是否相等
	 *
	 * @param now 当前版本号字符串，格式如"1.0.0"
	 * @param other 要比较的版本号字符串，格式如"2.0.0"
	 * @return 如果两个版本号相等则返回true，否则返回false
	 */
	public static boolean equals(String now, String other) {
		return Objects.equals(now, other);
	}

	/**
	 * 比较两个版本号的大小关系
	 *
	 * @param now 当前版本号字符串，格式如"1.0.0"
	 * @param other 要比较的版本号字符串，格式如"2.0.0"
	 * @return 如果当前版本更新返回2，如果更旧返回0，如果相等返回1
	 */
	public static byte is(String now, String other) {
		if (isNew(now, other)) {
			return 2;
		} else if (isOld(now, other)) {
			return 0;
		} else {
			return 1;
		}
	}
}
