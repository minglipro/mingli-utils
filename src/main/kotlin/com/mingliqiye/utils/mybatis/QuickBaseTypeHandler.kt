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
 * CurrentFile QuickBaseTypeHandler.kt
 * LastUpdate 2026-01-08 07:59:47
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis

import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

/**
 * 抽象类 QuickBaseTypeHandler 是 MyBatis 的 BaseTypeHandler 的扩展，
 * 提供了统一处理数据库字段与 Java 类型之间转换的抽象方法。
 * 子类需要实现 getValue 和 setValue 方法来完成具体的类型转换逻辑。
 *
 * @param T 要处理的 Java 类型
 */
abstract class QuickBaseTypeHandler<T> : BaseTypeHandler<T>() {
    /**
     * 抽象方法，用于从数据库结果中获取并转换为 Java 类型 T。
     *
     * @param vg 值获取器，封装了 ResultSet 或 CallableStatement
     * @param ct 调用类型，标识当前是从 ResultSet 还是 CallableStatement 获取数据
     * @param ci 列索引（可为 null）
     * @param cn 列名（可为 null）
     * @return 转换后的 Java 类型 T 实例
     * @throws SQLException SQL 执行异常时抛出
     */
    @Throws(SQLException::class)
    abstract fun getValue(
        vg: QuickBaseTypeHandlerValueGetter,
        ct: CallType,
        ci: Int?,
        cn: String?
    ): T

    /**
     * 抽象方法，用于将 Java 类型 T 设置到 PreparedStatement 中。
     *
     * @param ps        PreparedStatement 对象
     * @param index     参数索引位置
     * @param parameter Java 类型 T 的实例
     * @param jdbcType  JDBC 类型
     * @throws SQLException SQL 执行异常时抛出
     */
    @Throws(SQLException::class)
    abstract fun setValue(ps: PreparedStatement, index: Int, parameter: T, jdbcType: JdbcType?)

    /**
     * 实现 BaseTypeHandler 的 setNonNullParameter 方法，
     * 将非空参数设置到 PreparedStatement 中。
     *
     * @param ps        PreparedStatement 对象
     * @param i         参数索引位置
     * @param parameter Java 类型 T 的实例（非空）
     * @param jdbcType  JDBC 类型
     * @throws SQLException SQL 执行异常时抛出
     */
    @Throws(SQLException::class)
    override fun setNonNullParameter(ps: PreparedStatement, i: Int, parameter: T, jdbcType: JdbcType?) {
        setValue(ps, i, parameter, jdbcType)
    }

    /**
     * 实现 BaseTypeHandler 的 getNullableResult 方法，
     * 通过列名从 ResultSet 中获取可能为 null 的结果。
     *
     * @param rs         ResultSet 对象
     * @param columnName 数据库列名
     * @return 转换后的 Java 类型 T 实例（可能为 null）
     * @throws SQLException SQL 执行异常时抛出
     */
    @Throws(SQLException::class)
    override fun getNullableResult(rs: ResultSet, columnName: String): T {
        return getValue(QuickBaseTypeHandlerValueGetter(null, rs), CallType.RESULTSET_NAME, null, columnName)
    }

    /**
     * 实现 BaseTypeHandler 的 getNullableResult 方法，
     * 通过列索引从 ResultSet 中获取可能为 null 的结果。
     *
     * @param rs          ResultSet 对象
     * @param columnIndex 数据库列索引
     * @return 转换后的 Java 类型 T 实例（可能为 null）
     * @throws SQLException SQL 执行异常时抛出
     */
    @Throws(SQLException::class)
    override fun getNullableResult(rs: ResultSet, columnIndex: Int): T {
        return getValue(QuickBaseTypeHandlerValueGetter(null, rs), CallType.RESULTSET_INDEX, columnIndex, null)
    }

    /**
     * 实现 BaseTypeHandler 的 getNullableResult 方法，
     * 通过列索引从 CallableStatement 中获取可能为 null 的结果。
     *
     * @param cs          CallableStatement 对象
     * @param columnIndex 数据库列索引
     * @return 转换后的 Java 类型 T 实例（可能为 null）
     * @throws SQLException SQL 执行异常时抛出
     */
    @Throws(SQLException::class)
    override fun getNullableResult(cs: CallableStatement, columnIndex: Int): T {
        return getValue(QuickBaseTypeHandlerValueGetter(cs, null), CallType.CALLABLE_STATEMENT_INDEX, columnIndex, null)
    }
}
