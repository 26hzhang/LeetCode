package com.isaac.leetcodes;

import java.util.Arrays;

public class LeetCode_268_Missing_Number {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 1 };
		System.out.println(missingNumber(nums));
	}

	public static int missingNumber1(int[] nums) {
		Arrays.sort(nums);
		int ans = nums.length;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] != i) {
				ans = i;
				break;
			}
			i++;
		}
		return ans;
	}

	public static int missingNumber(int[] nums) {
		int result = nums.length * (nums.length + 1) / 2;
		for (int i = 0; i < nums.length; i++) {
			result -= nums[i];
		}
		return result;
	}
}
