package com.mingliqiye.utils.stream.interfaces;

public interface GetNameable<T> extends Getable<T> {
	T getName();

	default T get() {
		return getName();
	}
}
