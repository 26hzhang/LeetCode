package com.isaac.leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question:
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sum to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * • All numbers (including target) will be positive integers.
 * • Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (i.e., a1 ≤ a2 ≤ … ≤ ak).
 * • The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain:回溯问题。同理，去除重复和递归选择合适的数据。
 */
public class LeetCode_040_Combination_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> list = combination(candidates, target);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> combination(int[] candidates, int target) {
		List<List<Integer>> lList = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		recursion(lList, candidates, target, 0, new ArrayList<Integer>());
		return lList;
	}

	public static void recursion(List<List<Integer>> lList, int[] candidates, int target, int start, List<Integer> list) {
		if (target < 0)
			return;
		if (target == 0 && !lList.contains(list)) {
			lList.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (target >= candidates[i]) {
				list.add(candidates[i]);
				recursion(lList, candidates, target - candidates[i], i + 1, list);
				list.remove(list.size() - 1);
			}
		}
	}

}
