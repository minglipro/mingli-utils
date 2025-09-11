package com.mingliqiye.utils.iterator;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 范围 Range<br>
 * 类似 KT的 {@code 0..10 = Range.of(0,10)}
 * @author MingLiPro
 * @since 3.2.6
 */
@Getter
public class Range implements Iterable<Integer> {

	private final int start;
	private final int end;
	private int current;

	/**
	 * 创建一个范围 <br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param start 开始 (包含)
	 * @param end 完毕 (包含)
	 * @see Integer
	 */
	public Range(int start, int end) {
		this.start = start;
		this.current = start;
		this.end = end + 1;
	}

	/**
	 * 创建一个范围  {@code 0 - range}<br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param range 完毕 (包含)
	 * @see Integer
	 */
	public Range(int range) {
		this(0, range);
	}

	/**
	 * 创建一个范围  {@code 0 - range}<br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param range 完毕 (包含)
	 * @see Integer
	 * @return Range 对象
	 */
	public static Range of(int range) {
		return new Range(range);
	}

	/**
	 * 创建一个范围 <br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param start 开始 (包含)
	 * @param end 完毕 (包含)
	 * @see Integer
	 * @return Range 对象
	 */
	public static Range of(int start, int end) {
		return new Range(start, end);
	}

	/**
	 * 创建一个范围  {@code 0 - range}<br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param range 完毕 (包含)
	 * @see Integer
	 * @return Range 对象
	 */
	public static Range range(int range) {
		return new Range(range);
	}

	/**
	 * 创建一个范围 <br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param start 开始 (包含)
	 * @param end 完毕 (包含)
	 * @see Integer
	 * @return Range 对象
	 */
	public static Range range(int start, int end) {
		return new Range(start, end);
	}

	/**
	 * 获取迭代器
	 * @return 迭代器
	 */
	@Override
	public @NotNull Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return current < end;
			}

			@Override
			public Integer next() {
				if (current >= end) {
					return null;
				}
				return current++;
			}
		};
	}
}
