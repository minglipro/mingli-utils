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
 * CurrentFile MetaData.kt
 * LastUpdate 2025-09-20 10:45:43
 * UpdateUser MingLiPro
 */
@file:JvmName("MetaData")

package com.mingliqiye.utils.metadata

import com.mingliqiye.utils.resource.ResourceUtils
import java.util.stream.Collectors.toMap

fun getMetaData(): Map<String, String> {
    return ResourceUtils.getStringResource("/META-INF/meta-data").split("\n").stream().map {
        if (it.isBlank()) {
            return@map null
        }
        val split = it.split("=")
        if (split.size == 2) {
            split[0] to split[1]
        } else {
            return@map null
        }
    }.filter { it != null }.collect(toMap({ it!!.first }, { it!!.second }))
}

class MingliUtilsMetaData {
    var buildTime: String = ""
    var groupId: String = ""
    var artifactId: String = ""
    var version: String = ""
    var buildJdkVersion: String = ""
    var author: String = ""
    var website: String = ""
}

val mingliUtilsMetaData: MingliUtilsMetaData by lazy {
    val metaData = getMetaData()
    MingliUtilsMetaData().apply {
        buildTime = metaData["buildTime"] ?: ""
        groupId = metaData["groupId"] ?: ""
        artifactId = metaData["artifactId"] ?: ""
        version = metaData["version"] ?: ""
        buildJdkVersion = metaData["buildJdkVersion"] ?: ""
        author = metaData["author"] ?: ""
        website = metaData["website"] ?: ""
    }
}
