package com.isaac.leetcodes001_100;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 * Tags: Array, Binary Search
 *
 * @author ZHANG HAO
 *
 *         Explain: 使用二分法查找。
 *
 */
public class LeetCode_035_Search_Insert_Position {

	public static void main(String[] args) {

	}

	public static int searchInsert(int[] nums, int target) {
		if (nums == null)
			return 0;
		int pos1 = 0;
		int pos2 = nums.length - 1;
		while (pos1 <= pos2) {
			int mid = (pos1 + pos2) / 2;
			if (target == nums[mid])
				return mid;
			else if (target > nums[mid])
				pos1 = mid + 1;
			else
				pos2 = mid - 1;
		}
		return Math.max(pos1, pos2);
	}

}
