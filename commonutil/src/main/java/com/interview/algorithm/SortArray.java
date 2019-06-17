package com.interview.algorithm;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title SortArray -> Class
 * @Package CommonUtils -> com.interview.algorithm
 * @Description
 * @date 2019/5/29 9:47 
 */
public class SortArray {
	/**
	 * 数组右移K次, 原数组<code> [1, 2, 3, 4, 5, 6, 7]</code> 右移3次后结果为 <code>[5,6,7,1,2,3,4]</code>
	 *
	 * @author sunyiban
	 * @date 2019/5/29 9:48
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		int times = 3;

		array = testTrans1(array, times);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}

	}

	private static int[] testTrans1(int[] array, int times) {
		int[] resultArray = new int[array.length];

		// 循环次数按照移动长度和剩余数组长度最大的计算
		int loopTimes = array.length - times > times ? array.length - times : times;

		for (int i = 0; i < loopTimes; i++) {
			// 放不需要位移的值
			if (i < array.length - times) {
				resultArray[times + i] = array[i];
			}

			// 放需要位移的值,位移是最后出的放在最前
			if (i < times) {
				resultArray[i] = array[array.length - times + i];
			}
		}

		return resultArray;
	}

	private static int[] testTrans(int[] array, int times) {
		int[] result = new int[array.length];

		int[] subArray = new int[array.length];

		int j = 0;
		for(int i = array.length - 1; i >= 0; i--) {
			subArray[j] = array[i];
			j++;
		}

		for (int i = 0; i < times; i++) {
			result[i] = subArray[i];
		}

		for (int i = 0; i < array.length - times; i++) {
			result[times + i] = array[i];
		}

		return result;
	}
}
