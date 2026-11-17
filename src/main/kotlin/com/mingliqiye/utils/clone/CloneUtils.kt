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
 * CurrentFile CloneUtils.kt
 * LastUpdate 2026-02-08 10:36:51
 * UpdateUser MingLiPro
 */
@file:JvmName("CloneUtils")

package com.mingliqiye.utils.clone

import com.mingliqiye.utils.exception.JsonException
import com.mingliqiye.utils.json.api.JSONA
import java.io.*


/**
 * 通过 Java 序列化机制对当前对象进行深克隆。
 *
 * @param T 对象类型，必须实现 [Serializable]
 * @return 深克隆后的新对象
 */
@JvmName("_inline_deepClone")
inline fun <reified T : Serializable> T.deepClone(): T {
	return deepClone(this)
}

/**
 * 通过 JSON 序列化与反序列化对当前对象进行深克隆。
 *
 * @param T 对象类型
 * @return 深克隆后的新对象
 * @throws JsonException 如果 JSON 转换过程中发生异常
 */
inline fun <reified T> T.deepJsonClone(): T {
	try {
		return JSONA.convert(this as Any, this!!.javaClass) as T
	} catch (e: Exception) {
		throw JsonException(
			"Failed to deep clone object using JSON", e
		)
	}
}

/**
 * 通过 Java 序列化机制对对象进行深克隆。
 *
 * 将对象序列化到内存后再反序列化，得到一个全新的对象副本。
 *
 * @param T 对象类型，必须实现 [Serializable]
 * @param obj 要克隆的对象
 * @return 深克隆后的新对象
 * @throws RuntimeException 如果序列化或反序列化过程中发生 I/O 异常或类找不到
 */
@Suppress("UNCHECKED_CAST")
fun <T : Serializable?> deepClone(obj: T): T {
	try {
		val bao = ByteArrayOutputStream()
		val oos = ObjectOutputStream(bao)
		oos.writeObject(obj)
		val bis = ByteArrayInputStream(
			bao.toByteArray()
		)
		val ois = ObjectInputStream(bis)
		return ois.readObject() as T
	} catch (e: IOException) {
		throw RuntimeException(e)
	} catch (e: ClassNotFoundException) {
		throw RuntimeException(e)
	}
}
