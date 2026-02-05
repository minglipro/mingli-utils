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
 * CurrentFile JsonApi.kt
 * LastUpdate 2026-02-04 21:00:48
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api.base

import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.api.type.listType
import com.mingliqiye.utils.json.converters.base.BaseJsonConverter
import java.io.*
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * JSON处理接口，提供JSON字符串与Java对象之间的相互转换功能
 */
interface JsonApi {

    companion object {
        /**
         * 将JSON字符串解析为指定泛型类型对象
         *
         * @param json 待解析的JSON字符串
         * @param T    泛型参数，表示目标对象的类型
         * @return 解析后的对象实例
         */
        inline fun <reified T> JsonApi.parse(json: String): T = parse(json, object : JsonTypeReference<T>() {})

        /**
         * 将JSON字节数组解析为指定泛型类型对象
         *
         * @param json 待解析的JSON字节数组
         * @param T    泛型参数，表示目标对象的类型
         * @return 解析后的对象实例
         */
        inline fun <reified T> JsonApi.parse(json: ByteArray): T = parse(json, object : JsonTypeReference<T>() {})

        /**
         * 将JSON字符串解析为指定泛型类型对象，解析失败时返回默认值
         *
         * @param json     待解析的JSON字符串
         * @param defect   解析失败时返回的默认值
         * @param T        泛型参数，表示目标对象的类型
         * @return 解析后的对象实例或默认值
         */
        inline fun <reified T> JsonApi.parse(json: String, defect: T): T =
            parse(json, object : JsonTypeReference<T>() {}, defect)

        /**
         * 从文件路径读取JSON并解析为指定泛型类型对象
         *
         * @param path 文件路径
         * @param T    泛型参数，表示目标对象的类型
         * @return 解析后的对象实例
         */
        inline fun <reified T> JsonApi.parseFrom(path: String): T = parseFrom(path, object : JsonTypeReference<T>() {})

        /**
         * 从文件读取JSON并解析为指定泛型类型对象
         *
         * @param path 文件对象
         * @param T    泛型参数，表示目标对象的类型
         * @return 解析后的对象实例
         */
        inline fun <reified T> JsonApi.parseFrom(path: File): T = parseFrom(path, object : JsonTypeReference<T>() {})

        /**
         * 从输入流读取JSON并解析为指定泛型类型对象
         *
         * @param path 输入流
         * @param T    泛型参数，表示目标对象的类型
         * @return 解析后的对象实例
         */
        inline fun <reified T> JsonApi.parseFrom(path: InputStream): T =
            parseFrom(path, object : JsonTypeReference<T>() {})

        /**
         * 从路径读取JSON并解析为指定泛型类型对象
         *
         * @param path 路径对象
         * @param T    泛型参数，表示目标对象的类型
         * @return 解析后的对象实例
         */
        inline fun <reified T> JsonApi.parseFrom(path: Path): T = parseFrom(path, object : JsonTypeReference<T>() {})

        /**
         * 将JSON字符串解析为指定键值类型的Map集合
         *
         * @param json 待解析的JSON字符串
         * @param K    泛型参数，表示Map中键的类型
         * @param V    泛型参数，表示Map中值的类型
         * @return 解析后的Map集合
         */
        inline fun <reified K, reified V> JsonApi.parseMap(
            json: String
        ): MutableMap<K, V> = parseMap(json, K::class.java, V::class.java)


        /**
         * 使用内联函数和reified类型参数将源对象转换为目标类型的对象
         *
         * @param T 源对象的类型
         * @param D 目标对象的类型（通过reified类型参数推断）
         * @param source 需要转换的源对象
         * @return 转换后的目标类型对象
         */
        @JvmStatic
        inline fun <reified D> JsonApi.convert(source: Any): D = convert(source, object : JsonTypeReference<D>() {})

        /**
         * 添加JSON转换器到API中
         *
         * @param T 需要添加的JSON转换器类
         */
        @JvmStatic
        inline fun <reified T : BaseJsonConverter<*, *>> JsonApi.addJsonConverter() {
            addJsonConverter(T::class.java.newInstance())
        }

    }

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

    /**
     * 从文件路径读取JSON并解析为指定类型对象
     *
     * @param path  文件路径
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    fun <T> parseFrom(path: String, clazz: Class<T>): T {
        return parseFrom(Paths.get(path), clazz)
    }

    /**
     * 从路径读取JSON并解析为指定类型对象
     *
     * @param path  路径对象
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    fun <T> parseFrom(path: Path, clazz: Class<T>): T {
        return parseFrom(path.toFile(), clazz)
    }

    /**
     * 从文件读取JSON并解析为指定类型对象
     *
     * @param file  文件对象
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    fun <T> parseFrom(file: File, clazz: Class<T>): T {
        Files.newInputStream(file.toPath()).use { inputStream ->
            return parseFrom(inputStream, clazz)
        }
    }

    /**
     * 从输入流读取JSON并解析为指定类型对象
     *
     * @param inputStream 输入流
     * @param clazz       目标对象的Class类型
     * @param <T>         泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
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

    /**
     * 从文件路径读取JSON并解析为指定泛型类型对象
     *
     * @param path 文件路径
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    fun <T> parseFrom(path: String, type: JsonTypeReference<T>): T {
        return parseFrom(Paths.get(path), type)
    }

    /**
     * 从路径读取JSON并解析为指定泛型类型对象
     *
     * @param path 路径对象
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    fun <T> parseFrom(path: Path, type: JsonTypeReference<T>): T {
        return parseFrom(path.toFile(), type)
    }

    /**
     * 从文件读取JSON并解析为指定泛型类型对象
     *
     * @param file 文件对象
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    fun <T> parseFrom(file: File, type: JsonTypeReference<T>): T {
        Files.newInputStream(file.toPath()).use { inputStream ->
            return parseFrom<T>(inputStream, type)
        }
    }

    /**
     * 从输入流读取JSON并解析为指定泛型类型对象
     *
     * @param inputStream 输入流
     * @param type        目标对象的Type类型（支持泛型）
     * @param <T>         泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
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
        return try {
            parse(json, clazz)
        } catch (e: Exception) {
            defaultValue
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
        json: String, type: JsonTypeReference<T>, defaultValue: T
    ): T {
        return try {
            parse<T>(json, type)
        } catch (e: Exception) {
            defaultValue
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

    fun formatPretty(obj: Any, file: String) {
        formatPretty(obj, Paths.get(file))
    }

    fun formatPretty(obj: Any, file: Path) {
        formatPretty(obj, file.toFile())
    }

    fun formatPretty(obj: Any, file: File) {
        FileOutputStream(file).use { fos ->
            formatPretty(obj, fos)
        }
    }

    fun formatPretty(obj: Any, stream: OutputStream) {
        stream.write(formatPrettyBytes(obj))
    }

    fun formatPrettyUnicode(obj: Any, file: String) {
        formatPrettyUnicode(obj, Paths.get(file))
    }

    fun formatPrettyUnicode(obj: Any, file: Path) {
        formatPrettyUnicode(obj, file.toFile())
    }

    fun formatPrettyUnicode(obj: Any, file: File) {
        FileOutputStream(file).use { fos ->
            formatPrettyUnicode(obj, fos)
        }
    }

    fun formatPrettyUnicode(obj: Any, stream: OutputStream) {
        stream.write(formatPrettyUnicodeBytes(obj))
    }

    fun formatBytes(obj: Any): ByteArray {
        return format(obj)!!.toByteArray()
    }

    fun formatUnicodeBytes(obj: Any): ByteArray {
        return formatUnicode(obj)!!.toByteArray()
    }

    fun format(obj: Any, file: String) {
        format(obj, Paths.get(file))
    }

    fun format(obj: Any, file: Path) {
        format(obj, file.toFile())
    }

    fun format(obj: Any, file: File) {
        FileOutputStream(file).use { fos ->
            format(obj, fos)
        }
    }

    fun format(obj: Any, stream: OutputStream) {
        stream.write(formatPrettyBytes(obj))
    }

    fun formatUnicode(obj: Any, file: String) {
        formatUnicode(obj, Paths.get(file))
    }

    fun formatUnicode(obj: Any, file: Path) {
        formatUnicode(obj, file.toFile())
    }

    fun formatUnicode(obj: Any, file: File) {
        FileOutputStream(file).use { fos ->
            formatUnicode(obj, fos)
        }
    }

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
        json: String, keyType: Class<K>, valueType: Class<V>
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

    fun <D> convert(source: Any, destinationClass: Class<D>): D

    fun <D> convert(source: Any, destinationType: JsonTypeReference<D>): D

    fun addJsonConverter(c: BaseJsonConverter<*, *>)
}
