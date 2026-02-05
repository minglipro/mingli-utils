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
 * CurrentFile AnnotationGetter.kt
 * LastUpdate 2026-02-05 11:12:36
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

/**
 * 定义一个用于获取注解的接口。
 * 提供了一个通用方法来根据注解类型获取对应的注解实例。
 */
interface AnnotationGetter {
    /**
     * 根据指定的注解类型获取该类型的注解实例。
     *
     * @param clazz 注解的Class对象，表示要获取的注解类型。
     * @return 返回对应类型的注解实例，如果未找到则返回null。
     */
    fun <T : Annotation> get(clazz: Class<T>): T?

    companion object {
        /**
         * 使用内联函数和重ified类型参数简化注解获取操作。
         * 通过传入泛型参数自动推断注解类型，避免手动传递Class对象。
         *
         * @param T 注解类型，必须继承自Annotation。
         * @return 返回对应类型的注解实例，如果未找到则返回null。
         */
        inline fun <reified T : Annotation> AnnotationGetter.get(): T? = this.get(T::class.java)

        /**
         * 提供一个默认实现，始终返回null。
         * 可用于需要空注解获取器的场景。
         */
        val nullGetter = object : AnnotationGetter {
            /**
             * 始终返回null，不执行任何实际逻辑。
             *
             * @param clazz 注解的Class对象（未使用）。
             * @return 始终返回null。
             */
            override fun <T : Annotation> get(clazz: Class<T>): T? = null
        }
    }
}
