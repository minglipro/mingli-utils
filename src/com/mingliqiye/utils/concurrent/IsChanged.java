package com.mingliqiye.utils.concurrent;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * IsChanged 类提供了一个线程安全的包装器，用于检测值是否发生变化。
 * 它基于 AtomicReference 实现，适用于需要监控数据变更的并发场景。
 *
 * @param <T> 泛型类型，表示被包装的数据类型
 * @author MingLiPro
 */
public class IsChanged<T> {

    /**
     * 使用 AtomicReference 来保证对数据的原子操作
     */
    private final AtomicReference<T> atomicReferenceData;

    /**
     * 默认构造函数，初始化数据为 null
     */
    public IsChanged() {
        this(null);
    }

    /**
     * 带参数的构造函数，使用指定的初始值初始化
     *
     * @param data 初始数据值
     */
    public IsChanged(T data) {
        atomicReferenceData = new AtomicReference<>(data);
    }

    /**
     * 设置新的数据值，不检查是否发生变化
     *
     * @param data 要设置的新数据值
     */
    public void set(T data) {
        atomicReferenceData.set(data);
    }

    /**
     * 获取当前数据值
     *
     * @return 当前数据值
     */
    public T get() {
        return atomicReferenceData.get();
    }

    /**
     * 设置新的数据值并返回旧的数据值
     *
     * @param data 要设置的新数据值
     * @return 设置前的旧数据值
     */
    public T setAndGet(T data) {
        return atomicReferenceData.getAndSet(data);
    }

    /**
     * 设置新的数据值，如果新值与当前值不同则更新并返回 true，否则返回 false
     * 使用 CAS(Compare-And-Swap) 操作确保线程安全
     *
     * @param data 要设置的新数据值
     * @return 如果值发生变化返回 true，否则返回 false
     */
    public boolean setAndChanged(T data) {
        T currentData;
        do {
            currentData = get();
            // 如果新值与当前值相等，则认为没有变化，直接返回 false
            if (Objects.equals(data, currentData)) {
                return false;
            }
            // 使用 CAS 操作尝试更新值，如果失败则重试
        } while (!atomicReferenceData.compareAndSet(currentData, data));
        // 成功更新值，返回 true 表示发生了变化
        return true;
    }
}
