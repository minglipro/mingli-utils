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
 * CurrentFile IO.kt
 * LastUpdate 2026-02-06 13:21:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.io

import com.mingliqiye.utils.array.toHexString
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.string.join
import org.slf4j.Logger
import java.io.OutputStream
import java.io.PrintStream


/**
 * IO工具类，提供打印功能和系统输出流重定向到日志的功能
 */
object IO {

    @JvmStatic
    fun ByteArray.println(): ByteArray {
        this.toHexString().chunked(2).println()
        return this
    }

    @JvmStatic
    fun <T> List<T>.println(): List<T> {
        println("{" + ",".join(this) + "}")
        return this
    }

    @JvmStatic
    fun <T> Array<T>.println(): Array<T> {
        println("{" + ",".join(this) + "}")
        return this
    }

    @JvmStatic
    fun <T> T.println(): T {
        println(this)
        return this
    }

    @JvmStatic
    var originalOut: PrintStream = System.out

    @JvmStatic
    var originalErr: PrintStream = System.err


    @JvmStatic
    val outLog: Logger = MingLiLoggerFactory.getLogger("out")

    @JvmStatic
    val errLog: Logger = MingLiLoggerFactory.getLogger("err")

    /**
     * 打印多个参数，使用空格分隔
     * @param args 要打印的参数数组
     */
    @JvmStatic
    fun print(vararg args: Any?) {
        printA(" ", *args)
    }

    /**
     * 打印多个参数并换行，使用空格分隔
     * @param args 要打印的参数数组
     */
    @JvmStatic
    fun println(vararg args: Any?) {
        printlnA(" ", *args)
    }

    /**
     * 打印多个参数并换行，指定分隔符
     * @param sp 分隔符
     * @param args 要打印的参数数组
     */
    @JvmStatic
    fun printlnA(sp: String, vararg args: Any?) {
        printA(" ", *args)
        kotlin.io.println()
    }

    /**
     * 打印多个参数，指定分隔符
     * @param sp 分隔符，默认为空字符串
     * @param args 要打印的参数数组
     */
    @JvmStatic
    fun printA(sp: String = "", vararg args: Any?) {
        if (args.isEmpty()) {
            kotlin.io.println()
        }
        val sb = StringBuilder()
        for (i in args.indices) {
            sb.append(args[i])
            if (i < args.size - 1) sb.append(sp)
        }
        kotlin.io.print(sb)
    }

    @JvmStatic
            /**
             * 重定向 System.out 到 INFO 级别日志
             */
    fun redirectOutToInfo() {
        val outLogger = PrintStream(object : OutputStream() {
            private val buffer = StringBuilder()

            override fun write(b: Int) {
                if (b == '\n'.code) {
                    flushBuffer()
                } else {
                    buffer.append(b.toChar())
                }
            }

            override fun write(b: ByteArray, off: Int, len: Int) {
                val str = String(b, off, len)
                if (str.contains("\n")) {
                    val lines = str.split("\n")
                    lines.forEachIndexed { index, line ->
                        if (index == lines.size - 1 && !str.endsWith("\n")) {
                            buffer.append(line)
                        } else {
                            buffer.append(line)
                            flushBuffer()
                        }
                    }
                } else {
                    buffer.append(str)
                }
            }

            private fun flushBuffer() {
                val message = buffer.toString().trim()
                if (message.isNotBlank()) {
                    outLog.info(message)
                }
                buffer.clear()
            }

            override fun flush() {
                flushBuffer()
                super.flush()
            }
        }, true)

        System.setOut(outLogger)
    }

    @JvmStatic
            /**
             * 重定向 System.err 到 ERROR 级别
             */
    fun redirectErrToError() {
        val errLogger = PrintStream(object : OutputStream() {
            private val buffer = StringBuilder()

            override fun write(b: Int) {
                if (b == '\n'.code) {
                    flushBuffer()
                } else {
                    buffer.append(b.toChar())
                }
            }

            override fun write(b: ByteArray, off: Int, len: Int) {
                val str = String(b, off, len)
                if (str.contains("\n")) {
                    val lines = str.split("\n")
                    lines.forEachIndexed { index, line ->
                        if (index == lines.size - 1 && !str.endsWith("\n")) {
                            buffer.append(line)
                        } else {
                            buffer.append(line)
                            flushBuffer()
                        }
                    }
                } else {
                    buffer.append(str)
                }
            }

            private fun flushBuffer() {
                val message = buffer.toString().trim()
                if (message.isNotBlank()) {
                    errLog.error(message)
                }
                buffer.clear()
            }

            override fun flush() {
                flushBuffer()
                super.flush()
            }
        }, true)

        System.setErr(errLogger)
    }

    @JvmStatic
            /**
             * 完全重定向（包括第三方库的输出）
             */
    fun redirectAll() {
        redirectOutToInfo()
        redirectErrToError()
    }

    @JvmStatic
            /**
             * 恢复原始输出流
             */
    fun restore() {
        System.setOut(originalOut)
        System.setErr(originalErr)
    }
}
