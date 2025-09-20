/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile IO.kt
 * LastUpdate 2025-09-20 11:46:19
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.io


fun Any?.println() {
    IO.println(this)
}


class IO {
    companion object {

        @JvmStatic
        fun print(vararg args: Any?) {
            print(" ", *args)
        }

        @JvmStatic
        fun println(vararg args: Any?) {
            println(" ", *args)
        }

        @JvmStatic
        fun println(sp: String = " ", vararg args: Any?) {
            print(" ", *args)
            kotlin.io.println()
        }

        @JvmStatic
        fun print(sp: String = " ", vararg args: Any?) {
            if (args.isEmpty()) {
                kotlin.io.println()
            }
            val sb = StringBuilder()
            for (i in args.indices) {
                sb.append(args[i])
                if (i < args.size - 1) sb.append(sp)
            }
            kotlin.io.print(sb)
        }
    }
}
