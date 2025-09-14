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
 * CurrentFile Pseudocryptography.java
 * LastUpdate 2025-09-14 22:12:16
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.minecraft.pe.json;

import com.mingliqiye.utils.collection.ForEach;
import com.mingliqiye.utils.file.FileUtil;
import com.mingliqiye.utils.json.JsonApi;
import com.mingliqiye.utils.json.JsonTypeReference;
import com.mingliqiye.utils.string.StringUtils;
import lombok.val;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pseudocryptography {

	private final JsonApi jsonApi;

	public Pseudocryptography(JsonApi jsonApi) {
		this.jsonApi = jsonApi;
	}

	private Object prossed(Object object) {
		if (object instanceof Map) {
			System.out.println(object.getClass());
			val map = new HashMap<>((Map<Object, Object>) object);
			val map2 = new HashMap<>(map.size() + 3);
			map.forEach((key, value) -> {
				if (key instanceof String) {
					map2.put(prossed(key), prossed(value));
				}
			});

			return map2;
		} else if (object instanceof String) {
			return StringUtils.stringToUnicode((String) object);
		} else if (object instanceof List) {
			ForEach.forEach((List<Object>) object, (t, i) -> {
				((List<Object>) object).set(i, prossed(t));
			});
		}
		return object;
	}

	public void decode(String path) {
		try {
			final Map<String, Object> map = jsonApi.parseFrom(
				path,
				new JsonTypeReference<HashMap<String, Object>>() {}
			);

			String s = jsonApi.format(prossed(map)).replace("\\\\u", "\\u");
			FileUtil.writeStringToFile(StringUtils.format("old-{}", path), s);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
