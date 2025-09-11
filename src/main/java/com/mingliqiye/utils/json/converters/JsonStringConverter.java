package com.mingliqiye.utils.json.converters;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * JSON转换器接口，提供对象与字符串之间的相互转换功能，并支持多种JSON库
 *
 * @param <T> 需要转换的对象类型
 */
public abstract class JsonStringConverter<T> {

	public abstract Class<T> getTClass();

	/**
	 * 将对象转换为字符串
	 *
	 * @param obj 待转换的对象
	 * @return 转换后的字符串
	 */
	abstract String convert(T obj);

	/**
	 * 将字符串转换为对象
	 *
	 * @param string 待转换的字符串
	 * @return 转换后的对象
	 */
	abstract T deConvert(String string);

	/**
	 * 获取Jackson反序列化器
	 *
	 * @return Jackson的JsonDeserializer实例
	 */
	public JsonDeserializer<T> getJacksonJsonDeserializer() {
		return new JsonDeserializer<T>() {
			@Override
			public T deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException {
				// 如果是NaN则返回null
				if (p.isNaN()) return null;
				return deConvert(p.getValueAsString());
			}
		};
	}

	/**
	 * 获取Jackson序列化器
	 *
	 * @return Jackson的JsonSerializer实例
	 */
	public JsonSerializer<T> getJacksonJsonSerializer() {
		return new JsonSerializer<T>() {
			@Override
			public void serialize(
				T value,
				JsonGenerator gen,
				SerializerProvider serializers
			) throws IOException {
				// 如果值为null则写入null
				if (value == null) {
					gen.writeNull();
					return;
				}
				gen.writeString(convert(value));
			}
		};
	}

	public Module getJacksonModule() {
		Class<T> tClass = getTClass();
		SimpleModule m = new SimpleModule(tClass.getSimpleName());
		m.addSerializer(tClass, getJacksonJsonSerializer());
		m.addDeserializer(tClass, getJacksonJsonDeserializer());
		return m;
	}

	/**
	 * 获取Gson类型适配器
	 *
	 * @return Gson的TypeAdapter实例
	 */
	public TypeAdapter<T> getGsonTypeAdapter() {
		return new TypeAdapter<T>() {
			@Override
			public void write(JsonWriter out, T value) throws IOException {
				// 如果值为null则写入null值
				if (value == null) {
					out.nullValue();
					return;
				}
				out.value(convert(value));
			}

			@Override
			public T read(JsonReader in) throws IOException {
				String value = in.nextString();
				return deConvert(value);
			}
		};
	}

	/**
	 * FastJson 支持
	 */

	/**
	 * 获取FastJson对象写入器
	 *
	 * @return FastJson的ObjectWriter实例
	 */
	public ObjectWriter<T> getFastJsonObjectWriter() {
		return (
			JSONWriter writer,
			Object object,
			Object fieldName,
			Type fieldType,
			long features
		) -> {
			// 如果对象为null则写入null
			if (object == null) {
				writer.writeNull();
				return;
			}
			writer.writeString(convert((T) object));
		};
	}

	/**
	 * 获取FastJson对象读取器
	 *
	 * @return FastJson的ObjectReader实例
	 */
	public ObjectReader<T> getFastJsonObjectReader() {
		return (
			JSONReader reader,
			Type fieldType,
			Object fieldName,
			long features
		) -> {
			String value = reader.readString();
			return deConvert(value);
		};
	}
}
