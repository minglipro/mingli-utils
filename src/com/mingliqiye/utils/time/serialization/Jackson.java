package com.mingliqiye.utils.time.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.time.Formatter;

import java.io.IOException;

/**
 * Jackson 适配器
 *
 * @author MingLiPro
 */
public class Jackson {

	/**
	 * 为ObjectMapper添加自定义的 DateTime 序列化器和反序列化器
	 *
	 * @param objectMapper 用于注册自定义序列化模块的ObjectMapper实例
	 */
	public static void addSerializers(ObjectMapper objectMapper) {
		// 创建SimpleModule并添加DateTime类型的序列化器和反序列化器
		SimpleModule module = new SimpleModule()
			.addSerializer(DateTime.class, new DateTimeJsonSerializerM7())
			.addDeserializer(DateTime.class, new DateTimeJsonDeserializerM7());
		objectMapper.registerModule(module);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss.SSSSSSS 的反序列化适配器
	 * <p>
	 * 将 JSON 字符串按照指定格式解析为 DateTime 对象。
	 */
	public static class DateTimeJsonDeserializerM7
		extends DateTimeJsonDeserializer {

		/**
		 * 获取当前使用的日期时间格式化器
		 *
		 * @return 返回标准的 7 位毫秒时间格式化器
		 */
		@Override
		public Formatter getFormatter() {
			return Formatter.STANDARD_DATETIME_MILLISECOUND7;
		}
	}

	/**
	 * 默认日期时间反序列化器
	 * <p>
	 * 提供基础的日期时间反序列化功能，支持自定义格式化器。
	 */
	public static class DateTimeJsonDeserializer
		extends JsonDeserializer<DateTime> {

		/**
		 * 获取当前使用的日期时间格式化器
		 *
		 * @return 返回标准的日期时间格式化器
		 */
		public Formatter getFormatter() {
			return Formatter.STANDARD_DATETIME;
		}

		/**
		 * 获取格式化器对应的字符串表达式
		 *
		 * @return 格式化器的字符串值
		 */
		public String getFormatterString() {
			return getFormatter().getValue();
		}

		/**
		 * 反序列化方法：将 JSON 解析为 DateTime 对象
		 *
		 * @param p    JSON 解析器对象
		 * @param ctxt 反序列化上下文
		 * @return 解析后的 DateTime 对象，若输入为 NaN 则返回 null
		 * @throws IOException 当解析过程中发生 IO 异常时抛出
		 */
		@Override
		public DateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException {
			// 如果是 NaN 值则返回 null
			if (p.isNaN()) {
				return null;
			}
			// 使用指定格式将字符串解析为 DateTime 对象
			return DateTime.parse(
				p.getValueAsString(),
				getFormatterString(),
				true
			);
		}
	}

	/**
	 * yyyy-MM-dd HH:mm:ss.SSSSSSS 的序列化适配器
	 * <p>
	 * 将 DateTime 对象按指定格式转换为 JSON 字符串。
	 */
	public static class DateTimeJsonSerializerM7
		extends DateTimeJsonSerializer {

		/**
		 * 获取当前使用的日期时间格式化器
		 *
		 * @return 返回标准的 7 位毫秒时间格式化器
		 */
		@Override
		public Formatter getFormatter() {
			return Formatter.STANDARD_DATETIME_MILLISECOUND7;
		}
	}

	/**
	 * 默认日期时间序列化器
	 * <p>
	 * 提供基础的日期时间序列化功能，支持自定义格式化器。
	 */
	public static class DateTimeJsonSerializer
		extends JsonSerializer<DateTime> {

		/**
		 * 获取当前使用的日期时间格式化器
		 *
		 * @return 返回标准的日期时间格式化器
		 */
		public Formatter getFormatter() {
			return Formatter.STANDARD_DATETIME;
		}

		/**
		 * 获取格式化器对应的字符串表达式
		 *
		 * @return 格式化器的字符串值
		 */
		public String getFormatterString() {
			return getFormatter().getValue();
		}

		/**
		 * 序列化方法：将 DateTime 对象写入 JSON 生成器
		 *
		 * @param value       要序列化的 DateTime 对象
		 * @param gen         JSON 生成器
		 * @param serializers 序列化提供者
		 * @throws IOException 当写入过程中发生 IO 异常时抛出
		 */
		@Override
		public void serialize(
			DateTime value,
			JsonGenerator gen,
			SerializerProvider serializers
		) throws IOException {
			// 若值为 null，则直接写入 null
			if (value == null) {
				gen.writeNull();
				return;
			}
			// 按照指定格式将 DateTime 写入为字符串
			gen.writeString(value.format(getFormatterString(), true));
		}

		/**
		 * 带类型信息的序列化方法：用于支持多态类型处理
		 *
		 * @param value       要序列化的 DateTime 对象
		 * @param gen         JSON 生成器
		 * @param serializers 序列化提供者
		 * @param typeSer     类型序列化器
		 * @throws IOException 当写入过程中发生 IO 异常时抛出
		 */
		@Override
		public void serializeWithType(
			DateTime value,
			JsonGenerator gen,
			SerializerProvider serializers,
			TypeSerializer typeSer
		) throws IOException {
			// 写入类型前缀
			WritableTypeId typeId = typeSer.writeTypePrefix(
				gen,
				typeSer.typeId(value, JsonToken.VALUE_STRING)
			);
			// 执行实际序列化
			serialize(value, gen, serializers);
			// 写入类型后缀
			typeSer.writeTypeSuffix(gen, typeId);
		}
	}
}
