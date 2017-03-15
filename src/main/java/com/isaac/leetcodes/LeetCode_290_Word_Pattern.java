package com.isaac.leetcodes;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 *
 * Examples:
 * 1. pattern = "abba", str = "dog cat cat dog" should return true.
 * 2. pattern = "abba", str = "dog cat cat fish" should return false.
 * 3. pattern = "aaaa", str = "dog cat cat dog" should return false.
 * 4. pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * • You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 *
 * Tags: Hash Table.
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_290_Word_Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<Character, String>();
		String[] s = str.split(" ");
		if (s.length != pattern.length())
			return false;
		if (pattern.length() == 1)
			return true;
		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(pattern.charAt(i))) {
				if (!map.get(pattern.charAt(i)).equals(s[i]))
					return false;
			} else {
				if (map.containsValue(s[i]))
					return false;
				else
					map.put(pattern.charAt(i), s[i]);
			}
		}
		return true;
	}

}
