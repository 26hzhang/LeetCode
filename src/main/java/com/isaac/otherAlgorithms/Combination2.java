package com.isaac.otherAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Combination2 {

	public static void main(String[] args) {
		String s = "ABC";
		List<List<Character>> list = combine(s);
		for (List<Character> l : list) {
			System.out.println(l.toString());
		}
	}

	public static List<List<Character>> combine(String s) {
		List<List<Character>> list = new ArrayList<List<Character>>();
		if (s == null || s.length() == 0)
			return list;
		for (int i = 1; i <= s.length(); i++) {
			recursion(list, s, 0, i, new ArrayList<Character>());
		}
		return list;
	}

	public static void recursion(List<List<Character>> list, String s, int start, int num, List<Character> l) {
		if (num == 0) {
			list.add(new ArrayList<Character>(l));
			return;
		}
		if (start == s.length())
			return;
		l.add(s.charAt(start));
		recursion(list, s, start + 1, num - 1, l);
		l.remove(l.size() - 1);
		recursion(list, s, start + 1, num, l);
	}

}
