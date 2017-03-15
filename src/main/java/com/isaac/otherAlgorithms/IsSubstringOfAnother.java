package com.isaac.otherAlgorithms;

public class IsSubstringOfAnother {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdabcdabcdaaa";
		String str2 = "abcdabcdaaa";
		//System.out.println(str1.contains(str2));
		System.out.println(isSubstring(str1, str2));
	}

	public static boolean isSubstring(String str1, String str2) {
		int str2idx = 0;
		int str1idx = 0;
		int j = 0;
		while (j < str1.length()) { // worse case : O(m*n)
			if (str1.charAt(j) == str2.charAt(str2idx)) {
				if (str2idx == str2.length() - 1) {
					return true;
				}
				if (str2idx == 0)
					str1idx = j;
				str2idx++;
				j++;
			} else {
				str2idx = 0;
				while (++str1idx <= j)
					if (str1.charAt(str1idx) == str2.charAt(str2idx))
						break;
				j = str1idx;
			}
		}
		return false;
	}
}