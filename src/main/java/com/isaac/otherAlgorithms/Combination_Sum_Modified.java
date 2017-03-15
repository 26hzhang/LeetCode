package com.isaac.otherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Question:
 * 输入两个整数n和m，从数列1,2,3...n中随意取几个数，使其和等于m，要求列出所有的组合。
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 问题其实本质上就是0/1背包问题，对于每一个n，我们采用贪婪策略，先考察是否取n，
 *        如果取n，那么子问题就变成了find(n-1,m-n)，而如果舍弃n，子问题则为find(n-1,m)。
 *
 */
public class Combination_Sum_Modified {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int m = 20;
		List<List<Integer>> list = combination(n, m);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> combination(int n, int m) {
		List<List<Integer>> lList = new ArrayList<List<Integer>>();
		int up = n > m ? m : n;
		recursion(lList, up, m, new ArrayList<Integer>());
		return lList;
	}

	public static void recursion(List<List<Integer>> lList, int n, int m, List<Integer> list) {
		if (m == 0) {
			Collections.reverse(list);
			lList.add(new ArrayList<Integer>(list));
			Collections.reverse(list);
			return;
		}
		if (n <= 0 || m < 0)
			return;
		list.add(n);
		recursion(lList, n - 1, m - n, list); // 包含n
		list.remove(list.size() - 1);
		recursion(lList, n - 1, m, list); // 不包含n
	}

}
