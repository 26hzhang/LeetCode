package com.isaac.leetcodes1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question:
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets.
 * Note:
 * • Elements in a subset must be in non-descending order.
 * • The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 注意解决元素重复问题
 *
 */
public class LeetCode_090_Subsets_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> list = subsetsWithDup(nums);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return list;
		int length = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i <= length; i++) {
			recursion(list, new ArrayList<Integer>(), nums, 0, i);
		}
		return list;
	}

	public static void recursion(List<List<Integer>> list, List<Integer> l, int[] nums, int start, int n) {
		if (n == 0) {
			list.add(new ArrayList<Integer>(l));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (i == start || nums[i] != nums[i - 1]) {
				l.add(nums[i]);
				recursion(list, l, nums, i + 1, n - 1);
				l.remove(l.size() - 1);
			}
		}
	}

}
