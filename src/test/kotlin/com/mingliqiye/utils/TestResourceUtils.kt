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
 * CurrentFile TestResourceUtils.kt
 * LastUpdate 2026-11-26 18:00:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.exception.NotFoundResourceException
import com.mingliqiye.utils.resource.ResourceUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets

/**
 * [ResourceUtils] 的资源读取测试。
 */
class TestResourceUtils {

	companion object {
		private const val ABSOLUTE_PATH = "/resource-utils/absolute.txt"
		private const val RELATIVE_PATH = "resource-utils-relative.txt"
	}

	/**
	 * 验证绝对路径字节数组/字符串读取，默认 UTF-8。
	 */
	@Test
	fun testAbsoluteResourceAsStringAndBytes() {
		val text = ResourceUtils.getResourceAsString<TestResourceUtils>(ABSOLUTE_PATH)
		assertEquals("绝对路径资源\n第二行\n", text)

		val bytes = ResourceUtils.getResourceAsByteArray<TestResourceUtils>(ABSOLUTE_PATH)
		assertEquals(text, String(bytes, StandardCharsets.UTF_8))
	}

	/**
	 * 验证以类包为基准的相对路径读取。
	 */
	@Test
	fun testRelativeResource() {
		val text = ResourceUtils.getResourceAsString<TestResourceUtils>(RELATIVE_PATH)
		assertEquals("relative resource\n", text)
	}

	/**
	 * 验证按行读取。
	 */
	@Test
	fun testResourceAsLines() {
		val lines = ResourceUtils.getResourceAsLines<TestResourceUtils>(ABSOLUTE_PATH)
		assertEquals(listOf("绝对路径资源", "第二行"), lines)
	}

	/**
	 * 验证 URL、存在性判断和 ClassLoader 重载。
	 */
	@Test
	fun testUrlAndExists() {
		assertTrue(ResourceUtils.existsResource<TestResourceUtils>(ABSOLUTE_PATH))
		assertNotNull(ResourceUtils.getResourceAsUrl<TestResourceUtils>(ABSOLUTE_PATH))
		assertFalse(ResourceUtils.existsResource<TestResourceUtils>("/resource-utils/not-found.txt"))
		assertNull(ResourceUtils.getResourceAsUrl<TestResourceUtils>("/resource-utils/not-found.txt"))

		val classLoader = TestResourceUtils::class.java.classLoader
		assertEquals(
			"relative resource\n",
			ResourceUtils.getResourceAsString("/com/mingliqiye/utils/resource-utils-relative.txt", classLoader)
		)
	}

	/**
	 * 验证资源不存在时抛出带有路径信息的异常。
	 */
	@Test
	fun testMissingResource() {
		val exception = assertThrows(NotFoundResourceException::class.java) {
			ResourceUtils.getResourceAsString<TestResourceUtils>("/resource-utils/not-found.txt")
		}
		assertTrue(exception.message!!.contains("/resource-utils/not-found.txt"))
	}

	/**
	 * 验证空路径校验。
	 */
	@Test
	fun testBlankPath() {
		assertThrows(IllegalArgumentException::class.java) {
			ResourceUtils.getResourceAsString<TestResourceUtils>(" ")
		}
	}
}
