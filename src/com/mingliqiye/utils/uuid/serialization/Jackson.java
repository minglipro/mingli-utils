package com.mingliqiye.utils.uuid.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mingliqiye.utils.uuid.UUID;
import com.mingliqiye.utils.uuid.UUIDException;
import java.io.IOException;

/**
 * Jackson 序列化/反序列化适配器类，用于处理自定义 UUID 类的 JSON 转换
 *
 * @author MingLiPro
 */
public class Jackson {

	/**
	 * 为ObjectMapper添加UUID序列化和反序列化器
	 *
	 * @param objectMapper ObjectMapper实例，用于注册自定义序列化模块
	 */
	public static void addSerializers(ObjectMapper objectMapper) {
		// 创建SimpleModule并添加UUID的序列化器和反序列化器
		SimpleModule module = new SimpleModule()
			.addSerializer(UUID.class, new UUIDJsonSerializer())
			.addDeserializer(UUID.class, new UUIDJsonDeserializer());
		objectMapper.registerModule(module);
	}

	/**
	 * UUID 反序列化器
	 * <p>
	 * 将 JSON 字符串反序列化为自定义 UUID 对象
	 */
	public static class UUIDJsonDeserializer extends JsonDeserializer<UUID> {

		/**
		 * 反序列化方法：将 JSON 解析为 UUID 对象
		 *
		 * @param p    JSON 解析器对象
		 * @param ctxt 反序列化上下文
		 * @return 解析后的 UUID 对象，若输入为 NaN 则返回 null
		 * @throws IOException 当解析过程中发生 IO 异常时抛出
		 */
		@Override
		public UUID deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException {
			// 如果是 NaN 值则返回 null
			if (p.isNaN()) {
				return null;
			}
			// 使用指定字符串值创建新的 UUID 对象
			return new UUID(p.getValueAsString());
		}
	}

	/**
	 * UUID 序列化器
	 * <p>
	 * 将自定义 UUID 对象序列化为 JSON 字符串
	 */
	public static class UUIDJsonSerializer extends JsonSerializer<UUID> {

		/**
		 * 序列化方法：将 UUID 对象写入 JSON 生成器
		 *
		 * @param uuid               要序列化的 UUID 对象
		 * @param jsonGenerator      JSON 生成器
		 * @param serializerProvider 序列化提供者
		 * @throws UUIDException 当 UUID 处理过程中发生异常时抛出
		 * @throws IOException   当写入过程中发生 IO 异常时抛出
		 */
		@Override
		public void serialize(
			UUID uuid,
			JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider
		) throws UUIDException, IOException {
			// 若值为 null，则直接写入 null
			if (uuid == null) {
				jsonGenerator.writeNull();
				return;
			}
			// 将 UUID 写入为字符串
			jsonGenerator.writeString(uuid.toUUIDString());
		}

		/**
		 * 带类型信息的序列化方法：用于支持多态类型处理
		 *
		 * @param value       要序列化的 UUID 对象
		 * @param gen         JSON 生成器
		 * @param serializers 序列化提供者
		 * @param typeSer     类型序列化器
		 * @throws IOException 当写入过程中发生 IO 异常时抛出
		 */
		@Override
		public void serializeWithType(
			UUID value,
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
