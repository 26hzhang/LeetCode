package com.isaac.leetcodes301_400;

/**
 * Question:
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 =
 * 3 + 3 + 4).
 * Note: you may assume that n is not less than 2.
 *
 * Hint:
 * • There is a simple O(n) solution to this problem.
 * • You may check the breaking results of n ranging from 7 to 10 to discover
 * the regularities.
 *
 * Tags: Dynamic Programming, Math.
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 7 --> 2*2*3, 8 --> 2*3*3, 9 --> 3*3*3, 10 --> 3*3*2*2.
 *        由规律可得，所有的数据均转换成若干3和2的乘积，可以得到最大值，其中两个3的乘积大于3个2的乘积，
 *        因此分解的时候先分解出尽可能多的3，之后再是分解2。
 */
public class LeetCode_343_Integer_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(integerBreak(n));
	}

	public static int integerBreak(int n) {
		if (n <= 3)
			return n - 1;
		int count = 1;
		while (n - 3 >= 2 || n - 3 == 0) {
			count *= 3;
			n = n - 3;
		}
		while (n - 2 >= 0) {
			count *= 2;
			n = n - 2;
		}
		return count;
	}

}
