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

/**
 * PostgreSQL 的 UUID 类型处理器。
 * 将 [UUID] 与 PostgreSQL 原生 uuid 列互转：读取时以字符串形式取出并解析为 [UUID]，
 * 写入时通过 setObject 传入 java.util.UUID，由驱动按 uuid 类型处理。
 */
@MappedTypes(UUID::class)
class PgsqlUUIDTypeHandler : QuickBaseTypeHandler<UUID>() {
	/**
	 * 从 JDBC 数据源读取 UUID 字符串并解析为 [UUID]，数据库值为 null 时返回 null。
	 */
	override fun getValue(
		vg: QuickBaseTypeHandlerValueGetter, ct: CallType, ci: Int?, cn: String?,
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

	/**
	 * 将 [UUID] 以 java.util.UUID 对象写入 PreparedStatement，参数为 null 时按指定 JDBC 类型（默认 JAVA_OBJECT）写入 NULL。
	 */
	override fun setValue(
		ps: PreparedStatement, index: Int, parameter: UUID?, jdbcType: JdbcType?,
	) {
		if (parameter == null) {
			ps.setNull(index, jdbcType?.TYPE_CODE ?: JdbcType.JAVA_OBJECT.TYPE_CODE)
			return
		}
		ps.setObject(index, parameter.getUuid())
	}
}
