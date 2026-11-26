# Changelog

![Maven Central](https://img.shields.io/maven-metadata/v.svg?metadataUrl=https://repository.mingliqiye.com/repository/maven-public/com/mingliqiye/utils/mingli-utils/maven-metadata.xml&label=Mingliqiye%20Maven%20Public)

本文件记录 mingli-utils 各版本的主要变更。

## [5.8.0] - 2026-11-26

### 变更

- **exception**：异常体系接入 `com.mingliqiye.exception:mingli-exception:1.1.1-Final`，
  `MingLiUtilsBaseException` 继承公共基类 `MingLiBaseException`；依赖以 `api` 暴露，
  使用方可以统一捕获公共异常基类。

## [5.7.4] - 2026-11-26

### 新增

- **json**：新增 Gson 2 的 `JsonApi` 实现（`GsonJsonApi`）、JSON 树/Reader/Writer、
  转换器桥接与 Spring Boot 自动配置；Gson 为 `compileOnly` 可选依赖。
- **json**：新增 Fastjson2 的 `JsonApi` 实现（`FastJson2JsonApi`）、JSON 树/Reader/Writer、
  转换器桥接与 Spring Boot 自动配置；Fastjson2 为 `compileOnly` 可选依赖。
  provider 优先级为 Jackson 3 > Jackson 2 > Gson > Fastjson2。
- **security**：`AesUtils` 补齐 AES/GCM 解密、随机 IV 加解密、UTF-8 字符串处理、
  IV/密钥长度校验；修复 `createSecretKeySpec("AES", ...)` 误用 `MessageDigest` 的问题。
  `SecureUtils` 新增 `constantTimeEquals`，完善随机字节与密钥归一化。
- **resource**：`ResourceUtils` 新增流、URL、按行读取、ClassLoader 重载与资源存在性判断，
  统一 UTF-8 默认字符集，修复输入流未关闭问题。
- **network**：`NetworkAddress` 支持更完整的 IPv4/IPv6 校验与方括号输入；
  `NetworkEndpoint` 支持 `[IPv6]:port`，补充值对象方法、字节/ByteBuffer 边界校验与测试。
- **netty**：新增 `NettySportIO`，按平台自动选择 IO_URING / EPOLL / KQUEUE / NIO；
  `NamedMultiThreadIoEventLoopGroup` 支持传入 `IoHandlerFactory`。

### 变更

- **build**：新增 Fastjson2 可选依赖；元数据资源路径调整为
  `/assets/mingli-utils/meta-data`，`MetaData` / `Main` 同步更新。
- **json**：转换器工具拆分到 Gson/Fastjson2 独立文件，避免未引入对应 JSON 库时加载失败。
- **network**：IPv6 端点字符串输出为 `[address]:port`；IPv4 字节数组创建改为严格长度校验。
- **test**：新增 Gson、Fastjson2、AES、SecureUtils、ResourceUtils、network 测试。

### 移除

- 移除未使用的 `com.mingliqiye.utils.require.Required` 工具。

## [5.7.3] - 2026-11-23

### 新增

- **string**：新增 `stringBuilder { ... }` 工厂函数，通过 `StringBuilder().apply { ... }`
  创建并初始化 `StringBuilder`。

### 变更

- **exception**：`HttpStatusException`、`HttpStatusExceptionEnum` 及 30 个
  `httpErrorXXX()` 快捷函数补齐 KDoc（状态码、参数、抛出异常）；快捷函数的默认
  `message` 从 `null` 改为对应状态短语（如 `"Bad Gateway"`、`"Not Found"`），
  未显式传参时异常消息不再为空。
- **exception**：`JsonFormatException` 从 `JsonParserException.kt` 拆分为独立文件，
  包名和公开 API 不变；`JsonParserException.kt` 只保留解析异常。

## [5.7.2] - 2026-11-23

### 新增

- **spring**：新增 `@FastServiceScan` 注解及 `FastServiceScanRegistrar`、
  `FastServiceScannerProcessor`——扫描继承 `FastBaseIService` 或 `FastBaseIServiceNew3518`
  的具体类并注册为 Spring Bean；仅在启动类/配置类标注该注解时生效，扫描时机在所有
  `BeanDefinitionRegistryPostProcessor`（包括 `@MapperScan` 的 `MapperScannerConfigurer`）之后。
  支持 `value` / `basePackages` / `basePackageClasses`，`value` 与 `basePackages` 通过
  `@AliasFor` 互为别名；未指定包时使用标注类所在包；已标注 `@Component` / `@Service`
  的类自动跳过，避免重复注册。
- **test**：新增 `FastServiceScanRegistrarTest`（5 个用例）与
  `FastServiceScannerProcessorTest`（2 个用例，覆盖两个基类与某个基类缺失时的跳过逻辑）。

### 变更

- **spring**：`ApplicationDestroyedRunner`、`ApplicationReadyEventListener`、
  `ApplicationStartedRunner`、`ContextClosedEventListener` 由 Java 迁移为 Kotlin 实现，
  包名、属性及 `@AliasFor` 关系保持不变。
- **spring**：`ApplicationDestroyedRunner` / `ApplicationStartedRunner` 补全
  `@Deprecated` + `ReplaceWith`，IDE 可一键替换为 `ContextClosedEventListener` /
  `ApplicationReadyEventListener`；旧 Java 版本只有 `@Deprecated(since = ...)`。
- **build**：新增 `VERSIONSTYPE`（`r` = RELEASES，`s` = SNAPSHOT）控制版本后缀；
  补充 Spring / MyBatis-Plus 测试依赖。

### 修复

- **spring**：`FastServiceScannerProcessor` 改为按类名探测两个服务基类，
  仅引入一套 MyBatis-Plus 时只跳过缺失的基类，不再因类字面量加载父类失败抛出
  `NoClassDefFoundError`。

### 注意

- 事件监听注解的 `defaultExecution` 属性仅在 Spring Framework 6.2+ 中提供；
  在 Spring 5.3 下解析这些组合注解会抛出 `AnnotationConfigurationException`，使用方需按实际
  Spring 版本选择。

## [5.7.0] - 2026-11-23

### 新增

- **lock**：新增 `RedisLock` Redis 分布式锁工具——基于 Redisson 异步 API 实现协程挂起式加锁，
  等待期间不占用线程；默认启用看门狗自动续期，支持公平锁、自定义 key 前缀与固定租期；
  提供 `withLock`（等待获取）与 `tryWithLock`（抢不到立即返回 `null`）；
  新增 `RedisLockTimeoutException`。Redisson 为可选依赖（`compileOnly`），
  使用方需自行引入（建议 Redisson 3.13+ / 4.x）。

### 变更

- **build**：`build.gradle.kts` 与 `settings.gradle.kts` 移除已废弃的 `project.properties`、
  `settings.extra` 委托写法，改用 `providers.gradleProperty` 与显式访问器；
  `processResources` 的模板展开改为显式变量表，消除 Gradle 9 的配置期弃用警告。
- **build**：`.gitignore` 的 `*lock*` 规则改为 `*.lock`，避免把新增的 `lock` 包整体忽略。

### 测试

- 新增 `RedisLockTest`（7 个用例），通过动态代理模拟 Redisson 客户端，
  覆盖正常加锁释放、等待超时、跳过执行、公平锁、业务异常仍释放、wait/lease 透传。

## [5.6.0] - 2026-11-23

### 新增

- **thread**：新增 `SuspendUtils` 协程工具——`CoroutineContext.withContext`、
  `CoroutineContext.runBlocking`（按接收者上下文执行）与顶层 `runBlocking`
  （使用调用线程的事件循环）、`asCompletableDeferred`。
- **thread**：`GlobalThreadPool` 新增 `mainDispatcher` / `ioDispatcher` / `cpuDispatcher`、
  `pools()`、`snapshotAll()`、`isShutdown`，并自动注册 JVM 关闭钩子——
  进程正常退出时优雅关闭全部池（最多等待 5 秒，超时强制关闭）。
- **thread**：`runAsync` / `callAsync` / `computeAsync` / `runAsyncAwait` / `callAsyncAwait`
  移入 `GlobalThreadPool` 并加 `@JvmStatic`；参数改为 `Runnable` / `Callable`，
  Kotlin 与 Java 均可直接使用 lambda。
- **thread**：新增 `namedThreadFactory`；`ioThreadPool` / `cpuThreadPool` /
  `scheduledThreadPool` 增加 `daemon` 与 `rejectedHandler` 参数。
- **collection**：新增 `newArrayDeque()` 的三个重载。

### 变更

- **thread**：重构 `GlobalThreadPool`——main / io / cpu / scheduled 统一守护线程与池配置；
  `shutdownAll` 覆盖全部池、改用统一截止时间、幂等、超时 `shutdownNow` 并返回是否正常终止；
  全局池关闭后提交任务抛出 `RejectedExecutionException`；scheduled 开启 `removeOnCancelPolicy`、
  关闭时丢弃未到期延迟任务；补充池与调度器初始化、拒绝策略、关闭流程及关闭钩子的 Debug 日志。
- **thread**：`mainDispatcher` / `ioDispatcher` 复用 kotlinx-coroutines 共享调度器
  （命名限流视图），`cpuDispatcher` 绑定独立 cpu 池；`ThreadPoolBuilder` 抽出
  `namedThreadFactory` 供各线程池复用。
- **stream**：`SuperStream.toArray` 返回类型补充 jspecify `@NonNull`；
  `Collection.toArray` 泛型收紧为 `T : Any`。
- 移除 `ForEach`；更新依赖与版权年份。

### 修复

- **thread**：`CoroutineContext.runBlocking` 未使用接收者上下文，行为与普通 `runBlocking` 相同。
- **thread**：全局池关闭后任务被静默丢弃、`submit` 返回永不完成 `Future` 的问题。

### 测试

- 新增 `SuspendUtilsTest`；补充 `AsyncTasksTest` 中全局池、调度器与关闭钩子相关用例。

## [5.5.4] - 2026-11-18

### 新增

- **hash**：新增 `HashCodec` 哈希编解码器接口——实现类只需重写 `hash(InputStream)` 一个方法，
  字节数组/字符串/文件/路径重载、十六进制输出（`hashHex`）与基于 `MessageDigest.isEqual`
  的常量时间校验（`verifyHash`）均由默认实现提供；新增 `MessageDigestCodec` 流式基类
  （8KB 缓冲、恒定内存、不关闭调用方流）及 13 种 JDK 标准算法实现
  （MD2、MD5、SHA-1、SHA-224/256/384/512、SHA-512/224、SHA-512/256、SHA3-224/256/384/512）；
  提供 `HashUtils` 懒加载单例（`MD2`~`SHA512256`）与 `HashType` 枚举；
  新增 `TestHash` 测试覆盖已知向量、全部算法一致性、流生命周期与文件/路径重载。
- **test**：新增非官方 Log4j2 配置 XSD（覆盖 21 种 Appender、13 种 Layout、11 种 Filter、
  滚动策略与清理条件等，未知插件元素以开放内容模型放行），`log4j2.xml` 接入 Schema 校验。

### 变更

- **springboot**：事件监听注解迁移为 Java 实现——新增 `ApplicationReadyEventListener`、
  `ContextClosedEventListener`；`ApplicationStartedRunner`、`ApplicationDestroyedRunner`
  标记为废弃；移除 Kotlin 版注解及 `ApplicationListener`、`ApplicationRunnerData`；
  `Okhttp3AutoConfiguration` 改用 `@ContextClosedEventListener`。
- **http**：`MediaType` 枚举项之间补充空行（纯格式化，无内容变更）。

### 修复

- **build**：修正 `signing.secretKeyRingFile` 属性名笔误（误插入空格）。

### 文档

- hash 包全部接口、类、枚举与懒加载单例补全中文 KDoc；
  4 个 Spring Boot 事件监听注解补全 Javadoc。

## [5.5.2] - 2026-11-17

### 新增

- **tuple**：实现 `Tuple.compareTo` 字典序比较——同类型可比较元素按自然顺序，
  其余按字符串形式比较；公共前缀相等时元素个数较少的元组在前。
  新增 `TestTuple` 测试覆盖 6 种比较场景。

## [5.5.1] - 2026-11-17

### 新增

- **json**：新增 `reader` / `witer` / `judgment` 三组抽象，为 Jackson2 与 Jackson3 分别提供
  `JsonReader`、`JsonArrayReader`、`JsonObjectReader`、`JsonWriter`、`ArrayWriter`、`ObjectWriter`
  与 `ReaderJudgment` 实现（`BaseJsonReader` / `BaseJsonWriter` / `BaseJsonJudgment` 等基类）。
- **exception**：新增 `JsonFormatException`，表示 JSON 格式错误，继承自 `JsonException`。
- **time**：`DateTime.now(zone)` 支持指定时区；新增 `DateTime.atZone(zoneId)` 时区转换方法，
  `toString()` 输出包含 `zoneId`。

### 变更

- **json**：重构转换器体系——移除按类型划分的 `BaseJsonIntConverter`、`BaseJsonStringConverter`
  等 10 个转换器及 `JsonConverter` 接口，统一由 `BaseJsonConverter` 与 `JsonConverterUtils` 处理；
  简化 `DateTimeJsonConverter`、`UUIDJsonConverter`、`NetworkEndpointJsonConverter` 与
  Jackson2/Jackson3 序列化/反序列化桥接实现；精简 `JSONA` 与 `JsonApi` 门面。
- **tuple**：`Tuple` 声明实现 `Comparable<Tuple>`；迭代器改为基于 `toMutableList()` 的简化实现。
- **springboot**：`JsonAutoConfiguration` 与 `JacksonJsonBuilder` / `JacksonJsonBuilderImpl`
  同步适配新的 JSON 转换器体系。

### 文档

- 补全 src 下全部 Kotlin 文件的中文 KDoc 与 Java 文件的 Javadoc（约 1.3 万处），
  覆盖 exception、json、springboot、mybatis/mybatisplus、thread/netty/http、
  Tuple1~Tuple100 生成类、MediaType 全部枚举项及测试代码；已有文档保持不变。

## [5.4.4] - 2026-11-17

- 构建脚本调整（build.gradle.kts 发布配置完善）。
- SpringBoot 自动配置重构：新增 `JsonAutoConfiguration` 与 `JacksonBuilder`，
  精简 Jackson2/Jackson3 JsonApi 自动配置。

## [5.4.3] - 2026-11-17

- 新增 `JacksonJsonBuilder` / `JacksonJsonBuilderImpl` 构建器。
- `DateTime`、`UUID` 小幅调整；补充 log4j2 测试配置。

## [5.4.2] - 2026-11

- 修复 `JSONA.jsonApi` 编译错误。
- **mybatisplus**：新增 `FastBaseIServiceNew3518`（适配 MyBatis-Plus 3.5.18）。

## [5.4.0] - 2026-11

- **mybatisplus**：新增 `FastBaseIService`。
- 全项目统一 Tab 缩进并补全尾随逗号。
