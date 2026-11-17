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
 * CurrentFile JacksonJsonBuilderImpl.kt
 * LastUpdate 2026-11-17 20:09:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure.builder

import com.mingliqiye.utils.json.converters.base.BaseJsonConverter

open class JacksonJsonBuilderImpl : JacksonJsonBuilder() {
	override fun addJsonConverter(jsonConverter: BaseJsonConverter<*>): JacksonJsonBuilderImpl {
		data.add(jsonConverter)
		return this
	}

	override fun addJsonConverters(vararg jsonConverters: BaseJsonConverter<*>): JacksonJsonBuilder {
		data.addAll(jsonConverters)
		return this
	}

	private val data = mutableListOf<BaseJsonConverter<*>>()

	fun getData(): List<BaseJsonConverter<*>> {
		return data.toList()
	}

}
