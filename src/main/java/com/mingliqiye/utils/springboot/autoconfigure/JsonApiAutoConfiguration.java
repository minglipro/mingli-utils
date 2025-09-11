package com.mingliqiye.utils.springboot.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mingliqiye.utils.json.GsonJsonApi;
import com.mingliqiye.utils.json.JacksonJsonApi;
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
	@ConditionalOnClass(ObjectMapper.class)
	public JsonApi jacksonJsonApi(ObjectMapper objectMapper) {
		log.info(
			"MingliUtils-JsonApiAutoConfiguration: JacksonJsonApi bean is created."
		);
		return new JacksonJsonApi(objectMapper);
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnClass(Gson.class)
	public JsonApi gsonJsonApi(Gson gson) {
		log.info(
			"MingliUtils-JsonApiAutoConfiguration: GsonJsonApi bean is created."
		);
		return new GsonJsonApi(gson);
	}
}
