package com.isaac.otherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * it is a dynamic programming codes
 *
 */
public class Maximal_Ascend_SubArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, -1, 2, -3, 4, -5, -20, 6, -7, 8, 9, 10, -11, 9, 13, -19, 18, -17, -16, -15, 14, -13, -12, -11, -10, -9, -8, -7 };
		//int[] arr1 = {1, -1, 2, -3, 4, -5, -20, 6, -7};
		maxAscend1(arr, arr.length);
	}

	public static void maxAscend1(int[] arr, int length) {
		int[] count = new int[length];
		for (int i = 0; i < length; i++) {
			count[i] = 1;
			for (int j = 0; j < i; j++)
				if (arr[j] < arr[i] && count[j] + 1 > count[i])
					count[i] = count[j] + 1;
		}
		System.out.println(Arrays.toString(count));
		int max = count[0];
		int index = 0;
		for (int i = 1; i < length; i++) {
			if (count[i] > max) {
				max = count[i];
				index = i;
			}
		}
		System.out.println(max);
		List<Integer> list = new ArrayList<Integer>();
		list.add(arr[index]);
		int tmp = arr[index];
		for (int i = index - 1; i >= 0; i--) {
			if (count[i] == count[index]) {
				if (arr[i] > arr[index] && arr[i] <= tmp) {
					list.remove(list.size() - 1);
					index = i;
					list.add(arr[index]);
				}
			}
			if (count[i] == count[index] - 1) {
				tmp = arr[index];
				index = i;
				list.add(arr[index]);
			}
		}
		Collections.reverse(list);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
