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
 * CurrentFile Sha1Codec.kt
 * LastUpdate 2026-11-18 11:18:32
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.hash.code

/**
 * SHA-1 哈希编解码器（输出 160 位 / 20 字节）。
 *
 * SHA-1 已被证实存在碰撞攻击（SHAttered），不得用于安全场景，
 * 仅建议用于兼容遗留系统或非安全性校验。
 */
class Sha1Codec : MessageDigestCodec("SHA-1")
