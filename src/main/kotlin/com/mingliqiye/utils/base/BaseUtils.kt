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
 * CurrentFile BaseUtils.kt
 * LastUpdate 2025-09-17 10:54:46
 * UpdateUser MingLiPro
 */

@file:JvmName("BaseUtils")

package com.mingliqiye.utils.base

/**
 * Base64编解码器实例
 * 使用懒加载方式初始化Base64编解码器对象
 * 保证线程安全且只在首次访问时创建实例
 */
val BASE64: BaseCodec by lazy {
    Base64()
}

/**
 * Base91编解码器实例
 * 使用懒加载方式初始化Base91编解码器对象
 * 保证线程安全且只在首次访问时创建实例
 */
val BASE91: BaseCodec by lazy {
    Base91()
}

/**
 * Base91编解码器实例
 * 使用懒加载方式初始化Base91编解码器对象
 * 保证线程安全且只在首次访问时创建实例
 */
val BASE16: BaseCodec by lazy {
    Base16()
}


