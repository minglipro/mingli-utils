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
 * CurrentFile OsPath.kt
 * LastUpdate 2026-10-20 20:05:37
 * UpdateUser MingLiPro
 */



package com.mingliqiye.utils.path

import java.io.File
import java.net.URI
import java.nio.file.*
import java.util.*
import java.util.function.Consumer

class OsPath private constructor(private val path: Path) : Path by path {
    override fun forEach(action: Consumer<in Path>?) {
        path.forEach(action)
    }

    override fun spliterator(): Spliterator<Path?> {
        return path.spliterator()
    }

    override fun startsWith(other: String): Boolean {
        return path.startsWith(other)
    }

    override fun endsWith(other: String): Boolean {
        return path.endsWith(other)
    }

    override fun resolve(other: String): Path {
        return path.resolve(other)
    }

    override fun resolveSibling(other: Path): Path {
        return path.resolveSibling(other)
    }

    override fun resolveSibling(other: String): Path {
        return path.resolveSibling(other)
    }

    override fun toFile(): File {
        return path.toFile()
    }

    override fun register(
        watcher: WatchService,
        vararg events: WatchEvent.Kind<*>,
    ): WatchKey {
        return path.register(watcher, *events)
    }

    override fun iterator(): MutableIterator<Path> {
        return path.iterator()
    }

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
