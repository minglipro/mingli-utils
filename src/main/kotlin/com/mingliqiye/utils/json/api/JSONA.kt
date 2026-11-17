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
 * CurrentFile JSONA.kt
 * LastUpdate 2026-11-17 19:59:21
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.mingliqiye.utils.json.api.JSONA.jsonApi
import com.mingliqiye.utils.json.api.JSONA.setJsonApi
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.api.type.listType
import com.mingliqiye.utils.json.objects.base.JsonItem
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.nio.file.Path
import kotlin.io.path.readBytes

/**
 * JSON 工具门面，提供静态方法访问 JSON API 功能。
 *
 * [JSONA] 本身不实现 JSON 逻辑，而是持有一个可替换的 [JsonApi] 实例，
 * 所有方法都转发到当前实例。使用前必须先通过 [setJsonApi] 注入实现，
 * 未注入时访问 [jsonApi] 或调用任何转发方法都会抛出 [NullPointerException]。
 *
 * @see JsonApi
 * @see setJsonApi
 */
object JSONA {

	/**
	 * 当前 JSON API 实例，未注入时为 `null`。
	 *
	 * 使用 `@Volatile` 保证多线程下的可见性；仅在启动时注入一次的场景下无副作用。
	 */
	@Volatile
	@JvmStatic
	private var privateJsonApi: JsonApi? = null

	/**
	 * 获取当前 JSON API 实例。
	 *
	 * @return 已注入的 [JsonApi] 实例
	 * @throws NullPointerException 尚未调用 [setJsonApi] 时抛出
	 */
	@JvmStatic
	val jsonApi: JsonApi
		get() = privateJsonApi ?: throw NullPointerException("jsonApi is null plase setJsonApi first")

	/**
	 * 设置或替换 JSON API 实例。
	 *
	 * 设置后，[JSONA] 上所有转发方法立即使用新实例。
	 *
	 * @param jsa JSON API 实例
	 */
	@JvmStatic
	fun setJsonApi(jsa: JsonApi) {
		privateJsonApi = jsa
	}

	/**
	 * 通过反射创建 [T] 的无参实例并设置为当前 JSON API。
	 *
	 * @param T 继承自 [JsonApi] 的具体实现类，必须提供公开无参构造
	 * @throws NoSuchMethodException 实现类没有无参构造时抛出
	 * @throws ReflectiveOperationException 反射实例化失败时抛出
	 */
	inline fun <reified T : JsonApi> setJsonApi() {
		setJsonApi(T::class.java.getConstructor().newInstance() as JsonApi)
	}

	/**
	 * 将 JSON 字符串解析为指定类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param json 待解析的 JSON 字符串
	 * @param clazz 目标对象的 [Class] 类型
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parse(json: String, clazz: Class<T>): T = jsonApi.parse(json, clazz)

	/**
	 * 将 JSON 字符串解析为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型，由调用方通过 reified 推断
	 * @param json 待解析的 JSON 字符串
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	inline fun <reified T> parse(json: String): T {
		return jsonApi.parse(json, (object : JsonTypeReference<T>() {}))
	}

	/**
	 * 将字节数组形式的 JSON 解析为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型，由调用方通过 reified 推断
	 * @param json 待解析的 JSON 字节数组
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	inline fun <reified T> parse(json: ByteArray): T = jsonApi.parse(json, object : JsonTypeReference<T>() {})

	/**
	 * 将 JSON 字符串解析为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param json 待解析的 JSON 字符串
	 * @param type 目标对象的 [JsonTypeReference] 类型引用（支持泛型）
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parse(json: String, type: JsonTypeReference<T>): T = jsonApi.parse(json, type)

	/**
	 * 将对象格式化为 JSON 字符串。
	 *
	 * @param obj 待格式化的对象
	 * @return 格式化后的 JSON 字符串
	 */
	@JvmStatic
	fun format(obj: Any): String = jsonApi.format(obj)

	/**
	 * 从文件路径解析 JSON 为指定类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param path 文件路径
	 * @param clazz 目标对象的 [Class] 类型
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parseFrom(path: String, clazz: Class<T>): T = jsonApi.parseFrom(path, clazz)

	/**
	 * 从 [Path] 对象解析 JSON 为指定类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param path [Path] 对象
	 * @param clazz 目标对象的 [Class] 类型
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parseFrom(path: Path, clazz: Class<T>): T = jsonApi.parseFrom(path, clazz)

	/**
	 * 从 [File] 对象解析 JSON 为指定类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param file [File] 对象
	 * @param clazz 目标对象的 [Class] 类型
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parseFrom(file: File, clazz: Class<T>): T = jsonApi.parseFrom(file, clazz)

	/**
	 * 从 [InputStream] 解析 JSON 为指定类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param inputStream [InputStream] 对象
	 * @param clazz 目标对象的 [Class] 类型
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parseFrom(inputStream: InputStream, clazz: Class<T>): T = jsonApi.parseFrom(inputStream, clazz)

	/**
	 * 从文件路径解析 JSON 为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param path 文件路径
	 * @param type 目标对象的 [JsonTypeReference] 类型引用（支持泛型）
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parseFrom(path: String, type: JsonTypeReference<T>): T = jsonApi.parseFrom(path, type)

	/**
	 * 从 [Path] 对象解析 JSON 为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param path [Path] 对象
	 * @param type 目标对象的 [JsonTypeReference] 类型引用（支持泛型）
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parseFrom(path: Path, type: JsonTypeReference<T>): T = jsonApi.parseFrom(path, type)

	/**
	 * 从 [File] 对象解析 JSON 为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param file [File] 对象
	 * @param type 目标对象的 [JsonTypeReference] 类型引用（支持泛型）
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parseFrom(file: File, type: JsonTypeReference<T>): T = jsonApi.parseFrom(file, type)

	/**
	 * 从 [InputStream] 解析 JSON 为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param inputStream [InputStream] 对象
	 * @param type 目标对象的 [JsonTypeReference] 类型引用（支持泛型）
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parseFrom(inputStream: InputStream, type: JsonTypeReference<T>): T =
		jsonApi.parseFrom(inputStream, type)

	/**
	 * 将字节数组形式的 JSON 解析为指定类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param json 待解析的 JSON 字节数组
	 * @param clazz 目标对象的 [Class] 类型
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parse(json: ByteArray, clazz: Class<T>): T = jsonApi.parse(json, clazz)

	/**
	 * 将字节数组形式的 JSON 解析为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型
	 * @param json 待解析的 JSON 字节数组
	 * @param type 目标对象的 [JsonTypeReference] 类型引用（支持泛型）
	 * @return 解析后的对象实例
	 */
	@JvmStatic
	fun <T> parse(json: ByteArray, type: JsonTypeReference<T>): T = jsonApi.parse(json, type)

	/**
	 * 将 JSON 字符串解析为指定类型的对象，解析失败时返回默认值。
	 *
	 * @param T 目标对象类型
	 * @param json 待解析的 JSON 字符串
	 * @param clazz 目标对象的 [Class] 类型
	 * @param defaultValue 解析失败时返回的默认值
	 * @return 解析后的对象实例或默认值
	 */
	@JvmStatic
	fun <T> parse(json: String, clazz: Class<T>, defaultValue: T): T = jsonApi.parse(json, clazz, defaultValue)

	/**
	 * 将 JSON 字符串解析为指定泛型类型的对象，解析失败时返回默认值。
	 *
	 * @param T 目标对象类型
	 * @param json 待解析的 JSON 字符串
	 * @param type 目标对象的 [JsonTypeReference] 类型引用（支持泛型）
	 * @param defaultValue 解析失败时返回的默认值
	 * @return 解析后的对象实例或默认值
	 */
	@JvmStatic
	fun <T> parse(
		json: String, type: JsonTypeReference<T>, defaultValue: T,
	): T = jsonApi.parse(json, type, defaultValue)

	/**
	 * 将对象格式化为美化格式的 JSON 字符串（带缩进和换行）。
	 *
	 * @param obj 待格式化的对象
	 * @return 格式化后的美化 JSON 字符串
	 */
	@JvmStatic
	fun formatPretty(obj: Any): String = jsonApi.formatPretty(obj)

	/**
	 * 将对象格式化为美化格式的 JSON 字节数组。
	 *
	 * @param obj 待格式化的对象
	 * @return 格式化后的美化 JSON 字节数组
	 */
	@JvmStatic
	fun formatPrettyBytes(obj: Any): ByteArray = jsonApi.formatPrettyBytes(obj)

	/**
	 * 将对象格式化为美化格式的 JSON 字符串并写入文件。
	 *
	 * @param obj 待格式化的对象
	 * @param file 文件路径
	 */
	@JvmStatic
	fun formatPretty(obj: Any, file: String) = jsonApi.formatPretty(obj, file)

	/**
	 * 将对象格式化为美化格式的 JSON 字符串并写入文件。
	 *
	 * @param obj 待格式化的对象
	 * @param file [Path] 对象
	 */
	@JvmStatic
	fun formatPretty(obj: Any, file: Path) = jsonApi.formatPretty(obj, file)

	/**
	 * 将对象格式化为美化格式的 JSON 字符串并写入文件。
	 *
	 * @param obj 待格式化的对象
	 * @param file [File] 对象
	 */
	@JvmStatic
	fun formatPretty(obj: Any, file: File) = jsonApi.formatPretty(obj, file)

	/**
	 * 将对象格式化为美化格式的 JSON 字符串并写入输出流。
	 *
	 * @param obj 待格式化的对象
	 * @param stream [OutputStream] 对象
	 */
	@JvmStatic
	fun formatPretty(obj: Any, stream: OutputStream) = jsonApi.formatPretty(obj, stream)

	/**
	 * 将对象格式化为 JSON 字节数组。
	 *
	 * @param obj 待格式化的对象
	 * @return 格式化后的 JSON 字节数组
	 */
	@JvmStatic
	fun formatBytes(obj: Any): ByteArray = jsonApi.formatBytes(obj)

	/**
	 * 将对象格式化为 JSON 字符串并写入文件。
	 *
	 * @param obj 待格式化的对象
	 * @param file 文件路径
	 */
	@JvmStatic
	fun format(obj: Any, file: String) = jsonApi.format(obj, file)

	/**
	 * 将对象格式化为 JSON 字符串并写入文件。
	 *
	 * @param obj 待格式化的对象
	 * @param file [Path] 对象
	 */
	@JvmStatic
	fun format(obj: Any, file: Path) = jsonApi.format(obj, file)

	/**
	 * 将对象格式化为 JSON 字符串并写入文件。
	 *
	 * @param obj 待格式化的对象
	 * @param file [File] 对象
	 */
	@JvmStatic
	fun format(obj: Any, file: File) = jsonApi.format(obj, file)

	/**
	 * 将对象格式化为 JSON 字符串并写入输出流。
	 *
	 * @param obj 待格式化的对象
	 * @param stream [OutputStream] 对象
	 */
	@JvmStatic
	fun format(obj: Any, stream: OutputStream) = jsonApi.format(obj, stream)

	/**
	 * 将 JSON 字符串解析为指定元素类型的 [List] 集合。
	 *
	 * @param T [List] 中元素的类型
	 * @param json 待解析的 JSON 字符串
	 * @param elementType [List] 中元素的 [Class] 类型
	 * @return 解析后的 [List] 集合
	 */
	@JvmStatic
	fun <T> parseList(json: String, elementType: Class<T>): List<T> = parse(json, listType(elementType))

	/**
	 * 将 JSON 字符串解析为指定元素类型的 [List] 集合。
	 *
	 * @param T [List] 中元素的类型，由调用方通过 reified 推断
	 * @param json 待解析的 JSON 字符串
	 * @return 解析后的 [List] 集合
	 */
	@JvmStatic
	inline fun <reified T> parseList(json: String): List<T> = parse(json, listType(T::class.java))

	/**
	 * 将 JSON 字符串解析为指定键值类型的 [MutableMap] 集合。
	 *
	 * @param K [Map] 中键的类型
	 * @param V [Map] 中值的类型
	 * @param json 待解析的 JSON 字符串
	 * @param keyType [Map] 中键的 [Class] 类型
	 * @param valueType [Map] 中值的 [Class] 类型
	 * @return 解析后的 [MutableMap] 集合
	 */
	@JvmStatic
	fun <K, V> parseMap(
		json: String, keyType: Class<K>, valueType: Class<V>,
	): MutableMap<K, V> = jsonApi.parseMap(json, keyType, valueType)

	/**
	 * 将 JSON 字符串解析为指定键值类型的 [MutableMap] 集合。
	 *
	 * @param K [Map] 中键的类型，由调用方通过 reified 推断
	 * @param V [Map] 中值的类型，由调用方通过 reified 推断
	 * @param json 待解析的 JSON 字符串
	 * @return 解析后的 [MutableMap] 集合
	 */
	@JvmStatic
	inline fun <reified K, reified V> parseMap(
		json: String,
	): MutableMap<K, V> = jsonApi.parseMap(json, K::class.java, V::class.java)

	/**
	 * 验证字符串是否为有效的 JSON 格式。
	 *
	 * @param json 待验证的字符串
	 * @return 如果是有效的 JSON 格式返回 `true`，否则返回 `false`
	 */
	@JvmStatic
	fun isValidJson(json: String): Boolean = jsonApi.isValidJson(json)

	/**
	 * 将对象转换为 JSON 字节数组。
	 *
	 * @param obj 待转换的对象
	 * @return 转换后的 JSON 字节数组
	 */
	@JvmStatic
	fun toBytes(obj: Any): ByteArray = jsonApi.toBytes(obj)

	/**
	 * 将对象转换为美化格式的 JSON 字节数组。
	 *
	 * @param obj 待转换的对象
	 * @return 转换后的美化格式 JSON 字节数组
	 */
	@JvmStatic
	fun toBytesPretty(obj: Any): ByteArray = jsonApi.toBytesPretty(obj)

	/**
	 * 合并多个 JSON 字符串为一个 JSON 对象。
	 *
	 * @param jsons 待合并的 JSON 字符串数组
	 * @return 合并后的 JSON 字符串
	 */
	@JvmStatic
	fun merge(vararg jsons: String): String = jsonApi.merge(*jsons)

	/**
	 * 获取 JSON 字符串中指定路径节点的值。
	 *
	 * @param json JSON 字符串
	 * @param path 节点路径（如 `"user.name"`）
	 * @return 节点值的字符串表示；节点不存在时返回 `null`
	 */
	@JvmStatic
	fun getNodeValue(json: String, path: String): String? = jsonApi.getNodeValue(json, path)

	/**
	 * 更新 JSON 字符串中指定路径节点的值。
	 *
	 * @param json 原始 JSON 字符串
	 * @param path 节点路径（如 `"user.name"`）
	 * @param newValue 新的节点值
	 * @return 更新后的 JSON 字符串
	 */
	@JvmStatic
	fun updateNodeValue(json: String, path: String, newValue: Any): String =
		jsonApi.updateNodeValue(json, path, newValue)

	/**
	 * 将源对象转换为目标类型的对象。
	 *
	 * @param D 目标对象类型
	 * @param source 需要转换的源对象
	 * @param destinationClass 目标对象的 [Class] 类型
	 * @return 转换后的目标类型对象
	 */
	@JvmStatic
	fun <D> convert(source: Any, destinationClass: Class<D>): D = jsonApi.convert(source, destinationClass)

	/**
	 * 将源对象转换为目标类型的对象，目标类型通过 reified 推断。
	 *
	 * @param D 目标对象类型，由调用方通过 reified 推断
	 * @param source 需要转换的源对象
	 * @return 转换后的目标类型对象
	 */
	@JvmStatic
	inline fun <reified D> convert(source: Any): D = jsonApi.convert(source, object : JsonTypeReference<D>() {})

	/**
	 * 将源对象转换为目标类型的对象，使用 [JsonTypeReference] 指定目标类型。
	 *
	 * @param D 目标对象类型
	 * @param source 需要转换的源对象
	 * @param destinationType 目标对象的 [JsonTypeReference] 类型引用
	 * @return 转换后的目标类型对象
	 */
	@JvmStatic
	fun <D> convert(source: Any, destinationType: JsonTypeReference<D>): D =
		jsonApi.convert(source, destinationType)

	/**
	 * 将当前字符串解析为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型，由调用方通过 reified 推断
	 * @return 解析后的对象实例
	 */
	inline fun <reified T> String.parseJson() = parse<T>(this)

	/**
	 * 将当前字节数组解析为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型，由调用方通过 reified 推断
	 * @return 解析后的对象实例
	 */
	inline fun <reified T> ByteArray.parseJson() = parse<T>(this)

	/**
	 * 将当前 [InputStream] 的内容解析为指定泛型类型的对象，并自动关闭流。
	 *
	 * @param T 目标对象类型，由调用方通过 reified 推断
	 * @return 解析后的对象实例
	 */
	inline fun <reified T> InputStream.parseJson() = this.use { parse<T>(readBytes()) }

	/**
	 * 将当前 [File] 的内容解析为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型，由调用方通过 reified 推断
	 * @return 解析后的对象实例
	 */
	inline fun <reified T> File.parseJson() = this.inputStream().parseJson<T>()

	/**
	 * 将当前 [Path] 的内容解析为指定泛型类型的对象。
	 *
	 * @param T 目标对象类型，由调用方通过 reified 推断
	 * @return 解析后的对象实例
	 */
	inline fun <reified T> Path.parseJson() = this.toFile().inputStream().parseJson<T>()

	/**
	 * 将当前对象格式化为 JSON 字符串。
	 *
	 * @return 格式化后的 JSON 字符串
	 */
	fun Any.toJson() = format(this)

	/**
	 * 创建并返回一个注册了 Kotlin 模块的 Jackson [ObjectMapper]。
	 *
	 * @return 注册了 Kotlin 模块的 [ObjectMapper]
	 */
	@JvmStatic
	fun jacksonKotlinObjectMapper(): ObjectMapper = ObjectMapper().jacksonKotlinObjectMapper()

	/**
	 * 为当前 [ObjectMapper] 注册 Kotlin 模块并返回自身。
	 *
	 * @return 注册了 Kotlin 模块的 [ObjectMapper]（即当前实例）
	 */
	@JvmStatic
	fun ObjectMapper.jacksonKotlinObjectMapper(): ObjectMapper = this.registerModule(kotlinModule())

	/**
	 * 将 JSON 字符串解析为 [JsonItem] 对象。
	 *
	 * @param json JSON 格式的字符串
	 * @return 解析后的 [JsonItem] 对象，可能是 `JsonObject`、`JsonArray` 或 `JsonValue`
	 */
	@JvmStatic
	fun parseJsonItem(json: String): JsonItem = jsonApi.parseJsonItem(json)

	/**
	 * 将字节数组解析为 [JsonItem] 对象。
	 *
	 * 字节数组会被转换为字符串后再解析。
	 *
	 * @param byte JSON 格式的字节数组（通常是 UTF-8 编码）
	 * @return 解析后的 [JsonItem] 对象
	 */
	@JvmStatic
	fun parseJsonItem(byte: ByteArray): JsonItem {
		return parseJsonItem(String(byte))
	}

	/**
	 * 将输入流解析为 [JsonItem] 对象，并自动关闭输入流。
	 *
	 * @param inputStream JSON 数据的输入流
	 * @return 解析后的 [JsonItem] 对象
	 * @throws IOException 当读取输入流失败时抛出
	 *
	 * 使用示例：
	 * ```
	 * val inputStream = FileInputStream("data.json")
	 * val jsonItem = JSONA.parseJsonItem(inputStream)
	 * ```
	 */
	@JvmStatic
	@Throws(IOException::class)
	fun parseJsonItem(inputStream: InputStream): JsonItem {
		inputStream.use {
			return parseJsonItem(it.readAllBytes())
		}
	}

	/**
	 * 将文件解析为 [JsonItem] 对象。
	 *
	 * @param file 包含 JSON 数据的文件
	 * @return 解析后的 [JsonItem] 对象
	 * @throws IOException 当读取文件失败时抛出
	 *
	 * 使用示例：
	 * ```
	 * val file = File("config.json")
	 * val jsonItem = JSONA.parseJsonItem(file)
	 * ```
	 */
	@JvmStatic
	@Throws(IOException::class)
	fun parseJsonItem(file: File): JsonItem {
		return parseJsonItem(file.readBytes())
	}

	/**
	 * 将文件路径解析为 [JsonItem] 对象。
	 *
	 * @param path 包含 JSON 数据的文件路径
	 * @return 解析后的 [JsonItem] 对象
	 * @throws IOException 当读取文件失败时抛出
	 *
	 * 使用示例：
	 * ```
	 * val path = Paths.get("data/user.json")
	 * val jsonItem = JSONA.parseJsonItem(path)
	 * ```
	 */
	@JvmStatic
	@Throws(IOException::class)
	fun parseJsonItem(path: Path): JsonItem {
		return parseJsonItem(path.readBytes())
	}
}
