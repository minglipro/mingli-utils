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
 * CurrentFile FastServiceScannerProcessorTest.kt
 * LastUpdate 2026-11-23 14:05:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.mybatisplus.FastBaseIService
import com.mingliqiye.utils.mybatisplus.FastBaseIServiceNew3518
import com.mingliqiye.utils.mybatisplus.FastBaseMapper
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.support.DefaultListableBeanFactory

private class ScanTestEntity

private interface ScanTestMapper : FastBaseMapper<ScanTestEntity>

private class LegacyScanTestService : FastBaseIService<ScanTestEntity, ScanTestMapper>()

private class NewScanTestService : FastBaseIServiceNew3518<ScanTestEntity, ScanTestMapper>()

/**
 * FastServiceScannerProcessor 的扫描测试：两个基类的子类都应被注册。
 */
class FastServiceScannerProcessorTest {

	@Test
	fun testScansBothBaseServices() {
		val registry = DefaultListableBeanFactory()

		FastServiceScannerProcessor(arrayOf("com.mingliqiye.utils.springboot.autoconfigure"))
			.postProcessBeanFactory(registry)

		assertTrue(registry.containsBeanDefinition("legacyScanTestService"))
		assertTrue(registry.containsBeanDefinition("newScanTestService"))
	}

	/** 测试某个基类加载失败时只跳过该基类，不抛 NoClassDefFoundError */
	@Test
	fun testMissingBaseClassIsSkipped() {
		val registry = DefaultListableBeanFactory()
		registry.beanClassLoader = object : ClassLoader(FastServiceScannerProcessorTest::class.java.classLoader) {
			override fun loadClass(name: String, resolve: Boolean): Class<*> {
				if (name == "com.mingliqiye.utils.mybatisplus.FastBaseIService") {
					throw ClassNotFoundException(name)
				}
				return super.loadClass(name, resolve)
			}
		}

		FastServiceScannerProcessor(arrayOf("com.mingliqiye.utils.springboot.autoconfigure"))
			.postProcessBeanFactory(registry)

		assertTrue(registry.containsBeanDefinition("newScanTestService"))
		assertFalse(registry.containsBeanDefinition("legacyScanTestService"))
	}
}
