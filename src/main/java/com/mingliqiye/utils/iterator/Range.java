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
 * CurrentFile Range.java
 * LastUpdate 2025-09-14 20:23:26
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.iterator;

import kotlin.ranges.ClosedRange;
import kotlin.ranges.OpenEndRange;
import lombok.Getter;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 范围 Range<br>
 * Iterable 可遍历对象<br>
 * 类似 KT的 {@code 0..10 = Range.of(0,10)} {@code 0..10 step 2 = Range.of(0,10,2)}
 * @author MingLiPro
 * @since 3.2.6
 */
@Getter
public class Range
	implements Iterable<Integer>, ClosedRange<Integer>, OpenEndRange<Integer> {

	private final int start;
	private final int end;
	private final int step;
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
		this(start, end, 1);
	}

	/**
	 * 创建一个范围 <br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param start 开始 (包含)
	 * @param end 完毕 (包含)
	 * @param step 步长
	 * @see Integer
	 */
	public Range(int start, int end, int step) {
		this.start = start;
		this.current = start;
		this.step = step;
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
	 * 创建一个范围 <br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param start 开始 (包含)
	 * @param end 完毕 (包含)
	 * @param step 步长
	 * @see Integer
	 */
	public static Range of(int start, int end, int step) {
		return new Range(start, end, step);
	}

	/**
	 * 创建一个范围 <br>
	 * 最大值{@code Integer.MAX_VALUE = 2147483647 } <br>
	 * 最小值{@code Integer.MIN_VALUE = -2147483648} <br>
	 * @param start 开始 (包含)
	 * @param end 完毕 (包含)
	 * @param step 步长
	 * @see Integer
	 */
	public static Range range(int start, int end, int step) {
		return new Range(start, end, step);
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

				try {
					return current;
				} finally {
					current = current + step;
				}
			}
		};
	}

	@Override
	public boolean isEmpty() {
		return current < end;
	}

	@Override
	public @NotNull Integer getEndInclusive() {
		val va = end - step;
		return Math.max(va, 0);
	}

	@Override
	public boolean contains(@NotNull Integer integer) {
		if (step == 0) return false;
		if (step > 0) {
			if (integer < start || integer > end) return false;
		} else {
			if (integer > start || integer < end) return false;
		}
		return (integer - start) % step == 0;
	}

	@Override
	public @NotNull Integer getEndExclusive() {
		return end;
	}
	@Override
	public @NotNull Integer getStart() {
		return start;
	}
}
