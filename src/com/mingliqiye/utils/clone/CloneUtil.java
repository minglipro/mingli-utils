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
 * CurrentFile CloneUtil.java
 * LastUpdate 2025-09-09 09:32:17
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.clone;

import com.mingliqiye.utils.json.JsonApi;
import com.mingliqiye.utils.json.JsonException;
import java.io.*;

public class CloneUtil {

	/**
	 * 对指定的可序列化对象进行深拷贝
	 *
	 * @param object 需要进行深拷贝的对象，必须实现Serializable接口
	 * @param <T> 对象的类型，必须实现Serializable接口
	 * @return 深拷贝后的新对象，与原对象内容相同但内存地址不同
	 * @throws RuntimeException 当序列化或反序列化过程中发生IO异常或类未找到异常时抛出
	 */
	public static <T extends Serializable> T deepClone(T object) {
		try {
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bao);
			oos.writeObject(object);
			ByteArrayInputStream bis = new ByteArrayInputStream(
				bao.toByteArray()
			);
			ObjectInputStream ois = new ObjectInputStream(bis);
			return (T) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 深度克隆对象，使用JSON序列化和反序列化实现
	 *
	 * @param <T> 对象类型参数
	 * @param object 需要克隆的对象实例
	 * @param jsonApi JSON序列化接口实现
	 * @return 克隆后的对象实例
	 */
	public static <T> T deepJsonClone(T object, JsonApi jsonApi) {
		if (object == null) {
			return null;
		}

		if (jsonApi == null) {
			throw new IllegalArgumentException("jsonApi cannot be null");
		}

		try {
			return (T) jsonApi.convert(object, object.getClass());
		} catch (Exception e) {
			throw new JsonException(
				"Failed to deep clone object using JSON",
				e
			);
		}
	}
}
