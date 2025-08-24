package com.mingliqiye.utils.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializers {

	/**
	 * 为ObjectMapper添加自定义序列化器 uuid time
	 * @see com.mingliqiye.utils.uuid.UUID
	 * @see com.mingliqiye.utils.time.DateTime
	 * @param objectMapper ObjectMapper实例，用于注册自定义序列化器
	 */
	public static void addSerializers(ObjectMapper objectMapper) {
		// 添加UUID相关的序列化器
		com.mingliqiye.utils.uuid.serialization.Jackson.addSerializers(
			objectMapper
		);
		// 添加时间相关的序列化器
		com.mingliqiye.utils.time.serialization.Jackson.addSerializers(
			objectMapper
		);
	}
}
