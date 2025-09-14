/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile CloneUtil.kt
 * LastUpdate 2025-09-14 19:53:41
 * UpdateUser MingLiPro
 */
@file:JvmName("CloneUtils")

package com.mingliqiye.utils.clone

import com.mingliqiye.utils.json.JsonApi
import com.mingliqiye.utils.json.JsonException
import java.io.*


inline fun <reified T> Serializable.deepClone(): T {
    return deepClone(this) as T
}

inline fun <reified T> T.deepJsonClone(jsonApi: JsonApi): T {
    try {
        return jsonApi.convert(this, this!!.javaClass) as T

    } catch (e: Exception) {
        throw JsonException(
            "Failed to deep clone object using JSON",
            e
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
