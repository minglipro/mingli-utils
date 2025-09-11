package com.mingliqiye.utils.springboot.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mingliqiye.utils.jackson.Serializers;
import com.mingliqiye.utils.json.JacksonJsonApi;
import com.mingliqiye.utils.json.JsonApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@AutoConfigureAfter(
	name = {
		"org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration",
	}
)
@ConditionalOnClass(ObjectMapper.class)
public class JacksonAutoConfiguration {

	private final Logger log = LoggerFactory.getLogger(
		"MingliUtils-JacksonAutoConfiguration"
	);

	public JacksonAutoConfiguration() {
		log.info("MingliUtils JacksonAutoConfiguration succeed");
	}

	@Bean
	public JsonApi jsonApi(ObjectMapper objectMapper) {
		log.info("Creating JacksonJsonApi bean");
		Serializers.addSerializers(objectMapper);
		log.info("MingliUtils Serializers created");
		return new JacksonJsonApi(objectMapper);
	}
}
