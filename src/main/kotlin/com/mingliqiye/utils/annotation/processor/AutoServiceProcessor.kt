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
 * CurrentFile AutoServiceProcessor.kt
 * LastUpdate 2026-03-11 08:46:40
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.annotation.processor

import com.mingliqiye.utils.annotation.AutoService
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.lang.model.element.TypeElement
import javax.lang.model.type.MirroredTypesException
import javax.lang.model.type.TypeMirror
import javax.tools.StandardLocation


/**
 * [AutoService] 注解的编译期处理器。
 *
 * 扫描标注了 [AutoService] 的类，收集服务接口与实现类的映射关系，
 * 并在编译输出目录的 META-INF/services 下生成对应的服务注册文件。
 */
@SupportedAnnotationTypes("com.mingliqiye.utils.annotation.AutoService")
class AutoServiceProcessor : AbstractProcessor() {
	override fun init(processingEnv: ProcessingEnvironment) {
		super.init(processingEnv)
	}

	/**
	 * 处理标注了 [AutoService] 的元素，收集服务接口与实现类的映射并生成服务注册文件。
	 * 若注解未显式指定服务接口，则默认使用该类直接实现的接口。
	 *
	 * @param annotations 本轮处理的注解类型集合
	 * @param roundEnv 当前轮次的处理环境
	 * @return 是否已处理该注解，存在标注元素时返回 true，否则返回 false
	 */
	override fun process(
		annotations: Set<TypeElement>,
		roundEnv: RoundEnvironment,
	): Boolean {

		val service = mutableMapOf<String, MutableList<String>>()
		val elements = roundEnv.getElementsAnnotatedWith(AutoService::class.java)
		if (elements.isEmpty()) return false
		for (element in elements) {
			val autoServiceAnnotation = element.getAnnotation(AutoService::class.java)
			var asd = (try {
				autoServiceAnnotation!!.value.map { it.java.name }
			} catch (e: MirroredTypesException) {
				e.typeMirrors.map(TypeMirror::toString)
			})

			if (asd.isEmpty()) {
				if (element is TypeElement) {
					asd = element.interfaces.map { it.toString() }
				}
			}
			for (data in asd) {
				var ldata: MutableList<String>? = service[data]
				if (ldata == null) {
					ldata = mutableListOf()
					service[data] = ldata
				}
				ldata.add(element.toString())
			}
		}
		processClassAnnotation(service)
		return true
	}

	/**
	 * 根据服务接口与实现类的映射，在 META-INF/services 目录下生成服务注册文件。
	 * 实现列表为空或文件创建失败时打印提示信息并跳过。
	 *
	 * @param map 服务接口全限定名到实现类全限定名列表的映射
	 */
	fun processClassAnnotation(map: Map<String, MutableList<String>>) {
		map.forEach { (interfaceName, implementations) ->
			if (implementations.isEmpty()) {
				println("警告: $interfaceName 的实现列表为空!")
				return@forEach
			}
			try {
				val serviceFile = processingEnv.filer.createResource(
					StandardLocation.CLASS_OUTPUT,
					"",
					"META-INF/services/$interfaceName"
				)
				val content = StringBuilder()
				serviceFile.openWriter().use { writer ->
					implementations.forEach { impl ->
						val line = "$impl\n"
						content.append(line)
						writer.write(line)
					}
					writer.flush()
				}

			} catch (e: Exception) {
				println("文件创建失败: ${e.javaClass.name} - ${e.message}")
				e.printStackTrace()
			}
		}
	}
}
