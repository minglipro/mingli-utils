package com.mingliqiye.utils.springboot.autoconfigure;

import com.mingliqiye.utils.bean.springboot.SpringBeanUtil;
import com.mingliqiye.utils.collection.ForEach;
import com.mingliqiye.utils.jackson.Serializers;
import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.time.Formatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author MingLiPro
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(AutoConfiguration.class)
@ComponentScan({ SpringBeanUtil.PACKAGE_NAME })
public class AutoConfiguration {

	private static String banner =
		"---------------------------------------------------------\n" +
		"|  $$\\      $$\\ $$\\      $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   |\n" +
		"|  $$$\\    $$$ |$$ |     $$ |  $$ |\\__$$  __|$$  __$$\\  |\n" +
		"|  $$$$\\  $$$$ |$$ |     $$ |  $$ |   $$ |   $$ /  \\__| |\n" +
		"|  $$\\$$\\$$ $$ |$$ |     $$ |  $$ |   $$ |   \\$$$$$$\\   |\n" +
		"|  $$ \\$$$  $$ |$$ |     $$ |  $$ |   $$ |    \\____$$\\  |\n" +
		"|  $$ |\\$  /$$ |$$ |     $$ |  $$ |   $$ |   $$\\   $$ | |\n" +
		"|  $$ | \\_/ $$ |$$$$$$$$\\\\$$$$$$  |   $$ |   \\$$$$$$  | |\n" +
		"|  \\__|     \\__|\\________|\\______/    \\__|    \\______/  |\n";
	private boolean isloadObjMapper;

	public AutoConfiguration() throws IOException {
		print();

		try {
			Class<?> clasz = ClassLoader.getSystemClassLoader().loadClass(
				"com.fasterxml.jackson.databind.ObjectMapper"
			);
			isloadObjMapper = true;
		} catch (ClassNotFoundException ignored) {
			log.info(
				"Jackson ObjectMapper not found in classpath. Jackson serialization features will be disabled."
			);
		}
	}

	@PostConstruct
	public void init() {
		if (isloadObjMapper) {
			log.info("init ObjectMapper");
			Serializers.addSerializers(
				SpringBeanUtil.getBean(
					com.fasterxml.jackson.databind.ObjectMapper.class
				)
			);
			log.info("add ObjectMapper Serializers OK");
		} else {
			log.info("ObjectMapper is Not Found");
		}
	}

	public void print() throws IOException {
		InputStream inputStream = AutoConfiguration.class.getResourceAsStream(
			"/META-INF/meta-data"
		);
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
				// 直接计算需要的空格数来对齐
				int targetLength = 56; // 为右侧的 | 留出空间
				if (content.length() < targetLength) {
					int spacesNeeded = targetLength - content.length();
					StringBuilder da = new StringBuilder(content);
					for (int ia = 0; ia < spacesNeeded; ia++) {
						da.append(" ");
					}
					banner += da + "|\n";
				} else {
					banner += content.substring(0, targetLength) + "|\n";
				}
			}
		});
		System.out.printf(
			banner,
			DateTime.now().format(Formatter.STANDARD_DATETIME_MILLISECOUND7)
		);
		System.out.println(
			"---------------------------------------------------------"
		);
	}
}
