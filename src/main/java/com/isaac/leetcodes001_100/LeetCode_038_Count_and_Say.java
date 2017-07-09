package com.isaac.leetcodes001_100;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note:
 * • The sequence of integers will be represented as a string.
 *
 * Tags: String
 *
 * @author ZHANG HAO
 *
 *
 *
 */
public class LeetCode_038_Count_and_Say {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String countAndSay(int n) {
		String str = "1";
		while (n > 1) {
			int count = 0;
			String tmp = "";
			for (int i = 0; i < str.length(); i++) {
				count++;
				if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
					tmp = tmp + count + str.charAt(i);
					count = 0;
				}
			}
			str = tmp;
			n--;
		}
		return str;
	}

}
