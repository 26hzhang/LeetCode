package com.isaac.leetcodes;

/**
 * Note: This is an extension of House Robber.
 *
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * Tags: Dynamic Programming
 *
 * @author ZHANG HAO
 *
 *         Explain: 考虑到有环，起始位置分别考虑从0开始和从1开始，最终取更大值。
 *
 */
public class LeetCode_213_House_Robber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		if (nums.length == 3)
			return Math.max(nums[0], Math.max(nums[1], nums[2]));
		//
		int tmp1 = nums[0];
		int tmp2 = Math.max(nums[0], nums[1]);
		int res1 = 0;
		for (int i = 2; i < nums.length - 1; i++) {
			res1 = Math.max(tmp2, tmp1 + nums[i]);
			tmp1 = tmp2;
			tmp2 = res1;
		}
		//
		tmp1 = nums[1];
		tmp2 = Math.max(nums[1], nums[2]);
		int res2 = 0;
		for (int i = 3; i < nums.length; i++) {
			res2 = Math.max(tmp2, tmp1 + nums[i]);
			tmp1 = tmp2;
			tmp2 = res2;
		}
		return Math.max(res1, res2);
	}

}
