package com.interview;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title LambdaExample -> Class
 * @Package CommonUtils -> com.interview
 * @Description 关于lambda表达式的用法示例
 * @date 2019/6/11 9:30 
 */
public class LambdaExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");


		// 遍历
		list.forEach(a -> {System.out.print(a);});

		list.forEach(a -> System.out.print(a));

		list.forEach(System.out::print);

		// 过滤 + 遍历
		Predicate<String> predicate1 = (a) -> (!a.equals("c"));
		list.stream().filter(a -> !a.equals("c")).forEach(a -> {System.out.print(a);});
		list.stream().filter(predicate1).forEach(a -> {System.out.print(a);});

		// 取指定条数
		System.out.println("limit ______________");
		list.stream().limit(3).forEach(System.out::print);

		// 排序后生成新的list
		List<String> list1 = list.stream().sorted((a, b) -> (a.compareTo("b"))).collect(Collectors.toList());
		System.out.println("sort***********************************");
		list1.forEach(System.out::println);

		// 获取最小值
		String min = list.stream().min((a, b) -> (a.compareTo(b))).get();
		System.out.println("this is min : " + min);

		// 获取最大值
		String max = list.stream().max((a, b) -> (a.compareTo(b))).get();
		System.out.println("this is max:" + max);

		// 拼接字符串
		String str = list.stream().map((a) -> (a + "hello")).collect(Collectors.joining(";"));
		System.out.println("this is join string:");
		System.out.println(str);

		// 转成set
		Set<String> set = list.stream().map((a) -> (a)).collect(Collectors.toSet());
		// 转成tree
		TreeSet<String> tree = list.stream().collect(Collectors.toCollection(TreeSet::new));

		List<Integer> intlist = new ArrayList<>();
		intlist.add(1);
		intlist.add(2);
		intlist.add(3);
		intlist.add(4);
		intlist.add(5);
		intlist.add(6);
		intlist.add(7);

		// 数据汇总
		IntSummaryStatistics summaryStatistics = intlist.stream().mapToInt((a) -> a).summaryStatistics();
		System.out.println(summaryStatistics.getAverage());
		System.out.println(summaryStatistics.getCount());
		System.out.println(summaryStatistics.getMax());
		System.out.println(summaryStatistics.getMin());
		System.out.println(summaryStatistics.getSum());


		// 线程使用
		new Thread(() -> {
			System.out.println("hello this is thread");
		}).start();

		System.out.println("####################################################");

		Comparator<Integer> comparator = (a, b) -> (b - a);

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {return b - a;});
	    priorityQueue = new PriorityQueue<>(comparator);
		priorityQueue.offer(1);
		priorityQueue.offer(3);
		priorityQueue.offer(5);
		priorityQueue.offer(2);
		priorityQueue.offer(4);
		priorityQueue.offer(6);



	}




}
