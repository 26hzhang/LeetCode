package com.isaac.leetcodes001_100;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 *
 * Tags: Array, Two Pointers.
 *
 * @author ZHANG HAO
 *
 *         Explain: 让一个pointer指向array头部，另一个pointer i 对array进行遍历，当找到nums[n] !=
 *         nums[i]时，++n，然后让nums[n] = nums[i]，pointer i 继续向后遍历，直到结束。
 */
public class LeetCode_026_Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 1)
			return nums.length;
		int n = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[n] != nums[i])
				nums[++n] = nums[i];
		}
		return n + 1;
	}

}
