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
 * LastUpdate 2026-11-17 19:46:16
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters.base

/**
 * 注解获取接口，用于在自定义序列化/反序列化时读取字段上的注解
 */
interface AnnotationGetter {
	/**
	 * 获取指定类型的注解
	 *
	 * @param clazz 注解的Class类型
	 * @return 注解实例，不存在时返回null（默认实现始终返回null）
	 */
	fun <T : Annotation> getAnnotation(clazz: Class<T>): T? = null
}
