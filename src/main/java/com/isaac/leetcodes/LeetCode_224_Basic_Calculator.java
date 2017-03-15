package com.isaac.leetcodes;

public class LeetCode_224_Basic_Calculator {

	public static void main(String[] args) {
		String s = "(1+(4+5-2)-3) + (6+8)";
		System.out.println(compute(s));
	}

	public static int compute(String s) {
		if (s == null || s.isEmpty())
			return 0;
		s = s.replaceAll(" ", "");
		s = new StringBuilder().append("(").append(s).append(")").toString();
		int[] index = { 0 };
		return recursion(s, index);
	}

	public static int recursion(String s, int[] index) {
		int ans = 0;
		int i = index[0];
		int oper = 1;
		int num = 0;
		while (i < s.length()) {
			switch (s.charAt(i)) {
			case ('+'):
				ans += oper * num;
				oper = 1;
				i++;
				num = 0;
				break;
			case ('-'):
				ans += oper * num;
				oper = -1;
				i++;
				num = 0;
				break;
			case ('('):
				index[0] = i + 1;
				ans += oper * recursion(s, index);
				i = index[0];
				break;
			case (')'):
				index[0] = i + 1;
				return ans + oper * num;
			default:
				num = num * 10 + s.charAt(i) - '0';
				i++;
			}
		}
		return ans;
	}
}
