package com.isaac.leetcodes1_100;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 *
 * Hint:
 * • Try two pointers.
 * • Did you use the property of "the order of elements can be changed"?
 * • What happens when the elements to remove are rare?
 *
 * Tags: Array, Two Pointers.
 *
 * @author ZHANG HAO
 *
 *         Explain: 遍历一遍，排出所有的val。
 */
public class LeetCode_027_Remove_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int removeElement(int[] nums, int val) {
		int n = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != val)
				nums[n++] = nums[i];
		return n;
	}

}
