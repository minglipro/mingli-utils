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
 * CurrentFile AutoConfiguration.kt
 * LastUpdate 2026-03-10 09:04:30
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.ComponentScan

/**
 * 自动配置类，用于Spring Boot应用启动时加载相关组件和打印启动横幅。
 *
 * 该类通过@ComponentScan注解扫描指定包下的Bean，并在初始化时打印包含系统信息的启动横幅。
 */
@AutoConfiguration
@ComponentScan(
    "com.mingliqiye.utils.springboot.bean",
    "com.mingliqiye.utils.springboot.converters",
    "com.mingliqiye.utils.springboot.listener",
)
open class AutoConfiguration {

    /**
     * 初始化块，在类实例化时执行。
     *
     * 调用printBanner方法打印启动横幅，并记录日志表示自动配置成功。
     */
    init {
        com.mingliqiye.utils.main.Main.printb()
    }
}
