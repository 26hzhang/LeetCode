package com.isaac.leetcodes;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 *
 * Note:
 * • You may assume both s and t have the same length.
 *
 * Tags: Hash Table
 *
 * @author ZHANG HAO
 *
 *         Explain: 同理利用HashMap的性质。Key保存string s的值，value保存string
 *         t的值，如果存在相同key，而value不同，则不是Isomorphic。
 *
 */
public class LeetCode_205_Isomorphic_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> ht = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			if (ht.containsKey(s.charAt(i))) {
				if (ht.get(s.charAt(i)) != t.charAt(i))
					return false;
			} else {
				if (ht.containsValue(t.charAt(i)))
					return false;
				else
					ht.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}

}
