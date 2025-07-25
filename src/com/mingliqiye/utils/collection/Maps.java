package com.mingliqiye.utils.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Maps工具类提供了一系列创建Map实现的便捷方法。
 *
 * @author MingLiPro
 */
public class Maps {

    /**
     * 创建一个空的HashMap实例。
     *
     * @param <K> Map键的类型
     * @param <V> Map值的类型
     * @return 新创建的空HashMap实例
     */
    public static <K, V> Map<K, V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 创建一个指定初始容量的空HashMap实例。
     *
     * @param size 初始容量大小
     * @param <K>  Map键的类型
     * @param <V>  Map值的类型
     * @return 指定初始容量的空HashMap实例
     */
    public static <K, V> Map<K, V> newHashMap(int size) {
        return new HashMap<>(size);
    }

    /**
     * 根据已有Map创建一个新的HashMap实例。
     *
     * @param map 要复制的Map
     * @param <K> Map键的类型
     * @param <V> Map值的类型
     * @return 包含原Map所有元素的新HashMap实例
     */
    public static <K, V> Map<K, V> newHashMap(Map<K, V> map) {
        Map<K, V> newMap = newHashMap();
        newMap.putAll(map);
        return newMap;
    }

    /**
     * 创建一个空的LinkedHashMap实例。
     *
     * @param <K> Map键的类型
     * @param <V> Map值的类型
     * @return 新创建的空LinkedHashMap实例
     */
    public static <K, V> Map<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    /**
     * 创建一个指定初始容量的空LinkedHashMap实例。
     *
     * @param size 初始容量大小
     * @param <K>  Map键的类型
     * @param <V>  Map值的类型
     * @return 指定初始容量的空LinkedHashMap实例
     */
    public static <K, V> Map<K, V> newLinkedHashMap(int size) {
        return new LinkedHashMap<>(size);
    }

    /**
     * 根据已有Map创建一个新的LinkedHashMap实例。
     *
     * @param map 要复制的Map
     * @param <K> Map键的类型
     * @param <V> Map值的类型
     * @return 包含原Map所有元素的新LinkedHashMap实例
     */
    public static <K, V> Map<K, V> newLinkedHashMap(Map<K, V> map) {
        Map<K, V> newMap = newLinkedHashMap();
        newMap.putAll(map);
        return newMap;
    }

    /**
     * 创建一个空的TreeMap实例。
     *
     * @param <K> Map键的类型，必须实现Comparable接口
     * @param <V> Map值的类型
     * @return 新创建的空TreeMap实例
     */
    public static <K extends Comparable<K>, V> Map<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    /**
     * 根据已有Map创建一个新的TreeMap实例。
     *
     * @param map 要复制的Map
     * @param <K> Map键的类型，必须实现Comparable接口
     * @param <V> Map值的类型
     * @return 包含原Map所有元素的新TreeMap实例
     */
    public static <K extends Comparable<K>, V> Map<K, V> newTreeMap(
        Map<K, V> map
    ) {
        Map<K, V> newMap = newTreeMap();
        newMap.putAll(map);
        return newMap;
    }

    /**
     * 创建一个空的Hashtable实例。
     *
     * @param <K> Map键的类型
     * @param <V> Map值的类型
     * @return 新创建的空Hashtable实例
     */
    public static <K, V> Map<K, V> newHashtable() {
        return new Hashtable<>();
    }

    /**
     * 创建一个指定初始容量的空Hashtable实例。
     *
     * @param size 初始容量大小
     * @param <K>  Map键的类型
     * @param <V>  Map值的类型
     * @return 指定初始容量的空Hashtable实例
     */
    public static <K, V> Map<K, V> newHashtable(int size) {
        return new Hashtable<>(size);
    }

    /**
     * 根据已有Map创建一个新的Hashtable实例。
     *
     * @param map 要复制的Map
     * @param <K> Map键的类型
     * @param <V> Map值的类型
     * @return 包含原Map所有元素的新Hashtable实例
     */
    public static <K, V> Map<K, V> newHashtable(Map<K, V> map) {
        Map<K, V> newMap = newHashtable();
        newMap.putAll(map);
        return newMap;
    }

    /**
     * 创建一个空的ConcurrentHashMap实例。
     *
     * @param <K> Map键的类型
     * @param <V> Map值的类型
     * @return 新创建的空ConcurrentHashMap实例
     */
    public static <K, V> Map<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap<>();
    }

    /**
     * 创建一个指定初始容量的空ConcurrentHashMap实例。
     *
     * @param size 初始容量大小
     * @param <K>  Map键的类型
     * @param <V>  Map值的类型
     * @return 指定初始容量的空ConcurrentHashMap实例
     */
    public static <K, V> Map<K, V> newConcurrentHashMap(int size) {
        return new ConcurrentHashMap<>(size);
    }

    /**
     * 根据已有Map创建一个新的ConcurrentHashMap实例。
     *
     * @param map 要复制的Map
     * @param <K> Map键的类型
     * @param <V> Map值的类型
     * @return 包含原Map所有元素的新ConcurrentHashMap实例
     */
    public static <K, V> Map<K, V> newConcurrentHashMap(Map<K, V> map) {
        Map<K, V> newMap = newConcurrentHashMap();
        newMap.putAll(map);
        return newMap;
    }
}
