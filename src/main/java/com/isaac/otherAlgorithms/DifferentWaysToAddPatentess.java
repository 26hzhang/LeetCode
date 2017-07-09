package com.isaac.otherAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddPatentess {

	public static void main(String[] args) {
		String input = "2*3-4*5";
		//String input = "2-1-1";
		List<Integer> list = diffWaysToCompute2(input, new HashMap<String, List<Integer>>());
		System.out.println(list.toString());
	}

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> list = new ArrayList<>();
		if (input == null || input.isEmpty())
			return list;
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i)))
				continue;
			List<Integer> left = diffWaysToCompute(input.substring(0, i));
			List<Integer> right = diffWaysToCompute(input.substring(i + 1));
			for (int l : left) {
				for (int r : right) {
					switch (input.charAt(i)) {
					case ('+'):
						list.add(l + r);
						break;
					case ('-'):
						list.add(l - r);
						break;
					case ('*'):
						list.add(l * r);
						break;
					}
				}
			}
		}
		if (list.isEmpty())
			list.add(Integer.parseInt(input));
		return list;
	}

	public static List<Integer> diffWaysToCompute2(String input, Map<String, List<Integer>> memo) {
		List<Integer> list = new ArrayList<>();
		if (input == null || input.isEmpty())
			return list;
		if (memo.containsKey(input))
			return memo.get(input);
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i)))
				continue;
			List<Integer> left = diffWaysToCompute2(input.substring(0, i), memo);
			List<Integer> right = diffWaysToCompute2(input.substring(i + 1), memo);
			for (int l : left) {
				for (int r : right) {
					switch (input.charAt(i)) {
					case ('+'):
						list.add(l + r);
						break;
					case ('-'):
						list.add(l - r);
						break;
					case ('*'):
						list.add(l * r);
						break;
					}
				}
			}
		}
		if (list.isEmpty())
			list.add(Integer.parseInt(input));
		memo.put(input, list);
		return list;
	}

}
