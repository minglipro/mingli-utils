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
 * ModuleName mingli-utils.test
 * CurrentFile TestJson.kt
 * LastUpdate 2026-11-17 20:17:51
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.logger.Loggers
import com.mingliqiye.utils.io.SIO.println
import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.Jackson3JsonApi
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.base.getJackson3Module
import com.mingliqiye.utils.time.DateTime
import org.junit.jupiter.api.Test
import tools.jackson.module.kotlin.jsonMapper
import tools.jackson.module.kotlin.kotlinModule


/**
 * JSON API 集成测试，覆盖 Jackson3 与 DateTime 转换器的序列化/反序列化
 */
class TestJson {


	private val log = Loggers.getLogger<TestJson>()

	/** 测试配置 Jackson3 API 后 DateTime 的格式化与解析往返 */
	@Test
	fun test() {
		JSONA.setJsonApi(
			Jackson3JsonApi(
				jsonMapper {
					addModule(kotlinModule {})
					addModules(
						DateTimeJsonConverter().getJackson3Module()
					)
				}
			))

		JSONA.parse<DateTime>(JSONA.format(DateTime.now())).println()
	}
}
