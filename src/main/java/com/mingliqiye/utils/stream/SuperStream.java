/*
 * Copyright 2026 mingliqiye
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
 * LastUpdate 2026-01-20 13:27:09
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
 * SuperStream是一个增强版的Stream包装器，提供了更多的便捷方法和重载方法来处理各种数据类型的流操作。
 * 它继承了Stream接口并实现了所有Stream的方法，同时添加了一些额外的便利功能。
 */
public class SuperStream<T> implements Stream<T> {

    private final Stream<T> stream;


    /**
     * 构造一个新的SuperStream实例
     *
     * @param stream 被包装的基础Stream对象
     */
    private SuperStream(Stream<T> stream) {
        this.stream = stream;
    }

    /**
     * 创建一个包含指定整数元素的SuperStream
     *
     * @param args 可变参数的整数值数组
     * @return 包含指定整数的SuperStream实例
     */
    public static SuperStream<Integer> of(int... args) {
        return of(Collections.newArrayLists(args));
    }

    /**
     * 创建一个包含指定字节元素的SuperStream
     *
     * @param args 可变参数的字节数组
     * @return 包含指定字节的SuperStream实例
     */
    public static SuperStream<Byte> of(byte... args) {
        return of(Collections.newArrayLists(args));
    }

    /**
     * 创建一个包含指定短整数元素的SuperStream
     *
     * @param args 可变参数的短整数数组
     * @return 包含指定短整数的SuperStream实例
     */
    public static SuperStream<Short> of(short... args) {
        return of(Collections.newArrayLists(args));
    }

    /**
     * 创建一个包含指定字符元素的SuperStream
     *
     * @param args 可变参数的字符数组
     * @return 包含指定字符的SuperStream实例
     */
    public static SuperStream<Character> of(char... args) {
        return of(Collections.newArrayLists(args));
    }

    /**
     * 创建一个包含指定长整数元素的SuperStream
     *
     * @param args 可变参数的长整数数组
     * @return 包含指定长整数的SuperStream实例
     */
    public static SuperStream<Long> of(long... args) {
        return of(Collections.newArrayLists(args));
    }

    /**
     * 创建一个包含指定浮点数元素的SuperStream
     *
     * @param args 可变参数的浮点数数组
     * @return 包含指定浮点数的SuperStream实例
     */
    public static SuperStream<Float> of(float... args) {
        return of(Collections.newArrayLists(args));
    }

    /**
     * 创建一个包含指定双精度浮点数元素的SuperStream
     *
     * @param args 可变参数的双精度浮点数数组
     * @return 包含指定双精度浮点数的SuperStream实例
     */
    public static SuperStream<Double> of(double... args) {
        return of(Collections.newArrayLists(args));
    }


    /**
     * 将现有的Stream包装成SuperStream
     *
     * @param stream 需要包装的Stream对象
     * @param <T>    流中元素的类型
     * @return 包装后的SuperStream实例
     */
    public static <T> SuperStream<T> of(Stream<T> stream) {
        return new SuperStream<>(stream);
    }

    /**
     * 创建一个包含指定数组元素的SuperStream，支持并行处理
     *
     * @param ts       元素数组
     * @param parallel 是否使用并行流
     * @param <T>      数组元素的类型
     * @return 包含指定数组元素的SuperStream实例
     */
    public static <T> SuperStream<T> of(T[] ts, boolean parallel) {
        return of(Collections.newArrayLists(ts), parallel);
    }

    /**
     * 创建一个包含指定数组元素的SuperStream（默认串行）
     *
     * @param ts  元素数组
     * @param <T> 数组元素的类型
     * @return 包含指定数组元素的SuperStream实例
     */
    public static <T> SuperStream<T> of(T[] ts) {
        return of(ts, false);
    }


    /**
     * 创建一个包含指定集合元素的SuperStream（默认串行）
     *
     * @param collection 包含元素的集合
     * @param <T>        集合元素的类型
     * @return 包含指定集合元素的SuperStream实例
     */
    public static <T> SuperStream<T> of(Collection<T> collection) {
        return of(collection, false);
    }


    /**
     * 创建一个包含指定Map键值对Entry的SuperStream（默认串行）
     *
     * @param map 源Map对象
     * @param <K> Map的键类型
     * @param <V> Map的值类型
     * @return 包含Map Entry的SuperStream实例
     */
    public static <K, V> SuperStream<Map.Entry<K, V>> of(Map<K, V> map) {
        return of(map.entrySet(), false);
    }


    /**
     * 创建一个包含指定Map键值对Entry的SuperStream，支持并行处理
     *
     * @param map      源Map对象
     * @param parallel 是否使用并行流
     * @param <K>      Map的键类型
     * @param <V>      Map的值类型
     * @return 包含Map Entry的SuperStream实例
     */
    public static <K, V> SuperStream<Map.Entry<K, V>> of(Map<K, V> map, boolean parallel) {
        return SuperStream.of(map.entrySet(), parallel);
    }


    /**
     * 创建一个包含指定集合元素的SuperStream，支持并行处理
     *
     * @param stream   包含元素的集合
     * @param parallel 是否使用并行流
     * @param <T>      集合元素的类型
     * @return 包含指定集合元素的SuperStream实例
     */
    public static <T> SuperStream<T> of(Collection<T> stream, boolean parallel) {
        return parallel ? SuperStream.of(stream.parallelStream()) : SuperStream.of(stream.stream());
    }


    /**
     * 返回一个收集器，该收集器产生一个DoubleSummaryStatistics，描述输入元素的统计信息
     *
     * @param mapper 用于将输入元素映射到double值的函数
     * @param <T>    输入元素的类型
     * @return 产生DoubleSummaryStatistics的收集器
     */
    public static <T> Collector<T, ?, DoubleSummaryStatistics> summarizingDouble(@NotNull ToDoubleFunction<? super T> mapper) {
        return Collectors.summarizingDouble(mapper);
    }


    /**
     * 返回一个收集器，该收集器产生一个LongSummaryStatistics，描述输入元素的统计信息
     *
     * @param mapper 用于将输入元素映射到long值的函数
     * @param <T>    输入元素的类型
     * @return 产生LongSummaryStatistics的收集器
     */
    public static <T> Collector<T, ?, LongSummaryStatistics> summarizingLong(@NotNull ToLongFunction<? super T> mapper) {
        return Collectors.summarizingLong(mapper);
    }


    /**
     * 返回一个收集器，该收集器产生一个IntSummaryStatistics，描述输入元素的统计信息
     *
     * @param mapper 用于将输入元素映射到int值的函数
     * @param <T>    输入元素的类型
     * @return 产生IntSummaryStatistics的收集器
     */
    public static <T> Collector<T, ?, IntSummaryStatistics> summarizingInt(@NotNull ToIntFunction<? super T> mapper) {
        return Collectors.summarizingInt(mapper);
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到ConcurrentMap中
     *
     * @param keyMapper     用于产生键的映射函数
     * @param valueMapper   用于产生值的映射函数
     * @param mergeFunction 当键冲突时合并值的函数
     * @param mapSupplier   用于创建新Map的供应函数
     * @param <T>           输入元素的类型
     * @param <K>           键的类型
     * @param <U>           值的类型
     * @param <M>           Map的具体类型
     * @return 产生ConcurrentMap的收集器
     */
    public static <T, K, U, M extends ConcurrentMap<K, U>> Collector<T, ?, M> toConcurrentMap(@NotNull Function<? super T, ? extends K> keyMapper, @NotNull Function<? super T, ? extends U> valueMapper, @NotNull BinaryOperator<U> mergeFunction, @NotNull Supplier<M> mapSupplier) {
        return Collectors.toConcurrentMap(keyMapper, valueMapper, mergeFunction, mapSupplier);
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到ConcurrentMap中，使用BinaryOperator处理键冲突
     *
     * @param keyMapper     用于产生键的映射函数
     * @param valueMapper   用于产生值的映射函数
     * @param mergeFunction 当键冲突时合并值的函数
     * @param <T>           输入元素的类型
     * @param <K>           键的类型
     * @param <U>           值的类型
     * @return 产生ConcurrentMap的收集器
     */
    public static <T, K, U> Collector<T, ?, ConcurrentMap<K, U>> toConcurrentMap(@NotNull Function<? super T, ? extends K> keyMapper, @NotNull Function<? super T, ? extends U> valueMapper, @NotNull BinaryOperator<U> mergeFunction) {
        return Collectors.toConcurrentMap(keyMapper, valueMapper, mergeFunction);
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到ConcurrentMap中，使用HashMap.merge处理键冲突
     *
     * @param keyMapper   用于产生键的映射函数
     * @param valueMapper 用于产生值的映射函数
     * @param <T>         输入元素的类型
     * @param <K>         键的类型
     * @param <U>         值的类型
     * @return 产生ConcurrentMap的收集器
     */
    public static <T, K, U> Collector<T, ?, ConcurrentMap<K, U>> toConcurrentMap(@NotNull Function<? super T, ? extends K> keyMapper, @NotNull Function<? super T, ? extends U> valueMapper) {
        return Collectors.toConcurrentMap(keyMapper, valueMapper);
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到Map中
     *
     * @param keyMapper     用于产生键的映射函数
     * @param valueMapper   用于产生值的映射函数
     * @param mergeFunction 当键冲突时合并值的函数
     * @param mapSupplier   用于创建新Map的供应函数
     * @param <T>           输入元素的类型
     * @param <K>           键的类型
     * @param <U>           值的类型
     * @param <M>           Map的具体类型
     * @return 产生Map的收集器
     */
    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(@NotNull Function<? super T, ? extends K> keyMapper, @NotNull Function<? super T, ? extends U> valueMapper, @NotNull BinaryOperator<U> mergeFunction, @NotNull Supplier<M> mapSupplier) {
        return Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapSupplier);
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到Map中，使用BinaryOperator处理键冲突
     *
     * @param keyMapper     用于产生键的映射函数
     * @param valueMapper   用于产生值的映射函数
     * @param mergeFunction 当键冲突时合并值的函数
     * @param <T>           输入元素的类型
     * @param <K>           键的类型
     * @param <U>           值的类型
     * @return 产生Map的收集器
     */
    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(@NotNull Function<? super T, ? extends K> keyMapper, @NotNull Function<? super T, ? extends U> valueMapper, @NotNull BinaryOperator<U> mergeFunction) {
        return Collectors.toMap(keyMapper, valueMapper, mergeFunction);
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到Map中，使用HashMap.merge处理键冲突
     *
     * @param keyMapper   用于产生键的映射函数
     * @param valueMapper 用于产生值的映射函数
     * @param <T>         输入元素的类型
     * @param <K>         键的类型
     * @param <U>         值的类型
     * @return 产生Map的收集器
     */
    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(@NotNull Function<? super T, ? extends K> keyMapper, @NotNull Function<? super T, ? extends U> valueMapper) {
        return Collectors.toMap(keyMapper, valueMapper);
    }


    /**
     * 返回一个收集器，该收集器根据谓词将输入元素分区到Map中
     *
     * @param predicate  用于确定元素分区的谓词
     * @param downstream 应用于分区结果的下游收集器
     * @param <T>        输入元素的类型
     * @param <D>        下游收集器的结果类型
     * @param <A>        下游收集器的累加器类型
     * @return 产生分区Map的收集器
     */
    public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningBy(@NotNull Predicate<? super T> predicate, @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.partitioningBy(predicate, downstream);
    }


    /**
     * 返回一个收集器，该收集器根据谓词将输入元素分区到Map中
     *
     * @param predicate 用于确定元素分区的谓词
     * @param <T>       输入元素的类型
     * @return 产生分区Map的收集器
     */
    public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(@NotNull Predicate<? super T> predicate) {
        return Collectors.partitioningBy(predicate);
    }


    /**
     * 返回一个收集器，该收集器将输入元素按分类器分组到ConcurrentMap中
     *
     * @param classifier 用于分类元素的函数
     * @param mapFactory 用于创建Map的工厂函数
     * @param downstream 应用于分组结果的下游收集器
     * @param <T>        输入元素的类型
     * @param <K>        分类键的类型
     * @param <D>        下游收集器的结果类型
     * @param <A>        下游收集器的累加器类型
     * @param <M>        Map的具体类型
     * @return 产生ConcurrentMap的收集器
     */
    public static <T, K, D, A, M extends ConcurrentMap<K, D>> Collector<T, ?, M> groupingByConcurrent(@NotNull Function<? super T, ? extends K> classifier, @NotNull Supplier<M> mapFactory, @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.groupingByConcurrent(classifier, mapFactory, downstream);
    }


    /**
     * 返回一个收集器，该收集器将输入元素按分类器分组到ConcurrentMap中
     *
     * @param classifier 用于分类元素的函数
     * @param downstream 应用于分组结果的下游收集器
     * @param <T>        输入元素的类型
     * @param <K>        分类键的类型
     * @param <A>        下游收集器的累加器类型
     * @param <D>        下游收集器的结果类型
     * @return 产生ConcurrentMap的收集器
     */
    public static <T, K, A, D> Collector<T, ?, ConcurrentMap<K, D>> groupingByConcurrent(@NotNull Function<? super T, ? extends K> classifier, @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.groupingByConcurrent(classifier, downstream);
    }


    /**
     * 返回一个收集器，该收集器将输入元素按分类器分组到ConcurrentMap中
     *
     * @param classifier 用于分类元素的函数
     * @param <T>        输入元素的类型
     * @param <K>        分类键的类型
     * @return 产生ConcurrentMap的收集器
     */
    public static <T, K> Collector<T, ?, ConcurrentMap<K, List<T>>> groupingByConcurrent(@NotNull Function<? super T, ? extends K> classifier) {
        return Collectors.groupingByConcurrent(classifier);
    }


    /**
     * 返回一个收集器，该收集器将输入元素按分类器分组到Map中
     *
     * @param classifier 用于分类元素的函数
     * @param mapFactory 用于创建Map的工厂函数
     * @param downstream 应用于分组结果的下游收集器
     * @param <T>        输入元素的类型
     * @param <K>        分类键的类型
     * @param <D>        下游收集器的结果类型
     * @param <A>        下游收集器的累加器类型
     * @param <M>        Map的具体类型
     * @return 产生Map的收集器
     */
    public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> groupingBy(@NotNull Function<? super T, ? extends K> classifier, @NotNull Supplier<M> mapFactory, @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.groupingBy(classifier, mapFactory, downstream);
    }


    /**
     * 返回一个收集器，该收集器将输入元素按分类器分组到Map中
     *
     * @param classifier 用于分类元素的函数
     * @param downstream 应用于分组结果的下游收集器
     * @param <T>        输入元素的类型
     * @param <K>        分类键的类型
     * @param <A>        下游收集器的累加器类型
     * @param <D>        下游收集器的结果类型
     * @return 产生Map的收集器
     */
    public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(@NotNull Function<? super T, ? extends K> classifier, @NotNull Collector<? super T, A, D> downstream) {
        return Collectors.groupingBy(classifier, downstream);
    }


    /**
     * 返回一个收集器，该收集器将输入元素按分类器分组到Map中
     *
     * @param classifier 用于分类元素的函数
     * @param <T>        输入元素的类型
     * @param <K>        分类键的类型
     * @return 产生Map的收集器
     */
    public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(@NotNull Function<? super T, ? extends K> classifier) {
        return Collectors.groupingBy(classifier);
    }


    /**
     * 返回一个收集器，该收集器执行归约操作
     *
     * @param identity 归约操作的初始值
     * @param mapper   用于将输入元素映射到中间值的函数
     * @param op       用于组合中间值的二元操作符
     * @param <T>      输入元素的类型
     * @param <U>      中间值和结果的类型
     * @return 执行归约操作的收集器
     */
    public static <T, U> Collector<T, ?, U> reducing(U identity, @NotNull Function<? super T, ? extends U> mapper, @NotNull BinaryOperator<U> op) {
        return Collectors.reducing(identity, mapper, op);
    }


    /**
     * 返回一个收集器，该收集器执行归约操作
     *
     * @param op  用于组合元素的二元操作符
     * @param <T> 输入元素的类型
     * @return 执行归约操作的收集器
     */
    public static <T> Collector<T, ?, Optional<T>> reducing(@NotNull BinaryOperator<T> op) {
        return Collectors.reducing(op);
    }


    /**
     * 返回一个收集器，该收集器执行归约操作
     *
     * @param identity 归约操作的初始值
     * @param op       用于组合元素的二元操作符
     * @param <T>      输入元素的类型
     * @return 执行归约操作的收集器
     */
    public static <T> Collector<T, ?, T> reducing(T identity, @NotNull BinaryOperator<T> op) {
        return Collectors.reducing(identity, op);
    }


    /**
     * 返回一个收集器，该收集器计算输入元素的平均值
     *
     * @param mapper 用于将输入元素映射到double值的函数
     * @param <T>    输入元素的类型
     * @return 计算平均值的收集器
     */
    public static <T> Collector<T, ?, Double> averagingDouble(@NotNull ToDoubleFunction<? super T> mapper) {
        return Collectors.averagingDouble(mapper);
    }


    /**
     * 返回一个收集器，该收集器计算输入元素的平均值
     *
     * @param mapper 用于将输入元素映射到long值的函数
     * @param <T>    输入元素的类型
     * @return 计算平均值的收集器
     */
    public static <T> Collector<T, ?, Double> averagingLong(@NotNull ToLongFunction<? super T> mapper) {
        return Collectors.averagingLong(mapper);
    }


    /**
     * 返回一个收集器，该收集器计算输入元素的平均值
     *
     * @param mapper 用于将输入元素映射到int值的函数
     * @param <T>    输入元素的类型
     * @return 计算平均值的收集器
     */
    public static <T> Collector<T, ?, Double> averagingInt(@NotNull ToIntFunction<? super T> mapper) {
        return Collectors.averagingInt(mapper);
    }


    /**
     * 返回一个收集器，该收集器计算输入元素的总和
     *
     * @param mapper 用于将输入元素映射到double值的函数
     * @param <T>    输入元素的类型
     * @return 计算总和的收集器
     */
    public static <T> Collector<T, ?, Double> summingDouble(@NotNull ToDoubleFunction<? super T> mapper) {
        return Collectors.summingDouble(mapper);
    }


    /**
     * 返回一个收集器，该收集器计算输入元素的总和
     *
     * @param mapper 用于将输入元素映射到long值的函数
     * @param <T>    输入元素的类型
     * @return 计算总和的收集器
     */
    public static <T> Collector<T, ?, Long> summingLong(@NotNull ToLongFunction<? super T> mapper) {
        return Collectors.summingLong(mapper);
    }


    /**
     * 返回一个收集器，该收集器计算输入元素的总和
     *
     * @param mapper 用于将输入元素映射到int值的函数
     * @param <T>    输入元素的类型
     * @return 计算总和的收集器
     */
    public static <T> Collector<T, ?, Integer> summingInt(@NotNull ToIntFunction<? super T> mapper) {
        return Collectors.summingInt(mapper);
    }


    /**
     * 返回一个收集器，该收集器根据比较器找到最大元素
     *
     * @param comparator 用于比较元素的比较器
     * @param <T>        输入元素的类型
     * @return 找到最大元素的收集器
     */
    public static <T> Collector<T, ?, Optional<T>> maxBy(@NotNull Comparator<? super T> comparator) {
        return Collectors.maxBy(comparator);
    }


    /**
     * 返回一个收集器，该收集器根据比较器找到最小元素
     *
     * @param comparator 用于比较元素的比较器
     * @param <T>        输入元素的类型
     * @return 找到最小元素的收集器
     */
    public static <T> Collector<T, ?, Optional<T>> minBy(@NotNull Comparator<? super T> comparator) {
        return Collectors.minBy(comparator);
    }


    /**
     * 返回一个收集器，该收集器计算输入元素的数量
     *
     * @param <T> 输入元素的类型
     * @return 计算元素数量的收集器
     */
    public static <T> Collector<T, ?, Long> counting() {
        return Collectors.counting();
    }


    /**
     * 返回一个收集器，该收集器在应用下游收集器后执行finisher转换
     *
     * @param downstream 下游收集器
     * @param finisher   在下游收集器完成后应用的finisher函数
     * @param <T>        输入元素的类型
     * @param <A>        下游收集器的累加器类型
     * @param <R>        下游收集器的结果类型
     * @param <RR>       最终结果类型
     * @return 执行转换的收集器
     */
    public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(@NotNull Collector<T, A, R> downstream, @NotNull Function<R, RR> finisher) {
        return Collectors.collectingAndThen(downstream, finisher);
    }


    /**
     * 返回一个收集器，该收集器将输入元素映射后应用下游收集器
     *
     * @param mapper     用于映射输入元素的函数
     * @param downstream 应用于映射后元素的下游收集器
     * @param <T>        输入元素的类型
     * @param <U>        映射后元素的类型
     * @param <A>        下游收集器的累加器类型
     * @param <R>        下游收集器的结果类型
     * @return 执行映射和收集的收集器
     */
    public static <T, U, A, R> Collector<T, ?, R> mapping(@NotNull Function<? super T, ? extends U> mapper, @NotNull Collector<? super U, A, R> downstream) {
        return Collectors.mapping(mapper, downstream);
    }


    /**
     * 返回一个收集器，该收集器连接输入的字符序列
     *
     * @param delimiter 分隔符
     * @param prefix    前缀
     * @param suffix    后缀
     * @return 连接字符序列的收集器
     */
    public static Collector<CharSequence, ?, String> joining(@NotNull CharSequence delimiter, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        return Collectors.joining(delimiter, prefix, suffix);
    }


    /**
     * 返回一个收集器，该收集器连接输入的字符序列
     *
     * @param delimiter 分隔符
     * @return 连接字符序列的收集器
     */
    public static Collector<CharSequence, ?, String> joining(@NotNull CharSequence delimiter) {
        return Collectors.joining(delimiter);
    }


    /**
     * 返回一个收集器，该收集器连接输入的字符序列
     *
     * @return 连接字符序列的收集器
     */
    public static Collector<CharSequence, ?, String> joining() {
        return Collectors.joining();
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到Set中
     *
     * @param <T> 输入元素的类型
     * @return 产生Set的收集器
     */
    public static <T> Collector<T, ?, Set<T>> toSet() {
        return Collectors.toSet();
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到List中
     *
     * @param <T> 输入元素的类型
     * @return 产生List的收集器
     */
    public static <T> Collector<T, ?, List<T>> toList() {
        return Collectors.toList();
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到指定类型的集合中
     *
     * @param collectionFactory 用于创建集合的工厂函数
     * @param <T>               输入元素的类型
     * @param <C>               目标集合的具体类型
     * @return 产生指定类型集合的收集器
     */
    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(@NotNull Supplier<C> collectionFactory) {
        return Collectors.toCollection(collectionFactory);
    }


    /**
     * 返回一个收集器，该收集器将输入元素累积到Map中，键由keyMapper提供，值为元素本身
     *
     * @param keyMapper 用于产生键的映射函数
     * @param <T>       输入元素的类型
     * @param <K>       键的类型
     * @return 产生Map的收集器
     */
    public static <T, K> Collector<T, ?, Map<K, T>> toMap(Function<? super T, ? extends K> keyMapper) {
        return toMap(keyMapper, Function.identity());
    }


    /**
     * 返回一个收集器，该收集器将Map.Entry类型的输入元素累积到Map中
     *
     * @param <T> 输入元素的类型（必须是Map.Entry）
     * @param <K> 键的类型
     * @param <V> 值的类型
     * @return 产生Map的收集器
     */
    public static <T extends Map.Entry<K, V>, K, V> Collector<T, ?, Map<K, V>> toMap() {
        return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
    }

    /**
     * 对流中的每个元素应用过滤条件
     *
     * @param predicate 用于测试元素是否满足条件的谓词
     * @return 过滤后的SuperStream实例
     */
    public SuperStream<T> filter(Predicate<? super T> predicate) {
        return SuperStream.of(stream.filter(predicate));
    }

    /**
     * 使用指定的收集器对流进行收集操作
     *
     * @param collector 用于收集元素的收集器
     * @param <R>       收集结果的类型
     * @param <A>       收集器累加器的类型
     * @return 收集操作的结果
     */
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return stream.collect(collector);
    }

    /**
     * 获取流的Spliterator
     *
     * @return 流的Spliterator实例
     */
    @NotNull
    public Spliterator<T> spliterator() {
        return stream.spliterator();
    }

    /**
     * 将每个元素映射为IntStream并展平结果
     *
     * @param mapper 用于将元素映射为IntStream的函数
     * @return 展平后的IntStream
     */
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return stream.flatMapToInt(mapper);
    }

    /**
     * 检查流是否为并行流
     *
     * @return 如果流是并行的则返回true，否则返回false
     */
    public boolean isParallel() {
        return stream.isParallel();
    }

    /**
     * 获取流的迭代器
     *
     * @return 流的Iterator实例
     */
    @NotNull
    public Iterator<T> iterator() {
        return stream.iterator();
    }

    /**
     * 对流中的每个元素执行指定的动作
     *
     * @param action 要执行的动作函数
     */
    public void forEach(P1Function<? super T> action) {
        stream.forEach(action::call);
    }

    /**
     * 对流中的每个元素执行指定的动作，并传递索引
     *
     * @param action 要执行的动作函数，接收元素和索引作为参数
     */
    public void forEach(P2Function<? super T, Integer> action) {
        AtomicInteger i22 = new AtomicInteger(0);
        stream.forEach(i -> {
            action.call(i, i22.getAndAdd(1));
        });
    }

    /**
     * 对流中的每个元素执行指定的动作
     *
     * @param action 要执行的动作函数
     */
    public void forEach(Consumer<? super T> action) {
        stream.forEach(action);
    }

    /**
     * 将每个元素映射为Stream并展平结果
     *
     * @param mapper 用于将元素映射为Stream的函数
     * @param <R>    映射后元素的类型
     * @return 展平后的Stream实例
     */
    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return stream.flatMap(mapper);
    }

    /**
     * 返回一个串行流
     *
     * @return 串行的SuperStream实例
     */
    @NotNull
    public SuperStream<T> sequential() {
        return SuperStream.of(stream.sequential());
    }

    /**
     * 跳过指定数量的元素
     *
     * @param n 要跳过的元素数量
     * @return 跳过元素后的SuperStream实例
     */
    public SuperStream<T> skip(long n) {
        return SuperStream.of(stream.skip(n));
    }

    /**
     * 使用指定的收集器对流进行收集操作
     *
     * @param supplier    用于创建初始累加器的供应函数
     * @param accumulator 用于将元素添加到累加器的操作
     * @param combiner    用于合并两个累加器的操作
     * @param <R>         收集结果的类型
     * @return 收集操作的结果
     */
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return stream.collect(supplier, accumulator, combiner);
    }

    /**
     * 返回一个并行流
     *
     * @return 并行的SuperStream实例
     */
    @NotNull
    public SuperStream<T> parallel() {
        return SuperStream.of(stream.parallel());
    }

    /**
     * 将每个元素映射为DoubleStream并展平结果
     *
     * @param mapper 用于将元素映射为DoubleStream的函数
     * @return 展平后的DoubleStream
     */
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return stream.flatMapToDouble(mapper);
    }

    /**
     * 将流转换为指定类型的数组
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
     * 查找流中的第一个元素
     *
     * @return 包含第一个元素的Optional，如果流为空则返回空Optional
     */
    @NotNull
    public Optional<T> findFirst() {
        return stream.findFirst();
    }

    /**
     * 返回一个无序流
     *
     * @return 无序的SuperStream实例
     */
    @NotNull
    public SuperStream<T> unordered() {
        return SuperStream.of(stream.unordered());
    }

    /**
     * 根据比较器查找流中的最小元素
     *
     * @param comparator 用于比较元素的比较器
     * @return 包含最小元素的Optional，如果流为空则返回空Optional
     */
    @NotNull
    public Optional<T> min(Comparator<? super T> comparator) {
        return stream.min(comparator);
    }

    /**
     * 查找流中的任意元素
     *
     * @return 包含任意元素的Optional，如果流为空则返回空Optional
     */
    @NotNull
    public Optional<T> findAny() {
        return stream.findAny();
    }

    /**
     * 注册一个关闭处理器，在流关闭时执行
     *
     * @param closeHandler 关闭时要执行的Runnable
     * @return 添加了关闭处理器的SuperStream实例
     */
    @NotNull
    public SuperStream<T> onClose(@NotNull Runnable closeHandler) {
        return SuperStream.of(stream.onClose(closeHandler));
    }

    /**
     * 将每个元素映射为LongStream并展平结果
     *
     * @param mapper 用于将元素映射为LongStream的函数
     * @return 展平后的LongStream
     */
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return stream.flatMapToLong(mapper);
    }

    /**
     * 将流转换为指定类型的数组
     *
     * @param clazz 数组元素的Class对象
     * @return 转换后的数组
     */
    @NotNull
    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz) {
        return stream.toArray(i -> (T[]) Array.newInstance(clazz, i));
    }

    /**
     * 将流转换为Object数组
     *
     * @return 转换后的Object数组
     */
    @NotNull
    public Object[] toArray() {
        return stream.toArray();
    }

    /**
     * 按顺序对流中的每个元素执行指定的动作
     *
     * @param action 要执行的动作函数
     */
    public void forEachOrdered(Consumer<? super T> action) {
        stream.forEachOrdered(action);
    }

    /**
     * 关闭流并释放相关资源
     */
    public void close() {
        stream.close();
    }

    /**
     * 对流执行归约操作
     *
     * @param accumulator 用于组合元素的二元操作符
     * @return 归约操作的结果，如果流为空则返回空Optional
     */
    @NotNull
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return stream.reduce(accumulator);
    }

    /**
     * 返回一个根据指定比较器排序的流
     *
     * @param comparator 用于比较元素的比较器
     * @return 排序后的SuperStream实例
     */
    public SuperStream<T> sorted(Comparator<? super T> comparator) {
        return SuperStream.of(stream.sorted(comparator));
    }

    /**
     * 检查流中的所有元素是否都满足给定的谓词
     *
     * @param predicate 用于测试元素的谓词
     * @return 如果所有元素都满足谓词或流为空则返回true，否则返回false
     */
    public boolean allMatch(Predicate<? super T> predicate) {
        return stream.allMatch(predicate);
    }

    /**
     * 返回一个自然排序的流
     *
     * @return 排序后的SuperStream实例
     */
    public SuperStream<T> sorted() {
        return SuperStream.of(stream.sorted());
    }

    /**
     * 计算流中元素的数量
     *
     * @return 流中元素的数量
     */
    public long count() {
        return stream.count();
    }

    /**
     * 将流中的每个元素通过映射函数转换
     *
     * @param mapper 用于转换元素的映射函数
     * @param <R>    映射后元素的类型
     * @return 转换后的SuperStream实例
     */
    public <R> SuperStream<R> map(Function<? super T, ? extends R> mapper) {
        return SuperStream.of(stream.map(mapper));
    }

    /**
     * 对流执行归约操作
     *
     * @param identity    归约操作的初始值
     * @param accumulator 用于组合元素的二元操作符
     * @return 归约操作的结果
     */
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return stream.reduce(identity, accumulator);
    }

    /**
     * 检查流中的所有元素都不满足给定的谓词
     *
     * @param predicate 用于测试元素的谓词
     * @return 如果所有元素都不满足谓词则返回true，否则返回false
     */
    public boolean noneMatch(Predicate<? super T> predicate) {
        return stream.noneMatch(predicate);
    }

    /**
     * 返回一个去重后的流
     *
     * @return 去重后的SuperStream实例
     */
    public SuperStream<T> distinct() {
        return SuperStream.of(stream.distinct());
    }

    /**
     * 根据比较器查找流中的最大元素
     *
     * @param comparator 用于比较元素的比较器
     * @return 包含最大元素的Optional，如果流为空则返回空Optional
     */
    @NotNull
    public Optional<T> max(Comparator<? super T> comparator) {
        return stream.max(comparator);
    }

    /**
     * 将流中的每个元素映射为double值
     *
     * @param mapper 用于映射元素为double值的函数
     * @return 映射后的DoubleStream
     */
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return stream.mapToDouble(mapper);
    }

    /**
     * 限制流中元素的数量
     *
     * @param maxSize 最大元素数量
     * @return 限制后的SuperStream实例
     */
    public SuperStream<T> limit(long maxSize) {
        return SuperStream.of(stream.limit(maxSize));
    }

    /**
     * 将流中的每个元素映射为long值
     *
     * @param mapper 用于映射元素为long值的函数
     * @return 映射后的LongStream
     */
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return stream.mapToLong(mapper);
    }

    /**
     * 对流中的每个元素执行动作，然后返回原流
     *
     * @param action 要执行的动作函数
     * @return 原始的SuperStream实例
     */
    public SuperStream<T> peek(Consumer<? super T> action) {
        return SuperStream.of(stream.peek(action));
    }

    /**
     * 对流执行归约操作
     *
     * @param identity    归约操作的初始值
     * @param accumulator 用于组合元素的二元操作符
     * @param combiner    用于合并累加器的二元操作符
     * @param <U>         累加器和结果的类型
     * @return 归约操作的结果
     */
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return stream.reduce(identity, accumulator, combiner);
    }

    /**
     * 将流中的每个元素映射为int值
     *
     * @param mapper 用于映射元素为int值的函数
     * @return 映射后的IntStream
     */
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return stream.mapToInt(mapper);
    }

    /**
     * 检查流中是否有任何元素满足给定的谓词
     *
     * @param predicate 用于测试元素的谓词
     * @return 如果有任何元素满足谓词则返回true，否则返回false
     */
    public boolean anyMatch(Predicate<? super T> predicate) {
        return stream.anyMatch(predicate);
    }

    /**
     * 获取被包装的基础Stream对象
     *
     * @return 基础Stream对象
     */
    public Stream<T> getStream() {
        return stream;
    }

    /**
     * 将流中的元素收集到Map中，使用指定的键和值映射函数
     *
     * @param keyMapper   用于生成键的映射函数
     * @param valueMapper 用于生成值的映射函数
     * @param <K>         键的类型
     * @param <V>         值的类型
     * @return 包含映射结果的Map
     */
    public <K, V> Map<K, V> toAMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return collect(toMap(keyMapper, valueMapper));
    }

    /**
     * 将流中的元素收集到Map中，使用指定的键映射函数，值为元素本身
     *
     * @param keyMapper 用于生成键的映射函数
     * @param <K>       键的类型
     * @return 包含映射结果的Map
     */
    public <K> Map<K, T> toAMap(Function<? super T, ? extends K> keyMapper) {
        return collect(toMap(keyMapper));
    }

    /**
     * 将流中的元素收集到List中
     *
     * @return 包含流中所有元素的List
     */
    public List<T> toAList() {
        return collect(toList());
    }

}
