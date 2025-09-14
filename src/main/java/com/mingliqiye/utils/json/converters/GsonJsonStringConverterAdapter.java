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
 * CurrentFile GsonJsonStringConverterAdapter.java
 * LastUpdate 2025-09-14 22:12:16
 * UpdateUser MingLiPro
 */

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
