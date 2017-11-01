package com.isaac.leetcodes201_300;

import java.util.Arrays;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 *
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 * • The order of the result is not important. So in the above example, [5, 3]
 * is also correct.
 * • Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 *
 * Tags: Bit Manipulation.
 *
 * @author ZHANG HAO
 *
 *         Explain: 两个相同的数亦或等于0。
 *
 */
public class LeetCode_260_Single_Number_III {

	public static void main(String[] args) {

	}

	//order of result is not important, linear runtime complexity
	public static int[] singleNumber(int[] nums) {
		int[] res = new int[2];
		Arrays.sort(nums);
		int i = 0, index = 0;
		while (i < nums.length) {
			if (index > 1)
				break;
			if (i != nums.length - 1 && (nums[i] ^ nums[i + 1]) == 0) {
				i += 2;
			} else {
				res[index] = nums[i];
				index++;
				i += 1;
			}
		}
		return res;
	}

}
