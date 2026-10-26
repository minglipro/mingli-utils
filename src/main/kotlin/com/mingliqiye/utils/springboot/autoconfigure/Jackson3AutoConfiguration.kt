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
 * ProjectName FastBaseMapper.kt
 * ModuleName mingli-utils.main
 * CurrentFile Jackson3AutoConfiguration.kt
 * LastUpdate 2026-10-26 23:22:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure;

import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.UUIDJsonConverter
import com.mingliqiye.utils.json.converters.base.getJackson3Module
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer
import org.springframework.context.annotation.Bean

@ConditionalOnClass(name = ["tools.jackson.databind.json.JsonMapper", "org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration"])
@AutoConfigureAfter(name = ["org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration"])
open class Jackson3AutoConfiguration {

    private val logger = MingLiLoggerFactory.getLogger<Jackson3AutoConfiguration>()

    /**
     * 注册 UUID 的 Jackson 3 序列化/反序列化模块。
     *
     * 如需替换 UUID 处理逻辑，注册名为 [UUIDJsonConverterJsonMapperCustomizer]
     * 的 [JsonMapperBuilderCustomizer] Bean 即可，本 Bean 将自动跳过。
     */
    @Bean("UUIDJsonConverterJsonMapperCustomizer")
    @ConditionalOnMissingBean(name = ["UUIDJsonConverterJsonMapperCustomizer"])
    open fun getUUIDJsonConverterJsonMapperCustomizer(): JsonMapperBuilderCustomizer {
        return JsonMapperBuilderCustomizer { builder ->
            builder.addModule(UUIDJsonConverter.getJsonConverter().getJackson3Module())
        }.also {
            logger.info("MingliUtils Jackson3 UUID Serializers created")
        }
    }

    /**
     * 注册日期时间的 Jackson 3 序列化/反序列化模块。
     *
     * 如需替换日期时间处理逻辑，注册名为 [DateTimeJsonConverterJsonMapperCustomizer]
     * 的 [JsonMapperBuilderCustomizer] Bean 即可，本 Bean 将自动跳过。
     */
    @Bean("DateTimeJsonConverterJsonMapperCustomizer")
    @ConditionalOnMissingBean(name = ["DateTimeJsonConverterJsonMapperCustomizer"])
    open fun getDateTimeJsonConverterJsonMapperCustomizer(): JsonMapperBuilderCustomizer {
        return JsonMapperBuilderCustomizer { builder ->
            builder.addModule(DateTimeJsonConverter.getJsonConverter().getJackson3Module())
        }.also {
            logger.info("MingliUtils Jackson3 DateTime Serializers created")
        }
    }
}
