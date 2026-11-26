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
 * CurrentFile Main.java
 * LastUpdate 2026-11-26 18:20:50
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.main;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 工具库入口类，提供启动 Banner 打印以及进程、主机、用户等基础信息的获取方法。
 */
public class Main {
    /**
     * 启动时打印的 ASCII 艺术 Banner 文本
     */
    public final static String BANNER =
            "|  $$\\      $$\\ $$\\      $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   \n" +
                    "|  $$$\\    $$$ |$$ |     $$ |  $$ |\\__$$  __|$$  __$$\\  \n" +
                    "|  $$$$\\  $$$$ |$$ |     $$ |  $$ |   $$ |   $$ /  \\__| \n" +
                    "|  $$\\$$\\$$ $$ |$$ |     $$ |  $$ |   $$ |   \\$$$$$$\\   \n" +
                    "|  $$ \\$$$  $$ |$$ |     $$ |  $$ |   $$ |    \\____$$\\  \n" +
                    "|  $$ |\\$  /$$ |$$ |     $$ |  $$ |   $$ |   $$\\   $$ | \n" +
                    "|  $$ | \\_/ $$ |$$$$$$$$\\\\$$$$$$  |   $$ |   \\$$$$$$   \n" +
                    "|  \\__|     \\__|\\________|\\______/    \\__|    \\______/  \n|\n";

    /**
     * 程序入口，打印 Banner 与构建元数据信息，打印失败时静默忽略。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        try {
            printb();
        } catch (IOException ignored) {
        }
    }

    /**
     * 获取当前进程 PID 字符串。
     *
     * @return 当前进程 PID；获取失败时返回 "-1"
     */
    public static String getPid() {
        try {
            var name = ManagementFactory.getRuntimeMXBean().getName();
            var index = name.indexOf('@');
            if (index > 0) {
                return name.substring(0, index);
            } else {
                return "-1";
            }
        } catch (Exception e) {
            return "-1";
        }
    }

    /**
     * 获取计算机名，依次尝试环境变量 COMPUTERNAME、HOSTNAME 与本机主机名。
     *
     * @return 计算机名；获取失败时返回 "unknown"
     */
    public static String getComputerName() {
        try {
            var name = System.getenv("COMPUTERNAME");
            if (name == null || name.isEmpty()) {
                name = System.getenv("HOSTNAME");
            }
            if (name == null || name.isEmpty()) {
                name = InetAddress.getLocalHost().getHostName();
            }
            return name != null ? name : "unknown";
        } catch (Exception e) {
            return "unknown";
        }
    }

    /**
     * 获取当前用户名，依次尝试环境变量 USERNAME、USER 与 user.name。
     *
     * @return 当前用户名；获取失败时返回 "unknown"
     */
    public static String getUserName() {
        try {
            String user = System.getenv("USERNAME");

            if (user == null || user.isEmpty()) {
                user = System.getenv("USER");
            }
            if (user == null || user.isEmpty()) {
                user = System.getenv("user.name");
            }
            if (user == null || user.isEmpty()) {
                user = "unknown";
            }
            return user;
        } catch (Exception e) {
            return "unknown";
        }
    }


    /**
     * 打印 Banner 及构建元数据、JDK 版本、PID、计算机名、用户名与当前时间。
     * 若元数据资源不存在则直接返回。
     *
     * @throws IOException 读取元数据资源失败时抛出
     */
    public static void printb() throws IOException {
        InputStream inputStream = Main.class.getResourceAsStream("/assets/mingli-utils/meta-data");
        if (inputStream == null) return;
        String data = new String(inputStream.readAllBytes());
        inputStream.close();
        StringBuilder sb = new StringBuilder(BANNER);
        for (String sz : data.split("\n")) {
            var d = sz.split("=");
            sb.append("| -> ").append(d[0]).append(": ").append(d[1]).append("\n");
        }
        sb.append("| -> jdkVersion: ").append(System.getProperty("java.specification.version")).append("\n");
        sb.append("| -> pid: ").append(getPid()).append("\n");
        sb.append("| -> computerName: ").append(getComputerName()).append("\n");
        sb.append("| -> userName: ").append(getUserName()).append("\n");
        sb.append("| -> time: ")
                .append(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS")))
                .append("\n");
        System.out.println();
        System.out.println(sb);
    }
}
