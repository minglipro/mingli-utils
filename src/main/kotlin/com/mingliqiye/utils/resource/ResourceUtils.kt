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
 * LastUpdate 2026-05-23 10:28:28
 * UpdateUser MingLiPro
 */
package com.mingliqiye.utils.resource

import com.mingliqiye.utils.exception.NotFoundResourceException
import java.nio.charset.Charset

/**
 * 类路径资源读取工具对象，提供按相对路径或绝对路径读取资源文件为字节数组或字符串的方法。
 */
object ResourceUtils {


	/**
	 * 从类路径中读取资源文件并返回字节数组（使用 reified 类型参数）
	 *
	 * 这是一个内联扩展函数，利用 reified 关键字在编译时获取具体类型 T 的 Class 对象
	 *
	 * @param T 用于获取 ClassLoader 的类型参数（通常传入调用方的类）
	 * @param path 资源文件的路径（相对于 T 所在的包，或以 / 开头的绝对路径）
	 * @return 资源的字节数组
	 * @throws NotFoundResourceException 当资源不存在时抛出
	 *
	 * 使用示例：
	 * ```kotlin
	 * // 在当前类的包下查找 config.json
	 * val data = getResourceAsByteArray<MyClass>("config.json")
	 *
	 * // 使用绝对路径（从 classpath 根目录）
	 * val data = getResourceAsByteArray<MyClass>("/assets/config.json")
	 * ```
	 */
	inline fun <reified T> getResourceAsByteArray(path: String): ByteArray {
		// 将 reified T 的 KClass 转换为 Java 的 Class 对象，传递给重载方法
		return getResourceAsByteArray(path, T::class.java)
	}

	/**
	 * 从类路径中读取资源文件并返回字符串（使用 reified 类型参数）
	 *
	 * @param T 用于获取 ClassLoader 的类型参数
	 * @param resource 资源文件路径
	 * @param charset 字符编码，默认为系统默认字符集
	 * @return 资源文件的字符串内容
	 * @throws NotFoundResourceException 当资源不存在时抛出
	 *
	 * 使用示例：
	 * ```kotlin
	 * // 读取文本文件，使用默认编码
	 * val content = getResourceAsString<MyClass>("data.txt")
	 *
	 * // 指定 UTF-8 编码
	 * val content = getResourceAsString<MyClass>("data.txt", Charsets.UTF_8)
	 * ```
	 */
	inline fun <reified T> getResourceAsString(
		resource: String,
		charset: Charset = Charset.defaultCharset(),
	): String {
		// 将 reified T 的 Class 对象传递给重载方法
		return getResourceAsString(resource, charset, T::class.java)
	}

	/**
	 * 从类路径中读取资源文件并返回字符串（Java 友好重载版本）
	 *
	 * 此方法标记为 @JvmStatic，使其可以在 Java 代码中以静态方法形式调用
	 *
	 * @param path 资源文件路径
	 * @param charset 字符编码
	 * @param clazz 用于获取 ClassLoader 的参考类
	 * @return 资源文件的字符串内容
	 * @throws NotFoundResourceException 当资源不存在时抛出
	 *
	 * Java 调用示例：
	 * ```java
	 * // 在 Java 中调用
	 * String content = YourClass.getResourceAsString("config.json", StandardCharsets.UTF_8, MyClass.class);
	 * ```
	 */
	@JvmStatic
	fun getResourceAsString(path: String, charset: Charset, clazz: Class<*>): String {
		// 先读取为字节数组，再按指定字符集解码为字符串
		return String(getResourceAsByteArray(path, clazz), charset)
	}

	/**
	 * 从类路径中读取资源文件并返回字符串（使用默认字符集，Java 友好重载）
	 *
	 * @param path 资源文件路径
	 * @param clazz 用于获取 ClassLoader 的参考类
	 * @return 资源文件的字符串内容
	 * @throws NotFoundResourceException 当资源不存在时抛出
	 */
	@JvmStatic
	fun getResourceAsString(path: String, clazz: Class<*>): String {
		// 委托给上面的方法，使用系统默认字符集
		return getResourceAsString(path, Charset.defaultCharset(), clazz)
	}

	/**
	 * 从类路径中读取资源文件并返回字节数组（核心实现方法）
	 *
	 * 这是所有方法的核心实现，负责实际的资源查找和读取工作
	 *
	 * @param path 资源文件路径
	 *   - 如果以 "/" 开头：表示从 classpath 根目录查找
	 *   - 如果不以 "/" 开头：表示相对于 clazz 所在包的路径
	 * @param clazz 参考类，用于确定相对路径的基准包
	 * @return 资源的完整字节数组（使用 readAllBytes() 一次性读取）
	 * @throws NotFoundResourceException 当资源文件不存在时抛出，错误信息会显示完整的查找路径
	 *
	 * 资源查找规则说明：
	 * 1. 如果 path = "config.properties" 且 clazz = com.example.MyClass
	 *    实际查找路径：/com/example/config.properties
	 *
	 * 2. 如果 path = "/config.properties"
	 *    实际查找路径：/config.properties（classpath 根目录）
	 *
	 * 异常消息示例：
	 * - 找不到文件时抛出："/com/example/config.properties is not found"
	 */
	@JvmStatic
	fun getResourceAsByteArray(path: String, clazz: Class<*>): ByteArray {
		// 尝试从类路径中获取资源的输入流
		val stream = clazz.getResourceAsStream(path)
			?: throw NotFoundResourceException(
				// 构建详细的错误信息：显示实际查找的完整路径
				// 如果 path 不以 "/" 开头，则拼接类的包路径（将包名中的点替换为斜杠）
				(if (!path.startsWith("/"))
					"/${clazz.packageName.replace(".", "/")}/$path"  // 相对路径：相对于 clazz 的包
				else
					path  // 绝对路径：直接使用原路径
						) + " is not found"  // 添加 " is not found" 后缀
			)

		// 读取输入流中的所有字节并返回
		// Kotlin 的扩展函数，等同于 Java 9+ 的 InputStream.readAllBytes()
		return stream.readAllBytes()
	}
}
