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
 * CurrentFile BaseCodec.kt
 * LastUpdate 2026-02-09 19:58:29
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

import com.mingliqiye.utils.exception.CodecException
import java.io.File
import java.nio.file.Path

/**
 * BaseCodec 接口定义了一组用于编码和解码数据的基本方法。
 * 提供了对字节数组、字符串、文件和路径的编码与解码功能，
 * 并支持安全操作（在发生异常时返回默认值或布尔状态）。
 */
interface BaseCodec {

    /**
     * 对字节数组进行编码，并捕获可能发生的异常。
     *
     * @param bytes 需要编码的字节数组
     * @return 编码后的字符串结果
     * @throws CodecException 如果编码过程中发生异常
     */
    fun catchEncode(bytes: ByteArray) = try {
        encode(bytes)
    } catch (e: Exception) {
        throw CodecException(e)
    }

    /**
     * 对字符串进行解码，并捕获可能发生的异常。
     *
     * @param string 需要解码的字符串
     * @return 解码后的字节数组结果
     * @throws CodecException 如果解码过程中发生异常
     */
    fun catchDecode(string: String) = try {
        decode(string)
    } catch (e: Exception) {
        throw CodecException(e)
    }

    /**
     * 将字节数组编码为字符串。
     *
     * @param bytes 需要编码的字节数组
     * @return 编码后的字符串结果
     */
    fun encode(bytes: ByteArray): String

    /**
     * 将字符串解码为字节数组。
     *
     * @param string 需要解码的字符串
     * @return 解码后的字节数组结果
     */
    fun decode(string: String): ByteArray

    /**
     * 对文件内容进行编码。
     *
     * @param file 需要编码的文件对象
     * @return 文件内容编码后的字符串结果
     */
    fun encode(file: File) = catchEncode(file.readBytes())

    /**
     * 将字符串解码后写入指定文件。
     *
     * @param file 目标文件对象
     * @param string 需要解码的字符串
     */
    fun decode(file: File, string: String) =
        file.writeBytes(catchDecode(string))

    /**
     * 安全地对文件内容进行编码，如果发生异常则返回 null。
     *
     * @param file 需要编码的文件对象
     * @return 文件内容编码后的字符串结果，若失败则返回 null
     */
    fun encodeSafe(file: File) = try {
        encode(file)
    } catch (_: Exception) {
        null
    }

    /**
     * 安全地将字符串解码并写入指定文件，如果成功则返回 true，否则返回 false。
     *
     * @param file 目标文件对象
     * @param string 需要解码的字符串
     * @return 操作是否成功的布尔值
     */
    fun decodeSafe(file: File, string: String) = try {
        decode(file, string)
        true
    } catch (_: Exception) {
        false
    }

    /**
     * 对路径指向的文件内容进行编码。
     *
     * @param path 需要编码的文件路径
     * @return 文件内容编码后的字符串结果
     */
    fun encode(path: Path) = catchEncode(path.toFile().readBytes())

    /**
     * 将字符串解码后写入指定路径的文件。
     *
     * @param path 目标文件路径
     * @param string 需要解码的字符串
     */
    fun decode(path: Path, string: String) = path.toFile().writeBytes(catchDecode(string))

    /**
     * 安全地对路径指向的文件内容进行编码，如果发生异常则返回 null。
     *
     * @param path 需要编码的文件路径
     * @return 文件内容编码后的字符串结果，若失败则返回 null
     */
    fun encodeSafe(path: Path) = try {
        encode(path)
    } catch (_: Exception) {
        null
    }

    /**
     * 安全地将字符串解码并写入指定路径的文件，如果成功则返回 true，否则返回 false。
     *
     * @param path 目标文件路径
     * @param string 需要解码的字符串
     * @return 操作是否成功的布尔值
     */
    fun decodeSafe(path: Path, string: String) = try {
        decode(path, string)
        true
    } catch (_: Exception) {
        false
    }

    /**
     * 对字符串进行编码。
     *
     * @param string 需要编码的字符串
     * @return 编码后的字符串结果
     */
    fun encode(string: String) = catchEncode(string.toByteArray())

    /**
     * 将字符串解码为 UTF-8 格式的字符串。
     *
     * @param string 需要解码的字符串
     * @return 解码后的 UTF-8 字符串结果
     */
    fun decodetoString(string: String) = catchDecode(string).toString(Charsets.UTF_8)
}
