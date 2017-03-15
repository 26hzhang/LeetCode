package com.isaac.leetcodes;

/**
 * Question:
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Hint:
 * • Have you thought about this?
 * • Here are some good questions to ask before coding. Bonus points for you if
 * you have already thought through this!
 * • If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * • Did you notice that the reversed integer might overflow? Assume the input
 * is a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * • For the purpose of this problem, assume that your function returns 0 when
 * the reversed integer overflows.
 *
 * Tags: Math.
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 考虑数据溢出的问题，对于溢出，返回0
 *
 */
public class LeetCode_007_Reverse_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 123;
		System.out.println(reverse(n));
	}

	public static int reverse(int x) {
		if (x == 0)
			return 0;
		long rev = 0;
		String s = Integer.toString(x);
		String str = "";
		String operator = "";
		if (s.charAt(0) == '-') {
			str = s.substring(1);
			operator = "-";
		} else {
			str = s;
		}
		for (int i = str.length() - 1; i >= 0; i--) {
			if (!operator.isEmpty()) {
				rev = rev * 10 + (str.charAt(i) - '0') * -1;
				if (rev < Integer.MIN_VALUE)
					return 0;
			} else {
				rev = rev * 10 + (str.charAt(i) - '0');
				if (rev > Integer.MAX_VALUE)
					return 0;
			}
		}
		return (int) rev;
	}

}
