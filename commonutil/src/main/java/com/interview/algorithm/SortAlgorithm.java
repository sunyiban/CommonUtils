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

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void insertSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			for(int j = i + 1; j < array.length; j++) {
				if (array[j] < temp) {
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void bubblingSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	public static void chooseSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			int position = i;
			for (int j = i + 1; j < array.length; j++) {
				if (temp > array[j]) {
					temp = array[j];
					position = j;
				}
			}
			array[position] = array[i];
			array[i] = temp;
		}
	}

}
