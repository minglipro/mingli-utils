package com.mingliqiye.utils.hash;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.mindrot.jbcrypt.BCrypt;

/**
 * 提供常用的哈希计算工具方法，包括文件哈希值计算、BCrypt 加密等。
 *
 * @author MingLiPro
 */
public class HashUtils {

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * 计算指定文件的哈希值。
	 *
	 * @param file      要计算哈希值的文件对象
	 * @param algorithm 使用的哈希算法名称（如 SHA-256、MD5 等）
	 * @return 文件的十六进制格式哈希值字符串
	 * @throws IOException              当文件不存在或读取过程中发生 I/O 错误时抛出
	 * @throws NoSuchAlgorithmException 当指定的哈希算法不可用时抛出
	 */
	public static String calculateFileHash(File file, String algorithm)
		throws IOException, NoSuchAlgorithmException {
		// 检查文件是否存在
		if (!file.exists()) {
			throw new IOException("File not found: " + file.getAbsolutePath());
		}

		MessageDigest digest = MessageDigest.getInstance(algorithm);

		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] buffer = new byte[8192];
			int bytesRead;

			// 分块读取文件内容并更新摘要
			while ((bytesRead = fis.read(buffer)) != -1) {
				digest.update(buffer, 0, bytesRead);
			}
		}

		return bytesToHex(digest.digest());
	}

	/**
	 * 将字节数组转换为十六进制字符串表示。
	 *
	 * @param bytes 输入的字节数组
	 * @return 对应的十六进制字符串
	 */
	private static String bytesToHex(byte[] bytes) {
		StringBuilder hexString = new StringBuilder(2 * bytes.length);
		for (byte b : bytes) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	/**
	 * 使用 BCrypt 算法对字符串进行加密。
	 *
	 * @param string 需要加密的明文字符串
	 * @return 加密后的 BCrypt 哈希字符串
	 */
	public static String bcrypt(String string) {
		return BCrypt.hashpw(string, BCrypt.gensalt());
	}

	/**
	 * 验证给定字符串与 BCrypt 哈希是否匹配。
	 *
	 * @param string   明文字符串
	 * @param bcrypted 已经使用 BCrypt 加密的哈希字符串
	 * @return 如果匹配返回 true，否则返回 false
	 */
	public static boolean checkBcrypt(String string, String bcrypted) {
		return BCrypt.checkpw(string, bcrypted);
	}
}
