package com.isaac.otherAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combination3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int m = 7;
		List<List<Integer>> list = combine(n, m);
		for (List<Integer> l : list) {
			System.out.println(l.toString());
		}
	}

	public static List<List<Integer>> combine(int n, int m) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		n = n > m ? m : n;
		//recursion(list, n, m, new ArrayList<Integer>());
		recursion2(list, m, n, 1, new ArrayList<Integer>());
		return list;
	}

	public static void recursion(List<List<Integer>> list, int n, int m, List<Integer> l) {
		if (m == 0) {
			Collections.reverse(l);
			list.add(new ArrayList<Integer>(l));
			Collections.reverse(l);
			return;
		}
		if (n <= 0 || m < 0)
			return;
		l.add(n);
		recursion(list, n - 1, m - n, l);
		l.remove(l.size() - 1);
		recursion(list, n - 1, m, l);
	}

	public static void recursion2(List<List<Integer>> list, int n, int m, int start, List<Integer> l) {
		if (m == 0) {
			list.add(new ArrayList<Integer>(l));
			return;
		}
		if (n <= 0 || m < 0)
			return;
		for (int i = start; i <= n && m - i >= 0; i++) {
			l.add(i);
			recursion2(list, n, m - i, i + 1, l);
			l.remove(l.size() - 1);
		}
	}
}
