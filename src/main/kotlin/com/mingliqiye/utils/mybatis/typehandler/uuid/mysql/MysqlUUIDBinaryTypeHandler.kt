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
 * CurrentFile MysqlUUIDBinaryTypeHandler.kt
 * LastUpdate 2025-09-14 18:19:29
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis.typehandler.uuid.mysql

import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.mysqlToUuid
import com.mingliqiye.utils.uuid.uuidToMysql
import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

/**
 * JDBC类型转换 UUID
 * @author MingLiQiye
 * @date 2025/9/12
 */
@MappedTypes(UUID::class)
class MysqlUUIDBinaryTypeHandler : BaseTypeHandler<UUID>() {

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

    /**
     * 设置非空参数到PreparedStatement中
     *
     * @param ps PreparedStatement对象
     * @param i 参数索引
     * @param parameter UUID参数值
     * @param jdbcType JDBC类型
     */
    override fun setNonNullParameter(
        ps: PreparedStatement,
        i: Int,
        parameter: UUID,
        jdbcType: JdbcType
    ) {
        ps.setBytes(i, toByteArray(parameter))
    }

    /**
     * 从ResultSet中根据列名获取可空的UUID结果
     *
     * @param rs ResultSet对象
     * @param columnName 列名
     * @return UUID对象或null
     */
    override fun getNullableResult(
        rs: ResultSet,
        columnName: String
    ): UUID? {
        return toUUID(rs.getBytes(columnName))
    }

    /**
     * 从ResultSet中根据列索引获取可空的UUID结果
     *
     * @param rs ResultSet对象
     * @param columnIndex 列索引
     * @return UUID对象或null
     */
    override fun getNullableResult(rs: ResultSet, columnIndex: Int): UUID? {
        return toUUID(rs.getBytes(columnIndex))
    }

    /**
     * 从CallableStatement中根据列索引获取可空的UUID结果
     *
     * @param cs CallableStatement对象
     * @param columnIndex 列索引
     * @return UUID对象或null
     */
    override fun getNullableResult(
        cs: CallableStatement,
        columnIndex: Int
    ): UUID? {
        return toUUID(cs.getBytes(columnIndex))
    }

}
