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
 * LastUpdate 2026-02-05 11:09:16
 * UpdateUser MingLiPro
 */
package com.mingliqiye.utils.resource

import java.io.IOException

/**
 * 工具类，用于从类路径中加载资源文件。
 */
object ResourceUtils {

    /**
     * 从默认类路径中加载指定名称的资源文件，并以字节数组形式返回。
     *
     * @param resourceName 资源文件的名称（相对于类路径根目录）。
     * @return 资源文件的内容作为字节数组。
     * @throws IOException 如果资源未找到或读取失败时抛出。
     */
    @JvmStatic
    @Throws(IOException::class)
    fun getResource(resourceName: String): ByteArray {
        return getResource(resourceName, ResourceUtils::class.java)
    }

    /**
     * 从指定类的类路径中加载指定名称的资源文件，并以字节数组形式返回。
     *
     * @param resourceName 资源文件的名称（相对于类路径根目录）。
     * @param clazz 用于定位资源的类。
     * @return 资源文件的内容作为字节数组。
     * @throws IOException 如果资源未找到或读取失败时抛出。
     */
    @JvmStatic
    @Throws(IOException::class)
    fun getResource(resourceName: String, clazz: Class<*>): ByteArray {
        return clazz.getResourceAsStream(resourceName)?.use {
            it.readBytes()
        } ?: throw IOException("Resource not found: $resourceName")
    }

    /**
     * 从默认类路径中加载指定名称的资源文件，并以字符串形式返回。
     *
     * @param resourceName 资源文件的名称（相对于类路径根目录）。
     * @return 资源文件的内容作为字符串（使用UTF-8编码）。
     * @throws IOException 如果资源未找到或读取失败时抛出。
     */
    @JvmStatic
    @Throws(IOException::class)
    fun getStringResource(resourceName: String): String {
        return getStringResource(resourceName, ResourceUtils::class.java)
    }

    /**
     * 从指定类的类路径中加载指定名称的资源文件，并以字符串形式返回。
     *
     * @param resourceName 资源文件的名称（相对于类路径根目录）。
     * @param clazz 用于定位资源的类。
     * @return 资源文件的内容作为字符串（使用UTF-8编码）。
     * @throws IOException 如果资源未找到或读取失败时抛出。
     */
    @JvmStatic
    @Throws(IOException::class)
    fun getStringResource(resourceName: String, clazz: Class<*>): String {
        return clazz.getResourceAsStream(resourceName)?.use {
            it.readBytes().toString(charset = Charsets.UTF_8)
        } ?: throw IOException("Resource not found: $resourceName")
    }

    /**
     * 从调用者的类路径中加载指定名称的资源文件，并以字符串形式返回。
     *
     * @param resourceName 资源文件的名称（相对于类路径根目录）。
     * @return 资源文件的内容作为字符串（使用UTF-8编码）。
     * @throws IOException 如果资源未找到或读取失败时抛出。
     */
    @JvmStatic
    @Throws(IOException::class)
    fun getStringResourceCallers(resourceName: String): String {
        return getStringResource(resourceName, getCallerClass())
    }

    /**
     * 从调用者的类路径中加载指定名称的资源文件，并以字节数组形式返回。
     *
     * @param resourceName 资源文件的名称（相对于类路径根目录）。
     * @return 资源文件的内容作为字节数组。
     * @throws IOException 如果资源未找到或读取失败时抛出。
     */
    @JvmStatic
    @Throws(IOException::class)
    fun getResourceCallers(resourceName: String): ByteArray {
        return getResource(resourceName, getCallerClass())
    }

    /**
     * 获取当前调用栈中第一个非ResourceUtils类的调用者类。
     *
     * @return 调用者类对象；如果未找到则返回ResourceUtils类本身。
     */
    private fun getCallerClass(): Class<*> {
        val stackTrace = Thread.currentThread().stackTrace
        for (i in 2 until stackTrace.size) {
            val className = stackTrace[i].className
            try {
                val clazz = Class.forName(className)
                if (clazz != ResourceUtils::class.java) {
                    return clazz
                }
            } catch (e: ClassNotFoundException) {
                continue
            }
        }
        return ResourceUtils::class.java
    }
}
