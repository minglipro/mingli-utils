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
 * CurrentFile JacksonJsonAutoConfiguration.kt
 * LastUpdate 2026-10-28 23:30:03
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.UUIDJsonConverter
import com.mingliqiye.utils.json.converters.base.getJacksonModule
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean

/**
 * Jackson 2 的序列化模块自动配置（过渡兼容）。
 *
 * 在类路径存在 Jackson 2（`com.fasterxml.jackson.databind.ObjectMapper`）
 * 及对应 Spring Boot 自动配置时生效，向容器注册用于追加 UUID / 日期时间
 * 模块的 [Jackson2ObjectMapperBuilderCustomizer]。
 *
 * ## 定位说明
 *
 * Spring Boot 4 起默认 JSON 库为 Jackson 3，Jackson 2 的自动配置已被弃用，
 * 仅用于迁移过渡，并计划在未来版本移除。本类只服务于仍在使用 Jackson 2 的场景，
 * 新项目应优先使用 Jackson 3 的对应配置。
 *
 * ## 类名注意
 *
 * 条件与排序中引用的自动配置类名需与目标 Spring Boot 版本一致。
 * Spring Boot 4 中 Jackson 2 的自动配置类位于 `spring-boot-jackson2` 模块
 * （包路径形如 `org.springframework.boot.jackson2.autoconfigure.Jackson2AutoConfiguration`）。
 * 若项目中引用的类名不存在，本配置会被整体跳过而不报错，需自行核对。
 *
 * ## Bean 命名
 *
 * 与 Jackson 3 配置中的定制器 Bean 名称刻意区分（后缀 `2`），
 * 避免两套配置同时生效时发生名称冲突。
 *
 * @see Jackson2ObjectMapperBuilderCustomizer
 */
@ConditionalOnClass(name = ["com.fasterxml.jackson.databind.ObjectMapper", "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration"])
@AutoConfigureAfter(name = ["org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration"])
open class JacksonJsonAutoConfiguration {

    companion object {
        private val log = MingLiLoggerFactory.getLogger<JacksonJsonAutoConfiguration>()
    }

    @Bean("DateTimeJsonConverterJackson2ObjectMapperBuilderCustomizer")
    @ConditionalOnMissingBean(name = ["DateTimeJsonConverterJackson2ObjectMapperBuilderCustomizer"])
    fun getDateTimeJsonConverterJackson2ObjectMapperBuilderCustomizer() = Jackson2ObjectMapperBuilderCustomizer {
        log.info(
            "MingliUtils Jackson2 DateTime Serializers created"
        )
        it.modulesToInstall { modules ->
            modules.add(DateTimeJsonConverter.getJsonConverter().getJacksonModule())
        }
    }

    @Bean("UUIDJsonConverterJackson2ObjectMapperBuilderCustomizer")
    @ConditionalOnMissingBean(name = ["UUIDJsonConverterJackson2ObjectMapperBuilderCustomizer"])
    fun getUUIDJsonConverterJackson2ObjectMapperBuilderCustomizer() = Jackson2ObjectMapperBuilderCustomizer {
        log.info(
            "MingliUtils Jackson2 UUID Serializers created"
        )
        it.modulesToInstall { modules ->
            modules.add(UUIDJsonConverter.getJsonConverter().getJacksonModule())
        }
    }

}
