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
 * CurrentFile JacksonAutoConfiguration.kt
 * LastUpdate 2025-09-14 22:10:08
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.fasterxml.jackson.databind.ObjectMapper
import com.mingliqiye.utils.json.JacksonJsonApi
import com.mingliqiye.utils.json.JsonApi
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.UUIDJsonStringConverter
import com.mingliqiye.utils.logger.mingLiLoggerFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@ConditionalOnClass(ObjectMapper::class)
@AutoConfiguration
@AutoConfigureAfter(org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration::class)
open class JacksonAutoConfiguration(objectMapper: ObjectMapper) {
    companion object {
        private val log: Logger = mingLiLoggerFactory.getLogger("MingliUtils-JacksonAutoConfiguration")

        fun addModules(objectMapper: ObjectMapper): ObjectMapper {
            return objectMapper
                .registerModule(
                    DateTimeJsonConverter()
                        .jacksonJsonStringConverterAdapter
                        .getJacksonModule()
                )
                .registerModule(
                    UUIDJsonStringConverter()
                        .jacksonJsonStringConverterAdapter
                        .getJacksonModule()
                )
        }
    }

    private val log: Logger = LoggerFactory.getLogger("MingliUtils-JacksonAutoConfiguration")

    init {
        addModules(objectMapper)
        log.info("MingliUtils Jackson Serializers created")
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean
    open fun jsonApi(objectMapper: ObjectMapper): JsonApi {
        log.info("MingliUtils-JsonApiAutoConfiguration: JacksonJsonApi bean is created.")
        return JacksonJsonApi(objectMapper)
    }
}
