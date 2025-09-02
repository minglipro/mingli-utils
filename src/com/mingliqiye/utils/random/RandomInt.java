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
