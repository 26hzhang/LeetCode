package com.isaac.leetcodes001_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_001_Two_Sum {
	// Main
	public static void main(String[] args) {
		//int[] nums = { 8, 2, 1, 7, 11, 15 };
		//int[] nums = { 12, 2, 1, 7, 11, 15, 8, 9 ,10 };
		int[] nums = { 12, 2, 1, 7, 11, 15, 8, 9, 10, 13, 14 };
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	private static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] ans = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.isEmpty() || !map.containsKey(nums[i]))
				map.put(target - nums[i], i);
			else if (map.containsKey(nums[i])) {
				ans[0] = map.get(nums[i]);
				ans[1] = i;
				break;
			}
		}
		return ans;
	}
}
