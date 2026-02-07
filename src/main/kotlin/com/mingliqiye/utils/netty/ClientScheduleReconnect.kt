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
 * CurrentFile ClientScheduleReconnect.kt
 * LastUpdate 2026-01-20 08:10:15
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelFutureListener
import java.util.concurrent.TimeUnit

/**
 * 客户端调度重连抽象类，用于处理Netty客户端的自动重连机制
 * @param bootstrap Netty引导配置对象
 * @param delay 重连延迟时间，默认为10秒
 * @param timeUnit 延迟时间单位，默认为秒
 */
abstract class ClientScheduleReconnect {

    private val bootstrap: Bootstrap
    private var delay: Long = 10L
    private var timeUnit: TimeUnit = TimeUnit.SECONDS

    constructor() : this(Bootstrap())
    constructor(bootstrap: Bootstrap) : this(bootstrap, 10L)
    constructor(bootstrap: Bootstrap, delay: Long) : this(bootstrap, delay, TimeUnit.SECONDS)
    constructor(bootstrap: Bootstrap, delay: Long, timeUnit: TimeUnit) {
        this.bootstrap = bootstrap
        this.delay = delay
        this.timeUnit = timeUnit
    }

    open fun start() {
        initBootstrap(bootstrap)
        connect()
    }

    /**
     * 获取Netty引导配置对象
     * @return Bootstrap 引导配置对象
     */
    open fun getBootstrap(): Bootstrap = bootstrap

    /**
     * 获取当前连接的通道
     * @return Channel? 当前连接的通道，可能为空
     */
    open fun getChannel(): Channel? = channel

    /**
     * 获取时间单位
     * @return TimeUnit 时间单位
     */
    open fun getTimeUnit(): TimeUnit = timeUnit

    /**
     * 设置时间单位
     * @param timeUnit 新的时间单位
     */
    open fun setTimeUnit(timeUnit: TimeUnit) {
        this.timeUnit = timeUnit
    }

    /**
     * 获取重连延迟时间
     * @return Long 延迟时间
     */
    open fun getDelay(): Long = delay

    /**
     * 设置重连延迟时间
     * @param delay 新的延迟时间
     */
    open fun setDelay(delay: Long) {
        this.delay = delay
    }

    /**
     * 检查是否已连接
     * @return Boolean 是否已连接
     */
    open fun isConnected(): Boolean = channel?.isActive ?: false

    private var isStop = false
    private var channel: Channel? = null

    /**
     * 连接成功时的日志记录回调
     * @param channel 成功连接的通道
     */
    abstract fun onConnectedLog(channel: Channel)

    /**
     * 连接失败时的日志记录回调
     * @param cause 连接失败的原因，可能为空
     */
    abstract fun onConnectFailedLog(cause: Throwable?)

    /**
     * 停止连接时的日志记录回调
     */
    abstract fun onStoppedLog()
    abstract fun onConnectClosed()

    /**
     * 执行连接操作
     * @return ChannelFuture 连接结果的异步操作对象
     */
    abstract fun doConnect(): ChannelFuture

    /**
     * 初始化引导配置
     * @param bootstrap 要初始化的引导配置对象
     */
    open fun initBootstrap(bootstrap: Bootstrap) {

    }

    /**
     * 更新重连延迟配置
     * @param newDelay 新的延迟时间，必须大于0
     * @param newTimeUnit 新的时间单位
     * @throws IllegalArgumentException 当newDelay小于等于0时抛出
     */
    open fun updateReconnectDelay(newDelay: Long, newTimeUnit: TimeUnit) {
        require(newDelay > 0) { "Delay must be positive" }
        this.delay = newDelay
        this.timeUnit = newTimeUnit
    }

    /**
     * 执行连接操作，设置连接完成监听器
     */
    open fun connect() {
        doConnect().addListener(object : ChannelFutureListener {
            override fun operationComplete(future: ChannelFuture) {
                if (future.isSuccess) {
                    onConnected(future.channel())
                } else {
                    onConnectFailed(future.cause())
                }
            }
        })
    }

    /**
     * 停止连接并标记为停止状态
     */
    open fun stop() {
        isStop = true
        disConnect()
    }

    /**
     * 断开当前连接并清理通道引用
     */
    open fun disConnect() {
        channel?.close()
        channel = null
    }

    /**
     * 调度下一次重连操作
     */
    open fun scheduleReconnect() {
        // 检查是否已停止，如果已停止则记录日志并返回
        if (isStop) {
            onStoppedLog()
            return
        }
        bootstrap.config().group().schedule({
            // 再次检查停止状态，避免在调度期间被停止
            if (isStop) {
                onStoppedLog()
                return@schedule
            }
            connect()
        }, delay, timeUnit)
    }

    /**
     * 处理连接成功的逻辑
     * @param channel 成功连接的通道
     */
    open fun onConnected(channel: Channel) {
        this.channel = channel
        onConnectedLog(channel)
        // 监听通道关闭事件，以便在断开后重新调度连接
        channel.closeFuture().addListener { _ ->
            scheduleReconnect()
            onConnectClosed()
        }
    }

    /**
     * 处理连接失败的逻辑
     * @param cause 连接失败的原因
     */
    open fun onConnectFailed(cause: Throwable?) {
        onConnectFailedLog(cause)
        scheduleReconnect()
    }

}
