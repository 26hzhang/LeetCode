package com.isaac.otherAlgorithms;

import java.util.Arrays;

public class MaxIncreaseSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, -1, 2, -3, 4, -5, 6, -7 };
		System.out.println(maxLength(nums));
	}

	public static int maxLength(int[] nums) {
		int[] count = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && count[j] + 1 > count[i]) {
					count[i] = count[j] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(count));
		int max = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max)
				max = count[i];
		}
		return max;
	}

}
