package com.isaac.leetcodes201_300;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * • You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * • What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 *
 * Tags: Hash Table, Sort
 *
 * @author ZHANG HAO
 *
 *         Explain: 分别统计两个字符串，对于第一个字符串，+1操作；对于第二个字符串，-1操作。
 *
 */
public class LeetCode_242_Valid_Anagram {

	public static void main(String[] args) {

	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a'] += 1;
			count[t.charAt(i) - 'a'] -= 1;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}

	// or using the specific function in java
	public static boolean isAnagram2(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		Arrays.sort(ss);
		Arrays.sort(tt);
		return Arrays.equals(ss, tt);
	}

}
