package com.isaac.leetcodes;

import java.util.Arrays;

public class LeetCode_080_Remove_Duplicates_from_Sorted_Array_II {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2, 3, 3, 3, 4 };
		System.out.println(remove(nums));
	}

	public static int remove(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int idx = 1;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				if (count < 2)
					nums[idx++] = nums[i];
				count++;
			} else {
				nums[idx++] = nums[i];
				count = 1;
			}
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, idx)));
		return idx;
	}

	public static int remove2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length <= 2)
			return nums.length;
		int idx = 1;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				if (count < 2)
					nums[idx++] = nums[i];
				count++;
			} else {
				nums[idx++] = nums[i];
				count = 1;
			}
		}
		return idx;
	}
}
