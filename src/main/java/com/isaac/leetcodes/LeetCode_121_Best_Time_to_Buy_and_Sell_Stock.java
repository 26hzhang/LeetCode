package com.isaac.leetcodes;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 *
 * Tags: Array, Dynamic Programming
 *
 * @author ZHANG HAO
 *
 *         Explain: 动态规划思想
 *
 */
public class LeetCode_121_Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProfit(int[] prices) {
		int global = 0;
		int local = 0;
		int i = 1;
		while (i < prices.length) {
			local += prices[i] - prices[i - 1];
			local = local < 0 ? 0 : local;
			global = Math.max(global, local);
			i++;
		}
		return global;
	}

}
