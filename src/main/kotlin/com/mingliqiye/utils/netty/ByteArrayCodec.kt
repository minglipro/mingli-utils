/*
 * Copyright 2026 mingliqiye
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
 * CurrentFile ByteArrayCodec.kt
 * LastUpdate 2026-06-27 21:43:25
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext

/**
 * ByteBuf 与 ByteArray 互转的编解码器
 *
 * 入站：将 Netty 的 ByteBuf 解码为 Kotlin 的 ByteArray
 * 出站：将 Kotlin 的 ByteArray 编码为 Netty 的 ByteBuf
 *
 * @see NettyBaseCodec
 */
class ByteArrayCodec : NettyBaseCodec<ByteBuf, ByteArray>() {

	/**
	 * 解码：ByteBuf → ByteArray
	 *
	 * 将 Netty 的 ByteBuf 转换为 Kotlin 的 ByteArray
	 *
	 * @param inData 输入的 ByteBuf
	 * @param channelHandlerContext 上下文
	 * @param outList 输出列表（未使用）
	 * @return 转换后的 ByteArray
	 */
	override fun decode(
		inData: ByteBuf,
		channelHandlerContext: ChannelHandlerContext,
		outList: MutableList<Any>,
	): ByteArray {
		return inData.toByteArray()
	}

	/**
	 * 编码：ByteArray → ByteBuf
	 *
	 * 将 Kotlin 的 ByteArray 转换为 Netty 的 ByteBuf
	 *
	 * @param inData 输入的 ByteArray
	 * @param channelHandlerContext 上下文
	 * @param outList 输出列表（未使用）
	 * @return 转换后的 ByteBuf
	 *
	 */
	override fun encode(
		inData: ByteArray,
		channelHandlerContext: ChannelHandlerContext,
		outList: MutableList<Any>,
	): ByteBuf {
		return inData.toByteBuf()
	}
}
