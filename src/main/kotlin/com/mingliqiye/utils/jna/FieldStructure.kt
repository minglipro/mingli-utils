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
 * CurrentFile FieldStructure.kt
 * LastUpdate 2025-09-14 18:19:29
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.jna

import com.sun.jna.Structure
import java.lang.reflect.Modifier

/**
 * JNA结构体基类，自动处理字段顺序
 * 该类继承自JNA的Structure类，通过反射自动获取子类的公共非静态字段，
 * 并按声明顺序返回字段名列表，用于JNA结构体的字段映射。
 */
class FieldStructure : Structure() {
    /**
     * 获取结构体字段顺序列表
     * 通过反射遍历当前类及其父类的所有声明字段，过滤出公共非静态字段，
     * 按照字段在类中声明的顺序返回字段名列表。
     *
     * @return 包含字段名的列表，按声明顺序排列
     */
    override fun getFieldOrder(): MutableList<String> {
        val fieldOrderList: MutableList<String> = ArrayList()
        var cls: Class<*> = javaClass
        while (cls != FieldStructure::class.java) {
            val fields = cls.getDeclaredFields()
            var modifiers: Int
            for (field in fields) {
                modifiers = field.modifiers
                if (Modifier.isStatic(modifiers) ||
                    !Modifier.isPublic(modifiers)
                ) {
                    continue
                }
                fieldOrderList.add(field.name)
            }
            cls = cls.getSuperclass()
        }
        return fieldOrderList
    }
}
