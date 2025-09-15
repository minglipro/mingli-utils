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
 * CurrentFile FileUtils.kt
 * LastUpdate 2025-09-15 09:12:47
 * UpdateUser MingLiPro
 */
@file:JvmName("FileUtils")

package com.mingliqiye.utils.file

import com.mingliqiye.utils.path.OsPath
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

/**
 * 默认字符集
 */

var DEFAULT_CHARSET: Charset = StandardCharsets.UTF_8

/**
 * 读取文件内容为字符串
 *
 * @param filePath 文件路径
 * @return 文件内容字符串
 * @throws IOException 读取文件时发生错误
 */

@Throws(IOException::class)
fun readFileToString(filePath: String): String {
    return readFileToString(filePath, DEFAULT_CHARSET)
}

/**
 * 读取文件内容为字符串
 *
 * @param filePath 文件路径
 * @param charset  字符集
 * @return 文件内容字符串
 * @throws IOException 读取文件时发生错误
 */

@Throws(IOException::class)
fun readFileToString(filePath: String, charset: Charset): String {
    val path = OsPath.of(filePath)
    val bytes = Files.readAllBytes(path)
    return String(bytes, charset)
}

/**
 * 将字符串写入文件
 *
 * @param filePath 文件路径
 * @param content  要写入的内容
 * @throws IOException 写入文件时发生错误
 */
@Throws(IOException::class)
fun writeStringToFile(filePath: String, content: String) {
    writeStringToFile(filePath, content, DEFAULT_CHARSET)
}

/**
 * 将字符串写入文件
 *
 * @param filePath 文件路径
 * @param content  要写入的内容
 * @param charset  字符集
 * @throws IOException 写入文件时发生错误
 */
@Throws(IOException::class)
fun writeStringToFile(filePath: String, content: String, charset: Charset) {
    val path = Paths.get(filePath)
    path.parent?.let { Files.createDirectories(it) }
    Files.write(path, content.toByteArray(charset))
}

/**
 * 读取文件内容为字符串列表（按行分割）
 *
 * @param filePath 文件路径
 * @return 文件内容按行分割的字符串列表
 * @throws IOException 读取文件时发生错误
 */
@Throws(IOException::class)
fun readLines(filePath: String): List<String> {
    return readLines(filePath, DEFAULT_CHARSET)
}

/**
 * 读取文件内容为字符串列表（按行分割）
 *
 * @param filePath 文件路径
 * @param charset  字符集
 * @return 文件内容按行分割的字符串列表
 * @throws IOException 读取文件时发生错误
 */
@Throws(IOException::class)
fun readLines(filePath: String, charset: Charset): List<String> {
    val path = Paths.get(filePath)
    return Files.readAllLines(path, charset)
}

/**
 * 将字符串列表写入文件（每行一个元素）
 *
 * @param filePath 文件路径
 * @param lines    要写入的行内容列表
 * @throws IOException 写入文件时发生错误
 */
@Throws(IOException::class)
fun writeLines(filePath: String, lines: List<String>) {
    writeLines(filePath, lines, DEFAULT_CHARSET)
}

/**
 * 将字符串列表写入文件（每行一个元素）
 *
 * @param filePath 文件路径
 * @param lines    要写入的行内容列表
 * @param charset  字符集
 * @throws IOException 写入文件时发生错误
 */
@Throws(IOException::class)
fun writeLines(filePath: String, lines: List<String>, charset: Charset) {
    val path = Paths.get(filePath)
    Files.createDirectories(path.parent)
    Files.write(path, lines, charset)
}

/**
 * 复制文件
 *
 * @param sourcePath 源文件路径
 * @param targetPath 目标文件路径
 * @throws IOException 复制文件时发生错误
 */
@Throws(IOException::class)
fun copyFile(sourcePath: String, targetPath: String) {
    val source = Paths.get(sourcePath)
    val target = Paths.get(targetPath)
    Files.createDirectories(target.parent)
    Files.copy(source, target)
}

/**
 * 删除文件
 *
 * @param filePath 文件路径
 * @return 如果文件删除成功返回true，否则返回false
 */
fun deleteFile(filePath: String): Boolean {
    return try {
        val path = Paths.get(filePath)
        Files.deleteIfExists(path)
    } catch (e: IOException) {
        false
    }
}

/**
 * 检查文件是否存在
 *
 * @param filePath 文件路径
 * @return 如果文件存在返回true，否则返回false
 */
fun exists(filePath: String): Boolean {
    val path = Paths.get(filePath)
    return Files.exists(path)
}

/**
 * 获取文件大小
 *
 * @param filePath 文件路径
 * @return 文件大小（字节），如果文件不存在返回-1
 */

fun getFileSize(filePath: String): Long {
    return try {
        val path = Paths.get(filePath)
        Files.size(path)
    } catch (e: IOException) {
        -1
    }
}

/**
 * 创建目录
 *
 * @param dirPath 目录路径
 * @return 如果目录创建成功返回true，否则返回false
 */

fun createDirectory(dirPath: String): Boolean {
    return try {
        val path = Paths.get(dirPath)
        Files.createDirectories(path)
        true
    } catch (e: IOException) {
        false
    }
}

/**
 * 获取文件扩展名
 *
 * @param fileName 文件名
 * @return 文件扩展名（不包含点号），如果无扩展名返回空字符串
 */

fun getFileExtension(fileName: String): String {
    if (fileName.isEmpty()) {
        return ""
    }
    val lastDotIndex = fileName!!.lastIndexOf('.')
    return if (lastDotIndex == -1 || lastDotIndex == fileName.length - 1) {
        ""
    } else fileName.substring(lastDotIndex + 1)
}

/**
 * 获取不带扩展名的文件名
 *
 * @param fileName 文件名
 * @return 不带扩展名的文件名
 */
fun getFileNameWithoutExtension(fileName: String): String {
    if (fileName.isEmpty()) {
        return ""
    }
    val lastDotIndex = fileName!!.lastIndexOf('.')
    return if (lastDotIndex == -1) {
        fileName
    } else fileName.substring(0, lastDotIndex)
}

/**
 * 读取文件内容为字节数组
 *
 * @param filePath 文件路径
 * @return 文件内容的字节数组
 * @throws IOException 读取文件时发生错误
 */
@Throws(IOException::class)
fun readFileToByteArray(filePath: String): ByteArray {
    val path = Paths.get(filePath)
    return Files.readAllBytes(path)
}

/**
 * 将字节数组写入文件
 *
 * @param filePath 文件路径
 * @param data     要写入的字节数据
 * @throws IOException 写入文件时发生错误
 */

@Throws(IOException::class)
fun writeByteArrayToFile(filePath: String, data: ByteArray) {
    val path = Paths.get(filePath)
    Files.createDirectories(path.parent)
    Files.write(path, data)
}

/**
 * 将字节数组追加到文件末尾
 *
 * @param filePath 文件路径
 * @param data     要追加的字节数据
 * @throws IOException 追加数据时发生错误
 */

@Throws(IOException::class)
fun appendByteArrayToFile(filePath: String, data: ByteArray) {
    val path = Paths.get(filePath)
    Files.createDirectories(path.parent)
    Files.write(
        path, data, StandardOpenOption.CREATE, StandardOpenOption.APPEND
    )
}

/**
 * 分块读取大文件为字节数组列表
 *
 * @param filePath  文件路径
 * @param chunkSize 每块大小（字节）
 * @return 文件内容按指定大小分割的字节数组列表
 * @throws IOException 读取文件时发生错误
 */

@Throws(IOException::class)
fun readFileToByteArrayChunks(filePath: String, chunkSize: Int): List<ByteArray> {
    val chunks = mutableListOf<ByteArray>()
    val path = Paths.get(filePath)

    Files.newInputStream(path).use { inputStream ->
        val buffer = ByteArray(chunkSize)
        var bytesRead: Int
        while (inputStream.read(buffer).also { bytesRead = it } != -1) {
            val chunk = ByteArray(bytesRead)
            System.arraycopy(buffer, 0, chunk, 0, bytesRead)
            chunks.add(chunk)
        }
    }

    return chunks
}

/**
 * 将字节数组列表写入文件
 *
 * @param filePath 文件路径
 * @param chunks   字节数组列表
 * @throws IOException 写入文件时发生错误
 */

@Throws(IOException::class)
fun writeByteArrayChunksToFile(filePath: String, chunks: List<ByteArray>) {
    val path = Paths.get(filePath)
    Files.createDirectories(path.parent)

    Files.newOutputStream(path).use { outputStream ->
        for (chunk in chunks) {
            outputStream.write(chunk)
        }
    }
}
