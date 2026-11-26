/*
 * Copyright 2026 mingliqiye
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
 * ModuleName mingli-utils.test
 * CurrentFile TestGsonJsonApi.kt
 * LastUpdate 2026-11-26 17:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.json.api.GsonJsonApi
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.DateTimeJsonConverter
import com.mingliqiye.utils.json.converters.base.registerToGson
import com.mingliqiye.utils.time.DateTime
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * [GsonJsonApi] 的基础能力测试。
 */
class TestGsonJsonApi {

	/**
	 * 测试用的简单 Bean。
	 */
	class User {
		/** 用户名 */
		var name: String? = null

		/** 年龄 */
		var age: Int = 0
	}

	private val api = GsonJsonApi()

	/**
	 * 验证按 Class 解析与序列化。
	 */
	@Test
	fun testParseAndFormat() {
		val user = api.parse("""{"name":"mingli","age":18}""", User::class.java)
		assertEquals("mingli", user.name)
		assertEquals(18, user.age)

		val json = api.format(user)
		assertTrue(json.contains(""""name":"mingli""""))
		assertTrue(json.contains(""""age":18"""))
	}

	/**
	 * 验证泛型类型解析。
	 */
	@Test
	fun testGenericParse() {
		val type = object : JsonTypeReference<List<Int>>() {}
		val list = api.parse("[1,2,3]", type)
		assertEquals(listOf(1, 2, 3), list)
	}

	/**
	 * 验证树转换与缺失字段处理。
	 */
	@Test
	fun testJsonItemTree() {
		val root = api.parseJsonItem("""{"a":1,"b":{"c":"x"},"arr":[true,null]}""")
		assertTrue(root.isObject())
		assertEquals("1", root.getField("a").asNumber().toString())
		assertTrue(root.getField("missing").isNull())
		assertEquals("x", root.getField("b").getField("c").asString())
		assertTrue(root.getField("arr").get(1).isNull())
	}

	/**
	 * 验证点号路径读取与更新。
	 */
	@Test
	fun testNodePath() {
		val json = """{"user":{"name":"mingli"},"items":[{"id":1}]}"""
		assertEquals("mingli", api.getNodeValue(json, "user.name"))
		assertEquals("1", api.getNodeValue(json, "items.0.id"))
		assertNull(api.getNodeValue(json, "user.missing"))

		val updated = api.updateNodeValue(json, "user.name", "new")
		assertEquals("new", api.getNodeValue(updated, "user.name"))
	}

	/**
	 * 验证顶层合并与 JSON 合法性判断。
	 */
	@Test
	fun testMergeAndValidity() {
		val merged = api.merge("""{"a":1}""", """{"b":2}""")
		val root = api.parseJsonItem(merged)
		assertEquals("1", root.getField("a").asNumber().toString())
		assertEquals("2", root.getField("b").asNumber().toString())

		assertTrue(api.isValidJson(merged))
		assertFalse(api.isValidJson("{"))
	}

	/**
	 * 验证对象转换。
	 */
	@Test
	fun testConvert() {
		val map = mapOf("name" to "mingli", "age" to 18)
		val user = api.convert(map, User::class.java)
		assertEquals("mingli", user.name)
		assertEquals(18, user.age)
	}

	/**
	 * 验证 [com.mingliqiye.utils.json.converters.base.BaseJsonConverter] 与 Gson 的桥接。
	 */
	@Test
	fun testConverterBridge() {
		val gsonBuilder = GsonBuilder()
		DateTimeJsonConverter().registerToGson(gsonBuilder)
		val converterApi = GsonJsonApi(gsonBuilder)
		val value = DateTime.of(2026, 1, 2, 3, 4, 5)

		val type = object : JsonTypeReference<Map<String, DateTime>>() {}
		val source: Map<String, DateTime> = mapOf("time" to value)
		val json = converterApi.format(source)
		val parsed = converterApi.parse(json, type)

		assertEquals(value, parsed["time"])
	}
}
