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
 * CurrentFile DateTimeTypeHandler.kt
 * LastUpdate 2025-09-14 18:19:29
 * UpdateUser MingLiPro
 */
@file:JvmName("DateTimeConvertor")

package com.mingliqiye.utils.mybatis.typehandler.datetime

import com.mingliqiye.utils.time.DateTime
import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.time.LocalDateTime

/**
 * 将LocalDateTime对象转换为DateTime对象
 *
 * @param localDateTime LocalDateTime对象
 * @return DateTime对象，如果localDateTime为null则返回null
 */
fun toDateTime(localDateTime: LocalDateTime?): DateTime? {
    return localDateTime?.let { DateTime.of(it) }
}

/**
 * 将DateTime对象转换为LocalDateTime对象
 *
 * @param dateTime DateTime对象
 * @return LocalDateTime对象，如果dateTime为null则返回null
 */
fun toLocalDateTime(dateTime: DateTime?): LocalDateTime? {
    return dateTime?.toLocalDateTime()
}

/**
 * DateTime类型处理器，用于在数据库和Java对象之间转换DateTime类型
 * @author MingLiQiye
 * @date 2025/9/12
 */
@MappedTypes(DateTime::class)
class DateTimeTypeHandler : BaseTypeHandler<DateTime>() {

    @Throws(SQLException::class)
    override fun setNonNullParameter(
        ps: PreparedStatement,
        i: Int,
        parameter: DateTime,  // 移除了 ?，因为这是 non-null 方法
        jdbcType: JdbcType
    ) {
        // 使用 setObject 允许传入 null，由数据库处理
        ps.setObject(i, toLocalDateTime(parameter))
    }

    @Throws(SQLException::class)
    override fun getNullableResult(rs: ResultSet, columnName: String): DateTime? {
        // 安全类型转换和空检查
        return when (val value = rs.getObject(columnName)) {
            is LocalDateTime -> toDateTime(value)
            null -> null
            else -> throw SQLException("Expected LocalDateTime for column '$columnName', but got ${value.javaClass.name}")
        }
    }

    @Throws(SQLException::class)
    override fun getNullableResult(rs: ResultSet, columnIndex: Int): DateTime? {
        return when (val value = rs.getObject(columnIndex)) {
            is LocalDateTime -> toDateTime(value)
            null -> null
            else -> throw SQLException("Expected LocalDateTime at column index $columnIndex, but got ${value.javaClass.name}")
        }
    }

    @Throws(SQLException::class)
    override fun getNullableResult(cs: CallableStatement, columnIndex: Int): DateTime? {
        return when (val value = cs.getObject(columnIndex)) {
            is LocalDateTime -> toDateTime(value)
            null -> null
            else -> throw SQLException("Expected LocalDateTime at column index $columnIndex, but got ${value.javaClass.name}")
        }
    }
}
