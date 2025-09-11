package com.mingliqiye.utils.stream.interfaces;

public interface GetIdable<T> extends Getable<T> {
	T getId();

	default T get() {
		return getId();
	}
}
