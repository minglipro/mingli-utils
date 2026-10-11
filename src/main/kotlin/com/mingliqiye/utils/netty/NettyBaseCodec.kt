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
 * CurrentFile NettyBaseCodec.kt
 * LastUpdate 2026-06-27 21:50:22
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageCodec

/**
 * 基础编解码器抽象类
 *
 * 同时处理入站解码（I → O）和出站编码（O → I）
 * 继承自 Netty 的 MessageToMessageCodec，用于消息类型之间的转换
 *
 * @param I 入站消息类型（解码前的类型）
 * @param O 出站消息类型（解码后的类型/编码前的类型）
 *
 * 使用示例：
 * ```
 * class StringToIntCodec : NettyBaseCodec<String, Int>() {
 *     override fun decode(inData: String, ctx: ChannelHandlerContext, outList: MutableList<Any>): Int {
 *         return inData.toInt()
 *     }
 *     override fun encode(inData: Int, ctx: ChannelHandlerContext, outList: MutableList<Any>): String {
 *         return inData.toString()
 *     }
 * }
 * ```
 */
abstract class NettyBaseCodec<I : Any, O : Any> : MessageToMessageCodec<I, O>() {

    /**
     * 解码方法（Netty 框架回调）
     *
     * 将入站消息 I 转换为 O，并添加到输出列表
     *
     * @param ctx ChannelHandler 上下文，可用于获取 Channel 等信息
     * @param msg 入站消息（类型为 I）
     * @param out 输出列表，解码后的消息（类型为 O）将被添加到此列表
     *
     * @see decode 抽象方法，由子类实现具体的解码逻辑
     */
    override fun decode(ctx: ChannelHandlerContext, msg: I, out: MutableList<Any>) {
        // 调用子类实现的抽象解码方法，将结果添加到输出列表
        out.add(decode(msg, ctx, out))
    }

    /**
     * 编码方法（Netty 框架回调）
     *
     * 将出站消息 O 转换为 I，并添加到输出列表
     *
     * @param ctx ChannelHandler 上下文
     * @param msg 出站消息（类型为 O）
     * @param out 输出列表，编码后的消息（类型为 I）将被添加到此列表
     *
     * @see encode 抽象方法，由子类实现具体的编码逻辑
     */
    override fun encode(ctx: ChannelHandlerContext, msg: O, out: MutableList<Any>) {
        // 调用子类实现的抽象编码方法，将结果添加到输出列表
        out.add(encode(msg, ctx, out))
    }

    /**
     * 抽象解码方法
     *
     * 子类必须实现此方法，定义具体的解码逻辑
     * 将类型 I 的消息转换为类型 O
     *
     * @param inData 输入数据（类型 I），需要被解码
     * @param channelHandlerContext ChannelHandler 上下文
     * @param outList 输出列表，可用于在解码过程中添加多个消息（目前设计为单一返回值，outList 暂未使用）
     * @return 解码后的数据（类型 O）
     */
    abstract fun decode(
        inData: I,
        channelHandlerContext: ChannelHandlerContext,
        outList: MutableList<Any>,
    ): O

    /**
     * 抽象编码方法
     *
     * 子类必须实现此方法，定义具体的编码逻辑
     * 将类型 O 的消息转换为类型 I
     *
     * @param inData 输入数据（类型 O），需要被编码
     * @param channelHandlerContext ChannelHandler 上下文
     * @param outList 输出列表，可用于在编码过程中添加多个消息（目前设计为单一返回值，outList 暂未使用）
     * @return 编码后的数据（类型 I）
     */
    abstract fun encode(
        inData: O,
        channelHandlerContext: ChannelHandlerContext,
        outList: MutableList<Any>,
    ): I
}
