package com.isaac.otherAlgorithms;

/**
 * it is a dynamic programming codes
 *
 */
public class Maximal_Sum_of_SubArray {
	// 输入一个整形数组，数组里有正数也有负数。
	// 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
	// 求所有子数组的和的最大值，以及子数组的起始点和终止点。要求时间复杂度为 O(n)。
	public static void main(String[] args) {
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int[] ans = maxSum(arr);
		System.out.println(ans[0]);
		for (int i = ans[1]; i <= ans[2]; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] maxSum(int[] arr) {
		int start = 0, end = 0, tmpStart = 0, tmp = 0;
		boolean flag = false;
		int global = arr[0];
		int local = arr[0];
		for (int i = 1; i < arr.length; i++) {
			local = local + arr[i];
			if (local <= 0) {
				local = 0;
				tmpStart = i + 1;
				flag = true;
			}
			tmp = Math.max(local, global);
			if (tmp > global) {
				if (flag) {
					start = tmpStart;
					flag = false;
				}
				end = i;
			}
			global = tmp;
		}
		int[] ans = { global, start, end };
		return ans;
	}

}
