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
 * LastUpdate 2025-09-21 14:22:13
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.stream;

import com.mingliqiye.utils.collection.Collections;
import com.mingliqiye.utils.functions.P1Function;
import com.mingliqiye.utils.functions.P2Function;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.*;


/**
 * SuperStream 是对 Java 原生 Stream 的增强封装类，提供更便捷的流式操作接口。
 * 它支持链式调用，并扩展了部分原生 Stream 不支持的功能，例如带索引的 forEach 操作。
 *
 * @param <T> 流中元素的类型
 */
public class SuperStream<T> implements Stream<T> {

    private final Stream<T> stream;

    /**
     * 构造方法，将传入的 Stream 包装为 SuperStream。
     *
     * @param stream 要包装的原始 Stream
     */
    private SuperStream(Stream<T> stream) {
        this.stream = stream;
    }

    /**
     * 将指定的 Stream 包装为 SuperStream。
     *
     * @param stream 原始 Stream
     * @param <T>    流中元素的类型
     * @return 包装后的 SuperStream 实例
     */
    public static <T> SuperStream<T> of(Stream<T> stream) {
        return new SuperStream<>(stream);
    }

    public static <T> SuperStream<T> of(T[] ts, boolean parallel) {
        return of(Collections.newArrayLists(ts), parallel);
    }

    public static <T> SuperStream<T> of(T[] ts) {
        return of(ts, false);
    }

    /**
     * 将指定的 Collection 转换为 SuperStream，默认为顺序流。
     *
     * @param collection 原始集合
     * @param <T>        集合中元素的类型
     * @return 包装后的 SuperStream 实例
     */
    public static <T> SuperStream<T> of(Collection<T> collection) {
        return of(collection, false);
    }

    /**
     * 将指定的 Map 转换为 SuperStream，默认为顺序流。
     *
     * @param map 原始 Map
     * @param <K> Map 键的类型
     * @param <V> Map 值的类型
     * @return 包含 Map.Entry 的 SuperStream 实例
     */
    public static <K, V> SuperStream<Map.Entry<K, V>> of(Map<K, V> map) {
        return of(map.entrySet(), false);
    }

    /**
     * 将指定的 Map 转换为 SuperStream，可选择是否为并行流。
     *
     * @param map      原始 Map
     * @param parallel 是否使用并行流
     * @param <K>      Map 键的类型
     * @param <V>      Map 值的类型
     * @return 包含 Map.Entry 的 SuperStream 实例
     */
    public static <K, V> SuperStream<Map.Entry<K, V>> of(Map<K, V> map, boolean parallel) {
        return SuperStream.of(map.entrySet(), parallel);
    }

    /**
     * 将指定的 Collection 转换为 SuperStream，可选择是否为并行流。
     *
     * @param stream   原始集合
     * @param parallel 是否使用并行流
     * @param <T>      集合中元素的类型
     * @return 包装后的 SuperStream 实例
     */
    public static <T> SuperStream<T> of(Collection<T> stream, boolean parallel) {
        return parallel ? SuperStream.of(stream.parallelStream()) : SuperStream.of(stream.stream());
    }

    /**
     * 返回一个用于收集 Double 类型统计信息的 Collector。
     *
     * @param mapper 映射函数，将元素转换为 double 值
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, DoubleSummaryStatistics> summarizingDouble(@NotNull ToDoubleFunction<? super T> mapper) {
        return Collectors.summarizingDouble(mapper);
    }

    /**
     * 返回一个用于收集 Long 类型统计信息的 Collector。
     *
     * @param mapper 映射函数，将元素转换为 long 值
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, LongSummaryStatistics> summarizingLong(@NotNull ToLongFunction<? super T> mapper) {
        return Collectors.summarizingLong(mapper);
    }

    /**
     * 返回一个用于收集 Integer 类型统计信息的 Collector。
     *
     * @param mapper 映射函数，将元素转换为 int 值
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, IntSummaryStatistics> summarizingInt(@NotNull ToIntFunction<? super T> mapper) {
        return Collectors.summarizingInt(mapper);
    }

    /**
     * 返回一个用于收集元素到 ConcurrentMap 的 Collector，支持自定义合并策略和 Map 工厂。
     *
     * @param keyMapper     键映射函数
     * @param valueMapper   值映射函数
     * @param mergeFunction 合并函数
     * @param mapSupplier   Map 工厂
     * @param <T>           元素类型
     * @param <K>           键类型
     * @param <U>           值类型
     * @param <M>           Map 类型
     * @return Collector 实例
     */
    public static <T, K, U, M extends ConcurrentMap<K, U>> Collector<T, ?, M> toConcurrentMap(
            @NotNull Function<? super T, ? extends K> keyMapper,
            @NotNull Function<? super T, ? extends U> valueMapper,
            @NotNull BinaryOperator<U> mergeFunction,
            @NotNull Supplier<M> mapSupplier) {
        return Collectors.toConcurrentMap(keyMapper, valueMapper, mergeFunction, mapSupplier);
    }

    /**
     * 返回一个用于收集元素到 ConcurrentMap 的 Collector，支持自定义合并策略。
     *
     * @param keyMapper     键映射函数
     * @param valueMapper   值映射函数
     * @param mergeFunction 合并函数
     * @param <T>           元素类型
     * @param <K>           键类型
     * @param <U>           值类型
     * @return Collector 实例
     */
    public static <T, K, U> Collector<T, ?, ConcurrentMap<K, U>> toConcurrentMap(
            @NotNull Function<? super T, ? extends K> keyMapper,
            @NotNull Function<? super T, ? extends U> valueMapper,
            @NotNull BinaryOperator<U> mergeFunction) {
        return Collectors.toConcurrentMap(keyMapper, valueMapper, mergeFunction);
    }

    /**
     * 返回一个用于收集元素到 ConcurrentMap 的 Collector。
     *
     * @param keyMapper   键映射函数
     * @param valueMapper 值映射函数
     * @param <T>         元素类型
     * @param <K>         键类型
     * @param <U>         值类型
     * @return Collector 实例
     */
    public static <T, K, U> Collector<T, ?, ConcurrentMap<K, U>> toConcurrentMap(
            @NotNull Function<? super T, ? extends K> keyMapper,
            @NotNull Function<? super T, ? extends U> valueMapper) {
        return Collectors.toConcurrentMap(keyMapper, valueMapper);
    }

    /**
     * 返回一个用于收集元素到 Map 的 Collector，支持自定义合并策略和 Map 工厂。
     *
     * @param keyMapper     键映射函数
     * @param valueMapper   值映射函数
     * @param mergeFunction 合并函数
     * @param mapSupplier   Map 工厂
     * @param <T>           元素类型
     * @param <K>           键类型
     * @param <U>           值类型
     * @param <M>           Map 类型
     * @return Collector 实例
     */
    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(
            @NotNull Function<? super T, ? extends K> keyMapper,
            @NotNull Function<? super T, ? extends U> valueMapper,
            @NotNull BinaryOperator<U> mergeFunction,
            @NotNull Supplier<M> mapSupplier) {
        return Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapSupplier);
    }

    /**
     * 返回一个用于收集元素到 Map 的 Collector，支持自定义合并策略。
     *
     * @param keyMapper     键映射函数
     * @param valueMapper   值映射函数
     * @param mergeFunction 合并函数
     * @param <T>           元素类型
     * @param <K>           键类型
     * @param <U>           值类型
     * @return Collector 实例
     */
    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(
            @NotNull Function<? super T, ? extends K> keyMapper,
            @NotNull Function<? super T, ? extends U> valueMapper,
            @NotNull BinaryOperator<U> mergeFunction) {
        return Collectors.toMap(keyMapper, valueMapper, mergeFunction);
    }

    /**
     * 返回一个用于收集元素到 Map 的 Collector。
     *
     * @param keyMapper   键映射函数
     * @param valueMapper 值映射函数
     * @param <T>         元素类型
     * @param <K>         键类型
     * @param <U>         值类型
     * @return Collector 实例
     */
    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(
            @NotNull Function<? super T, ? extends K> keyMapper,
            @NotNull Function<? super T, ? extends U> valueMapper) {
        return Collectors.toMap(keyMapper, valueMapper);
    }

    /**
     * 返回一个用于根据条件将元素分组到两个列表中的 Collector。
     *
     * @param predicate  判断条件
     * @param downstream 下游 Collector
     * @param <T>        元素类型
     * @param <D>        下游结果类型
     * @return Collector 实例
     */
    public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningBy(
            @NotNull Predicate<? super T> predicate,
            @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.partitioningBy(predicate, downstream);
    }

    /**
     * 返回一个用于根据条件将元素分组到两个列表中的 Collector。
     *
     * @param predicate 判断条件
     * @param <T>       元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(@NotNull Predicate<? super T> predicate) {
        return Collectors.partitioningBy(predicate);
    }

    /**
     * 返回一个用于并发分组的 Collector，支持自定义 Map 工厂和下游 Collector。
     *
     * @param classifier 分类函数
     * @param mapFactory Map 工厂
     * @param downstream 下游 Collector
     * @param <T>        元素类型
     * @param <K>        键类型
     * @param <D>        下游结果类型
     * @param <A>        下游中间类型
     * @param <M>        Map 类型
     * @return Collector 实例
     */
    public static <T, K, D, A, M extends ConcurrentMap<K, D>> Collector<T, ?, M> groupingByConcurrent(
            @NotNull Function<? super T, ? extends K> classifier,
            @NotNull Supplier<M> mapFactory,
            @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.groupingByConcurrent(classifier, mapFactory, downstream);
    }

    /**
     * 返回一个用于并发分组的 Collector，支持自定义下游 Collector。
     *
     * @param classifier 分类函数
     * @param downstream 下游 Collector
     * @param <T>        元素类型
     * @param <K>        键类型
     * @param <A>        下游中间类型
     * @param <D>        下游结果类型
     * @return Collector 实例
     */
    public static <T, K, A, D> Collector<T, ?, ConcurrentMap<K, D>> groupingByConcurrent(
            @NotNull Function<? super T, ? extends K> classifier,
            @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.groupingByConcurrent(classifier, downstream);
    }

    /**
     * 返回一个用于并发分组的 Collector。
     *
     * @param classifier 分类函数
     * @param <T>        元素类型
     * @param <K>        键类型
     * @return Collector 实例
     */
    public static <T, K> Collector<T, ?, ConcurrentMap<K, List<T>>> groupingByConcurrent(
            @NotNull Function<? super T, ? extends K> classifier) {
        return Collectors.groupingByConcurrent(classifier);
    }

    /**
     * 返回一个用于分组的 Collector，支持自定义 Map 工厂和下游 Collector。
     *
     * @param classifier 分类函数
     * @param mapFactory Map 工厂
     * @param downstream 下游 Collector
     * @param <T>        元素类型
     * @param <K>        键类型
     * @param <D>        下游结果类型
     * @param <A>        下游中间类型
     * @param <M>        Map 类型
     * @return Collector 实例
     */
    public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> groupingBy(
            @NotNull Function<? super T, ? extends K> classifier,
            @NotNull Supplier<M> mapFactory,
            @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.groupingBy(classifier, mapFactory, downstream);
    }

    /**
     * 返回一个用于分组的 Collector，支持自定义下游 Collector。
     *
     * @param classifier 分类函数
     * @param downstream 下游 Collector
     * @param <T>        元素类型
     * @param <K>        键类型
     * @param <A>        下游中间类型
     * @param <D>        下游结果类型
     * @return Collector 实例
     */
    public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(
            @NotNull Function<? super T, ? extends K> classifier,
            @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.groupingBy(classifier, downstream);
    }

    /**
     * 返回一个用于分组的 Collector。
     *
     * @param classifier 分类函数
     * @param <T>        元素类型
     * @param <K>        键类型
     * @return Collector 实例
     */
    public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(@NotNull Function<? super T, ? extends K> classifier) {
        return Collectors.groupingBy(classifier);
    }

    /**
     * 返回一个用于归约的 Collector，支持映射和合并操作。
     *
     * @param identity 初始值
     * @param mapper   映射函数
     * @param op       合并函数
     * @param <T>      元素类型
     * @param <U>      结果类型
     * @return Collector 实例
     */
    public static <T, U> Collector<T, ?, U> reducing(U identity, @NotNull Function<? super T, ? extends U> mapper, @NotNull BinaryOperator<U> op) {
        return Collectors.reducing(identity, mapper, op);
    }

    /**
     * 返回一个用于归约的 Collector。
     *
     * @param op  合并函数
     * @param <T> 元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Optional<T>> reducing(@NotNull BinaryOperator<T> op) {
        return Collectors.reducing(op);
    }

    /**
     * 返回一个用于归约的 Collector，支持初始值。
     *
     * @param identity 初始值
     * @param op       合并函数
     * @param <T>      元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, T> reducing(T identity, @NotNull BinaryOperator<T> op) {
        return Collectors.reducing(identity, op);
    }

    /**
     * 返回一个用于计算平均值的 Collector，适用于 double 类型。
     *
     * @param mapper 映射函数
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Double> averagingDouble(@NotNull ToDoubleFunction<? super T> mapper) {
        return Collectors.averagingDouble(mapper);
    }

    /**
     * 返回一个用于计算平均值的 Collector，适用于 long 类型。
     *
     * @param mapper 映射函数
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Double> averagingLong(@NotNull ToLongFunction<? super T> mapper) {
        return Collectors.averagingLong(mapper);
    }

    /**
     * 返回一个用于计算平均值的 Collector，适用于 int 类型。
     *
     * @param mapper 映射函数
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Double> averagingInt(@NotNull ToIntFunction<? super T> mapper) {
        return Collectors.averagingInt(mapper);
    }

    /**
     * 返回一个用于求和的 Collector，适用于 double 类型。
     *
     * @param mapper 映射函数
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Double> summingDouble(@NotNull ToDoubleFunction<? super T> mapper) {
        return Collectors.summingDouble(mapper);
    }

    /**
     * 返回一个用于求和的 Collector，适用于 long 类型。
     *
     * @param mapper 映射函数
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Long> summingLong(@NotNull ToLongFunction<? super T> mapper) {
        return Collectors.summingLong(mapper);
    }

    /**
     * 返回一个用于求和的 Collector，适用于 int 类型。
     *
     * @param mapper 映射函数
     * @param <T>    元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Integer> summingInt(@NotNull ToIntFunction<? super T> mapper) {
        return Collectors.summingInt(mapper);
    }

    /**
     * 返回一个用于查找最大值的 Collector。
     *
     * @param comparator 比较器
     * @param <T>        元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Optional<T>> maxBy(@NotNull Comparator<? super T> comparator) {
        return Collectors.maxBy(comparator);
    }

    /**
     * 返回一个用于查找最小值的 Collector。
     *
     * @param comparator 比较器
     * @param <T>        元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Optional<T>> minBy(@NotNull Comparator<? super T> comparator) {
        return Collectors.minBy(comparator);
    }

    /**
     * 返回一个用于计数的 Collector。
     *
     * @param <T> 元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Long> counting() {
        return Collectors.counting();
    }

    /**
     * 返回一个用于在下游收集后进行后续处理的 Collector。
     *
     * @param downstream 下游 Collector
     * @param finisher   后续处理函数
     * @param <T>        元素类型
     * @param <A>        下游中间类型
     * @param <R>        下游结果类型
     * @param <RR>       最终结果类型
     * @return Collector 实例
     */
    public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(
            @NotNull Collector<T, A, R> downstream,
            @NotNull Function<R, RR> finisher) {
        return Collectors.collectingAndThen(downstream, finisher);
    }

    /**
     * 返回一个用于映射后收集的 Collector。
     *
     * @param mapper     映射函数
     * @param downstream 下游 Collector
     * @param <T>        元素类型
     * @param <U>        映射后的类型
     * @param <A>        下游中间类型
     * @param <R>        下游结果类型
     * @return Collector 实例
     */
    public static <T, U, A, R> Collector<T, ?, R> mapping(
            @NotNull Function<? super T, ? extends U> mapper,
            @NotNull Collector<? super U, A, R> downstream) {
        return Collectors.mapping(mapper, downstream);
    }

    /**
     * 返回一个用于连接字符串的 Collector，支持前缀、后缀和分隔符。
     *
     * @param delimiter 分隔符
     * @param prefix    前缀
     * @param suffix    后缀
     * @return Collector 实例
     */
    public static Collector<CharSequence, ?, String> joining(@NotNull CharSequence delimiter, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        return Collectors.joining(delimiter, prefix, suffix);
    }

    /**
     * 返回一个用于连接字符串的 Collector，支持分隔符。
     *
     * @param delimiter 分隔符
     * @return Collector 实例
     */
    public static Collector<CharSequence, ?, String> joining(@NotNull CharSequence delimiter) {
        return Collectors.joining(delimiter);
    }

    /**
     * 返回一个用于连接字符串的 Collector。
     *
     * @return Collector 实例
     */
    public static Collector<CharSequence, ?, String> joining() {
        return Collectors.joining();
    }

    /**
     * 返回一个用于收集元素到 Set 的 Collector。
     *
     * @param <T> 元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, Set<T>> toSet() {
        return Collectors.toSet();
    }

    /**
     * 返回一个用于收集元素到 List 的 Collector。
     *
     * @param <T> 元素类型
     * @return Collector 实例
     */
    public static <T> Collector<T, ?, List<T>> toList() {
        return Collectors.toList();
    }

    /**
     * 返回一个用于收集元素到指定集合类型的 Collector。
     *
     * @param collectionFactory 集合工厂
     * @param <T>               元素类型
     * @param <C>               集合类型
     * @return Collector 实例
     */
    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(@NotNull Supplier<C> collectionFactory) {
        return Collectors.toCollection(collectionFactory);
    }

    /**
     * 返回一个用于收集元素到 Map 的 Collector，键由 keyMapper 提供，值为元素本身。
     *
     * @param keyMapper 键映射函数
     * @param <T>       元素类型
     * @param <K>       键类型
     * @return Collector 实例
     */
    public static <T, K> Collector<T, ?, Map<K, T>> toMap(Function<? super T, ? extends K> keyMapper) {
        return toMap(keyMapper, Function.identity());
    }

    /**
     * 返回一个用于收集 Map.Entry 到 Map 的 Collector。
     *
     * @param <T> Map.Entry 类型
     * @param <K> 键类型
     * @param <V> 值类型
     * @return Collector 实例
     */
    public static <T extends Map.Entry<K, V>, K, V> Collector<T, ?, Map<K, V>> toMap() {
        return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
    }

    /**
     * 过滤流中的元素。
     *
     * @param predicate 过滤条件
     * @return 过滤后的 SuperStream 实例
     */
    public SuperStream<T> filter(Predicate<? super T> predicate) {
        return SuperStream.of(stream.filter(predicate));
    }

    /**
     * 使用指定的 Collector 收集流中的元素。
     *
     * @param collector Collector 实例
     * @param <R>       结果类型
     * @param <A>       中间类型
     * @return 收集结果
     */
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return stream.collect(collector);
    }

    /**
     * 返回此流的Spliterator对象
     *
     * @return 此流的Spliterator对象，用于并行处理流中的元素
     */
    @NotNull
    public Spliterator<T> spliterator() {
        return stream.spliterator();
    }

    /**
     * 将此流中的每个元素转换为一个IntStream，然后将所有生成的IntStream连接成一个IntStream
     *
     * @param mapper 用于将流中每个元素转换为IntStream的函数
     * @return 由所有转换后的IntStream连接而成的新IntStream
     */
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return stream.flatMapToInt(mapper);
    }

    /**
     * 判断此流是否为并行流
     *
     * @return 如果此流是并行流则返回true，否则返回false
     */
    public boolean isParallel() {
        return stream.isParallel();
    }

    /**
     * 返回此流的迭代器对象
     *
     * @return 此流的迭代器对象，用于顺序访问流中的元素
     */
    @NotNull
    public Iterator<T> iterator() {
        return stream.iterator();
    }


    /**
     * 对流中每个元素执行指定操作。
     *
     * @param action 操作函数
     */
    public void forEach(P1Function<? super T> action) {
        stream.forEach(action::call);
    }

    /**
     * 对流中每个元素执行指定操作，并传入元素索引。
     *
     * @param action 操作函数，接受元素和索引
     */
    public void forEach(P2Function<? super T, Integer> action) {
        AtomicInteger i22 = new AtomicInteger(0);
        stream.forEach(i -> {
            action.call(i, i22.getAndAdd(1));
        });
    }

    /**
     * 对流中的每个元素执行给定的操作。
     *
     * @param action 要对每个元素执行的操作，不能为 null
     */
    public void forEach(Consumer<? super T> action) {
        stream.forEach(action);
    }

    /**
     * 将流中的每个元素转换为一个流，并将这些流合并为一个流。
     *
     * @param mapper 用于将每个元素映射为流的函数，不能为 null
     * @param <R>    映射后流中元素的类型
     * @return 合并后的流
     */
    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return stream.flatMap(mapper);
    }

    /**
     * 返回一个顺序执行的流。
     *
     * @return 顺序执行的 SuperStream 实例
     */
    @NotNull
    public SuperStream<T> sequential() {
        return SuperStream.of(stream.sequential());
    }

    /**
     * 跳过流中的前 n 个元素。
     *
     * @param n 要跳过的元素数量
     * @return 跳过元素后的 SuperStream 实例
     */
    public SuperStream<T> skip(long n) {
        return SuperStream.of(stream.skip(n));
    }

    /**
     * 使用提供的供应器、累加器和组合器对流进行归约操作。
     *
     * @param supplier    结果容器的供应器
     * @param accumulator 将元素累积到结果容器中的函数
     * @param combiner    合并两个结果容器的函数
     * @param <R>         结果容器的类型
     * @return 归约后的结果
     */
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return stream.collect(supplier, accumulator, combiner);
    }

    /**
     * 返回一个并行执行的流。
     *
     * @return 并行执行的 SuperStream 实例
     */
    @NotNull
    public SuperStream<T> parallel() {
        return SuperStream.of(stream.parallel());
    }

    /**
     * 将流中的每个元素映射为 DoubleStream，并将这些流合并为一个 DoubleStream。
     *
     * @param mapper 用于将每个元素映射为 DoubleStream 的函数，不能为 null
     * @return 合并后的 DoubleStream
     */
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return stream.flatMapToDouble(mapper);
    }

    /**
     * 使用提供的生成器函数将流转换为数组。
     *
     * @param generator 用于创建数组的函数
     * @param <A>       数组元素的类型
     * @return 转换后的数组
     */
    @NotNull
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return stream.toArray(generator);
    }

    /**
     * 返回流中的第一个元素（如果存在）。
     *
     * @return 包含第一个元素的 Optional，如果流为空则返回空 Optional
     */
    @NotNull
    public Optional<T> findFirst() {
        return stream.findFirst();
    }

    /**
     * 返回一个无序的流。
     *
     * @return 无序的 SuperStream 实例
     */
    @NotNull
    public SuperStream<T> unordered() {
        return SuperStream.of(stream.unordered());
    }

    /**
     * 根据提供的比较器返回流中的最小元素（如果存在）。
     *
     * @param comparator 用于比较元素的比较器，不能为 null
     * @return 包含最小元素的 Optional，如果流为空则返回空 Optional
     */
    @NotNull
    public Optional<T> min(Comparator<? super T> comparator) {
        return stream.min(comparator);
    }

    /**
     * 返回流中的任意元素（如果存在）。
     *
     * @return 包含任意元素的 Optional，如果流为空则返回空 Optional
     */
    @NotNull
    public Optional<T> findAny() {
        return stream.findAny();
    }

    /**
     * 注册一个关闭处理器，在流关闭时执行。
     *
     * @param closeHandler 流关闭时要执行的处理器，不能为 null
     * @return 注册了关闭处理器的 SuperStream 实例
     */
    @NotNull
    public SuperStream<T> onClose(@NotNull Runnable closeHandler) {
        return SuperStream.of(stream.onClose(closeHandler));
    }

    /**
     * 将流中的每个元素映射为 LongStream，并将这些流合并为一个 LongStream。
     *
     * @param mapper 用于将每个元素映射为 LongStream 的函数，不能为 null
     * @return 合并后的 LongStream
     */
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return stream.flatMapToLong(mapper);
    }

    /**
     * 将流转换为数组。<br>
     * 使用反射获取类型 是空的的话抛出
     * {@code StreamEmptyException }
     *
     * @return 转换后的数组
     * @throws StreamEmptyException 如果流为空
     * @see StreamEmptyException
     */
    @NotNull
    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz) {
        return stream.toArray(i -> (T[]) Array.newInstance(clazz, i));
    }

    @NotNull
    public Object[] toArray() {
        return stream.toArray();
    }

    /**
     * 按照 encounter order 对流中的每个元素执行给定的操作。
     *
     * @param action 要对每个元素执行的操作，不能为 null
     */
    public void forEachOrdered(Consumer<? super T> action) {
        stream.forEachOrdered(action);
    }

    /**
     * 关闭流并释放相关资源。
     */
    public void close() {
        stream.close();
    }

    /**
     * 使用提供的累加器函数对流进行归约操作。
     *
     * @param accumulator 用于归约的累加器函数
     * @return 包含归约结果的 Optional，如果流为空则返回空 Optional
     */
    @NotNull
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return stream.reduce(accumulator);
    }

    /**
     * 根据提供的比较器对流进行排序。
     *
     * @param comparator 用于排序的比较器，不能为 null
     * @return 排序后的 SuperStream 实例
     */
    public SuperStream<T> sorted(Comparator<? super T> comparator) {
        return SuperStream.of(stream.sorted(comparator));
    }

    /**
     * 检查流中的所有元素是否都满足给定的谓词。
     *
     * @param predicate 用于测试元素的谓词，不能为 null
     * @return 如果所有元素都满足谓词则返回 true，否则返回 false
     */
    public boolean allMatch(Predicate<? super T> predicate) {
        return stream.allMatch(predicate);
    }

    /**
     * 对流中的元素进行自然排序。
     *
     * @return 排序后的 SuperStream 实例
     */
    public SuperStream<T> sorted() {
        return SuperStream.of(stream.sorted());
    }

    /**
     * 返回流中元素的数量。
     *
     * @return 元素的数量
     */
    public long count() {
        return stream.count();
    }

    /**
     * 将流中的每个元素通过映射函数转换为另一种类型。
     *
     * @param mapper 用于映射元素的函数，不能为 null
     * @param <R>    映射后元素的类型
     * @return 映射后的 SuperStream 实例
     */
    public <R> SuperStream<R> map(Function<? super T, ? extends R> mapper) {
        return SuperStream.of(stream.map(mapper));
    }

    /**
     * 使用提供的标识值和累加器函数对流进行归约操作。
     *
     * @param identity    归约的初始值
     * @param accumulator 用于归约的累加器函数
     * @return 归约后的结果
     */
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return stream.reduce(identity, accumulator);
    }

    /**
     * 检查流中是否没有任何元素满足给定的谓词。
     *
     * @param predicate 用于测试元素的谓词，不能为 null
     * @return 如果没有任何元素满足谓词则返回 true，否则返回 false
     */
    public boolean noneMatch(Predicate<? super T> predicate) {
        return stream.noneMatch(predicate);
    }

    /**
     * 返回一个去除重复元素后的流。
     *
     * @return 去重后的 SuperStream 实例
     */
    public SuperStream<T> distinct() {
        return SuperStream.of(stream.distinct());
    }

    /**
     * 根据提供的比较器返回流中的最大元素（如果存在）。
     *
     * @param comparator 用于比较元素的比较器，不能为 null
     * @return 包含最大元素的 Optional，如果流为空则返回空 Optional
     */
    @NotNull
    public Optional<T> max(Comparator<? super T> comparator) {
        return stream.max(comparator);
    }

    /**
     * 将流中的每个元素映射为 double 值，并返回一个 DoubleStream。
     *
     * @param mapper 用于将元素映射为 double 的函数，不能为 null
     * @return 映射后的 DoubleStream
     */
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return stream.mapToDouble(mapper);
    }

    /**
     * 限制流中元素的数量。
     *
     * @param maxSize 最大元素数量
     * @return 限制后的 SuperStream 实例
     */
    public SuperStream<T> limit(long maxSize) {
        return SuperStream.of(stream.limit(maxSize));
    }

    /**
     * 将流中的每个元素映射为 long 值，并返回一个 LongStream。
     *
     * @param mapper 用于将元素映射为 long 的函数，不能为 null
     * @return 映射后的 LongStream
     */
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return stream.mapToLong(mapper);
    }

    /**
     * 对流中的每个元素执行给定的操作，并返回相同的流。
     *
     * @param action 要对每个元素执行的操作，不能为 null
     * @return 相同的 SuperStream 实例
     */
    public SuperStream<T> peek(Consumer<? super T> action) {
        return SuperStream.of(stream.peek(action));
    }

    /**
     * 使用提供的标识值、累加器函数和组合器对流进行归约操作。
     *
     * @param identity    归约的初始值
     * @param accumulator 用于归约的累加器函数
     * @param combiner    用于合并部分结果的组合器函数
     * @param <U>         归约结果的类型
     * @return 归约后的结果
     */
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return stream.reduce(identity, accumulator, combiner);
    }

    /**
     * 将流中的每个元素映射为 int 值，并返回一个 IntStream。
     *
     * @param mapper 用于将元素映射为 int 的函数，不能为 null
     * @return 映射后的 IntStream
     */
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return stream.mapToInt(mapper);
    }

    /**
     * 检查流中是否有任何元素满足给定的谓词。
     *
     * @param predicate 用于测试元素的谓词，不能为 null
     * @return 如果有任何元素满足谓词则返回 true，否则返回 false
     */
    public boolean anyMatch(Predicate<? super T> predicate) {
        return stream.anyMatch(predicate);
    }


    /**
     * 获取原始 Stream。
     *
     * @return 原始 Stream 实例
     */
    public Stream<T> getStream() {
        return stream;
    }

    /**
     * 将流中的元素收集到 Map 中。
     *
     * @param keyMapper   键映射函数
     * @param valueMapper 值映射函数
     * @param <K>         键类型
     * @param <V>         值类型
     * @return 收集结果 Map
     */
    public <K, V> Map<K, V> toAMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return collect(toMap(keyMapper, valueMapper));
    }

    /**
     * 将流中的元素收集到 Map 中，值为元素本身。
     *
     * @param keyMapper 键映射函数
     * @param <K>       键类型
     * @return 收集结果 Map
     */
    public <K> Map<K, T> toAMap(Function<? super T, ? extends K> keyMapper) {
        return collect(toMap(keyMapper));
    }

    /**
     * 将流中的元素收集到 List 中。
     *
     * @return 收集结果 List
     */
    public List<T> toAList() {
        return collect(toList());
    }

}
