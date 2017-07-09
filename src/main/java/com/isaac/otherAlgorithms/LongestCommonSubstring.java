package com.isaac.otherAlgorithms;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "abcdefghijk";
		String str2 = "bBcdefgh";
		System.out.println(longest2(str1, str2));
		//System.out.println(Math.abs('B' - 'b'));
	}

	public static String longest(String str1, String str2) {
		if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty())
			return "";
		StringBuilder sb = new StringBuilder();
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int[][] mark = new int[str1.length()][str2.length()];
		int maxLen = 0;
		int lastBegin = 0;
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					if (i == 0 || j == 0) {
						mark[i][j] = 1;
					} else {
						mark[i][j] = 1 + mark[i - 1][j - 1];
					}
					if (mark[i][j] > maxLen) {
						maxLen = mark[i][j];
						// generate substring from str1 => i
						int thisBegin = i - mark[i][j] + 1;
						if (lastBegin == thisBegin) {
							//if the current LCS is the same as the last time this block ran
							sb.append(str1.charAt(i));
						} else {
							//this block resets the string builder if a different LCS is found
							lastBegin = thisBegin;
							sb = new StringBuilder();
							sb.append(str1.substring(lastBegin, i + 1));
						}
					}
				}
			}
		}
		return sb.toString();
	}

	public static String longest2(String str1, String str2) {
		if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty())
			return "";
		int len1 = str1.length();
		int len2 = str2.length();
		StringBuilder sb = new StringBuilder();
		int[][] mark = new int[len1][len2];
		int max = 0;
		int lastBegin = 0;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (str1.charAt(i) == str2.charAt(j) || Math.abs(str1.charAt(i) - str2.charAt(j)) == 32) {
					if (i == 0 || j == 0) {
						mark[i][j] = 1;
					} else {
						mark[i][j] = mark[i - 1][j - 1] + 1;
					}
					if (mark[i][j] > max) {
						max = mark[i][j];
						int thisBegin = i - mark[i][j] + 1;
						if (thisBegin == lastBegin) {
							sb.append(str1.charAt(i));
						} else {
							sb = new StringBuilder();
							sb.append(str1.substring(thisBegin, i + 1));
							lastBegin = thisBegin;
						}
					}
				}
			}
		}
		return sb.toString();
	}
}
