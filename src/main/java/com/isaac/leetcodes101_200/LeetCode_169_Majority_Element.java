package com.isaac.leetcodes101_200;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * Tags: Divide and Conquer, Array, Bit Manipulation
 *
 * @author ZHANG HAO
 *
 *         Explain: 出现超过⌊ n/2 ⌋，即至少出现⌊ n/2 ⌋＋1次。因此排序后Array的前半段和后半段均存在这个数，
 *         且相距⌊ n/2 ⌋的两个元素一定有一对是这个数。而其他数不可能。
 *
 */
public class LeetCode_169_Majority_Element {

	public static void main(String[] args) {

	}

	public static int majorityElement(int[] nums) {
		int judge = nums.length / 2;
		int num = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - judge; i++) {
			if (nums[i] == nums[i + judge]) {
				num = nums[i];
			}
		}
		return num;
	}

	// using bit manipulation
	public static int majorityElement2(int[] nums) {
		int res = Integer.MAX_VALUE;
		for (int n = 0; n <= 31; n++) {
			int numOf0Bits = 0;
			int numOf1Bits = 1;
			for (int num : nums) {
				int bit = (num & (1 << n)) >> n;
				if (bit != 0)
					numOf1Bits++;
				else
					numOf0Bits++;
			}
			if (numOf1Bits > numOf0Bits) {
				res = res | (1 << n);
			} else {
				res = res & (~(1 << n));
			}
		}
		return res;
	}

}
