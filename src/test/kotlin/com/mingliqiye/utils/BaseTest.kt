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
 * ModuleName mingli-utils.test
 * CurrentFile BaseTest.kt
 * LastUpdate 2026-02-08 03:05:52
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils

import com.mingliqiye.utils.base.code.*
import com.mingliqiye.utils.uuid.UUID
import org.junit.jupiter.api.Test


class BaseTest {
    @Test
    fun testBase2() {
        val uuid = UUID.getV7()
        val s = Base2.encode(uuid.toBytes())
        assert(uuid == UUID.of(Base2.decode(s)))
    }

    @Test
    fun testBase10() {
        val uuid = UUID.getV7()
        val s = Base10.encode(uuid.toBytes())
        assert(uuid == UUID.of(Base10.decode(s)))
    }

    @Test
    fun testBase16() {
        val uuid = UUID.getV7()
        val s = Base16.encode(uuid.toBytes())
        assert(uuid == UUID.of(Base16.decode(s)))
    }

    @Test
    fun testBase91() {
        val uuid = UUID.getV7()
        val s = Base91.encode(uuid.toBytes())
        assert(uuid == UUID.of(Base91.decode(s)))
    }

    @Test
    fun testBase256() {
        val uuid = UUID.getV7()
        val s = Base256.encode(uuid.toBytes())
        assert(uuid == UUID.of(Base256.decode(s)))
    }
}
