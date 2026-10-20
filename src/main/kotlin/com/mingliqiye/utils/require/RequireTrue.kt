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
 * LastUpdate 2026-10-20 20:05:24
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.require

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

const val DEFAULT_MESSAGE = "required fail"

class Required<T : Throwable>(private val newException: (message: String) -> T) {


    @OptIn(ExperimentalContracts::class)
    fun requireTrue(value: Boolean, message: String) {
        contract {
            returns() implies value
        }
        requireTrue(value) { message }
    }

    @OptIn(ExperimentalContracts::class)
    fun requireTrue(value: Boolean) {
        contract {
            returns() implies value
        }
        requireTrue(value) { DEFAULT_MESSAGE }
    }

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

fun newRequired(): Required<IllegalArgumentException> {
    return newRequired<IllegalArgumentException>()
}

fun <T : Throwable> newRequired(clazz: Class<T>): Required<T> {
    return Required {
        newException(clazz, it)
    }
}

inline fun <reified T : Throwable> newRequired(): Required<T> {
    return newRequired(T::class.java)
}

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

@OptIn(ExperimentalContracts::class)
fun <T : Throwable> requireTrue(value: Boolean, clazz: Class<T>, lazyMessage: () -> String) {
    contract {
        returns() implies value
    }
    if (!value) {
        throw newException(clazz, lazyMessage())
    }
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T : Throwable> requireTrue(value: Boolean, noinline lazyMessage: () -> String) {
    contract {
        returns() implies value
    }
    requireTrue(value, T::class.java, lazyMessage)
}

@OptIn(ExperimentalContracts::class)
fun <T : Throwable> Boolean.requireTrue(clazz: Class<T>, lazyMessage: () -> String) {
    contract {
        returns() implies this@requireTrue
    }
    requireTrue(this, clazz, lazyMessage)
}

@OptIn(ExperimentalContracts::class)
fun <T : Throwable> Boolean.requireTrue(clazz: Class<T>, message: String) {
    contract {
        returns() implies this@requireTrue
    }
    requireTrue(this, clazz) {
        message
    }
}

@OptIn(ExperimentalContracts::class)
fun <T : Throwable> requireTrue(value: Boolean, clazz: Class<T>, message: String) {
    contract {
        returns() implies value
    }
    requireTrue(value, clazz) { message }
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T : Throwable> requireTrue(value: Boolean, message: String) {
    contract {
        returns() implies value
    }
    requireTrue(value, T::class.java) { message }
}


@OptIn(ExperimentalContracts::class)
inline fun <reified T : Throwable> Boolean.requireTrue(noinline lazyMessage: () -> String) {
    contract {
        returns() implies this@requireTrue
    }
    requireTrue(this, T::class.java, lazyMessage)

}

@OptIn(ExperimentalContracts::class)
inline fun <reified T : Throwable> Boolean.requireTrue(message: String) {
    contract {
        returns() implies this@requireTrue
    }
    requireTrue(this, T::class.java, message)

}

@OptIn(ExperimentalContracts::class)
fun <T : Throwable> requireTrue(value: Boolean, clazz: Class<T>) {
    contract {
        returns() implies value
    }
    requireTrue(value, clazz) { DEFAULT_MESSAGE }
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T : Throwable> requireTrue(value: Boolean) {
    contract {
        returns() implies value
    }
    requireTrue(value, T::class.java) { DEFAULT_MESSAGE }
}


@OptIn(ExperimentalContracts::class)
fun <T : Throwable> Boolean.requireTrue(clazz: Class<T>) {
    contract {
        returns() implies this@requireTrue
    }
    requireTrue(this, clazz) { DEFAULT_MESSAGE }

}

@OptIn(ExperimentalContracts::class)
inline fun <reified T : Throwable> Boolean.requireTrue() {
    contract {
        returns() implies this@requireTrue
    }
    requireTrue(this, T::class.java) { DEFAULT_MESSAGE }

}
