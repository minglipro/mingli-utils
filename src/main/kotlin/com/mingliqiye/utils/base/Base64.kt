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
 * CurrentFile Base64.kt
 * LastUpdate 2026-02-08 03:08:10
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

/*
 * Base64编解码工具类
 * 提供Base64编码和解码功能的实现
 */
internal class Base64 : BaseCodec {

    /*
     * Base64编码器实例
     * 用于执行字节数组到Base64字符串的编码操作
     */
    val BASE_64_ENCODER: java.util.Base64.Encoder = java.util.Base64.getEncoder()

    /*
     * Base64解码器实例
     * 用于执行Base64字符串到字节数组的解码操作
     */
    val BASE_64_DECODER: java.util.Base64.Decoder = java.util.Base64.getDecoder()

    /*
     * 将字节数组编码为Base64字符串
     *
     * @param bytes 待编码的字节数组
     * @return 编码后的Base64字符串
     */
    override fun encode(bytes: ByteArray): String {
        return BASE_64_ENCODER.encodeToString(bytes)
    }

    /*
     * 将Base64字符串解码为字节数组
     *
     * @param string 待解码的Base64字符串
     * @return 解码后的字节数组
     */
    override fun decode(string: String): ByteArray {
        return BASE_64_DECODER.decode(string)
    }
}
