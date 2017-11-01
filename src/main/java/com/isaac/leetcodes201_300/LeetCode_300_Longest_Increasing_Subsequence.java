package com.isaac.leetcodes201_300;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 *
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is
 * 4. Note that there may be more than one LIS combination, it is only necessary
 * for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * Tags: Dynamic Programming, Binary Search
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_300_Longest_Increasing_Subsequence {

	public static void main(String[] args) {

	}

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		int length = nums.length;
		int[] count = new int[length];
		int max = 1;
		for (int i = 0; i < length; i++) {
			count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && count[j] + 1 > count[i]) {
					count[i] = count[j] + 1;
					max = Math.max(max, count[i]);
				}
			}
		}
		return max;
	}

}
