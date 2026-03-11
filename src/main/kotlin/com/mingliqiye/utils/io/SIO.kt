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
 * CurrentFile SIO.kt
 * LastUpdate 2026-02-27 12:36:11
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
 * 已弃用的IO对象，所有方法都委托给SIO对象
 * @deprecated 请使用SIO对象替代
 */
@Deprecated("This IO is deprecated. reName SIO", replaceWith = ReplaceWith("SIO"), level = DeprecationLevel.WARNING)
object IO {
    /**
     * 打印多个参数，使用空格分隔
     * @param args 要打印的参数数组
     */
    @JvmStatic
    fun print(vararg args: Any?) = SIO.print(*args)

    /**
     * 打印多个参数并换行，使用空格分隔
     * @param args 要打印的参数数组
     */
    @JvmStatic
    fun println(vararg args: Any?) = SIO.println(*args)

    /**
     * 打印多个参数并换行，指定分隔符
     * @param sp 分隔符
     * @param args 要打印的参数数组
     */
    @JvmStatic
    fun printlnA(sp: String, vararg args: Any?) = SIO.printlnA(sp, *args)

    /**
     * 打印多个参数，指定分隔符
     * @param sp 分隔符，默认为空字符串
     * @param args 要打印的参数数组
     */
    @JvmStatic
    fun printA(sp: String = "", vararg args: Any?) = SIO.printA(sp, *args)

    /**
     * 重定向 System.out 到 INFO 级别日志
     */
    @JvmStatic
    fun redirectOutToInfo() = SIO.redirectOutToInfo()

    /**
     * 重定向 System.err 到 ERROR 级别
     */
    @JvmStatic
    fun redirectErrToError() = SIO.redirectErrToError()

    /**
     * 完全重定向（包括第三方库的输出）
     */
    @JvmStatic
    fun redirectAll() = SIO.redirectAll()

    /**
     * 恢复原始输出流
     */
    @JvmStatic
    fun restore() = SIO.restore()
}


/**
 * IO工具类，提供打印功能和系统输出流重定向到日志的功能
 */
object SIO {

    /**
     * 扩展函数：将字节数组以十六进制格式打印，每两个字符用空格分隔
     * @return 原始字节数组
     */
    @JvmStatic
    fun ByteArray.println(): ByteArray {
        this.toHexString().chunked(2).println()
        return this
    }

    /**
     * 扩展函数：将列表以花括号格式打印，元素间用逗号分隔
     * @return 原始列表
     */
    @JvmStatic
    fun <T> List<T>.println(): List<T> {
        println("{" + ",".join(this) + "}")
        return this
    }

    /**
     * 扩展函数：将数组以花括号格式打印，元素间用逗号分隔
     * @return 原始数组
     */
    @JvmStatic
    fun <T> Array<T>.println(): Array<T> {
        println("{" + ",".join(this) + "}")
        return this
    }

    /**
     * 扩展函数：打印任意对象并返回该对象
     * @return 原始对象
     */
    @JvmStatic
    fun <T> T.println(): T {
        println(this)
        return this
    }

    /**
     * 原始标准输出流的备份
     */
    @JvmStatic
    val originalOut: PrintStream = System.out

    /**
     * 原始错误输出流的备份
     */
    @JvmStatic
    val originalErr: PrintStream = System.err

    /**
     * 用于记录标准输出的日志记录器
     */
    @JvmStatic
    val outLog: Logger = MingLiLoggerFactory.getLogger("out")

    /**
     * 用于记录错误输出的日志记录器
     */
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

    /**
     * 重定向 System.out 到 INFO 级别日志
     * 创建自定义PrintStream，将输出内容缓冲并记录到INFO级别日志中
     */
    @JvmStatic
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

    /**
     * 重定向 System.err 到 ERROR 级别
     * 创建自定义PrintStream，将错误输出内容缓冲并记录到ERROR级别日志中
     */
    @JvmStatic
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

    /**
     * 完全重定向（包括第三方库的输出）
     * 同时重定向标准输出和错误输出到对应的日志级别
     */
    @JvmStatic
    fun redirectAll() {
        redirectOutToInfo()
        redirectErrToError()
    }

    /**
     * 恢复原始输出流
     * 将System.out和System.err恢复到原始状态
     */
    @JvmStatic
    fun restore() {
        System.setOut(originalOut)
        System.setErr(originalErr)
    }
}
