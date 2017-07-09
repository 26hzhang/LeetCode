package com.isaac.otherAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TheFirstAppearOnceCharacter {

	public static void main(String[] args) {
		String str = "abcdaacbgdgrrrcftfvt";
		System.out.println(fstAppearOnce(str));
	}

	public static Character fstAppearOnce(String str) {
		if (str == null || str.isEmpty())
			return null;
		if (str.length() == 1)
			return str.charAt(0);
		Set<Character> set = new HashSet<Character>(); // store characters appear more than once
		List<Character> list = new ArrayList<Character>(); // store characters appear once
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i)))
				continue;
			if (list.contains(str.charAt(i))) {
				list.remove((Character) str.charAt(i));
				set.add(str.charAt(i));
			} else {
				list.add(str.charAt(i));
			}
		}
		return list.get(0);
	}

}
