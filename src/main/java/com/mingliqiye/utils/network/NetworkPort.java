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
 * CurrentFile NetworkPort.java
 * LastUpdate 2025-09-14 21:53:06
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.network;

import com.mingliqiye.utils.string.StringUtils;
import lombok.Getter;

import java.io.Serializable;

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
				StringUtils.format("{} 不是正确的端口号", port)
			);
		}
	}
}
