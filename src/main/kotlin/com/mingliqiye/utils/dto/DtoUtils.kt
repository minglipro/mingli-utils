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
 * CurrentFile DtoUtils.kt
 * LastUpdate 2025-09-19 13:38:56
 * UpdateUser MingLiPro
 */

@file:JvmName("DtoUtils")

package com.mingliqiye.utils.dto

import java.lang.reflect.Field


/**
 * 克隆一个对象，通过反射创建新实例并复制所有非静态字段值。
 *
 * @param obj 要克隆的对象，必须是非空的任意类型实例。
 * @return 返回一个新的对象实例，其字段值与原对象一致。
 */
fun <T : Any> clone(obj: T): T {
    val clazz = obj.javaClass
    val constructor = clazz.getDeclaredConstructor().apply {
        isAccessible = true
    }
    val instance = constructor.newInstance()

    // 遍历类及其父类的所有字段进行赋值
    var currentClass: Class<*>? = clazz
    while (currentClass != null) {
        currentClass.declaredFields.forEach { field ->
            if (!java.lang.reflect.Modifier.isStatic(field.modifiers)) {
                field.isAccessible = true
                field.set(instance, field.get(obj))
            }
        }
        currentClass = currentClass.superclass
    }

    return instance
}

/**
 * 定义 DTO 拷贝行为的枚举类型。
 */
enum class DotCopyType {
    /**
     * 表示使用点拷贝（.copy）方式处理字段。
     */
    DOT_COPY,

    /**
     * 表示普通拷贝方式处理字段。
     */
    COPY
}

/**
 * 标注用于控制 DTO 字段拷贝行为的注解。
 *
 * @param type 指定拷贝类型，默认为 COPY。
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY
)
annotation class DtoCopy(val type: DotCopyType = DotCopyType.COPY)

/**
 * 将源对象转换为目标 DTO 类型的实例，并根据字段名匹配拷贝字段值。
 *
 * @param obj 源对象，包含需要被拷贝的数据。
 * @param dtoClass 目标 DTO 的 Class 对象。
 * @return 返回一个新的目标 DTO 实例，字段值已从源对象拷贝。
 */
fun <R : Any> toDto(obj: Any, dtoClass: Class<R>): R {
    val instance = dtoClass.getDeclaredConstructor().apply {
        isAccessible = true
    }.newInstance()

    val sourceFields = getAllFields(obj.javaClass)

    for (sourceField in sourceFields) {
        sourceField.isAccessible = true
        val fieldName = sourceField.name
        val fieldValue = sourceField.get(obj)

        try {
            val targetField = dtoClass.getDeclaredField(fieldName).apply {
                isAccessible = true
            }
            if (java.lang.reflect.Modifier.isStatic(targetField.modifiers)) {
                continue
            }
            val ta = targetField.getAnnotation(DtoCopy::class.java)
            if (ta != null) {
                if (ta.type == DotCopyType.DOT_COPY) {
                    continue
                }
            }
            targetField.set(instance, fieldValue)

        } catch (e: NoSuchFieldException) {
            continue
        } catch (e: IllegalArgumentException) {
            continue
        }
    }

    return instance
}

/**
 * 获取指定类及其所有父类中声明的所有字段。
 *
 * @param clazz 起始类对象。
 * @return 包含所有字段的列表。
 */
private fun getAllFields(clazz: Class<*>): List<Field> {
    val fields = mutableListOf<Field>()
    var currentClass: Class<*>? = clazz
    while (currentClass != null && currentClass != Any::class.java) {
        fields.addAll(currentClass.declaredFields)
        currentClass = currentClass.superclass
    }
    return fields
}

