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
 * CurrentFile WinKernel32.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.jna.time;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.LongByReference;

/**
 * @author MingLiPro
 */
public interface WinKernel32 extends Library {
	static WinKernel32 load() {
		return Native.load("kernel32", WinKernel32.class);
	}

	boolean QueryPerformanceCounter(LongByReference lpPerformanceCount);
	boolean QueryPerformanceFrequency(LongByReference lpFrequency);
	void GetSystemTimePreciseAsFileTime(byte[] lpSystemTimeAsFileTime);
}
