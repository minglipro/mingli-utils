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
 * CurrentFile MingLiLoggerFactory.kt
 * LastUpdate 2026-02-05 10:20:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.logger

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.reflect.Method
import java.util.*

class MingLiLoggerFactory {

    companion object {

        private var nameMethod: Method? = null
        private var clazzMethod: Method? = null

        init {
            try {
                val clazz = Class.forName("com.mingliqiye.logger.Loggers")
                nameMethod = clazz.getMethod("getLogger", String::class.java)
                clazzMethod = clazz.getMethod("getLogger", Class::class.java)
            } catch (e: Exception) {
            }
        }

        private val mingLiLoggerFactory: MingLiLoggerFactory by lazy {
            MingLiLoggerFactory()
        }


        @JvmStatic
        fun getLogger(name: String): Logger {

            return if (mingLiLoggerFactory.checkSLF4JImplementation()) {
                if (nameMethod != null) {
                    nameMethod!!.invoke(null, name) as Logger
                } else {
                    LoggerFactory.getLogger(name)
                }
            } else mingLiLoggerFactory.getLogger(name)
        }

        @JvmStatic
        fun getLogger(clazz: Class<*>): Logger {
            return if (mingLiLoggerFactory.checkSLF4JImplementation()) {
                if (clazzMethod != null) {
                    clazzMethod!!.invoke(null, clazz) as Logger
                } else {
                    LoggerFactory.getLogger(clazz)
                }
            } else mingLiLoggerFactory.getLogger(clazz)
        }

        inline fun <reified T> getLogger() = getLogger(T::class.java)
    }

    private var hasSLF4JImplementation: Boolean? = null

    // 线程安全的延迟初始化
    private fun checkSLF4JImplementation(): Boolean {
        if (hasSLF4JImplementation == null) {
            synchronized(this) {
                if (hasSLF4JImplementation == null) {
                    hasSLF4JImplementation = try {
                        // 更可靠的检测方式
                        ServiceLoader.load(
                            Class.forName("org.slf4j.spi.SLF4JServiceProvider")
                        ).iterator().hasNext()
                    } catch (e: ClassNotFoundException) {
                        false
                    } catch (e: NoClassDefFoundError) {
                        false
                    }
                }
            }
        }
        return hasSLF4JImplementation ?: false
    }


    @JvmName("getLogger_prc_name")
    private fun getLogger(name: String): Logger = MingLiLogger(name)

    @JvmName("getLogger_prc_clazz")
    private fun getLogger(clazz: Class<*>): Logger = MingLiLogger(clazz.name)
}
