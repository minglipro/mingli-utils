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
 * CurrentFile ReflectUtils.kt
 * LastUpdate 2026-10-11 17:11:11
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.reflect

import com.mingliqiye.utils.io.SIO.ifOr
import java.lang.reflect.Method
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.javaMethod

object ReflectUtils {
    private val walker: StackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
    inline fun <reified T : Any> T.ktClass(): KClass<T> = T::class

    var <T : Any> KMutableProperty<T>.value: T
        get() = this.getter.call()
        set(t: T) = this.setter.call(t)

    val <T : Any> KProperty<T>.javaGetter: Method
        get() = this.getter.javaMethod!!

    val <T : Any> KMutableProperty<T>.javaSetter: Method
        get() = this.getter.javaMethod!!
    val <T : Any> KFunction<T>.java: Method
        get() = this.javaMethod!!

    fun getStackFrame(skip: Long = 0, limit: Long = 0): List<StackWalker.StackFrame> {
        return walker.walk {
            it.skip(skip + 2).ifOr(limit == 0L) {
                limit(limit)
            }.toList()
        }
    }
}
