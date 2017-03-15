package com.isaac.otherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ALGO";
		int k = 2;
		List<String> list = permute(str, k);
		for (String l : list)
			System.out.println(l);
	}

	public static List<String> permute(String str, int k) {
		List<String> list = new ArrayList<String>();
		if (str == null || str.isEmpty() || str.length() < k)
			return list;
		char[] arr = str.toCharArray();
		recursion(list, arr, k, new ArrayList<Character>());
		return list;
	}

	public static void recursion(List<String> list, char[] arr, int k, List<Character> l) {
		if (l.size() == k) {
			list.add(new StringBuilder().append(Arrays.toString(l.toArray())).toString());
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			l.add(arr[i]);
			recursion(list, arr, k, l);
			l.remove(l.size() - 1);
		}
	}

}
