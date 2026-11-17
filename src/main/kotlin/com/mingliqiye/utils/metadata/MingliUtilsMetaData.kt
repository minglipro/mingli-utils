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
 * CurrentFile MingliUtilsMetaData.kt
 * LastUpdate 2026-10-12 13:32:30
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.metadata

/**
 * mingli-utils 库的构建元数据数据类
 *
 * @property buildTime 构建时间
 * @property groupId 构建产物的 GroupId
 * @property artifactId 构建产物的 ArtifactId
 * @property version 库版本号
 * @property buildJdkVersion 构建所使用的 JDK 版本
 * @property author 作者
 * @property website 项目网站地址
 */
data class MingliUtilsMetaData(
	var buildTime: String = "",
	var groupId: String = "",
	var artifactId: String = "",
	var version: String = "",
	var buildJdkVersion: String = "",
	var author: String = "",
	var website: String = "",
)
