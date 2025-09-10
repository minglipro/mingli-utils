/*
 * Copyright 2025 mingliqiye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ProjectName mingli-utils
 * ModuleName mingli-utils.main
 * CurrentFile AutoConfiguration.java
 * LastUpdate 2025-09-09 08:37:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure;

import com.mingliqiye.utils.bean.springboot.SpringBeanUtil;
import com.mingliqiye.utils.collection.ForEach;
import com.mingliqiye.utils.jackson.Serializers;
import com.mingliqiye.utils.json.JacksonJsonApi;
import com.mingliqiye.utils.json.JsonApi;
import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.time.Formatter;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AutoConfiguration.class)
@ComponentScan({ SpringBeanUtil.PACKAGE_NAME })
public class AutoConfiguration {

	private static final String banner =
		"---------------------------------------------------------\n" +
		"|  $$\\      $$\\ $$\\      $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   |\n" +
		"|  $$$\\    $$$ |$$ |     $$ |  $$ |\\__$$  __|$$  __$$\\  |\n" +
		"|  $$$$\\  $$$$ |$$ |     $$ |  $$ |   $$ |   $$ /  \\__| |\n" +
		"|  $$\\$$\\$$ $$ |$$ |     $$ |  $$ |   $$ |   \\$$$$$$\\   |\n" +
		"|  $$ \\$$$  $$ |$$ |     $$ |  $$ |   $$ |    \\____$$\\  |\n" +
		"|  $$ |\\$  /$$ |$$ |     $$ |  $$ |   $$ |   $$\\   $$ | |\n" +
		"|  $$ | \\_/ $$ |$$$$$$$$\\\\$$$$$$  |   $$ |   \\$$$$$$  | |\n" +
		"|  \\__|     \\__|\\________|\\______/    \\__|    \\______/  |\n";
	private static String banner2;
	private final Logger log = LoggerFactory.getLogger(AutoConfiguration.class);
	private com.fasterxml.jackson.databind.ObjectMapper objectMapper;

	public AutoConfiguration() {}

	public static void printBanner() {
		StringBuilder bannerBuilder = new StringBuilder(banner);
		try (
			InputStream inputStream =
				AutoConfiguration.class.getResourceAsStream(
					"/META-INF/meta-data"
				)
		) {
			if (inputStream == null) {
				return;
			}
			int readlen;
			byte[] buffer = new byte[1024];
			StringBuilder metaData = new StringBuilder();
			while ((readlen = inputStream.read(buffer)) != -1) {
				metaData.append(new String(buffer, 0, readlen));
			}
			ForEach.forEach(metaData.toString().split("\n"), (s, i) -> {
				String[] d = s.trim().split("=", 2);
				if (d.length >= 2) {
					String content = "|  " + d[0] + ": " + d[1];
					int targetLength = 56;
					if (content.length() < targetLength) {
						bannerBuilder.append(
							String.format("%-" + targetLength + "s|\n", content)
						);
					} else {
						bannerBuilder
							.append(content, 0, targetLength)
							.append("|\n");
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		banner2 = bannerBuilder.toString();
		System.out.printf(
			banner2,
			DateTime.now().format(Formatter.STANDARD_DATETIME_MILLISECOUND7)
		);
		System.out.println(
			"---------------------------------------------------------"
		);
	}

	@PostConstruct
	public void init() {
		try {
			Class.forName("com.fasterxml.jackson.databind.ObjectMapper");
			log.info("init ObjectMapper");
			objectMapper = SpringBeanUtil.getBean(
				com.fasterxml.jackson.databind.ObjectMapper.class
			);
			Serializers.addSerializers(objectMapper);
			log.info("add ObjectMapper Serializers OK");
		} catch (ClassNotFoundException ignored) {
			log.info(
				"Jackson ObjectMapper not found in classpath. Jackson serialization features will be disabled."
			);
		} catch (Exception e) {
			log.warn("Failed to initialize ObjectMapper", e);
		}
		printBanner();
	}

	@Bean
	@ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
	public JsonApi jsonApi() {
		if (objectMapper == null) {
			log.warn(
				"ObjectMapper is not available, returning null for JsonApi"
			);
			return null;
		}
		log.info("Creating JacksonJsonApi bean");
		return new JacksonJsonApi(objectMapper);
	}
}
