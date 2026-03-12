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
 * CurrentFile BaseCodes.kt
 * LastUpdate 2026-03-12 10:03:32
 * UpdateUser MingLiPro
 */

@file:JvmName("BaseCodes")

package com.mingliqiye.utils.base.code

import com.mingliqiye.utils.base.*

/**
 * 提供Base2编码器的懒加载实例。
 * 该编码器用于将数据编码为二进制格式。
 */
@get:JvmName("base2")
val BASE2: BaseCodec by lazy {
    Base2Codec()
}

/**
 * 提供Base10编码器的懒加载实例。
 * 该编码器用于将数据编码为十进制格式。
 */
@get:JvmName("base10")
val BASE10: BaseCodec by lazy {
    Base10Codec()
}

/**
 * 提供Base16编码器的懒加载实例。
 * 该编码器用于将数据编码为十六进制格式。
 */
@get:JvmName("base16")
val BASE16: BaseCodec by lazy {
    Base16Codec()
}

/**
 * 提供Base64编码器的懒加载实例。
 * 该编码器用于将数据编码为Base64格式，常用于URL安全传输或存储。
 */
@get:JvmName("base64")
val BASE64: BaseCodec by lazy {
    Base64Codec()
}

@get:JvmName("base64Url")
val BASE64URL: BaseCodec by lazy {
    Base64UrlCodec()
}

/**
 * 提供Base91编码器的懒加载实例。
 * 该编码器用于将数据编码为Base91格式，具有较高的压缩效率。
 */
@get:JvmName("base91")
val BASE91: BaseCodec by lazy {
    Base91Codec()
}

/**
 * 提供Base256编码器的懒加载实例。
 * 该编码器用于将数据编码为Base256格式，适用于字节级数据处理。
 */
@get:JvmName("base256")
val BASE256: BaseCodec by lazy {
    Base256Codec()
}
