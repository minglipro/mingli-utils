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
 * CurrentFile OsPath.java
 * LastUpdate 2025-09-09 08:37:34
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.path;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class OsPath implements Path {

	private final Path path;

	private OsPath(Path path) {
		this.path = path;
	}

	public static OsPath of(String path) {
		return of(Paths.get(path));
	}

	public static OsPath of(Path path) {
		return new OsPath(path);
	}

    public static OsPath of(URI uri) {
        return new OsPath(Paths.get(uri));
    }
    public static OsPath of(File file) {
        return new OsPath(file.toPath());
    }
    public static OsPath getCwd(){
        return new OsPath(Paths.get(""));
    }

	@Override
	public @NotNull FileSystem getFileSystem() {
		return path.getFileSystem();
	}

	@Override
	public boolean isAbsolute() {
		return path.isAbsolute();
	}

	@Override
	public Path getRoot() {
		return path.getRoot();
	}

	@Override
	public Path getFileName() {
		return path.getFileName();
	}

	@Override
	public Path getParent() {
		Path a = path.getParent();
		if (a == null) {
			a = path.toAbsolutePath().getParent();
		}
		return a;
	}

	@Override
	public int getNameCount() {
		return path.getNameCount();
	}

	@Override
	public @NotNull Path getName(int index) {
		return path.getName(index);
	}

	@Override
	public @NotNull Path subpath(int beginIndex, int endIndex) {
		return path.subpath(beginIndex, endIndex);
	}

	@Override
	public boolean startsWith(@NotNull Path other) {
		return path.startsWith(other);
	}

	@Override
	public boolean startsWith(@NotNull String other) {
		return path.startsWith(other);
	}

	@Override
	public boolean endsWith(@NotNull Path other) {
		return path.endsWith(other);
	}

	@Override
	public boolean endsWith(@NotNull String other) {
		return path.endsWith(other);
	}

	@Override
	public @NotNull Path normalize() {
		return path.normalize();
	}

	@Override
	public @NotNull Path resolve(@NotNull Path other) {
		return path.resolve(other);
	}

	@Override
	public @NotNull Path resolve(@NotNull String other) {
		return path.resolve(other);
	}

	@Override
	public @NotNull Path resolveSibling(@NotNull Path other) {
		return path.resolveSibling(other);
	}

	@Override
	public @NotNull Path resolveSibling(@NotNull String other) {
		return path.resolveSibling(other);
	}

	@Override
	public @NotNull Path relativize(@NotNull Path other) {
		return path.relativize(other);
	}

	@Override
	public @NotNull URI toUri() {
		return path.toUri();
	}

	@Override
	public @NotNull Path toAbsolutePath() {
		return path.toAbsolutePath();
	}

	@Override
	public @NotNull Path toRealPath(@NotNull LinkOption... options)
		throws IOException {
		return path.toRealPath(options);
	}

	@Override
	public @NotNull File toFile() {
		return path.toFile();
	}

	@Override
	public @NotNull WatchKey register(
		@NotNull WatchService watcher,
		WatchEvent.@NotNull Kind<?>[] events,
		@NotNull WatchEvent.Modifier... modifiers
	) throws IOException {
		return path.register(watcher, events, modifiers);
	}

	@Override
	public @NotNull WatchKey register(
		@NotNull WatchService watcher,
		WatchEvent.@NotNull Kind<?>... events
	) throws IOException {
		return path.register(watcher, events);
	}

	@Override
	public @NotNull Iterator<@NotNull Path> iterator() {
		return path.iterator();
	}

	@Override
	public int compareTo(@NotNull Path other) {
		return path.compareTo(other);
	}

	@Override
	public boolean equals(Object other) {
		return path.equals(other);
	}

	@Override
	public int hashCode() {
		return path.hashCode();
	}

	@Override
	public @NotNull String toString() {
		return path.toString();
	}

	@Override
	public void forEach(Consumer<? super Path> action) {
		path.forEach(action);
	}

	@Override
	public Spliterator<Path> spliterator() {
		return path.spliterator();
	}
}
