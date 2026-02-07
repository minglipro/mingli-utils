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
 * CurrentFile Internationalization.kt
 * LastUpdate 2026-02-06 08:47:26
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.i18n

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.slf4j.Logger
import java.net.URL
import java.util.*

class Internationalization {
    var clazz: Class<*>
    var objectMapper: ObjectMapper
    var locale: Locale
    var backLocale: Locale
    val langPath: String
    val thisName: String
    val thisBackName: String
    private var log: Logger = MingLiLoggerFactory.getLogger<Internationalization>()


    constructor(
        clazz: Class<*>,
        objectMapper: ObjectMapper,
        locale: Locale = Locale.getDefault(),
        backLocale: Locale = Locale.US,
        langPath: String = "/lang",
        isloadSlef: Boolean = false
    ) {
        this.clazz = clazz
        this.objectMapper = objectMapper
        this.locale = locale
        this.backLocale = backLocale
        this.langPath = langPath
        thisName = getLanguageName(locale)
        thisBackName = getLanguageName(backLocale)
        readJson("/assets/mingli-utils/lang/${thisName}.json", Internationalization::class.java, thisName)
        if (!isloadSlef) {
            if (!readJson(fileName = "$langPath/${thisName}.json", lang = thisName)) {
                log.warn(getString("com.mingliqiye.utils.i18n.readjson.error", "$langPath/${thisName}.json"))
            }
        }
        if (thisName != thisBackName) {
            readJson("/assets/mingli-utils/lang/${thisBackName}.json", Internationalization::class.java, thisBackName)
            if (!isloadSlef) {
                if (!readJson(fileName = "$langPath/${thisBackName}.json", lang = thisBackName)) {
                    log.warn(getString("com.mingliqiye.utils.i18n.readjson.error", "$langPath/${thisBackName}.json"))
                }
            }
        }
    }

    fun getString(string: String, vararg any: Any): String {
        return getString(string).format(*any)
    }

    fun getString(string: String): String {
        return getKeyString(string)
    }

    fun getKeyString(key: String): String {
        val s = localesData[thisName]?.get(key) ?: localesData[thisBackName]?.get(key)
        if (s == null) {
            return key
        }
        return s
    }

    fun getLanguageName(locale: Locale): String =
        if (locale.country == null || locale.language == null) locale.country + locale.language else locale.language + '_' + locale.country

    constructor(
        clazz: Class<*>,
        objectMapper: ObjectMapper,
    ) : this(
        locale = Locale.getDefault(), clazz = clazz, objectMapper = objectMapper
    )

    constructor(
        clazz: Class<*>, objectMapper: ObjectMapper, langPath: String = "/lang"
    ) : this(
        locale = Locale.getDefault(), clazz = clazz, langPath = langPath, objectMapper = objectMapper
    )

    val localesData: MutableMap<String, MutableMap<String, String>> = mutableMapOf()

    fun getlangFile(
        clazzd: Class<*>, fileName: String
    ): URL? {
        return clazzd.getResource(fileName)
    }

    fun readJson(
        fileName: String, clazzd: Class<*> = clazz, lang: String
    ): Boolean {
        val byteArray: ByteArray? = getlangFile(clazzd, fileName)?.openStream()?.use { it.readBytes() }
        if (byteArray == null) return false
        val node: JsonNode = objectMapper.readTree(byteArray)
        if (node.isArray) return false
        if (node.isEmpty) return false
        var m = localesData[lang]
        if (m == null) {
            m = mutableMapOf()
            localesData[lang] = m
        }
        readJsonNode(node, "", m)
        return true
    }

    fun readJsonNode(node: JsonNode, path: String, map: MutableMap<String, String>) {
        val fields = node.properties().iterator()
        while (fields.hasNext()) {
            val (k, v) = fields.next()
            val pathName = if (path.isEmpty()) path + k else "$path.$k"
            if (v.isTextual) {
                map[pathName] = v.asText()
            } else if (v.isObject) {
                readJsonNode(v, pathName, map)
            }
        }
    }

}
