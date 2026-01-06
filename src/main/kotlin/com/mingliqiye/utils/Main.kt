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
 * CurrentFile Main.kt
 * LastUpdate 2026-01-06 14:04:14
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.network.NetworkEndpoint
import com.mingliqiye.utils.uuid.UUID
import java.nio.ByteBuffer

fun main() {
    val byteBuffer = ByteBuffer.allocate(320)
    NetworkEndpoint
        .of("0:65532")
        .writeIpv4toByteBuffer(byteBuffer)

    UUID.getMaxUUID().writeToByteBuffer(byteBuffer)

    byteBuffer.flip()

    println(NetworkEndpoint.ofIpv4(byteBuffer))
    println(UUID.of(byteBuffer))

}
