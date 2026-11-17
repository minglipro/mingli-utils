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
 * CurrentFile MetaData.kt
 * LastUpdate 2026-05-22 13:27:28
 * UpdateUser MingLiPro
 */
@file:JvmName("MetaData")

package com.mingliqiye.utils.metadata

import com.mingliqiye.utils.resource.ResourceUtils
import java.util.stream.Collectors.toMap

/**
 * 元数据资源定位锚点类，仅用于定位 `/META-INF/meta-data` 资源所在的类加载器
 */
class MetaDataResource

/**
 * 读取并解析 `/META-INF/meta-data` 资源文件
 *
 * 文件内容按行解析为 `key=value` 形式的键值对，空行与格式不合法的行会被忽略。
 *
 * @return 元数据键值对映射
 */
fun getMetaData(): Map<String, String> {
	return ResourceUtils.getResourceAsString<MetaDataResource>("/META-INF/meta-data").split("\n").stream().map {
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

/**
 * mingli-utils 库的构建元数据，延迟初始化
 *
 * 从 `/META-INF/meta-data` 资源解析并填充 [MingliUtilsMetaData]，缺失的字段以空字符串代替。
 */
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
