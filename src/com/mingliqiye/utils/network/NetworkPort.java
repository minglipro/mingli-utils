package com.mingliqiye.utils.network;

import com.mingliqiye.utils.string.StringUtil;
import java.io.Serializable;
import lombok.Getter;

/**
 * 网络端口类
 *
 * @author MingLiPro
 */
public class NetworkPort implements Serializable {

	@Getter
	private final int port;

	/**
	 * 构造函数，创建一个网络端口对象
	 *
	 * @param port 端口号，必须在0-65535范围内
	 */
	public NetworkPort(int port) {
		testPort(port);
		this.port = port;
	}

	/**
	 * 验证端口号是否合法
	 *
	 * @param port 待验证的端口号
	 * @throws NetworkException 当端口号不在合法范围(0-65535)内时抛出异常
	 */
	public static void testPort(int port) {
		// 验证端口号范围是否在0-65535之间
		if (!(0 <= port && 65535 >= port)) {
			throw new NetworkException(
				StringUtil.format("{} 不是正确的端口号", port)
			);
		}
	}
}
