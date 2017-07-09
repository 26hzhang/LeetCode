package com.isaac.otherAlgorithms;

import java.util.Arrays;

public class FIndTwoElementInArrayEqualToANumber {

	public static void main(String[] args) {

	}

	public static boolean findTwoElements(int[] arr, int num) {
		Arrays.sort(arr);
		int i = 0, j = arr.length - 1;
		while (arr[j] >= num) {
			j--;
		}
		while (i < j) {
			if (arr[i] + arr[j] == num)
				return true;
			if ((arr[i] + arr[j]) > num)
				j--;
			else
				i++;
		}
		return false;
	}

}
