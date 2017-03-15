package com.isaac.leetcodes;

public class LeetCode_227_Basic_Calculator_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3 + 2 * 2 ";
		System.out.println(compute(s));
	}

	public static int compute(String str) {
		str = str.replaceAll(" ", "");
		int sign = 1;
		int ans = 0;
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case ('+'):
				ans += sign * num;
				sign = 1;
				num = 0;
				break;
			case ('-'):
				ans += sign * num;
				sign = -1;
				num = 0;
				break;
			case ('*'):
				int tempNum1 = 0;
				while (++i < str.length() && Character.isDigit(str.charAt(i)))
					tempNum1 = tempNum1 * 10 + str.charAt(i) - '0';
				num = num * tempNum1;
				break;
			case ('/'):
				int tempNum2 = 0;
				while (++i < str.length() && Character.isDigit(str.charAt(i)))
					tempNum2 = tempNum2 * 10 + str.charAt(i) - '0';
				num = num / tempNum2;
				break;
			default:
				num = num * 10 + str.charAt(i) - '0';
			}
		}
		if (num != 0)
			ans += sign * num;
		return ans;
	}
}
