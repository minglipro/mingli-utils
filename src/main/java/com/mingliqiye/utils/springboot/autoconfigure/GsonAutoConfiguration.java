package com.mingliqiye.utils.springboot.autoconfigure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter;
import com.mingliqiye.utils.json.converters.JsonStringConverter;
import com.mingliqiye.utils.json.converters.UUIDJsonStringConverter;
import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.uuid.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@ConditionalOnClass(Gson.class)
@AutoConfiguration
@AutoConfigureAfter(
	name = {
		"org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration",
	}
)
public class GsonAutoConfiguration {

	private static final Logger log = LoggerFactory.getLogger(
		"MingliUtils-GsonAutoConfiguration"
	);

	public static GsonBuilder addTypeAdapter(GsonBuilder gsonBuilder) {
		JsonStringConverter<DateTime> dateTimeJsonConverter =
			new DateTimeJsonConverter();
		JsonStringConverter<UUID> uuidJsonStringConverter =
			new UUIDJsonStringConverter();
		return gsonBuilder
			.registerTypeAdapter(
				uuidJsonStringConverter.getTClass(),
				uuidJsonStringConverter.getGsonTypeAdapter()
			)
			.registerTypeAdapter(
				dateTimeJsonConverter.getTClass(),
				dateTimeJsonConverter.getGsonTypeAdapter()
			);
	}

	@Bean
	@Primary
	@ConditionalOnMissingBean
	public GsonBuilder gsonBuilder() {
		try {
			return addTypeAdapter(new GsonBuilder());
		} finally {
			log.info("MingliUtils GsonBuilder TypeAdapter add");
		}
	}
}
