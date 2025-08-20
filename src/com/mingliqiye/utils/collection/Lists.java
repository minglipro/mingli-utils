package com.mingliqiye.utils.collection;

import java.util.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Lists工具类提供了一系列创建List实现的便捷方法。
 *
 * @author MingLiPro
 */
public class Lists {

	/**
	 * 创建一个空的ArrayList实例。
	 *
	 * @param <T> 列表元素的类型
	 * @return 新创建的空ArrayList实例
	 */
	public static <T> List<T> newArrayList() {
		return new ArrayList<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的ArrayList实例。
	 *
	 * @param ts  要添加到列表中的元素，可以为0个或多个
	 * @param <T> 列表元素的类型
	 * @return 包含指定元素的新ArrayList实例
	 */
	public static <T> List<T> newArrayList(T... ts) {
		List<T> list = newArrayList();
		list.addAll(Arrays.asList(ts));
		return list;
	}

	/**
	 * 根据已有列表创建一个新的ArrayList实例。
	 *
	 * @param list 要复制的列表
	 * @param <T>  列表元素的类型
	 * @return 包含原列表所有元素的新ArrayList实例
	 */
	public static <T> List<T> newArrayList(List<T> list) {
		List<T> newList = newArrayList();
		newList.addAll(list);
		return newList;
	}

	/**
	 * 根据可迭代对象创建一个ArrayList实例。
	 *
	 * @param iterable 可迭代对象
	 * @param <T>      列表元素的类型
	 * @return 包含可迭代对象中所有元素的新ArrayList实例
	 */
	public static <T> List<T> newArrayList(Iterable<T> iterable) {
		List<T> list = newArrayList();
		for (T t : iterable) {
			list.add(t);
		}
		return list;
	}

	/**
	 * 创建一个指定初始容量的空ArrayList实例。
	 *
	 * @param size 初始容量大小
	 * @param <T>  列表元素的类型
	 * @return 指定初始容量的空ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size) {
		return new ArrayList<>(size);
	}

	/**
	 * 创建一个指定大小并用单个元素填充的ArrayList实例。
	 *
	 * @param size 列表大小
	 * @param t    用于填充列表的元素
	 * @param <T>  列表元素的类型
	 * @return 指定大小且所有元素都相同的ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size, T t) {
		List<T> list = newArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(t);
		}
		return list;
	}

	/**
	 * 创建一个指定大小并交替使用两个元素填充的ArrayList实例。
	 *
	 * @param size 列表大小
	 * @param t    第一个填充元素（索引为偶数时使用）
	 * @param t1   第二个填充元素（索引为奇数时使用）
	 * @param <T>  列表元素的类型
	 * @return 指定大小且交替填充两个元素的ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size, T t, T t1) {
		List<T> list = newArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(i % 2 == 0 ? t : t1);
		}
		return list;
	}

	/**
	 * 创建一个指定大小并循环使用三个元素填充的ArrayList实例。
	 *
	 * @param size 列表大小
	 * @param t    第一个填充元素（索引模3等于0时使用）
	 * @param t1   第二个填充元素（索引模3等于1时使用）
	 * @param t2   第三个填充元素（索引模3等于2时使用）
	 * @param <T>  列表元素的类型
	 * @return 指定大小且循环填充三个元素的ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size, T t, T t1, T t2) {
		List<T> list = newArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(i % 3 == 0 ? t : i % 3 == 1 ? t1 : t2);
		}
		return list;
	}

	/**
	 * 创建一个指定大小并循环使用四个元素填充的ArrayList实例。
	 *
	 * @param size 列表大小
	 * @param t    第一个填充元素（索引模4等于0时使用）
	 * @param t1   第二个填充元素（索引模4等于1时使用）
	 * @param t2   第三个填充元素（索引模4等于2时使用）
	 * @param t3   第四个填充元素（索引模4等于3时使用）
	 * @param <T>  列表元素的类型
	 * @return 指定大小且循环填充四个元素的ArrayList实例
	 */
	public static <T> List<T> newArrayList(int size, T t, T t1, T t2, T t3) {
		List<T> list = newArrayList(size);
		for (int i = 0; i < size; i++) {
			list.add(i % 4 == 0 ? t : i % 4 == 1 ? t1 : i % 4 == 2 ? t2 : t3);
		}
		return list;
	}

	/**
	 * 创建一个空的LinkedList实例。
	 *
	 * @param <T> 列表元素的类型
	 * @return 新创建的空LinkedList实例
	 */
	public static <T> List<T> newLinkedList() {
		return new LinkedList<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的LinkedList实例。
	 *
	 * @param ts  要添加到列表中的元素，可以为0个或多个
	 * @param <T> 列表元素的类型
	 * @return 包含指定元素的新LinkedList实例
	 */
	public static <T> List<T> newLinkedList(T... ts) {
		List<T> list = newLinkedList();
		list.addAll(Arrays.asList(ts));
		return list;
	}

	/**
	 * 根据已有列表创建一个新的LinkedList实例。
	 *
	 * @param list 要复制的列表
	 * @param <T>  列表元素的类型
	 * @return 包含原列表所有元素的新LinkedList实例
	 */
	public static <T> List<T> newLinkedList(List<T> list) {
		List<T> newList = newLinkedList();
		newList.addAll(list);
		return newList;
	}

	/**
	 * 创建一个空的Vector实例。
	 *
	 * @param <T> 列表元素的类型
	 * @return 新创建的空Vector实例
	 */
	public static <T> List<T> newVector() {
		return new Vector<>();
	}

	/**
	 * 根据可变参数创建一个包含指定元素的Vector实例。
	 *
	 * @param ts  要添加到列表中的元素，可以为0个或多个
	 * @param <T> 列表元素的类型
	 * @return 包含指定元素的新Vector实例
	 */
	public static <T> List<T> newVector(T... ts) {
		List<T> list = newVector();
		list.addAll(Arrays.asList(ts));
		return list;
	}

	/**
	 * 根据已有列表创建一个新的Vector实例。
	 *
	 * @param list 要复制的列表
	 * @param <T>  列表元素的类型
	 * @return 包含原列表所有元素的新Vector实例
	 */
	public static <T> List<T> newVector(List<T> list) {
		List<T> newList = newVector();
		newList.addAll(list);
		return newList;
	}

	/**
	 * 将指定列表中的每个元素转换为字符串表示形式
	 *
	 * @param <T>  列表元素的类型
	 * @param list 要转换的列表，不能为空
	 * @return 包含原列表各元素字符串表示的新列表，保持相同的顺序
	 */
	public static <T> List<String> toStringList(@NotNull List<T> list) {
		// 创建与原列表相同大小的新列表，用于存储字符串转换结果
		List<String> newList = newArrayList(list.size());
		for (T t : list) {
			newList.add(t == null ? "null" : t.toString());
		}
		return newList;
	}

	/**
	 * 将指定数组中的每个元素转换为字符串表示形式
	 *
	 * @param <T>  数组元素的类型
	 * @param list 要转换的数组，不能为空
	 * @return 包含原数组各元素字符串表示的新字符串数组
	 */
	public static <T> String[] toStringList(@NotNull T[] list) {
		// 创建新的字符串列表，用于存储转换后的结果
		List<String> newList = newArrayList(list.length);
		for (T t : list) {
			newList.add(t == null ? "null" : t.toString());
		}
		return newList.toArray(new String[0]);
	}

	@Nullable
	public static <T> T[] toArray(List<T> ts) {
		if (ts == null) {
			return null;
		}
		T[] items = (T[]) new Object[ts.size()];
		ForEach.forEach(ts, (t, i) -> {
			items[i] = t;
		});
		return items;
	}
}
