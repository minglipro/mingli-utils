package com.mingliqiye.utils.springboot.converters;

import com.mingliqiye.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * spring boot UUID到字符串转换器
 * @see UUID
 * @author MingliPro
 */
@Component
public class UUIDToStringConverter implements Converter<UUID, String> {

	@Override
	public String convert(@NotNull UUID source) {
		return source.toUUIDString();
	}
}
