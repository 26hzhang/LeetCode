package com.isaac.leetcodes201_300;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Tags: Math, Bit Manipulation.
 *
 * @author ZHANG HAO
 *
 *         Explain: 转换为binary string形式判断。
 *
 */
public class LeetCode_231_Power_of_Two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		String str = Integer.toBinaryString(n);
		for (int i = str.length() - 1; i > 0; i--) {
			if (str.charAt(i) == '1')
				return false;
		}
		return true;
	}

}
