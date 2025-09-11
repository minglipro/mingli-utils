package com.mingliqiye.utils.springboot.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter;
import com.mingliqiye.utils.json.converters.UUIDJsonStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

@ConditionalOnClass(ObjectMapper.class)
@AutoConfiguration
@AutoConfigureAfter(
	name = {
		"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration",
	}
)
public class JacksonAutoConfiguration {

	private static final Logger log = LoggerFactory.getLogger(
		"MingliUtils-JacksonAutoConfiguration"
	);

	public JacksonAutoConfiguration(ObjectMapper objectMapper) {
		addModules(objectMapper);
		log.info("MingliUtils Jackson Serializers created");
	}

	public static ObjectMapper addModules(ObjectMapper objectMapper) {
		return objectMapper
			.registerModule(new UUIDJsonStringConverter().getJacksonModule())
			.registerModule(new DateTimeJsonConverter().getJacksonModule());
	}
}
