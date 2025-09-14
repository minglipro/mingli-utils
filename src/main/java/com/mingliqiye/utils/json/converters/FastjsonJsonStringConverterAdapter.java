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
 * CurrentFile FastjsonJsonStringConverterAdapter.java
 * LastUpdate 2025-09-14 22:12:16
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.writer.ObjectWriter;

import java.lang.reflect.Type;

public class FastjsonJsonStringConverterAdapter<
	T extends JsonStringConverter<TT>,
	TT
> {

	private final JsonStringConverter<TT> jsonStringConverter;

	public FastjsonJsonStringConverterAdapter(T jsonStringConverter) {
		this.jsonStringConverter = jsonStringConverter;
	}

	public static <
		T extends JsonStringConverter<TT>,
		TT
	> FastjsonJsonStringConverterAdapter<T, TT> of(T t) {
		return new FastjsonJsonStringConverterAdapter<>(t);
	}

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
			writer.writeString(jsonStringConverter.convert((TT) object));
		};
	}

	/**
	 * 获取FastJson对象读取器
	 *
	 * @return FastJson的ObjectReader实例
	 */
	public ObjectReader<TT> getFastJsonObjectReader() {
		return (
			JSONReader reader,
			Type fieldType,
			Object fieldName,
			long features
		) -> {
			String value = reader.readString();
			return jsonStringConverter.deConvert(value);
		};
	}
}
