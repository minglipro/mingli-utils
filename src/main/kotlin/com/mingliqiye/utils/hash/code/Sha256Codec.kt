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
 * CurrentFile Sha256Codec.kt
 * LastUpdate 2026-11-18 11:18:32
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.hash.code

/**
 * SHA-256 哈希编解码器（SHA-2 家族，输出 256 位 / 32 字节）。
 *
 * 目前广泛使用的安全哈希算法，适用于文件校验、数字签名、消息摘要等场景。
 *
 * 使用示例：
 * ```
 * val sha256 = Sha256Codec()
 * val hex = sha256.hashHex("hello")
 * val ok = sha256.verifyHash("hello", hex)
 * ```
 */
class Sha256Codec : MessageDigestCodec("SHA-256")
