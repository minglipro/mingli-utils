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
 * CurrentFile FileUtils.kt
 * LastUpdate 2026-01-11 09:20:20
 * UpdateUser MingLiPro
 */
@file:JvmName("FileUtils")

package com.mingliqiye.utils.file

import com.mingliqiye.utils.path.OsPath
import java.io.File
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

/**
 * 默认字符集
 */
var DEFAULT_CHARSET: Charset = StandardCharsets.UTF_8

// 读取文件内容为字符串
@Throws(IOException::class)
        /**
         * 读取文件内容为字符串，使用默认字符集
         *
         * @return 文件内容的字符串表示
         * @throws IOException 读取文件时发生错误
         */
fun String.readFileToString(): String {
    return this.readFileToString(DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 读取文件内容为字符串
         *
         * @param charset 字符编码格式
         * @return 文件内容的字符串表示
         * @throws IOException 读取文件时发生错误
         */
fun String.readFileToString(charset: Charset): String {
    val path = OsPath.of(this)
    val bytes = Files.readAllBytes(path)
    return String(bytes, charset)
}

// 将字符串写入文件
@Throws(IOException::class)
        /**
         * 将字符串写入文件，使用默认字符集
         *
         * @param content 要写入的字符串内容
         * @throws IOException 写入文件时发生错误
         */
fun String.writeStringToFile(content: String) {
    this.writeStringToFile(content, DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 将字符串写入文件
         *
         * @param content 要写入的字符串内容
         * @param charset 字符编码格式
         * @throws IOException 写入文件时发生错误
         */
fun String.writeStringToFile(content: String, charset: Charset) {
    val path = Paths.get(this)
    path.parent?.let { Files.createDirectories(it) }
    Files.write(path, content.toByteArray(charset))
}

// 读取文件内容为字符串列表（按行分割）
@Throws(IOException::class)
        /**
         * 读取文件内容为字符串列表（按行分割），使用默认字符集
         *
         * @return 按行分割的字符串列表
         * @throws IOException 读取文件时发生错误
         */
fun String.readLines(): List<String> {
    return this.readLines(DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 读取文件内容为字符串列表（按行分割）
         *
         * @param charset 字符编码格式
         * @return 按行分割的字符串列表
         * @throws IOException 读取文件时发生错误
         */
fun String.readLines(charset: Charset): List<String> {
    val path = Paths.get(this)
    return Files.readAllLines(path, charset)
}

// 将字符串列表写入文件（每行一个元素）
@Throws(IOException::class)
        /**
         * 将字符串列表写入文件（每行一个元素），使用默认字符集
         *
         * @param lines 要写入的字符串列表
         * @throws IOException 写入文件时发生错误
         */
fun String.writeLines(lines: List<String>) {
    this.writeLines(lines, DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 将字符串列表写入文件（每行一个元素）
         *
         * @param lines 要写入的字符串列表
         * @param charset 字符编码格式
         * @throws IOException 写入文件时发生错误
         */
fun String.writeLines(lines: List<String>, charset: Charset) {
    val path = Paths.get(this)
    Files.createDirectories(path.parent)
    Files.write(path, lines, charset)
}

// 复制文件
@Throws(IOException::class)
        /**
         * 复制文件到目标路径
         *
         * @param targetPath 目标文件路径
         * @throws IOException 复制文件时发生错误
         */
fun String.copyFile(targetPath: String) {
    val source = Paths.get(this)
    val target = Paths.get(targetPath)
    Files.createDirectories(target.parent)
    Files.copy(source, target)
}

// 删除文件
/**
 * 删除文件
 *
 * @return 删除操作是否成功
 */
fun String.deleteFile(): Boolean {
    return try {
        val path = Paths.get(this)
        Files.deleteIfExists(path)
    } catch (e: IOException) {
        false
    }
}

// 检查文件是否存在
/**
 * 检查文件是否存在
 *
 * @return 文件是否存在
 */
fun String.exists(): Boolean {
    val path = Paths.get(this)
    return Files.exists(path)
}

// 获取文件大小
/**
 * 获取文件大小
 *
 * @return 文件大小（字节），如果获取失败则返回-1
 */
fun String.getFileSize(): Long {
    return try {
        val path = Paths.get(this)
        Files.size(path)
    } catch (e: IOException) {
        -1
    }
}

// 创建目录
/**
 * 创建目录
 *
 * @return 创建操作是否成功
 */
fun String.createDirectory(): Boolean {
    return try {
        val path = Paths.get(this)
        Files.createDirectories(path)
        true
    } catch (e: IOException) {
        false
    }
}

// 读取文件内容为字节数组
@Throws(IOException::class)
        /**
         * 读取文件内容为字节数组
         *
         * @return 文件内容的字节数组表示
         * @throws IOException 读取文件时发生错误
         */
fun String.readByteArray(): ByteArray {
    val path = Paths.get(this)
    return Files.readAllBytes(path)
}

// 将字节数组写入文件
@Throws(IOException::class)
        /**
         * 将字节数组写入文件
         *
         * @param data 要写入的字节数组
         * @throws IOException 写入文件时发生错误
         */
fun String.writeByteArray(data: ByteArray) {
    val path = Paths.get(this)
    Files.createDirectories(path.parent)
    Files.write(path, data)
}

// 将字节数组追加到文件末尾
@Throws(IOException::class)
        /**
         * 将字节数组追加到文件末尾
         *
         * @param data 要追加的字节数组
         * @throws IOException 追加文件时发生错误
         */
fun String.appendByteArray(data: ByteArray) {
    val path = Paths.get(this)
    Files.createDirectories(path.parent)
    Files.write(
        path, data, StandardOpenOption.CREATE, StandardOpenOption.APPEND
    )
}

// 分块读取大文件为字节数组列表
@Throws(IOException::class)
        /**
         * 分块读取大文件为字节数组列表
         *
         * @param chunkSize 每个块的大小
         * @return 字节数组列表
         * @throws IOException 读取文件时发生错误
         */
fun String.readByteArrayChunks(chunkSize: Int): List<ByteArray> {
    val chunks = mutableListOf<ByteArray>()
    val path = Paths.get(this)

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

// 将字节数组列表写入文件
@Throws(IOException::class)
        /**
         * 将字节数组列表写入文件
         *
         * @param chunks 字节数组列表
         * @throws IOException 写入文件时发生错误
         */
fun String.writeByteArrayChunks(chunks: List<ByteArray>) {
    val path = Paths.get(this)
    Files.createDirectories(path.parent)

    Files.newOutputStream(path).use { outputStream ->
        for (chunk in chunks) {
            outputStream.write(chunk)
        }
    }
}

// 读取文件内容为字符串
@Throws(IOException::class)
        /**
         * 读取文件内容为字符串，使用默认字符集
         *
         * @return 文件内容的字符串表示
         * @throws IOException 读取文件时发生错误
         */
fun Path.readFileToString(): String {
    return this.readFileToString(DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 读取文件内容为字符串
         *
         * @param charset 字符编码格式
         * @return 文件内容的字符串表示
         * @throws IOException 读取文件时发生错误
         */
fun Path.readFileToString(charset: Charset): String {
    val bytes = Files.readAllBytes(this)
    return String(bytes, charset)
}

// 将字符串写入文件
@Throws(IOException::class)
        /**
         * 将字符串写入文件，使用默认字符集
         *
         * @param content 要写入的字符串内容
         * @throws IOException 写入文件时发生错误
         */
fun Path.writeStringToFile(content: String) {
    this.writeStringToFile(content, DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 将字符串写入文件
         *
         * @param content 要写入的字符串内容
         * @param charset 字符编码格式
         * @throws IOException 写入文件时发生错误
         */
fun Path.writeStringToFile(content: String, charset: Charset) {
    this.parent?.let { Files.createDirectories(it) }
    Files.write(this, content.toByteArray(charset))
}

// 读取文件内容为字符串列表
@Throws(IOException::class)
        /**
         * 读取文件内容为字符串列表，使用默认字符集
         *
         * @return 按行分割的字符串列表
         * @throws IOException 读取文件时发生错误
         */
fun Path.readLines(): List<String> {
    return this.readLines(DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 读取文件内容为字符串列表
         *
         * @param charset 字符编码格式
         * @return 按行分割的字符串列表
         * @throws IOException 读取文件时发生错误
         */
fun Path.readLines(charset: Charset): List<String> {
    return Files.readAllLines(this, charset)
}

// 将字符串列表写入文件
@Throws(IOException::class)
        /**
         * 将字符串列表写入文件，使用默认字符集
         *
         * @param lines 要写入的字符串列表
         * @throws IOException 写入文件时发生错误
         */
fun Path.writeLines(lines: List<String>) {
    this.writeLines(lines, DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 将字符串列表写入文件
         *
         * @param lines 要写入的字符串列表
         * @param charset 字符编码格式
         * @throws IOException 写入文件时发生错误
         */
fun Path.writeLines(lines: List<String>, charset: Charset) {
    Files.createDirectories(this.parent)
    Files.write(this, lines, charset)
}

// 复制文件
@Throws(IOException::class)
        /**
         * 复制文件到目标路径
         *
         * @param target 目标文件路径
         * @throws IOException 复制文件时发生错误
         */
fun Path.copyTo(target: Path) {
    Files.createDirectories(target.parent)
    Files.copy(this, target)
}

// 删除文件
/**
 * 删除文件
 *
 * @return 删除操作是否成功
 */
fun Path.delete(): Boolean {
    return try {
        Files.deleteIfExists(this)
    } catch (e: IOException) {
        false
    }
}

// 检查文件是否存在
/**
 * 检查文件是否存在
 *
 * @return 文件是否存在
 */
fun Path.exists(): Boolean {
    return Files.exists(this)
}

// 获取文件大小
/**
 * 获取文件大小
 *
 * @return 文件大小（字节），如果获取失败则返回-1
 */
fun Path.getFileSize(): Long {
    return try {
        Files.size(this)
    } catch (e: IOException) {
        -1
    }
}

// 读取文件内容为字节数组
@Throws(IOException::class)
        /**
         * 读取文件内容为字节数组
         *
         * @return 文件内容的字节数组表示
         * @throws IOException 读取文件时发生错误
         */
fun Path.readByteArray(): ByteArray {
    return Files.readAllBytes(this)
}

// 将字节数组写入文件
@Throws(IOException::class)
        /**
         * 将字节数组写入文件
         *
         * @param data 要写入的字节数组
         * @throws IOException 写入文件时发生错误
         */
fun Path.writeByteArray(data: ByteArray) {
    Files.createDirectories(this.parent)
    Files.write(this, data)
}

// 将字节数组追加到文件末尾
@Throws(IOException::class)
        /**
         * 将字节数组追加到文件末尾
         *
         * @param data 要追加的字节数组
         * @throws IOException 追加文件时发生错误
         */
fun Path.appendByteArray(data: ByteArray) {
    Files.createDirectories(this.parent)
    Files.write(this, data, StandardOpenOption.CREATE, StandardOpenOption.APPEND)
}

// 分块读取大文件为字节数组列表
@Throws(IOException::class)
        /**
         * 分块读取大文件为字节数组列表
         *
         * @param chunkSize 每个块的大小
         * @return 字节数组列表
         * @throws IOException 读取文件时发生错误
         */
fun Path.readByteArrayChunks(chunkSize: Int): List<ByteArray> {
    val chunks = mutableListOf<ByteArray>()

    Files.newInputStream(this).use { inputStream ->
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

// 将字节数组列表写入文件
@Throws(IOException::class)
        /**
         * 将字节数组列表写入文件
         *
         * @param chunks 字节数组列表
         * @throws IOException 写入文件时发生错误
         */
fun Path.writeByteArrayChunks(chunks: List<ByteArray>) {
    Files.createDirectories(this.parent)

    Files.newOutputStream(this).use { outputStream ->
        for (chunk in chunks) {
            outputStream.write(chunk)
        }
    }
}

// 读取文件内容为字符串
@Throws(IOException::class)
        /**
         * 读取文件内容为字符串，使用默认字符集
         *
         * @return 文件内容的字符串表示
         * @throws IOException 读取文件时发生错误
         */
fun File.readFileToString(): String {
    return this.readFileToString(DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 读取文件内容为字符串
         *
         * @param charset 字符编码格式
         * @return 文件内容的字符串表示
         * @throws IOException 读取文件时发生错误
         */
fun File.readFileToString(charset: Charset): String {
    return String(this.readBytes(), charset)
}

// 将字符串写入文件
@Throws(IOException::class)
        /**
         * 将字符串写入文件，使用默认字符集
         *
         * @param content 要写入的字符串内容
         * @throws IOException 写入文件时发生错误
         */
fun File.writeStringToFile(content: String) {
    this.writeStringToFile(content, DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 将字符串写入文件
         *
         * @param content 要写入的字符串内容
         * @param charset 字符编码格式
         * @throws IOException 写入文件时发生错误
         */
fun File.writeStringToFile(content: String, charset: Charset) {
    this.parentFile?.mkdirs()
    this.writeText(content, charset)
}

// 读取文件内容为字符串列表
@Throws(IOException::class)
        /**
         * 读取文件内容为字符串列表，使用默认字符集
         *
         * @return 按行分割的字符串列表
         * @throws IOException 读取文件时发生错误
         */
fun File.readLines(): List<String> {
    return this.readLines(DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 读取文件内容为字符串列表
         *
         * @param charset 字符编码格式
         * @return 按行分割的字符串列表
         * @throws IOException 读取文件时发生错误
         */
fun File.readLines(charset: Charset): List<String> {
    return this.readLines(charset)
}

// 将字符串列表写入文件
@Throws(IOException::class)
        /**
         * 将字符串列表写入文件，使用默认字符集
         *
         * @param lines 要写入的字符串列表
         * @throws IOException 写入文件时发生错误
         */
fun File.writeLines(lines: List<String>) {
    this.writeLines(lines, DEFAULT_CHARSET)
}

@Throws(IOException::class)
        /**
         * 将字符串列表写入文件
         *
         * @param lines 要写入的字符串列表
         * @param charset 字符编码格式
         * @throws IOException 写入文件时发生错误
         */
fun File.writeLines(lines: List<String>, charset: Charset) {
    this.parentFile?.mkdirs()
    this.writeLines(lines, charset)
}

// 复制文件
@Throws(IOException::class)
        /**
         * 复制文件到目标文件
         *
         * @param target 目标文件
         * @throws IOException 复制文件时发生错误
         */
fun File.copyTo(target: File) {
    target.parentFile?.mkdirs()
    this.copyTo(target, overwrite = true)
}

// 删除文件
/**
 * 删除文件
 *
 * @return 删除操作是否成功
 */
fun File.delete(): Boolean {
    return this.delete()
}

// 检查文件是否存在
/**
 * 检查文件是否存在
 *
 * @return 文件是否存在
 */
fun File.exists(): Boolean {
    return this.exists()
}

// 获取文件大小
/**
 * 获取文件大小
 *
 * @return 文件大小（字节），如果文件不存在则返回-1L
 */
fun File.getFileSize(): Long {
    return if (this.exists()) this.length() else -1L
}

// 创建目录
/**
 * 创建目录
 *
 * @return 创建操作是否成功
 */
fun File.createDirectory(): Boolean {
    return this.mkdirs()
}

// 读取文件内容为字节数组
@Throws(IOException::class)
        /**
         * 读取文件内容为字节数组
         *
         * @return 文件内容的字节数组表示
         * @throws IOException 读取文件时发生错误
         */
fun File.readByteArray(): ByteArray {
    return this.readBytes()
}

// 将字节数组写入文件
@Throws(IOException::class)
        /**
         * 将字节数组写入文件
         *
         * @param data 要写入的字节数组
         * @throws IOException 写入文件时发生错误
         */
fun File.writeByteArray(data: ByteArray) {
    this.parentFile?.mkdirs()
    this.writeBytes(data)
}

// 将字节数组追加到文件末尾
@Throws(IOException::class)
        /**
         * 将字节数组追加到文件末尾
         *
         * @param data 要追加的字节数组
         * @throws IOException 追加文件时发生错误
         */
fun File.appendByteArray(data: ByteArray) {
    this.parentFile?.mkdirs()
    this.appendBytes(data)
}

// 分块读取大文件为字节数组列表
@Throws(IOException::class)
        /**
         * 分块读取大文件为字节数组列表
         *
         * @param chunkSize 每个块的大小
         * @return 字节数组列表
         * @throws IOException 读取文件时发生错误
         */
fun File.readByteArrayChunks(chunkSize: Int): List<ByteArray> {
    val chunks = mutableListOf<ByteArray>()

    this.inputStream().use { inputStream ->
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

// 将字节数组列表写入文件
@Throws(IOException::class)
        /**
         * 将字节数组列表写入文件
         *
         * @param chunks 字节数组列表
         * @throws IOException 写入文件时发生错误
         */
fun File.writeByteArrayChunks(chunks: List<ByteArray>) {
    this.parentFile?.mkdirs()

    this.outputStream().use { outputStream ->
        for (chunk in chunks) {
            outputStream.write(chunk)
        }
    }
}
