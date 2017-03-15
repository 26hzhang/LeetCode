package com.isaac.otherAlgorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DeterminePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcba";
		String str2 = "aabbc";
		System.out.println(isPermutation(str1, str2));
	}

	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			char c = str2.charAt(i);
			if (!map.containsKey(c))
				return false;
			else {
				int val = map.get(c);
				if (val == 0)
					return false;
				map.put(c, val - 1);
			}
		}
		Set<Character> set = map.keySet();
		for (char c : set) {
			if (map.get(c) != 0)
				return false;
		}
		return true;
	}

}
