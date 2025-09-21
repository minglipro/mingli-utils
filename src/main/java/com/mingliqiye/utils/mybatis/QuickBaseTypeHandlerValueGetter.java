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
 * CurrentFile QuickBaseTypeHandlerValueGetter.java
 * LastUpdate 2025-09-21 21:07:10
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.mybatis;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * QuickBaseTypeHandlerValueGetter类用于封装CallableStatement和ResultSet对象的获取操作
 * 该类提供了对存储过程调用结果和查询结果集的统一访问接口
 */
public class QuickBaseTypeHandlerValueGetter {
    private final CallableStatement callableStatement;
    private final ResultSet resultSet;

    /**
     * 构造函数，初始化QuickBaseTypeHandlerValueGetter实例
     *
     * @param callableStatement 存储过程调用语句对象，用于执行存储过程
     * @param resultSet         查询结果集对象，用于获取查询结果
     */
    public QuickBaseTypeHandlerValueGetter(CallableStatement callableStatement, ResultSet resultSet) {
        this.callableStatement = callableStatement;
        this.resultSet = resultSet;
    }

    /**
     * 获取结果集对象
     *
     * @return ResultSet 查询结果集对象
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * 获取存储过程调用语句对象
     *
     * @return CallableStatement 存储过程调用语句对象
     */
    public CallableStatement getCallableStatement() {
        return callableStatement;
    }
}
