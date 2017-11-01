package com.isaac.leetcodes201_300;

import java.util.Arrays;

/**
 * Question:
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 *
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 *
 * @author ZHANG HAO
 *
 *        Explain:
 *        指针j指向末尾元素，指针i从后往前，遇到0就将0后面开始到指针j处的元素全部前移一位，然后指针j指向的位置赋值为0，指针j前移。
 *
 */
public class LeetCode_283_Move_Zeroes {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		System.out.println(Arrays.toString(moveZeroes(nums)));

	}

	public static int[] moveZeroes(int[] nums) {
		int j = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] == 0) {
				for (int k = i; k < j; k++)
					nums[k] = nums[k + 1];
				nums[j--] = 0;
			}
		}
		return nums;
	}

}
