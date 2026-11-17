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

/**
 * 反射工具对象，提供 Kotlin 反射与 Java 反射之间的桥接扩展以及调用栈帧获取方法。
 */
object ReflectUtils {
	private val walker: StackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
	/**
	 * 任意对象的扩展函数，获取接收者对应的 KClass 对象。
	 *
	 * @param T 接收者类型
	 * @return 接收者类型对应的 KClass
	 */
	inline fun <reified T : Any> T.ktClass(): KClass<T> = T::class

	/**
	 * KMutableProperty 的扩展属性，通过 getter/setter 反射调用读写属性值。
	 */
	var <T : Any> KMutableProperty<T>.value: T
		get() = this.getter.call()
		set(t: T) = this.setter.call(t)

	/**
	 * KProperty 的扩展属性，获取属性 getter 对应的 Java 反射 Method 对象。
	 */
	val <T : Any> KProperty<T>.javaGetter: Method
		get() = this.getter.javaMethod!!

	/**
	 * KMutableProperty 的扩展属性，获取可变属性对应的 Java 反射 Method 对象。
	 */
	val <T : Any> KMutableProperty<T>.javaSetter: Method
		get() = this.getter.javaMethod!!
	/**
	 * KFunction 的扩展属性，获取函数对应的 Java 反射 Method 对象。
	 */
	val <T : Any> KFunction<T>.java: Method
		get() = this.javaMethod!!

	/**
	 * 获取当前调用栈的栈帧列表，自动跳过工具内部的栈帧。
	 *
	 * @param skip 额外跳过的栈帧数量，默认为 0
	 * @param limit 返回的栈帧数量上限，0 表示不限制
	 * @return 栈帧列表
	 */
	fun getStackFrame(skip: Long = 0, limit: Long = 0): List<StackWalker.StackFrame> {
		return walker.walk {
			it.skip(skip + 2).ifOr(limit == 0L) {
				limit(limit)
			}.toList()
		}
	}
}
