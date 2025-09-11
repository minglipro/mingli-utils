package com.mingliqiye.utils.springboot.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mingliqiye.utils.json.JacksonJsonApi;
import com.mingliqiye.utils.json.JsonApi;
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter;
import com.mingliqiye.utils.json.converters.UUIDJsonStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

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
			.registerModule(
				new DateTimeJsonConverter()
					.getJacksonJsonStringConverterAdapter()
					.getJacksonModule()
			)
			.registerModule(
				new UUIDJsonStringConverter()
					.getJacksonJsonStringConverterAdapter()
					.getJacksonModule()
			);
	}

	@Bean
	@Primary
	@ConditionalOnMissingBean
	public JsonApi jsonApi(ObjectMapper objectMapper) {
		log.info(
			"MingliUtils-JsonApiAutoConfiguration: JacksonJsonApi bean is created."
		);
		return new JacksonJsonApi(objectMapper);
	}
}
