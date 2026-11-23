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
 * ModuleName mingli-utils.main
 * CurrentFile FastServiceScanRegistrar.kt
 * LastUpdate 2026-11-23 14:21:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.springboot.annotation.FastServiceScan
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.RootBeanDefinition
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar
import org.springframework.core.type.AnnotationMetadata
import org.springframework.util.ClassUtils

/**
 * [FastServiceScan] 的注册器：解析注解上的扫描包，并把 [FastServiceScannerProcessor] 注册成 Bean。
 *
 * 通过 Spring 的 `MergedAnnotation.synthesize()` 读取注解，这样 `value` 与 `basePackages`
 * 之间的 `@AliasFor` 会像 `@MapperScan` 一样被正确合并（两者同时指定不同值时也会按 Spring
 * 的规则报错，而不是被静默合并）。
 *
 * 这里不直接扫描，而是注册一个 `BeanFactoryPostProcessor`，由 Spring 在所有
 * `BeanDefinitionRegistryPostProcessor`（如 `@MapperScan` 的 `MapperScannerConfigurer`）之后执行，
 * 从而保证扫描注册时机在 mapper 之后。
 */
class FastServiceScanRegistrar : ImportBeanDefinitionRegistrar {

	override fun registerBeanDefinitions(
		importingClassMetadata: AnnotationMetadata,
		registry: BeanDefinitionRegistry,
	) {
		val mergedAnnotation = importingClassMetadata.annotations.get(FastServiceScan::class.java)
		if (!mergedAnnotation.isPresent) return
		// synthesize 会应用 @AliasFor，value/basePackages 指向同一个值
		val annotation = mergedAnnotation.synthesize()
		val packages = resolvePackages(annotation, importingClassMetadata)
		if (packages.isEmpty()) return

		if (registry.containsBeanDefinition(PROCESSOR_BEAN_NAME)) return

		val definition = RootBeanDefinition(FastServiceScannerProcessor::class.java)
		definition.constructorArgumentValues.addIndexedArgumentValue(0, packages.toTypedArray())
		definition.role = BeanDefinition.ROLE_INFRASTRUCTURE
		registry.registerBeanDefinition(PROCESSOR_BEAN_NAME, definition)
	}

	/**
	 * 解析注解上的扫描包；未指定时取标注类所在包。
	 */
	private fun resolvePackages(
		annotation: FastServiceScan,
		importingClassMetadata: AnnotationMetadata,
	): Set<String> {
		val packages = LinkedHashSet<String>()

		// value 与 basePackages 互为 @AliasFor，这里各读一遍只是防御；重复值会被 Set 去重
		for (packageName in annotation.value) {
			if (packageName.isNotBlank()) packages += packageName.trim()
		}
		for (packageName in annotation.basePackages) {
			if (packageName.isNotBlank()) packages += packageName.trim()
		}
		for (baseClass in annotation.basePackageClasses) {
			packages += ClassUtils.getPackageName(baseClass.java)
		}

		if (packages.isEmpty()) {
			packages += ClassUtils.getPackageName(importingClassMetadata.className)
		}
		return packages
	}

	companion object {
		private const val PROCESSOR_BEAN_NAME = "fastServiceScannerProcessor"
	}
}
