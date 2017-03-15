package com.isaac.otherAlgorithms;

import java.util.Arrays;

public class FindKMinimumElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int k = 4;
		int[] ans = findKMinimum2(arr, k);
		System.out.println(Arrays.toString(ans));
	}

	// 输出非排序的k个最小元素
	public static int[] findKMinimum(int[] arr, int k) {
		int[] ans = new int[k];
		for (int i = 0; i < k; i++)
			ans[i] = arr[i];
		//略
		return ans;
	}

	// 输出排序后的k个最小元素
	public static int[] findKMinimum2(int[] arr, int k) {
		int[] ans = new int[k];
		for (int i = 0; i < k; i++)
			ans[i] = arr[i];
		fastSort(ans);
		for (int i = k; i < arr.length; i++) {
			if (arr[i] < ans[k - 1]) {
				ans[k - 1] = arr[i];
				fastSort(ans);
			}
		}
		return ans;
	}

	// fast sort
	public static void fastSort(int[] arr) {
		if (arr.length > 1) {
			recursion(arr, 0, arr.length - 1);
		}
	}

	public static void recursion(int[] arr, int low, int high) {
		if (low < high) {
			int middle = getMiddle(arr, low, high);
			recursion(arr, low, middle - 1);
			recursion(arr, middle + 1, high);
		}
	}

	public static int getMiddle(int[] arr, int low, int high) {
		int tmp = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= tmp)
				high--;
			arr[low] = arr[high];
			while (low < high && arr[low] <= tmp)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = tmp;
		return low;
	}

}
