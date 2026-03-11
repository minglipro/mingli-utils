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
 * CurrentFile Jackson3JsonApiAutoConfiguration.kt
 * LastUpdate 2026-02-26 14:24:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.exception.JsonException
import com.mingliqiye.utils.json.Jackson3JsonApi
import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.base.JsonApi
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import tools.jackson.databind.json.JsonMapper

@ConditionalOnClass(name = ["tools.jackson.databind.json.JsonMapper", "org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration"])
@AutoConfigureAfter(name = ["com.mingliqiye.utils.springboot.autoconfigure.Jackson3AutoConfiguration"])
open class Jackson3JsonApiAutoConfiguration {
    private val logger = MingLiLoggerFactory.getLogger<Jackson3JsonApiAutoConfiguration>()

    @Bean
    @ConditionalOnMissingBean
    open fun jsonApi(jsonMapper: JsonMapper): JsonApi {
        return Jackson3JsonApi(
            get = { jsonMapper },
            set = { throw JsonException("JSON API set method is not allowed.") }).also {
            logger.info("JsonApi Bean Auto Configuration Success")
            try {
                JSONA.getJsonApi()
            } catch (_: NullPointerException) {
                JSONA.setJsonApi(it)
                logger.info(
                    "JSONA Using {}", it.javaClass.name
                )
            }
        }
    }
}
