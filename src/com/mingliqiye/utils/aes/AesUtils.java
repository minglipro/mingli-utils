package com.mingliqiye.utils.aes;

import com.mingliqiye.utils.base64.Base64Utils;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtils {

	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES/GCM/NoPadding";
	private static final int GCM_IV_LENGTH = 12;
	private static final int GCM_TAG_LENGTH = 16;
	private static final SecureRandom SECURE_RANDOM = new SecureRandom();

	/**
	 * AES加密方法（使用GCM模式）
	 * @param sSrc 待加密的字符串
	 * @param sKey 加密密钥
	 * @return 加密后的字符串，格式为 IV:EncryptedData+Tag（均为Base64编码）
	 * @throws GeneralSecurityException 加密错误
	 */
	public static String encrypt(String sSrc, String sKey)
		throws GeneralSecurityException {
		if (sKey == null) {
			return null;
		}

		// 生成密钥
		SecretKeySpec secretKeySpec = createSecretKey(sKey);

		// 生成安全随机IV
		byte[] iv = new byte[GCM_IV_LENGTH];
		SECURE_RANDOM.nextBytes(iv);

		// 初始化加密器
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(
			GCM_TAG_LENGTH * 8,
			iv
		);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);

		// 执行加密
		byte[] encrypted = cipher.doFinal(
			sSrc.getBytes(StandardCharsets.UTF_8)
		);

		// 将IV和加密数据（包含认证标签）组合返回
		return Base64Utils.encode(
			(Base64Utils.encode(iv) +
				":" +
				Base64Utils.encode(encrypted)).getBytes()
		);
	}

	/**
	 * AES解密方法（使用GCM模式）
	 * @param sSrc 待解密的字符串，格式为 IV:EncryptedData+Tag（均为Base64编码）
	 * @param sKey 解密密钥
	 * @return 解密后的原始字符串
	 */
	public static String decrypt(String sSrc, String sKey) {
		if (sKey == null) {
			return null;
		}

		try {
			// 分割IV和加密数据
			String sSrcs = new String(Base64Utils.decode(sSrc));
			String[] parts = sSrcs.split(":", 2);
			if (parts.length != 2) {
				return null;
			}
			byte[] iv = Base64Utils.decode(parts[0]);
			byte[] encryptedData = Base64Utils.decode(parts[1]);
			if (iv.length != GCM_IV_LENGTH) {
				return null;
			}
			SecretKeySpec secretKeySpec = createSecretKey(sKey);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(
				GCM_TAG_LENGTH * 8,
				iv
			);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);
			byte[] original = cipher.doFinal(encryptedData);
			return new String(original, StandardCharsets.UTF_8);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 创建AES密钥，支持任意长度的密钥
	 * @param sKey 字符串密钥
	 * @return SecretKeySpec对象
	 * @throws Exception 可能抛出的异常
	 */
	private static SecretKeySpec createSecretKey(String sKey)
		throws GeneralSecurityException {
		byte[] key = sKey.getBytes(StandardCharsets.UTF_8);
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(key);
		return new SecretKeySpec(digest, ALGORITHM);
	}
}
