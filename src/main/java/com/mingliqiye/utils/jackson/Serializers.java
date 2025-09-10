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
 * CurrentFile Serializers.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializers {

	/**
	 * 为ObjectMapper添加自定义序列化器 uuid time
	 * @see com.mingliqiye.utils.uuid.UUID
	 * @see com.mingliqiye.utils.time.DateTime
	 * @param objectMapper ObjectMapper实例，用于注册自定义序列化器
	 */
	public static void addSerializers(ObjectMapper objectMapper) {
		// 添加UUID相关的序列化器
		com.mingliqiye.utils.uuid.serialization.Jackson.addSerializers(
			objectMapper
		);
		// 添加时间相关的序列化器
		com.mingliqiye.utils.time.serialization.Jackson.addSerializers(
			objectMapper
		);
	}
}
