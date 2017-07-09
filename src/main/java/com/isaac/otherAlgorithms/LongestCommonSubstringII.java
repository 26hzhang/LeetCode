package com.isaac.otherAlgorithms;

public class LongestCommonSubstringII {

	public static void main(String[] args) {
		String str1 = "ABCDA";
		String str2 = "ACBDEA";
		int max = LCS(str1, str2);
		System.out.println(max);
	}

	public static int LCS(String str1, String str2) {
		int[][] mark = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			mark[i][0] = 0;
		}
		for (int j = 0; j <= str2.length(); j++) {
			mark[0][j] = 0;
		}
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					mark[i][j] = mark[i - 1][j - 1] + 1;
				} else {
					mark[i][j] = Math.max(mark[i - 1][j], mark[i][j - 1]);
				}
			}
		}
		return mark[str1.length()][str2.length()];
	}

}
