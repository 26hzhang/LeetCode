package com.isaac.leetcodes201_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question:
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should
 * be a
 * unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * Example 1:
 * Input:
 * k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * Example 2:
 * Input:
 * k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 这道题也是回溯问题，从1-9中选择合适的k个数使其和为n。因此我们也可以从1开始，
 *        找可行的组合。目标值n为target，每次找到一个i小于target且未被添加则将其加入到list中，
 *        而target=target-i；利用递归找出所有可行解。
 */
public class LeetCode_216_Combination_Sum_III {

	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		List<List<Integer>> list = combinationSum3(k, n);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		if (k == 0 || k >= n) {
			return listList;
		}
		recursion(listList, new ArrayList<Integer>(), k, n, 1);
		return listList;
	}

	public static void recursion(List<List<Integer>> listList, List<Integer> list, int k, int target, int start) {
		if (target == 0 && list.size() == k) {
			listList.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i <= 9 && i <= target; i++) {
			list.add(i);
			recursion(listList, list, k, target - i, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
