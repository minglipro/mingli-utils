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
 * CurrentFile UUIDTypeHandler.kt
 * LastUpdate 2025-09-15 13:54:18
 * UpdateUser MingLiPro
 */
@file:JvmName("UUIDConvertor")

package com.mingliqiye.utils.mybatis.typehandler.uuid

import com.mingliqiye.utils.uuid.UUID
import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedJdbcTypes
import org.apache.ibatis.type.MappedTypes
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.UUID as JUUID


/**
 * 将字节数组转换为UUID对象
 *
 * @param byteArray 字节数组
 * @return UUID对象，如果字节数组为null则返回null
 */
fun byteArraytoUUID(byteArray: ByteArray?): UUID? {
    return byteArray?.let { UUID.of(it) }
}

/**
 * 将UUID对象转换为字节数组
 *
 * @param uuid UUID对象
 * @return 字节数组，如果UUID为null则返回null
 */
fun uuidToByteArray(uuid: UUID?): ByteArray? {
    return uuid?.toBytes()
}

/**
 * 将字符串转换为UUID对象
 *
 * @param str 字符串
 * @return UUID对象，如果字符串为null则返回null
 */
fun stringToUUID(str: String?): UUID? {
    return str?.let { UUID.of(it) }
}

/**
 * 将UUID对象转换为字符串
 *
 * @param uuid UUID对象
 * @return 字符串，如果UUID为null则返回null
 */
fun uuidToString(uuid: UUID?): String? {
    return uuid?.getString()
}

/**
 * 将java UUID转换为UUID对象
 *
 * @param uuid JUUID java UUID
 * @return UUID对象，如果字符串为null则返回null
 */
fun juuidToUUID(uuid: JUUID?): UUID? {
    return uuid?.let { UUID(it) }
}

/**
 * 将UUID对象转换为java UUID
 *
 * @param uuid UUID对象
 * @return java UUID，如果UUID为null则返回null
 */
fun uuidToJuuid(uuid: UUID?): JUUID? {
    return uuid?.getUuid()
}


/**
 * JDBC类型转换 UUID BINARY
 * @author MingLiQiye
 * @date 2025/9/12
 */
@MappedTypes(UUID::class)
@MappedJdbcTypes(JdbcType.BINARY)
class UUIDBinaryTypeHandler : BaseTypeHandler<UUID>() {
    /**
     * 设置非空参数到PreparedStatement中
     *
     * @param ps PreparedStatement对象
     * @param i 参数索引
     * @param parameter UUID参数值
     * @param jdbcType JDBC类型
     */
    override fun setNonNullParameter(
        ps: PreparedStatement, i: Int, parameter: UUID, jdbcType: JdbcType?
    ) {
        ps.setBytes(i, uuidToByteArray(parameter))
    }

    /**
     * 从ResultSet中根据列名获取可空的UUID结果
     *
     * @param rs ResultSet对象
     * @param columnName 列名
     * @return UUID对象或null
     */
    override fun getNullableResult(
        rs: ResultSet, columnName: String
    ): UUID? {
        return byteArraytoUUID(rs.getBytes(columnName))
    }

    /**
     * 从ResultSet中根据列索引获取可空的UUID结果
     *
     * @param rs ResultSet对象
     * @param columnIndex 列索引
     * @return UUID对象或null
     */
    override fun getNullableResult(rs: ResultSet, columnIndex: Int): UUID? {
        return byteArraytoUUID(rs.getBytes(columnIndex))
    }

    /**
     * 从CallableStatement中根据列索引获取可空的UUID结果
     *
     * @param cs CallableStatement对象
     * @param columnIndex 列索引
     * @return UUID对象或null
     */
    override fun getNullableResult(
        cs: CallableStatement, columnIndex: Int
    ): UUID? {
        return byteArraytoUUID(cs.getBytes(columnIndex))
    }
}

/**
 * JDBC类型转换 UUID String
 * @author MingLiQiye
 * @date 2025/9/12
 */
@MappedTypes(UUID::class)
@MappedJdbcTypes(JdbcType.VARCHAR)
class UUIDStringTypeHandler : BaseTypeHandler<UUID>() {
    /**
     * 设置非空参数到PreparedStatement中
     *
     * @param ps PreparedStatement对象
     * @param i 参数索引
     * @param parameter UUID参数值
     * @param jdbcType JDBC类型
     */
    override fun setNonNullParameter(
        ps: PreparedStatement, i: Int, parameter: UUID, jdbcType: JdbcType?
    ) {
        ps.setString(i, uuidToString(parameter))
    }

    /**
     * 从ResultSet中根据列名获取可空的UUID结果
     *
     * @param rs ResultSet对象
     * @param columnName 列名
     * @return UUID对象或null
     */
    override fun getNullableResult(
        rs: ResultSet, columnName: String
    ): UUID? {
        return stringToUUID(rs.getString(columnName))
    }

    /**
     * 从ResultSet中根据列索引获取可空的UUID结果
     *
     * @param rs ResultSet对象
     * @param columnIndex 列索引
     * @return UUID对象或null
     */
    override fun getNullableResult(rs: ResultSet, columnIndex: Int): UUID? {
        return stringToUUID(rs.getString(columnIndex))

    }

    /**
     * 从CallableStatement中根据列索引获取可空的UUID结果
     *
     * @param cs CallableStatement对象
     * @param columnIndex 列索引
     * @return UUID对象或null
     */
    override fun getNullableResult(
        cs: CallableStatement, columnIndex: Int
    ): UUID? {
        return stringToUUID(cs.getString(columnIndex))
    }

}

/**
 * JDBC类型转换 UUID java UUID
 * @author MingLiQiye
 * @date 2025/9/12
 */
@MappedTypes(UUID::class)
@MappedJdbcTypes(JdbcType.OTHER)
class UUIDTypeHandler : BaseTypeHandler<UUID>() {
    /**
     * 设置非空参数到PreparedStatement中
     *
     * @param ps PreparedStatement对象
     * @param i 参数索引
     * @param parameter UUID参数值
     * @param jdbcType JDBC类型
     */
    override fun setNonNullParameter(
        ps: PreparedStatement, i: Int, parameter: UUID, jdbcType: JdbcType?
    ) {
        ps.setObject(i, parameter.getUuid())
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
        return juuidToUUID(rs.getObject(columnName, JUUID::class.java) as JUUID)
    }

    /**
     * 从ResultSet中根据列索引获取可空的UUID结果
     *
     * @param rs ResultSet对象
     * @param columnIndex 列索引
     * @return UUID对象或null
     */
    override fun getNullableResult(rs: ResultSet, columnIndex: Int): UUID? {
        return juuidToUUID(rs.getObject(columnIndex, JUUID::class.java) as JUUID)
    }

    /**
     * 从CallableStatement中根据列索引获取可空的UUID结果
     *
     * @param cs CallableStatement对象
     * @param columnIndex 列索引
     * @return UUID对象或null
     */
    override fun getNullableResult(
        cs: CallableStatement, columnIndex: Int
    ): UUID? {
        return juuidToUUID(cs.getObject(columnIndex, JUUID::class.java) as JUUID)
    }
}
