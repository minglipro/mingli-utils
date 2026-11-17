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
 * CurrentFile QuickBaseTypeHandlerValueGetter.kt
 * LastUpdate 2026-01-07 19:10:44
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis

import java.sql.CallableStatement
import java.sql.ResultSet

/**
 * 类型处理器的值获取器，封装取值时可用的 JDBC 数据源。
 * 根据 [CallType] 的不同，实际使用 [resultSet] 或 [callableStatement] 读取数据，
 * 未使用的一方为 null。
 *
 * @property callableStatement 可调用语句对象，从存储过程输出参数取值时使用，否则为 null
 * @property resultSet 结果集对象，从查询结果取值时使用，否则为 null
 */
data class QuickBaseTypeHandlerValueGetter(var callableStatement: CallableStatement?, var resultSet: ResultSet?)
