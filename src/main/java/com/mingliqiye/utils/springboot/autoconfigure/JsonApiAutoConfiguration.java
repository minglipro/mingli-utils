package com.mingliqiye.utils.springboot.autoconfigure;

import com.mingliqiye.utils.json.JsonApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@AutoConfiguration
@AutoConfigureAfter(
	name = {
		"com.mingliqiye.utils.springboot.autoconfigure.GsonAutoConfiguration",
		"com.mingliqiye.utils.springboot.autoconfigure.JacksonAutoConfiguration",
	}
)
public class JsonApiAutoConfiguration {

	private static final Logger log = LoggerFactory.getLogger(
		"MingliUtils-JsonApiAutoConfiguration"
	);

	@Bean
	@Primary
	@ConditionalOnMissingBean
	@ConditionalOnClass(
		name = { "com.fasterxml.jackson.databind.ObjectMapper" }
	)
	public JsonApi jacksonJsonApi(
		com.fasterxml.jackson.databind.ObjectMapper objectMapper
	) {
		log.info(
			"MingliUtils-JsonApiAutoConfiguration: JacksonJsonApi bean is created."
		);
		return new com.mingliqiye.utils.json.JacksonJsonApi(objectMapper);
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnClass(name = { "com.google.gson.Gson" })
	public JsonApi gsonJsonApi(com.google.gson.Gson gson) {
		log.info(
			"MingliUtils-JsonApiAutoConfiguration: GsonJsonApi bean is created."
		);
		return new com.mingliqiye.utils.json.GsonJsonApi(gson);
	}
}
