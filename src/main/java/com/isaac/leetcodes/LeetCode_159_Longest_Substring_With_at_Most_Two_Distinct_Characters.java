package com.isaac.leetcodes;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_159_Longest_Substring_With_at_Most_Two_Distinct_Characters {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "gggggggccccvdvdddddffff";
		int k = 2;
		String substr = longestSubstring(str, k);
		System.out.println(substr);
	}

	public static String longestSubstring(String str, int k) {
		if (str == null)
			return null;
		if (str.length() <= k)
			return str;
		int maxLen = 0;
		int idx = 0;
		int start = 0;
		int end = 0;
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (set.size() == k && !set.contains(c)) {
				Set<Character> tmpSet = new HashSet<Character>();
				int tmpIdx = i + 1;
				while (tmpSet.size() <= k) {
					tmpIdx--;
					tmpSet.add(str.charAt(tmpIdx));
				}
				set.remove(str.charAt(tmpIdx));
				idx = tmpIdx + 1;
			}
			set.add(c);
			int tmp = i - idx + 1;
			if (maxLen < tmp) {
				maxLen = tmp;
				start = idx;
				end = i;
			}
		}
		return str.substring(start, end + 1);
	}

	// consider a specific case, where k == 2
	public static int longestSubstring2(String str) {
		int i = 0;
		int j = -1;
		int maxLen = 0;
		for (int k = 1; k < str.length(); k++) {
			if (str.charAt(k) == str.charAt(k - 1))
				continue;
			if (j >= 0 && str.charAt(j) != str.charAt(k)) {
				maxLen = Math.max(k - i, maxLen);
				i = j + 1;
			}
			j = k - 1;
		}
		return Math.max(str.length() - i, maxLen);
	}
}
