package com.mingliqiye.utils.stream.interfaces;

public interface GetKeyable<T> {
	T getKey();

	default T get() {
		return getKey();
	}
}
