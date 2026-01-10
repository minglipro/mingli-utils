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
 * CurrentFile Require.kt
 * LastUpdate 2026-01-10 08:53:26
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.request

import com.mingliqiye.utils.functions.P1RFunction
import com.mingliqiye.utils.functions.RFunction

class Require(private val must: Boolean) {

    constructor(funs: RFunction<Boolean>) : this(funs.call())

    constructor(must: RFunction<Boolean>, message: String) : this(must) {
        throws(message)
    }

    constructor(
        must: RFunction<Boolean>,
        message: String,
        exception: Class<out Exception> = IllegalArgumentException::class.java
    ) : this(must) {
        throws(message, exception)
    }

    constructor(must: Boolean, message: String) : this(must) {
        throws(message)
    }

    constructor(
        must: Boolean, message: String, exception: Class<out Exception> = IllegalArgumentException::class.java
    ) : this(must) {
        throws(message, exception)
    }

    constructor(
        must: Boolean, message: String, exception: P1RFunction<String, out Exception>
    ) : this(must) {
        throws(message, exception)
    }

    companion object {
        fun Boolean.require(message: String, exception: P1RFunction<String, out Exception>): Require {
            return Require(this, message, exception)
        }

        fun Boolean.require(
            message: String,
            exception: Class<out Exception> = IllegalArgumentException::class.java
        ): Require {
            return Require(this, message, exception)
        }

        @JvmStatic
        fun require(
            must: Boolean, message: String, exception: Class<out Exception> = IllegalArgumentException::class.java
        ): Require {
            return Require(must, message, exception)
        }

        @JvmStatic
        fun require(must: Boolean, message: String): Require {
            return Require(must, message)
        }

        @JvmStatic
        fun require(must: Boolean): Require {
            return Require(must)
        }

        @JvmStatic
        fun require(
            must: RFunction<Boolean>,
            message: String,
            exception: Class<out Exception> = IllegalArgumentException::class.java
        ): Require {
            return Require(must, message, exception)
        }

        @JvmStatic
        fun require(must: RFunction<Boolean>, message: String): Require {
            return Require(must, message)
        }

        @JvmStatic
        fun require(must: RFunction<Boolean>): Require {
            return Require(must)
        }
    }

    fun throws(message: String) {
        if (!must) {
            throw IllegalArgumentException(message)
        }
    }

    fun throws(string: String, exception: Class<out Exception>) {
        if (!must) {
            throw exception.getConstructor(String::class.java).newInstance(string)
        }
    }

    fun throws(string: String, exception: P1RFunction<String, out Exception>) {
        if (!must) {
            throw exception.call(string)
        }
    }
}
