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
 * CurrentFile UUIDConverter.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

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
