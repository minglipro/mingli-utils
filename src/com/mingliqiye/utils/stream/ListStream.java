package com.mingliqiye.utils.stream;

import com.mingliqiye.utils.collection.ForEach;
import com.mingliqiye.utils.collection.Lists;
import com.mingliqiye.utils.random.RandomInt;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.*;
import java.util.stream.*;
import org.jetbrains.annotations.NotNull;

/**
 * 自定义的 ListStream 实现类，用于对集合进行流式操作。
 * 该类实现了 Java 标准库中的 ListStream 接口，并基于 List 数据结构提供了一系列流式处理方法。
 *
 * @author MingLiPro
 * @param <T> 流中元素的类型
 */
public class ListStream<T> implements java.util.stream.Stream<T> {

	private final List<T> list;

	/**
	 * 构造方法，初始化 ListStream 实例。
	 *
	 * @param list 用于构造 ListStream 的列表数据，如果为 null 则使用空列表
	 */
	private ListStream(List<T> list) {
		this.list = list != null ? list : Lists.newArrayList();
	}

	/**
	 * 创建一个收集器，将元素收集到指定类型的集合中。
	 *
	 * @param collectionFactory 用于创建目标集合的工厂函数
	 * @param <T> 元素类型
	 * @param <C> 目标集合类型
	 * @return 收集器实例
	 */
	public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(
		@NotNull Supplier<C> collectionFactory
	) {
		return Collectors.toCollection(collectionFactory);
	}

	/**
	 * 创建一个收集器，将元素收集到 List 中。
	 *
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull List<T>> toList() {
		return Collectors.toList();
	}

	/**
	 * 创建一个收集器，将元素收集到 Set 中。
	 *
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Set<T>> toSet() {
		return Collectors.toSet();
	}

	/**
	 * 创建一个收集器，将字符序列连接为字符串。
	 *
	 * @return 收集器实例
	 */
	public static Collector<CharSequence, ?, @NotNull String> joining() {
		return Collectors.joining();
	}

	/**
	 * 创建一个收集器，将字符序列使用指定分隔符连接为字符串。
	 *
	 * @param delimiter 分隔符
	 * @return 收集器实例
	 */
	public static Collector<CharSequence, ?, @NotNull String> joining(
		@NotNull CharSequence delimiter
	) {
		return Collectors.joining(delimiter);
	}

	/**
	 * 创建一个收集器，将字符序列使用指定分隔符、前缀和后缀连接为字符串。
	 *
	 * @param delimiter 分隔符
	 * @param prefix 前缀
	 * @param suffix 后缀
	 * @return 收集器实例
	 */
	public static Collector<CharSequence, ?, @NotNull String> joining(
		@NotNull CharSequence delimiter,
		@NotNull CharSequence prefix,
		@NotNull CharSequence suffix
	) {
		return Collectors.joining(delimiter, prefix, suffix);
	}

	/**
	 * 创建一个收集器，先对元素进行映射，再使用下游收集器收集。
	 *
	 * @param mapper 映射函数
	 * @param downstream 下游收集器
	 * @param <T> 输入元素类型
	 * @param <U> 映射后元素类型
	 * @param <A> 下游收集器中间类型
	 * @param <R> 结果类型
	 * @return 收集器实例
	 */
	public static <T, U, A, R> Collector<T, ?, R> mapping(
		@NotNull Function<? super T, ? extends U> mapper,
		@NotNull Collector<? super U, A, R> downstream
	) {
		return Collectors.mapping(mapper, downstream);
	}

	/**
	 * 创建一个收集器，在下游收集完成后应用 finisher 函数。
	 *
	 * @param downstream 下游收集器
	 * @param finisher 完成后应用的函数
	 * @param <T> 输入元素类型
	 * @param <A> 下游收集器中间类型
	 * @param <R> 下游收集器结果类型
	 * @param <RR> 最终结果类型
	 * @return 收集器实例
	 */
	public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(
		@NotNull Collector<T, A, R> downstream,
		@NotNull Function<R, RR> finisher
	) {
		return Collectors.collectingAndThen(downstream, finisher);
	}

	/**
	 * 创建一个收集器，统计元素数量。
	 *
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Long> counting() {
		return Collectors.counting();
	}

	/**
	 * 创建一个收集器，找出最小元素。
	 *
	 * @param comparator 比较器
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Optional<T>> minBy(
		@NotNull Comparator<? super T> comparator
	) {
		return Collectors.minBy(comparator);
	}

	/**
	 * 创建一个收集器，找出最大元素。
	 *
	 * @param comparator 比较器
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Optional<T>> maxBy(
		@NotNull Comparator<? super T> comparator
	) {
		return Collectors.maxBy(comparator);
	}

	/**
	 * 创建一个收集器，对元素映射为 int 后求和。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Integer> summingInt(
		@NotNull ToIntFunction<? super T> mapper
	) {
		return Collectors.summingInt(mapper);
	}

	/**
	 * 创建一个收集器，对元素映射为 long 后求和。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Long> summingLong(
		@NotNull ToLongFunction<? super T> mapper
	) {
		return Collectors.summingLong(mapper);
	}

	/**
	 * 创建一个收集器，对元素映射为 double 后求和。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Double> summingDouble(
		@NotNull ToDoubleFunction<? super T> mapper
	) {
		return Collectors.summingDouble(mapper);
	}

	/**
	 * 创建一个收集器，对元素映射为 int 后计算平均值。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Double> averagingInt(
		@NotNull ToIntFunction<? super T> mapper
	) {
		return Collectors.averagingInt(mapper);
	}

	/**
	 * 创建一个收集器，对元素映射为 long 后计算平均值。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Double> averagingLong(
		@NotNull ToLongFunction<? super T> mapper
	) {
		return Collectors.averagingLong(mapper);
	}

	/**
	 * 创建一个收集器，对元素映射为 double 后计算平均值。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Double> averagingDouble(
		@NotNull ToDoubleFunction<? super T> mapper
	) {
		return Collectors.averagingDouble(mapper);
	}

	/**
	 * 创建一个收集器，使用指定初始值和操作符对元素进行归约。
	 *
	 * @param identity 初始值
	 * @param op 操作符
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, T> reducing(
		T identity,
		@NotNull BinaryOperator<T> op
	) {
		return Collectors.reducing(identity, op);
	}

	/**
	 * 创建一个收集器，使用指定操作符对元素进行归约。
	 *
	 * @param op 操作符
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<T, ?, @NotNull Optional<T>> reducing(
		@NotNull BinaryOperator<T> op
	) {
		return Collectors.reducing(op);
	}

	/**
	 * 创建一个收集器，先对元素进行映射，再使用指定初始值和操作符进行归约。
	 *
	 * @param identity 初始值
	 * @param mapper 映射函数
	 * @param op 操作符
	 * @param <T> 输入元素类型
	 * @param <U> 映射后元素类型
	 * @return 收集器实例
	 */
	public static <T, U> Collector<T, ?, U> reducing(
		U identity,
		@NotNull Function<? super T, ? extends U> mapper,
		@NotNull BinaryOperator<U> op
	) {
		return Collectors.reducing(identity, mapper, op);
	}

	/**
	 * 创建一个收集器，根据分类器对元素进行分组。
	 *
	 * @param classifier 分类器函数
	 * @param <T> 元素类型
	 * @param <K> 分类键类型
	 * @return 收集器实例
	 */
	public static <T, K> Collector<
		T,
		?,
		@NotNull Map<K, @NotNull List<T>>
	> groupingBy(@NotNull Function<? super T, ? extends K> classifier) {
		return Collectors.groupingBy(classifier);
	}

	/**
	 * 创建一个收集器，根据分类器对元素进行分组，并使用下游收集器处理每组元素。
	 *
	 * @param classifier 分类器函数
	 * @param downstream 下游收集器
	 * @param <T> 元素类型
	 * @param <K> 分类键类型
	 * @param <A> 下游收集器中间类型
	 * @param <D> 下游收集器结果类型
	 * @return 收集器实例
	 */
	public static <T, K, A, D> Collector<T, ?, @NotNull Map<K, D>> groupingBy(
		@NotNull Function<? super T, ? extends K> classifier,
		@NotNull Collector<? super T, A, D> downstream
	) {
		return Collectors.groupingBy(classifier, downstream);
	}

	/**
	 * 创建一个收集器，根据分类器对元素进行分组，使用指定的 Map 工厂和下游收集器。
	 *
	 * @param classifier 分类器函数
	 * @param mapFactory Map 工厂函数
	 * @param downstream 下游收集器
	 * @param <T> 元素类型
	 * @param <K> 分类键类型
	 * @param <D> 下游收集器结果类型
	 * @param <A> 下游收集器中间类型
	 * @param <M> 目标 Map 类型
	 * @return 收集器实例
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
		return Collectors.groupingBy(classifier, mapFactory, downstream);
	}

	/**
	 * 创建一个并发收集器，根据分类器对元素进行分组。
	 *
	 * @param classifier 分类器函数
	 * @param <T> 元素类型
	 * @param <K> 分类键类型
	 * @return 收集器实例
	 */
	public static <T, K> Collector<
		T,
		?,
		@NotNull ConcurrentMap<K, @NotNull List<T>>
	> groupingByConcurrent(
		@NotNull Function<? super T, ? extends K> classifier
	) {
		return Collectors.groupingByConcurrent(classifier);
	}

	/**
	 * 创建一个并发收集器，根据分类器对元素进行分组，并使用下游收集器处理每组元素。
	 *
	 * @param classifier 分类器函数
	 * @param downstream 下游收集器
	 * @param <T> 元素类型
	 * @param <K> 分类键类型
	 * @param <A> 下游收集器中间类型
	 * @param <D> 下游收集器结果类型
	 * @return 收集器实例
	 */
	public static <T, K, A, D> Collector<
		T,
		?,
		@NotNull ConcurrentMap<K, D>
	> groupingByConcurrent(
		@NotNull Function<? super T, ? extends K> classifier,
		@NotNull Collector<? super T, A, D> downstream
	) {
		return Collectors.groupingByConcurrent(classifier, downstream);
	}

	/**
	 * 创建一个并发收集器，根据分类器对元素进行分组，使用指定的 Map 工厂和下游收集器。
	 *
	 * @param classifier 分类器函数
	 * @param mapFactory Map 工厂函数
	 * @param downstream 下游收集器
	 * @param <T> 元素类型
	 * @param <K> 分类键类型
	 * @param <D> 下游收集器结果类型
	 * @param <A> 下游收集器中间类型
	 * @param <M> 目标 Map 类型
	 * @return 收集器实例
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
		return Collectors.groupingByConcurrent(
			classifier,
			mapFactory,
			downstream
		);
	}

	/**
	 * 创建一个收集器，根据谓词条件对元素进行分区。
	 *
	 * @param predicate 谓词函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<
		T,
		?,
		@NotNull Map<@NotNull Boolean, @NotNull List<T>>
	> partitioningBy(@NotNull Predicate<? super T> predicate) {
		return Collectors.partitioningBy(predicate);
	}

	/**
	 * 创建一个收集器，根据谓词条件对元素进行分区，并使用下游收集器处理每组元素。
	 *
	 * @param predicate 谓词函数
	 * @param downstream 下游收集器
	 * @param <T> 元素类型
	 * @param <D> 下游收集器结果类型
	 * @param <A> 下游收集器中间类型
	 * @return 收集器实例
	 */
	public static <T, D, A> Collector<
		T,
		?,
		@NotNull Map<@NotNull Boolean, D>
	> partitioningBy(
		@NotNull Predicate<? super T> predicate,
		@NotNull Collector<? super T, A, D> downstream
	) {
		return Collectors.partitioningBy(predicate, downstream);
	}

	/**
	 * 创建一个收集器，将元素转换为 Map。
	 *
	 * @param keyMapper 键映射函数
	 * @param valueMapper 值映射函数
	 * @param <T> 元素类型
	 * @param <K> 键类型
	 * @param <U> 值类型
	 * @return 收集器实例
	 */
	public static <T, K, U> Collector<T, ?, @NotNull Map<K, @NotNull U>> toMap(
		@NotNull Function<? super T, ? extends K> keyMapper,
		@NotNull Function<? super T, ? extends U> valueMapper
	) {
		return Collectors.toMap(keyMapper, valueMapper);
	}

	/**
	 * 创建一个收集器，将元素转换为 Map，并指定键冲突时的合并函数。
	 *
	 * @param keyMapper 键映射函数
	 * @param valueMapper 值映射函数
	 * @param mergeFunction 键冲突合并函数
	 * @param <T> 元素类型
	 * @param <K> 键类型
	 * @param <U> 值类型
	 * @return 收集器实例
	 */
	public static <T, K, U> Collector<T, ?, @NotNull Map<K, @NotNull U>> toMap(
		@NotNull Function<? super T, ? extends K> keyMapper,
		@NotNull Function<? super T, ? extends U> valueMapper,
		@NotNull BinaryOperator<U> mergeFunction
	) {
		return Collectors.toMap(keyMapper, valueMapper, mergeFunction);
	}

	/**
	 * 创建一个收集器，将元素转换为 Map，指定键冲突合并函数和 Map 工厂。
	 *
	 * @param keyMapper 键映射函数
	 * @param valueMapper 值映射函数
	 * @param mergeFunction 键冲突合并函数
	 * @param mapSupplier Map 工厂函数
	 * @param <T> 元素类型
	 * @param <K> 键类型
	 * @param <U> 值类型
	 * @param <M> 目标 Map 类型
	 * @return 收集器实例
	 */
	public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(
		@NotNull Function<? super T, ? extends K> keyMapper,
		@NotNull Function<? super T, ? extends U> valueMapper,
		@NotNull BinaryOperator<U> mergeFunction,
		@NotNull Supplier<M> mapSupplier
	) {
		return Collectors.toMap(
			keyMapper,
			valueMapper,
			mergeFunction,
			mapSupplier
		);
	}

	/**
	 * 创建一个并发收集器，将元素转换为 ConcurrentMap。
	 *
	 * @param keyMapper 键映射函数
	 * @param valueMapper 值映射函数
	 * @param <T> 元素类型
	 * @param <K> 键类型
	 * @param <U> 值类型
	 * @return 收集器实例
	 */
	public static <T, K, U> Collector<
		T,
		?,
		@NotNull ConcurrentMap<K, U>
	> toConcurrentMap(
		@NotNull Function<? super T, ? extends K> keyMapper,
		@NotNull Function<? super T, ? extends U> valueMapper
	) {
		return Collectors.toConcurrentMap(keyMapper, valueMapper);
	}

	/**
	 * 创建一个并发收集器，将元素转换为 ConcurrentMap，并指定键冲突时的合并函数。
	 *
	 * @param keyMapper 键映射函数
	 * @param valueMapper 值映射函数
	 * @param mergeFunction 键冲突合并函数
	 * @param <T> 元素类型
	 * @param <K> 键类型
	 * @param <U> 值类型
	 * @return 收集器实例
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
		return Collectors.toConcurrentMap(
			keyMapper,
			valueMapper,
			mergeFunction
		);
	}

	/**
	 * 创建一个并发收集器，将元素转换为 ConcurrentMap，指定键冲突合并函数和 Map 工厂。
	 *
	 * @param keyMapper 键映射函数
	 * @param valueMapper 值映射函数
	 * @param mergeFunction 键冲突合并函数
	 * @param mapSupplier Map 工厂函数
	 * @param <T> 元素类型
	 * @param <K> 键类型
	 * @param <U> 值类型
	 * @param <M> 目标 Map 类型
	 * @return 收集器实例
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
		return Collectors.toConcurrentMap(
			keyMapper,
			valueMapper,
			mergeFunction,
			mapSupplier
		);
	}

	/**
	 * 创建一个收集器，对元素映射为 int 后生成统计信息。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<
		T,
		?,
		@NotNull IntSummaryStatistics
	> summarizingInt(@NotNull ToIntFunction<? super T> mapper) {
		return Collectors.summarizingInt(mapper);
	}

	/**
	 * 创建一个收集器，对元素映射为 long 后生成统计信息。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<
		T,
		?,
		@NotNull LongSummaryStatistics
	> summarizingLong(@NotNull ToLongFunction<? super T> mapper) {
		return Collectors.summarizingLong(mapper);
	}

	/**
	 * 创建一个收集器，对元素映射为 double 后生成统计信息。
	 *
	 * @param mapper 映射函数
	 * @param <T> 元素类型
	 * @return 收集器实例
	 */
	public static <T> Collector<
		T,
		?,
		@NotNull DoubleSummaryStatistics
	> summarizingDouble(@NotNull ToDoubleFunction<? super T> mapper) {
		return Collectors.summarizingDouble(mapper);
	}

	/**
	 * 创建一个包含指定元素的 ListStream。
	 *
	 * @param ts 可变参数，表示要包含在 ListStream 中的元素
	 * @param <T> 元素类型
	 * @return 包含指定元素的新 ListStream 实例
	 */
	@SafeVarargs
	public static <T> ListStream<T> of(T... ts) {
		return new ListStream<>(Lists.newArrayList(ts));
	}

	/**
	 * 创建一个包含指定列表元素的 ListStream。
	 *
	 * @param ts 列表，表示要包含在 ListStream 中的元素
	 * @param <T> 元素类型
	 * @return 包含指定元素的新 ListStream 实例
	 */
	public static <T> ListStream<T> of(List<T> ts) {
		return new ListStream<>(Lists.newArrayList(ts));
	}

	/**
	 * 根据给定的谓词条件过滤流中的元素。
	 *
	 * @param predicate 用于测试元素是否应保留的谓词函数
	 * @return 包含满足条件元素的新 ListStream 实例
	 */
	@Override
	public ListStream<T> filter(Predicate<? super T> predicate) {
		List<T> result = Lists.newArrayList();
		for (T item : list) {
			if (predicate.test(item)) {
				result.add(item);
			}
		}
		return new ListStream<>(result);
	}

	/**
	 * 根据属性提取器和目标值过滤流中的元素。
	 *
	 * @param propertyExtractor 属性提取函数
	 * @param targetValue 目标值
	 * @return 包含满足条件元素的新 ListStream 实例
	 */
	public ListStream<T> filter(
		Function<T, Object> propertyExtractor,
		Object targetValue
	) {
		List<T> result = Lists.newArrayList();
		for (T item : list) {
			if (Objects.equals(propertyExtractor.apply(item), targetValue)) {
				result.add(item);
			}
		}
		return new ListStream<>(result);
	}

	/**
	 * 将流中的每个元素通过映射函数转换为另一种类型。
	 *
	 * @param mapper 映射函数，将元素从类型 T 转换为类型 R
	 * @param <R> 映射后元素的类型
	 * @return 包含转换后元素的新 ListStream 实例
	 */
	@Override
	public <R> ListStream<R> map(Function<? super T, ? extends R> mapper) {
		List<R> result = Lists.newArrayList();
		for (T item : list) {
			result.add(mapper.apply(item));
		}
		return new ListStream<>(result);
	}

	/**
	 * 将流中的元素转换为数组。
	 *
	 * @return 包含流中所有元素的数组
	 */
	public T[] array() {
		return (T[]) list.toArray();
	}

	/**
	 * 获取流中的元素列表。
	 *
	 * @return 包含流中所有元素的列表
	 */
	public List<T> list() {
		return list;
	}

	/**
	 * 将流中的每个元素通过映射函数转换为 int 类型。
	 *
	 * @param mapper 映射函数，将元素从类型 T 转换为 int
	 * @return 转换后的 IntStream 实例
	 */
	@Override
	public IntStream mapToInt(ToIntFunction<? super T> mapper) {
		return list.stream().mapToInt(mapper);
	}

	/**
	 * 将流中的每个元素通过映射函数转换为 long 类型。
	 *
	 * @param mapper 映射函数，将元素从类型 T 转换为 long
	 * @return 转换后的 LongStream 实例
	 */
	@Override
	public LongStream mapToLong(ToLongFunction<? super T> mapper) {
		return list.stream().mapToLong(mapper);
	}

	/**
	 * 将流中的每个元素通过映射函数转换为 double 类型。
	 *
	 * @param mapper 映射函数，将元素从类型 T 转换为 double
	 * @return 转换后的 DoubleStream 实例
	 */
	@Override
	public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
		return list.stream().mapToDouble(mapper);
	}

	/**
	 * 将流中的每个元素通过映射函数转换为另一个流，并将所有结果流合并为一个流。
	 *
	 * @param mapper 映射函数，将元素从类型 T 转换为另一个 ListStream
	 * @param <R> 映射后流中元素的类型
	 * @return 合并后的 ListStream 实例
	 */
	@Override
	public <R> ListStream<R> flatMap(
		Function<
			? super T,
			? extends java.util.stream.Stream<? extends R>
		> mapper
	) {
		List<R> result = Lists.newArrayList();
		for (T item : list) {
			java.util.stream.Stream<? extends R> stream = mapper.apply(item);
			if (stream != null) {
				stream.forEach(result::add);
			}
		}
		return new ListStream<>(result);
	}

	/**
	 * 将流中的每个元素通过映射函数转换为 IntStream，并将所有结果流合并为一个流。
	 *
	 * @param mapper 映射函数，将元素从类型 T 转换为 IntStream
	 * @return 合并后的 IntStream 实例
	 */
	@Override
	public IntStream flatMapToInt(
		Function<? super T, ? extends IntStream> mapper
	) {
		return list.stream().flatMapToInt(mapper);
	}

	/**
	 * 将流中的每个元素通过映射函数转换为 LongStream，并将所有结果流合并为一个流。
	 *
	 * @param mapper 映射函数，将元素从类型 T 转换为 LongStream
	 * @return 合并后的 LongStream 实例
	 */
	@Override
	public LongStream flatMapToLong(
		Function<? super T, ? extends LongStream> mapper
	) {
		return list.stream().flatMapToLong(mapper);
	}

	/**
	 * 将流中的每个元素通过映射函数转换为 DoubleStream，并将所有结果流合并为一个流。
	 *
	 * @param mapper 映射函数，将元素从类型 T 转换为 DoubleStream
	 * @return 合并后的 DoubleStream 实例
	 */
	@Override
	public DoubleStream flatMapToDouble(
		Function<? super T, ? extends DoubleStream> mapper
	) {
		return list.stream().flatMapToDouble(mapper);
	}

	/**
	 * 去除流中重复的元素，保持原有顺序。
	 *
	 * @return 包含去重后元素的新 ListStream 实例
	 */
	@Override
	public ListStream<T> distinct() {
		Set<T> seen = new LinkedHashSet<>(list);
		return new ListStream<>(new ArrayList<>(seen));
	}

	/**
	 * 对流中的元素进行自然排序。
	 *
	 * @return 排序后的新 ListStream 实例
	 */
	@Override
	public ListStream<T> sorted() {
		List<T> sortedList = Lists.newArrayList(list);
		Collections.sort((List<? extends Comparable>) sortedList);
		return new ListStream<>(sortedList);
	}

	/**
	 * 根据给定的比较器对流中的元素进行排序。
	 *
	 * @param comparator 用于比较元素的比较器
	 * @return 排序后的新 ListStream 实例
	 */
	@Override
	public ListStream<T> sorted(Comparator<? super T> comparator) {
		List<T> sortedList = Lists.newArrayList(list);
		sortedList.sort(comparator);
		return new ListStream<>(sortedList);
	}

	/**
	 * 对流中的每个元素执行指定的操作，但不改变流本身。
	 *
	 * @param action 要对每个元素执行的操作
	 * @return 当前 ListStream 实例
	 */
	@Override
	public ListStream<T> peek(Consumer<? super T> action) {
		for (T item : list) {
			action.accept(item);
		}
		return this;
	}

	/**
	 * 截取流中前 maxSize 个元素组成新的流。
	 *
	 * @param maxSize 要截取的最大元素数量
	 * @return 截取后的新 ListStream 实例
	 * @throws IllegalArgumentException 如果 maxSize 为负数
	 */
	@Override
	public ListStream<T> limit(long maxSize) {
		if (maxSize < 0) {
			throw new IllegalArgumentException("maxSize must be non-negative");
		}
		if (maxSize == 0) {
			return new ListStream<>(Lists.newArrayList());
		}

		List<T> limitedList = Lists.newArrayList();
		long count = 0;
		for (T item : list) {
			if (count >= maxSize) {
				break;
			}
			limitedList.add(item);
			count++;
		}
		return new ListStream<>(limitedList);
	}

	/**
	 * 跳过流中前 n 个元素，返回剩余元素组成的新流。
	 *
	 * @param n 要跳过的元素数量
	 * @return 跳过后的新 ListStream 实例
	 * @throws IllegalArgumentException 如果 n 为负数
	 */
	@Override
	public ListStream<T> skip(long n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must be non-negative");
		}
		if (n == 0) {
			return new ListStream<>(Lists.newArrayList(list));
		}

		List<T> skippedList = Lists.newArrayList();
		long count = 0;
		for (T item : list) {
			if (count >= n) {
				skippedList.add(item);
			}
			count++;
		}
		return new ListStream<>(skippedList);
	}

	/**
	 * 对流中的每个元素执行指定的操作。
	 *
	 * @param action 要对每个元素执行的操作
	 */
	@Override
	public void forEach(Consumer<? super T> action) {
		ForEach.forEach(list, action);
	}

	public void forEach(
		com.mingliqiye.utils.collection.ForEach.Consumer<? super T> action
	) {
		ForEach.forEach(list, action);
	}

	/**
	 * 按照元素出现的顺序对流中的每个元素执行指定的操作。
	 *
	 * @param action 要对每个元素执行的操作
	 */
	@Override
	public void forEachOrdered(Consumer<? super T> action) {
		forEach(action);
	}

	/**
	 * 将流中的元素转换为数组。
	 *
	 * @return 包含流中所有元素的数组
	 */
	@Override
	public @NotNull Object@NotNull [] toArray() {
		return list.toArray();
	}

	/**
	 * 使用指定的生成器函数将流中的元素转换为数组。
	 *
	 * @param generator 用于生成目标数组的函数
	 * @param <A> 数组元素的类型
	 * @return 包含流中所有元素的数组
	 */
	@Override
	public @NotNull <A> A[] toArray(IntFunction<A[]> generator) {
		return list.toArray(generator.apply(list.size()));
	}

	/**
	 * 使用指定的初始值和累积函数对流中的元素进行归约操作。
	 *
	 * @param identity 初始值
	 * @param accumulator 累积函数，用于将两个元素合并为一个
	 * @return 归约后的结果
	 */
	@Override
	public T reduce(T identity, BinaryOperator<T> accumulator) {
		T result = identity;
		for (T item : list) {
			result = accumulator.apply(result, item);
		}
		return result;
	}

	/**
	 * 使用指定的累积函数对流中的元素进行归约操作。
	 *
	 * @param accumulator 累积函数，用于将两个元素合并为一个
	 * @return 归约后的结果，如果流为空则返回空 Optional
	 */
	@Override
	public @NotNull Optional<T> reduce(BinaryOperator<T> accumulator) {
		if (list.isEmpty()) {
			return Optional.empty();
		}
		T result = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			result = accumulator.apply(result, list.get(i));
		}
		return Optional.of(result);
	}

	/**
	 * 使用指定的初始值、累积函数和组合函数对流中的元素进行归约操作。
	 *
	 * @param identity 初始值
	 * @param accumulator 累积函数，用于将元素与累积值合并
	 * @param combiner 组合函数，用于合并两个累积值
	 * @param <U> 累积值的类型
	 * @return 归约后的结果
	 */
	@Override
	public <U> U reduce(
		U identity,
		BiFunction<U, ? super T, U> accumulator,
		BinaryOperator<U> combiner
	) {
		U result = identity;
		for (T item : list) {
			result = accumulator.apply(result, item);
		}
		return result;
	}

	/**
	 * 使用指定的收集器将流中的元素收集到容器中。
	 *
	 * @param supplier 用于创建容器的函数
	 * @param accumulator 用于将元素添加到容器的函数
	 * @param combiner 用于合并两个容器的函数
	 * @param <R> 容器的类型
	 * @return 收集后的结果
	 */
	@Override
	public <R> R collect(
		Supplier<R> supplier,
		BiConsumer<R, ? super T> accumulator,
		BiConsumer<R, R> combiner
	) {
		R result = supplier.get();
		for (T item : list) {
			accumulator.accept(result, item);
		}
		return result;
	}

	@Override
	public String toString() {
		if (list.isEmpty()) {
			return "ListStream()";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("ListStream(");
		forEach((item, index) -> {
			sb.append(item);
			if (index != list.size() - 1) {
				sb.append(", ");
			} else {
				sb.append(")");
			}
		});
		return sb.toString();
	}

	/**
	 * 使用指定的收集器将流中的元素收集到容器中。
	 *
	 * @param collector 收集器，定义了如何收集元素
	 * @param <R> 收集结果的类型
	 * @param <A> 容器中元素的类型
	 * @return 收集后的结果
	 */
	@Override
	public <R, A> R collect(Collector<? super T, A, R> collector) {
		A container = collector.supplier().get();
		for (T item : list) {
			collector.accumulator().accept(container, item);
		}
		return collector.finisher().apply(container);
	}

	/**
	 * 根据给定的比较器找出流中的最小元素。
	 *
	 * @param comparator 用于比较元素的比较器
	 * @return 包含最小元素的 Optional，如果流为空则返回空 Optional
	 */
	@Override
	public @NotNull Optional<T> min(Comparator<? super T> comparator) {
		if (list.isEmpty()) {
			return Optional.empty();
		}
		T min = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			T current = list.get(i);
			if (comparator.compare(current, min) < 0) {
				min = current;
			}
		}
		return Optional.of(min);
	}

	/**
	 * 根据给定的比较器找出流中的最大元素。
	 *
	 * @param comparator 用于比较元素的比较器
	 * @return 包含最大元素的 Optional，如果流为空则返回空 Optional
	 */
	@Override
	public @NotNull Optional<T> max(Comparator<? super T> comparator) {
		if (list.isEmpty()) {
			return Optional.empty();
		}
		T max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			T current = list.get(i);
			if (comparator.compare(current, max) > 0) {
				max = current;
			}
		}
		return Optional.of(max);
	}

	/**
	 * 返回流中元素的数量。
	 *
	 * @return 元素数量
	 */
	@Override
	public long count() {
		return list.size();
	}

	/**
	 * 检查流中是否有至少一个元素满足给定的谓词条件。
	 *
	 * @param predicate 用于测试元素的谓词函数
	 * @return 如果有至少一个元素满足条件则返回 true，否则返回 false
	 */
	@Override
	public boolean anyMatch(Predicate<? super T> predicate) {
		for (T item : list) {
			if (predicate.test(item)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查流中是否所有元素都满足给定的谓词条件。
	 *
	 * @param predicate 用于测试元素的谓词函数
	 * @return 如果所有元素都满足条件则返回 true，否则返回 false
	 */
	@Override
	public boolean allMatch(Predicate<? super T> predicate) {
		for (T item : list) {
			if (!predicate.test(item)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查流中是否没有任何元素满足给定的谓词条件。
	 *
	 * @param predicate 用于测试元素的谓词函数
	 * @return 如果没有任何元素满足条件则返回 true，否则返回 false
	 */
	@Override
	public boolean noneMatch(Predicate<? super T> predicate) {
		return !anyMatch(predicate);
	}

	/**
	 * 获取流中的第一个元素。
	 *
	 * @return 包含第一个元素的 Optional，如果流为空则返回空 Optional
	 */
	@Override
	public @NotNull Optional<T> findFirst() {
		return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
	}

	/**
	 * 获取流中的最后一个元素。
	 *
	 * @return 包含最后一个元素的 Optional，如果流为空则返回空 Optional
	 */
	public @NotNull Optional<T> findEnd() {
		return list.isEmpty()
			? Optional.empty()
			: Optional.of(list.get(list.size() - 1));
	}

	/**
	 * 获取流中的任意一个元素。
	 *
	 * @return 包含任意一个元素的 Optional，如果流为空则返回空 Optional
	 */
	@Override
	public @NotNull Optional<T> findAny() {
		if (list.size() == 1) {
			return Optional.of(list.get(0));
		} else {
			return list.isEmpty()
				? Optional.empty()
				: Optional.of(
					list.get(RandomInt.randomInt(0, list.size() - 1))
				);
		}
	}

	/**
	 * 返回流中元素的迭代器。
	 *
	 * @return 元素迭代器
	 */
	@Override
	public @NotNull Iterator<T> iterator() {
		return list.iterator();
	}

	/**
	 * 返回流中元素的 Spliterator。
	 *
	 * @return 元素 Spliterator
	 */
	@Override
	public @NotNull Spliterator<T> spliterator() {
		return list.spliterator();
	}

	/**
	 * 检查当前流是否为并行流。
	 *
	 * @return 如果是并行流则返回 true，否则返回 false
	 */
	@Override
	public boolean isParallel() {
		return false;
	}

	/**
	 * 返回当前流的顺序版本。
	 *
	 * @return 当前流的顺序版本
	 */
	@Override
	public @NotNull ListStream<T> sequential() {
		return this;
	}

	/**
	 * 返回当前流的并行版本。
	 *
	 * @return 当前流的并行版本
	 */
	@Override
	public @NotNull ListStream<T> parallel() {
		return new ListStream<>(list);
	}

	/**
	 * 返回当前流的无序版本。
	 *
	 * @return 当前流的无序版本
	 */
	@Override
	public @NotNull ListStream<T> unordered() {
		return this;
	}

	/**
	 * 注册一个关闭处理器，在流关闭时执行。
	 *
	 * @param closeHandler 关闭处理器
	 * @return 当前 ListStream 实例
	 */
	@Override
	public @NotNull ListStream<T> onClose(@NotNull Runnable closeHandler) {
		return this;
	}

	/**
	 * 关闭流。
	 */
	@Override
	public void close() {
		list.clear();
	}
}
