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


@JvmName("_inline_deepClone")
inline fun <reified T : Serializable> T.deepClone(): T {
    return deepClone(this)
}

inline fun <reified T> T.deepJsonClone(): T {
    try {
        return JSONA.convert(this as Any, this!!.javaClass) as T
    } catch (e: Exception) {
        throw JsonException(
            "Failed to deep clone object using JSON", e
        )
    }
}

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
