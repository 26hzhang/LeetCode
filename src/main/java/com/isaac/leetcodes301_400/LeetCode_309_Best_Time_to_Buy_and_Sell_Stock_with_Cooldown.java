package com.isaac.leetcodes301_400;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * • You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * • After you sell your stock, you cannot buy stock on next day. (i.e.,
 * cooldown 1 day)
 *
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 * Tags: Dynamic Programming
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         Cooldown也加入更新，因为之前的cooldown对后面有影响，每次选择cooldown和
 *         profit中较大的作为当前的profit。
 *
 */
public class LeetCode_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProfit(int[] prices) {
		int cooldown = 0;
		int profit = 0;
		int i = 1;
		while (i < prices.length) {
			int tmp = profit;
			profit = Math.max(profit + prices[i] - prices[i - 1], cooldown);
			cooldown = Math.max(tmp, cooldown);
			i++;
		}
		return Math.max(profit, cooldown);
	}

}
