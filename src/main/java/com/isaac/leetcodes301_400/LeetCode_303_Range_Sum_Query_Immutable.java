package com.isaac.leetcodes301_400;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * Note:
 * 1. You may assume that the array does not change.
 * 2. There are many calls to sumRange function.
 *
 * Tags: Dynamic Programming
 *
 * @author ZHANG HAO
 *
 *         Explain: 动态规划解题，由于需要多次调用，因此使用一个辅助Array sums[]
 *         来保存从起始端到当前位置的sum，当需要一个范围的sum时，只需要进行相减操作。
 *
 */
public class LeetCode_303_Range_Sum_Query_Immutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] nums;
	int[] sums;

	//public NumArray(int[] nums)
	public LeetCode_303_Range_Sum_Query_Immutable(int[] nums) {
		this.nums = nums;
		this.sums = new int[nums.length];
		computeSum(nums);
	}

	public int sumRange(int i, int j) {
		return sums[j] - sums[i] + nums[i];
	}

	public void computeSum(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			sums[i] = i == 0 ? nums[i] : nums[i] + sums[i - 1];
		}
	}

}
