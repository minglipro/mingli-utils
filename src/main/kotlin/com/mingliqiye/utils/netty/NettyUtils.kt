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
 * CurrentFile NettyUtils.kt
 * LastUpdate 2026-01-06 14:33:44
 * UpdateUser MingLiPro
 */

@file:JvmName("NettyUtils")

package com.mingliqiye.utils.netty

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import java.nio.ByteBuffer

/**
 * 将ByteBuffer转换为Netty的ByteBuf对象
 *
 * 该函数使用Netty库的Unpooled工具类将标准的java.nio.ByteBuffer包装成Netty的ByteBuf
 * 以便在Netty框架中使用
 *
 * @receiver ByteBuffer 需要转换的原始ByteBuffer对象
 * @return ByteBuf 转换后的Netty ByteBuf对象，该对象包装了原始的ByteBuffer
 */
fun ByteBuffer.toByteBuf(): ByteBuf {
    return Unpooled.wrappedBuffer(this)
}

/**
 * 将Netty的ByteBuf对象转换为ByteBuffer
 *
 * 该函数通过ByteBuf的nioBuffer()方法将Netty的ByteBuf转换为标准的java.nio.ByteBuffer
 *
 * @receiver ByteBuf 需要转换的原始ByteBuf对象
 * @return ByteBuffer 转换后的java.nio.ByteBuffer对象
 */
fun ByteBuf.toByteBuffer(): ByteBuffer {
    return this.nioBuffer()
}

/**
 * 将Netty的ByteBuf对象转换为字节数组
 *
 * 该函数将ByteBuf中的可读字节读取到一个新的字节数组中
 *
 * @receiver ByteBuf 需要转换的原始ByteBuf对象
 * @return ByteArray 转换后的字节数组，包含ByteBuf中所有可读的字节数据
 */
fun ByteBuf.toByteArray(): ByteArray {
    val array = ByteArray(this.readableBytes())
    this.readBytes(array)
    return array
}

/**
 * 将字节数组转换为Netty的ByteBuf对象
 *
 * 该函数使用Netty库的Unpooled工具类将字节数组包装成Netty的ByteBuf
 * 以便在Netty框架中使用
 *
 * @receiver ByteArray 需要转换的原始字节数组
 * @return ByteBuf 转换后的Netty ByteBuf对象，该对象包装了原始的字节数组
 */
fun ByteArray.toByteBuf(): ByteBuf {
    return Unpooled.wrappedBuffer(this)
}

/**
 * 将字节数组转换为ByteBuffer对象
 *
 * @return 转换后的ByteBuffer对象，该ByteBuffer包装了原始字节数组
 */
fun ByteArray.toByteBuffer(): ByteBuffer {
    return ByteBuffer.wrap(this)
}
