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
 * CurrentFile BaseCodec.kt
 * LastUpdate 2025-09-17 10:35:23
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

import java.io.File
import java.io.IOException
import java.nio.file.Path

interface BaseCodec {
    /**
     * 将字节数组编码为Base64字符串
     *
     * @param bytes 需要编码的字节数组
     * @return 编码后的Base64字符串
     */
    fun encode(bytes: ByteArray): String

    /**
     * 将Base64字符串解码为字节数组
     *
     * @param string 需要解码的Base64字符串
     * @return 解码后的字节数组
     */
    fun decode(string: String): ByteArray

    /**
     * 将文件内容编码为Base64字符串
     *
     * @param file 需要编码的文件
     * @return 文件内容的Base64编码字符串
     * @throws IOException 当文件读取失败时抛出
     */
    @Throws(IOException::class)
    fun encode(file: File): String {
        return encode(file.readBytes())
    }

    /**
     * 将Base64字符串解码并写入文件
     *
     * @param file 目标文件
     * @param string 需要解码的Base64字符串
     * @throws IOException 当文件写入失败时抛出
     */
    @Throws(IOException::class)
    fun decode(file: File, string: String) {
        file.writeBytes(decode(string))
    }

    /**
     * 安全地将文件内容编码为Base64字符串，出现异常时返回null
     *
     * @param file 需要编码的文件
     * @return 文件内容的Base64编码字符串，失败时返回null
     */
    fun encodeSafe(file: File): String? {
        return try {
            encode(file)
        } catch (_: Exception) {
            null
        }
    }

    /**
     * 安全地将Base64字符串解码并写入文件，返回操作是否成功
     *
     * @param file 目标文件
     * @param string 需要解码的Base64字符串
     * @return 操作成功返回true，失败返回false
     */
    fun decodeSafe(file: File, string: String): Boolean {
        return try {
            decode(file, string)
            true
        } catch (_: Exception) {
            false
        }
    }

    /**
     * 将路径对应的文件内容编码为Base64字符串
     *
     * @param path 需要编码的文件路径
     * @return 文件内容的Base64编码字符串
     * @throws IOException 当文件读取失败时抛出
     */
    @Throws(IOException::class)
    fun encode(path: Path): String {
        return encode(path.toFile().readBytes())
    }

    /**
     * 将Base64字符串解码并写入路径指定的文件
     *
     * @param path 目标文件路径
     * @param string 需要解码的Base64字符串
     * @throws IOException 当文件写入失败时抛出
     */
    @Throws(IOException::class)
    fun decode(path: Path, string: String) {
        path.toFile().writeBytes(decode(string))
    }

    /**
     * 安全地将路径对应的文件内容编码为Base64字符串，出现异常时返回null
     *
     * @param path 需要编码的文件路径
     * @return 文件内容的Base64编码字符串，失败时返回null
     */
    fun encodeSafe(path: Path): String? {
        return try {
            encode(path)
        } catch (_: Exception) {
            null
        }
    }

    /**
     * 安全地将Base64字符串解码并写入路径指定的文件，返回操作是否成功
     *
     * @param path 目标文件路径
     * @param string 需要解码的Base64字符串
     * @return 操作成功返回true，失败返回false
     */
    fun decodeSafe(path: Path, string: String): Boolean {
        return try {
            decode(path, string)
            true
        } catch (_: Exception) {
            false
        }
    }
}
