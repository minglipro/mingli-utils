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
 * CurrentFile KotlinReflect.kt
 * LastUpdate 2026-03-11 08:16:32
 * UpdateUser MingLiPro
 */

@file:JvmName("KotlinReflect")

package com.mingliqiye.utils.reflect.kotlin

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.full.*
import kotlin.reflect.jvm.isAccessible

/**
 * 获取实例的 KClass
 */
inline fun <reified T : Any> T.kClass(): KClass<T> = T::class

/**
 * 获取实例的 Java Class
 */
inline fun <reified T : Any> T.kClassJava(): Class<T> = T::class.java

/**
 * 创建实例（通过无参构造函数）
 */
inline fun <reified T : Any> createInstance(): T = T::class.createInstance()

/**
 * 创建实例（通过主构造函数，提供参数）
 */
inline fun <reified T : Any> createInstance(vararg args: Any?): T? {
    val kClass = T::class
    val constructor = kClass.primaryConstructor
    return constructor?.let {
        it.isAccessible = true
        it.call(*args)
    }
}

/**
 * 获取所有父类（包括接口）
 */
inline fun <reified T : Any> T.superClasses(): Collection<KClass<*>> = T::class.allSuperclasses

/**
 * 判断是否是某个类的子类
 */
inline fun <reified T : Any, reified S : Any> T.isSubclassOf(): Boolean = T::class.isSubclassOf(S::class)

/**
 * 获取伴生对象实例
 */
inline fun <reified T : Any> T.companion(): Any? = T::class.companionObject?.objectInstance

/**
 * 获取对象的所有属性名
 */
inline fun <reified T : Any> T.propertyNames(): List<String> = T::class.memberProperties.map { it.name }

/**
 * 获取属性值
 */
inline fun <reified T : Any> T.getPropertyValue(name: String): Any? {
    val property = T::class.memberProperties.find { it.name == name }
    return if (property != null) {
        property.isAccessible = true
        property.get(this)
    } else null
}

/**
 * 设置属性值（仅适用于 var 属性）
 */
inline fun <reified T : Any> T.setPropertyValue(name: String, value: Any?): Boolean {
    val property = T::class.memberProperties.find { it.name == name }
    return if (property is kotlin.reflect.KMutableProperty<*>) {
        property.isAccessible = true
        property.setter.call(this, value)
        true
    } else false
}

/**
 * 批量获取属性值
 */
inline fun <reified T : Any> T.getPropertyValues(vararg names: String): Map<String, Any?> {
    val properties = T::class.memberProperties
    return names.associateWith { name ->
        properties.find { it.name == name }?.let {
            it.isAccessible = true
            it.get(this)
        }
    }
}

/**
 * 获取所有属性及其值
 */
inline fun <reified T : Any> T.getAllPropertyValues(): Map<String, Any?> {
    return T::class.memberProperties.associate { prop ->
        prop.isAccessible = true
        prop.name to prop.get(this)
    }
}

/**
 * 调用对象的方法
 */
inline fun <reified T : Any> T.callMethod(name: String, vararg args: Any?): Any? {
    val function = T::class.functions.find { it.name == name }
    return function?.let {
        it.isAccessible = true
        it.call(this, *args)
    }
}

/**
 * 调用静态方法（通过伴生对象）
 */
inline fun <reified T : Any> T.callStaticMethod(name: String, vararg args: Any?): Any? {
    val companion = T::class.companionObject?.objectInstance
    val function = companion?.let {
        it::class.functions.find { func -> func.name == name }
    }
    return function?.let {
        it.isAccessible = true
        it.call(companion, *args)
    }
}

/**
 * 获取所有方法名
 */
inline fun <reified T : Any> T.methodNames(): List<String> = T::class.functions.map { it.name }

/**
 * 检查类是否有特定注解
 */
inline fun <reified T : Any, reified A : Annotation> T.hasAnnotation(): Boolean = T::class.hasAnnotation<A>()

/**
 * 获取所有带有特定注解的属性
 */
inline fun <reified T : Any, reified A : Annotation> T.propertiesWithAnnotation(): List<String> {
    return T::class.memberProperties.filter { it.hasAnnotation<A>() }.map { it.name }
}

/**
 * 获取所有带有特定注解的方法
 */
inline fun <reified T : Any, reified A : Annotation> T.methodsWithAnnotation(): List<String> {
    return T::class.functions.filter { it.hasAnnotation<A>() }.map { it.name }
}

/**
 * 获取泛型类型参数
 */
inline fun <reified T : Any> T.genericType(): KType = T::class.starProjectedType

/**
 * 检查类型是否匹配
 */
inline fun <reified T : Any> T.isInstanceOf(instance: Any): Boolean = T::class.isInstance(instance)

// ==================== Java 互操作 ====================

/**
 * 获取对应的 Java 方法
 */
inline fun <reified T : Any> T.getJavaMethod(name: String, vararg paramTypes: Class<*>): java.lang.reflect.Method? {
    return T::class.java.getDeclaredMethod(name, *paramTypes).apply {
        isAccessible = true
    }
}

/**
 * 获取对应的 Java 字段
 */
inline fun <reified T : Any> T.getJavaField(name: String): java.lang.reflect.Field? {
    return T::class.java.getDeclaredField(name).apply {
        isAccessible = true
    }
}

/**
 * 调用 Java 方法
 */
inline fun <reified T : Any> T.callJavaMethod(name: String, vararg args: Any?): Any? {
    val method = T::class.java.methods.find { it.name == name }
    return method?.let {
        it.isAccessible = true
        it.invoke(this, *args)
    }
}

/**
 * 获取所有构造函数
 */
inline fun <reified T : Any> T.constructors(): List<KFunction<T>> = T::class.constructors.toList()

/**
 * 通过构造函数索引创建实例
 */
inline fun <reified T : Any> createInstanceByIndex(index: Int, vararg args: Any?): T? {
    val constructors = T::class.constructors.toList()
    return if (index < constructors.size) {
        constructors[index].apply { isAccessible = true }.call(*args)
    } else null
}

/**
 * 比较两个对象的属性值
 */
inline fun <reified T : Any> T.compareWith(other: T, vararg properties: String): Map<String, Pair<Any?, Any?>> {
    val result = mutableMapOf<String, Pair<Any?, Any?>>()
    val props = T::class.memberProperties.associateBy { it.name }

    properties.forEach { propName ->
        props[propName]?.let { prop ->
            prop.isAccessible = true
            result[propName] = Pair(prop.get(this), prop.get(other))
        }
    }
    return result
}

/**
 * 获取单例对象实例（适用于 object 声明）
 */
inline fun <reified T : Any> getSingletonInstance(): T? {
    return (T::class.objectInstance as? T)
}

/**
 * 检查是否是单例对象
 */
inline fun <reified T : Any> T.isSingleton(): Boolean = T::class.objectInstance != null

/**
 * 获取类的所有扩展函数
 */
inline fun <reified T : Any> T.extensionFunctions(): Collection<KFunction<*>> =
    T::class.declaredMemberExtensionFunctions
