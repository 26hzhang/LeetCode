package com.isaac.leetcodes001_100;

/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 * Tags: Math, String
 *
 * @author ZHANG HAO
 *
 *         Explain: 将String a和b 的长度变为想等，然后利用二进制加法的规则进行计算，注意进位的问题。
 *
 */
public class LeetCode_067_Add_Binary {

	public static void main(String[] args) {

	}

	public static String addBinary(String a, String b) {
		while (a.length() > b.length()) {
			b = "0" + b;
		}
		while (a.length() < b.length()) {
			a = "0" + a;
		}
		char[] a1 = a.toCharArray(), b1 = b.toCharArray();
		int index = 0;
		int n;
		for (int i = a1.length - 1; i >= 0; i--) {
			n = (a1[i] - '0') + (b1[i] - '0') + index;
			if (n == 3) {
				a1[i] = '1';
				index = 1;
			} else if (n == 2) {
				a1[i] = '0';
				index = 1;
			} else if (n == 1) {
				a1[i] = '1';
				index = 0;
			} else {
				index = 0;
			}
		}
		String str = "";
		if (index == 1)
			str = '1' + str;
		for (int i = 0; i < a1.length; i++) {
			str += a1[i];
		}
		return str;
	}

}
