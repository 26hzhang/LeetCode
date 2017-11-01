package com.isaac.leetcodes101_200;

import java.util.Arrays;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 *
 * Tags: Bit Manipulation.
 *
 * @author ZHANG HAO
 *
 *         Explain: 三个相同的数亦或等于这个数。
 *
 */
public class LeetCode_137_Single_Number_II {

	public static void main(String[] args) {

	}

	public static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length) {
			if (i < nums.length - 2 && (nums[i] ^ nums[i + 1] ^ nums[i + 2]) == nums[i + 1]) {
				i += 3;
			} else {
				break;
			}
		}
		return nums[i];
	}

}
