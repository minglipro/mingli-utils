package com.mingliqiye.utils.data;

/**
 * 泛型线程局部变量持有器
 * <p>
 * 封装了 ThreadLocal 的常用操作，提供更便捷的 API 来管理线程本地变量。
 *
 * @param <T> 存储的数据类型
 * @author MingLiPro
 */
public class ThreadLocalDataHolder<T> {

    private final ThreadLocal<T> threadLocal;

    /**
     * 构造函数，初始化 ThreadLocal 实例
     */
    public ThreadLocalDataHolder() {
        this.threadLocal = new ThreadLocal<>();
    }

    /**
     * 获取当前线程存储的值
     *
     * @return 当前线程存储的值，如果没有则返回null
     */
    public T get() {
        return threadLocal.get();
    }

    /**
     * 设置当前线程的值
     *
     * @param value 要存储的值
     */
    public void set(T value) {
        threadLocal.set(value);
    }

    /**
     * 移除当前线程存储的值
     * <p>
     * 防止内存泄漏，使用完毕后应调用此方法清理资源。
     */
    public void remove() {
        threadLocal.remove();
    }

    /**
     * 获取当前线程存储的值，如果不存在则返回默认值
     *
     * @param defaultValue 默认值
     * @return 当前线程存储的值或默认值
     */
    public T getOrDefault(T defaultValue) {
        T value = threadLocal.get();
        return value != null ? value : defaultValue;
    }

    /**
     * 安全获取值（避免NPE）
     * <p>
     * 在某些异常情况下防止抛出异常，直接返回 null。
     *
     * @return 值或null
     */
    public T safeGet() {
        try {
            return threadLocal.get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 检查当前线程是否有值
     *
     * @return 是否有值
     */
    public boolean isPresent() {
        return threadLocal.get() != null;
    }
}
