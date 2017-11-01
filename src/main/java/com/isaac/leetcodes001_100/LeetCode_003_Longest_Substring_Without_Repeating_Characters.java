package com.isaac.leetcodes001_100;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_003_Longest_Substring_Without_Repeating_Characters {
	public static void main(String[] args) {
		String str = "dvdfabcdefavd";
		String substr = longestSubstring(str);
		System.out.println(substr);
		System.out.println(substr.length());

	}

	private static String longestSubstring(String str) {
		if (str == null)
			return null;
		if (str.length() <= 1)
			return str;
		int max = 0;
		int idx = 0;
		int start = 0;
		int end = 0;
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!set.add(c)) {
				while (idx < i && str.charAt(idx) != c) {
					set.remove(str.charAt(idx));
					idx++;
				}
				idx++;
			}
			int tmp = i - idx + 1;
			if (max < tmp) {
				max = tmp;
				start = idx;
				end = i;
			}
		}
		return str.substring(start, end + 1);
	}
}
