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
 * LastUpdate 2026-02-05 10:57:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.base.BaseType
import com.mingliqiye.utils.io.IO.println
import com.mingliqiye.utils.json.api.JSONA
import com.mingliqiye.utils.json.api.JacksonJsonApi
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.UUIDJsonConverter
import com.mingliqiye.utils.string.formatd
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.DateTimeJsonFormat
import com.mingliqiye.utils.time.Formatter
import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.UUIDFormatType
import com.mingliqiye.utils.uuid.UUIDJsonFormat
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
        com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration.printBanner()
    }
}

data class AC<T>(
    var a: String = "AC",
    @field:DateTimeJsonFormat(Formatter.ISO8601, repcZero = false)
    var time: DateTime = DateTime.now(),
    @field:UUIDJsonFormat(
        base = BaseType.BASE256,
        value = UUIDFormatType.UPPER_NO_SPACE
    )
    var uuid: UUID = UUID.getV4(),
    var b: T
)

data class BC<T>(
    var a: String = "BC",
    var b: T
)

data class CC<T>(
    var a: String = "BC",
    var b: T
)
