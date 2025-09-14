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
 * CurrentFile MysqlUUIDv1.kt
 * LastUpdate 2025-09-14 18:19:29
 * UpdateUser MingLiPro
 */
@file:JvmName("MysqlUUIDv1")

package com.mingliqiye.utils.uuid


fun uuidToMysql(uuid: ByteArray): ByteArray {
    val reuuid = ByteArray(16)
    reuuid[4] = uuid[0]
    reuuid[5] = uuid[1]
    reuuid[6] = uuid[2]
    reuuid[7] = uuid[3]
    reuuid[2] = uuid[4]
    reuuid[3] = uuid[5]
    reuuid[0] = uuid[6]
    reuuid[1] = uuid[7]
    System.arraycopy(uuid, 8, reuuid, 8, 8)
    return reuuid
}

fun mysqlToUuid(uuid: ByteArray): ByteArray {
    val reuuid = ByteArray(16)
    reuuid[6] = uuid[0]
    reuuid[7] = uuid[1]
    reuuid[4] = uuid[2]
    reuuid[5] = uuid[3]
    reuuid[0] = uuid[4]
    reuuid[1] = uuid[5]
    reuuid[2] = uuid[6]
    reuuid[3] = uuid[7]
    System.arraycopy(uuid, 8, reuuid, 8, 8)
    return reuuid
}
