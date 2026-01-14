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
 * CurrentFile HashUtils.kt
 * LastUpdate 2026-01-11 09:09:52
 * UpdateUser MingLiPro
 */
@file:JvmName("HashUtils")

package com.mingliqiye.utils.hash


import com.mingliqiye.utils.bcrypt.checkpw
import com.mingliqiye.utils.bcrypt.hashpw
import com.mingliqiye.utils.bytes.bytesToHex
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * 计算指定文件的哈希值。
 *
 * @param file      要计算哈希值的文件对象
 * @param algorithm 使用的哈希算法名称（如 SHA-256、MD5 等）
 * @return 文件的十六进制格式哈希值字符串
 * @throws IOException              当文件不存在或读取过程中发生 I/O 错误时抛出
 * @throws NoSuchAlgorithmException 当指定的哈希算法不可用时抛出
 */
@Throws(IOException::class, NoSuchAlgorithmException::class)
fun calculateFileHash(file: File, algorithm: String): String {
    // 检查文件是否存在
    if (!file.exists()) {
        throw IOException("File not found: " + file.absolutePath)
    }

    val digest = MessageDigest.getInstance(algorithm)

    FileInputStream(file).use { fis ->
        val buffer = ByteArray(8192)
        var bytesRead: Int

        // 分块读取文件内容并更新摘要
        while (fis.read(buffer).also { bytesRead = it } != -1) {
            digest.update(buffer, 0, bytesRead)
        }
    }

    return bytesToHex(digest.digest())
}

/**
 * 使用 BCrypt 算法对字符串进行加密。
 *
 * @param string 需要加密的明文字符串
 * @return 加密后的 BCrypt 哈希字符串
 */
fun bcrypt(string: String): String {
    return hashpw(string)
}

/**
 * 验证给定字符串与 BCrypt 哈希是否匹配。
 *
 * @param string   明文字符串
 * @param bcrypted 已经使用 BCrypt 加密的哈希字符串
 * @return 如果匹配返回 true，否则返回 false
 */
fun checkBcrypt(string: String, bcrypted: String): Boolean {
    return checkpw(string, bcrypted)
}
