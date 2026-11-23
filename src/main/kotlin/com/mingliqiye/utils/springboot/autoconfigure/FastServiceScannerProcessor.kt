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
 * CurrentFile FastServiceScannerProcessor.kt
 * LastUpdate 2026-11-23 14:05:00
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.autoconfigure

import com.mingliqiye.utils.logger.MingLiLoggerFactory
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.context.annotation.AnnotationBeanNameGenerator
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.Ordered
import org.springframework.core.type.filter.AnnotationTypeFilter
import org.springframework.core.type.filter.AssignableTypeFilter
import org.springframework.stereotype.Component
import org.springframework.util.ClassUtils

/**
 * 扫描继承自 `com.mingliqiye.utils.mybatisplus.FastBaseIService` 或
 * `com.mingliqiye.utils.mybatisplus.FastBaseIServiceNew3518` 的具体类并注册为 Spring Bean。
 *
 * 两个基类分别适配旧版 `mybatis-plus-extension` 与新版 `mybatis-plus-spring`，哪个子类都能扫到。
 * 基类按类名在运行期探测：缺少对应 MyBatis-Plus 依赖时只跳过该基类，
 * 不会因为类字面量加载父类失败而抛 `NoClassDefFoundError` 导致启动中断。
 *
 * 这是一个 [BeanFactoryPostProcessor]，Spring 保证它在所有
 * `BeanDefinitionRegistryPostProcessor`（包括 `@MapperScan` 的 `MapperScannerConfigurer`）之后执行，
 * 因此 mapper 的 BeanDefinition 已经注册完毕，服务里的 `baseMapper` 注入不会因为时机问题失败。
 *
 * 已经标注 `@Component` / `@Service` 的类会交给普通组件扫描，这里跳过以避免重复注册。
 *
 * @param basePackages 要扫描的包
 */
class FastServiceScannerProcessor(
	private val basePackages: Array<String>,
) : BeanFactoryPostProcessor, Ordered {

	private val log = MingLiLoggerFactory.getLogger<FastServiceScannerProcessor>()

	override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
		val registry = beanFactory as? BeanDefinitionRegistry ?: return
		if (basePackages.isEmpty()) return

		val classLoader = beanFactory.beanClassLoader ?: FastServiceScannerProcessor::class.java.classLoader

		val scanner = ClassPathScanningCandidateComponentProvider(false).apply {
			// 已有 @Component/@Service 的由组件扫描负责，避免重复注册
			addExcludeFilter(AnnotationTypeFilter(Component::class.java))
		}

		var includeFilterCount = 0
		for (baseClassName in BASE_SERVICE_CLASS_NAMES) {
			// isPresent 内部 catch Throwable，父类缺失导致的 NoClassDefFoundError 也会返回 false
			if (!ClassUtils.isPresent(baseClassName, classLoader)) {
				log.debug("跳过未加载的服务基类: {}", baseClassName)
				continue
			}
			val baseClass = try {
				ClassUtils.forName(baseClassName, classLoader)
			} catch (t: Throwable) {
				log.debug("加载服务基类失败，已跳过: {}", baseClassName, t)
				continue
			}
			// 多个 include filter 之间是 OR 关系
			scanner.addIncludeFilter(AssignableTypeFilter(baseClass))
			includeFilterCount++
		}
		if (includeFilterCount == 0) {
			log.debug("没有可用的服务基类，跳过 FastBaseIService 扫描: packages={}", basePackages.toList())
			return
		}
		val nameGenerator = AnnotationBeanNameGenerator()
		var registered = 0

		for (basePackage in basePackages) {
			for (candidate in scanner.findCandidateComponents(basePackage)) {
				val className = candidate.beanClassName ?: continue
				val beanName = nameGenerator.generateBeanName(candidate, registry)
				val existing = if (registry.containsBeanDefinition(beanName)) {
					registry.getBeanDefinition(beanName)
				} else null

				when {
					existing == null -> {
						registry.registerBeanDefinition(beanName, candidate)
						registered++
					}

					existing.beanClassName == className -> Unit

					else -> {
						// 不同包下简单类名相同，用全限定名避免覆盖
						registry.registerBeanDefinition(className, candidate)
						registered++
					}
				}
			}
		}

		log.debug(
			"FastBaseIService/FastBaseIServiceNew3518 扫描完成: packages={}, registered={}",
			basePackages.toList(),
			registered,
		)
	}

	override fun getOrder(): Int = Ordered.LOWEST_PRECEDENCE

	companion object {
		/**
		 * 服务基类全限定名。用字符串而不是类字面量，避免运行期缺少对应 MyBatis-Plus 依赖时加载失败。
		 */
		private val BASE_SERVICE_CLASS_NAMES = listOf(
			"com.mingliqiye.utils.mybatisplus.FastBaseIService",
			"com.mingliqiye.utils.mybatisplus.FastBaseIServiceNew3518",
		)
	}
}
