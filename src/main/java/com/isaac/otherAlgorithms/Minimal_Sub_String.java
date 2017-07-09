package com.isaac.otherAlgorithms;

/**
 * it is a dynamic programming codes
 *
 */
public class Minimal_Sub_String {
	// 有一串首尾相连的珠子,共有m个,每一个珠子有一种颜色,并且颜色的总数不超过n(n<=10)
	// 求连续的珠子的颜色总数为n时，长度最小的区间。
	public static void main(String[] args) {

	}

	public static int minLength(int[] arr, int colors) {
		if (arr.length < colors)
			return -1;

		return 0;
	}

	public static int getMin(int[] arr) {
		if (arr == null)
			return -1;
		int min = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (min > arr[i])
				min = arr[i];
		return min;
	}

	public static int getMax(int[] arr) {
		if (arr == null)
			return -1;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (max < arr[i])
				max = arr[i];
		return max;
	}

}
