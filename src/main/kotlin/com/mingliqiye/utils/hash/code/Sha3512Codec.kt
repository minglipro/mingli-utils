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
 * CurrentFile Sha3512Codec.kt
 * LastUpdate 2026-11-18 11:18:52
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.hash.code

/**
 * SHA3-512 哈希编解码器（SHA-3 家族，Keccak 结构，输出 512 位 / 64 字节）。
 */
class Sha3512Codec : MessageDigestCodec("SHA3-512")
