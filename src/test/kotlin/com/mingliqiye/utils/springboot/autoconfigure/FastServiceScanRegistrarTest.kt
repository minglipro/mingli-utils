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
 * CurrentFile FastServiceScanRegistrarTest.kt
 * LastUpdate 2026-11-23 14:21:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.springboot.annotation.FastServiceScan
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.core.type.AnnotationMetadata

/**
 * FastServiceScanRegistrar 的单元测试，不启动 Spring 容器，只验证注解解析与注册行为。
 */
class FastServiceScanRegistrarTest {

	@FastServiceScan(basePackages = ["com.example.service"])
	private class ExplicitPackagesConfig

	@FastServiceScan("com.example.value")
	private class ValueAliasConfig

	@FastServiceScan(basePackageClasses = [FastServiceScanRegistrarTest::class])
	private class ClassPackagesConfig

	@FastServiceScan
	private class DefaultPackageConfig

	/** 测试显式 basePackages 会注册扫描器并使用配置的包 */
	@Test
	fun testExplicitPackages() {
		val registry = DefaultListableBeanFactory()
		val metadata = AnnotationMetadata.introspect(ExplicitPackagesConfig::class.java)

		FastServiceScanRegistrar().registerBeanDefinitions(metadata, registry)

		assertTrue(registry.containsBeanDefinition("fastServiceScannerProcessor"))
		val beanDefinition = registry.getBeanDefinition("fastServiceScannerProcessor")
		val packages = beanDefinition.constructorArgumentValues.getIndexedArgumentValue(0, Array<String>::class.java)?.value
		assertArrayEquals(arrayOf("com.example.service"), packages as Array<*>)
	}

	/** 测试 value 与 basePackages 的 @AliasFor 生效 */
	@Test
	fun testValueAlias() {
		val registry = DefaultListableBeanFactory()
		val metadata = AnnotationMetadata.introspect(ValueAliasConfig::class.java)

		FastServiceScanRegistrar().registerBeanDefinitions(metadata, registry)

		val beanDefinition = registry.getBeanDefinition("fastServiceScannerProcessor")
		val packages = beanDefinition.constructorArgumentValues.getIndexedArgumentValue(0, Array<String>::class.java)?.value
		assertArrayEquals(arrayOf("com.example.value"), packages as Array<*>)
	}

	/** 测试 basePackageClasses 会转换为其所在包 */
	@Test
	fun testBasePackageClasses() {
		val registry = DefaultListableBeanFactory()
		val metadata = AnnotationMetadata.introspect(ClassPackagesConfig::class.java)

		FastServiceScanRegistrar().registerBeanDefinitions(metadata, registry)

		val beanDefinition = registry.getBeanDefinition("fastServiceScannerProcessor")
		val packages = beanDefinition.constructorArgumentValues.getIndexedArgumentValue(0, Array<String>::class.java)?.value
		assertArrayEquals(arrayOf("com.mingliqiye.utils.springboot.autoconfigure"), packages as Array<*>)
	}

	/** 测试不写包名时默认使用标注类所在包 */
	@Test
	fun testDefaultPackage() {
		val registry = DefaultListableBeanFactory()
		val metadata = AnnotationMetadata.introspect(DefaultPackageConfig::class.java)

		FastServiceScanRegistrar().registerBeanDefinitions(metadata, registry)

		val beanDefinition = registry.getBeanDefinition("fastServiceScannerProcessor")
		val packages = beanDefinition.constructorArgumentValues.getIndexedArgumentValue(0, Array<String>::class.java)?.value
		assertArrayEquals(arrayOf("com.mingliqiye.utils.springboot.autoconfigure"), packages as Array<*>)
	}

	/** 测试重复处理同一个配置类不会重复注册扫描器 */
	@Test
	fun testIdempotentRegistration() {
		val registry = DefaultListableBeanFactory()
		val metadata = AnnotationMetadata.introspect(ExplicitPackagesConfig::class.java)
		val registrar = FastServiceScanRegistrar()

		registrar.registerBeanDefinitions(metadata, registry)
		registrar.registerBeanDefinitions(metadata, registry)

		assertEquals(1, registry.beanDefinitionCount)
	}
}
