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
 * CurrentFile ResourceUtils.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */
package com.mingliqiye.utils.resource

import com.mingliqiye.utils.exception.NotFoundResourceException
import java.io.InputStream
import java.net.URL
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

/**
 * 类路径资源读取工具。
 *
 * 提供最常用的资源读取能力：
 * - 读取为字节数组；
 * - 按指定字符集读取为字符串；
 * - 按行读取；
 * - 获取资源 URL / 判断资源是否存在；
 * - 获取资源输入流（由调用方负责关闭）。
 *
 * ### 路径规则
 * 与 [Class.getResource] / [Class.getResourceAsStream] 一致：
 * - 以 `/` 开头：从 classpath 根目录查找，例如 `/assets/config.json`；
 * - 不以 `/` 开头：相对于参考类所在包查找，例如参考类为 `com.example.MyClass` 时，
 *   `config.json` 会查找 `/com/example/config.json`。
 *
 * ### 默认字符集
 * 字符串读取默认使用 [DEFAULT_CHARSET]（UTF-8），不再依赖平台默认编码。
 *
 * @see NotFoundResourceException
 */
object ResourceUtils {

	/**
	 * 读取字符串时使用的默认字符集：UTF-8。
	 */
	@JvmField
	val DEFAULT_CHARSET: Charset = StandardCharsets.UTF_8

	/**
	 * 使用 reified 类型参数读取资源字节数组。
	 *
	 * @param T 用于获取 [ClassLoader] 和相对路径基准包的类型
	 * @param path 资源路径
	 * @return 资源字节数组
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	inline fun <reified T> getResourceAsByteArray(path: String): ByteArray {
		return getResourceAsByteArray(path, T::class.java)
	}

	/**
	 * 读取资源字节数组。
	 *
	 * 输入流会在方法内部关闭。
	 *
	 * @param path 资源路径
	 * @param clazz 参考类，用于定位相对路径和 ClassLoader
	 * @return 资源字节数组
	 * @throws IllegalArgumentException 路径为空时抛出
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsByteArray(path: String, clazz: Class<*>): ByteArray {
		return getResourceAsStream(path, clazz).use { it.readBytes() }
	}

	/**
	 * 使用指定 [ClassLoader] 读取资源字节数组。
	 *
	 * 资源路径会去掉开头的 `/`，按 ClassLoader 根路径查找。
	 *
	 * @param path 资源路径
	 * @param classLoader 用于查找资源的 ClassLoader
	 * @return 资源字节数组
	 * @throws IllegalArgumentException 路径为空时抛出
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsByteArray(path: String, classLoader: ClassLoader): ByteArray {
		return getResourceAsStream(path, classLoader).use { it.readBytes() }
	}

	/**
	 * 使用 reified 类型参数读取资源字符串，默认 UTF-8。
	 *
	 * @param T 用于获取 ClassLoader 的类型
	 * @param path 资源路径
	 * @param charset 字符集，默认 [DEFAULT_CHARSET]
	 * @return 资源字符串
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	inline fun <reified T> getResourceAsString(
		path: String,
		charset: Charset = DEFAULT_CHARSET,
	): String {
		return getResourceAsString(path, charset, T::class.java)
	}

	/**
	 * 读取资源字符串。
	 *
	 * @param path 资源路径
	 * @param charset 字符集
	 * @param clazz 参考类
	 * @return 资源字符串
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsString(path: String, charset: Charset, clazz: Class<*>): String {
		return String(getResourceAsByteArray(path, clazz), charset)
	}

	/**
	 * 读取资源字符串，使用默认 UTF-8 字符集。
	 *
	 * @param path 资源路径
	 * @param clazz 参考类
	 * @return 资源字符串
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsString(path: String, clazz: Class<*>): String {
		return getResourceAsString(path, DEFAULT_CHARSET, clazz)
	}

	/**
	 * 使用指定 [ClassLoader] 读取资源字符串。
	 *
	 * @param path 资源路径
	 * @param charset 字符集
	 * @param classLoader 资源 ClassLoader
	 * @return 资源字符串
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsString(path: String, charset: Charset, classLoader: ClassLoader): String {
		return String(getResourceAsByteArray(path, classLoader), charset)
	}

	/**
	 * 使用指定 [ClassLoader] 读取资源字符串，默认 UTF-8。
	 *
	 * @param path 资源路径
	 * @param classLoader 资源 ClassLoader
	 * @return 资源字符串
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsString(path: String, classLoader: ClassLoader): String {
		return getResourceAsString(path, DEFAULT_CHARSET, classLoader)
	}

	/**
	 * 使用 reified 类型参数按行读取资源。
	 *
	 * @param T 用于获取 ClassLoader 的类型
	 * @param path 资源路径
	 * @param charset 字符集，默认 [DEFAULT_CHARSET]
	 * @return 行列表，不包含行尾换行符
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	inline fun <reified T> getResourceAsLines(
		path: String,
		charset: Charset = DEFAULT_CHARSET,
	): List<String> {
		return getResourceAsLines(path, charset, T::class.java)
	}

	/**
	 * 按行读取资源。
	 *
	 * @param path 资源路径
	 * @param charset 字符集
	 * @param clazz 参考类
	 * @return 行列表，不包含行尾换行符
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsLines(path: String, charset: Charset, clazz: Class<*>): List<String> {
		return getResourceAsStream(path, clazz).bufferedReader(charset).use { it.readLines() }
	}

	/**
	 * 使用指定 [ClassLoader] 按行读取资源。
	 *
	 * @param path 资源路径
	 * @param charset 字符集
	 * @param classLoader 资源 ClassLoader
	 * @return 行列表，不包含行尾换行符
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsLines(path: String, charset: Charset, classLoader: ClassLoader): List<String> {
		return getResourceAsStream(path, classLoader).bufferedReader(charset).use { it.readLines() }
	}

	/**
	 * 使用指定 [ClassLoader] 按行读取资源，默认 UTF-8。
	 *
	 * @param path 资源路径
	 * @param classLoader 资源 ClassLoader
	 * @return 行列表，不包含行尾换行符
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsLines(path: String, classLoader: ClassLoader): List<String> {
		return getResourceAsLines(path, DEFAULT_CHARSET, classLoader)
	}

	/**
	 * 使用 reified 类型参数获取资源 URL。
	 *
	 * @param T 用于获取 ClassLoader 的类型
	 * @param path 资源路径
	 * @return 资源 URL；不存在时返回 `null`
	 */
	inline fun <reified T> getResourceAsUrl(path: String): URL? {
		return getResourceAsUrl(path, T::class.java)
	}

	/**
	 * 获取资源 URL。
	 *
	 * @param path 资源路径
	 * @param clazz 参考类
	 * @return 资源 URL；不存在时返回 `null`
	 * @throws IllegalArgumentException 路径为空时抛出
	 */
	@JvmStatic
	fun getResourceAsUrl(path: String, clazz: Class<*>): URL? {
		requirePath(path)
		return clazz.getResource(path)
	}

	/**
	 * 使用指定 [ClassLoader] 获取资源 URL。
	 *
	 * @param path 资源路径
	 * @param classLoader 资源 ClassLoader
	 * @return 资源 URL；不存在时返回 `null`
	 * @throws IllegalArgumentException 路径为空时抛出
	 */
	@JvmStatic
	fun getResourceAsUrl(path: String, classLoader: ClassLoader): URL? {
		requirePath(path)
		return classLoader.getResource(path.removePrefix("/"))
	}

	/**
	 * 使用 reified 类型参数判断资源是否存在。
	 *
	 * @param T 用于获取 ClassLoader 的类型
	 * @param path 资源路径
	 * @return 存在返回 `true`
	 */
	inline fun <reified T> existsResource(path: String): Boolean {
		return existsResource(path, T::class.java)
	}

	/**
	 * 判断资源是否存在。
	 *
	 * @param path 资源路径
	 * @param clazz 参考类
	 * @return 存在返回 `true`
	 */
	@JvmStatic
	fun existsResource(path: String, clazz: Class<*>): Boolean {
		return getResourceAsUrl(path, clazz) != null
	}

	/**
	 * 判断资源是否存在。
	 *
	 * @param path 资源路径
	 * @param classLoader 资源 ClassLoader
	 * @return 存在返回 `true`
	 */
	@JvmStatic
	fun existsResource(path: String, classLoader: ClassLoader): Boolean {
		return getResourceAsUrl(path, classLoader) != null
	}

	/**
	 * 使用 reified 类型参数获取资源输入流。
	 *
	 * @param T 用于获取 ClassLoader 的类型
	 * @param path 资源路径
	 * @return 资源输入流，调用方负责关闭
	 */
	inline fun <reified T> getResourceAsStream(path: String): InputStream {
		return getResourceAsStream(path, T::class.java)
	}

	/**
	 * 获取资源输入流。
	 *
	 * 调用方负责关闭返回的流；如果只是读取全部内容，优先使用
	 * [getResourceAsByteArray] 或 [getResourceAsString]。
	 *
	 * @param path 资源路径
	 * @param clazz 参考类
	 * @return 资源输入流
	 * @throws IllegalArgumentException 路径为空时抛出
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsStream(path: String, clazz: Class<*>): InputStream {
		requirePath(path)
		return clazz.getResourceAsStream(path)
			?: throw NotFoundResourceException("${resolveResourcePath(path, clazz)} is not found")
	}

	/**
	 * 使用指定 [ClassLoader] 获取资源输入流。
	 *
	 * 调用方负责关闭返回的流。
	 *
	 * @param path 资源路径
	 * @param classLoader 资源 ClassLoader
	 * @return 资源输入流
	 * @throws IllegalArgumentException 路径为空时抛出
	 * @throws NotFoundResourceException 资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsStream(path: String, classLoader: ClassLoader): InputStream {
		requirePath(path)
		val normalized = path.removePrefix("/")
		return classLoader.getResourceAsStream(normalized)
			?: throw NotFoundResourceException("/$normalized is not found")
	}

	/**
	 * 将资源路径解析为 classpath 根路径，用于错误信息和调试。
	 *
	 * - 以 `/` 开头时原样返回；
	 * - 相对路径会拼接参考类的包路径。
	 *
	 * @param path 资源路径
	 * @param clazz 参考类
	 * @return 绝对 classpath 路径
	 */
	@JvmStatic
	fun resolveResourcePath(path: String, clazz: Class<*>): String {
		if (path.startsWith("/")) {
			return path
		}
		val packagePath = clazz.packageName.replace('.', '/')
		return if (packagePath.isEmpty()) "/$path" else "/$packagePath/$path"
	}

	/**
	 * 校验资源路径非空。
	 *
	 * @param path 资源路径
	 */
	private fun requirePath(path: String) {
		require(path.isNotBlank()) { "resource path must not be blank" }
	}
}
