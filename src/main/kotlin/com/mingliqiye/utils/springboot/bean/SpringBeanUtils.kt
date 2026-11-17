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
 * CurrentFile SpringBeanUtils.kt
 * LastUpdate 2026-10-27 12:51:22
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.bean

import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ApplicationContextException
import org.springframework.stereotype.Component

/**
 * Spring Bean工具类，用于获取Spring容器中的Bean实例
 * 实现ApplicationContextAware接口以获取Spring的应用上下文
 */
@Component
class SpringBeanUtils : ApplicationContextAware {

	/**
	 * 伴生对象，持有应用上下文并提供静态的 Bean 获取方法。
	 */
	companion object {

		/**
		 * 当前 Spring 应用上下文。
		 *
		 * @return 已初始化的应用上下文
		 * @throws ApplicationContextException 如果应用上下文尚未初始化
		 */
		@JvmStatic
		val applicationContext: ApplicationContext
			get() = applicationContextBase
				?: throw ApplicationContextException("applicationContext isn't ContextInitialized ?")

		private var applicationContextBase: ApplicationContext? = null

		/**
		 * 按类型创建 Bean 的懒加载委托，首次访问时才从容器中获取。
		 *
		 * @param T Bean 类型，通过 reified 获取实际类型
		 * @return 懒加载委托，访问 value 时返回对应类型的 Bean 实例
		 */
		inline fun <reified T : Any> lazyBean(): Lazy<T> = lazy(::getBean)

		/**
		 * 按名称和类型创建 Bean 的懒加载委托，首次访问时才从容器中获取。
		 *
		 * @param T Bean 类型，通过 reified 获取实际类型
		 * @param name Bean 的名称
		 * @return 懒加载委托，访问 value 时返回对应名称和类型的 Bean 实例
		 */
		inline fun <reified T : Any> lazyBean(name: String): Lazy<T> = lazy {
			getBean(name, T::class.java)
		}


		/**
		 * 根据 reified 类型获取 Bean 实例。
		 *
		 * @param T Bean 类型，通过 reified 获取实际类型
		 * @return 指定类型的 Bean 实例
		 * @throws BeansException 当获取 Bean 失败时抛出
		 */
		@Throws(BeansException::class)
		inline fun <reified T : Any> getBean() = getBean(T::class.java)

		/**
		 * 根据Bean名称获取Bean实例
		 *
		 * @param name Bean的名称
		 * @return 指定名称的Bean实例
		 * @throws BeansException 当获取Bean失败时抛出
		 * @throws ClassCastException 当类型转换失败时抛出
		 */
		@JvmStatic
		@Throws(BeansException::class)
		@Suppress("UNCHECKED_CAST")
		fun getBean(name: String): Any = applicationContext.getBean(name)

		/**
		 * 根据Bean类型获取Bean实例
		 *
		 * @param clazz Bean的类型
		 * @return 指定类型的Bean实例
		 * @throws BeansException 当获取Bean失败时抛出
		 */
		@JvmStatic
		@Throws(BeansException::class)
		fun <T : Any> getBean(clazz: Class<T>): T {
			return applicationContext.getBean(clazz)
		}

		/**
		 * 根据Bean名称和类型获取Bean实例
		 *
		 * @param name Bean的名称
		 * @param clazz Bean的类型
		 * @return 指定名称和类型的Bean实例
		 * @throws BeansException 当获取Bean失败时抛出
		 */
		@JvmStatic
		@Throws(BeansException::class)
		fun <T : Any> getBean(name: String, clazz: Class<T>): T {
			return applicationContext.getBean<T>(name, clazz)
		}
	}


	/**
	 * 设置Spring的应用上下文
	 *
	 * @param applicationContext Spring的应用上下文
	 * @throws BeansException 当设置应用上下文失败时抛出
	 */
	@Throws(BeansException::class)
	override fun setApplicationContext(applicationContext: ApplicationContext) {
		applicationContextBase = applicationContext
	}
}
