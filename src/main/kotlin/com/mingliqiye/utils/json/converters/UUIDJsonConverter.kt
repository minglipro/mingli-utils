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
 * CurrentFile UUIDJsonConverter.kt
 * LastUpdate 2026-02-05 11:19:45
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters

import com.mingliqiye.utils.base.BaseType
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.base.AnnotationGetter
import com.mingliqiye.utils.json.converters.base.AnnotationGetter.Companion.get
import com.mingliqiye.utils.json.converters.base.BaseJsonStringConverter
import com.mingliqiye.utils.objects.isNull
import com.mingliqiye.utils.string.isNullish
import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.UUIDFormatType
import com.mingliqiye.utils.uuid.UUIDJsonFormat

/**
 * UUIDJsonConverter 是一个用于处理 UUID 类型与 JSON 字符串之间转换的类。
 * 它继承自 BaseJsonStringConverter，并实现了 convert 和 deConvert 方法，
 * 分别用于将 UUID 对象序列化为字符串以及反序列化字符串为 UUID 对象。
 */
class UUIDJsonConverter : BaseJsonStringConverter<UUID> {

    /**
     * 将 UUID 对象转换为字符串形式。
     *
     * @param obj 需要转换的 UUID 对象，可能为 null。
     * @param annotationGetter 用于获取注解信息的对象。
     * @return 转换后的字符串，如果输入为 null 则返回 null。
     */
    override fun convert(
        obj: UUID?,
        annotationGetter: AnnotationGetter
    ): String? {
        // 如果输入对象为 null，直接返回 null
        if (obj.isNull()) return null

        // 获取 UUIDJsonFormat 注解信息，若未找到则使用默认格式
        val dateTimeJsonFormat: UUIDJsonFormat = annotationGetter.get<UUIDJsonFormat>() ?: return obj.getString()

        // 根据注解中的 base 和 value 属性选择合适的字符串表示方式
        return if (BaseType.BASE16 != dateTimeJsonFormat.base) {
            obj.getString(dateTimeJsonFormat.base)
        } else if (UUIDFormatType.NO_UPPER_SPACE != dateTimeJsonFormat.value) {
            obj.getString(dateTimeJsonFormat.value)
        } else {
            obj.getString()
        }
    }

    /**
     * 将字符串反序列化为 UUID 对象。
     *
     * @param obj 需要反序列化的字符串，可能为 null 或空。
     * @param annotationGetter 用于获取注解信息的对象。
     * @return 反序列化后的 UUID 对象，如果输入无效则返回 null。
     */
    override fun deConvert(
        obj: String?,
        annotationGetter: AnnotationGetter
    ): UUID? {
        // 如果输入字符串为 null 或空，直接返回 null
        if (obj.isNullish()) return null

        // 获取 UUIDJsonFormat 注解信息，若未找到则使用默认解析方式
        val dateTimeJsonFormat: UUIDJsonFormat = annotationGetter.get<UUIDJsonFormat>() ?: return UUID.of(obj)

        // 根据注解中的 base 属性选择合适的解析方式
        return if (BaseType.BASE16 != dateTimeJsonFormat.base) {
            UUID.of(obj, dateTimeJsonFormat.base)
        } else {
            UUID.of(obj)
        }
    }

    /**
     * 返回当前转换器支持的目标类型引用。
     *
     * @return 表示 UUID 类型的 JsonTypeReference 对象。
     */
    override fun getFromType() = JsonTypeReference.of<UUID>()
}
