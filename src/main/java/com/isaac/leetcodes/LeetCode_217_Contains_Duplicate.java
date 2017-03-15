package com.isaac.leetcodes;

import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * Tags: Array, Hash Table
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         Java中的HashSet具有元素不可重复的性质，因此可用于判断Array中是否存在重复元素。
 *         若添加重复元素，add(num)操作将返回false
 *
 */
public class LeetCode_217_Contains_Duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashInt = new HashSet<Integer>();
		for (int num : nums) {
			if (!hashInt.add(num))
				return true;
		}
		return false;
	}

}
