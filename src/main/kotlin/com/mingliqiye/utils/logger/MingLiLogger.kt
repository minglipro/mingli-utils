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
 * CurrentFile MingLiLogger.kt
 * LastUpdate 2026-11-16 11:35:40
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.logger

import org.slf4j.Logger
import org.slf4j.Marker
import org.slf4j.helpers.MessageFormatter

/**
 * 简易 SLF4J Logger 实现，将各级别日志直接输出到标准输出流。
 * 所有日志级别始终启用，消息格式遵循 SLF4J 的 {} 占位符风格。
 *
 * @param name 日志器名称，输出时作为标识显示
 */
class MingLiLogger(private val name: String) : Logger {
	override fun getName(): String {
		return name
	}

	/**
	 * 始终返回 true，TRACE 级别日志始终启用。
	 */
	override fun isTraceEnabled(): Boolean {
		return true
	}

	override fun trace(msg: String?) {
		msg?.let { toPrintln(it, MingLiLoggerLevel.TRACE) }
	}

	override fun trace(format: String?, arg: Any?) {
		format?.let {
			val message = format(it, arg)
			toPrintln(message, MingLiLoggerLevel.TRACE)
		}
	}

	override fun trace(format: String?, arg1: Any?, arg2: Any?) {
		format?.let {
			val message = format(it, arg1, arg2)
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

	/**
	 * 始终返回 true，忽略 marker 参数。
	 */
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

	/**
	 * 始终返回 true，DEBUG 级别日志始终启用。
	 */
	override fun isDebugEnabled(): Boolean {
		return true
	}

	override fun debug(msg: String?) {
		msg?.let { toPrintln(it, MingLiLoggerLevel.DEBUG) }
	}

	override fun debug(format: String?, arg: Any?) {
		format?.let {
			val message = format(it, arg)
			toPrintln(message, MingLiLoggerLevel.DEBUG)
		}
	}

	override fun debug(format: String?, arg1: Any?, arg2: Any?) {
		format?.let {
			val message = format(it, arg1, arg2)
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

	/**
	 * 始终返回 true，忽略 marker 参数。
	 */
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

	/**
	 * 始终返回 true，INFO 级别日志始终启用。
	 */
	override fun isInfoEnabled(): Boolean {
		return true
	}

	override fun info(msg: String?) {
		msg?.let { toPrintln(it, MingLiLoggerLevel.INFO) }
	}

	override fun info(format: String?, arg: Any?) {
		format?.let {
			val message = format(it, arg)
			toPrintln(message, MingLiLoggerLevel.INFO)
		}
	}

	override fun info(format: String?, arg1: Any?, arg2: Any?) {
		format?.let {
			val message = format(it, arg1, arg2)
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

	/**
	 * 始终返回 true，忽略 marker 参数。
	 */
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

	/**
	 * 始终返回 true，WARN 级别日志始终启用。
	 */
	override fun isWarnEnabled(): Boolean {
		return true
	}

	override fun warn(msg: String?) {
		msg?.let { toPrintln(it, MingLiLoggerLevel.WARN) }
	}

	override fun warn(format: String?, arg: Any?) {
		format?.let {
			val message = format(it, arg)
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
			val message = format(it, arg1, arg2)
			toPrintln(message, MingLiLoggerLevel.WARN)
		}
	}

	override fun warn(msg: String?, t: Throwable?) {
		msg?.let {
			val message = if (t != null) "$it: ${t.message}" else it
			toPrintln(message, MingLiLoggerLevel.WARN)
		}
	}

	/**
	 * 始终返回 true，忽略 marker 参数。
	 */
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

	/**
	 * 始终返回 true，ERROR 级别日志始终启用。
	 */
	override fun isErrorEnabled(): Boolean {
		return true
	}

	override fun error(msg: String?) {
		msg?.let { toPrintln(it, MingLiLoggerLevel.ERROR) }
	}

	override fun error(format: String?, arg: Any?) {
		format?.let {
			val message = format(it, arg)
			toPrintln(message, MingLiLoggerLevel.ERROR)
		}
	}

	override fun error(format: String?, arg1: Any?, arg2: Any?) {
		format?.let {
			val message = format(it, arg1, arg2)
			toPrintln(message, MingLiLoggerLevel.ERROR)
		}
	}

	override fun error(format: String?, vararg arguments: Any?) {
		format?.let {
			val message = formatArray(it, arguments)
			toPrintln(message, MingLiLoggerLevel.ERROR)
		}
	}

	/**
	 * 输出 ERROR 级别日志，仅输出消息文本，忽略异常参数。
	 */
	override fun error(msg: String?, t: Throwable?) {
		msg?.let {
			toPrintln(it, MingLiLoggerLevel.ERROR)
		}
	}

	/**
	 * 始终返回 true，忽略 marker 参数。
	 */
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

	/**
	 * 按指定日志级别格式化并输出日志消息。
	 *
	 * @param message 日志消息内容
	 * @param level 日志级别
	 */
	fun toPrintln(message: String, level: MingLiLoggerLevel) {
		when (level) {
			MingLiLoggerLevel.TRACE -> wirteToSteam("[TRACE] [$name] $message\n")
			MingLiLoggerLevel.DEBUG -> wirteToSteam("[DEBUG] [$name] $message\n")
			MingLiLoggerLevel.INFO -> wirteToSteam("[INFO] [$name] $message\n")
			MingLiLoggerLevel.WARN -> wirteToSteam("[WARN] [$name] $message\n")
			MingLiLoggerLevel.ERROR -> wirteToSteam("[ERROR] [$name] $message\n")
		}
	}

	/**
	 * 将字符串以字节形式写入标准输出流。
	 *
	 * @param string 要输出的字符串
	 */
	fun wirteToSteam(string: String) {
		System.out.write(string.toByteArray())
	}

	private fun format(format: String, vararg args: Any?): String {
		return formatArray(format, args)
	}

	private fun formatArray(format: String, arguments: Array<out Any?>): String {
		return MessageFormatter.arrayFormat(
			format,
			arguments
		).message
	}
}
