package com.isaac.leetcodes;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 *
 * Note:
 * • A word is defined as a character sequence consists of non-space characters
 * only.
 *
 * For example,
 * Given s = "Hello World",
 * return 5.
 *
 * Tags: String
 *
 * @author ZHANG HAO
 *
 *         Explain: 从后往前寻找空格，找到最后一个单词前的空格后跳出循环并返回count。
 *
 */
public class LeetCode_058Length_of_Last_Word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int lengthOfLastWord(String s) {
		if (s.length() == 0)
			return 0;
		int index = s.length() - 1;
		int count = 0;
		int tmp = 0;
		while (index >= 0) {
			if (s.charAt(index) != ' ') {
				count++;
				tmp = 1;
			}
			if (tmp == 1 && s.charAt(index) == ' ')
				break;
			index--;
		}
		return count;
	}

}
