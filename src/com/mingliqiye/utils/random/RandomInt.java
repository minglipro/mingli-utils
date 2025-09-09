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
 * CurrentFile RandomInt.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author MingLiPro
 */
public class RandomInt {

	/**
	 * 生成指定范围内的随机整数
	 * @param min 最小值（包含）
	 * @param max 最大值（不包含）
	 * @return 随机整数
	 */
	public static int randomIntNoHave(int min, int max) {
		if (min > max) {
			int t = min;
			min = max;
			max = t;
		}
		if (min == max) {
			return min;
		}
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	/**
	 * 生成指定范围内的随机整数
	 * @param min 最小值（包含）
	 * @param max 最大值（包含）
	 * @return 随机整数
	 */
	public static int randomInt(int min, int max) {
		return randomIntNoHave(min, ++max);
	}
}
