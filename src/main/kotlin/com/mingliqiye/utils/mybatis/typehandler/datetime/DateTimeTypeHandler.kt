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
 * CurrentFile DateTimeTypeHandler.kt
 * LastUpdate 2026-01-07 19:23:12
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis.typehandler.datetime

import com.mingliqiye.utils.mybatis.CallType
import com.mingliqiye.utils.mybatis.QuickBaseTypeHandler
import com.mingliqiye.utils.mybatis.QuickBaseTypeHandlerValueGetter
import com.mingliqiye.utils.time.DateTime
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import java.sql.PreparedStatement
import java.sql.Timestamp

/**
 * DateTime类型处理器，用于在数据库和Java对象之间转换DateTime类型
 */
@MappedTypes(DateTime::class)
class DateTimeTypeHandler : QuickBaseTypeHandler<DateTime>() {

    override fun getValue(
        vg: QuickBaseTypeHandlerValueGetter,
        ct: CallType,
        ci: Int?,
        cn: String?
    ): DateTime {
        return DateTime.of(
            (when (ct) {
                CallType.RESULTSET_INDEX -> vg.resultSet!!.getTimestamp(ci!!)
                CallType.RESULTSET_NAME -> vg.resultSet!!.getTimestamp(cn!!)
                CallType.CALLABLE_STATEMENT_INDEX -> vg.callableStatement!!.getTimestamp(ci!!)
            })
        )
    }

    override fun setValue(
        ps: PreparedStatement,
        index: Int,
        parameter: DateTime,
        jdbcType: JdbcType?
    ) {
        ps.setTimestamp(index, Timestamp.valueOf(parameter.toLocalDateTime()))
    }
}
