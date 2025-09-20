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
 * CurrentFile SpringBeanUtils.kt
 * LastUpdate 2025-09-19 20:07:08
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.bean

import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
 * Spring Bean工具类，用于获取Spring容器中的Bean实例
 * 实现ApplicationContextAware接口以获取Spring的应用上下文
 */
@Component
class SpringBeanUtils : ApplicationContextAware {

    companion object {

        @JvmStatic
        private var applicationContext: ApplicationContext? = null

        /**
         * 根据Bean名称获取Bean实例
         *
         * @param name Bean的名称
         * @return 指定名称的Bean实例
         * @throws BeansException 当获取Bean失败时抛出
         * @throws ClassCastException 当类型转换失败时抛出
         */
        @JvmStatic
        @Throws(BeansException::class, ClassCastException::class)
        @Suppress("UNCHECKED_CAST")
        fun <T> getBean(name: String): T {
            return applicationContext!!.getBean(name) as T
        }

        /**
         * 根据Bean类型获取Bean实例
         *
         * @param clazz Bean的类型
         * @return 指定类型的Bean实例
         * @throws BeansException 当获取Bean失败时抛出
         */
        @JvmStatic
        @Throws(BeansException::class)
        fun <T> getBean(clazz: Class<T>): T {
            return applicationContext!!.getBean(clazz)
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
        fun <T> getBean(name: String, clazz: Class<T>): T {
            return applicationContext!!.getBean<T>(name, clazz)
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
        SpringBeanUtils.applicationContext = applicationContext
    }
}
