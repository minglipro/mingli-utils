package com.mingliqiye.utils.uuid.typehandlers;

import com.mingliqiye.utils.uuid.UUID;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.nio.ByteBuffer;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
     * 将 UUID 对象转换为二进制字节数组
     *
     * @param uuid 要转换的 UUID 对象
     * @return 包含 UUID 数据的 16 字节二进制数组
     */
    public static byte[] UUID_TO_BIN(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.GetUUID().getMostSignificantBits());
        bb.putLong(uuid.GetUUID().getLeastSignificantBits());
        return bb.array();
    }

    /**
     * 将二进制字节数组转换为 UUID 对象
     *
     * @param bytes 包含 UUID 数据的二进制字节数组
     * @return 转换后的 UUID 对象，如果输入为 null 则返回 null
     */
    public static UUID BIN_TO_UUID(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return UUID.of(bytes);
    }

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
        ps.setBytes(i, UUID_TO_BIN(parameter));
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
        return BIN_TO_UUID(rs.getBytes(columnName));
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
        return BIN_TO_UUID(rs.getBytes(columnIndex));
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
        return BIN_TO_UUID(cs.getBytes(columnIndex));
    }
}
