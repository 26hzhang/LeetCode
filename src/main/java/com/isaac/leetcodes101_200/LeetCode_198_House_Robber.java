package com.isaac.leetcodes101_200;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * Tags: Dynamic Programming
 *
 * @author ZHANG HAO
 *
 *         Explain: 动态规划
 *
 */
public class LeetCode_198_House_Robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return nums[0] > nums[1] ? nums[0] : nums[1];
		} else {
			int tmp1 = nums[0];
			int tmp2 = Math.max(nums[0], nums[1]);
			int result = 0;
			for (int i = 2; i < nums.length; i++) {
				result = Math.max(tmp2, tmp1 + nums[i]);
				tmp1 = tmp2;
				tmp2 = result;
			}
			return result;
		}
	}

}
