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
 * CurrentFile NamedThreadFactory.kt
 * LastUpdate 2026-01-31 21:05:02
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

/**
 * 命名线程工厂类，用于创建具有自定义名称的线程
 * @param getName 用于获取线程名称的回调函数接口
 */
open class NamedThreadFactory(private val getName: NamedThreadFactoryNameGetter) : ThreadFactory {

    companion object {

        @JvmStatic
        private val allThreadPoolNumber = AtomicInteger(0)

        /**
         * 函数式接口，用于定义线程名称生成规则
         */
        @FunctionalInterface
        fun interface NamedThreadFactoryNameGetter {
            /**
             * 获取线程名称
             * @param clazz 线程工厂类
             * @param poolNumber 线程池编号
             * @param threadNumber 线程编号
             * @return 生成的线程名称
             */
            fun getName(clazz: Class<out NamedThreadFactory>, poolNumber: Int, threadNumber: Int): String
        }

        /**
         * 默认的线程名称生成器
         */
        @JvmStatic
        val defaultGetName =
            NamedThreadFactoryNameGetter { clazz, poolNumber, threadNumber -> "${clazz.simpleName}-$poolNumber-$threadNumber" }

        /**
         * 创建命名线程工厂实例
         * @param name 线程名称前缀
         * @return NamedThreadFactory实例
         */
        @JvmStatic
        fun of(name: String): NamedThreadFactory {
            return NamedThreadFactory { a, b, c ->
                "$name-$c"
            }
        }

        /**
         * 创建命名线程工厂实例
         * @param getter 线程名称生成器，默认使用defaultGetName
         * @return NamedThreadFactory实例
         */
        @JvmStatic
        fun of(getter: NamedThreadFactoryNameGetter = defaultGetName): NamedThreadFactory {
            return NamedThreadFactory(getter)
        }
    }

    // 当前线程工厂的线程计数器
    private val threadNumber = AtomicInteger(0)

    // 全局线程池计数器，用于标识不同的线程池
    private val threadPoolNumber = allThreadPoolNumber.addAndGet(1)

    /**
     * 获取线程名称
     * @param clazz 线程工厂类
     * @param poolNumber 线程池编号
     * @param threadNumber 线程编号
     * @return 生成的线程名称
     */
    open fun getThreadName(clazz: Class<out NamedThreadFactory>, poolNumber: Int, threadNumber: Int) =
        getName.getName(clazz, poolNumber, threadNumber)

    /**
     * 创建新线程
     * @param r 线程执行的任务
     * @return 新创建的线程对象
     */
    override fun newThread(r: Runnable): Thread {
        return Thread(r).let {
            it.name = getThreadName(this.javaClass, threadPoolNumber, threadNumber.addAndGet(1))
            it
        }
    }
}
