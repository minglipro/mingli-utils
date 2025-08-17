package com.mingliqiye.utils;

import com.mingliqiye.utils.collection.Lists;
import com.mingliqiye.utils.string.StringUtil;
import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.time.Formatter;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// 字符串工具使用示例
		System.out.println("=== 字符串工具使用示例 ===");
		String formatted = StringUtil.format(
			"你好 {}，今天是{}年{}月{}日",
			"张三",
			2025,
			7,
			25
		);
		System.out.println(formatted);

		List<String> fruits = Lists.newArrayList("苹果", "香蕉", "橙子");
		String joined = StringUtil.join(", ", fruits);
		System.out.println("水果列表: " + joined);

		// 时间工具使用示例
		System.out.println("\n=== 时间工具使用示例 ===");
		DateTime now = DateTime.now();
		System.out.println("当前时间: " + now);
		System.out.println(
			"标准格式: " + now.format(Formatter.STANDARD_DATETIME)
		);

		DateTime specificDate = DateTime.of(2025, 1, 1, 12, 0, 0);
		System.out.println(
			"指定时间: " + specificDate.format(Formatter.STANDARD_DATETIME)
		);

		// 集合工具使用示例
		System.out.println("\n=== 集合工具使用示例 ===");
		List<Integer> numbers = Lists.newArrayList(10, 20, 30);
		System.out.println("数字列表: " + numbers);

		List<String> linkedList = Lists.newLinkedList(
			"第一个",
			"第二个",
			"第三个"
		);
		System.out.println("链表内容: " + linkedList);
	}
}
