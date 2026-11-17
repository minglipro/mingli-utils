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
 * CurrentFile Jackson3ApiJavaHelper.java
 * LastUpdate 2026-03-18 08:32:31
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.api;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.cfg.MapperBuilder;


/**
 * Jackson 3 API 的 Java 辅助类，用于在 Java 侧调用 Kotlin 内联/受限 API。
 */
public class Jackson3ApiJavaHelper {
    /**
     * 基于现有 ObjectMapper 创建可重新配置的 MapperBuilder。
     *
     * @param objectMapper 需要重建的 ObjectMapper 实例
     * @return 由该 ObjectMapper 派生的 MapperBuilder
     */
    @SuppressWarnings("rawtypes")
    static MapperBuilder rebuild(ObjectMapper objectMapper) {
        return objectMapper.rebuild();
    }
}
