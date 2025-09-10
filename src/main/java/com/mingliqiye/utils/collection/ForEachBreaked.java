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
 * CurrentFile ForEach.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.collection;

import com.mingliqiye.utils.functions.P1RFunction;
import com.mingliqiye.utils.functions.P2RFunction;
import com.mingliqiye.utils.functions.P3RFunction;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

/**
 * ForEachBreaked 工具类提供对集合和映射的增强遍历功能，支持在遍历过程中中断操作。
 * 包含多个重载的 forEach 方法，支持带索引的遍历操作，并且可以在满足条件时提前终止遍历。
 * <br>
 *
 * <p>
 * return null; // 提前下一次遍历 = continue;
 * <p>
 * return true; // 提前终止遍历 = break;
 * <p>
 * return false; // 继续下一次遍历
 *
 * @author MingLiPro
 * @since 3.0.4
 */
public class ForEachBreaked {

    /**
     * 对给定的集合执行指定的操作，操作包含元素值和索引。
     * 根据集合类型选择最优的遍历方式以提高性能。
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param collection 要遍历的集合，可以是 List 或其他 Collection 实现
     * @param action     要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param <T>        集合中元素的类型
     */
    public static <T> void forEach(Collection<T> collection, P2RFunction<? super T, Integer, Boolean> action) {
        // 参数校验：如果集合或操作为空，则直接返回
        if (collection == null || action == null) {
            return;
        }

        // 如果集合实现了 RandomAccess 接口（如 ArrayList），使用索引访问优化性能
        if (collection instanceof RandomAccess && collection instanceof List) {
            List<T> list = (List<T>) collection;
            for (int i = 0; i < list.size(); i++) {
                if (action.call(list.get(i), i)) return;
            }
        }
        // 如果是普通 List，使用迭代器遍历并手动维护索引
        else if (collection instanceof List) {
            int index = 0;
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (action.call(it.next(), index)) return;
                index++;
            }
        }
        // 其他类型的集合使用增强 for 循环，并手动维护索引
        else {
            int index = 0;
            for (T element : collection) {
                if (action.call(element, index)) return;
                index++;
            }
        }
    }

    /**
     * 对给定的集合执行指定的操作，仅处理元素值。
     * 根据集合是否实现 RandomAccess 接口选择最优的遍历方式。
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param collection 要遍历的集合
     * @param action     要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param <T>        集合中元素的类型
     */
    public static <T> void forEach(Collection<T> collection, P1RFunction<? super T, Boolean> action) {
        // 参数校验：如果集合或操作为空，则直接返回
        if (collection == null || action == null) {
            return;
        }

        // 如果集合实现了 RandomAccess 接口，使用索引访问提升性能
        if (collection instanceof RandomAccess) {
            List<T> list = (List<T>) collection;
            for (int i = 0; i < list.size(); i++) {
                if (action.call(list.get(i))) return;
            }
        }
        // 否则使用增强 for 循环进行遍历
        else {
            for (T element : collection) {
                if (action.call(element)) return;
            }
        }
    }

    /**
     * 对给定的映射执行指定的操作，操作包含键、值和索引。
     * 根据映射类型选择不同的遍历策略。
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param map    要遍历的映射
     * @param action 要对每个键值对执行的操作，接收键、值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param <K>    映射中键的类型
     * @param <V>    映射中值的类型
     */
    public static <K, V> void forEach(Map<K, V> map, P3RFunction<? super K, ? super V, Integer, Boolean> action) {
        // 参数校验：如果映射或操作为空，则直接返回
        if (map == null || action == null) {
            return;
        }

        // 遍历 TreeMap 的条目集合并传递索引
        if (map instanceof TreeMap) {
            int index = 0;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (action.call(entry.getKey(), entry.getValue(), index)) return;
                index++;
            }
        }
        // 遍历 ConcurrentMap 或 LinkedHashMap 的条目集合并传递索引
        else if (map instanceof ConcurrentMap || map instanceof LinkedHashMap) {
            int index = 0;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (action.call(entry.getKey(), entry.getValue(), index)) return;
                index++;
            }
        }
        // 遍历其他类型映射的条目集合并传递索引
        else {
            int index = 0;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (action.call(entry.getKey(), entry.getValue(), index)) return;
                index++;
            }
        }
    }

    /**
     * 对给定的映射执行指定的操作，仅处理键和值。
     * 根据映射类型选择不同的遍历策略。
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param map    要遍历的映射
     * @param action 要对每个键值对执行的操作，接收键和值作为参数，返回 Boolean 值决定是否继续遍历
     * @param <K>    映射中键的类型
     * @param <V>    映射中值的类型
     */
    public static <K, V> void forEach(Map<K, V> map, P2RFunction<? super K, ? super V, Boolean> action) {
        // 参数校验：如果映射或操作为空，则直接返回
        if (map == null || action == null) {
            return;
        }

        // 遍历 TreeMap 的条目集合
        if (map instanceof TreeMap) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (action.call(entry.getKey(), entry.getValue())) return;
            }
        }
        // 如果是 ConcurrentMap 或 LinkedHashMap，使用其内置的 forEach 方法
        else if (map instanceof ConcurrentMap || map instanceof LinkedHashMap) {
            forEach(map.entrySet(), (i) -> {
                if (action.call(i.getKey(), i.getValue())) return true;
                return false;
            });
        }
        // 遍历其他类型映射的条目集合
        else {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (action.call(entry.getKey(), entry.getValue())) return;
            }
        }
    }

    /**
     * 对可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的可变参数数组
     * @param <T>     数组中元素的类型
     */
    public static <T> void forEach(P2RFunction<? super T, Integer, Boolean> action, T... objects) {
        forEach(Lists.newArrayList(objects), action);
    }

    /**
     * 对数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param <T>     数组中元素的类型
     */
    public static <T> void forEach(T[] objects, P2RFunction<? super T, Integer, Boolean> action) {
        forEach(action, objects);
    }

    /**
     * 对数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的数组
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param <T>     数组中元素的类型
     */
    public static <T> void forEach(T[] objects, P1RFunction<? super T, Boolean> action) {
        forEach(action, objects);
    }

    /**
     * 对可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的可变参数数组
     * @param <T>     数组中元素的类型
     */
    public static <T> void forEach(P1RFunction<? super T, Boolean> action, T... objects) {
        forEach(Lists.toList(objects), (t, i) -> {
            if (action.call(t)) return true;
            return false;
        });
    }

    /**
     * 对整型数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的整型数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     */
    public static void forEach(int[] objects, P2RFunction<Integer, Integer, Boolean> action) {
        forEach(action, objects);
    }

    /**
     * 对整型可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的整型可变参数数组
     */
    private static void forEach(P2RFunction<Integer, Integer, Boolean> action, int... objects) {
        forEach(objects, action);
    }

    /**
     * 对整型可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的整型可变参数数组
     */
    private static void forEach(P1RFunction<Integer, Boolean> action, int... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对字节数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的字节数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     */
    public static void forEach(byte[] objects, P2RFunction<Byte, Integer, Boolean> action) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对字节可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的字节可变参数数组
     */
    private static void forEach(P2RFunction<Byte, Integer, Boolean> action, byte... objects) {
        forEach(objects, action);
    }

    /**
     * 对字节可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的字节可变参数数组
     */
    private static void forEach(P1RFunction<Byte, Boolean> action, byte... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对短整型数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的短整型数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     */
    public static void forEach(short[] objects, P2RFunction<Short, Integer, Boolean> action) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对短整型可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的短整型可变参数数组
     */
    private static void forEach(P2RFunction<Short, Integer, Boolean> action, short... objects) {
        forEach(objects, action);
    }

    /**
     * 对短整型可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的短整型可变参数数组
     */
    private static void forEach(P1RFunction<Short, Boolean> action, short... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对长整型数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的长整型数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     */
    public static void forEach(long[] objects, P2RFunction<Long, Integer, Boolean> action) {
        forEach(action, objects);
    }

    /**
     * 对长整型可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的长整型可变参数数组
     */
    private static void forEach(P2RFunction<Long, Integer, Boolean> action, long... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对长整型可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的长整型可变参数数组
     */
    private static void forEach(P1RFunction<Long, Boolean> action, long... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对浮点数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的浮点数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     */
    public static void forEach(float[] objects, P2RFunction<Float, Integer, Boolean> action) {
        forEach(action, objects);
    }

    /**
     * 对浮点可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的浮点可变参数数组
     */
    private static void forEach(P2RFunction<Float, Integer, Boolean> action, float... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对浮点可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的浮点可变参数数组
     */
    private static void forEach(P1RFunction<Float, Boolean> action, float... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对双精度浮点数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的双精度浮点数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     */
    public static void forEach(double[] objects, P2RFunction<Double, Integer, Boolean> action) {
        forEach(action, objects);
    }

    /**
     * 对双精度浮点可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的双精度浮点可变参数数组
     */
    private static void forEach(P2RFunction<Double, Integer, Boolean> action, double... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对双精度浮点可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的双精度浮点可变参数数组
     */
    private static void forEach(P1RFunction<Double, Boolean> action, double... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对字符数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的字符数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     */
    public static void forEach(char[] objects, P2RFunction<Character, Integer, Boolean> action) {
        forEach(action, objects);
    }

    /**
     * 对字符可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的字符可变参数数组
     */
    private static void forEach(P2RFunction<Character, Integer, Boolean> action, char... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对字符可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的字符可变参数数组
     */
    private static void forEach(P1RFunction<Character, Boolean> action, char... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对布尔数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param objects 要遍历的布尔数组
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     */
    public static void forEach(boolean[] objects, P2RFunction<Character, Integer, Boolean> action) {
        forEach(objects, action);
    }

    /**
     * 对布尔可变参数数组执行指定的操作，操作包含元素值和索引
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，接收元素值和索引作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的布尔可变参数数组
     */
    private static void forEach(P2RFunction<Boolean, Integer, Boolean> action, boolean... objects) {
        forEach(Lists.toList(objects), action);
    }

    /**
     * 对布尔可变参数数组执行指定的操作，仅处理元素值
     * 当操作返回 true 时，遍历将提前终止。
     *
     * @param action  要对每个元素执行的操作，只接收元素值作为参数，返回 Boolean 值决定是否继续遍历
     * @param objects 要遍历的布尔可变参数数组
     */
    private static void forEach(P1RFunction<Boolean, Boolean> action, boolean... objects) {
        forEach(Lists.toList(objects), action);
    }

}
