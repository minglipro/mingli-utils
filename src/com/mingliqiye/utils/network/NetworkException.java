package com.mingliqiye.utils.network;

/**
 * 网络异常类，用于处理网络相关的运行时异常
 *
 * @author MingLiPro
 */
public class NetworkException extends RuntimeException {

	/**
	 * 构造一个带有指定详细消息的网络异常
	 *
	 * @param message 异常的详细消息
	 */
	public NetworkException(String message) {
		super(message);
	}

	/**
	 * 构造一个网络异常，指定原因异常
	 *
	 * @param e 导致此异常的原因异常
	 */
	public NetworkException(Exception e) {
		super(e);
	}
}
