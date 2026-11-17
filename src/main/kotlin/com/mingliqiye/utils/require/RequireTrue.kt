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
 * CurrentFile RequireTrue.kt
 * LastUpdate 2026-10-20 21:07:55
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.require

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * 校验失败时使用的默认错误消息。
 */
const val DEFAULT_MESSAGE = "required fail"

/**
 * 条件校验器，校验失败时通过指定的异常构造函数创建并抛出异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param newException 异常构造函数，根据错误消息创建异常实例
 */
class Required<T : Throwable>(private val newException: (message: String) -> T) {


	/**
	 * 校验条件必须为 true，否则使用指定消息抛出异常。
	 *
	 * @param value 待校验的条件
	 * @param message 校验失败时的错误消息
	 */
	@OptIn(ExperimentalContracts::class)
	fun requireTrue(value: Boolean, message: String) {
		contract {
			returns() implies value
		}
		requireTrue(value) { message }
	}

	/**
	 * 校验条件必须为 true，否则使用默认消息抛出异常。
	 *
	 * @param value 待校验的条件
	 */
	@OptIn(ExperimentalContracts::class)
	fun requireTrue(value: Boolean) {
		contract {
			returns() implies value
		}
		requireTrue(value) { DEFAULT_MESSAGE }
	}

	/**
	 * 校验条件必须为 true，否则使用延迟生成的消息抛出异常。
	 *
	 * @param value 待校验的条件
	 * @param lazyMessage 延迟错误消息生成函数，仅在校验失败时调用
	 */
	@OptIn(ExperimentalContracts::class)
	fun requireTrue(value: Boolean, lazyMessage: () -> String) {
		contract {
			returns() implies value
		}
		if (!value) {
			throw newException(lazyMessage())
		}
	}

}

/**
 * 根据异常类的 Class 对象创建条件校验器。
 *
 * @param T 校验失败时抛出的异常类型
 * @param clazz 异常类的 Class 对象，必须具有接收 String 消息的构造函数
 * @return 使用该异常类型的条件校验器
 */
fun <T : Throwable> newRequired(clazz: Class<T>): Required<T> {
	return Required {
		newException(clazz, it)
	}
}

/**
 * 创建默认的条件校验器，校验失败时抛出 IllegalArgumentException。
 *
 * @return 使用 IllegalArgumentException 的条件校验器
 */
fun newRequired(): Required<IllegalArgumentException> {
	return newRequired<IllegalArgumentException>()
}

/**
 * 通过 reified 类型参数创建条件校验器，无需显式传入 Class 对象。
 *
 * @param T 校验失败时抛出的异常类型
 * @return 使用该异常类型的条件校验器
 */
@JvmName("newRequiredInline")
inline fun <reified T : Throwable> newRequired(): Required<T> {
	return newRequired(T::class.java)
}

/**
 * 通过反射调用异常类接收 String 消息的构造函数创建异常实例。
 *
 * @param T 异常类型
 * @param clazz 异常类的 Class 对象，不能是抽象类
 * @param msg 异常消息
 * @return 新创建的异常实例
 * @throws IllegalStateException 如果异常类无法实例化
 */
fun <T : Throwable> newException(clazz: Class<T>, msg: String): T = try {
	val constructor = clazz.getConstructor(String::class.java).also {
		check(!java.lang.reflect.Modifier.isAbstract(clazz.modifiers)) {
			"${clazz.name} 是抽象类，无法实例化"
		}
	}
	constructor.newInstance(msg)
} catch (e: ReflectiveOperationException) {
	throw IllegalStateException("无法实例化 ${clazz.name}", e)
}

/**
 * 校验条件必须为 true，否则使用延迟生成的消息抛出指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param value 待校验的条件
 * @param clazz 异常类的 Class 对象
 * @param lazyMessage 延迟错误消息生成函数，仅在校验失败时调用
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueDef")
fun <T : Throwable> requireTrue(value: Boolean, clazz: Class<T>, lazyMessage: () -> String) {
	contract {
		returns() implies value
	}
	if (!value) {
		throw newException(clazz, lazyMessage())
	}
}

/**
 * 校验条件必须为 true，否则使用延迟生成的消息抛出 reified 指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param value 待校验的条件
 * @param lazyMessage 延迟错误消息生成函数，仅在校验失败时调用
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueInline")
inline fun <reified T : Throwable> requireTrue(value: Boolean, noinline lazyMessage: () -> String) {
	contract {
		returns() implies value
	}
	requireTrue(value, T::class.java, lazyMessage)
}

/**
 * Boolean 扩展函数，校验接收者必须为 true，否则使用延迟生成的消息抛出指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param clazz 异常类的 Class 对象
 * @param lazyMessage 延迟错误消息生成函数，仅在校验失败时调用
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueOnBoolean")
fun <T : Throwable> Boolean.requireTrue(clazz: Class<T>, lazyMessage: () -> String) {
	contract {
		returns() implies this@requireTrue
	}
	requireTrue(this, clazz, lazyMessage)
}

/**
 * Boolean 扩展函数，校验接收者必须为 true，否则使用指定消息抛出指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param clazz 异常类的 Class 对象
 * @param message 校验失败时的错误消息
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueOnBoolean")
fun <T : Throwable> Boolean.requireTrue(clazz: Class<T>, message: String) {
	contract {
		returns() implies this@requireTrue
	}
	requireTrue(this, clazz) {
		message
	}
}

/**
 * 校验条件必须为 true，否则使用指定消息抛出指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param value 待校验的条件
 * @param clazz 异常类的 Class 对象
 * @param message 校验失败时的错误消息
 */
@OptIn(ExperimentalContracts::class)
fun <T : Throwable> requireTrue(value: Boolean, clazz: Class<T>, message: String) {
	contract {
		returns() implies value
	}
	requireTrue(value, clazz) { message }
}

/**
 * 校验条件必须为 true，否则使用指定消息抛出 reified 指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param value 待校验的条件
 * @param message 校验失败时的错误消息
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueInline")
inline fun <reified T : Throwable> requireTrue(value: Boolean, message: String) {
	contract {
		returns() implies value
	}
	requireTrue(value, T::class.java) { message }
}


/**
 * Boolean 扩展函数，校验接收者必须为 true，否则使用延迟生成的消息抛出 reified 指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param lazyMessage 延迟错误消息生成函数，仅在校验失败时调用
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueOnBoolean")
inline fun <reified T : Throwable> Boolean.requireTrue(noinline lazyMessage: () -> String) {
	contract {
		returns() implies this@requireTrue
	}
	requireTrue(this, T::class.java, lazyMessage)

}

/**
 * Boolean 扩展函数，校验接收者必须为 true，否则使用指定消息抛出 reified 指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param message 校验失败时的错误消息
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueOnBoolean")
inline fun <reified T : Throwable> Boolean.requireTrue(message: String) {
	contract {
		returns() implies this@requireTrue
	}
	requireTrue(this, T::class.java, message)

}

/**
 * 校验条件必须为 true，否则使用默认消息抛出指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param value 待校验的条件
 * @param clazz 异常类的 Class 对象
 */
@OptIn(ExperimentalContracts::class)
fun <T : Throwable> requireTrue(value: Boolean, clazz: Class<T>) {
	contract {
		returns() implies value
	}
	requireTrue(value, clazz) { DEFAULT_MESSAGE }
}

/**
 * 校验条件必须为 true，否则使用默认消息抛出 reified 指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param value 待校验的条件
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueInline")
inline fun <reified T : Throwable> requireTrue(value: Boolean) {
	contract {
		returns() implies value
	}
	requireTrue(value, T::class.java) { DEFAULT_MESSAGE }
}

/**
 * 校验条件必须为 true，否则使用默认消息抛出 IllegalArgumentException。
 *
 * @param value 待校验的条件
 */
@OptIn(ExperimentalContracts::class)
fun requireTrue(value: Boolean) {
	contract {
		returns() implies value
	}
	requireTrue(value, IllegalArgumentException::class.java) { DEFAULT_MESSAGE }
}

/**
 * 校验条件必须为 true，否则使用指定消息抛出 IllegalArgumentException。
 *
 * @param value 待校验的条件
 * @param message 校验失败时的错误消息
 */
@OptIn(ExperimentalContracts::class)
fun requireTrue(value: Boolean, message: String) {
	contract {
		returns() implies value
	}
	requireTrue(value, IllegalArgumentException::class.java) { message }
}

/**
 * 校验条件必须为 true，否则使用延迟生成的消息抛出 IllegalArgumentException。
 *
 * @param value 待校验的条件
 * @param lazyMessage 延迟错误消息生成函数，仅在校验失败时调用
 */
@OptIn(ExperimentalContracts::class)
fun requireTrue(value: Boolean, lazyMessage: () -> String) {
	contract {
		returns() implies value
	}
	requireTrue(value, IllegalArgumentException::class.java, lazyMessage)
}


/**
 * Boolean 扩展函数，校验接收者必须为 true，否则使用默认消息抛出指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 * @param clazz 异常类的 Class 对象
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueOnBoolean")
fun <T : Throwable> Boolean.requireTrue(clazz: Class<T>) {
	contract {
		returns() implies this@requireTrue
	}
	requireTrue(this, clazz) { DEFAULT_MESSAGE }

}

/**
 * Boolean 扩展函数，校验接收者必须为 true，否则使用默认消息抛出 reified 指定类型的异常。
 *
 * @param T 校验失败时抛出的异常类型
 */
@OptIn(ExperimentalContracts::class)
@JvmName("requireTrueOnBoolean")
inline fun <reified T : Throwable> Boolean.requireTrue() {
	contract {
		returns() implies this@requireTrue
	}
	requireTrue(this, T::class.java) { DEFAULT_MESSAGE }

}
