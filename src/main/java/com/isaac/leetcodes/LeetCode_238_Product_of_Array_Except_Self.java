package com.isaac.leetcodes;

import java.util.Stack;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array
 * does not count as extra space for the purpose of space complexity analysis.)
 *
 * Tags: Array
 *
 * @author ZHANG HAO
 *
 *         Explain: 判断数组中有多少个0，2个及以上，则所有值均为0，只有一个0的话，只有一个非0，没有0的话…
 *
 *
 */
public class LeetCode_238_Product_of_Array_Except_Self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		Stack<Integer> list = new Stack<Integer>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				list.push(i);
				count++;
			}
		}
		if (count >= 2) {

		} else if (count == 1) {
			int tmp = 1;
			int j = list.pop();
			for (int i = 0; i < nums.length; i++) {
				if (i != j)
					tmp *= nums[i];
			}
			res[j] = tmp;
		} else {
			int tmp = 1;
			for (int i = 1; i < nums.length; i++) {
				tmp *= nums[i];
			}
			res[0] = tmp;
			for (int i = 1; i < nums.length; i++) {
				res[i] = res[i - 1] * nums[i - 1] / nums[i];
			}
		}
		return res;
	}

}
