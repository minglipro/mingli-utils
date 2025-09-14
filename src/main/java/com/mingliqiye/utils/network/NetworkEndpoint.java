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
 * CurrentFile NetworkEndpoint.java
 * LastUpdate 2025-09-14 21:52:54
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network;

import com.mingliqiye.utils.string.StringUtils;
import lombok.Getter;

import java.io.Serializable;
import java.net.InetSocketAddress;

/**
 * IP和端口聚集类，用于封装网络地址与端口信息。
 * 该类提供了与InetSocketAddress之间的相互转换功能。
 *
 * @author MingLiPro
 * @see InetSocketAddress
 */
public class NetworkEndpoint implements Serializable {

	@Getter
	private final NetworkAddress networkAddress;

	@Getter
	private final NetworkPort networkPort;

	/**
	 * 构造函数，使用指定的网络地址和端口创建NetworkEndpoint实例。
	 *
	 * @param networkAddress 网络地址对象
	 * @param networkPort    网络端口对象
	 * @see NetworkAddress
	 * @see NetworkPort
	 */
	private NetworkEndpoint(
		NetworkAddress networkAddress,
		NetworkPort networkPort
	) {
		this.networkAddress = networkAddress;
		this.networkPort = networkPort;
	}

	/**
	 * 根据给定的InetSocketAddress对象创建NetworkEndpoint实例。
	 *
	 * @param address InetSocketAddress对象
	 * @return 新建的NetworkEndpoint实例
	 * @see InetSocketAddress
	 */
	public static NetworkEndpoint of(InetSocketAddress address) {
		return new NetworkEndpoint(
			new NetworkAddress(address.getHostString()),
			new NetworkPort(address.getPort())
		);
	}

	/**
	 * 根据主机名或IP字符串和端口号创建NetworkEndpoint实例。
	 *
	 * @param s 主机名或IP地址字符串
	 * @param i 端口号
	 * @return 新建的NetworkEndpoint实例
	 */
	public static NetworkEndpoint of(String s, Integer i) {
		NetworkAddress networkAddress = new NetworkAddress(s);
		NetworkPort networkPort = new NetworkPort(i);
		return new NetworkEndpoint(networkAddress, networkPort);
	}

	/**
	 * 根据"host:port"格式的字符串创建NetworkEndpoint实例。
	 * 例如："127.0.0.1:8080"
	 *
	 * @param s "host:port"格式的字符串
	 * @return 新建的NetworkEndpoint实例
	 */
	public static NetworkEndpoint of(String s) {
		// 查找最后一个冒号的位置，以支持IPv6地址中的冒号
		int lastColonIndex = s.lastIndexOf(':');
		return of(
			s.substring(0, lastColonIndex),
			Integer.parseInt(s.substring(lastColonIndex + 1))
		);
	}

	/**
	 * 将当前NetworkEndpoint转换为InetSocketAddress对象。
	 *
	 * @return 对应的InetSocketAddress对象
	 * @see InetSocketAddress
	 */
	public InetSocketAddress toInetSocketAddress() {
		return new InetSocketAddress(
			networkAddress.toInetAddress(),
			networkPort.getPort()
		);
	}

	/**
	 * 将当前NetworkEndpoint转换为"host:port"格式的字符串。
	 * 例如："127.0.0.1:25563"
	 *
	 * @return 格式化后的字符串
	 */
	public String toHostPortString() {
		return StringUtils.format(
			"{}:{}",
			networkAddress.getIp(),
			networkPort.getPort()
		);
	}

	/**
	 * 返回NetworkEndpoint的详细字符串表示形式。
	 * 格式：NetworkEndpoint(IP=...,Port=...,Endpoint=...)
	 *
	 * @return 包含详细信息的字符串
	 */
	public String toString() {
		return StringUtils.format(
			"NetworkEndpoint(IP={},Port={},Endpoint={})",
			networkAddress.getIp(),
			networkPort.getPort(),
			toHostPortString()
		);
	}

	/**
	 * 获取主机名或IP地址字符串。
	 *
	 * @return 主机名或IP地址
	 */
	public String getHost() {
		return networkAddress.getIp();
	}

	/**
	 * 获取端口号。
	 *
	 * @return 端口号
	 */
	public Integer getPort() {
		return networkPort.getPort();
	}
}
