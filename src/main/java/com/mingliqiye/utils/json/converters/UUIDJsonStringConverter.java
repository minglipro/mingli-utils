package com.mingliqiye.utils.json.converters;

import com.mingliqiye.utils.uuid.UUID;

public class UUIDJsonStringConverter extends JsonStringConverter<UUID> {

	@Override
	public Class<UUID> getTClass() {
		return UUID.class;
	}

	@Override
	public String convert(UUID obj) {
		if (obj == null) {
			return null;
		}
		return obj.toUUIDString();
	}

	@Override
	public UUID deConvert(String string) {
		if (string == null) {
			return null;
		}
		return UUID.of(string);
	}
}
