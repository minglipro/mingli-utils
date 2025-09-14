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
 * CurrentFile SuperStream.java
 * LastUpdate 2025-09-14 20:16:59
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.stream;

import com.mingliqiye.utils.collection.Lists;
import com.mingliqiye.utils.collection.Maps;
import com.mingliqiye.utils.stream.interfaces.Getable;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.*;
import java.util.stream.*;

/**
 * 自定义的 SuperStream 实现类，用于对集合进行流式操作。
 * 该类实现了 Java 标准库中的 Stream 接口，并基于 List 数据结构提供了一系列流式处理方法。
 *
 * @param <T> 流中元素的类型
 * @author MingLiPro
 */
public class SuperStream<T> implements Stream<T> {

	/**
	 * 内部流对象，用于执行实际的流操作。
	 */
	private final Stream<T> stream;

	/**
	 * 构造函数，使用给定的流对象初始化 SuperStream。
	 *
	 * @param stream 流对象
	 */
	public SuperStream(Stream<T> stream) {
		this.stream = stream;
	}

	/**
	 * 创建一个 SuperStream 实例，基于给定的集合。
	 *
	 * @param collection 集合
	 * @param parallel   是否并行流
	 * @param <T>        元素类型
	 * @return SuperStream 实例
	 */
	public static <T> SuperStream<T> of(
		Collection<T> collection,
		boolean parallel
	) {
		return new SuperStream<>(
			parallel ? collection.parallelStream() : collection.stream()
		);
	}

	/**
	 * 创建一个 SuperStream 实例，基于给定的集合。
	 *
	 * @param collection 集合
	 * @param <T>        元素类型
	 * @return SuperStream 实例
	 */
	public static <T> SuperStream<T> of(Collection<T> collection) {
		return of(collection, false);
	}

	/**
	 * 创建一个 SuperStream 实例，基于给定的 Map。
	 *
	 * @param map      Map
	 * @param parallel 是否并行流
	 * @param <K>      键类型
	 * @param <V>      值类型
	 * @return SuperStream 实例
	 */
	public static <K, V> SuperStream<Map.Entry<K, V>> of(
		Map<K, V> map,
		boolean parallel
	) {
		return new SuperStream<>(
			parallel ? map.entrySet().parallelStream() : map.entrySet().stream()
		);
	}

	/**
	 * 创建一个 SuperStream 实例，基于给定的 Map。
	 *
	 * @param map Map
	 * @param <K> 键类型
	 * @param <V> 值类型
	 * @return SuperStream 实例
	 */
	public static <K, V> SuperStream<Map.Entry<K, V>> of(Map<K, V> map) {
		return of(map, false);
	}

	/**
	 * 创建一个 SuperStream 构建器。
	 *
	 * @param <T> 元素类型
	 * @return 构建器
	 */
	public static <T> Builder<T> builder() {
		return new Builder<T>() {
			private final List<T> list = new ArrayList<>();

			@Override
			public void accept(T t) {
				list.add(t);
			}

			@Override
			public @NotNull SuperStream<T> build() {
				return new SuperStream<>(list.stream());
			}
		};
	}

	/**
	 * 创建一个空的 SuperStream 实例。
	 *
	 * @param <T> 元素类型
	 * @return SuperStream 实例
	 */
	public static @NotNull <T> SuperStream<T> empty() {
		return new SuperStream<>(Stream.empty());
	}

	/**
	 * 创建一个包含单个元素的 SuperStream 实例。
	 *
	 * @param t   元素
	 * @param <T> 元素类型
	 * @return SuperStream 实例
	 */
	public static @NotNull <T> SuperStream<T> of(T t) {
		return new SuperStream<>(Stream.of(t));
	}

	/**
	 * 创建一个包含多个元素的 SuperStream 实例。
	 *
	 * @param values 元素数组
	 * @param <T>    元素类型
	 * @return SuperStream 实例
	 */
	@SafeVarargs
	public static @NotNull <T> SuperStream<T> of(T... values) {
		return new SuperStream<>(Stream.of(values));
	}

	/**
	 * 创建一个无限流，使用指定的种子和函数生成元素。
	 *
	 * @param seed 种子
	 * @param f    函数
	 * @param <T>  元素类型
	 * @return SuperStream 实例
	 */
	public static @NotNull <T> SuperStream<T> iterate(
		T seed,
		UnaryOperator<T> f
	) {
		return new SuperStream<>(Stream.iterate(seed, f));
	}

	/**
	 * 创建一个无限流，使用指定的供应商生成元素。
	 *
	 * @param s   供应商
	 * @param <T> 元素类型
	 * @return SuperStream 实例
	 */
	public static @NotNull <T> SuperStream<T> generate(Supplier<T> s) {
		return new SuperStream<>(Stream.generate(s));
	}

	/**
	 * 连接两个流。
	 *
	 * @param a   第一个流
	 * @param b   第二个流
	 * @param <T> 元素类型
	 * @return SuperStream 实例
	 */
	public static @NotNull <T> SuperStream<T> concat(
		@NotNull Stream<? extends T> a,
		@NotNull Stream<? extends T> b
	) {
		return new SuperStream<>(Stream.concat(a, b));
	}

	public T get(int index) {
		return find(index).orElse(null);
	}

	public Optional<T> find(int index) {
		if (index < 0 || index >= size()) {
			return Optional.empty();
		}
		return Optional.of(toList().get(index));
	}

	public boolean isEmpty() {
		return !findAny().isPresent();
	}

	public long size() {
		return count();
	}

	/**
	 * 将流中的元素收集到 List 中。
	 *
	 * @return 包含流中所有元素的 List
	 */
	public List<T> toList() {
		return stream.collect(Collectors.toList());
	}

	/**
	 * 将流中的元素收集到 Set 中。
	 *
	 * @return 包含流中所有元素的 Set
	 */
	public Set<T> toSet() {
		return stream.collect(Collectors.toSet());
	}

	/**
	 * 将流中的元素转换为 Map，键由 mapper 生成，值为元素本身。
	 *
	 * @param mapper 键映射函数
	 * @param <D>    键类型
	 * @return 包含流中所有元素的 Map
	 */
	public <D> Map<D, T> toMap(Function<T, D> mapper) {
		return stream.collect(Collectors.toMap(mapper));
	}

	/**
	 * 将流中的元素转换为 Map.Entry 列表，并使用 Maps.ofEntries 方法转换为 Map。
	 *
	 * @param <K> 键类型
	 * @param <V> 值类型
	 * @return 包含流中所有元素的 Map
	 */
	@SuppressWarnings("unchecked")
	public <K, V> Map<K, V> entryToMap() {
		return Maps.ofEntries((List<Map.Entry<K, V>>) toList());
	}

	/**
	 * 返回一个顺序流。
	 *
	 * @return SuperStream 实例
	 */
	@Override
	public @NotNull SuperStream<T> sequential() {
		return new SuperStream<>(stream.sequential());
	}

	/**
	 * 过滤流中的元素。
	 *
	 * @param predicate 谓词函数
	 * @return SuperStream 实例
	 */
	@Override
	public SuperStream<T> filter(Predicate<? super T> predicate) {
		return new SuperStream<>(stream.filter(predicate));
	}

	/**
	 * 过滤流中的元素，使用 Function 作为谓词。
	 *
	 * @param predicate 谓词函数
	 * @return SuperStream 实例
	 * @since 3.2.5
	 */
	public SuperStream<T> filterBoolean(Function<T, Boolean> predicate) {
		return new SuperStream<>(stream.filter(predicate::apply));
	}

	/**
	 * 映射流中的元素。
	 *
	 * @param mapper 映射函数
	 * @param <R>    映射后的元素类型
	 * @return SuperStream 实例
	 */
	@Override
	public <R> SuperStream<R> map(Function<? super T, ? extends R> mapper) {
		return new SuperStream<>(stream.map(mapper));
	}

	/**
	 * 扁平化映射流中的元素。
	 *
	 * @param mapper 映射函数
	 * @param <R>    映射后的元素类型
	 * @return SuperStream 实例
	 */
	@Override
	public <R> SuperStream<R> flatMap(
		Function<? super T, ? extends Stream<? extends R>> mapper
	) {
		return new SuperStream<>(stream.flatMap(mapper));
	}

	/**
	 * 将流中的元素映射为 int 值。
	 *
	 * @param mapper 映射函数
	 * @return IntStream 实例
	 */
	@Override
	public IntStream mapToInt(ToIntFunction<? super T> mapper) {
		return stream.mapToInt(mapper);
	}

	/**
	 * 将流中的元素映射为 long 值。
	 *
	 * @param mapper 映射函数
	 * @return LongStream 实例
	 */
	@Override
	public LongStream mapToLong(ToLongFunction<? super T> mapper) {
		return stream.mapToLong(mapper);
	}

	/**
	 * 将流中的元素映射为 double 值。
	 *
	 * @param mapper 映射函数
	 * @return DoubleStream 实例
	 */
	@Override
	public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
		return stream.mapToDouble(mapper);
	}

	/**
	 * 扁平化映射流中的元素为 IntStream。
	 *
	 * @param mapper 映射函数
	 * @return IntStream 实例
	 */
	@Override
	public IntStream flatMapToInt(
		Function<? super T, ? extends IntStream> mapper
	) {
		return stream.flatMapToInt(mapper);
	}

	/**
	 * 扁平化映射流中的元素为 LongStream。
	 *
	 * @param mapper 映射函数
	 * @return LongStream 实例
	 */
	@Override
	public LongStream flatMapToLong(
		Function<? super T, ? extends LongStream> mapper
	) {
		return stream.flatMapToLong(mapper);
	}

	/**
	 * 扁平化映射流中的元素为 DoubleStream。
	 *
	 * @param mapper 映射函数
	 * @return DoubleStream 实例
	 */
	@Override
	public DoubleStream flatMapToDouble(
		Function<? super T, ? extends DoubleStream> mapper
	) {
		return stream.flatMapToDouble(mapper);
	}

	/**
	 * 去除流中的重复元素。
	 *
	 * @return SuperStream 实例
	 */
	@Override
	public SuperStream<T> distinct() {
		return new SuperStream<>(stream.distinct());
	}

	/**
	 * 对流中的元素进行排序。
	 *
	 * @return SuperStream 实例
	 */
	@Override
	public SuperStream<T> sorted() {
		return new SuperStream<>(stream.sorted());
	}

	/**
	 * 使用指定的比较器对流中的元素进行排序。
	 *
	 * @param comparator 比较器
	 * @return SuperStream 实例
	 */
	@Override
	public SuperStream<T> sorted(Comparator<? super T> comparator) {
		return new SuperStream<>(stream.sorted(comparator));
	}

	/**
	 * 对流中的每个元素执行操作。
	 *
	 * @param action 操作函数
	 * @return SuperStream 实例
	 */
	@Override
	public SuperStream<T> peek(Consumer<? super T> action) {
		return new SuperStream<>(stream.peek(action));
	}

	/**
	 * 限制流中的元素数量。
	 *
	 * @param maxSize 最大元素数量
	 * @return SuperStream 实例
	 */
	@Override
	public SuperStream<T> limit(long maxSize) {
		return new SuperStream<>(stream.limit(maxSize));
	}

	/**
	 * 跳过流中的前 n 个元素。
	 *
	 * @param n 跳过的元素数量
	 * @return SuperStream 实例
	 */
	@Override
	public SuperStream<T> skip(long n) {
		return new SuperStream<>(stream.skip(n));
	}

	/**
	 * 对流中的每个元素执行操作。
	 *
	 * @param action 操作函数
	 */
	@Override
	public void forEach(Consumer<? super T> action) {
		stream.forEach(action);
	}

	/**
	 * 对流中的每个元素按顺序执行操作。
	 *
	 * @param action 操作函数
	 */
	@Override
	public void forEachOrdered(Consumer<? super T> action) {
		stream.forEachOrdered(action);
	}

	/**
	 * 将流中的元素转换为数组。
	 *
	 * @return 包含流中所有元素的数组
	 */
	@Override
	public @NotNull Object@NotNull [] toArray() {
		return stream.toArray();
	}

	/**
	 * 将流中的元素转换为指定类型的数组。
	 *
	 * @param generator 数组生成器
	 * @param <A>       数组元素类型
	 * @return 包含流中所有元素的数组
	 */
	@Override
	public @NotNull <A> A@NotNull [] toArray(IntFunction<A[]> generator) {
		return stream.toArray(generator);
	}

	/**
	 * 使用指定的初始值和累加器对流中的元素进行归约。
	 *
	 * @param identity    初始值
	 * @param accumulator 累加器
	 * @return 归约结果
	 */
	@Override
	public T reduce(T identity, BinaryOperator<T> accumulator) {
		return stream.reduce(identity, accumulator);
	}

	/**
	 * 使用指定的累加器对流中的元素进行归约。
	 *
	 * @param accumulator 累加器
	 * @return 归约结果
	 */
	@Override
	public @NotNull Optional<T> reduce(BinaryOperator<T> accumulator) {
		return stream.reduce(accumulator);
	}

	/**
	 * 使用指定的初始值、累加器和组合器对流中的元素进行归约。
	 *
	 * @param identity    初始值
	 * @param accumulator 累加器
	 * @param combiner    组合器
	 * @param <U>         归约结果类型
	 * @return 归约结果
	 */
	@Override
	public <U> U reduce(
		U identity,
		BiFunction<U, ? super T, U> accumulator,
		BinaryOperator<U> combiner
	) {
		return stream.reduce(identity, accumulator, combiner);
	}

	/**
	 * 使用指定的供应商、累加器和组合器对流中的元素进行收集。
	 *
	 * @param supplier    供应商
	 * @param accumulator 累加器
	 * @param combiner    组合器
	 * @param <R>         收集结果类型
	 * @return 收集结果
	 */
	@Override
	public <R> R collect(
		Supplier<R> supplier,
		BiConsumer<R, ? super T> accumulator,
		BiConsumer<R, R> combiner
	) {
		return stream.collect(supplier, accumulator, combiner);
	}

	/**
	 * 使用指定的收集器对流中的元素进行收集。
	 *
	 * @param collector 收集器
	 * @param <R>       收集结果类型
	 * @param <A>       收集器中间结果类型
	 * @return 收集结果
	 */
	@Override
	public <R, A> R collect(Collector<? super T, A, R> collector) {
		return stream.collect(collector);
	}

	/**
	 * 找出流中的最小元素。
	 *
	 * @param comparator 比较器
	 * @return 最小元素
	 */
	@Override
	public @NotNull Optional<T> min(Comparator<? super T> comparator) {
		return stream.min(comparator);
	}

	/**
	 * 找出流中的最大元素。
	 *
	 * @param comparator 比较器
	 * @return 最大元素
	 */
	@Override
	public @NotNull Optional<T> max(Comparator<? super T> comparator) {
		return stream.max(comparator);
	}

	/**
	 * 计算流中的元素数量。
	 *
	 * @return 元素数量
	 */
	@Override
	public long count() {
		return stream.count();
	}

	/**
	 * 判断流中是否有任意元素满足谓词。
	 *
	 * @param predicate 谓词函数
	 * @return 是否满足
	 */
	@Override
	public boolean anyMatch(Predicate<? super T> predicate) {
		return stream.anyMatch(predicate);
	}

	/**
	 * 判断流中是否所有元素都满足谓词。
	 *
	 * @param predicate 谓词函数
	 * @return 是否满足
	 */
	@Override
	public boolean allMatch(Predicate<? super T> predicate) {
		return stream.allMatch(predicate);
	}

	/**
	 * 判断流中是否没有元素满足谓词。
	 *
	 * @param predicate 谓词函数
	 * @return 是否满足
	 */
	@Override
	public boolean noneMatch(Predicate<? super T> predicate) {
		return stream.noneMatch(predicate);
	}

	/**
	 * 找出流中的第一个元素。
	 *
	 * @return 第一个元素
	 */
	@Override
	public @NotNull Optional<T> findFirst() {
		return stream.findFirst();
	}

	/**
	 * 找出流中的任意元素。
	 *
	 * @return 任意元素
	 */
	@Override
	public @NotNull Optional<T> findAny() {
		return stream.findAny();
	}

	/**
	 * 返回流的迭代器。
	 *
	 * @return 迭代器
	 */
	@Override
	public @NotNull Iterator<T> iterator() {
		return stream.iterator();
	}

	/**
	 * 返回流的 Spliterator。
	 *
	 * @return Spliterator
	 */
	@Override
	public @NotNull Spliterator<T> spliterator() {
		return stream.spliterator();
	}

	/**
	 * 判断流是否为并行流。
	 *
	 * @return 是否为并行流
	 */
	@Override
	public boolean isParallel() {
		return stream.isParallel();
	}

	/**
	 * 返回一个并行流。
	 *
	 * @return SuperStream 实例
	 */
	@Override
	public @NotNull SuperStream<T> parallel() {
		return new SuperStream<>(stream.parallel());
	}

	/**
	 * 返回一个无序流。
	 *
	 * @return SuperStream 实例
	 */
	@Override
	public @NotNull SuperStream<T> unordered() {
		return new SuperStream<>(stream.unordered());
	}

	/**
	 * 注册流关闭时的处理器。
	 *
	 * @param closeHandler 关闭处理器
	 * @return SuperStream 实例
	 */
	@Override
	public @NotNull SuperStream<T> onClose(@NotNull Runnable closeHandler) {
		return new SuperStream<>(stream.onClose(closeHandler));
	}

	/**
	 * 关闭流。
	 */
	@Override
	public void close() {
		stream.close();
	}

	public Optional<T> findLast() {
		if (isEmpty()) {
			return Optional.empty();
		}
		val l = Lists.toList(stream);
		return Optional.of(l.get(l.size() - 1));
	}

	public T getFirst() {
		return findFirst().orElse(null);
	}

	public T getLast() {
		return findLast().orElse(null);
	}

	public T getAny() {
		return findAny().orElse(null);
	}

	/**
	 * 内部静态类 Collectors，用于提供常用的收集器实现。
	 * 所有方法均是对 java.util.stream.Collectors 的封装或扩展。
	 */
	public static class Collectors {

		/**
		 * 返回一个收集器，用于将元素映射为 long 值并求和。
		 *
		 * @param mapper 映射函数，将元素转换为 long 值
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Long> summingLong(
			@NotNull ToLongFunction<? super T> mapper
		) {
			return java.util.stream.Collectors.summingLong(mapper);
		}

		/**
		 * 返回一个收集器，将元素收集到指定类型的集合中。
		 *
		 * @param collectionFactory 集合工厂，用于创建目标集合
		 * @param <T>               元素类型
		 * @param <C>               目标集合类型
		 * @return 收集器
		 */
		public static <T, C extends Collection<T>> Collector<
			T,
			?,
			C
		> toCollection(@NotNull Supplier<C> collectionFactory) {
			return java.util.stream.Collectors.toCollection(collectionFactory);
		}

		/**
		 * 返回一个收集器，将元素收集到 List 中。
		 *
		 * @param <T> 元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull List<T>> toList() {
			return java.util.stream.Collectors.toList();
		}

		/**
		 * 返回一个收集器，将元素收集到 Set 中。
		 *
		 * @param <T> 元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Set<T>> toSet() {
			return java.util.stream.Collectors.toSet();
		}

		/**
		 * 返回一个收集器，将字符序列连接成字符串。
		 *
		 * @return 收集器
		 */
		public static Collector<CharSequence, ?, @NotNull String> joining() {
			return java.util.stream.Collectors.joining();
		}

		/**
		 * 返回一个收集器，将字符序列使用指定分隔符连接成字符串。
		 *
		 * @param delimiter 分隔符
		 * @return 收集器
		 */
		public static Collector<CharSequence, ?, @NotNull String> joining(
			@NotNull CharSequence delimiter
		) {
			return java.util.stream.Collectors.joining(delimiter);
		}

		/**
		 * 返回一个收集器，将字符序列使用指定前缀、后缀和分隔符连接成字符串。
		 *
		 * @param delimiter 分隔符
		 * @param prefix    前缀
		 * @param suffix    后缀
		 * @return 收集器
		 */
		public static Collector<CharSequence, ?, @NotNull String> joining(
			@NotNull CharSequence delimiter,
			@NotNull CharSequence prefix,
			@NotNull CharSequence suffix
		) {
			return java.util.stream.Collectors.joining(
				delimiter,
				prefix,
				suffix
			);
		}

		/**
		 * 返回一个收集器，先对元素进行映射，再使用下游收集器进行收集。
		 *
		 * @param mapper     映射函数
		 * @param downstream 下游收集器
		 * @param <T>        输入元素类型
		 * @param <U>        映射后的元素类型
		 * @param <A>        下游收集器的中间结果类型
		 * @param <R>        最终结果类型
		 * @return 收集器
		 */
		public static <T, U, A, R> Collector<T, ?, R> mapping(
			@NotNull Function<? super T, ? extends U> mapper,
			@NotNull Collector<? super U, A, R> downstream
		) {
			return java.util.stream.Collectors.mapping(mapper, downstream);
		}

		/**
		 * 返回一个收集器，在下游收集完成后应用 finisher 函数。
		 *
		 * @param downstream 下游收集器
		 * @param finisher   完成后应用的函数
		 * @param <T>        元素类型
		 * @param <A>        下游收集器的中间结果类型
		 * @param <R>        下游收集器的结果类型
		 * @param <RR>       最终结果类型
		 * @return 收集器
		 */
		public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(
			@NotNull Collector<T, A, R> downstream,
			@NotNull Function<R, RR> finisher
		) {
			return java.util.stream.Collectors.collectingAndThen(
				downstream,
				finisher
			);
		}

		/**
		 * 返回一个收集器，用于统计元素数量。
		 *
		 * @param <T> 元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Long> counting() {
			return java.util.stream.Collectors.counting();
		}

		/**
		 * 返回一个收集器，找出最小元素。
		 *
		 * @param comparator 比较器
		 * @param <T>        元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Optional<T>> minBy(
			@NotNull Comparator<? super T> comparator
		) {
			return java.util.stream.Collectors.minBy(comparator);
		}

		/**
		 * 返回一个收集器，找出最大元素。
		 *
		 * @param comparator 比较器
		 * @param <T>        元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Optional<T>> maxBy(
			@NotNull Comparator<? super T> comparator
		) {
			return java.util.stream.Collectors.maxBy(comparator);
		}

		/**
		 * 返回一个收集器，将元素映射为 int 值并求和。
		 *
		 * @param mapper 映射函数
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Integer> summingInt(
			@NotNull ToIntFunction<? super T> mapper
		) {
			return java.util.stream.Collectors.summingInt(mapper);
		}

		/**
		 * 返回一个收集器，将元素映射为 double 值并求和。
		 *
		 * @param mapper 映射函数
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Double> summingDouble(
			@NotNull ToDoubleFunction<? super T> mapper
		) {
			return java.util.stream.Collectors.summingDouble(mapper);
		}

		/**
		 * 返回一个收集器，计算元素映射为 int 值的平均值。
		 *
		 * @param mapper 映射函数
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Double> averagingInt(
			@NotNull ToIntFunction<? super T> mapper
		) {
			return java.util.stream.Collectors.averagingInt(mapper);
		}

		/**
		 * 返回一个收集器，计算元素映射为 long 值的平均值。
		 *
		 * @param mapper 映射函数
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Double> averagingLong(
			@NotNull ToLongFunction<? super T> mapper
		) {
			return java.util.stream.Collectors.averagingLong(mapper);
		}

		/**
		 * 返回一个收集器，计算元素映射为 double 值的平均值。
		 *
		 * @param mapper 映射函数
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Double> averagingDouble(
			@NotNull ToDoubleFunction<? super T> mapper
		) {
			return java.util.stream.Collectors.averagingDouble(mapper);
		}

		/**
		 * 返回一个收集器，使用指定的初始值和二元操作符进行归约。
		 *
		 * @param identity 初始值
		 * @param op       二元操作符
		 * @param <T>      元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, T> reducing(
			T identity,
			@NotNull BinaryOperator<T> op
		) {
			return java.util.stream.Collectors.reducing(identity, op);
		}

		/**
		 * 返回一个收集器，使用指定的二元操作符进行归约。
		 *
		 * @param op  二元操作符
		 * @param <T> 元素类型
		 * @return 收集器
		 */
		public static <T> Collector<T, ?, @NotNull Optional<T>> reducing(
			@NotNull BinaryOperator<T> op
		) {
			return java.util.stream.Collectors.reducing(op);
		}

		/**
		 * 返回一个收集器，先对元素进行映射，再使用指定的初始值和二元操作符进行归约。
		 *
		 * @param identity 初始值
		 * @param mapper   映射函数
		 * @param op       二元操作符
		 * @param <T>      元素类型
		 * @param <U>      映射后的元素类型
		 * @return 收集器
		 */
		public static <T, U> Collector<T, ?, U> reducing(
			U identity,
			@NotNull Function<? super T, ? extends U> mapper,
			@NotNull BinaryOperator<U> op
		) {
			return java.util.stream.Collectors.reducing(identity, mapper, op);
		}

		/**
		 * 返回一个收集器，按分类器对元素进行分组。
		 *
		 * @param classifier 分类器函数
		 * @param <T>        元素类型
		 * @param <K>        分类键类型
		 * @return 收集器
		 */
		public static <T, K> Collector<
			T,
			?,
			@NotNull Map<K, @NotNull List<T>>
		> groupingBy(@NotNull Function<? super T, ? extends K> classifier) {
			return java.util.stream.Collectors.groupingBy(classifier);
		}

		/**
		 * 返回一个收集器，按分类器对元素进行分组，并使用下游收集器处理每个组。
		 *
		 * @param classifier 分类器函数
		 * @param downstream 下游收集器
		 * @param <T>        元素类型
		 * @param <K>        分类键类型
		 * @param <A>        下游收集器的中间结果类型
		 * @param <D>        下游收集器的结果类型
		 * @return 收集器
		 */
		public static <T, K, A, D> Collector<
			T,
			?,
			@NotNull Map<K, D>
		> groupingBy(
			@NotNull Function<? super T, ? extends K> classifier,
			@NotNull Collector<? super T, A, D> downstream
		) {
			return java.util.stream.Collectors.groupingBy(
				classifier,
				downstream
			);
		}

		/**
		 * 返回一个收集器，按分类器对元素进行分组，并使用指定的 Map 工厂和下游收集器。
		 *
		 * @param classifier 分类器函数
		 * @param mapFactory Map 工厂
		 * @param downstream 下游收集器
		 * @param <T>        元素类型
		 * @param <K>        分类键类型
		 * @param <D>        下游收集器的结果类型
		 * @param <A>        下游收集器的中间结果类型
		 * @param <M>        Map 类型
		 * @return 收集器
		 */
		public static <T, K, D, A, M extends Map<K, D>> Collector<
			T,
			?,
			M
		> groupingBy(
			@NotNull Function<? super T, ? extends K> classifier,
			@NotNull Supplier<M> mapFactory,
			@NotNull Collector<? super T, A, D> downstream
		) {
			return java.util.stream.Collectors.groupingBy(
				classifier,
				mapFactory,
				downstream
			);
		}

		/**
		 * 返回一个并发收集器，按分类器对元素进行分组。
		 *
		 * @param classifier 分类器函数
		 * @param <T>        元素类型
		 * @param <K>        分类键类型
		 * @return 收集器
		 */
		public static <T, K> Collector<
			T,
			?,
			@NotNull ConcurrentMap<K, @NotNull List<T>>
		> groupingByConcurrent(
			@NotNull Function<? super T, ? extends K> classifier
		) {
			return java.util.stream.Collectors.groupingByConcurrent(classifier);
		}

		/**
		 * 返回一个并发收集器，按分类器对元素进行分组，并使用下游收集器处理每个组。
		 *
		 * @param classifier 分类器函数
		 * @param downstream 下游收集器
		 * @param <T>        元素类型
		 * @param <K>        分类键类型
		 * @param <A>        下游收集器的中间结果类型
		 * @param <D>        下游收集器的结果类型
		 * @return 收集器
		 */
		public static <T, K, A, D> Collector<
			T,
			?,
			@NotNull ConcurrentMap<K, D>
		> groupingByConcurrent(
			@NotNull Function<? super T, ? extends K> classifier,
			@NotNull Collector<? super T, A, D> downstream
		) {
			return java.util.stream.Collectors.groupingByConcurrent(
				classifier,
				downstream
			);
		}

		/**
		 * 返回一个并发收集器，按分类器对元素进行分组，并使用指定的 Map 工厂和下游收集器。
		 *
		 * @param classifier 分类器函数
		 * @param mapFactory Map 工厂
		 * @param downstream 下游收集器
		 * @param <T>        元素类型
		 * @param <K>        分类键类型
		 * @param <D>        下游收集器的结果类型
		 * @param <A>        下游收集器的中间结果类型
		 * @param <M>        Map 类型
		 * @return 收集器
		 */
		public static <T, K, A, D, M extends ConcurrentMap<K, D>> Collector<
			T,
			?,
			M
		> groupingByConcurrent(
			@NotNull Function<? super T, ? extends K> classifier,
			@NotNull Supplier<M> mapFactory,
			@NotNull Collector<? super T, A, D> downstream
		) {
			return java.util.stream.Collectors.groupingByConcurrent(
				classifier,
				mapFactory,
				downstream
			);
		}

		/**
		 * 返回一个收集器，按谓词对元素进行分区。
		 *
		 * @param predicate 谓词函数
		 * @param <T>       元素类型
		 * @return 收集器
		 */
		public static <T> Collector<
			T,
			?,
			@NotNull Map<@NotNull Boolean, @NotNull List<T>>
		> partitioningBy(@NotNull Predicate<? super T> predicate) {
			return java.util.stream.Collectors.partitioningBy(predicate);
		}

		/**
		 * 返回一个收集器，按谓词对元素进行分区，并使用下游收集器处理每个分区。
		 *
		 * @param predicate  谓词函数
		 * @param downstream 下游收集器
		 * @param <T>        元素类型
		 * @param <D>        下游收集器的结果类型
		 * @param <A>        下游收集器的中间结果类型
		 * @return 收集器
		 */
		public static <T, D, A> Collector<
			T,
			?,
			@NotNull Map<@NotNull Boolean, D>
		> partitioningBy(
			@NotNull Predicate<? super T> predicate,
			@NotNull Collector<? super T, A, D> downstream
		) {
			return java.util.stream.Collectors.partitioningBy(
				predicate,
				downstream
			);
		}

		/**
		 * 返回一个收集器，将元素转换为 Map。
		 *
		 * @param keyMapper   键映射函数
		 * @param valueMapper 值映射函数
		 * @param <T>         元素类型
		 * @param <K>         键类型
		 * @param <U>         值类型
		 * @return 收集器
		 */
		public static <T, K, U> Collector<
			T,
			?,
			@NotNull Map<K, @NotNull U>
		> toMap(
			@NotNull Function<? super T, ? extends K> keyMapper,
			@NotNull Function<? super T, ? extends U> valueMapper
		) {
			return java.util.stream.Collectors.toMap(keyMapper, valueMapper);
		}

		/**
		 * 返回一个收集器，将元素转换为 Map，并指定合并函数。
		 *
		 * @param keyMapper     键映射函数
		 * @param valueMapper   值映射函数
		 * @param mergeFunction 合并函数
		 * @param <T>           元素类型
		 * @param <K>           键类型
		 * @param <U>           值类型
		 * @return 收集器
		 */
		public static <T, K, U> Collector<
			T,
			?,
			@NotNull Map<K, @NotNull U>
		> toMap(
			@NotNull Function<? super T, ? extends K> keyMapper,
			@NotNull Function<? super T, ? extends U> valueMapper,
			@NotNull BinaryOperator<U> mergeFunction
		) {
			return java.util.stream.Collectors.toMap(
				keyMapper,
				valueMapper,
				mergeFunction
			);
		}

		/**
		 * 返回一个收集器，将元素转换为 Map，并指定合并函数和 Map 工厂。
		 *
		 * @param keyMapper     键映射函数
		 * @param valueMapper   值映射函数
		 * @param mergeFunction 合并函数
		 * @param mapSupplier   Map 工厂
		 * @param <T>           元素类型
		 * @param <K>           键类型
		 * @param <U>           值类型
		 * @param <M>           Map 类型
		 * @return 收集器
		 */
		public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(
			@NotNull Function<? super T, ? extends K> keyMapper,
			@NotNull Function<? super T, ? extends U> valueMapper,
			@NotNull BinaryOperator<U> mergeFunction,
			@NotNull Supplier<M> mapSupplier
		) {
			return java.util.stream.Collectors.toMap(
				keyMapper,
				valueMapper,
				mergeFunction,
				mapSupplier
			);
		}

		/**
		 * 返回一个并发收集器，将元素转换为 ConcurrentMap。
		 *
		 * @param keyMapper   键映射函数
		 * @param valueMapper 值映射函数
		 * @param <T>         元素类型
		 * @param <K>         键类型
		 * @param <U>         值类型
		 * @return 收集器
		 */
		public static <T, K, U> Collector<
			T,
			?,
			@NotNull ConcurrentMap<K, U>
		> toConcurrentMap(
			@NotNull Function<? super T, ? extends K> keyMapper,
			@NotNull Function<? super T, ? extends U> valueMapper
		) {
			return java.util.stream.Collectors.toConcurrentMap(
				keyMapper,
				valueMapper
			);
		}

		/**
		 * 返回一个并发收集器，将元素转换为 ConcurrentMap，并指定合并函数。
		 *
		 * @param keyMapper     键映射函数
		 * @param valueMapper   值映射函数
		 * @param mergeFunction 合并函数
		 * @param <T>           元素类型
		 * @param <K>           键类型
		 * @param <U>           值类型
		 * @return 收集器
		 */
		public static <T, K, U> Collector<
			T,
			?,
			@NotNull ConcurrentMap<K, U>
		> toConcurrentMap(
			@NotNull Function<? super T, ? extends K> keyMapper,
			@NotNull Function<? super T, ? extends U> valueMapper,
			@NotNull BinaryOperator<U> mergeFunction
		) {
			return java.util.stream.Collectors.toConcurrentMap(
				keyMapper,
				valueMapper,
				mergeFunction
			);
		}

		/**
		 * 返回一个并发收集器，将元素转换为 ConcurrentMap，并指定合并函数和 Map 工厂。
		 *
		 * @param keyMapper     键映射函数
		 * @param valueMapper   值映射函数
		 * @param mergeFunction 合并函数
		 * @param mapSupplier   Map 工厂
		 * @param <T>           元素类型
		 * @param <K>           键类型
		 * @param <U>           值类型
		 * @param <M>           Map 类型
		 * @return 收集器
		 */
		public static <T, K, U, M extends ConcurrentMap<K, U>> Collector<
			T,
			?,
			M
		> toConcurrentMap(
			@NotNull Function<? super T, ? extends K> keyMapper,
			@NotNull Function<? super T, ? extends U> valueMapper,
			@NotNull BinaryOperator<U> mergeFunction,
			@NotNull Supplier<M> mapSupplier
		) {
			return java.util.stream.Collectors.toConcurrentMap(
				keyMapper,
				valueMapper,
				mergeFunction,
				mapSupplier
			);
		}

		/**
		 * 返回一个收集器，计算元素映射为 int 值的统计信息。
		 *
		 * @param mapper 映射函数
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<
			T,
			?,
			@NotNull IntSummaryStatistics
		> summarizingInt(@NotNull ToIntFunction<? super T> mapper) {
			return java.util.stream.Collectors.summarizingInt(mapper);
		}

		/**
		 * 返回一个收集器，计算元素映射为 long 值的统计信息。
		 *
		 * @param mapper 映射函数
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<
			T,
			?,
			@NotNull LongSummaryStatistics
		> summarizingLong(@NotNull ToLongFunction<? super T> mapper) {
			return java.util.stream.Collectors.summarizingLong(mapper);
		}

		/**
		 * 返回一个收集器，计算元素映射为 double 值的统计信息。
		 *
		 * @param mapper 映射函数
		 * @param <T>    元素类型
		 * @return 收集器
		 */
		public static <T> Collector<
			T,
			?,
			@NotNull DoubleSummaryStatistics
		> summarizingDouble(@NotNull ToDoubleFunction<? super T> mapper) {
			return java.util.stream.Collectors.summarizingDouble(mapper);
		}

		/**
		 * 返回当前元素本身。
		 *
		 * @param t   元素
		 * @param <T> 元素类型
		 * @return 元素本身
		 */
		public static <T> T getThis(T t) {
			return t;
		}

		/**
		 * 返回一个收集器，将元素收集到 List 中。
		 *
		 * @param <T> 元素类型
		 * @param <K> Map.Key
		 * @param <V> Map.Value
		 * @return 收集器
		 */
		public static <T extends Map.Entry<K, V>, K, V> Collector<
			T,
			?,
			@NotNull Map<K, V>
		> toEntryMap() {
			return toMap(Map.Entry::getKey, Map.Entry::getValue);
		}

		public static <T extends Getable<K>, K> Collector<
			T,
			?,
			@NotNull Map<K, T>
		> toMap() {
			return toMap(Getable::get, Collectors::getThis);
		}

		/**
		 * 返回一个收集器，将元素转换为 Map，键由 keyMapper 生成，值为元素本身。
		 *
		 * @param keyMapper 键映射函数
		 * @param <T>       元素类型
		 * @param <K>       键类型
		 * @return 收集器
		 */
		public static <T, K> Collector<T, ?, @NotNull Map<K, @NotNull T>> toMap(
			@NotNull Function<? super T, ? extends K> keyMapper
		) {
			return Collectors.toMap(keyMapper, Collectors::getThis);
		}
	}
}
