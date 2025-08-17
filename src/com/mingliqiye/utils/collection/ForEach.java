package com.mingliqiye.utils.collection;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

/**
 * ListsAMaps 工具类提供对集合和映射的增强遍历功能。
 * 包含多个重载的 forEach 方法，支持带索引的遍历操作。
 */
public class ForEach {

	/**
	 * 对给定的集合执行指定的操作，操作包含元素值和索引。
	 * 根据集合类型选择最优的遍历方式以提高性能。
	 *
	 * @param collection 要遍历的集合，可以是 List 或其他 Collection 实现
	 * @param action     要对每个元素执行的操作，接收元素值和索引作为参数
	 * @param <T>        集合中元素的类型
	 */
	public static <T> void forEach(
		Collection<T> collection,
		ForEach.Consumer<? super T> action
	) {
		// 参数校验：如果集合或操作为空，则直接返回
		if (collection == null || action == null) {
			return;
		}

		// 如果集合实现了 RandomAccess 接口（如 ArrayList），使用索引访问优化性能
		if (collection instanceof RandomAccess && collection instanceof List) {
			List<T> list = (List<T>) collection;
			for (int i = 0; i < list.size(); i++) {
				action.call(list.get(i), i);
			}
		}
		// 如果是普通 List，使用迭代器遍历并手动维护索引
		else if (collection instanceof List) {
			int index = 0;
			Iterator<T> it = collection.iterator();
			while (it.hasNext()) {
				action.call(it.next(), index);
				index++;
			}
		}
		// 其他类型的集合使用增强 for 循环，并手动维护索引
		else {
			int index = 0;
			for (T element : collection) {
				action.call(element, index);
				index++;
			}
		}
	}

	/**
	 * 对给定的集合执行指定的操作，仅处理元素值。
	 * 根据集合是否实现 RandomAccess 接口选择最优的遍历方式。
	 *
	 * @param collection 要遍历的集合
	 * @param action     要对每个元素执行的操作，只接收元素值作为参数
	 * @param <T>        集合中元素的类型
	 */
	public static <T> void forEach(
		Collection<T> collection,
		java.util.function.Consumer<? super T> action
	) {
		// 参数校验：如果集合或操作为空，则直接返回
		if (collection == null || action == null) {
			return;
		}

		// 如果集合实现了 RandomAccess 接口，使用索引访问提升性能
		if (collection instanceof RandomAccess) {
			List<T> list = (List<T>) collection;
			for (int i = 0; i < list.size(); i++) {
				action.accept(list.get(i));
			}
		}
		// 否则使用增强 for 循环进行遍历
		else {
			for (T element : collection) {
				action.accept(element);
			}
		}
	}

	/**
	 * 对给定的映射执行指定的操作，操作包含键、值和索引。
	 * 根据映射类型选择不同的遍历策略。
	 *
	 * @param map    要遍历的映射
	 * @param action 要对每个键值对执行的操作，接收键、值和索引作为参数
	 * @param <K>    映射中键的类型
	 * @param <V>    映射中值的类型
	 */
	public static <K, V> void forEach(
		Map<K, V> map,
		BiConsumer<? super K, ? super V> action
	) {
		// 参数校验：如果映射或操作为空，则直接返回
		if (map == null || action == null) {
			return;
		}

		// 遍历 TreeMap 的条目集合并传递索引
		if (map instanceof TreeMap) {
			int index = 0;
			for (Map.Entry<K, V> entry : map.entrySet()) {
				action.call(entry.getKey(), entry.getValue(), index);
				index++;
			}
		}
		// 遍历 ConcurrentMap 或 LinkedHashMap 的条目集合并传递索引
		else if (map instanceof ConcurrentMap || map instanceof LinkedHashMap) {
			int index = 0;
			for (Map.Entry<K, V> entry : map.entrySet()) {
				action.call(entry.getKey(), entry.getValue(), index);
				index++;
			}
		}
		// 遍历其他类型映射的条目集合并传递索引
		else {
			int index = 0;
			for (Map.Entry<K, V> entry : map.entrySet()) {
				action.call(entry.getKey(), entry.getValue(), index);
				index++;
			}
		}
	}

	/**
	 * 对给定的映射执行指定的操作，仅处理键和值。
	 * 根据映射类型选择不同的遍历策略。
	 *
	 * @param map    要遍历的映射
	 * @param action 要对每个键值对执行的操作，接收键和值作为参数
	 * @param <K>    映射中键的类型
	 * @param <V>    映射中值的类型
	 */
	public static <K, V> void forEach(
		Map<K, V> map,
		java.util.function.BiConsumer<? super K, ? super V> action
	) {
		// 参数校验：如果映射或操作为空，则直接返回
		if (map == null || action == null) {
			return;
		}

		// 遍历 TreeMap 的条目集合
		if (map instanceof TreeMap) {
			for (Map.Entry<K, V> entry : map.entrySet()) {
				action.accept(entry.getKey(), entry.getValue());
			}
		}
		// 如果是 ConcurrentMap 或 LinkedHashMap，使用其内置的 forEach 方法
		else if (map instanceof ConcurrentMap || map instanceof LinkedHashMap) {
			map.forEach(action);
		}
		// 遍历其他类型映射的条目集合
		else {
			for (Map.Entry<K, V> entry : map.entrySet()) {
				action.accept(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 自定义消费者接口，用于接收元素值和索引。
	 *
	 * @param <T> 元素类型
	 */
	@FunctionalInterface
	public interface Consumer<T> {
		/**
		 * 执行消费操作。
		 *
		 * @param value 元素值
		 * @param index 元素在集合中的索引
		 */
		void call(T value, int index);
	}

	/**
	 * 自定义二元消费者接口，用于接收键、值和索引。
	 *
	 * @param <K> 键类型
	 * @param <V> 值类型
	 */
	@FunctionalInterface
	public interface BiConsumer<K, V> {
		/**
		 * 执行消费操作。
		 *
		 * @param key   键
		 * @param value 值
		 * @param index 键值对在映射中的索引
		 */
		void call(K key, V value, int index);
	}
}
