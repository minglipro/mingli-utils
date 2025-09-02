package com.mingliqiye.utils.random;

/**
 * @author MingLiPro
 */
public class RandomString {

	public static String randomString(int length, String chars) {
		String[] charsd = chars.split("");
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = RandomInt.randomInt(0, charsd.length - 1);
			sb.append(charsd[index]);
		}
		return sb.toString();
	}

	public static String randomString(int length) {
		return randomString(
			length,
			"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
		);
	}
}
