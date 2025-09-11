package com.mingliqiye.utils.json.converters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class GsonJsonStringConverterAdapter<
	T extends JsonStringConverter<TT>,
	TT
> {

	private final JsonStringConverter<TT> jsonStringConverter;

	public GsonJsonStringConverterAdapter(T jsonStringConverter) {
		this.jsonStringConverter = jsonStringConverter;
	}

	public static <
		T extends JsonStringConverter<TT>,
		TT
	> GsonJsonStringConverterAdapter<T, TT> of(T t) {
		return new GsonJsonStringConverterAdapter<>(t);
	}

	/**
	 * 获取Gson类型适配器
	 *
	 * @return Gson的TypeAdapter实例
	 */
	public TypeAdapter<TT> getGsonTypeAdapter() {
		return new TypeAdapter<TT>() {
			@Override
			public void write(JsonWriter out, TT value) throws IOException {
				if (value == null) {
					out.nullValue();
					return;
				}
				out.value(jsonStringConverter.convert(value));
			}

			@Override
			public TT read(JsonReader in) throws IOException {
				String value = in.nextString();
				return jsonStringConverter.deConvert(value);
			}
		};
	}
}
