package com.mingliqiye.utils.springboot.converters;

import com.mingliqiye.utils.time.DateTime;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.mingliqiye.utils.time.Formatter.STANDARD_DATETIME_MILLISECOUND7;

/**
 * spring boot 字符串到DateTime转换器
 *
 * @author MingliPro
 * @see DateTime
 *
 *
 */
@Component
public class StringToDateTimeConverter implements Converter<String, DateTime> {

	@Override
	public DateTime convert(@NotNull String source) {
		return DateTime.parse(source, STANDARD_DATETIME_MILLISECOUND7, true);
	}
}
