package com.isaac.leetcodes101_200;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 *
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * Tags: Math.
 *
 * @author ZHANG HAO
 *
 *
 */
public class LeetCode_168_Excel_Sheet_Column_Title {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String convertToTitle(int n) {
		StringBuffer str = new StringBuffer();
		while (n > 0) {
			str.insert(0, (char) ('A' + --n % 26));
			n /= 26;
		}
		return str.toString();
	}

}
