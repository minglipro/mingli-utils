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
 * CurrentFile Okhttp3AutoConfiguration.kt
 * LastUpdate 2026-02-27 17:40:32
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.EventListener

@AutoConfiguration
@ConditionalOnClass(name = ["okhttp3.OkHttpClient"])
open class Okhttp3AutoConfiguration {

    private var okHttpClient: okhttp3.OkHttpClient? = null

    val log: Logger = MingLiLoggerFactory.getLogger<Okhttp3AutoConfiguration>()

    @Autowired(required = false)
    open var userDefinedBuilder: okhttp3.OkHttpClient.Builder? = null

    open fun initOkHttpClient() {
        if (userDefinedBuilder == null) {
            okHttpClient = okhttp3.OkHttpClient()
        } else {
            userDefinedBuilder!!.build()
        }
    }

    @Bean
    open fun okHttpClient(): okhttp3.OkHttpClient {
        if (okHttpClient == null) {
            initOkHttpClient()
        }
        log.info("OkHttpClient initialized (using ${if (userDefinedBuilder != null) "user-defined" else "default"} builder)")
        return okHttpClient!!
    }


    @EventListener(ContextClosedEvent::class)
    open fun handleContextClosed() {
        if (okHttpClient != null) {
            log.info("Context closed, cleaning up OkHttpClient...")
            okHttpClient?.dispatcher?.executorService?.shutdown()
            okHttpClient?.connectionPool?.evictAll()
            okHttpClient?.dispatcher?.executorService?.shutdownNow()
        }
    }
}
