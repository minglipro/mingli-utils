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
 * CurrentFile DateTimeToStringConverter.kt
 * LastUpdate 2026-02-04 21:57:43
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.converters

import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.Formatter
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class DateTimeToStringConverter : Converter<DateTime, String?> {
    override fun convert(source: DateTime): String {
        return source.format(Formatter.STANDARD_DATETIME)
    }
}
