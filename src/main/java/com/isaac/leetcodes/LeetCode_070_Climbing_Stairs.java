package com.isaac.leetcodes;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * Tags: Dynamic Programming
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         动态规划，上1阶有1种方法：1；上2阶有2种方法：11，2；上3阶有3种方法：111，12，21；上4阶有5种方法：
 *         1111，121，211，112，22；……上n阶有：上n-1阶的方法数+上n-2阶的方法数。
 *
 */
public class LeetCode_070_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int climbStairs(int n) {
		int count = 0;
		int tmp = 1;
		int pre = 0;
		for (int i = 0; i < n; i++) {
			count = pre + tmp;
			pre = tmp;
			tmp = count;
		}
		return count;
	}

}
