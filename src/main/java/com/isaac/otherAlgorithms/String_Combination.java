package com.isaac.otherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question:
 * 输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc。
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 假设我们想在长度为n的字符串中求m个字符的组合。我们先从头扫描字符串的第一个字符。
 *        针对第一个字符，我们有两种选择：第一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；
 *        第二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。这两种选择都很容易用递归实现。
 *
 */
public class String_Combination {

	public static void main(String[] args) {
		String str = "abc";
		List<List<Character>> list = combination(str);
		for (List<Character> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Character>> combination(String str) {
		List<List<Character>> lList = new ArrayList<List<Character>>();
		if (str == null || str.length() == 0)
			return lList;
		for (int i = 1; i <= str.length(); i++) {
			recursion(lList, str, 0, i, new ArrayList<Character>());
		}
		return lList;
	}

	public static void recursion(List<List<Character>> lList, String str, int start, int number, List<Character> list) {
		if (number == 0) {
			lList.add(new ArrayList<Character>(list));
			return;
		}
		if (start == str.length())
			return;
		list.add(str.charAt(start));
		recursion(lList, str, start + 1, number - 1, list); //第一种选择
		list.remove(list.size() - 1);
		recursion(lList, str, start + 1, number, list); //第二种选择
	}

}
