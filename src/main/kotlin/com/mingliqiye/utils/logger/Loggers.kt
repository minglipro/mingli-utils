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
 * CurrentFile Loggers.kt
 * LastUpdate 2026-02-05 10:20:31
 * UpdateUser MingLiPro
 */

@file:JvmName("Loggers")

package com.mingliqiye.utils.logger


import org.slf4j.Logger
import org.slf4j.Marker

enum class MingLiLoggerLevel {
    TRACE,
    DEBUG,
    INFO,
    WARN,
    ERROR
}

class MingLiLogger(private val name: String) : Logger {
    override fun getName(): String {
        return name
    }

    override fun isTraceEnabled(): Boolean {
        return true
    }

    override fun trace(msg: String?) {
        msg?.let { toPrintln(it, MingLiLoggerLevel.TRACE) }
    }

    override fun trace(format: String?, arg: Any?) {
        format?.let {
            val message = format1(it, arg)
            toPrintln(message, MingLiLoggerLevel.TRACE)
        }
    }

    override fun trace(format: String?, arg1: Any?, arg2: Any?) {
        format?.let {
            val message = format2(it, arg1, arg2)
            toPrintln(message, MingLiLoggerLevel.TRACE)
        }
    }

    override fun trace(format: String?, vararg arguments: Any?) {
        format?.let {
            val message = formatArray(it, arguments)
            toPrintln(message, MingLiLoggerLevel.TRACE)
        }
    }

    override fun trace(msg: String?, t: Throwable?) {
        msg?.let {
            val message = if (t != null) "$it: ${t.message}" else it
            toPrintln(message, MingLiLoggerLevel.TRACE)
        }
    }

    override fun isTraceEnabled(marker: Marker?): Boolean {
        return true
    }

    override fun trace(marker: Marker?, msg: String?) {
        trace(msg)
    }

    override fun trace(marker: Marker?, format: String?, arg: Any?) {
        trace(format, arg)
    }

    override fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        trace(format, arg1, arg2)
    }

    override fun trace(marker: Marker?, format: String?, vararg arguments: Any?) {
        trace(format, *arguments)
    }

    override fun trace(marker: Marker?, msg: String?, t: Throwable?) {
        trace(msg, t)
    }

    override fun isDebugEnabled(): Boolean {
        return true
    }

    override fun debug(msg: String?) {
        msg?.let { toPrintln(it, MingLiLoggerLevel.DEBUG) }
    }

    override fun debug(format: String?, arg: Any?) {
        format?.let {
            val message = format1(it, arg)
            toPrintln(message, MingLiLoggerLevel.DEBUG)
        }
    }

    override fun debug(format: String?, arg1: Any?, arg2: Any?) {
        format?.let {
            val message = format2(it, arg1, arg2)
            toPrintln(message, MingLiLoggerLevel.DEBUG)
        }
    }

    override fun debug(format: String?, vararg arguments: Any?) {
        format?.let {
            val message = formatArray(it, arguments)
            toPrintln(message, MingLiLoggerLevel.DEBUG)
        }
    }

    override fun debug(msg: String?, t: Throwable?) {
        msg?.let {
            val message = if (t != null) "$it: ${t.message}" else it
            toPrintln(message, MingLiLoggerLevel.DEBUG)
        }
    }

    override fun isDebugEnabled(marker: Marker?): Boolean {
        return true
    }

    override fun debug(marker: Marker?, msg: String?) {
        debug(msg)
    }

    override fun debug(marker: Marker?, format: String?, arg: Any?) {
        debug(format, arg)
    }

    override fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        debug(format, arg1, arg2)
    }

    override fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
        debug(format, *arguments)
    }

    override fun debug(marker: Marker?, msg: String?, t: Throwable?) {
        debug(msg, t)
    }

    override fun isInfoEnabled(): Boolean {
        return true
    }

    override fun info(msg: String?) {
        msg?.let { toPrintln(it, MingLiLoggerLevel.INFO) }
    }

    override fun info(format: String?, arg: Any?) {
        format?.let {
            val message = format1(it, arg)
            toPrintln(message, MingLiLoggerLevel.INFO)
        }
    }

    override fun info(format: String?, arg1: Any?, arg2: Any?) {
        format?.let {
            val message = format2(it, arg1, arg2)
            toPrintln(message, MingLiLoggerLevel.INFO)
        }
    }

    override fun info(format: String?, vararg arguments: Any?) {
        format?.let {
            val message = formatArray(it, arguments)
            toPrintln(message, MingLiLoggerLevel.INFO)
        }
    }

    override fun info(msg: String?, t: Throwable?) {
        msg?.let {
            val message = if (t != null) "$it: ${t.message}" else it
            toPrintln(message, MingLiLoggerLevel.INFO)
        }
    }

    override fun isInfoEnabled(marker: Marker?): Boolean {
        return true
    }

    override fun info(marker: Marker?, msg: String?) {
        info(msg)
    }

    override fun info(marker: Marker?, format: String?, arg: Any?) {
        info(format, arg)
    }

    override fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        info(format, arg1, arg2)
    }

    override fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
        info(format, *arguments)
    }

    override fun info(marker: Marker?, msg: String?, t: Throwable?) {
        info(msg, t)
    }

    override fun isWarnEnabled(): Boolean {
        return true
    }

    override fun warn(msg: String?) {
        msg?.let { toPrintln(it, MingLiLoggerLevel.WARN) }
    }

    override fun warn(format: String?, arg: Any?) {
        format?.let {
            val message = format1(it, arg)
            toPrintln(message, MingLiLoggerLevel.WARN)
        }
    }

    override fun warn(format: String?, vararg arguments: Any?) {
        format?.let {
            val message = formatArray(it, arguments)
            toPrintln(message, MingLiLoggerLevel.WARN)
        }
    }

    override fun warn(format: String?, arg1: Any?, arg2: Any?) {
        format?.let {
            val message = format2(it, arg1, arg2)
            toPrintln(message, MingLiLoggerLevel.WARN)
        }
    }

    override fun warn(msg: String?, t: Throwable?) {
        msg?.let {
            val message = if (t != null) "$it: ${t.message}" else it
            toPrintln(message, MingLiLoggerLevel.WARN)
        }
    }

    override fun isWarnEnabled(marker: Marker?): Boolean {
        return true
    }

    override fun warn(marker: Marker?, msg: String?) {
        warn(msg)
    }

    override fun warn(marker: Marker?, format: String?, arg: Any?) {
        warn(format, arg)
    }

    override fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        warn(format, arg1, arg2)
    }

    override fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
        warn(format, *arguments)
    }

    override fun warn(marker: Marker?, msg: String?, t: Throwable?) {
        warn(msg, t)
    }

    override fun isErrorEnabled(): Boolean {
        return true
    }

    override fun error(msg: String?) {
        msg?.let { toPrintln(it, MingLiLoggerLevel.ERROR) }
    }

    override fun error(format: String?, arg: Any?) {
        format?.let {
            val message = format1(it, arg)
            toPrintln(message, MingLiLoggerLevel.ERROR)
        }
    }

    override fun error(format: String?, arg1: Any?, arg2: Any?) {
        format?.let {
            val message = format2(it, arg1, arg2)
            toPrintln(message, MingLiLoggerLevel.ERROR)
        }
    }

    override fun error(format: String?, vararg arguments: Any?) {
        format?.let {
            val message = formatArray(it, arguments)
            toPrintln(message, MingLiLoggerLevel.ERROR)
        }
    }

    override fun error(msg: String?, t: Throwable?) {
        msg?.let {
            val message = if (t != null) "$it: ${t.message}" else it
            toPrintln(message, MingLiLoggerLevel.ERROR)
        }
    }

    override fun isErrorEnabled(marker: Marker?): Boolean {
        return true
    }

    override fun error(marker: Marker?, msg: String?) {
        error(msg)
    }

    override fun error(marker: Marker?, format: String?, arg: Any?) {
        error(format, arg)
    }

    override fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        error(format, arg1, arg2)
    }

    override fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
        error(format, *arguments)
    }

    override fun error(marker: Marker?, msg: String?, t: Throwable?) {
        error(msg, t)
    }

    fun toPrintln(message: String, level: MingLiLoggerLevel) {
        when (level) {
            MingLiLoggerLevel.TRACE -> wirteToSteam("[TRACE] [$name] $message\n")
            MingLiLoggerLevel.DEBUG -> wirteToSteam("[DEBUG] [$name] $message\n")
            MingLiLoggerLevel.INFO -> wirteToSteam("[INFO] [$name] $message\n")
            MingLiLoggerLevel.WARN -> wirteToSteam("[WARN] [$name] $message\n")
            MingLiLoggerLevel.ERROR -> wirteToSteam("[ERROR] [$name] $message\n")
        }
    }

    fun wirteToSteam(string: String) {
        System.out.write(string.toByteArray())
    }

    private fun format1(format: String, arg: Any?): String {
        return if (format.contains("{}")) {
            format.replaceFirst("{}", arg?.toString() ?: "null")
        } else {
            "$format $arg"
        }
    }

    private fun format2(format: String, arg1: Any?, arg2: Any?): String {
        return format.replaceFirst("{}", arg1?.toString() ?: "null")
            .replaceFirst("{}", arg2?.toString() ?: "null")
    }

    private fun formatArray(format: String, arguments: Array<out Any?>): String {
        var result = format
        for (arg in arguments) {
            result = result.replaceFirst("{}", arg?.toString() ?: "null")
        }
        return result
    }
}
