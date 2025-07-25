# mingli-utils

一个功能丰富的Java工具类库，提供字符串处理、时间处理、文件操作、网络工具、哈希计算等常用工具方法。

## 项目概述

mingli-utils 是一个 Java 工具类库，提供各种常用的工具方法，旨在简化开发流程，减少重复代码。

## 技术栈

- JDK 版本: Java 8
- 构建工具: Gradle (Kotlin DSL)
- 依赖库:
    - Lombok 1.18.38: 用于简化 Java Bean 代码
    - Jackson Databind 2.19.2: 用于 JSON 序列化
    - MyBatis 3.5.19: 持久层框架
    - Spring Boot Starter 2.7.14: Spring Boot基础依赖
    - Bouncy Castle 1.81: 加密算法库
    - UUID Creator 6.1.0: UUID生成工具
    - jBCrypt 0.4: BCrypt加密实现
    - JetBrains Annotations 24.0.0: 注解库

## 主要功能模块

### 字符串处理 (StringUtil)

提供常用的字符串操作方法：

- `toString()`: 对象转字符串
- `format()`: 格式化字符串
- `isEmpty()`: 判断字符串是否为空
- `join()`: 连接字符串
- `split()`: 分割字符串

### 集合工具 (Lists)

提供创建各种List实现的便捷方法：

- `newArrayList()`: 创建ArrayList实例
- `newLinkedList()`: 创建LinkedList实例
- `newVector()`: 创建Vector实例

### 时间处理 (time)

提供时间相关功能：

- `DateTime`: 时间处理类，封装了LocalDateTime的操作
- `DateTimeOffset`: 时间偏移量处理
- `Formatter`: 常用时间格式枚举
- `DateTimeUnit`: 时间单位常量定义

### 文件操作 (FileUtil)

提供文件读写等操作：

- `readFileToString()`: 读取文件内容为字符串
- `writeStringToFile()`: 将字符串写入文件
- `readLines()`: 读取文件内容为字符串列表（按行分割）
- `writeLines()`: 将字符串列表写入文件（每行一个元素）
- `copyFile()`: 复制文件
- `deleteFile()`: 删除文件
- `exists()`: 检查文件是否存在
- `getFileSize()`: 获取文件大小

### 网络工具 (network)

提供网络地址处理功能：

- `NetworkEndpoint`: 网络端点（IP+端口）封装
- `NetworkAddress`: 网络地址处理（支持IPv4/IPv6）
- `NetworkPort`: 网络端口处理

### 哈希工具 (HashUtils)

提供哈希计算功能：

- `calculateFileHash()`: 计算文件哈希值
- `bcrypt()`: BCrypt加密
- `checkBcrypt()`: 验证BCrypt哈希

### 系统工具 (SystemUtil)

提供系统相关工具方法：

- `isWindows()/isMac()/isUnix()`: 操作系统类型判断
- `getJdkVersion()`: 获取JDK版本
- `getLocalIps()`: 获取本地IP地址

### UUID工具 (uuid)

提供UUID处理功能：

- `UUID`: UUID封装类，支持时间戳型UUID

### 并发工具 (concurrent)

提供线程安全的数据结构：

- `IsChanged`: 基于CAS操作的线程安全包装类

### 函数式工具 (functions)

提供函数式编程支持：

- `Debouncer`: 防抖器实现

## 使用示例

```java
// 字符串格式化
String message =
        StringUtil.format("Hello {}, you are {} years old", "张三", 25);

// 创建列表
List<String> fruits = Lists.newArrayList("苹果", "香蕉", "橙子");

// 连接字符串
String result = StringUtil.join(", ", fruits);

// 时间处理
DateTime now = DateTime.now();
String formatted = now.format(Formatter.STANDARD_DATETIME);

// 文件操作
FileUtil.

writeStringToFile("example.txt","Hello World");

String content = FileUtil.readFileToString("example.txt");

// 网络地址处理
NetworkEndpoint endpoint = NetworkEndpoint.of("127.0.0.1", 8080);
InetSocketAddress address = endpoint.toInetSocketAddress();

// 哈希计算
String hash = HashUtils.bcrypt("password");
boolean matches = HashUtils.checkBcrypt("password", hash);
```

## 构建和运行

使用以下命令构建项目：

```bash
./gradlew build
```

发布到本地Maven仓库：

```bash
./gradlew publishToMavenLocal
```

## 项目配置

项目在 `gradle.properties` 中定义了以下配置：

```properties
JDKVERSIONS=1.8
GROUPSID=com.mingliqiye.utils
ARTIFACTID=mingli-utils
VERSIONS=1.0.4
```

## License

本项目采用Apache 2.0许可证，详细信息请查看 [LICENSE](LICENSE) 文件。
