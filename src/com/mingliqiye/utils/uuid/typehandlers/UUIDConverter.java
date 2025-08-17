package com.mingliqiye.utils.uuid.typehandlers;

import com.mingliqiye.utils.uuid.MysqlUUIDv1;
import com.mingliqiye.utils.uuid.UUID;

public class UUIDConverter {

	public static String UUID_TO_STR(UUID uuid) {
		return uuid.toUUIDString();
	}

	public static UUID STR_TO_UUID(String string) {
		return UUID.of(string);
	}

	public static byte[] UUID_TO_BIN(UUID uuid) {
		return uuid.toBytes();
	}

	public static UUID BIN_TO_UUID(byte[] bytes) {
		return UUID.of(bytes);
	}

	public static byte[] MYSQL_UUID_TO_BIN(UUID uuid) {
		return MysqlUUIDv1.uuidToMysql(uuid.toBytes());
	}

	public static UUID BIN_TO_MYSQL_UUID(byte[] bytes) {
		return UUID.of(MysqlUUIDv1.mysqlToUuid(bytes));
	}
}
