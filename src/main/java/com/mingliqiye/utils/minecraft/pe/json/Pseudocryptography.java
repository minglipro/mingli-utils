package com.mingliqiye.utils.minecraft.pe.json;

import com.mingliqiye.utils.collection.ForEach;
import com.mingliqiye.utils.file.FileUtil;
import com.mingliqiye.utils.json.JsonApi;
import com.mingliqiye.utils.json.JsonTypeReference;
import com.mingliqiye.utils.string.StringUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.val;

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
			return StringUtil.stringToUnicode((String) object);
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
			FileUtil.writeStringToFile(StringUtil.format("old-{}", path), s);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
