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
 * CurrentFile UUIDBinaryTypeHandler.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.uuid.typehandlers;

import com.mingliqiye.utils.uuid.UUID;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * UUIDBinaryTypeHandler 类用于处理 UUID 类型与数据库 BINARY 类型之间的转换
 * 该类继承自 BaseTypeHandler，专门处理 UUID 对象的序列化和反序列化
 *
 * @author MingLiPro
 */
@MappedTypes({ UUID.class })
@MappedJdbcTypes(JdbcType.BINARY)
public class UUIDBinaryTypeHandler extends BaseTypeHandler<UUID> {

	/**
	 * 设置非空参数到 PreparedStatement 中
	 *
	 * @param ps        PreparedStatement 对象
	 * @param i         参数在 SQL 语句中的位置索引
	 * @param parameter 要设置的 UUID 参数值
	 * @param jdbcType  JDBC 类型信息
	 * @throws SQLException 当数据库操作发生错误时抛出
	 */
	@Override
	public void setNonNullParameter(
		PreparedStatement ps,
		int i,
		UUID parameter,
		JdbcType jdbcType
	) throws SQLException {
		ps.setBytes(i, UUIDConverter.UUID_TO_BIN(parameter));
	}

	/**
	 * 从 ResultSet 中根据列名获取可为空的 UUID 结果
	 *
	 * @param rs         ResultSet 对象
	 * @param columnName 数据库列名
	 * @return 转换后的 UUID 对象，可能为 null
	 * @throws SQLException 当数据库操作发生错误时抛出
	 */
	@Override
	public UUID getNullableResult(ResultSet rs, String columnName)
		throws SQLException {
		return UUIDConverter.BIN_TO_UUID(rs.getBytes(columnName));
	}

	/**
	 * 从 ResultSet 中根据列索引获取可为空的 UUID 结果
	 *
	 * @param rs          ResultSet 对象
	 * @param columnIndex 数据库列索引
	 * @return 转换后的 UUID 对象，可能为 null
	 * @throws SQLException 当数据库操作发生错误时抛出
	 */
	@Override
	public UUID getNullableResult(ResultSet rs, int columnIndex)
		throws SQLException {
		return UUIDConverter.BIN_TO_UUID(rs.getBytes(columnIndex));
	}

	/**
	 * 从 CallableStatement 中根据参数索引获取可为空的 UUID 结果
	 *
	 * @param cs          CallableStatement 对象
	 * @param columnIndex 参数索引
	 * @return 转换后的 UUID 对象，可能为 null
	 * @throws SQLException 当数据库操作发生错误时抛出
	 */
	@Override
	public UUID getNullableResult(CallableStatement cs, int columnIndex)
		throws SQLException {
		return UUIDConverter.BIN_TO_UUID(cs.getBytes(columnIndex));
	}
}
