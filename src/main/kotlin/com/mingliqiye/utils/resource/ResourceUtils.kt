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
 * CurrentFile ResourceUtils.kt
 * LastUpdate 2025-09-20 10:26:47
 * UpdateUser MingLiPro
 */
package com.mingliqiye.utils.resource

import java.io.IOException

class ResourceUtils {
    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun getResource(resourceName: String): ByteArray {
            return getResource(resourceName, ResourceUtils::class.java)
        }

        @JvmStatic
        @Throws(IOException::class)
        fun getResource(resourceName: String, clazz: Class<*>): ByteArray {
            return clazz.getResourceAsStream(resourceName)?.use {
                it.readBytes()
            } ?: throw IOException("Resource not found: $resourceName")
        }


        @JvmStatic
        @Throws(IOException::class)
        fun getStringResource(resourceName: String): String {
            return getStringResource(resourceName, ResourceUtils::class.java)
        }


        @JvmStatic
        @Throws(IOException::class)
        fun getStringResource(resourceName: String, clazz: Class<*>): String {
            return clazz.getResourceAsStream(resourceName)?.use {
                it.readBytes().toString(charset = Charsets.UTF_8)
            } ?: throw IOException("Resource not found: $resourceName")
        }


        @JvmStatic
        @Throws(IOException::class)
        fun getStringResourceCallers(resourceName: String): String {
            return getStringResource(resourceName, getCallerClass())
        }

        @JvmStatic
        @Throws(IOException::class)
        fun getResourceCallers(resourceName: String): ByteArray {
            return getResource(resourceName, getCallerClass())
        }

        private fun getCallerClass(): Class<*> {
            val stackTrace = Thread.currentThread().stackTrace
            for (i in 2 until stackTrace.size) {
                val className = stackTrace[i].className
                try {
                    val clazz = Class.forName(className)
                    if (clazz != ResourceUtils::class.java && clazz != Companion::class.java) {
                        return clazz
                    }
                } catch (e: ClassNotFoundException) {
                    continue
                }
            }
            return ResourceUtils::class.java
        }
    }
}
