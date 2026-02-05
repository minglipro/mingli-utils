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
 * CurrentFile ThreadRunner.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.thread

import com.mingliqiye.utils.netty.NamedThreadFactory
import com.mingliqiye.utils.system.availableProcessors
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * 线程执行器工具类，用于管理线程池并提供异步任务执行功能
 */
object ThreadRunner {

    var executorService: ExecutorService? = null

    /**
     * 关闭线程池执行器
     * 首先尝试正常关闭，如果失败则强制关闭
     */
    @JvmStatic
    fun close() {
        try {
            executorService?.shutdown()
        } catch (_: Exception) {
            executorService?.shutdownNow()
        }
    }

    /**
     * 初始化线程池执行器
     * 创建固定大小的线程池，线程数量为可用处理器核心数的两倍
     *
     * @param string 线程名称前缀，默认为"MingliUtilThread"
     */
    @JvmStatic
    fun init(string: String = "MingliUtilThread") {
        executorService = Executors.newFixedThreadPool(
            availableProcessors * 2,
            NamedThreadFactory { clazz, poolNumber, threadNumber ->
                "$string #$threadNumber"
            })
    }

    /**
     * 异步执行Runnable任务
     *
     * @param runnable 要执行的Runnable任务
     * @return Future对象，可用于获取任务执行结果或控制任务状态
     */
    @JvmStatic
    fun runThread(runnable: Runnable): Future<*> {
        return executorService!!.submit(runnable)
    }

    /**
     * 异步执行Callable任务
     *
     * @param runnable 要执行的Callable任务
     * @return Future对象，可用于获取任务执行结果或控制任务状态
     */
    @JvmStatic
    fun <T> runThread(runnable: Callable<T>): Future<T> {
        return executorService!!.submit(runnable)
    }

    /**
     * 同步执行Runnable任务，阻塞等待任务完成
     *
     * @param runnable 要执行的Runnable任务
     * @return 任务执行结果（通常为null）
     */
    @JvmStatic
    fun runThreadAwait(runnable: Runnable): Any {
        return executorService!!.submit(runnable).get()
    }

    /**
     * 同步执行Callable任务，阻塞等待任务完成并返回结果
     *
     * @param runnable 要执行的Callable任务
     * @return 任务执行结果
     */
    @JvmStatic
    fun <T> runThreadAwait(runnable: Callable<T>): T {
        return executorService!!.submit(runnable).get()
    }
}
