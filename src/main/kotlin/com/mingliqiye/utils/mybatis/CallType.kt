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
 * CurrentFile CallType.kt
 * LastUpdate 2026-01-07 19:06:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis

/**
 * 类型处理器取值时的调用类型枚举。
 * 标识当前是从 ResultSet 还是 CallableStatement、以及通过列索引还是列名获取数据，
 * 供 [QuickBaseTypeHandler.getValue] 在取值时选择对应的 JDBC 访问方式。
 */
enum class CallType {
	/**
	 * 通过索引访问结果集
	 * 使用数字索引位置来获取结果集中的数据
	 */
	RESULTSET_INDEX,

	/**
	 * 通过名称访问结果集
	 * 使用列名来获取结果集中的数据
	 */
	RESULTSET_NAME,

	/**
	 * 通过索引访问可调用语句
	 * 使用数字索引位置来获取可调用语句中的数据
	 */
	CALLABLE_STATEMENT_INDEX
}
