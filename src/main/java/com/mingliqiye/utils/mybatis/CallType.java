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
 * CurrentFile CallType.java
 * LastUpdate 2025-09-21 21:06:52
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis;

/**
 * CallType枚举类定义了不同的调用类型
 * 用于标识数据库操作中结果集和可调用语句的访问方式
 */
public enum CallType {
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
