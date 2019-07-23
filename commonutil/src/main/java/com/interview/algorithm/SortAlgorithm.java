package com.interview.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title SortAlgorithm -> Class
 * @Package CommonUtils -> com.interview.algorithm
 * @Description 排序算法
 * @date 2019/5/10 9:34 
 */
public class SortAlgorithm {
	public static void main(String[] args) {
		int[] array = {1, 3, 4, 5, 19, 2, 31, 23, 25, 48, 37, 98};

		insertSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void insertSort(int[] array) {
		// 进行length-1次循环
		for (int i = 1; i < array.length; i++) {
			// 由于前面的元素都是排序好的，所以只有小于第一个元素的时候才需要插入
			if(array[i] < array[i-1]){
				int temp = array[i];
				while(i > 0 && temp < array[i-1]){
					array[i] = array[i-1];
					i--;
				}
				array[i] = temp;
			}
		}

	}

	public static void bubblingSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	public static void chooseSort(int[] array) {
		// 全部遍历找出最小元素
		for (int i = 0; i < array.length; i++) {
			// 最小元素，初始值未第一个
			int min = array[i];
			// 最小值下标，初始值未第一个
			int pos = i, j = i;
			// 当前元素和后面所有元素比较，选出最小值，如果有则交换最小值和下标
			while (j < array.length) {
				if (array[j] < min) {
					min = array[j];
					pos = j;
				}
				j++;
			}

			// 如果最小值不等于当前元素，替换
			if (min != array[i]) {
				int temp = array[i];
				array[i] = min;
				array[pos] = temp;
			}

		}
	}

}
