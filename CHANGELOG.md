# Changelog

本文件记录 mingli-utils 各版本的主要变更。

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