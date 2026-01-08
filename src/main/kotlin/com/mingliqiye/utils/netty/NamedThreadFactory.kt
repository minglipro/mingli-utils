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
 * LastUpdate 2026-01-08 13:21:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.netty

import io.netty.util.concurrent.FastThreadLocalThread
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger


open class NamedThreadFactory(private val getName: NamedThreadFactoryNameGetter) : ThreadFactory {

    companion object {

        @JvmStatic
        private val allThreadPoolNumber = AtomicInteger(0)

        @FunctionalInterface
        fun interface NamedThreadFactoryNameGetter {
            fun getName(clazz: Class<out NamedThreadFactory>, poolNumber: Int, threadNumber: Int): String
        }

        @JvmStatic
        val defaultGetName =
            NamedThreadFactoryNameGetter { clazz, poolNumber, threadNumber -> "${clazz.simpleName}-$poolNumber-$threadNumber" }

        @JvmStatic
        fun of(name: String): NamedThreadFactory {
            return NamedThreadFactory { a, b, c ->
                "$name-$c"
            }
        }

        @JvmStatic
        fun of(getter: NamedThreadFactoryNameGetter = defaultGetName): NamedThreadFactory {
            return NamedThreadFactory(getter)
        }
    }


    private val threadNumber = AtomicInteger(0)
    private val threadPoolNumber = allThreadPoolNumber.addAndGet(1)

    open fun getThreadName(clazz: Class<out NamedThreadFactory>, poolNumber: Int, threadNumber: Int) =
        getName.getName(clazz, poolNumber, threadNumber)

    override fun newThread(r: Runnable): Thread {
        return FastThreadLocalThread(
            null,
            r,
            getThreadName(this.javaClass, threadPoolNumber, threadNumber.addAndGet(1))
        )
    }
}
