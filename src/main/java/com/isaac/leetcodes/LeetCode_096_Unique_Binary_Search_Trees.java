package com.isaac.leetcodes;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 1 3 3 2 1
 * \ / / / \ \
 * 3 2 1 1 3 2
 * / / \ \
 * 2 1 2 3
 *
 * Tags: Tree, Dynamic Programming
 *
 * @author ZHANG HAO
 *
 *         Explain: 动态规划，找规律
 */
public class LeetCode_096_Unique_Binary_Search_Trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int numTrees(int num) {
		if (num == 1)
			return 1;
		if (num == 2)
			return 2;
		int[] count = new int[num + 1];
		count[1] = 1;
		count[2] = 2;
		for (int i = 3; i < count.length; i++) {
			int ans = 0;
			int n = i - 2;
			int m = i - 1 - n;
			while (m < i - 1) {
				ans += count[n] * count[m];
				n--;
				m++;
			}
			count[i] = ans + count[i - 1] * 2;
		}
		return count[num];
	}

}
