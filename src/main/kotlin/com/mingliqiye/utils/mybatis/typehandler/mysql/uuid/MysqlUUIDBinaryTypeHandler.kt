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
 * CurrentFile MysqlUUIDBinaryTypeHandler.kt
 * LastUpdate 2026-01-07 19:30:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis.typehandler.mysql.uuid

import com.mingliqiye.utils.mybatis.CallType
import com.mingliqiye.utils.mybatis.QuickBaseTypeHandler
import com.mingliqiye.utils.mybatis.QuickBaseTypeHandlerValueGetter
import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.mysqlToUuid
import com.mingliqiye.utils.uuid.uuidToMysql
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import java.sql.PreparedStatement

@MappedTypes(UUID::class)
class MysqlUUIDBinaryTypeHandler : QuickBaseTypeHandler<UUID>() {

    companion object {
        /**
         * 将字节数组转换为UUID对象
         *
         * @param byteArray 字节数组
         * @return UUID对象，如果字节数组为null则返回null
         */
        private fun toUUID(byteArray: ByteArray?): UUID? {
            return byteArray?.let { UUID.of(mysqlToUuid(it)) }
        }

        /**
         * 将UUID对象转换为字节数组
         *
         * @param uuid UUID对象
         * @return 字节数组，如果UUID为null则返回null
         */
        fun toByteArray(uuid: UUID?): ByteArray? {
            return uuid?.let { uuidToMysql(it.toBytes()) }
        }
    }

    override fun getValue(
        vg: QuickBaseTypeHandlerValueGetter, ct: CallType, ci: Int?, cn: String?
    ): UUID {
        return toUUID(
            when (ct) {
                CallType.RESULTSET_NAME -> vg.resultSet!!.getBytes(cn!!)
                CallType.RESULTSET_INDEX -> vg.resultSet!!.getBytes(ci!!)
                CallType.CALLABLE_STATEMENT_INDEX -> vg.resultSet!!.getBytes(ci!!)
            }
        )!!
    }

    override fun setValue(
        ps: PreparedStatement, index: Int, parameter: UUID, jdbcType: JdbcType?
    ) {
        ps.setBytes(index, toByteArray(parameter))
    }

}
