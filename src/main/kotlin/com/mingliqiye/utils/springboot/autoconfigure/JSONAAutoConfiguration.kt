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
 * CurrentFile JSONAAutoConfiguration.kt
 * LastUpdate 2026-11-16 11:28:52
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean


@AutoConfiguration
@AutoConfigureAfter(name = ["com.mingliqiye.utils.springboot.autoconfigure.JacksonJsonApiAutoConfiguration", "com.mingliqiye.utils.springboot.autoconfigure.Jackson3JsonApiAutoConfiguration"])
@ConditionalOnBean(JsonApi::class)
open class JSONAAutoConfiguration(
	jsonApi: JsonApi,
) {
	val log = MingLiLoggerFactory.getLogger<JSONAAutoConfiguration>()

	init {
		JSONA.setJsonApi(jsonApi)
		log.info(
			"JSONA use {}", jsonApi.javaClass
		)
	}
}
