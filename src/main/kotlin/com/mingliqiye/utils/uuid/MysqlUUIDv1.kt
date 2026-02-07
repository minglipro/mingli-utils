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
 * CurrentFile MysqlUUIDv1.kt
 * LastUpdate 2026-02-06 14:52:40
 * UpdateUser MingLiPro
 */
@file:JvmName("MysqlUUIDConvertor")

package com.mingliqiye.utils.uuid

import com.mingliqiye.utils.array.copyTo

/**
 * 将标准UUID字节数组转换为MySQL存储格式的字节数组
 * MySQL中UUID的存储格式与标准UUID的字节顺序不同，需要重新排列字节顺序
 *
 * @param uuid 标准UUID格式的字节数组（16字节）
 * @return 转换后的MySQL存储格式字节数组（16字节）
 * @since 4.6.2
 */
fun uuidToMysql(uuid: ByteArray): ByteArray {
    return ByteArray(16).also {
        // 按照MySQL UUID存储格式重新排列字节：前4字节、中间2字节、后2字节、最后8字节
        uuid.copyTo(it, 0, 4, 4)
            .copyTo(it, 4, 2, 2)
            .copyTo(it, 6, 0, 2)
            .copyTo(it, 8, 8, 8)
    }
}

/**
 * 将MySQL存储格式的UUID字节数组转换回标准UUID格式
 * MySQL中UUID的存储格式与标准UUID的字节顺序不同，需要恢复原始字节顺序
 *
 * @param uuid MySQL存储格式的字节数组（16字节）
 * @return 转换后的标准UUID格式字节数组（16字节）
 * @since 4.6.2
 */
fun mysqlToUuid(uuid: ByteArray): ByteArray {
    return ByteArray(16).also {
        // 按照标准UUID格式恢复字节顺序：第6-7字节、第4-5字节、第0-3字节、第8-15字节
        uuid.copyTo(it, 0, 6, 2)
            .copyTo(it, 2, 4, 2)
            .copyTo(it, 4, 0, 4)
            .copyTo(it, 8, 8, 8)
    }
}
