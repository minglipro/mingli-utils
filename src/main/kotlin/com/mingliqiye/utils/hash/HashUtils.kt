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
 * CurrentFile HashUtils.kt
 * LastUpdate 2026-11-18 18:53:11
 * UpdateUser MingLiPro
 */
@file:JvmName("HashUtils")

package com.mingliqiye.utils.hash

import com.mingliqiye.utils.hash.code.*


/**
 * 提供 MD2 哈希器的懒加载实例。
 * 该哈希器输出 128 位摘要，算法已过时，仅用于兼容遗留系统。
 */
@get:JvmName("getMd2Codec")
val MD2 by lazy(::Md2Codec)

/**
 * 提供 MD5 哈希器的懒加载实例。
 * 该哈希器输出 128 位摘要，存在碰撞漏洞，不得用于安全场景，仅建议非安全性校验。
 */
@get:JvmName("getMd5Codec")
val MD5 by lazy(::Md5Codec)

/**
 * 提供 SHA-1 哈希器的懒加载实例。
 * 该哈希器输出 160 位摘要，存在碰撞攻击，不得用于安全场景，仅建议非安全性校验。
 */
@get:JvmName("getSha1Codec")
val SHA1 by lazy(::Sha1Codec)

/**
 * 提供 SHA-224 哈希器的懒加载实例。
 * 该哈希器属于 SHA-2 家族，输出 224 位摘要。
 */
@get:JvmName("getSha224Codec")
val SHA224 by lazy(::Sha224Codec)

/**
 * 提供 SHA-256 哈希器的懒加载实例。
 * 该哈希器属于 SHA-2 家族，输出 256 位摘要，适用于文件校验、数字签名等场景。
 */
@get:JvmName("getSha256Codec")
val SHA256 by lazy(::Sha256Codec)

/**
 * 提供 SHA-384 哈希器的懒加载实例。
 * 该哈希器属于 SHA-2 家族，输出 384 位摘要。
 */
@get:JvmName("getSha384Codec")
val SHA384 by lazy(::Sha384Codec)

/**
 * 提供 SHA-512 哈希器的懒加载实例。
 * 该哈希器属于 SHA-2 家族，输出 512 位摘要，在 64 位平台上通常比 SHA-256 更快。
 */
@get:JvmName("getSha512Codec")
val SHA512 by lazy(::Sha512Codec)

/**
 * 提供 SHA3-224 哈希器的懒加载实例。
 * 该哈希器属于 SHA-3 家族（Keccak 结构），输出 224 位摘要。
 */
@get:JvmName("getSha3224Codec")
val SHA3224 by lazy(::Sha3224Codec)

/**
 * 提供 SHA3-256 哈希器的懒加载实例。
 * 该哈希器属于 SHA-3 家族（Keccak 结构），输出 256 位摘要。
 */
@get:JvmName("getSha3256Codec")
val SHA3256 by lazy(::Sha3256Codec)

/**
 * 提供 SHA3-384 哈希器的懒加载实例。
 * 该哈希器属于 SHA-3 家族（Keccak 结构），输出 384 位摘要。
 */
@get:JvmName("getSha3384Codec")
val SHA3384 by lazy(::Sha3384Codec)

/**
 * 提供 SHA3-512 哈希器的懒加载实例。
 * 该哈希器属于 SHA-3 家族（Keccak 结构），输出 512 位摘要。
 */
@get:JvmName("getSha3512Codec")
val SHA3512 by lazy(::Sha3512Codec)

/**
 * 提供 SHA-512/224 哈希器的懒加载实例。
 * 该哈希器以 SHA-512 的运算结构截断输出至 224 位，在 64 位平台上性能优于 SHA-224。
 */
@get:JvmName("getSha512224Codec")
val SHA512224 by lazy(::Sha512224Codec)

/**
 * 提供 SHA-512/256 哈希器的懒加载实例。
 * 该哈希器以 SHA-512 的运算结构截断输出至 256 位，在 64 位平台上性能优于 SHA-256。
 */
@get:JvmName("getSha512256Codec")
val SHA512256 by lazy(::Sha512256Codec)
