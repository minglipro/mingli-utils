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
 * LastUpdate 2026-02-06 15:15:46
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.i18n.I18N
import com.mingliqiye.utils.i18n.I18N.infoTranslater
import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.system.computerName
import com.mingliqiye.utils.system.getPid
import com.mingliqiye.utils.system.jdkVersion
import com.mingliqiye.utils.system.userName
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.Formatter
import org.springframework.context.annotation.ComponentScan
import java.io.IOException

/**
 * 自动配置类，用于Spring Boot应用启动时加载相关组件和打印启动横幅。
 *
 * 该类通过@ComponentScan注解扫描指定包下的Bean，并在初始化时打印包含系统信息的启动横幅。
 */
@org.springframework.boot.autoconfigure.AutoConfiguration
@ComponentScan(
    "com.mingliqiye.utils.springboot.bean",
    "com.mingliqiye.utils.springboot.converters"
)
open class AutoConfiguration {
    private val log = MingLiLoggerFactory.getLogger("MingliUtils-AutoConfiguration")

    companion object {
        /**
         * 启动横幅字符串，包含艺术字体和占位符。
         */
        private const val BANNER =
            " |  $$\\      $$\\ $$\\      $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   \n" +
                    "|  $$$\\    $$$ |$$ |     $$ |  $$ |\\__$$  __|$$  __$$\\  \n" +
                    "|  $$$$\\  $$$$ |$$ |     $$ |  $$ |   $$ |   $$ /  \\__| \n" +
                    "|  $$\\$$\\$$ $$ |$$ |     $$ |  $$ |   $$ |   \\$$$$$$\\   \n" +
                    "|  $$ \\$$$  $$ |$$ |     $$ |  $$ |   $$ |    \\____$$\\  \n" +
                    "|  $$ |\\$  /$$ |$$ |     $$ |  $$ |   $$ |   $$\\   $$ | \n" +
                    "|  $$ | \\_/ $$ |$$$$$$$$\\\\$$$$$$  |   $$ |   \\$$$$$$   \n" +
                    "|  \\__|     \\__|\\________|\\______/    \\__|    \\______/  \n|\n"

        /**
         * 打印启动横幅，包含系统元数据（如JDK版本、进程ID、计算机名等）。
         *
         * 该方法从资源文件中读取元数据，并将其格式化后追加到横幅中进行输出。
         * 如果读取资源失败，则仅打印默认横幅。
         */
        fun printBanner() {
            val bannerBuilder = StringBuilder(BANNER)

            // 尝试从资源文件中读取元数据并拼接到横幅中
            try {
                val inputStream = AutoConfiguration::class.java.getResourceAsStream("/META-INF/meta-data") ?: return
                inputStream.use { stream ->
                    var readlen: Int
                    val buffer = ByteArray(1024)
                    val metaData = StringBuilder()

                    // 逐块读取资源文件内容
                    while (stream.read(buffer).also { readlen = it } != -1) {
                        metaData.append(String(buffer, 0, readlen))
                    }

                    // 解析元数据并添加额外的系统信息
                    val da = metaData.toString().split("\n").toMutableList()
                    da.add("${I18N.getString("com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration.jdkRuntime")}=$jdkVersion")
                    da.add("${I18N.getString("com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration.pid")}=$getPid")
                    da.add("${I18N.getString("com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration.computerName")}=$computerName")
                    da.add("${I18N.getString("com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration.userName")}=$userName")
                    da.add(
                        "${I18N.getString("com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration.time")}=" + DateTime.now()
                            .format(Formatter.STANDARD_DATETIME_MILLISECOUND7, false)
                    )

                    // 格式化每条元数据并追加到横幅中
                    da.forEach { s: String ->
                        val d = s.trim { it <= ' ' }.split("=".toRegex(), 2).toTypedArray()
                        if (d.size >= 2) {
                            val content = "| ->  " + I18N.getString(d[0]) + ": " + d[1]
                            val targetLength = 56
                            if (content.length < targetLength) {
                                bannerBuilder.append(
                                    String.format(
                                        "%-${targetLength}s\n",
                                        content
                                    )
                                )
                            } else {
                                bannerBuilder
                                    .append(content, 0, targetLength)
                                    .append("|\n")
                            }
                        }
                    }
                }
            } catch (e: IOException) {
                // 捕获IO异常并打印堆栈跟踪
                e.printStackTrace()
            }

            // 输出最终构建的横幅
            println("")
            println(bannerBuilder.toString().trim())
            println("")
        }
    }

    /**
     * 初始化块，在类实例化时执行。
     *
     * 调用printBanner方法打印启动横幅，并记录日志表示自动配置成功。
     */
    init {
        printBanner()
        log.infoTranslater("com.mingliqiye.utils.springboot.autoconfigure.AutoConfiguration.bean")
    }
}
