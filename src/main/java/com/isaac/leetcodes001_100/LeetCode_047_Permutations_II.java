package com.isaac.leetcodes001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Question:
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: Similar to LeetCode 46, the difference is to delete the
 *        duplicates
 */
public class LeetCode_047_Permutations_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 2 };
		List<List<Integer>> list = permuteUnique(nums);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> lList = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return lList;
		recursion(lList, nums, 0);
		return lList;
	}

	public static void recursion(List<List<Integer>> lList, int[] nums, int start) {
		if (start == nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (int n : nums) {
				list.add(n);
			}
			lList.add(list);
			return;
		}
		Set<Integer> appeared = new HashSet<Integer>();
		for (int i = start; i < nums.length; i++) {
			if (appeared.add(nums[i])) {
				int tmp = nums[i];
				nums[i] = nums[start];
				nums[start] = tmp;
				recursion(lList, nums, start + 1);
				tmp = nums[i]; // backtracking
				nums[i] = nums[start];
				nums[start] = tmp;
			}
		}
	}

}
