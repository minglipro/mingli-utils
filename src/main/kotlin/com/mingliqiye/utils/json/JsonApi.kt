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
 * CurrentFile JsonApi.kt
 * LastUpdate 2025-09-15 22:32:50
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json

import com.mingliqiye.utils.json.converters.JsonConverter
import com.mingliqiye.utils.json.converters.JsonStringConverter
import java.io.*
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


/**
 * JSON处理接口，提供JSON字符串与Java对象之间的相互转换功能
 */
interface JsonApi {
    /**
     * 将JSON字符串解析为指定类型的对象
     *
     * @param json  待解析的JSON字符串
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
    </T> */
    fun <T> parse(json: String, clazz: Class<T>): T

    /**
     * 将JSON字符串解析为指定泛型类型对象
     *
     * @param json 待解析的JSON字符串
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
    </T> */
    fun <T> parse(json: String, type: JsonTypeReference<T>): T

    /**
     * 将对象格式化为JSON字符串
     *
     * @param obj 待格式化的对象
     * @return 格式化后的JSON字符串
     */
    fun format(obj: Any): String

    fun formatUnicode(obj: Any): String

    @Throws(IOException::class)
    fun <T> parseFrom(path: String, clazz: Class<T>): T {
        return parseFrom(Paths.get(path), clazz)
    }

    @Throws(IOException::class)
    fun <T> parseFrom(path: Path, clazz: Class<T>): T {
        return parseFrom(path.toFile(), clazz)
    }

    @Throws(IOException::class)
    fun <T> parseFrom(file: File, clazz: Class<T>): T {
        Files.newInputStream(file.toPath()).use { inputStream ->
            return parseFrom(inputStream, clazz)
        }
    }

    @Throws(IOException::class)
    fun <T> parseFrom(inputStream: InputStream, clazz: Class<T>): T {
        val bytes = ByteArray(1024)
        ByteArrayOutputStream().use { bos ->
            var readlength: Int
            while ((inputStream.read(bytes).also { readlength = it }) != -1) {
                bos.write(bytes, 0, readlength)
            }
            return parse(bos.toByteArray(), clazz)
        }
    }

    @Throws(IOException::class)
    fun <T> parseFrom(path: String, type: JsonTypeReference<T>): T {
        return parseFrom(Paths.get(path), type)
    }

    @Throws(IOException::class)
    fun <T> parseFrom(path: Path, type: JsonTypeReference<T>): T {
        return parseFrom(path.toFile(), type)
    }

    @Throws(IOException::class)
    fun <T> parseFrom(file: File, type: JsonTypeReference<T>): T {
        Files.newInputStream(file.toPath()).use { inputStream ->
            return parseFrom<T>(inputStream, type)
        }
    }

    @Throws(IOException::class)
    fun <T> parseFrom(inputStream: InputStream, type: JsonTypeReference<T>): T {
        val bytes = ByteArray(1024)
        ByteArrayOutputStream().use { bos ->
            var readlength: Int
            while ((inputStream.read(bytes).also { readlength = it }) != -1) {
                bos.write(bytes, 0, readlength)
            }
            return parse(bos.toByteArray(), type)
        }
    }

    /**
     * 将字节数组形式的JSON解析为指定类型的对象
     *
     * @param json  待解析的JSON字节数组
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
    </T> */
    fun <T> parse(json: ByteArray, clazz: Class<T>): T {
        return parse(String(json), clazz)
    }

    /**
     * 将字节数组形式的JSON解析为指定泛型类型对象
     *
     * @param json 待解析的JSON字节数组
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
    </T> */
    fun <T> parse(json: ByteArray, type: JsonTypeReference<T>): T {
        return parse(String(json), type)
    }

    /**
     * 将JSON字符串解析为指定类型的对象，解析失败时返回默认值
     *
     * @param json         待解析的JSON字符串
     * @param clazz        目标对象的Class类型
     * @param defaultValue 解析失败时返回的默认值
     * @param <T>          泛型参数，表示目标对象的类型
     * @return 解析后的对象实例或默认值
    </T> */
    fun <T> parse(json: String, clazz: Class<T>, defaultValue: T): T {
        try {
            return parse(json, clazz)
        } catch (e: Exception) {
            return defaultValue
        }
    }

    /**
     * 将JSON字符串解析为指定泛型类型对象，解析失败时返回默认值
     *
     * @param json         待解析的JSON字符串
     * @param type         目标对象的Type类型（支持泛型）
     * @param defaultValue 解析失败时返回的默认值
     * @param <T>          泛型参数，表示目标对象的类型
     * @return 解析后的对象实例或默认值
     **/
    fun <T> parse(
        json: String,
        type: JsonTypeReference<T>,
        defaultValue: T
    ): T {
        try {
            return parse<T>(json, type)
        } catch (e: Exception) {
            return defaultValue
        }
    }

    /**
     * 将对象格式化为美化格式的JSON字符串（带缩进和换行）
     *
     * @param object 待格式化的对象
     * @return 格式化后的美化JSON字符串
     */
    fun formatPretty(obj: Any): String

    fun formatPrettyBytes(obj: Any): ByteArray {
        return formatPretty(obj)!!.toByteArray()
    }

    fun formatPrettyUnicode(obj: Any): String

    fun formatPrettyUnicodeBytes(obj: Any): ByteArray {
        return formatPrettyUnicode(obj)!!.toByteArray()
    }

    @Throws(IOException::class)
    fun formatPretty(obj: Any, file: String) {
        formatPretty(obj, Paths.get(file))
    }

    @Throws(IOException::class)
    fun formatPretty(obj: Any, file: Path) {
        formatPretty(obj, file.toFile())
    }

    @Throws(IOException::class)
    fun formatPretty(obj: Any, file: File) {
        FileOutputStream(file).use { fos ->
            formatPretty(obj, fos)
        }
    }

    @Throws(IOException::class)
    fun formatPretty(obj: Any, stream: OutputStream) {
        stream.write(formatPrettyBytes(obj))
    }

    @Throws(IOException::class)
    fun formatPrettyUnicode(obj: Any, file: String) {
        formatPrettyUnicode(obj, Paths.get(file))
    }

    @Throws(IOException::class)
    fun formatPrettyUnicode(obj: Any, file: Path) {
        formatPrettyUnicode(obj, file.toFile())
    }

    @Throws(IOException::class)
    fun formatPrettyUnicode(obj: Any, file: File) {
        FileOutputStream(file).use { fos ->
            formatPrettyUnicode(obj, fos)
        }
    }

    @Throws(IOException::class)
    fun formatPrettyUnicode(obj: Any, stream: OutputStream) {
        stream.write(formatPrettyUnicodeBytes(obj))
    }

    fun formatBytes(obj: Any): ByteArray {
        return format(obj)!!.toByteArray()
    }

    fun formatUnicodeBytes(obj: Any): ByteArray {
        return formatUnicode(obj)!!.toByteArray()
    }

    @Throws(IOException::class)
    fun format(obj: Any, file: String) {
        format(obj, Paths.get(file))
    }

    @Throws(IOException::class)
    fun format(obj: Any, file: Path) {
        format(obj, file.toFile())
    }

    @Throws(IOException::class)
    fun format(obj: Any, file: File) {
        FileOutputStream(file).use { fos ->
            format(obj, fos)
        }
    }

    @Throws(IOException::class)
    fun format(obj: Any, stream: OutputStream) {
        stream.write(formatPrettyBytes(obj))
    }

    @Throws(IOException::class)
    fun formatUnicode(obj: Any, file: String) {
        formatUnicode(obj, Paths.get(file))
    }

    @Throws(IOException::class)
    fun formatUnicode(obj: Any, file: Path) {
        formatUnicode(obj, file.toFile())
    }

    @Throws(IOException::class)
    fun formatUnicode(obj: Any, file: File) {
        FileOutputStream(file).use { fos ->
            formatUnicode(obj, fos)
        }
    }

    @Throws(IOException::class)
    fun formatUnicode(obj: Any, stream: OutputStream) {
        stream.write(formatPrettyUnicodeBytes(obj))
    }

    /**
     * 将JSON字符串解析为指定元素类型的List集合
     *
     * @param json        待解析的JSON字符串
     * @param elementType List中元素的类型
     * @param <T>         泛型参数，表示List中元素的类型
     * @return 解析后的List集合
    </T> */
    fun <T> parseList(json: String, elementType: Class<T>): List<T> {
        return parse(json, type = listType(elementType))
    }

    /**
     * 将JSON字符串解析为指定键值类型的Map集合
     *
     * @param json      待解析的JSON字符串
     * @param keyType   Map中键的类型
     * @param valueType Map中值的类型
     * @param <K>       泛型参数，表示Map中键的类型
     * @param <V>       泛型参数，表示Map中值的类型
     * @return 解析后的Map集合
    </V></K> */
    fun <K, V> parseMap(
        json: String,
        keyType: Class<K>,
        valueType: Class<V>
    ): MutableMap<K, V> {
        val mapType: JsonTypeReference<MutableMap<K, V>> = object : JsonTypeReference<MutableMap<K, V>>() {}
        return parse<MutableMap<K, V>>(json, mapType)
    }

    /**
     * 验证字符串是否为有效的JSON格式
     *
     * @param json 待验证的字符串
     * @return 如果是有效的JSON格式返回true，否则返回false
     */
    fun isValidJson(json: String): Boolean

    /**
     * 将对象转换为JSON字节数组
     *
     * @param object 待转换的对象
     * @return 转换后的JSON字节数组
     */
    fun toBytes(obj: Any): ByteArray {
        return format(obj)!!.toByteArray()
    }

    /**
     * 将对象转换为美化格式的JSON字节数组
     *
     * @param object 待转换的对象
     * @return 转换后的美化格式JSON字节数组
     */
    fun toBytesPretty(obj: Any): ByteArray {
        return formatPretty(obj)!!.toByteArray()
    }

    /**
     * 合并多个JSON字符串为一个JSON对象
     *
     * @param jsons 待合并的JSON字符串数组
     * @return 合并后的JSON字符串
     */
    fun merge(vararg jsons: String): String

    /**
     * 获取JSON字符串中指定路径节点的值
     *
     * @param json JSON字符串
     * @param path 节点路径（如："user.name"）
     * @return 节点值的字符串表示
     */
    fun getNodeValue(json: String, path: String): String?

    /**
     * 更新JSON字符串中指定路径节点的值
     *
     * @param json     原始JSON字符串
     * @param path     节点路径（如："user.name"）
     * @param newValue 新的节点值
     * @return 更新后的JSON字符串
     */
    fun updateNodeValue(json: String, path: String, newValue: Any): String

    fun <T, D> convert(source: T, destinationClass: Class<D>): D

    fun <T, D> convert(source: T, destinationType: JsonTypeReference<D>): D

    fun addJsonConverter(c: JsonConverter<*, *>)
    fun addJsonStringConverter(c: JsonStringConverter<*>)
}
