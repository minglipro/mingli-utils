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
 * LastUpdate 2026-01-08 10:45:37
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelFutureListener
import java.util.concurrent.TimeUnit

abstract class ClientScheduleReconnect(
    protected val bootstrap: Bootstrap,
    protected var delay: Long = 10L,
    protected var timeUnit: TimeUnit = TimeUnit.SECONDS
) {
    protected var isStop = false
    protected var channel: Channel? = null


    abstract fun onConnectedLog(channel: Channel)
    abstract fun onConnectFailedLog(cause: Throwable?)
    abstract fun onStoppedLog()
    abstract fun doConnect(): ChannelFuture

    open fun updateReconnectDelay(newDelay: Long, newTimeUnit: TimeUnit) {
        require(newDelay > 0) { "Delay must be positive" }
        this.delay = newDelay
        this.timeUnit = newTimeUnit
    }

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


    open fun stop() {
        isStop = true
        disConnect()
    }

    open fun disConnect() {
        channel?.close()
        channel = null
    }


    open fun scheduleReconnect() {
        if (isStop) {
            onStoppedLog()
            return
        }
        bootstrap.config().group().schedule({
            if (isStop) {
                onStoppedLog()
                return@schedule
            }
            connect()
        }, delay, timeUnit)
    }

    open fun onConnected(channel: Channel) {
        this.channel = channel
        onConnectedLog(channel)
        channel.closeFuture().addListener { _ ->
            scheduleReconnect()
        }
    }

    open fun onConnectFailed(cause: Throwable?) {
        onConnectFailedLog(cause)
        scheduleReconnect()
    }

    open fun isConnected(): Boolean {
        return channel?.isActive ?: false
    }
}
