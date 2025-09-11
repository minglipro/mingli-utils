package com.mingliqiye.utils.springboot.converters;

import static com.mingliqiye.utils.time.Formatter.STANDARD_DATETIME;

import com.mingliqiye.utils.time.DateTime;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * spring boot DateTime到字符串转换器
 *
 * @author MingliPro
 * @see DateTime
 *
 *
 */
@Component
public class DateTimeToStringConverter implements Converter<DateTime, String> {

	@Override
	public String convert(@NotNull DateTime source) {
		return source.format(STANDARD_DATETIME);
	}
}
