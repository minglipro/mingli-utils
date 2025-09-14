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
 * CurrentFile GsonAutoConfiguration.kt
 * LastUpdate 2025-09-14 22:06:47
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mingliqiye.utils.json.GsonJsonApi
import com.mingliqiye.utils.json.JsonApi
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.JsonStringConverter
import com.mingliqiye.utils.json.converters.UUIDJsonStringConverter
import com.mingliqiye.utils.logger.mingLiLoggerFactory
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.uuid.UUID
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer
import org.springframework.context.annotation.Bean

@ConditionalOnClass(Gson::class)
@AutoConfiguration
@AutoConfigureAfter(
    name = ["org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration",
        "com.mingliqiye.utils.springboot.autoconfigure.JacksonAutoConfiguration"]
)
open class GsonAutoConfiguration {
    companion object {
        private val log: Logger = LoggerFactory.getLogger("MingliUtils-GsonAutoConfiguration")

        fun addTypeAdapter(gsonBuilder: GsonBuilder): GsonBuilder {
            val dateTimeJsonConverter: JsonStringConverter<DateTime> = DateTimeJsonConverter()
            val uuidJsonStringConverter: JsonStringConverter<UUID> = UUIDJsonStringConverter()

            try {
                return gsonBuilder
                    .registerTypeAdapter(
                        uuidJsonStringConverter.getTClass(),
                        dateTimeJsonConverter
                            .getGsonJsonStringConverterAdapter()
                            .getGsonTypeAdapter()
                    )
                    .registerTypeAdapter(
                        dateTimeJsonConverter.getTClass(),
                        dateTimeJsonConverter
                            .getGsonJsonStringConverterAdapter()
                            .getGsonTypeAdapter()
                    )
            } finally {
                log.info("MingliUtils GsonBuilder TypeAdapter add")
            }
        }
    }

    private val log: Logger = mingLiLoggerFactory.getLogger("MingliUtils-GsonAutoConfiguration")

    @Bean
    open fun mingliGsonCustomizer(): GsonBuilderCustomizer {
        return GsonBuilderCustomizer { gsonBuilder: GsonBuilder -> addTypeAdapter(gsonBuilder) }
    }

    @Bean
    @ConditionalOnMissingBean
    open fun jsonApi(gson: Gson): JsonApi {
        log.info("MingliUtils-JsonApiAutoConfiguration: GsonJsonApi bean is created.")
        return GsonJsonApi(gson)
    }
}
