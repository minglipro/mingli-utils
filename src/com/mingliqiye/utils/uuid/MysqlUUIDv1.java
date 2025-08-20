package com.mingliqiye.utils.uuid;

import lombok.var;

/**
 * MySQL UUID格式与标准UUID格式相互转换工具类
 * <p>
 * MySQL使用不同的字节顺序存储UUID，此类提供了在MySQL格式和标准UUID格式之间转换的方法
 * @author MingLiPro
 */
public class MysqlUUIDv1 {

	/**
	 * 将标准UUID格式转换为MySQL格式的UUID
	 *
	 * @param uuid 标准UUID格式的字节数组，长度必须为16字节
	 * @return MySQL格式的UUID字节数组，长度为16字节
	 */
	public static byte[] uuidToMysql(byte[] uuid) {
		var reuuid = new byte[16];
		// 转换时间戳低位部分
		reuuid[4] = uuid[0];
		reuuid[5] = uuid[1];
		reuuid[6] = uuid[2];
		reuuid[7] = uuid[3];

		// 转换时间戳中位部分
		reuuid[2] = uuid[4];
		reuuid[3] = uuid[5];

		// 转换时间戳高位部分
		reuuid[0] = uuid[6];
		reuuid[1] = uuid[7];

		// 复制时钟序列和节点标识部分
		System.arraycopy(uuid, 8, reuuid, 8, 8);
		return reuuid;
	}

	/**
	 * 将MySQL格式的UUID转换为标准UUID格式
	 *
	 * @param uuid MySQL格式的UUID字节数组，长度必须为16字节
	 * @return 标准UUID格式的字节数组，长度为16字节
	 */
	public static byte[] mysqlToUuid(byte[] uuid) {
		var reuuid = new byte[16];
		// 转换时间戳高位部分
		reuuid[6] = uuid[0];
		reuuid[7] = uuid[1];

		// 转换时间戳中位部分
		reuuid[4] = uuid[2];
		reuuid[5] = uuid[3];

		// 转换时间戳低位部分
		reuuid[0] = uuid[4];
		reuuid[1] = uuid[5];
		reuuid[2] = uuid[6];
		reuuid[3] = uuid[7];

		// 复制时钟序列和节点标识部分
		System.arraycopy(uuid, 8, reuuid, 8, 8);
		return reuuid;
	}
}
