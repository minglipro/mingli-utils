package com.mingliqiye.utils.functions;

import java.util.concurrent.*;

/**
 * 防抖器类，用于实现防抖功能，防止在短时间内重复执行相同任务
 *
 * @author MingLiPro
 */
public class Debouncer {

	private final ScheduledExecutorService scheduler =
		Executors.newSingleThreadScheduledExecutor();
	private final ConcurrentHashMap<Object, Future<?>> delayedMap =
		new ConcurrentHashMap<>();
	private final long delay;

	/**
	 * 构造函数，创建一个防抖器实例
	 *
	 * @param delay 延迟时间
	 * @param unit  时间单位
	 */
	public Debouncer(long delay, TimeUnit unit) {
		this.delay = unit.toMillis(delay);
	}

	/**
	 * 执行防抖操作，如果在指定延迟时间内再次调用相同key的任务，则取消之前的任务并重新计时
	 *
	 * @param key  任务的唯一标识符，用于区分不同任务
	 * @param task 要执行的任务
	 */
	public void debounce(final Object key, final Runnable task) {
		// 提交新任务并获取之前可能存在的任务
		final Future<?> prev = delayedMap.put(
			key,
			scheduler.schedule(
				() -> {
					try {
						task.run();
					} finally {
						// 任务执行完成后从映射中移除
						delayedMap.remove(key);
					}
				},
				delay,
				TimeUnit.MILLISECONDS
			)
		);

		// 如果之前存在任务，则取消它
		if (prev != null) {
			prev.cancel(true);
		}
	}

	/**
	 * 关闭防抖器，取消所有待执行的任务并关闭调度器
	 */
	public void shutdown() {
		// 先取消所有延迟任务
		for (Future<?> future : delayedMap.values()) {
			future.cancel(true);
		}
		delayedMap.clear();

		// 再关闭调度器
		scheduler.shutdownNow();
	}
}
