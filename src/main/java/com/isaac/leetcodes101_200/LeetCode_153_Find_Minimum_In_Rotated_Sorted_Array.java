package com.isaac.leetcodes101_200;

public class LeetCode_153_Find_Minimum_In_Rotated_Sorted_Array {
	public static void main(String[] args) {

	}

	public int findMin(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] - nums[i + 1] > 0)
				return nums[i + 1];
		}
		return nums[0];
	}
}
