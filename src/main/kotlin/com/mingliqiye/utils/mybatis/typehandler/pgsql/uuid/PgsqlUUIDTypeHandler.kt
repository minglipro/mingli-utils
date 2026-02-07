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
 * CurrentFile PgsqlUUIDTypeHandler.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis.typehandler.pgsql.uuid

import com.mingliqiye.utils.mybatis.CallType
import com.mingliqiye.utils.mybatis.QuickBaseTypeHandler
import com.mingliqiye.utils.mybatis.QuickBaseTypeHandlerValueGetter
import com.mingliqiye.utils.uuid.UUID
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import java.sql.PreparedStatement

@MappedTypes(UUID::class)
class PgsqlUUIDTypeHandler : QuickBaseTypeHandler<UUID>() {
    override fun getValue(
        vg: QuickBaseTypeHandlerValueGetter, ct: CallType, ci: Int?, cn: String?
    ): UUID? {
        val data: String? = when (ct) {
            CallType.RESULTSET_INDEX ->
                vg.resultSet!!.getString(ci!!)

            CallType.RESULTSET_NAME ->
                vg.resultSet!!.getString(cn)

            CallType.CALLABLE_STATEMENT_INDEX ->
                vg.callableStatement!!.getString(cn)
        }
        if (data == null) {
            return null
        }
        return UUID.of(data)
    }

    override fun setValue(
        ps: PreparedStatement, index: Int, parameter: UUID?, jdbcType: JdbcType?
    ) {
        if (parameter == null) {
            ps.setNull(index, jdbcType?.TYPE_CODE ?: JdbcType.JAVA_OBJECT.TYPE_CODE)
            return
        }
        ps.setObject(index, parameter.getUuid())
    }
}
