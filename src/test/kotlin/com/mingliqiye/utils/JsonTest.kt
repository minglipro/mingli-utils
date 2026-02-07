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
 * CurrentFile JsonTest.kt
 * LastUpdate 2026-02-08 02:29:27
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.mingliqiye.utils.annotation.UUIDJsonFormat
import com.mingliqiye.utils.array.toHexString
import com.mingliqiye.utils.base.BaseType
import com.mingliqiye.utils.io.IO.println
import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.JacksonJsonApi
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.UUIDJsonConverter
import com.mingliqiye.utils.json.converters.base.JackSonJsonConverter.Companion.addJsonConverter
import com.mingliqiye.utils.json.converters.base.getJsonConverter
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.string.formatd
import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.UUIDFormatType
import com.mingliqiye.utils.uuid.mysqlToUuid
import com.mingliqiye.utils.uuid.uuidToMysql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JsonTest {
    @Test
    fun testJSONA() {

        JSONA.setJsonApi(
            JacksonJsonApi(
                JSONA.jacksonKotlinObjectMapper()
            )
        )
        JSONA.addJsonConverter<UUIDJsonConverter>()
        JSONA.addJsonConverter<DateTimeJsonConverter>()

        "{} {} {} {}".formatd("0", 1).println()
    }

    @Test
    fun testBANNER() {
        val log = MingLiLoggerFactory.getLogger<JsonTest>()
        com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration.printBanner()
    }

    @Test
    fun testMysqld() {
        val v = UUID.of("c3efb797-0323-11f1-8791-3aff070ec47d")
        val ba = uuidToMysql(v.toBytes())
        val ca = mysqlToUuid(ba)
        assertEquals(
            "11F10323C3EFB79787913AFF070EC47D",
            ba.toHexString().println()
        )
        assertEquals(
            "C3EFB797032311F187913AFF070EC47D",
            ca.toHexString().println()
        )
    }

    @Test
    fun testGson2() {
        getJsonConverter<UUIDJsonConverter>()
        getJsonConverter<DateTimeJsonConverter>()
    }

    @Test
    fun testGson() {

        val obm = jacksonObjectMapper()
            .addJsonConverter<UUIDJsonConverter>()
            .addJsonConverter<DateTimeJsonConverter>()

        obm.readValue<AC<CC<ZZ<UUID>>>>(
            obm.writeValueAsString(
                AC(c = CC(b = ZZ(b = UUID.getV7())))
            ).println()
        ).println()
    }
}

data class AC<T>(
    var a: String = "AC",
    @field:UUIDJsonFormat(
        base = BaseType.BASE256,
        value = UUIDFormatType.UPPER_NO_SPACE
    )
    var uuid: UUID = UUID.getV4(),
    var b: BC = BC(),
    var c: T
)

data class BC(
    var a: String = "BC",
)

data class CC<T>(
    var a: String = "BC",
    var b: T
)


data class ZZ<T>(
    var a: String = "ZZ",
    @field:UUIDJsonFormat(
        base = BaseType.BASE256,
        value = UUIDFormatType.UPPER_NO_SPACE
    )
    var b: T
)
