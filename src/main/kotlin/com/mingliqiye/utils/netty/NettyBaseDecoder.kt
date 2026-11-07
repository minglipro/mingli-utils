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
 * CurrentFile NettyBaseDecoder.kt
 * LastUpdate 2026-06-27 21:51:10
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder

/**
 * Netty 基础解码器抽象类
 *
 * 用于将入站消息从类型 I 解码为类型 O
 * 继承自 Netty 的 MessageToMessageDecoder，适用于消息类型之间的转换
 *
 * 适用场景：
 * - 将一种业务对象转换为另一种业务对象
 * - 将字符串解析为 JSON 对象
 * - 将字节数组反序列化为 POJO
 *
 * @param I 输入消息类型（解码前的类型）
 * @param O 输出消息类型（解码后的类型）
 *
 * 使用示例：
 * ```
 * class StringToIntDecoder : NettyBaseDecoder<String, Int>() {
 *     override fun decode(inData: String, ctx: ChannelHandlerContext, outList: MutableList<Any>): Int {
 *         return inData.toInt()
 *     }
 * }
 * ```
 *
 * @see io.netty.handler.codec.MessageToMessageDecoder
 * @see io.netty.handler.codec.ByteToMessageDecoder
 */
abstract class NettyBaseDecoder<I : Any, O : Any> : MessageToMessageDecoder<I>() {

	/**
	 * 解码方法（Netty 框架回调）
	 *
	 * 由 Netty 在收到入站消息时自动调用
	 * 将入站消息 I 转换为 O，并添加到输出列表
	 *
	 * @param ctx ChannelHandler 上下文
	 *          - 可用于获取 Channel 信息
	 *          - 可用于触发后续事件
	 *          - 可用于获取 ChannelPipeline 引用
	 * @param msg 入站消息（类型为 I）
	 *          - 由 Netty 从 Channel 中读取
	 *          - 可能是 ByteBuf、String 或其他类型
	 * @param out 输出列表（类型为 MutableList<Any>）
	 *          - 解码后的消息（类型为 O）将被添加到此列表
	 *          - 列表中的消息会传递给下一个 InboundHandler
	 *          - 可以添加多个消息，实现一对多的转换
	 *
	 * @see #decode 抽象方法，由子类实现具体的解码逻辑
	 */
	override fun decode(ctx: ChannelHandlerContext, msg: I, out: MutableList<Any>) {
		// 调用子类实现的抽象解码方法，将结果添加到输出列表
		// 子类通过抽象方法返回解码后的对象，然后添加到 out 中
		out.add(decode(msg, ctx, out))
	}

	/**
	 * 抽象解码方法
	 *
	 * 子类必须实现此方法，定义从 I 到 O 的具体转换逻辑
	 *
	 * 实现注意事项：
	 * 1. 此方法会在 Netty 的 EventLoop 线程中执行，避免阻塞操作
	 * 2. 如果输入数据不完整，应该抛出异常或返回 null
	 * 3. 如果 outList 可以接收多个消息，可以多次调用 outList.add()
	 * 4. 注意管理 ByteBuf 的引用计数（如果 I 是 ByteBuf）
	 *
	 * @param inData 输入数据（类型 I），需要被解码
	 *          - 由调用方（Netty 框架）传入
	 *          - 不应为 null（泛型约束为 Any）
	 * @param channelHandlerContext ChannelHandler 上下文
	 *          - 可用于获取 ChannelHandlerContext 相关信息
	 *          - 可用于在解码过程中触发额外操作
	 * @param outList 输出列表
	 *          - 可用于在解码过程中添加多个消息
	 *          - 当前设计为单一返回值，outList 暂作为扩展预留
	 *          - 如果需要在解码过程中输出多个消息，可以直接操作此列表并返回 null
	 * @return 解码后的数据（类型 O）
	 *          - 不能返回 null（泛型约束为 Any）
	 *          - 返回值会被自动添加到 outList 中
	 *
	 * @see #decode 包装方法，由框架调用
	 */
	abstract fun decode(
		inData: I,
		channelHandlerContext: ChannelHandlerContext,
		outList: MutableList<Any>,
	): O
}
