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
 * CurrentFile DateTimeTypeHandler.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.time.typehandlers;

import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.time.Formatter;
import java.sql.*;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * DateTime类型处理器类
 * 用于在MyBatis中处理DateTime类型与数据库VARCHAR类型之间的转换
 */
@MappedTypes({ DateTime.class })
@MappedJdbcTypes(JdbcType.VARCHAR)
public class DateTimeTypeHandler extends BaseTypeHandler<DateTime> {

	/**
	 * 设置非空参数值
	 * 将DateTime对象转换为Timestamp并设置到PreparedStatement中
	 *
	 * @param ps        PreparedStatement对象
	 * @param i         参数索引位置
	 * @param parameter DateTime参数值
	 * @param jdbcType  JDBC类型
	 * @throws SQLException SQL异常
	 */
	@Override
	public void setNonNullParameter(
		PreparedStatement ps,
		int i,
		DateTime parameter,
		JdbcType jdbcType
	) throws SQLException {
		ps.setTimestamp(i, Timestamp.valueOf(parameter.getLocalDateTime()));
	}

	/**
	 * 从ResultSet中获取可为空的结果值
	 * 根据列名获取字符串值并解析为DateTime对象
	 *
	 * @param rs         ResultSet对象
	 * @param columnName 列名
	 * @return DateTime对象，如果值为null则返回null
	 * @throws SQLException SQL异常
	 */
	@Override
	public DateTime getNullableResult(ResultSet rs, String columnName)
		throws SQLException {
		return parse(rs.getString(columnName));
	}

	/**
	 * 从ResultSet中获取可为空的结果值
	 * 根据列索引获取字符串值并解析为DateTime对象
	 *
	 * @param rs          ResultSet对象
	 * @param columnIndex 列索引
	 * @return DateTime对象，如果值为null则返回null
	 * @throws SQLException SQL异常
	 */
	@Override
	public DateTime getNullableResult(ResultSet rs, int columnIndex)
		throws SQLException {
		return parse(rs.getString(columnIndex));
	}

	/**
	 * 从CallableStatement中获取可为空的结果值
	 * 根据列索引获取字符串值并解析为DateTime对象
	 *
	 * @param cs          CallableStatement对象
	 * @param columnIndex 列索引
	 * @return DateTime对象，如果值为null则返回null
	 * @throws SQLException SQL异常
	 */
	@Override
	public DateTime getNullableResult(CallableStatement cs, int columnIndex)
		throws SQLException {
		return parse(cs.getString(columnIndex));
	}

	/**
	 * 解析字符串为DateTime对象
	 *
	 * @param s 待解析的字符串
	 * @return DateTime对象，如果字符串为null则返回null
	 */
	public DateTime parse(String s) {
		if (s == null) {
			return null;
		}
		return DateTime.parse(s, Formatter.STANDARD_DATETIME_MILLISECOUND7);
	}

	/**
	 * 格式化DateTime对象为字符串
	 *
	 * @param t DateTime对象
	 * @return 格式化后的字符串
	 */
	public String format(DateTime t) {
		return t.format(Formatter.STANDARD_DATETIME_MILLISECOUND7);
	}
}
