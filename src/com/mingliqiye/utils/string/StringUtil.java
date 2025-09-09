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
 * CurrentFile StringUtil.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.string;

import com.mingliqiye.utils.callback.P1RFunction;
import com.mingliqiye.utils.collection.Lists;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串工具类，提供常用的字符串处理方法
 */
public class StringUtil {

	/**
	 * 将对象转换为字符串表示形式
	 *
	 * @param obj 需要转换的对象，可以为null
	 * @return 如果对象为null则返回空字符串，否则返回对象的字符串表示
	 */
	public static String toString(Object obj) {
		// 如果对象为null，返回空字符串；否则调用对象的toString方法
		return obj == null ? "" : obj.toString();
	}

	/**
	 * 格式化字符串，将格式字符串中的占位符{}替换为对应的参数值<br>
	 * 示例：输出 {} StringUtil.format("{},{},{}", "666", "{}", "777") - "666,{},777"<br>
	 * 示例 StringUtil.format("{},{},{},{}", "666", "{}", "777") - "666,{},777,"<br>
	 * 没有实际{} 会替换为 "" 空字符串
	 *
	 * @param format 格式字符串，使用{}作为占位符，如果为null则返回null
	 * @param args   用于替换占位符的参数数组
	 * @return 格式化后的字符串
	 */
	public static String format(String format, Object... args) {
		if (format == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		int placeholderCount = 0;
		int lastIndex = 0;
		int len = format.length();

		for (int i = 0; i < len - 1; i++) {
			if (format.charAt(i) == '{' && format.charAt(i + 1) == '}') {
				// 添加前面的部分
				sb.append(format, lastIndex, i);
				// 替换为 MessageFormat 占位符 {index}
				sb.append('{').append(placeholderCount).append('}');
				placeholderCount++;
				i++; // 跳过 '}'
				lastIndex = i + 1;
			}
		}

		// 添加剩余部分
		sb.append(format.substring(lastIndex));

		// 构造实际参数数组
		Object[] actualArgs;
		if (args.length < placeholderCount) {
			actualArgs = new String[placeholderCount];
			System.arraycopy(args, 0, actualArgs, 0, args.length);
			for (int i = args.length; i < placeholderCount; i++) {
				actualArgs[i] = "";
			}
		} else {
			actualArgs = args;
		}

		// 如果没有占位符，直接返回格式化后的字符串
		if (placeholderCount == 0) {
			return sb.toString();
		}

		try {
			return MessageFormat.format(
				sb.toString(),
				(Object[]) Lists.toStringList(actualArgs)
			);
		} catch (IllegalArgumentException e) {
			// 返回原始格式化字符串或抛出自定义异常，视业务需求而定
			return sb.toString();
		}
	}

	/**
	 * 判断字符串是否为空
	 *
	 * @param str 待检查的字符串
	 * @return 如果字符串为null或空字符串则返回true，否则返回false
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	/**
	 * 使用指定的分隔符将多个对象连接成一个字符串
	 *
	 * @param spec    用作分隔符的字符串
	 * @param objects 要连接的对象数组
	 * @return 使用指定分隔符连接后的字符串
	 */
	public static String joinOf(String spec, String... objects) {
		return join(spec, Arrays.asList(objects));
	}

	/**
	 * 将字符串按照指定分隔符分割成字符串列表，并移除列表开头的空字符串元素
	 *
	 * @param str       待分割的字符串
	 * @param separator 用作分割符的字符串
	 * @return 分割后的字符串列表，不包含开头的空字符串元素
	 */
	public static List<String> split(String str, String separator) {
		List<String> data = new ArrayList<>(
			Arrays.asList(str.split(separator))
		);
		// 移除列表开头的所有空字符串元素
		while (!data.isEmpty() && data.get(0).isEmpty()) {
			data.remove(0);
		}
		return data;
	}

	/**
	 * 将列表中的元素按照指定分隔符连接成字符串
	 *
	 * @param <P>       列表元素的类型
	 * @param separator 分隔符，用于连接各个元素
	 * @param list      待连接的元素列表
	 * @param fun       转换函数，用于将列表元素转换为字符串，如果为null则使用toString()方法
	 * @return 连接后的字符串，如果列表为空或null则返回空字符串
	 */
	public static <P> String join(
		String separator,
		List<P> list,
		P1RFunction<P, String> fun
	) {
		// 处理空列表情况
		if (list == null || list.isEmpty()) {
			return "";
		}

		// 构建结果字符串
		StringBuilder sb = StringUtil.stringBuilder(list.size() * 16);
		for (int i = 0; i < list.size(); i++) {
			P item = list.get(i);
			// 将元素转换为字符串
			String itemStr = fun == null
				? (item == null ? "null" : item.toString())
				: fun.call(item);

			// 第一个元素直接添加，其他元素先添加分隔符再添加元素
			if (i == 0) {
				sb.append(itemStr);
			} else {
				sb.append(separator).append(itemStr);
			}
		}
		return sb.toString();
	}

	/**
	 * 使用指定分隔符连接字符串列表
	 *
	 * @param separator 分隔符，不能为null
	 * @param list      字符串列表，不能为null
	 * @return 连接后的字符串
	 * @throws IllegalArgumentException 当separator或list为null时抛出
	 */
	public static String join(String separator, List<String> list) {
		if (separator == null) {
			throw new IllegalArgumentException("Separator cannot be null");
		}
		if (list == null) {
			throw new IllegalArgumentException("List cannot be null");
		}
		return join(separator, list, null);
	}

	/**
	 * 创建一个新的StringBuilder实例
	 *
	 * @param i 指定StringBuilder的初始容量
	 * @return 返回一个新的StringBuilder对象，其初始容量为指定的大小
	 */
	public static StringBuilder stringBuilder(int i) {
		return new StringBuilder(i);
	}
}
