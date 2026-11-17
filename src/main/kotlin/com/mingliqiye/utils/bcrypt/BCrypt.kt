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
 * CurrentFile BCrypt.kt
 * LastUpdate 2025-09-19 20:17:41
 * UpdateUser MingLiPro
 */

@file:JvmName("BCrypt")

package com.mingliqiye.utils.bcrypt


import java.security.SecureRandom
import org.mindrot.jbcrypt.BCrypt as JBCrypt


/**
 * 使用随机生成的盐对字符串进行 BCrypt 哈希。
 *
 * @param string 需要哈希的明文字符串
 * @return BCrypt 哈希字符串
 */
fun hashpw(string: String): String {
	return hashpw(string, gensalt())
}


/**
 * 使用指定的盐对字符串进行 BCrypt 哈希。
 *
 * @param string 需要哈希的明文字符串
 * @param salt BCrypt 盐字符串，默认随机生成
 * @return BCrypt 哈希字符串
 */
fun hashpw(string: String, salt: String = gensalt()): String {
	return JBCrypt.hashpw(string, salt)
}


/**
 * 验证明文字符串与 BCrypt 哈希是否匹配。
 *
 * @param string 明文字符串
 * @param bcrypted 已生成的 BCrypt 哈希字符串
 * @return 匹配返回 true，否则返回 false
 */
fun checkpw(string: String, bcrypted: String): Boolean {
	return JBCrypt.checkpw(string, bcrypted)
}


/**
 * 生成默认工作因子（10）的 BCrypt 盐。
 *
 * @return BCrypt 盐字符串
 */
fun gensalt(): String {
	return JBCrypt.gensalt()
}


/**
 * 生成指定工作因子的 BCrypt 盐。
 *
 * @param long 工作因子（log2 迭代次数），值越大计算越慢
 * @return BCrypt 盐字符串
 */
fun gensalt(long: Int): String {
	return JBCrypt.gensalt(long)
}


/**
 * 使用指定的安全随机数生成器生成 BCrypt 盐。
 *
 * @param long 工作因子（log2 迭代次数）
 * @param secureRandom 用于生成盐的安全随机数生成器
 * @return BCrypt 盐字符串
 */
fun gensalt(long: Int, secureRandom: SecureRandom): String {
	return JBCrypt.gensalt(long, secureRandom)
}
