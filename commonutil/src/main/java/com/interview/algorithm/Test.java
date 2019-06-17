package com.interview.algorithm;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title Test -> Class
 * @Package CommonUtils -> com.interview.algorithm
 * @Description
 * @date 2019/5/29 16:37 
 */
public class Test {

	public static void main(String[] args) {
		int[] nums = {1,2};
		List<Integer> list = new ArrayList<>();

//		System.out.println(Integer.bitCount(1)); // 1
//		System.out.println(Integer.bitCount(2)); // 1
//		System.out.println(Integer.bitCount(3)); // 2
//		System.out.println(Integer.bitCount(4)); // 1
//		System.out.println(Integer.bitCount(5)); // 2
//
//		System.out.println(Integer.toBinaryString(3));
//		System.out.println(Integer.toBinaryString(13));
//		System.out.println(Integer.toBinaryString(23));
//		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());

//		int i = minPatches(nums, 18);

//		System.out.println(testTree("1,#,1,#,#"));

//		int[] param = {11, 3, 12, 4, 5};
//		increasingTriplet(param);

//		String[] words = {"abc", "cba", "bcd", "def"};
//		palindromePairs(words);


//		char[] at = String.valueOf(101312).toCharArray();
//		Arrays.sort(at);
//		String str = new String(at);
//		System.out.println(str);
//
//		List<Integer> list1 = new ArrayList<>();

		int[] A = {5, 10};
		int[] B = {3, 7};
		int[] C = {6, 6};
		int[][] D = new int[3][2];
		D[0] = A;
		D[1] = B;
		D[2] = C;
		countMinFuel(10, 5, D);

		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);

		Map<String, List<Integer>> map = new HashMap<>();
		map.put("hello", integerList);

		System.out.println(map.get("hello"));

		integerList.set(0, 3);
		System.out.println(map.get("hello"));


		try {
			new Thread(() -> {
				throw new IllegalArgumentException("这是一个异常");
			}).start();
		} catch (Exception e) {
			System.out.println("主线程捕获到了这个异常");
			e.printStackTrace();
		}

		FutureTask futureTask = new FutureTask(() -> {
			Thread.sleep(2000);
			return "执行结束";
		});

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(futureTask);

		futureTask.cancel(true);
	}

	public static int countMinFuel(int target, int startFuel, int[][] stations) {
		if(stations.length == 0) {
			return startFuel>=target?0:-1;
		}
		// 按从大到小的顺序出队列
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		int sum = startFuel;
		int ans = 0;
		for(int i = 0;i < stations.length;i++) {
			// 如果油量无法到达加油站
			while(sum < stations[i][0]) {
				Integer ii = queue.poll();
				if(ii == null) {
					return -1;
				}
				sum += ii;
				ans++;
			}
			queue.offer(stations[i][1]);
		}
		while(sum < target) {
			Integer ii = queue.poll();
			if(ii == null) {
				return -1;
			}
			sum += ii;
			ans++;
		}
		return ans;
	}


	public static int[] advantageCount(int[] A, int[] B) {
		if (A == null || A.length <= 1) {
			return A;
		}
		// 对A排序，依次取最小的大于B的元素
		Arrays.sort(A);
		// 结果数组
		int[] res = new int[A.length];
		// B数组下标
		int i = 0;
		for (int b : B) {
			// A中最小值
			int min = -1;
			// A中最小值下标
			int minIndex = -1;
			// 结果元素
			res[i] = -1;
			for (int j = 0; j < A.length; j++) {
				int a = A[j];
				if (a == -1) {
					continue;
				}
				// 拿到一个最小值及其下标
				if (min == -1) {
					min = a;
					minIndex = j;
				}
				// 如果是大于B元素，赋值到结果数组并剔除
				if (a > b) {
					res[i] = a;
					A[j] = -1;
					break;
				}
			}
			// 如果没有找到大于B数组中的数，将一个最小值放入当前下标
			if (res[i] == -1) {
				res[i] = min;
				// 将该最小值的改为-1，相当于剔除一个元素
				A[minIndex] = -1;
			}
			i++;
		}
		return res;
	}


	public static void printAllSortNumber(String num) {
		String[] array = num.split("");

		for (int i = 0; i < array.length; i++) {

		}
	}


	public static int binaryGap1(int N) {
		int result = 0;
		int begin = 0;
		int i = 1;
		while (N > 0) {
			if ((N & 1) == 1) {
				if (begin > 0) {
					int res = i - begin;
					if (result < res) {
						result = res;
					}
				}
				begin = i;
			}
			N = N >> 1;
			i++;
		}

		return result;
	}

	public static int binaryGap(int N) {
		int result = 0;
		String binary = Integer.toBinaryString(N);
		int begin = 0;
		String[] arr = binary.split("");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("1")) {
				int res = i - begin;
				if (result < res) {
					result = res;
				}
				begin = i;
			}
		}

		return result;
	}


	public static int[][] transpose(int[][] A) {
		int[][] result = new int[A[0].length][A.length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				result[j][i] = A[i][j];
			}
		}

		return result;
	}


	public static List<List<Integer>> palindromePairs(String[] words) {
		// 记录结果的二维数组
		List<List<Integer>> result = new ArrayList<>();
		// 拼出所有字符串组合
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				// 排除自身
				if (i == j) {
					continue;
				}
				// 判断是否回文数
				if(isRebackWords(words[i] + words[j])) {
					// 放入结果数组
					List<Integer> inside = new ArrayList<>();
					inside.add(i);
					inside.add(j);
					result.add(inside);
				}

			}
		}

		return result;
	}

	public static boolean isRebackWords(String word) {
		int len = word.length();
		int j = 0;

		while (j <= (len / 2) - 1 && word.charAt(j) == word.charAt(len - j - 1)) {
			j++;
		}

		return j == len / 2;
	}


	public boolean isSelfCrossing(int[] x) {
		if (x == null || x.length < 4) {
			return false;
		}

		for (int i = 3; i < x.length; i++) {
			if (x[i] >= x[i - 2] && x[i - 3] >= x[i - 1]) {
				return true;
			}

			if (i >= 4 && x[i - 1] == x[i - 3] && x[i] >= x[i - 2] - x[i - 4]) {
				return true;
			}

			if (i >= 5 && x[i - 2] >= x[i - 4] && x[i - 3] >= x[i - 1] && x[i - 1] >= x[i - 3]  - x[i - 5] && x[i] >= x[i - 2] - x[i - 4]) {
				return true;
			}
		}

		return false;
	}

	public static boolean increasingTriplet(int[] nums) {
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;

		for (int e : nums) {
			if (e <= a) {
				a = e;
			} else if (e <= b) {
				b = e;
			} else {
				return true;
			}
		}
		return false;
	}

	public static boolean testTree(String array) {
		if (array.startsWith("#") && !array.equals("#")) {
			return false;
		}

		if (!array.endsWith("#")) {
			return false;
		}

		String[] ar = array.split(",");
		int count = 1;

		for (int i = 0; i < ar.length - 1; i++) {
			System.out.println(ar[i] + ":" + ar[i].equals("#"));
			count += ar[i].equals("#") ? -1 : 1;
			if (count == 0) {
				return false;
			}
		}
		return count == 1;
	}


	public static int minPatches(int[] nums, int n) {
		int count = 0;
		int miss = 1;
		int idx = 0;
		int len = nums.length;
		while (miss <= n) {
			if (idx < len && nums[idx] <= miss) {
				miss += nums[idx];
				idx += 1;
			} else {
				count++;
				miss += miss;
			}
		}
		return count;
	}
}
