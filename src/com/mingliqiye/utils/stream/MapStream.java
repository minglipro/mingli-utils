package com.mingliqiye.utils.stream;

import com.mingliqiye.utils.collection.Lists;

import java.util.*;
import java.util.function.*;

/**
 * 用于处理键值对的流实现
 *
 * @author MingLiPro
 * @param <K> 键类型
 * @param <V> 值类型
 */
public class MapStream<K, V> {

	private final List<Map.Entry<K, V>> entries;

	/**
	 * 构造方法
	 *
	 * @param entries 包含键值对的列表
	 */
	private MapStream(List<Map.Entry<K, V>> entries) {
		this.entries = entries != null ? entries : Lists.newArrayList();
	}

	/**
	 * 从Map创建MapStream
	 *
	 * @param map 输入Map
	 * @param <K> 键类型
	 * @param <V> 值类型
	 * @return MapStream实例
	 */
	public static <K, V> MapStream<K, V> of(Map<K, V> map) {
		return new MapStream<>(new ArrayList<>(map.entrySet()));
	}

	/**
	 * 从键值对数组创建MapStream
	 *
	 * @param entries 键值对数组
	 * @param <K>     键类型
	 * @param <V>     值类型
	 * @return MapStream实例
	 */
	@SafeVarargs
	public static <K, V> MapStream<K, V> of(Map.Entry<K, V>... entries) {
		return new MapStream<>(Lists.newArrayList(entries));
	}

	/**
	 * 根据键过滤MapStream
	 *
	 * @param keyPredicate 键的谓词条件
	 * @return 过滤后的MapStream
	 */
	public MapStream<K, V> filterByKey(Predicate<? super K> keyPredicate) {
		List<Map.Entry<K, V>> result = Lists.newArrayList();
		for (Map.Entry<K, V> entry : entries) {
			if (keyPredicate.test(entry.getKey())) {
				result.add(entry);
			}
		}
		return new MapStream<>(result);
	}

	/**
	 * 根据值过滤MapStream
	 *
	 * @param valuePredicate 值的谓词条件
	 * @return 过滤后的MapStream
	 */
	public MapStream<K, V> filterByValue(Predicate<? super V> valuePredicate) {
		List<Map.Entry<K, V>> result = Lists.newArrayList();
		for (Map.Entry<K, V> entry : entries) {
			if (valuePredicate.test(entry.getValue())) {
				result.add(entry);
			}
		}
		return new MapStream<>(result);
	}

	/**
	 * 过滤MapStream
	 *
	 * @param predicate 键值对的谓词条件
	 * @return 过滤后的MapStream
	 */
	public MapStream<K, V> filter(Predicate<Map.Entry<K, V>> predicate) {
		List<Map.Entry<K, V>> result = Lists.newArrayList();
		for (Map.Entry<K, V> entry : entries) {
			if (predicate.test(entry)) {
				result.add(entry);
			}
		}
		return new MapStream<>(result);
	}

	/**
	 * 转换键
	 *
	 * @param keyMapper 键映射函数
	 * @param <R>       新的键类型
	 * @return 转换后的MapStream
	 */
	public <R> MapStream<R, V> mapKey(
		Function<? super K, ? extends R> keyMapper
	) {
		List<Map.Entry<R, V>> result = Lists.newArrayList();
		for (Map.Entry<K, V> entry : entries) {
			R newKey = keyMapper.apply(entry.getKey());
			result.add(new AbstractMap.SimpleEntry<>(newKey, entry.getValue()));
		}
		return new MapStream<>(result);
	}

	/**
	 * 转换值
	 *
	 * @param valueMapper 值映射函数
	 * @param <R>         新的值类型
	 * @return 转换后的MapStream
	 */
	public <R> MapStream<K, R> mapValue(
		Function<? super V, ? extends R> valueMapper
	) {
		List<Map.Entry<K, R>> result = Lists.newArrayList();
		for (Map.Entry<K, V> entry : entries) {
			R newValue = valueMapper.apply(entry.getValue());
			result.add(new AbstractMap.SimpleEntry<>(entry.getKey(), newValue));
		}
		return new MapStream<>(result);
	}

	/**
	 * 转换键值对
	 *
	 * @param entryMapper 键值对映射函数
	 * @param <R>         新的键类型
	 * @param <S>         新的值类型
	 * @return 转换后的MapStream
	 */
	public <R, S> MapStream<R, S> map(
		Function<Map.Entry<K, V>, Map.Entry<R, S>> entryMapper
	) {
		List<Map.Entry<R, S>> result = Lists.newArrayList();
		for (Map.Entry<K, V> entry : entries) {
			result.add(entryMapper.apply(entry));
		}
		return new MapStream<>(result);
	}

	/**
	 * 将键值对流转换为Map
	 *
	 * @return 包含所有键值对的Map
	 */
	public Map<K, V> toMap() {
		Map<K, V> map = new HashMap<>();
		for (Map.Entry<K, V> entry : entries) {
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}

	/**
	 * 将键值对流转换为Map，指定Map类型和键冲突时的合并函数
	 *
	 * @param mapSupplier    Map工厂函数
	 * @param mergeFunction  键冲突合并函数
	 * @param <M>            Map类型
	 * @return 包含所有键值对的Map
	 */
	public <M extends Map<K, V>> M toMap(
		Supplier<M> mapSupplier,
		BinaryOperator<V> mergeFunction
	) {
		M map = mapSupplier.get();
		for (Map.Entry<K, V> entry : entries) {
			map.merge(entry.getKey(), entry.getValue(), mergeFunction);
		}
		return map;
	}

	/**
	 * 对每个键值对执行操作
	 *
	 * @param action 要执行的操作
	 */
	public void forEach(BiConsumer<? super K, ? super V> action) {
		for (Map.Entry<K, V> entry : entries) {
			action.accept(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * 计算键值对数量
	 *
	 * @return 键值对数量
	 */
	public long count() {
		return entries.size();
	}

	/**
	 * 获取键的流
	 *
	 * @return 键的流
	 */
	public ListStream<K> keys() {
		List<K> keys = Lists.newArrayList();
		for (Map.Entry<K, V> entry : entries) {
			keys.add(entry.getKey());
		}
		return ListStream.of(keys);
	}

	/**
	 * 获取值的流
	 *
	 * @return 值的流
	 */
	public ListStream<V> values() {
		List<V> values = Lists.newArrayList();
		for (Map.Entry<K, V> entry : entries) {
			values.add(entry.getValue());
		}
		return ListStream.of(values);
	}

	/**
	 * 对键值对进行排序
	 *
	 * @param comparator 比较器
	 * @return 排序后的MapStream
	 */
	public MapStream<K, V> sorted(Comparator<Map.Entry<K, V>> comparator) {
		List<Map.Entry<K, V>> sortedEntries = Lists.newArrayList(entries);
		sortedEntries.sort(comparator);
		return new MapStream<>(sortedEntries);
	}

	/**
	 * 限制键值对数量
	 *
	 * @param maxSize 最大数量
	 * @return 限制后的MapStream
	 */
	public MapStream<K, V> limit(long maxSize) {
		if (maxSize < 0) {
			throw new IllegalArgumentException("maxSize must be non-negative");
		}
		if (maxSize == 0) {
			return new MapStream<>(Lists.newArrayList());
		}

		List<Map.Entry<K, V>> limitedEntries = Lists.newArrayList();
		long count = 0;
		for (Map.Entry<K, V> entry : entries) {
			if (count >= maxSize) {
				break;
			}
			limitedEntries.add(entry);
			count++;
		}
		return new MapStream<>(limitedEntries);
	}

	/**
	 * 跳过指定数量的键值对
	 *
	 * @param n 要跳过的数量
	 * @return 跳过后的MapStream
	 */
	public MapStream<K, V> skip(long n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must be non-negative");
		}
		if (n == 0) {
			return new MapStream<>(Lists.newArrayList(entries));
		}

		List<Map.Entry<K, V>> skippedEntries = Lists.newArrayList();
		long count = 0;
		for (Map.Entry<K, V> entry : entries) {
			if (count >= n) {
				skippedEntries.add(entry);
			}
			count++;
		}
		return new MapStream<>(skippedEntries);
	}

	@Override
	public String toString() {
		if (entries.isEmpty()) {
			return "MapStream()";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("MapStream(");
		for (int i = 0; i < entries.size(); i++) {
			Map.Entry<K, V> entry = entries.get(i);
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			if (i != entries.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		return sb.toString();
	}
}
