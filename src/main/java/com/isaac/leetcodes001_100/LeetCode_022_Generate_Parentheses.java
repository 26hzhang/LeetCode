package com.isaac.leetcodes001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * Tags: Backtracking, String
 *
 * @author zhanghao
 *
 *         Explain: 回溯法
 */
public class LeetCode_022_Generate_Parentheses {

	public static void main(String[] args) {

	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if (n == 0)
			return list;
		int sum = recursion(list, 0, "", n, n);
		System.out.println(sum);
		return list;
	}

	public static int recursion(List<String> list, int sum, String str, int leftP, int rightP) {
		if (rightP == 0) {
			sum++;
			list.add(str);
		}
		if (leftP > 0)
			sum = recursion(list, sum, str + "(", leftP - 1, rightP);
		if (rightP > leftP)
			sum = recursion(list, sum, str + ")", leftP, rightP - 1);
		return sum;
	}

}
