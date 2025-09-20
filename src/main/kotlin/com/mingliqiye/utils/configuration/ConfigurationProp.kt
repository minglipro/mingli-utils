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
 * CurrentFile ConfigurationProp.kt
 * LastUpdate 2025-09-19 11:30:04
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.configuration

/**
 * 配置属性注解，用于标记配置类中的字段，支持通过命令行参数进行初始化。
 *
 * @param name 配置项的名称，默认为空字符串，表示使用字段名作为配置项名称。
 * @param description 配置项的描述信息，默认为空字符串。
 * @param showHelper 是否显示帮助信息，默认为 true。
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FIELD,      // 添加字段支持
    AnnotationTarget.PROPERTY    // 添加属性支持
)
annotation class ConfigurationProp(val name: String = "", val description: String = "", val showHelper: Boolean = true)

/**
 * 根据字段名生成对应的 setter 方法名。
 *
 * @param fieldName 字段名。
 * @return 对应的 setter 方法名。
 */
private fun getSetterName(fieldName: String): String {
    return "set" + fieldName.take(1).uppercase() + fieldName.substring(1)
}

/**
 * 根据字段名生成对应的 getter 方法名。
 *
 * @param fieldName 字段名。
 * @return 对应的 getter 方法名。
 */
private fun getGetterName(fieldName: String): String {
    return "get" + fieldName.take(1).uppercase() + fieldName.substring(1)
}

/**
 * 配置初始化器，用于解析命令行参数并填充配置对象。
 */
open class ConfigurationProps {

    companion object {
        /**
         * 初始化配置类实例，并根据命令行参数填充其字段。
         *
         * @param clazz 配置类的 Class 对象。
         * @param args 命令行参数数组。
         * @return 初始化后的配置类实例。
         */
        @JvmStatic
        fun <T : ConfigurationProps> init(clazz: Class<T>, args: Array<String>): T {
            val mapsArgs = parseArguments(args)
            val instance = clazz.getDeclaredConstructor().newInstance()

            processFields(clazz, instance, mapsArgs)

            return instance
        }

        /**
         * 解析命令行参数，将其转换为键值对映射。
         *
         * 支持以下格式：
         * - `--key=value` 或 `-k=value`：键值对形式。
         * - `--key value` 或 `-k value`：键和值分开的形式。
         * - `--flag` 或 `-f`：布尔标志形式，默认值为 "true"。
         *
         * @param args 命令行参数数组。
         * @return 解析后的键值对映射。
         */
        private fun parseArguments(args: Array<String>): Map<String, List<String>> {
            val mapsArgs = mutableMapOf<String, MutableList<String>>()

            var i = 0
            while (i < args.size) {
                val arg = args[i]

                when {
                    arg.startsWith("--") -> {
                        // 处理 --key=value 格式
                        if (arg.contains("=")) {
                            val (key, value) = arg.substring(2).split("=", limit = 2)
                            mapsArgs.getOrPut(key) { mutableListOf() }.add(value)
                        }
                        // 处理 --key value 格式
                        else if (i + 1 < args.size && !args[i + 1].startsWith("-")) {
                            val key = arg.substring(2)
                            val value = args[i + 1]
                            mapsArgs.getOrPut(key) { mutableListOf() }.add(value)
                            i++ // 跳过下一个参数
                        }
                        // 处理 --flag 格式的布尔标志
                        else {
                            val key = arg.substring(2)
                            mapsArgs.getOrPut(key) { mutableListOf() }.add("true")
                        }
                    }

                    arg.startsWith("-") -> {
                        // 处理 -k=value 格式
                        if (arg.contains("=")) {
                            val (key, value) = arg.substring(1).split("=", limit = 2)
                            mapsArgs.getOrPut(key) { mutableListOf() }.add(value)
                        }
                        // 处理 -k value 格式
                        else if (i + 1 < args.size && !args[i + 1].startsWith("-")) {
                            val key = arg.substring(1)
                            val value = args[i + 1]
                            mapsArgs.getOrPut(key) { mutableListOf() }.add(value)
                            i++
                        }
                        // 处理 -f 格式的布尔标志
                        else {
                            val key = arg.substring(1)
                            mapsArgs.getOrPut(key) { mutableListOf() }.add("true")
                        }
                    }
                }
                i++
            }

            return mapsArgs
        }

        /**
         * 处理配置类中的字段，根据解析出的参数设置字段值。
         *
         * @param clazz 配置类的 Class 对象。
         * @param instance 配置类的实例。
         * @param mapsArgs 解析后的命令行参数映射。
         */
        private fun <T : ConfigurationProps> processFields(
            clazz: Class<T>,
            instance: T,
            mapsArgs: Map<String, List<String>>
        ) {
            val fields = clazz.declaredFields

            for (field in fields) {
                val configurationProp = field.getAnnotation(ConfigurationProp::class.java)
                if (configurationProp != null) {
                    val fieldName = configurationProp.name.ifEmpty { field.name }
                    val values = mapsArgs[fieldName]

                    if (values != null) {
                        try {
                            val setter = clazz.getDeclaredMethod(
                                getSetterName(field.name),
                                field.type
                            )

                            val value = convertValue(field.type, values, configurationProp)
                            setter.invoke(instance, value)
                        } catch (e: Exception) {
                            println("Warning: Failed to set field ${field.name}: ${e.message}")
                        }
                    }
                }
            }
        }

        /**
         * 将字符串值转换为目标类型。
         *
         * @param type 目标类型。
         * @param values 字符串值列表。
         * @param annotation 配置属性注解。
         * @return 转换后的值。
         */
        private fun convertValue(
            type: Class<*>,
            values: List<String>,
            annotation: ConfigurationProp
        ): Any? {
            val lastValue = values.lastOrNull() ?: return null

            return when (type) {
                String::class.java -> lastValue

                Integer::class.java, Int::class.java -> try {
                    lastValue.toInt()
                } catch (e: NumberFormatException) {
                    println("Warning: Invalid integer value '$lastValue'")
                    null
                }

                Long::class.java, java.lang.Long::class.java -> try {
                    lastValue.toLong()
                } catch (e: NumberFormatException) {
                    println("Warning: Invalid long value '$lastValue'")
                    null
                }

                Double::class.java, java.lang.Double::class.java -> try {
                    lastValue.toDouble()
                } catch (e: NumberFormatException) {
                    println("Warning: Invalid double value '$lastValue'")
                    null
                }

                Boolean::class.java, java.lang.Boolean::class.java -> when (lastValue.lowercase()) {
                    "true", "1", "yes", "on" -> true
                    "false", "0", "no", "off" -> false
                    else -> {
                        println("Warning: Invalid boolean value '$lastValue'")
                        null
                    }
                }

                List::class.java -> values

                else -> {
                    println("Warning: Unsupported type ${type.simpleName}")
                    null
                }
            }
        }
    }

    fun printHelp() {
        val fields = this::class.java.declaredFields
        val help = StringBuilder()
        for (field in fields) {
            val configurationProp = field.getAnnotation(ConfigurationProp::class.java)
            if (configurationProp != null && configurationProp.showHelper) {
                val fieldName = configurationProp.name.ifEmpty { field.name }
                help.append("$fieldName -> 类型: ${field.type.simpleName}")
                if (configurationProp.description.isNotEmpty()) {
                    help.append(" 描述: ${configurationProp.description}")
                }
                help.append("\n")
            }
        }
        println(help)
    }

    val fields: Map<String, Any?>
        get() {
            val fields = this::class.java.declaredFields
            val fieldValues = mutableMapOf<String, Any?>()
            for (field in fields) {
                field.isAccessible = true
                val fieldName = field.name
                val fieldValue = field.get(this)
                fieldValues[fieldName] = fieldValue
            }
            return fieldValues
        }
}
