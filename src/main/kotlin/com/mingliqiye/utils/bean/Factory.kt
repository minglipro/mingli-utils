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
 * CurrentFile Factory.kt
 * LastUpdate 2025-09-15 22:32:50
 * UpdateUser MingLiPro
 */
@file:JvmName("Factory")

package com.mingliqiye.utils.bean

import com.mingliqiye.utils.bean.annotation.ComponentBean
import com.mingliqiye.utils.bean.annotation.InjectBean
import java.io.File
import java.net.URL
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

/**
 * 存储所有已注册的Bean实例，键为Bean名称，值为Bean实例
 */
private val BEANS: ConcurrentHashMap<String, Any> = ConcurrentHashMap()

/**
 * 存储按类型查找的Bean实例，键为Bean的Class对象，值为Bean实例
 */
private val TYPE_BEANS: ConcurrentHashMap<KClass<*>, Any> = ConcurrentHashMap()

/**
 * 自动扫描指定类所在包下的所有类并注册为Bean
 *
 * @param c 指定的类，用于获取其所在的包
 * @throws IllegalArgumentException 如果传入的类为null或位于默认包中
 */
fun autoScan(c: Class<*>?) {
    if (c == null) {
        throw IllegalArgumentException("Class cannot be null")
    }
    val pkg = c.`package`
    if (pkg == null) {
        throw IllegalArgumentException("Class is in the default package")
    }
    scan(pkg.name)
}

/**
 * 扫描指定包路径下的所有类文件，并注册其中带有@ComponentBean注解的类为Bean
 *
 * @param basePackage 要扫描的基础包名
 * @throws RuntimeException 如果在扫描过程中发生异常
 */
fun scan(basePackage: String) {
    try {
        val path = basePackage.replace('.', '/')
        val classLoader = Thread.currentThread().contextClassLoader
        val resources: Enumeration<URL> = classLoader.getResources(path)
        while (resources.hasMoreElements()) {
            val resource = resources.nextElement()
            val file = File(resource.toURI())
            scanDirectory(file, basePackage)
        }
        injectDependencies()
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}

/**
 * 递归扫描目录中的所有类文件，并注册符合条件的类为Bean
 *
 * @param directory   当前要扫描的目录
 * @param packageName 当前目录对应的包名
 * @throws Exception 如果在扫描或类加载过程中发生异常
 */
private fun scanDirectory(directory: File, packageName: String) {
    val files = directory.listFiles() ?: return

    for (file in files) {
        if (file.isDirectory) {
            scanDirectory(file, "$packageName.${file.name}")
        } else if (file.name.endsWith(".class")) {
            val className = packageName + '.' + file.name.replace(".class", "")
            registerComponent(Class.forName(className))
        }
    }
}

/**
 * 注册一个带有@ComponentBean注解的类为Bean实例
 *
 * @param clazz 要注册的类
 * @throws Exception 如果在实例化类或处理注解时发生异常
 */
private fun registerComponent(clazz: Class<*>) {
    if (clazz.isAnnotationPresent(ComponentBean::class.java)) {
        val component = clazz.getAnnotation(ComponentBean::class.java)
        val name = component.value.ifEmpty { clazz.name }
        val instance = clazz.getDeclaredConstructor().newInstance()
        BEANS[name] = instance
        val kClass = clazz.kotlin
        TYPE_BEANS[kClass] = instance

        for (interfaceClass in clazz.interfaces) {
            TYPE_BEANS.putIfAbsent(interfaceClass.kotlin, instance)
        }
    }
}

/**
 * 对所有已注册的Bean进行依赖注入处理
 *
 * @throws Exception 如果在注入过程中发生异常
 */
private fun injectDependencies() {
    for (bean in BEANS.values) {
        for (field in bean.javaClass.declaredFields) {
            if (field.isAnnotationPresent(InjectBean::class.java)) {
                val inject = field.getAnnotation(InjectBean::class.java)
                val dependency = findDependency(field.type, inject.value)
                if (dependency == null) {
                    throw IllegalStateException(
                        "No suitable dependency found for field " + field.name + " in class " + bean.javaClass.name
                    )
                }
                field.isAccessible = true
                field.set(bean, dependency)
            }
        }
    }
}

/**
 * 根据类型和名称查找对应的依赖实例
 *
 * @param type 依赖的类型
 * @param name 依赖的名称（可为空）
 * @return 找到的依赖实例，未找到则返回null
 */
private fun findDependency(type: Class<*>, name: String): Any? {
    if (name.isNotEmpty()) {
        return BEANS[name]
    }

    val dependency = TYPE_BEANS[type.kotlin]
    if (dependency != null) {
        return dependency
    }

    for (interfaceType in TYPE_BEANS.keys) {
        if (type.isAssignableFrom(interfaceType.java)) {
            return TYPE_BEANS[interfaceType]
        }
    }

    return null
}

/**
 * 将一个对象添加到Bean容器中，使用其类名作为键
 *
 * @param obj 要添加的对象
 * @throws RuntimeException 如果在注入依赖时发生异常
 */
fun add(obj: Any) {
    val clazz = obj.javaClass
    val name = clazz.name
    BEANS[name] = obj
    TYPE_BEANS[clazz.kotlin] = obj
    try {
        injectDependencies()
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}

/**
 * 将一个对象以指定名称添加到Bean容器中
 *
 * @param name   Bean的名称
 * @param obj 要添加的对象
 * @throws RuntimeException 如果在注入依赖时发生异常
 */
fun add(name: String, obj: Any) {
    BEANS[name] = obj
    TYPE_BEANS[obj.javaClass.kotlin] = obj
    try {
        injectDependencies()
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}

/**
 * 根据类型获取对应的Bean实例
 *
 * @param objclass Bean的类型
 * @param T      Bean的泛型类型
 * @return 对应类型的Bean实例，未找到则返回null
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> get(objclass: KClass<T>): T? {
    return TYPE_BEANS[objclass] as? T
}

/**
 * 根据名称和类型获取对应的Bean实例
 *
 * @param name     Bean的名称
 * @param objclass Bean的类型
 * @param T      Bean的泛型类型
 * @return 对应名称和类型的Bean实例，未找到则返回null
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> get(name: String, objclass: KClass<T>): T? {
    return BEANS[name] as? T
}

/**
 * 根据名称获取对应的Bean实例
 *
 * @param name Bean的名称
 * @return 对应名称的Bean实例，未找到则返回null
 */
fun get(name: String): Any? {
    return BEANS[name]
}
