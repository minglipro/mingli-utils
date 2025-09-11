package com.mingliqiye.utils.json;

import com.google.gson.*;

public class GsonJsonApi implements JsonApi {

	private final Gson gson;
	private final Gson gsonUnicode;
	private final Gson gsonPretty;
	private final Gson gsonPrettyUnicode;

	public GsonJsonApi() {
		gson = new GsonBuilder()
			.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
			.create();

		gsonUnicode = new GsonBuilder()
			.disableHtmlEscaping()
			.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
			.create();

		gsonPretty = new GsonBuilder()
			.setPrettyPrinting()
			.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
			.create();

		gsonPrettyUnicode = new GsonBuilder()
			.setPrettyPrinting()
			.disableHtmlEscaping()
			.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
			.create();
	}

	public GsonJsonApi(Gson gson) {
		this.gson = gson
			.newBuilder()
			.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
			.create();
		this.gsonUnicode = gson
			.newBuilder()
			.disableHtmlEscaping()
			.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
			.create();
		this.gsonPretty = gson
			.newBuilder()
			.setPrettyPrinting()
			.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
			.create();
		this.gsonPrettyUnicode = gson
			.newBuilder()
			.setPrettyPrinting()
			.disableHtmlEscaping()
			.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
			.create();
	}

	@Override
	public <T> T parse(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	@Override
	public <T> T parse(String json, JsonTypeReference<T> type) {
		return gson.fromJson(json, type.getType());
	}

	@Override
	public String format(Object object) {
		return gson.toJson(object);
	}

	@Override
	public String formatUnicode(Object object) {
		return gsonUnicode.toJson(object);
	}

	@Override
	public String formatPretty(Object object) {
		return gsonPretty.toJson(object);
	}

	@Override
	public String formatPrettyUnicode(Object object) {
		return gsonPrettyUnicode.toJson(object);
	}

	@Override
	public boolean isValidJson(String json) {
		try {
			JsonElement element = JsonParser.parseString(json);
			return true;
		} catch (JsonSyntaxException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String merge(String... jsons) {
		JsonObject merged = new JsonObject();
		for (String json : jsons) {
			if (json == null || json.isEmpty()) {
				continue;
			}
			try {
				JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
				for (String key : obj.keySet()) {
					merged.add(key, obj.get(key));
				}
			} catch (Exception e) {
				// 忽略无效的 JSON 字符串
			}
		}
		return gson.toJson(merged);
	}

	@Override
	public String getNodeValue(String json, String path) {
		try {
			JsonElement element = JsonParser.parseString(json);
			String[] paths = path.split("\\.");
			JsonElement current = element;

			for (String p : paths) {
				if (current.isJsonObject()) {
					current = current.getAsJsonObject().get(p);
				} else {
					return null;
				}

				if (current == null) {
					return null;
				}
			}

			return current.isJsonPrimitive()
				? current.getAsString()
				: current.toString();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String updateNodeValue(String json, String path, Object newValue) {
		try {
			JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
			String[] paths = path.split("\\.");
			JsonObject current = obj;

			// 导航到倒数第二层
			for (int i = 0; i < paths.length - 1; i++) {
				String p = paths[i];
				if (!current.has(p) || !current.get(p).isJsonObject()) {
					current.add(p, new JsonObject());
				}
				current = current.getAsJsonObject(p);
			}

			// 设置最后一层的值
			String lastPath = paths[paths.length - 1];
			if (newValue == null) {
				current.remove(lastPath);
			} else {
				JsonElement element = gson.toJsonTree(newValue);
				current.add(lastPath, element);
			}

			return gson.toJson(obj);
		} catch (Exception e) {
			return json;
		}
	}

	@Override
	public <T, D> D convert(T source, Class<D> destinationClass) {
		String json = gson.toJson(source);
		return gson.fromJson(json, destinationClass);
	}

	@Override
	public <T, D> D convert(T source, JsonTypeReference<D> destinationType) {
		String json = gson.toJson(source);
		return gson.fromJson(json, destinationType.getType());
	}
}
