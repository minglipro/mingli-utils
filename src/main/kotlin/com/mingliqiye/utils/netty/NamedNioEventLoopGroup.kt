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
 * CurrentFile NamedNioEventLoopGroup.kt
 * LastUpdate 2026-02-05 10:20:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import com.mingliqiye.utils.system.availableProcessors
import io.netty.channel.nio.NioEventLoopGroup
import java.text.MessageFormat

/**
 * 命名的NIO事件循环组，继承自NioEventLoopGroup
 * 用于创建具有自定义命名规则的线程池，便于线程管理和调试
 *
 * @param name 线程池的名称，默认为"NioEventLoopGroup"
 * @param template 线程名称的格式模板，默认为"{0}-{2}-{3}"，{0} 名字 {1} 类名 {2} 线程池序号 {3} 线程池内线程的序号
 * @param nThreads 线程数量，默认为核心数的2倍
 */
open class NamedNioEventLoopGroup(
    val template: String = "{0}-{2}-{3}",
    val name: String = "NioEventLoopGroup",
    nThreads: Int = availableProcessors * 2
) :
    NioEventLoopGroup(
        nThreads,
        NamedThreadFactory(
            getName = { a, b, c -> MessageFormat.format(template, name, a, b, c) }
        )
    )
