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
 * CurrentFile AutoConfiguration.kt
 * LastUpdate 2025-09-14 22:09:46
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.collection.ForEach
import com.mingliqiye.utils.logger.mingLiLoggerFactory
import com.mingliqiye.utils.system.getJdkVersion
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.Formatter
import org.springframework.context.annotation.ComponentScan
import java.io.IOException

@org.springframework.boot.autoconfigure.AutoConfiguration
@ComponentScan(
    "com.mingliqiye.utils.bean.springboot",
    "com.mingliqiye.utils.springboot.converters"
)
open class AutoConfiguration {
    companion object {
        private const val banner =
            "---------------------------------------------------------\n" +
                    "|  $$\\      $$\\ $$\\      $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   |\n" +
                    "|  $$$\\    $$$ |$$ |     $$ |  $$ |\\__$$  __|$$  __$$\\  |\n" +
                    "|  $$$$\\  $$$$ |$$ |     $$ |  $$ |   $$ |   $$ /  \\__| |\n" +
                    "|  $$\\$$\\$$ $$ |$$ |     $$ |  $$ |   $$ |   \\$$$$$$\\   |\n" +
                    "|  $$ \\$$$  $$ |$$ |     $$ |  $$ |   $$ |    \\____$$\\  |\n" +
                    "|  $$ |\\$  /$$ |$$ |     $$ |  $$ |   $$ |   $$\\   $$ | |\n" +
                    "|  $$ | \\_/ $$ |$$$$$$$$\\\\$$$$$$  |   $$ |   \\$$$$$$  | |\n" +
                    "|  \\__|     \\__|\\________|\\______/    \\__|    \\______/  |\n"

        private var banner2: String? = null
        private val log = mingLiLoggerFactory.getLogger("MingliUtils-AutoConfiguration")

        fun printBanner() {
            val bannerBuilder = StringBuilder(banner)
            try {
                val inputStream = AutoConfiguration::class.java.getResourceAsStream("/META-INF/meta-data")
                if (inputStream == null) {
                    return
                }
                inputStream.use { stream ->
                    var readlen: Int
                    val buffer = ByteArray(1024)
                    val metaData = StringBuilder()
                    while (stream.read(buffer).also { readlen = it } != -1) {
                        metaData.append(String(buffer, 0, readlen))
                    }
                    val da = metaData.toString().split("\n").toMutableList()
                    da.add("time=" + DateTime.now().format(Formatter.STANDARD_DATETIME_MILLISECOUND7))
                    da.add("jdkRuntime=" + getJdkVersion())
                    ForEach.forEach(da) { s: String, _: Int ->
                        val d = s.trim { it <= ' ' }.split("=".toRegex(), 2).toTypedArray()
                        if (d.size >= 2) {
                            val content = "|  " + d[0] + ": " + d[1]
                            val targetLength = 56
                            if (content.length < targetLength) {
                                bannerBuilder.append(
                                    String.format(
                                        "%-" + targetLength + "s|\n",
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
                e.printStackTrace()
            }
            banner2 = bannerBuilder.toString()
            println(banner2)
            println("---------------------------------------------------------")
        }
    }

    init {
        printBanner()
        log.info("MingliUtils AutoConfiguration succeed")
    }
}
