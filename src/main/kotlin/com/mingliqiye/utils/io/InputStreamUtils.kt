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
 * CurrentFile InputStreamUtils.kt
 * LastUpdate 2026-03-11 08:46:40
 * UpdateUser MingLiPro
 */
@file:JvmName("InputStreamUtils")

package com.mingliqiye.utils.io

import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset


/**
 * 读取输入流中的全部字节并按指定字符集解码为字符串。
 *
 * @param charset 字符编码，默认为 [Charsets.UTF_8]
 * @return 解码后的字符串
 */
fun InputStream.readAllText(charset: Charset = Charsets.UTF_8) = this.readAllBytes().toString(charset)

/**
 * 将输入流中的全部字节导出到指定输出流，并刷新输出流。
 *
 * @param out 目标输出流
 */
fun InputStream.exportBytes(out: OutputStream) {
	out.write(this.readAllBytes())
	out.flush()
}

/**
 * 读取输入流中的全部字节并转换为字节列表。
 *
 * @return 包含全部字节的列表
 */
fun InputStream.readToList(): List<Byte> = this.readBytes().toList()


/**
 * 读取输入流中的全部字节。
 *
 * @return 包含全部字节的字节数组
 */
@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
@JvmName("readInputStreamAllBytes")
fun InputStream.readAllBytes(): ByteArray = this.readBytes()
