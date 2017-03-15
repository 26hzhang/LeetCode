package com.isaac.leetcodes;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Hints:
 * • Could negative integers be palindromes? (ie, -1)
 * • If you are thinking of converting the integer to string, note the
 * restriction of using extra space.
 * • You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * • There is a more generic way of solving this problem.
 *
 * Tags: Math.
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 利用数学方式将测试数据反转，最后判断新数据和原数据是否相等。
 *
 */
public class LeetCode_009_Palindrome_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPalindrome(int x) {
		int res = 0;
		int judge = x;
		while (x > 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res == judge;
	}

}
