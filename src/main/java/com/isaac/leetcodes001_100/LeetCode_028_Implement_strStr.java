package com.isaac.leetcodes001_100;

/**
 * Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 * Tags: Two Pointers, String.
 *
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_028_Implement_strStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		int m = haystack.length();
		int n = needle.length();
		for (int i = 0; i <= (m - n); i++) {
			String tmp = haystack.substring(i, i + n);
			if (tmp.equals(needle)) {
				return i;
			}
		}
		return -1;
	}

}
