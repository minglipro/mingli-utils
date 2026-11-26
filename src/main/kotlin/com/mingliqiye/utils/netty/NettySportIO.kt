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
 * CurrentFile NettySportIO.kt
 * LastUpdate 2026-11-26 18:55:25
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import io.netty.channel.IoHandlerFactory
import io.netty.channel.ServerChannel
import io.netty.channel.epoll.Epoll
import io.netty.channel.epoll.EpollIoHandler
import io.netty.channel.epoll.EpollServerSocketChannel
import io.netty.channel.kqueue.KQueue
import io.netty.channel.kqueue.KQueueIoHandler
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.channel.nio.NioIoHandler
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.uring.IoUring
import io.netty.channel.uring.IoUringIoHandler
import io.netty.channel.uring.IoUringServerSocketChannel

/**
 * Netty 传输层实现枚举，封装各平台原生传输的通道类型与 IoHandler 工厂。
 *
 * @property ioName 日志展示名
 * @property channelClass 服务端监听通道类型
 * @property newFactory IoHandlerFactory 构造回调
 */
enum class NettySportIO(
    val ioName: String,
    val channelClass: Class<out ServerChannel>,
    val newFactory: () -> IoHandlerFactory,
) {
    /** Linux io_uring（性能最优，需内核与 native 库支持）。 */
    IO_URING("LinuxIoUring", IoUringServerSocketChannel::class.java, IoUringIoHandler::newFactory),

    /** macOS/BSD kqueue。 */
    KQUEUE("MacOsKQueue", KQueueServerSocketChannel::class.java, KQueueIoHandler::newFactory),

    /** Linux epoll。 */
    EPOLL("LinuxEpoll", EpollServerSocketChannel::class.java, EpollIoHandler::newFactory),

    /** 跨平台 Java NIO（兜底）。 */
    NIO("JavaNio", NioServerSocketChannel::class.java, NioIoHandler::newFactory),
    ;

    companion object {
        /** 按当前平台自动选择最优传输：IO_URING > EPOLL > KQUEUE > NIO。 */
        @JvmStatic
        @get:JvmName("getSystemSportIO")
        val systemSportIO by lazy {
            when {
                IoUring.isAvailable() -> IO_URING
                Epoll.isAvailable() -> EPOLL
                KQueue.isAvailable() -> KQUEUE
                else -> NIO
            }
        }
    }
}
