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
 * CurrentFile Converters.kt
 * LastUpdate 2025-09-15 09:19:48
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.converters

import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.Formatter
import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.UUID.Companion.of
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class DateTimeToStringConverter : Converter<DateTime, String?> {
    override fun convert(source: DateTime): String {
        return source.format(Formatter.STANDARD_DATETIME)
    }
}

@Component
class UUIDToStringConverter : Converter<UUID, String> {
    override fun convert(source: UUID): String {
        return source.getString()
    }
}

@Component
class StringToDateTimeConverter : Converter<String, DateTime> {
    override fun convert(source: String): DateTime {
        return DateTime.parse(source, Formatter.STANDARD_DATETIME_MILLISECOUND7, true)
    }
}

@Component
class StringToUUIDConverter : Converter<String, UUID> {
    override fun convert(source: String): UUID {
        return of(source)
    }
}
