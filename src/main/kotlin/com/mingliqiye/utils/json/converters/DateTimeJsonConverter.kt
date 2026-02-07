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
 * CurrentFile DateTimeJsonConverter.kt
 * LastUpdate 2026-02-07 22:13:41
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.json.converters

import com.mingliqiye.utils.annotation.DateTimeJsonFormat
import com.mingliqiye.utils.json.api.type.JsonTypeReference
import com.mingliqiye.utils.json.converters.base.AnnotationGetter
import com.mingliqiye.utils.json.converters.base.AnnotationGetter.Companion.get
import com.mingliqiye.utils.json.converters.base.BaseJsonStringConverter
import com.mingliqiye.utils.objects.isNull
import com.mingliqiye.utils.string.isNullish
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.Formatter


/**
 * DateTimeJsonConverter 是一个用于处理 DateTime 类型与 JSON 字符串之间转换的类。
 * 它继承自 BaseJsonStringConverter，提供了序列化（convert）和反序列化（deConvert）的功能。
 */
class DateTimeJsonConverter private constructor() : BaseJsonStringConverter<DateTime> {


    companion object {
        private val dateTimeJsonConverter by lazy {
            DateTimeJsonConverter()
        }

        @JvmStatic
        fun getJsonConverter(): DateTimeJsonConverter = dateTimeJsonConverter
    }

    /**
     * 将 DateTime 对象转换为 JSON 字符串。
     *
     * @param obj 需要转换的 DateTime 对象，可能为 null。
     * @param annotationGetter 用于获取注解信息的对象，用于决定格式化方式。
     * @return 转换后的字符串，如果输入为 null 则返回 null。
     * @throws Exception 如果在转换过程中发生异常。
     */
    @Throws(Exception::class)
    override fun convert(obj: DateTime?, annotationGetter: AnnotationGetter): String? {
        // 如果输入对象为 null，直接返回 null
        if (obj.isNull()) return null

        // 获取 DateTimeJsonFormat 注解信息
        val dateTimeJsonFormat: DateTimeJsonFormat? = annotationGetter.get<DateTimeJsonFormat>()

        // 根据注解中的格式化规则进行转换
        return if (Formatter.NONE != dateTimeJsonFormat?.value && dateTimeJsonFormat != null) {
            obj.format(dateTimeJsonFormat.value, dateTimeJsonFormat.repcZero)
        } else if (dateTimeJsonFormat?.formatter?.isEmpty() == false) {
            obj.format(dateTimeJsonFormat.formatter, dateTimeJsonFormat.repcZero)
        } else {
            obj.format()
        }
    }

    /**
     * 将 JSON 字符串转换为 DateTime 对象。
     *
     * @param obj 需要转换的字符串，可能为 null 或空。
     * @param annotationGetter 用于获取注解信息的对象，用于决定解析方式。
     * @return 解析后的 DateTime 对象，如果输入为 null 或空则返回 null。
     * @throws Exception 如果在解析过程中发生异常。
     */
    @Throws(Exception::class)
    override fun deConvert(obj: String?, annotationGetter: AnnotationGetter): DateTime? {
        // 如果输入字符串为 null 或空，直接返回 null
        if (obj.isNullish()) return null

        // 获取 DateTimeJsonFormat 注解信息
        val dateTimeJsonFormat: DateTimeJsonFormat? = annotationGetter.get<DateTimeJsonFormat>()

        // 根据注解中的解析规则进行转换
        return if (Formatter.NONE != dateTimeJsonFormat?.value && dateTimeJsonFormat != null) {
            DateTime.parse(obj, dateTimeJsonFormat.value, dateTimeJsonFormat.repcZero)
        } else if (dateTimeJsonFormat?.formatter?.isEmpty() == false) {
            DateTime.parse(obj, dateTimeJsonFormat.formatter, dateTimeJsonFormat.repcZero)
        } else {
            DateTime.parse(obj)
        }
    }

    /**
     * 获取当前转换器支持的目标类型引用。
     *
     * @return 返回 DateTime 类型的 JsonTypeReference。
     * @throws Exception 如果在获取类型引用时发生异常。
     */
    @Throws(Exception::class)
    override fun getFromType(): JsonTypeReference<DateTime> = JsonTypeReference.of<DateTime>()
}
