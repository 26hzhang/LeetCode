package com.isaac.leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question:
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sum to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * • All numbers (including target) will be positive integers.
 * • Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (i.e., a1 ≤ a2 ≤ … ≤ ak).
 * • The solution set must not contain duplicate combinations.
 * For example, given candidate set [2,3,6,7] and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 回溯问题。利用DFS思想，每层递归中都遍历candidates中的每个元素，
 *        如果满足candidates[i] + sum <= target，则令sum+=candidates[i]，
 *        并递归继续从一开始寻找满足条件的元素，直到sum=target则记录当前的list。
 */
public class LeetCode_039_Combination_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> list = combinationSum(candidates, target);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> lList = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		recursion(lList, candidates, target, 0, 0, new ArrayList<Integer>());
		return lList;
	}

	public static void recursion(List<List<Integer>> lList, int[] candidates, int target, int sum, int start, List<Integer> list) {
		if (sum == target) {
			lList.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (sum + candidates[i] <= target) {
				list.add(candidates[i]);
				recursion(lList, candidates, target, sum + candidates[i], i, list);
				list.remove(list.size() - 1);
			}
		}
	}

}
