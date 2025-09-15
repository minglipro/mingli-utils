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
 * CurrentFile GsonJsonApi.kt
 * LastUpdate 2025-09-15 22:07:43
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json

import com.google.gson.*
import com.mingliqiye.utils.json.converters.JsonConverter
import com.mingliqiye.utils.json.converters.JsonStringConverter

class GsonJsonApi : JsonApi {

    private var gsonUnicode: Gson
    private var gsonPretty: Gson
    private var gsonPrettyUnicode: Gson
    private var gson: Gson

    constructor() {
        gson = GsonBuilder()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create()

        gsonUnicode = GsonBuilder()
            .disableHtmlEscaping()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create()

        gsonPretty = GsonBuilder()
            .setPrettyPrinting()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create()

        gsonPrettyUnicode = GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create()
    }

    constructor(gson: Gson) {
        this.gson = gson
            .newBuilder()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create()
        this.gsonUnicode = gson
            .newBuilder()
            .disableHtmlEscaping()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create()
        this.gsonPretty = gson
            .newBuilder()
            .setPrettyPrinting()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create()
        this.gsonPrettyUnicode = gson
            .newBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create()
    }

    override fun <T> parse(json: String, clazz: Class<T>): T {
        return gson.fromJson(json, clazz)
    }

    override fun <T> parse(json: String, type: JsonTypeReference<T>): T {
        return gson.fromJson(json, type.type)
    }

    override fun format(obj: Any): String {
        return gson.toJson(obj)
    }

    override fun formatUnicode(obj: Any): String {
        return gsonUnicode.toJson(obj)
    }

    override fun formatPretty(obj: Any): String {
        return gsonPretty.toJson(obj)
    }

    override fun formatPrettyUnicode(obj: Any): String {
        return gsonPrettyUnicode.toJson(obj)
    }

    override fun isValidJson(json: String): Boolean {
        return try {
            JsonParser.parseString(json)
            true
        } catch (e: JsonSyntaxException) {
            false
        } catch (e: Exception) {
            false
        }
    }

    override fun merge(vararg jsons: String): String {
        val merged = JsonObject()
        for (json in jsons) {
            if (json.isNullOrEmpty()) {
                continue
            }
            try {
                val obj = JsonParser.parseString(json).asJsonObject
                for (key in obj.keySet()) {
                    merged.add(key, obj.get(key))
                }
            } catch (e: Exception) {
                // 忽略无效的 JSON 字符串
            }
        }
        return gson.toJson(merged)
    }

    override fun getNodeValue(json: String, path: String): String? {
        return try {
            var element = JsonParser.parseString(json)
            val paths = path.split("\\.".toRegex()).toTypedArray()
            var current = element

            for (p in paths) {
                if (current.isJsonObject) {
                    current = current.asJsonObject.get(p)
                } else {
                    return null
                }

                if (current == null) {
                    return null
                }
            }

            if (current.isJsonPrimitive) current.asString else current.toString()
        } catch (e: Exception) {
            null
        }
    }

    override fun updateNodeValue(json: String, path: String, newValue: Any): String {
        return try {
            val obj = JsonParser.parseString(json).asJsonObject
            val paths = path.split("\\.".toRegex()).toTypedArray()
            var current = obj

            // 导航到倒数第二层
            for (i in 0 until paths.size - 1) {
                val p = paths[i]
                if (!current.has(p) || !current.get(p).isJsonObject) {
                    current.add(p, JsonObject())
                }
                current = current.getAsJsonObject(p)
            }

            // 设置最后一层的值
            val lastPath = paths[paths.size - 1]
            val element = gson.toJsonTree(newValue)
            current.add(lastPath, element)

            gson.toJson(obj)
        } catch (e: Exception) {
            json
        }
    }

    override fun <T, D> convert(source: T, destinationClass: Class<D>): D {
        val json = gson.toJson(source)
        return gson.fromJson(json, destinationClass)
    }

    override fun <T, D> convert(source: T, destinationType: JsonTypeReference<D>): D {
        val json = gson.toJson(source)
        return gson.fromJson(json, destinationType.type)
    }

    override fun addJsonConverter(c: JsonConverter<*, *>) {
        c.getStringConverter()?.let {
            gson = gson
                .newBuilder()
                .registerTypeAdapter(
                    it.tClass,
                    it.gsonJsonStringConverterAdapter
                )
                .create()
            gsonUnicode = gsonUnicode
                .newBuilder()
                .registerTypeAdapter(
                    it.tClass,
                    it.gsonJsonStringConverterAdapter
                )
                .create()
            gsonPretty = gsonPretty
                .newBuilder()
                .registerTypeAdapter(
                    it.tClass,
                    it.gsonJsonStringConverterAdapter
                )
                .create()
            gsonPrettyUnicode = gsonPrettyUnicode
                .newBuilder()
                .registerTypeAdapter(
                    it.tClass,
                    it.gsonJsonStringConverterAdapter
                )
                .create()
        }

    }

    override fun addJsonStringConverter(c: JsonStringConverter<*>) {
        addJsonConverter(c)
    }
}
