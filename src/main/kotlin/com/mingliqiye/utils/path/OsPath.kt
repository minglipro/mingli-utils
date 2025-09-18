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
 * CurrentFile OsPath.kt
 * LastUpdate 2025-09-18 09:47:43
 * UpdateUser MingLiPro
 */



package com.mingliqiye.utils.path

import java.io.File
import java.net.URI
import java.nio.file.Path
import java.nio.file.Paths

class OsPath private constructor(private val path: Path) : Path by path {

    companion object {
        @JvmStatic
        fun of(path: String): OsPath {
            return of(Paths.get(path))
        }

        @JvmStatic
        fun of(path: Path): OsPath {
            return OsPath(path)
        }

        @JvmStatic
        fun of(uri: URI): OsPath {
            return OsPath(Paths.get(uri))
        }

        @JvmStatic
        fun of(file: File): OsPath {
            return OsPath(file.toPath())
        }

        @JvmStatic
        fun getCwd(): OsPath {
            return OsPath(Paths.get(""))
        }
    }
}
