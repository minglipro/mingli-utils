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
 * LastUpdate 2026-02-05 10:34:30
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.api.type.listType
import com.mingliqiye.utils.json.converters.base.BaseJsonConverter
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import java.nio.file.Path

/**
 * JSON工具类，提供静态方法访问JSON API功能
 */
object JSONA {
    @JvmStatic
    private var jsonApi: JsonApi? = null

    /**
     * 获取JSON API实例
     *
     * @return JSON API实例
     * @throws NullPointerException 当JSON API未初始化时抛出异常
     */
    @Throws(NullPointerException::class)
    @JvmStatic
    fun getJsonApi(): JsonApi {
        if (jsonApi == null) {
            throw NullPointerException("jsonApi is null plase setJsonApi first")
        }
        return jsonApi!!
    }

    /**
     * 设置JSON API实例
     *
     * @param jsa JSON API实例
     */
    @JvmStatic
    fun setJsonApi(jsa: JsonApi) {
        jsonApi = jsa
    }

    /**
     * 使用反射创建并设置指定类型的JSON API实例
     *
     * @param T 继承自JsonApi的具体实现类
     */
    inline fun <reified T : JsonApi> setJsonApi() {
        setJsonApi(T::class.java.newInstance() as JsonApi)
    }

    /**
     * 将JSON字符串解析为指定类型的对象
     *
     * @param json  待解析的JSON字符串
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parse(json: String, clazz: Class<T>): T = getJsonApi().parse(json, clazz)

    /**
     * 将JSON字符串解析为指定泛型类型对象
     *
     * @param json 待解析的JSON字符串
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    inline fun <reified T> parse(json: String): T {
        return getJsonApi().parse(json, (object : JsonTypeReference<T>() {}))
    }

    /**
     * 将字节数组形式的JSON解析为指定泛型类型对象
     *
     * @param json 待解析的JSON字节数组
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    inline fun <reified T> parse(json: ByteArray): T = getJsonApi().parse(json, object : JsonTypeReference<T>() {})

    /**
     * 将JSON字符串解析为指定泛型类型对象
     *
     * @param json 待解析的JSON字符串
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parse(json: String, type: JsonTypeReference<T>): T = getJsonApi().parse(json, type)

    /**
     * 将对象格式化为JSON字符串
     *
     * @param obj 待格式化的对象
     * @return 格式化后的JSON字符串
     */
    @JvmStatic
    fun format(obj: Any): String = getJsonApi().format(obj)

    /**
     * 将对象格式化为带Unicode转义的JSON字符串
     *
     * @param obj 待格式化的对象
     * @return 格式化后的带Unicode转义的JSON字符串
     */
    @JvmStatic
    fun formatUnicode(obj: Any): String = getJsonApi().formatPrettyUnicode(obj)

    /**
     * 从文件路径解析JSON为指定类型的对象
     *
     * @param path  文件路径
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parseFrom(path: String, clazz: Class<T>): T = getJsonApi().parseFrom(path, clazz)

    /**
     * 从Path对象解析JSON为指定类型的对象
     *
     * @param path  Path对象
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parseFrom(path: Path, clazz: Class<T>): T = getJsonApi().parseFrom(path, clazz)

    /**
     * 从File对象解析JSON为指定类型的对象
     *
     * @param file  File对象
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parseFrom(file: File, clazz: Class<T>): T = getJsonApi().parseFrom(file, clazz)

    /**
     * 从InputStream解析JSON为指定类型的对象
     *
     * @param inputStream InputStream对象
     * @param clazz       目标对象的Class类型
     * @param <T>         泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parseFrom(inputStream: InputStream, clazz: Class<T>): T = getJsonApi().parseFrom(inputStream, clazz)

    /**
     * 从文件路径解析JSON为指定泛型类型对象
     *
     * @param path 文件路径
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parseFrom(path: String, type: JsonTypeReference<T>): T = getJsonApi().parseFrom(path, type)

    /**
     * 从Path对象解析JSON为指定泛型类型对象
     *
     * @param path Path对象
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parseFrom(path: Path, type: JsonTypeReference<T>): T = getJsonApi().parseFrom(path, type)

    /**
     * 从File对象解析JSON为指定泛型类型对象
     *
     * @param file File对象
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parseFrom(file: File, type: JsonTypeReference<T>): T = getJsonApi().parseFrom(file, type)

    /**
     * 从InputStream解析JSON为指定泛型类型对象
     *
     * @param inputStream InputStream对象
     * @param type        目标对象的Type类型（支持泛型）
     * @param <T>         泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parseFrom(inputStream: InputStream, type: JsonTypeReference<T>): T =
        getJsonApi().parseFrom(inputStream, type)

    /**
     * 将字节数组形式的JSON解析为指定类型的对象
     *
     * @param json  待解析的JSON字节数组
     * @param clazz 目标对象的Class类型
     * @param <T>   泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parse(json: ByteArray, clazz: Class<T>): T = getJsonApi().parse(json, clazz)

    /**
     * 将字节数组形式的JSON解析为指定泛型类型对象
     *
     * @param json 待解析的JSON字节数组
     * @param type 目标对象的Type类型（支持泛型）
     * @param <T>  泛型参数，表示目标对象的类型
     * @return 解析后的对象实例
     */
    @JvmStatic
    fun <T> parse(json: ByteArray, type: JsonTypeReference<T>): T = getJsonApi().parse(json, type)

    /**
     * 将JSON字符串解析为指定类型的对象，解析失败时返回默认值
     *
     * @param json         待解析的JSON字符串
     * @param clazz        目标对象的Class类型
     * @param defaultValue 解析失败时返回的默认值
     * @param <T>          泛型参数，表示目标对象的类型
     * @return 解析后的对象实例或默认值
     */
    @JvmStatic
    fun <T> parse(json: String, clazz: Class<T>, defaultValue: T): T = getJsonApi().parse(json, clazz, defaultValue)

    /**
     * 将JSON字符串解析为指定泛型类型对象，解析失败时返回默认值
     *
     * @param json         待解析的JSON字符串
     * @param type         目标对象的Type类型（支持泛型）
     * @param defaultValue 解析失败时返回的默认值
     * @param <T>          泛型参数，表示目标对象的类型
     * @return 解析后的对象实例或默认值
     */
    @JvmStatic
    fun <T> parse(
        json: String, type: JsonTypeReference<T>, defaultValue: T
    ): T = getJsonApi().parse(json, type, defaultValue)

    /**
     * 将对象格式化为美化格式的JSON字符串（带缩进和换行）
     *
     * @param obj 待格式化的对象
     * @return 格式化后的美化JSON字符串
     */
    @JvmStatic
    fun formatPretty(obj: Any): String = getJsonApi().formatPretty(obj)

    /**
     * 将对象格式化为美化格式的JSON字节数组
     *
     * @param obj 待格式化的对象
     * @return 格式化后的美化JSON字节数组
     */
    @JvmStatic
    fun formatPrettyBytes(obj: Any): ByteArray = getJsonApi().formatPrettyBytes(obj)

    /**
     * 将对象格式化为带Unicode转义的美化JSON字符串
     *
     * @param obj 待格式化的对象
     * @return 格式化后的带Unicode转义的美化JSON字符串
     */
    @JvmStatic
    fun formatPrettyUnicode(obj: Any): String = getJsonApi().formatPrettyUnicode(obj)

    /**
     * 将对象格式化为带Unicode转义的美化JSON字节数组
     *
     * @param obj 待格式化的对象
     * @return 格式化后的带Unicode转义的美化JSON字节数组
     */
    @JvmStatic
    fun formatPrettyUnicodeBytes(obj: Any): ByteArray = getJsonApi().formatPrettyUnicodeBytes(obj)

    /**
     * 将对象格式化为美化格式的JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file 文件路径
     */
    @JvmStatic
    fun formatPretty(obj: Any, file: String) = getJsonApi().formatPretty(obj, file)

    /**
     * 将对象格式化为美化格式的JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file Path对象
     */
    @JvmStatic
    fun formatPretty(obj: Any, file: Path) = getJsonApi().formatPretty(obj, file)

    /**
     * 将对象格式化为美化格式的JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file File对象
     */
    @JvmStatic
    fun formatPretty(obj: Any, file: File) = getJsonApi().formatPretty(obj, file)

    /**
     * 将对象格式化为美化格式的JSON字符串并写入输出流
     *
     * @param obj    待格式化的对象
     * @param stream OutputStream对象
     */
    @JvmStatic
    fun formatPretty(obj: Any, stream: OutputStream) = getJsonApi().formatPretty(obj, stream)

    /**
     * 将对象格式化为带Unicode转义的美化JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file 文件路径
     */
    @JvmStatic
    fun formatPrettyUnicode(obj: Any, file: String) = getJsonApi().formatPrettyUnicode(obj, file)

    /**
     * 将对象格式化为带Unicode转义的美化JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file Path对象
     */
    @JvmStatic
    fun formatPrettyUnicode(obj: Any, file: Path) = getJsonApi().formatPrettyUnicode(obj, file)

    /**
     * 将对象格式化为带Unicode转义的美化JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file File对象
     */
    @JvmStatic
    fun formatPrettyUnicode(obj: Any, file: File) = getJsonApi().formatPrettyUnicode(obj, file)

    /**
     * 将对象格式化为带Unicode转义的美化JSON字符串并写入输出流
     *
     * @param obj    待格式化的对象
     * @param stream OutputStream对象
     */
    @JvmStatic
    fun formatPrettyUnicode(obj: Any, stream: OutputStream) = getJsonApi().formatPrettyUnicode(obj, stream)

    /**
     * 将对象格式化为JSON字节数组
     *
     * @param obj 待格式化的对象
     * @return 格式化后的JSON字节数组
     */
    @JvmStatic
    fun formatBytes(obj: Any): ByteArray = getJsonApi().formatBytes(obj)

    /**
     * 将对象格式化为带Unicode转义的JSON字节数组
     *
     * @param obj 待格式化的对象
     * @return 格式化后的带Unicode转义的JSON字节数组
     */
    @JvmStatic
    fun formatUnicodeBytes(obj: Any): ByteArray = getJsonApi().formatUnicodeBytes(obj)

    /**
     * 将对象格式化为JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file 文件路径
     */
    @JvmStatic
    fun format(obj: Any, file: String) = getJsonApi().format(obj, file)

    /**
     * 将对象格式化为JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file Path对象
     */
    @JvmStatic
    fun format(obj: Any, file: Path) = getJsonApi().format(obj, file)

    /**
     * 将对象格式化为JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file File对象
     */
    @JvmStatic
    fun format(obj: Any, file: File) = getJsonApi().format(obj, file)

    /**
     * 将对象格式化为JSON字符串并写入输出流
     *
     * @param obj    待格式化的对象
     * @param stream OutputStream对象
     */
    @JvmStatic
    fun format(obj: Any, stream: OutputStream) = getJsonApi().format(obj, stream)

    /**
     * 将对象格式化为带Unicode转义的JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file 文件路径
     */
    @JvmStatic
    fun formatUnicode(obj: Any, file: String) = getJsonApi().formatUnicode(obj, file)

    /**
     * 将对象格式化为带Unicode转义的JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file Path对象
     */
    @JvmStatic
    fun formatUnicode(obj: Any, file: Path) = getJsonApi().formatUnicode(obj, file)

    /**
     * 将对象格式化为带Unicode转义的JSON字符串并写入文件
     *
     * @param obj  待格式化的对象
     * @param file File对象
     */
    @JvmStatic
    fun formatUnicode(obj: Any, file: File) = getJsonApi().formatUnicode(obj, file)

    /**
     * 将对象格式化为带Unicode转义的JSON字符串并写入输出流
     *
     * @param obj    待格式化的对象
     * @param stream OutputStream对象
     */
    @JvmStatic
    fun formatUnicode(obj: Any, stream: OutputStream) = getJsonApi().formatUnicode(obj, stream)

    /**
     * 将JSON字符串解析为指定元素类型的List集合
     *
     * @param json        待解析的JSON字符串
     * @param elementType List中元素的类型
     * @param <T>         泛型参数，表示List中元素的类型
     * @return 解析后的List集合
     */
    @JvmStatic
    fun <T> parseList(json: String, elementType: Class<T>): List<T> = parse(json, listType(elementType))

    /**
     * 将JSON字符串解析为指定元素类型的List集合
     *
     * @param json 待解析的JSON字符串
     * @param <T>  泛型参数，表示List中元素的类型
     * @return 解析后的List集合
     */
    @JvmStatic
    inline fun <reified T> parseList(json: String): List<T> = parse(json, listType(T::class.java))

    /**
     * 将JSON字符串解析为指定键值类型的Map集合
     *
     * @param json      待解析的JSON字符串
     * @param keyType   Map中键的类型
     * @param valueType Map中值的类型
     * @param <K>       泛型参数，表示Map中键的类型
     * @param <V>       泛型参数，表示Map中值的类型
     * @return 解析后的Map集合
     */
    @JvmStatic
    fun <K, V> parseMap(
        json: String, keyType: Class<K>, valueType: Class<V>
    ): MutableMap<K, V> = getJsonApi().parseMap(json, keyType, valueType)

    /**
     * 将JSON字符串解析为指定键值类型的Map集合
     *
     * @param json 待解析的JSON字符串
     * @param <K>  泛型参数，表示Map中键的类型
     * @param <V>  泛型参数，表示Map中值的类型
     * @return 解析后的Map集合
     */
    @JvmStatic
    inline fun <reified K, reified V> parseMap(
        json: String
    ): MutableMap<K, V> = getJsonApi().parseMap(json, K::class.java, V::class.java)

    /**
     * 验证字符串是否为有效的JSON格式
     *
     * @param json 待验证的字符串
     * @return 如果是有效的JSON格式返回true，否则返回false
     */
    @JvmStatic
    fun isValidJson(json: String): Boolean = getJsonApi().isValidJson(json)

    /**
     * 将对象转换为JSON字节数组
     *
     * @param object 待转换的对象
     * @return 转换后的JSON字节数组
     */
    @JvmStatic
    fun toBytes(obj: Any): ByteArray = getJsonApi().toBytes(obj)

    /**
     * 将对象转换为美化格式的JSON字节数组
     *
     * @param object 待转换的对象
     * @return 转换后的美化格式JSON字节数组
     */
    @JvmStatic
    fun toBytesPretty(obj: Any): ByteArray = getJsonApi().toBytesPretty(obj)

    /**
     * 合并多个JSON字符串为一个JSON对象
     *
     * @param jsons 待合并的JSON字符串数组
     * @return 合并后的JSON字符串
     */
    @JvmStatic
    fun merge(vararg jsons: String): String = getJsonApi().merge(*jsons)

    /**
     * 获取JSON字符串中指定路径节点的值
     *
     * @param json JSON字符串
     * @param path 节点路径（如："user.name"）
     * @return 节点值的字符串表示
     */
    @JvmStatic
    fun getNodeValue(json: String, path: String): String? = getJsonApi().getNodeValue(json, path)

    /**
     * 更新JSON字符串中指定路径节点的值
     *
     * @param json     原始JSON字符串
     * @param path     节点路径（如："user.name"）
     * @param newValue 新的节点值
     * @return 更新后的JSON字符串
     */
    @JvmStatic
    fun updateNodeValue(json: String, path: String, newValue: Any): String =
        getJsonApi().updateNodeValue(json, path, newValue)

    /**
     * 将源对象转换为目标类型的对象
     *
     * @param T 源对象的类型
     * @param D 目标对象的类型
     * @param source 需要转换的源对象
     * @param destinationClass 目标对象的Class类型
     * @return 转换后的目标类型对象
     */
    @JvmStatic
    fun <D> convert(source: Any, destinationClass: Class<D>): D = getJsonApi().convert(source, destinationClass)

    /**
     * 使用内联函数和reified类型参数将源对象转换为目标类型的对象
     *
     * @param T 源对象的类型
     * @param D 目标对象的类型（通过reified类型参数推断）
     * @param source 需要转换的源对象
     * @return 转换后的目标类型对象
     */
    @JvmStatic
    inline fun <reified D> convert(source: Any): D = getJsonApi().convert(source, object : JsonTypeReference<D>() {})

    /**
     * 将源对象转换为目标类型的对象，使用JsonTypeReference指定目标类型
     *
     * @param T 源对象的类型
     * @param D 目标对象的类型
     * @param source 需要转换的源对象
     * @param destinationType 目标对象的JsonTypeReference类型引用
     * @return 转换后的目标类型对象
     */
    @JvmStatic
    fun <D> convert(source: Any, destinationType: JsonTypeReference<D>): D =
        getJsonApi().convert(source, destinationType)

    /**
     * 添加JSON转换器到API中
     *
     * @param c 需要添加的JSON转换器实例
     */
    @JvmStatic
    fun addJsonConverter(c: BaseJsonConverter<*, *>) = getJsonApi().addJsonConverter(c)

    /**
     * 使用反射创建并添加指定类型的JSON转换器到API中
     *
     * @param T 继承自BaseJsonConverter的具体实现类
     */
    inline fun <reified T : BaseJsonConverter<*, *>> addJsonConverter() =
        addJsonConverter(T::class.java.newInstance())


    inline fun <reified T> String.parseJson() = parse<T>(this)
    inline fun <reified T> ByteArray.parseJson() = parse<T>(this)
    inline fun <reified T> InputStream.parseJson() = this.use { parse<T>(readBytes()) }
    inline fun <reified T> File.parseJson() = this.inputStream().parseJson<T>()
    inline fun <reified T> Path.parseJson() = this.toFile().inputStream().parseJson<T>()

    fun Any.toJson() = format(this)

    fun jacksonKotlinObjectMapper(): ObjectMapper = ObjectMapper().jacksonKotlinObjectMapper()
    fun ObjectMapper.jacksonKotlinObjectMapper(): ObjectMapper = this.registerModule(kotlinModule())
}
