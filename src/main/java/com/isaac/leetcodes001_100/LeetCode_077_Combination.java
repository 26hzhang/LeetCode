package com.isaac.leetcodes001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question:
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author ZHANG HAO
 * @Email: isaac.changhau@gmail.com
 *
 *         Explain: backtracking
 *
 */
public class LeetCode_077_Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int k = 2;
		List<List<Integer>> list = combine(n, k);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (n < k || k <= 0)
			return list;
		recursion(list, n, k, 1, new ArrayList<Integer>());
		return list;
	}

	public static void recursion(List<List<Integer>> list, int n, int k, int start, List<Integer> l) {
		if (l.size() == k) {
			list.add(new ArrayList<Integer>(l));
			return;
		}
		for (int i = start; i <= n; i++) {
			l.add(i);
			recursion(list, n, k, i + 1, l);
			l.remove(l.size() - 1);
		}
	}

}
