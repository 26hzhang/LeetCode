package com.isaac.leetcodes301_400;

import java.util.Arrays;

/**
 * Question:
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Tags: Dynamic Programming
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 构建一个count array，然后将给定的value位置赋值1，然后动态规划求解。
 *
 */
public class LeetCode_322_Coin_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (coins.length == 0 || amount < 0)
			return -1;
		Arrays.sort(coins);
		int[] count = new int[amount + 1];
		for (int i = 0; i < coins.length && coins[i] <= amount; i++) {
			count[coins[i]] = 1;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 1)
				count[i] = 99999999;
		}
		for (int i = 1; i <= amount; i++) { // 从第一个开始，因为硬币没有0
			if (count[i] == 99999999) {
				for (int j = 0; j < coins.length && coins[j] < i; j++) {
					if (count[i] > count[i - coins[j]] + 1)
						count[i] = count[i - coins[j]] + 1;
				}
			}
		}
		return count[amount] >= 99999999 ? -1 : count[amount];
	}

}
