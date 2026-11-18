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
 * CurrentFile Md5Codec.kt
 * LastUpdate 2026-11-18 11:18:32
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.hash.code

/**
 * MD5 哈希编解码器（输出 128 位 / 16 字节）。
 *
 * MD5 已被证实存在碰撞漏洞，不得用于数字签名、密码存储等安全场景，
 * 仅建议用于兼容遗留系统或非安全性校验（如文件完整性粗检）。
 */
class Md5Codec : MessageDigestCodec("MD5")
