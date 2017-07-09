package com.isaac.leetcodes1_100;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 *
 * Tags: String.
 *
 * @author ZHANG HAO
 *
 *         Explain: 先确定两个string的最长prefix，之后对剩下的每一个字符串进行比对。
 *
 */
public class LeetCode_014_Longest_Common_Prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String longestCommonPrefix(String[] strs) {
		String str = "";
		if (strs.length == 0)
			return str;
		if (strs.length == 1)
			return strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (i == 1) {
				int n = strs[0].length() > strs[1].length() ? strs[1].length() : strs[0].length();
				for (int j = 0; j < n; j++) {
					if (strs[0].charAt(j) == strs[1].charAt(j))
						str = str + strs[0].charAt(j);
					else
						break;
				}
			} else {
				while (!strs[i].startsWith(str))
					str = str.substring(0, str.length() - 1);
			}
		}
		return str;
	}

}
