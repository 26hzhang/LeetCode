package com.isaac.otherAlgorithms;

import java.util.Arrays;

public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AABCDEBAZ";
		System.out.println(maxPalindrome(str));
	}

	public static int maxPalindrome(String str) {
		int[][] mark = new int[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++)
			mark[i][i] = 1;
		for (int subLen = 2; subLen <= str.length(); subLen++) {
			for (int i = 0; i <= str.length() - subLen; i++) {
				int j = i + subLen - 1;
				if (str.charAt(i) == str.charAt(j)) {
					if (subLen == 2)
						mark[i][j] = 2;
					else
						mark[i][j] = mark[i + 1][j - 1] + 2;
				} else {
					mark[i][j] = Math.max(mark[i + 1][j], mark[i][j - 1]);
				}
			}
		}
		for (int i = 0; i < mark.length; i++) {
			System.out.println(Arrays.toString(mark[i]));
		}
		return mark[0][str.length() - 1];
	}

}
