package com.isaac.leetcodes101_200;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * Tags: Math
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         有多少个5就有多少个末尾0。注意，5=1*5一个5，15=3*5一个5，25=5*52个5。
 *         同理125=5*5*53个5。因此计算方式为：
 *         以100为例，100/5=20，20/5=4，4/5=0。所以100的阶乘一共有20+4＋0=24的末尾0。
 *
 */
public class LeetCode_172_Factorial_Trailing_Zeroes {

	public static void main(String[] args) {

	}

	public static int trailingZeroes(int n) {
		if (n <= 4)
			return 0;
		int count = 0;
		while (n != 0) {
			count += n / 5;
			n = n / 5;
		}
		return count;
	}

}
