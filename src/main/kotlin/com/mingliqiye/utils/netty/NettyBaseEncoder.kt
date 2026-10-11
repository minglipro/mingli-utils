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
 * CurrentFile NettyBaseEncoder.kt
 * LastUpdate 2026-06-27 21:51:10
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder

/**
 * Netty 基础编码器抽象类
 *
 * 用于将出站消息从类型 I 编码为类型 O
 * 继承自 Netty 的 MessageToMessageEncoder，适用于消息类型之间的转换
 *
 * 适用场景：
 * - 将业务对象序列化为传输格式
 * - 将 JSON 对象转换为字符串
 * - 将 POJO 序列化为字节数组
 *
 * ⚠️ 注意：如果需要将对象编码为 ByteBuf，应使用 MessageToByteEncoder
 *
 * @param I 输入消息类型（编码前的类型）
 * @param O 输出消息类型（编码后的类型）
 *
 * 使用示例：
 * ```
 * class IntToStringEncoder : NettyBaseEncoder<Int, String>() {
 *     override fun encode(inData: Int, ctx: ChannelHandlerContext, outList: MutableList<Any>): String {
 *         return inData.toString()
 *     }
 * }
 * ```
 *
 * @see io.netty.handler.codec.MessageToMessageEncoder
 * @see MessageToByteEncoder
 */
abstract class NettyBaseEncoder<I : Any, O : Any> : MessageToMessageEncoder<I>() {

    /**
     * 编码方法（Netty 框架回调）
     *
     * 由 Netty 在发送出站消息时自动调用
     * 将出站消息 I 编码为 O，并添加到输出列表
     *
     * 执行流程：
     * 1. 用户调用 Channel.write(msg) 发送消息
     * 2. Netty 将消息传递给 Pipeline 中的 OutboundHandler
     * 3. 此方法被调用，执行编码逻辑
     * 4. 编码结果添加到 out 列表
     * 5. Netty 将 out 列表中的消息传递给下一个 OutboundHandler
     *
     * @param ctx ChannelHandler 上下文
     *          - 可用于获取 Channel 信息
     *          - 可用于触发后续写操作
     *          - 可用于获取 ChannelPipeline 引用
     * @param msg 出站消息（类型为 I）
     *          - 由业务层调用 write 方法时传入
     *          - 可能是任意类型
     * @param out 输出列表（类型为 MutableList<Any>）
     *          - 编码后的消息（类型为 O）将被添加到此列表
     *          - 列表中的消息会传递给下一个 OutboundHandler
     *          - 可以添加多个消息，实现一对多的转换
     *
     * @see #encode 抽象方法，由子类实现具体的编码逻辑
     */
    override fun encode(ctx: ChannelHandlerContext, msg: I, out: MutableList<Any>) {
        // 调用子类实现的抽象编码方法，将结果添加到输出列表
        // 子类通过抽象方法返回编码后的对象，然后添加到 out 中
        out.add(encode(msg, ctx, out))
    }

    /**
     * 抽象编码方法
     *
     * 子类必须实现此方法，定义从 I 到 O 的具体转换逻辑
     *
     * 实现注意事项：
     * 1. 此方法会在 Netty 的 EventLoop 线程中执行，避免阻塞操作
     * 2. 编码后的对象应该是线程安全的（可能会被多个线程访问）
     * 3. 如果 outList 可以接收多个消息，可以多次调用 outList.add()
     * 4. 如果 I 是 ByteBuf，注意引用计数管理
     * 5. 编码结果应该是完整的消息，不要依赖后续 handler 补充
     *
     * 性能建议：
     * - 尽量复用对象池中的资源（如 ByteBuf）
     * - 避免在编码过程中进行大量数据复制
     * - 考虑使用 DirectBuffer 减少内存拷贝
     *
     * @param inData 输入数据（类型 I），需要被编码
     *          - 由调用方（业务层）传入
     *          - 不应为 null（泛型约束为 Any）
     * @param channelHandlerContext ChannelHandler 上下文
     *          - 可用于获取 ChannelHandlerContext 相关信息
     *          - 可用于在编码过程中触发额外操作
     *          - 可通过 ctx.alloc() 获取 ByteBufAllocator 分配内存
     * @param outList 输出列表
     *          - 可用于在编码过程中添加多个消息
     *          - 当前设计为单一返回值，outList 暂作为扩展预留
     *          - 如果需要在编码过程中输出多个消息，可以直接操作此列表并返回 null
     * @return 编码后的数据（类型 O）
     *          - 不能返回 null（泛型约束为 Any）
     *          - 返回值会被自动添加到 outList 中
     *
     * @see #encode 包装方法，由框架调用
     */
    abstract fun encode(
        inData: I,
        channelHandlerContext: ChannelHandlerContext,
        outList: MutableList<Any>,
    ): O
}
