package com.isaac.leetcodes101_200;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 *
 * Tags: Array, Greedy
 *
 * @author ZHANG HAO
 *
 *         Explain: 贪婪算法
 *
 */
public class LeetCode_122_Best_Time_to_Buy_and_Sell_Stock_II {

	public static void main(String[] args) {

	}

	public static int maxProfit(int[] prices) {
		int gain = 0;
		int i = 0;
		while (i < prices.length - 1) {
			if (prices[i + 1] > prices[i])
				gain += prices[i + 1] - prices[i];
			i++;
		}
		return gain;
	}

}
