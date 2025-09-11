package com.mingliqiye.utils.json.converters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

/**
 * JSON转换器的适配器
 * @param <T> JSON转换器
 * @param <TT> JSON转换器的泛型
 * @author MingLiPro
 */
public class JacksonJsonStringConverterAdapter<
	T extends JsonStringConverter<TT>,
	TT
> {

	private final JsonStringConverter<TT> jsonStringConverter;

	private JacksonJsonStringConverterAdapter(T jsonStringConverter) {
		this.jsonStringConverter = jsonStringConverter;
	}

	/**
	 *
	 * @param t JSON转换器实例
	 * @return JSON转换器的适配器
	 * @param <T> JSON转换器
	 * @param <TT> JSON转换器的泛型
	 */
	public static <
		T extends JsonStringConverter<TT>,
		TT
	> JacksonJsonStringConverterAdapter<T, TT> of(T t) {
		return new JacksonJsonStringConverterAdapter<>(t);
	}

	/**
	 * 获取Jackson反序列化器
	 *
	 * @return Jackson的JsonDeserializer实例
	 */
	public JsonDeserializer<TT> getJacksonJsonDeserializer() {
		return new JsonDeserializer<TT>() {
			@Override
			public TT deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException {
				if (p.isNaN()) return null;
				return jsonStringConverter.deConvert(p.getValueAsString());
			}
		};
	}

	/**
	 * 获取Jackson序列化器
	 *
	 * @return Jackson的JsonSerializer实例
	 */
	public JsonSerializer<TT> getJacksonJsonSerializer() {
		return new JsonSerializer<TT>() {
			@Override
			public void serialize(
				TT value,
				JsonGenerator gen,
				SerializerProvider serializers
			) throws IOException {
				if (value == null) {
					gen.writeNull();
					return;
				}
				gen.writeString(jsonStringConverter.convert(value));
			}
		};
	}

	/**
	 *
	 * 获取 Jackson 的格式化模块
	 *
	 * @return 格式化模块
	 */
	public Module getJacksonModule() {
		Class<TT> tClass = jsonStringConverter.getTClass();
		SimpleModule m = new SimpleModule(tClass.getSimpleName());
		m.addSerializer(tClass, getJacksonJsonSerializer());
		m.addDeserializer(tClass, getJacksonJsonDeserializer());
		return m;
	}
}
