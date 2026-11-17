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
 * LastUpdate 2026-01-28 10:08:46
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

/**
 * MySQL 的 UUID 二进制类型处理器。
 * 将 [UUID] 与 MySQL BINARY(16) 列互转，写入前按 MySQL 的字节序重排（[uuidToMysql]），
 * 读取后再还原为标准 UUID 字节序（[mysqlToUuid]），以便 UUID 在数据库中按时间有序存储。
 */
@MappedTypes(UUID::class)
class MysqlUUIDBinaryTypeHandler : QuickBaseTypeHandler<UUID>() {

	/**
	 * 伴生对象，提供 UUID 与 MySQL 二进制字节数组之间的转换工具方法。
	 */
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

	/**
	 * 从 JDBC 数据源读取字节数组，按 MySQL 字节序还原为 [UUID]，数据库值为 null 时返回 null。
	 */
	override fun getValue(
		vg: QuickBaseTypeHandlerValueGetter, ct: CallType, ci: Int?, cn: String?,
	): UUID? {

		val data: ByteArray? = when (ct) {
			CallType.RESULTSET_NAME -> vg.resultSet!!.getBytes(cn!!)
			CallType.RESULTSET_INDEX -> vg.resultSet!!.getBytes(ci!!)
			CallType.CALLABLE_STATEMENT_INDEX -> vg.resultSet!!.getBytes(ci!!)
		}
		if (data == null) {
			return null
		}

		return toUUID(
			data
		)
	}

	/**
	 * 将 [UUID] 转换为 MySQL 字节序的字节数组写入 PreparedStatement，参数为 null 时写入 BINARY 类型的 NULL。
	 */
	override fun setValue(
		ps: PreparedStatement, index: Int, parameter: UUID?, jdbcType: JdbcType?,
	) {
		if (parameter == null) {
			ps.setNull(index, java.sql.Types.BINARY)
			return
		}
		ps.setBytes(index, toByteArray(parameter))
	}

}
