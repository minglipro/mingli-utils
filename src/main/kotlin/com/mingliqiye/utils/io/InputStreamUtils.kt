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
 * CurrentFile InputStreamUtils.kt
 * LastUpdate 2025-09-15 17:26:34
 * UpdateUser MingLiPro
 */
@file:JvmName("InputStreamUtils")

package com.mingliqiye.utils.io

import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset


fun InputStream.readAllText(charset: Charset = Charsets.UTF_8): String {
    return this.readAllBytes().toString(charset)
}

fun InputStream.readAllBytes(): ByteArray {
    return this.readBytes()
}

fun InputStream.exportBytes(out: OutputStream) {
    out.write(this.readAllBytes())
    out.flush()
}

fun InputStream.readToList(): List<Byte> {
    return this.readBytes().toList()
}




