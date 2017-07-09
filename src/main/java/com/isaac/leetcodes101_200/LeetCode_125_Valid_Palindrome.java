package com.isaac.leetcodes101_200;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * • Have you consider that the string might be empty? This is a good question
 * to ask during an interview.
 * • For the purpose of this problem, we define empty string as valid
 * palindrome.
 *
 * Tags: Two Pointers, String.
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_125_Valid_Palindrome {

	public static void main(String[] args) {

	}

	public static boolean isPalindrome(String s) {
		//转换为小写字母并且滤除所有非字母元素
		s = s.toLowerCase();
		s = s.replaceAll("[^0-9a-z]", "");
		if (s.length() <= 1)
			return true;
		int high = s.length() - 1;
		int low = 0;
		while (low < high) {
			if (s.charAt(low) != s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}

}
