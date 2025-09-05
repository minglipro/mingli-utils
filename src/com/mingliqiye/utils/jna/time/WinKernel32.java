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
