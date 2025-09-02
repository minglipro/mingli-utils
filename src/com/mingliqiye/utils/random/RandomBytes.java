package com.mingliqiye.utils.random;

import com.mingliqiye.utils.collection.ForEach;

/**
 * @author MingLiPro
 */
public class RandomBytes {

	public static byte[] randomBytes(int length) {
		byte[] bytes = new byte[length];
		ForEach.forEach(bytes, (b, i) ->
			bytes[i] = randomByte((byte) 0x00, (byte) 0xff)
		);
		return bytes;
	}

	public static byte randomByte(byte from, byte to) {
		int fromInt = from & 0xFF;
		int toInt = to & 0xFF;
		int randomValue = RandomInt.randomInt(fromInt, toInt);
		return (byte) (randomValue & 0xFF);
	}

	public static byte randomByteNoHave(byte from, byte to) {
		int fromInt = from & 0xFF;
		int toInt = to & 0xFF;
		int randomValue = RandomInt.randomIntNoHave(fromInt, toInt);
		return (byte) (randomValue & 0xFF);
	}
}
