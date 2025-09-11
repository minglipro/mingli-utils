package com.mingliqiye.utils.springboot.converters;

import com.mingliqiye.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * spring boot 字符串到UUID转换器
 * @see UUID
 * @author MingliPro
 */
@Component
public class StringToUUIDConverter implements Converter<String, UUID> {

	@Override
	public UUID convert(@NotNull String source) {
		return UUID.of(source);
	}
}
