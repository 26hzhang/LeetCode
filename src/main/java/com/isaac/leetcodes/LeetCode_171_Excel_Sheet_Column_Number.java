package com.isaac.leetcodes;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * Tags: Math
 *
 * @author ZHANG HAO
 *
 *         Explain: 注意步进为26。
 *
 */
public class LeetCode_171_Excel_Sheet_Column_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int titleToNumber(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count = count * 26 + (s.charAt(i) - 'A' + 1);
		}
		return count;
	}

}
