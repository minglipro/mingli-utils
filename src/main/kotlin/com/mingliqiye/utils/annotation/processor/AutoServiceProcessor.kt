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
 * LastUpdate 2026-02-08 01:24:16
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.annotation.processor

import com.mingliqiye.utils.annotation.AutoService
import com.mingliqiye.utils.io.IO.println
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.lang.model.element.TypeElement
import javax.lang.model.type.MirroredTypesException
import javax.lang.model.type.TypeMirror
import javax.tools.StandardLocation


@SupportedAnnotationTypes("com.mingliqiye.utils.annotation.AutoService")
class AutoServiceProcessor : AbstractProcessor() {
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }

    override fun process(
        annotations: Set<TypeElement>,
        roundEnv: RoundEnvironment
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
