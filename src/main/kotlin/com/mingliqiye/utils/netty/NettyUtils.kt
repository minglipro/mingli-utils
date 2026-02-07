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
 * LastUpdate 2026-01-31 20:50:41
 * UpdateUser MingLiPro
 */

@file:JvmName("NettyUtils")

package com.mingliqiye.utils.netty

import com.mingliqiye.utils.functions.P1Function
import io.netty.bootstrap.Bootstrap
import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import java.nio.ByteBuffer
import java.nio.charset.Charset

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
 * 为ServerBootstrap配置子通道初始化器
 *
 * 该函数用于设置ServerBootstrap的childHandler，当新的客户端连接建立时，
 * 会调用提供的函数来初始化子通道
 *
 * @receiver ServerBootstrap 需要配置的服务器引导程序实例
 * @param funa 用于初始化通道的回调函数，接收Channel作为参数
 * @return ServerBootstrap 返回当前实例以支持链式调用
 */
@JvmName("channelInit")
fun ServerBootstrap.channelInitializer(funa: P1Function<Channel>): ServerBootstrap {
    this.childHandler(object : ChannelInitializer<Channel>() {
        override fun initChannel(ch: Channel) {
            funa.call(ch)
        }
    })
    return this
}

/**
 * 为Bootstrap配置通道初始化器
 *
 * 该函数用于设置Bootstrap的handler，当客户端连接建立时，
 * 会调用提供的函数来初始化通道
 *
 * @receiver Bootstrap 需要配置的客户端引导程序实例
 * @param funa 用于初始化通道的回调函数，接收Channel作为参数
 * @return Bootstrap 返回当前实例以支持链式调用
 */
@JvmName("channelInit")
fun Bootstrap.channelInitializer(funa: P1Function<Channel>): Bootstrap {
    this.handler(object : ChannelInitializer<Channel>() {
        override fun initChannel(ch: Channel) {
            funa.call(ch)
        }
    })
    return this
}

/**
 * 将字符串转换为Netty的ByteBuf对象
 *
 * @receiver String 需要转换的原始字符串
 * @param charset 字符编码，默认UTF-8
 * @return ByteBuf 转换后的Netty ByteBuf对象
 */
fun String.toByteBuf(charset: Charset = Charsets.UTF_8): ByteBuf {
    return Unpooled.wrappedBuffer(this.toByteArray(charset))
}

/**
 * 将ByteBuf转换为字符串
 *
 * @receiver ByteBuf 需要转换的ByteBuf对象
 * @param charset 字符编码，默认UTF-8
 * @return String 转换后的字符串
 */
fun ByteBuf.toString(charset: Charset = Charsets.UTF_8): String {
    val bytes = this.toByteArray()
    return String(bytes, charset)
}


/**
 * 将Int转换为ByteBuf
 *
 * @receiver Int 需要转换的整数值
 * @return ByteBuf 转换后的Netty ByteBuf对象，包含4字节的整数数据
 */
fun Int.toByteBuf(): ByteBuf {
    val buffer = Unpooled.buffer(4)
    buffer.writeInt(this)
    return buffer
}

/**
 * 将Long转换为ByteBuf
 *
 * @receiver Long 需要转换的长整数值
 * @return ByteBuf 转换后的Netty ByteBuf对象，包含8字节的长整数数据
 */
fun Long.toByteBuf(): ByteBuf {
    val buffer = Unpooled.buffer(8)
    buffer.writeLong(this)
    return buffer
}

/**
 * 将ByteBuf转换为Int
 *
 * @receiver ByteBuf 需要转换的ByteBuf对象
 * @return Int 从ByteBuf中读取的整数值
 */
fun ByteBuf.toInt(): Int {
    return this.readInt()
}

/**
 * 将ByteBuf转换为Long
 *
 * @receiver ByteBuf 需要转换的ByteBuf对象
 * @return Long 从ByteBuf中读取的长整数值
 */
fun ByteBuf.toLong(): Long {
    return this.readLong()
}

/**
 * 安全地获取ByteBuf的字节数组，避免堆外内存访问异常
 *
 * @receiver ByteBuf 需要转换的ByteBuf对象
 * @return ByteArray 转换后的字节数组
 */
fun ByteBuf.safeToByteArray(): ByteArray {
    return if (this.hasArray()) {
        // 如果是堆内内存，直接获取数组
        this.array().copyOfRange(this.arrayOffset(), this.arrayOffset() + this.readableBytes())
    } else {
        // 如果是堆外内存，使用readBytes
        val array = ByteArray(this.readableBytes())
        this.getBytes(this.readerIndex(), array)
        array
    }
}

/**
 * 获取ByteBuf的十六进制字符串表示
 *
 * @receiver ByteBuf 需要转换的ByteBuf对象
 * @return String 十六进制字符串表示
 */
fun ByteBuf.toHexString(): String {
    val array = this.safeToByteArray()
    return array.joinToString("") { "%02x".format(it) }
}

/**
 * 合并多个ByteBuf为一个
 *
 * @param byteBufs 需要合并的ByteBuf数组
 * @return ByteBuf 合并后的ByteBuf对象
 */
fun combineByteBuf(vararg byteBufs: ByteBuf): ByteBuf {
    val totalCapacity = byteBufs.sumOf { it.readableBytes() }
    val combined = Unpooled.buffer(totalCapacity)
    byteBufs.forEach { combined.writeBytes(it.duplicate()) }
    return combined
}

/**
 * 安全关闭通道
 */
fun Channel.closeSafely() {
    if (isOpen) {
        close()
    }
}

/**
 * 检查通道是否处于活跃状态
 */
val Channel.isActive: Boolean
    get() = isOpen && isActive

/**
 * 异步写入数据到通道
 *
 * @param data 需要写入的数据
 */
fun Channel.writeAndFlushAsync(data: Any) {
    writeAndFlush(data).addListener { future ->
        if (!future.isSuccess) {
            // 可以在这里添加错误处理逻辑
            println("Write failed: ${future.cause()}")
        }
    }
}

/**
 * 安全释放ByteBuf资源
 *
 * @receiver ByteBuf 需要释放的ByteBuf对象
 * @return Boolean 释放操作是否成功
 */
fun ByteBuf.releaseSafely(): Boolean {
    return if (refCnt() > 0) release() else true
}

/**
 * 尝试释放ByteBuf资源，不抛出异常
 *
 * @receiver ByteBuf 需要释放的ByteBuf对象
 * @return Boolean 释放操作是否成功
 */
fun ByteBuf.tryRelease(): Boolean {
    return try {
        if (refCnt() > 0) release() else false
    } catch (e: Exception) {
        false
    }
}
